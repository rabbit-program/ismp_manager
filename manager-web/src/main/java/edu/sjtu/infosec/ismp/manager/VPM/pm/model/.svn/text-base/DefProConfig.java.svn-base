package edu.sjtu.infosec.ismp.manager.VPM.pm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 默认参数配置
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "vpm_pm_def_pro_config")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class DefProConfig implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 配置名
	 */
    @Column(name="pro_name")
	private String proName;
	/**
	 * 配置值
	 */
    @Column(name="pro_value")
	private String proValue;
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
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProValue() {
		return proValue;
	}
	public void setProValue(String proValue) {
		this.proValue = proValue;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
