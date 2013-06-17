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
 * @Description: 软件执行策略信息对象
 * @author liuqing
 */
@Entity
@Table(name = "vpm_sd_execute_policy")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class ExecutePolicy implements Serializable {

	/**
	* @Fields serialVersionUID : 
	*    TODO
	*/
	private static final long serialVersionUID = 4324241047688597633L;

	/**
	 * 主键Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/**
	 * 分发后执行标志
	 */
	@Column(name="execute_check_tag")
	private Boolean executeCheckTag;

	/**
	 * 执行文件，相对路径 ：.//setup//setup.exe
	 */
	@Column(name="execute_file_path")
	private String executeFilePath;

	/**
	 * 执行参数
	 */
	@Column(name="execute_parameter")
	private String executeParameter;

	/**
	 * 提示信息
	 */
	@Column(name="execute_prompting_message")
	private String executePromptingMessage;
	

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
		if (!(other instanceof ExecutePolicy))
			return false;
		ExecutePolicy castOther = (ExecutePolicy) other;
		return new EqualsBuilder().append(id, castOther.id).append(executeCheckTag,
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
		return new HashCodeBuilder().append(id).append(executeCheckTag).append(
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
		return new ToStringBuilder(this).append(id).append("executeCheckTag",
				executeCheckTag).append("executeParameter", executeParameter)
				.append("executePromptingMessage", executePromptingMessage)
				.append("executeFilePath", executeFilePath).toString();
	}

}
