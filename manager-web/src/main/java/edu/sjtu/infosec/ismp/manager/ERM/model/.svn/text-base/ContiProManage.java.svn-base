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
 * 应急过程管理
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "erm_pro_manage")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class ContiProManage implements Serializable {
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
	 *事件编号
	 */
    @Column(name="event_id")
	private Integer eventId;
	/**
	 *事件名称
	 */
	@Column(name = "event_name", length = 20, nullable = true)
	private String event_name;
	/**
	 *事件类型
	 */
	@Column(name = "event_type", length =20, nullable = true)
	private String event_type;
	/**
	 *事件内容
	 */
	@Column(name = "event_content")
	@Type(type="text")
	private String eventContent;
	/**
	 * 对应系统
	 */
	@Column(name = "system", length =20, nullable = true)
	private String system;
	/**
	 *协调者的信息
	 */
	@Column(name = "coord_info", length =2000, nullable = true)
	private String coord_info;
	/**
	 * 短信指令内容
	 */
	@Column(name = "notif_msg", length = 2000, nullable = true)
	private String notif_msg;
	/**
	 * 应急通知内容
	 **/
	@Column(name = "process_content", length = 2000, nullable = true)
	private String processContent;
	/**
	 *应急过程总结
	 */
	@Column(name = "resp_summary", length = 2000, nullable = true)
	private String resp_summary;
	
	
	
	
	
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
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getCoord_info() {
		return coord_info;
	}
	public void setCoord_info(String coord_info) {
		this.coord_info = coord_info;
	}
	public String getNotif_msg() {
		return notif_msg;
	}
	public void setNotif_msg(String notif_msg) {
		this.notif_msg = notif_msg;
	}
	public String getProcessContent() {
		return processContent;
	}
	public void setProcessContent(String processContent) {
		this.processContent = processContent;
	}
	public String getResp_summary() {
		return resp_summary;
	}
	public void setResp_summary(String resp_summary) {
		this.resp_summary = resp_summary;
	}
}