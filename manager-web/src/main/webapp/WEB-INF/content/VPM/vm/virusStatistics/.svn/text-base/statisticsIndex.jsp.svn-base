<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <%@ include file="/common/meta.jsp" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>病毒管理_病毒统计</title>
	</head>
	<body>
	   病毒统计
     <select id="sqt" name="sqt" onchange="javascript:window.location.href='${ctx}/ismp/domain/local/vpm/vm/virusStatistics.do?qt='+this.value;">
        <option value="d" <c:if test="${qt=='d' }">selected="selected"</c:if>>日统计</option>
        <option value="m" <c:if test="${qt=='m' }">selected="selected"</c:if>>月统计</option>
        <option value="y" <c:if test="${qt=='y' }">selected="selected"</c:if>>年统计</option>
     </select>
     <c:choose>
        <c:when test="${qt=='m' }">
                        月统计
        </c:when>
        <c:when test="${qt=='y' }">
                        年统计
        </c:when>
        <c:otherwise>
                        日统计
        </c:otherwise>
     </c:choose>
	</body>
</html>