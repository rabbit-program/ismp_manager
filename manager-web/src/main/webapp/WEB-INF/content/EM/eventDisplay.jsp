<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="org.springframework.context.ApplicationContext"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <META http-equiv="refresh" content="60"> -->
<!-- <script type='text/javascript' src='项目名称/dwr/util.js'></script> -->
<script language="JavaScript" src="${ctx}/js/EM/g_datetime.js"></script>
<script type="text/javascript" src="${ctx }/js/EM/event.js"></script>
<title>无标题文档</title>
<link href="${ctx }/css/comm/other/Newcommon.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx }/css/comm/other/Maincontant.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="${ctx }/css/comm/other/common.css"
	type="text/css" />
<link rel="stylesheet" href="${ctx }/css/comm/other/boxy.css"
	type="text/css" />
<script type="text/javascript" src="${ctx }/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx }/js/comm/other/sorttable.js"></script>
<script type="text/javascript"
	src="${ctx }/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript"
	src="${ctx }/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript"
	src="${ctx }/js/comm/other/js/floatdiv.js"></script>
<title>无标题文档</title>
<script type="text/javascript">
	function doStatical(type) {
		var start = document.getElementById("beginDate").value;
		var end = document.getElementById("endDate").value;
		if (start.length == "") {
			alert("请输入开始时间");
			document.getElementById("beginDate").focus();
			return;
		}
		if (end.length == "") {
			alert("请输入结束时间");
			document.getElementById("endDate").focus();
			return;
		}
		if (start > end) {
			alert("输入的开始时间必须要小于结束时间");
			return;
		}
		window.location.href = "eventStatisticalAnals.do?method=eventAnalysis&beginDate="
				+ start + "&endDate=" + end;

	}

	function doOk() {
		var start = document.getElementById("beginDate").value;
		var end = document.getElementById("endDate").value;
		var bureauId = document.getElementById("bureauId").value;

		if (start.length == "") {
			alert("请输入开始时间");
			document.getElementById("beginDate").focus();
			return;
		}
		if (end.length == "") {
			alert("请输入结束时间");
			document.getElementById("endDate").focus();
			return;
		}
		if (start > end) {
			alert("输入的开始时间必须要小于结束时间");
			return;
		}
		window.location.href = "eventStatisticalAnals.do?method=eventDisplay&beginDate="
				+ start + "&endDate=" + end + "&bureauId=" + bureauId;
	}
</script>

<%    
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

</head>
<body>
<div id="contant" class="mainbg">
<div id="banner" class="grayline overf bannerH">
<li class="nor" id="m"><a
	href="${ctx }/eventAction.do?method=showListByTag"><span
	style="background: url(${ctx }/img/comm/other/03.gif) no-repeat; padding-left: 22px;">事件监测</span></a></li>
<li class="nor"><a
	href="${ctx }/eventSelectCondition.do?method=eventSelectCondition&select=safe"><span
	style="background: url(${ctx }/img/comm/other/05375363.gif) no-repeat; padding-left: 22px;">事件查询</span></a></li>
<li class="nor"><a
	href="${ctx }/eventStatisticalAnals.do?method=eventStatisticalAnalysis"><span
	style="background: url(${ctx }/img/comm/other/map01.png) no-repeat; padding-left: 22px;">统计分析</span></a></li>
<li class="nor"><a
	href="${ctx }/eventAction.do?method=eventInTimeSpecific"><span
	style="background: url(${ctx }/img/comm/other/053753177.gif) no-repeat; padding-left: 22px;">实时显示</span></a></li>
<li class="nor"><a
	href="${ctx }/eventCorrelationAction.do?method=eventCorrelation"><span
	style="background: url(${ctx }/img/comm/other/053753177.gif) no-repeat; padding-left: 22px;">事件关联</span></a></li>
<li class="act"><a
	href="eventStatisticalAnals.do?method=eventDisplay"><span
	style="background: url(${ctx }/img/comm/other/045631195.gif) no-repeat; padding-left: 22px;">事件展示
</span></a></li>
</div>
<div class="contant">
<h2>过滤条件</h2>
<div class="greenborder greenback overf pad3">
<div class="pad3">
<table width="90%" border="0" align="center" cellpadding="0"
	cellspacing="0" class="css1">
	<tr>
		<td>&nbsp;&nbsp;部&nbsp;&nbsp;门&nbsp;&nbsp;：&nbsp;&nbsp;&nbsp;<select
			name="bureauId" id="bureauId">
			<c:forEach items="${managerOfUser }" var="manager">
				<c:if test="${bureauId == manager.id}">
					<option value="${manager.id }" selected="selected">${manager.domainName
					}</option>
				</c:if>
				<c:if test="${bureauId != manager.id}">
					<option value="${manager.id }">${manager.domainName }</option>
				</c:if>
			</c:forEach></td>
		<td colspan="2">统计开始时间：<input id="beginDate" name="beginDate"
			class="Wdate" type="text" value="${begin }"
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
		</td>
		<td colspan="2">统计结束时间：<input id="endDate" name="endDate"
			class="Wdate" type="text" value="${end }"
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
		</td>
		<td><input type="submit" name="statical" id="statical" value="确认"
			onclick="doOk()" /></td>
	</tr>

</table>
</div>
</div>
<br />
<h2>图表显示</h2>
<div id="data" class="greenborder overf pad1 ">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<!-- 展示四种统计类型 -->
	<tr>
		<td align="right"><applet codebase="../manager-web/applet/topo/"
			code="org.infosec.ismp.applet.event.EventSafetyBarChart.class"
			archive="twaver-2.3.jar,spring-web-3.0.2.RELEASE.jar,spring-beans-3.0.2.RELEASE.jar,aopalliance-1.0.jar,spring-context-3.0.2.RELEASE.jar,spring-core-3.0.2.RELEASE.jar,commons-logging-api-1.1.jar,spring-aop-3.0.2.RELEASE.jar,commons-lang-2.5.jar,ismp-manager-rmi-1.0-SNAPSHOT.jar,ismp-topo-applet-2.0-SNAPSHOT.jar"
			name="Alert Picture Applet" width="460" height="300" hspace="0"
			vspace="0" align="left">
			<param name="beginTime" value="${beginTime }" />
			<param name="endTime" value="${endTime }" />
			<param name="bureauId" value="${bureauId }" />
			<param name="serverpath" value="<%=basePath%>"/>
		</applet></td>
		<td><applet codebase="../manager-web/applet/topo/"
			code="org.infosec.ismp.applet.event.EventPieChart.class"
			archive="twaver-2.3.jar,spring-web-3.0.2.RELEASE.jar,spring-beans-3.0.2.RELEASE.jar,aopalliance-1.0.jar,spring-context-3.0.2.RELEASE.jar,spring-core-3.0.2.RELEASE.jar,commons-logging-api-1.1.jar,spring-aop-3.0.2.RELEASE.jar,commons-lang-2.5.jar,ismp-manager-rmi-1.0-SNAPSHOT.jar,ismp-topo-applet-2.0-SNAPSHOT.jar"
			name="Alert Picture Applet" width="460" height="300" hspace="0"
			vspace="0" align="left">
			<param name="beginTime" value="${beginTime }" />
			<param name="endTime" value="${endTime }" />
			<param name="bureauId" value="${bureauId }" />
			<param name="serverpath" value="<%=basePath%>"/>
		</applet></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td width="480" align="right" valign="top">
		<table border="1" width="400">
			<thead>
				<tr align="center">
					<th colspan="5" align="center">
					<h2><b>事件Top10排名</b></h2>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty eventStatisticsList}">
					<tr>
						<td colspan="5" align="center">Sorry ! 暂无相应的数据...</td>
					</tr>
				</c:if>
				<c:forEach items="${eventStatisticsList}" var="obj">
					<tr>
						<td width="20">&nbsp;&nbsp;&nbsp;</td>
						<td width="155">IP：<input type="text" value="${obj[3]}"
							readonly="readonly"></td>
						<td colspan="2"><img
							src="${ctx}/img/EM/eventTopTen${obj[0]}.gif" width="${obj[1] }"
							height="15" style="background-color: blue" /></img></td>
						<td width="100" align="left">${obj[2]}件</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</td>
		<td><applet codebase="../manager-web/applet/topo/"
			code="org.infosec.ismp.applet.event.EventTypeBarChart.class"
			archive="twaver-2.3.jar,spring-web-3.0.2.RELEASE.jar,spring-beans-3.0.2.RELEASE.jar,aopalliance-1.0.jar,spring-context-3.0.2.RELEASE.jar,spring-core-3.0.2.RELEASE.jar,commons-logging-api-1.1.jar,spring-aop-3.0.2.RELEASE.jar,commons-lang-2.5.jar,ismp-manager-rmi-1.0-SNAPSHOT.jar,ismp-topo-applet-2.0-SNAPSHOT.jar"
			name="Alert Picture Applet" width="460" height="300" hspace="0"
			vspace="0" align="left">
			<param name="beginTime" value="${beginTime }" />
			<param name="endTime" value="${endTime }" />
			<param name="bureauId" value="${bureauId }" />
			<param name="serverpath" value="<%=basePath%>"/>
		</applet></td>
	</tr>
</table>

</div>
</div>
</div>
</body>
</html>
