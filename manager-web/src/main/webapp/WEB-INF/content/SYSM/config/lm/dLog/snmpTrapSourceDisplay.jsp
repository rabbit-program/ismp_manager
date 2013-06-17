<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx }/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx }/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx }/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx }/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx }/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx }/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx }/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx }/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" src="${ctx}/js/LM/goPage.js"></script>
<script type="text/javascript">
$(function(){
	$(".boxy").boxy();
});
</script>
<script type="text/javascript">

function validate_SysLogConfigSourceQuery(){
	var deviceIP = document.getElementById("deviceIP").value;
	if(deviceIP.length > 0){
		if (!deviceIP.match(/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/)) {
			alert("你输入的IP地址无效"); 
			return false;
		} else {
			return true;
		}
	}
}

function updateStatus(id,status){
	var op = true;
	if(status){
		if(confirm("您是否要  关闭  该日志源!")){
			op = false;
		}else{
			return;
		}
	}else{
		if(confirm("您是否要  开启  该日志源!")){
			op = true;
		}else{
			return;
		}
	}
	window.location.href="snmpTrapConfigAction.do?method=updateSnmpTrapSource&id=" + id + "&startCollect=" + op;
}

function deleteSource(id,status){
	if(confirm("您是否要  删除  该日志源!")){
		window.location.href="snmpTrapConfigAction.do?method=delSnmpTrapSource&id=" + id + "&startCollect=" + status;
	}else{
		return;
	}
}
</script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="nor" id="m"><a href="${ctx}/ismp/domain/local/userConfig.do?method=forward&main=1"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">用户管理</span></a></li>
    <li class="act"><a href="${ctx}/ismp/domain/local/sysm/sysConfig.do"><span style="background:url(${ctx }/img/comm/other/03.gif) no-repeat; padding-left:22px;">平台配置</span></a></li>
  </div>
  <div class="contant"><h2 class="martop10">当前为SnmpTrap日志源配置</h2>
    <div class="greenborder pad3 overf">
<div class="greenborder greenback overf pad3 Height_a" >
<form action="snmpTrapConfigAction.do?method=getSnmpTrapSource" method="post" onsubmit="return validate_SysLogConfigSourceQuery()">
	<span style="float:left;">
		 <b>部门: <select name="domain">
					<option value="all" selected="selected">--全部--</option>
					<c:forEach items="${domainList }" var="domain">
						<option value="${domain.id }">${domain.domainName }</option>
					</c:forEach>
				</select>
&nbsp;&nbsp;&nbsp;
		设备IP: <input type="text" size="15" class="input" name="deviceIP"/> 
&nbsp;&nbsp;&nbsp;
		 状态: <select name="startCollectSwitch">
				<option value="true">启用</option>
                <option value="false">未启用</option> 
			</select> </b>
		<input class="submit" type="submit" name="submit" value="搜索"  style="margin-left:12px;" />
		<input class="submit" type="reset" name="reset" value="重置" /></span>
</form>	
<a href="snmpTrapConfigAction.do?method=initSnmpTrapSourceType" class="R6 R7 boxy" title="添加日志源"  style="margin-left:80px;">添加日志源</a> <a href="${ctx}/ismp/domain/local/sysm/sysConfig.do" class="R6 R7">返回上一级</a>
</div>
      <h2 class="martop10">SnmpTrap日志源 列表</h2>
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓ </span></th>
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
					<td width="205"><a href="javascript:updateStatus(${logSource.id },${logSource.startCollectSwitch });" class="R6 R7">修改状态</a><a href="javascript:deleteSource(${logSource.id },'${logSource.startCollectSwitch }');" class="R6 R7">删除</a></td>
				</tr>
			</c:forEach>
            </tbody>
          </table>
      </div>
      <ul id="page">
        <li><a class="first" href="snmpTrapConfigAction.do?method=getSnmpTrapSource&type=page"></a></li>

		<c:if test="${pageResult.pageNo-1 >= 1}">
        	<li><a class="pre" href="snmpTrapConfigAction.do?method=getSnmpTrapSource&type=page&pageNo=${pageResult.pageNo-1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo-1 == 0}">
        	<li><a class="pre" href="snmpTrapConfigAction.do?method=getSnmpTrapSource&type=page"></a></li>
		</c:if>

		<c:if test="${pageResult.pageNo+1 < pageResult.pageMaxSum}">
        	<li><a class="next" href="snmpTrapConfigAction.do?method=getSnmpTrapSource&type=page&pageNo=${pageResult.pageNo+1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo+1 >= pageResult.pageMaxSum}">
        	<li><a class="next" href="snmpTrapConfigAction.do?method=getSnmpTrapSource&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
		</c:if>

			<li><a class="last" href="snmpTrapConfigAction.do?method=getSnmpTrapSource&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
        <li>共 ${pageResult.pageMaxSum } 页 跳至
          <input type="text" size="2" class="input" name="mark"/>
          &nbsp; </li>
        <li><a class="R6" href="javascript:goPage('${pageResult.pageMaxSum }','snmpTrapConfigAction.do?method=getSnmpTrapSource&type=page');">GO</a></li>
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