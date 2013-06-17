package edu.sjtu.infosec.ismp.manager.VPM.sd.comm;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import key.HashStr;

import org.apache.log4j.Logger;

import edu.sjtu.infosec.ismp.manager.VPM.sd.model.SoftwareInfo;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.container.BaseInfoManagerBO;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.container.SoftwareManagerBO;

/**  
 * @Title: FileProcessUtil.java
 * @Package edu.sjtu.infosec.ismp.center.virus.software.util
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-8-12 下午10:08:46   
 * @version V1.0  
 */
/**
 * @ClassName: FileProcessUtil
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-8-12 下午10:08:46
 * 
 */
public class FileProcessUtil {
	private static Logger logger = Logger.getLogger(FileProcessUtil.class);
	/**
	 * 指定转换的字符集
	 */
	private final static char[] HEX_CHAE = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	// /**
	// * main decription : TODO
	// *
	// * @param args
	// */
	public static void main(String[] args) {
		// // TODO Auto-generated method stub
		// String folderName = "C:\\manager";
		// System.out.println(getDispatchFileNamesByDir(folderName));
		// List<String> folders = new ArrayList<String>();
		// folders.add(folderName);
		// cleanFolderTrash(folders);
		// System.out.println(getFileNamesByDir(folderName, "xml"));
		// SimpleDateFormat dateFormat = new SimpleDateFormat(
		// "yyyy-mm-dd hh:mm:ss.sss");
		// System.out.println("=======" + dateFormat.format(new Date()));
		// String fileName = "c:\\test";
		// String hashType = "MD5";
		// StringBuffer md5 = new StringBuffer("");
		// System.out.println(hashType + " == "
		// + getHash(fileName, hashType, null));
		// // System.out.println("toHexString --> " +
		// toHexString(getHash(fileName,
		// // hashType).getBytes()));
		// System.out.println("=======" + dateFormat.format(new Date()));
		// md5.delete(0, md5.length());
		// System.out.println(hashType + " == "
		// + getHash(fileName, hashType, null));
		// hashType = "SHA1";
		// System.out.println(hashType + " == "
		// + getHash(fileName, hashType, null));
		// hashType = "SHA-256";
		// System.out.println(hashType + " == "
		// + getHash(fileName, hashType, null));
		// hashType = "SHA-384";
		// System.out.println(hashType + " == "
		// + getHash(fileName, hashType, null));
		// hashType = "SHA-512";
		// System.out.println(hashType + " == "
		// + getHash(fileName, hashType, null));

		// String fileAbsolutPath = "C://test//QQ2008.exe";
		// File file = new File(fileAbsolutPath);
		// int blockNum = getBlockNum(file.length());
		// FileOutputStream out = null;
		// try {
		// out = new FileOutputStream("c://parent//QQ2008.exe", true);
		// for (int i = 0; i < blockNum; i++) {
		// byte[] content = getSpecifyFileByte(fileAbsolutPath, i);
		// System.out.println(content.length);
		// out.write(content);
		// out.flush();
		// }
		// // out.close();
		// // String fileAbsolutPath = "C://parent//WinRAR_3.80_SC-PRET.xml";
		// // byte[] content =
		// getLittleFileByte("C://test//WinRAR_3.80_SC-PRET.xml");
		// // out = new FileOutputStream(fileAbsolutPath, false);
		// // out.write(content);
		// //out.flush();
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } finally {
		// if (out != null) {
		// try {
		// out.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }
		// createDirectory("D:/test");
		getSpecifiedFileParameter("c:\\manager","Eclipse_cvs.xml");
	}

	/**
	 * 
	 * checkDirectoryExist decription : 检测指定目录名是否存在
	 * 
	 * @param folderName
	 *            (如：C:\\folderName)
	 * @return
	 */
	public static boolean checkDirectoryExist(String folderName) {
		File file = new File(folderName);
		if (!file.exists()) {
			return false;
		}
		return file.isDirectory();
	}

	/**
	 * 
	 * createDirectory decription : 根据目录名创建相应的文件夹
	 * 
	 * @param folderName
	 *            文件夹绝对路径(如：C:\\folderName)
	 */
	public static void createDirectory(String folderName) {
		File file = new File(folderName);
		file.mkdir();
	}

	/**
	 * 
	 * getFileNamesByDir decription : 根据文件夹名和文件后缀名得到符合条件的所有不带后缀的文件名
	 * 
	 * @param folderName
	 *            文件夹绝对路径(如：C:\\folderName) 不可以为空
	 * @param suffixName
	 *            文件后缀名(如：xml或.xml) 可以为空(为空的情况是得到该文件夹下的所有不带后缀的文件名
	 * @return
	 */
	public static List<String> getFileNamesByDir(String folderName,
			String suffixName) {
		List<String> list = new ArrayList<String>();
		// 检测该文件夹是否存在
		if (!checkDirectoryExist(folderName)) {
			try {
				createDirectory(folderName);
			} catch (Exception e) {
			}
			return list;
		}
		// 得到文件夹
		File folder = new File(folderName);

		// 得到该文件夹下的所有文件名
		String[] fileNames = folder.list();
		// 文件名
		String fileName = null;
		// 文件名中"."的下标位置
		int index = 0;

		// 文件后缀名不为空的情况
		if (suffixName != null && suffixName.trim().length() > 0) {
			if (suffixName.indexOf(".") < 0) {
				// 后缀名没有包含"."的情况,添加"."后避免了后缀名在文件名的"."前面出现的情况
				suffixName = "." + suffixName;
			}
		}
		for (int i = 0; i < fileNames.length; i++) {
			// 得到每个文件名
			// System.out.println(fileNames[i]);
			fileName = fileNames[i];
			// 得到文件名中"."的下标位置
			index = fileName.indexOf(".");
			// 文件名中"."的下标位置小于0的情况（即：该文件为文件夹或者不规范的情况)
			if (index <= 0) {
				continue;
			}
			// 文件后缀名不为空的情况
			if (suffixName != null && suffixName.trim().length() > 0) {
				// 得到文件名中包含有该后缀名的位置
				index = fileName.indexOf(suffixName);
				// System.out.println(suffixName +" index :" + index);
				if (index <= 0) {
					continue;
				}
			}
			list.add(fileName.split(suffixName)[0]);
		}
		// System.out.println(list.size());
		return list;
	}

	/**
	 * 
	 * getDispatchFileNamesByDir decription : 根据文件夹名得到可以分发的所有不带后缀的文件名
	 * 
	 * @param folderName
	 *            文件夹绝对路径(如：C:\\folderName) 不可以为空
	 * @return
	 */
	public static List<String> getDispatchFileNamesByDir(String folderName) {
		List<String> list = new ArrayList<String>();
		// 检测该文件夹是否存在
		if (!checkDirectoryExist(folderName)) {
			try {
				createDirectory(folderName);
			} catch (Exception e) {
			}
			return list;
		}
		// 得到文件夹
		File folder = new File(folderName);

		// 得到该文件夹下的所有文件名
		String[] fileNames = folder.list();
		// 文件名
		String fileName = null;
		// 文件名中"."的下标位置
		int index = 0;

		// 文件后缀名
		String suffixName = ".xml";
		for (int i = 0; i < fileNames.length; i++) {
			// 得到每个文件名
			// System.out.println(fileNames[i]);
			fileName = fileNames[i];
			// 得到文件名中"."的下标位置
			index = fileName.indexOf(".");
			// 文件名中"."的下标位置小于0的情况（即：该文件为文件夹或者不规范的情况)
			if (index <= 0) {
				continue;
			}
			// 文件后缀名不为空的情况

			// 得到文件名中包含有该后缀名的位置
			index = fileName.indexOf(suffixName);
			// System.out.println(suffixName +" index :" + index);

			if (index == -1) {
				continue;
			}
			// validate检查
			if (!checkValidate(folderName, fileName)) {
				continue;
			}
			list.add((fileName.split(suffixName)[0]));
		}
		// System.out.println(list.size());
		// 清理不符合标准的文件
		// cleanDispatchFileNames(list,folderName);
		return list;
	}

	/**
	 * 
	 * checkValidate decription : 检验validate
	 * 
	 * @param folderName
	 *            文件夹名
	 * @param fileName
	 *            包含后缀名的文件名
	 * @return boolean
	 * 
	 */
	private static boolean checkValidate(String folderName, String fileName) {
		Boolean result = false;
		// xml文件中的validate
		String xmlValidate = getValidateFromXml(folderName, fileName);

		// xml文件中的validate为空的情况
		if (xmlValidate == null || xmlValidate.trim().length() <= 0) {
			return result;
		}
		// 处理后的validate
		String fileParameter = getSpecifiedFileParameter(folderName, fileName);
		// 得到正确处理的validate
		String validate = "";
		try {
			validate = HashStr.getHash(fileParameter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!validate.trim().equals("") && xmlValidate.equals(validate)) {
			result = true;
		}
		return result;
	}

	/**
	 * 此方法没有用
	 * getSpecifiedFileParameter decription : 根据软件信息对象得到相对应的需要加密的传入参数值
	 * 
	 * @param folderName
	 *            文件夹名
	 * @param fileName
	 *            包含后缀名的文件名
	 * @return String
	 * 
	 */
	public static String getSpecifiedFileParameter(String folderName,
			String fileName) {
		StringBuffer result = new StringBuffer("");
		if ((folderName == null || folderName.trim().length() <= 0)
				&& (fileName == null || fileName.trim().length() <= 0)) {
			return result.toString();
		}
		// 拼接绝对路径
		String absolutePath = folderName + File.separator + fileName;
		SoftwareManagerBO bo = XmlProcessUtil
				.getSoftwareManagerBOByXml(absolutePath);
		//return getHASHStr(bo);
		return null;
	}

	/**
	 * getHASHStr decription : 获得Hash 传入参数
	 * 
	 * @param SoftwareManagerBO
	 *            bo
	 * @return String
	 */
	public static String getHASHStr(SoftwareInfo softwareInfo ) {
		StringBuffer result = new StringBuffer("");
		if (softwareInfo == null ) {
			return result.toString();
		}
		if (softwareInfo.getType() != null) {
			result.append(softwareInfo.getType().trim());
		}
		result.append(";");
		if (softwareInfo.getTypeInfo().getName() != null) {
			result.append(softwareInfo.getTypeInfo().getName().trim());
		}
		result.append(";");
		if (softwareInfo.getId() != null) {
			result.append(softwareInfo.getId().toString().trim());
		}
		result.append(";");
		if (softwareInfo.getSize() != null) {
			result.append(softwareInfo.getSize());
		}
		result.append(";");
		if (softwareInfo.getUploadTime() != null) {
			result.append(softwareInfo.getUploadTime().toString().trim());
		}
		result.append(";");
		if (softwareInfo.getMD5() != null) {
			result.append(softwareInfo.getMD5().trim());
		}
		String temp = result.toString();
		if (temp.replace(";", "").trim().length() <= 0) {
			return "";
		} else {
			return result.toString();
		}
	}

	/**
	 * 
	 * getValidateFromXml decription : 得到xml文件中的validate
	 * 
	 * @param folderName
	 * @param fileName
	 * @return String
	 * 
	 */
	private static String getValidateFromXml(String folderName, String fileName) {
		String validate = "";
		if ((folderName == null || folderName.trim().length() <= 0)
				&& (fileName == null || fileName.trim().length() <= 0)) {
			return validate;
		}
		String absolutePath = folderName + File.separator + fileName;

		SoftwareManagerBO bo = XmlProcessUtil
				.getSoftwareManagerBOByXml(absolutePath);
		if (bo == null || bo.getBaseInfoManagerBO() == null
				|| bo.getBaseInfoManagerBO().getValidate() == null
				|| bo.getBaseInfoManagerBO().getValidate().trim().length() <= 0) {
			return validate;
		}
		validate = bo.getBaseInfoManagerBO().getValidate();
		return validate;
	}

	/**
	 * 
	 * deleteFileByAbsolutePath decription : 根据文件绝对路径删除文件或文件夹
	 * 
	 * @param absolutePath
	 *            ：文件或文件夹的绝对路径(如：C:\\test\\fileName.xml 或：C:\\test)
	 * @return
	 */
	public static boolean deleteFileByAbsolutePath(String absolutePath) {
		File file = new File(absolutePath);
		// 如果文件存在的情况下
		if (file.exists()) {
			return file.delete();
		} else {
			return true;
		}
	}

	/**
	 * 
	 * deleteFilebyAbsolutePaths decription : 删除指定的多个文件或者指定的文件夹
	 * 
	 * @param fileNames
	 *            需要删除的多个文件名(<C:\\test\\one.xml,C:\\test\\two.xml....>)
	 * @return 没有被删除的文件名列表
	 */
	public static List<String> deleteFilebyAbsolutePaths(List<String> fileNames) {
		// 没有删除掉的文件名集合
		List<String> notDeleteFileNames = new ArrayList<String>();
		// 需要删除的文件名List不为空的情况
		if (fileNames != null) {
			String fileName = null;
			// 循环文件名List
			for (int i = 0; i < fileNames.size(); i++) {
				// 得到每个文件名
				fileName = fileNames.get(i);
				// 没有删除的情况
				if (!deleteFileByAbsolutePath(fileName)) {
					// System.out.println(fileName);
					notDeleteFileNames.add(fileName);
				}
			}
		}
		// 返回没有删除的文件名列表
		return notDeleteFileNames;
	}

	/**
	 * 
	 * getHash decription :
	 * 得到需要文件的哈希算法值对下载的文件和原文件进行MD5一致性检查（对方可以判断下载的文件是否更改或传输正常）
	 * 
	 * @param fileName
	 *            文件的绝对路径(可以是文件夹得绝对路径)
	 * @param hashType
	 *            MD5 SHA-1 SHA-256 SHA-384 SHA-512
	 * @param md5
	 *            需要返回的字符串
	 * @return
	 * @throws Exception
	 */
	public static String getHash(String fileName, String hashType,
			StringBuffer md5) throws Exception {
		// 需要返回的字符串为空的情况
		if (md5 == null) {
			md5 = new StringBuffer("");
		}
		// 如果需要计算的算法为空的情况
		if (hashType == null) {
			hashType = "MD5";
		}
		// 根据文件名得到需要检查的文件
		File file = new File(fileName);
		// 如果文件为目录的情况下
		if (file.isDirectory()) {
			for (int i = 0; i < file.list().length; i++) {
				// 得到文件的绝对路径
				String tempFileName = fileName + File.separator + file.list()[i];
				// System.out.println(tempFileName);
				// 递归调用
				getHash(tempFileName, hashType, md5);
			}
		} else {
			// 文件是单个的文件时
			md5.append(getFileHash(fileName, hashType));
		}
		return md5.toString();
	}

	/**
	 * 
	 * getFileHash decription : 得到单个文件的Hash值
	 * 
	 * @param fileName
	 * @param hashType
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	private static String getFileHash(String fileName, String hashType)
			throws NoSuchAlgorithmException, IOException {
		// 根据文件名得到文件读出流
		InputStream fis = new FileInputStream(fileName);
		byte[] buffer = new byte[1024];
		// 得到md5信息摘要算法类
		MessageDigest md5 = MessageDigest.getInstance(hashType);
		int numRead = 0;
		while ((numRead = fis.read(buffer)) > 0) {
			// 使用指定的 byte 数组更新摘要
			md5.update(buffer, 0, numRead);
		}
		fis.close();
		// 通过执行操作完成哈希计算 并转换成字符串
		return toHexString(md5.digest());
	}

	/**
	 * 
	 * toHexString decription : 把完成的哈希计算结果转换成字符串
	 * 
	 * @param b
	 * @return
	 */
	private static String toHexString(byte[] b) {
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(HEX_CHAE[(b[i] & 0xf0) >>> 4]);
			sb.append(HEX_CHAE[b[i] & 0x0f]);
		}
		return sb.toString();
	}

	/**
	 * 
	 * getLittleFileByte decription : 当指定文件小于10M时,得到该文件的字节数组
	 * 
	 * @param fileAbsolutePath
	 * @return
	 */
	private static byte[] getLittleFileByte(String fileAbsolutePath) {
		// 根据文件的路径的得到文件
		File file = new File(fileAbsolutePath);
		// 指定路径的文件不存在的情况下
		if (!file.exists()) {
			return null;
		}
		// 得到文件读入流
		BufferedInputStream in = null;

		// 字节输出流
		ByteArrayOutputStream out = null;
		// 返回数组对象
		byte[] contents = new byte[(int) file.length()];
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			// 得到字节输出流
			out = new ByteArrayOutputStream(1024);
			// 得到临时的数组对象
			byte[] temp = new byte[contents.length];
			// 每次读入的大小
			int size = 0;
			// 把读入流写入到字节输出流中
			while ((size = in.read(temp)) != -1) {
				out.write(temp, 0, size);
			}
			out.flush();
			// 得到返回数组对象
			contents = out.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// 返回数组对象
		return contents;
	}

	/**
	 * 
	 * getSpecifyFileByte decription : 根据文件的绝对路径和分割的块位置得到文件的分割块处的字节流
	 * 
	 * @param fileAbsolutePath
	 *            原文件及完整路径
	 * 
	 * @param blockNum
	 *            当前块的位置
	 * @return
	 */
	public static byte[] getSpecifyFileByte(String fileAbsolutePath,
			Integer blockNum) {
		// 以只读方式得到指定路径的文件
		// 
		if (blockNum == null) {
			return getLittleFileByte(fileAbsolutePath);
		}
		// 根据文件的路径的得到文件
		File file = new File(fileAbsolutePath);
		if (!file.exists()) {
			return null;
		}
		// 得到文件的大小
		long fileSize = file.length();
		// 得到每个分割块的大小
		long blockSize = SoftwareProcessUtil.BLOCK_SIZE;

		// 得到需要得到的起始点
		long beginPoint = blockSize * (blockNum);

		// 得到终止点
		long lastPoint = blockSize * (blockNum + 1);
		if (lastPoint > fileSize) {
			lastPoint = fileSize;
		}
		// 返回数组对象
		byte[] contents = null;

		// 得到文件读入流
		RandomAccessFile in = null;

		// 得到字节输出流
		ByteArrayOutputStream out = null;
		try {
			// 得到文件读入流
			in = new RandomAccessFile(fileAbsolutePath, "r");
			// 设置读入起始点
			in.seek(beginPoint);
			// 得到字节输出流
			out = new ByteArrayOutputStream(1024);
			// 得到临时的数组对象
			byte[] temp = new byte[1024];

			// 临时变量,写过的字节数
			long readedSize = 0;

			// 临时变量,每次读入的字节数
			int readingSize = 0;

			// 循环读入文件流
			// 开始读入点加上已经读入点大于终止点的情况下终止循环
			while ((beginPoint + readedSize) < lastPoint) {
				// 读入到临时变量
				// 得到可以读入的大小
				readingSize = in.read(temp);
				// 开始读入点加上已经读入的大小加上现在读入的大小大于最终点时的情况
				if ((beginPoint + readedSize + readingSize) > lastPoint) {
					// 最后读入的大小
					readingSize = (int) (lastPoint - (beginPoint + readedSize));
				}
				// 写入Byte数组流
				out.write(temp, 0, readingSize);
				// 给已经读入的赋值
				readedSize += readingSize;
			}
			// 得到返回数组对象
			contents = out.toByteArray();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.flush();
					// 关闭文件写入流
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		// System.out.println(String.valueOf(contents));
		return contents;
	}

	/**
	 * 
	 * getBlockNum decription : 根据传进来的文件大小,决定文件的可分割数
	 * 
	 * @param fileSize
	 * @return
	 */
	public static int getBlockNum(long fileSize) {
		// 当文件等于0的情况
		if (fileSize == 0) {
			return 0;
		}
		// 当文件小于等于10M的情况
		if (fileSize <= SoftwareProcessUtil.BLOCK_SIZE) {
			return 1;
		}
		// 当文件大于等于10M的情况
		return (int) (fileSize / SoftwareProcessUtil.BLOCK_SIZE + 1);
	}

	/**
	 * 
	 * checkFileExist decription : 检测指定文件是否存在
	 * 
	 * @param absoultFileName
	 *            (如：C:\\folderName\\QQ.exe)
	 * @return
	 */
	public static boolean checkFileExist(String absoultFileName) {
		File file = new File(absoultFileName);
		boolean result = file.exists();
		file = null;
		return result;
	}

	/**
	 * 
	 * deletedSpecifyFile decription : 删除指定文件
	 * 
	 * @param absoultFileName
	 */
	public static void deletedSpecifyFile(String absoultFileName) {
		File file = new File(absoultFileName);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 
	 * cleanFolderTrash decription : 清理指定文件夹中的不合标准的多余文件
	 * 
	 * @param absoultFolders
	 */
	public static void cleanFolderTrash(List<String> absoultFolders) {
		if (absoultFolders == null || absoultFolders.isEmpty()) {
			return;
		}
		for (int i = 0; i < absoultFolders.size(); i++) {
			// 得到每一个需要清理的文件夹绝对路径
			String absoultFolder = absoultFolders.get(i);
			File file = new File(absoultFolder);
			if (!file.exists() || !file.isDirectory()) {
				continue;
			}
			String[] files = file.list();
			if (files == null || files.length <= 0) {
				continue;
			}
			// 需要删除的文件List
			List<String> deleteNames = new ArrayList<String>();
			// 可以分发的软件信息名列表
			List<String> dispatchNames = getDispatchFileNamesByDir(absoultFolder);
			Set<String> dispatchNameSet = new HashSet<String>(dispatchNames);

			for (int j = 0; j < files.length; j++) {
				// 得到当前的文件名
				String fileName = files[j];
				// 初始化
				int lastIndex = fileName.length();
				if (fileName.indexOf(".") != -1) {
					lastIndex = fileName.lastIndexOf(".");
				}
				String prefixName = fileName.substring(0, lastIndex);
				// 分发文件集合中不包含当前软件的文件名时
				if (!dispatchNameSet.contains(prefixName)) {
					deleteNames.add(absoultFolder + File.separator + fileName);
				}
			}
			for (int m = 0; m < deleteNames.size(); m++) {
				File deleteFile = new File(deleteNames.get(m));
				deleteFile.delete();
				// System.out.println("deleteFileName = " + deleteFile.getName()
				// + " deleted = " + deleteFile.delete());
			}

		}
	}

	private static List<String> cleanDispatchFileNames(
			List<String> dispatchNames, String absoultFolderName) {
		List<String> result = new ArrayList<String>();
		// 需要传输的参数为空或者需要清理的list为空的情况
		if (dispatchNames == null || dispatchNames.isEmpty()
				|| absoultFolderName == null
				|| absoultFolderName.trim().length() <= 0) {
			return result;
		}
		// 检验文件是不是文件夹
		if (!checkDirectoryExist(absoultFolderName)) {
			return result;
		}
		File folder = new File(absoultFolderName);
		String[] files = folder.list();
		// 文件夹中的文件为空时
		if (files == null || files.length <= 0) {
			return result;
		}
		Set<String> fileSet = new HashSet<String>();
		// 把文件夹中的所有文件名加入到set中
		for (int i = 0; i < files.length; i++) {
			String fileName = files[i];
			if (fileName != null && fileName.trim().length() >= 0) {
				fileSet.add(fileName);
			}
		}

		// 需要删除的文件List
		List<String> deleteNames = new ArrayList<String>();
		for (int i = 0; i < dispatchNames.size(); i++) {
			String fileName = dispatchNames.get(i);
			// 得到xml文件的绝对路径
			String xmlFileName = absoultFolderName + File.separator + fileName + ".xml";
			// 根据xml文件的绝对路径得到软件信息
			SoftwareManagerBO softwareManagerBO = XmlProcessUtil
					.getSoftwareManagerBOByXml(xmlFileName);
			if (softwareManagerBO == null) {
				deleteNames.add(fileName);
				continue;
			}
			// 根据软件信息得到软件的基本信息
			BaseInfoManagerBO baseInfoBO = softwareManagerBO
					.getBaseInfoManagerBO();
			// 软件基本信息为空的情况
			if (baseInfoBO == null) {
				deleteNames.add(fileName);
				continue;
			}
			// 根据软件基本信息的得到软件名
			String softwareName = baseInfoBO.getName();
			// 软件名为空的情况
			if (softwareName == null || softwareName.trim().length() <= 0) {
				deleteNames.add(fileName);
				continue;
			}
			// 当前文件夹中不包含软件xml信息中对应的软件名时
			if (!fileSet.contains(softwareName)) {
				deleteNames.add(fileName);
				continue;
			}

			// // validate检查不一致的情况
			// if (!checkValidate(absoultFolderName, (fileName+".xml"))) {
			// deleteNames.add(fileName);
			// }
		}
		// 删除不符合标准的软件名
		dispatchNames.removeAll(deleteNames);
		return dispatchNames;
	}
	/**
	 * 
	 * syncDispatchFolder
	 *      decription : 同步清除父目录中的可分发文件列表
	 * @param softwareInfo
	 * @param absoultFolderName
	 * void
	 *
	 */
	public static void syncDispatchFolder(String absoultFolderName){
		// 检验文件是不是文件夹
		if (!checkDirectoryExist(absoultFolderName)) {
			return ;
		}
		File parentFolder = new File(absoultFolderName);
		String[] files = parentFolder.list();
		// 文件夹中的文件为空时
		if (files == null || files.length <= 0) {
			return ;
		}
		deletFiles(absoultFolderName,files);
	}
	
	/**
	 * 
	 * syncDispatchFolder
	 *      decription : 同步清除父目录中的可分发文件列表
	 * @param softwareInfo
	 * @param absoultFolderName
	 * void
	 *
	 */
	public static void syncDispatchFolder(String softwareInfo,String absoultFolderName) {
		
		// 检验文件是不是文件夹
		if (!checkDirectoryExist(absoultFolderName)) {
			return ;
		}
		File parentFolder = new File(absoultFolderName);
		String[] files = parentFolder.list();
		// 文件夹中的文件为空时
		if (files == null || files.length <= 0) {
			return ;
		}
		// 需要下载的软件信息为空的情况
		if(softwareInfo == null || softwareInfo.trim().length() <= 0) {
			deletFiles(absoultFolderName,files);
		}
		Set<String> names = getSoftAndXmlNameByInfos(softwareInfo);
		// 分割处理的结果
		if (names == null || names.isEmpty()) {
			deletFiles(absoultFolderName,files);
		}
		for(int i =0; i < files.length ;i ++){
			String fileName = files[i].trim();
			if(!names.contains(fileName)){
				File deleteFile = new File(absoultFolderName+File.separator+fileName);
				deleteFile.delete();
			}
		}
	}

	/**
	 * getSoftAndXmlNameByInfos
	 *      decription : TODO
	 * @param tempInfos
	 * void
	 * 
	 */
	private static Set<String> getSoftAndXmlNameByInfos(String  softwareInfo) {
		// 服务器端传来的可下载的软件列表信息Map<软件名,String[软件大小,上传时间]>
		String[] tempInfos = softwareInfo.split(";");
		
		// 远程服务器中可以下载的软件信息名集合,包含有软件的.xml文件
		Set<String> names = new HashSet<String>();
		// 对分割的结果集进行循环 name:xxx&size:12312&uploadTime:2009-11-19 00:30:30.812;
		for (int i = 0; i < tempInfos.length; i++) {
			// 得到每个可以下载的Xml的详细信息
			// name:xxx&size:12312&updateTime:2009-11-19 00:30:30.812;
			String definiteInfos = tempInfos[i];
			if (definiteInfos == null || definiteInfos.trim().length() <= 0) {
				continue;
			}
			// 把得到的单个xml详细信息以&分割
			String[] definiteInfo = definiteInfos.split("&");
			if (definiteInfo == null || definiteInfo.length < 1) {
				continue;
			}
			// 得到软件名name:xxx
			String nameStr = definiteInfo[0];
			if(nameStr == null) {
				continue;
			}
			nameStr = nameStr.substring(nameStr.indexOf(":") + 1, nameStr
					.length());
			names.add(nameStr.trim());
			// 得到该软件对应的xml文件名
			int index = nameStr.lastIndexOf(".");
			String xmlNameStr = null;
			if(index == -1){
				xmlNameStr = nameStr.trim() +".xml";
			}else{
				xmlNameStr = nameStr.substring(0,index).trim()+".xml";
			}
			names.add(xmlNameStr);			
		}
		return names;
	}

	/**
	 * deletFiles
	 *      decription : TODO
	 * @param files
	 * void
	 * 
	 */
	private static void deletFiles(String absoultFolderName, String[] files) {
		for (int m = 0; m < files.length; m++) {
			File deleteFile = new File(absoultFolderName + File.separator + files[m]);
			
			if(deleteFile.exists()) {
				forceDelete(deleteFile);
			}
			
		}
	}
	/**
	 * try to delete given file , try 10 times
	 * 
	 * @param f
	 * @return true if file deleted success, nor false;
	 */
	public static boolean forceDelete(File f) {
		if(!f.exists()){
			return true;
		}
		boolean result = false;
		int tryCount = 0;
		while (!result && tryCount++ < 10) {
			logger.debug("try to delete file " + f.getName() + " cnt:"
					+ tryCount);
			System.gc();
			result = f.delete();
			if(result){
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
