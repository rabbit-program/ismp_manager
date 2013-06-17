<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css"
	type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css"
	type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript"
	src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript"
	src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" src="${ctx}/js/LM/goPage.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	$(".boxy").boxy();
});
</script>
</head>
<body>
<div id="contant" class="mainbg">
<div id="banner" class="grayline overf bannerH">
<li class="nor" id="m"><a
	href="${ctx }/ismp/lm/dlog/sysLogAction.do?method=originalDisplay"><span
	style="background:url(${ctx }/img/comm/other/virus.gif) no-repeat; padding-left:22px;">系统日志</span></a></li>
<sec:authorize ifAllGranted="ROLE_AdminAll">
	<li class="act" id="m"><a
		href="${ctx }/ismp/lm/pflog/systemLogAction.do?method=init"><span
		style="background:url(${ctx }/img/comm/other/01.gif) no-repeat; padding-left:22px;">平台日志</span></a></li>
</sec:authorize></div>
<div class="contant">
<div class="greenborder pad3 overf">
<h2 class="martop10">请选择查询条件</h2>
<div class="greenborder Height_a greenback overf pad3">
<form action="systemLogAction.do?method=init" method="post"><span
	style="float: left;"> 模块: <select name="moduleName">
	<option value="all" selected="selected">--全部--</option>
	<option value="拓扑管理">拓扑管理</option>
	<option value="资产管理">资产管理</option>
	<option value="运维支撑">运维支撑</option>
	<option value="等级保护">等级保护</option>
	<option value="病毒补丁">病毒补丁</option>
	<option value="服务检测">服务检测</option>
	<option value="事件管理">事件管理</option>
	<option value="态势感知">态势感知</option>
	<option value="风险评估">风险评估</option>
	<option value="日志审计">日志审计</option>
	<option value="应急响应">应急响应</option>
	<option value="告警管理">告警管理</option>
<option value="网站安全监测">网站安全监测</option>
    <option value="应用系统权限管理">应用系统权限管理</option>
    <option value="系统管理">系统管理</option>
</select> &nbsp;&nbsp;&nbsp; 起始时间: <input name="beginDate" class="Wdate"
	readonly="readonly" type="text" value="${dateList[0] }"
	onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
&nbsp;&nbsp;&nbsp; 截止时间: <input name="endDate" class="Wdate"
	readonly="readonly" type="text" value="${dateList[1] }"
	onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
</b> <input class="submit" type="submit" name="submit" value="搜索"
	style="margin-left: 12px;" /> <input class="submit" type="reset"
	name="reset" value="重置" /></span></form>

</div>
<h2 class="martop10">SystemLog列表</h2>
<div id="data" class="greenborder overf pad1">
<form name="f1" id="f1" action="" method="post">
<table id="senfe" sortcol="-1">
	<thead>
		<tr>
			<th style="cursor: pointer" onclick="sortTable('senfe',0);">序号 <span
				class="webdings">↓ </span></th>
			<th>时间</th>
			<th>用户名</th>
			<th>用户角色名</th>
			<th>模块名</th>
			<th>操作描述</th>
			<th>操作结果</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty pageResult.pageResult }">
			<tr>
				<td align="center" colspan="7">Sorry ! 暂无相应的数据...</td>
			</tr>
		</c:if>
		<c:forEach items="${pageResult.pageResult }" var="sysLogBean"
			varStatus="status">
			<tr>
				<td>${status.index + 1 }</td>
				<!-- 显示条数序号(<td>${sysLogBean.id }</td>  sysLog日志序号) -->
				<td>${sysLogBean.time }</td>
				<td>${sysLogBean.username }</td>
				<td>${sysLogBean.roleName }</td>
				<td>${sysLogBean.moduleName }</td>
				<td>
				<div class="tdcut" title="${sysLogBean.operationDesc }">${sysLogBean.operationDesc
				}</div>
				</td>
				<td>${sysLogBean.control }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form>
</div>
<ul id="page">
	<li><a class="first"
		href="systemLogAction.do?method=init&type=page"></a></li>

	<c:if test="${pageResult.pageNo-1 >= 1}">
		<li><a class="pre"
			href="systemLogAction.do?method=init&type=page&pageNo=${pageResult.pageNo-1 }"></a></li>
	</c:if>
	<c:if test="${pageResult.pageNo-1 == 0}">
		<li><a class="pre"
			href="systemLogAction.do?method=init&type=page"></a></li>
	</c:if>

	<c:if test="${pageResult.pageNo+1 < pageResult.pageMaxSum}">
		<li><a class="next"
			href="systemLogAction.do?method=init&type=page&pageNo=${pageResult.pageNo+1 }"></a></li>
	</c:if>
	<c:if test="${pageResult.pageNo+1 >= pageResult.pageMaxSum}">
		<li><a class="next"
			href="systemLogAction.do?method=init&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
	</c:if>

	<li><a class="last"
		href="systemLogAction.do?method=init&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
	<li>共 ${pageResult.pageMaxSum } 页 跳至 <input type="text" size="2"
		class="input" name="mark" /> &nbsp;</li>
	<li><a class="R6"
		href="javascript:goPage('${pageResult.pageMaxSum }','systemLogAction.do?method=init&type=page')">GO</a></li>
</ul>
<br />
<br />
<br />
</div>
</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>