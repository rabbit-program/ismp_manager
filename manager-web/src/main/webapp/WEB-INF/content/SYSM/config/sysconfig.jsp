<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <jsp:include page="/WEB-INF/content/SYSM/user/top.jsp"></jsp:include>
  </div>
  <div class="contant">
    <div id="data" class=" pad3 overf">
		<sec:authorize ifAllGranted="ROLE_AdminAll">
	        <jsp:include page="/WEB-INF/content/SYSM/config/sysConfig/index.jsp"></jsp:include>
	        <br/>
		</sec:authorize>
        <sec:authorize ifAllGranted="ROLE_AdminAll">
            <jsp:include page="/WEB-INF/content/SYSM/config/client/index.jsp"></jsp:include>
            <br/>
        </sec:authorize>
        <jsp:include page="/WEB-INF/content/SYSM/config/lm/dLog/dLogConfig.jsp"></jsp:include>
    	
    </div>
  </div>
</div>
</body>
</html>
