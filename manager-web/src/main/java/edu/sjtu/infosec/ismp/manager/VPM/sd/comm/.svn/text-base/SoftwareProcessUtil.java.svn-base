package edu.sjtu.infosec.ismp.manager.VPM.sd.comm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import edu.sjtu.infosec.ismp.manager.VPM.sd.model.container.BaseInfoManagerBO;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.container.SoftwareManagerBO;

/**  
 * @Title: SoftwareProcessUtil.java
 * @Package edu.sjtu.infosec.ismp.manager.virus.software.util
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-8-24 下午10:52:50   
 * @version V1.0  
 */
/**
 * @ClassName: SoftwareProcessUtil
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-8-24 下午10:52:50
 * 
 */
public class SoftwareProcessUtil {
	private static Logger logger = Logger.getLogger(SoftwareProcessUtil.class);

	public static void main(String[] args) {
		// System.out.println(splitString("CXDOEER LENGTH:324 ", "LENGTH"));
		// System.out.println(HTTP_HEAD_GET_INFO.getBytes().length);
		// System.out.println("Get HTTP/1.1  ".getBytes().length);
		// String str = null;
		// str = "asdf新建文本文件sadf.txt";
		// String res = null;
		// try {
		// res = getStringFromByteArray(str.getBytes("UTF-8"));
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println(res);
	}

	/**
	 * HTTP Get 头信息(14byte)
	 */
	public static final String HTTP_HEAD_GET_INFO = "Get HTTP/1.1 \r\n\r\n ";

	/**
	 * CLOSE SOCKET HTTP Get头信息
	 */
	public static final String HTTP_HEAD_CLOSE_SOCKET = "CLOSE SOCKET";
	
	/**
	 * CLEAN FOLDER HTTP Get头信息
	 */
	public static final String HTTP_HEAD_CLEAN_FOLDER = "CLEAN FOLDER";
	/**
	 * CONTINUE FOR HTTP Get头信息
	 */
	public static final String HTTP_HEAD_CONTINUE_FOR = "CONTINUE FOR";
	/**
	 * BREAK FOR HTTP Get头信息
	 */
	public static final String HTTP_HEAD_BREAK_FOR = "BREAK FOR";

	/**
	 * Server Socket端的通信阻塞时间
	 */
	public static final int SERVER_SOCKET_TIME_OUT = 30000;

	/**
	 * Client Socket端的通信阻塞时间
	 */
	public static final int CLIENT_SOCKET_TIME_OUT = 3 * 60 * 1000;

	/**
	 * 对文件进行分割的每块的大小 : 30K
	 */
	public static final int BLOCK_SIZE = 30 * 1024;

	/**
	 * Socket inputStream 每次文件流传输的数组长度
	 */
	public static final int SOCKET_INPUT_ARRAY_LENGTH = 1024 + HTTP_HEAD_GET_INFO
			.getBytes().length;

	/**
	 * 
	 * spliceHttpHeadInfo decription : 拼接请求的HTTP头信息 :Get HTTP/1.1
	 * 
	 * @return
	 */
	public static byte[] spliceRequestHttpHeadInfo() {
		return addByte(HTTP_HEAD_GET_INFO);
	}

	/**
	 * 
	 * spliceDownloadLengthHeadInfo decription : 拼接下次下载长度的响应头信息
	 * 
	 * @param size
	 * @return
	 */
	public static byte[] spliceDownloadLengthHeadInfo(int size) {

		return addByte(HTTP_HEAD_GET_INFO + "LENGTH:" + size);
	}

	/**
	 * 
	 * spliceDownloadNameHeadInfo decription : 拼接下载文件名的请求头信息
	 * 
	 * @param downloadSize
	 * @return
	 */
	public static byte[] spliceDownloadNameHeadInfo(String downloadName) {
		return addByte(HTTP_HEAD_GET_INFO + "NAME:" + downloadName);
	}

	/**
	 * 
	 * spliceCloseSocketHeadInfo decription : 拼接关闭Socket的HTTP请求头信息
	 * 
	 * @return
	 */
	public static byte[] spliceCloseSocketHeadInfo() {
		return addByte(HTTP_HEAD_GET_INFO + HTTP_HEAD_CLOSE_SOCKET);
	}

	/**
	 * 
	 * spliceContinueForHeadInfo decription : 拼接跳出循环的HTTP请求头信息
	 * 
	 * @return
	 */
	public static byte[] spliceContinueForHeadInfo() {
		return addByte(HTTP_HEAD_GET_INFO + HTTP_HEAD_CONTINUE_FOR);
	}

	/**
	 * 
	 * spliceBreakForHeadInfo decription : 拼接终止循环的HTTP请求头信息
	 * 
	 * @return
	 */
	public static byte[] spliceBreakForHeadInfo() {
		return addByte(HTTP_HEAD_GET_INFO + HTTP_HEAD_BREAK_FOR);
	}
	/**
	 * 
	 * spliceCleanFolderForHeadInfo decription : 拼接清空父目录中所有软件的HTTP请求头信息
	 * 
	 * @return
	 */
	public static byte[] spliceCleanFolderForHeadInfo(){
		return addByte(HTTP_HEAD_GET_INFO + HTTP_HEAD_CLEAN_FOLDER);
	}
	/**
	 * 
	 * addByte decription : 给不足socket 每次传输的数组长度的字符添加到每次传输的数组长度个字节数
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] addByte(String str) {
		byte[] result = new byte[SOCKET_INPUT_ARRAY_LENGTH];
		byte[] temp = null;
		try{
			temp = str.getBytes("UTF-8");
		}catch(Exception e) {
			logger.error(e);
		}
		for (int i = 0; i < result.length; i++) {
			if (i < temp.length) {
				result[i] = temp[i];
			} else {
				result[i] = ' ';
			}
		}
		return result;
	}

	/**
	 * 
	 * getHTTPHeadLength decription : 得到头信息长度
	 * 
	 * @return
	 */
	public static int getHTTPHeadLength() {
		return HTTP_HEAD_GET_INFO.getBytes().length;
	}

	/**
	 * 
	 * splitString decription : 截取split字符串后面的字符串 如:(Get HTTP/1.1 NAME:QQ.exe
	 * 调用此方法后为 QQ.exe)
	 * 
	 * @param request
	 * @param split
	 * @return
	 */
	public static String splitString(String request, String split) {
		// 请求分割的参数和分割符为空的情况
		if (request == null || request.trim().length() <= 0 || split == null) {
			return null;
		}
		int startIndex = request.indexOf(split + ":") + split.length() + 1;
		return request.substring(startIndex, request.length()).trim();
	}

	/**
	 * 
	 * getNameIsInDownloadMap decription : 查看需要下载的文件或文件的xml文件是否在可以下载的软件列表中
	 * 
	 * @param softwareName
	 *            需要下载的软件或软件的xml文件名
	 * @param downloads
	 *            可以下载的软件列表
	 * @return
	 */
	public static boolean getNameIsInDownloadMap(String softwareName,
			Map<String, Long> downloads) {
		// 如果需要查找的软件名为空,或可以下载的软件名为空的情况
		if (softwareName == null || softwareName.indexOf(".") == -1
				|| downloads == null || downloads.isEmpty()) {
			return false;
		}
		// 得到所有可以下载的软件名
		Set<String> nameSet = downloads.keySet();

		Iterator<String> nameIte = nameSet.iterator();
		String name = null;
		// 返回结果
		boolean result = false;
		while (nameIte.hasNext()) {
			// 得到软件名
			name = nameIte.next();
			// 软件名为空或者软件名中没有包含.的情况
			if (name == null || name.trim().length() <= 0
					|| name.indexOf(".") == -1) {
				continue;
			}
			// 得到去除最后一个"."后面字符的新字符串
			name = name.substring(0, name.lastIndexOf("."));
			// 如果去除需要比较的软件名去除"."后面的字符串和得到的可以下载的软件名去"."后面字符的字符串一致的情况，就说明该文件可以下载
			if (softwareName.substring(0, softwareName.lastIndexOf("."))
					.equals(name)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * 
	 * getNameAndLengthMap decription : 根据需要下载的软件信息得到软件名和软件大小的Map
	 * 
	 * @param downloadInfos
	 * @return
	 */
	public static Map<String, Long> getNameAndLengthMap(byte[] downloadInfos) {
		// 需要解析的参数为空的情况
		if (downloadInfos == null || downloadInfos.length <= 0) {
			return null;
		}
		// 初始化返回结果
		Map<String, Long> result = new HashMap<String, Long>();
		// 转换成字符串
		String info = null;
		try {
			info = new String(downloadInfos, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			logger
					.info("ERR HAPEN AT  SoftwareProcessUtil.getNameAndLengthMap : new String(downloadInfos,UTF-8);");
		}
		if (info == null) {
			return result;
		}
		// 以分号分隔
		String[] nameAndLengths = info.split(";");
		// 当需要下载的软件名和软件大小为空时
		if (nameAndLengths == null || nameAndLengths.length <= 0) {
			return null;
		}
		for (int i = 0; i < nameAndLengths.length; i++) {
			// 得到每一个名字和大小的组合：name:xxx.exe&size:123213
			String nameAndLength = nameAndLengths[i];
			// 得到以"&"分割后的字符串组
			String[] temp = nameAndLength.split("&");
			// 得到文件名name:xxx.exe
			String nameStr = temp[0];
			// 得到文件大小size:123213
			String sizeStr = temp[1];
			// 如果软件名和软件大小为空的情况
			if (nameStr == null || sizeStr == null
					|| sizeStr.trim().length() <= 0) {
				continue;
			}
			nameStr = nameStr.substring(nameStr.indexOf(":") + 1, nameStr
					.length());
			sizeStr = sizeStr.substring(sizeStr.indexOf(":") + 1, sizeStr
					.length());
			// 如果软件名和软件大小为空的情况
			if (nameStr == null || sizeStr == null
					|| sizeStr.trim().length() <= 0) {
				continue;
			}
			// 得到文件大小
			Long size = new Long(sizeStr.trim());

			// 把软件名和软件大小设置到返回结果Map中
			result.put(nameStr.trim(), size);
		}
		// 如果需要返回的结果为空的情况
		if (result.isEmpty()) {
			return null;
		}
		return result;
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
		if (fileSize <= BLOCK_SIZE) {
			return 1;
		}
		// 当文件大于等于10M的情况
		return (int) (fileSize / BLOCK_SIZE + 1);
	}

	/**
	 * 
	 * processSoftwareInfos decription :
	 * 根据服务器传来的可下载软件,和本地父目录中的所有软件得到本地当前可以下载的软件信息集合
	 * 
	 * @param softwareInfos
	 *            如:name:xxx&size:12312&updateTime:2009-11-19
	 *            00:30:30.812;name:xxx&size:12312&updateTime:2009-11-19
	 *            00:30:30.812;
	 * @param softwareBOs
	 * @return Map<String,Long>
	 * 
	 */
	public static Map<String, Long> processSoftwareInfos(String softwareInfos,
			List<SoftwareManagerBO> softwareBOs) {
		Map<String, String[]> downloadInfos = processSoftwareInfos(softwareInfos);

		return getDownloadSoftwareInfos(downloadInfos, softwareBOs);

	}

	/**
	 * 
	 * getDownloadSoftwareInfos decription :
	 * 根据服务器传来的可下载软件信息和本地父目录中的所有软件得到本地当前可以下载的软件信息集合
	 * 
	 * @param downloadInfos
	 * @param softwareBOs
	 * @return Map<String,Long>
	 * 
	 */
	private static Map<String, Long> getDownloadSoftwareInfos(
			Map<String, String[]> downloadInfos,
			List<SoftwareManagerBO> softwareBOs) {
		// 没有可以下载的软件信息的情况
		if (downloadInfos == null || downloadInfos.isEmpty()) {
			return null;
		}
		// 本地父目录中的没有软件时的情况
		if (softwareBOs == null || softwareBOs.isEmpty()) {
			return parentFolderIsNull(downloadInfos);
		}
		// 返回值
		Map<String, Long> result = new HashMap<String, Long>();
		// 根据本地父目录中的软件信息集合得到相对应的map<软件名,软件创建时间>
		Map<String, String> localParentSofts = getLocalParentFolderSoftwares(softwareBOs);
		// 服务器传来的可以下载的软件信息名
		Iterator<String> nameIter = downloadInfos.keySet().iterator();
		while (nameIter.hasNext()) {
			// 服务器上的软件名
			String name = nameIter.next();
			// 软件大小和创建时间
			String[] sizeAndUploadTime = downloadInfos.get(name);
			if (sizeAndUploadTime == null || sizeAndUploadTime.length <= 0) {
				continue;
			}
			// 服务器上的软件大小
			String sizeStr = sizeAndUploadTime[0];
			// 服务器上的软件时间
			String uploadTime = sizeAndUploadTime[1];
			// 本地父文件夹中的软件创建时间
			String uploadTimeTemp = localParentSofts.get(name);
			// 根据文件名得到的软件创建时间不为空,并且软件创建时间相同的情况就说明该父目录中的该软件和服务器上的一致
			if (uploadTimeTemp != null
					&& uploadTime.equals(uploadTimeTemp.trim())) {
				continue;
			}

			try {
				result.put(name, new Long(sizeStr.trim()));
			} catch (Exception e) {
				logger.error(e);
				logger
						.info("ERR HAPPEN AT SoftwareProcessUtil.getDownloadSoftwareInfos : result.put(name, new Long(sizeStr.trim()))");
			}

		}
		return result;
	}

	/**
	 * 
	 * getLocalParentFolderSoftwares decription :
	 * 根据本地父目录中的软件信息集合得到相对应的map<软件名,软件创建时间>
	 * 
	 * @param softwareBOs
	 * @return Map<String,String>
	 * 
	 */
	private static Map<String, String> getLocalParentFolderSoftwares(
			List<SoftwareManagerBO> softwareBOs) {
		Map<String, String> locals = new HashMap<String, String>();
		if (softwareBOs == null || softwareBOs.isEmpty()) {
			return null;
		}
		for (int i = 0; i < softwareBOs.size(); i++) {
			SoftwareManagerBO managerBo = softwareBOs.get(i);
			if (managerBo == null) {
				continue;
			}
			BaseInfoManagerBO baseManagerBo = managerBo.getBaseInfoManagerBO();
			String softwareName = baseManagerBo.getName();
			String uploadTime = baseManagerBo.getUploadTime();
			if (softwareName == null || softwareName.trim().length() <= 0) {
				continue;
			}
			softwareName = softwareName.trim();
			if (uploadTime == null) {
				uploadTime = "";
			}
			locals.put(softwareName, uploadTime.trim());
		}
		return locals;
	}

	/**
	 * parentFolderIsNull decription : 本地父目录中的没有软件时的情况
	 * 
	 * @param downloadInfos
	 *            : Map<软件名,String[软件大小,软件创建时间]>
	 * @param softwareBOs
	 *            void
	 * 
	 */
	private static Map<String, Long> parentFolderIsNull(
			Map<String, String[]> downloadInfos) {
		Map<String, Long> result = new HashMap<String, Long>();

		Set<String> softNames = downloadInfos.keySet();
		Iterator<String> softNameIters = softNames.iterator();
		while (softNameIters.hasNext()) {
			String softName = (String) softNameIters.next();
			String[] sizeAndUploadTime = downloadInfos.get(softName);
			if (sizeAndUploadTime == null || sizeAndUploadTime.length <= 0) {
				continue;
			}
			String sizeStr = sizeAndUploadTime[0];
			try {
				result.put(softName, new Long(sizeStr.trim()));
			} catch (Exception e) {
				logger.error(e);
				logger
						.info("ERR HAPPEN AT SoftwareProcessUtil.parentFolderIsNull : result.put(softName, new Long(sizeStr.trim()))");
			}
		}
		return result;
	}

	/**
	 * 
	 * processSoftwareInfos decription : 根据服务器传来的可下载软件信息得到软件名,和软件大小,软件创建时间的集合
	 * 
	 * @param downloadSoftwareInfos
	 * @return Map<String,String[]> :Map<软件名,String[软件大小,软件创建时间]>
	 * 
	 */
	private static Map<String, String[]> processSoftwareInfos(
			String downloadSoftwareInfos) {
		// 服务器端传来的可下载的软件列表信息Map<软件名,String[软件大小,上传时间]>
		String[] tempInfos = downloadSoftwareInfos.split(";");
		Map<String, String[]> result = new HashMap<String, String[]>();
		// 分割处理的结果
		if (tempInfos == null || tempInfos.length <= 0) {
			return null;
		}
		// 对分割的结果集进行循环 name:xxx&size:12312
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
			// 得到文件大小size:123213
			String sizeStr = definiteInfo[1];
			// 得到软件的创建时间
			String uploadTimeStr = definiteInfo[2];

			// 如果软件名和软件大小为空的情况
			if (nameStr == null || sizeStr == null
					|| sizeStr.trim().length() <= 0) {
				continue;
			}
			nameStr = nameStr.substring(nameStr.indexOf(":") + 1, nameStr
					.length());
			sizeStr = sizeStr.substring(sizeStr.indexOf(":") + 1, sizeStr
					.length());
			uploadTimeStr = uploadTimeStr.substring(
					uploadTimeStr.indexOf(":") + 1, uploadTimeStr.length());
			// 如果软件名和软件大小为空的情况
			if (nameStr == null || nameStr.trim().length() <= 0
					|| sizeStr == null || sizeStr.trim().length() <= 0) {
				continue;
			}
			String[] temp = new String[2];
			temp[0] = sizeStr.trim();
			temp[1] = uploadTimeStr.trim();
			// 加入需要返回的结果集合中
			result.put(nameStr.trim(), temp);
		}
		return result;
	}

	// /**
	// *
	// * processSoftwareInfos decription :
	// * 把服务器传来的可以下载的软件数据信息和本地的已经下载的软件信息进行比较，得出可以下载的软件信息
	// *
	// *
	// * @param softwareInfos
	// * 如：name:xxx&size:12312;name: xxx&size:12312;...
	// * @return
	// * @throws SoftwareManagerException
	// */
	// public static Map<String, Long> processSoftwareInfos(String
	// softwareInfos,
	// List<String> prefixnames) throws SoftwareManagerException {
	// // 如果输入的需要处理的字符串为空的情况
	// if (softwareInfos == null || softwareInfos.trim().length() < 0) {
	// return null;
	// }
	// // // 得到本地软件分发父文件夹中的所有xml的名字
	// // List<String> names = softwareManagerService
	// // .getAllSoftwareNames(parentFolderAbsolutePath);
	//
	// // 对需要处理的字符串以分号分割
	// String[] tempInfos = softwareInfos.split(";");
	// // 分割处理的结果
	// if (tempInfos == null || tempInfos.length <= 0) {
	// return null;
	// }
	// // 初始化需要返回的结果
	// Map<String, Long> result = new HashMap<String, Long>();
	//
	// // 临时存储变量
	// List<String> softwareNames = new ArrayList<String>();
	//
	// // 对分割的结果集进行循环 name:xxx&size:12312
	// for (int i = 0; i < tempInfos.length; i++) {
	// // 得到每个可以下载的Xml的详细信息
	// // name:xxx&size:12312;
	// String definiteInfos = tempInfos[i];
	// if (definiteInfos == null || definiteInfos.trim().length() <= 0) {
	// continue;
	// }
	// // 把得到的单个xml详细信息以&分割
	// String[] definiteInfo = definiteInfos.split("&");
	// if (definiteInfo == null || definiteInfo.length < 1) {
	// continue;
	// }
	// // 得到软件名name:xxx
	// String nameStr = definiteInfo[0];
	// // 得到文件大小size:123213
	// String sizeStr = definiteInfo[1];
	// // 如果软件名和软件大小为空的情况
	// if (nameStr == null || sizeStr == null
	// || sizeStr.trim().length() <= 0) {
	// continue;
	// }
	// nameStr = nameStr.substring(nameStr.indexOf(":") + 1, nameStr
	// .length());
	// sizeStr = sizeStr.substring(sizeStr.indexOf(":") + 1, sizeStr
	// .length());
	// // 如果软件名和软件大小为空的情况
	// if (nameStr == null || sizeStr == null
	// || sizeStr.trim().length() <= 0) {
	// continue;
	// }
	// // 加入临时比较变量集合中
	// softwareNames.add(nameStr);
	// // 加入需要返回的结果集合中
	// result.put(nameStr, new Long(sizeStr.trim()));
	// }
	// // 如果需要下载的软件集合为空的情况
	// if (result.isEmpty()) {
	// return null;
	// }
	// // 本地父目录里的软件信息列表为空的情况
	// if (prefixnames == null || prefixnames.isEmpty()) {
	// return result;
	// }
	//
	// // 循环本地的父文件夹中的所有xml文件名
	// for (int i = 0; i < prefixnames.size(); i++) {
	// // 得到本地父目录中不含后缀名的文件名
	// String prefixname = prefixnames.get(i);
	//
	// // 循环服务器端可以下载的软件信息列表
	// for (int j = 0; j < softwareNames.size(); j++) {
	// // 得到可以下载的文件名
	// String softwareName = softwareNames.get(j);
	// // 可以下载的文件名中没有后缀名的情况"."
	// if (softwareName.lastIndexOf(".") == -1) {
	// // 文件名不符合标准的情况下
	// result.remove(softwareName);
	// continue;
	// }
	// // 如果本地父目录中的软件前缀名和服务器可以下载的软件的前缀名一致的情况
	// if (prefixname.equals(softwareName.substring(0, softwareName
	// .lastIndexOf(".")))) {
	// result.remove(softwareName);
	// break;
	// }
	// }
	// }
	// // 可以下载的软件信息为空的情况
	// if (result.isEmpty()) {
	// return null;
	// }
	// // 返回可以下载的软件名
	// return result;
	// }
	/**
	 * 
	 * addInputByte decription : 给需要传递的文件信息加上伪HTTP头信息
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] addInputHeadInfo(byte[] infos) {
		// 需要传递的文件信息为空的情况
		if (infos == null) {
			return null;
		}
		// 得到默认的头信息
		byte[] headByte = HTTP_HEAD_GET_INFO.getBytes();
		// 初始化需要返回的信息
		byte[] result = new byte[headByte.length + infos.length];
		for (int i = 0; i < result.length; i++) {
			if (i < headByte.length) {
				result[i] = headByte[i];
			} else {
				result[i] = infos[i - headByte.length];
			}
		}
		// System.out.println("headByte : infos : result = " + headByte.length
		// + " : " + infos.length + " : " + result.length + " = "
		// + (headByte.length + infos.length));
		return result;
	}

	/**
	 * 
	 * getInputStreamByte decription : 从Socket inputStream中得到去除头信息的字节数组
	 * 
	 * @param in
	 * @param byteSize
	 *            需要读取的包含头信息的字节流的长度
	 * @return
	 * @throws Exception
	 */
	public static byte[] getInputStreamByte(InputStream input, Integer byteSize)
			throws Exception {
		// 设置已经读取数从去头信息开始
		int readed = 0; // 已经读取数
		// 头信息长度
		int headSize = HTTP_HEAD_GET_INFO.getBytes().length;
		// 初始化需要返回的数组
		byte[] result = new byte[byteSize - headSize];

		byte[] temp = new byte[byteSize];

		int available = 0; // 可读数
		// 休眠时间
		int timeOut = 0;
		while (readed < byteSize) {
			timeOut = 0;
			while (available == 0) {
				// 等到有数据可读
				available = input.available(); // 可读数
				if (available == 0) {
					timeOut++;
					if (timeOut >= 60) {
						throw new Exception("软件分发,没有可读数据,SOCKET 数据读取超时异常!");
					}
					Thread.sleep(1000);

				}
			}
			if (available > (byteSize - readed)) {
				available = byteSize - readed; // 剩余数
			}
			byte[] buffer = new byte[available];
			int reading = input.read(buffer);
			for (int n = 0; n < reading; n++) {
				temp[readed + n] = buffer[n];
			}
			available = 0;
			readed += reading; // 已读字符
		}
		// 给返回结果赋值;
		for (int i = 0; i < result.length; i++) {
			result[i] = temp[headSize + i];
		}
		return result;
	}

	/**
	 * 
	 * splitFileAbsolutePath decription : 拼接文件的绝对路径
	 * 
	 * @param absolutePath
	 * @param fileName
	 * @return
	 */
	public static String splitFileAbsolutePath(String absolutePath,
			String fileName) {
		if (absolutePath == null || absolutePath.trim().length() <= 0
				|| fileName == null || fileName.trim().length() <= 0) {
			return null;
		}
		fileName = absolutePath + File.separator + fileName;

		return fileName;
	}

	/**
	 * 
	 * splitTwoDispatchSoftware decription :
	 * 拼接本地用户自己上传的可以下载的软件信息和本地在远程服务器上下载的可以上传的软件信息
	 * 
	 * @param localInfo
	 * @param remoteInfo
	 * @return
	 */
	public static byte[] splitTwoDispatchSoftware(byte[] localInfo,
			byte[] remoteInfo) {
		// 本地分发文件夹中可以下载的软件信息
		String local = "";
		// 本地从远程服务器中下载的可以分发的软件信息
		String remote = "";
		// 本地信息不为空的情况
		if (localInfo != null) {
			local = new String(localInfo);
		}
		// 远程信息不为空的情况
		if (remoteInfo != null) {
			remote = new String(remoteInfo);
		}
		// 初始化需要返回的对象
		String result = local + remote;
		// 返回对象不为空的情况
		if (result.trim().length() <= 0) {
			return null;
		}
		return result.getBytes();
	}

	/**
	 * 
	 * getLocalIPAddress decription : 得到本机的IP地址
	 * 
	 * @return
	 */
	public static String getLocalIPAddress() {
		String osName = System.getProperty("os.name");
		StringBuffer systemPathBuff = new StringBuffer("");
		if (osName.indexOf("Windows") > -1) {
			// Windows操作系统的cmd.exe的绝对路径
			systemPathBuff.append("c:\\WINDOWS\\system32\\cmd.exe");
		}
		if (osName.indexOf("NT") > -1) {
			// NT操作系统的cmd.exe的绝对路径
			systemPathBuff.append("c:\\WINDOWS\\command.com");
		}
		// 
		Process pro = null;
		// IP地址 的零时变量
		String ipResult = null;
		try {
			InputStream is = null;
			BufferedReader br = null;
			// 读取第一行
			String message = null;
			int index = -1;

			// 此语句相当于在cmd下面执行 ipconfig/all 的命令.并得到命令执行完毕后的输出流
			pro = Runtime.getRuntime().exec(
					systemPathBuff.toString() + " /c ipconfig/all");
			is = pro.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			// 读取第一行
			message = br.readLine();
			index = message.indexOf("Physical Address");
			while (message != null) {
				if ((index = message.indexOf("IP Address")) > 0) {
					ipResult = message.substring(index + 36).trim();
					break;
				}
				// 读取下一行
				message = br.readLine();
			}
			// System.out.println(ipResult);
			// 读入流的关闭
			br.close();
			pro.destroy();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Can't get mac address!");
		}
		return ipResult;
	}

	/**
	 * 
	 * getLocalMacAddress decription : 得到本机的Mac地址
	 * 
	 * @return
	 */
	public static String getLocalMacAddress() {
		String osName = System.getProperty("os.name");
		StringBuffer systemPathBuff = new StringBuffer("");
		if (osName.indexOf("Windows") > -1) {
			// Windows操作系统的cmd.exe的绝对路径
			systemPathBuff.append("c:\\WINDOWS\\system32\\cmd.exe");
		}
		if (osName.indexOf("NT") > -1) {
			// NT操作系统的cmd.exe的绝对路径
			systemPathBuff.append("c:\\WINDOWS\\command.com");
		}
		// 
		Process pro = null;
		// Mac地址 的零时变量
		String macResult = null;
		try {
			InputStream is = null;
			BufferedReader br = null;
			// 读取第一行
			String message = null;
			int index = -1;
			// Mac地址的得到
			// 此语句相当于在cmd下面执行 ipconfig/all 的命令.并得到命令执行完毕后的输出流
			pro = Runtime.getRuntime().exec(
					systemPathBuff.toString() + " /c ipconfig/all");
			is = pro.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			// 读取第一行
			message = br.readLine();
			while (message != null) {
				if ((index = message.indexOf("Physical Address")) > 0) {
					macResult = message.substring(index + 36).trim();
					break;
				}
				// 读取下一行
				message = br.readLine();
			}
			// System.out.println("index :" + index);
			// System.out.println(macResult);
			// 读入流的关闭
			br.close();
			pro.destroy();

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Can't get mac address!");
		}
		return macResult;
	}

	/**
	 * 
	 * getStringFromByteArray decription : 根据字节数组得到正确的字符串
	 * 
	 * @param c
	 * @return String
	 * 
	 */
	public static String getStringFromByteArray(byte[] c) {
		final String[] encoders = new String[] { "GB2312", "UTF-8", "GBK",
				"ISO8859-1" };
		if (c == null || c.length <= 0) {
			return null;
		}
		String result = new String(c);
		if (!isMessyCode(result)) {
			return result;
		}
		for (int i = 0; i < encoders.length; i++) {
			try {
				result = new String(c, encoders[i]);
				if (isMessyCode(result)) {
					continue;
				} else {
					break;
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				continue;
			}
		}
		return result;
	}

	/**
	 * 
	 * isChinese decription : 判断是否是中文编码
	 * 
	 * @param c
	 * @return boolean
	 * 
	 */
	private static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
				|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
				|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
				|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * isMessyCode decription : 判断是否是乱码
	 * 
	 * @param strName
	 * @return boolean
	 * 
	 */
	private static boolean isMessyCode(String strName) {

		Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
		Matcher m = p.matcher(strName);
		String after = m.replaceAll("");
		String temp = after.replaceAll("\\p{P}", "");

		char[] ch = temp.trim().toCharArray();
		// float chLength = ch.length;
		float count = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (!Character.isLetterOrDigit(c)) { // 确定指定字符是否为字母或数字

				if (!isChinese(c)) {
					count = count + 1;
				}
			}
		}
		// float result = count / chLength;
		// if (result > 0.4) {
		// return true;
		// } else {
		// return false;
		// }
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
}
