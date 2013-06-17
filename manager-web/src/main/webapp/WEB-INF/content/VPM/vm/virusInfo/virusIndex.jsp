<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/VM/input.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/VM/cal.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/VM/swapimage.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/comm.js"></script>
<script type="text/javascript">
var winWidth=900
var winheight=600
var xposition=0; 
var yposition=0;
var currPersonNo;

var winFeature ="menubar=no,toolbar=no,status=yes,resizable=yes,width=550px,height=370px,scrollbars=yes"
var winFeature2 ="menubar=no,toolbar=no,status=no,resizable=no,width=0.1px,height=0.1px,scrollbars=no"

if ((screen.width >= 1024)) {
    winFeature ="menubar=no,toolbar=no,status=yes,resizable=yes,width=550,height=370,scrollbars=yes";
    winWidth=1000;
    winheight=700;  
}

if ((parseInt(navigator.appVersion) >= 4 )) {
    xposition = (screen.width - winWidth) / 2;
    yposition = (screen.height - winheight-10) / 2;
}

function doReset(){
    document.getElementById("clientId").value = "";
    document.getElementById("assetCode").value = "";
    document.getElementById("interDate").value = "";
}

function remarkdDisp(name){
    window.open("${ctx}/ismp/domain/local/vpm/vm/statiscalStrateVirusAction.do?method=showListByBaseTag&code="+name,"openWin",winFeature+",left="+xposition+",top="+yposition);
}

function noHave(){
    alert('对不起!没有该补丁的简要描述');
}

function clientInView(clientId){
    window.open("${ctx}/ismp/domain/local/vpm/vm/patchQueryActioin.do?method=clientInView&clientId="+clientId+"&currentPage=1","openWin",winFeature+",left="+xposition+",top="+yposition);
}
//查看病毒告警实时记录详细信息
function openRealTimeData(alertId){    
   //var clientID=document.getElementById("sensorId").value;
    window.open('${ctx}/ismp/domain/local/vpm/vm/virusAlertDetial.do?vasi='+alertId,'newwindow','height=442,width=900,top=0,left=0,toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no') ;
}
// 分页用到
function test(){
    var page=document.getElementById("currPage").value;
    window.location.href="${ctx}/ismp/domain/local/vpm/vm/virusInfo.do?cup="+page;
}
</script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="act" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('vm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/virus.gif) no-repeat; padding-left:22px;">病毒管理</span></a></li>
    <li class="nor" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('pm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">补丁管理</span></a></li>
    <li class="nor"><a href="javascript:void(0)" onclick="javascript:to_url('sd','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">软件分发</span></a></li>
  </div>
  <div class="contant">
    <div class="overf h20 martop10">
      <li id="m"><a  class="mback" href="${ctx}/ismp/domain/local/vpm/vm/vmAction.do"><span class="menus10"> 客户端管理</span></a></li>
      <li><a  class="mbacka" href="${ctx}/ismp/domain/local/vpm/vm/virusInfo.do"><span class="menus11">病毒管理</span></a></li>
    </div>
    <div id="data" class="overf">
    <table>
        <tr>
          <td width="200"><div class="greenback overf pad3" style="width:200px; height:500px; overflow:auto; margin:0;">
          <jsp:include page="../comm/leftFrameTree.jsp"></jsp:include> </div></td>
          <td valign="top">         
          <div class="greenborder greenback overf pad3  martop8" >
              本周共发现病毒  <span class="alert">${allNum}</span>  条， 已处理    <span class="alert">${okNum}</span>  条，未处理    <span class="alert">${unOkNum}</span>  条。
            </div>
            <table class="martop8">
  <tr>
    <td width="50%" style="border-right:1px solid #a4ce31;">
      <%@ include file="/WEB-INF/content/VPM/vm/virusInfo/clientsContractTopN.jsp"%>
    </td>
    <td>
       <%@ include file="/WEB-INF/content/VPM/vm/virusInfo/virusTopN.jsp"%>
    </td>
  </tr>
</table>
<h2>具体感染情况如下</h2><table id="senfe" sortcol="-1">
  <tr>
    <th> 客户端名称 </th>
    <th> 客户端IP </th>
    <th> 病毒名称 </th>
    <th> 最后发现时间 </th>
    <th> 查杀结果 </th>
    <th> 操 作 </th>
  </tr>
       <c:forEach var="alert" items="${alertList}" varStatus="status">
            <tr <c:if test="${status.count%2==0}">bgcolor="#E8E8E8"</c:if>>
              <td><div><a href="${ctx}/ismp/domain/local/vpm/vm/clientsVirusInfoAction.do?vci=${alert.virusClients.id}" target="_self">${alert.virusClients.name}</a></div></td>
              <td><div>${alert.virusClients.clientIP}</div></td>
              <td><div><a href="#" onClick="openRealTimeData('${alert.id}')">${alert.virus.name}</a></div></td>
              <td><div>${alert.lastFindTime}</div></td>
              <td><div>${alert.killResult.name}</div></td>
              <td><div ><a href="#" onClick="openRealTimeData('${alert.id}')">告警详情</a></div></td>
            </tr>
    </c:forEach>
</table>
        <ul id="page">
          <li><a class="first" href="${ctx}/ismp/domain/local/vpm/vm/virusInfo.do?cup=1"></a></li>
           <c:if test="${currPage>1 }">
          <li><a class="pre" href="${ctx}/ismp/domain/local/vpm/vm/virusInfo.do?cup=${currPage-1 }"></a></li>
            </c:if>
            <c:if test="${currPage<totalPage }">
          <li><a class="next" href="${ctx}/ismp/domain/local/vpm/vm/virusInfo.do?cup=${currPage+1 }"></a></li>
            </c:if>
          <li><a class="last" href="${ctx}/ismp/domain/local/vpm/vm/virusInfo.do?cup=${totalPage }"></a></li>
          <li>共  ${totalPage }页 跳至
            <input id="currPage" name="currPage"  type="text" size="2" class="input" value="${currPage }" />
          </li>
          <li><a  class="R6" href="javascript:test();">GO</a></li>
        </ul>
          </td>
        </tr>
      </table>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
