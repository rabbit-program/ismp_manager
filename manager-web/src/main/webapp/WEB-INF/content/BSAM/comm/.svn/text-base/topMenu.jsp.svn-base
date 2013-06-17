<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<div id="banner" class="grayline overf bannerH" >

   <li <c:choose><c:when test="${situationMenu=='location'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose> id="m">
        <a href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getSecurityAreaSituationList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
            <span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">物理园区态势</span>
        </a>
   </li>

   <li <c:choose><c:when test="${situationMenu=='config'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>>
        <a href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=getMachineList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
            <span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">态势参数设置</span>
        </a>
   </li>

   <li <c:choose><c:when test="${situationMenu=='topSituation'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>>
        <a href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getTopMachineSituationList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
            <span style="background:url(${ctx}/img/comm/other/156.gif) no-repeat; padding-left:22px;">主机态势排名</span>
        </a>
   </li>

   <li <c:choose><c:when test="${situationMenu=='topWeight'}">class='act'</c:when><c:otherwise>class='nor'</c:otherwise></c:choose>>
<!--        <a href="${ctx}/ismp/domain/local/bsam/situation_ranking_20_static.do">-->
        <a href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=getTopMachineListByWeight<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
            <span style="background:url(${ctx}/img/comm/other/157.gif) no-repeat; padding-left:22px;">主机重要性排名</span>
        </a>
   </li>

  </div>