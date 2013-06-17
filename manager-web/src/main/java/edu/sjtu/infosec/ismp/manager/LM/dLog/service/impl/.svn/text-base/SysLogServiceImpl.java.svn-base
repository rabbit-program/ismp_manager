package edu.sjtu.infosec.ismp.manager.LM.dLog.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.LM.dLog.comm.InitSysLogSeverityAndFacility;
import edu.sjtu.infosec.ismp.manager.LM.dLog.dao.SysLogDao;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLog;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLogFacility;
import edu.sjtu.infosec.ismp.manager.LM.dLog.model.SysLogSeverity;
import edu.sjtu.infosec.ismp.manager.LM.dLog.service.SysLogService;
import edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogFrom;
import edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogInitQueryBean;
import edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogResponseQueryBean;
import edu.sjtu.infosec.ismp.manager.LM.util.InitQueryDate;
import edu.sjtu.infosec.ismp.manager.LM.util.StringDisplayOptimize;
import edu.sjtu.infosec.ismp.manager.LM.util.modle.PageBean;
import edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog.SysLogSource;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;
import edu.sjtu.infosec.ismp.security.OperatorDetails;

public class SysLogServiceImpl implements SysLogService {

	private SysLogDao sysLogDao;

	public SysLogDao getSysLogDao() {
		return sysLogDao;
	}

	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}

	public void sysLogBaseInfoService() throws Exception {
		
		/**
		 * 保存syslog的产生日志的程序模块
		 */
		
		List<SysLogFacility> facilityList = sysLogDao.initSysLogFacility();
		if(!facilityList.isEmpty()){
			for(SysLogFacility sysLogFacility : facilityList){
				InitSysLogSeverityAndFacility.addSysLogFacility(sysLogFacility);
			}
		}
		
		/**
		 * 保存syslog的严重性
		 */
		
		List<SysLogSeverity> severityList = sysLogDao.initSysLogSeverity();
		if(!severityList.isEmpty()){
			for(SysLogSeverity sysLogSeverity: severityList){
				InitSysLogSeverityAndFacility.addSysLogSeverity(sysLogSeverity);
			}
		}
		
		//打印出SYSLOGFACILITY和SYSLOGSEVERITY的大小
//		System.out.println(InitSysLogSeverityAndFacility.SYSLOGFACILITY.size());
//		System.out.println(InitSysLogSeverityAndFacility.SYSLOGSEVERITY.size());
	}

	public SysLogInitQueryBean initQuery() throws Exception {
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		SysLogInitQueryBean initQueryBean = new SysLogInitQueryBean();
		List<String> initDate = InitQueryDate.initQueryDate(30);
		
		TreeMap<Integer,String> facilityMap = new TreeMap<Integer, String>();
		TreeMap<Integer,String> severityMap = new TreeMap<Integer, String>();
		facilityMap = InitSysLogSeverityAndFacility.getSysLogFacility(facilityMap);
		severityMap = InitSysLogSeverityAndFacility.getSysLogSeverity(severityMap);
		
		initQueryBean.setDomain(user.getDomainList());
		initQueryBean.setBeginDate(initDate.get(0));
		initQueryBean.setEndDate(initDate.get(1));
		initQueryBean.setFacility(facilityMap);
		initQueryBean.setSeverity(severityMap);
		
		
		//打印出用户角色、部门、时间
//		System.out.println(user.getRoleList());
//		System.out.println(user.getDomainList());
//		System.out.println(initDate);
//		System.out.println("产生日志的程序模块:" + initQueryBean.getFacility());
//		System.out.println("严重性:" + initQueryBean.getSeverity());
		return initQueryBean;
	}

	public SysLogResponseQueryBean responseQuery(ActionForm from,OperatorDetails user) throws Exception {
		SysLogResponseQueryBean responseQueryBean = new SysLogResponseQueryBean();		
		SysLogFrom sysLogFrom = (SysLogFrom)from;
		
		try {
			BeanUtils.copyProperties(responseQueryBean, sysLogFrom);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		responseQueryBean.setQuery(StringDisplayOptimize.stringOptimize(this.getQueryString(responseQueryBean,user), 50));
		
//		//打印信息
//		System.out.println("----------responseQueryBean------------");
//		System.out.println(responseQueryBean.getDomain());
//		System.out.println(responseQueryBean.getBeginDate());
//		System.out.println(responseQueryBean.getEndDate());
//		System.out.println(responseQueryBean.getHostname());
//		System.out.println(responseQueryBean.getMessage());
//		System.out.println(responseQueryBean.getFacility());
//		System.out.println(responseQueryBean.getSeverity());
//		System.out.println(responseQueryBean.getQuery());
//		System.out.println(sysLogFrom.getDeviceIP());
//		System.out.println("----------responseQueryBean------------");
		
		return responseQueryBean;
	}
	
	/**
	 * 获得查询条件的字符串	SysLogResponseQueryBean.query
	 * @param responseQuery
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private String getQueryString(SysLogResponseQueryBean responseQuery,OperatorDetails user)throws Exception{
		int count = 0;
		StringBuffer queryString = new StringBuffer();
		
		if(responseQuery.getDomain() == null || responseQuery.getDomain().equals("all")){
			count++;
		}else{
			List<Domain> domainList = user.getDomainList();
			for(Domain domain : domainList){
				if(responseQuery.getDomain().equals(domain.getId()+"")){
					queryString.append("部门：" + domain.getDomainName()+"、");
					break;
				}
			}
		}
		
		if(responseQuery.getFacility() == null || responseQuery.getFacility().equals("all")){
			count++;
		}else{
			Map<Integer,String> facilityMap = InitSysLogSeverityAndFacility.SYSLOGFACILITY;
			queryString.append("程序模块：" + facilityMap.get(Integer.parseInt(responseQuery.getFacility()))+"、");
		}
		
		if(responseQuery.getBeginDate() != null && !responseQuery.getBeginDate().equals("") && responseQuery.getEndDate() != null && !responseQuery.getEndDate().equals("")){
			queryString.append("时间段：" + responseQuery.getBeginDate() + "～" +responseQuery.getEndDate()+"、");
		}
		
		if(responseQuery.getHostname() == null || responseQuery.getHostname().equals("")){
			count++;
		}else{
			queryString.append("主机IP：" + responseQuery.getHostname() +"、");
		}
		
		if(responseQuery.getSeverity() == null || responseQuery.getSeverity().equals("all")){
			count++;
		}else{
			Map<Integer,String> severityMap = InitSysLogSeverityAndFacility.SYSLOGSEVERITY;
			queryString.append("严重性：" + severityMap.get(Integer.parseInt(responseQuery.getSeverity()))+"、");
		}
		
		if(responseQuery.getMessage() == null || responseQuery.getMessage().equals("")){
			count++;
		}else{
			queryString.append("消息关键字：" + responseQuery.getMessage() +"、");
		}
		
		if(count >= 5){
			return "查询全部信息 !";
		}
		return queryString.toString();
	}

	public PageBean getSysLog(SysLogResponseQueryBean sysLogQueryBean,
			Integer pageNo,String initBeginDate,String initEndDate) throws Exception {
		PageBean pageBean = new PageBean();
		
		pageBean.setResultRowSum(getPageResultRowSum(sysLogQueryBean,initBeginDate,initEndDate));
		pageBean.setPageRowNum(8);
		pageBean.setPageMaxSum((pageBean.getResultRowSum()+(pageBean.getPageRowNum()-1))/pageBean.getPageRowNum());		
		pageBean.setPageNo(pageNo);
		pageBean.setPageResult(this.getPageResult(sysLogQueryBean, pageNo-1*pageBean.getPageRowNum(), pageBean.getPageRowNum(),initBeginDate,initEndDate));

/**
 * 		2010-9-19  作废
 */
//		pageBean.setPageResult(this.optimizePageResult(sysLogQueryBean, pageNo-1, pageBean.getPageRowNum(), initBeginDate, initEndDate));
		
		//打印信息
//		System.out.println("----------PageBean---------");
//		System.out.println("当前页：" + pageBean.getPageNo());
//		System.out.println("一共多少页：" + pageBean.getPageMaxSum());
//		System.out.println("每页多少行：" + pageBean.getPageRowNum());
//		System.out.println("一共多少行：" + pageBean.getResultRowSum());
//		System.out.println("符合查询数：" + pageBean.getPageResult().size());
//		System.out.println("----------PageBean---------");
		return pageBean;
	}
	
	/**
	 * 获得lm_dlog_syslog表中的数据总数
	 * @return
	 * @throws Exception
	 */
	private Integer getPageResultRowSum(SysLogResponseQueryBean sysLogQueryBean,String initBeginDate,String initEndDate)throws Exception{
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		StringBuffer HQL = new StringBuffer();
		
		HQL.append("select count(*) from SysLog where 1=1");
//		
//		if(sysLogQueryBean.getDomain() != null && !sysLogQueryBean.getDomain().equals("") && !sysLogQueryBean.getDomain().equals("all")){
//			HQL.append(",Domain");
//		}
//		if(sysLogQueryBean.getFacility() != null && !sysLogQueryBean.getFacility().equals("all")){
//			HQL.append(",SysLogFacility");
//		}
//		if(sysLogQueryBean.getSeverity() != null && !sysLogQueryBean.getSeverity().equals("all")){
//			HQL.append(",SysLogSeverity");
//		}
	
		if(sysLogQueryBean.getDomain() != null && !sysLogQueryBean.getDomain().equals("") && !sysLogQueryBean.getDomain().equals("all")){
			HQL.append(" and domain="+sysLogQueryBean.getDomain());
		}
		if(sysLogQueryBean.getDomain() == null || sysLogQueryBean.getDomain().equals("all")){
			String inDomain = "00";
			List<Domain> domainList = user.getDomainList();
			for(Domain d : domainList)
				inDomain += ","+d.getId();
			HQL.append(" and domain in ("+inDomain+")");
		}
		if(sysLogQueryBean.getFacility() != null && !sysLogQueryBean.getFacility().equals("all")){
			HQL.append(" and facility="+sysLogQueryBean.getFacility());
		}
		if(sysLogQueryBean.getSeverity() != null && !sysLogQueryBean.getSeverity().equals("all")){
			HQL.append(" and severity="+sysLogQueryBean.getSeverity());
		}
		if(sysLogQueryBean.getBeginDate() != null && sysLogQueryBean.getEndDate() != null){
			HQL.append(" and timestamp between '"+sysLogQueryBean.getBeginDate()+"' and '"+sysLogQueryBean.getEndDate()+"'");
		}else{
			HQL.append(" and timestamp between '"+initBeginDate+"' and '"+initEndDate+"'");
		}
		if(sysLogQueryBean.getHostname() != null && !sysLogQueryBean.getHostname().trim().equals("")){
			HQL.append(" and hostname='"+sysLogQueryBean.getHostname().trim()+"'");
		}
		if(sysLogQueryBean.getMessage() != null && !sysLogQueryBean.getMessage().trim().equals("")){
			HQL.append(" and message like '%"+sysLogQueryBean.getMessage().trim()+"%'");
		}
		
		return sysLogDao.getPageResultRowSum(HQL.toString());
	}
	
	/**
	 * 得到lm_dlog_syslog表中符合HQL条件的数据。并分页
	 * @param sysLogQueryBean
	 * @param pageNo
	 * @param pageRowNum
	 * @return
	 * @throws Exception
	 */
	private List<SysLog> getPageResult(SysLogResponseQueryBean sysLogQueryBean,Integer pageNo,Integer pageRowNum,String initBeginDate,String initEndDate)throws Exception{
		OperatorDetails user = SecurityUserHolder.getCurrentUser();
		StringBuffer HQL = new StringBuffer();
		
		HQL.append("from SysLog where 1=1");
//		
//		if(sysLogQueryBean.getDomain() != null && !sysLogQueryBean.getDomain().equals("") && !sysLogQueryBean.getDomain().equals("all")){
//			HQL.append(",Domain");
//		}
//		if(sysLogQueryBean.getFacility() != null && !sysLogQueryBean.getFacility().equals("all")){
//			HQL.append(",SysLogFacility");
//		}
//		if(sysLogQueryBean.getSeverity() != null && !sysLogQueryBean.getSeverity().equals("all")){
//			HQL.append(",SysLogSeverity");
//		}
	
		if(sysLogQueryBean.getDomain() != null && !sysLogQueryBean.getDomain().equals("") && !sysLogQueryBean.getDomain().equals("all")){
			HQL.append(" and domain="+sysLogQueryBean.getDomain());
		}
		if(sysLogQueryBean.getDomain() == null || sysLogQueryBean.getDomain().equals("all")){
			String inDomain = "00";
			List<Domain> domainList = user.getDomainList();
			for(Domain d : domainList)
				inDomain += ","+d.getId();
			HQL.append(" and domain in ("+inDomain+")");
		}
		if(sysLogQueryBean.getFacility() != null && !sysLogQueryBean.getFacility().equals("all")){
			HQL.append(" and facility="+sysLogQueryBean.getFacility());
		}
		if(sysLogQueryBean.getSeverity() != null && !sysLogQueryBean.getSeverity().equals("all")){
			HQL.append(" and severity="+sysLogQueryBean.getSeverity());
		}
		if(sysLogQueryBean.getBeginDate() != null && sysLogQueryBean.getEndDate() != null){
			HQL.append(" and timestamp between '"+sysLogQueryBean.getBeginDate()+"' and '"+sysLogQueryBean.getEndDate()+"'");
		}else{
			HQL.append(" and timestamp between '"+initBeginDate+"' and '"+initEndDate+"'");
		}
		if(sysLogQueryBean.getHostname() != null && !sysLogQueryBean.getHostname().trim().equals("")){
			HQL.append(" and hostname='"+sysLogQueryBean.getHostname().trim()+"'");
		}
		if(sysLogQueryBean.getMessage() != null && !sysLogQueryBean.getMessage().trim().equals("")){
			HQL.append(" and message like '%"+sysLogQueryBean.getMessage().trim()+"%'");
		}
		
		HQL.append(" order by timestamp desc");
		
//		//打印信息
//		System.out.println("--HQL--" + HQL.toString());
//		System.out.println("initTime: " + initBeginDate + "～" + initEndDate);
//		System.out.println("Time: " + sysLogQueryBean.getBeginDate() + "～" + sysLogQueryBean.getEndDate());
		
		return sysLogDao.getPageResult(HQL.toString(), pageNo, pageRowNum);
	}
	
	/**
	 * 优化SysLog的message字符
	 * 2010-9-19	作废
	 */
//	private List<SysLog> optimizePageResult(SysLogResponseQueryBean sysLogQueryBean,Integer pageNo,Integer pageRowNum,String initBeginDate,String initEndDate)throws Exception{
//		List<SysLog> sysLogList = this.getPageResult(sysLogQueryBean, pageNo, pageRowNum, initBeginDate, initEndDate);
//		List<SysLog> sysLog = new ArrayList<SysLog>();
//		
//		for(SysLog syslog : sysLogList){
//			syslog.setMessageOptimize(StringDisplayOptimize.stringOptimize(syslog.getMessage(), 20));
//			sysLog.add(syslog);
//		}
//		
//		return sysLog;
//	}
	
	public List<SysLogSource> getAllSysLogSource(SysLogSource sysLogSource,List<Domain> domain,Integer pageNo,Integer pageRowNum) throws Exception {
		return sysLogDao.getAllSysLogSource(sysLogSource, domain, pageNo, pageRowNum);
	}
	
	public Integer getAllSysLogSourceCount(SysLogSource sysLogSource,List<Domain> domain) throws Exception {
		return sysLogDao.getAllSysLogSourceCount(sysLogSource, domain);
	}
}
