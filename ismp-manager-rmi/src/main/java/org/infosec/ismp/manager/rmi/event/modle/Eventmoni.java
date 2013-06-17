package org.infosec.ismp.manager.rmi.event.modle;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Eventmoni entity.
 * 
 * 事件监测表，表的每个元组表示一台设备上的事件监测情况。
 * 
 * @author 林超 2010-11-18
 */
@Entity
@Table(name = "em_event_moni")
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
public class Eventmoni implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3783832626454543480L;

	/**
	 * 记录编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * 设备ID，唯一标识一个设备
	 */
	@Column(name = "faci_id", length = 20)
	private String faciId;

	/**
	 * 设备名称
	 */
	@Column(name = "faci_name", length = 20)
	private String faciName;

	/**
	 * 设备IP地址
	 */
	@Column(name = "faci_ip", length = 20, nullable = false)
	private String faciIp;

	/**
	 * 设备中的事件量初值
	 */
	@Column(name = "init_value")
	private Integer initValue;

	/**
	 * 设备中的事件量当前值
	 */
	@Column(name = "curr_value", nullable = false)
	private Integer currValue;

	/**
	 * 事件量增长幅度
	 */
	@Column(name = "rangee", length = 4)
	private Double range;

	/**
	 * 设备中的事件总量
	 */
	@Column(name = "total_value", nullable = false)
	private Integer totalValue;

	/**
	 * 进行事件监测分析时当前切点的时间
	 */
	@Column(name = "time", nullable = false)
	private Timestamp time;

	/**
	 * 设备中的事件量最大值
	 */
	@Column(name = "max_value")
	private Integer maxValue;

	/**
	 * 设备中的事件量最小值
	 */
	@Column(name = "min_value")
	private Integer minValue;

	/**
	 * 事件冗余度
	 */
	@Column(name = "redundance")
	private Float redundance;

	/**
	 * 设备中事件的威胁等级
	 */
	@Column(name = "thre_rank", nullable = false)
	private Integer threRank;

	/**
	 * 事件类型，可能是一系列类型的集合
	 */
	@Column(name = "type", length = 1024)
	private String type;

	/**
	 * 设备可用度
	 */
	@Column(name = "faci_avai")
	private Double faciAvai;

	/**
	 * bureauId
	 */
	@Column(name="domain")
	private String domain;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFaciId() {
		return faciId;
	}

	public void setFaciId(String faciId) {
		this.faciId = faciId;
	}

	public String getFaciName() {
		return faciName;
	}

	public void setFaciName(String faciName) {
		this.faciName = faciName;
	}

	public String getFaciIp() {
		return faciIp;
	}

	public void setFaciIp(String faciIp) {
		this.faciIp = faciIp;
	}

	public Integer getInitValue() {
		return initValue;
	}

	public void setInitValue(Integer initValue) {
		this.initValue = initValue;
	}

	public Integer getCurrValue() {
		return currValue;
	}

	public void setCurrValue(Integer currValue) {
		this.currValue = currValue;
	}

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public Integer getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Integer totalValue) {
		this.totalValue = totalValue;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public Integer getMinValue() {
		return minValue;
	}

	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	public Float getRedundance() {
		return redundance;
	}

	public void setRedundance(Float redundance) {
		this.redundance = redundance;
	}

	public Integer getThreRank() {
		return threRank;
	}

	public void setThreRank(Integer threRank) {
		this.threRank = threRank;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getFaciAvai() {
		return faciAvai;
	}

	public void setFaciAvai(Double faciAvai) {
		this.faciAvai = faciAvai;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
