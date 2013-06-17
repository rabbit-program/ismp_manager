<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div id="data" class="pad1 ">
<table>
  <tr>
    <th> ID </th>
    <td>${clientQuestion.id }</td>
    <th> 所属域</th>
    <td>${clientQuestion.domain.domainName }</td>
  </tr>
  <tr>
    <th> 编号</th>
    <td>${clientQuestion.sn } </td>
    <th> sensorId</th>
    <td>${clientQuestion.sensorId } </td>
  </tr>
  <tr>
    <th> 问题来源</th>
    <td>${clientQuestion.source } </td>
    <th> 服务地址</th>
    <td>${clientQuestion.serverUrl } </td>
  </tr>
  <tr>
    <th> 问题提交人</th>
    <td>${clientQuestion.linkman } </td>
    <th> 提交人联系方式</th>
    <td>${clientQuestion.contactInfo }</td>
    
  </tr>
  <tr>
    <th> 问题状态</th>
    <td><c:choose><c:when test="${clientQuestion.state==1}">未处理</c:when>
        <c:when test="${clientQuestion.state==2}">处理中</c:when>
        <c:when test="${clientQuestion.state==3}">已处理</c:when>
        <c:when test="${clientQuestion.state==4}">已关闭</c:when>
        <c:otherwise>未知</c:otherwise></c:choose></td>
    <th> 创建时间</th>
    <td>${clientQuestion.createTime }</td>
    
  </tr>
  <tr>
    <th> 问题标题</th>
    <td>${clientQuestion.name } </td>
    <th>&nbsp;</th>
    <td>&nbsp;</td>
  </tr>


  <tr>
    <th>问题描述</th>
    <td> <textarea cols="80" rows="6" readonly>${clientQuestion.desc }</textarea> </td>
	 <th>&nbsp;</th>
	 <td>&nbsp;</td>
  </tr>
  <tr>
    <th> 备注 </th>
    <td><textarea cols="80" rows="6" readonly>${clientQuestion.remark }</textarea></td>
	 <th>&nbsp;</th>
	 <td>&nbsp;</td>
  </tr>
  </table>
</div>
</body>
</html>
