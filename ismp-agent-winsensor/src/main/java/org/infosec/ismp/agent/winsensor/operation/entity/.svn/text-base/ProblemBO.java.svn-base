package org.infosec.ismp.agent.winsensor.operation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Rocky
 * @version create time: Jan 14, 2011 4:10:19 PM
 *
 */
@Entity
@Table(name="problem")
public class ProblemBO implements Serializable {

	private static final long serialVersionUID = 3275175648946172919L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="sensor_id", length=100)
	private String sensorId;		//Sensor client unique identify.
	
	@Column(name="problem_id", length=100)
	private String problemId;		//Operation problem unique identify.
	
	@Column(name="title", length=255)
	private String title;		// Problem title.
	
	@Column(name="description", length=1000)
	private String description;		//Problem description.
	
	@Column(name="service_address", length=255)
	private String serviceAddress;		//Service address.
	
	@Column(name="contact", length=100)
	private String contact;		//Contact.
	
	@Column(name="contact_address", length=255)
	private String contactAddress;		//Contact address.
	
	@Column(name="create_time", length=100)
	private String createTime;			//Problem create time.
	
	@Column(name="if_send_to_manager")
	private Boolean ifSendToManager;		//If send the problem to manager.
	
	@Column(name="if_manager_received")
	private Boolean ifManagerReceived;		//If manager server received the problem.
	
	@Column(name="if_problem_closed")
	private Boolean IfProblemClosed;			//If the problem is closed.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="prob_closed_time")
	private Date probClosedTime;		//The time problem closed.
	
	@Column(name="if_send_prob_closed")
	private Boolean ifSendProbClosed;		//If send the info that closed problem to sensor client.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="send_prob_closed_time")
	private Date sendProbClosedTime;		//The time sent the info that closed problem to sensor client.
	
	@Column(name="work_orders_id", length=100)
	private String workOrdersId;		//WorkOrders identify.
	
	@Column(name="if_generated_work_orders")
	private Boolean ifGeneratedWorkOrders;		//If generated workOrders.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="work_orders_gene_time")
	private Date workOrdersGeneTime;		//The time generated workOrders.
	
	@Column(name="if_send_gene_work_orders")
	private Boolean ifSendGeneWorkOrders;		//If send the info that generated workOrders to sensor client.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="send_gene_work_orders_time")
	private Date sendGeneworkOrdersTime;		//The time sent the info that generated workOrders to sensor client.
	
	@Column(name="if_work_orders_closed")
	private Boolean ifWorkOrdersClosed;			//If the workOrders closed.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="work_orders_closed_time")
	private Date workOrdersClosedTime;			//The time workOrders closed.
	
	@Column(name="if_send_work_orders_closed")
	private Boolean ifSendWorkOrdersClosed;		//If send the info that closed workOrders to sensor client.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="send_orders_closed_time")
	private Date sendOrdersClosedTime;		//The time sent the info that closed workOrders to sensor client.
	
	@Column(name="if_work_orders_complete")
	private Boolean ifWorkOrdersComplete;			//If complete the workOrders.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="work_orders_comp_time")
	private Date workOrdersCompTime;			//The time complete the workOrders.
	
	@Column(name="if_send_orders_completed")
	private Boolean ifSendOrdersCompleted;			//If send the info that complete the workOrders to sensor client.
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="send_orders_comp_time")
	private Date sendOrdersCompTime;			//The time send the info that complete the workOrders to sensor client.

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Boolean getIfSendToManager() {
		return ifSendToManager;
	}

	public void setIfSendToManager(Boolean ifSendToManager) {
		this.ifSendToManager = ifSendToManager;
	}

	public Boolean getIfManagerReceived() {
		return ifManagerReceived;
	}

	public void setIfManagerReceived(Boolean ifManagerReceived) {
		this.ifManagerReceived = ifManagerReceived;
	}

	public Boolean getIfProblemClosed() {
		return IfProblemClosed;
	}

	public void setIfProblemClosed(Boolean ifProblemClosed) {
		IfProblemClosed = ifProblemClosed;
	}

	public Date getProbClosedTime() {
		return probClosedTime;
	}

	public void setProbClosedTime(Date probClosedTime) {
		this.probClosedTime = probClosedTime;
	}

	public Boolean getIfSendProbClosed() {
		return ifSendProbClosed;
	}

	public void setIfSendProbClosed(Boolean ifSendProbClosed) {
		this.ifSendProbClosed = ifSendProbClosed;
	}

	public Date getSendProbClosedTime() {
		return sendProbClosedTime;
	}

	public void setSendProbClosedTime(Date sendProbClosedTime) {
		this.sendProbClosedTime = sendProbClosedTime;
	}

	public String getWorkOrdersId() {
		return workOrdersId;
	}

	public void setWorkOrdersId(String workOrdersId) {
		this.workOrdersId = workOrdersId;
	}

	public Boolean getIfGeneratedWorkOrders() {
		return ifGeneratedWorkOrders;
	}

	public void setIfGeneratedWorkOrders(Boolean ifGeneratedWorkOrders) {
		this.ifGeneratedWorkOrders = ifGeneratedWorkOrders;
	}

	public Date getWorkOrdersGeneTime() {
		return workOrdersGeneTime;
	}

	public void setWorkOrdersGeneTime(Date workOrdersGeneTime) {
		this.workOrdersGeneTime = workOrdersGeneTime;
	}

	public Boolean getIfSendGeneWorkOrders() {
		return ifSendGeneWorkOrders;
	}

	public void setIfSendGeneWorkOrders(Boolean ifSendGeneWorkOrders) {
		this.ifSendGeneWorkOrders = ifSendGeneWorkOrders;
	}

	public Date getSendGeneworkOrdersTime() {
		return sendGeneworkOrdersTime;
	}

	public void setSendGeneworkOrdersTime(Date sendGeneworkOrdersTime) {
		this.sendGeneworkOrdersTime = sendGeneworkOrdersTime;
	}

	public Boolean getIfWorkOrdersClosed() {
		return ifWorkOrdersClosed;
	}

	public void setIfWorkOrdersClosed(Boolean ifWorkOrdersClosed) {
		this.ifWorkOrdersClosed = ifWorkOrdersClosed;
	}

	public Date getWorkOrdersClosedTime() {
		return workOrdersClosedTime;
	}

	public void setWorkOrdersClosedTime(Date workOrdersClosedTime) {
		this.workOrdersClosedTime = workOrdersClosedTime;
	}

	public Boolean getIfSendWorkOrdersClosed() {
		return ifSendWorkOrdersClosed;
	}

	public void setIfSendWorkOrdersClosed(Boolean ifSendWorkOrdersClosed) {
		this.ifSendWorkOrdersClosed = ifSendWorkOrdersClosed;
	}

	public Date getSendOrdersClosedTime() {
		return sendOrdersClosedTime;
	}

	public void setSendOrdersClosedTime(Date sendOrdersClosedTime) {
		this.sendOrdersClosedTime = sendOrdersClosedTime;
	}

	public Boolean getIfWorkOrdersComplete() {
		return ifWorkOrdersComplete;
	}

	public void setIfWorkOrdersComplete(Boolean ifWorkOrdersComplete) {
		this.ifWorkOrdersComplete = ifWorkOrdersComplete;
	}

	public Date getWorkOrdersCompTime() {
		return workOrdersCompTime;
	}

	public void setWorkOrdersCompTime(Date workOrdersCompTime) {
		this.workOrdersCompTime = workOrdersCompTime;
	}

	public Boolean getIfSendOrdersCompleted() {
		return ifSendOrdersCompleted;
	}

	public void setIfSendOrdersCompleted(Boolean ifSendOrdersCompleted) {
		this.ifSendOrdersCompleted = ifSendOrdersCompleted;
	}

	public Date getSendOrdersCompTime() {
		return sendOrdersCompTime;
	}

	public void setSendOrdersCompTime(Date sendOrdersCompTime) {
		this.sendOrdersCompTime = sendOrdersCompTime;
	}
}
