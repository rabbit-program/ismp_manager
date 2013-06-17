<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/common/taglibs.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资产可用性统计</title> 
<style type="text/css">
#nav {
	-moz-border-radius: 8px;
	background: #d1d1d1;
	height: 46px;
	padding: 14px 0 0 24px;
	font-size: 12px;
}

a,a:visited,a:hover,a:active {
	text-decoration: none;
	outline: none;
}

#nav ul {
	
}

#nav li {
	list-style: none;
	float: left;
	display: block;
	margin: 0 32px 0 0;
}

#nav .list {
	margin-left: -5px;
	padding: 4px 4px 0px 4px;
}

#nav a.list,#nav a:visited .list {
	-moz-border-radius: 4px;
	display: block;
	color: black;
	border: 1px solid #d1d1d1;
}

#nav a:hover .list,#nav a:active .list,#nav a:focus .list {
	-moz-border-radius: 4px;
	height: 20px;
	color: #5ca613;
	background: url(images/btn_button_a.gif) repeat-x;
	background-position: left center;
	border: 1px solid #c2c2c2;
}

.btn {
	padding: 2px;
	border: 1px solid #d1d1d1;
	background-position: left center;
}

a.btn,a:visited .btn {
	margin-top: -3px;
	-moz-border-radius: 4px;
	display: block;
	background: url(images/btn_button_n.gif) repeat-x;
	text-shadow: 0 1px 1px rgba(255, 255, 255, 1);
	font-weight: normal;
}

a:hover .btn,a:active .btn {
	-moz-border-radius: 4px;
	background: url(images/btn_button_a.gif) repeat-x;
	font-weight: normal;
}

.border {
	margin-top: 12px;
	padding: 6px;
	border: 1px solid #d1d1d1;
}
</style>

<script type="text/javascript">
     function show(model)
     {
    	 var cpu = document.getElementById("cpu"); 
         var hard = document.getElementById("hard"); 
         var mem = document.getElementById("mem"); 
         var net = document.getElementById("net"); 
         var qu = document.getElementById("qu"); 
         var on = document.getElementById("on"); 
         if(model == "cpu")
         { 
        	 cpu.style.display = "inline";
        	 hard.style.display = "none";
        	 mem.style.display = "none";
        	 net.style.display = "none";
        	 qu.style.display = "none";
        	 on.style.display = "none";
         }
         if(model == "hard")
         { 
        	 cpu.style.display = "none";
        	 hard.style.display = "inline";
        	 mem.style.display = "none";
        	 net.style.display = "none";
        	 qu.style.display = "none";
        	 on.style.display = "none";
         }
         if(model == "mem")
         { 
        	 cpu.style.display = "none";
        	 hard.style.display = "none";
        	 mem.style.display = "inline";
        	 net.style.display = "none";
        	 qu.style.display = "none";
        	 on.style.display = "none";
         }
         if(model == "net")
         { 
        	 cpu.style.display = "none";
        	 hard.style.display = "none";
        	 mem.style.display = "none";
        	 net.style.display = "inline";
        	 qu.style.display = "none";
        	 on.style.display = "none";
         } 
         if(model == "qu")
         { 
        	 cpu.style.display = "none";
        	 hard.style.display = "none";
        	 mem.style.display = "none";
        	 net.style.display = "none";
        	 qu.style.display = "inline";
        	 on.style.display = "none";
         } 
         if(model == "on")
         { 
        	 cpu.style.display = "none";
        	 hard.style.display = "none";
        	 mem.style.display = "none";
        	 net.style.display = "none";
        	 qu.style.display = "none";
        	 on.style.display = "inline";
         } 
    	
     }
</script>
</head>

<body>
<div id="nav">
<ul>
	<li class="map01"><a href="#"></a></li>
	<li><a class="list" href="javascript:show('cpu')">CPU</a></li>
	<li class="map02"><a href="#"></a></li>
	<li><a class="list" href="javascript:show('hard')">硬盘</a></li>
	<li class="map03"><a href="#"></a></li>
	<li><a class="list" href="javascript:show('mem')">内存</a></li>
	<li class="map04"><a href="#"></a></li>
	<li><a class="list" href="javascript:show('net')">网络接口</a></li>
	<li class="map04"><a href="#"></a></li>
	<li><a class="list" href="javascript:show('qu')">网络流量</a></li>
	<li class="map05"><a href="#"></a></li>
	<li><a class="list" href="javascript:show('on')">在线统计</a></li>
	<li class="map06"><a href="#"></a></li>
	<li><input type="button"
		onclick="javascript:location.href='DevicePerformance.do?deviceId=${deviceId}'" value="资产可用性报表" class="an-1" /></li>
</ul>
</div>
<div id="cpu" class="border">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="center" colspan="2">CPU使用率统计</td>

	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="80%">&nbsp;</td>
	</tr>
	<tr>
		<td>
		<div align="right">每日</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${cpuDImg}"/></td>
	</tr>
	<tr>
		<td>
		<div align="right">每月</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${cpuMImg}" />
		</td>
	</tr>
	<tr>
		<td>
		<div align="right">每年</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${cpuYImg}" />
		</td>
	</tr>
</table>
</div>
<div id="hard" class="border" style="display: none;">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="center" colspan="2">硬盘使用率统计</td>

	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="80%">&nbsp;</td>
	</tr>
	<tr>
		<td>
		<div align="right">每日</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${harDImg}" /></td>
	</tr>
	<tr>
		<td>
		<div align="right">每月</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${harMImg}" />
		</td>
	</tr>
	<tr>
		<td>
		<div align="right">每年</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${harYImg}" />
		</td>
	</tr>
</table>
</div>
<div id="mem" class="border" style="display: none;">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="center" colspan="2">内存使用率统计</td>

	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="80%">&nbsp;</td>
	</tr>
	<tr>
		<td>
		<div align="right">每日</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${meDImg}" /></td>
	</tr>
	<tr>
		<td>
		<div align="right">每月</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${meMImg}" />
		</td>
	</tr>
	<tr>
		<td>
		<div align="right">每年</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${meYImg}" />
		</td>
	</tr>
</table>
</div>
<div id="net" class="border" style="display: none;">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="center" colspan="2">网络接口使用率统计</td>

	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="80%">&nbsp;</td>
	</tr>
	<tr>
		<td>
		<div align="right">每日</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${netDImg}" /></td>
	</tr>
	<tr>
		<td>
		<div align="right">每月</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${netMImg}" />
		</td>
	</tr>
	<tr>
		<td>
		<div align="right">每年</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${netYImg}" />
		</td>
	</tr>
</table>
</div>
<div id="qu" class="border" style="display: none;">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="center" colspan="2">网络流量统计</td>

	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="80%">&nbsp;</td>
	</tr>
	<tr>
		<td>
		<div align="right">每日</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${quDImg}" /></td>
	</tr>
	<tr>
		<td>
		<div align="right">每月</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${quMImg}" />
		</td>
	</tr>
	<tr>
		<td>
		<div align="right">每年</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${quYImg}" />
		</td>
	</tr>
</table>
</div>
<div id="on" class="border" style="display: none;">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	align="center">
	<tr>
		<td align="center" colspan="2">在线统计</td>

	</tr>
	<tr>
		<td width="20%">&nbsp;</td>
		<td width="80%">&nbsp;</td>
	</tr>
	<tr>
		<td>
		<div align="right">每日</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${onDImg}" /></td>
	</tr>
	<tr>
		<td>
		<div align="right">每月</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${onMImg}" />
		</td>
	</tr>
	<tr>
		<td>
		<div align="right">每年</div>
		</td>
		<td><img
			src="<%=request.getContextPath()%>/DisplayChart?filename=${onYImg}" />
		</td>
	</tr>
</table>
</div>
</body>
</html>
