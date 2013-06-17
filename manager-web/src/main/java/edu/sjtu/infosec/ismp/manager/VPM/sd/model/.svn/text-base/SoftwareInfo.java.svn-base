package edu.sjtu.infosec.ismp.manager.VPM.sd.model;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Description: 软件基本信息对象
 * @author liuqing
 */
@Entity
@Table(name = "vpm_sd_info")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class SoftwareInfo implements Serializable {

	private static final long serialVersionUID = -2008561859196997709L;
	/**
	 * 主键Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 软件名 必须项,必须和上传文件名相对应 (如：QQ.exe 对应的软件名就是QQ.exe)
	 */
	@Column(name = "name")
	private String name;
	/**
	 * 软件类型，FILE or DIR
	 */
	@Column(name = "type")
	private String type;
	/**
	 * 软件发布时间
	 */
	@Column(name = "uploadTime")
	private Timestamp uploadTime;
	/**
	 *界面使用的链接名称
	 */
	@Column(name = "soft_link_name")
	private String softLinkName;
	/**
	 * 软件MD5
	 */
	@Column(name = "md5")
	private String MD5;
	/**
	 * 验证信息
	 */
	@Column(name = "validate")
	private String validate;
	/**
	 * 软件大小，字节
	 */
	@Column(name = "size")
	private Long size;
	
	/**
	 * 软件类型
	 */
    @ManyToOne
	@JoinColumn(name="type_id")
	private TypeInfo typeInfo;
	
	/**
	 * 分发策略
	 */
	@OneToOne(cascade={CascadeType.ALL},optional=false)
	@JoinColumn(name="dispatch_id")
	private DispatchPolicy dispatchPolicy;
	
	/**
	 * 执行策略
	 */
    @OneToOne(cascade={CascadeType.ALL},optional=false)
    @JoinColumn(name="execute_id")
	private ExecutePolicy executePolicy;
	
    /**
     * 验证策略
     */
    @OneToOne(cascade={CascadeType.ALL},optional=false)
    @JoinColumn(name="validate_id")
	private ValidatePolicy validatePolicy;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the uploadTime
	 */
	public Timestamp getUploadTime() {
		return uploadTime;
	}

	/**
	 * @param uploadTime the uploadTime to set
	 */
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	/**
	 * @return the softLinkName
	 */
	public String getSoftLinkName() {
		return softLinkName;
	}

	/**
	 * @param softLinkName the softLinkName to set
	 */
	public void setSoftLinkName(String softLinkName) {
		this.softLinkName = softLinkName;
	}
	
	/**
	 * @return the mD5
	 */
	public String getMD5() {
		return MD5;
	}

	/**
	 * @param md5 the mD5 to set
	 */
	public void setMD5(String md5) {
		MD5 = md5;
	}

	/**
	 * @return the validate
	 */
	public String getValidate() {
		return validate;
	}

	/**
	 * @param validate the validate to set
	 */
	public void setValidate(String validate) {
		this.validate = validate;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}
	
	/**
	 * @return the typeInfo
	 */
	public TypeInfo getTypeInfo() {
		return typeInfo;
	}
	/**
	 * @param typeInfo the typeInfo to set
	 */
	public void setTypeInfo(TypeInfo typeInfo) {
		this.typeInfo = typeInfo;
	}
	/**
	 * @return the dispatchPolicy
	 */
	public DispatchPolicy getDispatchPolicy() {
		return dispatchPolicy;
	}
	/**
	 * @param dispatchPolicy the dispatchPolicy to set
	 */
	public void setDispatchPolicy(DispatchPolicy dispatchPolicy) {
		this.dispatchPolicy = dispatchPolicy;
	}
	/**
	 * @return the executePolicy
	 */
	public ExecutePolicy getExecutePolicy() {
		return executePolicy;
	}
	/**
	 * @param executePolicy the executePolicy to set
	 */
	public void setExecutePolicy(ExecutePolicy executePolicy) {
		this.executePolicy = executePolicy;
	}
	/**
	 * @return the validatePolicy
	 */
	public ValidatePolicy getValidatePolicy() {
		return validatePolicy;
	}
	/**
	 * @param validatePolicy the validatePolicy to set
	 */
	public void setValidatePolicy(ValidatePolicy validatePolicy) {
		this.validatePolicy = validatePolicy;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof SoftwareInfo))
			return false;
		SoftwareInfo castOther = (SoftwareInfo) other;
		return new EqualsBuilder().append(id, castOther.id).append(name, castOther.name).append(type,
				castOther.type).append(size, castOther.size).append(uploadTime,
				castOther.uploadTime).append(MD5, castOther.MD5).append(validate,
				castOther.validate).isEquals();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new HashCodeBuilder().append(id).append(name).append(type).append(size)
				.append(uploadTime).append(MD5).append(
						validate).toHashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new ToStringBuilder(this).append(id).append("name", name).append("type",
				type).append("size", size).append("uploadTime", uploadTime)
				.append("MD5", MD5).append(
						"validate", validate).toString();
	}
}