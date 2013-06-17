<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <%@ include file="/common/meta.jsp" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>信息安全监控综合管理代理</title>
	</head>
    <frameset rows="91,*" framespacing="0" border="0" frameborder="no">
		<frame src="${ctx}/common/frames/subs/top.jsp" scrolling="no" noresize="noresize" id="topFrame"></frame>
		<frameset cols="180,13,*" framespacing="0" frameborder="no" id="MainFrame" name="MainFrame">
			<frame src="${ctx}/common/frames/subs/left.jsp" name="left" scrolling="auto" noresize="noresize" id="menu"></frame>
			<frame src="${ctx}/common/frames/subs/min.jsp" frameborder="no" scrolling="no" noresize="noresize" id="min" name="middle"></frame>
			<frame src="${ctx}/fwdPage.do" name="mainContant" scrolling="auto" noresize="noresize" ></frame>
		</frameset>
	</frameset>
    <noframes>
		<body>
			<center>
				正在建设中...
		        <a href="${ctx}/j_spring_security_logout">logout</a>
			</center>
		</body>
    </noframes>
</html>