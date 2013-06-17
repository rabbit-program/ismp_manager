<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<style type="text/css">
<!--
.STYLE1 {
	color: #FF0000
}
-->
</style>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript">
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
			var regid = document.getElementById("registrationtimepage").value;
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
</head>
<body>
<html:form action="/ismp/domain/local/am/soft.do?method=updateSoft"
	onsubmit="return validateSoftForm(this)">
<input type="hidden" name="locid" value="${locid }"/>
	<div id="data">
	
			更新软件信息(<font size="2" color="red">说明：带*号表示必填</font>)
			<table >
						<html:hidden property="softbo.id"/>
						<tr>
							<th>软件名称：</th>
							<td>
							<input type="text" name="softbo.name" id="name" value="${softinfo.name }"> 
							<span class="STYLE1">*</span></td>
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
							<td>
								<input type="text" name="softbo.manufacturer" value="${softinfo.manufacturer }" id="manufacturer">
							 <span
								class="STYLE1">*</span></td>
							<th>版本：</th>
							<td>
							<input type="text" name="softbo.version" value="${softinfo.version }" id="version">
							<span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>描述信息：</th>
							<td>
							<input type="text" name="softbo.description" value="${softinfo.description }" id="description">
							 <span	class="STYLE1">*</span> </td>
							<th>使用人：</th>
							<td width="36%">
							<input type="text" name="softbo.user" value="${softinfo.user }" id="user">
							<span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>使用人电话：</th>
							<td>
							<input type="text" name="softbo.telephone" value="${softinfo.telephone }" id="telephone">
							<span class="STYLE1">*</span></td>
							<th>单位：</th>
							<td>
							<input type="text" name="softbo.unit" value="${softinfo.unit }" id="unit">
							 <span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>部门：</th>
							<td>
							<input type="text" name="softbo.department" value="${softinfo.department }" id="department">
							 <span class="STYLE1">*</span></td>
							<th>状态：</th>
							<td><select name="softbo.status">
								<c:choose>
									<c:when test="${softForm.softbo.status == 1}">
										<option value="1" selected="selected">在用</option>
										<option value="2">废弃</option>
									</c:when>
									<c:when test="${softForm.softbo.status == 2}">
										<option value="1">在用</option>
										<option value="2" selected="selected">废弃</option>
									</c:when>
									<c:otherwise>
										<option value="1">在用</option>
                                        <option value="2">废弃</option>
									</c:otherwise>
								</c:choose>
							</select> <span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>登记时间：</th>
							<td><input type="text" name="registrationtimepage"
								id="registrationtimepage"
								value="<bean:write name="softinfo" property="registrationTime" format="yyyy-MM-dd HH:mm"/>"
								readonly="readonly" class="Wdate"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" /> <span
								class="STYLE1">*</span></td>
							<th>有效期：</th>
							<td>
								<input name="softbo.validityPeriod" type="text" size="8" maxlength="6" id="validityPeriod" value="${softinfo.validityPeriod }">
								月 <span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>采购时间:</th>
							<td><input type="text" name="stocktimepage"
								id="stocktimepage"
								value="<bean:write name="softinfo" property="stockTime" format="yyyy-MM-dd HH:mm"/>"
								readonly="readonly" class="Wdate"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" />
							<span class="STYLE1">*</span></td>
							<th>所属域:</th>
							<td> <select name="softbo.locationId">
                                <logic:notEmpty name="managerbo" scope="session">
                                    <logic:iterate id="m" name="managerbo" scope="session">
                                        <option <c:if test="${locid eq m.id }">selected="selected"</c:if>  value="${m.id }">${m.domainName}</option>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </select> 
						 </td>
						</tr>
					</table>
					
					
					
					
					
					
					
					
					
					
					
					
					<!-- <table >
						<html:hidden property="softbo.id"/>
						<tr>
							<th>软件名称：</th>
							<td><html:text property="softbo.name"/> 
							
							<span class="STYLE1">*</span></td>
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
							<td><html:text property="softbo.manufacturer" /> <span
								class="STYLE1">*</span></td>
							<th>版本：</th>
							<td><html:text property="softbo.version" /> <span
								class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>描述信息：</th>
							<td><html:text property="softbo.description" /> <span
								class="STYLE1">*</span> </td>
							<th>使用人：</th>
							<td width="36%"><html:text property="softbo.user"></html:text>
							<span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>使用人电话：</th>
							<td><html:text property="softbo.telephone" /> <span
								class="STYLE1">*</span></td>
							<th>单位：</th>
							<td><html:text property="softbo.unit" /> <span
								class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>部门：</th>
							<td><html:text property="softbo.department" /> <span
								class="STYLE1">*</span></td>
							<th>状态：</th>
							<td><select name="softbo.status">
								<c:choose>
									<c:when test="${softForm.softbo.status == 1}">
										<option value="1" selected="selected">在用</option>
										<option value="2">废弃</option>
									</c:when>
									<c:when test="${softForm.softbo.status == 2}">
										<option value="1">在用</option>
										<option value="2" selected="selected">废弃</option>
									</c:when>
									<c:otherwise>
										<option value="1">在用</option>
                                        <option value="2">废弃</option>
									</c:otherwise>
								</c:choose>
							</select> <span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>登记时间：</th>
							<td><input type="text" name="registrationtimepage"
								id="registrationtimepage"
								value="<bean:write name="softinfo" property="registrationTime" format="yyyy-MM-dd HH:mm"/>"
								readonly="readonly" class="Wdate"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" /> <span
								class="STYLE1">*</span></td>
							<th>有效期：</th>
							<td><html:text property="softbo.validityPeriod" size="8"
								maxlength="6"></html:text>月 <span class="STYLE1">*</span></td>
						</tr>
						<tr>
							<th>采购时间:</th>
							<td><input type="text" name="stocktimepage"
								id="stocktimepage"
								value="<bean:write name="softinfo" property="stockTime" format="yyyy-MM-dd HH:mm"/>"
								readonly="readonly" class="Wdate"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" />
							<span class="STYLE1">*</span></td>
							<th>所属域:</th>
							<td> <select name="softbo.locationId">
                                <logic:notEmpty name="managerbo" scope="session">
                                    <logic:iterate id="m" name="managerbo" scope="session">
                                        <option <c:if test="${locid eq m.id }">selected="selected"</c:if>  value="${m.id }">${m.domainName}</option>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </select> 
						 </td>
						</tr>
					</table> -->
		</div>
		<div align="center" class="martop8">
			<input type="submit" class="submit" name="Submit" value="更新" />
			<input type="button" name="Submit3"	class="submit" value="返回" onclick="javascript:history.back(-1);">
		</div>
	
</html:form>
</body>
</html>