package edu.sjtu.infosec.monitor.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Rocky
 * @version create time：Aug 3, 2010 9:23:55 PM
 * 
 * 数据库操作的工具类
 */
public class ConnectionUtil {
	
	private Connection connection = null;
	private PreparedStatement stat = null;
	private String driver = null;

	private String url = null;
	private String username = null;
	private String password = null;
	private PropertiesUtil properties = new PropertiesUtil();

	public ConnectionUtil(String configName) {
		loadConfig(configName);
		connection = getConnection(driver, url, username, password);
	}

	private void loadConfig(String configName) {
		Properties prop = properties.load(configName);

		driver = prop.getProperty("jdbc.orcale.driver");
		url = prop.getProperty("jdbc.orcale.url");
		username = prop.getProperty("jdbc.orcale.username");
		password = prop.getProperty("jdbc.orcale.password");
	}

	private Connection getConnection(String driver, String url,
			String username, String password) {
		Connection conn = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO
			System.err.println("getDataSource() error: " + e);
		}

		return conn;
	}

	/**
	 * 统一负责去数据库中获取数据
	 * 
	 * @param sql
	 *            sql语句
	 * @return 结果集
	 * @throws Exception
	 */
	public ResultSet getData(String sql, Object... parameters) {
		ResultSet rs = null;
		
		try {
			if (sql == null || "".equals(sql.trim())) {
				throw new SQLException("sql is null.");
			}
			
			stat = connection.prepareStatement(sql);
			
			for (int i = 0; i < parameters.length; i++) {
				stat.setObject(i + 1, parameters[i]);
			}
			
			rs = stat.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rs;
	}

	public void close() {
		try {
			if (stat != null) {
				stat.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static void main(String[] args) {
		ConnectionUtil cu = new ConnectionUtil("dataSyncToCenter.properties");

		Connection c = cu.getConnection();
		if (c != null) {
			System.out.println("Connection OK!");
		}
	}
}
