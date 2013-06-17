<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.awt.*"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mainframe</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/tree/dtree.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
<script type="text/javascript" src="${ctx}/js/comm/tree/dtree_linkMan.js"></script>
<script type="text/javascript" src="${ctx}/js/ERM/check.js"></script>

<script type="text/javascript">

function golinkDelete(id,path,respname) {
    if (id == "" || id == null) {
        alert("请选择 节点！");
    } else {
        var r = confirm("确认删除")
        if (r==true) {
          window.location.href = path+ "/ismp/domain/local/erm/phoneTree.do?method=deleteNode&linkManId="+id+"&respname="+respname;
        }
    } 
}
function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}


function clean(){
	document.getElementById("name").value="";
	document.getElementById("mp").value="";
	document.getElementById("job").value="";
	document.getElementById("fax").value="";
	document.getElementById("email").value="";
}  

function clean1(){
	document.getElementById("name").value="";
} 

function  trim(str){
    for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
    for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
    if(i>j) return "";  
    return  str.substring(i,j);  
} 

function onEdit(isTeam){
	if(isTeam=='yes'){
		var name1=document.getElementById("name").value ;
		if (trim(name1) == ""|| trim(name1) == null|| name1 == undefined|| name1.length > 20) {
	        alert("姓名必须填写且不能超过20个字");
	        name1.focus; return ;
	    } 
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
	        email.focus; return ;
	    } 
	}
    document.forms[0].submit();
}
</script>

</head>
<body class="pad3">
<div  id="data" class="pad1 ">
<h2>Telltree 你现在选择的是 " <b>${respname} </b>"</h2>
  <div class="greenborder greenback overf pad3" style="width:400px; height:300px; overflow-y:scroll; float:left;">
        <div id="dtree" class="dtree">
            <p><a href="javascript: d.openAll();">全部展开</a> | <a href="javascript: d.closeAll();">全部收起</a></p>
            <script type="text/javascript">
            d=new dTree('d',"${ctx}");
            ${treeList}
            document.write(d);
            </script>
        </div>  
  </div>
  <div class="greenborder greenback overf pad3" style="width:230px; min-height:300px; float:left; margin-left:13px;">
<logic:empty name="link">
    <table >
        <tr>
            <td style="color: red" colspan="2">请选择左边节点</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </table>
</logic:empty> 
<logic:notEmpty name="link">
<form action="${ctx}/ismp/domain/local/erm/phoneTree.do?method=edit&respname=${respname}" method="post">
     <table >
         <html:hidden property="id" value="${link.id}" />
         <html:hidden property="pid" value="${link.pid}" />
         <html:hidden property="fid" value="${link.fid}" />
         <tr>
             <td colspan="2" style="color: red">
                 <c:choose>
                  <c:when test="${isTeam == 'yes'}">
                                                                                               编辑应急团队信息
                  </c:when>
                  <c:otherwise>
                                                                                              编辑应急联系人信息
                  </c:otherwise>
                 </c:choose>
             </td>
         </tr>
         <tr>
             <td>
                 <c:choose>
                  <c:when test="${isTeam == 'yes'}">                                                              
                                                                                             小组名 :<span class="alert">*</span>
                  </c:when>
                  <c:otherwise>
                                                                                              姓名 :<span class="alert">*</span>
                  </c:otherwise>
                 </c:choose>
             </td>
             <td><html:text property="name" styleId="name"  value="${link.name}" /></td>
         </tr>
         <c:choose>
         <c:when test="${isTeam == 'yes'}">
             
             <tr>
             <td>小组编号 :<span class="alert">*</span></td>
             <td><html:text property="teamCode" styleId="teamCode"  value="${link.teamCode}" readonly="true" /></td>                                                        
             </tr>
         </c:when>
         <c:otherwise>
         <tr>
             <td>手机号 :<span class="alert">*</span></td>
             <td><html:text property="mp" styleId="mp"  value="${link.mp}" /></td>
         </tr>

         <tr>
             <td>工作角色:<span class="alert">*</span></td>
             <td><html:text property="job" styleId="job" value="${link.job}" /></td>
         </tr>
         
         <tr>
             <td>传真号 :<span class="alert">*</span></td>
             <td><html:text property="fax" styleId="fax"  value="${link.fax}" /></td>
         </tr>
         <tr>
             <td>邮件地址(Email) :<span class="alert">*</span></td>
             <td><html:text property="email"  styleId="email" value="${link.email}" /></td>

         </tr>
         
         </c:otherwise>
         </c:choose>
         <tr>

             <td><input type="button" value="修改"  class="R6 R7"  onclick="onEdit('${isTeam}')"/></td>
                <c:choose>
                  <c:when test="${isTeam == 'yes'}">                                                              
                    <td><input type="button" value="重置" class="R6 R7"  onclick="clean1();"/></td>
                  </c:when>
                  <c:otherwise>
                    <td><input type="button" value="重置" class="R6 R7"  onclick="clean();" /></td>
                  </c:otherwise>
                 </c:choose>
            
            </tr>
        
  </table>
<form>
</logic:notEmpty>
</div>
<div class="paddiv">This is for verticl spacing</div>
<c:if test="${treeList == 'null' || treeList==''}">      
<a href="#" class="R6 R7" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/erm/phoneTree.do?method=addteam&linkManid=${linkManid}&teamCode=${teamCode}','新增小组','scrollbars=yes,width=300,height=200')">新增小组</a>
</c:if>
<c:if test="${isTeam == 'yes'}">                                                                                               
<a href="#" class="R6 R7" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/erm/phoneTree.do?method=addteam&linkManid=${linkManid}&teamCode=${teamCode}','新增小组','scrollbars=yes,width=300,height=200')">新增小组</a>
<a href="#" class="R6 R7" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/erm/phoneTree.do?method=addperson&linkManid=${linkManid}&teamCode=${teamCode}','新增人员','scrollbars=yes,width=300,height=350')">新增人员</a>
</c:if>
<a onclick="golinkDelete('${linkManid}','${ctx}','${respname}');" class="R6 R7" href="#" >删除节点</a>
<div class="paddiv">This is for verticl spacing</div>
</div>
</body>
</html>
