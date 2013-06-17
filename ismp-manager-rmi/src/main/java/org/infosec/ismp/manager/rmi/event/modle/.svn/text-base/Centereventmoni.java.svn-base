package org.infosec.ismp.manager.rmi.event.modle;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Eventmoni entity.
 * 
 * 事件监测表，表的每个元组表示一台设备上的事件监测情况。
 * 
 * @author wudengke 2009-6-1
 */
@Entity
@Table(name = "em_center_event_moni")
@org.hibernate.annotations.Entity(dynamicInsert=true,dynamicUpdate=true)
public class Centereventmoni extends Object implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4337669242208320950L;

	/**
	 * 记录编号
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/**
	 * 事件量初值
	 */
	@Column(name = "init_value", nullable = false)
	private Integer initValue;

	/**
	 * 事件量当前值
	 */
	@Column(name = "curr_value", nullable = false)
	private Integer currValue;

	/**
	 * 事件量增长幅度
	 */
	@Column(name = "rangee", length = 4, nullable = false)
	private Double range;

	/**
	 * 事件总量
	 */
	@Column(name = "total_value", nullable = false)
	private Integer totalValue;

	/**
	 * 进行事件监测分析时当前切点的时间
	 */
	@Column(name = "time", nullable = false)
	private Timestamp time;

	/**
	 * 事件量最大值
	 */
	@Column(name = "max_value", nullable = false)
	private Integer maxValue;

	/**
	 * 事件量最小值
	 */
	@Column(name = "min_value", nullable = false)
	private Integer minValue;

	/**
	 * 事件冗余度
	 */
	@Column(name = "redundance", nullable = false)
	private Float redundance;

	/**
	 * 事件的威胁等级
	 */
	@Column(name = "thre_rank", nullable = false)
	private Integer threRank;

	/**
	 * 事件类型，可能是一系列类型的集合
	 */
	@Column(name = "type", length = 1024, nullable = false)
	private String type;

	/**
	 * 可用度
	 */
	@Column(name = "faci_avai", nullable = false)
	private Double faciRvai;

	/**
	 * 表明不同的单位ID
	 */
	@Column(name = "bureau_id",nullable = false)
	private String bureauId;

	/**
	 * 表明不同的单位，如：＂委办局１＂，＂委办局２＂
	 */
	@Column(name = "bureau_name", length = 20,nullable = false)
	private String bureauName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Double getFaciRvai() {
		return faciRvai;
	}

	public void setFaciRvai(Double faciRvai) {
		this.faciRvai = faciRvai;
	}

	public String getBureauId() {
		return bureauId;
	}

	public void setBureauId(String bureauId) {
		this.bureauId = bureauId;
	}

	public String getBureauName() {
		return bureauName;
	}

	public void setBureauName(String bureauName) {
		this.bureauName = bureauName;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Centereventmoni)) {
			return false;
		}
		Centereventmoni evt = (Centereventmoni) other;
		return new EqualsBuilder().append(this.initValue, evt.initValue)
				.append(this.currValue, evt.currValue).append(this.range,
						evt.range).append(this.totalValue, evt.totalValue)
				.append(this.time, evt.time)
				.append(this.maxValue, evt.maxValue).append(this.minValue,
						evt.minValue).append(this.redundance, evt.redundance)
				.append(this.threRank, evt.threRank)
				.append(this.type, evt.type)
				.append(this.faciRvai, evt.faciRvai).append(this.bureauId,
						evt.bureauId).append(this.bureauName, evt.bureauName)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.initValue).append(
				this.currValue).append(this.range).append(this.totalValue)
				.append(this.maxValue).append(this.minValue).append(
						this.redundance).append(this.threRank)
				.append(this.type).append(this.faciRvai).append(this.bureauId)
				.append(bureauName).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(id).append(this.initValue)
				.append(this.currValue).append(this.range).append(
						this.totalValue).append(this.maxValue).append(
						this.minValue).append(this.redundance).append(
						this.threRank).append(this.type).append(this.faciRvai)
				.append(this.bureauId).append(bureauName).toString();
	}

}
