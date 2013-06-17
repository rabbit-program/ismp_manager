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

/**
 * SysLog的日志源类型
 * @author Lin Chao
 * @date 2010-09-20
 * @version 1.0
 */
@Entity
@Table(name = "lm_dlog_syslog_source_type")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SysLogSourceType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6428922287711191324L;
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
	 * 设备类型:FireWall、VPN、Audit
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
	private SysLogSourceHandleOrParser handleOrParserType;
	
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

	public SysLogSourceHandleOrParser getHandleOrParserType() {
		return handleOrParserType;
	}

	public void setHandleOrParserType(SysLogSourceHandleOrParser handleOrParserType) {
		this.handleOrParserType = handleOrParserType;
	}
	
}
