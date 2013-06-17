<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <%@ include file="/common/meta.jsp" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>信息安全监控综合管理代理</title>
	</head>
	<body>
        <center>
	<!-- 
			对不起，您没有被授权进行此操作，请联系管理员进行授权后，重新登陆再尝试此操作！
	 -->
	        <img src="${ctx}/img/comm/other/warn_unauthorized.png">
	        <br/>
	<!-- 
			<a href="javascript:history.go(-1);">返回</a>
	 -->
			<a href="${ctx}/j_spring_security_logout" target="_top">退出并重新登陆</a>
        </center>
	</body>
</html>