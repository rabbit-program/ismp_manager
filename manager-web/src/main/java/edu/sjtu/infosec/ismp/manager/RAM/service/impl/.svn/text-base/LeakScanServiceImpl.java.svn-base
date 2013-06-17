package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import edu.sjtu.infosec.ismp.manager.RAM.dao.AssetDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.DicAsseKindDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.LeakScanDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoAsse;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoLeak;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDicAsseKind;
import edu.sjtu.infosec.ismp.manager.RAM.service.LeakScanService;

/**
 * 应用层 漏洞扫描Manager实现类.
 */
public class LeakScanServiceImpl  implements LeakScanService {

	private LeakScanDao leakScanDao;
	/**
     * 资产录入数据访问对象接口
     */
    private AssetDao assetDao;
    /**
     * 资产类型数据访问对象接口
     */
    private DicAsseKindDao dicAsseKindDao;
    
	public void setLeakScanDao(LeakScanDao leakScanDao) {
		this.leakScanDao = leakScanDao;
	}

	public void setAssetDao(AssetDao assetDao) {
		this.assetDao = assetDao;
	}

	public void setDicAsseKindDao(DicAsseKindDao dicAsseKindDao) {
		this.dicAsseKindDao = dicAsseKindDao;
	}

	/**
     * 批量保存/更新扫描漏洞
     * 
     * @param leaks
     * 漏洞列表
     **/
	public void batchSaveOrUpdate(List<AsseInfoLeak> leaks) {
		
		leakScanDao.batchSaveOrUpdate(leaks);
	}

	/**
     * 查询漏洞
     * 
     * @param id
     *    漏洞id
     * @return 漏洞对象
     **/
	public AsseInfoLeak find(String id) {
		
		return leakScanDao.find(new Integer(id));
	}

	 /**
     * 查询漏洞
     * 
     * @param cveId
     *    cveId
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞对象
     **/
	public AsseInfoLeak findByCveId(String cveId,AsseInfoProj asseInfoProj) {
		
		return leakScanDao.findByCveId(cveId,asseInfoProj);
	}

	/**
     * 查询漏洞数量
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞数量
     **/
	public int getCount(AsseInfoProj asseInfoProj, String ip) {
		
		return leakScanDao.getCount(asseInfoProj, ip);
	}

	/**
     * 查询漏洞记录
     * @param asseInfoProj
     *            测评项目
     * @return 分页记录列表
     **/
	public List<AsseInfoLeak> listAsseInfoLeak(AsseInfoProj asseInfoProj) {
		
		return leakScanDao.listAsseInfoLeak(asseInfoProj);
	}

	

	 /**
     * 删除漏洞
     * 
     * @param leak
     * 漏洞
     **/
	public void remove(AsseInfoLeak leak) {
		
		leakScanDao.remove(leak);
	}

	/**
     * 批量删除漏洞
     * 
     * @param leakList
     *     漏洞列表
     **/
	public void remove(List<AsseInfoLeak> leakList) {
		
		leakScanDao.remove(leakList);
	}

	/**
     * 保存/更新扫描漏洞
     * 
     * @param leak
     * 漏洞
     **/
	public void saveOrUpdate(AsseInfoLeak leak) {
		
		leakScanDao.saveOrUpdate(leak);
	}

	public void importDataByXlsFile(AsseInfoProj asseInfoProj, InputStream inputXls) throws IOException, BiffException {
		
		boolean exit = checkExit(asseInfoProj);
	    if(!exit) {
	    	List<AsseInfoLeak> newLeaks = new ArrayList<AsseInfoLeak>();
	    	Workbook wb = Workbook.getWorkbook(inputXls);
			Sheet sheet = wb.getSheet(2); 
			int rows = sheet.getRows();
			for (int i = 1; i < rows; i++) {
				String risk = sheet.getCell(0, i).getContents();
				String leakDescribe = sheet.getCell(1, i).getContents();
				String ip = sheet.getCell(2, i).getContents();
				if(!"".equals(StringUtils.trimToEmpty(ip))) {
				 String[] ips = StringUtils.split(ip, ",");
				 for(String leakIp : ips) {
					 List<AsseInfoAsse> asseInfoList = assetDao.findByIP(leakIp);
					 AsseInfoAsse asseInfo = asseInfoList.get(0);
		             if(asseInfo == null) {
		            		AsseInfoAsse newAsse = new AsseInfoAsse();
		            		newAsse.setDomain(asseInfoProj.getDomain());
		            		newAsse.setAsseInfoProjId(asseInfoProj.getId());
		            		newAsse.setIp(leakIp);
		            		newAsse.setImportance("H");
		            		AsseKnowDicAsseKind asseKind = dicAsseKindDao.find("other1");
		            		newAsse.setAsseKind(asseKind);
		            		Integer maxId = assetDao.getMaxId()+1;
		            		newAsse.setAssetName("Unknow"+maxId);
		            		newAsse.setAssetCode("other1"+maxId);
		            		assetDao.saveOrUpdate(newAsse);
		            		asseInfo = newAsse;
		            	}
				  AsseInfoLeak asseInfoLeak = new AsseInfoLeak();
				  asseInfoLeak.setAsse(asseInfo);
				  asseInfoLeak.setAsseInfoProj(asseInfoProj);
				  asseInfoLeak.setLocation(leakDescribe);
				  asseInfoLeak.setDescribe(leakDescribe);
				  asseInfoLeak.setIp(leakIp);
				  asseInfoLeak.setRisk(retRisk(risk));
				  newLeaks.add(asseInfoLeak);
				 }
			  }
			}
			leakScanDao.batchSaveOrUpdate(newLeaks);
	    }
	}
	
	private String retRisk(String riskName) {
		String risk = "L";
		if(!"".equals(StringUtils.trimToEmpty(riskName))) {
			if("[高]".equals(StringUtils.trim(riskName))) {
				risk = "H";
			}else if("[中]".equals(StringUtils.trim(riskName))) {
				risk = "M";
			}else if("[低]".equals(StringUtils.trim(riskName))) {
				risk = "L";
			}
		}
		return risk;
	}
	
	/**
     * 导入扫描报告
     * @param asseInfoProj
     *            测评项目
     * @param inputXml
     *     报告绝对路径
     **/
	public void importDataByXmlFile(AsseInfoProj asseInfoProj, InputStream inputXml) {
		
		    boolean exit = checkExit(asseInfoProj);
		    if(!exit) {
		     List<AsseInfoLeak> newLeaks = new ArrayList<AsseInfoLeak>();
			 SAXReader saxReader = new SAXReader();
			 try {
				Document document = saxReader.read(inputXml);
				Element  root = document.getRootElement();
				Element vulRoot = root.element("VULS");
	            List vulList = vulRoot.elements("VUL");
	            Iterator vulIterator = vulList.iterator();
	            while(vulIterator.hasNext()){
	            	Element vulElement = (Element) vulIterator.next();
	            	Element TARGETIP = vulElement.element("TARGET_IP");
	            	AsseInfoAsse asseInfo = null;
	            	if(TARGETIP.getText()!=null && !"".equals(TARGETIP.getText().trim())) {
	            	List asseInfoList = assetDao.findByIP(TARGETIP.getText().trim());
	            	asseInfo = (AsseInfoAsse) asseInfoList.get(0);
	            	}
	            	if(asseInfo == null) {
	            		AsseInfoAsse newAsse = new AsseInfoAsse();
	            		newAsse.setDomain(asseInfoProj.getDomain());
	            		newAsse.setAsseInfoProjId(asseInfoProj.getId());
	            		newAsse.setIp(TARGETIP.getText().trim());
	            		newAsse.setImportance("H");
	            		AsseKnowDicAsseKind asseKind = dicAsseKindDao.find("other1");
	            		newAsse.setAsseKind(asseKind);
	            		Integer maxId = assetDao.getMaxId()+1;
	            		newAsse.setAssetName("Unknow"+maxId);
	            		newAsse.setAssetCode("other1"+maxId);
	            		assetDao.saveOrUpdate(newAsse);
	            		asseInfo = newAsse;
	            	}
	            	Element securityRoot = vulElement.element("SEVERITYS");
	            	List securityElementList = securityRoot.elements("SEVERITY");
	            	Iterator securityIterator = securityElementList.iterator();
	            	while(securityIterator.hasNext()){
	            		Element securityElement = (Element) securityIterator.next();
	            		AsseInfoLeak asseInfoLeak = new AsseInfoLeak();
	            		asseInfoLeak.setIp(TARGETIP.getText());
	            		asseInfoLeak.setAsse(asseInfo);
	            		asseInfoLeak.setAsseInfoProj(asseInfoProj);
	            		Element VULID = securityElement.element("VUL_ID");
	            		asseInfoLeak.setKnowId(VULID.getText().trim());
	            		Element PROTO = securityElement.element("PROTO");
	            		asseInfoLeak.setProtocol(PROTO.getText());
	            		Element PORT = securityElement.element("PORT");
	            		asseInfoLeak.setPort(PORT.getText());
	            		Element messSTRING = securityElement.element("MESS_STRING");
	            		asseInfoLeak.setMessage(messSTRING.getText());
	            		newLeaks.add(asseInfoLeak);
	            	}
	            	
	            }
	            leakScanDao.batchSaveOrUpdate(newLeaks);
	            Element pluginRoot = root.element("PLUGINS");
				List pluginList = pluginRoot.elements("PLUGIN");
				Iterator pluginIterator = pluginList.iterator();
				while(pluginIterator.hasNext()) {
					Element pluginElement = (Element) pluginIterator.next();
					
					Element PLUGIN_ID = pluginElement.element("PLUGIN_ID");
	        		
	        		Element VUL_ID = pluginElement.element("VUL_ID");
	        		if(VUL_ID.getText()!=null && !"".equals(VUL_ID.getText().trim())) {
	        		
	        		List<AsseInfoLeak> asseInfoLeaks = findByVulId(VUL_ID.getText().trim(), asseInfoProj);
	        	    if(asseInfoLeaks!=null && asseInfoLeaks.size()>0) {
	        		 for(int i=0;i<asseInfoLeaks.size();i++) {
	        			 
	        		 AsseInfoLeak asseInfoLeak = asseInfoLeaks.get(i);
	        		 asseInfoLeak.setPluginId(PLUGIN_ID.getText().trim());
	        		
	        		Element NAME = pluginElement.element("NAME");
	        		asseInfoLeak.setLocation(NAME.getText());
	        		
	        		Element CVE_ID = pluginElement.element("CVE_ID");
	        		if(CVE_ID.getText()!=null && !"".equals(CVE_ID.getText())) {
	        		 asseInfoLeak.setCveId(CVE_ID.getText().trim());
	        		}
	        		
	        		Element NSFOCUS_ID = pluginElement.element("NSFOCUS_ID");
	        		asseInfoLeak.setNsfocusId(NSFOCUS_ID.getText());
	        		
	        		Element BUGTRAQ_ID = pluginElement.element("BUGTRAQ_ID");
	        		asseInfoLeak.setBugtraqId(BUGTRAQ_ID.getText());
	        		
	        		Element RISK = pluginElement.element("RISK");
	        		asseInfoLeak.setRisk(retSecuLeve(RISK.getText()));
	        		
	        		Element SOLUTION = pluginElement.element("SOLUTION");
	        		asseInfoLeak.setSolution(SOLUTION.getText());
	        		
	        		Element DESCRIPTION = pluginElement.element("DESCRIPTION");
	        		asseInfoLeak.setDescribe(DESCRIPTION.getText());
	        		
	        		leakScanDao.saveOrUpdate(asseInfoLeak);
	        		     }
	        		   }
	        		}
				}
	            
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		  }
	}

	/**
     * 判断安全级别
     * @param risk
     *  绿盟xml报告中的risk值
     * @return true/false
     **/
	public String retSecuLeve(String risk){
		String secuLeve="L";
		if(risk!=null && !"".equals(risk.trim())) {
			int riskNum = Integer.parseInt(risk.trim());
			if(riskNum>=1 && riskNum<=4) {
				secuLeve="L";
			}else if(riskNum>=5 && riskNum<=7) {
				secuLeve="M";
			}else if(riskNum>=8 && riskNum<=10) {
				secuLeve="H";
			}
		}
		return secuLeve;
	}
	
	/**
     * 检查是否已导入过
     * @param asseInfoProj
     *            测评项目
     * @return true/false
     **/
	public boolean checkExit(AsseInfoProj asseInfoProj) {
		
		boolean ret = false;
		List<AsseInfoLeak> list = listAsseInfoLeak(asseInfoProj);
		if(list!=null && list.size()>0) {
			ret = true;
		}
		return ret;
	}

	/**
     * 查询漏洞
     * 
     * @param pluginId
     *    pluginId
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞对象
     **/
	public List findByPluginId(String pluginId,AsseInfoProj asseInfoProj) {
		
		return leakScanDao.findByPluginId(pluginId,asseInfoProj);
	}

	/**
     * 查询漏洞
     * 
     * @param vulId
     *    vulId
     * @param asseInfoProj
     *            测评项目
     * @return 漏洞对象
     **/
	public List findByVulId(String vulId, AsseInfoProj asseInfoProj) {
		
		return leakScanDao.findByVulId(vulId, asseInfoProj);
	}

	/**
     * 查询IP地址列表
     * @param asseInfoProj
     *            测评项目
     * @return IP地址列表
     **/
	public List<String> listIP(AsseInfoProj asseInfoProj) {
		
		return leakScanDao.listIP(asseInfoProj);
	}

	
	public List<String> listCVEId(AsseInfoProj asseInfoProj) {
		
		return leakScanDao.listCVEId(asseInfoProj);
	}
	/**
     * 查询漏洞分页记录
     **/
	public List<AsseInfoLeak> findAll(int startResult, int maxResult,
			AsseInfoProj asseInfoProj, String ip) {
       List<AsseInfoLeak> list = leakScanDao.findAll(startResult,maxResult,asseInfoProj, ip);
       return list;
	}

	

	
}
