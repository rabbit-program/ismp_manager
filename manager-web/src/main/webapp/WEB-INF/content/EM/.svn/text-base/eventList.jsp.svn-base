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
var xmlReq;// = new ActiveXObject("microsoft.XMLHTTP");
function createXMLReq(){
    if(window.XMLHttpRequest){
        xmlReq = new XMLHttpRequest();
    }else if(window.ActiveXObject){
        xmlReq = new ActiveXObject("microsoft.XMLHTTP");
    }
}
function deviceInView(index){
    //alert("inner deviceInView");
    createXMLReq();
    var ip = document.getElementById("IP"+index).value;
    //alert(ip);
    var id = document.getElementById("Id"+index).value;
    var bureauId = document.getElementById("bureauId"+index).value;
    var para = "&eventFaciIp="+ip+"&id="+id+"&bureauId="+bureauId;
    //alert(para);
    xmlReq.open("GET", "eventAction.do?method=deviceInView"+para, true);
    xmlReq.onreadystatechange = getResult;
    xmlReq.send(null);
}
function getResult(){
    //var obj = {"name":"weblogic 10服务器","type":"null","add":"192.168.9.253","mac":"002481C4D499","state":"null","style":"null"};
    if(xmlReq.readyState == 4){
        if(xmlReq.status == 200){
            var value = xmlReq.responseText;
            alert(value);
        }
    }
}
function chakan(){
    var bureauId = document.getElementById("bureauId").value;

    window.location.href = "eventAction.do?method=showListByTag&pageno=1&eventName=${eventName}&bureauId="+bureauId;
}
function onclick0(){
    window.location.href = "eventAction.do?method=showListByTag&pageno=1&eventName=";
}
function onclick1(){
    window.location.href = "eventAction.do?method=showListByTag&pageno=1&eventName=1";
}
function onclick2(){
    window.location.href = "eventAction.do?method=showListByTag&pageno=1&eventName=2";
}
function onclick3(){
    window.location.href = "eventAction.do?method=showListByTag&pageno=1&eventName=3";
}

var myData = new Array();
function trClick(index){
    //暂定跳到行情报表显示页面
    var ip = document.getElementById("IP"+index).value;
    var bureauId = document.getElementById("bureauId"+index).value;
    
    //分时走势页面
    //window.location.href="${basePath}/eventAction.do?method=eventTimeTrend&faci_ip="+ip+"&bureauId="+bureauId;
    
    //行情报表页面
    window.location.href="eventAction.do?method=eventSpecific&faci_ip="+ip+"&bureauId="+bureauId;
    //window.location.href="${basePath}/eventAction.do?method=eventSpecific&faci_ip="+faci_ip+"&id="+id;
}
function goPage(totalPage) {
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
        window.location.href="eventAction.do?method=showListByTag"+"&mark="+mark;
    }    
   }
function doDelete(){
    var defineName = document.getElementById("defineName").value;
    var defaultMark = document.getElementById("defaultMark").value;
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
        window.location.href="eventAction.do?method=deleteEvent&deleteIn="+deleteIn+"&mark="+defaultMark+"&eventName="+defineName;
    }
}
function addDefineEvent(){
    var defineIn = "";
    var isSelect = false;
    var selectValue = document.getElementById("eventDefine").value;
    for(var i = 0; i < document.getElementsByName("operate").length; i ++){
        if(document.getElementsByName("operate")[i].checked){
            defineIn = defineIn + document.getElementsByName("operate")[i].value + ",";
            isSelect = true;
        }
    }
    if(isSelect == false){
        alert("请选择你要增加到自定义事件"+selectValue+"的记录");
        return;
    }
    var allCondition = defineIn + selectValue;
    //alert(allCondition);
    window.location.href="eventAction.do?method=addDefineEvent&defineEventCondition="+allCondition;
}
function callback(data){
    var array = new Array();
    var checkBoxList = document.getElementsByName("operate");
    var aa = 0;
    for(var j = 0; j < checkBoxList.length; j ++){
        if(checkBoxList[j].checked == true){
           array[j] = "checked";
        }else{
           array[j] = "";
        }
    }
    var eventListSize = "${eventListSize}";
//    var displayHead = document.getElementById("dHead").innerHTML;
    
    var displayIn = "<ul class='border'><li style='width:100%'><table><tr align='center'><th>序号</th> <th>名称</th> <th>部门名称</th> <th>IP地址</th> <th>日初值</th> <th>当前值</th><th>幅度</th> <th>日总量</th> <th>最高</th> <th>最低</th> <th>冗余度</th><th>威胁等级</th><th width='25%'>类型</th><th>可用度</th><th>操作</th></tr>";
    <%if (request.getAttribute("eventListSize") != null) {
				for (int j = 0; j < Integer.parseInt(request.getAttribute(
						"eventListSize").toString()); j++) {
					request.setAttribute("i", j);%>
        var index = <%=j%> + 1;
        displayIn = displayIn + "<tr onDblClick='trClick("+index+")'>";
        displayIn = displayIn + "<input type='hidden' name='IP"+index+"' id='IP"+index+"' value='${eventList[i][0] }'>";
        displayIn = displayIn + "<input type='hidden' name='Id"+index+"' id='Id"+index+"' value='${eventList[i][1] }'>";
        displayIn = displayIn + "<input type='hidden' name='name"+index+"' id='name"+index+"' value='${eventList[i][2] }'>";
        displayIn = displayIn + "<input type='hidden' name='bureauId"+index+"' id='bureauId"+index+"' value='${eventList[i][3].id}'>";
        displayIn = displayIn + "<td align='center'>"+index+"</td> <td align='center'>${eventList[i][2] }</td> <td align='center'>${eventList[i][4]}</td> <td align='center'>${eventList[i][0] }</td>"
        var isHave = false;
        var inHave = false;
        if(data.length > 0 && data != null){
            myData = data;
        }
        //alert(data[0]);
        for(var a = 0; a < data.length; a++){
        	//alert(data[a].faci_ip != null && data[a].bureauId != null && isHave == false);
			//alert(data[a].faciIp+"--"+data[a].domain+"--"+'${eventList[i][0]}'+"--"+'${eventList[i][3]}');
            if(data[a].faciIp != null && data[a].domain != null && isHave == false){
            	//alert(data[a].faciIp == '${eventList[i][0]}' && data[a].domain == '${eventList[i][3].id}');
                if(data[a].faciIp == '${eventList[i][0]}' && data[a].domain == '${eventList[i][3].id}'){
                	        
                    displayIn = displayIn + "<input type='hidden' name='init"+index+"' id='init"+index+"' value="+data[a].initValue+">";
                    displayIn = displayIn + "<input type='hidden' name='curr"+index+"' id='curr"+index+"' value="+data[a].currValue+">";
                    displayIn = displayIn + "<input type='hidden' name='max"+index+"' id='max"+index+"' value="+data[a].maxValue+">";
                    displayIn = displayIn + "<input type='hidden' name='min"+index+"' id='min"+index+"' value="+data[a].minValue+">";
                    displayIn = displayIn + "<input type='hidden' name='thre"+index+"' id='thre"+index+"' value="+data[a].threRank+">";
                    displayIn = displayIn + "<input type='hidden' name='total"+index+"' id='total"+index+"' value="+data[a].totalValue+">";
                    
                    displayIn = displayIn + "<td align='center'>"+data[a].initValue+"</td> <td align='center'>"+data[a].currValue+"</td>";
                    displayIn = displayIn + "<td align='center'>"+data[a].range+"</td> <td align='center'>"+data[a].totalValue+"</td> <td align='center'>"+data[a].maxValue+"</td> <td align='center'>"+data[a].minValue+"</td> <td align='center'>"+data[a].redundance+"</td>";
                    displayIn = displayIn + "<td align='center'>"+data[a].threRank+"</td> <td align='center'>"+data[a].type+"</td> <td align='center'>"+data[a].faciAvai+"</td>";
                    isHave = true;
                }
            }
        }
        if((data == null || data.length == 0) && isHave == false){
            for(var b = 0; b < myData.length; b++){
                if(myData[b].faciIp != null && data[a].domian != null && inHave == false){
                    if(myData[b].faciIp == '${eventList[i][0]}' && data[a].domian == '${eventList[i][3].id}'){
                        
                        displayIn = displayIn + "<input type='hidden' name='init"+index+"' id='init"+index+"' value="+myData[b].initValue+">";
                        displayIn = displayIn + "<input type='hidden' name='curr"+index+"' id='curr"+index+"' value="+myData[b].currValue+">";
                        displayIn = displayIn + "<input type='hidden' name='max"+index+"' id='max"+index+"' value="+myData[b].maxValue+">";
                        displayIn = displayIn + "<input type='hidden' name='min"+index+"' id='min"+index+"' value="+myData[b].minValue+">";
                        displayIn = displayIn + "<input type='hidden' name='thre"+index+"' id='thre"+index+"' value="+myData[b].threRank+">";
                        displayIn = displayIn + "<input type='hidden' name='total"+index+"' id='total"+index+"' value="+myData[b].totalValue+">";
                        
                        displayIn = displayIn + "<td align='center'>"+myData[b].initValue+"</td> <td align='center'>"+myData[b].currValue+"</td>";
                        displayIn = displayIn + "<td align='center'>"+myData[b].range+"</td> <td align='center'>"+myData[b].totalValue+"</td> <td align='center'>"+myData[b].maxValue+"</td> <td align='center'>"+myData[b].minValue+"</td> <td align='center'>"+myData[b].redundance+"</td>";
                        displayIn = displayIn + "<td align='center'>"+myData[b].threRank+"</td> <td align='center'>"+myData[b].type+"</td> <td align='center'>"+myData[b].faciAvai+"</td>";
                        inHave = true;                
                    }
                }
            }
        }
        if(inHave == false && isHave == false){
            displayIn = displayIn + "<input type='hidden' name='init"+index+"' id='init"+index+"' value='0'>";
            displayIn = displayIn + "<input type='hidden' name='curr"+index+"' id='curr"+index+"' value='0'>";
            displayIn = displayIn + "<input type='hidden' name='max"+index+"' id='max"+index+"' value='0'>";
            displayIn = displayIn + "<input type='hidden' name='min"+index+"' id='min"+index+"' value='0'>";
            displayIn = displayIn + "<input type='hidden' name='thre"+index+"' id='thre"+index+"' value='0'>";
            displayIn = displayIn + "<input type='hidden' name='total"+index+"' id='total"+index+"' value='0'>";
            
            displayIn = displayIn + "<td align='center'>0</td> <td align='center'>0</td>";
            displayIn = displayIn + "<td align='center'>0</td> <td align='center'>0</td> <td align='center'>0</td> <td align='center'>0</td> <td align='center'>0</td>";
            displayIn = displayIn + "<td align='center'>0</td> <td align='center'></td> <td align='center'></td>";
        }

        if(array[index - 1] == "checked"){
            displayIn = displayIn + "<td align='center'><input type='checkbox' name='operate' id='operate' checked='"+array[index-1]+"' value='${eventList[i][0] }@${eventList[i][0] }' /></td>";
        }else{
            displayIn = displayIn + "<td align='center'><input type='checkbox' name='operate' id='operate' value='${eventList[i][0] }@${eventList[i][0] }' /></td>";
        }
        
        displayIn = displayIn +"</tr>";
        <%}
			}%>
        displayIn += "</table></li></ul>";
        document.getElementById("MyDiv").innerHTML = displayIn;
        document.getElementById("display").style.display="block";
        //data = null;
        //data.length = 0;
        setTimeout("eventLoad()", 5000);
    }
    function errh(errorString, exception){
        <%request.setAttribute("faile", true);%>
        //alert("通信服务启动错误");
    }
    
    function eventLoad(){
        var ip = document.getElementById("ip").value;
        dwr.engine.setErrorHandler(errh);
        EventSrviceClient.doNewEvents("WebComeHere",callback);
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
<script type="text/javascript" src="${ctx }/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx }/js/comm/other/sorttable.js"></script>
<script type="text/javascript"
	src="${ctx }/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript"
	src="${ctx }/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript"
	src="${ctx }/js/comm/other/js/floatdiv.js"></script>
</head>
<body onload="eventLoad()" scrolling="auto" >
<div id="contant" class="mainbg">
<div id="banner" class="grayline overf bannerH">
<li class="act" id="m"><a
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
<li class="nor"><a
	href="eventStatisticalAnals.do?method=eventDisplay"><span
	style="background: url(${ctx }/img/comm/other/045631195.gif) no-repeat; padding-left: 22px;">事件展示
</span></a></li>
</div>
<div class="contant">
<h2>事件列表</h2>
<input type="hidden" name="ip" id="ip" value="${faci_ip }" /> <c:if
	test="${faile == true}">
	<div id="display" name="display" style="display: block">
</c:if> <c:if test="${faile == false}">
	<div id="display" name="display" style="display: none">
</c:if>
<div class="greenborder greenback overf pad3 Height_a">
<div class="pad3">部门: <select name="bureauId" id="bureauId">
	<option>----全部----</option>
	<c:forEach items="${managerOfUser }" var="manager">
		<c:if test="${bureauId == manager.id}">
			<option value="${manager.id }" selected="selected">${manager.domainName
			}</option>
		</c:if>
		<c:if test="${bureauId != manager.id}">
			<option value="${manager.id }">${manager.domainName }</option>
		</c:if>
	</c:forEach>
</select> <input type="button" id="wbj" value="确定" onclick="chakan()"></div>
</div>
<div class="contant">
<h2 class="martop8">查看列表</h2>

<div id="data" class="greenborder overf pad1 ">
<samp style="height: 25px;"  style="float:right;">
<a
	href="javascript:onclick0()">全部事件查看</a> | <a
	href="javascript:onclick1()">自定义事件一查看</a> | <a
	href="javascript:onclick2()">自定义事件二查看</a> | <a
	href="javascript:onclick3()">自定义事件三查看</a></samp>
<div name="MyDiv" id="MyDiv">
<table id="senfe" sortcol="-1">
	<thead>
		<tr  align='center'>
		<th>序号</th>
		<th>名称</th>
		<th>部门名称</th>
		<th>IP地址</th>
		<th>日初值</th>
		<th>当前值</th>
		<th>幅度</th>
		<th>日总量</th>
		<th>最高</th>
		<th>最低</th>
		<th>冗余度</th>
		<th>威胁等级</th>
		<th width='25%'>类型</th>
		<th>可用度</th>
		<th>操作</th>
		</tr>
	</thead>
	<tbody>

</tbody>
</table>
</div>
<div class="martop8 Height_t">
<ul id="page">
	<li><a class="first"
		href="eventAction.do?method=showListByTag&pageno=1&eventName=${eventName }&bureauId=${bureauId }"></a></li>

	<c:if test="${page.currentPage-1 >= 1}">
		<li><a class="pre"
			href="eventAction.do?method=showListByTag&pageno=${page.currentPage-1}&eventName=${eventName }&bureauId=${bureauId }"></a></li>
	</c:if>
	<c:if test="${page.currentPage-1 <= 0}">
		<li><a class="pre"
			href="eventAction.do?method=showListByTag&pageno=1&eventName=${eventName }&bureauId=${bureauId }"></a></li>
	</c:if>

	<c:if test="${page.currentPage+1 < page.totalPage}">
		<li><a class="next"
			href="eventAction.do?method=showListByTag&pageno=${page.currentPage+1}&eventName=${eventName }&bureauId=${bureauId }"></a></li>
	</c:if>
	<c:if test="${page.currentPage+1 >= page.totalPage}">
		<li><a class="next"
			href="eventAction.do?method=showListByTag&pageno=${page.totalPage}&eventName=${eventName }&bureauId=${bureauId }"></a></li>
	</c:if>

	<li><a class="last"
		href="eventAction.do?method=showListByTag&pageno=${page.totalPage}&eventName=${eventName }&bureauId=${bureauId }"></a></li>
	<li>共 ${page.totalPage }页 第${page.currentPage }页 跳至 <input
		type="text" size="4" name="mark" id="mark" />页 <input type="button"
		name="go" id="go" value="GO" size="4"
		onclick="goPage(${page.totalPage})" /></li>


	<li  style="float:right;"><input type="hidden" name="defineName" value="${eventName }" id="defineName" /> 
		<input type="hidden" name="defaultMark"	value="${pageMark }" id="defaultMark" /> 
		<input name="button1" type="submit" class="an-1" id="button1" value="<bean:message key="selectAll" bundle="event"/>"
			onclick="selectAll()" /> 
		<input name="button2" type="submit"	class="an-1" id="button2" value="<bean:message key="reset" bundle="event"/>" 
			onclick="reset()" />
	
	<c:if test="${eventName != null}">
		<input name="button4" type="submit" class="an-1" id="button4" value="<bean:message key="delete" bundle="event"/>"
			onclick="doDelete()" />
	</c:if> 

	<c:if test="${eventName == null}">
		<input name="button3" type="submit" class="an-1" id="button3" value="自定义添加" disabled="true" onclick="addDefineEvent()" />
			<font color="red" size="2"><bean:message key="remark" bundle="event" /></font>
				<select name="eventDefine" class="css1" id="eventDefine" onchange="selectChange()">
					<option value="0"><bean:message key="select" bundle="event" /></option>
					<option value="1"><bean:message key="one" bundle="event" /></option>
					<option value="2"><bean:message key="two" bundle="event" /></option>
					<option value="3"><bean:message key="three" bundle="event" /></option>
				</select>
	</c:if>
</li>
</ul>
<br />
      <br />
	  <br />
</div>
</div>
</div>
</div>

</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>

