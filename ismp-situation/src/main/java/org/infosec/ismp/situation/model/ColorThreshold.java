package org.infosec.ismp.situation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 颜色阈值表类.
 * Author：cchang
 * 2010-9-21 下午02:22:46
 */
@Entity
@Table(name = "bsam_color_threshold")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class ColorThreshold implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4436794762056614512L;

	/**
     * 主键id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    /**
     * 颜色名
     **/
    @Column(name="color", length = 10, nullable = false)
    private String color;
    
    /**
     * 阈值
     **/
    @Column(name="value", nullable = false)
    private Integer value;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
