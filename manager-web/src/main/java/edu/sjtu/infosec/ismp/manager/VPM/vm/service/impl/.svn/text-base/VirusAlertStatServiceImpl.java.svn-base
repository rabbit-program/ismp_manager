package edu.sjtu.infosec.ismp.manager.VPM.vm.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.vm.dao.VirusAlertStatDao;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopVirus;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusAlertsStat;
import edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients;
import edu.sjtu.infosec.ismp.manager.VPM.vm.service.VirusAlertStatService;

public class VirusAlertStatServiceImpl implements VirusAlertStatService {
	
	private VirusAlertStatDao virusAlertsStatDao;
	
//	private SystemLogService systemlogservice;
	
	
	public void setVirusAlertsStatDao(VirusAlertStatDao virusAlertsStatDao) {
		this.virusAlertsStatDao = virusAlertsStatDao;
	}
//	public void setSystemlogservice(SystemLogService systemlogservice) {
//		this.systemlogservice = systemlogservice;
//	}
	
	
	
	
	public void addVirusAlertStat(VirusAlertsStat virusAlertStat)
			throws Exception {
		virusAlertsStatDao.addVirusAlertStat(virusAlertStat);
	}
	public void deleteVirusAlertStat(VirusAlertsStat virusAlertStat)
			throws Exception {
		virusAlertsStatDao.deleteVirusAlertStat(virusAlertStat);
	}
	public void updateVirusAlertStat(VirusAlertsStat virusAlertStat)
			throws Exception {
		virusAlertsStatDao.updateVirusAlertStat(virusAlertStat);
	}
	public List<VirusAlertsStat> findAllVirusAlertStat() throws Exception {
		List<VirusAlertsStat> list = virusAlertsStatDao.findAllVirusAlertStat();
		return list;
	}
	public VirusAlertsStat findVirusAlertStatById(int id) throws Exception {
		VirusAlertsStat virusAlertStat = virusAlertsStatDao.findVirusAlertStatById(id);
		return virusAlertStat;
	}
	public List<VirusAlertsStat> findAllByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClients != null){
			list = virusAlertsStatDao.findAllByVirusClients(virusClients, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusAlertsStat> findAllByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClientsList!=null && virusClientsList.size()>0){
			list = virusAlertsStatDao.findAllByVirusClientsList(virusClientsList, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public long findAllNumByVirusClients(VirusClients virusClients,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		long num = 0;
		if(virusClients != null){
			num = virusAlertsStatDao.findAllNumByVirusClients(virusClients, startRecordTime, endRecordTime);
		}
		return num;
	}
	public long findAllNumByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		long num = 0;
		if(virusClientsList!=null && virusClientsList.size()>0){
			num = virusAlertsStatDao.findAllNumByVirusClientsList(virusClientsList, startRecordTime, endRecordTime);
		}
		return num;
	}
	public List<VirusAlertsStat> findKilledByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClients != null){
			list = virusAlertsStatDao.findKilledByVirusClients(virusClients, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusAlertsStat> findKilledByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClientsList!=null && virusClientsList.size()>0){
			list = virusAlertsStatDao.findKilledByVirusClientsList(virusClientsList, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public long findKilledNumByVirusClients(VirusClients virusClients,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		long num = 0;
		if(virusClients != null){
			num = virusAlertsStatDao.findKilledNumByVirusClients(virusClients, startRecordTime, endRecordTime);
		}
		return num;
	}
	public long findKilledNumByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		long num = 0;
		if(virusClientsList!=null && virusClientsList.size()>0){
			num = virusAlertsStatDao.findKilledNumByVirusClientsList(virusClientsList, startRecordTime, endRecordTime);
		}
		return num;
	}
	public List<VirusAlertsStat> findUnkilledByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClients != null){
			list = virusAlertsStatDao.findUnkilledByVirusClients(virusClients, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusAlertsStat> findUnkilledByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClientsList!=null && virusClientsList.size()>0){
			list = virusAlertsStatDao.findUnkilledByVirusClientsList(virusClientsList, startRecordTime, endRecordTime);
		}else{
			list = null;
		}
		return list;
	}
	public long findUnkilledNumByVirusClients(VirusClients virusClients,
			Timestamp startRecordTime, Timestamp endRecordTime)
			throws Exception {
		long num = 0;
		if(virusClients != null){
			num = virusAlertsStatDao.findUnkilledNumByVirusClients(virusClients, startRecordTime, endRecordTime);
		}
		return num;
	}
	public long findUnkilledNumByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime) throws Exception {
		long num = 0;
		if(virusClientsList!=null && virusClientsList.size()>0){
			num = virusAlertsStatDao.findUnkilledNumByVirusClientsList(virusClientsList, startRecordTime, endRecordTime);
		}
		return num;
	}
	public List<VirusAlertsStat> findAllByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClients != null){
			list = virusAlertsStatDao.findAllByVirusClients(virusClients, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusAlertsStat> findAllByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClientsList!=null && virusClientsList.size()>0){
			list = virusAlertsStatDao.findAllByVirusClientsList(virusClientsList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusAlertsStat> findAllVirusAlertStat(int startResult,
			int maxResult) throws Exception {
		List<VirusAlertsStat> list = virusAlertsStatDao.findAllVirusAlertStat(startResult, maxResult);
		return list;
	}
	public List<VirusAlertsStat> findKilledByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClients != null){
			list = virusAlertsStatDao.findKilledByVirusClients(virusClients, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusAlertsStat> findKilledByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClientsList!=null && virusClientsList.size()>0){
			list = virusAlertsStatDao.findKilledByVirusClientsList(virusClientsList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusAlertsStat> findUnkilledByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClients != null){
			list = virusAlertsStatDao.findUnkilledByVirusClients(virusClients, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public List<VirusAlertsStat> findUnkilledByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int startResult, int maxResult)
			throws Exception {
		List<VirusAlertsStat> list = new ArrayList<VirusAlertsStat>();
		if(virusClientsList!=null && virusClientsList.size()>0){
			list = virusAlertsStatDao.findUnkilledByVirusClientsList(virusClientsList, startRecordTime, endRecordTime, startResult, maxResult);
		}else{
			list = null;
		}
		return list;
	}
	public long findAllNum() throws Exception {
		return virusAlertsStatDao.findAllNum();
	}
	public List<TopVirus> findTopVirusCountByVirusClients(
			VirusClients virusClients, Timestamp startRecordTime,
			Timestamp endRecordTime, int topNum) throws Exception {
		List<TopVirus> list = virusAlertsStatDao.findTopVirusCountByVirusClients(virusClients, startRecordTime, endRecordTime, topNum);
		return list;
	}
	public List<TopVirus> findTopVirusCountByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int topNum) throws Exception {
		List<TopVirus> list = virusAlertsStatDao.findTopVirusCountByVirusClientsList(virusClientsList, startRecordTime, endRecordTime, topNum);
		return list;
	}
	public List<TopClients> findTopClientsCountByVirusClientsList(
			List<VirusClients> virusClientsList, Timestamp startRecordTime,
			Timestamp endRecordTime, int topNum) throws Exception {
		List<TopClients> list = virusAlertsStatDao.findTopClientsCountByVirusClientsList(virusClientsList, startRecordTime, endRecordTime, topNum);
		return list;
	}

}
