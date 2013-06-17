<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="/common/taglibs.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="/css/assessmentCss.css" rel="stylesheet" type="text/css" />

</head>

<frameset rows="*" cols="164,*" framespacing="0"  frameborder="no" border="0" id="mframe">
  <frame src="fwdPage.do?left=1" name="leftFrame" scrolling="yes" frameborder="0" marginheight="0" marginwidth="0" noresize="noresize" id="leftFrame" title="leftFrame" />
  <frame src="fwdPage.do?assetwelcome=1" scrolling="yes" name="childFrame" id="mainFrame" title="mainFrame" frameborder="0" marginheight="0" marginwidth="0" />
</frameset>
<noframes>
<body>不支持frameset框架</body>
</noframes>
</html>