<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
         alert("请选择需要取消关联的设备!");
         return false;
     }       
 
}
</script>
<style type="text/css">
<!--
.STYLE1 {
    color: #FFFFFF;
    font-weight: bold;
}
-->
</style>
</head>
<body>
<html:form action="/ismp/domain/local/am/hardwareRelating.do?method=cancelHardwareRaleting" onsubmit="return checkBox()">
		<input type="hidden" name="hid" value="${hardware.id}">    
       <div id="contant">
		<div id="main">
			<div  id="data" class="pad1 greenborder">
				 <h2 class="martop8">关联资产</h2>
				 <div class="greenborder pad3"><p>硬件名称：${hardware.name }</p>
	 			 <p>版本：${hardware.version }</p>
	 			 <p>描述信息：${hardware.description }</p></div>
	 			 <input type="hidden" name="hardwareraletingvo.hardwareId" value="${hardwareinfo.id }"/>
	  			 <h2 class="martop8">请选择设备</h2>
	  			 <input type=checkbox name=mmAll onclick="checkAll(this, 'asscheckbox')">全选/反选
	  			 
	  			 
	  			 <table >
                    <thead>
                    	<tr>
                    		<th colspan="2">设备名称</th>
                    		<th>备注信息</th>
                    	</tr>
                    </thead>
                    <tbody>
                   <logic:notEmpty name="deviceList">
                        <logic:iterate id="dev" name="deviceList" indexId="i">
                          <tr >
                            <td ><input type="checkbox" value="${dev.id }"  name="asscheckbox" id="asscheckbox" /></td>
                            <td>${dev.name }</td>
                            <td><logic:notEmpty name="hlist">
                                <logic:iterate id="h" name="hlist">
                                  <c:if test="${h.assetId==dev.id}">
                                    ${h.description }
                                  </c:if>
                                </logic:iterate>
                              </logic:notEmpty></td>
                          </tr>
                        </logic:iterate>
                      </logic:notEmpty>
                      <logic:empty name="deviceList">
                        <tr>
                          <td colspan="3"><div align="center"><font color="red">没有记录</font></div></td>
                        </tr>
                      </logic:empty>
                    </tbody>
                  </table>
			</div>
		</div>
	 </div>
   	<div align="center">
	     <input class="submit" type="submit" value="取消关联" name="Submit">                    
	     <input class="submit" type="button" onclick="javascript:history.back(-1);" value="返回" name="Submit3">
	</div>
       
          
          
          
          
          
          
          
          
</html:form>
</body>
</html>