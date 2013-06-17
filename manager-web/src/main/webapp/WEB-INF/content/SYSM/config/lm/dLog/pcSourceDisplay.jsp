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
<script type="text/javascript" src="${ctx}/js/LM/pcValidate.js"></script>
<script type="text/javascript">
$(function(){
	$(".boxy").boxy();
});
</script>
<script type="text/javascript">

function validate_pcConfigSourceQuery(){
	var deviceIP = document.getElementById("sensorIp").value;
	if(deviceIP.length > 0){
		if (!deviceIP.match(/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/)) {
			alert("你输入的IP地址无效"); 
			return false;
		} else {
			return true;
		}
	}
}

function reset(){
	var sensorSenquence = document.getElementsByName("sensorSequence");
    for(i=0; i < sensorSenquence.length; i++) {
        sensorSenquence[i].checked = false;
    }
}
function selectAll(){
	var sensorSenquence = document.getElementsByName("sensorSequence");
    for(k=0; k < sensorSenquence.length; k++) {
        sensorSenquence[k].checked = true;
    }
}

function updateAllStatus(){
	var sensorSenquence = document.getElementsByName("sensorSequence");
	var isSelect = false;
	var idList = "";
	for(j = 0; j < sensorSenquence.length; j ++){
		if(sensorSenquence[j].checked == true){
			isSelect = true;
			idList = idList + sensorSenquence[j].value + ",";
		}
	}
    if(isSelect == false){
        alert("请选择要开启的Sensor");
        return;
    }else{
        if(confirm("您是否要  开启  此批Sensor采集!")){
    		window.location.href="pcConfigAction.do?method=updatePcSource&id=" + idList;
        }else{
            return;
        }
    }
}


function updateStatus(id,status){
	var op = true;
	if(status){
		if(confirm("您是否要  关闭  该Sensor采集!")){
			op = false;
		}else{
			return;
		}
	}else{
		if(confirm("您是否要  开启  该Sensor采集!")){
			op = true;
		}else{
			return;
		}
	}
	window.location.href="pcConfigAction.do?method=updatePcSource&id=" + id + "&startCollect=" + op;
}

function deleteSource(id,status){
	if(confirm("您是否要  删除  该日志源!")){
		window.location.href="sysLogConfigAction.do?method=delSysLogSource&id=" + id + "&startCollect=" + status;
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
  <div class="contant"><h2 class="martop10">当前为  PC 日志源配置</h2>
    <div class="greenborder pad3 overf">
<div class="greenborder greenback overf pad3 Height_a" >
<form action="pcConfigAction.do?method=getPcSource&type=sel" method="post" onsubmit="return validate_pcConfigSourceQuery();">
	<span style="float:left;">
		 <b>部门: <select name="domain">
					<option value="all" selected="selected">--全部--</option>
					<c:forEach items="${domainList }" var="domain">
						<option value="${domain.id }">${domain.domainName }</option>
					</c:forEach>
				</select>
&nbsp;&nbsp;&nbsp;
		设备IP: <input type="text" size="15" class="input" name="sensorIp"/> 
&nbsp;&nbsp;&nbsp;
		 状态: <select name="startCollectSwitch">
				<option value="true" title="启用">启用</option>
                <option value="false" title="未启用">未启用</option> 
			</select> </b>
		<input class="submit" type="submit" name="submit" value="搜索"  style="margin-left:12px;" />
		<input class="submit" type="reset" name="reset" value="重置" /></span>
</form>

	<a href="javascript:updateAllStatus();" class="R6 R7" title="批量开启"  style="float: right;margin-right:70px;">批量开启</a>

<a href="${ctx}/ismp/domain/local/sysm/sysConfig.do" class="R6 R7" style="margin-left:200px;">返回上一级</a>
</div>
      <h2 class="martop10">已分配部门 Sensor 列表</h2>
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> 序号 <span class="webdings">↓ </span></th>
                <th> 计算机名称</th>
                <th> Mac </th>
				<th> 系统 </th>
				<th> 设备IP </th>
				<th> 所属部门 </th>
				<th> 采集间隔(分) </th>
                <th width="70"> 采集状态 </th>
                <th width="150"> <span style="float: left;">操作</span> 
						<a class="R6" style="float: left; margin: 6px; height:19px;" href="javascript:selectAll()">全选</a>
						<span style="float: left;">|</span>
						<a class="R6" style="float: left; margin: 6px; height:19px;" href="javascript:reset()">取消</a>
				</th>
              </tr>
            </thead>
            <tbody>
			<c:if test="${empty pageResult.pageResult }">
					<tr>
					<td align="center" colspan="9">Sorry ! 暂无相应的数据...</td>
					</tr>
			</c:if>
			<c:forEach items="${pageResult.pageResult}" var="sensor" varStatus="status">
				<tr>
					<td>${status.index + 1 }</td>
					<td>${sensor.computerName }</td>
					<td>${sensor.sensorMac }</td>
					<td>${sensor.computerOSType }</td>
					<td>${sensor.sensorIp }</td>
					<td>${sensor.domain.domainName }</td>
					<td>${sensor.intervalCollectTime/60 }</td>
					
				<c:if test="${sensor.sensorIsExist==true }">
					<c:if test="${sensor.startMonitorSwitch==true }">
						<td>${sensor.startCollectSwitch == true?'启用':'未启用'}</td>
						<td width="205">
							<c:if test="${sensor.startCollectSwitch}">
								<span style="float: left; margin-left:20px; margin-right:20px;"><img src="${ctx }/img/LM/l_ok.png" width="16" height="16" title="已开启采集"/></span>
								<a href="javascript:updateStatus(${sensor.id },${sensor.startCollectSwitch });" class="R6" style=" height:19px;">关闭</a>
							</c:if>
							<c:if test="${!sensor.startCollectSwitch}">
								<input class="noneborder" type="checkbox" name="sensorSequence" title="勾选开启采集" style="float:left; margin-left:18px; margin-right:18px;" value="${sensor.id }" />
								<a href="pcConfigAction.do?method=updatePcSourceintervalCollectTime&id=${sensor.id }" class="R6 boxy" style=" height:19px;" title="开启Sensor采集">开启</a>
							</c:if>
						</td>
					</c:if>
					<c:if test="${sensor.startMonitorSwitch==false }">
						<td colspan="2" align="center" style="FONT-SIZE: 11pt; COLOR: #ff00ff; LINE-HEIGHT: 150%; FONT-FAMILY: 华文新魏" title="该Sensor在TOPO管理面板上没有开启监控!"><img src="${ctx }/img/LM/l_err.png" width="16" height="16" title="该Sensor在TOPO管理面板上没有开启监控!"/>此设备未开启监控</td>
					</c:if>
				</c:if>
				<c:if test="${sensor.sensorIsExist==false }">
					<td colspan="2" align="center" style="FONT-SIZE: 11pt; COLOR: #ff00ff; LINE-HEIGHT: 150%; FONT-FAMILY: 华文新魏" title="该Sensor在TOPO管理面板上已删除"><img src="${ctx }/img/LM/monitor.gif" width="16" height="16" title="该Sensor在TOPO管理面板上已删除"/>此Sensor已作废</td>
				</c:if>
				</tr>
			</c:forEach>
            </tbody>
          </table>
      </div>
      <ul id="page">
        <li><a class="first" href="pcConfigAction.do?method=getPcSource&type=page"></a></li>

		<c:if test="${pageResult.pageNo-1 >= 1}">
        	<li><a class="pre" href="pcConfigAction.do?method=getPcSource&type=page&pageNo=${pageResult.pageNo-1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo-1 == 0}">
        	<li><a class="pre" href="pcConfigAction.do?method=getPcSource&type=page"></a></li>
		</c:if>

		<c:if test="${pageResult.pageNo+1 < pageResult.pageMaxSum}">
        	<li><a class="next" href="pcConfigAction.do?method=getPcSource&type=page&pageNo=${pageResult.pageNo+1 }"></a></li>
		</c:if>
		<c:if test="${pageResult.pageNo+1 >= pageResult.pageMaxSum}">
        	<li><a class="next" href="pcConfigAction.do?method=getPcSource&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
		</c:if>

			<li><a class="last" href="pcConfigAction.do?method=getPcSource&type=page&pageNo=${pageResult.pageMaxSum }"></a></li>
        <li>共 ${pageResult.pageMaxSum } 页 跳至
          <input type="text" size="2" class="input" name="mark"/>
          &nbsp; </li>
        <li><a class="R6" href="javascript:goPage('${pageResult.pageMaxSum }','pcConfigAction.do?method=getPcSource&type=page')">GO</a></li>
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