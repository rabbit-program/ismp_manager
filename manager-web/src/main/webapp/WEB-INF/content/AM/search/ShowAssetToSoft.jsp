<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript">
                  function fwd(typid){                      
                      var curpage=document.getElementById("mid").value;
                      location.href="soft.do?method=getAssetToSoft&aid="+${assetId}+"&curpage="+curpage;
                  }
                  function fwdAdd(){                     
                      location.href="fwdPage.do?addSoft=1"
                  }
                  function del(id,tid){
                      if(confirm("确认删除吗？")){                        
                        location.href="soft.do?method=getAssetToSoft&aid="+id+"&tid="+tid;
                      }else{                         
                         return;
                      }
                  }
           </script>


</head>
<body>


<div id="data">
      <h2 class="martop8">软件列表</h2>
		<table >
			<tr>
				<th>名称</th>
				<th>描述</th>
				<th>版本</th>
				<th>厂商</th>
				<th>创建时间</th>
			</tr>
			<logic:notEmpty name="softlist">
				<logic:iterate id="s" name="softlist">
					<tr>
						<td>${s.name }</td>
						<td>${s.description }</td>
						<td>${s.version }</td>
						<td>${s.manufacturer}</td>
						<td><bean:write property="registrationTime" name="s"
							format="yyyy-MM-dd" /></td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>
			<logic:empty name="softlist">
				<tr>
					<td>没有相关记录!</td>
				</tr>
			</logic:empty>
		</table>
		
		 <ul id="page">
	        <li><a class="first" href="soft.do?method=getAssetToSoft&aid=${assetId}&curpage=1"></a></li>
	        <li>
		        <c:if test="${page.hasPrePage==true}">
					<a class="pre" href="soft.do?method=getAssetToSoft&aid=${assetId}&curpage=${page.currentPage-1 }"></a>
				</c:if>
			</li>
	        <li>
		        <c:if test="${page.hasNextPage==true}">
					<a class="next" href="soft.do?method=getAssetToSoft&aid=${assetId}&curpage=${page.currentPage+1 }"></a>
				</c:if>
			</li>
	        <li><a class="last"	href="soft.do?method=getAssetToSoft&aid=${assetId}&curpage=${page.totalPage }"></a></li>
	        <li>共${page.totalPage }页 跳至<jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
      	</ul>
</div>
</body>
</html>

<!-- <tr>
						<td colspan="5" align="right"><a
							href="soft.do?method=getAssetToSoft&aid=${assetId}&curpage=1">首页</a> 
						<c:if test="${page.hasPrePage==true}">
							<a
								href="soft.do?method=getAssetToSoft&aid=${assetId}&curpage=${page.currentPage-1 }">上一页</a>
						</c:if> <c:if test="${page.hasPrePage==false}">
                                                                                     上一页
                  </c:if> <c:if test="${page.hasNextPage==true}">
							<a
								href="soft.do?method=getAssetToSoft&aid=${assetId}&curpage=${page.currentPage+1 }">
							下一页</a>
						</c:if> <c:if test="${page.hasNextPage==false}">
                                                                           下一页
                  </c:if> <a
							href="soft.do?method=getAssetToSoft&aid=${assetId}&curpage=${page.totalPage }">末页</a> 共${page.totalCount
						}条记录,当前第${page.currentPage }页,共${page.totalPage }页,转到第
                        <!-- 分页TB -->