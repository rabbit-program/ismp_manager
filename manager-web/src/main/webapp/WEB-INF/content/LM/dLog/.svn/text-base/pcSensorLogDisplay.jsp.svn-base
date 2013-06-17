<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx }/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx }/css/comm/other/common.css" type="text/css" />
<script type="text/javascript" src="${ctx }/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx }/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/LM/goPage.js"></script>
</head>
<body >
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
      <li><a  class="mback" href="sysLogAction.do?method=logSourceDisplay"><span class="menus10">Syslog</span></a></li>
      <li><a  class="mback" href="snmpTrapAction.do?method=getSnmpTrapSource"><span class="menus11">Trap</span></a></li>
      <li><a  class="mbacka" href="pcAction.do?method=getPcSource"><span class="menus12">PC</span></a></li><li style="margin-left:30px;">&nbsp;</li>
	  <li style="margin-left:12px;"><a class="R6 R7" href="pcAction.do?method=getPcSource">返回上一级</a></li>
    </div>
    <div class="greenborder pad3 overf">
      <h2 class="martop10">Sensor日志  列表</h2>
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓ </span></th>
					<th>计算机名</th>
			        <th>日志源采集IP</th>
			        <th>事件名称</th>
			        <th>事件类型</th>
			        <th>事件发生时间</th>
			        <th>事件源</th>
			        <th>事件分类</th>
			        <th>事件用户名</th>
					<th>事件描述</th>
              </tr>
            </thead>
            <tbody>
			<c:if test="${empty pageResult.pageResult }">
					<tr>
					<td align="center" colspan="10">Sorry ! 暂无相应的数据...</td>
					</tr>
			</c:if>
			<c:forEach items="${pageResult.pageResult}" var="pcLog" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${pcLog.computerName }</td>
					<td>${pcLog.sourceIp }</td>
					<td>${pcLog.eventName }</td>
					<td>${pcLog.eventType }</td>
					<td>${pcLog.eventTime }</td>
					<td>${pcLog.eventSource }</td>
					<td>${pcLog.eventCategory }</td>
					<td>${pcLog.userName }</td>
					<td> <div class="tdcut" title="${pcLog.eventDescription }">${pcLog.eventDescription }</div></td>
				</tr>
			</c:forEach>
            </tbody>
          </table>
      </div>
      <ul id="page">
        <li><a class="first" href="pcAction.do?method=getSensorLog&logsourcelogo=${logsourcelogo }&type=page"></a></li>

		<c:if test="${pageResult.pageNo-1 >= 1}">
        	<li><a class="pre" href="pcAction.do?method=getSensorLog&logsourcelogo=${logsourcelogo }&type=page&pageNo=${pageResult.pageNo-1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo-1 == 0}">
        	<li><a class="pre" href="pcAction.do?method=getSensorLog&logsourcelogo=${logsourcelogo }&type=page"></a></li>
		</c:if>

		<c:if test="${pageResult.pageNo+1 < pageResult.pageMaxSum}">
        	<li><a class="next" href="pcAction.do?method=getSensorLog&logsourcelogo=${logsourcelogo }&type=page&pageNo=${pageResult.pageNo+1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo+1 >= pageResult.pageMaxSum}">
        	<li><a class="next" href="pcAction.do?method=getSensorLog&logsourcelogo=${logsourcelogo }&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
		</c:if>

			<li><a class="last" href="pcAction.do?method=getSensorLog&logsourcelogo=${logsourcelogo }&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
        <li>共 ${pageResult.pageMaxSum } 页 跳至
          <input type="text" size="2" class="input" name="mark"/>
          &nbsp; </li>
        <li><a class="R6" href="javascript:goPage('${pageResult.pageMaxSum }','pcAction.do?method=getSensorLog&logsourcelogo=${logsourcelogo }&type=page')">GO</a></li>
</ul>
      <br />
      <br />
      <br />
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>