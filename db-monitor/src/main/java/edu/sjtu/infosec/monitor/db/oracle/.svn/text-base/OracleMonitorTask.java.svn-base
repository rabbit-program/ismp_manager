package edu.sjtu.infosec.monitor.db.oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.monitor.db.model.OracleStatus;
import edu.sjtu.infosec.monitor.db.model.TableSpaceUser;
import edu.sjtu.infosec.monitor.db.utils.ConnectionUtil;

public class OracleMonitorTask implements Runnable {

	private ResultSet rs = null;

	public void run() {
		ConnectionUtil conn = null;
		conn = new ConnectionUtil("application.properties");
		try {
			 Integer sessionNum = getSessionNum(conn); 						// 获取Session数
			 Map<String, Integer> map = getLockNum(conn); 					// 获取各项锁数量
			 Integer deadLockNum = getDeadLockNum(conn); 					// 获取死锁数量
			 double cache = getCache(conn);									 // 获取命中率
			 double cpu = getCPU(conn);										 // 获取CUP使用情況
			Integer transactionNum = getTransactionNum(conn);				 // 获取事物数
			List<TableSpaceUser> list = getTableSpaces(conn); 				// 获取表空间使用情况
			double processMem = getProcessMem(conn);					  	//获取进程消耗的内存情况
			
			OracleStatus os = new OracleStatus();
			os.setCache(cache);
			os.setCpu(cpu);
			os.setDeadlock(deadLockNum);
			os.setLockNum(map);
			os.setOracleSessionNum(sessionNum);
			os.setProcessMem(processMem);
			os.setTableSpaces(list);
			os.setTransactionNum(transactionNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取Session数
	 * 
	 * @param sql
	 * @return
	 */
	private Integer getSessionNum(ConnectionUtil conn) throws Exception {
		Integer sessionNum = null;
		String sql = "select count(*) from v$session where type='USER'";
		rs = conn.getData(sql);
		while (rs.next()) {
			sessionNum = rs.getInt(1);
		}
		return sessionNum;
	}

	/**
	 * 获取各类锁的数量
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	private Map<String, Integer> getLockNum(ConnectionUtil conn)
			throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql = "select t1.LOCKED_MODE,sum(t1.LOCKED_MODE) "
				+ "from v$locked_object t1,v$session t2 "
				+ "where t1.session_id=t2.sid " + "group by t1.LOCKED_MODE";
		rs = conn.getData(sql);
		while (rs.next()) {
			String typeName = rs.getString(1);
			Integer typeNum = rs.getInt(2);
			map.put(typeName, typeNum);
		}
		return map;
	}

	/**
	 * 获取死锁数量
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	private Integer getDeadLockNum(ConnectionUtil conn) throws Exception {
		Integer deadLockNum = null;
		String sql = "select count(*) from v$locked_object";
		rs = conn.getData(sql);
		while (rs.next()) {
			deadLockNum = rs.getInt(1);
		}
		return deadLockNum;
	}

	/**
	 * 獲取Cache命中率
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	private double getCache(ConnectionUtil conn) throws Exception {
		double cache = 0.0;
		String sql = "SELECT 1 - (PHYSICAL_READS / (DB_BLOCK_GETS + CONSISTENT_GETS)) "
				+ "FROM V$BUFFER_POOL_STATISTICS " 
				+ "WHERE NAME='DEFAULT'";
		rs = conn.getData(sql);
		while (rs.next()) {
			cache = rs.getDouble(1);
		}
		return cache;
	}

	/**
	 * 獲取CPU使用情況
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	private double getCPU(ConnectionUtil conn) throws Exception {
		double cpu = 0.0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		String sql = "select stat_name,value from v$osstat where stat_name in('AVG_BUSY_TIME','AVG_IDLE_TIME')";
		rs = conn.getData(sql);
		while (rs.next()) {
			String name = rs.getString(1);
			Integer value = rs.getInt(2);
			map.put(name, value);
		}
		 cpu = Double.parseDouble(map.get("AVG_BUSY_TIME").toString())/(map.get("AVG_BUSY_TIME")+map.get(
		 "AVG_IDLE_TIME"));
		return cpu;
	}

	/**
	 * 获取事物数
	 * 
	 * @param conn
	 * @return
	 * @throws Exceptionn
	 */
	private Integer getTransactionNum(ConnectionUtil conn) throws Exception {
		Integer transactionNum = null;
		String sql = "select count(*) from v$Transaction";
		rs = conn.getData(sql);
		while (rs.next()) {
			transactionNum = rs.getInt(1);
		}
		return transactionNum;
	}

	/**
	 * 获取表空间使用情况
	 * 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	private List<TableSpaceUser> getTableSpaces(ConnectionUtil conn)
			throws Exception {
		List<TableSpaceUser> list = new ArrayList<TableSpaceUser>();
		String sql = "SELECT UPPER(F.TABLESPACE_NAME),"
				+ "D.TOT_GROOTTE_MB,"
				+ "D.TOT_GROOTTE_MB - F.TOTAL_BYTES,"
				+ "TO_CHAR(ROUND((D.TOT_GROOTTE_MB - F.TOTAL_BYTES) / D.TOT_GROOTTE_MB * 100,2),'990.99') || '%',"
				+ "F.TOTAL_BYTES " 
				+ "FROM (SELECT TABLESPACE_NAME,"
				+ "ROUND(SUM(BYTES) / (1024 * 1024), 2) TOTAL_BYTES,"
				+ "ROUND(MAX(BYTES) / (1024 * 1024), 2) MAX_BYTES "
				+ "FROM SYS.DBA_FREE_SPACE " 
				+ "GROUP BY TABLESPACE_NAME) F,"
				+ "(SELECT DD.TABLESPACE_NAME,"
				+ "ROUND(SUM(DD.BYTES) / (1024 * 1024), 2) TOT_GROOTTE_MB "
				+ "FROM SYS.DBA_DATA_FILES DD "
				+ "GROUP BY DD.TABLESPACE_NAME) D "
				+ "WHERE D.TABLESPACE_NAME = F.TABLESPACE_NAME ORDER BY 1";
		rs = conn.getData(sql);
		while (rs.next()) {
			TableSpaceUser tb = new TableSpaceUser();
			tb.setName(rs.getString(1));
			tb.setSize(rs.getDouble(2));
			tb.setUsed(rs.getDouble(3));
			tb.setUsedPercent(rs.getString(4));
			tb.setFree(rs.getDouble(5));
			list.add(tb);
		}
		return list;
	}

	/**
	 * 获取进程消耗的内存情况
	 * 
	 * @return
	 * @throws Exception
	 */
	private double getProcessMem(ConnectionUtil conn) throws Exception {
		double processMem = 0;
		String sql = "select sum(pga_used_mem)/(1024*1024) from v$process "
				+ "group by program " + "having program = 'ORACLE.EXE (SHAD)'";
		rs = conn.getData(sql);
		while (rs.next()) {
			processMem = rs.getDouble(1);
		}
		return processMem;
	}

}
