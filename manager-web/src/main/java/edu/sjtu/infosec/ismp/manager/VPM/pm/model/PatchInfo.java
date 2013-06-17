package edu.sjtu.infosec.ismp.manager.VPM.pm.model;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 补丁信息
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public class PatchInfo implements Serializable {
	private Integer id;
	private int revisionNumber;
	private String defaultTitle;
	private String defaultDescription;
	private Timestamp arrivalDate;
	private Timestamp creationDate;
	private double isDeclined;
	private String updateType;
	private String updateSource;
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getRevisionNumber() {
		return revisionNumber;
	}

	public void setRevisionNumber(int revisionNumber) {
		this.revisionNumber = revisionNumber;
	}

	public String getDefaultTitle() {
		return defaultTitle;
	}

	public void setDefaultTitle(String defaultTitle) {
		this.defaultTitle = defaultTitle;
	}

	public String getDefaultDescription() {
		return defaultDescription;
	}

	public void setDefaultDescription(String defaultDescription) {
		this.defaultDescription = defaultDescription;
	}

	public Timestamp getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Timestamp arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public double getIsDeclined() {
		return isDeclined;
	}

	public void setIsDeclined(double isDeclined) {
		this.isDeclined = isDeclined;
	}

	public String getUpdateType() {
		return updateType;
	}

	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

	public String getUpdateSource() {
		return updateSource;
	}

	public void setUpdateSource(String updateSource) {
		this.updateSource = updateSource;
	}
	
}
