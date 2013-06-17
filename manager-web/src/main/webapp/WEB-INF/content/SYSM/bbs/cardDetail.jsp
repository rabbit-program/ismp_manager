<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table width="80%" border="1" cellpadding="0" cellspacing="1">
  <tr>
    <td valign="top" width="58" height="48"><span style="color: red;"><bean:write name="questions" property="sender.username"/></span></td>
    <td >
    <div style="width:100%;">
    <div class="title">&nbsp;&nbsp;<span style="color: blue;"><bean:write name="questions" property="q_title"/></span></div>
    <div style="white-space:normal; display:block; width:100%; word-break:break-all"> <p> &nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="questions" property="q_details"/> </p></div>
    <div style="text-align:right">  <bean:write name="questions" property="createTime" format="yyyy-MM-dd HH:mm:ss"/></div>
  </div>
</td>
  </tr>
  <tr>
    <td>姓名</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="102">&nbsp;</td>
    <td>
    <form id="form1" name="form1" method="post" action="">
    
        <div class="revert">
          <label for="context"></label>
          <textarea name="context" id="context" cols="56" rows="5"></textarea>
          
        </div>
        <div class="hf">
          <input type="submit" name="tj" id="tj" value="提交" />
        </div>
    </form></td>
  </tr>
</table>

 
</body>
</html>