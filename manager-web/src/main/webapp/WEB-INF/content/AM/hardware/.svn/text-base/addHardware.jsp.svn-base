<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript">
		   var regu = /^[-]{0,1}[0-9]{1,}$/;
           function breakPage(){
               window.location.history.go(-1);
           } 
           
           function checkHardwareInput(){
        	   if (document.getElementById("1").value == null
          				|| document.getElementById("1").value == undefined
          				|| document.getElementById("1").value == ""
          				|| document.getElementById("1").value.length > 30){
          			alert("硬件名称必填且不超过30个字符!");
          			return false;
          		}else if (document.getElementById("2").value == null
       				|| document.getElementById("2").value == undefined
       				|| document.getElementById("2").value == ""
       				|| document.getElementById("2").value.length > 30){
       			alert("硬件版本必填且不超过30个字符!");
       			return false;
       		}else if (document.getElementById("3").value == null
       				|| document.getElementById("3").value == undefined
       				|| document.getElementById("3").value == ""
       				|| document.getElementById("3").value.length > 30){
       			alert("发行商必填且不超过30个字符!");
       			return false;
       		}else if (document.getElementById("4").value == null
       				|| document.getElementById("4").value == undefined
       				|| document.getElementById("4").value == ""
       				|| document.getElementById("4").value.length > 20){
       			alert("容量或主频信息必填!");
       			return false;
       		}else if (document.getElementById("5").value == null
       				|| document.getElementById("5").value == undefined
       				|| document.getElementById("5").value == ""
       				|| document.getElementById("5").value.length > 8
       				|| !regu.test(document.getElementById("5").value)){
       			alert("有 效 期必填且为数字!");
       			return false;
       		}else if (document.getElementById("6").value == null
       				|| document.getElementById("6").value == undefined
       				|| document.getElementById("6").value == ""
       				|| document.getElementById("6").value.length > 600){
       			alert("描述必填!");
       			return false;
       		}else if (document.getElementById("7").value == null
       				|| document.getElementById("7").value == undefined
       				|| document.getElementById("7").value == ""){
       			alert("登记时间必填!");
       			return false;
       		}else if (document.getElementById("8").value == null
       				|| document.getElementById("8").value == undefined
       				|| document.getElementById("8").value == ""){
       			alert("采购时间必填!");
       			return false;
       		}else{
       			return true;
       		}
       		}   
   
</script>
<style type="text/css">
<!--
.STYLE1 { 
	color: #FF0000
}
-->
</style>
</head>
<body>
<html:form action="/ismp/domain/local/am/hardware.do?method=addHardware" onsubmit="return checkHardwareInput()">
	<input type="hidden" name="locid" value="${locid}" />
	
	
<div id="contant">
<div id="main">
 <div id="data">
 	<h2 class="martop8">添加硬件(<font size="2" color="red">说明：带*号表示必填</font>)</h2>
				<table >

						<tr>
							<th>硬件名称：</th>
							<td width="39%"><input id="1" name="hardware.name" type="text"
								maxlength="30"> <span class="STYLE1">*</span></td>
							<th>硬件类型：</th>
							<td><select name="hardware.hardwareType">
								<option value="cpu" selected="selected">CPU</option>
								<c:choose>
									<c:when test="${sessionScope.hardwareType == 'harddisk'}">
										<option value="harddisk" selected="selected">硬盘</option>
									</c:when>
									<c:otherwise>
										<option value="harddisk">硬盘</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${sessionScope.hardwareType == 'memory'}">
										<option value="memory" selected="selected">内存</option>
									</c:when>
									<c:otherwise>
										<option value="memory">内存</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${sessionScope.hardwareType == 'interface'}">
										<option value="interface" selected="selected">网卡</option>
									</c:when>
									<c:otherwise>
										<option value="interface">网卡</option>
									</c:otherwise>
								</c:choose>
							</select></td>
						</tr>
						<tr>
							<th>硬件版本：</th>
							<td><input id="2" name="hardware.version" type="text"
								maxlength="30"> <span class="STYLE1">*</span></td>
							<th>发行商：</th>
							<td><input id="3" name="hardware.manufacturer" type="text"
								maxlength="30"> <span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>状 &nbsp;&nbsp;&nbsp;态：</th>
							<td><select name="hardware.status">
								<option value="1">在用</option>
								<option value="2">废弃</option>
							</select> <span class="STYLE1">*</span></td>
							<th>容量或主频信息：</th>
							<td width="36%"><input id="4" name="hardware.capacity" type="text"
								maxlength="20"> <span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>有 效 期：</th>
							<td><input id="5" type="text" name="hardware.validityPeriod"
								size="8" maxlength="6">月 <span class="STYLE1">*</span></td>
							<th>登&nbsp;&nbsp;记&nbsp;&nbsp;时&nbsp;&nbsp;间：</th>
							<td><input id="7" type="text" readonly="readonly"
								name="registrationtimepage" id="registrationtimepage"
								class="Wdate"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" /> <span
								class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>所属域：</th>
							<td><select name="hardware.locationId">
								<logic:notEmpty name="managerbo" scope="session">
									<logic:iterate id="m" name="managerbo" scope="session">
										<option
											<c:if test="${locid eq m.id }">selected="selected"</c:if>
											value="${m.id }">${m.domainName}</option>
									</logic:iterate>
								</logic:notEmpty>
							</select></td>
							<th>采&nbsp;&nbsp;购&nbsp;&nbsp;时&nbsp;&nbsp;间：</th>
							<td><input id="8" type="text" readonly="readonly"
								name="stocktimepage" id="stocktimepage" class="Wdate"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" /> <span
								class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>描&nbsp;&nbsp;&nbsp;&nbsp;述：</th>
							<td><textarea id="6" rows="4" cols="55" name="hardware.description"></textarea>
							<span class="STYLE1">*</span></td>
							<td></td>
							<td></td>
						</tr>
					</table>
			<div align="center" class="martop8">
                    <input class="submit" type="submit" value="添加"  name="Submit">
                    <input class="submit" type="submit" value="重置"  name="Submit">                      
                    <input class="submit" type="button" onclick="javascript:history.back(-1);" value="返回" name="Submit3">
            </div>
		</div>
	</div>
</div>
</html:form>
</body>
</html>