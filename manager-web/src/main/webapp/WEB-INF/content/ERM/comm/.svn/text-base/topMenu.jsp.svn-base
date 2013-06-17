<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<div id="banner" class="grayline overf bannerH" >
    <li <c:choose><c:when test="${respMenu=='rm'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose> id="m"><a href="${ctx}/ismp/domain/local/erm/respShow.do<sec:authorize ifAllGranted='ROLE_AdminAll'>?isAll=1</sec:authorize>"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">预案管理</span></a></li>
    <li <c:choose><c:when test="${respMenu=='fp'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>><a href="${ctx}/ismp/domain/local/erm/respPrint.do?method=showselect<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">文件打印</span></a></li>
</div>