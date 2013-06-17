<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title></title>
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
  function fwd(typid){                      
      var curpage=document.getElementById("mid").value;
      document.getElementById("crupag").value=curpage;      
      document.forms[0].action="location.do?curpage="+curpage;
      document.forms[0].submit();
  }

  function topage(curpage){
      document.getElementById("crupag").value=curpage;      
      document.forms[0].action="location.do?curpage="+curpage;
      document.forms[0].submit();
	}
  
  function fwdAdd(){                     
      location.href="fwdPage.do?addAsset=1"
  }
  function del(did){      
      var pid=document.getElementById("pd").value;
      if(confirm("确认删除吗？")){                        
        location.href="location.do?method=delDevice&did="+did+"&pid="+pid;
      }else{                         
         return;
      }
  }

  
  function forward(pid){
     location.href="location.do?method=getNotJoinAssetDevice&pid="+pid
  }
  function cleanForward(pid){
     location.href="location.do?method=getByJoinAssetDevice&pid="+pid;
  }
</script>

</head>
<body>
<form action="location.do" target="childFrameLoaction"><input
	type="hidden" name="pid" value="${publicPid}" id="pd"> <input
	type="hidden" name="curpage" id="crupag"> <input type="hidden"
	name="method" value="findlocationDevicePagin"> <input
	type="hidden" name="seachpos" value="${seachpos }">
<form>
  
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
           <tr>
                <td width="682"><h2 class="martop8">资产列表</h2></td>
                <td ><!-- 如果有权限的情况下才给修改按钮 --> 
                <sec:authorize ifAllGranted='ROLE_AdminAll'>
                 <a href="#" class="R6 R7" onclick="forward('${publicPid}')">添加位置关联</a>
                 <a href="#" class="R6 R7" onclick="cleanForward('${publicPid }')">取消位置关联</a>
                </sec:authorize>
</td>

            </tr>
      </table>
      
      <div id="data">
      <table >
                    <tr>
                        <th>名称</th>
                        <th>描述</th>
                        <th>操作</th>
                    </tr>
                   <logic:notEmpty name="devicelist">
                        <logic:iterate id="dl" name="devicelist">
                            <tr>
                                <td>
                                <div align="center">${dl.name }</div>
                                </td>
                                <td>
                                <div align="center">${dl.description }</div>
                                </td>
                                <td>
                                <div align="center">
                                	<a href="location.do?method=getOneDevice&deviceId=${dl.id }&part=1" class="R6 R7">详细信息</a> 
                                	<!-- <a href="#" class="R6 R7" onclick="Boxy.load('location.do?method=getOneDevice&deviceId=${dl.id }&part=1');">详细信息</a> -->
                                	<sec:authorize ifAllGranted='ROLE_AdminAll'>
                                    <a href="javaScript:del('${dl.id }')" class="R6">删除</a>
                                    </sec:authorize>
                                   </div>
                                </td>
                            </tr>
                        </logic:iterate>
                    </logic:notEmpty>
                    <logic:empty name="devicelist">
                    	<tr>
                    		<td colspan="3">
                    			<div style="color: red;" align="center">没有记录</div>
                    		</td>
                    	</tr>
                    </logic:empty>
         </table>
         
          <ul id="page">
	        <li><a class="first" href="javaScript:topage('1')"></a></li>
	        <li>
	        <c:if test="${page.hasPrePage==true}">
				<a class="pre" href="javaScript:topage('${page.currentPage-1}')"></a>
			</c:if>
			</li>
	        <li>
	        <c:if test="${page.hasNextPage==true}">
				<a class="next" href="javaScript:topage('${page.currentPage+1 }')"></a>
			</c:if>
			</li>
	        <li><a class="last"	href="javaScript:topage('${page.totalPage }')"></a></li>
	        <li>共${page.totalPage }页 跳至
	          <jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
      	  </ul>
	</div>
</body>
</html>