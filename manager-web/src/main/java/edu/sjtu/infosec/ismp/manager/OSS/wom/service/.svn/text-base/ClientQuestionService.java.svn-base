package edu.sjtu.infosec.ismp.manager.OSS.wom.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.OSS.wom.model.ClientQuestion;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * Service层 客户端问题service.
 */
public interface ClientQuestionService {
	/**
	 * 保存/更新客户端问题
	 */
	void saveOrUpdate(ClientQuestion clientQuestion);

	/**
	 * 删除客户端问题
	 */
	void remove(ClientQuestion clientQuestion);

	/**
	 * 批量删除客户端问题
	 */
	void remove(String[] clientQuestions);

	/**
	 * 查询客户端问题
	 */
	ClientQuestion findById(Integer id);

	/**
	 * 客户端问题分页信息
	 */
	List<ClientQuestion> findAll(int startResult, int maxResult,Domain domain,Integer state);

	/**
	 * 委办局下客户端问题分页信息
	 */
	List<ClientQuestion> findAllByDomain(List<Domain> userDomainList,
			int startResult, int maxResult,Domain domain,Integer state);

	/**
	 * 客户端问题查询记录总条数
	 */
	int getCount(Domain domain,Integer state);

	/**
	 * 委办局下客户端问题查询记录总条数
	 */
	int getCountByDomain(List<Domain> userDomainList,Domain domain,Integer state);
}