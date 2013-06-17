package edu.sjtu.infosec.ismp.manager.VPM.sd.model.container;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Title: ValidatePolicyManagerBO.java
 * @Package edu.sjtu.infosec.ismp.manager.virus.software.model
 * @Description: 验证策略信息对象
 * @author wjianzhuo
 * @date 2009-8-12 上午11:03:56
 * @version V1.0
 */
public class ValidatePolicyManagerBO implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1510440643753531997L;

	/**
	 * 验证标志
	 */
	private Boolean validateCheckTag;

	/**
	 * 验证文件路径
	 */
	private String validateFilePath;

	/**
	 * 验证文件版本
	 */
	private String validateFileVersion;

	/**
	 * 注册表项/键
	 */
	private String validateRegisterKey;

	/**
	 * 进程
	 */
	private String validateProcess;

	/**
	 * 服务
	 */
	private String validateService;

	/**
	 * @return the validateCheckTag
	 */
	public Boolean getValidateCheckTag() {
		return validateCheckTag;
	}

	/**
	 * @param vValidateCheckTag
	 *            the validateCheckTag to set
	 */
	public void setValidateCheckTag(Boolean vValidateCheckTag) {
		validateCheckTag = vValidateCheckTag;
	}

	/**
	 * @return the validateFilePath
	 */
	public String getValidateFilePath() {
		return validateFilePath;
	}

	/**
	 * @param vValidateFilePath
	 *            the validateFilePath to set
	 */
	public void setValidateFilePath(String vValidateFilePath) {
		validateFilePath = vValidateFilePath;
	}

	/**
	 * @return the validateFileVersion
	 */
	public String getValidateFileVersion() {
		return validateFileVersion;
	}

	/**
	 * @param vValidateFileVersion
	 *            the validateFileVersion to set
	 */
	public void setValidateFileVersion(String vValidateFileVersion) {
		validateFileVersion = vValidateFileVersion;
	}

	/**
	 * @return the validateRegisterKey
	 */
	public String getValidateRegisterKey() {
		return validateRegisterKey;
	}

	/**
	 * @param vValidateRegisterKey
	 *            the validateRegisterKey to set
	 */
	public void setValidateRegisterKey(String vValidateRegisterKey) {
		validateRegisterKey = vValidateRegisterKey;
	}

	/**
	 * @return the validateProcess
	 */
	public String getValidateProcess() {
		return validateProcess;
	}

	/**
	 * @param vValidateProcess
	 *            the validateProcess to set
	 */
	public void setValidateProcess(String vValidateProcess) {
		validateProcess = vValidateProcess;
	}

	/**
	 * @return the validateService
	 */
	public String getValidateService() {
		return validateService;
	}

	/**
	 * @param vValidateService
	 *            the validateService to set
	 */
	public void setValidateService(String vValidateService) {
		validateService = vValidateService;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		if (!(other instanceof ValidatePolicyManagerBO))
			return false;
		ValidatePolicyManagerBO castOther = (ValidatePolicyManagerBO) other;
		return new EqualsBuilder().append(validateCheckTag,
				castOther.validateCheckTag).append(validateFilePath,
				castOther.validateFilePath).append(validateFileVersion,
				castOther.validateFileVersion).append(validateProcess,
				castOther.validateProcess).append(validateRegisterKey,
				castOther.validateRegisterKey).append(validateService,
				castOther.validateService).isEquals();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new HashCodeBuilder().append(validateCheckTag).append(
				validateFilePath).append(validateFileVersion).append(
				validateProcess).append(validateRegisterKey).append(
				validateService).toHashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new ToStringBuilder(this).append("validateCheckTag",
				validateCheckTag).append("validateFilePath", validateFilePath)
				.append("validateFileVersion", validateFileVersion).append(
						"validateProcess", validateProcess).append(
						"validateRegisterKey", validateRegisterKey).append(
						"validateService", validateService).toString();
	}

}
