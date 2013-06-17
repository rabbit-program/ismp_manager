package edu.sjtu.infosec.ismp.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import edu.sjtu.infosec.ismp.manager.SYSM.user.self.service.UserService;

public class IPRoleAuthenticationFilter extends OncePerRequestFilter{
	
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res, FilterChain chain)
		throws IOException, ServletException {
	      // before we allow the request to proceed, we'll first get the user's role
	      // and see if it's an administrator
	      final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	      Object principal  = authentication.getPrincipal();
//	      if (principal instanceof OperatorDetails) {
//	    	  String username = ((OperatorDetails)principal).getUsername();
//	      } else {
//	    	  String username = principal.toString();
//	      }
//	      System.out.println("自定义过滤器："+authentication);
//	      System.out.println("认证用户内容" + principal);
	      if (authentication != null&& principal instanceof OperatorDetails) {
//	          boolean shouldCheck = false;
	    	  OperatorDetails user = (OperatorDetails)principal;
//	    	  List<Domain> domains = user.getDomainList();
//	    	  for(Domain department:domains){
//	    		  System.out.println("用户管理的域："+department.getDomainName());
//	    	  }
	    	  //对于不同角色的循环
	          for (GrantedAuthority authority : authentication.getAuthorities()) {
	        	  String ipaddress = req.getRemoteAddr();
	        	  boolean shouldAllow = true;
	        	  if(authority.getAuthority().trim().equals("ROLE_AdminAll")){
//	        		  System.out.println("@@@@@超级管里员"); 
	        		  shouldAllow = userService.loginService(ipaddress);
	        	  }else{
	        		  shouldAllow = userService.loginService(user.getDomainList(), ipaddress);
	        	  }
//	      		  if (list.get(0) == null) {
//	      			 shouldAllow = true;
//	      		  }
	      		  if(!shouldAllow) {
	                  // fail the requestAdvanced Confguration and Extension [ 160 ]
	                  throw new AccessDeniedException("Access has been denied for your IP address: "+req.getRemoteAddr());
	              }
//	              if(authority.getAuthority().equals(targetRole)) {
//	                  shouldCheck = true;
//	                  break;
//	                   }
//	          }
//	          // if we should check IP, then check
//	          if(shouldCheck && allowedIPAddresses.size() > 0) {
//	              boolean shouldAllow = false;
//	              for (String ipAddress : allowedIPAddresses) {
//	                  if(req.getRemoteAddr().equals(ipAddress)) {
//	                      shouldAllow = true;
//	                      break;
//	                  }
//	              }
//	              
//	              if(!shouldAllow) {
//	                  // fail the requestAdvanced Confguration and Extension [ 160 ]
//	                  throw new AccessDeniedException("Access has been denied for your IP address: "+req.getRemoteAddr());
//	              }
	          }
	      } else {
	        logger.warn("The IPRoleAuthenticationFilter should be placed after the user has been authenticated in the filter chain.");
	      }
	      chain.doFilter(req, res);  
	// accessors (getters and setters) omitted
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
