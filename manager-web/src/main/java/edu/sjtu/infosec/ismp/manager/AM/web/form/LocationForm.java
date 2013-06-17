package edu.sjtu.infosec.ismp.manager.AM.web.form;

import java.sql.Timestamp;

import org.apache.struts.action.ActionForm;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO;


public class LocationForm extends ActionForm {
	
	 //封装树形节点信息
    private AssetPositionBO position=new AssetPositionBO();

    private AssetDeviceBO assetBo=new AssetDeviceBO();
    

	
	private String stocktimepage;
	private String registrationtimepage;
	public String getStocktimepage() {
		return stocktimepage;
	}

	public void setStocktimepage(String stocktimepage) {
		this.stocktimepage = stocktimepage;
		if(stocktimepage.equals("")){
			this.assetBo.setStockTime(null);
		}else{
			this.assetBo.setStockTime(Timestamp.valueOf(stocktimepage));
		}
	
	}

	public String getRegistrationtimepage() {
		return registrationtimepage;
	}

	public void setRegistrationtimepage(String registrationtimepage) {
		this.registrationtimepage = registrationtimepage;
		if(registrationtimepage.equals("")){
			this.assetBo.setRegistrationTime(null);
		}else{
			this.assetBo.setRegistrationTime(Timestamp.valueOf(registrationtimepage));
		}

	}

	public AssetDeviceBO getAssetBo() {
		return assetBo;
	}

	public void setAssetBo(AssetDeviceBO assetBo) {
		this.assetBo = assetBo;
	}

	public AssetPositionBO getPosition() {
		return position;
	}

	public void setPosition(AssetPositionBO position) {
		this.position = position;
	} 
} 
