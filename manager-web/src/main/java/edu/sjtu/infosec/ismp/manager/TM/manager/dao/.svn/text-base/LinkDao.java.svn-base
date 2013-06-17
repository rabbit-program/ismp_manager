package edu.sjtu.infosec.ismp.manager.TM.manager.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.manager.rmi.tm.manager.model.LinkEntity;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component
public class LinkDao extends HibernateDao<LinkEntity, Integer>{
	private static final String DELETE_LINKS = "delete from LinkEntity where linkId in(:ids)";
	
	/**
	 * 删除域集合
	 * @param linkEntitys
	 */
	public void deleteLinks(List<LinkEntity> linkEntitys) {
		if(linkEntitys == null) return;
		List<Long> ids = new ArrayList<Long>();
		for(LinkEntity linkEntity:linkEntitys) {
			ids.add(linkEntity.getLinkId());
		}
		Map<String, List<Long>> map = Collections.singletonMap("ids", ids);
		batchExecute(DELETE_LINKS,map);
	}
	
	/**
	 * 保存或更新线
	 * @param linkEntity
	 */
	public void saveOrUpdateLink(LinkEntity linkEntity) {
		if(getSession() != null)
			getSession().saveOrUpdate(linkEntity);
	}
	
	/**
	 * 保存或更新线集合
	 * @param linkEntitys
	 */
	public void saveOrUpdateLinks(List<LinkEntity> linkEntitys) {
		if(linkEntitys == null) return;
		for(LinkEntity linkEntity : linkEntitys) {
			saveOrUpdateLink(linkEntity);
		}
	}
}
