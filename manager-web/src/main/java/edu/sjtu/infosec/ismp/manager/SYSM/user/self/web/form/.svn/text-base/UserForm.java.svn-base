package edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.form;

import org.apache.struts.action.ActionForm;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.model.BlackAndWhiteBO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.vo.UserUpdateVO;
import edu.sjtu.infosec.ismp.manager.SYSM.user.self.web.vo.UserVO;
import edu.sjtu.infosec.ismp.security.User;

public class UserForm extends ActionForm{

	
	//封装用户名信息
	private User user=new User();

	
	//封装查询条件
	private UserVO uservo=new UserVO();
	
	//封装更新时候的用户基本信息
	
	private UserUpdateVO userupdatevo=new UserUpdateVO();
	

	private String depict;//委办局描述
	
	private String managerName;//委办局名称
	
	private Integer mid;//委办局ID
	
	private Integer rid;//角色ID
	
	public String toString() {
		return new ToStringBuilder(this).append("user", user).append("uservo",
				uservo).append("userupdatevo", userupdatevo).append("depict",
				depict).append("managerName", managerName).append("mid", mid)
				.append("rid", rid).append("blackandwhitebo", blackandwhitebo)
				.append("status", status).toString();
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public boolean equals(final Object other) {
		if (!(other instanceof UserForm))
			return false;
		UserForm castOther = (UserForm) other;
		return new EqualsBuilder().append(user, castOther.user).append(uservo,
				castOther.uservo).append(userupdatevo, castOther.userupdatevo)
				.append(depict, castOther.depict).append(managerName,
						castOther.managerName).append(mid, castOther.mid)
				.append(rid, castOther.rid).append(blackandwhitebo,
						castOther.blackandwhitebo).append(status,
						castOther.status).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(user).append(uservo).append(
				userupdatevo).append(depict).append(managerName).append(mid)
				.append(rid).append(blackandwhitebo).append(status)
				.toHashCode();
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}



	public UserUpdateVO getUserupdatevo() {
		return userupdatevo;
	}

	public void setUserupdatevo(UserUpdateVO userupdatevo) {
		this.userupdatevo = userupdatevo;
	}

	//黑白名单
	private BlackAndWhiteBO blackandwhitebo=new BlackAndWhiteBO();
	
	public BlackAndWhiteBO getBlackandwhitebo() {
		return blackandwhitebo;
	}

	public void setBlackandwhitebo(BlackAndWhiteBO blackandwhitebo) {
		this.blackandwhitebo = blackandwhitebo;
	}

	//特殊查询条件	
	private String status;//用户 状态
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if(status.equals("")||status.equals("2")){		
			this.uservo.setEnabled(null);
		}else{
			if(status.equals("0")){
			    this.uservo.setEnabled(false);	
			}else{
				this.uservo.setEnabled(true);
			}
		}
		this.status = status;
	}

	public UserVO getUservo() {
		return uservo;
	}

	public void setUservo(UserVO uservo) {
		this.uservo = uservo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
