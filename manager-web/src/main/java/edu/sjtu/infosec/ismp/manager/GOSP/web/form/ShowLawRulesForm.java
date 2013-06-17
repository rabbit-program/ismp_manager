package edu.sjtu.infosec.ismp.manager.GOSP.web.form;

import org.apache.struts.action.ActionForm;

public class ShowLawRulesForm extends ActionForm{

	private static final long serialVersionUID = 1L;
	
	private int dmid;

	public int getDmid() {
		return dmid;
	}

	public void setDmid(int dmid) {
		this.dmid = dmid;
	}
	

}
