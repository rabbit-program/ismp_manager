<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat,java.util.Date" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>漏洞扫描</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
</head>
<body>
<div  id="data" class="pad1 ">
<table>
  <tr>
    <th>目标主机IP</th>
    <td>${leak.ip }&nbsp;</td>
    <th>对应资产名称</th>
    <td>${leak.asse.assetName }&nbsp;</td>
  </tr>
  <tr>
    <th>资产编号</th>
    <td>${leak.asse.assetCode }&nbsp;</td>
    <th>插件ID号</th>
    <td>${leak.pluginId }&nbsp;</td>
  </tr>
  <tr>
    <th>漏洞ID号</th>
    <td>${leak.knowId }&nbsp;</td>
    <th>CVE(CAN)ID</th>
    <td>${leak.cveId }&nbsp;</td>
  </tr>
  <tr>
    <th>插件（漏洞）名称</th>
    <td>${leak.location }&nbsp;</td>
    <th>严重程度</th>
    <td><span class="font_tip"><b><c:choose>
                       <c:when test="${leak.risk=='L'}">
                                                                 低风险
                       </c:when>
                       <c:when test="${leak.risk=='M'}">
                                                                 中风险
                       </c:when>
                        <c:when test="${leak.risk=='H'}">
                                                                 高风险
                       </c:when>
                     </c:choose></b></span></td>
  </tr>
  <tr>
    <th>厂商ID号</th>
    <td><a href="http://www.nsfocus.net/index.php?act=sec_bug&do=view&bug_id=${leak.nsfocusId }" target="_blank">
                   ${leak.nsfocusId }</a></td>
    <th>对应端口</th>
    <td>${leak.port }&nbsp;</td>
  </tr>
  <tr>
    <th>威胁描述</th>
  
  </tr>
  <tr>
    <td colspan="4"><div style="width:450px;"><textarea cols="145" rows="5" readonly>${leak.describe }</textarea></div></td>
    </tr>
  <tr>
    <th>漏洞对应的返回值</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><div style="width:450px;"><textarea cols="145" rows="5" readonly>${leak.message }</textarea></div></td>
    </tr>
 <tr>
    <th>建议措施</th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><div style="width:450px;"> <textarea cols="145" rows="5" readonly>${leak.solution }</textarea></div></td>
    </tr>
</table>
</body>
</div>
