package org.infosec.ismp.agent.pollable.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;

/**
 * 特别服务对象.
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */

@Entity
@Table(name="SpService")
public class SpServiceEntity {

	public static final String  STATUS_UP = "on";
	
	public static final String  STATUS_DOWN = "down";
	@Id
	private int serviceId;

	private String name;

	private String serviceType;

	private String status;

	private String ipAddr;

	private String svcLostEventUei;

	private long m_interval;

	private boolean ifHalfInterval;

	private Timestamp svcLostServiceTime;
	
	public SpServiceEntity() {
	}

	@CollectionOfElements(fetch=FetchType.EAGER)
	@JoinTable(name = "spservice_param", joinColumns = @JoinColumn(name = "serviceId"))
	private List<SpServiceParmEntity> parms = new ArrayList<SpServiceParmEntity>();



	public List<SpServiceParmEntity> getParms() {
		return parms;
	}

	public void setParms(List<SpServiceParmEntity> parms) {
		this.parms = parms;
	}

	public int getServiceId() {
		return serviceId;
	}

	public String getName() {
		return name;
	}

	public String getServiceType() {
		return serviceType;
	}


	public String getStatus() {
		return status;
	}

	public String getIpAddr() {
		return ipAddr;
	}


	public String getSvcLostEventUei() {
		return svcLostEventUei;
	}


    @Column(name="m_interval", length=64)
	public long getInterval() {
		return m_interval;
	}


	public boolean isIfHalfInterval() {
		return ifHalfInterval;
	}


	public Timestamp getSvcLostServiceTime() {
		return svcLostServiceTime;
	}

	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param ipAddr the ipAddr to set
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	/**
	 * @param svcLostEventUei the svcLostEventUei to set
	 */
	public void setSvcLostEventUei(String svcLostEventUei) {
		this.svcLostEventUei = svcLostEventUei;
	}

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(long interval) {
		this.m_interval = interval;
	}

	/**
	 * @param ifHalfInterval the ifHalfInterval to set
	 */
	public void setIfHalfInterval(boolean ifHalfInterval) {
		this.ifHalfInterval = ifHalfInterval;
	}

	/**
	 * @param svcLostServiceTime the svcLostServiceTime to set
	 */
	public void setSvcLostServiceTime(Timestamp svcLostServiceTime) {
		this.svcLostServiceTime = svcLostServiceTime;
	}


}
