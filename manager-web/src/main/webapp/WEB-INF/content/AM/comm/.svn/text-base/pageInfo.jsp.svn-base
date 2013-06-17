<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<link href="${pageContext.request.contextPath}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/SYSM/login.js" type="text/javascript" language="javascript"></script>
<input type="hidden" id="maxPagesize" value="${page.totalPage }">
<input type="hidden" id="curpageSize" value="${page.currentPage }">
<input type="text" class="input" size="3"  maxlength="7" value="${page.currentPage}" id="mid"
    name="mark"
    onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==46"
    onpaste="return !clipboardData.getData('text').match(/\D/)"
    ondragenter="return false" style="ime-mode: Disabled" />
<li><a class="R6" onclick="checkPagenumber('${typid }')" style="cursor: hand">GO</a></li>
