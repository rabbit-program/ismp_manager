package edu.sjtu.infosec.ismp.manager.VPM.vm.web.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.HtmlFactory;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;

/**
 * 病毒客户端映射，简单查询模型
 */
public class VirusClientsORMForm extends ActionForm {
	

	private VirusClients vc = new VirusClients();
	SimpleDateFormat simpdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
	public VirusClients getVc() {
		return vc;
	}
	public void setVc(VirusClients vc) {
		this.vc = vc;
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
