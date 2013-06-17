package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

	/**
	 * 设备子类型号
	 * @author 肖高峰
	 *
	 */
	@Entity
	@Table(name = "tm_topo_manager_device_model")
	@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
	public class DeviceModelEntity implements Serializable{

		private static final long serialVersionUID = 3675838046153645642L;

		/**
		 * ID
		 */
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "model_id")
		private Integer modeId;

		
		/**
		 * 设备名 
		 */
		@Column(name = "name", length = 50)
		private String name;
   

		/**
		 * 设备品牌Id
		 */
		@ManyToOne
		@JoinColumn(name="brand_id")
		 private  TradeMarkEntity tradeMark;
		
		 /**
		 * 设备英文名 
		 */
		@Column(name = "en_name", length = 50)
		private String enName;
		
		public String getEnName() {
			return enName;
		}

		public void setEnName(String enName) {
			this.enName = enName;
		}

		public Integer getModeId() {
			return modeId;
		}

		public void setModeId(Integer modeId) {
			this.modeId = modeId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		
		public TradeMarkEntity getTradeMark() {
			return tradeMark;
		}

		public void setTradeMark(TradeMarkEntity tradeMark) {
			this.tradeMark = tradeMark;
		}

		@Override
		public final boolean equals(Object o) {
			if (!(o instanceof DeviceModelEntity)) {
				return false;
			}
			DeviceModelEntity another = (DeviceModelEntity) o;
			return new EqualsBuilder().append(modeId, another.modeId)
			                          .append(name, another.name)
			                          .append(tradeMark,another.tradeMark)
								      .append(enName,another.enName)
			                          .isEquals();
		}

		@Override
		public final int hashCode() {
			return new HashCodeBuilder().append(modeId)
								        .append(name)
								        .append(tradeMark)
								        .append(enName)
								        .hashCode();
		}

		@Override
		public final String toString() {
			return name;
		}
	}