package edu.sjtu.infosec.ismp.manager.AM.web.form;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;


public class AssetForm extends ActionForm {

	private AssetDeviceBO assetBo = new AssetDeviceBO();

	// 文件 Form
	private FormFile excelFile;
	// 类型
	private int assettypeid;
	
	private String[] assetIps;
	private String[] assetMacs;

	public String[] getAssetIps() {
		return assetIps;
	}

	public void setAssetIps(String[] assetIps) {
		this.assetIps = assetIps;
	}

	public String[] getAssetMacs() {
		return assetMacs;
	}

	public void setAssetMacs(String[] assetMacs) {
		this.assetMacs = assetMacs;
	}

	public int getAssettypeid() {
		return assettypeid;
	}

	public void setAssettypeid(int assettypeid) {
		this.assettypeid = assettypeid;
	}

	public FormFile getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(FormFile excelFile) {
		this.excelFile = excelFile;
	}

	private String stocktimepage;
	private String registrationtimepage;

	public String getStocktimepage() {
		return stocktimepage;
	}

	public void setStocktimepage(String stocktimepage) {
		if (stocktimepage.equals("")) {
			this.assetBo.setStockTime(null);
		} else { 
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				try {
					this.assetBo.setStockTime(new Timestamp((format.parse(stocktimepage)).getTime()));
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
		if (registrationtimepage.equals("")) {
			this.assetBo.setRegistrationTime(null);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				try {
					this.assetBo.setRegistrationTime(new Timestamp((format.parse(registrationtimepage)).getTime()));
				} catch (ParseException e) { 
					e.printStackTrace();
				}
			
		}
	}

	public AssetDeviceBO getAssetBo() {
		return assetBo;
	}

	public void setAssetBo(AssetDeviceBO assetBo) {
		this.assetBo = assetBo;
	}
}
