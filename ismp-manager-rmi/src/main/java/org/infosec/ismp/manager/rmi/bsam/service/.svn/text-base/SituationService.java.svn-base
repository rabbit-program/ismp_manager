package org.infosec.ismp.manager.rmi.bsam.service;

import java.sql.Timestamp;
import java.util.List;

import org.infosec.ismp.manager.rmi.bsam.model.MachineSituationVO;
import org.infosec.ismp.manager.rmi.bsam.model.SecurityAreaSituationVO;
import org.infosec.ismp.manager.rmi.bsam.model.SubUnitSituationVO;

/**
 * 
 * @author cchang
 * @date 2010-12-8 16:03:19
 */
public interface SituationService {
	
	/**
	 * 根据传入的域id查找beginTime——endTime时间段内的安全域态势(最新的一条)
	 * @param domainId
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	SecurityAreaSituationVO getSecurityAreaSituationBySecurityAreaId(String domainId,Timestamp beginTime,Timestamp endTime);
	/**
	 * 根据传入的机房id查找beginTime——endTime时间段内的机房态势(最新的一条)
	 * @param machineRoomId
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	SubUnitSituationVO getMachineRoomSituationByMachineRoomId(String machineRoomId,Timestamp beginTime,Timestamp endTime);
	/**
	 * 根据传入的机柜id查找beginTime——endTime时间段内的机柜态势(最新的一条)
	 * @param machineCabinetId
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	SubUnitSituationVO getMachineCabinetSituationByMachineCabinetId(String machineCabinetId,Timestamp beginTime,Timestamp endTime);
	/**
	 * 根据传入的主机id查找beginTime——endTime时间段内的主机态势(最新的一条)
	 * @param machineId
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	SubUnitSituationVO getMachineSituationByMachineId(String machineId,Timestamp beginTime,Timestamp endTime);
	
	/**
	 * 取得beginTime——endTime时间段内态势前topNum名的主机态势
	 * @param userDomainStr
	 * @param isAll
	 * @param beginTime
	 * @param endTime
	 * @param topNum
	 * @return
	 */
	List<MachineSituationVO> getTopMachineSituation(String userDomainStr,String isAll,Timestamp beginTime,Timestamp endTime,Integer topNum);
	
}
