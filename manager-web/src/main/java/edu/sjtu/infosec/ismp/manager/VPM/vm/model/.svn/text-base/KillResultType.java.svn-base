package edu.sjtu.infosec.ismp.manager.VPM.vm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 病毒查杀结果类型
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "vpm_vm_kill_result_type")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class KillResultType implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 编码
	 */
    @Column(name="code")
	private String code;
	/**
	 * 名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 简介
	 */
    @Column(name="summary")
	private String summary;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
