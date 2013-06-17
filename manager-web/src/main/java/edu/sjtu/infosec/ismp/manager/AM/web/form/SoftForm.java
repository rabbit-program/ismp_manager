package edu.sjtu.infosec.ismp.manager.AM.web.form;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetSoftwareBO;


/***
 * 封装软件表单信息的 Form
 * 
 * **/
public class SoftForm extends ActionForm {

	private AssetSoftwareBO softbo = new AssetSoftwareBO();
	
	private String stocktimepage;
	private String registrationtimepage;

	public String getStocktimepage() {
		return stocktimepage;
	}

	public void setStocktimepage(String stocktimepage) { 
		if(stocktimepage.equals("")){
			this.softbo.setStockTime(null);
		}else{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				this.softbo.setStockTime(new Timestamp((format.parse(stocktimepage)).getTime()));
			} catch (ParseException e) { 
				e.printStackTrace();
			}
		}
		this.stocktimepage = stocktimepage;
	}

	public String getRegistrationtimepage() {
		return registrationtimepage;
	}

	public void setRegistrationtimepage(String registrationtimepage) {
		this.registrationtimepage = registrationtimepage;
		if(registrationtimepage.equals("")){
			this.softbo.setRegistrationTime(null);
		}else{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				this.softbo.setRegistrationTime(new Timestamp((format.parse(registrationtimepage)).getTime()));
			} catch (ParseException e) { 
				e.printStackTrace();
			}
		}

	}

	public AssetSoftwareBO getSoftbo() {
		return softbo;
	}

	public void setSoftbo(AssetSoftwareBO softbo) {
		this.softbo = softbo;
	}

}
