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

<script language=Javascript> 
function checkAll(e, itemName) 
{ 
  var aa = document.getElementsByName(itemName); 
  for (var i=0; i<aa.length; i++) 
   aa[i].checked = e.checked; 
} 
function checkItem(e, allName) 
{ 
  var all = document.getElementsByName(allName)[0]; 
  if(!e.checked) all.checked = false; 
  else 
  { 
    var aa = document.getElementsByName(e.name); 
    for (var i=0; i<aa.length; i++) 
     if(!aa[i].checked) return; 
    all.checked = true; 
  } 
} 
function checkBox(){
    var a = document.getElementsByName("asscheckbox");
    var n = a.length;
    var k = 0;
    for (var i=0; i<n; i++){
         if(a[i].checked){
             k = 1;
         }
     }
     if(k==0){
         alert("请选择需要关联的设备!");
         return false;
     }       
 
}
</script> 

</head>
<body>
  <html:form action="/ismp/domain/local/am/softrelating.do?method=addSoftRelating" onsubmit="return checkBox()">
	 <div id="contant">
		<div id="main">
	  <div  id="data" class="pad1 greenborder">
	  <div class="greenborder pad3"><p>硬件名称：${softinfo.name }</p>
	  <p>版本：${softinfo.version }</p>
	  <p>描述信息：${softinfo.description }</p></div>
	  <h2 class="martop8">请选择设备</h2>
	  <p>全选/反选 <input type=checkbox name=mmAll onclick="checkAll(this, 'asscheckbox')"></p>
	  <input type="hidden" name="softrelatingvo.softwareId" value="${softinfo.id }">
	  
	  
	  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
                 <tr>
                 	<td colspan="2">
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								 <logic:notEmpty name="deviceList">    
				                   <logic:iterate id="dev" name="deviceList" indexId="i">
		                                      <c:if test="${i%5==0}">
		                                      	<tr> 
		                                      </c:if>                                 
				                            <td><input type="checkbox" value="${dev.id }" name="asscheckbox" id="asscheckbox" />${dev.name }</td>
				                    </logic:iterate>
				                 </logic:notEmpty>
							</tr>
						</table>                    	
                 	</td>
                 </tr>
                 <tr>
                      <td width="13%">备注信息：</td>
                      <td width="87%"><textarea cols="70" rows="5" name="softrelatingvo.description"></textarea></td>
                 </tr>
       </table>
	  
		</div>
		<div align="center">
		     <input class="submit" type="submit" value="关联" name="Submit">                    
		     <input class="submit" type="button" onclick="javascript:history.back(-1);" value="返回" name="Submit3">
		</div>
          </div>
          </div>
</html:form>
</body>
</html>