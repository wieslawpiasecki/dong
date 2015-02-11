package com.wpi.test.support;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.sql.DataSource;

/**
 * Created by Wiesław Piasecki on 2015-01-02.
 */

@TestExecutionListeners({TransactionalTestExecutionListener.class})
public class AbstractDbSpringContextTestsSupport extends AbstractSpringContextTestsSupport {

    /***/
    @Autowired
    private SessionFactory sessionFactory;
    /***/
    @Autowired
    private DataSource dataSource;

    /***/
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    /***/
    private Resource[] contentResources = {};

    public AbstractDbSpringContextTestsSupport() {
    }

//    /**
//     * @param transferFilesLocations location of xml transfer files, which are initialized on BeforeMethod.
//     */
//    public AbstractDbSpringContextTestsSupport(String... transferFilesLocations) {
//        contentResources = createContentResources(transferFilesLocations);
//    }
//
//
//    public void afterPropertiesSet() throws Exception {
//    //   super.afterPropertiesSet();
//        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
//    }
//
//    @BeforeMethod(alwaysRun = true)
//    public void prepareDbData() {
//        try {
//            deleteDatabaseContent();
//            initializeDatabaseContent();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException(e);
//        }
//    }

//    private void initializeDatabaseContent() {
//        DbUtil.forMib(moduleIntegratorBus).initializeDatabaseContent(contentResources);
//    }
//
//    private void deleteDatabaseContent() {
//        //        DbUtil.forMib(moduleIntegratorBus).deleteDatabaseContent("/cgm/g3/orm/.*");
//        executeSQLOutsideOfTransaction("update ORM_MEDICATIONORDER set MORPARENTINWARDORDERID=NULL;", false);
//        executeSQLOutsideOfTransaction("update ORM_InwardMedOrderComment set imcOrderID=NULL;", false);
//        for (String s : sequenceTablesToCleanResolver.getSequenceTablesToClean()) {
//            executeSQLOutsideOfTransaction("delete from " + s, false);
//        }
//    }
//
//    private Resource[] createContentResources(String... dataSetLocations) {
//        List<Resource> resources = new ArrayList<Resource>();
//        for (String dataSetLocation : dataSetLocations) {
//            resources.add(new ClassPathResource(dataSetLocation));
//        }
//        return resources.toArray(new Resource[resources.size()]);
//    }
//
//    protected void executeSQLOutsideOfTransaction(String sql, boolean continueOnError) {
//        SimpleJdbcTestUtils.executeSqlScript(this.simpleJdbcTemplate, new ByteArrayResource(sql.getBytes()), continueOnError);
//    }
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
}

