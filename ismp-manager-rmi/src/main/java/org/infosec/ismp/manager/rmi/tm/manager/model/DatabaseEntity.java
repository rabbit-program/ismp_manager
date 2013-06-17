package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 数据库实体
 * @author 肖高峰
 */
@Entity
@Table(name = "tm_topo_manager_database")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class DatabaseEntity implements Serializable{

	private static final long serialVersionUID = 1993458227114034873L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="database_id") 
	private Long databaseId;		
	/**
	 * node 外键
	 */
	@OneToOne
	@JoinColumn(name = "node_id")
	private NodeEntity node;
	
	/**
	 * 显示标识名
	 */
	@Column(name="display_name", length=100)
	private String displayName;		
	
	/**
	 * 数据名称
	 */
	@Column(name="database_name", length=100)
	private String databaseName;		
	
	/**
	 * IP地址
	 */
	@Column(name="ip", length=20)
	private String ip;		
	/**
	 * 端口
	 */
	private Integer port;
	
	/**
	 * 数据库驱动
	 */
	@Column(name="driver", length=100)
	private String driver;		
	
	/**
	 * 数据库url
	 */
	@Column(name="url", length=100)
	private String url;		
	
	/**
	 * 数据库用户名
	 */
	@Column(name="username", length=100)
	private String username; 		
	
	/**
	 * 数据库密码
	 */
	@Column(name="password", length=80)
	private String password;		
	
	/**
	 * 在线轮询时间
	 */
	@Column(name="up_interval")
	private Long upInterval;			
	
	/**
	 * 下线轮询时间
	 */
	@Column(name="down_interval")
	private Long downInterval;		
	
	/**
	 * 数据库类型
	 */
	@Column(name="type", length=20)
	private String type;		
	
	/**
	 * 数据库版本
	 */
	@Column(name="version", length=50)
	private String version;		
	
	
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Long getDatabaseId() {
		return databaseId;
	}

	public NodeEntity getNode() {
		return node;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public String getIp() {
		return ip;
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public long getUpInterval() {
		return upInterval;
	}

	public long getDownInterval() {
		return downInterval;
	}

	public String getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}
	
	
	public void setDatabaseId(Long databaseId) {
		this.databaseId = databaseId;
	}

	public void setNode(NodeEntity node) {
		this.node = node;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUpInterval(Long upInterval) {
		this.upInterval = upInterval;
	}

	public void setDownInterval(Long downInterval) {
		this.downInterval = downInterval;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		
		if (other == null) {
			return false;
		}
		
		if (! (other instanceof DatabaseEntity)) {
			return false;
		}
		
		DatabaseEntity database = (DatabaseEntity) other;
		if ((database.ip == this.ip) 
				&& (database.node == this.node)
				&& (database.displayName == this.displayName) 
				&& (database.databaseName == this.databaseName) 
				&& (database.type == this.type) 
				&& (database.password == this.password) 
				&& (database.version == this.version)
				&& (database.driver == this.driver)
				&& (database.upInterval == this.upInterval)
				&& (database.username == this.username)) {
			return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		final int constant = 37;
		int total = 17;
		
		total = constant * total + ((ip == null) ? 0 : ip.hashCode());
		total = constant * total + ((databaseId == null) ? 0 : databaseId.hashCode());
		total = constant * total + ((displayName == null) ? 0 : displayName.hashCode());
		total = constant * total + ((databaseName == null) ? 0 : databaseName.hashCode());
		total = constant * total + ((type == null) ? 0 : type.hashCode());
		total = constant * total + ((version == null) ? 0 : version.hashCode());
		total = constant * total + ((node == null) ? 0 : node.hashCode());
		total = constant * total + ((password == null) ? 0 : password.hashCode());
		total = constant * total + ((this.driver == null) ? 0 : driver.hashCode());
		total = constant * total + ((this.upInterval == null) ? 0 : upInterval.hashCode());
		total = constant * total + ((this.username == null) ? 0 : username.hashCode());
		
		return total;
	}

	@Override
	public String toString() {
		StringBuffer value = new StringBuffer(this.getClass().toString());
		
		value.append(", nodeId = " + node );
		value.append(",  ip = " + ip);
		value.append(", displayName = " + displayName);
		value.append(", databaseName = " + databaseName);
		value.append(", password = " + password);
		value.append(", type = " + type);
		value.append(", version = " + version);
		
		return value.toString();
	}
}
