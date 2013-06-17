package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.AM.model.AssetDeviceBO;
import edu.sjtu.infosec.ismp.manager.RAM.dao.AssetDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DicAsseKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.AssetService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;
import edu.sjtu.infosec.ismp.security.Domain;


/**
 * 应用层 资产录入Manager实现类.
 * 


 */
public class AssetServiceImpl  implements AssetService {

    
    /**
     * 资产类型数据访问对象接口
     */
    private DicAsseKindDao dicAsseKindDao;
    
    /**
     * 资产录入数据访问对象接口
     */
    private AssetDao assetDao;

  
    
    public void setDicAsseKindDao(DicAsseKindDao dicasseKindDao) {
        this.dicAsseKindDao = dicasseKindDao;
    }
    
    
    
    public void setAssetDao(AssetDao assetDao) {
		this.assetDao = assetDao;
	}



	/**
     * 查询资产信息
     * 
     * @param assetCode
     *            资产编号
     * @return 资产信息对象
     */
    public AsseInfoAsse findByAssetCode(String assetCode) {
        
        return assetDao.find(assetCode);
    }

    /**
     * 查询资产信息
     * 
     * @param id
     *            资产id
     * @return 资产信息对象
     */
    public AsseInfoAsse findById(String id) {
        
        return assetDao.find(new Integer(id));
    }
    
    /**
     * 查询该委办局资产信息
     * 
     * @param inst
     *            被测机构
     * @param asseKind
     *            资产类别
     * @return 资产信息对象列表
     */
    public List<AsseInfoAsse> find(Domain domain ,AsseKnowDicAsseKind asseKind) {
        
        return assetDao.find1(domain, asseKind);
    }
    
    /**
     * 查询该委办局资产信息
     * @return asset_device对象列表
     **/
    public List<AssetDeviceBO> findFromAssetModule(Domain domain){
        
List<AssetDeviceBO> assetList = assetDao.findFromAssetModule();
        
        if(assetList!=null && assetList.size()>0) {
            System.out.println("开始从资产管理模块设备基本信息表读取保存数据");
            System.out.println("new sn num:"+assetList.size());
         for(int i=0;i<assetList.size();i++) {
             AsseKnowDicAsseKind asseKind = null;
             AssetDeviceBO assetDeviceBO = assetList.get(i);
             Integer nextId = assetDao.getMaxId();
             if(assetDeviceBO.getAssetType()!=null) {
             	int assetType = assetDeviceBO.getAssetType().intValue();
              if(assetType==1 ||assetType==6 ||assetType==15) {
                  asseKind = dicAsseKindDao.find(new Integer(21));
               }else{
             	 asseKind = dicAsseKindDao.find(new Integer(assetType));
               }
             }
             String sn = "";
             if(assetDeviceBO.getSn() != null) {
            	 sn = assetDeviceBO.getSn();
             }else{
            	 sn = asseKind.getAssetKindId()+nextId.toString();
             }
             AsseInfoAsse asseInfoAsse = findByAssetCode(sn);
             if(asseInfoAsse == null) {
            	 asseInfoAsse = new AsseInfoAsse();
            	 asseInfoAsse.setAssetCode(assetDeviceBO.getSn());
            	 asseInfoAsse.setImportance("H");
            	 asseInfoAsse.setMemo("none");
            	 if(asseKind!=null) {
            		 asseInfoAsse.setAsseKind(asseKind);
            	 }
             }
             
             if(assetDeviceBO.getName()!=null) {
                 asseInfoAsse.setAssetName(assetDeviceBO.getName());
             }else{
            	 asseInfoAsse.setAssetName("Unknown"+nextId);	 
             }
             if(assetDeviceBO.getUser()!=null) {
              asseInfoAsse.setRespMan(assetDeviceBO.getUser());
             }else{
              asseInfoAsse.setRespMan("none"); 
             }
             if(assetDeviceBO.getIp()!=null) {
              asseInfoAsse.setIp(assetDeviceBO.getIp());
             }else{
                 asseInfoAsse.setIp("");    
             }
            
             asseInfoAsse.setDomain(domain);
             assetDao.saveOrUpdate(asseInfoAsse);
         }
             System.out.println("从资产管理模块设备基本信息表读取保存数据结束");
        }
        return assetList;
    }

    /**
     * 查询该委办局资产信息记录数
     * 
     * @param inst
     *            被测机构
     * @param asseKind
     *            资产类别
     * @return 业务信息记录数
     */
  /*  public int getCount(AsseInfoInst inst, AsseKnowDicAsseKind asseKind) {
        
        return assetDao.getCount(inst, asseKind);
    }*/

    /**
     * 删除资产信息
     * 
     * @param assetCode
     *            资产编号
     */
    public void remove(String assetCode) {
        if(assetCode != null) {
            AsseInfoAsse asseInfoAsse = assetDao.find(assetCode);
            assetDao.remove(asseInfoAsse);
        }
    }

    /**
     * 批量删除资产信息
     * 
     * @param assetCodes
     *            资产编号数组
     */
    public void remove(String[] assetCodes) {
        List<AsseInfoAsse> asseInfoAsseList = new ArrayList<AsseInfoAsse>();
        for(int i=0;i<assetCodes.length;i++) {
            AsseInfoAsse asseInfoAsse = assetDao.find(assetCodes[i]);
            asseInfoAsseList.add(asseInfoAsse);
        }
        if(asseInfoAsseList.size()>0) {
            assetDao.remove(asseInfoAsseList);
        }
    }

    /**
     * 保存/更新资产信息
     * 
     * @param asseInfoAsse
     *            资产信息
     */
    public void saveOrUpdate(AsseInfoAsse asseInfoAsse) {
        assetDao.saveOrUpdate(asseInfoAsse);
    }

	/**
     * 查询资产信息
     * @param ip
     * ip地址
     * @return 资产信息对象
     */
	public  List<AsseInfoAsse>  findByIP(String ip) {
		return assetDao.findByIP(ip);
	}

	/**
     * 查询该委办局资产信息记录
     * 
     * @param inst
     *            被测机构
     * @return 资产信息列表
     */
	public List<AsseInfoAsse> listAsse(Domain domain) {
		return assetDao.listAsse(domain);
	}
	
	/**
     * 统计该委办局重要性资产数目
     * 
     * @param inst
     *            被测机构
     * @return 重要性资产数目Map
     */
	@SuppressWarnings("unchecked")
	public Map statAsseImpoNum(Domain domain) {
		Map asseImpoNumMap = new HashMap();
		/*Long HighAsseImpoNum = assetDao.statHighImpoAsse(domain);
		Long MiddAsseImpoNum = assetDao.statMiddImpoAsse(domain);
		Long LowAsseImpoNum = assetDao.statLowImpoAsse(domain);
		asseImpoNumMap.put("HighAsseImpoNum", HighAsseImpoNum);
		asseImpoNumMap.put("MiddAsseImpoNum", MiddAsseImpoNum);
		asseImpoNumMap.put("LowAsseImpoNum", LowAsseImpoNum);*/
		return asseImpoNumMap;
	}

	
	public Object[] listDistinctAssetName(Domain domain) {
		return assetDao.listDistinctAssetName(domain);
	}

	public Object[] findByAssetCodeDWR(String assetCode) {
		return assetDao.findByDWR(assetCode);
	}

	public AsseKnowDicAsseKind findAsseKind(String assetKindIdSelect) {
		return assetDao.findAsseKind(assetKindIdSelect);
	}

	public List<AsseInfoAsse> findByAsseKindId(String domain, String asseKindId) {
		return assetDao.findByAsseKindId(domain, asseKindId);
	}
	
    /**
     * 查询该委办局资产信息分页记录
     */
	public List<AsseInfoAsse> findAll(int startResult, int maxResult,
			Domain domain, AsseKnowDicAsseKind asseKind) {
		return assetDao.findAll(startResult,maxResult,domain,asseKind);
	}

	public Long getCount(Domain domain, AsseKnowDicAsseKind asseKind) {
		return assetDao.getCount(domain,asseKind);
	}
	
	

}
