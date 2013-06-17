<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>session过期！</title>
    </head>
    <body>
        <%
            response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
            String newLocn = request.getContextPath();
            response.setHeader("Location",newLocn);
        %>
    </body>
</html>