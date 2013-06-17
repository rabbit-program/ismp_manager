package org.infosec.ismp.applet.manager.utilities;

import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.model.LinkModel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.DomainEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.LinkEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;

import twaver.Node;

/**
 * 前后台模型转换
 * @author 肖高峰
 * 
 * 所有方法第一个参数为目标对象，第二个参数为源对象
 */
public class ChangeModelUtil {
	
	public static void changeModel(NodeModel model,NodeEntity node) {
		if(node == null || model == null) return;
		model.setNodeId(node.getNodeId());
		model.setName(node.getName());
		model.setPointX(node.getPointX());
		model.setPointY(node.getPointY());
		model.setWidth(node.getWidth());
		model.setHeight(node.getHeight());
		model.setMac(node.getNetCardCode());
		model.setStatus(node.getStatus());
		if(node.getParentDomain() != null) {
			String guid = TopoConst.getTopoID(TopoConst.DOMAIN_ID+node.getParentDomain().getId().toString());
			model.setParentDomain((DomainModel)TopoConst.BOX.getElementByID(guid));
		}
		model.setBrand(node.getBrand());
		model.setModel(node.getModel());
		model.setNodeStyle(node.getNodeStyle());
		model.setType(node.getType());
		model.setIsVisible(node.getIsVisible());
		model.setManagerStyle(node.getManagerStyle());
		model.setIpAddress(node.getIpAddress());
		model.setRemark(node.getRemark());
		model.setSystem(node.getSystem());
		
	}
	
	public static NodeModel changeModel(DeviceEntity device) {
		if(device == null || device.getNode() == null) return null;
		NodeModel model = new NodeModel();
		changeModel(model,device.getNode());
		model.setSensor(device.getSensor());
		model.setDatabase(device.getDatabase());
		model.setSnmp(device.getSnmp());
		return model;
	}
	
	public static NodeModel changeModel(NodeModel model ,DeviceEntity device) {
		if(device == null || device.getNode() == null || model == null) return null;
		changeModel(model,device.getNode());
		model.setSensor(device.getSensor());
		model.setDatabase(device.getDatabase());
		model.setSnmp(device.getSnmp());
		return model;
	}
	
	
	public static void changeModel(NodeEntity model,NodeModel node) {
		if(node == null || model == null) return;
		model.setNodeId(node.getNodeId());
		model.setName(node.getName());
		model.setPointX(node.getPointX());
		model.setPointY(node.getPointY());
		model.setWidth(node.getWidth());
		model.setHeight(node.getHeight());
		model.setNetCardCode(node.getMac());
		model.setStatus(node.getStatus());
		if(node.getParentDomain() != null) {
			DomainEntity domain = new DomainEntity();
			changeDomainModel(domain,node.getParentDomain());
			model.setParentDomain(domain);
		}
		model.setBrand(node.getBrand());
		model.setModel(node.getModel());
		model.setNodeStyle(node.getNodeStyle());
		model.setType(node.getType());
		model.setIsVisible(node.getIsVisible());
		model.setManagerStyle(node.getManagerStyle());
		model.setIpAddress(node.getIpAddress());
		model.setRemark(node.getRemark());
		model.setSystem(node.getSystem());
		node.setPointX((int)node.getX());
		node.setPointY((int)node.getY());
	}
	
	public static DeviceEntity changeToDeviceModel(NodeModel node) {
		if(node == null) return null;
		DeviceEntity device = new DeviceEntity();
		NodeEntity nodeEntity = new NodeEntity();
		changeModel(nodeEntity,node);
		device.setNode(nodeEntity);
		device.setSensor(node.getSensor());
		device.setDatabase(node.getDatabase());
		device.setSnmp(node.getSnmp());
		return device;
	}
	
	public static void changeDomainModel(DomainEntity domain,DomainModel model) {
		if(model == null || domain == null) return;
		domain.setId(model.getId());
		domain.setDomainName(model.getDomainName());
		domain.setDescription(model.getDescription());
		DomainModel parentModel = model.getParentDomain();
		if(parentModel == null)return;
		DomainEntity parentEntity = new DomainEntity();
		changeParentDomainModel(parentEntity,parentModel);
		domain.setParentDomain(parentEntity);
	}
	
	public static void changeDomainModel(DomainModel domain,DomainEntity model) {
		if(model == null || domain == null) return;
		domain.setId(model.getId());
		domain.setDomainName(model.getDomainName());
		domain.setDescription(model.getDescription());
		domain.setParentDomain(changeParentDomainModel(model));
	}
	
	private static void changeParentDomainModel(DomainEntity domain,DomainModel model) {
		if(model == null || domain == null) return;
		domain.setId(model.getId());
		domain.setDomainName(model.getDomainName());
		domain.setDescription(model.getDescription());
	}
	
	private static DomainModel changeParentDomainModel(DomainEntity domain) {
		if(domain == null) return null;
		String guid = TopoConst.getTopoID(TopoConst.DOMAIN_ID+domain.getId());
		Object o = TopoConst.BOX.getElementByID(guid);
		if(o != null) {
			return (DomainModel)o;
		}
		return null;
	}
	
	public static void changeLinkModel(LinkModel model,LinkEntity link) {
		model.setLinkId(link.getLinkId());
		String fromGUID = TopoConst.getTopoID(link.getFromDeviceId().getNodeId());
		model.setFrom((Node)TopoConst.BOX.getElementByID(fromGUID));
		String toGUID = TopoConst.getTopoID(link.getToDeviceId().getNodeId());
		model.setTo((Node)TopoConst.BOX.getElementByID(toGUID));
		model.setFromDevicePort(link.getFromDevicePort());
		model.setToDevicePort(link.getToDevicePort());
		model.setLinkState(link.getLinkState());
	}
	
	public static void changeLinkModel(LinkEntity link,LinkModel model) {
		link.setLinkId(model.getLinkId());
		Node fromNode = model.getFrom();
		if(fromNode != null) {
			if(fromNode instanceof NodeModel) {
				NodeEntity node = new NodeEntity();
				changeModel(node, (NodeModel)fromNode);
				link.setFromDeviceId(node);
			} else if(fromNode instanceof DomainModel) {
				link.setFromDeviceId(((DomainModel)fromNode).getDatabaseNode());
			}
			
		}
		Node toNode = model.getTo();
		if(toNode != null) {
			if(toNode instanceof NodeModel) {
				NodeEntity node = new NodeEntity();
				changeModel(node, (NodeModel)toNode);
				link.setToDeviceId(node);
			} else if(toNode instanceof DomainModel) {
				link.setToDeviceId(((DomainModel)toNode).getDatabaseNode());
			}
		}
		link.setFromDevicePort(model.getFromDevicePort());
		link.setToDevicePort(model.getToDevicePort());
		link.setLinkState(model.getLinkState());
	}
	
	//把数据节点转换为云图
	public static DomainModel changeDomainModel(DomainModel model,NodeEntity node) {
		model.setDatabaseNode(node);
		if(node.getDomain() != null) {
			model.setId(node.getDomain().getId());
			model.setName(node.getDomain().getDomainName());
			model.setDescription(node.getDomain().getDescription());
			
		}
		if(node.getParentDomain() != null) {
			DomainModel parentDomain = changeParentDomainModel(node.getParentDomain());
			model.setParentDomain(parentDomain);
		}
		model.setLocation(node.getPointX(), node.getPointY());
		return model;
	}
	//把云图转换数据节点
	public static NodeEntity changeDomainModel(NodeEntity node,DomainModel model) {
		DomainEntity domain = null;
		DomainModel parentModel = model.getParentDomain();
		if(model.getDatabaseNode() == null || model.getDatabaseNode().getNodeId() == null) {
			//数据还没保存
			 node = new NodeEntity();
			 domain = new DomainEntity();
			 
		} else {
			//数据库已有记录
			 node = model.getDatabaseNode();
			 domain = model.getDatabaseNode().getDomain();
		}
		if(parentModel != null) {
			//有父节点
			node.setParentDomain(parentModel.getDatabaseNode().getDomain());
			domain.setParentDomain(node.getParentDomain());
		} 
		domain.setDomainName(model.getName());
		domain.setDescription(model.getDescription());
		
		node.setPointX((int)model.getX());
		node.setPointY((int)model.getY());
		node.setDomain(domain);
		return node;
	}
	
	
	public static DeviceEntity changeDeviceEntity(NodeModel node) {
		NodeEntity nodeEntity = new NodeEntity();
		ChangeModelUtil.changeModel(nodeEntity, node);
		DeviceEntity device = new DeviceEntity();
		device.setNode(nodeEntity);
		device.setDatabase(node.getDatabase());
		device.setSensor(node.getSensor());
		device.setSnmp(node.getSnmp());
		return device;
	}
}
