package org.infosec.ismp.situation.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *  态势对应事件表类.
 * Author：cchang
 * 2010-11-3 14:15:08
 */
@Entity
@Table(name = "bsam_situation_event")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class SituationEvent {

	/**
     * 主键id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    /**
     * 态势产生时间
     **/
    @Column(name="time", nullable = false)
    private Timestamp time;
    
    /**
     * 事件id
     **/
    @Column(name="event_id", nullable = false)
    private Integer eventId;
    
    /**
     * 事件的目的IP
     **/
    @Column(name="event_ip")
    private String eventIP;
    
    /**
     * 事件的产生模块
     **/
    @Column(name="srcmod")
    private String srcmod;
    
    /**
     * 事件的记录时间
     **/
    @Column(name="event_log_time")
    private Timestamp eventLogTime;
    
    /**
     * 事件的原始时间
     **/
    @Column(name="event_old_time")
    private Timestamp eventOldTime;

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

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	
	public String getEventIP() {
		return eventIP;
	}

	public void setEventIP(String eventIP) {
		this.eventIP = eventIP;
	}

	public String getSrcmod() {
		return srcmod;
	}

	public void setSrcmod(String srcmod) {
		this.srcmod = srcmod;
	}

	public Timestamp getEventLogTime() {
		return eventLogTime;
	}

	public void setEventLogTime(Timestamp eventLogTime) {
		this.eventLogTime = eventLogTime;
	}

	public Timestamp getEventOldTime() {
		return eventOldTime;
	}

	public void setEventOldTime(Timestamp eventOldTime) {
		this.eventOldTime = eventOldTime;
	}
}
