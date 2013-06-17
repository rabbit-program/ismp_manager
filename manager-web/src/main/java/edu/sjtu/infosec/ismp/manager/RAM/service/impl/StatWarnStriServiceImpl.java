package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import edu.sjtu.infosec.ismp.manager.RAM.dao.StatWarnStriDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseKnowStatWarnStri;
import edu.sjtu.infosec.ismp.manager.RAM.service.StatWarnStriService;

/**
 * 应用层 知识库静态安全阈值Manager实现类.
 * 


 **/
public class StatWarnStriServiceImpl  implements StatWarnStriService {

	/**
     * statWarnStriDao
     * 
     */
    private StatWarnStriDao statWarnStriDao;

    /**
     * setStatWarnStriDao
     * @param vstatWarnStriDao
     * 知识库静态安全阈值Dao
     **/
    public void setStatWarnStriDao(StatWarnStriDao vstatWarnStriDao) {
		this.statWarnStriDao = vstatWarnStriDao;
	}
    
	public AsseKnowStatWarnStri find(Integer id) {
		
		return statWarnStriDao.find(id);
	}

	

	public AsseKnowStatWarnStri getWarnStri() {
		
		return statWarnStriDao.getWarnStri();
	}

	public void remove(AsseKnowStatWarnStri statWarnStri) {
		
		statWarnStriDao.remove(statWarnStri);
	}

	public String retIsWarn(Integer vulnHighNum, Integer vulnMiduNum,
			Integer vulnLowNum) {
		
		String isWarn="n";
		AsseKnowStatWarnStri statWarnStri = getWarnStri();
		Integer high = statWarnStri.getVulnHighNum();
		Integer midd = statWarnStri.getVulnMiduNum();
		Integer low = statWarnStri.getVulnLowNum();
		if(vulnHighNum.intValue()>high || vulnMiduNum.intValue()>midd || vulnLowNum.intValue()>low) {
			isWarn="y";
		}
		return isWarn;
	}

	public void saveOrUpdate(AsseKnowStatWarnStri statWarnStri) {
		
		statWarnStriDao.saveOrUpdate(statWarnStri);
	}

}
