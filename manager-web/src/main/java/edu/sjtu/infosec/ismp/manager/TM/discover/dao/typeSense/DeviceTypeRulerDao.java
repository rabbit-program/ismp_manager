package edu.sjtu.infosec.ismp.manager.TM.discover.dao.typeSense;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.discover.model.typeSense.DeviceTypeRuler;


/**
 * 匹配规则-数据库操作
 * @author Wu Guojie
 * @date 2009-6-8
 * @version 1.0
 */
public interface DeviceTypeRulerDao {
	/**
	 * 添加规则
	 * @param deviceTypeRuler
	 * 规则
	 */
	void addDeviceTypeRuler(DeviceTypeRuler deviceTypeRuler) throws Exception;
	/**
	 * 删除规则
	 * @param deviceTypeRuler
	 * 规则
	 */
	void deleteDeviceTypeRuler(DeviceTypeRuler deviceTypeRuler) throws Exception;
	/**
	 * 修改规则
	 * @param deviceTypeRuler
	 * 规则
	 */
	void updateDeviceTypeRuler(DeviceTypeRuler deviceTypeRuler) throws Exception;
	/**
	 * 查找所有规则
	 * @return 规则list
	 */
	List<DeviceTypeRuler> findAllDeviceTypeRulers() throws Exception;
	/**
	 * 通过名字查找规则
	 * @param name
	 * 名字
	 * @return 规则list
	 */
	List<DeviceTypeRuler> findAllDeviceTypeRulersByDeviceName(String name) throws Exception;
	/**
	 * 通过id查找规则
	 * @param id
	 * id
	 * @return 规则
	 */
	DeviceTypeRuler findDeviceTypeRulerById(int id) throws Exception;
	/**
	 * 查找所有规则名
	 * @return 规则名list
	 */
	List<String> findAllDeviceName() throws Exception;
}
