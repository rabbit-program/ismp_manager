package edu.sjtu.infosec.ismp.manager.BSAM.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.infosec.ismp.manager.rmi.bsam.service.SituationService;

import edu.sjtu.infosec.ismp.manager.BSAM.comm.Constants;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.ColorThresholdDao;
import edu.sjtu.infosec.ismp.manager.BSAM.dao.MachineDao;
import edu.sjtu.infosec.ismp.manager.BSAM.model.MachineSituationVO;
import edu.sjtu.infosec.ismp.manager.BSAM.service.MachineSituationService;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.comm.SecurityUserHolder;
import edu.sjtu.infosec.ismp.security.Domain;

public class MachineSituationServiceImpl implements MachineSituationService {
	
	private static Logger logger = Logger.getLogger(MachineSituationServiceImpl.class); 
	
	private MachineDao machineDao;
	
	private ColorThresholdDao colorThresholdDao;
	
	private SituationService situationService;///RMI
	
	public MachineDao getMachineDao() {
		return machineDao;
	}

	public void setMachineDao(MachineDao machineDao) {
		this.machineDao = machineDao;
	}

	public ColorThresholdDao getColorThresholdDao() {
		return colorThresholdDao;
	}

	public void setColorThresholdDao(ColorThresholdDao colorThresholdDao) {
		this.colorThresholdDao = colorThresholdDao;
	}

	public SituationService getSituationService() {
		return situationService;
	}

	public void setSituationService(SituationService situationService) {
		this.situationService = situationService;
	}

	@SuppressWarnings("unchecked")
	public List getTopMachineSituation(String isAllAndtopNum) {
		 ///解析传递过来的isAllAndtopNum参数
		 String[] tempArr =  isAllAndtopNum.split(",");
		 String isAll = tempArr[0];
		 String topNum = tempArr[1];
		 ///用户域列表
		 List<Domain> userDomainList = SecurityUserHolder.getCurrentUser().getDomainList();
		 StringBuffer userDomainStr = new StringBuffer();
			
		 ///遍历userDomainList,将domain的id组成一个字符串
		 for (int i = 0; i < userDomainList.size(); i++) {
			if(i != (userDomainList.size()-1)){
				userDomainStr.append(userDomainList.get(i).getId()).append(",");
			}else{
				userDomainStr.append(userDomainList.get(i).getId());
			}
		 }
		 ///当前时间
		 Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		 ///三分钟之前的时间
		 Timestamp beginTime = new Timestamp(currentTime.getTime() - Constants.T);
		 
		 String errorMessage = "right";
		 List<MachineSituationVO> topMachineSituationList = new ArrayList<MachineSituationVO>();
		 
		 try {
			///取得beginTime——endTime时间段内态势前topNum名的主机态势
			 List<org.infosec.ismp.manager.rmi.bsam.model.MachineSituationVO> tempTopMachineSituationList 
			 	= situationService.getTopMachineSituation(userDomainStr.toString(), isAll, beginTime, currentTime, Integer.parseInt(topNum));
			 for (org.infosec.ismp.manager.rmi.bsam.model.MachineSituationVO machineSituationVO : tempTopMachineSituationList) {
				 MachineSituationVO tempMachineSituationVO = new MachineSituationVO();
				 tempMachineSituationVO.setId(machineSituationVO.getId());
				 tempMachineSituationVO.setIp(machineSituationVO.getIp());
				 tempMachineSituationVO.setMachineDescription(machineSituationVO.getMachineDescription());
				 tempMachineSituationVO.setMachineName(machineSituationVO.getMachineName());
				 tempMachineSituationVO.setParentName(machineSituationVO.getParentName());
				 tempMachineSituationVO.setParentType(machineSituationVO.getParentType());
				 tempMachineSituationVO.setTime(machineSituationVO.getTime());
				 tempMachineSituationVO.setAttackThreat(machineSituationVO.getAttackThreat());
				 tempMachineSituationVO.setVirusCondition(machineSituationVO.getVirusCondition());
				 tempMachineSituationVO.setInvalidConnection(machineSituationVO.getInvalidConnection());
				 tempMachineSituationVO.setWholeSituation(machineSituationVO.getWholeSituation());
				 topMachineSituationList.add(tempMachineSituationVO);
			 }
		} catch (Exception e) {
			logger.error("后台调用失败！");
			errorMessage = "error";
		}
		
//		 /** 以下模拟RMI返回结果测试 **/
//		 List<MachineSituationVO> topMachineSituationList = new ArrayList<MachineSituationVO>();
//		 for (int i = 0; i < 20; i++) {
//			 MachineSituationVO tempMachineSituationVO = new MachineSituationVO();
//			 tempMachineSituationVO.setId(1);
//			 tempMachineSituationVO.setIp("192.168.9.121");
//			 tempMachineSituationVO.setMachineDescription("这是主机信息");
//			 tempMachineSituationVO.setTime(currentTime);
//			 tempMachineSituationVO.setAttackThreat(3.5f);
//			 tempMachineSituationVO.setVirusCondition(4.5f);
//			 tempMachineSituationVO.setInvalidConnection(5.5f);
//			 switch (i) {
//				case 0:
//					tempMachineSituationVO.setWholeSituation(99.52f);///模拟生成5以内随机数
//					break;
//				case 1:
//					tempMachineSituationVO.setWholeSituation(85.34f);///模拟生成5-10以内随机数
//					break;
//				case 2:
//					tempMachineSituationVO.setWholeSituation(82.56f);///模拟生成10-15以内随机数
//					break;
//				case 3:
//					tempMachineSituationVO.setWholeSituation(78.23f);///模拟生成15-20以内随机数
//					break;
//				case 4:
//					tempMachineSituationVO.setWholeSituation(75.23f);///模拟生成20-25以内随机数
//					break;
//				case 5:
//					tempMachineSituationVO.setWholeSituation(72.35f);///模拟生成25-30以内随机数
//					break;
//				case 6:
//					tempMachineSituationVO.setWholeSituation(68.25f);///模拟生成30-35以内随机数
//					break;
//				case 7:
//					tempMachineSituationVO.setWholeSituation(62.53f);///模拟生成35-40以内随机数
//					break;
//				case 8:
//					tempMachineSituationVO.setWholeSituation(58.56f);///模拟生成40-45以内随机数
//					break;
//				case 9:
//					tempMachineSituationVO.setWholeSituation(55.23f);///模拟生成45-50以内随机数
//					break;
//				case 10:
//					tempMachineSituationVO.setWholeSituation(51.02f);///模拟生成50-55以内随机数
//					break;
//				case 11:
//					tempMachineSituationVO.setWholeSituation(49.58f);///模拟生成55-60以内随机数
//					break;
//				case 12:
//					tempMachineSituationVO.setWholeSituation(46.89f);///模拟生成60-65以内随机数
//					break;
//				case 13:
//					tempMachineSituationVO.setWholeSituation(40.12f);///模拟生成65-70以内随机数
//					break;
//				case 14:
//					tempMachineSituationVO.setWholeSituation(34.59f);///模拟生成70-75以内随机数
//					break;
//				case 15:
//					tempMachineSituationVO.setWholeSituation(30.76f);///模拟生成75-80以内随机数
//					break;
//				case 16:
//					tempMachineSituationVO.setWholeSituation(25.36f);///模拟生成80-85以内随机数
//					break;
//				case 17:
//					tempMachineSituationVO.setWholeSituation(24.23f);///模拟生成85-90以内随机数
//					break;
//				case 18:
//					tempMachineSituationVO.setWholeSituation(18.52f);///模拟生成90-95以内随机数
//					break;
//				case 19:
//					tempMachineSituationVO.setWholeSituation(7.56f);///模拟生成95-100以内随机数
//					break;
//				case 20:
//					tempMachineSituationVO.setWholeSituation(2.35f);///模拟生成95-100以内随机数
//					break;
//			 }
////			 tempMachineSituationVO.setWholeSituation((float)Math.random()*100);///模拟生成100以内随机数
//			 tempMachineSituationVO.setMachineName("主机192.168.9.121");
//			 tempMachineSituationVO.setParentType("机柜");
//			 tempMachineSituationVO.setParentName("机柜：7号楼9号楼");
//			 
////			 Machine tempMachine = (Machine)machineDao.getObject(Machine.class, 6);
////			 
////			 tempMachineSituationVO.setMachineName(tempMachine.getMachineName());
////			 
////			 if(Constants.JiGui.equals(tempMachine.getParentType())){
////				 tempMachineSituationVO.setParentType("机柜");
////				 tempMachineSituationVO.setParentName(tempMachine.getMachineCabinet().getMachineCabinetName());
////			 }else if(Constants.JiFang.equals(tempMachine.getParentType())){
////				 tempMachineSituationVO.setParentType("机房");
////				 tempMachineSituationVO.setParentName(tempMachine.getMachineRoom().getMachineRoomName());
////			 }else if(Constants.AnQuanYu.equals(tempMachine.getParentType())){
////				 tempMachineSituationVO.setParentType("安全域");
////				 tempMachineSituationVO.setParentName(tempMachine.getDomain().getDomainName());
////			 }
//			 
//			 topMachineSituationList.add(tempMachineSituationVO);
//		}
//		/** 以上模拟RMI返回结果测试 **/
		 ///取得颜色阈值列表
		 List colorThresholdList = colorThresholdDao.getColorThresholdList();
		 
		 List totalList = new ArrayList();
		 if(null != topMachineSituationList && null != colorThresholdList){
			 totalList.add(0, topMachineSituationList);///放入主机态势列表
			 totalList.add(1, colorThresholdList);///放入颜色阈值列表
			 totalList.add(2, errorMessage);///将错误信息带到前台页面。便于RMI连接失败时给出友好提示。
		 }
		 
		 return totalList;
	}
//	====================================================
}
