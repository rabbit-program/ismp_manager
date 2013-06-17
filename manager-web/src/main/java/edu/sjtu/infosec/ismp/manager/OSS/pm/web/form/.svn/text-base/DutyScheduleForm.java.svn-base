package edu.sjtu.infosec.ismp.manager.OSS.pm.web.form;

import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Complaint;
import edu.sjtu.infosec.ismp.manager.OSS.pm.model.DutySchedule;

public class DutyScheduleForm  extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8766177804482631503L;

	public DutySchedule getDs() {
		return ds;
	}

	public void setDs(DutySchedule ds) {
		this.ds = ds;
	}

	private DutySchedule ds = new DutySchedule();
	
	/**
	 * @return the complaint
	 */
	public Complaint getComplaint() {
		return complaint;
	}

	/**
	 * @param complaint the complaint to set
	 */
	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	private Complaint complaint = new Complaint();
	
	public Timestamp getCreateStartDate() {
		return createStartDate;
	}
	public void setCreateStartDate(Timestamp createStartDate) {
		this.createStartDate = createStartDate;
	}
	public Timestamp getCreateEndDate() {
		return createEndDate;
	}
	public void setCreateEndDate(Timestamp createEndDate) {
		this.createEndDate = createEndDate;
	}
	private Timestamp createStartDate;
	private Timestamp createEndDate;
}
