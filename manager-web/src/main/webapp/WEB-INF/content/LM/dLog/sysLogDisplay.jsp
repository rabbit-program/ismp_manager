<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
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
<script type="text/javascript" src="${ctx}/js/LM/goPage.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	$(".boxy").boxy();
});
</script>
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
      <li id="m"><a  class="mbacka" href="sysLogAction.do?method=originalDisplay"><span class="menus10"> 原始Syslog</span></a></li>
      <li><a  class="mback" href="sysLogAction.do?method=logSourceDisplay"><span class="menus10">Syslog</span></a></li>
      <li><a  class="mback" href="snmpTrapAction.do?method=getSnmpTrapSource"><span class="menus11">Trap</span></a></li>
      <li><a  class="mback" href="pcAction.do?method=getPcSource"><span class="menus12">PC</span></a></li>
    </div>
    <div class="greenborder pad3 overf">
      <h2 class="martop10">请选择查询条件</h2>
    <div class="greenborder Height_a greenback overf pad3" >
      <span style="float:left;">当前搜索条件为：</span>
 <span class="tdcut_a" style="float:left;" title="${sysLogResponseQueryBean.query.stringOptimize }"><span class="font_tip">${sysLogResponseQueryBean.query.stringOptimize }</span></span>
<a href="sysLogAction.do?method=getQueryEntry" class="R6 R7 boxy" title="自定义搜索">自定义搜索</a>
    </div>
      <h2 class="martop10">原始Syslog列表</h2>
      <div id="data" class="greenborder overf pad1" >
        <form name="f1" id="f1" action="" method="post">
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓ </span></th>
                <th> 部门名称</th>
                <th> 主机IP </th>
                <th> 时间 </th>
                <th> 程序模块 </th>
				<th> 内容 </th>
                <th> 严重性 </th>
              </tr>
            </thead>
            <tbody>
			<c:if test="${empty pageResult.pageResult }">
					<tr>
					<td align="center" colspan="7">Sorry ! 暂无相应的数据...</td>
					</tr>
			</c:if>
            <c:forEach items="${pageResult.pageResult }" var="sysLogBean" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>	<!-- 显示条数序号(<td>${sysLogBean.id }</td>  sysLog日志序号) -->
					<td>${sysLogBean.domain.domainName }</td>
					<td>${sysLogBean.hostname }</td>
					<td>${sysLogBean.timestamp }</td>
					<td>${sysLogBean.facility.facilityDescribe }</td>
					<td> <div class="tdcut" title="${sysLogBean.message }">${sysLogBean.message }</div> </td>
					<td>${sysLogBean.severity.severityDescribe }</td>
				</tr>
			</c:forEach>
            </tbody>
          </table>
        </form>
      </div>
      <ul id="page">
        <li><a class="first" href="sysLogAction.do?method=originalDisplay&type=page"></a></li>

		<c:if test="${pageResult.pageNo-1 >= 1}">
        	<li><a class="pre" href="sysLogAction.do?method=originalDisplay&type=page&pageNo=${pageResult.pageNo-1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo-1 == 0}">
        	<li><a class="pre" href="sysLogAction.do?method=originalDisplay&type=page"></a></li>
		</c:if>

		<c:if test="${pageResult.pageNo+1 < pageResult.pageMaxSum}">
        	<li><a class="next" href="sysLogAction.do?method=originalDisplay&type=page&pageNo=${pageResult.pageNo+1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo+1 >= pageResult.pageMaxSum}">
        	<li><a class="next" href="sysLogAction.do?method=originalDisplay&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
		</c:if>

			<li><a class="last" href="sysLogAction.do?method=originalDisplay&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
        <li>共 ${pageResult.pageMaxSum } 页 跳至
          <input type="text" size="2" class="input" name="mark"/>
          &nbsp; </li>
        <li><a class="R6" href="javascript:goPage('${pageResult.pageMaxSum }','sysLogAction.do?method=originalDisplay&type=page')">GO</a></li>
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