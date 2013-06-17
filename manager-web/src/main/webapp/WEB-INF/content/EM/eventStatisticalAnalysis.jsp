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
<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<!-- <script type='text/javascript' src='项目名称/dwr/util.js'></script> -->
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script language="JavaScript" src="${ctx}/js/EM/g_datetime.js"></script>
<script type="text/javascript" src="${ctx }/js/EM/event.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
<link href="${ctx }/css/comm/other/Newcommon.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx }/css/comm/other/Maincontant.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="${ctx }/css/comm/other/common.css"
	type="text/css" />
<link rel="stylesheet" href="${ctx }/css/comm/other/boxy.css"
	type="text/css" />
<script type="text/javascript"
	src="${ctx }/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript"
	src="${ctx }/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript"
	src="${ctx }/js/comm/other/js/floatdiv.js"></script>
<title>无标题文档</title>

<script type="text/javascript">
	var CalendarWebControl = new atCalendarControl();

	function viewReport() {
		var start = document.getElementById("beginDate").value;
		var end = document.getElementById("endDate").value;
		var selectType = document.getElementById("jumpMenu").value;
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
		window.location.target = "childFrameEvent";
		if (selectType == 'sbType') {
			window.location.href = "EventGroupByDeviceType.do?startDate="
					+ start + ":00" + "&endDate=" + end + ":00&bureauId="
					+ bureauId;
		} else if (selectType == 'yu') {
			window.location.href = "EventGroupBySubDomain.do?startDate="
					+ start + ":00" + "&endDate=" + end + ":00";
		} else if (selectType == 'topTen') {
			window.location.href = "EventTop10.do?startDate=" + start + ":00"
					+ "&endDate=" + end + ":00&bureauId=" + bureauId;
		} else if (selectType == 'eventType') {
			window.location.href = "EventGroupByType.do?startDate=" + start
					+ ":00" + "&endDate=" + end + ":00&bureauId=" + bureauId;
		}
	}

	function changeMeth() {
		var selectType = document.getElementById("jumpMenu").value;
		if (selectType == 'sbType') {
			document.getElementById("report").value = "设备类型报表";
			document.getElementById("bureauId").style.display = "block";
			document.getElementById("wbj").style.display = "block";
		} else if (selectType == 'yu') {
			document.getElementById("report").value = "域报表";
			document.getElementById("bureauId").style.display = "none";
			document.getElementById("wbj").style.display = "none";
		} else if (selectType == 'topTen') {
			document.getElementById("report").value = "topTen报表";
			document.getElementById("bureauId").style.display = "block";
			document.getElementById("wbj").style.display = "block";
		} else if (selectType == 'eventType') {
			document.getElementById("report").value = "事件类型报表";
			document.getElementById("bureauId").style.display = "block";
			document.getElementById("wbj").style.display = "block";
		}
	}

	function doSubmit() {
		var start = document.getElementById("beginDate").value;
		var end = document.getElementById("endDate").value;
		var selectType = document.getElementById("jumpMenu").value;

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
		window.location.target = "childFrameEvent";
		if (selectType != 'yu') {
			var bureauId = document.getElementById("bureauId").value;
			window.location.href = "eventStatisticalAnals.do?method=eventAnalysis&beginDate="
					+ start
					+ "&endDate="
					+ end
					+ "&selectType="
					+ selectType
					+ "&bureauId=" + bureauId;
		} else {
			window.location.href = "eventStatisticalAnals.do?method=eventAnalysis&beginDate="
					+ start + "&endDate=" + end + "&selectType=" + selectType;
		}
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
<li class="act"><a
	href="${ctx }/eventStatisticalAnals.do?method=eventStatisticalAnalysis"><span
	style="background: url(${ctx }/img/comm/other/map01.png) no-repeat; padding-left: 22px;">统计分析</span></a></li>
<li class="nor"><a
	href="${ctx }/eventAction.do?method=eventInTimeSpecific"><span
	style="background: url(${ctx }/img/comm/other/053753177.gif) no-repeat; padding-left: 22px;">实时显示</span></a></li>
<li class="nor"><a
	href="${ctx }/eventCorrelationAction.do?method=eventCorrelation"><span
	style="background: url(${ctx }/img/comm/other/053753177.gif) no-repeat; padding-left: 22px;">事件关联</span></a></li>
<li class="nor"><a
	href="eventStatisticalAnals.do?method=eventDisplay"><span
	style="background: url(${ctx }/img/comm/other/045631195.gif) no-repeat; padding-left: 22px;">事件展示
</span></a></li>
</div>
<div class="contant">
<h2>过滤条件</h2>
<div class="greenborder greenback overf pad3">
<div class="pad3">
<table width="80%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>&nbsp;</td>
		<td>
		<table width="90%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td  align="right">统计类型：</td>
				<td><select name="jumpMenu" id="jumpMenu"
					onchange="changeMeth()">
					<c:if test="${selectType == 'sbType'}">
						<c:set var="select1" value="selected" />
					</c:if>
					<c:if test="${selectType == 'yu'}">
						<c:set var="select2" value="selected" />
					</c:if>
					<c:if test="${selectType == 'topTen'}">
						<c:set var="select3" value="selected" />
					</c:if>
					<c:if test="${selectType == 'eventType'}">
						<c:set var="select4" value="selected" />
					</c:if>

					<option value="sbType"${select1 } >设备类型统计</option>
					<option value="yu"${select2 }>域统计</option>
					<option value="topTen"${select3 }>源IP的TOP 10排名</option>
					<option value="eventType"${select4 }>事件类型统计</option>
				</select></td>
				<c:if test="${selectType == 'yu'}">
					<td id="wbj" style="display: none"  align="right">部门：</td>
					<td><select name="bureauId" id="bureauId"
						style="display: none">
						<c:forEach items="${managerOfUser }" var="manager">
							<c:if test="${bureauId == manager.id}">
								<option value="${manager.id }" selected="selected">${manager.domainName
								}</option>
							</c:if>
							<c:if test="${bureauId != manager.id}">
								<option value="${manager.id }">${manager.domainName }</option>
							</c:if>
						</c:forEach></td>
				</c:if>
				<c:if test="${selectType != 'yu'}">
					<td id="wbj"  align="right">部门：</td>
					<td><select name="bureauId" id="bureauId">
						<c:forEach items="${managerOfUser }" var="manager">
							<c:if test="${bureauId == manager.id}">
								<option value="${manager.id }" selected="selected">${manager.domainName
								}</option>
							</c:if>
							<c:if test="${bureauId != manager.id}">
								<option value="${manager.id }">${manager.domainName }</option>
							</c:if>
						</c:forEach></td>
				</c:if>
			</tr>
			<tr>
				<td align="right">起始日期：</td>
				<td><input id="beginDate" name="beginDate" class="Wdate"
					type="text" value="${begin }"
					onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
				<!-- <input type="text" class="inp" name="beginDate" id="beginDate" onFocus="CalendarWebControl.show(this,true,this.value);" readonly value="${begin }"/> -->
				</td>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<td align="right">终止日期：</td>
				<td><input id="endDate" name="endDate" class="Wdate"
					type="text" value="${end }"
					onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
				<!-- <input type="text" class="inp" name="endDate" id="endDate" onFocus="CalendarWebControl.show(this,true,this.value);" readonly value="${end }"/> -->
				</td>
			</tr>

			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>

		</table>
		</td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
		<td colspan="2"><input name="button" type="submit" id="button" value="显示统计结果"
			onclick="doSubmit()" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
			test="${selectType == 'sbType'}">
			<input name="report" type="button" id="report" value="设备类型报表"
				onclick="viewReport()" size="20" />
		</c:if> <c:if test="${selectType != 'sbType'}">
			<input name="report" type="button" id="report" value="报表查看"
				onclick="viewReport()" size="20" />
		</c:if></td>
	</tr>
</table>
</div>
</div>

<h2>列表显示</h2>
<div id="data" class="greenborder overf pad1 ">
<table id="senfe" sortcol="-1" width="100%">
<tr>
	<td width="600" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${selectType == 'sbType'}">
		<applet codebase="../manager-web/applet/topo/"
			code="org.infosec.ismp.applet.event.EventSafetyBarChart"
			archive="twaver-2.3.jar,spring-web-3.0.2.RELEASE.jar,spring-beans-3.0.2.RELEASE.jar,aopalliance-1.0.jar,spring-context-3.0.2.RELEASE.jar,spring-core-3.0.2.RELEASE.jar,commons-logging-api-1.1.jar,spring-aop-3.0.2.RELEASE.jar,commons-lang-2.5.jar,ismp-manager-rmi-1.0-SNAPSHOT.jar,ismp-topo-applet-2.0-SNAPSHOT.jar"
			name="Alert Picture Applet" width="100%" height="300" hspace="0"
			vspace="0" align="left">
			<param name="beginTime" value="${beginTime }" />
			<param name="endTime" value="${endTime }" />
			<param name="bureauId" value="${bureauId }" />
			<param name="serverpath" value="<%=basePath%>"/>
		</applet>
	</c:if> <c:if test="${selectType == 'yu'}">
		<applet codebase="../manager-web/applet/topo/"
			code="org.infosec.ismp.applet.event.EventPieChart.class"
			archive="twaver-2.3.jar,spring-web-3.0.2.RELEASE.jar,spring-beans-3.0.2.RELEASE.jar,aopalliance-1.0.jar,spring-context-3.0.2.RELEASE.jar,spring-core-3.0.2.RELEASE.jar,commons-logging-api-1.1.jar,spring-aop-3.0.2.RELEASE.jar,commons-lang-2.5.jar,ismp-manager-rmi-1.0-SNAPSHOT.jar,ismp-topo-applet-2.0-SNAPSHOT.jar"
			name="Alert Picture Applet" width="80%" height="300" hspace="0"
			vspace="0" align="left">
			<param name="beginTime" value="${beginTime }" />
			<param name="endTime" value="${endTime }" />
			<param name="bureauId" value="0" />
			<param name="serverpath" value="<%=basePath%>"/>
		</applet>
	</c:if> <c:if test="${selectType == 'topTen'}">
		<table border="1" width="100%">
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
				<td colspan="5" align="center">
					Sorry ! 暂无相应的数据...
				</td>
			</tr>
			</c:if>
			<c:forEach items="${eventStatisticsList}" var="obj">
				<tr>
						<td width="50">&nbsp;&nbsp;&nbsp;</td>
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
	</c:if> <c:if test="${selectType == 'eventType'}">
		<applet codebase="../manager-web/applet/topo/"
			code="org.infosec.ismp.applet.event.EventTypeBarChart.class"
			archive="twaver-2.3.jar,spring-web-3.0.2.RELEASE.jar,spring-beans-3.0.2.RELEASE.jar,aopalliance-1.0.jar,spring-context-3.0.2.RELEASE.jar,spring-core-3.0.2.RELEASE.jar,commons-logging-api-1.1.jar,spring-aop-3.0.2.RELEASE.jar,commons-lang-2.5.jar,ismp-manager-rmi-1.0-SNAPSHOT.jar,ismp-topo-applet-2.0-SNAPSHOT.jar"
			name="Alert Picture Applet" width="100%" height="300" hspace="0"
			vspace="0" align="left">
			<param name="beginTime" value="${beginTime }" />
			<param name="endTime" value="${endTime }" />
			<param name="bureauId" value="${bureauId }" />
			<param name="serverpath" value="<%=basePath%>"/>
		</applet>
	</c:if></td>
	<td width="400" align="left"><c:if
		test="${selectType == 'sbType'}">
		<table bgcolor="#D8D8D8" width="100%" border="1" align="center"
			cellpadding="0" cellspacing="0" class="css1">
			<tr>
				<td colspan="2" align="center">设备类型事件总量统计</td>
			</tr>
			<tr>
				<td align="center">设备类型</td>
				<td align="center">事件总量</td>
			</tr>
			<c:forEach items="${eventStatisticsList}" var="eventStatistic">
				<tr>
					<td align="center">${eventStatistic[0] }</td>
					<td align="center">${eventStatistic[1] }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if> <c:if test="${selectType == 'yu'}">
		<table bgcolor="#D8D8D8" width="100%" border="1" align="center"
			cellpadding="0" cellspacing="0" class="css1">
			<tr>
				<td colspan="2" align="center">域统计事件总量统计</td>
			</tr>
			<tr>
				<td align="center">域类型</td>
				<td align="center">事件总量</td>
			</tr>
			<c:forEach items="${eventStatisticsList}" var="eventStatistic">
				<tr>
					<td align="center">${eventStatistic[0] }</td>
					<td align="center">${eventStatistic[1] }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if> <c:if test="${selectType == 'eventType'}">
		<table bgcolor="#D8D8D8" width="100%" border="1" align="center"
			cellpadding="0" cellspacing="0" class="css1">
			<tr>
				<td colspan="2" align="center">事件类型事件总量统计</td>
			</tr>
			<tr>
				<td align="center">事件类型</td>
				<td align="center">事件总量</td>
			</tr>
			<c:forEach items="${eventStatisticsList}" var="eventStatistic">
				<tr>
					<td align="center">${eventStatistic[0] }</td>
					<td align="center">${eventStatistic[1] }</td>
				</tr>
			</c:forEach>
		</table>

	</c:if></td>
</tr>
<tr>
<td>&nbsp;</td>
</tr>
</table>
<br/>
<br/>
</div>
</div>
</div>

</body>
</html>
