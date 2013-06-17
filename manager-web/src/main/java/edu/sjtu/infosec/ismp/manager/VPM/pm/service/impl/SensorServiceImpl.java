package edu.sjtu.infosec.ismp.manager.VPM.pm.service.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.SensorClients;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.SensorClientsPatchService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.SensorService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

public class SensorServiceImpl implements SensorService {
	private SensorClientsPatchService sensorClientPatchService = new SensorClientsPatchServiceImpl();

	public List<PatchInfo> findAllOkPatchInfo() throws Exception {
		return sensorClientPatchService.findPatchInfoBy("false");
	}

	public PageResult findAllOkPatchInfo(Page page) throws Exception {
		return sensorClientPatchService.findPatchInfoBy("false", page);
	}

	public int findAllOkPatchInfoNum() throws Exception {
		return sensorClientPatchService.findPatchInfoByNum("false");
	}

	public List<PatchInfo> findAllPatchInfo() throws Exception {
		return sensorClientPatchService.findAllPatchInfo();
	}

	public PageResult findAllPatchInfo(Page page) throws Exception {
		return sensorClientPatchService.findAllPatchInfo(page);
	}

	public int findAllPatchInfoNum() throws Exception {
		return sensorClientPatchService.findAllPatchInfoNum();
	}

	public List<PatchUpdateInfo> findAllPatchUpdateFailedBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {5};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "in", states);
	}

	public PageResult findAllPatchUpdateFailedBySensorClients(
			SensorClients sensorClients, PMPage page) throws Exception {
		int[] states = {5};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "in", states, page);
	}

	public int findAllPatchUpdateFailedNumBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {5};
		return sensorClientPatchService.findAllByIDNum(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "inCount", states);
	}

	public List<PatchUpdateInfo> findAllPatchUpdateInfoBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "in", states);
	}

	public PageResult findAllPatchUpdateInfoBySensorClients(
			SensorClients sensorClients, PMPage page) throws Exception {
		int[] states = {};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "in", states, page);
	}

	public int findAllPatchUpdateInfoNumBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {};
		return sensorClientPatchService.findAllByIDNum(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "inCount", states);
	}

	public List<PatchUpdateInfo> findAllPatchUpdateNeedBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {2,3,6};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "in", states);
	}

	public PageResult findAllPatchUpdateNeedBySensorClients(
			SensorClients sensorClients, PMPage page) throws Exception {
		int[] states = {2,3,6};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "in", states, page);
	}

	public int findAllPatchUpdateNeedNumBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {2,3,6};
		return sensorClientPatchService.findAllByIDNum(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "inCount", states);
	}

	public int findAllPatchUpdateNoNumStateBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {1,2,3,4,5,6};
		return sensorClientPatchService.findAllByIDNum(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "notinCount", states);
	}

	public List<PatchUpdateInfo> findAllPatchUpdateNoStateBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {1,2,3,4,5,6};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "notin", states);
	}

	public PageResult findAllPatchUpdateNoStateBySensorClients(
			SensorClients sensorClients, PMPage page) throws Exception {
		int[] states = {1,2,3,4,5,6};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "notin", states, page);
	}

	public List<PatchUpdateInfo> findAllPatchUpdateOKBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {1,4};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "in", states);
	}

	public PageResult findAllPatchUpdateOKBySensorClients(
			SensorClients sensorClients, PMPage page) throws Exception {
		int[] states = {1,4};
		return sensorClientPatchService.findAllByID(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "in", states, page);
	}

	public int findAllPatchUpdateOkNumBySensorClients(
			SensorClients sensorClients) throws Exception {
		int[] states = {1,4};
		return sensorClientPatchService.findAllByIDNum(sensorClientPatchService.getComputerTargetID(sensorClients.getSensorIP()), "inCount", states);
	}

	public int findClientsNumOfNeedUpdate(List<SensorClients> sensorClientsList)
			throws Exception {
		int needNum = 0;
		for(SensorClients sc: sensorClientsList){
			int num = findAllPatchUpdateNeedNumBySensorClients(sc);
			if(num > 0){
				needNum++;
			}
		}
		return needNum;
	}

	public List<SensorClients> findClientsOfNeedUpdate(
			List<SensorClients> sensorClientsList) throws Exception {
		List<SensorClients> scList = new ArrayList<SensorClients>();
		for(SensorClients sc: sensorClientsList){
			int num = findAllPatchUpdateNeedNumBySensorClients(sc);
			if(num > 0){
				scList.add(sc);
			}
		}
		return scList;
	}

	public List<SensorClients> findClientsOfNeedUpdate(
			List<SensorClients> sensorClientsList, int startResult, int maxResult) throws Exception {
		List<SensorClients> scList = findClientsOfNeedUpdate(sensorClientsList);
		List<SensorClients> list = new ArrayList<SensorClients>();
		for(int i=0; i<maxResult; i++){
			if((startResult + i) < scList.size()){
				list.add(scList.get(startResult + i));
			}
		}
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	
}
