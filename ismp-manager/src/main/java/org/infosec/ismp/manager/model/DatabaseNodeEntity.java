package org.infosec.ismp.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_node_entity")
public class DatabaseNodeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String domain;
	private String nodeid;
	@Column(name = "db_interval")
	private Long interval;
	private String url;
	private Integer port;
	private String username;
	private String password;
	private String driver;
	private String dbtype;
	private String version;
	private String dbname;
	private Boolean halfWhenDown;
	
	public Integer getId() {
		return id;
	}

	public String getDomain() {
		return domain;
	}
	public String getNodeid() {
		return nodeid;
	}
	public Long getInterval() {
		return interval;
	}
	public String getUrl() {
		return url;
	}
	public Integer getPort() {
		return port;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getDriver() {
		return driver;
	}
	public String getDbtype() {
		return dbtype;
	}
	public String getVersion() {
		return version;
	}
	public String getDbname() {
		return dbname;
	}
	public Boolean getHalfWhenDown() {
		return halfWhenDown;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}
	public void setInterval(Long interval) {
		this.interval = interval;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public void setDbtype(String dbtype) {
		this.dbtype = dbtype;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public void setHalfWhenDown(Boolean halfWhenDown) {
		this.halfWhenDown = halfWhenDown;
	}
	


}
