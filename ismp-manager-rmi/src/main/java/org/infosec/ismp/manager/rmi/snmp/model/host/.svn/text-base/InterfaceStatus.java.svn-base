package org.infosec.ismp.manager.rmi.snmp.model.host;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 */
public class InterfaceStatus implements Serializable {

	private static final long serialVersionUID = 8243149518716953145L;

	public InterfaceStatus() {

	}
    /**
     * 变量名称：description 变量类型：String <br>
     * 说明：接口文字描述
     */
    private String description;
    /**
     * 变量名称：ifIndex 变量类型：String <br>
     * 说明：接口Index;
     */
	private String ifIndex;
    /**
     * 变量名称：ipAddress 变量类型：String <br>
     * 说明：接口IP地址
     */
    private String ipAddress;

    /**
     * 变量名称：netMask 变量类型：String <br>
     * 说明：接口子网掩码
     */
    private String netMask;

    /**
     * 变量名称：physicalAddress 变量类型：String <br>
     * 说明：接口MAC地址，格式满足以下正则表达式：
     * "([0-9,a-f,A-F]{2}\\s){5}[0-9,a-f,A-F]{2}"
     */
    private String physicalAddress;
    
    /**
     * 变量名称：up 变量类型：Boolean <br>
     * 说明：接口状态是up还是down，true表示up，false表示down
     */
    private Boolean status;
    
    /**
     * 变量名称：speed 变量类型：Long <br>
     * 说明：接口速率，单位为bit/s，比如10M以太网此值为10000000
     */
    private Long speed;
    
    /**
     * 变量名称：inPackets 变量类型：Long <br>
     * 说明：接口累计流入IP报文数
     */
    private Long inPackets;
    
    /**
     * 变量名称：outPackets 变量类型：Long <br>
     * 说明：接口累计流出IP报文数
     */
    private Long outPackets;
    
    /**
     * 变量名称：inBytes 变量类型：Long <br>
     * 说明：接口累计流入字节数
     */
    private Long inBytes;
    
    /**
     * 变量名称：outBytes 变量类型：Long <br>
     * 说明：接口累计流出字节数
     */
    private Long outBytes;

	public String getDescription() {
		return description;
	}

	public String getIfIndex() {
		return ifIndex;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getNetMask() {
		return netMask;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public Boolean getStatus() {
		return status;
	}

	public Long getSpeed() {
		return speed;
	}

	public Long getInPackets() {
		return inPackets;
	}

	public Long getOutPackets() {
		return outPackets;
	}

	public Long getInBytes() {
		return inBytes;
	}

	public Long getOutBytes() {
		return outBytes;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIfIndex(String ifIndex) {
		this.ifIndex = ifIndex;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public void setNetMask(String netMask) {
		this.netMask = netMask;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setSpeed(Long speed) {
		this.speed = speed;
	}

	public void setInPackets(Long inPackets) {
		this.inPackets = inPackets;
	}

	public void setOutPackets(Long outPackets) {
		this.outPackets = outPackets;
	}

	public void setInBytes(Long inBytes) {
		this.inBytes = inBytes;
	}

	public void setOutBytes(Long outBytes) {
		this.outBytes = outBytes;
	}

	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString()).append(
				"ifIndex", ifIndex).append("physAddress", physicalAddress)
				.append("ipAddress", ipAddress).append("netMask", netMask).append("inBytes",
						inBytes).append("outBytes", outBytes).append("inPackets", inPackets).append(
						"outPackets", outPackets).append(
								"status", status).append("description",
								description).append("speed", speed).toString();
	}

}
