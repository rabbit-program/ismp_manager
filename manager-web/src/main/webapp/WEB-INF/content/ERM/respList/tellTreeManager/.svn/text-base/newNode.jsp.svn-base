<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
<script type="text/javascript" src="${ctx}/js/ERM/check.js"></script>
<script type="text/javascript" src="${ctx}/dwr/interface/linkManService.js"></script>
<script type="text/javascript" src="${ctx}/dwr/engine.js"></script>
<script type="text/javascript" src="${ctx}/dwr/util.js"></script>
<script type="text/javaScript">

function addTeam(treeid,teamCode) {
	
    if (teamCode == "" || teamCode == null) {
    	checkCallTreeTeam();
    	document.forms[0].submit();
    }else if(treeid=="" || treeid == null){
    	alert("请选择 要添加子节点所属父节点！");
    }else{
        	checkCallTreeTeam();
        	var teamCode = document.getElementById("team_code").value;
        	var respid = document.getElementById("respid").value;
        	linkManService.checkTeamId(respid,teamCode,chkExt);
    }
}

function chkExt(data){
    if(data==true){
        document.getElementById("notice").innerHTML="<font color='red'>小组编号重复请输重新输入</font>";
    	//alert("小组编号重复请输重新输入");
    }else{
    	document.getElementById("notice").innerHTML="";
    	document.forms[0].submit();
    }
}

function clean(){
    document.forms[0].name.value="";
    document.forms[0].team_code.value="";
    document.getElementById("notice").innerHTML="";
}  


</script>
</head>
<body class="pad3" >

<div  id="data" class="pad1 ">
	<h2>新建团队信息</h2>
	<div id="notice"></div>
    <form action="${ctx}/ismp/domain/local/erm/phoneTree.do?method=addNode" method="post" >
	<table>
		<tr>
			<th> 小组名称 <span class="alert">*</span></th>
			<td><input size="12" id="name" name="name"/></td>
		</tr>
		<tr>
			<th> 小组编号 <span class="alert">*  (注意:不可重复)  </span></th>
			<td><input size="12" id="team_code" name="team_code" /></td>
		</tr>
    <input type="hidden" id="job" name="job" />
    <input type="hidden" id="email" name="email" />
    <input type="hidden" id="fax" name="fax" />
    <input type="hidden" id="mp" name="mp" />
    <input type="hidden" id="respid" name="respid" value="${respid}"/>
	<input type="hidden" id="linkManid" name="linkManid" value="${linkManid}">
	</table>
	<div class="paddiv">This is for verticl spacing</div>
	<a href="#" class="R6" onclick="addTeam('${linkManid}','${teamCode}');">新增</a> <a href="#" onclick="clean()" class="R6">重置</a> 
    </form>
	<div class="paddiv">This is for verticl spacing</div>
</div>
</boyd>
</html>