<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script language=Javascript> 
function checkAll(e, itemName) 
{ 
  var aa = document.getElementsByName(itemName); 
  for (var i=0; i<aa.length; i++) 
   aa[i].checked = e.checked; 
} 
function checkItem(e, allName) 
{ 
  var all = document.getElementsByName(allName)[0]; 
  if(!e.checked) all.checked = false; 
  else 
  { 
    var aa = document.getElementsByName(e.name); 
    for (var i=0; i<aa.length; i++) 
     if(!aa[i].checked) return; 
    all.checked = true; 
  } 
} 

function del(id){
       var a = document.getElementsByName("checkboxLog");
       var n = a.length;
       var k = 0;
       for (var i=0; i<n; i++){
            if(a[i].checked){
                k = 1;
            }
        }
        if(k==0){
            alert("请选中需要删除项!");
            return;
        }       
    if(confirm("确认删除所选项吗？")){                        
       document.forms[0].submit();
    }else{                         
       return;
    }
} 
</script>
<style type="text/css">
<!--
body {
    margin-left: auto;
    margin-top: auto;
    margin-right: auto;
    margin-bottom: auto;
}
-->
</style>
<link href="css/assessmentCss.css" rel="stylesheet" type="text/css" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<html:form action="/ismp/domain/local/am/changelog.do?method=delChangeLog&id=${id}">


<h2 class="martop8">资产更变列表</h2>
<sec:authorize ifAllGranted='ROLE_AdminAll'>
<input class="submit" type="button" value="选择删除" onclick="javaScript:del('${id}')" />
</sec:authorize>
          <div id="data">
          <logic:present name="changelogList">
	          <table>
	            <tr>
	              <th>全选 <input type=checkbox name=mmAll onclick="checkAll(this, 'checkboxLog')" /></th>
	              <th>更改前状态</th>
	              <th>更改后状态</th>
	              <th>创建时间</th>
	            </tr>
	              <tbody>
	                <logic:iterate id="ch" name="changelogList">
	                     <tr>
	                         <td>
	                         <div align="center"><input type="checkbox"
	                             name="checkboxLog" value="${ch.id}" /></div>
	                         </td>
	                         <td>${ch.statusBefore }</td>
	                         <td>${ch.statusAfter }</td>
	                         <td><bean:write name="ch" property="createTime" format="yyyy-MM-dd HH:mm:ss"/></td>
	                     </tr>
	                 </logic:iterate>
	              </tbody>
	            </table>
            </logic:present>
	            <ul id="page">
			        <li>
			        	<a class="first" href="changelog.do?method=searchAll&id=${requestScope.id }&curpage=1"></a>
			        </li>
			        <li>
				        <c:if test="${page.hasPrePage==true}">
							<a class="pre" href="changelog.do?method=searchAll&id=${requestScope.id }&curpage=${page.currentPage-1 }"></a>
						</c:if>
					</li>
			        <li>
				        <c:if test="${page.hasNextPage==true}">
							<a class="next" href="changelog.do?method=searchAll&id=${requestScope.id }&curpage=${page.currentPage+1 }"></a>
						</c:if>
					</li>
			        <li>
			        	<a class="last"	href="changelog.do?method=searchAll&id=${requestScope.id }&curpage=${page.totalPage }"></a>
			        </li>
			        <li>共${page.totalPage }页 跳至<jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
	      		</ul>
            </div>
</html:form>
<script type="text/javascript">
    function fwd(curpage) {
        //var curpage = document.getElementById("pageid").value;
        //var deid = document.getElementById("deid").value;
        var curp = document.getElementById("mid").value;
        location.href = "changelog.do?method=searchAll&id="+${requestScope.id }+"&curpage=" + curp;
    }
</script>
</body>
</html>
