package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * 拓扑管理设备品牌
 * @author xiaogaofeng
 *
 */
@Entity
@Table(name = "tm_topo_manager_device_brand")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class TradeMarkEntity  implements Serializable {

	private static final long serialVersionUID = 8302815676367941787L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "brand_id")
	private Integer markId;

    /**
	 * 设备名 
	 */
	@Column(name = "name", length = 50)
	private String markName;
	
	 /**
	 * 设备英文名 
	 */
	@Column(name = "english_name", length = 50)
	private String enName;
	
	@Transient
//	private List<DeviceModelEntity> models= new ArrayList<DeviceModelEntity>();

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

//	public List<DeviceModelEntity> getModels() {
//		return models;
//	}
//
//	public void setModels(List<DeviceModelEntity> models) {
//		this.models = models;
//	}

	public Integer getMarkId() {
		return markId;
	}
	
	public void setMarkId(Integer markId) {
		this.markId = markId;
	}

	public String getMarkName() {
		return markName;
	}

	public void setMarkName(String markName) {
		this.markName = markName;
	}

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof TradeMarkEntity)) {
			return false;
		}
		TradeMarkEntity another = (TradeMarkEntity) o;
		return new EqualsBuilder().append(markId, another.markId)
		                          .append(markName, another.markName)
		                          .append(enName, another.enName)
		                          .isEquals();
	}

	@Override
	public final int hashCode() {
		return new HashCodeBuilder().append(markId)
							        .append(markName)
							        .append(enName)
							        .hashCode();
	}

	@Override
	public final String toString() {
		return markName;
	}
   

	
}
