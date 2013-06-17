package edu.sjtu.infosec.ismp.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Sets;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * 
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 * 
 */
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

	private AccountManager accountManager;

	/**
	 * 获取用户Detail信息的回调函数.
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		User user = accountManager.findUserByLoginName(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户" + username + " 不存在");
		}

		Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(user);

		boolean enabled = user.getEnabled();
		boolean accountNonExpired = true;//过期时间
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;//锁定时间

		OperatorDetails userDetails = new OperatorDetails(user.getLoginName(),
				user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuths);
		// 加入登录时间信息和用户角色
		userDetails.setLoginTime(new Date());
		userDetails.setRoleList(new ArrayList(user.getRoles()));
		userDetails.setDomainList(new ArrayList(user.getDomains()));
		System.out.println("框架里的用户信息:"+userDetails);
		return userDetails;
	}

	/**
	 * 获得用户所有角色的权限.
	 */
	private Set<GrantedAuthority> obtainGrantedAuthorities(User user) {
		Set<GrantedAuthority> authSet = Sets.newHashSet();
		for (Role role : user.getRoles()) {
			System.out.println("role name is : " + role.getName());
			authSet.add(new GrantedAuthorityImpl("ROLE_" + role.getRole()));
		}
		return authSet;
	}

	@Autowired
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
}