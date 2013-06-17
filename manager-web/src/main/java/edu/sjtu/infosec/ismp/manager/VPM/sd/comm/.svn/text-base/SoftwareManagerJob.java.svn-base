package edu.sjtu.infosec.ismp.manager.VPM.sd.comm;

import java.util.List;

/**  
 * @Title: SoftwareManagerJob.java
 * @Package edu.sjtu.infosec.ismp.manager.virus.software.job
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-9-1 下午03:32:12   
 * @version V1.0  
 */
/**
 * @ClassName: SoftwareManagerJob
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-9-1 下午03:32:12
 *
 */
public class SoftwareManagerJob {
	/**
	 * 需要定时清理的文件夹路径集合
	 */
	private List<String> absoultFolders;
	/**
	 * @param vAbsoultFolders the absoultFolders to set
	 */
	public void setAbsoultFolders(List<String> vAbsoultFolders) {
		absoultFolders = vAbsoultFolders;
	}

	/**
	 * 
	 * cleanFolderTrashJob
	 *      decription : 定时清理工作
	 */
	public void cleanFolderTrashJob(){
		FileProcessUtil.cleanFolderTrash(absoultFolders);
	}
}
