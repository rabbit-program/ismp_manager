package edu.sjtu.infosec.ismp.manager.RAM.service;

import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 应用层 资产录入Manager接口.
 */
public interface AssetService {

    /**
     * 保存/更新资产信息
     */
    void saveOrUpdate(AsseInfoAsse asseInfoAsse);

    /**
     * 删除资产信息
     */
    void remove(String assetCode);

    /**
     * 批量删除资产信息
     */
    void remove(String[] assetCodes);

    /**
     * 查询资产信息
     * @param assetCode
     *            资产编号
     * @return 资产信息对象
     */
    AsseInfoAsse findByAssetCode(String assetCode);
    
    AsseKnowDicAsseKind findAsseKind(String assetKindIdSelect);
    
    Object[] findByAssetCodeDWR(String assetCode);

    /**
     * 查询资产信息
     * @param ip
     * ip地址
     * @return 资产信息对象
     */
    List<AsseInfoAsse> findByIP(String ip);
    
    /**
     * 查询资产信息
     * 
     * @param id
     *            资产id
     * @return 资产信息对象
     */
    AsseInfoAsse findById(String id);
    
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

    /**
     * 查询该委办局资产信息
     * 
     * @param orgCode
     * 被测机构组织机构代码
     * @param asseKindId
     *        资产类别Id
     * @return 资产信息对象列表
     */
    List<AsseInfoAsse> findByAsseKindId(String domainId, String asseKindId);
    
    /**
     * 查询该委办局资产信息
     * @return asset_device对象列表
     **/
    List<AssetDeviceBO> findFromAssetModule(Domain domain);
    
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
     * 查询该委办局资产信息分页记录
     * 
     * @param inst
     *            被测机构
     * @param page
     *            分页对象
     * @param asseKind
     *            资产类别
     * @return 分页信息
     */
     List<AsseInfoAsse>  findAll(int startResult, int maxResult, Domain domain, AsseKnowDicAsseKind asseKind);
    
    /**
     * 查询该委办局资产信息记录
     * 
     * @param inst
     *            被测机构
     * @return 资产信息列表
     */
     List<AsseInfoAsse> listAsse(Domain domain);
    
    /**
     * 统计该委办局重要性资产数目
     * 
     * @param inst
     *            被测机构
     * @return 重要性资产数目Map
     */
	 Map statAsseImpoNum(Domain domain);
	
	 Object[] listDistinctAssetName(Domain domain );
}
