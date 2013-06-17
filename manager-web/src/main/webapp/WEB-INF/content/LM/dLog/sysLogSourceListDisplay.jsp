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

<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/LM/goPage.js"></script>
<script type="text/javascript" src="${ctx}/js/LM/sysLogValidate.js"></script>
<script type="text/javascript">

function validate_SysLogSourceQuery(){
	var deviceIP = document.getElementById("deviceIP").value;
	if(deviceIP.length > 0){
		if (!deviceIP.match(/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/)) {
			alert("你输入的IP地址无效"); 
			return false;
		} else {
			return false;
		}
	}
}
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
      <li id="m"><a  class="mback" href="sysLogAction.do?method=originalDisplay"><span class="menus10"> 原始Syslog</span></a></li>
      <li><a  class="mbacka" href="sysLogAction.do?method=logSourceDisplay"><span class="menus10">Syslog</span></a></li>
      <li><a  class="mback" href="snmpTrapAction.do?method=getSnmpTrapSource"><span class="menus11">Trap</span></a></li>
      <li><a  class="mback" href="pcAction.do?method=getPcSource"><span class="menus12">PC</span></a></li>
    </div>
    <div class="greenborder pad3 overf">
      <h2 class="martop10">请选择查询条件</h2>
<div class="greenborder greenback overf pad3 Height_a" >
<form action="sysLogAction.do?method=logSourceDisplay" method="post" onsubmit="return validate_SysLogSourceQuery()">
	<span style="float:left;">
		 <b>部门: <select name="domain">
					<option value="all" selected="selected">--全部--</option>
					<c:forEach items="${domainList }" var="domain">
						<option value="${domain.id }">${domain.domainName }</option>
					</c:forEach>
				</select>
<span style="margin-left:10px;">&nbsp;</span>
		设备IP: <input type="text" size="15" class="input" name="deviceIP"/> 
<span style="margin-left:10px;">&nbsp;</span>
		 状态: <select name="startCollectSwitch">
				<option value="true">启用</option>
                <option value="false">未启用</option> 
			</select> </b>
	</span>
		<input class="submit" type="submit" name="submit" value="搜索"  style="margin-left:12px;" />
		<input class="submit" type="reset" name="reset" value="重置" /></span>
</form>
</div>
      <h2 class="martop10">Syslog日志源 列表</h2>
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓</span></th>
                <th> 日志源名称</th>
                <th> 创建时间 </th>
				<th> 相关设备名称 </th>
				<th> 设备IP </th>
				<th> 所属部门 </th>
                <th> 当前状态 </th>
                <th> 操作</th>
              </tr>
            </thead>
            <tbody>
			<c:if test="${empty pageResult.pageResult }">
					<tr>
					<td align="center" colspan="8">Sorry ! 暂无相应的数据...</td>
					</tr>
			</c:if>
			<c:forEach items="${pageResult.pageResult}" var="logSource" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${logSource.sourceName }</td>
					<td>${logSource.createTime }</td>
					<td>${logSource.sourceType.sourceTypeName }</td>
					<td>${logSource.deviceIP }</td>
					<td>${logSource.domain.domainName }</td>
					<td>${logSource.startCollectSwitch == true?'启用':'未启用'}</td>
					<td><a href="sysLogDivSourceAction.do?method=sysLogGetDevice&device=${logSource.sourceType.handleOrParserType.webHandleClass }&logsourcelogo=${logSource.logSourceseQuence }" class="R6 R7">查看日志源</a></td>
				</tr>
			</c:forEach>
            </tbody>
          </table>
      </div>
      <ul id="page">
        <li><a class="first" href="sysLogAction.do?method=logSourceDisplay&type=page"></a></li>

		<c:if test="${pageResult.pageNo-1 >= 1}">
        	<li><a class="pre" href="sysLogAction.do?method=logSourceDisplay&type=page&pageNo=${pageResult.pageNo-1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo-1 == 0}">
        	<li><a class="pre" href="sysLogAction.do?method=logSourceDisplay&type=page"></a></li>
		</c:if>

		<c:if test="${pageResult.pageNo+1 < pageResult.pageMaxSum}">
        	<li><a class="next" href="sysLogAction.do?method=logSourceDisplay&type=page&pageNo=${pageResult.pageNo+1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo+1 >= pageResult.pageMaxSum}">
        	<li><a class="next" href="sysLogAction.do?method=logSourceDisplay&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
		</c:if>

			<li><a class="last" href="sysLogAction.do?method=logSourceDisplay&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
        <li>共 ${pageResult.pageMaxSum } 页 跳至
          <input type="text" size="2" class="input" name="mark"/>
          &nbsp; </li>
        <li><a class="R6" href="javascript:goPage('${pageResult.pageMaxSum }','sysLogAction.do?method=logSourceDisplay&type=page')">GO</a></li>
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