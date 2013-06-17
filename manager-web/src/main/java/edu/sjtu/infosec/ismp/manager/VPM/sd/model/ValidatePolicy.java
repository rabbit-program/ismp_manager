package edu.sjtu.infosec.ismp.manager.VPM.sd.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Description: 验证策略信息对象
 * @author liuqing
 */
@Entity
@Table(name = "vpm_sd_validate_policy")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class ValidatePolicy implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1510440643753531997L;
	/**
	 * 主键Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 验证标志
	 */
	@Column(name = "validate_check_tag")
	private Boolean validateCheckTag;

	/**
	 * 验证文件路径
	 */
	@Column(name = "validate_file_path")
	private String validateFilePath;

	/**
	 * 验证文件版本
	 */
	@Column(name = "validate_file_version")
	private String validateFileVersion;

	/**
	 * 注册表项/键
	 */
	@Column(name = "validate_register_key")
	private String validateRegisterKey;

	/**
	 * 进程
	 */
	@Column(name = "validate_process")
	private String validateProcess;

	/**
	 * 服务
	 */
	@Column(name = "validate_service")
	private String validateService;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the validateCheckTag
	 */
	public Boolean getValidateCheckTag() {
		return validateCheckTag;
	}

	/**
	 * @param validateCheckTag the validateCheckTag to set
	 */
	public void setValidateCheckTag(Boolean validateCheckTag) {
		this.validateCheckTag = validateCheckTag;
	}

	/**
	 * @return the validateFilePath
	 */
	public String getValidateFilePath() {
		return validateFilePath;
	}

	/**
	 * @param validateFilePath the validateFilePath to set
	 */
	public void setValidateFilePath(String validateFilePath) {
		this.validateFilePath = validateFilePath;
	}

	/**
	 * @return the validateFileVersion
	 */
	public String getValidateFileVersion() {
		return validateFileVersion;
	}

	/**
	 * @param validateFileVersion the validateFileVersion to set
	 */
	public void setValidateFileVersion(String validateFileVersion) {
		this.validateFileVersion = validateFileVersion;
	}

	/**
	 * @return the validateRegisterKey
	 */
	public String getValidateRegisterKey() {
		return validateRegisterKey;
	}

	/**
	 * @param validateRegisterKey the validateRegisterKey to set
	 */
	public void setValidateRegisterKey(String validateRegisterKey) {
		this.validateRegisterKey = validateRegisterKey;
	}

	/**
	 * @return the validateProcess
	 */
	public String getValidateProcess() {
		return validateProcess;
	}

	/**
	 * @param validateProcess the validateProcess to set
	 */
	public void setValidateProcess(String validateProcess) {
		this.validateProcess = validateProcess;
	}

	/**
	 * @return the validateService
	 */
	public String getValidateService() {
		return validateService;
	}

	/**
	 * @param validateService the validateService to set
	 */
	public void setValidateService(String validateService) {
		this.validateService = validateService;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		if (!(other instanceof ValidatePolicy))
			return false;
		ValidatePolicy castOther = (ValidatePolicy) other;
		return new EqualsBuilder().append(id, castOther.id).append(validateCheckTag,
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
		return new HashCodeBuilder().append(id).append(validateCheckTag).append(
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
		return new ToStringBuilder(this).append(id).append("validateCheckTag",
				validateCheckTag).append("validateFilePath", validateFilePath)
				.append("validateFileVersion", validateFileVersion).append(
						"validateProcess", validateProcess).append(
						"validateRegisterKey", validateRegisterKey).append(
						"validateService", validateService).toString();
	}

}
