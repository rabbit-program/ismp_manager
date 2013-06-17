package edu.sjtu.infosec.ismp.manager.comm.comm.reports;

import java.io.File;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.impl.SessionFactoryImpl;
import org.springframework.context.ApplicationContext;

/**
 * 使用报表模板及数据等来生成JapserPrint
 * @author Wu Guojie
 * @date 2009-7-1
 * @version 1.0
 */
public class JasperPrintWithHibernate {
	private static ApplicationContext applicationContext;
    /** 传入的参数 */
    private Map params;

    /** 模板文件的地址 */
    private String reportFilePath;
    
    /**jrxml文件*/
    private List<String> jrxmlFilePathList;

    /** dataSrouce */
    private JRDataSource dataSource;

    public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public JRDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(JRDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public String getReportFilePath() {
        return reportFilePath;
    }

    public List<String> getJrxmlFilePathList() {
		return jrxmlFilePathList;
	}

	public void setJrxmlFilePathList(List<String> jrxmlFilePathList) {
		this.jrxmlFilePathList = jrxmlFilePathList;
	}

	public void setReportFilePath(String reportFilePath) throws Exception {
        if (reportFilePath == null || !reportFilePath.endsWith(".jasper"))
            throw new Exception("您传入的模板文件格式不对，请传入以.jasper为后缀的文件!");
        this.reportFilePath = reportFilePath;
    }

    public JasperPrintWithHibernate() {
        super();
    }

    public JasperPrintWithHibernate(List<String> jrxmlFilePathList,String reportFilePath, Map params, ApplicationContext applicationContext) throws Exception {
    	for(String jrxmlFilePath : jrxmlFilePathList){
            if (jrxmlFilePath == null || !jrxmlFilePath.endsWith(".jrxml")){
            	throw new Exception("模板文件格式不对，请传入以.jrxml为后缀的文件!");
            }
    	}
        this.setJrxmlFilePathList(jrxmlFilePathList);
        this.setReportFilePath(reportFilePath);
        this.setParams(params);
        this.setApplicationContext(applicationContext);
    }

    /**
     * 取得Hibernate Session
     * 
     */
    private static Session createSession()
    {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        return ((SessionFactoryImpl)applicationContext.getBean("sessionFactory")).openSession();
    }
    
    /**
     * 取得参数
     * 
     */
    private  Map getParameters(Session session)
    {
        this.params.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, session);

        return params;
    }
    
    /**
     * 取得JasperPrint
     * 
     * @return
     * @throws Exception
     */
    public JasperPrint getJasperPrint() throws Exception {      
        // 编译成.jasper文件
    	for(String jrxmlFilePath : this.jrxmlFilePathList){
            JasperCompileManager.compileReportToFile(jrxmlFilePath);   
    	}
        File reportFile = new File(this.reportFilePath);
        if (!reportFile.exists())
            throw new Exception("传入的模板文件不存在!");

        try {
            // Load编译好的模板
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile.getPath());
            // 进行数据填充
            Session session = createSession();
            Transaction transaction = session.beginTransaction();
            getParameters(session);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, this.params);
            return jasperPrint;

        } catch (JRException jre) {
            jre.printStackTrace();
            throw new Exception("在进行数据填充时发生了错误中，请检查是否是数据库连接错误或者是用来填充的参数map有误!");
        }

    }
}
