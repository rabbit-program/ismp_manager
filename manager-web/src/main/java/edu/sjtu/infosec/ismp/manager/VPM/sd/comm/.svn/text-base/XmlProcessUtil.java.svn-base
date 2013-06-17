package edu.sjtu.infosec.ismp.manager.VPM.sd.comm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

import edu.sjtu.infosec.ismp.manager.VPM.sd.model.DispatchPolicy;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.ExecutePolicy;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.SoftwareInfo;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.ValidatePolicy;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.container.BaseInfoManagerBO;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.container.DispatchPolicyManagerBO;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.container.ExecutePolicyManagerBO;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.container.SoftwareManagerBO;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.container.ValidatePolicyManagerBO;
import edu.sjtu.infosec.ismp.manager.VPM.sd.web.form.SoftwareForm;

/**  
 * @Title: XmlProcessUtil.java
 * @Package edu.sjtu.infosec.ismp.manager.virus.software.util
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-8-12 下午05:12:51   
 * @version V1.0  
 */
/**
 * @ClassName: XmlProcessUtil
 * @Description: TODO
 * @author wjianzhuo
 * @date 2009-8-12 下午05:12:51
 * 
 */
public class XmlProcessUtil {
	// public static void main(String[] args) throws Exception {
	// // 产生路径和文件名
	// String path = "C:\\test\\software_temp.xml";
	// // 产生软件BO
	// SoftwareCenterBO bo = new SoftwareCenterBO();
	// // 产生基本信息BO
	// BaseInfoCenterBO baseInfo = new BaseInfoCenterBO();
	// baseInfo.setUploadTime("2009-10-10 10:10:10");
	// baseInfo.setMD5("XDDOL323444PDX");
	// baseInfo.setName("software_temp.xml");
	// baseInfo.setSize(101231313l);
	// baseInfo.setType("FILE");
	// baseInfo.setCategory("系统软件");
	// // 把基本信息BO加入到软件信息BO中
	// bo.setBaseInfoCenterBO(baseInfo);
	//	
	// // 产生分发策略信息BO
	// DispatchPolicyCenterBO dispatch = new DispatchPolicyCenterBO();
	// dispatch.setConsistencyCheckTag(null);
	// dispatch.setDispatchFormTag(false);
	// dispatch.setDispatchCheckTag(true);
	// dispatch.setDispatchThreadNum(10);
	// dispatch.setDispatchEndDate(null);
	// dispatch.setDispatchStartDate(null);
	// dispatch.setDispatchEndTime(19 * 60 * 60 * 1000L);
	// dispatch.setDispatchStartTime((24 - 19 + 7) * 60 * 60 * 1000L);
	// dispatch.setDispatchPriority(2);
	// // 把分发策略BO加入到软件信息BO中
	// bo.setDispatchPolicyCenterBO(dispatch);
	//	
	// // 产生执行策略信息BO
	// ExecutePolicyCenterBO execute = new ExecutePolicyCenterBO();
	// execute.setExecuteCheckTag(true);
	// execute.setExecuteFilePath(".//setup//setup.exe");
	// execute.setExecuteParameter("-d setup.exe");
	// execute.setExecutePromptingMessage("正在安装软件....");
	// // 把执行策略BO加入到软件信息BO中
	// bo.setExecutePolicyCenterBO(execute);
	//	
	// // 产生验证策略信息BO
	// ValidatePolicyCenterBO validate = new ValidatePolicyCenterBO();
	// validate.setValidateCheckTag(true);
	// validate.setValidateFilePath("c://dest//360setup.exe");
	// validate.setValidateFileVersion(1.0);
	// validate.setValidateProcess("360.exe");
	// validate.setValidateRegisterKey("LOCALHOST_SOFTWARE.exe.exe");
	// validate.setValidateService("360.service");
	// bo.setValidatePolicyCenterBO(validate);
	// // 调用写入XML操作方法
	// writeSoftwareXML(path, bo);
	// XMLConfiguration config = getConfiguration(path);
	// // 只有new一个XMLConfiguration的实例就可以了.
	// String executeTag = config.getString("base-info.type");
	//	
	// System.out.println("execute-policy.execute-tag: "
	// + config.getString("base-info.type"));
	// String version = config
	// .getString("validate-policy.validate-file-version");
	// bo = getSoftwareCenterBOByXml(path);
	// if (bo != null) {
	// System.out.println(bo.toString());
	// } else {
	// System.out.println("BO is null");
	// }
	// }

	/**
	 * 
	 * getConfiguration decription : 得到XML操作对象
	 * 
	 * @param absolutePath
	 *            需要添加的文件路径和文件名 如：c:/test/newbook.xml 或 c:\\test\\newbook.xml
	 * @return
	 */
	public static XMLConfiguration getConfiguration(String absolutePath) {
		File file = new File(absolutePath);

		if (file == null || !file.exists()) {
			return null;
		}
		XMLConfiguration config = null;
		try {
			config = new XMLConfiguration(file);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}

	/**
	 * 
	 * getSoftwareCenterBOByXml decription : 根据XML文件的绝对路径得到该文件对应的软件信息对象
	 * 
	 * @param absolutePath
	 *            需要操作的XML文件路径和文件名 如：c://test//newbook.xml
	 * @return
	 */
	public static SoftwareManagerBO getSoftwareManagerBOByXml(
			String absolutePath) {
		SoftwareManagerBO software = null;
		try {
			// 根据绝对路径得到XML操作句柄
			XMLConfiguration config = getConfiguration(absolutePath);
			if (config == null) {
				return null;
			}
			// 分发软件基础类
			software = new SoftwareManagerBO();

			// 判断根据该XML得到对应的软件信息BO对象是否为空的标志
			boolean isNullTag = true;
			// 根据XML操作句柄得到软件基本信息BO对象
			BaseInfoManagerBO baseInfo = getBaseInfoManagerBO(config);
			if (baseInfo != null) {
				// 设置基本信息BO对象
				software.setBaseInfoManagerBO(baseInfo);
				isNullTag = false;
			}

			// 根据XML操作句柄得到软件分发策略信息BO对象
			DispatchPolicyManagerBO dispatch = getDispatchPolicyManagerBO(config);
			if (dispatch != null) {
				// 设置软件分发策略信息BO对象
				software.setDispatchPolicyManagerBO(dispatch);
				isNullTag = false;
			}

			// 根据XML操作句柄得到软件执行策略信息BO对象
			ExecutePolicyManagerBO execute = getExecutePolicyManagerBO(config);
			if (execute != null) {
				// 设置软件执行策略信息BO对象
				software.setExecutePolicyManagerBO(execute);
				isNullTag = false;
			}

			// 根据XML操作句柄得到软件验证策略信息BO对象
			ValidatePolicyManagerBO validate = getValidatePolicyManagerBO(config);
			if (validate != null) {
				// 设置软件验证策略信息BO对象
				software.setValidatePolicyManagerBO(validate);
				isNullTag = false;
			}
			// 根据该XML文件并没有得到相对应的软件信息对象的情况
			if (isNullTag) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return software;
		}
		return software;

	}

	/**
	 * 
	 * writeSoftwareXML decription : 书写软件XML标签集
	 * 
	 * @param absolutePath
	 *            需要添加的文件路径和文件名 如：c:/test/newbook.xml 或 c:\\test\\newbook.xml
	 * @param bo
	 * @throws IOException
	 */
	public static void writeSoftwareXML(String absolutePath,
			SoftwareForm sfotwareFomr) throws IOException {
		// 如果产生XML文件的路径和文件名为空的情况或者软件对象为空,或者软件对象中的基本信息为空,
		// 或者软件对象分发策略为空,或者软件对象的执行策略为空,或者软件的验证策略为空的情况
		SoftwareInfo bo = sfotwareFomr.getSi();
		if (absolutePath == null || absolutePath.trim().length() <= 0
				|| bo == null || bo == null
				|| bo.getDispatchPolicy() == null
				|| bo.getExecutePolicy() == null
				|| bo.getValidatePolicy() == null) {
			return;
		}
		String name = bo.getName().substring(0,bo.getName().lastIndexOf("."));
		String path = absolutePath+"\\"+name+".xml";
		// 根据路径和文件名得到文件输出流
		OutputStreamWriter fs = new OutputStreamWriter(new FileOutputStream(path), "UTF-8");
		// 书写软件XML头信息
		writeXmlHeadInfo(fs);
		// 书写软件基本信息XML标签集
		writeBaseInfoManagerXml(fs, bo);
		// 书写软件分发策略XML标签集
		writeDispatchPolicyManagerXml(fs, bo.getDispatchPolicy());
		// 书写软件执行策略XML标签集
		writeExecutePolicyManagerXml(fs, bo.getExecutePolicy());
		// 书写软件验证策略XML标签集
		writeValidatePolicyManagerXml(fs, bo.getValidatePolicy());
		// 书写软件XML尾部信息
		writeXmlFootInfo(fs);
		fs.flush();
		// 关闭写入流
		fs.close();
		sfotwareFomr.setXmlPath(path);
	}

	/**
	 * 
	 * writeXmlHeadInfo decription : 书写软件XML头部信息
	 * 
	 * @param fs
	 * @throws IOException
	 */
	private static void writeXmlHeadInfo(OutputStreamWriter fs)
			throws IOException {
		fs.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		fs.write("\n<software>");
	}

	/**
	 * 
	 * writeBaseInfoManagerXml decription : 书写软件基本信息XML标签集
	 * 
	 * @param fs
	 * @param BaseInfoManagerBO
	 * @throws IOException
	 */
	private static void writeBaseInfoManagerXml(OutputStreamWriter fs,
			SoftwareInfo bo) throws IOException {
		// --- 基本信息 ---
		fs.write("\n\t<!-- 基本信息 -->");
		fs.write("\n\t<base-info>\n");

		// 软件名
		fs.write("\t\t<!-- 软件名 -->\n");
		fs.write("\t\t<name>");
		fs.write(bo.getName() == null ? "" : bo.getName().trim());
		fs.write("</name>\n");

		// 软件类型
		fs.write("\t\t<!-- 软件类型 FILE or DIR -->\n");
		fs.write("\t\t<type>");
		fs.write(bo.getType() == null ? "" : bo.getType().trim());
		fs.write("</type>\n");

		// 软件类别
		fs.write("\t\t<!-- 软件类别 -->\n");
		fs.write("\t\t<category>");
		fs.write(bo.getTypeInfo().getName() == null ? "" : bo.getTypeInfo().getName().trim());
		fs.write("</category>\n");

		// 软件大小
		fs.write("\t\t<!-- 软件大小,字节 -->\n");
		fs.write("\t\t<size>");
		fs.write(bo.getSize() == null ? "" : bo.getSize() + "");
		fs.write("</size>\n");

		// 软件MD5
		fs.write("\t\t<!-- 软件MD5 -->\n");
		fs.write("\t\t<MD5>");
		fs.write(bo.getMD5() == null ? "" : bo.getMD5());
		fs.write("</MD5>\n");

		// 软件发布时间
		fs.write("\t\t<!-- 软件发布时间 -->\n");
		fs.write("\t\t<upload-time>");
		fs.write(bo.getUploadTime() == null ? TimeProcessUtil
				.getNowDateString() : bo.getUploadTime().toString().trim() + "");
		fs.write("</upload-time>\n");

		// 验证信息
		fs.write("\t\t<!-- 验证信息-->\n");
		fs.write("\t\t<validate>");
		fs.write(bo.getValidate() == null ? "" : bo.getValidate().trim() + "");
		fs.write("\t\t</validate>\n");

		fs.write("\t</base-info>\n");
	}

	/**
	 * 
	 * writeDispatchPolicyManagerXml decription : 书写软件分发策略XML标签集
	 * 
	 * @param fs
	 * @param bo
	 * @throws IOException
	 */
	private static void writeDispatchPolicyManagerXml(OutputStreamWriter fs,
			DispatchPolicy bo) throws IOException {
		// --- 分发策略 ---
		fs.write("\n\t<!-- 分发策略 -->");
		fs.write("\n\t<dispatch-policy>\n");

		// 是否需要分发标志
		fs.write("\t\t<!-- 分发标志,是否需要分发标志 -->\n");
		fs.write("\t\t<dispatch-check-tag>");
		fs.write(bo.getDispatchCheckTag() == null ? "false" : bo
				.getDispatchCheckTag()
				+ "");
		fs.write("</dispatch-check-tag>\n");

		// 是否需要进行一致性检查标志
		fs.write("\t\t<!-- 是否需要进行一致性检查标志 -->\n");
		fs.write("\t\t<consistency-check-tag>");
		fs.write(bo.getConsistencyCheckTag() == null ? "false" : bo
				.getConsistencyCheckTag()
				+ "");
		fs.write("</consistency-check-tag>\n");

		// rar形态表示标志 true:表示是我们自己打的rar包 false:表示是用户上传的rar包
		fs
				.write("\t\t<!-- rar形态表示标志 true:表示是我们自己打的rar包 false:表示是用户上传的rar包  -->\n");
		fs.write("\t\t<dispatch-form-tag>");
		fs.write(bo.getDispatchFormTag() == null ? "" : bo.getDispatchFormTag()
				+ "");
		fs.write("</dispatch-form-tag>\n");

		// 分发优先级, 0, 1, 2
		fs.write("\t\t<!-- 分发优先级,0,1,2 -->\n");
		fs.write("\t\t<dispatch-priority>");
		fs.write(bo.getDispatchPriority() == null ? "0" : bo
				.getDispatchPriority()
				+ "");
		fs.write("</dispatch-priority>\n");

		// 并发分发数量
		fs.write("\t\t<!-- 并发分发数量 -->\n");
		fs.write("\t\t<dispatch-thread-num>");
		fs.write(bo.getDispatchThreadNum() == null ? "5" : bo
				.getDispatchThreadNum()
				+ "");
		fs.write("</dispatch-thread-num>\n");

		// 分发开始日期
		fs.write("\t\t<!-- 分发开始日期 -->\n");
		fs.write("\t\t<dispatch-start-date>");
		fs.write(bo.getDispatchStartDate() == null ? "" : bo
				.getDispatchStartDate().toString().trim()
				+ "");
		fs.write("</dispatch-start-date>\n");

		// 分发结束日期
		fs.write("\t\t<!-- 分发结束日期 -->\n");
		fs.write("\t\t<dispatch-end-date>");
		fs.write(bo.getDispatchEndDate() == null ? "" : bo.getDispatchEndDate().toString().trim()
				+ "");
		fs.write("</dispatch-end-date>\n");

		// 分发开始时间
		fs.write("\t\t<!-- 分发开始时间 -->\n");
		fs.write("\t\t<dispatch-start-time>");
		fs.write(bo.getDispatchStartTime() == null ? "" : bo
				.getDispatchStartTime()
				+ "");
		fs.write("</dispatch-start-time>\n");

		// 分发结束时间
		fs.write("\t\t<!-- 分发结束时间 -->\n");
		fs.write("\t\t<dispatch-end-time>");
		fs.write(bo.getDispatchEndTime() == null ? "" : bo.getDispatchEndTime()
				+ "");
		fs.write("</dispatch-end-time>");

		fs.write("\n\t</dispatch-policy>\n");
	}

	/**
	 * 
	 * writeExecutePolicyManagerXml decription : 书写软件执行策略XML标签集
	 * 
	 * @param fs
	 * @param bo
	 * @throws IOException
	 */
	private static void writeExecutePolicyManagerXml(OutputStreamWriter fs,
			ExecutePolicy bo) throws IOException {
		// --- 执行策略 ---
		fs.write("\n\t<!-- 执行策略 -->");
		fs.write("\n\t<execute-policy>\n");

		// 分发后执行标志
		fs.write("\t\t<!-- 分发后执行标志  -->\n");
		fs.write("\t\t<execute-check-tag>");
		fs.write(bo.getExecuteCheckTag() == null ? "false" : bo
				.getExecuteCheckTag()
				+ "");
		fs.write("</execute-check-tag>\n");

		// 执行文件，相对路径
		fs.write("\t\t<!-- 执行文件,相对路径 -->\n");
		fs.write("\t\t<execute-file-path>");
		fs
				.write(bo.getExecuteFilePath() == null ? "" : bo
						.getExecuteFilePath().trim());
		fs.write("</execute-file-path>\n");

		// 执行参数
		fs.write("\t\t<!-- 执行参数 -->\n");
		fs.write("\t\t<execute-parameter>");
		fs.write(bo.getExecuteParameter() == null ? "" : bo
				.getExecuteParameter().trim());
		fs.write("</execute-parameter>\n");

		// 提示信息
		fs.write("\t\t<!-- 提示信息 -->\n");
		fs.write("\t\t<execute-prompting-message>");
		fs.write(bo.getExecutePromptingMessage() == null ? "" : bo
				.getExecutePromptingMessage().trim());
		fs.write("</execute-prompting-message>");
		fs.write("\n\t</execute-policy>\n");
	}

	/**
	 * 
	 * writeValidatePolicyManagerXml decription : 书写软件验证策略XML标签集
	 * 
	 * @param fs
	 * @param bo
	 * @throws IOException
	 */
	private static void writeValidatePolicyManagerXml(OutputStreamWriter fs,
			ValidatePolicy bo) throws IOException {
		// --- 验证策略 ---
		fs.write("\n\t<!-- 验证策略 -->");
		fs.write("\n\t<validate-policy>\n");

		// 验证标志
		fs.write("\t\t<!-- 验证标志 -->\n");
		fs.write("\t\t<validate-check-tag>");
		fs.write(bo.getValidateCheckTag() == null ? "false" : bo
				.getValidateCheckTag()
				+ "");
		fs.write("</validate-check-tag>\n");

		// 验证文件路径
		// fs.write("\t\t<!-- 验证文件路径 -->\n");
		fs.write("\t\t<validate-file-path>");
		fs.write(bo.getValidateFilePath() == null ? "" : bo
				.getValidateFilePath().trim());
		fs.write("</validate-file-path>\n");

		// 验证文件版本
		fs.write("\t\t<!-- 验证文件版本 -->\n");
		fs.write("\t\t<validate-file-version>");
		fs.write(bo.getValidateFileVersion() == null ? "" : bo
				.getValidateFileVersion().trim()
				+ "");
		fs.write("</validate-file-version>\n");

		// 注册表项/键
		fs.write("\t\t<!-- 注册表项/键 -->\n");
		fs.write("\t\t<validate-register-key>");
		fs.write(bo.getValidateRegisterKey() == null ? "" : bo
				.getValidateRegisterKey().trim());
		fs.write("</validate-register-key>\n");

		// 进程
		fs.write("\t\t<!-- 进程 -->\n");
		fs.write("\t\t<validate-process>");
		fs
				.write(bo.getValidateProcess() == null ? "" : bo
						.getValidateProcess().trim());
		fs.write("</validate-process>\n");

		// 服务
		fs.write("\t\t<!-- 服务 -->\n");
		fs.write("\t\t<validate-service>");
		fs
				.write(bo.getValidateService() == null ? "" : bo
						.getValidateService().trim());
		fs.write("</validate-service>");

		fs.write("\n\t</validate-policy>\n");
		// fs.write("</software>");
	}

	/**
	 * 
	 * writeXmlFootInfo decription : 书写软件XML尾部信息
	 * 
	 * @param fs
	 * @throws IOException
	 */
	private static void writeXmlFootInfo(OutputStreamWriter fs)
			throws IOException {
		fs.write("</software>");
	}

	/**
	 * 
	 * getBaseInfoManagerBO decription : 根据XML操作句柄得到软件基本信息BO对象
	 * 
	 * @param config
	 * @return
	 */
	private static BaseInfoManagerBO getBaseInfoManagerBO(
			XMLConfiguration config) {
		// 产生基本信息BO
		BaseInfoManagerBO baseInfo = new BaseInfoManagerBO();
		if (config == null) {
			return null;
		}
		// 软件名
		baseInfo.setName(config.getString("base-info.name").trim());

		// 软件发布时间
		baseInfo.setUploadTime(config.getString("base-info.upload-time").trim());

		// 软件类型，FILE or DIR
		baseInfo.setType(config.getString("base-info.type").trim());

		// 软件类别
		baseInfo.setCategory(config.getString("base-info.category").trim());

		// 软件大小
		Long size = config.getString("base-info.size") == null ? null
				: new Long(config.getString("base-info.size").trim());
		baseInfo.setSize(size);

		// 软件MD5
		baseInfo.setMD5(config.getString("base-info.MD5"));

		baseInfo.setValidate(config.getString("base-info.validate"));
		return baseInfo;
	}

	/**
	 * 
	 * getDispatchPolicyManagerBO decription : 根据XML操作句柄得到软件分发策略信息BO对象
	 * 
	 * @param config
	 * @return
	 */
	private static DispatchPolicyManagerBO getDispatchPolicyManagerBO(
			XMLConfiguration config) {
		// // 产生分发策略信息BO
		DispatchPolicyManagerBO dispatch = new DispatchPolicyManagerBO();
		if (config == null) {
			return null;
		}
		Boolean tag = null;
		// 是否需要一致性检查标志
		tag = config.getString("dispatch-policy.consistency-check-tag") == null ? false
				: new Boolean(config
						.getString("dispatch-policy.consistency-check-tag").trim());
		dispatch.setConsistencyCheckTag(tag);

		// 分发标志，是否需要分发
		tag = config.getString("dispatch-policy.dispatch-check-tag") == null ? false
				: new Boolean(config
						.getString("dispatch-policy.dispatch-check-tag").trim());
		dispatch.setDispatchCheckTag(tag);

		// rar形态表示标志 true:表示是我们自己打的rar包 false:表示是用户上传的rar包
		tag = config.getString("dispatch-policy.dispatch-form-tag") == null ? false
				: new Boolean(config
						.getString("dispatch-policy.dispatch-form-tag").trim());
		dispatch.setDispatchFormTag(tag);

		// 分发开始日期
		dispatch.setDispatchStartDate(config
				.getString("dispatch-policy.dispatch-start-date").trim());

		// 分发结束日期
		dispatch.setDispatchEndDate(config
				.getString("dispatch-policy.dispatch-end-date").trim());

		String time = config.getString("dispatch-policy.dispatch-start-time");
		if (time != null && time.trim().length() > 0) {
			// 分发开始时间
			dispatch.setDispatchStartTime(new Long(time.trim()));
		}

		time = config.getString("dispatch-policy.dispatch-end-time");
		if (time != null && time.trim().length() > 0) {
			// 分发结束时间
			dispatch.setDispatchEndTime(new Long(time.trim()));
		}

		// 并发分发数量
		Integer num = config.getString("dispatch-policy.dispatch-thread-num") == null ? null
				: new Integer(config
						.getString("dispatch-policy.dispatch-thread-num").trim());
		dispatch.setDispatchThreadNum(num);

		// 分发优先级, 0, 1, 2
		Integer priority = config
				.getString("dispatch-policy.dispatch-priority") == null ? null
				: new Integer(config
						.getString("dispatch-policy.dispatch-priority").trim());
		dispatch.setDispatchPriority(priority);
		return dispatch;
	}

	/**
	 * 
	 * getExecutePolicyManagerBO decription : 根据XML操作句柄得到软件执行策略信息BO对象
	 * 
	 * @param config
	 * @return
	 */
	private static ExecutePolicyManagerBO getExecutePolicyManagerBO(
			XMLConfiguration config) {
		ExecutePolicyManagerBO execute = new ExecutePolicyManagerBO();
		if (config == null) {
			return null;
		}
		Boolean tag = null;
		// 分发后执行标志
		tag = config.getString("execute-policy.execute-check-tag") == null ? false
				: new Boolean(config
						.getString("execute-policy.execute-check-tag").trim());
		execute.setExecuteCheckTag(tag);

		// 执行文件，相对路径
		execute.setExecuteFilePath(config
				.getString("execute-policy.execute-file-path"));

		// 执行参数
		execute.setExecuteParameter(config
				.getString("execute-policy.execute-parameter"));

		// 提示信息
		execute.setExecutePromptingMessage(config
				.getString("execute-policy.execute-prompting-message"));

		return execute;
	}

	/**
	 * 
	 * getValidatePolicyManagerBO decription : 根据XML操作句柄得到软件验证策略信息BO对象
	 * 
	 * @param config
	 * @return
	 */
	private static ValidatePolicyManagerBO getValidatePolicyManagerBO(
			XMLConfiguration config) {
		// // 产生验证策略信息BO
		ValidatePolicyManagerBO validate = new ValidatePolicyManagerBO();
		if (config == null) {
			return null;
		}
		Boolean tag = null;
		// 验证标志
		tag = config.getString("validate-policy.validate-check-tag") == null ? false
				: new Boolean(config
						.getString("validate-policy.validate-check-tag").trim());
		validate.setValidateCheckTag(tag);

		// 验证文件版本
		String version = config
				.getString("validate-policy.validate-file-version");
		validate.setValidateFileVersion(version);

		// 验证文件路径
		validate.setValidateFilePath(config
				.getString("validate-policy.validate-file-path"));

		// 注册表项/键
		validate.setValidateRegisterKey(config
				.getString("validate-policy.validate-register-key"));

		// 进程
		validate.setValidateProcess(config
				.getString("validate-policy.validate-process"));

		// 服务
		validate.setValidateService(config
				.getString("validate-policy.validate-service"));

		return validate;
	}
}
