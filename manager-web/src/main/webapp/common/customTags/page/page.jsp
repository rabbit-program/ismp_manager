<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<script type="text/javaScript">
    //function toPage(curpage) {
    //    document.getElementById("currPage").value = curpage;
    //    document.forms["respShow"].submit();
    //}
</script>
<ul id="page">
    <li><a class="first" href="javascript:toPage(1);"></a></li>
    <c:if test="${currPage>1 }">
        <li><a class="pre" href="javascript:toPage(${currPage-1 });"></a></li>
    </c:if>
    <c:if test="${currPage<totalPage }">
        <li><a class="next" href="javascript:toPage(${currPage+1 });"></a></li>
    </c:if>
    <li><a class="last" href="javascript:toPage(${totalPage });"></a></li>
    <li>
                             共 ${totalPage } 页 跳至
        <input id="currPage" name="currPage" type="text" size="2" class="input" value="${currPage }"/>
        &nbsp;
    </li>
    <li><a class="R6" href="javascript:toPage(document.getElementById('currPage').value);">GO</a></li>
</ul>