<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="/css/assessmentCss.css" rel="stylesheet" type="text/css" />

</head>
<frameset rows="280,*" cols="*" framespacing="0"  frameborder="no" border="0" id="mframe">
  <frame src="${url}&id=${requestScope.id }"  name="top"  scrolling="no"   frameborder="0" marginheight="0" marginwidth="0" noresize="noresize"   />
  <frame src="chlog.do" name="down"  scrolling="auto"  frameborder="0" marginheight="0" marginwidth="0" />
</frameset>
<noframes>
</noframes>
</html>