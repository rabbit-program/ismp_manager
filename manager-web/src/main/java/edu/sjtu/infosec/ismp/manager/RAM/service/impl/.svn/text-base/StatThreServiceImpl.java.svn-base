package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatThreService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 静态威胁Manager接口实现类.
 * 


 */
public class StatThreServiceImpl  implements StatThreService {

	/**
     * 静态威胁数据访问对象接口
     */
	private StatThreDao statThreDao;
	
	/**
     * setStatThreDao
     * @param statThreDao 
     * 静态威胁数据访问对象接口
     **/
	public void setStatThreDao(StatThreDao statThreDao) {
		this.statThreDao = statThreDao;
	}

	/**
     * 查询静态威胁
     * @param id
     *    静态威胁id
     * @return 静态威胁对象
     **/
	public AsseKnowStatThre find(String id) {
		
		return statThreDao.find(new Integer(id));
	}

	/**
     * 查询静态威胁数量
     * @return 静态威胁数量
     **/
	public int getCount() {
		
		return statThreDao.getCount();
	}

	/**
     * 返回所有静态威胁
     * @return 静态威胁列表
     **/
	public List<AsseKnowStatThre> listAllStatThre() {
		
		return statThreDao.listAllStatThre();
	}

	/**
     * 根据静态威胁类别返回测评项目未选的静态威胁点
     * @param asseInfoProjId
     *     测评项目编号
     * @param statThreKind
     *     静态威胁类别
     * @return 静态威胁列表
     **/
	public List<AsseKnowStatThre> listStatThre(String asseInfoProjId,
			AsseKnowStatThreKind statThreKind) {
		
		return statThreDao.listStatThre(new Integer(asseInfoProjId), statThreKind);
	}

	/**
     * 查询静态威胁分页记录
     * @param page
     *     分页对象
     * @return 分页记录列表
     **/
	public PageResult listStatThrePage(Page page) {
		
		int totalCount = getCount();
		page = PageUtil.createPage(page, totalCount);
		List<AsseKnowStatThre> list = statThreDao.listStatThrePage(page);
		return new PageResult(page, list);
	}

	/**
     * 删除静态威胁对象
     * @param statThre
     *   静态威胁对象
     **/
	public void remove(AsseKnowStatThre statThre) {
		
		statThreDao.remove(statThre);
	}

	/**
     * 保存/更新静态威胁对象
     * @param statThre
     *    静态威胁对象
     **/
	public void saveOrUpdate(AsseKnowStatThre statThre) {
		
		statThreDao.saveOrUpdate(statThre);
	}

}
