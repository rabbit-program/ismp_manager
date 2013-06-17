<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<div id="banner" class="grayline overf bannerH" >
	<li <c:choose><c:when test="${respMenu=='pm'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose> id="m">
		<a href="#">
		  <span style="background:url(../../../../../img/comm/other/013.gif) no-repeat; padding-left:22px;">值班管理</span>
		</a>
	</li>
	<li <c:choose><c:when test="${respMenu=='klbm'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>>
		<a href="#">
		  <span style="background:url(../../../../../img/comm/other/379.gif) no-repeat; padding-left:22px;">运维知识库</span>
		</a>
	</li>
	<li <c:choose><c:when test="${respMenu=='smoa'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>>
		<a href="#">
		  <span style="background:url(../../../../../img/comm/other/062.gif) no-repeat; padding-left:22px;">安全管理操作审计</span>
		</a>
	</li>
	<li <c:choose><c:when test="${respMenu=='wom'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>>
		<a href="#">
		  <span style="background:url(../../../../../img/comm/other/027.gif) no-repeat; padding-left:22px;">运维工单</span>
		</a>
	</li>
</div>