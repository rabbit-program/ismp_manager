package edu.sjtu.infosec.ismp.manager.TM.manager.serivce;


import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeTypeEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TopoManageConstant;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;
import org.infosec.ismp.manager.rmi.tm.manager.service.TopoWebService;

import edu.sjtu.infosec.ismp.manager.TM.manager.BasicTest;
import edu.sjtu.infosec.ismp.manager.TM.manager.service.TopoWebServiceImpl;

public class TopoWebServiceTest extends BasicTest {
//	private static TopoWebServiceImpl webService;

	
	private static TopoWebServiceImpl webService;
	
	
	
	public void testUp() {
		try {
			webService = (TopoWebServiceImpl) appContext.getBean("topoWebService");
			System.out.println(webService+"-----------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	public void testTradeMarkDaoSave() {
//		webService.tradeMarkDaoSave(new TradeMarkEntity());
//	}
	

	public static void setWebService(TopoWebServiceImpl webService) {
		TopoWebServiceTest.webService = webService;
	}

	

	public void testGetTradeMarkAll() {
		try {
			List<TradeMarkEntity> list = webService.getTradeMarkAll();
			if(list == null) return;
			System.out.println("---品牌记录数--"+list.size());
			if(list.size() >0) {
				System.out.println("---MarkId--"+list.get(0).getMarkId());
				System.out.println("---EnName--"+list.get(0).getEnName());
				System.out.println("---MarkName--"+list.get(0).getMarkName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testGetDeviceModelAll() {
		try {
			List<DeviceModelEntity> list = webService.getDeviceModelAll();
			if(list == null) return;
			System.out.println("---型号记录数--"+list.size());
			if(list.size() >0) {
				System.out.println("---ModeId--"+list.get(0).getModeId());
				System.out.println("---EnName--"+list.get(0).getEnName());
				System.out.println("---MarkName--"+list.get(0).getTradeMark().getMarkName());
				System.out.println("---ModeName---"+list.get(0).getName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testGetNodeTypeAll() {
		try {
			List<NodeTypeEntity> list = webService.getNodeTypeAll();
			if(list == null) return;
			System.out.println("---设备类型记录数--"+list.size());
			if(list.size() >0) {
				System.out.println("---typeId--"+list.get(0).getTypeId());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void testGetDomainAll() {
//		try {
//			List<DomainEntity> list = webService.getDomainAll();
//			if(list == null) return;
//			System.out.println("---域记录数--"+list.size());
//			if(list.size() >1) {
//				System.out.println("---domainId--"+list.get(1).getDomainId());
//				if(list.get(1).getParent() == null) {
//					System.out.println("父节点为根节点！");
//				} else {
//					System.out.println("---parentId--"+list.get(1).getParent().getDomainId());
//				}
//				System.out.println("---remark----"+list.get(1).getRemark());
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void testFindDomainById() {
//		try {
//			DomainEntity domain = webService.findDomainById("1");
//			System.out.println("---哉第一条记录--"+domain);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
/*	
	public void testSaveOrUpdateDomain() {
		
		DomainEntity domain = new DomainEntity();
		domain.setDomainId(3L);
		domain.setDomainName("BBBBB");
		try {
			webService.saveOrUpdateDomain(domain1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	
//	public void testDeleteDomain() {
//		DomainEntity domain = new DomainEntity();
//		domain.setDomainId(1L);
//		try {
//			webService.deleteDomain(domain);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	/*
	public void testDeleteDomains() {
		
		List<DomainEntity> list = webService.getDomainAll();
		try {
			webService.deleteDomains(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
//	public void testGetNodeAll() {
//		try {
//			List<NodeEntity> list = webService.getNodeAll();
//			if(list != null && list.size() > 0) {
//				System.out.println("-----NodeId----"+list.get(0).getNodeId());
//				System.out.println("-----brandId----"+list.get(0).getBrand().getMarkId());
//				System.out.println("-----getModeId----"+list.get(0).getModel().getModeId());
//				System.out.println("-----getDomainId----"+list.get(0).getDomain().getDomainId());
////				System.out.println("-----getManagerStyle----"+list.get(0).getManagerStyle());
//				System.out.println("-----typeId----"+list.get(0).getType().getTypeId());
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	public void testSaveOrUpdateNode() {
//		
//		DomainEntity domain = new DomainEntity();
//		domain.setDomainId(3L);
//		domain.setDomainName("BBBBB");
//		
//		NodeEntity node = webService.findNodeById("DDDDDDDDDDDDDDDD");
//		node.setDomain(domain);
//		
//		try {
//			webService.saveOrUpdateNode(node);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
	
	public void testGetDeviceByNode() {
		try {
			NodeEntity node = new NodeEntity();
			node.setNodeId("AAA");
			node.setManagerStyle(TopoManageConstant.DATABASE);
			DeviceEntity device = webService.getDeviceByNode(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void testAddNode() throws Exception {
		NodeEntity node = new NodeEntity();
		webService.saveOrUpdateNode(node);
		System.out.println(node.getNodeId());
	}
	
	public void testGetModelsByTradeMark() throws Exception {
		Map map = webService.getModelsByTradeMark();
		System.out.println(map.size());
		for(Object o : map.keySet()){
	        System.out.println(map.get(o));
	    }
	}
	
}
