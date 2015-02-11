package com.wpi.spring;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.orm.hibernate4.SpringSessionContext;
import org.springframework.orm.hibernate4.SpringSessionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Created by Wiesław Piasecki on 2015-01-03.
 */
public class ClassLoaderSpringSessionContext implements CurrentSessionContext {

    private final SessionFactoryImplementor sessionFactory;
    private final SpringSessionContext sessionContext;

    public ClassLoaderSpringSessionContext(final SessionFactoryImplementor sessionFactory) {
        this.sessionFactory = sessionFactory;  // This is actually some class loading logic that isn't important to this transaction problem.
        this.sessionContext = new SpringSessionContext(this.sessionFactory);
    }

    @Override
    public Session currentSession() throws HibernateException {
        try {
            return sessionContext.currentSession();
        } catch (HibernateException e) {
            if (TransactionSynchronizationManager.isSynchronizationActive()) {
                Session session = this.sessionFactory.openSession();
                if (TransactionSynchronizationManager.isCurrentTransactionReadOnly()) {
                    session.setFlushMode(FlushMode.MANUAL);
                }
                SessionHolder sessionHolder = new SessionHolder(session);
                TransactionSynchronizationManager
                        .registerSynchronization(new SpringSessionSynchronization(sessionHolder,
                                this.sessionFactory));
                TransactionSynchronizationManager.bindResource(this.sessionFactory, sessionHolder);
                sessionHolder.setSynchronizedWithTransaction(true);
                return session;
            } else {
                throw new HibernateException(
                        "Could not obtain transaction-synchronized Session for current thread");
            }
        }
    }
}