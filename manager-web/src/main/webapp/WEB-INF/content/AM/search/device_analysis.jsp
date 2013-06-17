<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<script type="text/javascript" src="js/prototype-1.6.0.3.js"
	language="javascript"></script>
<script type="text/javascript">
	function doForward(value) {
		location.href = "deviceAnalysis.do?locid=" + value;
	}
</script>

</head>
<body> 


<div id="data">
	<h2 class="martop8">物理位置信息</h2> 
	<div class="greenborder greenback overf pad3 Height_a" align="center">
						所属机构： <select name="d"
							onchange="doForward(this.value)">
							<option value="-1">全部机构</option>
							<logic:notEmpty name="managerbo" scope="session">
								<logic:iterate id="m" name="managerbo" scope="session">
									<option
										<c:if test="${locid eq m.id }"> selected="selected" </c:if>
										value="${m.id }">${m.domainName}</option>
								</logic:iterate>
							</logic:notEmpty>
						</select>
	</div>
	
	<h2 class="martop8">资产设备年历统计</h2>
	<div class="greenborder overf pad3" align="center">
		<img src="<%=request.getContextPath()%>/DisplayChart?filename=${deviceImg}" />
	</div>
</div>

<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<td height="21">&nbsp;</td> 
	</tr>

	<tr>
		<td height="21">&nbsp;</td> 
	</tr>

	<tr>
		<td height="21">&nbsp;</td> 
	</tr>
</table>
</body>
<script type="text/javascript">
	//window.parent.topFrame.location.reload();
	parent.topFrame.location.reload();
</script>
</html>
