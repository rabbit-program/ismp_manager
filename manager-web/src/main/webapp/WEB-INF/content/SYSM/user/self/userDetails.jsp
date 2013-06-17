<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<div  id="data" class="pad1 ">
<h2>用户详细信息</h2>
  <table>
    <tr>
      <th>用户名</th>
      <td>${user.loginName }</td>
      <th>真实姓名</th>
      <td>${user.username }</td>
    </tr>
    <tr>
      <th>手机</th>
      <td>${user.mobile }</td>
      <th>邮箱</th>
      <td>${user.email }</td>
    </tr>
    <tr>
      <th>电话</th>
      <td>${user.phone }</td>
      <th>职位</th>
      <td>${user.job }</td>
    </tr>
    <tr>
      <th>创建时间</th>
      <td>${user.registertime }</td>
      <th>所属角色</th>
      <td><c:set var="size" value="0"></c:set>
          <c:forEach	var="role" items="${rlist}" varStatus="s">
			<c:set var="size" value="1"></c:set>
			<c:if test="${s.index==0}"> ${role.name} </c:if>
			<c:if test="${s.index!=0}"> ,${role.name} </c:if>
		</c:forEach> 
		<c:if test="${size==0}">未分配角色</c:if>
	   </td>
    </tr>
    <tr>
      <th>管辖部门</th>
      <td><c:set var="size" value="0"></c:set>
          	<c:forEach	var="domain" items="${domainList}" varStatus="s">
			<c:set var="size" value="1"></c:set>
			 <c:if test="${s.index==0}"> ${domain.domainName} </c:if>
			 <c:if test="${s.index!=0}"> ,${domain.domainName} </c:if>
			</c:forEach> 
			<c:if test="${size==0}">未分配部门</c:if> </td>
      <th>状态</th>
      <td><c:if test="${user.enabled==true}">启用</c:if>
          <c:if test="${user.enabled==false}">禁用</c:if>
      </td>
    </tr>
  </table>
</div>
