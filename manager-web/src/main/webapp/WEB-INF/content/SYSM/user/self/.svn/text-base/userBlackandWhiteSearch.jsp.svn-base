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
    function FirstPage(curpage) {
        document.getElementById("curpage").value = curpage;
        document.forms[0].submit();
    }
    function upPage(curpage) {
        document.getElementById("curpage").value = curpage;
        document.forms[0].submit();
    }
    function nextPage(curpage) {
        document.getElementById("curpage").value = curpage;
        document.forms[0].submit();
    }
    function endPage(curpage) {
        document.getElementById("curpage").value = curpage;
        document.forms[0].submit();
    }
    function fwd(curpage){
        document.getElementById("curpage").value = document
                .getElementById("mid").value;
        document.forms[0].submit();
    }
    function searchBW(){
    	 document.forms[0].submit();
    }
    function del(uid){
		if(confirm("您确定要删除该用户！")){
			//location.href = "userConfig.do?method=deleteBlackandWhite&amp;bid="+uid;
			document.forms("bwsearchForm").action="userConfig.do?method=deleteBlackandWhite";
			document.getElementById("bid").value = uid;
			document.forms("bwsearchForm").submit();
		}else{
			return;
		}
    }
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
 <jsp:include page="/WEB-INF/content/SYSM/user/self/usertop.jsp"></jsp:include> </div>
    </div>
    <div class="greenborder pad3 overf">
    <h2 class="martop10">请选择查询条件</h2>
    <form action="userConfig.do?method=getPageListBlackAndWhite" name="bwsearchForm" id="bwsearchForm" method="post">
    <input type="hidden" id="curpage" name="curpage" value="${page.currentPage}"/>
    <input type="hidden" id="bid" name="bid" />
    <input type="hidden" id="blackandwhiteFwd" name="blackandwhiteFwd" value="1"/>
    <div class="greenborder greenback overf pad3 Height_a" >
      <span style="float:left;">类型
      <select name="blackandwhitebo.marker">
         <option value="2">全部</option>
         <c:if test="${blackandwhitebo.marker==0}">
         <option value="0" selected="selected">黑名单</option>
         </c:if>
         <c:if test="${blackandwhitebo.marker==1}">
          <option value="1" selected="selected">白名单</option>
         </c:if>
         <c:if test="${blackandwhitebo.marker!=0}">
           <option value="0">黑名单</option>
         </c:if>
         <c:if test="${blackandwhitebo.marker!=1}">
            <option value="1">白名单</option>
         </c:if>
       </select> 角色
       <select name="blackandwhitebo.role">
		<option value="-1">----全部----</option>
		<logic:notEmpty name="rolesSearchList">
		<logic:iterate id="rolelist" name="rolesSearchList">
		<option value="${rolelist.name }" <c:if test="${blackandwhitebo.role==rolelist.role}">selected="selected"</c:if>>${rolelist.name}</option>
		</logic:iterate>
		</logic:notEmpty> 
	 	</select>域
		<select name="blackandwhitebo.domain">
		<option value="-1">----全部----</option>
		<logic:notEmpty name="domainList">
		<logic:iterate id="domain" name="domainList">
		<option value="${domain.id }" <c:if test="${blackandwhitebo.domain==domain.id}">selected="selected"</c:if>>${domain.domainName}</option>
		</logic:iterate>
		</logic:notEmpty> 
	    </select> 描述
	  <input name="blackandwhitebo.depict" id="depict" type="text" value="${blackandwhitebo.depict}" size="8" class="input"/></span> 
	  <a href="#" class="R6" style="margin-left:12px;" onclick="searchBW();">搜索</a>
    </div>
    </form>
      <h2 class="martop10">用户列表</h2>
      <div id="data" class="greenborder overf pad1 " >
        <form name="f1" id="f1" action="" method="post">
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0,'int');">ID<span class="webdings">6</span></th>
                <th>类型</th>
                <th>IP地址</th>
                <th>角色</th>
                <th>域</th>
                <th>描述</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
            <logic:notEmpty name="list">
            	<logic:iterate id="blackandwhitebo" name="list">
            		<tr>
            			<td>${blackandwhitebo.id }</td>
            			<td>
            				<c:if test="${blackandwhitebo.marker==0}">黑名单</c:if>
            				<c:if test="${blackandwhitebo.marker==1}">白名单</c:if>
            			</td>
            			<td>${blackandwhitebo.ipaddress }</td>
            			<td>${blackandwhitebo.role }</td>
            			<td>
            			<logic:iterate id="domain" name="domainList">
            				<c:if test="${blackandwhitebo.domain == domain.id}">${domain.domainName}</c:if>
            			</logic:iterate>
            			</td>
            			<td>${blackandwhitebo.depict }</td>
            			<td>
            			<a class="R6" href="#"  onclick="MM_openBrWindow('${ctx}/ismp/domain/local/userConfig.do?method=getByIdBlackAndWhite&amp;blid=${blackandwhitebo.id}&amp;update=1&amp;curpage=${page.currentPage}','修改黑白名单','scrollbars=yes,width=600,height=500');" >修改</a>
            			<a class="R6" href="javascript:del(${blackandwhitebo.id });">删除</a>
            			<a href="&amp;curpage=${page.currentPage}&amp;marker=${blackandwhitebo.marker}&amp;role=${blackandwhitebo.role}&amp;domain=${blackandwhitebo.domain}&amp;depict=${blackandwhitebo.depict}&amp;blackandwhiteFwd=1"></a>
            			</td>
            		</tr>
            	</logic:iterate>
            </logic:notEmpty>
            </tbody>
          </table>
        </form>
      </div>
      <div class="paddiv">This is for verticl spacing</div>
      <ul id="page">
        <li><a class="first" href="javaScript:FirstPage('1')"></a></li>
        <li>
        <c:if test="${page.hasPrePage==true}">
			<a class="pre" href="javaScript:upPage('${page.currentPage-1}')"></a>
		</c:if>
		</li>
        <li>
        <c:if test="${page.hasNextPage==true}">
			<a class="next" href="javaScript:nextPage('${page.currentPage+1 }')"></a>
		</c:if>
		</li>
        <li><a class="last"	href="javaScript:endPage('${page.totalPage }')"></a></li>
        <li>共${page.totalPage }页 跳至
          <jsp:include page="/WEB-INF/content/SYSM/user/other/pageInfo.jsp"></jsp:include></li>
      </ul>
      <br />
      <br />
      <br />
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
