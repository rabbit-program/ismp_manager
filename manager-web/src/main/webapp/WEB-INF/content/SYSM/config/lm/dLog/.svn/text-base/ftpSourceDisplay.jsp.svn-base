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
<form action="" method="post">
-...................待完成....................-<br/>
	名称：<input name="dName" type="text"/><br/>
	设备IP：<input name="dIP" type="text"/><br/>
	名称：<input name="dName" type="text"/><br/>
	名称：<input name="dName" type="text"/><br/>
	名称：<input name="dName" type="text"/><br/>
</form>

<br/>
Ftp日志源
................................................................
&nbsp;
<br/><br/>
<table border="1">
<c:forEach items="${ftpSourceList}" var="logSource">
	<tr>
		<td>${logSource.sourceName }</td>
		<td>${logSource.createTime }</td>
		<td>${logSource.ftpCollectSourceIp }</td>
		<td>${logSource.ftpCollectSourcePort }</td>
		<td>${logSource.ftpCollectSourceName }</td>
		<td>${logSource.ftpCollectSourcePassword }</td>
		<td>${logSource.ftpCollectSourcePath }</td>
		<td>${logSource.ftpCollectSourceFileName }</td>
		<td>${logSource.domain.domainName }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>