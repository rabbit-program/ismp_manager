package org.infosec.ismp.situation.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 记录读取位置类
 * Author：cchang
 * 2010-10-18 10:49:40
 */
@Entity
@Table(name = "bsam_record_index")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class RecordIndex {

	/**
	 * 主键id
	 **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
	private Integer id;

	/**
	 * 时间
	 **/
    @Column(name="time", nullable = false)
	private Timestamp time;

	/**
	 * 表读取位置
	 **/
    @Column(name="column_number", nullable = false)
	private Integer columnNumber;

	/**
	 * 序列号
	 */
    @Column(name="index", nullable = false)
	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Integer getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(Integer columnNumber) {
		this.columnNumber = columnNumber;
	}
}
