<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript">
           function breakPage(){
               window.location.history.go(-1);
           } 

           function validateSoftForm(){
               
        	var name = document.getElementById("name").value;
   			if(name==''){
   				alert("软件名不能为空！");
   				return false;
   			}else if(name.length>80){
   				alert("软件名长度太长！");
   				return false;
   			}

   			var manufacturer = document.getElementById("manufacturer").value;
   			if(manufacturer==''){
   				alert("发行商不能为空！");
   				return false;
   			}else if(manufacturer.length>100){
   				alert("发行商长度太长！");
   				return false;
   			}

   			var version = document.getElementById("version").value;
   			if(version==''){
   				alert("发行商不能为空！");
   				return false;
   			}else if(version.length>100){
   				alert("发行商长度太长！");
   				return false;
   			}

   			var description = document.getElementById("description").value;
   			if(description==''){
   				alert("描述信息不能为空！");
   				return false;
   			}else if(description.length>100){
   				alert("描述信息长度太长！");
   				return false;
   			}
   			var user = document.getElementById("user").value;
   			if(user==''){
   				alert("使用人不能为空！");
   				return false;
   			}else if(user.length>100){
   				alert("使用人长度太长！");
   				return false;
   			}
   			var telephone = document.getElementById("telephone").value;
   			if(telephone==''){
   				alert("电话不能为空！");
   				return false;
   			}else if(telephone.length>100){
   				alert("电话长度太长！");
   				return false;
   			}
   			var unit = document.getElementById("unit").value;
   			if(unit==''){
   				alert("单位不能为空！");
   				return false;
   			}else if(unit.length>100){
   				alert("单位长度太长！");
   				return false;
   			}
   			var department = document.getElementById("department").value;
   			if(department==''){
   				alert("部门不能为空！");
   				return false;
   			}else if(department.length>100){
   				alert("部门长度太长！");
   				return false;
   			}
   			var regid = document.getElementById("regid").value;
   			if(regid==''){
   				alert("登记时间不能为空！");
   				return false;
   			}else if(regid.length>100){
   				alert("登记时间长度太长！");
   				return false;
   			}
   			var validityPeriod = document.getElementById("validityPeriod").value;
   			var vpch = /\d/;
   			if(validityPeriod==''){
   				alert("有效期不能为空！");
   				return false;
   			}else{
   				if(vpch.test(validityPeriod)==false){
   					alert("有效期必须为数字！");
   					return false;
   				}
   			}
   			var stocktimepage = document.getElementById("stocktimepage").value;
   			if(stocktimepage==''){
   				alert("采购时间不能为空！");
   				return false;
   			}else if(stocktimepage.length>100){
   				alert("采购时间长度太长！");
   				return false;
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
<html:form action="/ismp/domain/local/am/soft.do?method=addSoft"
	onsubmit="return validateSoftForm(this)">
	<input type="hidden" name="locid" value="${locid }" />
	
	<div id="data">
	<table>
			<tr>
					<th>软件名称：</th>
					<td><input type="text" name="softbo.name" id="name"> <span
						class="STYLE1">*</span></td>
					<th>软件类型：</th>
					<td><select name="softbo.softwareType">
						<option value="os" selected="selected">操作系统</option>
						<c:choose>
							<c:when test="${sessionScope.SoftType == 'db'}">
								<option value="db" selected="selected">数据库</option>
							</c:when>
							<c:otherwise>
								<option value="db">数据库</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${sessionScope.SoftType == 'app'}">
								<option value="app" selected="selected">应用软件</option>
							</c:when>
							<c:otherwise>
								<option value="app">应用软件</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${sessionScope.SoftType == 'oa'}">
								<option value="oa" selected="selected">办公软件</option>
							</c:when>
							<c:otherwise>
								<option value="oa">办公软件</option>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${sessionScope.SoftType == 'other'}">
								<option value="other" selected="selected">其他</option>
							</c:when>
							<c:otherwise>
								<option value="other">其他</option>
							</c:otherwise>
						</c:choose>
					</select></td>
				</tr>
				<tr>
					<th>发行商：</th>
					<td><input type="text" name="softbo.manufacturer" id="manufacturer"> <span
						class="STYLE1">*</span></td>
					<th>版本：</th>
					<td><input type="text" name="softbo.version" id="version"> <span
						class="STYLE1">*</span></td>
				</tr>
				<tr>
					<th>描述信息：</th>
					<td><input type="text" name="softbo.description" id="description"> <span
						class="STYLE1">*</span></td>
					<th>使用人：</th>
					<td ><input type="text" name="softbo.user" id="user">
					<span class="STYLE1">*</span></td>
				</tr>
				<tr>
					<th>使用人电话：</th>
					<td><input type="text" name="softbo.telephone" id="telephone"> <span
						class="STYLE1">*</span></td>
					<th>单位：</th>
					<td><input type="text" name="softbo.unit" id="unit"> <span
						class="STYLE1">*</span></td>
				</tr>
				<tr>
					<th>部门：</th>
					<td><input type="text" name="softbo.department" id="department"> <span
						class="STYLE1">*</span></td>
					<th>状态：</th>
					<td><select name="softbo.status">
						<option value="1">在用</option>
						<option value="2">废弃</option>
					</select> <span class="STYLE1">*</span></td>
				</tr>
				<tr>
					<th>登记时间：</th>
					<td><input type="text" readonly="readonly" id="regid"
						name="registrationtimepage" id="registrationtimepage"
						class="Wdate"
						onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" /> <span
						class="STYLE1">*</span></td>
					<th>有效期：</th>
					<td><input type="text" name="softbo.validityPeriod" size="8" id="validityPeriod"
						maxlength="6">月 <span class="STYLE1">*</span></td>
				</tr>
				<tr>

					<th>采购时间:</th>
					<td><input type="text" readonly="readonly"
						name="stocktimepage" id="stocktimepage" class="Wdate"
						onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" /> <span
						class="STYLE1">*</span></td>
					<th>所属域:</th>
					<td><select name="softbo.locationId">
						<logic:notEmpty name="managerbo" scope="session">
							<logic:iterate id="m" name="managerbo" scope="session">
								<option
									<c:if test="${locid eq m.id }">selected="selected"</c:if>
									value="${m.id }">${m.domainName}</option>
							</logic:iterate>
						</logic:notEmpty>
						</select>
					</td>
				</tr>
		</table>
	</div>
	
	<div align="center" class="martop8">
           <input class="submit" type="submit" value="添加"  name="Submit">
           <input class="submit" type="reset" value="重置"  name="Submit">                      
           <input class="submit" type="button" onclick="javascript:history.back(-1);" value="返回" name="Submit3">
     </div>
</html:form>
