package edu.sjtu.infosec.ismp.manager.SYSM.user.other.web.form;

import java.sql.Timestamp;
import org.apache.struts.action.ActionForm;
import edu.sjtu.infosec.ismp.manager.SYSM.user.other.model.AppSysRole;
public class AppSysRoleForm  extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5048488962935702827L;


	public AppSysRole getAsr() {
		return asr;
	}
	public void setAsr(AppSysRole asr) {
		this.asr = asr;
	}
	private AppSysRole asr = new AppSysRole();
	
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
