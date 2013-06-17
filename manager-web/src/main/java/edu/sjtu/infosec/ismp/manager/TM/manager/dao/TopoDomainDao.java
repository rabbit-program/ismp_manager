package edu.sjtu.infosec.ismp.manager.TM.manager.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.infosec.ismp.manager.rmi.tm.manager.model.DomainEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;


@Component
public class TopoDomainDao extends HibernateDao<DomainEntity, Integer>{
	
	private static final String QUERY_CASECADE_DOMIN = "select d from Domain d where d.parentDomain =:fDomain";
	private static final String DELETE_DOMAINS = "delete from DomainEntity where id in(:ids)";
	
	/**
	 * 删除域集合
	 * @param domainEntitys
	 */
	public void deleteDomains(List<DomainEntity> domainEntitys) {
		if(domainEntitys == null) return;
		List<Integer> ids = new ArrayList<Integer>();
		for(DomainEntity domainEntity:domainEntitys) {
			ids.add(domainEntity.getId());
		}
		Map<String, List<Integer>> map = Collections.singletonMap("ids", ids);
		batchExecute(DELETE_DOMAINS,map);
	}
	
	/**
	 * 保存或更新域
	 * @param domainEntity
	 */
	public void saveOrUpdateDomain(DomainEntity domainEntity) {
		if(getSession() != null) {
			if(domainEntity.getParentDomain() != null && domainEntity.getParentDomain().getId() == null) {
				domainEntity.setParentDomain(null);
			}
			getSession().saveOrUpdate(domainEntity);
		}
	}
	
	/**
	 * 保存或更新域集合
	 * @param domainEntitys
	 */
	public void saveOrUpdateDomains(List<DomainEntity> domainEntitys) {
		if(domainEntitys == null) return;
		for(DomainEntity domainEntity : domainEntitys) {
			saveOrUpdateDomain(domainEntity);
		}
	}
	
	/**
	 * 查询域及其子域信息
	 * @param set 
	 */
	@SuppressWarnings("unchecked")
	public List<DomainEntity> getCasecadeDomain(Set<DomainEntity> set) {
		if(set!=null&&set.size()!=0){
			List result = new ArrayList(set);
//			result.addAll();
			for(DomainEntity domain:set){
				List qr = getDomianByParent(domain,result);
				result.addAll(qr);
			}
			return result;
		}
		return null;
	}

	
	/**
	 * 递归查询子域信息
	 * @param domain
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<DomainEntity> getDomianByParent(DomainEntity domain,List result){
		Query query = createQuery(QUERY_CASECADE_DOMIN);
		query.setParameter("fDomain", domain);
		List<DomainEntity> pr = distinct(query).list();
		
		if(pr!=null&&pr.size()!=0){
			result.addAll(pr);
			for(DomainEntity yu:pr){
				List<DomainEntity> anore = getDomianByParent(yu,result);
				result.addAll(anore);
			}
		}
		return result;
	}

}
