package org.infosec.ismp.manager.rmi.tm.manager.comm;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库常量类
 * @author 肖高峰
 *
 */
public class DatabaseConst {
	public static final String DATABASE_TYPE_ORACLE = "ORACLE";
	public static final String DATABASE_TYPE_SQL_SERVER = "SQL Server";
	public static final String DATABASE_VERSION_ORACLE_9I = "9i";
	public static final String DATABASE_VERSION_ORACLE_10G = "10g";
	public static final String DATABASE_VERSION_SQL_SERVER_2005 = "2005";
	public static final String DATABASE_VERSION_SQL_SERVER_2000 = "2000";
	public static final String[] DATABASE_TYPE = new String[]{DATABASE_TYPE_ORACLE,DATABASE_TYPE_SQL_SERVER};
	public static final String[] DATABASE_VERSION_ORACLE = new String[]{DATABASE_VERSION_ORACLE_9I,DATABASE_VERSION_ORACLE_10G};
	public static final String[] DATABASE_VERSION_SQL_SERVER = new String[]{DATABASE_VERSION_SQL_SERVER_2000,DATABASE_VERSION_SQL_SERVER_2005};
	public static final Map<String,String[]> DATABASE_TYPE_VERSION = new HashMap<String,String[]>();
	static {
		DATABASE_TYPE_VERSION.put(DATABASE_TYPE[0], DATABASE_VERSION_ORACLE);
		DATABASE_TYPE_VERSION.put(DATABASE_TYPE[1], DATABASE_VERSION_SQL_SERVER);
	}
	
}
