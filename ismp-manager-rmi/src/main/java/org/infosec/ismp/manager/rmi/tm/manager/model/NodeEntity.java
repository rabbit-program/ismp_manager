package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;

/**
 * 拓扑管理设备品牌
 * @author xiaogaofeng
 *
 */
@Entity
@Table(name = "tm_topo_manager_node")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class NodeEntity implements Serializable{
	
	private static final long serialVersionUID = -6461767501737916582L;
	/**
	 * 平台Node 的唯一标识
	 */

	@Id
	@Column(name = "node_id",updatable = false,unique = true,nullable = false,scale=0,length=60)
	@GeneratedValue(generator = "system-uuid")   
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")  
	private String nodeId;
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	/**
	 * 节点名字
	 */
	@Column(name = "name", length = 50)
	private String name;
	
	/**
	 * 坐标X
	 */
	@Column(name = "point_x")
	private Integer  pointX;
	
	/**
	 * 坐标Y
	 */
	@Column(name = "point_y",columnDefinition ="int(11) default '0'")
	private Integer  pointY;
	
	/**
	 * 节点宽度
	 */
	@Column(columnDefinition ="int(11) default '30'")
	private Integer width;
	
	/**
	 * 节点高度
	 */
	@Column(columnDefinition ="int(11) default '30'")
	private Integer height;
	
	/**
	 * 0/1 未激活/已激活 默认0
	 */
	@Column(columnDefinition ="int(1) default '0'")
	private Integer status;
	
	/**
	 * 所属云视图ID
	 */
	@ManyToOne
	@JoinColumn(name = "parent_domain_id")
	private DomainEntity parentDomain;
	
	/**
	 * 当前设备是一个云图
	 */
	@ManyToOne
	@JoinColumn(name = "domain_id")
	private DomainEntity domain;
	
	
	/**
	 * 品牌ID
	 */
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private TradeMarkEntity brand;
	
	/**
	 * 型号ID
	 */
	@ManyToOne
	@JoinColumn(name = "model_id")
	private DeviceModelEntity model;
	
	/**
	 * 节点类型ID
	 */
	@ManyToOne
	@JoinColumn(name="type_id")
	private NodeTypeEntity type;
	
	/**
	 * 0/1 不可见/可见 默认 1
	 */
	@Column(name = "is_visible" , columnDefinition ="int(1) default '1'")
	private Integer isVisible;
	
	/**
	 * 0/1  物理节点/逻辑节点  默认 0
	 */
	@Column(name = "node_style",columnDefinition ="int(1) default '0'")
	private Integer nodeStyle;
	
	
	/**
	 * 管理方式（SNMP/Database/Sensor…）默认SNMP
	 */
	@Column(name = "manager_style",columnDefinition ="varchar(20) default 'SNMP'")
	private String managerStyle;
	
	/**
	 * ip地址
	 */
	@Column(name = "ip_address")
	private String ipAddress;
	
	/**
	 * mac地址
	 */
	@Column(name = "mac")
	private String netCardCode;
	
	private String system;
	
	 /**
     * 创建时间
     */
   
    private Timestamp createTime;
    
    /**
     * 域描述
     */
    @Column(name="remark"  ,length =500)
    private String remark;
 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPointX() {
		return pointX;
	}

	public void setPointX(Integer pointX) {
		this.pointX = pointX;
	}

	public Integer getPointY() {
		return pointY;
	}

	public void setPointY(Integer pointY) {
		this.pointY = pointY;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public DomainEntity getDomain() {
		return domain;
	}
	public void setDomain(DomainEntity domain) {
		this.domain = domain;
	}
	public DomainEntity getParentDomain() {
		return parentDomain;
	}
	public void setParentDomain(DomainEntity parentDomain) {
		this.parentDomain = parentDomain;
	}
	public TradeMarkEntity getBrand() {
		return brand;
	}
	public void setBrand(TradeMarkEntity brand) {
		this.brand = brand;
	}
	public DeviceModelEntity getModel() {
		return model;
	}
	public void setModel(DeviceModelEntity model) {
		this.model = model;
	}
	public NodeTypeEntity getType() {
		return type;
	}
	public void setType(NodeTypeEntity type) {
		this.type = type;
	}
	public Integer getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	public Integer getNodeStyle() {
		return nodeStyle;
	}

	public void setNodeStyle(Integer nodeStyle) {
		this.nodeStyle = nodeStyle;
	}

	public String getManagerStyle() {
		return managerStyle;
	}

	public void setManagerStyle(String managerStyle) {
		this.managerStyle = managerStyle;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	public String getNetCardCode() {
		return netCardCode;
	}
	public void setNetCardCode(String netCardCode) {
		this.netCardCode = netCardCode;
	}
	@Column(name="create_time")
	 @Temporal(value = TemporalType.TIMESTAMP)  
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	@Override
    public final boolean equals(Object o) {
        if (!(o instanceof NodeEntity)) {
            return false;
        }
        NodeEntity another = (NodeEntity) o;
        return new EqualsBuilder().append(nodeId, another.nodeId)
							      .append(name, another.name)
							      .append(pointX, another.pointX)
							      .append(remark, another.remark)
							      .append(pointY,another.pointY)
							      .append(width, another.width)
							      .append(pointX, another.pointX)
							      .append(remark, another.remark)
							      .append(pointY,another.pointY)
							      .append(createTime, another.createTime)
							      .append(height,another.height)
							      .append(width, another.width)
							      .append(status, another.status)
							      .append(domain, another.domain)
							      .append(brand, another.brand)
							      .append(model, another.model)
							      .append(nodeStyle, another.nodeStyle)
							      .append(ipAddress, another.ipAddress)
							      .append(isVisible, another.isVisible)
							      .append(type, another.type)
							      .isEquals();
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(nodeId)
							        .append(name)
							        .append(pointX)
							        .append(remark)
							        .append(pointY)
							        .append(createTime)
							        .append(width)
							        .append(height)
							        .append(status)
							        .append(domain)
							        .append(brand)
							        .append(model)
							        .append(nodeStyle)
							        .append(ipAddress)
							        .append(isVisible)
							        .append(type)
							        .hashCode();
    }

    @Override
    public final String toString() {
        return new ToStringBuilder(this).append(nodeId)
								        .append(name)
								        .append(pointX)
								        .append(remark)
								        .append(pointY)
								        .append(createTime)
								        .append(width)
								        .append(height)
								        .append(status)
								        .append(domain)
								        .append(brand)
								        .append(model)
								        .append(nodeStyle)
								        .append(ipAddress)
								        .append(isVisible)
								        .append(type)
								        .toString();
    }
    
}
