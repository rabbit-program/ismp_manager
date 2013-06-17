package org.infosec.ismp.manager.model.db;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author guoxianwei
 * @date 2010-12-15 下午04:35:37
 *   表空间
 */
@Embeddable
public class WorkspaceEntity implements Serializable {

	private static final long serialVersionUID = 1205659661628486999L;
	
	private String name;		//表空间名
	
	private String type;			//表空间类型
	
	private Long capability;			//表空间大小（单位：M）
	
	private Long usedSpace;		//已使用大小（单位：M）
	
	private Double usedRatio;			//利用率（保留小数点后2位）


	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public Long getCapability() {
		return capability;
	}

	public Long getUsedSpace() {
		return usedSpace;
	}

	public Double getUsedRatio() {
		return usedRatio;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCapability(Long capability) {
		this.capability = capability;
	}

	public void setUsedSpace(Long usedSpace) {
		this.usedSpace = usedSpace;
	}

	public void setUsedRatio(Double usedRatio) {
		this.usedRatio = usedRatio;
	}


}

