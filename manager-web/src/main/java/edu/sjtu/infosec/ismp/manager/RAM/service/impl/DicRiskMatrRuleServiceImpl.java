package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.RAM.dao.DicRiskMatrRuleDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicRiskMatrRule;
import edu.sjtu.infosec.ismp.manager.RAM.service.DicRiskMatrRuleService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 风险矩阵字典表Manager实现类.
 */
public class DicRiskMatrRuleServiceImpl  implements DicRiskMatrRuleService {

	/** 
     * 风险矩阵字典表数据访问对象接口
     */
	private DicRiskMatrRuleDao dicRiskMatrRuleDao;
	
	/**
     * @param vdicRiskMatrRuleDao
     * 风险矩阵字典表数据访问对象接口(Spring Ioc容器依赖注入)
     */
	public void setDicRiskMatrRuleDao(DicRiskMatrRuleDao dicRiskMatrRuleDao) {
		this.dicRiskMatrRuleDao = dicRiskMatrRuleDao;
	}

	/**
     * 查询矩阵规则
     * 
     * @param id
     *            矩阵规则id
     * @return 矩阵规则对象
     */
	public AsseKnowDicRiskMatrRule find(String id) {
		
		return dicRiskMatrRuleDao.find(new Integer(id));
	}

	

	/**
     * 查询矩阵规则
     * @param asseImpo
     * 资产重要性
     * @param vulnSeri
     * 脆弱点严重性
     * @param threPoss
     * 威胁发生可能性
     * @return 矩阵规则对象
     */
	public AsseKnowDicRiskMatrRule find(String asseImpo, String vulnSeri,
			String threPoss) {
		
		return dicRiskMatrRuleDao.find(asseImpo, vulnSeri, threPoss);
	}

	/**
     * 查询矩阵规则记录数
     * @return 矩阵规则记录数
     */
	public int getCount() {
		
		return dicRiskMatrRuleDao.getCount();
	}

	/**
     * 返回所有矩阵规则
     * @return 矩阵规则列表
     */
	public List<AsseKnowDicRiskMatrRule> listAllDicRiskMatrRule() {
		
		return dicRiskMatrRuleDao.listAllDicRiskMatrRule();
	}

	/**
     * 查询矩阵规则分页记录
     * 
     * @param page
     *            分页对象
     * @return 分页记录列表
     */
	public PageResult listDicRiskMatrRulePage(Page page) {
		
		int totalCount = getCount();
        page = PageUtil.createPage(page, totalCount);
        List list = dicRiskMatrRuleDao.listDicRiskMatrRulePage(page);
        return new PageResult(page, list);
	}

	/**
     * 删除矩阵规则
     * 
     * @param dicRiskMatrRule
     *            矩阵规则
     */
	public void remove(AsseKnowDicRiskMatrRule dicRiskMatrRule) {
		
		dicRiskMatrRuleDao.remove(dicRiskMatrRule);
	}

	/**
     * 保存/更新矩阵规则
     * 
     * @param dicRiskMatrRule
     *            矩阵规则
     */
	public void saveOrUpdate(AsseKnowDicRiskMatrRule dicRiskMatrRule) {
		
		dicRiskMatrRuleDao.saveOrUpdate(dicRiskMatrRule);
	}

}
