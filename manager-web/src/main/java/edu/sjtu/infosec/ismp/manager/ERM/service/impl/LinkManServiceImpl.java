package edu.sjtu.infosec.ismp.manager.ERM.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import edu.sjtu.infosec.ismp.manager.ERM.dao.LinkManDao;
import edu.sjtu.infosec.ismp.manager.ERM.model.LinkMan;
import edu.sjtu.infosec.ismp.manager.ERM.model.RespInfoBO;
import edu.sjtu.infosec.ismp.manager.ERM.service.LinkManService;
import edu.sjtu.infosec.ismp.security.Domain;

public class LinkManServiceImpl implements LinkManService {
	
	private LinkManDao linkManDao;
	
//	private SystemLogService systemlogservice;
	
	   
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}

	public void add(LinkMan linkMan) throws Exception {
		linkManDao.add(linkMan);
	}

	public void delete(LinkMan linkMan) throws Exception {
		linkManDao.delete(linkMan);
	}

	public void update(LinkMan linkMan) throws Exception {
		linkManDao.update(linkMan);
	}

	public List<LinkMan> findAll() throws Exception {
		List<LinkMan> list = linkManDao.findAll();
		return list;
	}

	public List<LinkMan> findAllByDomain(List<Domain> domainList)
			throws Exception {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<LinkMan> list = linkManDao.findAllByDomain(domainList);
			return list;
		}
	}

	public LinkMan findById(Integer id) {
		if(id == null){
			return null;
		}else{
			LinkMan linkMan = linkManDao.findById(id);
			return linkMan;
		}
	}

	public List<LinkMan> findByRespInfo(RespInfoBO respInfo) {
		if(respInfo == null){
			return null;
		}else{
			List<LinkMan> list = linkManDao.findByRespInfo(respInfo);
			return list;
		}
	}

	public List<LinkMan> findByRespInfoId(Integer id) {
		if(id == null){
			return null;
		}else{
			List<LinkMan> list = linkManDao.findByRespInfoId(id);
			return list;
		}
	}

	public void deleteLinkManByRespInfo(RespInfoBO resp) {
		linkManDao.deleteLinkManByRespInfo(resp);
	}

	public String getTree(List<LinkMan> linkManList, String basePath,String respname) {
		String treeList = "";
		for (LinkMan linkman : linkManList) {
			String title = linkman.getName();
			if(!"".equals(StringUtils.trimToEmpty(linkman.getTeamCode()))) {
			 title += "(小组编号:"+StringUtils.trimToEmpty(linkman.getTeamCode())+")";
			}
			treeList = treeList + "d.add(" 
										+ linkman.getPid() + ","
										+ linkman.getFid() + ","
										+ "'" + title + "',"
										+ "'" + basePath + "/ismp/domain/local/erm/phoneTree.do?method=showedit&treeid=" + linkman.getId() + "&respname="+respname+"',"
										+ "'" + linkman.getName() + "'"
						 			+ ");";
		}
		
		/*treeList += "document.write(d);";*/
		return treeList;
	}
	public void saveorupdate(LinkMan linkman) {
		linkManDao.saveorupdate(linkman);
	}

	public boolean checkTeamId(Integer repid, String teamCode) {
		return linkManDao.checkTeamId(repid, teamCode);
	}

	public Integer getMaxPid(Integer respid) {
		return linkManDao.getMaxPid(respid);
	}

	public void deleteByPid(String s,String respid) {
		linkManDao.deleteByPid(s,respid);
	}

	public List<LinkMan> queryByPid(Integer pid,String respid) {
		
		return linkManDao.queryByPid(pid,respid);
	}

	public LinkMan findByTeamId(String teamCode,String respid) {
		// TODO Auto-generated method stub
		return linkManDao.findByTeamId(teamCode,respid);
	}
	
}
