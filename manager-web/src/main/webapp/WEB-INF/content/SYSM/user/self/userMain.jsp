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
	//删除用户操作。
	var id;
	 function del(uid,bname){        
        id = uid;
		document.getElementById("userIds").value = uid;
		var sessionUname = document.getElementById("sessionUname").value;
		if (bname == sessionUname) {
			alert('不能删除自己');
			return;
		}
		if (confirm("确定删除此用户吗？")) {
			document.forms("mainForm").action="userConfig.do?method=deleteUser";
			document.forms("mainForm").submit();
		} else {
			return;
		}
    }

	var sids;
    function updateStatus(uid,sid){
        sids=sid;
        document.getElementById("userIds").value=uid; 
        document.getElementById("statuss").value=sid;
        document.forms("mainForm").action="userConfig.do?method=updateUserStatus";
        if(sids==0){
            if(confirm("确定需要禁用该用户吗?")){                                           
                document.forms("mainForm").submit();
            }else{                         
               return;
            }    
       }
       if(sids==1){
           if(confirm("确定需要启用该用户吗?")){                                           
               document.forms("mainForm").submit();
           }else{                         
              return;
           }    
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
      	<jsp:include page="/WEB-INF/content/SYSM/user/self/usertop.jsp"></jsp:include>
       </div>
    <div class="greenborder pad3 overf">
    <form action="userConfig.do?method=getBlurUser" method="post" name="mainForm" id="mainForm">
     <input type="hidden" id="curpage" name="curpage" value="${page.currentPage }"> 
    <input type="hidden" name="userId" id="userIds">
    <input type="hidden" name="statuss"	id="statuss"> 
    <input name="hidden" type="hidden" id="sessionUname" value="${userbo.username }">
    <input name="all" value="true" type="hidden"/>
      <div class="paddiv"></div>
      <h2>用户列表</h2>
      <div id="data" class="greenborder overf pad1 ">
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0,'int');">ID<span class="webdings">6</span></th>
                <th>用户名</th>
                <th>角色</th>
                <th>真实姓名</th>
                <th>状态</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
            <logic:notEmpty name="list">
            	<logic:iterate id="user" name="list">
            	<tr>
            		<td>${user.id }</td>
            		<td>${user.loginName }</td>
            		<td> 
            			<c:set var="size" value="0"></c:set>
            			<c:forEach	var="role" items="${rolemap[user.id]}" varStatus="s">
							<c:set var="size" value="1"></c:set>
							 <c:if test="${s.index==0}"> ${role.name} </c:if>
							 <c:if test="${s.index!=0}"> ,${role.name} </c:if>
						</c:forEach> 
						<c:if test="${size==0}">未分配角色</c:if>
					</td>
            		<td>${user.username }</td>
            		<td>
            			<c:if test="${user.enabled==true}">启用</c:if>
            			<c:if test="${user.enabled==false}">禁用</c:if>
            		</td>
            		<td><a class="R6" href="#" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/userConfig.do?method=getUserById&userId=${user.id}','用户详情','scrollbars=yes,width=600,height=500');">详情</a>
						<a class="R6" href="#" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/userConfig.do?method=getUserById&amp;userId=${user.id}&amp;update=1&amp;curpage=${page.currentPage}','修改用户','scrollbars=yes,width=600,height=500');">修改</a>
						<a class="R6" href="javascript:del('${user.id }','${user.username }')"> 删除</a>
						<c:if test="${user.enabled==false}">
							<a class="R6" href="javascript:updateStatus('${user.id }','1')">启用</a>
						</c:if>
						<c:if test="${user.enabled==true}">
							<a class="R6" href="javascript:updateStatus('${user.id }','0')">禁用</a>
						</c:if>
                        
                        <a class="R6 R7" href="#" onclick="MM_openBrWindow('${ctx}/ismp/domain/local/userConfig.do?method=getUserToManagerById&uid=${user.id}','指派部门','scrollbars=yes,width=600,height=500');">指派部门</a>
					</td>
            	</tr>
            	</logic:iterate>
            </logic:notEmpty>
            </tbody>
          </table>
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
      </form>
      <!-- <form action="userConfig.do" method="post">
		<input type="hidden" value="updateUserStatus" name="method">
		<input type="hidden" name="userId" id="userIds">
		 <input type="hidden" name="statuss" id="statuss" >
	 </form> -->
	
      
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
