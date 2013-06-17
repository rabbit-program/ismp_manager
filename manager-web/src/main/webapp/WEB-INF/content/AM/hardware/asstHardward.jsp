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
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>

<script type="text/javascript">
                  function fwd(typid){  
                      var curpage=document.getElementById("mid").value;
                      var locid=document.getElementById("locid").value;
                      var type_id = document.getElementById("hardwaretype").value;
                      location.href="hardware.do?method=findHardWarePagin&hid="+type_id+"&curpage="+curpage+"&locid=" + locid;
                  }
                  function fwdAdd(locid){                     
                      location.href="fwdPage.do?addHardware=1&locid="+locid;
                  }
                  function del(id,tid,locid){
                      if(confirm("确认删除吗？")){                        
                        location.href="hardware.do?method=deleteHardware&hid="+id+"&tid="+tid+"&locid=" + locid;
                      }else{                         
                         return;
                      }
                  }
                  function fwpage(curpage){  
                      var locid=document.getElementById("locid").value;
                      var type_id = document.getElementById("hardwaretype").value;
                      location.href="hardware.do?method=findHardWarePagin&hid="+type_id+"&curpage="+curpage+"&locid=" + locid;
                  }
           </script>


</head>
<body>

<div id="contant">
<div id="main">
 <div id="data">
 	<h2 class="martop8">硬件列表</h2>
 	<input type="hidden" id="locid"  value="${locid}"/>
 	<input type="hidden" id="hardwaretype" value="${sessionScope.hardwareType }">
 	<table>
					<tr>
						<th>名称</th>
						<th>描述</th>
						<th>版本</th>
						<th>厂商</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
					<logic:notEmpty name="hardwarelist">
						<logic:iterate id="s" name="hardwarelist">
							<tr>
								<td>${s.name }</td>
								<td>${s.description }</td>
								<td>${s.version }</td>
								<td>${s.manufacturer}</td>
								<td><bean:write property="registrationTime" name="s"
									format="yyyy-MM-dd" /></td>
								<td >
									<a class="R6 R7" href="hardware.do?method=getOneHardware&hid=${s.id}">详细信息</a> <!-- 如果有权限的情况下才给修改按钮 --> 
									<!-- <a class="R6 R7" href="#" onclick="Boxy.load('hardware.do?method=getOneHardware&hid=${s.id}');" >详细信息</a> -->
									<sec:authorize ifAllGranted='ROLE_AdminAll'>
										<a class="R6 R7" href="hardware.do?method=getOneHardware&hardwareRaleting=1&hid=${s.id }">设备关联</a>
										<a class="R6 R7" href="hardware.do?method=getOneHardware&cancelHardwareRaleting=1&hid=${s.id }">取消关联</a>
										<a class="R6" href="hardware.do?method=getOneHardware&hid=${s.id }&up=1&locid=${locid}">修改</a>
										<!-- <a class="R6" href="#" onclick="Boxy.load('hardware.do?method=getOneHardware&hid=${s.id }&up=1&locid=${locid}');">修改</a> -->
										<a class="R6" href="javaScript:del('${s.id }','${s.hardwareType }','${locid }')">删除</a>
									</sec:authorize>
								</td>


							</tr>
						</logic:iterate>
					</logic:notEmpty>
					<logic:empty name="hardwarelist">
						<tr>
							<td align="center" class="border  minheight" colspan="6"><span class="alert">没有数据显示</span></td>
						</tr>
					</logic:empty>
					
		</table>
 		
 	</div>
 	
 	 <ul id="page">
        <li><a class="first" href="javaScript:fwpage('1')"></a></li>
        <li>
        <c:if test="${page.hasPrePage==true}">
			<a class="pre" href="javaScript:fwpage('${page.currentPage-1}')"></a>
		</c:if>
		</li>
        <li>
        <c:if test="${page.hasNextPage==true}">
			<a class="next" href="javaScript:fwpage('${page.currentPage+1 }')"></a>
		</c:if>
		</li>
        <li><a class="last"	href="javaScript:fwpage('${page.totalPage }')"></a></li>
        <li>共${page.totalPage }页 跳至
          <jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
          <sec:authorize ifAllGranted='ROLE_AdminAll'>
        	<li>
        	<a href="fwdPage.do?addHardware=1&locid=${locid}" class="R6 R7 boxy">添加硬件</a> 
        	<!-- <a href="#" onclick="Boxy.load('fwdPage.do?addHardware=1&locid=${locid}');" class="R6 R7 boxy">添加硬件</a> -->
        	</li>
          </sec:authorize>
      </ul>
	</div>
</div>



</body>
</html>