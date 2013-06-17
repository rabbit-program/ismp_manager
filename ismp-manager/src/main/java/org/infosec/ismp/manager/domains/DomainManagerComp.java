package org.infosec.ismp.manager.domains;

import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.util.ThreadCategory;

/**
 * 管理所有的域
 * 
 * @author lianglin
 * 
 */
public class DomainManagerComp {

	private Map<String, DomainComponent> m_domains = new HashMap<String, DomainComponent>();

	/**
	 * 创建一个新的域
	 * 
	 * @param domainId
	 * @return
	 */
	public DomainComponent createDomain(String domainId) {
		DomainComponent domain = new DomainComponent(domainId);
		m_domains.put(domainId, domain);
		log().debug("创建一个新的域,域id是 : " + domainId);
		return domain;
	}

	/**
	 * 删除一个域，如果该域不存在，没有任何工作
	 * 
	 * @param domainId
	 */
	public void removeDomain(String domainId) {
		synchronized (m_domains) {
			if (m_domains.containsKey(domainId)) {
				m_domains.remove(domainId);
				log().debug("删除对应的域: " + domainId);
			} else {
				log().debug("没有找到对应的域 :" + domainId);
			}
		}

	}

	/**
	 * 根据域标识，返回域，如果该域不存在，返回null;
	 * 
	 * @param domainId
	 * @return
	 */
	public DomainComponent findDomain(String domainId) {
		return m_domains.get(domainId);
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
