/**
 * 
 */
package edu.sjtu.infosec.ismp.manager.VPM.pm.dao;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchInfo;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;

/**
 * @author Admin
 *
 */
public interface SensorClientsPatchDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao
	 * #getComputerTargetId(java.lang.String)
	 */
	public abstract String getComputerTargetId(String IP) throws Exception;

	@Deprecated
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao
	 * #getPatchUpdateInfoByState(java.lang.String, java.lang.String, int[])
	 */
	public abstract List getPatchUpdateInfoByState(String computerID,
			String type, int[] states) throws Exception;

	/**
	 * 分页显示
	 */
	public abstract List getPatchUpdateInfoByState(String computerID,
			String type, int[] states, PMPage page) throws Exception;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao
	 * #getPatchUpdateInfoByStateCount(java.lang.String, java.lang.String,
	 * int[])
	 */
	public abstract Integer getPatchUpdateInfoByStateCount(String computerID,
			String type, int[] states) throws Exception;

	@Deprecated
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao
	 * #getPatchInfo(java.lang.String, java.lang.String)
	 */
	public abstract List<PatchInfo> getPatchInfo(String declined, String type)
			throws Exception;

	/**
	 * 分页显示
	 */
	public abstract List<PatchInfo> getPatchInfo(String declined, String type,
			Page page) throws Exception;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.sjtu.infosec.ismp.manager.patchManager.dao.impl.SensorClientsPatchDao
	 * #getPatchInfoCount(java.lang.String, java.lang.String)
	 */
	public abstract Integer getPatchInfoCount(String declined, String type)
			throws Exception;

	public abstract PatchInfo getPatchInfoById(String id, String declined)
			throws Exception;

}