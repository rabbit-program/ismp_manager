package edu.sjtu.infosec.ismp.manager.TM.manager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.infosec.ismp.manager.rmi.tm.discover.model.Line;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.manager.model.AssetDevice;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.DomainEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.LinkEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeTypeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.SNMPEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.SensorEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TopoManageConstant;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.AM.service.AssetDeviceService;
import edu.sjtu.infosec.ismp.manager.TM.discover.dao.LineDao;
import edu.sjtu.infosec.ismp.manager.TM.discover.dao.NodeDao;
import edu.sjtu.infosec.ismp.manager.TM.manager.dao.DatabaseDao;
import edu.sjtu.infosec.ismp.manager.TM.manager.dao.DeviceModelDao;
import edu.sjtu.infosec.ismp.manager.TM.manager.dao.LinkDao;
import edu.sjtu.infosec.ismp.manager.TM.manager.dao.SNMPDao;
import edu.sjtu.infosec.ismp.manager.TM.manager.dao.SensorDao;
import edu.sjtu.infosec.ismp.manager.TM.manager.dao.TopoDomainDao;
import edu.sjtu.infosec.ismp.manager.TM.manager.dao.TopoNodeDao;
import edu.sjtu.infosec.ismp.manager.TM.manager.dao.TopoNodeTypeDao;
import edu.sjtu.infosec.ismp.manager.TM.manager.dao.TradeMarkDao;

/**
 * 拓扑Web层存储、读取实现
 * @author 肖高峰
 *
 */
@Component
public class TopoWebServiceImpl implements TopoWebService{
	private TradeMarkDao tradeMarkDao;
	private DeviceModelDao deviceModelDao;
	private LinkDao linkDao;
	private TopoNodeDao topoNodeDao;
	private TopoNodeTypeDao nodeTypeDao;
	private TopoDomainDao domainDao;
	private SNMPDao snmpDao;
	private DatabaseDao databaseDao;
	private SensorDao sensorDao;
	private AssetDeviceService assetDeviceService;
	
	private LineDao lineDao;
	private NodeDao nodeDao;
	
	public void setLineDao(LineDao lineDao) {
		this.lineDao = lineDao;
	}
	
	public void setNodeDao(NodeDao nodeDao) {
		this.nodeDao = nodeDao;
	}

	
	public void setAssetDeviceService(AssetDeviceService assetDeviceService) {
		this.assetDeviceService = assetDeviceService;
	}

	@Autowired(required=true)
	public void setTradeMarkDao(TradeMarkDao tradeMarkDao) {
		this.tradeMarkDao = tradeMarkDao;
	}
	
	
	@Autowired(required=true)
	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}
	
	@Autowired(required=true)
	public void setTopoNodeDao(TopoNodeDao topoNodeDao) {
		this.topoNodeDao = topoNodeDao;
	}
	
	@Autowired(required=true)
	public void setTopoNodeTypeDao(TopoNodeTypeDao nodeTypeDao) {
		this.nodeTypeDao = nodeTypeDao;
	}
	
	@Autowired(required=true)
	public void setSnmpDao(SNMPDao snmpDao) {
		this.snmpDao = snmpDao;
	}

	@Autowired(required=true)
	public void setDatabaseDao(DatabaseDao databaseDao) {
		this.databaseDao = databaseDao;
	}

	@Autowired(required=true)
	public void setSensorDao(SensorDao sensorDao) {
		this.sensorDao = sensorDao;
	}

	@Autowired(required=true)
	public void setDeviceModelDao(DeviceModelDao deviceModelDao) {
		this.deviceModelDao = deviceModelDao;
	}
	
	@Autowired(required=true)
	public void setTopoDomainDao(TopoDomainDao domainDao) {
		this.domainDao = domainDao;
	}


	/**
	 * 查询出所有品牌
	 */
	@Transactional(readOnly=false)
    public List<TradeMarkEntity> getTradeMarkAll() throws Exception{
		return tradeMarkDao.getAll();
	}
	
	/**
	 * 查询出所有型号
	 */
	@Transactional(readOnly=false)
    public List<DeviceModelEntity> getDeviceModelAll() throws Exception{
		return deviceModelDao.getAll();
	}
	
	/**
	 * 查询所有设备类型
	 */
	@Transactional(readOnly=false)
    public List<NodeTypeEntity> getNodeTypeAll() throws Exception{
		return nodeTypeDao.getAll();
	}
	
	//----------------------------------------------------------------------
	
	/**
	 * 查询出所有域
	 * @throws Exception 
	 */
	@Transactional(readOnly=false)
    public List<DomainEntity> getDomainAll() throws Exception{
		return domainDao.getAll();
	}
	
	/**
	 * 添加修改云域
	 * @throws Exception 
	 */
	@Transactional(readOnly=false)
	public DomainEntity saveOrUpdateDomain(DomainEntity domainEntity) throws Exception {
		if(domainEntity == null) return null;
		Integer id = domainEntity.getId();
		domainDao.saveOrUpdateDomain(domainEntity);
		if(id == null) {
			NodeEntity node = new NodeEntity();
			node.setName(domainEntity.getDomainName());
			node.setParentDomain(domainEntity.getParentDomain());
			topoNodeDao.saveOrUpdateNode(node);
		}
		return domainEntity;
	}
	
	/**
	 * 添加修改云域集合
	 * @throws Exception 
	 */
	@Transactional(readOnly=false)
	public List<DomainEntity> saveOrUpdateDomains(List<DomainEntity> domainEntitys) throws Exception {
		if(domainEntitys == null || domainEntitys.size() == 0) return null;
		for(DomainEntity domain:domainEntitys) {
			saveOrUpdateDomain(domain);
		}
		return domainEntitys;
	}
	
	/**
	 * 根据对象删除域
	 * @throws Exception 
	 */
	@Transactional(readOnly=false)
	public void deleteDomain(DomainEntity domainEntity) throws Exception {
		if(domainEntity != null) {
			domainDao.delete(domainEntity);
		}
	}
	
	/**
	 * 根据对象删除域集合
	 * @throws Exception 
	 */
	@Transactional(readOnly=false)
	public void deleteDomains(List<DomainEntity> domainEntitys) throws Exception {
		if(domainEntitys == null || domainEntitys.size() == 0) return;
		domainDao.saveOrUpdateDomains(domainEntitys);
	}
		
	//--------------------------------------------------------------
	/**
	 * 查询出所有节点
	 */
	@Transactional(readOnly=false)
    public List<NodeEntity> getNodeAll() throws Exception{
		return topoNodeDao.getAll();
	}
	
	/**
	 * 查询出所有设备
	 */
	@Transactional(readOnly=false)
	public List<DeviceEntity> getDeviceAll() throws Exception {
		List<DeviceEntity> devices = new ArrayList<DeviceEntity>();
		List<NodeEntity> nodes = topoNodeDao.getAll();
		for(NodeEntity node : nodes) {
			devices.add(getDeviceByNode(node));
		}
		return devices;
	}
	
	/**
	 * 根据node ID查询节点
	 */
	@Transactional(readOnly=false)
    public NodeEntity findNodeById(String uId) throws Exception{
		NodeEntity nodeEntity = null;
		if(uId != null) {
			nodeEntity = topoNodeDao.findUniqueBy("nodeId", uId);
		}
		return nodeEntity;
	}
	
	/**
	 * 添加修改节点
	 */
	@Transactional(readOnly=false)
	public NodeEntity saveOrUpdateNode(NodeEntity nodeEntity) throws Exception{
		if(nodeEntity == null) return null;
		if(nodeEntity.getDomain() != null) {
			domainDao.saveOrUpdateDomain(nodeEntity.getDomain());
		}
		topoNodeDao.saveOrUpdateNode(nodeEntity);
		return nodeEntity;
	}
	
	/**
	 * 添加修改节点集合
	 */
	@Transactional(readOnly=false)
	public List<NodeEntity> saveOrUpdateNodes(List<NodeEntity> nodeEntitys) throws Exception{
		if(nodeEntitys == null || nodeEntitys.size()== 0)return null;
		for(NodeEntity node : nodeEntitys) {
			saveOrUpdateNode(node);
		}
		return nodeEntitys;
	}
	
	/**
	 * 根据对象删除节点
	 */
	@Transactional(readOnly=false)
	public void deleteNode(NodeEntity nodeEntity) throws Exception{
		if(nodeEntity != null) {
			if(nodeEntity.getDomain() != null) {
				domainDao.delete(nodeEntity.getDomain());
			}
			topoNodeDao.delete(nodeEntity);
		}
	}
	
	/**
	 * 根据对象删除节点集合
	 */
	@Transactional(readOnly=false)
	public void deleteNodes(List<NodeEntity> nodeEntitys) throws Exception{
		if(nodeEntitys == null || nodeEntitys.size() == 0) return;
		for(NodeEntity node:nodeEntitys) {
			deleteNode(node);
		}
	}
	//--------------------------------------------------------------
	
	/**
	 * 查询出所有线
	 */
	@Transactional(readOnly=false)
    public List<LinkEntity> getLinkAll() throws Exception{
		return linkDao.getAll();
	}
	
	/**
	 * 根据ID查询线
	 */
	@Transactional(readOnly=false)
    public LinkEntity findLinkById(String id) throws Exception{
		LinkEntity linkEntity = null;
		if(id != null) {
			linkEntity = linkDao.findUniqueBy("linkId", id);
		}
		return linkEntity;
	}
	
	/**
	 * 添加修改线
	 */
	@Transactional(readOnly=false)
	public LinkEntity saveOrUpdateLink(LinkEntity linkEntity) throws Exception{
		if(linkEntity == null) return null;
		linkDao.saveOrUpdateLink(linkEntity);
		return linkEntity;
	}
	
	
	
	/**
	 * 添加修改线
	 */
	@Transactional(readOnly=false)
	public List<LinkEntity> saveOrUpdateLinks(List<LinkEntity> linkEntitys) throws Exception{
		if(linkEntitys == null || linkEntitys.size() == 0) return linkEntitys;
		linkDao.saveOrUpdateLinks(linkEntitys);
		return linkEntitys;
	}
	
	/**
	 * 根据对象删除线
	 */
	@Transactional(readOnly=false)
	public void deleteLink(LinkEntity linkEntity) throws Exception{
		if(linkEntity != null) {
			linkDao.delete(linkEntity);
		}
	}
	
	/**
	 * 根据对象删除节点集合
	 */
	@Transactional(readOnly=false)
	public void deleteLinks(List<LinkEntity> linkEntitys) throws Exception{
		if(linkEntitys == null || linkEntitys.size() == 0) return;
		linkDao.deleteLinks(linkEntitys);
	}
	
	//---------------------------------------------------------------------
	
	/**
	 * 查询单个节点所有基本属性
	 */
	@Transactional(readOnly=false)
    public DeviceEntity getDeviceByNode(NodeEntity node) throws Exception{
		DeviceEntity device = new DeviceEntity();
		device.setNode(node);
		if(node == null) return device;
		String type = node.getManagerStyle();
		if(type == null) return device;
		String  propertyName = "node";
		if(type.equals(TopoManageConstant.SNMP)) {
			device.setSnmp(snmpDao.findUniqueBy(propertyName, node));
		} else if(type.equals(TopoManageConstant.DATABASE)) {
			device.setDatabase(databaseDao.findUniqueBy(propertyName, node));
		} else if(type.equals(TopoManageConstant.SENSOR)) {
			device.setSensor(sensorDao.findUniqueBy(propertyName, node));
		}
		return device;
	}

	
	/**
	 * 添加修改设备
	 * 1.先添加Node表
	 * 2.判断 nodeManageType 再添加 Sensor|Database|SNMP表
	 */
	@Transactional(readOnly=false)
	public DeviceEntity saveOrUpdateDevice(DeviceEntity deviceEntity) throws Exception{
		if(deviceEntity == null || deviceEntity.getNode() == null) return null;
		saveOrUpdateNode(deviceEntity.getNode());
		String manageType = deviceEntity.getNode().getManagerStyle();
		if(manageType == null) return null;
		if(manageType.equals(TopoManageConstant.SNMP) && deviceEntity.getSnmp() != null) {
			deviceEntity.getSnmp().setNode(deviceEntity.getNode());
			snmpDao.getSession().saveOrUpdate(deviceEntity.getSnmp());
		} else if(manageType.equals(TopoManageConstant.DATABASE) && deviceEntity.getDatabase() != null) {
			deviceEntity.getDatabase().setNode(deviceEntity.getNode());
			databaseDao.getSession().saveOrUpdate(deviceEntity.getDatabase());
		} else if(manageType.equals(TopoManageConstant.SENSOR) && deviceEntity.getSensor() != null) {
			deviceEntity.getSensor().setNode(deviceEntity.getNode());
			sensorDao.getSession().saveOrUpdate(deviceEntity.getSensor());
		}
		return deviceEntity;
	}
	
	/**
	 * 删除设备
	 * 1.先删除Node表
	 * 2.判断nodeManageType 再删除 Sensor|Database|SNMP表
	 */
	@Transactional(readOnly=false)
	public void deleteDevice(DeviceEntity deviceEntity) throws Exception{
		if(deviceEntity == null || deviceEntity.getNode() == null) return;
		deleteNode(deviceEntity.getNode());
		String manageType = deviceEntity.getNode().getManagerStyle();
		if(manageType == null) return;
		if(manageType.equals(TopoManageConstant.SNMP) && deviceEntity.getSnmp() != null) {
			snmpDao.delete(deviceEntity.getSnmp());
		} else if(manageType.equals(TopoManageConstant.DATABASE) && deviceEntity.getDatabase() != null) {
			databaseDao.delete(deviceEntity.getDatabase());
		} else if(manageType.equals(TopoManageConstant.SENSOR) && deviceEntity.getSensor() != null) {
			sensorDao.delete(deviceEntity.getSensor());
		}
	}

	/**
	 * 先查出两个表的数据。再做关联
	 */
	@Transactional(readOnly=false)
	public Map<TradeMarkEntity, List<DeviceModelEntity>> getModelsByTradeMark()
			throws Exception {
		Map<TradeMarkEntity, List<DeviceModelEntity>> map = new HashMap<TradeMarkEntity, List<DeviceModelEntity>>();
		List<TradeMarkEntity> tradeMarks = tradeMarkDao.getAll();
		List<DeviceModelEntity> deviceModels = deviceModelDao.getAll();
		if(tradeMarks == null) return map;
		for(TradeMarkEntity brand:tradeMarks) {
			List<DeviceModelEntity> temp = new ArrayList<DeviceModelEntity>();
			for(DeviceModelEntity model:deviceModels) {
				if(brand.equals(model.getTradeMark())) {
					temp.add(model);
				}
			}
			map.put(brand, temp);
		}
		return map;
	}
	

	//-------------------------------------实现读取拓扑发现数据-----start--------------------
	Map<Node,NodeEntity> mapping = new HashMap<Node,NodeEntity>();
	/**
	 * 获得拓扑发现所有的节点
	 * 1.查出拓扑管理表中的node
	 * 2.查出拓扑发现表中的node
	 * 3.用sensorID来比较匹配（去重复添加）
	 * 4.把比较后的数据换对象
	 * 5.保存比较后发现的数据到拓扑管理的表中
	 * 6.返回插入后的数据
	 */
	@Transactional(readOnly=false)
	public List<DeviceEntity> getTopoDiscoverDeviceAll() throws Exception{
		List<NodeEntity> topoNodes = getNodeAll();
		List<DeviceEntity> devices = getDeviceByNode(topoNodes);
		
		List<Node> nodes = nodeDao.findAllNodes();
		
		//比较后的拓扑发现node
		List<Node> tempNodes = new ArrayList<Node>();
		for(Node node:nodes) {
			boolean isSame = true;//可以添加
			for(DeviceEntity device:devices) {
				if(node.getSensorId() != null && device.getSensor() != null
						&& device.getSensor().getSensorId() != null 
						&& (node.getSensorId().equals(device.getSensor().getSensorId()))) {
					isSame = false;
					break;
					//比较两个表中是否有相同的sensorID记录  :PC
				} else if(node.getMac()!=null && node.getMac().equals(device.getNode().getNetCardCode())){
					isSame = false;
					break;
					//比较两个表中是否有相同的Mac记录  :其它设备
				} else if(node.getMac() == null && node.getIpAddr() != null && node.getIpAddr().equals(device.getNode().getIpAddress())) {
					isSame = false;
					break;
					//比较IP 相同地址
				}
			}
		  if(isSame) {
			  tempNodes.add(node);
		  }
		}
		
		List<DeviceEntity> tempdevices = new ArrayList<DeviceEntity>();
		for(Node tempNode : tempNodes) {
			DeviceEntity device = new DeviceEntity();
			NodeEntity topoNode = new NodeEntity();
			SensorEntity sensor = new SensorEntity();
			SNMPEntity snmp = new SNMPEntity();
			
			topoNode.setStatus(0);
			if(tempNode.getNodeType() != null) {
				NodeTypeEntity nodeType = new NodeTypeEntity();
				//BeanUtils.copyProperties(nodeType, tempNode.getNodeType());
				nodeType.setTypeId(tempNode.getNodeType().getId());
				topoNode.setType(nodeType);
			} else {
				NodeTypeEntity nodeType = new NodeTypeEntity();
				//BeanUtils.copyProperties(nodeType, tempNode.getNodeType());
				nodeType.setTypeId(8);
				topoNode.setType(nodeType);
			}
			topoNode.setName(tempNode.getName());
			topoNode.setIpAddress(tempNode.getIpAddr());
			topoNode.setNetCardCode(tempNode.getMac());
			topoNode.setRemark(tempNode.getDescription());
			snmp.setCommunity(tempNode.getCommunity());
			if(tempNode.getPort() != null) {
				snmp.setPort(tempNode.getPort()+"");
			}
			
			if(topoNode.getType() == null || topoNode.getType().equals(0)) {
				//拓扑发现未识别类型
				topoNode.setManagerStyle("未识别");
			} else if((tempNode.getSensorId() != null && tempNode.getSensorId().equals(""))
					|| (tempNode.getNodeType()!=null && tempNode.getNodeType().getId()==3)){
				//发现的是sensor
				topoNode.setManagerStyle(TopoManageConstant.SENSOR);
				sensor.setSensorId(tempNode.getSensorId());
				sensor.setMac(tempNode.getMac());
			} else {
				//发现的是其它SNMP类型
				topoNode.setManagerStyle(TopoManageConstant.SNMP);
			}
			
//			TradeMarkEntity brand = tradeMarkDao.findUniqueBy("enName", "cisco");
//			topoNode.setBrand(brand);
			topoNode.setNetCardCode(tempNode.getMac());
			device.setNode(topoNode);
			device.setSensor(sensor);
			device.setSnmp(snmp);
			tempdevices.add(device);
			mapping.put(tempNode, topoNode);
		}
		
		saveDevices(tempdevices);
		
		return tempdevices;
	}
	/**
	 * 获得拓扑发现所有的线
	 *  tempNodes 增加这个局部变量。是为了防止多少调用 getTopoDiscoverDeviceAll()实现
	 * 1.查出拓扑发现所有的连接线
	 * 2.筛选有效的连接线
	 * 3.复制两个表的对象数据
	 * 4.保存数据到拓扑管理表
	 * 6.返回保存后的数据
	 * @return List<LinkEntity>
	 */
	@Transactional(readOnly=false)
	public List<LinkEntity> getTopoDiscoverLinkAll() throws Exception{
		List<Line> lines = lineDao.findAllLines();
		if(mapping == null) return null;
		Set<Node> set = mapping.keySet();
		List<Node> tempNodes = new ArrayList<Node>(set);
		//筛选后的连接线
		List<Line> tempLines = new ArrayList<Line>();
		for(Line line : lines) {
			if(line.getNodeDest() == null || line.getNodeSelf() == null) {
				continue;
			}
			for(Node node : tempNodes) {
				if(line.getNodeDest().equals(node) || line.getNodeSelf().equals(node)) {
					tempLines.add(line);
				}
			}
		}
		
		List<LinkEntity> tempLinks = new ArrayList<LinkEntity>();
		for(Line line : tempLines) {
			LinkEntity link = new LinkEntity();
			link.setFromDeviceId(mapping.get(line.getNodeSelf()));
			link.setToDeviceId(mapping.get(line.getNodeDest()));
			tempLinks.add(link);
		}
		
		linkDao.saveOrUpdateLinks(tempLinks);
		
		mapping.clear();
		return tempLinks;
	}
	
	/**
	 * 获得未分配域的sensor
	 */
	@Transactional(readOnly=false)
	public List<DeviceEntity> getSensorAllByUnDomain() throws Exception {
		return getDeviceByNode(topoNodeDao.findSensorByUnDomain());
	}
	
	/**
	 * 查询出所有节点
	 */
	@Transactional(readOnly=false)
    private List<DeviceEntity> getDeviceByNode(List<NodeEntity> nodes) throws Exception{
    	List<DeviceEntity> devices = new ArrayList<DeviceEntity>();
    	for(NodeEntity node:nodes) {
    		devices.add(getDeviceByNode(node));
    	}
		return devices;
	}
    /**
	 * 保存所有节点
	 */
    private void saveDevices(List<DeviceEntity> devices) throws Exception{
    	for(DeviceEntity device:devices) {
    		saveOrUpdateDevice(device);
    	}
	}
	//-------------------------------------实现读取拓扑发现数据-----end----------------------
    
    //查询资产信息
    @Transactional(readOnly=false)
	public AssetDevice getAssetByNodeId(String nodeId) throws Exception {
		if(nodeId == null) return null;
		AssetDeviceBO bo = assetDeviceService.getByNodeId(nodeId);
		if(bo == null) return null;
		AssetDevice bean = new AssetDevice();
		BeanUtils.copyProperties(bean, bo);
		return bean;
	}

    
}
