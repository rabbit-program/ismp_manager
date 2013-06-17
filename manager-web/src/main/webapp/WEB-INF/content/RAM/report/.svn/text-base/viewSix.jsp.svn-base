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
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
</head>
<body>
<c:if test="${dynaThre!=null}">
<div  id="data" class="pad1 ">
<table>
  <tr>
    <th> 威胁名称 </th>
    <td>${statThre.threat}</td>
  </tr>
  <tr>
    <th> 威胁描述 </th>
    <td>${statThre.memo }</td>
  </tr>
  <tr>
    <th> 威胁可能性 </th>
    <td><c:forEach items="${dicSecuLeveList }" var="secuLeve">
                      <c:if test="${secuLeve.secuLeveId==dynaThre.possibility }">
                       <c:set var="secuLeveName" value="${secuLeve.secuLeveName }" />
                      </c:if>
                     </c:forEach>${secuLeveName }</td>
  </tr>
  </table>

</div>
</c:if>

<c:if test="${dynaLeakThre!=null}">
<div  id="data" class="pad1 ">
<table>
  <tr>
    <th> 威胁名称 </th>
    <td>${statCVEThre.threat}</td>
  </tr>
  <tr>
    <th> 威胁描述 </th>
    <td>${statCVEThre.memo }</td>
  </tr>
  <tr>
    <th> 威胁可能性 </th>
    <td><c:forEach items="${dicSecuLeveList }" var="secuLeve">
                      <c:if test="${secuLeve.secuLeveId==dynaLeakThre.possibility }">
                       <c:set var="secuLeveName" value="${secuLeve.secuLeveName }" />
                      </c:if>
                     </c:forEach>${secuLeveName }</td>
  </tr>
  </table>

</div>
</c:if>
</body>
</html>