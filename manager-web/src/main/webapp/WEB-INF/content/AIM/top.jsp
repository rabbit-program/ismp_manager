<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<ul>
    <li <c:choose><c:when test="${topcss=='alertIndex'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>   id="m"><a href="${ctx }/ismp/domain/local/aim/alert.do?method=getListPageAlertAction&amp;home=1&amp;first=true"><span style="background:url(${ctx}/img/SYSM/page-edit-icon.png) no-repeat; padding-left:22px;">告警浏览</span></a></li> 
    <li <c:choose><c:when test="${topcss=='alertFind'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>   id="m"><a href="${ctx }/ismp/domain/local/aim/alertRule.do?method=alertFind"><span style="background:url(${ctx}/img/SYSM/page-search-icon.png) no-repeat; padding-left:22px;">告警查询</span></a></li> 
    <li <c:choose><c:when test="${topcss=='alertFindFrame'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>   id="m"><a href="${ctx }/ismp/domain/local/aim/alertRule.do?method=alertFindFrame"><span style="background:url(${ctx}/img/SYSM/usersearch.png) no-repeat; padding-left:22px;">告警规则</span></a></li> 
    <li <c:choose><c:when test="${topcss=='userconfig'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>   id="m"><a href="#" onclick="openAlert();"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">告警监控</span></a></li>   
</ul>