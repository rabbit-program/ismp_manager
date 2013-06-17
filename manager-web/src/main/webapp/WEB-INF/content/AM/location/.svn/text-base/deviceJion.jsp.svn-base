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
    var a = document.getElementsByName("assetid");
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
     var descr = document.getElementById("descr").value;
     if(descr.length>200){
         	alert("备注过长！");
			return false;
     }   
 
}
</script> 
   
  <style type="text/css">
<!--
.STYLE2 {
    font-size: 14px;
    font-weight: bold;
    color: #408080;
}
.STYLE3 {
    color: #408080;
    font-weight: bold;
}
-->
  </style>
</head>
<body>

<html:form action="/ismp/domain/local/am/location.do?method=assetJionposition" onsubmit="return checkBox()">
       <div id="data"> 
       <h2 class="martop8">物理位置信息</h2> 
       <input type="hidden" name="seachpos" value="${seachpos}"> 
         
         <table >
                 <tr>
                   <td align="center" bgcolor="#F3F3F3">房号:${assetPositionBo.description }
                                <input type="hidden" name="pid" value="${assetPositionBo.id }">                       </td>
                 </tr>
          </table>
         
         
         </div>
         <div id="data">
         <h2 class="martop8">请选择设备</h2> 
         <div>
                  <input type=checkbox name=mmAll onclick="checkAll(this, 'assetid')">
                  <span>全选/反选</span>
         </div> 
         
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="css1">
         	<tr><td colspan="5"></td> </tr>
                          <logic:notEmpty name="dlist">
                            <logic:iterate id="d" name="dlist" indexId="i">
                              <c:if test="${i%5==0}">
                              <tr>                              </c:if>                                
                                 <td width="110">
                                    <input type="checkbox" value="${d.id }" name="assetid" id="asscheckbox" />${d.name }  
                                 </td>
                                
                            </logic:iterate>
                             <tr>
                                 	<td >备注信息：</td>
                                 	<td colspan="4">
                                 		<textarea name="descr" id="descr" rows="4" cols="175"></textarea>
                                 	</td>
                              </tr>
                          </logic:notEmpty>
            </table> 
           <div align="center">
                    <input type="submit" name="Submit" class="submit" value="关联" />
                    <input type="button" class="submit" name="Submit3" value="返回"  onclick="javascript:history.back(-1);" />
           </div>
          </div>
</html:form>
</body>
</html>