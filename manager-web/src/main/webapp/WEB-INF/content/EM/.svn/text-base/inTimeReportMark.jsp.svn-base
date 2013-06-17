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
<script type="text/javascript"
	src="${ctx}/dwr/interface/EventSrviceClient.js"></script>
<script type="text/javascript">
Date.prototype.format = function(format)   
{   
   var o = {   
     "M+" : this.getMonth()+1, //month   
     "d+" : this.getDate(),    //day   
     "h+" : this.getHours(),   //hour   
     "m+" : this.getMinutes(), //minute   
     "s+" : this.getSeconds(), //second   
     "q+" : Math.floor((this.getMonth()+3)/3), //quarter   
     "S"  : this.getMilliseconds() //millisecond   
   }   
   if(/(y+)/.test(format)) format=format.replace(RegExp.$1,   
     (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
   for(var k in o)if(new RegExp("("+ k +")").test(format))   
     format = format.replace(RegExp.$1,   
       RegExp.$1.length==1 ? o[k] :    
         ("00"+ o[k]).substr((""+ o[k]).length));   
   return format;   
}

function doOk(){
	var maxCount = document.getElementById("maxCount").value;
	var bureauId = document.getElementById("bureauId").value;
	if(maxCount!=""){
		if(maxCount<5){
			alert("显示的记录数请不要少于  5  条");
			document.getElementById("maxCount").value="";
			return ;
		}
	}
	window.location.href = "eventAction.do?method=eventInTimeSpecific&maxCount="+maxCount+"&bureauId="+bureauId;
}
//var myData = new Array();
function createRawEventRow(data){
	var tbody = document.getElementById("tBody");
	
	 var col0 =document.createElement("TD");//添加列
	 col0.appendChild(document.createTextNode(data.domain));
     
     var col1 =document.createElement("TD");//添加列
     col1.appendChild(document.createTextNode(data.eventTime.format("yyyy-MM-dd hh:mm:ss")));
     
     var col2 =document.createElement("TD");//添加列
     col2.appendChild(document.createTextNode(data.srcIp));

     var col3 =document.createElement("TD");//添加列
     col3.appendChild(document.createTextNode(data.srcPort));
     
     var col4 =document.createElement("TD");//添加列
     col4.appendChild(document.createTextNode(data.destIp));
     
     var col5 =document.createElement("TD");//添加列
     col5.appendChild(document.createTextNode(data.destPort));
     
     var col6 =document.createElement("TD");//添加列
     col6.appendChild(document.createTextNode(data.threRank));
     
     var col7 =document.createElement("TD");//添加列
     col7.appendChild(document.createTextNode(data.faciType));
     
     var col8 =document.createElement("TD");//添加列
     col8.appendChild(document.createTextNode(data.eventType));
     
     var col9 =document.createElement("TD");//添加列
     col9.appendChild(document.createTextNode(data.protType));
     
     var col10 =document.createElement("TD");//添加列

     	var div = document.createElement("div");
		var innerHTML = data.descrip;
     	div.innerHTML = innerHTML;
     	div.title = innerHTML;
     	div.className = 'tdcut';
     	
     col10.appendChild(div);
     
     var row = document.createElement("TR"); //添加行
     row.appendChild(col0);//把列应用到行
     row.appendChild(col1);//把列应用到行
     row.appendChild(col2);
     row.appendChild(col3);
     row.appendChild(col4);
     row.appendChild(col5);
     row.appendChild(col6);
     row.appendChild(col7);
     row.appendChild(col8);
     row.appendChild(col9);
     row.appendChild(col10);

     var firstRow = tbody.getElementsByTagName("TR")[0];//得到第一行
     if(firstRow != null){
         var maxCount = "${maxCount}";
         if(maxCount!=null && maxCount.length>0){
        	 if(tbody.childNodes.length >= maxCount){
                 removeLastRow(tbody);
             }
         }else{
        	 if(tbody.childNodes.length >= 13){
                 removeLastRow(tbody);
             }
         }
         
    	 tbody.insertBefore(row, firstRow);//把当前产生的这行插入到第一行的前面
    	 senfe('senfe','#fff','#eee','#fdf4db','');
     }else{
         tbody.appendChild(row);//如果没有第一行就添加行
     }
}
//移走最后一行
function removeLastRow(tbody)
{
    var length = tbody.childNodes.length;
    var last_row_show = tbody.getElementsByTagName("TR")[length-1];
//    var last_row_show=tbody.childNodes[length-1];
    tbody.removeChild(last_row_show);
}
function goPage() {
    var mark=document.getElementById("mark").value;
    window.location.href="eventAction.do?method=showListByTag"+"&mark="+mark+"&bureauId="+bureauId;;    
   }
function callback(data){
	if(data.length > 0){
	    for(var j = 0; j < data.length; j ++){
	    	   createRawEventRow(data[j]);
        }
	}
    setTimeout("eventLoad()", 1000);
}

function errh(errorString, exception){
    <%request.setAttribute("faile",true);%>
    //alert("通信服务启动错误");
}

function eventLoad(){
	dwr.engine.setErrorHandler(errh);
	EventSrviceClient.doRealtimeEvents("${bureauIds}",callback);
}

function chakan(){
    var bureauId = document.getElementById("bureauId").value;
    if(bureauId.length == 0){
        alert("请选择部门");
        return;
    }
    var maxCount = document.getElementById("maxCount").value;
	if(maxCount!=""){
    	if(maxCount<5){
			alert("显示的记录数请不要少于  5  条");
			document.getElementById("maxCount").value="";
			return ;
		}
	}
    window.location.href = "eventAction.do?method=eventInTimeSpecific&maxCount="+maxCount+"&bureauId="+bureauId;
}
</script>
<title>无标题文档</title>
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
</head>
<body onload="eventLoad()">
<div id="contant" class="mainbg">
<div id="banner" class="grayline overf bannerH">
<li class="nor" id="m"><a href="${ctx }/eventAction.do?method=showListByTag"><span
	style="background: url(${ctx }/img/comm/other/03.gif) no-repeat; padding-left: 22px;">事件监测</span></a></li>
<li class="nor"><a href="${ctx }/eventSelectCondition.do?method=eventSelectCondition&select=safe"><span
	style="background: url(${ctx }/img/comm/other/05375363.gif) no-repeat; padding-left: 22px;">事件查询</span></a></li>
<li class="nor"><a href="${ctx }/eventStatisticalAnals.do?method=eventStatisticalAnalysis"><span
	style="background: url(${ctx }/img/comm/other/map01.png) no-repeat; padding-left: 22px;">统计分析</span></a></li>
<li class="act"><a
	href="${ctx }/eventAction.do?method=eventInTimeSpecific"><span
	style="background: url(${ctx }/img/comm/other/053753177.gif) no-repeat; padding-left: 22px;">实时显示</span></a></li>
<li class="nor"><a
	href="${ctx }/eventCorrelationAction.do?method=eventCorrelation"><span
	style="background: url(${ctx }/img/comm/other/053753177.gif) no-repeat; padding-left: 22px;">事件关联</span></a></li>
<li class="nor"><a href="eventStatisticalAnals.do?method=eventDisplay"><span
	style="background: url(${ctx }/img/comm/other/045631195.gif) no-repeat; padding-left: 22px;">事件展示
</span></a></li>
</div>
<div class="contant">
<h2>过滤条件</h2>
<div class="greenborder greenback overf pad3 Height_a">
<div class="pad3"><font size="2">&nbsp;&nbsp;&nbsp;&nbsp;部门：</font><select
	name="bureauId" id="bureauId">
	<option>----全部----</option>
	<c:forEach items="${managerBoList }" var="manager">
		<c:if test="${bureauId == manager.id}">
			<option value="${manager.id }" selected="selected">${manager.domainName
			}</option>
		</c:if>
		<c:if test="${bureauId != manager.id}">
			<option value="${manager.id }">${manager.domainName }</option>
		</c:if>
	</c:forEach>
	<input type="button" class="submit" id="button" value="确定" onclick="chakan()" /></div>
</div>
<h2 class="martop8">实时列表显示</h2>
<div id="data" class="greenborder overf pad1 ">
<table id="senfe" sortcol="-1">
	<thead>
		<tr>
			<th>部门名称</th>
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
	<tbody id="tBody" name="tBody">
	</tbody>
	<tr align="center">
		<td colspan="11" align="center">您需要显示的记录数：<input type="text"
			name="maxCount" id="maxCount" value="${maxCount}" /><input
			type="button" class="submit" name="OK" id="OK" onclick="doOk()" value="确定"></td>
	</tr>
</table>
</div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>

