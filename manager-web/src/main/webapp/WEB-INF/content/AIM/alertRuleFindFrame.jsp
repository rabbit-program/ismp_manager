<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/common/taglibs.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
</head>
<frameset rows="100%,*" cols="*"marginheight="0"  id="alertDrFrame" name="alertDrFrame" marginwidth="0" scrolling="no"  marginheight="0" marginwidth="0" border="0">
  <frame src="${ctx}/ismp/domain/local/aim/alertRule.do?method=getPageAlertRule&disuse=1" name="topFrame" marginheight="0" scrolling="auto" marginwidth="0"  marginheight="0" marginwidth="0" scrolling="no" noresize="noresize" id="topFrame" />
  <frame src="${ctx}/ismp/domain/local/aim/alertRule.do?method=getPageAlertRuleDisuse&disuse=0" name="alertDisuseRuleFrame" id="alertRuleFrame" marginheight="0" scrolling="auto" marginwidth="0"  marginheight="0" marginwidth="0" />
</frameset>
<noframes>
</noframes></html>
