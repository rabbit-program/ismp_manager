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
	function search(){
		document.forms[0].submit();
	}
	function del(id){
		if(confirm("您确定要删除该部门！")){
			location.href = "${ctx}/ismp/domain/local/userConfig.do?method=delDomainById&amp;mid="+id+"&amp;curpage="+${page.currentPage };
		}else{
			return;
		}
	}
</script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">用户管理</span></a></li>
    <li class="nor"><a href="#"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">其他管理</span></a></li>
  </div>
  <div class="contant">    
    <div class="overf h20 martop10">
  	<li id="m"><a  class="mback" href="${ctx}/ismp/domain/local/userConfig.do?method=getBlurUser&all=true"><span class="menus01">用户浏览</span></a></li>
      <li><a  class="mback" href="${ctx}/ismp/domain/local/userConfig.do?method=getRoleAll"><span class="menus02">用户条件查询</span></a></li>
      <li><a  class="mback" href="${ctx}/ismp/domain/local/userConfig.do?method=forward&blackandwhiteFwd=1"><span class="menus03">黑白名单查询</span></a></li>
      <li><a  class="mback" href="${ctx}/ismp/domain/local/userConfig.do?method=forward&add=1"><span class="menus04">新增用户</span></a></li>
      <li><a  class="mback" href="${ctx}/ismp/domain/local/userConfig.do?method=forward&addBlackAndWhite=1"><span class="menus05">新增黑白名单</span></a></li>
      <li><a  class="mback" href="${ctx}/ismp/domain/local/userConfig.do?method=getBlackandWhiteStatus"><span class="menus06">黑白名单状态管理</span></a></li>
      <li><a  class="mbacka" href="${ctx}/ismp/domain/local/userConfig.do?method=getUserToManagerByList"><span class="menus07">部门管理</span></a></li>
      <li><a  class="mback" href="${ctx}/ismp/domain/local/userResetPassword.do"><span class="menus08">密码重置</span></a></li>    </div>
    </div>
    <div class="greenborder pad3 overf">
    <form action="userConfig.do" name="searchForm" id="searchForm" method="post">
    <h2 class="martop10">请输入查询条件</h2>
    <input type="hidden" name="method" value="getUserToManagerByList"/>
    <input type="hidden" name="curpage" id="curpage" value="${page.currentPage}"/>
    <div class="greenborder greenback overf pad3 Height_a" >
      <span style="float:left;">部门名称<input type="text" name="domainname" id="domainname" size="8" class="input" value="${domainname }" /></span> <a href="javascript:search();" class="R6" style="margin-left:12px;">搜索</a> 
      <!-- <a href="#" class="R6" style="margin-left:12px;" onclick="Boxy.load('${ctx}/ismp/domain/local/userConfig.do?method=forward&amp;addManager=1');">新增</a> -->
       
    </div>
    </form>
      <h2 class="martop10">部门列表</h2>
      <div id="data" class="greenborder overf pad1 " >
        <form name="f1" id="f1" action="" method="post">
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0,'int');">ID<span class="webdings">6</span></th>
                <th>部门名称</th>
                <th>描述</th>
				<!-- <th>操作</th> -->
              </tr>
            </thead>
            <tbody>
              
              <logic:notEmpty name="list">
              	<logic:iterate id="domain" name="list" indexId="index">
              		<tr>
              		<td> ${domain.id } </td>
	                <td> ${domain.domainName }</td>
	                <td> ${domain.description }</td>
	                <td>
	                <!-- <a href="#" class="R6" onclick="Boxy.load('${ctx}/ismp/domain/local/userConfig.do?method=forward&amp;updateManager=1&amp;mid=${domain.id}&amp;curpage=${page.currentPage}');">编辑</a>
	                <a href="#" class="R6" onclick="del(${domain.id});">删除</a> -->
	                <!-- <a href="javascript:del('userConfig.do?method=delDomainById&did=${domain.id}')" class="R6" >删除</a> -->
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
