/**
 * 
 */
package edu.sjtu.infosec.ismp.manager.EM.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author @author 林超
 *
 * 2009-6-1 下午02:03:39
 */
public class NormalizedEvent implements Serializable{

    //private long timeStamp;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3852091922141407341L;

	/**
     * 事件源IP地址
     */
    private String src_ip; 
    
    /**
     * 事件源端口
     */
    private Integer src_port;
    
    /**
     * 事件目的IP
     */
    private String dest_ip; //目的IP
    
    /**
     * 安全设备类型
     */
    private String faci_type; //设备类型
    
    /**
     * 安全事件类型
     */
    private String event_type; //事件类型
    
    /**
     * 协议类型
     */
    private String prot_type; //协议类型
    
    /**
     * 对事件的描述
     */
    private String descrip; //描述
    
    /**
     * 数据流方向，0向内; 1向外 true:0 false:1
     */
    private Boolean direction; 
    
    /**
     * 事件目的端口
     */
    private Integer dest_port; //目的端口
    
    /**
     * 事件威胁等级
     */
    public Integer thre_rank; //事件威胁等级
    
    /**
     * 操作，如删除，不同的数字代表不同的操作类型
     */
    private Byte operarion; //操作
    
    /**
     * 事件时间
     */
    private Timestamp time; //时间
    
    /**
     * 安全设备IP，唯一标识一个设备
     */
    private String faci_ip; //设备IP
    
    /**
     * agentId
     */
    private Integer agentId;
    
    /**
     * 委办局ID
     */
    private Integer bureauId;
    
    /**
     * 委办局名称
     */
    private String bureauName;


	public String getBureauName() {
		return bureauName;
	}

	public void setBureauName(String bureauName) {
		this.bureauName = bureauName;
	}

	public Integer getBureauId() {
		return bureauId;
	}

	public void setBureauId(Integer bureauId) {
		this.bureauId = bureauId;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	/**
     * 
     * getFaci_ip
     */
    public String getFaci_ip() {
        return faci_ip;
    }

    /**
     * 
     * setFaci_ip
     */
    public void setFaci_ip(String vFaci_ip) {
        faci_ip = vFaci_ip;
    }

    /**
     * 
     * getSrc_ip
     */
    public String getSrc_ip() {
        return src_ip;
    }

    /**
     * 
     * setSrc_ip
     */
    public void setSrc_ip(String vSrc_ip) {
        src_ip = vSrc_ip;
    }

    public Integer getSrc_port() {
        return src_port;
    }

    /**
     * 
     * setSrc_port
     */
    public void setSrc_port(Integer vSrc_port) {
        src_port = vSrc_port;
    }

    /**
     * 
     * getDest_ip
     */
    public String getDest_ip() {
        return dest_ip;
    }

    /**
     * 
     * setDest_ip
     */
    public void setDest_ip(String vDest_ip) {
        dest_ip = vDest_ip;
    }

    /**
     * 
     * getFaci_type
     */
    public String getFaci_type() {
        return faci_type;
    }

    /**
     * 
     * setFaci_type
     */
    public void setFaci_type(String vFaci_type) {
        faci_type = vFaci_type;
    }

    /**
     * 
     * getEvent_type
     */
    public String getEvent_type() {
        return event_type;
    }

    /**
     * 
     * setEvent_type
     */
    public void setEvent_type(String vEvent_type) {
        event_type = vEvent_type;
    }

    /**
     * 
     * getProt_type
     */
    public String getProt_type() {
        return prot_type;
    }

    /**
     * 
     * setProt_type
     */
    public void setProt_type(String vProt_type) {
        prot_type = vProt_type;
    }

    /**
     * 
     * getDescrip
     */
    public String getDescrip() {
        return descrip;
    }

    /**
     * 
     * setDescrip
     */
    public void setDescrip(String vDescrip) {
        descrip = vDescrip;
    }

    /**
     * 
     * getDirection
     */
    public Boolean getDirection() {
        return direction;
    }

    /**
     * 
     * setDirection
     */
    public void setDirection(Boolean vDirection) {
        direction = vDirection;
    }

    /**
     * 
     * getDest_port
     */
    public Integer getDest_port() {
        return dest_port;
    }

    /**
     * 
     * setDest_port
     */
    public void setDest_port(Integer vDest_port) {
        dest_port = vDest_port;
    }

    /**
     * 
     * getThre_rank
     */
    public Integer getThre_rank() {
        return thre_rank;
    }

    /**
     * 
     * setThre_rank
     */
    public void setThre_rank(Integer vThre_rank) {
        thre_rank = vThre_rank;
    }

    /**
     * 
     * getOperarion
     */
    public Byte getOperarion() {
        return operarion;
    }

    /**
     * 
     * setOperarion
     */
    public void setOperarion(Byte vOperarion) {
        operarion = vOperarion;
    }

    /**
     * 
     * getTime
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * 
     * setTime
     */
    public void setTime(Timestamp vTime) {
        time = vTime;
    }
    
//    /**
//     * 
//     */
//    public NormalizedEvent(){
//        timeStamp = System.currentTimeMillis();
//    }    
}
