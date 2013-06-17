package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatThreKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatThreKindService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 静态威胁类别Manager接口实现类.
 */
public class StatThreKindServiceImpl  implements StatThreKindService {

	/**
     * 静态威胁类别数据访问对象接口
     */
	private StatThreKindDao statThreKindDao;
	
	/**
     * setStatThreKindDao
     * @param statthreKindDao 
     * 静态威胁类别数据访问对象接口
     **/
	public void setStatThreKindDao(StatThreKindDao statthreKindDao) {
		this.statThreKindDao = statthreKindDao;
	}

	/**
     * 查询静态威胁类别
     * 
     * @param id
     *    静态威胁类别id
     * @return 静态威胁类别对象
     **/
	public AsseKnowStatThreKind find(String id) {
		
		return statThreKindDao.find(new Integer(id));
	}

	/**
     * 查询静态威胁类别数量
     * @return 静态威胁类别数量
     **/
	public int getCount() {
		
		return statThreKindDao.getCount();
	}

	 /**
     * 返回所有静态威胁类别
     * @return 所有静态威胁类别列表
     **/
	public List<AsseKnowStatThreKind> listAllStatThreKind() {
		
		return statThreKindDao.listAllStatThreKind();
	}

	/**
     * 查询静态威胁类别分页记录
     * @param page
     * 分页对象
     * @return 分页记录列表
     **/
	public PageResult listStatThreKindPage(Page page) {
		int totalCount = getCount();
		page = PageUtil.createPage(page, totalCount);
		List<AsseKnowStatThreKind> list = statThreKindDao.listStatThreKindPage(page);
		return new PageResult(page, list);
	}

	/**
     * 删除静态威胁类别对象
     * 
     * @param statThreKind
     *   静态威胁类别对象
     **/
	public void remove(AsseKnowStatThreKind statThreKind) {
		
		statThreKindDao.remove(statThreKind);
	}

	/**
     * 保存/更新静态威胁类别对象
     * 
     * @param statThreKind
     *    静态脆弱点类别对象
     **/
	public void saveOrUpdate(AsseKnowStatThreKind statThreKind) {
		
		statThreKindDao.saveOrUpdate(statThreKind);
	}

	
	public AsseKnowStatThreKind findByKind(String kind) {
		
		return statThreKindDao.find(kind);
	}

}
