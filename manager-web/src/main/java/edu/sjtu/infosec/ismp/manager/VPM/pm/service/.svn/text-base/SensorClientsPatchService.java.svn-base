/**
 * 
 */
package edu.sjtu.infosec.ismp.manager.VPM.pm.service;

import java.util.List;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchInfo;
import edu.sjtu.infosec.ismp.manager.VPM.pm.model.PatchUpdateInfo;
import edu.sjtu.infosec.ismp.manager.comm.model.page.Page;
import edu.sjtu.infosec.ismp.manager.comm.model.page.PageResult;

/**
 * @author Admin
 *
 */
public interface SensorClientsPatchService {

	/**
	 * 
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public abstract String getComputerTargetID(String ip) throws Exception;

	@Deprecated
	/**
	 * 
	 */
	public abstract List<PatchInfo> findPatchInfoBy(String declined)
			throws Exception;

	/**
	 * 有条件的分页查询，返回《PatchInfo》
	 * @param declined
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public abstract PageResult findPatchInfoBy(String declined, Page page)
			throws Exception;

	/**
	 * 有条件的获取总记录数，《patchInfo》
	 * @param declined
	 * @return
	 * @throws Exception
	 */
	public abstract Integer findPatchInfoByNum(String declined)
			throws Exception;

	@Deprecated
	/**
	 * 已过时，返回所有的记录数，没分页，返回《PatchInfo》
	 */
	public abstract List<PatchInfo> findAllPatchInfo() throws Exception;

	/**
	 * 推荐使用此方法，返回所有的记录数，分页显示，返回《PatchInfo》
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public abstract PageResult findAllPatchInfo(Page page) throws Exception;

	/**
	 * 返回所有的记录数，《PatchInfo》
	 * @return
	 * @throws Exception
	 */
	public abstract Integer findAllPatchInfoNum() throws Exception;

	@Deprecated
	/**
	 * 已过时，根据条件查询记录，返回《PatchUpdateInfo》
	 */
	public abstract List<PatchUpdateInfo> findAllByID(String computerID,
			String type, int[] states) throws Exception;

	/**
	 * 推荐使用此方法，根据条件分页显示，返回《PatchUpdateInfo》
	 * @param computerID
	 * @param type
	 * @param states
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public abstract PageResult findAllByID(String computerID, String type,
			int[] states, PMPage page) throws Exception;

	/**
	 * 返回条件返回总记录数，返回《PatchUpdateInfo》
	 * @param computerID
	 * @param type
	 * @param states
	 * @return
	 * @throws Exception
	 */
	public abstract Integer findAllByIDNum(String computerID, String type,
			int[] states) throws Exception;

}