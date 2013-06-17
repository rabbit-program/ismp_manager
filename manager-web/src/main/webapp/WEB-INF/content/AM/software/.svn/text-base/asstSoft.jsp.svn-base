<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript">
	function fwd(typid) {
		var curpage = document.getElementById("mid").value;
		// document.getElementById("curpage").value = document.getElementById("mid").value;
		var locid = document.getElementById("locid").value;
		var type_id = document.getElementById("typeid").value;
		location.href = "soft.do?method=findSoftPagin&sid=" + type_id
				+ "&curpage=" + curpage + "&locid=" + locid;
	}
	function fwdAdd(locid) {
		location.href = "fwdPage.do?addSoft=1&locid=" + locid;
	}
	function del(id, tid, locid) {
		if (confirm("确认删除吗？")) {
			location.href = "soft.do?method=deleteSoft&softid=" + id + "&tid="
					+ tid + "&locid=" + locid;
		} else {
			return;
		}
	}
</script>
</head>
<body>
<input type="hidden" id="locid" value="${locid }" name="locid" />
<input type="hidden" id="typeid" value="${sessionScope.SoftType }" name="typeid">
<div id="contant">
</div>
    <div id="data">
      <h2 class="martop8">软件列表</h2>
	<table>
		<tr>
			<th>名称</th>
			<th>厂商</th>
			<th>版本</th>
			<th>登记时间</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<logic:present name="softlist">
			<logic:iterate id="s" name="softlist">
				<tr>
					<td>${s.name }</td>
					<td>${s.manufacturer}</td>
					<td>${s.version }</td>
					<td><bean:write property="registrationTime" name="s"
						format="yyyy-MM-dd" /></td>
					<td>${s.description}</td>
					<td><a href="soft.do?method=getOneSoft&sid=${s.id }" class="R6 R7">详细信息</a>
						<!-- <a href="#" class="R6 R7" onclick="Boxy.load('soft.do?method=getOneSoft&sid=${s.id }');" >详细信息</a> -->
						<sec:authorize ifAllGranted='ROLE_AdminAll'>
							<a class="R6 R7" href="soft.do?method=getOneSoft&sid=${s.id }&relating=1" >设备关联</a>
							<a class="R6 R7" href="soft.do?method=getOneSoft&sid=${s.id }&cancel=1">取消关联</a>
							<!-- <a class="R6" href="#" onclick="Boxy.load('soft.do?method=getOneSoft&sid=${s.id }&up=1&locid=${locid}');">修改</a> -->
							<a class="R6" href="soft.do?method=getOneSoft&sid=${s.id }&up=1&locid=${locid}">修改</a>
							<a class="R6" href="javaScript:del('${s.id }','${s.softwareType}','${locid }')">删除</a>
						</sec:authorize>
						</td>
				</tr>
			</logic:iterate>
		</logic:present>
		<logic:empty name="softlist">
			<tr>
				<td align="center" class="border  minheight" colspan="6"><span class="alert">没有数据显示</span></td>
			</tr>
		</logic:empty>
	</table>
	</div>
	
<div id="page" >
<ul>
	<li><a
		href="soft.do?method=findSoftPagin&sid=${softid}&curpage=1&locid=${locid}"
		class="first"></a></li>
	<li><c:if test="${page.hasPrePage==true}">
		<a
			href="soft.do?method=findSoftPagin&sid=${softid}&curpage=${page.currentPage-1 }&locid=${locid}"
			class="pre"> </a>
	</c:if> </li>
	<li><c:if test="${page.hasNextPage==true}">
		<a
			href="soft.do?method=findSoftPagin&sid=${softid}&curpage=${page.currentPage+1 }&locid=${locid}"
			class="next"></a>
	</c:if></li>
	<li><a
		href="soft.do?method=findSoftPagin&sid=${softid}&curpage=${page.totalPage }&locid=${locid}"
		class="last"></a></li>
	<li>当前${page.currentPage }页,共${page.totalPage } 页 跳至 </li>
	<li><jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
	<sec:authorize ifAllGranted='ROLE_AdminAll'>
	<li>
	<a href="${ctx}/ismp/domain/local/am/fwdPage.do?addSoft=1&locid=${locid }" class="R6 R7 boxy" title="添加软件">添加软件</a>
	<!-- <a href="#" onclick="Boxy.load('${ctx}/ismp/domain/local/am/fwdPage.do?addSoft=1&locid=${locid }');" class="R6 R7 boxy" title="添加软件">添加软件</a> -->
	</li>
	</sec:authorize>
</ul>
</div>
</div>
</div>
</body>
</html>
