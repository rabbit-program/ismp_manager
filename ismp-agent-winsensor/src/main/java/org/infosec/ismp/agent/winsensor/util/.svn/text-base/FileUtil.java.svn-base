package org.infosec.ismp.agent.winsensor.util;

import java.io.File;

import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * @author Rocky
 * @version create time：Nov 15, 2010 2:35:18 PM
 * 
 */
public class FileUtil {
	
	public void printAllFileName(String path, String prefix, String suffix) {
		File file = new File(path);
		if (file.exists() && file.isDirectory()) {
			String[] fileNames = file.list(new SuffixFileFilter(".jar"));
			for (int i = 0; i < fileNames.length; i++) {
				System.out.print(prefix + fileNames[i] + suffix);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileUtil fileUtil = new FileUtil();
		fileUtil.printAllFileName("D:\\ismp-manager2\\lib", "lib/", ";");
//		fileUtil.printAllFileName(args[0], args[1], args[2]);
	}

}
