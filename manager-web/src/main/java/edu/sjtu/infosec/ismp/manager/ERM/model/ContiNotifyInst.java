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
 * 通知指令
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "erm_notify_inst")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class ContiNotifyInst implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属通知过程
	 */
    @ManyToOne 
    @JoinColumn(name="notify_proc_id")
	private ContiNotifyProc notifyProc;
	/**
	 *通知指令名称
	 */
    @Column(name="name")
	private String name;
	/**
	 *通知指令内容
	 */
    @Column(name="content")
	private String content;
    
    
    
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ContiNotifyProc getNotifyProc() {
		return notifyProc;
	}
	public void setNotifyProc(ContiNotifyProc notifyProc) {
		this.notifyProc = notifyProc;
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
