package org.infosec.ismp.manager.rmi.tm.discover.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 拓扑发现-节点
 * @author Wu Guojie
 * @date 2009-6-6
 * @version 1.0
 */
@Entity
@Table(name = "tm_find_node")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class Node implements Serializable {
	/**
	 * 节点ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 节点名称 
	 */
    @Column(name="name")
	private String name;
	/**
	 * 节点类型
	 */
    @ManyToOne 
    @JoinColumn(name="type")
	private NodeType nodeType;
	/**
	 * sensorId
	 */
    @Column(name="sensor_id")
	private String sensorId;
	/**
	 * IP
	 */
    @Column(name="ip_addr")
	private String ipAddr;
	/**
	 * parentIP
	 */
    @Column(name="parent_ip_addr")
	private String parentIpAddr;
	/**
	 * 端口
	 */
    @Column(name="port")
	private Integer port;
	
	/**
	 * 获取SNMP信息的团体名
	 */
    @Column(name="community")
	private String community;
	/**
	 * 响应时间
	 */
    @Column(name="search_time")
	private String searchTime;
	/**
	 * 尝试次数
	 */
    @Column(name="try_num")
	private Integer tryNum;
	/**
	 * 连接的自接口
	 */
    @Column(name="self_interface")
	private String selfInterface;
	/**
	 * 连接的邻居接口
	 */
    @Column(name="neighbor_interface")
	private String neighborInterface;
	/**
	 * 子网掩码
	 */
    @Column(name="net_mask")
	private String netMask;
	/**
	 * 所属子网
	 */
    @Column(name="sub_net")
	private String subNet;
   /**
    * mac地址
    */
    @Column(name="mac")
	private String mac;
	/**
	 * 节点层次
	 */
    @Column(name="level")
	private Integer level;
	/**
	 * 节点描述
	 */
    @Column(name="description")
	private String description;
	/**
	 * x轴坐标
	 */
    @Column(name="x")
	private Integer x;
	/**
	 * Y轴坐标
	 */
    @Column(name="y")
	private Integer y;
	/**
	 * 添加时间
	 */
    @Column(name="add_date")
	private Date addDate;
	/**
	 * 修改时间
	 */
    @Column(name="update_date")
	private Date updateDate; 
	/**
	 * 备注
	 */
    @Column(name="remarks")
	private String remarks;
	
	
	

	/**
	 * @return the parentIpAddr
	 */
	public String getParentIpAddr() {
		return parentIpAddr;
	}

	/**
	 * @param parentIpAddr
	 * the parentIpAddr to set
	 */
	public void setParentIpAddr(String parentIpAddr) {
		this.parentIpAddr = parentIpAddr;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	/**
	 * @return the tryNum
	 */
	public Integer getTryNum() {
		return tryNum;
	}

	/**
	 * @param tryNum
	 * the tryNum to set
	 */
	public void setTryNum(Integer tryNum) {
		this.tryNum = tryNum;
	}

	/**
	 * @return the searchTime
	 */
	public String getSearchTime() {
		return searchTime;
	}

	/**
	 * @param searchTime
	 * the searchTime to set
	 */
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 * the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nodeType
	 */
	public NodeType getNodeType() {
		return nodeType;
	}
    
	/**
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port
	 * the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 * the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the community
	 */
	public String getCommunity() {
		return community;
	}

	/**
	 * @param community
	 * the community to set
	 */
	public void setCommunity(String community) {
		this.community = community;
	}

	
	/**
	 * @param nodeType
	 * the nodeType to set
	 */
	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the selfInterface
	 */
	public String getSelfInterface() {
		return selfInterface;
	}

	/**
	 * @param selfInterface
	 * the selfInterface to set
	 */
	public void setSelfInterface(String selfInterface) {
		this.selfInterface = selfInterface;
	}

	/**
	 * @return the neighborInterface
	 */
	public String getNeighborInterface() {
		return neighborInterface;
	}

	/**
	 * @param neighborInterface
	 * the neighborInterface to set
	 */
	public void setNeighborInterface(String neighborInterface) {
		this.neighborInterface = neighborInterface;
	}

	/**
	 * @return the netMask
	 */
	public String getNetMask() {
		return netMask;
	}

	/**
	 * @param netMask
	 * the netMask to set
	 */
	public void setNetMask(String netMask) {
		this.netMask = netMask;
	}

	/**
	 * @return the subNet
	 */
	public String getSubNet() {
		return subNet;
	}

	/**
	 * @param subNet
	 * the subNet to set
	 */
	public void setSubNet(String subNet) {
		this.subNet = subNet;
	}

	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * @param mac
	 * the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level
	 * the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}


	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x
	 * the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y
	 * the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	/**
	 * @return the addDate
	 */
	public Date getAddDate() {
		return addDate;
	}

	/**
	 * @param addDate
	 * the addDate to set
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 * the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks
	 * the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the ipAddr
	 */
	public String getIpAddr() {
		return ipAddr;
	}

	/**
	 * @param ipAddr
	 * the ipAddr to set
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	
	
	/**
	 * 比较是否相等
	 * 
	 * @param o
	 *            另一个设备节点
	 * 
	 * @return true/false
	 * */
	public final boolean equals(Object o) {
		if (!(o instanceof Node)) {
			return false;
		}
		Node another = (Node) o;
		return new EqualsBuilder().append(id, another.id)
		                          .append(name, another.name)
		                          .append(nodeType, another.nodeType)
		                          .append(ipAddr, another.ipAddr)
		                          .append(port, another.port)
		                          .append(community, another.community)
		                          .append(searchTime, another.searchTime)
		                          .append(tryNum, another.tryNum)
		                          .append(netMask, another.netMask)
		                          .append(subNet, another.subNet)
		                          .append(mac, another.mac)
		                          .append(level, another.level)
		                          .append(description,another.description)
		                          .append(x, another.x)
		                          .append(y, another.y)
		                          .append(addDate, another.addDate)
		                          .append(updateDate, another.updateDate)
		                          .append(remarks, another.remarks)
		                      	  .isEquals();
	}

	/**
	 * 获取哈希值
	 * 
	 * @return 哈希值
	 * */
	public final int hashCode() {
		return new HashCodeBuilder().append(id)
									.append(name)
									.append(nodeType)
									.append(ipAddr)
									.append(port)
									.append(community)
									.append(searchTime)
									.append(tryNum)
									.append(netMask)
									.append(subNet)
									.append(mac)
									.append(level)
									.append(description)
									.append(x)
									.append(y)
									.append(addDate)
									.append(updateDate)
									.append(remarks)
									.hashCode();
	}

	/**
	 * 链接toString
	 * 
	 * @return 属性字符串
	 * */
	public final String toString() {
		return new ToStringBuilder(this).append(id)
										.append(name)
										.append(nodeType)
										.append(ipAddr)
										.append(port)
										.append(community)
										.append(searchTime)
										.append(tryNum)
										.append(netMask)
										.append(subNet)
										.append(mac)
										.append(level)
										.append(description)
										.append(x)
										.append(y)
										.append(addDate)
										.append(updateDate)
										.append(remarks)
										.toString();
	}
	
}
