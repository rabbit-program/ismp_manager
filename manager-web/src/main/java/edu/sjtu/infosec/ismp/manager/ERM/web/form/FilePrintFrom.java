package edu.sjtu.infosec.ismp.manager.ERM.web.form;

import org.apache.struts.action.ActionForm;

public class FilePrintFrom extends ActionForm {

	private static final long serialVersionUID = 1L;

	private int id;
	
	private int selectresp;
	
	private String printcontent;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSelectresp() {
		return selectresp;
	}

	public void setSelectresp(int selectresp) {
		this.selectresp = selectresp;
	}

	public String getPrintcontent() {
		return printcontent;
	}

	public void setPrintcontent(String printcontent) {
		this.printcontent = printcontent;
	}
	
	
}
