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
function goPage(totalPage) {
    var useIn = document.getElementById("useIn").value;
    var winLen = document.getElementById("timeLen").value;
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
    window.location.href="eventCorrelationAction.do?method=eventCorrelationInUse"+"&mark="+mark+"&useIn="+useIn+"&winLen="+winLen;    
}
}
function selectAll(){
    var checkBoxList = document.getElementsByName("operate");
    for(i=0; i < checkBoxList.length; i++) {
           checkBoxList[i].checked = true;
    }
}

function reset(){
    var checkBoxList = document.getElementsByName("operate");
    for(i=0; i < checkBoxList.length; i++) {
           if(checkBoxList[i].checked){
               checkBoxList[i].checked = false;
           }
    }
}

function doDelete(){
    //var defineName = document.getElementById("defineName").value;
    var useIn = document.getElementById("useIn").value;
    var winLen = document.getElementById("timeLen").value;
    var defaultMark = document.getElementById("dMark").value;
    
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
    alert(deleteIn);
    if(window.confirm("你确定要删除吗?")){
        window.location.href="eventCorrelationAction.do?method=eventCorrelationDel&deleteIn="+deleteIn+"&mark="+defaultMark+"&useIn="+useIn+"&winLen="+winLen;//+"&eventName="+defineName;
    }
}

function init(useIn,timeLen){
	document.getElementById("useIn").value = useIn;
	document.getElementById("timeLen").value = timeLen;
}
</script>
</head>
<body onload="init('${useIn }','${timeLen }')">
<div id="contant" class="mainbg">
<div id="banner" class="grayline overf bannerH">
<li class="nor" id="m"><a href="${ctx }/eventAction.do?method=showListByTag"><span
	style="background: url(${ctx }/img/comm/other/03.gif) no-repeat; padding-left: 22px;">事件监测</span></a></li>
<li class="nor"><a href="${ctx }/eventSelectCondition.do?method=eventSelectCondition&select=safe"><span
	style="background: url(${ctx }/img/comm/other/05375363.gif) no-repeat; padding-left: 22px;">事件查询</span></a></li>
<li class="nor"><a href="${ctx }/eventStatisticalAnals.do?method=eventStatisticalAnalysis"><span
	style="background: url(${ctx }/img/comm/other/map01.png) no-repeat; padding-left: 22px;">统计分析</span></a></li>
<li class="nor"><a
	href="${ctx }/eventAction.do?method=eventInTimeSpecific"><span
	style="background: url(${ctx }/img/comm/other/053753177.gif) no-repeat; padding-left: 22px;">实时显示</span></a></li>
<li class="act"><a
	href="${ctx }/eventCorrelationAction.do?method=eventCorrelation"><span
	style="background: url(${ctx }/img/comm/other/053753177.gif) no-repeat; padding-left: 22px;">事件关联</span></a></li>
<li class="nor"><a href="eventStatisticalAnals.do?method=eventDisplay"><span
	style="background: url(${ctx }/img/comm/other/045631195.gif) no-repeat; padding-left: 22px;">事件展示
</span></a></li>
</div>
<input type="hidden" id="useIn" name="useIn"/>
<input type="hidden" id="timeLen" name="timeLen"/>
<h2 class="martop8">列表</h2>
<div id="data" class="greenborder overf pad1 ">
<table id="senfe" sortcol="-1">
	<thead>
            <tr>
				<th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓ </span></th>
                <th>时间</th> 
                <th>源IP</th> 
                <th>源端口</th> 
                <th>目的端口</th> 
                <th>威胁等级</th>
                <th>设备类型</th> 
                <th>事件类型</th> 
                <th>协议类型</th> 
                <th>目的IP</th> 
                <th>描述</th> 
                <th>统计</th>
            </tr>
</thead>
<tbody>
			<c:if test="${empty realDispList }">
				<tr>
					<td align="center" colspan="12">Sorry ! 暂无相应的数据...</td>
				</tr>
			</c:if>
            <c:forEach items="${realDispList}" var="obj" varStatus="status">
                <tr><td>${status.index+1 }</td>
                     <td>${obj[1] }</td> <td>${obj[2] }</td> <td>${obj[3] }</td> <td>${obj[4] }</td> <td>${obj[5] }</td>
                     <td>${obj[6] }</td> <td>${obj[7] }</td> <td>${obj[8] }</td> <td>${obj[9] }</td> <td>${obj[10] }</td>
                     <td>${obj[11] }</td>
                </tr>
               
            </c:forEach>
</tbody>
          </table>
</div>
      <div id="page">
        <ul>
          <li><a class="first" href="eventCorrelationAction.do?method=eventCorrelationInUse&pageno=1&useIn=${useIn}&winLen=${timeLen}"></a></li>

          <c:if test="${page.currentPage-1 >= 1}">
             <li><a class="pre" href="eventCorrelationAction.do?method=eventCorrelationInUse&pageno=${page.currentPage-1}&useIn=${useIn}&winLen=${timeLen}"></a></li>
          </c:if>
          <c:if test="${page.currentPage-1 <= 0}">
             <li><a class="pre" href="eventCorrelationAction.do?method=eventCorrelationInUse&pageno=1&useIn=${useIn}&winLen=${timeLen}"></a></li>
          </c:if>

          <c:if test="${page.currentPage+1 < page.totalPage}">
             <li><a class="next" href="eventCorrelationAction.do?method=eventCorrelationInUse&pageno=${page.currentPage+1}&useIn=${useIn}&winLen=${timeLen}"></a></li>
          </c:if>
          <c:if test="${page.currentPage+1 >= page.totalPage}">
             <li><a class="next" href="eventCorrelationAction.do?method=eventCorrelationInUse&pageno=${page.totalPage}&useIn=${useIn}&winLen=${timeLen}"></a></li>
          </c:if>
          
          <li><a class="last" href="eventCorrelationAction.do?method=eventCorrelationInUse&pageno=${page.totalPage}&useIn=${useIn}&winLen=${timeLen}"></a></li>
          <li>共 ${page.totalPage }页  第${page.currentPage }页  跳至
            <input type="text" size="4" name="mark" id="mark"/>页
            <input type="button" name="go" id="go" value="GO" size="4" onclick="goPage(${page.totalPage})"/>
          </li>
        </ul>
      </div>
<br />
<br />
<br />
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
