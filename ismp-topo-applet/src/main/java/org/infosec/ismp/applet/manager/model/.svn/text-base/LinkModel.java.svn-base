package org.infosec.ismp.applet.manager.model;

import twaver.Link;

/**
 * 连接线模型
 * @author 肖高峰
 *
 */
public class LinkModel extends Link{
	private static final long serialVersionUID = -1517448219268446302L;
	public static final String PREFIX = "LinkModel";
	public static final String LINK_ID_PROPERTY = PREFIX + "LinkId";
	public static final String LINK_STATE_PROPERTY = PREFIX + "LinkState";
	public static final String NODE_TYPE_PROPERTY = PREFIX + "NodeType";
	public static final String FROM_DEVICE_PORT_PROPERTY = PREFIX + "FromDevicePort";
	public static final String TO_DEVICE_PORT_PROPERTY = PREFIX + "ToDevicePort";
	

    public Long getLinkId() {
    	Object o = getClientProperty(LINK_ID_PROPERTY);
		if(o != null ) {
			return (Long)o;
		}
		return null;
	}

	public void setLinkId(Long linkId) {
		putClientProperty(LINK_ID_PROPERTY,linkId);
	}

	public Integer getLinkState() {
		Object o = getClientProperty(LINK_STATE_PROPERTY);
		if(o != null ) {
			return (Integer)o;
		}
		return null;
	}

	public void setLinkState(Integer linkState) {
		putClientProperty(LINK_STATE_PROPERTY, linkState);
	}

	public Integer getNodeType() {
		Object o = getClientProperty(NODE_TYPE_PROPERTY);
		if(o != null ) {
			return (Integer)o;
		}
		return null;
	}

	public void setNodeType(Integer nodeType) {
		putClientProperty(NODE_TYPE_PROPERTY, nodeType);
	}

	public String getFromDevicePort() {
		Object o = getClientProperty(FROM_DEVICE_PORT_PROPERTY);
		if(o != null ) {
			return (String)o;
		}
		return null;
	}

	public void setFromDevicePort(String fromDevicePort) {
		putClientProperty(FROM_DEVICE_PORT_PROPERTY, fromDevicePort);
	}

	public String getToDevicePort() {
		Object o = getClientProperty(TO_DEVICE_PORT_PROPERTY);
		if(o != null ) {
			return (String)o;
		}
		return null;
	}

	public void setToDevicePort(String toDevicePort) {
		putClientProperty(TO_DEVICE_PORT_PROPERTY, toDevicePort);
	}
}
