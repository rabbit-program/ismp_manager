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
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />

<script language="javascript">

function  trim(str){
    for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
    for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
    if(i>j) return "";  
    return  str.substring(i,j);  
} 

function checkRespInput() {
	 var name= document.getElementById("name").value;
	 var dmid= document.getElementById("dmid").value;
	 var sysName= document.getElementById("sysName").value; 
	 var sysDesc= document.getElementById("sysDesc").value; 
	 var touchBy= document.getElementById("touchBy").value;  
	 var references= document.getElementById("references").value; 
	 //alert(name+"===,"+dmid+"===,"+sysName+"=====,"+sysDesc+"===,"+touchBy+"===,"+references+"===,");
    if (trim(name) == null|| name == undefined|| trim(name) == ""|| name.length > 25) {
        alert("预案名称必填且不超过25个字符!");
        name.focus; return ;
    } else if (dmid == null|| dmid == undefined|| dmid == "") {
        alert("请选择所属单位!");
        dmid.focus; return ;
    } else if (trim(sysName) == null|| sysName == undefined|| trim(sysName) == ""|| sysName.length > 255) {
        alert("IT系统描述必填且不超过255个字符!");
        sysName.focus; return ;
    } else if (trim(sysDesc) == null|| sysDesc == undefined|| trim(sysDesc) == ""|| sysDesc.length > 255) {
        alert("应急目标描述必填且不超过255个字符!");
        sysDesc.focus; return ;
    } else if (trim(touchBy) == null|| touchBy == undefined || trim(touchBy) == ""|| touchBy.length > 255) {
        alert("预备案的假定必填且不超过255个字符!");
        touchBy.focus; return ;
    } else if (trim(references) == null|| references == undefined|| trim(references) == ""|| references.length > 255) {
        alert("参考文献必填且不超过255个字符!");
        references.focus; return ;
    } 
    document.forms[0].submit();
}

</script>
</head>

<body>
<form action="${ctx}/ismp/domain/local/erm/addrespinfo.do?isAll=${isAll}" method="post" id="addForm" name="addForm" >
	<input id="isAdd" name="isAdd" type="hidden" value="1" />
	<div id="data" class="pad1 ">
	    <h2>建立新预案 "<span class="alert">*</span>"为必填项</h2>
	    <table>
	        <tr>
	            <th>预案名称<span class="alert">*</span></th>
	            <td><input size="8" name="name" id="name" /></td>
	            <th>所属单位<span class="alert">*</span></th>
	            <td>
	                <select id="dmid" name="dmid">
	                    <c:forEach items="${udl}" var="ud">
	                        <option value="${ud.id}">${ud.domainName}</option>
	                    </c:forEach>
	                </select>
	            </td>
	        </tr>
	        <tr>
	            <th>IT系统描述<span class="alert">*</span></th>
	            <td colspan="3"><textarea cols="60" rows="5" name="sysName" id="sysName"></textarea></td>
	        </tr>
	        <tr>
	            <th>应急目标描述<span class="alert">*</span></th>
	            <td colspan="3"><textarea name="sysDesc" cols="60" rows="5" id="sysDesc"></textarea></td>
	        </tr>
	        <tr>
	            <th>预案的假定<span class="alert">*</span></th>
	            <td colspan="3"><textarea name="touchBy" cols="60" rows="5" id="touchBy"></textarea></td>
	        </tr>
	        <tr>
	            <th>参考文献<span class="alert">*</span></th>
	            <td colspan="3"><textarea name="references" cols="60" rows="5" id="references"></textarea></td>
	        </tr>
	    </table>
	    <div class="paddiv"></div>
	    <input type="button" value="提交" class="R6 R7" onclick="checkRespInput()"/>
	    <div class="paddiv"></div>
	</div>
</form>
</body>
</html>