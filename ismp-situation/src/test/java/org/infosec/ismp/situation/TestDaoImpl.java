package org.infosec.ismp.situation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.infosec.ismp.situation.dao.MachineCabinetDao;
import org.infosec.ismp.situation.dao.MachineCabinetSituationDao;
import org.infosec.ismp.situation.dao.MachineDao;
import org.infosec.ismp.situation.dao.MachineRoomDao;
import org.infosec.ismp.situation.dao.MachineRoomSituationDao;
import org.infosec.ismp.situation.dao.MachineSituationDao;
import org.infosec.ismp.situation.dao.SecurityAreaDao;
import org.infosec.ismp.situation.dao.SecurityAreaSituationDao;
import org.infosec.ismp.situation.model.Machine;
import org.infosec.ismp.situation.model.MachineCabinetSituation;
import org.infosec.ismp.situation.model.MachineRoom;
import org.infosec.ismp.situation.model.MachineRoomSituation;
import org.infosec.ismp.situation.model.MachineSituation;
import org.infosec.ismp.situation.model.SecurityAreaSituation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDaoImpl extends TestCase {
	
	public static ApplicationContext context;
	
	static {
			context = new ClassPathXmlApplicationContext(
			new String[]{
					"classpath*:applicationContext-resources.xml",
					"classpath*:applicationContext-dao-situation.xml",
			});
	}
	///测试MachineSituationDaoImpl
	public void testMachineSituationDao() {
		MachineSituationDao machineSituationDao = (MachineSituationDao) context.getBean("machineSituationDao");
		
		List<MachineSituation> machineSituations = new ArrayList<MachineSituation>();
		for (int i = 0; i < 5; i++) {
			MachineSituation machineSituation = new MachineSituation();
			machineSituation.setAttackThreat(i*0.1f);
			machineSituation.setIp("127.0.0.1");
//			machineSituation.setMachineId(i*1);
			machineSituation.setInvalidConnection(i*0.2f);
			machineSituation.setVirusCondition(i*0.3f);
			machineSituation.setWholeSituation(i*0.4f);
			machineSituation.setTime(new Timestamp(new Date().getTime()));
			machineSituations.add(machineSituation);
		}
		machineSituationDao.save(machineSituations);
		System.out.println("测试：主机态势已经全部保存入库！！");
	}
	
	///测试MachineCabinetSituationDaoImpl
	public void testMachineCabinetSituationDaoImpl(){
		MachineCabinetSituationDao cabinetSituationDao =  (MachineCabinetSituationDao) context.getBean("machineCabinetSituationDao");
		List<MachineCabinetSituation> machineCabinetSituations = new ArrayList<MachineCabinetSituation>();
		for (int i = 0; i < 5; i++) {
			MachineCabinetSituation cabinetSituation = new MachineCabinetSituation();
			cabinetSituation.setMachineCabinetName("测试机柜名称" + i);
//			cabinetSituation.setMachineCabinetId(i);
			cabinetSituation.setWholeSituation(i*0.4f);
			cabinetSituation.setTime(new Timestamp(new Date().getTime()));
			machineCabinetSituations.add(cabinetSituation);
		}
		cabinetSituationDao.save(machineCabinetSituations);
		System.out.println("测试：机柜态势已经全部保存入库！！");
	}
	
	///测试MachineRoomSituationDaoImpl
	public void testMachineRoomSituationDaoImpl(){
		MachineRoomSituationDao machineRoomSituationDao = (MachineRoomSituationDao) context.getBean("machineRoomSituationDao");
		List<MachineRoomSituation> machineRoomSituations = new ArrayList<MachineRoomSituation>();
		for (int i = 0; i < 5; i++) {
			MachineRoomSituation roomSituation = new MachineRoomSituation();
//			roomSituation.setMachineRoomId(i);
			roomSituation.setMachineRoomName("测试机房名称");
			roomSituation.setTime(new Timestamp(new Date().getTime()));
			roomSituation.setWholeSituation(i*1f);
			machineRoomSituations.add(roomSituation);
		}
		machineRoomSituationDao.save(machineRoomSituations);
		System.out.println("测试：机房态势已经全部保存入库！！");
		
	}
	
	///测试SecurityAreaSituationDaoImpl
	public void testSecurityAreaSituationDaoImpl(){
		SecurityAreaSituationDao securityAreaSituationDao = (SecurityAreaSituationDao) context.getBean("securityAreaSituationDao");
		List<SecurityAreaSituation> securityAreaSituations = new ArrayList<SecurityAreaSituation>();
		for (int i = 0; i < 5; i++) {
			SecurityAreaSituation securityAreaSituation = new SecurityAreaSituation();
//			securityAreaSituation.setSecurityAreaId(i);
			securityAreaSituation.setSecurityAreaName("测试安全域名称" + i);
			securityAreaSituation.setTime(new Timestamp(new Date().getTime()));
			securityAreaSituation.setWholeSituation(i*1f);
			securityAreaSituations.add(securityAreaSituation);
		}
		securityAreaSituationDao.save(securityAreaSituations);
		System.out.println("测试：安全域态势已经全部保存入库！！");
	}
	
	///测试MachineDaoImpl
	@SuppressWarnings("unchecked")
	public void testMachineDaoImpl(){
		MachineDao machineDao = (MachineDao) context.getBean("machineDao");
		HashMap map = (HashMap) machineDao.getAllMachine();
		for(Object o : map.keySet()){   
			System.out.println("key = " + o.toString() + "  entry = " + ((Machine)map.get(o)).getMachineName());   
		}
		
	}
	
	///测试MachineCabinetDaoImpl
	public void testMachineCabinetDao(){
		MachineCabinetDao machineCabinetDao = (MachineCabinetDao) context.getBean("machineCabinetDao");
		HashMap map = (HashMap) machineCabinetDao.getAllMachineCabinet();
		for(Object o : map.keySet()){   
			System.out.println("key = " + o.toString() + "  entry = " + map.get(o).toString());   
		}
	}
	
	///测试SecurityAreaDaoImpl
	public void testSecurityAreaDaoImpl(){
		SecurityAreaDao securityAreaDao = (SecurityAreaDao) context.getBean("securityAreaDao");
		HashMap map = (HashMap) securityAreaDao.getAllSecurityArea();
		for(Object o : map.keySet()){   
			System.out.println("key = " + o.toString() + "  entry = " + map.get(o).toString());   
		}
	}
	
//	///测试MachineRoomDaoImpl
//	public void testMachineRoomDaoImpl(){
//		MachineRoomDao machineRoomDao = (MachineRoomDao) context.getBean("machineRoomDao");
//		List<MachineRoom> list = machineRoomDao.getMachineRoomList();
//		for (MachineRoom machineRoom : list) {
//			System.out.println(machineRoom.getMachineRoomName());
//		}
//	}
	

}
