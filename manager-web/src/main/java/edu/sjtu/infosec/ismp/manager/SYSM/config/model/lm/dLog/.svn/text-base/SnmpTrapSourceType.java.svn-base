package edu.sjtu.infosec.ismp.manager.SYSM.config.model.lm.dLog;

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

@Entity
@Table(name="lm_dlog_snmptrap_source_type")
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true)
public class SnmpTrapSourceType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9020760494445157640L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	/**
	 * 日志源类型 名称
	 */
	@Column(name="source_type_name")
	private String sourceTypeName;
	
	/**
	 * 创建时间
	 */
	@Column(name="create_time")
	private Timestamp createTime;
	
	/**
	 * 设备类型:IDS
	 */
	@Column(name="type")
	private String type;
	
	/**
	 * 设备的商标、牌子
	 */
	@Column(name="brand")
	private String brand;
	
	/**
	 * 设备品牌的某个型号
	 */
	@Column(name="category")
	private String category;
	
	/**
	 * 此类设备用哪些处理器来进行处理
	 */
	@ManyToOne 
	@JoinColumn(name="handle_type")
	private SnmpTrapSourceHandleOrParser handleOrParserType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceTypeName() {
		return sourceTypeName;
	}

	public void setSourceTypeName(String sourceTypeName) {
		this.sourceTypeName = sourceTypeName;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public SnmpTrapSourceHandleOrParser getHandleOrParserType() {
		return handleOrParserType;
	}

	public void setHandleOrParserType(
			SnmpTrapSourceHandleOrParser handleOrParserType) {
		this.handleOrParserType = handleOrParserType;
	}
	
}
