package edu.sjtu.infosec.ismp.manager.RAM.service.impl;

import java.util.List;
import edu.sjtu.infosec.ismp.manager.RAM.dao.ProjectDao;
import edu.sjtu.infosec.ismp.manager.RAM.model.AsseInfoProj;
import edu.sjtu.infosec.ismp.manager.RAM.service.ProjectService;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 应用层 测评项目Manager实现类.
 */
public class ProjectServiceImpl  implements ProjectService {

    /**
     * 测评项目数据访问对象接口
     */
    private ProjectDao projectDao;

    /**
     * 测评项目数据访问对象接口(Spring Ioc容器依赖注入)
     */
    public void setProjectDao(ProjectDao projectdao) {
        this.projectDao = projectdao;
    }

    /**
     * 查询测评项目
     */
    public AsseInfoProj find(Integer projCode) {

        return projectDao.find(projCode);
    }

    /**
     * 查询历次测评项目
     */
    /*public List find(AsseInfoInst inst) {

        return projectDao.find(inst);
    }*/

    /**
     * 删除测评项目信息
     */
    public void remove(AsseInfoProj project) {

        projectDao.remove(project);
    }

    /**
     * 保存/更新测评项目信息
     */
    public void saveOrUpdate(AsseInfoProj project) {

        projectDao.saveOrUpdate(project);
    }

    /**
     * 查询测评项目分页记录
     * @return 分页记录列表
     */

	public List<AsseInfoProj> findAll(String asseBeginTime, String asseEndTime,
			int startResult, int maxResult, int offcpers, Domain domain,
			String assePers, String secuLeve) {
		List<AsseInfoProj> list = projectDao.findAll(asseBeginTime, asseEndTime, startResult, maxResult,offcpers,domain,assePers,secuLeve);
		return list;
	}

	public List<AsseInfoProj> findAllByDomain(List<Domain> domainList,
			String asseBeginTime, String asseEndTime, int startResult,
			int maxResult, int offcpers, Domain domain, String assePers,
			String secuLeve) {
		if(domainList == null){
			return null;
		}else if(domainList.size()<=0){
			return null;
		}else{
			List<AsseInfoProj>  list = projectDao.findAllByDomain(domainList,asseBeginTime, asseEndTime, startResult, maxResult,offcpers,domain,assePers,secuLeve);
			return list;
		}
	}

	public long findAllNum(String asseBeginTime, String asseEndTime,
			int offcpers, Domain domain, String assePers, String secuLeve) {
		long num = projectDao.findAllNum(asseBeginTime, asseEndTime,offcpers,domain,assePers,secuLeve);
		return num;
	}

	public long findAllNumByDomain(List<Domain> domainList,String asseBeginTime, String asseEndTime, int offcpers,String assePers, String secuLeve) {
		if(domainList == null){
			return 0;
		}else if(domainList.size()<=0){
			return 0;
		}else{
			long num = projectDao.findAllNumByDomain(domainList,asseBeginTime,asseEndTime,offcpers,assePers,secuLeve);
			return num;
		}
	}



}
