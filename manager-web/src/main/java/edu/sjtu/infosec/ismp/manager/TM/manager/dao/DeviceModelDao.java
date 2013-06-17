package edu.sjtu.infosec.ismp.manager.TM.manager.dao;

import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

/**
 * 负责读取、保存设备的子类型号信息
 * @author 肖高峰
 *
 */

@Component
public class DeviceModelDao extends HibernateDao<DeviceModelEntity, Integer>{
	
}
