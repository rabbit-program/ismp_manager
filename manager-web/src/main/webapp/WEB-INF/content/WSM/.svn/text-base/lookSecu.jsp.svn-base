<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
</script>
</head>
<body>

<div id="data" class="pad1 ">
<table>
  <tr>
    <th> 编号 </th>
    <td>${webMonitorRecords.sn }</td>
    <th> 名称 </th>
    <td>${webMonitorRecords.name }</td>
  </tr>
  <tr>
    <th> 轮询时间</th>
    <td>${webMonitorRecords.timeInterval } </td>
    <th> 超时时间</th>
    <td>${webMonitorRecords.timeOut } </td>
  </tr>
  <tr>
    <th> 创建时间</th>
    <td>${webMonitorRecords.createTime } </td>
    <th> 最后修改时间</th>
    <td>${webMonitorRecords.lastUpdateTime } </td>
  </tr>
  <tr>
    <th> URL</th>
    <td>${webMonitorRecords.url } </td>
    <th> 所属域</th>
    <td>${webMonitorRecords.domain.domainName }</td>
    
  </tr>
  <tr>
    <th> 描述</th>
    <td> <textarea cols="80" rows="7" readonly>${webMonitorRecords.desc }</textarea> </td>
	 <th>&nbsp;</th>
	 <td>&nbsp;</td>
  </tr>
  <tr>
    <th> 备注 </th>
    <td><textarea cols="80" rows="7" readonly>${webMonitorRecords.remark }</textarea></td>
	 <th>&nbsp;</th>
	 <td>&nbsp;</td>
  </tr>
  </table>
</div>
</body>
</html>
