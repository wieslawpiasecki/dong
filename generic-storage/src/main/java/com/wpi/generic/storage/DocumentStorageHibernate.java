package com.wpi.generic.storage;

import com.wpi.generic.storage.serailization.XMLDocumentSerializer;
import com.wpi.generic.storage.serialization.DocumentDeserializer;
import com.wpi.generic.storage.serialization.SerializedDocument;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import static org.hibernate.criterion.Restrictions.and;
import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by Wiesław Piasecki on 2015-01-02.
 */
@Repository
@Transactional
@Scope
public class DocumentStorageHibernate implements DocumentStorage {
    private SessionFactory sessionFactory;

    private XMLDocumentSerializer xmlDocumentSerializer;
    private DocumentDeserializer documentDeserializer;

    @Autowired
    public DocumentStorageHibernate(SessionFactory sessionFactory, XMLDocumentSerializer xmlDocumentSerializer, DocumentDeserializer documentDeserializer) {
        this.sessionFactory = sessionFactory;
        this.xmlDocumentSerializer = xmlDocumentSerializer;
        this.documentDeserializer = documentDeserializer;
    }

    @Override
    public void store(Document document) {
        Session session = sessionFactory.getCurrentSession();
        SerializedDocument serialized = xmlDocumentSerializer.serialize(document);
        session.saveOrUpdate(serialized);
    }

    @Override
    public Document findByVersionedId(VersionedDocumentId versionedDocumentId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Criteria criteria = currentSession.createCriteria(SerializedDocument.class);
        criteria.add(and(eq(SerializedDocument.ID, versionedDocumentId.getId()),eq(SerializedDocument.VERSION,versionedDocumentId.getVersion())));
        SerializedDocument serializedDocument = (SerializedDocument)criteria.uniqueResult();
        return documentDeserializer.deserialize(serializedDocument);
    }
}
