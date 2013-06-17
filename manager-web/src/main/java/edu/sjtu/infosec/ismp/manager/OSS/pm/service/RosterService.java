package edu.sjtu.infosec.ismp.manager.OSS.pm.service;

import java.sql.Timestamp;
import java.util.List;
import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 
 * @author Wu Guojie
 * @date 2010-5-14
 * @version 1.0
 */
public interface RosterService {
	/**
	 * 增
	 */
	public void add(Roster roster)throws Exception;
	/**
	 * 删
	 */
	public void delete(Roster roster)throws Exception;
	/**
	 * 改
	 */
	public void update(Roster roster)throws Exception;
	/**
	 * 查询为 id 的对象
	 */
	public Roster findById(int id);
	/**
	 * 查询所有
	 */
	public List<Roster> findAll();
	/**
	 * 条件查询
	 */
	public List<Roster> findConditionsInfo(Roster roster,List<Domain> domainList,PMPage page,Timestamp startRecordTime, Timestamp endRecordTime);
	
	public List<Roster> selectAll(List<Domain> domainList);
	
	public List<Roster> findLikeAll(Object[] args);
}
