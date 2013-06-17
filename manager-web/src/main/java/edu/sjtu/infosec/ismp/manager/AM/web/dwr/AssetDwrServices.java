package edu.sjtu.infosec.ismp.manager.AM.web.dwr;

import java.util.List;

import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;

public interface AssetDwrServices {
	List<DeviceModelEntity> selectModels(String ename) throws Exception;
}
