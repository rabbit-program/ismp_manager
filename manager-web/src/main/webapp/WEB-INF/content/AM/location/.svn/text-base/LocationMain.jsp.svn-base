<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 
<link href="css/assessmentCss.css" rel="stylesheet" type="text/css" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type='text/javascript'
	src='${basePath }/dwr/interface/checkLocation.js'></script>
<script type='text/javascript' src='${basePath }/dwr/engine.js'></script>
<script type='text/javascript' src='${basePath }/dwr/util.js'></script>
<script type="text/javascript">
	function loufang(flag) {
		if (flag == false) {
			document.getElementById("chial").style.display = "none";
		//	document.getElementById("parent").style.display = "";
		} else {
			document.getElementById("chial").style.display = "";
		//	document.getElementById("parent").style.display = "";
		}
	}
	function addRomm() {
		var pid = document.getElementById("posi").value;
		location.href = "location.do?method=getChialNode&parentId=" + pid;
	}
	function delRomm() {
		
		var pid = document.getElementById("posi").value;
		location.href = "location.do?method=getChialNode&del=1&parentId=" + pid;
	}
	function checkLou() {
		var louhao = document.getElementById("louNumber").value;
		var posi = document.getElementById("posi").value;
		if (posi == '') {
			alert('请选择委办局');
			return;
		}
		if (louhao == '') {
			alert("请输入楼栋名称");
			return;
		}
		checkLocation.getNodeDwr(louhao, posi, callBack);

	}

	function callBack(data) {

		if (data == true) {
			alert('名称重复了,请重新选择!');
			return;
		} else {
			document.forms[0].action = "location.do?method=addTree";
			document.forms[0].submit();
		}
	}
</script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="13"></td>
				<td width="13"></td>
				<td width="410" class="css4"><!--<input type="button" class="an-1"
					onclick="JavaScript:loufang(false)" value="添加委办局" /> --><input
					type="button" class="an-1" onclick="JavaScript:loufang(true)"
					value="添加楼号" /> <input type="button" class="an-1"
					onclick="JavaScript:addRomm()" value="添加房号" /></td>
				<td width="410" class="css4">
				<div align="right"><input type="button" value="删除楼栋信息"
					class="an-1" onclick="delRomm()"></div>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>

	<tr>
		<td width="3%" rowspan="3">&nbsp;</td>
		<td>
		<table width="90%" border="0" cellspacing="0" cellpadding="0"
			class="bian">
			<tr>
				<td height="4" background="images/a-021.gif"></td>
			</tr>
			<tr>
				<td bgcolor="f9f9fb">
				<table width="70%" border="0" align="center" cellpadding="0"
					cellspacing="0" class="css1">
					<tr>
						<td height="36">
						<p align="right"></p>
						</td>
					</tr> 
					<tr>
						<td height="92"> 
						<p align="center"></p>
						<html:form action="location.do?method=addTree"
							target="mainchiltFrame">
							<div id="chial"  style="display: inline;">
							<table width="355" border="0" align="center" cellpadding="0"
								cellspacing="0" class="css3">
								<tr>
									<td width="105">
									 部门名称: 
									</td>
									<td width="105">
									<div align="center"><select  name="position.parentId"
										id="posi">
										<logic:notEmpty name="managerbo" scope="session">
											<logic:iterate id="m" name="managerbo" scope="session"> 
													<option value="${m.id }">${m.managerName }</option> 
											</logic:iterate>
										</logic:notEmpty>
									</select></div>
									</td>
								</tr>
								<tr>
									<td>
									 楼栋名称: 
									</td>
									<td><input name="position.description"
										type="text" id="louNumber" maxlength="40"></td>
								</tr>
								<tr>
									<td height="23">&nbsp;</td>
									<td> <input type="button" name="Submit"
										class="an-1" onclick="checkLou()" value="添加">  </td>
								</tr>
							</table>
							</div>
						</html:form> <!--<html:form action="location.do?method=addTree"
							target="mainchiltFrame">
							<div id="parent">
							<table width="355" border="0" align="center" class="css3">

								<tr>
									<td width="105">
									<div align="center">委办局名称:</div>
									</td>
									<td width="234"   class="css2"><input
										type="text" name="position.description"> <input
										type="hidden" value="0" name="position.parentId"></td>
								</tr>
								<tr>
									<td height="23">&nbsp;</td>
									<td><label> <input type="submit" name="Submit"
										class="an-1" value="添加"> </label></td>
								</tr>
							</table>
							</div>
						</html:form> 
						 
						--></td>
					</tr>
					 
				</table>
				</td>
			</tr>
			<tr>
				<td background="images/a-026.gif"></td>
			</tr>
		</table>
		</td>
	</tr>
	  
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="15"></td>
			</tr>
		</table>
</td>
</tr>
</table>
</body>
</html>