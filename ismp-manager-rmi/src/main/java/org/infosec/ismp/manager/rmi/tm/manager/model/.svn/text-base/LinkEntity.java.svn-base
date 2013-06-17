package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

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
 * 连接线模型
 * @author 肖高峰
 *
 */
@Entity
@Table(name = "tm_topo_manager_link")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class LinkEntity implements  Serializable{
	private static final long serialVersionUID = -1517448219268446302L;

	/**
	 * 设备链接节点ID
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="link_id")
	private Long linkId;
    
	/**
     *设备状态
     */
    @Column(name="link_state" )
     private Integer  linkState;
    
    /**
     *设备类型
     */
    @Column(name="node_type" )
     private Integer  nodeType;

  
    /**
     *from 设备
     */
    @ManyToOne
	@JoinColumn(name="from_node_id")
    private NodeEntity fromDeviceId;
    
	/**
     *to 设备
     */
    @ManyToOne
	@JoinColumn(name="to_node_id" )
    private NodeEntity toDeviceId;
    
    /**
     * form设备端口
     */
    @Column(name="from_device_port" )
     private String  fromDevicePort;
    
    /**
     * to设备端口
     */
    @Column(name="to_device_port" )
     private String  toDevicePort;
    
	public NodeEntity getFromDeviceId() {
		return fromDeviceId;
	}

	public void setFromDeviceId(NodeEntity fromDeviceId) {
		this.fromDeviceId = fromDeviceId;
	}

	public NodeEntity getToDeviceId() {
		return toDeviceId;
	}

	public void setToDeviceId(NodeEntity toDeviceId) {
		this.toDeviceId = toDeviceId;
	}
	

    public Long getLinkId() {
		return linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	public Integer getLinkState() {
		return linkState;
	}

	public void setLinkState(Integer linkState) {
		this.linkState = linkState;
	}

	public Integer getNodeType() {
		return nodeType;
	}

	public void setNodeType(Integer nodeType) {
		this.nodeType = nodeType;
	}

	public String getFromDevicePort() {
		return fromDevicePort;
	}

	public void setFromDevicePort(String fromDevicePort) {
		this.fromDevicePort = fromDevicePort;
	}

	public String getToDevicePort() {
		return toDevicePort;
	}

	public void setToDevicePort(String toDevicePort) {
		this.toDevicePort = toDevicePort;
	}
	
	
	@Override
    public final boolean equals(Object o) {
        if (!(o instanceof LinkEntity)) {
            return false;
        }
        LinkEntity another = (LinkEntity) o;
        return new EqualsBuilder().append(linkId, another.linkId)
                                   .append(linkState,another.linkState)
                                   .append(nodeType, another.nodeType)
                                   .append(toDevicePort, another.toDevicePort)
                                   .append(fromDevicePort, another.fromDevicePort)
                                   .append(toDeviceId, another.toDeviceId)
                                   .append(fromDeviceId, another.fromDeviceId)
                                   .isEquals();
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder().append(linkId)
        .append(linkId)
        .append(linkState)
        .append(nodeType)
        .append(toDevicePort)
        .append(fromDevicePort)
        .append(toDeviceId)
        .append(fromDeviceId)
        .hashCode();
    }

    @Override
    public final String toString() {
        return new ToStringBuilder(this)
        .append(linkId)
        .append(linkState)
        .append(nodeType)
        .append(toDevicePort)
        .append(fromDevicePort)
        .append(toDeviceId)
        .append(fromDeviceId)
        .toString();
    }
	
}
