package edu.sjtu.infosec.ismp.manager.AM.web.form;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetHardwareBO;


public class HardwareForm extends ActionForm {
        
	
	//封装硬件的Form表单信息的VO
	private AssetHardwareBO hardware=new AssetHardwareBO();
	
	private String stocktimepage;
	private String registrationtimepage;

	public String getStocktimepage() {
		return stocktimepage;
	}

	public void setStocktimepage(String stocktimepage) { 
	    if(stocktimepage.equals("")){
	    	this.hardware.setStockTime(null);
	    }else {
	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    	try {
				this.hardware.setStockTime(new Timestamp((format.parse(stocktimepage)).getTime()));
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
		if(registrationtimepage.equals("")){
			this.hardware.setRegistrationTime(null);
		}else{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				this.hardware.setRegistrationTime(new Timestamp((format.parse(registrationtimepage)).getTime()));
			} catch (ParseException e) { 
				e.printStackTrace();
			}
		}
		this.registrationtimepage = registrationtimepage;
	}

	public AssetHardwareBO getHardware() {
		return hardware;
	}

	public void setHardware(AssetHardwareBO hardware) {
		this.hardware = hardware;
	}

	

}
