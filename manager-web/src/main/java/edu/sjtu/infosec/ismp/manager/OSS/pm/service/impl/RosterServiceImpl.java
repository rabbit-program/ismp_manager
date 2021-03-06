package edu.sjtu.infosec.ismp.manager.OSS.pm.service.impl;

import java.sql.Timestamp;
import java.util.List;
import edu.sjtu.infosec.ismp.manager.OSS.pm.dao.RosterDao;
import edu.sjtu.infosec.ismp.manager.OSS.pm.model.Roster;
import edu.sjtu.infosec.ismp.manager.OSS.pm.service.RosterService;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPageUtil;
import edu.sjtu.infosec.ismp.security.Domain;

public class RosterServiceImpl implements RosterService {
	private RosterDao rosterDao;
	public void setRosterDao(RosterDao rosterDao) {
		this.rosterDao = rosterDao;
	}
	public void add(Roster roster) throws Exception {
		rosterDao.add(roster);
	}

	public void delete(Roster roster) throws Exception {
		rosterDao.delete(roster);
	}

	public List<Roster> findAll() {
		return rosterDao.findAll();
	}

	public Roster findById(int id) {
		return rosterDao.findById(id);
	}

	public List<Roster> findConditionsInfo(Roster roster,
			List<Domain> domainList, PMPage page, Timestamp startRecordTime,
			Timestamp endRecordTime) {
		List<Roster> list=  rosterDao.findConditionsInfo(roster, domainList, page, startRecordTime, endRecordTime);
		int count = (int) rosterDao.findRosterByCount(roster, domainList, page, startRecordTime, endRecordTime);
		page.setPageInfo(PMPageUtil.createPage(page, count));
		return list;
	}

	public void update(Roster roster) throws Exception {
		rosterDao.update(roster);
	}

	public List<Roster> selectAll(List<Domain> domainList) {
		return rosterDao.findConditionsInfo(null, domainList, null, null, null);
	}
	public List<Roster> findLikeAll(Object[] args) {
		return rosterDao.findLikeAll(args);
	}

}
