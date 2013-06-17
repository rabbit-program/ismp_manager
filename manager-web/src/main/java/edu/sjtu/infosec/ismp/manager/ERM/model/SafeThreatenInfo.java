package edu.sjtu.infosec.ismp.manager.ERM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 安全威胁表
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "erm_safe_threaten_info")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SafeThreatenInfo implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 描述
	 */
    @Column(name="desc")
	private String desc;
	
	
	
	
	
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
