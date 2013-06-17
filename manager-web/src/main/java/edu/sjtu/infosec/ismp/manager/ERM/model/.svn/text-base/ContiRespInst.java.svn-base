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
 * 响应指令
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "erm_resp_inst")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class ContiRespInst implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属响应过程
	 */
    @ManyToOne 
    @JoinColumn(name="resp_proc_id")
	private ContiRespProc respProc;
	/**
	 *响应指令名称
	 */
    @Column(name="name")
	private String name;
	/**
	 *响应指令内容
	 */
    @Column(name="content")
	private String content;
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ContiRespProc getRespProc() {
		return respProc;
	}
	public void setRespProc(ContiRespProc respProc) {
		this.respProc = respProc;
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
}
