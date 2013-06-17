package org.infosec.ismp.applet.manager.model;

import java.sql.Date;

import org.infosec.ismp.applet.manager.task.AddOrUpdateNodeTask;
import org.infosec.ismp.manager.rmi.tm.manager.model.AssetDevice;
import org.infosec.ismp.manager.rmi.tm.manager.model.DatabaseEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceInformation;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeTypeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.SNMPEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.SensorEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;

import twaver.Node;

/**
 * 节点模型
 * @author xiaogaofeng
 *
 */
public class NodeModel extends Node implements TopoNode{
	private static final long serialVersionUID = -5353039996456463001L;
	public static final String PREFIX = "NodeModel";
	public static final String NODE_ID_PROPERTY = PREFIX + "NodeId";
	public static final String POINT_X_PROPERTY = PREFIX + "PointX";
	public static final String POINT_Y_PROPERTY = PREFIX + "PointY";
	public static final String WIDTH_PROPERTY = PREFIX + "Width";
	public static final String HEIGHT_PROPERTY = PREFIX + "Height";
	public static final String STATUS_PROPERTY = PREFIX + "Status";
	public static final String DOMAIN_PROPERTY = PREFIX + "Domain";
	public static final String BRAND_PROPERTY = PREFIX + "Brand";
	public static final String MODEL_PROPERTY = PREFIX + "Model";
	public static final String TYPE_PROPERTY = PREFIX + "Type";
	public static final String IS_VISIBLE_PROPERTY = PREFIX + "IsVisible";
	public static final String NODE_STYLE_PROPERTY = PREFIX + "NodeStyle";
	public static final String MANAGER_STYLE_PROPERTY = PREFIX + "ManagerStyle";
	public static final String IP_ADDRESS_PROPERTY = PREFIX + "IpAddress";
	public static final String CREATETIME_PROPERTY = PREFIX + "";
	public static final String MAC_PROPERTY = PREFIX + "Mac";
	public static final String REMARK_PROPERTY = PREFIX + "Remark";
	public static final String SENSOR_PROPERTY = PREFIX + "Sensor";
	public static final String DATABASE_PROPERTY = PREFIX + "Database";
	public static final String SNMP_PROPERTY = PREFIX + "Snmp";
	public static final String SYSTEM_PROPERTY = PREFIX + "System";
	public static final String DEVICE_INFORMATION = PREFIX + "DeviceInformation";
	public static final String ASSET_INFORMATION =  PREFIX + "AssetInformation";
	public String getNodeId() {
		Object o = getClientProperty(NODE_ID_PROPERTY);
		if(o != null ) {
			return (String)o;
		}
		return null;
	}
	public void setNodeId(String nodeId) {
		putClientProperty(NODE_ID_PROPERTY, nodeId);
	}
	
	public AssetDevice getAssetInformation() {
		Object o = getClientProperty(ASSET_INFORMATION);
		if(o != null ) {
			return (AssetDevice)o;
		}
		return null;
	}
	public void setAssetInformation(AssetDevice assetInformation) {
		putClientProperty(ASSET_INFORMATION, assetInformation);
	}
	public DeviceInformation getDeviceInfomation() {
		Object o = getClientProperty(DEVICE_INFORMATION);
		if(o != null ) {
			return (DeviceInformation)o;
		}
		return null;
	}
	
	public void setDeviceInfomation(DeviceInformation deviceInfo) {
		putClientProperty(DEVICE_INFORMATION, deviceInfo);
	}

	public Integer getPointX() {
		return (int)getX();
	}
		

	public void setPointX(Integer pointX) {
		if(pointX != null) {
			xLocation = pointX;
		}
	}
	
	public Integer getPointY() {
		return (int)getY();
	}
	
	public void setPointY(Integer pointY) {
		if(pointY != null) {
			yLocation = pointY;
		}
	}

	public Integer getNodeWidth() {
		return getWidth();
	}
	
	public void setWidth(Integer width) {
		//TODO
	}

	public Integer getNodeHeight() {
		return super.getHeight();
	}

	public void setHeight(int height) {
		//TODO
	}
	
	public String getMac() {
		Object o = getClientProperty(MAC_PROPERTY);
		if(o != null ) {
			return (String)o;
		}
		return null;	
	}
	public void setMac(String mac) {
		putClientProperty(MAC_PROPERTY, mac);
	}

	public Integer getStatus() {
		Object o = getClientProperty(STATUS_PROPERTY);
		if(o != null ) {
			return (Integer)o;
		}
		return null;
	}

	public void setStatus(Integer status) {
		putClientProperty(STATUS_PROPERTY, status);
	}

	public DomainModel getParentDomain() {
		Object o = getClientProperty(DOMAIN_PROPERTY);
		if(o != null ) {
			return (DomainModel)o;
		}
		return null;
	}
	
	public void setParentDomain(DomainModel domain) {
		putClientProperty(DOMAIN_PROPERTY, domain);
		super.setParent(domain);
	}
	public TradeMarkEntity getBrand() {
		Object o = getClientProperty(BRAND_PROPERTY);
		if(o != null ) {
			return (TradeMarkEntity)o;
		}
		return null;
	}
	public void setBrand(TradeMarkEntity brand) {
		putClientProperty(BRAND_PROPERTY, brand);
	}
	public DeviceModelEntity getModel() {
		Object o = getClientProperty(MODEL_PROPERTY);
		if(o != null ) {
			return (DeviceModelEntity)o;
		}
		return null;
	}
	public void setModel(DeviceModelEntity model) {
		putClientProperty(MODEL_PROPERTY, model);
	}
	public NodeTypeEntity getType() {
		Object o = getClientProperty(TYPE_PROPERTY);
		if(o != null ) {
			return (NodeTypeEntity)o;
		}
		return null;
	}
	public void setType(NodeTypeEntity type) {
		putClientProperty(TYPE_PROPERTY, type);
	}
	public Integer getIsVisible() {
		Object o = getClientProperty(IS_VISIBLE_PROPERTY);
		if(o != null ) {
			return (Integer)o;
		}
		return null;
	}

	public void setIsVisible(Integer isVisible) {
		putClientProperty(IS_VISIBLE_PROPERTY, isVisible);
	}

	public Integer getNodeStyle() {
		Object o = getClientProperty(NODE_STYLE_PROPERTY);
		if(o != null ) {
			return (Integer)o;
		}
		return null;
	}

	public void setNodeStyle(Integer nodeStyle) {
		putClientProperty(NODE_STYLE_PROPERTY, nodeStyle);
	}

	public String getManagerStyle() {
		Object o = getClientProperty(MANAGER_STYLE_PROPERTY);
		if(o != null ) {
			return (String)o;
		}
		return null;
	}

	public void setManagerStyle(String managerStyle) {
		putClientProperty(MANAGER_STYLE_PROPERTY, managerStyle);
	}

	public String getIpAddress() {
		Object o = getClientProperty(IP_ADDRESS_PROPERTY);
		if(o != null ) {
			return (String)o;
		}
		return null;
	}

	public void setIpAddress(String ipAddress) {
		putClientProperty(IP_ADDRESS_PROPERTY, ipAddress);
	}
	
	public SensorEntity getSensor() {
		Object o = getClientProperty(SENSOR_PROPERTY);
		if(o != null ) {
			return (SensorEntity)o;
		}
		return null;
	}
	public void setSensor(SensorEntity sensor) {
		putClientProperty(SENSOR_PROPERTY, sensor);
	}
	public DatabaseEntity getDatabase() {
		Object o = getClientProperty(DATABASE_PROPERTY);
		if(o != null ) {
			return (DatabaseEntity)o;
		}
		return null;
	}
	public void setDatabase(DatabaseEntity database) {
		putClientProperty(DATABASE_PROPERTY, database);
	}
	public SNMPEntity getSnmp() {
		Object o = getClientProperty(SNMP_PROPERTY);
		if(o != null ) {
			return (SNMPEntity)o;
		}
		return null;
	}
	public void setSnmp(SNMPEntity snmp) {
		putClientProperty(SNMP_PROPERTY, snmp);
	}
	public Date getCreateTime() {
		Object o = getClientProperty(CREATETIME_PROPERTY);
		if(o != null ) {
			return (Date)o;
		}
		return null;	
	}

	public void setCreateTime(Date createTime) {
		putClientProperty(CREATETIME_PROPERTY, createTime);
	}

	public String getRemark() {
		Object o = getClientProperty(REMARK_PROPERTY);
		if(o != null ) {
			return (String)o;
		}
		return null;
	}

	public void setRemark(String remark) {
		putClientProperty(REMARK_PROPERTY, remark);
	}
	
	public String getSystem() {
		Object o = getClientProperty(SYSTEM_PROPERTY);
		if(o != null ) {
			return (String)o;
		}
		return null;	
	}
	public void setSystem(String system) {
		putClientProperty(SYSTEM_PROPERTY, system);
	}
	
	public void save(NodeModel node) {
		if(node != null) {
			new AddOrUpdateNodeTask(node).execute();
		}
	}
	
	public String toString() {
		return this.getName();
	}
	public String activeBigICO() {
		// TODO Auto-generated method stub
		return null;
	}
	public String activeSmallICO() {
		// TODO Auto-generated method stub
		return null;
	}
}
