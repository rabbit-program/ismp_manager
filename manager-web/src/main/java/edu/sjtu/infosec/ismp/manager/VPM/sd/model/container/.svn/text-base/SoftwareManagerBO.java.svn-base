package edu.sjtu.infosec.ismp.manager.VPM.sd.model.container;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Title: SoftwareManagerBO.java
 * @Package edu.sjtu.infosec.ismp.manager.virus.software.model
 * @Description: 软件信息对象
 * @author wjianzhuo
 * @date 2009-8-12 上午10:41:35
 * @version V1.0
 */
public class SoftwareManagerBO implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 3660630747037286029L;

	/**
	 * 软件基本信息
	 */
	private BaseInfoManagerBO baseInfoManagerBO;

	/**
	 * 软件分发策略
	 */
	private DispatchPolicyManagerBO dispatchPolicyManagerBO;

	/**
	 * 软件执行策略
	 */
	private ExecutePolicyManagerBO executePolicyManagerBO;

	/**
	 * 软件验证策略
	 */
	private ValidatePolicyManagerBO validatePolicyManagerBO;

	/**
	 * @return the dispatchPolicyManagerBO
	 */
	public DispatchPolicyManagerBO getDispatchPolicyManagerBO() {
		return dispatchPolicyManagerBO;
	}

	/**
	 * @param vDispatchPolicyManagerBO
	 *            the dispatchPolicyManagerBO to set
	 */
	public void setDispatchPolicyManagerBO(
			DispatchPolicyManagerBO vDispatchPolicyManagerBO) {
		dispatchPolicyManagerBO = vDispatchPolicyManagerBO;
	}

	/**
	 * @return the executePolicyManagerBO
	 */
	public ExecutePolicyManagerBO getExecutePolicyManagerBO() {
		return executePolicyManagerBO;
	}

	/**
	 * @param vExecutePolicyManagerBO
	 *            the executePolicyManagerBO to set
	 */
	public void setExecutePolicyManagerBO(
			ExecutePolicyManagerBO vExecutePolicyManagerBO) {
		executePolicyManagerBO = vExecutePolicyManagerBO;
	}

	/**
	 * @return the validatePolicyManagerBO
	 */
	public ValidatePolicyManagerBO getValidatePolicyManagerBO() {
		return validatePolicyManagerBO;
	}

	/**
	 * @param vValidatePolicyManagerBO
	 *            the validatePolicyManagerBO to set
	 */
	public void setValidatePolicyManagerBO(
			ValidatePolicyManagerBO vValidatePolicyManagerBO) {
		validatePolicyManagerBO = vValidatePolicyManagerBO;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		if (!(other instanceof SoftwareManagerBO))
			return false;
		SoftwareManagerBO castOther = (SoftwareManagerBO) other;
		return new EqualsBuilder().append(dispatchPolicyManagerBO,
				castOther.dispatchPolicyManagerBO).append(
				executePolicyManagerBO, castOther.executePolicyManagerBO)
				.append(baseInfoManagerBO, castOther.baseInfoManagerBO).append(
						validatePolicyManagerBO,
						castOther.validatePolicyManagerBO).isEquals();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new HashCodeBuilder().append(dispatchPolicyManagerBO).append(
				executePolicyManagerBO).append(baseInfoManagerBO).append(
				validatePolicyManagerBO).toHashCode();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see edu.sjtu.infosec.ismp.base.BaseObject#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return new ToStringBuilder(this).append("dispatchPolicyManagerBO",
				dispatchPolicyManagerBO).append("executePolicyManagerBO",
				executePolicyManagerBO).append("baseInfoManagerBO",
				baseInfoManagerBO).append("validatePolicyManagerBO",
				validatePolicyManagerBO).toString();
	}

	/**
	 * @return the baseInfoManagerBO
	 */
	public BaseInfoManagerBO getBaseInfoManagerBO() {
		return baseInfoManagerBO;
	}

	/**
	 * @param vBaseInfoManagerBO
	 *            the baseInfoManagerBO to set
	 */
	public void setBaseInfoManagerBO(BaseInfoManagerBO vBaseInfoManagerBO) {
		baseInfoManagerBO = vBaseInfoManagerBO;
	}

}
