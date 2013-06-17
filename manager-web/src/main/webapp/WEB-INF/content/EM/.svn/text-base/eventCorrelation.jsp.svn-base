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
<script type="text/javascript" language="javascript">
function doSave(){
    var rule_name = document.getElementById("rule_name").value;
    var corr_type = document.getElementById("corr_type").value;
    var prot_rule = document.getElementById("prot_rule").value;
    var src_ip = document.getElementById("src_ip").value;
    var dest_ip = document.getElementById("dest_ip").value;
    var dest_port = document.getElementById("dest_port").value;
    
    if(rule_name.length==0||corr_type.length==0||prot_rule.length==0||src_ip.length==0||dest_ip.length==0||dest_port.length==0){
        alert("请输入完全必要信息");
        return;
    }
    var parameter = "&rule_name="+rule_name+"&corr_type="+corr_type+"&prot_rule="+prot_rule+"&src_ip="+src_ip+"&dest_ip="+dest_ip+"&dest_port="+dest_port;//+"&winLen="+winLen;
    window.location.href="eventCorrelationAction.do?method=eventCorrelationSave"+parameter;
}

function goPage(totalPage){
    var mark=document.getElementById("mark").value;
    if(mark > totalPage){
        alert("最大页码值为："+totalPage);
        document.getElementById("mark").value = "";
        document.getElementById("mark").focus();
        return;
    }if(mark <= 0){
        alert("请输入有效的页码值!!");
        document.getElementById("mark").value = "";
        document.getElementById("mark").focus();
        return;
    }else{
        window.location.href="eventCorrelationAction.do?method=eventCorrelation"+"&mark="+mark;
    }    
}

function doReset(){
    document.getElementById("rule_name").value="";
    document.getElementById("dest_port").value="";
    document.getElementById("corr_type").value="";
    document.getElementById("prot_rule").value="";
    document.getElementById("src_ip").value="";
    document.getElementById("dest_ip").value="";
}

function Del(){
    var mark = document.getElementById("mark").value;
    var deleteIn = "";
    var isSelect = false;
    for(var i = 0; i < document.getElementsByName("operate").length; i ++){
        if(document.getElementsByName("operate")[i].checked){
            deleteIn = deleteIn + document.getElementsByName("operate")[i].value + ",";
            isSelect = true;
        }
    }  
    if(isSelect == false){
        alert("请选择你要删除的记录");
        return;
    }
    if(window.confirm("你确定要删除吗?")){
        window.location.href="eventCorrelationAction.do?method=correlationDelete&deleteIn="+deleteIn+"&mark="+mark;//+"&useIn="+useIn+"&winLen="+winLen;//+"&eventName="+defineName;
    }
}

function Use(){
    var winLen = document.getElementById("winLen").value;
    var useIn = "";
    for(var i = 0; i < document.getElementsByName("operate").length; i ++){
        if(document.getElementsByName("operate")[i].checked){
            useIn = useIn + document.getElementsByName("operate")[i].value + ",";
        }
    }  
    if(isNaN(winLen) || winLen.length == 0){
        alert("关联窗口长度必须输入的数字");
        return;
    }
    if(useIn.length == 0){
        alert("请选择要关联的规则")
        return;
    }
    if(window.confirm("你确定要关联吗")){
        window.location.href="eventCorrelationAction.do?method=eventCorrelationInUse&useIn="+useIn+"&winLen="+winLen;
    }
}

function doUpdate(){
    var rule_name = document.getElementById("rule_name").value;
    var corr_type = document.getElementById("corr_type").value;
    var prot_rule = document.getElementById("prot_rule").value;
    var src_ip = document.getElementById("src_ip").value;
    var dest_ip = document.getElementById("dest_ip").value;
    var dest_port = document.getElementById("dest_port").value;
    var id = document.getElementById("id").value;
    
    if(rule_name.length==0||corr_type.length==0||prot_rule.length==0||src_ip.length==0||dest_ip.length==0||dest_port.length==0){
        alert("请输入完全必要信息");
        return;
    }
    var parameter = "&rule_name="+rule_name+"&corr_type="+corr_type+"&prot_rule="+prot_rule+"&src_ip="+src_ip+"&dest_ip="+dest_ip+"&dest_port="+dest_port+"&id="+id;
    window.location.href="eventCorrelationAction.do?method=eventCorrelationDoUpdate"+parameter;
}
function v(){
	var rule_name = document.getElementById("rule_name").value;
	if(rule_name.length==0){
		alert("请输入完全必要信息");
		return false;
	}else{
		return true;
	}
}
</script>
</head>
<body>
<c:if test="${eventcorrrule.rule_name == null}">
	<form action="eventCorrelationAction.do?method=eventCorrelationSave"
		method="post" onsubmit="return v()">
</c:if>
<c:if test="${eventcorrrule.rule_name != null}">
	<form
		action="eventCorrelationAction.do?method=eventCorrelationDoUpdate"
		method="post" onsubmit="return v()">
</c:if>
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
<li class="act"><a
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
<table width="100%">
	<tr>
		<td>&nbsp;</td>
		<td align="left">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="css1">
			<tr>
				<td align="right" width="100">关联规则名称： <input type="hidden" name="id"
					id="id" value="${eventcorrrule.id }"></input></td>
				<td><input type="text" name="rule_name" id="rule_name"
					value="${eventcorrrule.rule_name }" /></td>
				<td align="right"  width="200">目的端口：</td>
				<td><select name="dest_port" id="dest_port">
					<c:if test="${eventcorrrule.dest_port == '类型任意' }">
						<c:set var="select1" value="selected"></c:set>
					</c:if>
					<c:if test="${eventcorrrule.dest_port == '类型相同' }">
						<c:set var="select2" value="selected"></c:set>
					</c:if>
					<option value="类型任意"${select1 }>类型任意</option>
					<option value="类型相同"${select2 }>类型相同</option>
				</select></td>
			</tr>
			<tr>
				<td align="right">关联类型：</td>
				<td><select name="corr_type" id="corr_type">
					<c:if test="${eventcorrrule.corr_type == '0' }">
						<c:set var="select3" value="selected"></c:set>
					</c:if>
					<c:if test="${eventcorrrule.corr_type == '1' }">
						<c:set var="select4" value="selected"></c:set>
					</c:if>
					<option value="0"${select3 }>类型任意</option>
					<option value="1"${select4 }>类型相同</option>
				</select></td>
				<td align="right">协议规则：</td>
				<td><select name="prot_rule" id="prot_rule">
					<c:if test="${eventcorrrule.prot_rule == '类型任意' }">
						<c:set var="select5" value="selected"></c:set>
					</c:if>
					<c:if test="${eventcorrrule.prot_rule == '类型相同' }">
						<c:set var="select6" value="selected"></c:set>
					</c:if>
					<option value="类型任意"${select5 }>类型任意</option>
					<option value="类型相同"${select6 }>类型相同</option>
				</select></td>
			</tr>
			<tr>
				<td align="right">源地址规则：</td>
				<td><select name="src_ip" id="src_ip">
					<c:if test="${eventcorrrule.src_ip == '类型任意' }">
						<c:set var="select7" value="selected"></c:set>
					</c:if>
					<c:if test="${eventcorrrule.src_ip == '类型相同' }">
						<c:set var="select8" value="selected"></c:set>
					</c:if>
					<option value="类型任意"${select7 }>类型任意</option>
					<option value="类型相同"${select8 }>类型相同</option>
				</select></td>
				<td align="right">目的地址规则：</td>
				<td><select name="dest_ip" id="dest_ip">
					<c:if test="${eventcorrrule.dest_ip == '类型任意' }">
						<c:set var="select9" value="selected"></c:set>
					</c:if>
					<c:if test="${eventcorrrule.dest_ip == '类型相同' }">
						<c:set var="select10" value="selected"></c:set>
					</c:if>
					<option value="类型任意"${select9 }>类型任意</option>
					<option value="类型相同"${select10 }>类型相同</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				<td align="center" colspan="2"><c:if
					test="${eventcorrrule.rule_name != null}">
					<input name="button" type="submit" id="button" value="添 加"
						disabled="disabled" />
					<input name="button2" type="reset" id="button2" value="重 置"
						onclick="doReset()" />
					<c:if test="${eventcorrrule.rule_name != null}">&nbsp;
                                        <input name="upd" type="submit"
							id="upd" value="修改" />
					</c:if>
				</c:if> <c:if test="${eventcorrrule.rule_name == null}">
					<input name="button" type="submit" id="button" value="添 加" />
					<input name="button2" type="reset" id="button2" value="重 置"
						onclick="doReset()" />
					<c:if test="${eventcorrrule.rule_name != null}">&nbsp;
                                        <input name="upd" type="submit"
							id="upd" value="修改" />
					</c:if>
				</c:if></td>
			</tr>
		</table>
		</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
</div>

<h2 class="martop8">关联规则列表</h2>
<div id="data" class="greenborder overf pad1 ">
<table id="senfe" sortcol="-1">
	<thead>
		<tr>
			<th style="cursor: pointer" onclick="sortTable('senfe',0);">序号 <span
				class="webdings">↓ </span></th>
			<th>名称</th>
			<th>关联类型</th>
			<th>协议规则</th>
			<th>源地址规则</th>
			<th>目的地址规则</th>
			<th>目的端口规则</th>
			<th>编辑</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty eventcorrruleList }">
			<tr>
				<td align="center" colspan="9">Sorry ! 暂无相应的数据...</td>
			</tr>
		</c:if>
		<c:forEach items="${eventcorrruleList}" var="eventcorrrule"
			varStatus="status">

			<tr>
				<td>${status.index+1 }</td>
				<td>${eventcorrrule.rule_name }</td>
				<c:if test="${eventcorrrule.corr_type == 0}">
					<td>类型任意</td>
				</c:if>
				<c:if test="${eventcorrrule.corr_type == 1}">
					<td>类型相同</td>
				</c:if>
				<td>${eventcorrrule.prot_rule }</td>
				<td>${eventcorrrule.src_ip }</td>
				<td>${eventcorrrule.dest_ip }</td>
				<td>${eventcorrrule.dest_port }</td>
				<td><a
					href="eventCorrelationAction.do?method=eventCorrelationUpdate&id=${eventcorrrule.id }">编辑</a></td>
				<td><input type="checkbox" name="operate" id="operate"
					value="${eventcorrrule.id}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div id="page">
<ul>
	<li><a class="first"
		href="eventCorrelationAction.do?method=eventCorrelation&pageno=1"></a></li>

	<c:if test="${page.currentPage-1 >= 1}">
		<li><a class="pre"
			href="eventCorrelationAction.do?method=eventCorrelation&pageno=${page.currentPage-1}"></a></li>
	</c:if>
	<c:if test="${page.currentPage-1 == 0}">
		<li><a class="pre"
			href="eventCorrelationAction.do?method=eventCorrelation&pageno=1"></a></li>
	</c:if>

	<c:if test="${page.currentPage+1 < page.totalPage}">
		<li><a class="next"
			href="eventCorrelationAction.do?method=eventCorrelation&pageno=${page.currentPage+1}"></a></li>
	</c:if>
	<c:if test="${page.currentPage+1 >= page.totalPage}">
		<li><a class="next"
			href="eventCorrelationAction.do?method=eventCorrelation&pageno=${page.totalPage}"></a></li>
	</c:if>

	<li><a class="last"
		href="eventCorrelationAction.do?method=eventCorrelation&pageno=${page.totalPage}"></a></li>
	<li>共 ${page.totalPage }页 第${page.currentPage }页 跳至 <input
		type="text" size="4" name="mark" id="mark" />页 <input type="button"
		name="go" id="go" value="GO" size="4"
		onclick="goPage(${page.totalPage})" /></li>
</ul>
<br />
<br />
<br />
</div>
</div>
</div>
</div>

<table align="right">
	<tr>
		<td colspan="6" align="right"><font color="red">关联窗口长度</font>：<input
			type="text" name="winLen" id="winLen" />秒 <input type="button"
			name="use" id="use" class="an-1" value="关联规则应用" onclick="Use();" />
		<input type="button" name="del" id="del" class="an-1" value="删除关联规则"
			onclick="Del()" /></td>
	</tr>
</table>

</form>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
