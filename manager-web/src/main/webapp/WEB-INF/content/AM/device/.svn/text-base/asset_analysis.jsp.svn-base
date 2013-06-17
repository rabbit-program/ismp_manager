<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset"%> 
<%@ page import="org.jfree.chart.*"%> 
<%@ page import="org.jfree.chart.plot.*"%> 
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%> 
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%> 
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%> 
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%> 
<%@ page import="java.io.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" src="js/prototype-1.6.0.3.js"
	language="javascript"></script>

<script type="text/javascript">
	function fwd(curpage){
	    document.getElementById("curpage").value = document
	            .getElementById("mid").value;
	    document.forms[0].submit();
	}
	function gopage(curPage) {
		var locid = document.getElementById("locid").value;
		document.forms['sub1'].target = "childFrame";
		var path="assetAvailability.do?method=assetAnalysis&locid="
            + locid ;
        document.getElementById("curPage").value=curPage;
		document.forms['sub1'].action = path;
		
		document.forms['sub1'].submit();
	}
</script>
<style type="text/css">
<!--.STYLE1 {color: #FF0000}-->
</style>
</head>
<body>
	<div class="greenborder pad3 overf">
			<table width="100%" border="0" align="center" cellpadding="0"	cellspacing="0" class="css1">
					<tr align="center">
						<td colspan="4">
						
						 <applet codebase="."
							code="org.infosec.ismp.applet.manager.AM.AssetDeviceChart.class"
							archive="${ctx }/applet/asset/ismp-topo-applet-2.0-SNAPSHOT.jar,${ctx}/applet/asset/twaver-2.3.jar"
							name="Alert Picture Applet" width="100%" height="300"
							hspace="0" vspace="0" align="left">
							<param name="serverPath" value="${serverPath }" />
							<param name="locId" value="${locId }" />
							<param name="network" value="${network }" />
							<param name="security" value="${security }" />
							<param name="server" value="${server }" />
							<param name="terminal" value="${terminal }" />
							<param name="location" value="${location}" />
						</applet> 
						</td>
					</tr>
			</table>		
	</div>		

	<div id="data">
			<h2 class="martop10">统计列表 <a href="DeviceCountInBureauGroupByType.do?outPutFileType=1&bureauId=${locId}">导出(${location})数据</a></h2>
			<table id="senfe" sortcol="-1">
				<thead>
					<tr>
						<th >名称</th>
						<th >厂商</th>
						<th >型号</th>
						<th >登记时间</th>
						<th >有效期</th>
						<th >物理位置</th>
						<th >性能利用率</th>
						<th >存储利用率</th>
						<th >网络利用率</th>
					</tr>
				</thead>
				<tbody>
					<logic:present name="deviceVOList">
						<logic:iterate id="dev" name="deviceVOList">
							<tr>
								<td>${dev.name }</td>
								<td>${dev.manufacturer }</td>
								<td>${dev.model }</td>
								<td><bean:write property="registrationTime" name="dev"	format="yyyy-MM-dd" /></td>
								<td>${dev.validityPeriod }个月</td>
								<td>${dev.location }</td>
								<td>${dev.capability }</td>
								<td>${dev.availHardware }</td>
								<td>${dev.availNetwork }</td>
							</tr>
						</logic:iterate>
					</logic:present>
				</tbody>
			</table>
			
			<ul id="page">
		        <li><a class="first" href="javaScript:gopage('1')"></a></li>
		        <li>
		        <c:if test="${page.hasPrePage==true}">
					<a class="pre" href="javaScript:gopage('${page.currentPage-1}')"></a>
				</c:if>
				</li>
		        <li>
		        <c:if test="${page.hasNextPage==true}">
					<a class="next" href="javaScript:gopage('${page.currentPage+1 }')"></a>
				</c:if>
				</li>
		        <li><a class="last"	href="javaScript:gopage('${page.totalPage }')"></a></li>
		        <li>共${page.totalPage }页 跳至
		          <jsp:include page="/WEB-INF/content/AM/comm/pageInfo.jsp"></jsp:include></li>
     		</ul>
	</div>
									

<form id="sub1" name="sub1">
			<input type="hidden" name="method"	value="assetAnalysis" /> 
			<input type="hidden" id="locid" name="locid" value="${locId}" />
		    <input type="hidden" id="curPage" name="curpage" />
</form>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</body>
</html>
