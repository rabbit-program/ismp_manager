<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>检测项详细信息</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
</head>
<body>
<div id="contant">
<div id="main">
<form action="/ismp/domain/local/scm/monitorAction.do" method="post">
    <div  id="data" class="pad1 ">
	   <table width="70%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<th>ID号</th>
				<td><input type="text" class="input" value="${monitor.id}" disabled="disabled"/></td>
				<th>检测项目名称</th>
				<td><input type="text" class="input" value="${monitor.name}" disabled="disabled"/></td>
			</tr>

            <tr>
                <th>检测项目类型</th>
                <td><input type="text" class="input" value="${monitor.subType}" disabled="disabled"/></td>
                <th>超时时间</th>
                <td><input type="text" class="input" value="${monitor.timeout}" disabled="disabled"/></td>
            </tr>

			<tr>
<!--				<th>监控地址</th>-->
<!--				<td><input type="text" class="input" value="${monitor.url}" disabled="disabled"/></td>-->
				<th>IP地址</th>
				<td><input type="text" class="input" value="${monitor.ip}" disabled="disabled"/></td>
				<th>端口号</th>
				<td><input type="text" class="input" value="${monitor.port}" disabled="disabled"/></td>
			</tr>

            <tr>
                <th>重试次数</th>
                <td><input type="text" class="input" value="${monitor.retry}" disabled="disabled"/></td>
                <th>检测间隔时间</th>
                <td><input type="text" class="input" value="${monitor.intervalTime}" disabled="disabled"/></td>
            </tr>

            <tr>
                <th>用户名</th>
                <td><input type="text" class="input" value="${monitor.userid}" disabled="disabled"/></td>
                <th>密码</th>
                <td><input type="text" class="input" value="${monitor.password}" disabled="disabled"/></td>
            </tr>

            <tr>
                <th>检测项目描述</th>
                <td><input type="text" class="input" value="${monitor.description}" disabled="disabled"/></td>
                <th>所属域</th>
                <td><input type="text" class="input" value="${monitor.domain.domainName}" disabled="disabled"/></td>
            </tr>

            <tr>
                <th>监控地址</th>
                <td><input type="text" class="input" value="${monitor.url}" disabled="disabled"/></td>
                <th>&nbsp;&nbsp;</th>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            </tr>
        </table>            

        <div class="martop8" align="center">
            <input class="button" type="button" name="button" value="关闭" onclick="window.close();"/>
            <div class="paddiv"></div>
        </div>
    </div>
</form>
</div>
</div>
</body>
</html>

