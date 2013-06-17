<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<title>index</title>
</head>
<body>
<h2>${asseInfoProj.domain.domainName }业务及支撑资产清单</h2>
<div id="data">
<table width="100%">

  <tr>
    <th> 业务名称 </th>
    <th> 业务重要性 </th>
    <th> 对应资产 </th>
  </tr>
<c:forEach items="${busiImpoList }" var="objectArray" >
 <tr>
    <td>${objectArray[0] }</td>
    <td><c:forEach items="${dicSecuLeveList }" var="secuLeve">
                      <c:if test="${secuLeve.secuLeveId==objectArray[1] }">
                       <c:set var="secuLeveName" value="${secuLeve.secuLeveName }" />
                      </c:if>
                     </c:forEach>${secuLeveName }</td>
    <td>${objectArray[2] }</td>
  </tr>
</c:forEach> 
</table>
</div>
</body>
</html>
