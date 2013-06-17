package org.infosec.ismp.manager.rmi.tm.manager.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 整个设备对象
 * @author 肖高峰
 *
 */
public class DeviceEntity implements Serializable{
	private static final long serialVersionUID = -3580450545626066522L;
	
	private NodeEntity node;
	
	private SNMPEntity snmp;
	
	private SensorEntity sensor;
	
	private DatabaseEntity database;
	
	
	public NodeEntity getNode() {
		return node;
	}
	public void setNode(NodeEntity node) {
		this.node = node;
	}
	public SNMPEntity getSnmp() {
		return snmp;
	}
	public void setSnmp(SNMPEntity snmp) {
		this.snmp = snmp;
	}
	public SensorEntity getSensor() {
		return sensor;
	}
	public void setSensor(SensorEntity sensor) {
		this.sensor = sensor;
	}
	public DatabaseEntity getDatabase() {
		return database;
	}
	public void setDatabase(DatabaseEntity database) {
		this.database = database;
	}
	
	@Override
    public final boolean equals(Object o) {
        if (!(o instanceof DeviceEntity)) {
            return false;
        }
        DeviceEntity another = (DeviceEntity) o;
        return new EqualsBuilder().append(node,another.node)
                                   .append(snmp, another.snmp)
                                   .append(sensor, another.sensor)
                                   .append(database, another.database)
                                   .isEquals();
    }
    
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
        .append(node)
        .append(snmp)
        .append(sensor)
        .append(database)
        .hashCode();
    }

    @Override
    public final String toString() {
        return new ToStringBuilder(this)
        .append(node)
        .append(snmp)
        .append(sensor)
        .append(database)
        .toString();
    }
}
