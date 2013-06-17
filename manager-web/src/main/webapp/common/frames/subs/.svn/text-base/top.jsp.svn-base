<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <%@ include file="/common/meta.jsp" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
        <link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
	</head>
	<body class="bg">
		<div class="logo">
        </div>
<!-- 
        <div class="help">
            <a href="${ctx}/help.do" title="Help" target="_black"></a>
        </div>
 -->
        <div class="help">
            <a href="${ctx}/ismp/sysm/other/bbs.do?method=findAnswersAll" title="bbs" target="_black">bbs</a>
        </div>
        <div class="marqu">
            <marquee scrolldelay="400" onmousemove="stop()" onmouseout="start()" style="cursor:default;">
                                           尊敬的 
                <span class="font_bold">
                    <sec:authentication property="name"/>
                </span>
                                            欢迎光临本系统，您在系统中所属角色为：
                <span class="font_bold">
		            <sec:authorize ifAllGranted="ROLE_AdminAll">
	                                               超级管理员
	                </sec:authorize>
	                <sec:authorize ifAllGranted="ROLE_DomainAdminAll">
	                                               域管理员
	                </sec:authorize>
	                <sec:authorize ifAllGranted="ROLE_DomainAdminLocal">
	                                               域本地管理员
	                </sec:authorize>
	                <sec:authorize ifNotGranted="ROLE_AdminAll,ROLE_DomainAdminAll,ROLE_DomainAdminLocal">
	                                               未知
	                </sec:authorize>
                </span>
            </marquee>
        </div>
	</body>
</html>