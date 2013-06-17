package edu.sjtu.infosec.ismp.manager.VPM.pm.web.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateTactics;

public class TacticsForm extends ActionForm {

	private PatchUpdateTactics t = new PatchUpdateTactics();
	SimpleDateFormat simpdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String globalDefaultPolicy;
	private Date createStartDate;
	private Date createEndDate;
	private String csd;
	private String ced;
	public Date getCreateStartDate() {
		return createStartDate;
	}
	public Date getCreateEndDate() {
		return createEndDate;
	}
	public String getGlobalDefaultPolicy() {
		return globalDefaultPolicy;
	}
	public void setGlobalDefaultPolicy(String globalDefaultPolicy) {
		this.globalDefaultPolicy = globalDefaultPolicy;
	}
	public PatchUpdateTactics getT() {
		return t;
	}
	public void setT(PatchUpdateTactics t) {
		this.t = t;
	}
	public void setCsd(String csd) {
		if(HtmlFactory.isNotEmpty(csd)){
			  try {
				this.createStartDate=simpdate.parse(csd);
			} catch (ParseException e) {
				this.createStartDate=null;
				System.err.println("时间转换出错");
			}
		}
	}
	public void setCed(String ced) {
		if(HtmlFactory.isNotEmpty(ced)){
			  try {
				this.createEndDate=simpdate.parse(ced);
			} catch (ParseException e) {
				this.createEndDate=null;
				System.err.println("时间转换出错");
			}
		}
	}
}
