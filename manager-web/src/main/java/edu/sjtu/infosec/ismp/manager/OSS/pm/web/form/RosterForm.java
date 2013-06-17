package edu.sjtu.infosec.ismp.manager.OSS.pm.web.form;

import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;

public class RosterForm extends ActionForm {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 5101302608829170987L;

	public Roster getRoster() {
		return roster;
	}
	public void setRoster(Roster roster) {
		this.roster = roster;
	}
	private Roster roster = new Roster();

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
