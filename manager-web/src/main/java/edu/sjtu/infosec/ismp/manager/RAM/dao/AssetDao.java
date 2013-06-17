package edu.sjtu.infosec.ismp.manager.RAM.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 数据层 资产录入Dao访问接口.
 * 
 */
public interface AssetDao  {

    /**
     * 保存/更新资产信息
     * 
     * @param asseInfoAsse
     *            资产信息
     */
    void saveOrUpdate(AsseInfoAsse asseInfoAsse);

    Integer getMaxId();
    
    /**
     * 删除资产信息
     * 
     * @param asseInfoAsse
     *            资产信息
     */
    void remove(AsseInfoAsse asseInfoAsse);

    /**
     * 批量删除资产信息
     * 
     * @param asseInfoAsseList
     *            资产信息对象列表
     */
    void remove(List<AsseInfoAsse> asseInfoAsseList);

    /**
     * 查询资产信息
     * 
     * @param assetCode
     *            资产编号
     * @return 资产信息对象
     */
    AsseInfoAsse find(String assetCode);
    Object[] findByDWR(String assetCode);

    /**
     * 查询资产信息
     * @param ip
     * ip地址
     * @return 资产信息对象
     */
    List<AsseInfoAsse>  findByIP(String ip);
    
    /**
     * 查询资产信息
     * 
     * @param id
     *            资产id
     * @return 资产信息对象
     */
    AsseInfoAsse find(Integer id);
    
    AsseKnowDicAsseKind findAsseKind(String assetKindIdSelect);
    
    /**
     * 查询该委办局资产信息
     * 
     * @param inst
     *            被测机构
     * @param asseKind
     *            资产类别
     * @return 资产信息对象列表
     */
    List<AsseInfoAsse> find(Domain domain, AsseKnowDicAsseKind asseKind);
    List<AsseInfoAsse> find1(Domain domain, AsseKnowDicAsseKind asseKind);

    /**
     * 查询该委办局资产信息
     * @return asset_device对象列表
     **/
    List<AssetDeviceBO> findFromAssetModule();
    
    /**
     * 查询该委办局资产信息记录数
     * 
     * @param inst
     *            被测机构
     * @param asseKind
     *            资产类别
     * @return 业务信息记录数
     */
    Long getCount(Domain domain, AsseKnowDicAsseKind asseKind);

    /**
     * 查询该委办局资产信息记录
     * 
     * @param inst
     *            被测机构
     * @return 资产信息列表
     */
    List<AsseInfoAsse> listAsse(Domain domain);
    
    /**
     * 查询该委办局资产重要性为高的资产数目
     * @param inst
     * 被测机构
     * @return 重要性为高的资产数目
     */
	Long statHighImpoAsse(Domain domain);
	
	/**
     * 查询该委办局资产重要性为中的资产数目
     * @param inst
     * 被测机构
     * @return 重要性为高的资产数目
     */
	Long statMiddImpoAsse(Domain domain);
	
	/**
     * 查询该委办局资产重要性为低的资产数目
     * @param inst
     * 被测机构
     * @return 重要性为高的资产数目
     */
	Long statLowImpoAsse(Domain domain);
	
	Object[] listDistinctAssetName(Domain domain);
	
    /**
     * 查询该委办局资产信息分页记录
     */
	List<AsseInfoAsse> findAll(int startResult, int maxResult,
			Domain domain, AsseKnowDicAsseKind asseKind);

	List<AsseInfoAsse> findByAsseKindId(String domain, String asseKindId);
	
	
}
