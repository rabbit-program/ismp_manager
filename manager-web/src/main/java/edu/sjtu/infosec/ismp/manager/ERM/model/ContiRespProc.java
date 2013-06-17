package edu.sjtu.infosec.ismp.manager.ERM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 响应过程
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "erm_resp_proc")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class ContiRespProc implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属预案
	 */
    @ManyToOne 
    @JoinColumn(name="resp_info_id")
	private RespInfoBO respInfo;
	/**
	 * 响应过程名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 响应过程内容
	 */
    @Column(name="content")
	private String content;
	/**
	 * 安全威胁
	 */
    @ManyToOne 
    @JoinColumn(name="safe_threaten_id")
	private SafeThreatenInfo safeThreaten;
    
    
    
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public RespInfoBO getRespInfo() {
		return respInfo;
	}
	public void setRespInfo(RespInfoBO respInfo) {
		this.respInfo = respInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public SafeThreatenInfo getSafeThreaten() {
		return safeThreaten;
	}
	public void setSafeThreaten(SafeThreatenInfo safeThreaten) {
		this.safeThreaten = safeThreaten;
	}
}