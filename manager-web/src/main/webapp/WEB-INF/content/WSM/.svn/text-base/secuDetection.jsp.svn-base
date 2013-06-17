<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网站安全检测</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/webMonitorRecordsService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script language="javascript" >
function toChange(nodeId){
    webMonitorRecordsService.isChange(nodeId,function callback(flag){
        if(flag==true){
          var i=nodeId+"3";
          var node = document.getElementById(i);
          node.disabled=true;
          document.getElementById(nodeId+"2").innerHTML="页面未更改";
          
        }
    });
}

function toPage(curpage) {
	var isAll = $("isAll").value;
    document.getElementById("currPage").value = curpage;
    window.location.href="${ctx}/ismp/domain/local/wsm/webMonitor.do?method=showWebMonitor&currPage="+curpage+"&isAll="+isAll;
}

function deletes(id) {
    if(window.confirm("确定要删除吗？")){
        var currPage=document.getElementById("currPage").value;
        var isAll = $("isAll").value;
        window.location.href="${ctx}/ismp/domain/local/wsm/webMonitor.do?method=delWebMonitor&id="+id+"&isAll="+isAll+"&currPage="+currPage;
    }
}

function edit(id) {
    var currPage=document.getElementById("currPage").value;
	var isAll = $("isAll").value;
    window.location.href="${ctx}/ismp/domain/local/wsm/webMonitor.do?method=preSaveWebMonitor&id="+id+"&isAll="+isAll+"&currPage="+currPage;
}

function look(id){
    secondWindow = open("${ctx}/ismp/domain/local/wsm/webMonitor.do?method=look&id="+id,"detail","height=400,width=800,scrollbars=yes");
}

function add() {
    var currPage=document.getElementById("currPage").value;
	var isAll = $("isAll").value;
    window.location.href="${ctx}/ismp/domain/local/wsm/webMonitor.do?method=preSaveWebMonitor&isAll="+isAll+"&currPage="+currPage;
}

</script>
</head>
<body onload="getWebStates();"> 
 <div id="contant" class="mainbg">
<div id="banner" class="grayline overf bannerH" >    
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">网站安全检测</span></a></li>
</div>
<div class="contant">
    <h2>新建安全检测</h2>
    <div class="greenborder greenback overf pad3 Height_a" >
        <p><a class="R6 R7" href="javascript:add();" >新建安全检测</a></p>
    </div>
    <div class="paddiv">This is for verticl spacing</div>
    <h2>查看列表</h2>
    <div id="data" class="greenborder overf pad1" >
        <form name="f1" id="f1" action="" method="post">
          <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th width="5%" style="cursor:pointer" onclick="sortTable('senfe',0);">ID<span class="webdings"></span></th>
                <th width="12%" style="cursor:pointer" onclick="sortTable('senfe',0);">名称</th>
                 <th width="12%" style="cursor:pointer">所属部门</th>
                <th width="20%" style="cursor:pointer" onclick="sortTable('senfe',0);">描述</th>
                <th width="14%">在线状态</th>
                <th width="14%">响应时间</th>
                <th width="25%">是否变更</th>
                <th width="10%">操作</th>
              </tr>
            </thead>
            <tbody>
            <input type="hidden" id="id" name="id" value="${nodeIdList}" />
            <c:forEach items="${webMonitorList}" var="webMonitor">
              <tr>
                <input type="hidden" value="${webMonitor.timeInterval}"  name="${webMonitor.nodeId}timeInterval" id="${webMonitor.nodeId}timeInterval"></input>
                <input type="hidden" value="${webMonitor.timeOut}" name="${webMonitor.nodeId}timeOut" id="${webMonitor.nodeId}timeOut" ></input>
                <td>${webMonitor.id}</td>
                <td>${webMonitor.name}</td>
                <td>${webMonitor.domain.domainName}</td>
                <td>${webMonitor.desc}</td>
                <td><span id="${webMonitor.nodeId}0"></span></td>
                <td><span id="${webMonitor.nodeId}1"></span></td>
                <td><span id="${webMonitor.nodeId}2"></span><span class=" greenback overf pad3">
                   <input class="submit"  id="${webMonitor.nodeId}3" name="${webMonitor.nodeId}3" type="button" value="认可"  onclick="toChange('${webMonitor.nodeId}');" disabled="disabled"/>
                </span></td>
                <td><span class="tdnowrap"><a href="javascript:deletes('${webMonitor.id}');">删除</a>| <a href="javascript:edit('${webMonitor.id}');">修改</a>| <a href="javascript:look('${webMonitor.id}');">查看</a></span></td>
              </tr>
			</c:forEach>
            </tbody>
          </table>
        </form>
    </div>
    <div class="martop8 Height_t">
    <ul id="page">
      <li><a class="first" href="javascript:toPage(1);"></a></li>
      <c:if test="${currPage>1 }">
          <li><a class="pre" href="javascript:toPage(${currPage-1 });"></a></li>
      </c:if>
      <c:if test="${currPage<totalPage }">
          <li><a class="next" href="javascript:toPage(${currPage+1 });"></a></li>
      </c:if>
      <li><a class="last" href="javascript:toPage(${totalPage });"></a></li>
      <li>
                                                  共 ${totalPage } 页 跳至
          <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage }"/>
          &nbsp;
      </li>
      <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li>
  </ul>
    <br />
  </div>
     </div>
   
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
<script language="javascript" type="text/javascript" defer=true>
            function getWebStates(){
                var nodes = new Array();
                var ids = document.getElementById("id").value;
                ids =ids.substring(1,ids.length-1);
                nodes = ids.split(",");
                for(var i=0;i<nodes.length;i++){
                    if(i==0){
                        var timeInterval0 = document.getElementById(trim(nodes[0])+"timeInterval").value;
                        var timeOut0 = document.getElementById(trim(nodes[0])+"timeOut").value;
                        count0(trim(nodes[0]),timeInterval0,timeOut0);
                    }
                    if(i==1){
                         var timeInterval1 = document.getElementById(trim(nodes[1])+"timeInterval").value;
                         var timeOut1 = document.getElementById(trim(nodes[1])+"timeOut").value;
                         count1(trim(nodes[1]),timeInterval1,timeOut1);
                    }
                    
                    if(i==2){
                        var timeInterval2 = document.getElementById(trim(nodes[2])+"timeInterval").value;
                        var timeOut2 = document.getElementById(trim(nodes[2])+"timeOut").value;
                        count2(trim(nodes[2]),timeInterval2,timeOut2);
                    }
                    if(i==3){
                        var timeInterval3 = document.getElementById(trim(nodes[3])+"timeInterval").value;
                        var timeOut3 = document.getElementById(trim(nodes[3])+"timeOut").value;
                        count3(trim(nodes[3]),timeInterval3,timeOut3);
                    }
                    if(i==4){
                        var timeInterval4 = document.getElementById(trim(nodes[4])+"timeInterval").value;
                        var timeOut4 = document.getElementById(trim(nodes[4])+"timeOut").value;
                        count4(trim(nodes[4]),timeInterval4,timeOut4);
                    }
                }
            }

            function  trim(str){
                for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
                for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
                if(i>j) return "";  
                return  str.substring(i,j);  
            } 

            function findWebStates(nodeId,timeOutTime){
                webMonitorRecordsService.findWebStates(nodeId,timeOutTime,function back(date){
                	 var node = document.getElementById(nodeId+"3");
                    if(date!=null&&date!=""){
                        document.getElementById(nodeId+"0").innerHTML=date[0];
                        document.getElementById(nodeId+"1").innerHTML=date[1];
                        document.getElementById(nodeId+"2").innerHTML=date[2];
                        node.disabled=date[3];
                    }else{
                    	document.getElementById(nodeId+"0").innerHTML="无数据";
                        document.getElementById(nodeId+"1").innerHTML="无数据";
                        document.getElementById(nodeId+"2").innerHTML="无数据";
                        node.disabled=true;
                    }
                });
            }

            function delaytime(nodeId){
            	document.getElementById(trim(nodeId)+"0").innerHTML="等待中";
                document.getElementById(trim(nodeId)+"1").innerHTML="等待中";
                document.getElementById(trim(nodeId)+"2").innerHTML="等待中";
            }

            function count0(nodeId,intervalTime,timeOutTime) {
            	delaytime(nodeId);
                var timerID0 = setInterval("findWebStates('"+nodeId+"',"+timeOutTime+")",intervalTime*1000);
                var timerOut0 = setInterval(function clean1(){
                    webMonitorRecordsService.findOverStates(nodeId,function back(date){
                        if(date=="yes"){
                        	clearInterval(timerID0);
                            clearInterval(timerOut0);
                        }
                    });
                    },intervalTime*1000+2000);
            }
            function count1(nodeId,intervalTime,timeOutTime) {
            	delaytime(nodeId);
                var timerID1 = setInterval("findWebStates('"+nodeId+"',"+timeOutTime+")",intervalTime*1000);
                var timerOut1 = setInterval(function clean1(){
                    webMonitorRecordsService.findOverStates(nodeId,function back(date){
                        if(date=="yes"){
                            clearInterval(timerID1);
                            clearInterval(timerOut1);
                        }
                    });
                    },intervalTime*1000+2000);
            }
            function count2(nodeId,intervalTime,timeOutTime) {
            	delaytime(nodeId);
                var timerID2 = setInterval("findWebStates('"+nodeId+"',"+timeOutTime+")",intervalTime*1000);
                var timerOut2 = setInterval(function clean1(){
                    webMonitorRecordsService.findOverStates(nodeId,function back(date){
                        if(date=="yes"){
                        	clearInterval(timerID2);
                            clearInterval(timerOut2);
                        }
                    });
                    },intervalTime*1000+2000);
            }
            function count3(nodeId,intervalTime,timeOutTime) {
            	delaytime(nodeId);
                var timerID3 = setInterval("findWebStates('"+nodeId+"',"+timeOutTime+")",intervalTime*1000);
                var timerOut3 = setInterval(function clean1(){
                    webMonitorRecordsService.findOverStates(nodeId,function back(date){
                        if(date=="yes"){
                        	clearInterval(timerID3);
                            clearInterval(timerOut3);
                        }
                    });
                    },intervalTime*1000+2000);
            }
            function count4(nodeId,intervalTime,timeOutTime) {
            	delaytime(nodeId);
                var timerID4 = setInterval("findWebStates('"+nodeId+"',"+timeOutTime+")",intervalTime*1000);
                var timerOut4 = setInterval(function clean1(){
                    webMonitorRecordsService.findOverStates(nodeId,function back(date){
                        if(date=="yes"){
                        	clearInterval(timerID4);
                            clearInterval(timerOut4);
                        }
                    });
                    },intervalTime*1000+2000);
            }
            
  </script>
</html>
