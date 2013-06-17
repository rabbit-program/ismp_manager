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
 * 业务影响分析(BIA)
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "erm_bia")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class ContiBia implements Serializable {
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
	 * 业务过程
	 */
    @Column(name="business")
	private String business;
	/**
	 *优先级（高/中/低）
	 */
    @ManyToOne 
    @JoinColumn(name="priority_level_id")
	private PriorityLevel priorityLevel;
	/**
	 *关键资产
	 */
    @Column(name="assets")
	private String assets;
	/**
	 * 恢复时间目标
	 */
    @Column(name="rto")
	private int rto;

	/**
	 *恢复时间点目标
	 */
    @Column(name="rtpo")
	private int rtpo;
	
	
	
	

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

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public PriorityLevel getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(PriorityLevel priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public String getAssets() {
		return assets;
	}

	public void setAssets(String assets) {
		this.assets = assets;
	}

	public int getRto() {
		return rto;
	}

	public void setRto(int rto) {
		this.rto = rto;
	}

	public int getRtpo() {
		return rtpo;
	}

	public void setRtpo(int rtpo) {
		this.rtpo = rtpo;
	}
}
