package edu.sjtu.infosec.ismp.manager.VPM.pm.service.impl;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.manager.VPM.pm.dao.SensorClientsPatchDao;
import edu.sjtu.infosec.ismp.manager.VPM.pm.dao.impl.SensorClientsPatchDaoImpl;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.service.SensorClientsPatchService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * @author Admin
 *
 */
public class SensorClientsPatchServiceImpl implements SensorClientsPatchService{
	
	private SensorClientsPatchDao scpd = new SensorClientsPatchDaoImpl();
	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#getComputerTargetID(java.lang.String)
	 */
	public String getComputerTargetID(String ip)throws Exception{
		System.out.println("SensorClientsPatchServiceImpl:getComputerTargetID():IP:"+ip);
		return scpd.getComputerTargetId(ip);
	}
	

	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#findPatchInfoBy(java.lang.String)
	 */
	@Deprecated
	/**
	 * 
	 */
	public List<PatchInfo> findPatchInfoBy(String declined) throws Exception {
		System.out.println("SensorClientsPatchServiceImpl:findPatchInfoBy():declined:"+declined);
		List<PatchInfo> list = scpd.getPatchInfo(declined, "other");
		if(list!=null && !list.isEmpty()){
			return list;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#findPatchInfoBy(java.lang.String, edu.sjtu.infosec.ismp.base.mciommon.Page)
	 */
	public PageResult findPatchInfoBy(String declined,Page page) throws Exception {
		System.out.println("SensorClientsPatchServiceImpl:findPatchInfoBy():declined:"+declined+",当前页："+page.getCurrentPage());
		PageResult pr = new PageResult();
		List<PatchInfo> list = scpd.getPatchInfo(declined, "other",page);
		Integer countSize = scpd.getPatchInfoCount(declined, "count");
		page= PageUtil.createPage(page, countSize);
		if(list!=null && !list.isEmpty()){
			pr.setPage(page);
			pr.setPageList(list);
			return pr;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#findPatchInfoByNum(java.lang.String)
	 */
	public Integer findPatchInfoByNum(String declined) throws Exception {
		System.out.println("SensorClientsPatchServiceImpl:findPatchInfoByNum():declined:"+declined);
		return scpd.getPatchInfoCount(declined, "count");
	}

	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#findAllPatchInfo()
	 */
	@Deprecated
	/**
	 * 已过时，返回所有的记录数，没分页，返回《PatchInfo》
	 */
	public List<PatchInfo> findAllPatchInfo() throws Exception {
		System.out.println("SensorClientsPatchServiceImpl:findAllPatchInfo()");
		List<PatchInfo> list = scpd.getPatchInfo(null,"other");
		if(list!=null && !list.isEmpty()){
			return list;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#findAllPatchInfo(edu.sjtu.infosec.ismp.base.mciommon.Page)
	 */
	public PageResult findAllPatchInfo(Page page) throws Exception {
		System.out.println("SensorClientsPatchServiceImpl:findAllPatchInfo(),当前页："+page.getCurrentPage());
		PageResult pr = new PageResult();
		List<PatchInfo> list = scpd.getPatchInfo(null,"other",page);
		Integer countSize = scpd.getPatchInfoCount(null, "count");
		page= PageUtil.createPage(page, countSize);
		if(list!=null && !list.isEmpty()){
			pr.setPage(page);
			pr.setPageList(list);
			return pr;
		}
		return null;
	}

	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#findAllPatchInfoNum()
	 */
	public Integer findAllPatchInfoNum() throws Exception {
		System.out.println("SensorClientsPatchServiceImpl:findAllPatchInfoNum()");
		return scpd.getPatchInfoCount(null, "count");
	}

	
	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#findAllByID(java.lang.String, java.lang.String, int[])
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	/**
	 * 已过时，根据条件查询记录，返回《PatchUpdateInfo》
	 */
	public List<PatchUpdateInfo> findAllByID(String computerID,String type,int[] states)throws Exception{
		System.out.println("SensorClientsPatchServiceImpl:findAllByID():computerID:"+computerID+",type:"+type+",states:"+states);
		List<PatchUpdateInfo> list = scpd.getPatchUpdateInfoByState(computerID, type, states);
		for(PatchUpdateInfo pui: list){
			pui.setPatchInfo(scpd.getPatchInfoById(pui.getUpdateId(),"false"));
		}
		if(list!=null && !list.isEmpty()){
			return list;
		}
		return null;
	}
	

	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#findAllByID(java.lang.String, java.lang.String, int[], edu.sjtu.infosec.ismp.base.mciommon.Page)
	 */
	@SuppressWarnings("unchecked")
	public PageResult findAllByID(String computerID,String type,int[] states,PMPage page)throws Exception{
		System.out.println("SensorClientsPatchServiceImpl:findAllByID():computerID:"+computerID+",type:"+type+",states:"+states+",+declined,当前页："+page.getCurrentPage());
		if(computerID == null || computerID ==""){
			return null;
		}
		PageResult pr = new PageResult();
		List<PatchUpdateInfo> list = scpd.getPatchUpdateInfoByState(computerID, type, states,page);
		for(PatchUpdateInfo pui: list){
			pui.setPatchInfo(scpd.getPatchInfoById(pui.getUpdateId(),"false"));
		}
//		Integer countSize = scpd.getPatchUpdateInfoByStateCount(computerID, "inCount", states);								//总记录
		Integer countSize = scpd.getPatchUpdateInfoByStateCount(computerID, type.equalsIgnoreCase("in")?"inCount":"notInCount", states);								//总记录
		page = PMPageUtil.createPage(page, countSize);
		if(list!=null && !list.isEmpty()){
			pr.setPmpage(page);
			pr.setPageList(list);
			return pr;
		}
		return null;
	}
	
	
	/* (non-Javadoc)
	 * @see edu.sjtu.infosec.ismp.manager.patchManager.service.impl.SensorClientsPatchService#findAllByIDNum(java.lang.String, java.lang.String, int[])
	 */
	public Integer findAllByIDNum(String computerID,String type,int[] states)throws Exception{
		System.out.println("SensorClientsPatchServiceImpl:findAllByIDNum():computerID:"+computerID+",type:"+type+",states:"+states);
		return scpd.getPatchUpdateInfoByStateCount(computerID, type, states);
	}

}
