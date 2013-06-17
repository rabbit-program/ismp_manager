package edu.sjtu.infosec.ismp.manager.AIM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name="aim_fusion_rule")
@org.hibernate.annotations.Entity(dynamicUpdate=true)
public class AlertFusionRuleBO implements Serializable{
	/**
	 * 主键自动增长
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;  
	
     /**
      * 归并时间
      */
	private Integer fusionTime;
   
	/**
	 * 描述
	 */
	private String depict;

	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("fusionTime",
				fusionTime).append("depict", depict).toString();
	}

	public boolean equals(final Object other) {
		if (!(other instanceof AlertFusionRuleBO))
			return false;
		AlertFusionRuleBO castOther = (AlertFusionRuleBO) other;
		return new EqualsBuilder().append(id, castOther.id).append(fusionTime,
				castOther.fusionTime).append(depict, castOther.depict)
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(id).append(fusionTime).append(
				depict).toHashCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFusionTime() {
		return fusionTime;
	}

	public void setFusionTime(Integer fusionTime) {
		this.fusionTime = fusionTime;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}
}
