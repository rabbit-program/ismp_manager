<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" language="javascript" src="${ctx }/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript">
<!--
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
function onReset()
{
  
   var inputs =  $("posi").getInputs("text")
   for(var i=0; i < inputs.size(); i++)
        inputs[i].value = " ";
}
//-->
</script>
</head>

<body>



<div class="contant">
     <div class="overf h20 martop10">
     <ul>
      	<li id="m"><a  class="mback" href='device_.do' target='mainchiltFrame'><span class="menus10">设备查询</span></a></li>
      	<li><a  class="mback" href='soft_.do' target='mainchiltFrame'><span class="menus11"> 软件查询</span></a></li>
      	<li><a  class="mback" href='hard_.do' target='mainchiltFrame'><span class="menus12">硬件查询</span></a></li>
       	<li><a  class="mbacka" href='pos_.do' target='mainchiltFrame'><span class="menus07">物理位置查询</span></a></li>
       </ul>
    </div>
     <div class="greenborder pad3 overf">
   	 <h2 class="martop10">请选择查询条件</h2>
    	<div class="greenborder greenback overf pad3 " >
    					<form name="posi" id="pos"	action="search.do?method=searchPosition" method="post">
								<table >
									<tr>
										<td colspan="4">&nbsp;</td>
									</tr>
									<tr align="center">
										<td>地理位置描述：<input type="text" name="position.description"
											value="${position.description}" /></td>
									</tr>

									<tr>
										<td colspan="4">
										<div align="center">
											<input name="button3" type="submit"	class="submit" id="button3" value="查 询" /> 
											<input name="button4" type="button" class="submit" onclick="onReset()" value="重 置" />
										</div>
										</td>
									</tr>
								</table>
								</form>
		</div>
		
		  <h2 class="martop8">统计列表</h2>
          <div id="data"><table>
            <tr>
              <th>地理位置描述</th>
              <th>是否根节点</th>
              <th>操作</th>
            </tr>
              <tbody>
               <c:choose>
						<c:when test="${positionList != null}">
							<c:forEach items="${positionList}" var="pos">
								<tr>
									<td>${pos.description }</td>
									<td><c:if test="${pos.parentId == null}">是
                                        </c:if> <c:if
										test="${pos.parentId != null}">否 </c:if></td>
									<td>
									<c:choose>
									<c:when test="${pos.parentId != null}">
									<sec:authorize ifAllGranted='ROLE_AdminAll'>
										<a class="R6 R7" href="location.do?method=getByJoinAssetDevice&pid=${pos.id}&seachpos=1">取消关联</a>
										<a class="R6 R7" href="location.do?method=getNotJoinAssetDevice&pid=${pos.id }&seachpos=1">设备关联</a>
									</sec:authorize>
									</c:when>
									</c:choose>
									<sec:authorize ifAllGranted='ROLE_AdminAll'>
									<a class="R6" href="javascript:del(${pos.id })">删除</a>
									</sec:authorize>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						
			 	</c:choose>
			 	
						<logic:empty name="positionList">
							<tr>
								<td align="center" class="border  minheight" colspan="6"><span class="alert">没有数据显示</span></td>
							</tr>
						</logic:empty>
              </tbody>
            </table>
            <input type="hidden" id="curpage" value="${currentPage }"/>
		<ul id="page">
	        <li><a class="first" href="javaScript:fwpage('1')"></a></li>
	        <li>
	        <c:if test="${page.hasPrePage==true}">
				<a class="pre" href="javaScript:fwpage('${page.currentPage-1}')"></a>
			</c:if>
			</li>
	        <li>
	        <c:if test="${page.hasNextPage==true}">
				<a class="next" href="javaScript:fwpage('${page.currentPage+1 }')"></a>
			</c:if>
			</li>
	        <li><a class="last"	href="javaScript:fwpage('${page.totalPage }')"></a></li>
	        <li>共${page.totalPage }页 跳至
	          <jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
     	</ul>
	</div>
  </div>
</div>

<script type="text/javascript">
	function fwd(curPage) {
		var curpage = document.getElementById("mid").value;
		document.forms[0].action = "search.do?method=searchPosition&curpage="
				+ curpage;
		document.forms[0].submit();
	}
	function fwpage(curPage) {
		document.forms[0].action = "search.do?method=searchPosition&curpage="
				+ curPage;
		document.forms[0].submit();
	}
	function del(id) {
		if (window.confirm("你确定要删除吗?")) {
			var curpage = document.getElementById("curpage").value;
			document.forms[0].action = "search.do?method=deletePosition&id="
					+ id + "&curpage=" + curpage;
			document.forms[0].submit();
		}
	}
</script>

</body>
</html>
