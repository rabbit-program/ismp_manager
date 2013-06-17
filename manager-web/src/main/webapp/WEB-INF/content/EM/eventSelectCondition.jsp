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
<script type="text/javascript">
var CalendarWebControl = new atCalendarControl();

function myReset(){
    var select = document.getElementById("select").value;
    window.location.href="eventSelectCondition.do?method=reset&select="+select;
}

function doSubmit(){
    var select = document.getElementById("select").value;
    if(select == "safe"){   
           var beginDate = document.getElementById("beginDate").value;
           var endDate = document.getElementById("endDate").value;
           var src_port = document.getElementById("src_port").value;
           var src_ip = document.getElementById("src_ip").value;
           var faci_type = document.getElementById("faci_type").value;
           var thre_rank = document.getElementById("thre_rank").value;
           var event_type = document.getElementById("event_type").value;
           var dest_port = document.getElementById("dest_port").value;

           if((beginDate != null && beginDate.length != 0) || (endDate != null && endDate != 0)){
                if(beginDate == null || beginDate.length == 0 || endDate == null || endDate.length == 0){
                    alert("请同时输入开始日期和结束日期");
                    return false;
                }
           }
           if(beginDate.length == 0  ||  endDate.length == 0){
                alert("请输入起止时间");
                return false;
           }
           if(beginDate>endDate){//表示开始时间大于结束时间
               alert("输入的开始时间必须小于结束时间");
               return false;
           }
           return true;
    }else if(select == "jiank"){
        var begin = document.getElementById("begin").value;
        var end = document.getElementById("end").value;
        var IPAddress = document.getElementById("IPAddress").value;
        //var eventTypes = document.getElementById("eventType").value;

        if((begin != null && begin.length != 0) || (end != null && end != 0)){
            if(begin == null || begin.length == 0 || end == null || end.length == 0){
                alert("请同时输入开始日期和结束日期");
                return false;
            }
       }
       if(begin.length == 0  ||  end.length == 0){
            alert("请输入起止时间");
            return false;
       }
       if(begin>end){//表示开始时间大于结束时间
           alert("输入的开始时间必须小于结束时间");
           return false;
       }

       return true;
    }
}

function goPages(totalPage){
    var beginDate = document.getElementById("beginDate").value;
    var endDate = document.getElementById("endDate").value;
    var src_port = document.getElementById("src_port").value;
    var src_ip = document.getElementById("src_ip").value;
    var faci_type = document.getElementById("faci_type").value;
    var thre_rank = document.getElementById("thre_rank").value;
    //var event_type = document.getElementById("event_type").value;
    var dest_port = document.getElementById("dest_port").value;
    var select = document.getElementById("select").value;
    var bureauId = document.getElementById("bureauId").value;
    var parameters = "&beginDate="+beginDate+"&endDate="+endDate+"&src_port="+src_port+"&src_ip="+src_ip+"&faci_type="+faci_type
                     +"&thre_rank="+thre_rank+"&dest_port="+dest_port+"&select="+select+"&bureauId="+bureauId;

    var mark=document.getElementById("mark").value;
    if(mark <= 0){
        alert("请输入有效的页码!!");
        document.getElementById("mark").value = ""
        document.getElementById("mark").focus();
        return;
    }else if(mark > totalPage){
        alert("最大页码值为："+totalPage);
        document.getElementById("mark").value = ""
        document.getElementById("mark").focus();
        return;
    }else{
        window.location.href="eventSelectCondition.do?method=selectByCondition&mark="+mark+parameters;
    }    
}

function goPage(totalPage){

    var begin = document.getElementById("begin").value;
    var end = document.getElementById("end").value;
    var IPAddress = document.getElementById("IPAddress").value;
    //var eventTypes = document.getElementById("eventTypes").value;
    var select = document.getElementById("select").value;
    var mark=document.getElementById("marks").value;
    var bureauId = document.getElementById("bureauId").value;
    
    var parameter = "&begin="+begin+"&end="+end+"&IPAddress="+IPAddress+"&select="+select+"&marks="+mark+"&bureauId="+bureauId;
   
    
    if(mark <= 0){
        alert("请输入有效的页码!!");
        document.getElementById("marks").value = ""
        document.getElementById("marks").focus();
        return;
    }else if(mark > totalPage){
        alert("最大页码值为："+totalPage);
        document.getElementById("marks").value = ""
        document.getElementById("marks").focus();
        return;
    }else{
        window.location.href="eventSelectCondition.do?method=selectByJianKong"+parameter;
    }
}

function selectChange(selectValue){
    if(selectValue != null && selectValue.length != ""){
        if(selectValue == "safe"){
            document.getElementById("jiankDisplay").style.display='none';
            document.getElementById("safe1").style.display='block';
            document.getElementById("safe2").style.display="block";
            document.getElementById("safe3").style.display="block";
            document.getElementById("safe4").style.display="block";
            document.getElementById("jiank1").style.display="none";
            document.getElementById("jiank2").style.display="none";
            document.getElementById("bureauId").style.display="block";
            document.getElementById("wbj").style.display="block";
            document.getElementById("safeDisplay").style.display='block';
        }else if(selectValue == "jiank"){
        	document.getElementById("safeDisplay").style.display='none';
        	document.getElementById("jiankDisplay").style.display='block';
            document.getElementById("jiank1").style.display="block";
            document.getElementById("jiank2").style.display="block";
            document.getElementById("bureauId").style.display="none";
            document.getElementById("wbj").style.display="none";
            document.getElementById("safe1").style.display="none";
            document.getElementById("safe2").style.display="none";
            document.getElementById("safe3").style.display="none";
            document.getElementById("safe4").style.display="none";
        }
    }else{
        var sValue = document.getElementById("select").value;
        if(sValue == "safe"){
        	document.getElementById("jiankDisplay").style.display='none';
        	document.getElementById("safeDisplay").style.display='block';
            document.getElementById("bureauId").style.display='block';
            document.getElementById("wbj").style.display="block";
            document.getElementById("safe1").style.display="block";
            document.getElementById("safe2").style.display="block";
            document.getElementById("safe3").style.display="block";
            document.getElementById("safe4").style.display="block";
            document.getElementById("jiank1").style.display="none";
            document.getElementById("jiank2").style.display="none";
        }else if(sValue == "jiank"){
        	document.getElementById("safeDisplay").style.display='none';
        	document.getElementById("jiankDisplay").style.display='block';
            document.getElementById("jiank1").style.display="block";
            document.getElementById("jiank2").style.display="block";
            document.getElementById("safe1").style.display="none";
            document.getElementById("safe2").style.display="none";
            document.getElementById("safe3").style.display="none";
            document.getElementById("safe4").style.display="none";
            document.getElementById("bureauId").style.display="none";
            document.getElementById("wbj").style.display="none";
        }
    }
}
</script>
</head>
<body onload="selectChange('${select}')">
<div id="contant" class="mainbg">
<div id="banner" class="grayline overf bannerH">
<li class="nor" id="m"><a
	href="${ctx }/eventAction.do?method=showListByTag"><span
	style="background: url(${ctx }/img/comm/other/03.gif) no-repeat; padding-left: 22px;">事件监测</span></a></li>
<li class="act"><a
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
<li class="nor"><a
	href="eventStatisticalAnals.do?method=eventDisplay"><span
	style="background: url(${ctx }/img/comm/other/045631195.gif) no-repeat; padding-left: 22px;">事件展示
</span></a></li>
</div>

<div class="contant">
<h2>过滤条件</h2>
<div class="greenborder greenback overf pad3">
<div class="pad3">
<form action="eventSelectCondition.do?method=selectMethod" method="post">
<table width="100%">
	<tr>
		<td align="right">事件类型：</td>
		<td><select name="select" id="select" onchange="selectChange('')">
			<c:if test="${select == 'safe'}">
				<c:set var="select1" value="selected" />
			</c:if>
			<c:if test="${select == 'jiank'}">
				<c:set var="select2" value="selected" />
			</c:if>
			<option value="safe"${select1 }>安全设备上报的事件</option>
			<!-- <option value="jiank"${select2 }>设备监控发现事件</option> -->
		</select></td>
		<td id="wbj" name="wbj"  align="right">部门：</td>
		<td><select name="bureauId" id="bureauId">
			<c:forEach items="${managerOfUser }" var="manager">
				<c:if test="${bureauId == manager.id}">
					<option value="${manager.id }" selected="selected">${manager.domainName
					}</option>
				</c:if>
				<c:if test="${bureauId != manager.id}">
					<option value="${manager.id }">${manager.domainName }</option>
				</c:if>
			</c:forEach>
		</select></td>
	</tr>
	<c:if test="${select == null}">
		<c:set var="safeDisplay" value="block" />
		<c:set var="jiankDisplay" value="none" />
	</c:if>
	<tr id="safe1" style="display: ${safeDisplay }">
		<td align="right">起始日期：</td>
		<td><input id="beginDate" name="beginDate" class="Wdate"
			readonly="readonly" type="text" value="${beginDate }"
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
		<!-- <input type="text" class="inp" name="beginDate" id="beginDate" onFocus="CalendarWebControl.show(this,true,this.value);" readonly value="${beginDate }"/>-->
		</td>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<td  align="right">终止日期：</td>
		<td><input id="endDate" name="endDate" class="Wdate" type="text"
			readonly="readonly" value="${endDate }"
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
		<!-- <input type="text" class="inp" name="endDate" id="endDate" onFocus="CalendarWebControl.show(this,true,this.value);" readonly value="${endDate }"/> -->
		</td>
	</tr>
	<tr id="safe2" style="display: ${safeDisplay }">
		<td width="13%"  align="right">源端口：</td>
		<td width="36%"><input type="text" name="src_port" id="src_port"
			value="${eventSelectConditionForm.src_port }" /></td>
		<td width="13%"  align="right">源IP：</td>
		<td width="36%"><input type="text" name="src_ip" id="src_ip"
			value="${eventSelectConditionForm.src_ip }" /></td>
	</tr>
	<tr id="safe3" style="display:${safeDisplay }">
		<td  align="right">设备类型：</td>
		<td><input type="text" name="faci_type" id="faci_type"
			value="${eventSelectConditionForm.faci_type }" /></td>
		<td  align="right">威胁等级：</td>
		<td><input type="text" name="thre_rank" id="thre_rank"
			value="${eventSelectConditionForm.thre_rank }" /></td>
	</tr>
	<tr id="safe4" style="display:${safeDisplay }">
		<td  align="right">事件类型：</td>
		<td><input type="text" name="event_type" id="event_type"
			value="${eventSelectConditionForm.event_type }" /></td>
		<td width="10%"  align="right">目的端口：</td>
		<td><input type="text" name="dest_port" id="dest_port"
			value="${eventSelectConditionForm.dest_port }" /></td>
	</tr>

	<tr id="jiank1" style="display: ${jiankDisplay }">
		<td  align="right"> 起始日期：</td>
		<td><input id="begin" value="${begin }" name="begin"
			readonly="readonly" class="Wdate" type="text"
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
		<!-- <input type="text" class="inp" name="beginTime" id="beginTime" onFocus="CalendarWebControl.show(this,true,this.value);" readonly/>-->
		</td>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<td  align="right">终止日期：</td>
		<td><input id="end" value="${end }" name="end" class="Wdate"
			readonly="readonly" type="text"
			onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
		<!-- <input type="text" class="inp" name="endTime" id="endTime" onFocus="CalendarWebControl.show(this,true,this.value);" readonly/> -->
		</td>
	</tr>
	<tr id="jiank2" style="display: ${jiankDisplay }">
		<td  align="right">IP地址：</td>
		<td><input type="text" name="IPAddress" id="IPAddress"
			value="${eventSelectConditionForm.IPAddress }" /></td>
		<td align="right">事件类型：</td>
		<td><input type="text" name="eventTypes" id="eventTypes"
			value="${eventSelectConditionForm.eventTypes }" /></td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
		<td colspan="2"><input name="button" type="submit" id="button"
			value="查 询" onmouseover="doSubmit()" /> <input name="button2"
			type="button" id="button2" value="重置" onclick="myReset()" /></td>
	</tr>
</table>
</form>
</div>
</div>

<h2>列表显示</h2>
<div id="data" class="greenborder overf pad1 ">
<div id="safeDisplay">
<table id="senfe" sortcol="-1" width="100%">
	<thead>
		<tr>
			<th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓ </span></th>
			<th>时间</th>
			<th>源IP</th>
			<th>源端口</th>
			<th>目的IP</th>
			<th>目的端口</th>
			<th>威胁等级</th>
			<th>设备类型</th>
			<th>事件类型</th>
			<th>协议类型</th>
			<th>描述</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty eventrealdispList }">
			<tr>
				<td align="center" colspan="11">Sorry ! 暂无相应的数据...</td>
			</tr>
		</c:if>
		<c:if test="${eventrealdispList != null}">
			<c:forEach items="${eventrealdispList }" var="realdisp" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${realdisp[2].eventTime }</td>
					<td>${realdisp[2].srcIp }</td>
					<td>${realdisp[2].srcPort }</td>
					<td>${realdisp[2].destIp }</td>
					<td>${realdisp[2].destPort }</td>
					<td>${realdisp[2].threRank }</td>
					<td>${realdisp[2].faciType }</td>
					<td>${realdisp[2].eventType }</td>
					<c:if
						test="${realdisp[2].prot_type == null || realdisp[2].prot_type == '' || realdisp[2].prot_type == 'null'}">
						<td></td>
					</c:if>
					<c:if
						test="${realdisp[2].prot_type != null && realdisp[2].prot_type != '' && realdisp[2].prot_type != 'null'}">
						<td>${realdisp[2].prot_type}</td>
					</c:if>
					<c:if
						test="${realdisp[2].descrip == null || realdisp[2].descrip == '' || realdisp[2].descrip == 'null'}">
						<td></td>
					</c:if>
					<c:if
						test="${realdisp[2].descrip != null && realdisp[2].descrip != '' && realdisp[2].descrip != 'null'}">
						<td> <div class="tdcut" title="${realdisp[2].descrip }">${realdisp[2].descrip }</div> </td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<div id="page">
<ul>
	<li><a class="first"
		href="eventSelectCondition.do?method=selectByCondition&pageno=1&beginDate=${beginDate}&endDate=${endDate}&src_port=${src_port}&src_ip=${src_ip}&thre_rank=${thre_rank}&dest_port=${dest_port}&select=${select }&bureauId=${bureauId }"></a></li>

	<c:if test="${page.currentPage-1 >= 1}">
		<li><a class="pre"
			href="eventSelectCondition.do?method=selectByCondition&pageno=${page.currentPage-1}&beginDate=${beginDate}&endDate=${endDate}&src_port=${src_port}&src_ip=${src_ip}&thre_rank=${thre_rank}&dest_port=${dest_port}&select=${select }&bureauId=${bureauId }"></a></li>
	</c:if>
	<c:if test="${page.currentPage-1 <= 0}">
		<li><a class="pre"
			href="eventSelectCondition.do?method=selectByCondition&pageno=1&beginDate=${beginDate}&endDate=${endDate}&src_port=${src_port}&src_ip=${src_ip}&thre_rank=${thre_rank}&dest_port=${dest_port}&select=${select }&bureauId=${bureauId }"></a></li>
	</c:if>

	<c:if test="${page.currentPage+1 < page.totalPage}">
		<li><a class="next"
			href="eventSelectCondition.do?method=selectByCondition&pageno=${page.currentPage+1}&beginDate=${beginDate}&endDate=${endDate}&src_port=${src_port}&src_ip=${src_ip}&thre_rank=${thre_rank}&dest_port=${dest_port}&select=${select }&bureauId=${bureauId }"></a></li>
	</c:if>
	<c:if test="${page.currentPage+1 >= page.totalPage}">
		<li><a class="next"
			href="eventSelectCondition.do?method=selectByCondition&pageno=${page.totalPage}&beginDate=${beginDate}&endDate=${endDate}&src_port=${src_port}&src_ip=${src_ip}&thre_rank=${thre_rank}&dest_port=${dest_port}&select=${select }&bureauId=${bureauId }"></a></li>
	</c:if>

	<li><a class="last"
		href="eventSelectCondition.do?method=selectByCondition&pageno=${page.totalPage}&beginDate=${beginDate}&endDate=${endDate}&src_port=${src_port}&src_ip=${src_ip}&thre_rank=${thre_rank}&dest_port=${dest_port}&select=${select }&bureauId=${bureauId }"></a></li>
	<li>共 ${page.totalPage }页 第${page.currentPage }页 跳至 <input
		type="text" size="4" name="mark" id="mark" />页 <input type="button"
		name="go" id="go" value="GO" size="4"
		onclick="goPages(${page.totalPage})" /></li>
</ul>
<br />
<br />
<br />
</div>
</div>
<div id="jiankDisplay">
<table id="senfe" sortcol="-1">
	<thead>
		<tr>
			<th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓ </span></th>
			<th>事件生成时间</th>
			<th>事件类型</th>
			<th>触发值</th>
			<th>状态参数阈值</th>
			<th>设备IP地址</th>
			<th>事件描述</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty eventmoniinfoList }">
			<tr>
				<td align="center" colspan="7">Sorry ! 暂无相应的数据...</td>
			</tr>
		</c:if>
		<c:if test="${eventmoniinfoList != null}">
			<c:forEach items="${eventmoniinfoList }" var="eventmoni" step="1"
				varStatus="state">
				<tr>
					<td>${state.index + 1}</td>
					<td>${eventmoni.time}</td>
					<td>${eventmoni.eventType }</td>
					<td>${eventmoni.alertValue }</td>
					<td>${eventmoni.threshold }</td>
					<td>${eventmoni.ipAddress }</td>
					<c:if
						test="${eventmoni.descrip == null || eventmoni.descrip == '' || eventmoni.descrip == 'null'}">
						<td></td>
					</c:if>
					<c:if
						test="${eventmoni.descrip != null && eventmoni.descrip != '' && eventmoni.descrip != 'null'}">
						<td>${eventmoni.descrip }</td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table>
<div id="page">
<ul>
	<li><a class="first"
		href="eventSelectCondition.do?method=selectByJianKong&pageno=1&begin=${begin}&end=${end}&select=${select }&bureauId=${bureauId }"></a></li>

	<c:if test="${page.currentPage-1 >= 1}">
		<li><a class="pre"
			href="eventSelectCondition.do?method=selectByJianKong&pageno=${page.currentPage-1}&begin=${begin}&end=${end}&select=${select }&bureauId=${bureauId }"></a></li>
	</c:if>
	<c:if test="${page.currentPage-1 <= 0}">
		<li><a class="pre"
			href="eventSelectCondition.do?method=selectByJianKong&pageno=1&begin=${begin}&end=${end}&select=${select }&bureauId=${bureauId }"></a></li>
	</c:if>

	<c:if test="${page.currentPage+1 < page.totalPage}">
		<li><a class="next"
			href="eventSelectCondition.do?method=selectByJianKong&pageno=${page.currentPage+1}&begin=${begin}&end=${end}&select=${select }&bureauId=${bureauId }"></a></li>
	</c:if>
	<c:if test="${page.currentPage+1 >= page.totalPage}">
		<li><a class="next"
			href="eventSelectCondition.do?method=selectByJianKong&pageno=${page.totalPage}&begin=${begin}&end=${end}&select=${select }&bureauId=${bureauId }"></a></li>
	</c:if>

	<li><a class="last"
		href="eventSelectCondition.do?method=selectByJianKong&pageno=${page.totalPage}&begin=${begin}&end=${end}&select=${select}&bureauId=${bureauId }"></a></li>
	<li>共 ${page.totalPage }页 第${page.currentPage }页 跳至 <input
		type="text" size="4" name="marks" id="marks" />页 <input type="button"
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
</div>

</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
