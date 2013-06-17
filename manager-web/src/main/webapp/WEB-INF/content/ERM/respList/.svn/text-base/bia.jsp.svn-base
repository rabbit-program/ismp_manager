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

<script type="text/javaScript">
function  trim(str){
    for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
    for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
    if(i>j) return "";  
    return  str.substring(i,j);  
} 
function checkBiaInput() {
	var business=document.getElementById("business").value;
    var priorityLevel=document.getElementById("priorityLevel").value;
    //alert(priorityLevel);
    var assets=document.getElementById("assets").value;
    var rto=document.getElementById("rto").value;
    var rtpo=document.getElementById("rtpo").value;

    if (trim(business) == ""|| trim(business) == null|| business == undefined) {
         alert("业务过程必须填写");
         business.focus; return ;
    } 
    if (priorityLevel == ""|| priorityLevel == null|| priorityLevel == undefined) {
        alert("请选择应急优先等级");
        priorityLevel.focus; return ;
    } 
    if (trim(assets) == ""|| trim(assets) == null|| assets == undefined) {
        alert("关键资产必须填写");
        assets.focus; return ;
    } 
    if (rto == ""|| rto == null|| rto == undefined ||/^\s*([1-9]\d*)?\s*$/.test(rto)==false) {
        alert("恢复时间目标必须填写且为数字");
        rto.focus; return ;
    }  
    if (rtpo == ""|| rtpo == null|| rtpo == undefined || /^\s*([1-9]\d*)?\s*$/.test(rtpo)==false) {
        alert("恢复时间点目标必须填写且为数字");
        //alert(rtpo);
        rtpo.focus; return ;
      } 
     document.forms[0].submit();
}

function clean(){
	document.getElementById("business").value="";
    document.getElementById("priorityLevel").value=1;
    document.getElementById("assets").value="";
    document.getElementById("rto").value="";
    document.getElementById("rtpo").value="";
}
</script>
</head>

<body class="pad3">
<form action="${ctx}/ismp/domain/local/erm/bia.do?method=savaorupdate" method="post">
<div  id="data" class="pad1 ">
  <h2>你现在选择的是  "  <b>${respname }</b> "</h2>
<logic:present name="biaList">
    <logic:notEmpty name="biaList">
        <logic:iterate id="bia" name="biaList">
    <table>
        <tr>
            <th> 业务过程 <span class="alert">*</span></th>
            <td colspan="3"><textarea name="business"  id="business" cols="30" rows="3">${bia.business }</textarea></td>
        </tr>
        <tr>
            <th> 应急优先等级 <span class="alert">*</span></th>
            <td colspan="3">
            <select id="priorityLevel" name="priorityLevel">
            <logic:present name="plist">
                <logic:notEmpty name="plist">
                    <logic:iterate id="info" name="plist">
                        <option value="${info.id }" <c:if test="${info.id ==bia.priorityLevel.id}">selected='selected'</c:if>>${info.name}</option>
                    </logic:iterate>
                </logic:notEmpty>
            </logic:present>
            </select>
     
            </td>
        </tr>
        <tr>
            <th> 关键资产 <span class="alert">*</span></th>
            <td colspan="3"><textarea name="assets" id="assets" cols="30" rows="3">${bia.assets }</textarea></td>
        </tr>
        <tr>
            <th> 恢复时间目标 <span class="alert">*</span></th>
            <td>
                <input size="12" name="rto" id="rto" value="${bia.rto}" /> 
                小时
            </td>
            <th>恢复时间点目标 <span class="alert">*</span></th>
            <td>
                <input size="12" name="rtpo" id="rtpo" value="${bia.rtpo }" />
                小时
            </td>
            <input type="hidden" value="${bia.id }" name="id"  id="id"/>
        </tr>
    </table>
        </logic:iterate>
    </logic:notEmpty>
</logic:present>

<logic:notPresent name="biaList">
    <table>
        <tr>
            <th> 业务过程 <span class="alert">*</span></th>
            <td colspan="3"><textarea id="business" name="business" cols="30" rows="3"></textarea></td>
        </tr>
        <tr>
            <th> 应急优先等级 <span class="alert">*</span></th>
            <td colspan="3">
                <select name="priorityLevel" id="priorityLevel">
                    <option value="1">高</option>
                    <option value="2">中</option>
                    <option value="3">低</option>
                </select>
            </td>
        </tr>
        <tr>
            <th> 关键资产 <span class="alert">*</span></th>
            <td colspan="3"><textarea id="assets" name="assets" cols="30" rows="3"></textarea></td>
        </tr>
        <tr>
            <th> 恢复时间目标 <span class="alert">*</span></th>
            <td>
                <input size="12" name="rto" id="rto" /> 
                小时
            </td>
            <th>恢复时间点目标 <span class="alert">*</span></th>
            <td>
                <input size="12"  id="rtpo" name="rtpo" />
                小时
            </td>
            <input type="hidden" name="id" id="id" />
        </tr>
    </table>
</logic:notPresent>
	
    <div class="paddiv">This is for verticl spacing</div>
	<input type="button" value="提交" class="R6 R7" onclick="checkBiaInput()" /><input type="button" value="清空" onclick="clean();"  class="R6 R7"  />
	<div class="paddiv">This is for verticl spacing</div>
</div>
</form>
</body>
</html>
