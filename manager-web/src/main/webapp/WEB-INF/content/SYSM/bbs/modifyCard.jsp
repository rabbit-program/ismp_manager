<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form id="form1" name="form1" method="post" action="${ctx}/ismp/sysm/other/bbs.do?method=addAnswers">
  <table width="415" height="134" border="1">
    <tr>
      <td width="93">标题</td>
      <td width="306"><label for="title"></label>
      <input type="text" name="title" id="title" /></td>
    </tr>
    <tr>
      <td>内容</td>
      <td><label for="textarea"></label>
      <textarea name="contextDetails"  id="contextDetails"  cols="45" rows="5"></textarea></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="tj" id="tj" value="提交" /> 
      <input type="reset" name="button" id="button" value="重置" /></td>
    </tr>
  </table>
</form>


</body>
</html>