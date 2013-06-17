<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript">

function ckeckForm(form){
    //验证IP地址
   var ipch= /^([1-9]|[1-9]\d|1\d{2}|2[0-1]\d|22[0-3])(\.(\d|[1-9]\d|1\d{2}|2[0-4]\d|25[0-5])){3}$/  ;
   var ip=document.getElementById("ipaddress").value;
    if(ip!=''){
        if(ipch.test(ip)==false){
           alert('IP地址不正确（IP地址格式为：192.168.9.253）');
           return false;
        }
    } 
    
 }
function doClick(){ 
	window.open("device_.do","mainchiltFrame");
}
</script>
</head>
<body>



<div id="data">
      <h2 class="martop8">设备详细信息</h2>
		<form action="asset.do?method=updateSearchDevice" method="post"	onsubmit="return ckeckForm(this)"><input type="hidden"
				name="assetBo.id" value="${device.id }" />
			<table >
				<tr>
					<th>资产名称：</th>
					<td><input type="text" name="assetBo.name"
						value="${device.name }" /></td>
					<th>资产类型：</th>
					<td><select name="assetBo.assetType">
						<option
							<c:if test="${device.assetType == 1}">selected="selected"</c:if>
							value="1">网络设备</option>
						<option
							<c:if test="${device.assetType == 2}"> selected="selected"</c:if>
							value="2">安全设备</option>
						<option
							<c:if test="${device.assetType == 3}"> selected="selected"</c:if>
							value="3">服务器</option>
						<option
							<c:if test="${device.assetType == 4}"> selected="selected"</c:if>
							value="4">桌面主机</option>
					</select></td>
				</tr>
				<tr>
					<th>资产编号：</th>
					<td><input type="text" name="assetBo.sn"
						value="${device.sn }" /></td>
					<th>采购日期：</th>
					<td><input type="text" name="stocktimepage"
						id="stocktimepage" readonly="readonly"
						value="<bean:write format='yyyy-MM-dd HH:mm' property='stockTime' name='device' />"
						class="Wdate"
						onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" /></td>
				</tr>
				<tr>
					<th>有效期：</th>
					<td><input type="text" name="assetBo.validityPeriod"
						value="${device.validityPeriod }" size="4" maxlength="6" />月</td>
					<th>当前状态：</th>
					<td><select name="assetBo.status">
						<option
							<c:if test="${device.status == 1}">selected="selected"</c:if>
							value="1">在线</option>
						<option
							<c:if test="${device.status == 2}">selected="selected"</c:if>
							value="2">报废</option>
					</select></td>
				</tr>
				<tr>
					<th>使 用 人：</th>
					<td><input type="text" name="assetBo.user"
						value="${device.user }" /></td>
					<th>联系方式：</th>
					<td><input type="text" name="assetBo.telephone"
						value="${device.telephone }" /></td>
				</tr>
				<tr>
					<th>IP 地 址：</th>
					<td><input id="ipaddress" type="text" name="assetBo.ip"
						value="${device.ip }" /></td>
					<th>单位：</th>
					<td><input type="text" name="assetBo.unit"
						value="${device.unit }" /></td>
				</tr>
				<tr>
					<td colspan="4">
					<div align="center"><input name="button3" type="submit"
						class="submit" id="button3" value="修 改" /> <input name="button4" type="button"
						class="submit" id="button4" value="返 回" onclick="doClick();"/></div>
					</td>
				</tr>
			</table>
			</form>
			
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="test">
							<tr>
								<td></td>
								<td width="129"><a
									href="soft.do?method=getAssetToSoft&aid=${device.id }"
									target="down"><span class="menus10"> 软件信息 </span> </td>
								<td width="126"><a
									href="hardware.do?method=getAssetToHardware&hid=${device.id }"
									target="down"><span class="menus11"> 硬件信息</span> </td>
								<td width="147"><a
									href="location.do?method=getLocationinfo&did=${device.id}"
									target="down"><span class="menus12"> 地理位置信息</span></td>
								<td width="143"><a
									href="changelog.do?method=searchAll&id=${device.id }"
									target="down"><span class="menus07"> 资产变动信息 </span> </td>
								<td width="148"><a
									href="assetAvailability.do?method=statisticAnalysis&deviceId=${device.id }"
									target="_blank"><span class="menus07"> 可用性统计查看</span> </td>
								<td width="321" align="right">&nbsp;</td>
							</tr>
						</table>
</div>

</body>
</html>
