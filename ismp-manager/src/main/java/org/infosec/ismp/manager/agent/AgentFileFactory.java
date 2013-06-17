package org.infosec.ismp.manager.agent;

import java.io.File;
import java.io.FileFilter;

import org.infosec.ismp.util.ThreadCategory;
import org.springframework.util.Assert;

/**
 * Singlon类
 * 
 * @author lianglin
 * 
 */
public class AgentFileFactory {
	private final File rootFile;
	private static AgentFileFactory factory;

	private AgentFileFactory(File rootFile) {
		this.rootFile = rootFile;
	}

	public  static AgentFileFactory getInstance() {
		if (factory == null) {
			throw new RuntimeException("AgentFileFactory没有初始化，请先初始化");
		}
		return factory;
	}
	
	public synchronized static void init(File rootFile){
		if(factory==null){
			log().info("AgentFileFactory初始化成功");
			factory = new AgentFileFactory(rootFile);
		}else{
			throw new RuntimeException("AgentFileFactory已经初始化，请勿重复初始化");
		}
	}
	
	protected String createAgentTempFileName(String agentId){
		return "agent_"+agentId+".ser";
	}
	
//	public File findAgentConfigFile(String agentId){
//		File[] files = rootFile.listFiles(new FileFilter(){
//
//			@Override
//			public boolean accept(File pathname) {
//				String name = pathname.getName();
//				if(name.startsWith("agent_")&&name.endsWith(".ser")){
//					return true;
//				}
//				return false;
//			}
//			
//		});
//		
//		for(File file :files){
//			String name = file.getName();
//			String fileName = createAgentTempFileName(agentId);
//			if(name.indexOf(fileName)>0){
//				return file;
//			}
//		}
//		return null;
//	}
	
	public File createAgentConfigFile(String agentId){
		checkInit();
		File file = new File(rootFile,createAgentTempFileName(agentId));
		if(file.exists()&&file.isDirectory()){
			System.out.println(rootFile+"目录下有同名文件夹"+file+",无法创建新的Agent文件");
			log().fatal(rootFile+"目录下有同名文件夹"+file+",无法创建新的Agent文件");
			System.exit(1);
		}
		return file;
	}
	
	private void checkInit(){
		Assert.state(rootFile!=null,"rootFile没有初始化，请检查");
	}
	
	static ThreadCategory log(){
		return ThreadCategory.getInstance(AgentFileFactory.class.getClass());
	}
}
