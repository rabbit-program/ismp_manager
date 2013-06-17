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
<div id="data">
<table width="100%">
  <tr>
  <center><td width="700" align="center"><img src="${graphURL }" width="700" height="350" border="0" usemap="#${filename }" /></td> </center> 
  </tr>
</table>
<h2 class="martop10">${asseInfoProj.domain.domainName }资产及重要性清单</h2>
<table width="100%">
  <tr>
    <th> 资产类别 </th>
    <th> 资产名称 </th>
    <th> 资产重要性 </th>
  </tr>
 <c:forEach items="${assetList }" var="asse" >
  <tr>
    <td>${asse.asseKind.assetKindName }</td>
    <td>${asse.assetName }</td>
    <td><c:forEach items="${dicSecuLeveList }" var="secuLeve">
                      <c:if test="${secuLeve.secuLeveId==asse.importance }">
                       <c:set var="secuLeveName" value="${secuLeve.secuLeveName }" />
                      </c:if>
                     </c:forEach>${secuLeveName }</td>
  </tr>
 </c:forEach>
</table>
</div>
</body>
</html>
