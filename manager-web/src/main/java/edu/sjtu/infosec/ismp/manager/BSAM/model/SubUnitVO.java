package edu.sjtu.infosec.ismp.manager.BSAM.model;

import java.io.Serializable;

/**
 * 下级单位VO类.
 * Author：cchang
 * 2010-12-20 11:11:53
 */
public class SubUnitVO implements Serializable {

	private static final long serialVersionUID = 7020734578733357145L;
	
	private Integer id;
	
	private String name;
	
	///取值：AnQuanYu,JiFang,JiGui,ZhuJi
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
}
