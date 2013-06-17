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
<script type="text/javascript">
           function breakPage(){
               window.location.history.go(-1);
           } 
 
   </script>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 12px;
	color: #FF3399;
}

.STYLE2 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>

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
          alert("请选择需要取消关联的设备!");
          return false;
      }       
  
 }

</script>
</head>
<body>

<html:form action="/ismp/domain/local/am/location.do?method=cancelAssetJionposition" onsubmit="return checkBox()">
	<input type="hidden" name="seachpos" value="${seachpos }">
	<div id="data">
	<h2 class="martop8">物理位置信息</h2> 
		<table >
				<tr>
					<td align="center" bgcolor="#F3F3F3"></td>
				</tr>
				<tr>

					<td align="center" bgcolor="#F3F3F3">房号:${assetPositionBo.description } <input
						type="hidden" name="pid" checked="checked"
						value="${assetPositionBo.id }"></td>
				</tr>
		</table>
		<h2 class="martop8">请选择设备</h2> 
		<table >
				<tr>
					<th>
					<input type=checkbox name=mmAll	onClick="checkAll(this, 'assetid')"> 全选/反选 
					</th>
					<th>设备名称	</th>
					<th>描述信息</th>
				</tr>
				<logic:notEmpty name="dlist">
					<logic:iterate id="d" name="dlist" indexId="i">
						<tr class="css1">
							<td width="4%" height="22">
							<div align="left"><input type="checkbox" value="${d.id }"
								name="assetid" id="asscheckbox" /></div>
							</td>
							<td width="35%">${d.name }</td>
							<td><logic:notEmpty name="assetList">
								<logic:iterate id="al" name="assetList">
									<c:if test="${d.id==al.assetId}">
										<div align="center">${al.description }</div>
									</c:if>
								</logic:iterate>
							</logic:notEmpty></td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
				<tr>
					
				</tr>
		</table>
		
		<div align="center">
			<input type="submit" class="submit" name="Submit" value="取消关联" />
		 	<input type="button" class="submit" name="Submit3" value="返回" onClick="javascript:history.back(-1);" />
		</div>
		
		
	</div>
</html:form>
</body>
</html>