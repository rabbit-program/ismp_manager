<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type='text/javascript' src='${ctx }/dwr/interface/checkLocation.js'></script>
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>

<script type="text/javascript"><!--
	function addRomm() {
		var pid = document.getElementById("weibanju").value;
		document.getElementById("chial").style.display = "none";
		document.getElementById("lou").style.display = "";
		location.href = "location.do?method=getChialNode&parentId=" + pid;
	}
	function delRomm() {
		var pid = document.getElementById("p").value;
		location.href = "location.do?method=getChialNode&del=1&parentId=" + pid;
	}
	function loufang(flag) {
		if (flag == false) {
			document.getElementById("chial").style.display = "none";
		//	document.getElementById("parent").style.display = "";
			document.getElementById("lou").style.display = "none";
		} else {
			document.getElementById("chial").style.display = "";
		//	document.getElementById("parent").style.display = "none";
			document.getElementById("lou").style.display = "none";
		}
	}

	function checkLou() {
		var louhao = document.getElementById("fang").value;
		var pid = document.getElementById("weibanju").value;
		 var louName = document.getElementById("ln").value;
		if (pid == '') {
			alert('请选择委办局');
			return;
		}
	 	if (louName == '') {
			alert('选择楼号名称');
			return;
		}
		if (louhao == '') {
			alert("请输入房间信息");
			return;
		} 
		 
		 checkLocation.getNodeDwr(louName, pid, callBackRomm);
	}
	function callBackRomm(data) {
		if (data == true) {
			alert('名称重复了,请重新选择!');
			return;
		} else {
			var pid = document.getElementById("weibanju").value;
			//document.forms[0].target="childFrameLoaction";
			document.forms[0].action = "location.do?method=addTree";
            document.forms[0].submit();
			//document.forms[0].action = "location.do?method=getChialNode&parentId=" + pid; // "location.do?method=addTree";
			//document.forms[0].submit();
		}
	}

	function checkL() {
		var louhao = document.getElementById("louNumber").value;
		var p = document.getElementById("p").value;
		if (p == '') {
			alert('请选择域');
			return;
		}
		if (louhao == '') {
			alert("请输入楼栋名称");
			return;
		}
		checkLocation.getNodeDwr(louhao,p, callBack);

	}

	function callBack(data) {

		if (data == true) {
			alert('名称重复了,请重新选择!');
			return;
		} else {
			document.forms[1].action = "location.do?method=addTree";
			document.forms[1].submit();
		}
	}
	function doLoc(value)
	{
		
		document.forms[0].target="childFrameLoaction";
		/*document.forms[0].action */ location.href = "location.do?method=getChialNode&parentId=" + value; // "location.do?method=addTree";
      //  document.forms[0].submit();
	}
--></script>
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
				<td width="14"></td>
				<td width="14"></td>
				<td width="420" class="css4"><!--<input type="button" class="an-1"
					onclick="JavaScript:loufang(false)" value="添加委办局" /> -->
					<input	type="button" class="submit" onclick="JavaScript:loufang(true)"	value="添加楼号 " />
					<input type="button" class="submit" onclick="javaScript:addRomm()" value="添加房号">
					<a href="#" class="R6 R7" onclick="loufang(true);">添加楼号</a>
					<a href="#" class="R6 R7" onclick="addRomm()">添加楼号</a>
					</td>
				<td width="410" class="css4">
				<div align="right">
					<input type="button" value="删除楼栋信息"	class="submit" onclick="delRomm()">
					</div>
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
						<td height="36"></td>
					</tr>
					<tr>
						<td height="92"><html:form
							action="/ismp/domain/local/am/location.do?method=addTree" target="mainchiltFrame">
							<div id="lou">
							<table width="355" border="0" align="center" cellpadding="0"
								cellspacing="0" class="css3">
								<tr>
									<td>部门:</td>
									<td width="105">
										 <select name="position.parentId_" id="weibanju" onChange="doLoc(value)"   >
                                        <logic:notEmpty name="managerbo" scope="session">
                                            <logic:iterate id="m" name="managerbo" scope="session"> 
                                                    <option value="${m.id }" <c:if test="${parentId == m.id }">selected="selected"</c:if> >${m.domainName }</option> 
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </select></td>
								</tr>
								<tr>
									<td>楼栋名称:</td>
									<td width="234"><select name="position.parentId" id="ln">
										<logic:notEmpty name="nodeList">
											<logic:iterate id="pl" name="nodeList">
												<option value="${pl.id }" >${pl.description}</option>
											</logic:iterate>
										</logic:notEmpty>
									</select></td>
								</tr>
								<tr>
									<td>房间号:</td>
									<td><input name="position.description" type="text"
										id="fang" maxlength="40"></td>
								</tr>
								<tr>
									<td height="23">&nbsp;</td>
									<td><label> <input type="button" class="an-1"
										onclick="checkLou()" name="Submit" value="添加"> </label></td>
								</tr>
							</table>
							</div>
						</html:form> <html:form action="location.do?method=addTree"
							target="mainchiltFrame">
							<div id="chial" style="display: none;">
							<table width="355" border="0" align="center" class="css3">
								<tr>
									<td>
									<div>部门:</div>
									</td>
									<td width="105">
									<div> <select name="position.parentId"
                                        id="p">
                                        <logic:notEmpty name="managerbo" scope="session">
                                            <logic:iterate id="m" name="managerbo" scope="session"> 
                                                    <option value="${m.id }">${m.domainName }</option> 
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </select></div>
									</td>
								</tr>
								<tr>
									<td width="105">
									<div>楼栋名称:</div>
									</td>
									<td width="234"><input type="text"
										name="position.description" id="louNumber"></td>
								</tr>
								<tr>
									<td height="23">&nbsp;</td>
									<td><label> <input type="button" class="submit"
										name="Submit" value="添加" onclick="checkL()"> </label></td>
								</tr>
							</table>
							</div>
						</html:form></td>
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
</body>
</html>