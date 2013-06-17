package edu.sjtu.infosec.ismp.manager.SYSM.user.other.web.form;

import java.sql.Timestamp;
import org.apache.struts.action.ActionForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysInfo;
public class AppSysInfoForm  extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5048488962935702827L;

	private AppSysInfo asi = new AppSysInfo();
	public AppSysInfo getAsi() {
		return asi;
	}
	public void setAsi(AppSysInfo asi) {
		this.asi = asi;
	}
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
