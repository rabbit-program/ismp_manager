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

import org.hibernate.annotations.Type;

/**
 * 文件打印
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "erm_resp_file_print")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class RespFilePrint implements Serializable {
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
	 *预案文件内容
	 */
	@Column(name = "content")
	@Type(type="text")
	private String content;
	
	
	
	
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
