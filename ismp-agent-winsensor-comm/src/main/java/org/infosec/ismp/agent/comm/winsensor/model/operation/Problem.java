package org.infosec.ismp.agent.comm.winsensor.model.operation;

import java.io.Serializable;

/**
 * @author Rocky
 * @version create time：Dec 16, 2010 7:38:15 PM
 * Problem generated in system operation. And commit by sensor client.
 */
public class Problem implements Serializable{

	private static final long serialVersionUID = -9002588243601070540L;

	private String sensorId;		//Sensor client unique identify.
	
	private String problemId;		//Operation problem unique identify.
	
	private String title;		// Problem title.
	
	private String description;		//Problem description.
	
	private String serviceAddress;		//Service address.
	
	private String contact;		//Contact.
	
	private String contactAddress;		//Contact address.
	
	private String createTime;			//Problem create time.

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
