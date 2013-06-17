package org.infosec.ismp.manager.rmi.sysm.config.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统配置-数据传输
 * @author Wu Guojie
 * @date 2010-12-29
 * @version 1.0
 */
@Entity
@Table(name = "sysm_config_data_syn")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SysConfigDataSyn implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 配置命名
	 */
    @Column(name="name")
	private String name;
	/**
	 * center端IP
	 */
    @Column(name="center_ip")
	private String centerIp;
	/**
	 * 数据通信端口
	 */
    @Column(name="data_syn_port")
	private String dataSynPort;
	/**
	 * 备注
	 */
    @Column(name="remarks")
	private String remarks;
    
    
    
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCenterIp() {
		return centerIp;
	}
	public void setCenterIp(String centerIp) {
		this.centerIp = centerIp;
	}
	public String getDataSynPort() {
		return dataSynPort;
	}
	public void setDataSynPort(String dataSynPort) {
		this.dataSynPort = dataSynPort;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
