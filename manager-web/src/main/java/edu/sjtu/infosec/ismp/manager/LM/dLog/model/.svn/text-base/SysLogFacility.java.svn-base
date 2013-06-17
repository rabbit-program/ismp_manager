package edu.sjtu.infosec.ismp.manager.LM.dLog.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysLog的产生日志的程序模块
 * @author Lin Chao
 * @date 2010-09-06
 * @version 1.0
 */

@Entity
@Table(name = "lm_dlog_syslog_facility")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SysLogFacility implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8801686397452454828L;

	@Id
	private Integer facilityNumber;

	private String facilityDescribe;

	public Integer getFacilityNumber() {
		return facilityNumber;
	}

	public void setFacilityNumber(Integer facilityNumber) {
		this.facilityNumber = facilityNumber;
	}

	public String getFacilityDescribe() {
		return facilityDescribe;
	}

	public void setFacilityDescribe(String facilityDescribe) {
		this.facilityDescribe = facilityDescribe;
	}
}
