package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatSecuElemDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatSecuElem;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatSecuElemService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 静态安全要素Manager接口实现类.
 * 


 */
public class StatSecuElemServiceImpl  implements StatSecuElemService {

    /**
     * secuElemDao
     * 
     */
    private StatSecuElemDao secuElemDao;

    /**
     * setSecuElemDao
     * @param secuelemDao
     * 静态安全要素Dao
     **/
    public void setSecuElemDao(StatSecuElemDao secuelemDao) {
        this.secuElemDao = secuelemDao;
    }
    
    /**
     * 查询静态安全要素
     * 
     * @param elemCode
     *        要素编码
     * @return 静态安全要素对象
     **/
    public AsseKnowStatSecuElem find(String elemCode) {
        
        AsseKnowStatSecuElem statSecuElem = new AsseKnowStatSecuElem();
        if(elemCode!=null && !"".equals(elemCode)) {
         statSecuElem = secuElemDao.find(elemCode);
        }
        return statSecuElem;
    }

    /**
     * 查询静态安全要素
     * 
     * @param id
     *    要素id
     * @return 静态安全要素对象
     **/
    public AsseKnowStatSecuElem findById(String id) {
        
        return secuElemDao.find(new Integer(id));
    }

    /**
     * 返回静态安全要素树各个根节点列表
     * @return 静态安全要素根节点列表
     **/
    public List<AsseKnowStatSecuElem> findTree() {
        
        return secuElemDao.findTree();
    }

    /**
     * 查询静态安全要素数量
     * @return 静态安全要素数量
     **/
    public int getCount() {
       
        return secuElemDao.getCount();
    }

    /**
     * 查询静态安全要素分页记录
     * @param page
     *            分页对象
     * @return 分页记录列表
     **/
    public PageResult listStatSecuElemPage(Page page) {
        int totalCount = secuElemDao.getCount();
        page = PageUtil.createPage(page, totalCount);
        List<AsseKnowStatSecuElem> list = secuElemDao.listStatSecuElemPage(page);
        return new PageResult(page, list);
    }

    /**
     * 删除静态安全要素
     * 
     * @param statSecuElem
     *         静态安全要素
     **/
    public void remove(AsseKnowStatSecuElem statSecuElem) {
        
        secuElemDao.remove(statSecuElem);
    }

    /**
     * 批量删除静态安全要素
     * 
     * @param statSecuElemList
     *     静态安全要素对象列表
     **/
    public void remove(List<AsseKnowStatSecuElem> statSecuElemList) {
        
        secuElemDao.remove(statSecuElemList);
    }

    /**
     * 保存/更新静态安全要素
     * 
     * @param statSecuElem
     *         静态安全要素
     **/
    public void saveOrUpdate(AsseKnowStatSecuElem statSecuElem) {
        
        secuElemDao.saveOrUpdate(statSecuElem);
    }

	public List<AsseKnowStatSecuElem> listStatSecuElem() {
		List<AsseKnowStatSecuElem> list = secuElemDao.listStatSecuElem();
		return list;
	}

}
