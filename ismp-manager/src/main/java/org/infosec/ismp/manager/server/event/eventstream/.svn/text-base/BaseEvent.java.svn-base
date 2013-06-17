/**
 * 
 */
package org.infosec.ismp.manager.server.event.eventstream;

import java.sql.Timestamp;
 
/**
 * 定义事件的基本信息
 * @author Jianyu Shen
 *
 * 2009-6-1
 */
public abstract class BaseEvent {
 
    //public Long timeStamp;
    
    /**
     * 事件源IP
     */
    private String src_ip;
    
    /**
     * 事件源端口
     */
    private Integer src_port;
    
    /**
     * 目的IP
     */
    private String dest_ip;
    
    /**
     * 安全设备类型
     */
    private String faci_type;
    
    /**
     * 安全事件类型
     */
    private String event_type;
    
    /**
     * 协议类型
     */
    private String prot_type;
    
    /**
     * 事件描述
     */
    private String descrip;
    
    /**
     * 数据流方向，向内或向外
     */
    private Boolean direction;
    
    /**
     * 目的端口
     */
    private Integer dest_port;
    
    /**
     * 威胁等级，1到5以供5级
     */
    public Integer thre_rank;
    
    /**
     * 操作，如删除，不同的数字代表不同的操作类型
     */
    private Byte operarion;
    
    /**
     * 事件时间
     */
    private Timestamp time;
    
    /**
     * 设备唯一IP，表示唯一设备
     */
    private String faci_ip;


    /**
     * 
     * TODO
     * getSrc_ip
     * String
     */
    public String getSrc_ip() {
        return src_ip;
    }

    /**
     * 
     * TODO
     * setSrc_ip
     * void
     */
    public void setSrc_ip(String vSrc_ip) {
        src_ip = vSrc_ip;
    }

    /**
     * 
     * TODO
     * getSrc_port
     * int
     */
    public Integer getSrc_port() {
        return src_port;
    }
    
    /**
     * 
     * TODO
     * setSrc_port
     * void
     */
    public void setSrc_port(Integer vSrc_port) {
        src_port = vSrc_port;
    }

    /**
     * 
     * TODO
     * getDest_ip
     * String
     */
    public String getDest_ip() {
        return dest_ip;
    }
    
    /**
     * 
     * TODO
     * setDest_ip
     * void
     */
    public void setDest_ip(String vDest_ip) {
        dest_ip = vDest_ip;
    }
    
    /**
     * 
     * getFaci_type
     * String
     */
    public String getFaci_type() {
        return faci_type;
    }
    
    /**
     * 
     * setFaci_type
     * void
     */
    public void setFaci_type(String vFaci_type) {
        faci_type = vFaci_type;
    }

    /**
     * 
     * getEvent_type
     * String
     */
    public String getEvent_type() {
        return event_type;
    }

    /**
     * 
     * setEvent_type
     * void
     */
    public void setEvent_type(String vEvent_type) {
        event_type = vEvent_type;
    }

    /**
     * 
     * getProt_type
     * String
     */
    public String getProt_type() {
        return prot_type;
    }

    /**
     * 
     * setProt_type
     * void
     */
    public void setProt_type(String vProt_type) {
        prot_type = vProt_type;
    }
    
    /**
     * 
     * TODO
     * getDescrip
     * String
     */
    public String getDescrip() {
        return descrip;
    }

    /**
     * 
     * setDescrip
     * void
     */
    public void setDescrip(String vDescrip) {
        descrip = vDescrip;
    }

    /**
     * 
     * getDirection
     * char
     */
    public Boolean getDirection() {
        return direction;
    }

    /**
     * 
     * setDirection
     * void
     */
    public void setDirection(Boolean vDirection) {
        direction = vDirection;
    }

    /**
     * 
     * getDest_port
     * int
     */
    public Integer getDest_port() {
        return dest_port;
    }

    /**
     * 
     * setDest_port
     * void
     */
    public void setDest_port(Integer vDest_port) {
        dest_port = vDest_port;
    }

    /**
     * 
     * getThre_rank
     * int
     */
    public Integer getThre_rank() {
        return thre_rank;
    }

    /**
     * 
     * setThre_rank
     * void
     */
    public void setThre_rank(Integer vThre_rank) {
        thre_rank = vThre_rank;
    }

    /**
     * 
     * getOperarion
     * char
     */
    public Byte getOperarion() {
        return operarion;
    }

    /**
     * 
     * setOperarion
     * void
     */
    public void setOperarion(Byte vOperarion) {
        operarion = vOperarion;
    }

    /**
     * 
     * getTime
     * String
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * 
     * setTime
     * void
     */
    public void setTime(Timestamp vTime) {
        time = vTime;
    }

    /**
     * 
     * getFaci_id
     * String
     */
    public String getFaci_ip() {
        return faci_ip;
    }

    /**
     * 
     * setFaci_id
     * void
     */
    public void setFaci_ip(String vFaci_ip) {
        faci_ip = vFaci_ip;
    }
 
//    /**
//     * 
//     */
//    public BaseEvent(){
//        timeStamp = System.currentTimeMillis();
//    }
    
    /**
     * 
     * getType
     * String
     */
    public String getType(){
        return this.getClass().getSimpleName();
    }
    
}
