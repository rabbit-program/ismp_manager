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

<script type="text/javaScript">
function  trim(str){
    for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
    for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
    if(i>j) return "";  
    return  str.substring(i,j);  
} 

function addTeam(treeid) {
  //  alert(treeid);
    if (treeid == "" || treeid == null) {
        alert("请选择 要添加子节点所属父节点！");
    }else{
		var name=document.getElementById("name").value ;
		var mp=document.getElementById("mp").value;
		var job = document.getElementById("job").value;
		var fax=document.getElementById("fax").value ;
		var email=document.getElementById("email").value;
		
		if (trim(name) == ""|| trim(name) == null|| name == undefined|| name.length > 20) {
		    alert("姓名必须填写且不能超过20个字");
		    name.focus; return ;
		} 
		 if (trim(mp) == ""|| trim(mp) == null|| mp == undefined|| mp.length > 11 || /^\s*([1-9]\d*)?\s*$/.test(mp)==false) {
		    alert("手机号必须为数字且不能超过11个字");
		    mp.focus; return ;
		} 
		if (trim(job) == ""|| trim(job) == null|| job == undefined|| job.length > 20) {
		    alert("工作角色必须填写正确且不能超过20个字");
		    job.focus; return ;
		} 
		if (trim(fax) == ""|| trim(fax) == null|| fax == undefined||  fax.length > 10 ||/^\s*([1-9]\d*)?\s*$/.test(fax)==false) {
		    alert("传真号码必须填写正确且不能超过10个字符");
		    fax.focus; return ;
		}  
		if (email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) == -1 ||email == ""|| email == null|| email == undefined || email.length > 50) {
		    alert("邮件地址必须填写正确且不能超过50个字符");
		    //alert(email);
		    email.focus; return ;
		} 
        document.forms[0].submit();
    }
}

function clean(){
     document.forms[0].name.value="";
     document.forms[0].mp.value="";
     document.forms[0].job.value="";
     document.forms[0].fax.value="";
     document.forms[0].email.value="";
 }  
</script>
</head>
<body >
<div  id="data" class="pad1 ">
<h2>新建联系人信息</h2>
 <form action="${ctx}/ismp/domain/local/erm/phoneTree.do?method=addNode&linkManid=${linkManid}" method="post" >
  <table>
    <tr>
      <th> 姓名: <span class="alert">*</span></th>
      <td><input size="12" id="name" name="name"/></td>
    </tr>
    <tr>  
      <th> 手机号: <span class="alert">*</span></th>
      <td><input size="12" id="mp" name="mp"/></td>     
    </tr>
    <tr>
      <th> 工作角色:<span class="alert">*</span> </th>
      <td><input size="12" id="job" name="job"/></td>
    </tr>
    <tr>
      <th> 传真号:<span class="alert">*</span> </th>
      <td><input size="12" id="fax" name="fax"/></td>
    </tr>
    <tr>
      <th> 邮件地址(Email):<span class="alert">*</span> </th>
      <td><input size="12"  id="email" name="email"/></td>
    </tr>
     <input type="hidden" id="team_code" name="team_code" >
	<input type="hidden" id="linkManid" name="linkManid" value="${linkManid}">

  </table>
  <div class="paddiv">This is for verticl spacing</div>
<a href="#" class="R6" onclick="addTeam('${linkManid}');">新增</a>  <a href="#" class="R6" onclick="clean()">重置</a> 
<div class="paddiv">This is for verticl spacing</div>
</form>
</div>
</body>
</html>