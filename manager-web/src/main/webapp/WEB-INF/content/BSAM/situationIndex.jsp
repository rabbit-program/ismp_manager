<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<!-- 
<script type='text/javascript' src='${basePath}/dwr-situation/engine.js'></script>
<script type='text/javascript' src='${basePath}/dwr-situation/util.js'></script>
<script type='text/javascript' src='${basePath}/dwr-situation/interface/JavaChat.js'></script>
 -->
<script type='text/javascript'>
	function sendMessage(){
		///JavaChat.addMessage(dwr.util.getValue("text"));
	}
	function autoShow(){
		////JavaChat.circleMessage();
	}
</script>
</head>
<body>
    <jsp:forward page="situationHome.jsp"></jsp:forward>
</body>
</html>
