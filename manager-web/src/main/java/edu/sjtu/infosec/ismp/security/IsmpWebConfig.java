package edu.sjtu.infosec.ismp.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * manager web的一些动态属性设定表，如是否启用黑白访问名单等一些动态配置
 * 
 * $Id: IsmpWebConfig.java 221 2010-08-31 05:44:07Z caoqi $
 *
 */
@Entity
@Table(name = "ismp_web_config")
public class IsmpWebConfig extends IdEntity {
	private  Boolean enableBlack = Boolean.FALSE;
	private  Boolean enableWhite = Boolean.FALSE;

	@Column
	public Boolean getEnableBlack() {
		return enableBlack;
	}

	@Column
	public Boolean getEnableWhite() {
		return enableWhite;
	}

	public void setEnableBlack(Boolean enableBlack) {
		this.enableBlack = enableBlack;
	}

	public void setEnableWhite(Boolean enableWhite) {
		this.enableWhite = enableWhite;
	}
	
	
	

}
