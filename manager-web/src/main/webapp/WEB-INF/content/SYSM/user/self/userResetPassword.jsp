<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript">
function MM_openBrWindow(theURL,winName,features) {
	window.open(encodeURI(theURL),winName,features);
}
</script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
  <jsp:include page="/WEB-INF/content/SYSM/user/top.jsp"></jsp:include>
  </div>
  <div class="contant">    
    <div class="overf h20 martop10">
  <jsp:include page="/WEB-INF/content/SYSM/user/self/usertop.jsp"></jsp:include>   </div>
    </div>
    <div class="greenborder pad3 overf">
    <h2 class="martop10">密码管理</h2>
    <div class="greenborder greenback overf pad3 Height_a" >
      <a href="#" class="R6 R7" style="margin-left:12px;" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/resetPassWord.do','密码重置','scrollbars=yes,width=600,height=500');">密码重置</a> 
      <a href="#" class="R6 R7" style="margin-left:12px;" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/updatePassWord.do','修改密码','scrollbars=yes,width=600,height=500');">修改密码</a>
    </div></div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
