package org.infosec.ismp.applet.discover.ui;

import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;
/**
 * CDPEntryData
 * @author sshanshan
 * @date 2009-06-19
 * @version 1.0
 */
public class CDPEntryData {
	/**
	 * 是否选中
	 */
    private Boolean isSelect = new Boolean(false);
    /**
     * id
     */
    private Integer id = null;
	/**
	 * 节点名称 
	 */
	private String name;
    /**
     * ip
     */
    private String ip = "";
	/**
	 * 端口
	 */
    private Integer port = null;
    /**
     * 节点类型
     */
    private NodeType type = null;
    /**
     * 尝试次数
     */
    private Integer tryTimes = null;
    /**
     * 应答时间
     */
    private String responseTime = null;
	/**
	 * 子网掩码
	 */
    private String mask = "";
	/**
	 * 节点层次
	 */
    private int layer = 0;
	/**
	 * 获取SNMP信息的团体名
	 */
	private String community;
	/**
	 * 连接的自接口
	 */
	private String selfInterface;
	/**
	 * 连接的邻居接口
	 */
	private String neighborInterface;
    /**
     * 节点描述
     */
    private String description = "";
    /**
     * 备注
     */
    private String remarks = "";

	/**
     * 构造函数
     */
    public CDPEntryData(){
        
    }

    /**
     * 获取是否选中
     * @return isSelect
     */
    public Boolean getIsSelect() {
        return isSelect;
    }
    /**
     * 设置是否选中
     * @param isSelect
     */
    public void setIsSelect(Boolean isSelect) {
        this.isSelect = isSelect;
    }

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public NodeType getType() {
		return type;
	}

	public void setType(NodeType type) {
		this.type = type;
	}

	public Integer getTryTimes() {
		return tryTimes;
	}

	public void setTryTimes(Integer tryTimes) {
		this.tryTimes = tryTimes;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getSelfInterface() {
		return selfInterface;
	}

	public void setSelfInterface(String selfInterface) {
		this.selfInterface = selfInterface;
	}

	public String getNeighborInterface() {
		return neighborInterface;
	}

	public void setNeighborInterface(String neighborInterface) {
		this.neighborInterface = neighborInterface;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
