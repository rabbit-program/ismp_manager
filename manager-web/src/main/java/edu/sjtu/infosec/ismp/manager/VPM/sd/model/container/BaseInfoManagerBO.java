package edu.sjtu.infosec.ismp.manager.VPM.sd.model.container;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * @Title: BaseInfoManagerBO.java
 * @Package edu.sjtu.infosec.ismp.manager.virus.software.model
 * @Description: 软件基本信息对象
 * @author wjianzhuo
 * @date 2009-8-12 上午11:12:15
 * @version V1.0
 */

public class BaseInfoManagerBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2008561859196997709L;

	/**
	 * 软件名 必须项,必须和上传文件名相对应 (如：QQ.exe 对应的软件名就是QQ.exe)
	 */
	private String name;

	/**
	 * 软件类型，FILE or DIR
	 */
	private String type;



	/**
	 * 软件类别
	 */
	private String category;

	/**
	 * 软件发布时间
	 */
	private String uploadTime;
	/**
	 *界面使用的链接名称
	 */
	public String softLinkName;
	
	/**
	 * 软件MD5
	 */
	private String MD5;

	private String validate;

	/**
	 * 软件大小，字节
	 */
	private Long size;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
 
	
	
	/**
	 * @param vName
	 *            the name to set
	 */
	public void setName(String vName) {
		name = vName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param vType
	 *            the type to set
	 */
	public void setType(String vType) {
		type = vType;
	}

	/**
	 * @return the uploadTime
	 */
	public String getUploadTime() {
		return uploadTime;
	}

	/**
	 * @param vUploadTime
	 *            the uploadTime to set
	 */
	public void setUploadTime(String vUploadTime) {
		uploadTime = vUploadTime;
	}

	/**
	 * @return the mD5
	 */
	public String getMD5() {
		return MD5;
	}

	/**
	 * @param vMd5
	 *            the mD5 to set
	 */
	public void setMD5(String vMd5) {
		MD5 = vMd5;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param vSize
	 *            the size to set
	 */
	public void setSize(Long vSize) {
		size = vSize;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param vCategory
	 *            the category to set
	 */
	public void setCategory(String vCategory) {
		category = vCategory;
	}

	/**
	 * @return the validate
	 */
	public String getValidate() {
		return validate;
	}

	/**
	 * @param vValidate
	 *            the validate to set
	 */
	public void setValidate(String vValidate) {
		validate = vValidate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof BaseInfoManagerBO))
			return false;
		BaseInfoManagerBO castOther = (BaseInfoManagerBO) other;
		return new EqualsBuilder().append(name, castOther.name).append(type,
				castOther.type).append(size, castOther.size).append(uploadTime,
				castOther.uploadTime).append(MD5, castOther.MD5).append(
				category, castOther.category).append(validate,
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
		return new HashCodeBuilder().append(name).append(type).append(size)
				.append(uploadTime).append(MD5).append(category).append(
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
		return new ToStringBuilder(this).append("name", name).append("type",
				type).append("size", size).append("uploadTime", uploadTime)
				.append("MD5", MD5).append("category", category).append(
						"validate", validate).toString();
	}
	public String getSoftLinkName() {
		return softLinkName;
	}



	public void setSoftLinkName(String softLinkName) {
		this.softLinkName = softLinkName;
	}
}
