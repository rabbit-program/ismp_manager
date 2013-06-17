<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>

<script type="text/javascript" src="${ctx}/js/LM/prototype.js"></script>
<script type="text/javascript" src="${ctx}/js/LM/getSysLogDiv.js"></script>
<script type="text/javascript">
function goDivPage(totalPage,href,div) {
    var mark=document.getElementById("mark").value;
    if(mark > totalPage){
        alert("最大页码值为："+totalPage);
        document.getElementById("mark").value = "";
        document.getElementById("mark").focus();
        return;
    }if(mark <= 0 || isNaN(mark)){
        alert("请输入有效的页码值!!");
        document.getElementById("mark").value = "";
        document.getElementById("mark").focus();
        return;
    }else{
    	showAddDivBox('sysLogDivSourceAction.do?method=sysLogDeviceForward&pageNo='+mark,div);
    }
}
</script>
</head>
<body onload="showAddDivBox('sysLogDivSourceAction.do?method=sysLogDeviceForward&pageNo=1','sysLogDisplay')">
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="act" id="m"><a href="sysLogAction.do?method=originalDisplay"><span style="background:url(${ctx }/img/comm/other/virus.gif) no-repeat; padding-left:22px;">系统日志</span></a></li>
    <sec:authorize ifAllGranted="ROLE_AdminAll">
	     <li class="nor" id="m"><a href="${ctx }/ismp/lm/pflog/systemLogAction.do?method=init"><span style="background:url(${ctx }/img/comm/other/01.gif) no-repeat; padding-left:22px;">平台日志</span></a></li>
	</sec:authorize> 
  </div>
  <div class="contant">
   <div class="overf h20 martop10">
      <li id="m"><a  class="mback" href="sysLogAction.do?method=originalDisplay"><span class="menus10"> 原始Syslog</span></a></li>
      <li><a  class="mbacka" href="sysLogAction.do?method=logSourceDisplay"><span class="menus10">Syslog</span></a></li>
      <li><a  class="mback" href="snmpTrapAction.do?method=getSnmpTrapSource"><span class="menus11">Trap</span></a></li>
      <li><a  class="mback" href="pcAction.do?method=getPcSource"><span class="menus12">PC</span></a></li><li style="margin-left:30px;">&nbsp;</li>
	  <li style="margin-left:12px;"><a class="R6 R7" href="javascript:history.back(1)">返回上一级</a></li>
    </div>
 
	<div class="greenborder pad3 overf" id="sysLogDisplay"">
	数据加载中...
	</div>

  </div>
</div>
<script type="text/javascript">setTimeout(function(){senfe("senfe","#fff","#eee","#fdf4db","");},500);</script> 
</body>
</html>
