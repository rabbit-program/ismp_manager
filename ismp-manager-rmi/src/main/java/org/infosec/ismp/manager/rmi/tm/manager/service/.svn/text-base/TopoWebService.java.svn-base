package org.infosec.ismp.manager.rmi.tm.manager.service;

import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.tm.manager.model.AssetDevice;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.DomainEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.LinkEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeTypeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;

/**
 * 拓扑管理WEB操作接口
 * @author 肖高峰
 *
 */
public interface TopoWebService {
	
	/**
	 * 
	 * @param assetDevice
	 * @throws Exception
	 */
	public AssetDevice getAssetByNodeId(String nodeId) throws Exception;

	/**
	 * 查询所有设备品牌列表
	 * @return List<TradeMarkEntity>
	 * @throws Exception
	 */
    public List<TradeMarkEntity> getTradeMarkAll() throws Exception;
	
	/**
	 * 查询出所有设备型号
	 * @return List<DeviceModelEntity>
	 * @throws Exception
	 */
    public List<DeviceModelEntity> getDeviceModelAll() throws Exception;
    
    /**
     * 查询出所有关联的品牌及型号
     * @return Map<TradeMarkEntity,List<DeviceModelEntity>> Map<品牌,List<型号>> 
     * @throws Exception
     */
    public Map<TradeMarkEntity,List<DeviceModelEntity>> getModelsByTradeMark() throws Exception;
	
	
    /**
     * 查询所有设备类型
     * @return List<NodeTypeEntity>
     * @throws Exception
     */
    public List<NodeTypeEntity> getNodeTypeAll() throws Exception;
	
	/**
	 * 查询出所有域
	 * @return  List<DomainEntity>
	 * @throws Exception
	 */
    public List<DomainEntity> getDomainAll() throws Exception;
	
	/**
	 * 添加修改云域
	 * @param DomainEntity
	 * @throws Exception
	 */
	public DomainEntity saveOrUpdateDomain(DomainEntity domainEntity) throws Exception;
	
	/**
	 * 添加修改云域集合
	 * @param List<DomainEntity>
	 * @throws Exception
	 */
	public List<DomainEntity> saveOrUpdateDomains(List<DomainEntity> domainEntitys) throws Exception;
	
	/**
	 * 根据对象删除域
	 * @param DomainEntity
	 * @throws Exception
	 */
	public void deleteDomain(DomainEntity domainEntity) throws Exception;
	
	/**
	 * 根据对象删除域集合
	 * @param List<DomainEntity>
	 * @throws Exception
	 */
	public void deleteDomains(List<DomainEntity> domainEntitys) throws Exception;
		
	/**
	 * 查询出所有节点
	 * @return List<NodeEntity>
	 * @throws Exception
	 */
    public List<NodeEntity> getNodeAll() throws Exception;
    
    /**
	 * 查询出所有设备
	 * @return List<NodeEntity>
	 * @throws Exception
	 */
    public List<DeviceEntity> getDeviceAll() throws Exception;
	
	/**
	 * 根据node ID查询节点
	 * @param String nodeID
	 * @return NodeEntity
	 * @throws Exception
	 */
    public NodeEntity findNodeById(String uId) throws Exception;
	
	/**
	 * 添加/修改节点
	 * 将回产生一个平台 NodeID
	 * 添加节点请注意：
	 *   1.在拓扑面板上显示必须添加以下几个属性值
	 *     (1) setType(NodeTypeEntity) 所属哪一类设备
	 *     (2) setDomainsetDomain(DomainEntity) 所属哪一个上层域
	 *   2.没有要求在拓扑面板上显示请添加以下几个属性值
	 *     (1)setNodeStyle(Integer)  设置为 1  
	 * 如果想添加更多的信息请参考节点Bean --NodeEntity
	 * @see org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity 
	 * @param NodeEntity
	 * @throws Exception
	 */
	public NodeEntity saveOrUpdateNode(NodeEntity nodeEntity) throws Exception;
	
	/**
	 * 添加修改节点集合
	 * @param List<NodeEntity>
	 * @throws Exception
	 */
	public List<NodeEntity> saveOrUpdateNodes(List<NodeEntity> nodeEntitys) throws Exception;
	
	/**
	 * 根据对象删除节点
	 * @param NodeEntity
	 * @throws Exception
	 */
	public void deleteNode(NodeEntity nodeEntity) throws Exception;
	
	/**
	 * 根据对象删除节点集合
	 * @param List<NodeEntity>
	 * @throws Exception
	 */
	public void deleteNodes(List<NodeEntity> nodeEntitys) throws Exception;
	
	/**
	 * 查询出所有线
	 * @return List<LinkEntity>
	 * @throws Exception
	 */
    public List<LinkEntity> getLinkAll() throws Exception;
	
	/**
	 * 根据ID查询线
	 * @param String
	 * @return LinkEntity
	 * @throws Exception
	 */
    public LinkEntity findLinkById(String id) throws Exception;
	
	/**
	 * 添加修改线
	 * @param LinkEntity
	 * @throws Exception
	 */
	public LinkEntity saveOrUpdateLink(LinkEntity linkEntity) throws Exception;
	
	
	/**
	 * 添加修改线
	 * @param List<LinkEntity>
	 * @throws Exception
	 */
	public List<LinkEntity> saveOrUpdateLinks(List<LinkEntity> linkEntitys) throws Exception;
	
	/**
	 * 根据对象删除线	
	 * @param LinkEntity
	 * @throws Exception
	 */
	public void deleteLink(LinkEntity linkEntity) throws Exception;
	
	/**
	 * 根据对象删除节点集合
	 * @param List<LinkEntity>
	 * @throws Exception
	 */
	public void deleteLinks(List<LinkEntity> linkEntitys) throws Exception;
	
	
	/**
	 * 查询对应的设备信息
	 * @param NodeEntity
	 * @return DeviceEntity
	 * @throws Exception
	 */
    public DeviceEntity getDeviceByNode(NodeEntity node) throws Exception;

	
	/**
	 * 添加修改设备
	 * 1.先添加Node表
	 * 2.判断 nodeManageType 再添加 Sensor|Database|SNMP表
	 * @param deviceEntity
	 * @throws Exception
	 */
	public DeviceEntity saveOrUpdateDevice(DeviceEntity deviceEntity) throws Exception;
	
	/**
	 * 删除设备
	 * 1.先删除Node表
	 * 2.判断nodeManageType 再删除 Sensor|Database|SNMP表
	 * @param deviceEntity
	 * @throws Exception
	 */
	public void deleteDevice(DeviceEntity deviceEntity) throws Exception;
	
	/**
	 * 获得拓扑发现的节点
	 * @return List<DeviceEntity>
	 * @throws Exception
	 */
	public List<DeviceEntity> getTopoDiscoverDeviceAll() throws Exception;
	
	/**
	 * 获得拓扑发现的连接线 !!!注意调用这个接口之间，请先接用 getTopoDiscoverDeviceAll()
	 * @return List<LinkEntity>
	 * @throws Exception
	 */
	public List<LinkEntity> getTopoDiscoverLinkAll() throws Exception;
	
	/**
	 * 获得未分配域的sensor
	 * @return List<DeviceEntity>
	 * @throws Exception
	 */
	public List<DeviceEntity> getSensorAllByUnDomain() throws Exception;
}
