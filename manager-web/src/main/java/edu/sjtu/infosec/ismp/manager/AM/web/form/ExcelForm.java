package edu.sjtu.infosec.ismp.manager.AM.web.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

@SuppressWarnings("serial")
public class ExcelForm extends ActionForm {
	private FormFile excelFile;

	public FormFile getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(FormFile excelFile) {
		this.excelFile = excelFile;
	}
	
}
