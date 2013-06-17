package edu.sjtu.infosec.ismp.manager.VPM.sd.model.container;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Title: ExecutePolicyManagerBO.java
 * @Package edu.sjtu.infosec.ismp.manager.virus.software.model
 * @Description: 软件执行策略信息对象
 * @author wjianzhuo
 * @date 2009-8-12 上午11:00:49
 * @version V1.0
 */

public class ExecutePolicyManagerBO implements Serializable {

	/**
	* @Fields serialVersionUID : 
	*    TODO
	*/
	private static final long serialVersionUID = 4324241047688597633L;

	/**
	 * 分发后执行标志
	 */
	private Boolean executeCheckTag;

	/**
	 * 执行文件，相对路径 ：.//setup//setup.exe
	 */
	private String executeFilePath;

	/**
	 * 执行参数
	 */
	private String executeParameter;

	/**
	 * 提示信息
	 */
	private String executePromptingMessage;

	/**
	 * @return the executeCheckTag
	 */
	public Boolean getExecuteCheckTag() {
		return executeCheckTag;
	}

	/**
	 * @param vExecuteCheckTag
	 *            the executeCheckTag to set
	 */
	public void setExecuteCheckTag(Boolean vExecuteCheckTag) {
		executeCheckTag = vExecuteCheckTag;
	}

	/**
	 * @return the executeParameter
	 */
	public String getExecuteParameter() {
		return executeParameter;
	}

	/**
	 * @param vExecuteParameter
	 *            the executeParameter to set
	 */
	public void setExecuteParameter(String vExecuteParameter) {
		executeParameter = vExecuteParameter;
	}

	/**
	 * @return the executePromptingMessage
	 */
	public String getExecutePromptingMessage() {
		return executePromptingMessage;
	}

	/**
	 * @param vExecutePromptingMessage
	 *            the executePromptingMessage to set
	 */
	public void setExecutePromptingMessage(String vExecutePromptingMessage) {
		executePromptingMessage = vExecutePromptingMessage;
	}

	/**
	 * @return the executeFilePath
	 */
	public String getExecuteFilePath() {
		return executeFilePath;
	}

	/**
	 * @param vExecuteFilePath
	 *            the executeFilePath to set
	 */
	public void setExecuteFilePath(String vExecuteFilePath) {
		executeFilePath = vExecuteFilePath;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		if (!(other instanceof ExecutePolicyManagerBO))
			return false;
		ExecutePolicyManagerBO castOther = (ExecutePolicyManagerBO) other;
		return new EqualsBuilder().append(executeCheckTag,
				castOther.executeCheckTag).append(executeParameter,
				castOther.executeParameter).append(executePromptingMessage,
				castOther.executePromptingMessage).append(executeFilePath,
				castOther.executeFilePath).isEquals();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new HashCodeBuilder().append(executeCheckTag).append(
				executeParameter).append(executePromptingMessage).append(
				executeFilePath).toHashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new ToStringBuilder(this).append("executeCheckTag",
				executeCheckTag).append("executeParameter", executeParameter)
				.append("executePromptingMessage", executePromptingMessage)
				.append("executeFilePath", executeFilePath).toString();
	}

}
