package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.sjtu.infosec.ismp.manager.RAM.dao.PapeDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.ProjectDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.StatSecuElemDao;
import edu.sjtu.infosec.ismp.manager.RAM.dao.VulnAnalDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoPape;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowDynaVuln;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatSecuElem;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatVulnPoin;
import edu.sjtu.infosec.ismp.manager.RAM.service.PapeService;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageUtil;

/**
 * 应用层 问卷Manager接口实现类.
 * 


 */
public class PapeServiceImpl  implements PapeService {

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
     * papeDao
     * 
     */
    private PapeDao papeDao;

    /**
     * setPapeDao
     * @param papedao
     * 问卷Dao
     **/
    public void setPapeDao(PapeDao papedao) {
        this.papeDao = papedao;
    }
    
    /**
     * 测评项目数据访问对象接口
     */
    private ProjectDao projectDao;

    /**
     * @param projectdao
     *            测评项目数据访问对象接口(Spring Ioc容器依赖注入)
     */
    public void setProjectDao(ProjectDao projectdao) {
        this.projectDao = projectdao;
    }
    
    /**
     * 动态脆弱点分析数据访问对象接口
     */
	private VulnAnalDao vulnAnalDao;
	
	/**
     * setVulnAnalDao
     * @param vulnanalDao 
     * 动态脆弱点分析数据访问对象接口
     **/
	public void setVulnAnalDao(VulnAnalDao vulnanalDao) {
		this.vulnAnalDao = vulnanalDao;
	}
	
    /**
     * 查询问卷问题
     * 
     * @param id
     *    问卷问题id
     * @return 问卷问题对象
     **/
    public AsseInfoPape find(String id) {
        
        return papeDao.find(new Integer(id));
    }
    
    public AsseInfoPape findbySecuId(Integer projId,String id) {
        
        return papeDao.findbySecuId(projId,new Integer(id));
    }

    /**
     * 查询问卷问题数量
     * @param asseInfoProj
     *            测评项目
     * @return 问卷问题数量
     **/
    public int getCount(AsseInfoProj asseInfoProj) {
       
        return papeDao.getCount(asseInfoProj);
    }

    /**
     * 查询问卷问题分页记录
     * @param page
     *     分页对象
     * @param asseInfoProj
     *            测评项目
     * @return 分页记录列表
     **/
    public PageResult listAsseInfoPape(Page page,
            AsseInfoProj asseInfoProj) {
        int totalCount = papeDao.getCount(asseInfoProj);
        page = PageUtil.createPage(page, totalCount);
        List<AsseInfoPape> list = papeDao.listAsseInfoPape(page, asseInfoProj);
        return new PageResult(page, list);
    }

    /**
     * 删除问卷问题
     * 
     * @param question
     * 问卷问题
     **/
    public void remove(AsseInfoPape question) {
        
        papeDao.remove(question);
    }

    /**
     * 批量删除问卷问题
     * 
     * @param questionList
     *     问卷问题对象列表
     **/
    public void remove(List<AsseInfoPape> questionList) {
        
        papeDao.remove(questionList);
    }

    /**
     * 保存/更新问卷问题
     * 
     * @param question
     * 问卷问题
     **/
    public void saveOrUpdate(AsseInfoPape question) {
        if(question!=null &&!"".equals(question)){
            papeDao.saveOrUpdate(question);
        }
    }

    /**
     * 批量保存/更新问卷问题
     * 
     * @param question
     * 问卷问题
     **/
    public void batchSaveOrUpdate(String elemCode,AsseInfoProj asseInfoProj) {
        String[] elemCodes = elemCode.split(";");
        String elemcode = "";
        List<AsseInfoPape> questions = new ArrayList<AsseInfoPape>();
        List<AsseInfoPape> exitPapesList = papeDao.listAsseInfoPape(null, asseInfoProj);
        List<AsseKnowStatSecuElem> haveSelectedSEList = new ArrayList<AsseKnowStatSecuElem>();
        if(exitPapesList!=null && exitPapesList.size()>0) {
            for(int i=0;i<exitPapesList.size();i++){
             AsseInfoPape pape = (AsseInfoPape) exitPapesList.get(i);
             haveSelectedSEList.add(pape.getSecuElem());
            }
        }
        System.out.println("haveSelectedSEList.size():"+haveSelectedSEList.size());
        for(int i=0;i<elemCodes.length;i++) {
            elemcode = elemCodes[i];
            System.out.println(elemcode);
            if(elemcode!=null && !"".equals(elemcode)) {
                AsseInfoPape question = new AsseInfoPape();
                AsseKnowStatSecuElem statSecuElem = new AsseKnowStatSecuElem();
                statSecuElem = secuElemDao.find(elemcode);
              if(haveSelectedSEList.size()==0 || !haveSelectedSEList.contains(statSecuElem)) {   
                question.setAsseInfoProjId(asseInfoProj.getId());
                question.setSecuElem(statSecuElem);
                System.out.println("入库问卷的安全要素编码："+statSecuElem.getElemCode());
                questions.add(question);
              }
            }
        }
        
        if(questions.size()>0) {
         papeDao.batchSaveOrUpdate(questions);
        }
        
    }

    /**
     * 返回这个测评项目已选安全要素
     * @param asseInfoProj
     *            测评项目
     * @return 已选安全要素列表
     **/
    public List listSelectedStatSecuElems(
            String asseInfoProjId) {
        
        AsseInfoProj asseInfoProj =projectDao.find(new Integer(asseInfoProjId));
        List<AsseKnowStatSecuElem> selectedStatSecuElemList = new ArrayList<AsseKnowStatSecuElem>();
        List<AsseInfoPape> list = papeDao.listAsseInfoPape(null, asseInfoProj);
        AsseInfoPape asseInfoPape = null;
        if(list!=null && list.size()>0) {
            for(int i=0;i<list.size();i++) {
             AsseKnowStatSecuElem statSecuElem = new AsseKnowStatSecuElem();
             asseInfoPape = (AsseInfoPape) list.get(i);
             statSecuElem = asseInfoPape.getSecuElem();
             selectedStatSecuElemList.add(statSecuElem);
             System.out.println("DWR getSelectedStatSecuElem Code:"+statSecuElem.getElemCode());
            }
        }
        return selectedStatSecuElemList;
    }
    
    /**
     * 返回这个测评项目已选安全要素对应的Pape
     * @param asseInfoProj
     *            测评项目
     * @return 对应PapeMap
     **/
    public Map relatedSecuElemPapeMap(
            String asseInfoProjId) {
        
        AsseInfoProj asseInfoProj =projectDao.find(new Integer(asseInfoProjId));
        Map relatedSecuElemPapeMap = new HashMap();
        List<AsseInfoPape> list = papeDao.listAsseInfoPape(null, asseInfoProj);
        AsseInfoPape asseInfoPape = null;
        if(list!=null && list.size()>0) {
            for(int i=0;i<list.size();i++) {
             AsseKnowStatSecuElem statSecuElem = new AsseKnowStatSecuElem();
             asseInfoPape = (AsseInfoPape) list.get(i);
             statSecuElem = asseInfoPape.getSecuElem();
             relatedSecuElemPapeMap.put(statSecuElem.getElemCode(), asseInfoPape.getId());
             System.out.println("DWR getSelectedStatSecuElem Code:"+statSecuElem.getElemCode());
            }
        }
        return relatedSecuElemPapeMap;
    }

    /**
     * 查询下一题问题
     * @param asseInfoPape
     *            当前问题
     * @return 下一题问题
     **/
    public AsseInfoPape getNextQuestion(AsseInfoPape asseInfoPape) {
        
        AsseInfoPape question = new AsseInfoPape();
        if(asseInfoPape.getAnswer()!=null) {
            if("no".equals(asseInfoPape.getAnswer().trim()) && asseInfoPape.getSecuElem().getJumpSecuElem()!=null) {
                   question = papeDao.getNextJumpAsseInfoPape(asseInfoPape);
                   if(question == null) {
                       
                       List list = papeDao.listNextPapes(asseInfoPape);
                       if(list!=null && list.size()>0) {
                          question = (AsseInfoPape) list.get(0);
                       }
                   }
            }else{
                List list = papeDao.listNextPapes(asseInfoPape);
                if(list!=null && list.size()>0) {
                   question = (AsseInfoPape) list.get(0);
                }
            }
        }else{
                List list = papeDao.listNextPapes(asseInfoPape);
                if(list!=null && list.size()>0) {
                   question = (AsseInfoPape) list.get(0);
                }
        }
         
        
        return question;
    }

    /**
     * 查询已答问题列表
     * @param asseInfoProjId
     *   项目编号
     * @return 已答问题列表
     **/
    public List<AsseInfoPape> listAnsweredPapes(String asseInfoProjId) {
        
        List<AsseInfoPape> answeredPapesList = papeDao.listAnsweredPapes(new Integer(asseInfoProjId));
        return answeredPapesList;
    }
    
    /**
     * 保存动态脆弱点
     * @param asseInfoProjId
     *   项目编号
     * @return 已答问题列表
     **/
    public void saveDynaVulnPoint(String asseInfoProjId) {
    	
    	AsseKnowDynaVuln asseKnowDynaVuln = null;
    	AsseInfoPape asseInfoPape = null;
    	List<AsseKnowDynaVuln> dynaVulnPointList = new ArrayList<AsseKnowDynaVuln>();
    	AsseInfoProj asseInfoProj =projectDao.find(new Integer(asseInfoProjId));
    	List<AsseInfoPape> answeredPapesList = new ArrayList<AsseInfoPape>();
    	List<AsseInfoPape> answeredPapesList1 = papeDao.listPapesByAnswer(new Integer(asseInfoProjId), "no");
    	List<AsseInfoPape> answeredPapesList2 = papeDao.listPapesByAnswer(new Integer(asseInfoProjId), "notCertain");
    	if(answeredPapesList1!=null && answeredPapesList1.size()>0) {
    		answeredPapesList.addAll(answeredPapesList1);
    	}
        if(answeredPapesList2!=null && answeredPapesList2.size()>0) {
        	answeredPapesList.addAll(answeredPapesList2);
    	}
    	List<AsseKnowDynaVuln> dynaVulnList = vulnAnalDao.listDynaVulnPoint(asseInfoProj.getId());
    	List<Integer> dynaVulnId = new ArrayList<Integer>();
    	if(dynaVulnList!=null && dynaVulnList.size()>0) {
    	 	for(int i=0;i<dynaVulnList.size();i++) {
    	 		asseKnowDynaVuln = (AsseKnowDynaVuln) dynaVulnList.get(i);
    	 		dynaVulnId.add(asseKnowDynaVuln.getAsseKnowStatVulnPoinId());
    	 	}
    	}
    	
    		for(int i=0;i<answeredPapesList.size();i++) {
    			asseInfoPape = answeredPapesList.get(i);
    			if(!dynaVulnId.contains(asseInfoPape.getSecuElem().getVulnPoin().getId())) {
    				
    				AsseKnowDynaVuln dynaVuln = new AsseKnowDynaVuln();
    				dynaVuln.setAsseInfoProjId(new Integer(asseInfoProjId));
    				dynaVuln.setAsseKnowStatVulnKindId(asseInfoPape.getSecuElem().getVulnPoin().getVulnKind().getId());
    				dynaVuln.setSource(asseInfoPape.getSecuElem().getVulnPoin().getSource());
    				dynaVuln.setAsseKnowStatVulnPoinId(asseInfoPape.getSecuElem().getVulnPoin().getId());
    				dynaVuln.setSeriLeve("L");
    				dynaVulnPointList.add(dynaVuln);
    			}
    		}
    	
    	vulnAnalDao.batchSaveOrUpdate(dynaVulnPointList);
    }

    /**
     * 根据问卷查询脆弱点列表
     * @param asseInfoProjId
     *           测评项目Id
    * @return 脆弱点列表
     **/
	public List<AsseKnowStatVulnPoin> listVulnPoinByPaper(String asseInfoProjId) {
		
		AsseInfoPape asseInfoPape = null;
		List<AsseKnowStatVulnPoin> vulnPoinByPaperList = new ArrayList<AsseKnowStatVulnPoin>();
		List<AsseInfoPape> answeredPapesList1 = papeDao.listPapesByAnswer(new Integer(asseInfoProjId), "no");
    	List<AsseInfoPape> answeredPapesList2 = papeDao.listPapesByAnswer(new Integer(asseInfoProjId), "notCertain");
    	if(answeredPapesList1!=null && answeredPapesList1.size()>0) {
    		for(int i=0;i<answeredPapesList1.size();i++) {
    			asseInfoPape = answeredPapesList1.get(i);
    			vulnPoinByPaperList.add(asseInfoPape.getSecuElem().getVulnPoin());
    		}
    	}
        if(answeredPapesList2!=null && answeredPapesList2.size()>0) {
            for(int i=0;i<answeredPapesList2.size();i++) {
            	asseInfoPape = answeredPapesList2.get(i);
            	vulnPoinByPaperList.add(asseInfoPape.getSecuElem().getVulnPoin());
    		}
    	}
		return vulnPoinByPaperList;
	}
    
}
