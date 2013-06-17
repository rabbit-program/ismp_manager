package edu.sjtu.infosec.ismp.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springside.modules.orm.hibernate.HibernateDao;

@Component
public class UserDao extends HibernateDao<User, String> {

	private static final String QUERY_USER_WITH_ROLE = "select u from User u left join fetch u.roleList order by u.id";
	private static final String COUNT_USERS = "select count(u) from User u";
	private static final String DISABLE_USERS = "update User u set u.status='disabled' where id in(:ids)";
	private static final String QUERY_All_DOMAIN = "select d from Domain d";
	private static final String QUERY_CASECADE_DOMIN = "select d from Domain d where d.parentDomain =:fDomain";
	/**
	 * 批量修改用户状态.
	 */
	public void disableUsers(List<String> ids) {
		Map<String, List<String>> map = Collections.singletonMap("ids", ids);
		batchExecute(UserDao.DISABLE_USERS, map);
	}

	/**
	 * 使用 HQL 预加载lazy init的List<Role>,用DISTINCE_ROOT_ENTITY排除重复数据.
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUserWithRoleByDistinctHql() {
		Query query = createQuery(QUERY_USER_WITH_ROLE);
		return distinct(query).list();
	}

	/**
	 * 使用Criteria 预加载lazy init的List<Role>, 用DISTINCE_ROOT_ENTITY排除重复数据.
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUserWithRolesByDistinctCriteria() {
		Criteria criteria = createCriteria().setFetchMode("roleList",
				FetchMode.JOIN);
		return distinct(criteria).list();
	}

	/**
	 * 统计用户数.
	 */
	public Long getUserCount() {
		return findUnique(UserDao.COUNT_USERS);
	}

	/**
	 * 初始化User的延迟加载关联roleList.
	 */
	public void initUser(User user) {
		Hibernate.initialize(user.getRoles());
	}
	/**
	 * 查询所有域信息
	 */
	@SuppressWarnings("unchecked")
	public List<Domain> getAllDomain() {
		Query query = createQuery(QUERY_All_DOMAIN);
		return distinct(query).list();
	}
	/**
	 * 查询域及其子域信息
	 * @param set 
	 */
	@SuppressWarnings("unchecked")
	public List<Domain> getCasecadeDomain(Set<Domain> set) {
		if(set!=null&&set.size()!=0){
			List result = new ArrayList(set);
//			result.addAll();
			for(Domain domain:set){
				List qr = getDomianByParent(domain,result);
				result.addAll(qr);
			}
			return result;
		}
		return null;
	}
	/**
	 * 递归查询子域信息
	 * @param set 
	 */
	@SuppressWarnings("unchecked")
	private List<Domain> getDomianByParent(Domain domain,List result){
		Query query = createQuery(QUERY_CASECADE_DOMIN);
		query.setParameter("fDomain", domain);
		List<Domain> pr = distinct(query).list();
		if(pr!=null&&pr.size()!=0){
			result.addAll(pr);
			for(Domain yu:pr){
				List<Domain> anore = getDomianByParent(yu,result);
				result.addAll(anore);
			}
		}
		return result;
	}
}