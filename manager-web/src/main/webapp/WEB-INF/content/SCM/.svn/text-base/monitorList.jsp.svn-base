<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>

<!--引入DWR框架-->
<script type='text/javascript' src='${ctx}/dwr/interface/monitorService.js'></script>
<script type='text/javascript' src='${ctx}/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx}/dwr/util.js'></script>

<script type="text/javascript" >
	
	function MM_openBrWindow(theURL,winName,features) { //v2.0
        window.open(theURL,winName,features);
    }
    
	function addRow(id, caption, description, type, timeSpace, success,remainder, managerName) {
        var tableObj = document.getElementById("senfe");
        var newRowObj = tableObj.insertRow(tableObj.rows.length);
        var newcaption = newRowObj.insertCell(newRowObj.cells.length);
        var newdescription = newRowObj.insertCell(newRowObj.cells.length);
        var newtype = newRowObj.insertCell(newRowObj.cells.length);
        var newmanagerName = newRowObj.insertCell(newRowObj.cells.length);
        var newtimeSpace = newRowObj.insertCell(newRowObj.cells.length);
        var newremainder = newRowObj.insertCell(newRowObj.cells.length);
        var newsuccess = newRowObj.insertCell(newRowObj.cells.length);
        var newlink = newRowObj.insertCell(newRowObj.cells.length);

        newcaption.innerHTML = caption;
        newcaption.width = "13%";
        
        newdescription.innerHTML = description;
        newdescription.width = "13%";
    
        newtype.innerHTML = type;
        newtype.width = "13%";
        
        newtimeSpace.innerHTML = timeSpace;//轮询间隔
        newtimeSpace.width = "8%";

        newmanagerName.innerHTML = managerName;
        newmanagerName.width = "13%";
        
        if (success == -2) {
            newremainder.innerHTML = "<img src='${ctx}/img/SCM/wait.png' title='等待中...'/>";
        } else {
            newremainder.innerHTML = remainder;//剩余时间
        }
        newremainder.width = "8%";
        if (success == 0) {
            newsuccess.innerHTML = "<img src='${ctx}/img/SCM/s_ok.png' title='连接成功'/>";
        } else if (success == 1) {
            newsuccess.innerHTML = "<img src='${ctx}/img/SCM/s_err.png' title='连接失败'/>";
        } else if (success == -1) {
            newsuccess.innerHTML = "<img src='${ctx}/img/SCM/b_disable.png' title='未启动监控'/>";
        } else if (success == -2) {
            newsuccess.innerHTML = "<img src='${ctx}/img/SCM/s_waitcheck.png' title='等待检测'/>";
        }
        var aaa = 111;
        newsuccess.width = "7%";
        newlink.width = "23%";
        newlink.innerHTML = "<a title='激活监控项' href='${ctx}/ismp/domain/local/scm/monitorAction.do?method=enableMonitor&id="  + id
                + "'><img src='${ctx}/img/SCM/b_enable.png' border='0'/></a>&nbsp;&nbsp;<a title='暂停监控项' href='${ctx}/ismp/domain/local/scm/monitorAction.do?method=disableMonitor&id=" + id
                + "'><img src='${ctx}/img/SCM/b_disable.png'  border='0'/></a>&nbsp;&nbsp;<a title='立即检测' href='${ctx}/ismp/domain/local/scm/monitorAction.do?method=checkAtOnceMonitor&id=" + id
                + "'><img src='${ctx}/img/SCM/b_check.png' border='0'/></a>&nbsp;&nbsp;<a title='查看详细' href='#' onclick='wopendetail(" + id
                + ")'><img src='${ctx}/img/SCM/b_detail.png' border='0'/></a>&nbsp;&nbsp;<a title='删除监控项' onclick='deleteMonitor(" + id
                + ")' href='#'><img src='${ctx}/img/SCM/b_delete.gif' border='0'/></a>&nbsp;&nbsp;<a title='编辑' href='#' onclick='wopen(" + id
                + ")'><img src='${ctx}/img/SCM/b_edit.gif' border='0'/></a>"
    }
	function deleteMonitor(id) {
		if(window.confirm("确定删除此监控项？")){
	        var currPage=document.getElementById("currPage").value;
	        var isAll = document.getElementById("isAll").value;
	        window.location.href="${ctx}/ismp/domain/local/scm/monitorAction.do?method=monitorDelete&id="+id+"&isAll="+isAll+"&currPage="+currPage;
	    }
    }
	function wopendetail(id) {
        window.open("${ctx}/ismp/domain/local/scm/monitorAction.do?method=monitorDetail&id=" + id+ "",
             "","toolbar=no,location=no,directories=no,menubar=no,scrollbars=no,resizable=no,status=no,top=300,left=400,width=500,height=330");
    }
	function wopen(id) {
        window.open("${ctx}/ismp/domain/local/scm/monitorAction.do?method=toUpdateMonitorJsp&id=" + id + "",
             "","toolbar=no,location=no,directories=no,menubar=no,scrollbars=no,resizable=no,status=no,top=250,left=250,width=800,height=600");
    }
	function limitNum(obj) {
        if (obj.replace(/[\d+]/ig, "").length > 0) {
            return false;
        } else {
            return true;
        }
    }
	function toPage(currPage) {
		var totalPage = document.getElementById("totalPage").value;
		var isAll = document.getElementById("isAll").value;
	    if(0 == totalPage){
	    	totalPage = 1;
	    }
	    if("number" == typeof(currPage)){
	    	document.getElementById("currPage").value = currPage;
            window.location.href = "${ctx}/ismp/domain/local/scm/monitorAction.do?method=getMonitorList&currPage="
                    + currPage + "&isAll=" + isAll;
		}else {
			if((currPage.indexOf("-")   ==   0)||!(currPage.indexOf(".")   ==   -1)){
	            alert("跳转页数只能是整数!");
	        }else if (parseInt(currPage) > parseInt(totalPage) || currPage <= 0) {
	            alert("输入的页数范围有误,请重新输入!");
	        }else {
	            document.getElementById("currPage").value = currPage;
	            window.location.href = "${ctx}/ismp/domain/local/scm/monitorAction.do?method=getMonitorList&currPage="
	                    + currPage + "&isAll=" + isAll; 
	        }
		}
	}
</script>
</head>
<body onload="findMonitorStates();">
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/virus.gif) no-repeat; padding-left:22px;">服务检测</span></a></li>
  </div>
  <div class="contant">
    <div class="pad3 overf">
      <h2 class="martop10">查看列表</h2>
        <form name="f1" id="f1" action="/ismp/domain/local/scm/monitorAction.do?method=addMonitor" method="post">
           <input type="hidden" id="isAll" name="isAll" value="${isAll}"/> 
<!--           <input type="hidden" id="domainArr" value="${domainArr}" />-->
           <div id="data" class="greenborder overf pad1" >
	            <table id="titleName" sortcol="-1">
		            <thead>
		              <tr>
		                <th width="13%" style="cursor:pointer" onclick="sortTable('senfe',0);">名称</th>
			            <th width="20%">描述</th>
			            <th width="13%">监控类型</th>
			            <th width="13%">所属部门</th>
<!--			            <th width="8%">轮询间隔</th>-->
<!--			            <th width="8%">剩余时间</th>-->
			            <th width="7%">当前状态</th>
			            <th width="16%">操作</th>
		              </tr>
		            </thead>
	            </table>
				<table id="senfe" name="monitortable" sortcol="-1" border="0" cellpadding="0" cellspacing="1">
                    <tbody>
                        <input type="hidden" id="id" name="id" value="${nodeIdList}" />
                        <logic:notEmpty name="monitorList">
                            <logic:iterate id="monitor" name="monitorList" indexId="i">
                            <tr>
                              <input type="hidden" value="${monitor.intervalTime}"  name="${monitor.nodeId}intervalTime" id="${monitor.nodeId}intervalTime"></input>
                              <input type="hidden" value="${monitor.timeout}" name="${monitor.nodeId}timeout" id="${monitor.nodeId}timeout" ></input>
                              <td width="13%">${monitor.name }</td>
                              <td width="20%">${monitor.description}</td>
                              <td width="13%">${monitor.subType }</td>
                              <td width="13%">${monitor.domain.domainName }</td>
<!--                              <td width="8%">轮询间隔</td>-->
<!--                              <td width="8%">剩余时间</td>-->
                              <td width="7%" align="center">
                                        <span id="${monitor.nodeId}0"></span>
<!--                                    <img src='${ctx}/img/SCM/b_disable.png' title='未启动监控'/>-->
                              </td>
                              <td width="16%">
<!--                                <a title='激活' onclick="wopen('${monitor.id}')" href='#'><img src='${ctx}/img/SCM/b_enable.png' border='0'/></a>-->
<!--                                <a title='暂停' onclick="wopen('${monitor.id}')" href='#'><img src='${ctx}/img/SCM/b_disable.png'  border='0'/></a>-->
                                <a title='编辑' onclick="wopen('${monitor.id}')" href='#'><img src='${ctx}/img/SCM/b_edit.gif' border='0'/></a>&nbsp;&nbsp;&nbsp;&nbsp;
                                <a title='删除' onclick="deleteMonitor('${monitor.id}')" href='#'><img src='${ctx}/img/SCM/b_delete.gif' border='0'/></a>&nbsp;&nbsp;&nbsp;&nbsp;
                                <a title='查看' onclick="wopendetail('${monitor.id}')" href='#'><img src='${ctx}/img/SCM/b_detail.png' border='0'/></a>&nbsp;&nbsp;&nbsp;&nbsp;
                              </td>
                            </tr>
                            </logic:iterate>
                         </logic:notEmpty>    
                         <logic:empty name="monitorList">
                            <tr>
                                <td colspan="6">没有找到监控项！</td>
                            </tr>
                         </logic:empty>
                    </tbody>
				</table>
           </div>
           <div class="paddiv"></div>
                <ul id="page">
                    <li><a class="first" href="javascript:toPage(1);"></a></li>
                    <c:if test="${currPage>1 }">
                        <li><a class="pre" href="javascript:toPage(${currPage-1 });"></a></li>
                    </c:if>
                    <c:if test="${currPage<totalPage }">
                        <li><a class="next" href="javascript:toPage(${currPage+1 });"></a></li>
                    </c:if>
                    <li>
                        <input type="hidden" value="${totalPage }" id="totalPage"/>
                        <a class="last" href="javascript:toPage(${totalPage });"></a>
                    </li>
                    <li>
                                                                共 ${totalPage } 页 跳至
						<input type="text" class="input" size="3" maxlength="7"
						        value="${currPage}" id="currPage" name="currPage"
						        onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==46"
						        onpaste="return !clipboardData.getData('text').match(/\D/)"
						        ondragenter="return false" style="ime-mode: Disabled" />&nbsp;
<!--                        <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage}"/>&nbsp;-->
                    </li>
                    <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li>
                    <li><a class="R6 R7" href="#" title="新建检测项目" 
                            onclick="MM_openBrWindow('${ctx}/ismp/domain/local/scm/monitorAction.do?method=monitorInput&isAll=${isALL }&currPage=${currPage })',
                                    '新建检测项目','scrollbars=yes,width=800,height=600,top=250,left=250')">新建检测项目
                        </a>
                    </li>
                </ul>
                <br/><br/><br/>
      </form>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
<script type="text/javascript" language="javascript" defer=true>
       function findMonitorStates(){
    	   var nodes = new Array();
           var ids = document.getElementById("id").value;///取得的是这个页面上nodeList  例如[1,2,3,4,5] 大小就是每页的记录数
           ids =ids.substring(1,ids.length-1);///去掉两边的中括号  例如1,2,3,4,5
           nodes = ids.split(",");///用","分隔成数组
           
           for(var i=0;i<nodes.length;i++){///遍历nodes数组
               if(i==0){///第一条记录的node
            	   if(null != document.getElementById(trim(nodes[0])+"intervalTime") && null != document.getElementById(trim(nodes[0])+"timeout")){
	                   var intervalTime0 = document.getElementById(trim(nodes[0])+"intervalTime").value;///取得第一条记录的检测间隔时间(页面隐藏域)
	                   var timeout0 = document.getElementById(trim(nodes[0])+"timeout").value;///取得第一条记录的超时时间(页面隐藏域)
	                   count0(trim(nodes[0]),intervalTime0,timeout0);
                   }
               }
               if(i==1){///第二条记录的node
                    var intervalTime1 = document.getElementById(trim(nodes[1])+"intervalTime").value;///取得第二条记录的检测间隔时间(页面隐藏域)
                    var timeout1 = document.getElementById(trim(nodes[1])+"timeout").value;///取得第二条记录的超时时间(页面隐藏域)
                    count1(trim(nodes[1]),intervalTime1,timeout1);
               }
               if(i==2){///第三条记录的node
                   var intervalTime2 = document.getElementById(trim(nodes[2])+"intervalTime").value;///取得第三条记录的检测间隔时间(页面隐藏域)
                   var timeout2 = document.getElementById(trim(nodes[2])+"timeout").value;///取得第三条记录的超时时间(页面隐藏域)
                   count2(trim(nodes[2]),intervalTime2,timeout2);
               }
               if(i==3){///第四条记录的node
                   var intervalTime3 = document.getElementById(trim(nodes[3])+"intervalTime").value;///取得第四条记录的检测间隔时间(页面隐藏域)
                   var timeout3 = document.getElementById(trim(nodes[3])+"timeout").value;///取得第三条记录的超时时间(页面隐藏域)
                   count3(trim(nodes[3]),intervalTime3,timeout3);
               }
               if(i==4){///第五条记录的node
                   var intervalTime4 = document.getElementById(trim(nodes[4])+"intervalTime").value;///取得第五条记录的检测间隔时间(页面隐藏域)
                   var timeout4 = document.getElementById(trim(nodes[4])+"timeout").value;///取得第三条记录的超时时间(页面隐藏域)
                   count4(trim(nodes[4]),intervalTime4,timeout4);
               }
           }
       }
       
       function  trim(str){
           for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
           for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
           if(i>j) return "";  
           return  str.substring(i,j);  
       }

       function getMonitorStates(nodeId,timeOutTime){
    	   delaytime(nodeId);
           monitorService.getMonitorStates(nodeId,timeOutTime,function back(date){
               if(null != date){
                   if(date == 0){
                	   document.getElementById(trim(nodeId)+"0").innerHTML="<img src='${ctx}/img/SCM/s_err.png' title='检测失败'/>"; 
                   }else if(date == 1){
                	   document.getElementById(trim(nodeId)+"0").innerHTML="<img src='${ctx}/img/SCM/s_ok.png' title='检测成功'/>";
                   }else if(date == 2){
                       document.getElementById(trim(nodeId)+"0").innerHTML="<img src='${ctx}/img/SCM/s_err.png' title='检测失败'/>";
                   }else if(date == -1){
                	   document.getElementById(trim(nodeId)+"0").innerHTML="后台连接失败";
                   }
               }else{
                   document.getElementById(trim(nodeId)+"0").innerHTML="无数据";
               }
           });
       }

       function delaytime(nodeId){
           ///将当前状态的位置放置  等待  的图片。
           document.getElementById(trim(nodeId)+"0").innerHTML="<img src='${ctx}/img/SCM/wait.png' title='等待检测'/>";///放一张等待的图片
       }
       
       function count0(nodeId,intervalTime,timeOutTime) {
           delaytime(nodeId);///将当前状态的位置放置  等待  的图片。
           /**
           setInterval() 方法可按照指定的周期（以毫秒计）来调用函数或计算表达式。

           setInterval() 方法会不停地调用函数，直到 clearInterval() 被调用或窗口被关闭。
                             由 setInterval() 返回的 ID 值可用作 clearInterval() 方法的参数。
           **/
           ///每intervalTime秒调用一次getMonitorStates(nodeId,timeOutTime)从后台获取监控机状态
           var timerID0 = setInterval("getMonitorStates('" + trim(nodeId) + "'," + timeOutTime + ")",intervalTime * 1000);
           
           var timerOut0 = setInterval(function clean1(){
        	   monitorService.getMonitorOverStates(trim(nodeId), function back(date){
                   if(date == "yes"){
                	   clearInterval(timerID0);
                       clearInterval(timerOut0);
                   }
               });
               },intervalTime*1000+2000);
       }

       function count1(nodeId,intervalTime,timeOutTime) {
           delaytime(nodeId);
           var timerID1 = setInterval("getMonitorStates('" + trim(nodeId) + "'," + timeOutTime + ")",intervalTime * 1000);
           var timerOut1 = setInterval(function clean1(){
        	   monitorService.getMonitorOverStates(trim(nodeId), function back(date){
        		   if(date == "yes"){
                       clearInterval(timerID1);
                       clearInterval(timerOut1);
                   }
               });
               },intervalTime*1000+2000);
       }

       function count2(nodeId,intervalTime,timeOutTime) {
           delaytime(nodeId);
           var timerID2 = setInterval("getMonitorStates('" + trim(nodeId) + "'," + timeOutTime + ")",intervalTime * 1000);
           var timerOut2 = setInterval(function clean1(){
               monitorService.getMonitorOverStates(trim(nodeId), function back(date){
            	   if(date == "yes"){
                       clearInterval(timerID2);
                       clearInterval(timerOut2);
                   }
               });
               },intervalTime*1000+2000);
       }

       function count3(nodeId,intervalTime,timeOutTime) {
           delaytime(nodeId);
           var timerID3 = setInterval("getMonitorStates('" + trim(nodeId) + "'," + timeOutTime + ")",intervalTime * 1000);
           var timerOut3 = setInterval(function clean1(){
               monitorService.getMonitorOverStates(trim(nodeId), function back(date){
            	   if(date == "yes"){
                       clearInterval(timerID3);
                       clearInterval(timerOut3);
                   }
               });
               },intervalTime*1000+2000);
       }

       function count4(nodeId,intervalTime,timeOutTime) {
           delaytime(nodeId);
           var timerID4 = setInterval("getMonitorStates('" + trim(nodeId) + "'," + timeOutTime + ")",intervalTime * 1000);
           var timerOut4 = setInterval(function clean1(){
               monitorService.getMonitorOverStates(trim(nodeId), function back(date){
            	   if(date == "yes"){
                       clearInterval(timerID4);
                       clearInterval(timerOut4);
                   }
               });
               },intervalTime*1000+2000);
       }
       
</script>
</html>
