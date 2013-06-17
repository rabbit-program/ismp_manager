<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript">
	function assign(){
			document.forms("assignForm").submit();
		}
</script>
<div  id="data" class="pad1 ">
<h2>指派部门 / 修改部门</h2>
<form action="userConfig.do?method=updateUserToManager" method="post" id="assignForm" name="assignForm">
	<input type="hidden" name="userid" id="userid" value="${user.id }">
	<input type="hidden" name="search" value="${search }">
	<input type="hidden" name="curpage" value="${curpage }">
  <table>
    <tr>
      <th>用户名</th>
      <td>${user.loginName }  </td>
      <th>真实姓名</th>
      <td>${user.username }</td>
    </tr>
    <tr>
      <th>手机</th>
      <td>${user.mobile }</td>
      <th><div align="center">邮箱</div></th>
      <td>${user.email }</td>
    </tr>
    <tr>
      <th>电话</th>
      <td>${user.phone }</td>
       <th>状态</th>
      <td><c:if test="${user.enabled}">可用</c:if><c:if test="${!user.enabled}">不可用</c:if> </td>
    </tr>
    <tr>
      <th>创建时间</th>
      <td>${user.registertime }</td>
      <th>所属角色</th>
      <td> 
      		<logic:notEmpty name="rolelist">
     	 <logic:iterate id="rl" indexId="s" name="rolelist">
     	 			<c:set value="0" var="flag"></c:set>
					<logic:iterate id="rol" name="rlist" indexId="i">
						<c:if test="${rol.role==rl.role}">
							<c:set value="1" var="flag"></c:set>
							<td><input type="checkbox" name="roleid" value="${rl.id }" checked="checked"></td>
							<td>${rl.name}</td>
						</c:if>
					</logic:iterate>
					<c:if test="${flag==0}">
					<td><input type="checkbox" name="roleid" value="${rl.id }">
					</td>
					<td>${rl.name}</td>
					</c:if>
		</logic:iterate>
		</logic:notEmpty>
      </td>
    </tr>
  </table>
  <h2>指派部门 / 修改部门</h2>
   <table>
   	<logic:notEmpty name="domainList">
   		<logic:iterate id="rl" indexId="s" name="domainList">
   			<tr>
   				<c:set value="0" var="flag"></c:set>
   				<logic:notEmpty name="domainset">
   					<logic:iterate id="r2" name="domainset">
   						<c:if test="${rl.domainName eq r2.domainName}">
   							<c:set value="1" var="flag"></c:set>
   							<td><input type="checkbox" name="mid" value="${rl.id}" checked="checked"> ${rl.domainName }</td>
   						</c:if>
   					</logic:iterate>
   				</logic:notEmpty>
				<c:if test="${flag==0}">
					<td><input type="checkbox" name="mid" value="${rl.id}" > ${rl.domainName }</td>
				</c:if>   				
   			</tr>
   		</logic:iterate>
   	</logic:notEmpty>
  </table>
  </form>
  <div class="paddiv">This is for verticl spacing</div>
<a href="#" onclick="assign();" class="R6">指派</a>
<div class="paddiv">This is for verticl spacing</div>
</div>
