<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.TreeMap"%>
<%@ page import="edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogInitQueryBean"%>
<%@ page import="edu.sjtu.infosec.ismp.manager.LM.dLog.web.form.SysLogResponseQueryBean"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.util.Iterator"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Information System Management Platform</title>
</head>
<body>
Ftp展示 <br/>
<table border="1">
<c:forEach items="${ftpList}" var="log">
	<tr>
		<td>${log.eventTime }</td>
		<td>${log.createTime }</td>
		<td>${log.csIp }</td>
		<td>${log.csMethod }</td>
		<td>${log.csUriStem }</td>
		<td>${log.scStatus }</td>
		<td>${log.ftpCollectSourceIp }</td>
		<td>${log.domain.domainName }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>