<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

 <div class="overf h20 martop10">
    <li id="m">
        <a <c:choose><c:when test="${womMenu=='ques'}">class='mbacka'</c:when><c:otherwise>class='mback'</c:otherwise></c:choose>  href="${ctx}/ismp/domain/local/oss/clientQuestion.do?method=showQuestion<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
          <span span class="menus10" >客户端问题管理</span>
        </a>
    </li>
    <li >
        <a <c:choose><c:when test="${womMenu=='work'}">class='mbacka'</c:when><c:otherwise>class='mback'</c:otherwise></c:choose>  href="${ctx}/ismp/domain/local/oss/workOrder.do?method=showWorkOrder<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>">
          <span class="menus11" >工单管理</span>
        </a>
    </li>
</div>