package edu.sjtu.infosec.ismp.manager.WSM.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 网站安全检测记录
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "wsm_web_monitor_records")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class WebMonitorRecords implements Serializable {
	/**
	 * ID
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
	private Integer id;
	/**
	 * 所属域
	 */
	@ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
	/**
	 * 编号
	 */
    @Column(name="sn" , length = 20)
	private String sn;
	/**
	 * 名称
	 */
    @Column(name="name" , length = 20)
	private String name;
	/**
	 * 描述
	 */
    @Column(name="description", length = 500)
	private String desc;
	/**
	 * URL
	 */
    @Column(name="url" , length = 500)
	private String url;
	/**
	 * 轮询时间
	 */
    @Column(name="time_interval")
	private int timeInterval;
	/**
	 * 超时时间
	 */
    @Column(name="time_out")
	private int timeOut;

	/**
	 * 在线状态
	 * 0：不在线
	 * 1：在线
	 */
    @Column(name="online_state")
	private int onlineState;
	/**
	 * 响应时间
	 */
    @Column(name="resp_time")
	private int respTime;
	/**
	 * 页面变更md5编码
	 */
    @Column(name="change_code", length = 255)
	private String changeCode;
   
    /**
	 * nodeId对应拓扑管理
	 */
    @Column(name="node_id",length = 500)
	private String nodeId;
	/**
	 * 创建时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
	/**
	 * 最后修改时间
	 */
    @Column(name="last_update_time")
	private Timestamp lastUpdateTime;
	/**
	 * 备注
	 */
    @Column(name="remark", length = 255)
	private String remark;
    
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
	}
	public int getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	public int getOnlineState() {
		return onlineState;
	}
	public void setOnlineState(int onlineState) {
		this.onlineState = onlineState;
	}
	public int getRespTime() {
		return respTime;
	}
	public void setRespTime(int respTime) {
		this.respTime = respTime;
	}
	public String getChangeCode() {
		return changeCode;
	}
	public void setChangeCode(String changeCode) {
		this.changeCode = changeCode;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
}
