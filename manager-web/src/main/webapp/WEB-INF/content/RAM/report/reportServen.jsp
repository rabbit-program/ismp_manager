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
<script type="text/javascript">
</script>
<title>index</title>
</head>
<body>
<div id="data">
<table width="100%">
  <tr>
    <td width="700" align="center"><center><br/><img src="${graphURL }" width="700" height="350" border="0" usemap="#${filename }" /><br/><br/><img src="${graphURL1 }" width="700" height="350" border="0" usemap="#${filename1 }" /></center></td>
</table>
<h2 class="martop10"> ${asseInfoProj.domain.domainName }各资产的风险列表</h2>
<table width="100%">
  <tr>
    <th> 资产名称 </th>
    <th> 威胁</th>
    <th> 脆弱性 </th>
    <th> 风险等级 </th>
    <th> 改进措施 </th>
  </tr>
 <c:forEach items="${repoList }" var="repo" >
  <tr>
    <td> ${repo.asseName }</td>
    <td> ${repo.threName }</td>    
    <td> ${repo.vulnPoinName}</td>
    <td>
        <c:forEach items="${dicSecuLeveList }" var="secuLeve">
                      <c:if test="${secuLeve.secuLeveId==repo.riskValu }">
                       <c:set var="secuLeveName" value="${secuLeve.secuLeveName }" />
                      </c:if>
        </c:forEach>${secuLeveName }
    </td>
    <td> ${repo.sugg}</td>
    </tr>
 </c:forEach>
</table>
</div>
</body>
</html>
