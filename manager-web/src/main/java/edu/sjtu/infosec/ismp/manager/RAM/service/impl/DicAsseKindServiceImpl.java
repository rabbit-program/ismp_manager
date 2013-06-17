package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicAsseKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicAsseKindService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * 应用层 资产类型数据字典Manager实现类.
 * 


 */
public class DicAsseKindServiceImpl  implements DicAsseKindService{

    /**
     * 资产类型数据访问对象接口
     */
    private DicAsseKindDao dicAsseKindDao;
    
    /**
     * @param dicasseKindDao
     *            资产类型数据访问对象接口(Spring Ioc容器依赖注入)
     */
    public void setDicAsseKindDao(DicAsseKindDao dicasseKindDao) {
        this.dicAsseKindDao = dicasseKindDao;
    }

    /**
     * 查询资产类型
     * 
     * @param assetKindId
     *            资产类型编号
     * @return 资产类型对象
     */
    public AsseKnowDicAsseKind find(String assetKindId) {
        
        return dicAsseKindDao.find(assetKindId);
    }
    
    /**
     * 查询资产类型
     * 
     * @param id
     *            资产类型id
     * @return 资产类型对象
     */
    public AsseKnowDicAsseKind findById(String id) {
        
        return dicAsseKindDao.find(new Integer(id));
    }

    /**
     * 查询资产类型记录数
     * 
     * @param paramMap
     *            查询条件
     * @return 资产类型记录数
     */
    public int getCount(Map paramMap) {
        
        return dicAsseKindDao.getCount(paramMap);
    }

    /**
     * 查询资产类型
     * @param paramMap
     *            查询条件
     * @return 资产类型列表
     */
    public List listDicAsseKind(Map paramMap) {
        
        return dicAsseKindDao.listDicAsseKind(paramMap);
    }
    public List listDicAsseKindByid(){
    	return dicAsseKindDao.listDicAsseKindByid();
    }

    /**
     * 查询资产类型分页记录
     * .
     * @param page
     *            分页对象
     * @param paramMap
     *            查询条件
     * @return 分页记录列表
     */
    public List listDicAsseKindPage(Page page, Map paramMap) {
        
        return dicAsseKindDao.listDicAsseKindPage(page, paramMap);
    }

    /** 
     * 删除资产类型
     * 
     * @param dicAsseKind
     *            资产类型
     */
    public void remove(AsseKnowDicAsseKind dicAsseKind) {
        
        dicAsseKindDao.remove(dicAsseKind);
    }

    /**
     * 保存/更新资产类型
     * 
     * @param dicAsseKind
     *            资产类型
     */
    public void saveOrUpdate(AsseKnowDicAsseKind dicAsseKind) {
        
        dicAsseKindDao.saveOrUpdate(dicAsseKind);
    }

    /**
     * 查询资产类型树父节点
     * @return 资产类型树父节点列表
     */
    public List listRootNode() {
       
        return dicAsseKindDao.listRootNode();
    }

    /**
     * 查询选择的资产类型
     * @return 选择的资产类型列表
     */
    public List listChildNode(){
        
        //AsseKnowDicAsseKind asseKind = new AsseKnowDicAsseKind();
        List asseKindList = new ArrayList();
        List childNodeList = dicAsseKindDao.listChildNode1();
        List parentNodeList = dicAsseKindDao.listRootNode1();
        if(childNodeList!=null && childNodeList.size()>0) {
            asseKindList.addAll(childNodeList);
        }
        if(parentNodeList!=null && parentNodeList.size()>0) {
            for(int i=0;i<parentNodeList.size();i++) {
//                asseKind = (AsseKnowDicAsseKind) parentNodeList.get(i);
//                if(asseKind.getChildAsseKinds().size()==0){
//                    asseKindList.add(asseKind);
//                }
            	Object[] parentNode = (Object[]) parentNodeList.get(i);
            	String assetKindId = (String) parentNode[1];
            	List list = dicAsseKindDao.listChildNode(assetKindId);
            	if(list.isEmpty()) {
            	 asseKindList.add(parentNode);
            	}
            }
        }
        return asseKindList;
    }
}
