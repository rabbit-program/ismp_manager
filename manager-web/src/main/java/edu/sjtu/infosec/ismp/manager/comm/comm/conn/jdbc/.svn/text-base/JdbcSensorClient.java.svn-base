package edu.sjtu.infosec.ismp.manager.comm.comm.conn.jdbc;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.RowSetDynaClass;
import org.apache.log4j.Logger;
import org.infosec.ismp.manager.rmi.sysm.config.model.SysConfigDb;
import org.infosec.ismp.manager.rmi.sysm.config.service.SysConfigDbService;

public class JdbcSensorClient {
	private static SysConfigDbService sysConfigDbService;
    public static LinkedList<SysConfigDbService> list = new LinkedList<SysConfigDbService>();
	private static Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement prepstmt = null;
	private static Logger logger = Logger.getLogger(JdbcSensorClient.class);
	/**
	 * @param sysConfigDbService the sysConfigDbService to set
	 */
	public static void setSysConfigDbService(SysConfigDbService sysConfigDbService) {
		JdbcSensorClient.sysConfigDbService = sysConfigDbService;
	}
	/**
	 * 以创建Statement 初始化Mysql
	 */
	public JdbcSensorClient() {
		try {
			getDirectConn();
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.err.println("jdbc init error: " + e);
		}
	}

	/*
	 * private void getDataSource() { try { Context ctx = new InitialContext();
	 * if (ctx == null) throw new Exception("Boom - No Context");
	 * 
	 * DataSource ds = (DataSource) ctx .lookup("java:comp/env/jdbc/userDB"); if
	 * (ds != null) conn = ds.getConnection();
	 * 
	 * } catch (Exception e) { System.err.println("getDataSource() error: " +
	 * e); } }
	 */

	// 数据库Connection是使用DataSource接口建立，
	// 它为用户提供的能力比DriverManager提供的基本Connection对象的能力要多得多v
	private static final  Connection getDirectConn() {
		synchronized (list) {
				    ReadProp readProp = new ReadProp();
				    Properties properties = readProp.read();
					String driver = properties.getProperty("Ums.Driver");
					String url = properties.getProperty("Ums.url");
					String username = properties.getProperty("Ums.username");
					String password = properties.getProperty("Ums.password");
				    System.out.println(driver + url + username + password);
				    System.out.println(sysConfigDbService);
				if(list.size() > 0 ){
				     try {
						SysConfigDb  sysConfigDb =	list.getLast().findByName("WSUS");
						driver  = sysConfigDb.getDbDriver();
					     url = sysConfigDb.getDbUrl();
					     username = sysConfigDb.getUsername();
					     password =sysConfigDb.getPassword();
				    	 while (list.size() > 2 ){
				    		 list.remove();
				    	 }
					} catch (Exception e) {
					}
				 }
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("getDataSource() error: " + e);
			}
		}
		return conn;

	}

	/**
	 * 以创建PreparedStatement 初始化Mysql
	 */
	public JdbcSensorClient(String sql) {
		try {
			getDirectConn();
			prepareStatement(sql);
		} catch (Exception e) {
			System.err.println("jdbc init error: " + e);
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public void prepareStatement(String sql) throws SQLException {
		prepstmt = conn.prepareStatement(sql);
	}

	public void setString(int index, String value) throws SQLException {
		prepstmt.setString(index, value);
	}

	public void setInt(int index, int value) throws SQLException {
		prepstmt.setInt(index, value);
	}

	public void setBoolean(int index, boolean value) throws SQLException {
		prepstmt.setBoolean(index, value);
	}

	public void setDate(int index, Date value) throws SQLException {
		prepstmt.setDate(index, value);
	}

	public void setLong(int index, long value) throws SQLException {
		prepstmt.setLong(index, value);
	}

	public void setFloat(int index, float value) throws SQLException {
		prepstmt.setFloat(index, value);
	}

	public void setBinaryStream(int index, InputStream in, int length)
			throws SQLException {
		prepstmt.setBinaryStream(index, in, length);
	}

	public void clearParameters() throws SQLException {
		prepstmt.clearParameters();
	}

	public PreparedStatement getPreparedStatement() {
		return prepstmt;
	}

	public Statement getStatement() {
		return stmt;
	}

	/**
	 * 执行Statement查询语句
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String sql) throws SQLException {
		if (stmt != null) {
			return stmt.executeQuery(sql);
		} else
			return null;
	}

	/**
	 * 执行Statement查询语句
	 * 
	 * @param sql
	 * @return String
	 * @throws SQLException
	 */
	public String executeQueryString(String sql) throws SQLException {
		String value = null;
		ResultSet rs = null;

		try {
			rs = executeQuery(sql);
			if (rs.next()) {
				value = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (rs != null) {
				rs.close();
			}
			close();// 关闭连接
		}
         System.out.println("executeQueryString---------------------------------"+value);
		return value;
	}

	/**
	 * 执行PreparedStatement查询语句
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery() throws SQLException {
		if (prepstmt != null) {
			return prepstmt.executeQuery();
		} else
			return null;
	}

	public List populate(String sql, Class clazz) throws Exception {
		ResultSet rs = executeQuery(sql);
		ResultSetMetaData metaData = rs.getMetaData(); // 取得结果集的元元素
		int colCount = metaData.getColumnCount(); // 取得所有列的个数
		List ret = new ArrayList(); // 存放返回结果的容器
		Field[] fields = clazz.getDeclaredFields(); // 取得业务对象的属性

		while (rs.next()) {
			Object newInstance = clazz.newInstance(); // 构造业务对象实例
			// 将结果集中每一条记录，每一个字段取出，根据命名规则，对对应的业务对象的属性进行赋值
			for (int i = 1; i <= colCount; i++) { // 对于该记录的每一列
				try {
					Object value = rs.getObject(i);
					for (int j = 0; j < fields.length; j++) {
						Field f = fields[j];
						if (f.getName().equalsIgnoreCase(
								metaData.getColumnName(i).replaceAll("_", ""))) {
							if (value == null)
								value = "";
							BeanUtils.copyProperty(newInstance, f.getName(),
									value);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			ret.add(newInstance);
		}
		if (rs != null)
			rs.close();
		close();// 关闭连接
		return ret;
	}

	public static List find(String sSQL, Class elementClass, Object[] objParms)
			throws Exception {
		long begin = System.currentTimeMillis();
		List listReturn = new LinkedList();

		RowSetDynaClass rowset = execQuery(sSQL, objParms);
		RowSetToObjectCollection(rowset, elementClass, listReturn);
		// logger.info("SQL LoG \n SQL = " + sSQL + " Parm Collection Dump -- "
		// + dumpCollection(createParmCollection(objParms)));
		long cost = System.currentTimeMillis() - begin;
		if (cost > 200) {
			logger
					.warn(" ** A find cost over 200ms, please have a check the sql, the reason maybe a bad sql or the sql return a lot of records. sSQL = '"
							+ sSQL
							+ "' Parm Collection Dump -- "
							+ dumpCollection(createParmCollection(objParms))
							+ " ** ");
		} else {
			// logger.debug(" * find cost = '" + cost + "'  * ");
		}
		return listReturn;
	}

	public static Collection createParmCollection(Object[] objParms) {
		Collection col = new LinkedList();
		for (int i = 0; i < objParms.length; i++) {
			Object objParm = objParms[i];
			col.add(objParm);
		}
		return col;
	}

	protected static String dumpCollection(Collection colToDump) {
		if (colToDump == null) {
			return " null collection ";
		} else {
			StringBuffer sbDumpResult = new StringBuffer(" Dump Collection : ");
			int iPos = 0;
			for (Iterator iterator = colToDump.iterator(); iterator.hasNext();) {
				Object emt = iterator.next();
				sbDumpResult.append(++iPos).append(":'").append(emt).append(
						"' ");
			}
			return sbDumpResult.toString();
		}
	}

	public static RowSetDynaClass execQuery(String sSQL, Object[] oaParms)
			throws Exception {
		long begin = System.currentTimeMillis();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getDirectConn();
			pstmt = con.prepareStatement(sSQL,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			int iPos = 0;
			for (int i = 0; i < oaParms.length; i++) {
				Object parm = oaParms[i];
				// NGtodo Change for TEMP. but needed in AIX's weblogic
				if (parm == null) {
					parm = "";
				}
				pstmt.setObject(++iPos, parm);
			}
			rs = pstmt.executeQuery();
			rs.beforeFirst();
			RowSetDynaClass rsdc = new RowSetDynaClass(rs);
			long cost = System.currentTimeMillis() - begin;
			if (cost > 200) {
				logger
						.warn(" ** A execQuery cost over 200ms, please have a check the sql, the reason maybe a bad sql or the sql return a lot of records. sSQL = '"
								+ sSQL
								+ "' Parm Collection Dump -- "
								+ dumpCollection(createParmCollection(oaParms))
								+ " ** ");
			} else {
				// logger.debug(" * execQuery cost = '" + cost + "'  * ");
			}
			return rsdc;
		} catch (SQLException e) {
			logger.error("SQLException \n SQL = " + sSQL
					+ " Parm Collection Dump -- "
					+ dumpCollection(createParmCollection(oaParms)), e);
			throw new Exception("SQLException", e);
		} finally {
			cleanup(pstmt, con, rs);
		}
	}

	/**
	 * Convert RowSet objects to specified javabean collection.
	 * 
	 * @param p_rowset
	 * @param javabeanClass
	 * @param p_colReturn
	 *            this function will add the new instance into this collection.
	 *            Must be Not Null.
	 * @throws Exception
	 */
	private static void RowSetToObjectCollection(RowSetDynaClass p_rowset,
			Class javabeanClass, Collection p_colReturn) throws Exception {
		List rows = p_rowset.getRows();

		try {
			if (rows.size() > 0) {
				for (int i = 0; i < rows.size(); i++) {
					DynaBean dynaBean = (DynaBean) rows.get(i);
					Object javabean = javabeanClass.newInstance();
					populate(javabean, BeanUtils.describe(dynaBean), true);
					p_colReturn.add(javabean);
				}
			}
		} catch (InstantiationException e) {
			logger.error("InstantiationException", e);
			throw new Exception("InstantiationException", e);
		} catch (IllegalAccessException e) {
			logger.error("IllegalAccessException ( class DynaBean )", e);
			throw new Exception("IllegalAccessException", e);
		} catch (NoSuchMethodException e) {
			logger.error("NoSuchMethodException ( class DynaBean )", e);
			throw new Exception("NoSuchMethodException", e);
		}
	}

	/**
	 * Enhance the BeanUtils's populate function to support ignore properties'
	 * case. but before use it, please be sure the bean's field name and the
	 * map's key names has no duplicate. ignoreCase = false 's performance is
	 * better than ignorCase = true.
	 * 
	 * @param beanTo
	 * @param mapFrom
	 * @param ignoreCase
	 *            ignore the properties' names' case or not.
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	private static void populate(Object beanTo, Map mapFrom, boolean ignoreCase)
			throws IllegalAccessException, InvocationTargetException {
		// Do nothing unless both arguments have been specified
		if ((beanTo == null) || (mapFrom == null)) {
			return;
		}

		if (ignoreCase) {
			// Loop through the property name/value pairs to be set
			Iterator names = mapFrom.keySet().iterator();
			Field[] fields = beanTo.getClass().getDeclaredFields();
			Map mapFieldName = new HashMap(fields.length);
			Map mapTypeName = new HashMap();
			for (int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String name = field.getName();
				mapFieldName.put(name.toLowerCase(), name);
				mapTypeName.put(name.toLowerCase(), field.getType());
			}

			while (names.hasNext()) {
				// Identify the property name and value(s) to be assigned
				String name = (String) names.next();
				if (name == null) {
					continue;
				} else if (mapFieldName.get(name.toLowerCase()) == null) {
					continue;
				}
				Class type = (Class) mapTypeName.get(name.toLowerCase());
				if (mapFrom.get(name) == null
						&& java.sql.Timestamp.class.equals(type))
					continue;
				// System.out.println(type.getName());
				Object value = mapFrom.get(name) == null ? "" : mapFrom
						.get(name);
				// Perform the assignment for this property
				BeanUtils.setProperty(beanTo, mapFieldName.get(
						name.toLowerCase()).toString(), value);
			}
			mapFieldName.clear();
		} else {
			BeanUtils.populate(beanTo, mapFrom);
		}
	}

	private static Field[] getFields(Object objToListFields) {
		// after test, use cache is not faster than no cache. JDK1.4.1
		return objToListFields.getClass().getDeclaredFields();
		/*
		 * Field[] FieldsForFrom; Class objFromClass; String objFromClassName =
		 * null; objFromClass = objToListFields.getClass(); objFromClassName =
		 * objFromClass.getName(); FieldsForFrom =
		 * (Field[])ReflectCacheForFields.get(objFromClassName); if (null ==
		 * FieldsForFrom) { FieldsForFrom = objFromClass.getDeclaredFields();
		 * ReflectCacheForFields.put(objFromClassName, FieldsForFrom); } return
		 * FieldsForFrom;
		 */
	}

	/**
	 * 执行Statement更改语句
	 * 
	 * @param sql
	 * @throws SQLException
	 */
	public void executeUpdate(String sql) throws SQLException {
		if (stmt != null)
			stmt.executeUpdate(sql);
		close();// 关闭连接
	}

	/**
	 * 执行PreparedStatement更改语句
	 * 
	 * @throws SQLException
	 */
	public void executeUpdate() throws SQLException {
		if (prepstmt != null)
			prepstmt.executeUpdate();
		close();// 关闭连接
	}

	public final static void cleanup(Statement stmt, Connection conn,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (Exception ex) {
		}
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (Exception e) {
		}
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 关闭连接
	 */
	public void close() {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (prepstmt != null) {
				prepstmt.close();
				prepstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (Exception e) {
			System.err.println("Mysql close error: " + e);
		}

	}
}