package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatCVEThreDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatCVEThre;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatThreKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatCVEThreService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 知识库静态漏洞威胁Manager接口实现类.
 */
public class StatCVEThreServiceImpl  implements StatCVEThreService {

	/**
     * 知识库静态漏洞威胁数据访问对象接口
     */
    private StatCVEThreDao statCVEThreDao;

    public void setStatCVEThreDao(StatCVEThreDao statcVEThreDao) {
		this.statCVEThreDao = statcVEThreDao;
	}
    
	/**
     * 查询静态漏洞威胁
     * @param id
     *    静态漏洞威胁id
     * @return 静态漏洞威胁对象
     **/
	public AsseKnowStatCVEThre findById(String id) {
		
		return statCVEThreDao.find(new Integer(id));
	}

	

	/**
     * 查询静态漏洞威胁
     * @param cveId
     * CVE_ID
     * @return 静态漏洞威胁对象
     **/
	public List find(String cveId) {
		
		return statCVEThreDao.find(cveId);
	}

	/**
     * 查询静态漏洞威胁数量
     * @return 静态漏洞威胁数量
     **/
	public int getCount() {
		
		return statCVEThreDao.getCount();
	}

	/**
     * 返回所有静态漏洞威胁
     * @return 静态漏洞威胁列表
     **/
	public List<AsseKnowStatCVEThre> listAllStatCVEThre() {
		
		return statCVEThreDao.listAllStatCVEThre();
	}

	/**
     * 根据静态威胁类别返回静态漏洞威胁列表
     * @param statThreKind
     *     静态威胁类别
     * @return 静态威胁列表
     **/
	public List<AsseKnowStatCVEThre> listStatCVEThre(
			AsseKnowStatThreKind statThreKind) {
		
		return statCVEThreDao.listStatCVEThre(statThreKind);
	}

	/**
     * 根据静态威胁编号返回静态漏洞威胁列表
     * @param threCode
     *    静态威胁编号
     * @return 静态漏洞威胁列表
     **/
	public List<AsseKnowStatCVEThre> listStatCVEThre(String threCode) {
		
		return statCVEThreDao.listStatCVEThre(threCode);
	}

	/**
     * 查询静态漏洞威胁分页记录
     * @param page
     *     分页对象
     * @return 分页记录列表
     **/
	public PageResult listStatCVEThrePage(Page page) {
		
		int totalCount = getCount();
        page = PageUtil.createPage(page, totalCount);
        List<AsseKnowStatCVEThre> list = statCVEThreDao.listStatCVEThrePage(page);
        return new PageResult(page, list);
	}

	/**
     * 删除静态漏洞威胁对象
     * @param statCVEThre
     *   静态漏洞威胁对象
     **/
	public void remove(AsseKnowStatCVEThre statCVEThre) {
		
		statCVEThreDao.remove(statCVEThre);
	}

	/**
     * 保存/更新静态漏洞威胁对象
     * @param statCVEThre
     *    静态漏洞威胁对象
     **/
	public void saveOrUpdate(AsseKnowStatCVEThre statCVEThre) {
		
		statCVEThreDao.saveOrUpdate(statCVEThre);
	}

	
	public List<AsseKnowStatCVEThre> listStatCVEThreByCVEIdScale(List CVEIdList) {
		
		return statCVEThreDao.listStatCVEThreByCVEIdScale(CVEIdList);
	}

	
}
