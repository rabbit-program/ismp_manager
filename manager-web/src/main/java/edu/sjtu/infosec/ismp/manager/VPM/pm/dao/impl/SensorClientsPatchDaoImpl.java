package edu.sjtu.infosec.ismp.manager.VPM.pm.dao.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.dao.SensorClientsPatchDao;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateInfo;
import edu.sjtu.infosec.ismp.manager.comm.comm.conn.jdbc.JdbcSensorClient;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 补丁更新 的操作
 * 
 * @author Admin
 * 
 */
public class SensorClientsPatchDaoImpl implements SensorClientsPatchDao{

	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao#getComputerTargetId(java.lang.String)
	 */
	public String getComputerTargetId(String IP) throws Exception {
		// jdbc类
		JdbcSensorClient jsc = new JdbcSensorClient();
		String sql = "select top 1 ComputerTargetId from PUBLIC_VIEWS.vComputerTarget where IPAddress = '"
				+ IP + "'";
		System.out.println(sql);
		return jsc.executeQueryString(sql);
	}

	
	@Deprecated
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao
	 * #getPatchUpdateInfoByState(java.lang.String, java.lang.String, int[])
	 */
	public List getPatchUpdateInfoByState(String computerID, String type,
			int[] states) throws Exception {
		// 获取SQL字符串
		String sql = getSqlPatchUpdateInfo(computerID, type, states);
		System.out.println("sql语句是：" + sql);
		// 返回记录
		System.out.println("查询了记录！");
		return JdbcSensorClient.find(sql, PatchUpdateInfo.class,
				new Object[] {});
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao#getPatchUpdateInfoByState(java.lang.String, java.lang.String, int[], edu.sjtu.infosec.ismp.base.mciommon.Page)
	 */
	public List getPatchUpdateInfoByState(String computerID, String type,
			int[] states, PMPage page) throws Exception {
		// 获取SQL字符串
		String sql = getSqlPatchUpdateInfo(computerID, type, states, page);
		System.out.println("sql语句是：" + sql);
		// 返回记录
		System.out.println("查询了记录！");
		return JdbcSensorClient.find(sql, PatchUpdateInfo.class,
				new Object[] {});
	}

	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao#getPatchUpdateInfoByStateCount(java.lang.String, java.lang.String, int[])
	 */
	public Integer getPatchUpdateInfoByStateCount(String computerID,
			String type, int[] states) throws Exception {
		// jdbc类
		JdbcSensorClient jsc = new JdbcSensorClient();
		// 获取SQL字符串
		String sql = getSqlPatchUpdateInfo(computerID, type, states);
		System.out.println("sql语句是：" + sql);
		// 返回数量
		String count = jsc.executeQueryString(sql);
		return count == null ? 0 : Integer.parseInt(count);
	}

	
	@Deprecated
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao
	 * #getPatchInfo(java.lang.String, java.lang.String)
	 */
	public List<PatchInfo> getPatchInfo(String declined, String type)
			throws Exception {
		// jdbc类
		String sql = getSqlByPatchInfo(declined, type);
		// 返回记录
		return JdbcSensorClient.find(sql, PatchInfo.class, new Object[] {});
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao#getPatchInfo(java.lang.String, java.lang.String, edu.sjtu.infosec.ismp.base.mciommon.Page)
	 */
	public List<PatchInfo> getPatchInfo(String declined, String type, Page page)
			throws Exception {
		// jdbc类
		String sql = getSqlByPatchInfo(declined, type, page);
		// 返回记录
		return JdbcSensorClient.find(sql, PatchInfo.class, new Object[] {});
	}


	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao#getPatchInfoCount(java.lang.String, java.lang.String)
	 */
	public Integer getPatchInfoCount(String declined, String type)
			throws Exception {
		// jdbc类
		JdbcSensorClient jsc = new JdbcSensorClient();
		System.out
				.println("SensorClientsPatchDaoImpl:getPatchInfoCount():declined:"
						+ declined + ",type:" + type);
		// SQL语句
		String sql = getSqlByPatchInfo(declined, type);
		String count = jsc.executeQueryString(sql);
		System.out.println("getPatchInfoCount():count: " + count);
		return count == null ? 0 : Integer.parseInt(count);
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao#getPatchInfoById(java.lang.String, java.lang.String)
	 */
	public PatchInfo getPatchInfoById(String id, String declined)
			throws Exception {
		// jdbc类
		String sql = "select PUBLIC_VIEWS.vUpdate.UpdateId, PUBLIC_VIEWS.vUpdate.RevisionNumber,Title as DefaultTitle,Description as DefaultDescription,ClassificationId, ArrivalDate, CreationDate, IsDeclined, IsWsusInfrastructureUpdate, MsrcSeverity, PublicationState, UpdateType, UpdateSource, KnowledgebaseArticle, SecurityBulletin, InstallationCanRequestUserInput, InstallationRequiresNetworkConnectivity, InstallationImpact, InstallationRebootBehavior from PUBLIC_VIEWS.vUpdate"
					 +" join"
					 +" vwUpdateLocalizedProperties on (PUBLIC_VIEWS.vUpdate.UpdateId=vwUpdateLocalizedProperties.UpdateId) where ShortLanguage = 'zh-cn' and IsDeclined ='"+declined+"' and PUBLIC_VIEWS.vUpdate.UpdateId = '"+id+"'";		
		// 返回记录
		List<PatchInfo> list = JdbcSensorClient.find(sql, PatchInfo.class,
				new Object[] {});
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 拼接SQL语句
	 * 
	 * @param states
	 * @return
	 */
	private static String getSqlPatchUpdateInfo(String computerID, String type,
			int[] states) {
		// SQL语句
		StringBuffer sql = null;

		// 如果没有状态值，就返回所有记录
		if (states.length <= 0) {
			if (type.equalsIgnoreCase("in") || type.equalsIgnoreCase("notIn")) {
				sql = new StringBuffer(
						"select UpdateId, ComputerTargetId, State from PUBLIC_VIEWS.vUpdateInstallationInfo where ComputerTargetId='"
								+ computerID + "'");
			} else {
				sql = new StringBuffer(
						"select count(*) from PUBLIC_VIEWS.vUpdateInstallationInfo where ComputerTargetId='"
								+ computerID + "'");
			}
			return sql.toString();
		}
		// select * from xx where 1=1 and state in (states);
		if (type.equalsIgnoreCase("in") || type.equalsIgnoreCase("notIn")) {
			sql = new StringBuffer(
					"select UpdateId, ComputerTargetId, State from PUBLIC_VIEWS.vUpdateInstallationInfo where 1=1 and ComputerTargetId ='"
							+ computerID + "'");
			if (type.equalsIgnoreCase("in")) {
				sql.append("and state in(");
			} else {
				sql.append("and state not in(");
			}
		} else {
			sql = new StringBuffer(
					"select count(*) from PUBLIC_VIEWS.vUpdateInstallationInfo where 1=1 and ComputerTargetId ='"
							+ computerID + "'");
			if (type.equalsIgnoreCase("inCount")) {
				sql.append("and state in(");
			} else {
				sql.append("and state not in(");
			}
		}

		for (int i = 0; i < states.length; i++) {
			sql.append(states[i] + ",");
		}
		int index = sql.lastIndexOf(",");
		System.out
				.println("SensorClientsPatchDaoImpl:getSqlPatchUpdateInfo():SQL:"
						+ sql);
		return sql.substring(0, index) + ")";
	}

	/**
	 * 拼接SQL语句，PatchInfo
	 * 
	 * @return
	 */
	private static String getSqlByPatchInfo(String declined, String type) {
		// SQL语句
		StringBuffer sql = null;

		// select * from xx where 1=1 and state in (states);
		if (!type.equalsIgnoreCase("count")) {
			sql = new StringBuffer(
					"select UpdateId, RevisionNumber, DefaultTitle, DefaultDescription, ClassificationId, ArrivalDate, CreationDate, IsDeclined, IsWsusInfrastructureUpdate, MsrcSeverity, PublicationState, UpdateType, UpdateSource, KnowledgebaseArticle, SecurityBulletin, InstallationCanRequestUserInput, InstallationRequiresNetworkConnectivity, InstallationImpact, InstallationRebootBehavior from PUBLIC_VIEWS.vUpdate where 1=1 ");
			if (declined != null) {
				sql.append("and IsDeclined='" + declined + "'");
			}
		} else {
			sql = new StringBuffer(
					"select count(*) from PUBLIC_VIEWS.vUpdate where 1=1 ");
			if (declined != null) {
				sql.append("and IsDeclined='" + declined + "'");
			}
		}
		System.out.println("SensorClientsPatchDaoImpl:getSqlByPatchInfo():SQL:"
				+ sql);
		return sql.toString();
	}

	/**
	 * 拼接SQL语句(分页)
	 * 
	 * @param states
	 * @return
	 */
	private static String getSqlPatchUpdateInfo(String computerID, String type,
			int[] states, PMPage page) {
		// SQL语句
		StringBuffer sql = null;
		
		// 如果没有状态值，就返回所有记录
		if (states.length <= 0) {
			if (type.equalsIgnoreCase("in") || type.equalsIgnoreCase("notIn")) {
				/*sql = new StringBuffer(
						"select top "
								+ page.getEveryPage()
								+ " UpdateId, ComputerTargetId, State from PUBLIC_VIEWS.vUpdateInstallationInfo where UpdateId not in( select top (("
								+ page.getCurrentPage()
								+ "-1)*"
								+ page.getEveryPage()
								+ ") UpdateId from PUBLIC_VIEWS.vUpdateInstallationInfo) and ComputerTargetId='"
								+ computerID + "'");*/
				sql = new StringBuffer(
						"select top "
							+ page.getEveryPage()
							+ " UpdateId, ComputerTargetId, State from (select top ("+page.getCurrentPage()+"*"+page.getEveryPage()+") ROW_NUMBER() OVER (order by updateId) as id,UpdateId, ComputerTargetId, State from PUBLIC_VIEWS.vUpdateInstallationInfo) as UpdateInstallationInfo" 
							+ " where id > (("+page.getCurrentPage()+"-1)*"+page.getEveryPage()+")");
			} else {
				sql = new StringBuffer(
						"select count(UpdateId) from PUBLIC_VIEWS.vUpdateInstallationInfo where ComputerTargetId='"
								+ computerID + "'");
			}
			return sql.toString();
		}
		
		// select * from xx where 1=1 and state in (states);
		if (type.equalsIgnoreCase("in") || type.equalsIgnoreCase("notIn")) {
			/*旧分页语句，效率较低
			 * sql = new StringBuffer(
					"select top "
							+ page.getEveryPage()
							+ " UpdateId, ComputerTargetId, State from PUBLIC_VIEWS.vUpdateInstallationInfo where UpdateId not in( select top (("
							+ page.getCurrentPage()
							+ "-1)*"
							+ page.getEveryPage()
							+ ") UpdateId from PUBLIC_VIEWS.vUpdateInstallationInfo) and ComputerTargetId='"
							+ computerID + "'");*/
			//新分页语句，效率较高
			sql = new StringBuffer(
					"select top "
						+ page.getEveryPage()
						+ " UpdateId, ComputerTargetId, State from (select top ("+page.getCurrentPage()+"*"+page.getEveryPage()+") ROW_NUMBER() OVER (order by updateId) as id,UpdateId, ComputerTargetId, State from PUBLIC_VIEWS.vUpdateInstallationInfo) as UpdateInstallationInfo" 
						+ " where id > (("+page.getCurrentPage()+"-1)*"+page.getEveryPage()+")");
			if (type.equalsIgnoreCase("in")) {
				sql.append("and state in(");
			} else {
				sql.append("and state not in(");
			}
		} else {
			sql = new StringBuffer(
					"select count(*) from PUBLIC_VIEWS.vUpdateInstallationInfo where 1=1 and ComputerTargetId ='"
							+ computerID + "'");
			if (type.equalsIgnoreCase("inCount")) {
				sql.append("and state in(");
			} else {
				sql.append("and state not in(");
			}
		}

		for (int i = 0; i < states.length; i++) {
			sql.append(states[i] + ",");
		}
		int index = sql.lastIndexOf(",");
		System.out
				.println("SensorClientsPatchDaoImpl:getSqlPatchUpdateInfo():SQL:"
						+ sql);
		return sql.substring(0, index) + ")";
	}

	/**
	 * 拼接SQL语句，PatchInfo（分页）
	 * 
	 * @return
	 */
	private static String getSqlByPatchInfo(String declined, String type,
			Page page) {
		// SQL语句
		StringBuffer sql = null;

		// select * from xx where 1=1 and state in (states);
		if (!type.equalsIgnoreCase("count")) {
			/*原有分页语句（效率太低）
			sql = new StringBuffer(
					"select top "
							+ page.getEveryPage()
							+ " UpdateId, RevisionNumber, DefaultTitle, DefaultDescription, ClassificationId, ArrivalDate, CreationDate, IsDeclined, IsWsusInfrastructureUpdate, MsrcSeverity, PublicationState, UpdateType, UpdateSource, KnowledgebaseArticle, SecurityBulletin, InstallationCanRequestUserInput, InstallationRequiresNetworkConnectivity, InstallationImpact, InstallationRebootBehavior from PUBLIC_VIEWS.vUpdate where UpdateId not in (select top (("
							+ page.getCurrentPage() + "-1)*" + page.getEveryPage()
							+ ") UpdateId from PUBLIC_VIEWS.vUpdate)");*/
			
			//新分页查询语句（2010.6.30:xy）
			sql = new StringBuffer(
					"select top "+page.getEveryPage()+" * from ( select top ("+page.getCurrentPage()+"*"+page.getEveryPage()+") ROW_NUMBER() OVER (order by PUBLIC_VIEWS.vUpdate.updateId) as id,PUBLIC_VIEWS.vUpdate.UpdateId, PUBLIC_VIEWS.vUpdate.RevisionNumber,Title as DefaultTitle,Description as DefaultDescription,ClassificationId, ArrivalDate, CreationDate, IsDeclined, IsWsusInfrastructureUpdate, MsrcSeverity, PublicationState, UpdateType, UpdateSource, KnowledgebaseArticle, SecurityBulletin, InstallationCanRequestUserInput, InstallationRequiresNetworkConnectivity, InstallationImpact, InstallationRebootBehavior from PUBLIC_VIEWS.vUpdate"
					+" join" 
					+" vwUpdateLocalizedProperties on (PUBLIC_VIEWS.vUpdate.UpdateId=vwUpdateLocalizedProperties.UpdateId) where ShortLanguage = 'zh-cn') as vUpdate"
					+" where id > (("+page.getCurrentPage()+" - 1) * "+page.getEveryPage()+")");
			if (declined != null) {
				sql.append("and IsDeclined='" + declined + "'");
			}
		} else {
			sql = new StringBuffer(
					"select count(*) from PUBLIC_VIEWS.vUpdate where 1=1 ");
			if (declined != null) {
				sql.append("and IsDeclined='" + declined + "'");
			}
		}
		System.out.println("SensorClientsPatchDaoImpl:getSqlByPatchInfo():SQL:"
				+ sql);
		return sql.toString();
	}

	public static void main(String[] args) throws Exception {
		Page page = new Page();
		page.setEveryPage(10);
		page.setCurrentPage(2);
		String sql = getSqlByPatchInfo("false","in",page);
		System.out.println(sql);
	}

}
