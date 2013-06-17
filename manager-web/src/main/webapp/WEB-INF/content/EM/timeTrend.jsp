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
function onclick1(){
    window.location.href = "eventAction.do?method=eventTimeTrend&faci_ip=${paraList[0]}&bureauId=${bureauId }&name=${paraList[1]}&init=${paraList[2]}"
                           + "&curr=${paraList[3]}&max=${paraList[4]}&min=${paraList[5]}&thre=${paraList[6]}";
}
function onclick2(){
    window.location.href = "eventAction.do?method=eventSpecific&faci_ip=${paraList[0]}&bureauId=${bureauId }&name=${paraList[1]}&init=${paraList[2]}"
                           + "&curr=${paraList[3]}&max=${paraList[4]}&min=${paraList[5]}&thre=${paraList[6]}";
}
function onclick3(){
	window.location.href = "eventAction.do?method=monitoringInformation&faci_ip=${paraList[0]}&bureauId=${bureauId }&name=${paraList[1]}&init=${paraList[2]}"
        + "&curr=${paraList[3]}&max=${paraList[4]}&min=${paraList[5]}&thre=${paraList[6]}";
}
function onclick4(){
    window.location.href = "eventAction.do?method=showListByTag";
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

<%    
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

</head>
<body>
<div id="contant" class="mainbg">
<div id="banner" class="grayline overf bannerH">
<li class="act" id="m"><a href="${ctx }/eventAction.do?method=showListByTag"><span
	style="background: url(${ctx }/img/comm/other/03.gif) no-repeat; padding-left: 22px;">事件监测</span></a></li>
<li class="nor"><a href="${ctx }/eventSelectCondition.do?method=eventSelectCondition&select=safe"><span
	style="background: url(${ctx }/img/comm/other/05375363.gif) no-repeat; padding-left: 22px;">事件查询</span></a></li>
<li class="nor"><a href="${ctx }/eventStatisticalAnals.do?method=eventStatisticalAnalysis"><span
	style="background: url(${ctx }/img/comm/other/map01.png) no-repeat; padding-left: 22px;">统计分析</span></a></li>
<li class="nor"><a
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
<input type="hidden" name="ip" id="ip" value="${faci_ip }"/>
<input type="hidden" name="bureauId" id="bureauId" value="${bureauId }"/>
<div id="data" class="greenborder overf pad1 ">
<h2>事件监测---详细信息</h2>
         <table width='100%' border='0' cellpadding='0' cellspacing='0' class='biaoge'>
<applet
  codebase = "../manager-web/applet/topo/"
  code     = "org.infosec.ismp.applet.event.EventOneLineChart.class"
  archive  = "twaver-2.3.jar,spring-web-3.0.2.RELEASE.jar,spring-beans-3.0.2.RELEASE.jar,aopalliance-1.0.jar,spring-context-3.0.2.RELEASE.jar,spring-core-3.0.2.RELEASE.jar,commons-logging-api-1.1.jar,spring-aop-3.0.2.RELEASE.jar,commons-lang-2.5.jar,ismp-manager-rmi-1.0-SNAPSHOT.jar,ismp-topo-applet-2.0-SNAPSHOT.jar"
  name     = "Alert Picture Applet"
  width    = "100%"
  height   = "300"
  hspace   = "0"
  vspace   = "0"
  align    = "left"
>
<param name="serverpath" value="${serverPath }"/>
<param name="faciIp" value="${faci_ip }"/>
<param name="serverpath" value="<%=basePath%>"/>
</applet> 
          </table>
  <div class="martop8 Height_t">
<ul>
<li  style="float:right;">
          <input type="button" name="button1" class="an-1" value="事件趋势" onclick="onclick1()"/>
          <input type="button" name="button2" class="an-1" value="详细信息" onclick="onclick2()"/>
          <input type="button" name="button3" class="an-1" value="监控信息" onclick="onclick3()"/>
          <input type="button" name="button3" class="an-1" value="返回" onclick="onclick4()"/>　
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
</html>

