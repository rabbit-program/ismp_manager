package org.infosec.ismp.model.db.status;

import java.io.Serializable;

/**
 * @author Rocky
 * @version create time：Sep 1, 2010 2:01:21 PM
 * 
 */
public class Workspace implements Serializable {

	private static final long serialVersionUID = -49747563046213344L;

	private long id;		//id
	
	private String name;		//表空间名
	
	private String type;			//表空间类型
	
	private long capability;			//表空间大小（单位：M）
	
	private long usedSpace;		//已使用大小（单位：M）
	
	private double usedRatio;			//利用率（保留小数点后2位）

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCapability() {
		return capability;
	}

	public void setCapability(long capability) {
		this.capability = capability;
	}

	public double getUsedSpace() {
		return usedSpace;
	}

	public void setUsedSpace(long usedSpace) {
		this.usedSpace = usedSpace;
	}

	public double getUsedRatio() {
		return usedRatio;
	}

	public void setUsedRatio(double usedRatio) {
		this.usedRatio = usedRatio;
	}
}
