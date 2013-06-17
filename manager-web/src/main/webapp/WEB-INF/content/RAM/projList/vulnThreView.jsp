<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>脆弱性分析</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>

<title>脆弱点与威胁关联信息</title>
</head>
<body>
<div  id="data" class="pad1 ">
<table>
  <tr>
    <th> 资产名称 </th>
    <td>${dynaThre.asse.assetName }&nbsp;</td>
  </tr>
  <tr>
    <th> 资产编号</th>
    <td>${dynaThre.asse.assetCode }&nbsp; </td>
  </tr>
  <tr>
    <th> 安全事件发生可能性 </th>
    <td><span class="font_tip"><b>  <c:choose>
                       <c:when test="${dynaThre.possibility=='L'}">
                                                                 低
                       </c:when>
                       <c:when test="${dynaThre.possibility=='M'}">
                                                                 中
                       </c:when>
                        <c:when test="${dynaThre.possibility=='H'}">
                                                                 高
                       </c:when>
                     </c:choose></b></span></td>
  </tr>
  <tr>
    <th> 脆弱点描述 </th>
    <td> <textarea cols="105" rows="7" readonly>${statVulnPoin.describe }</textarea> </td>
  </tr>
  <tr>
    <th> 威胁描述 </th>
    <td><textarea cols="105" rows="7" readonly>${statThre.threat }</textarea></td>
  </tr>
<tr>
    <th> 威胁备注 </th>
    <td><textarea cols="105" rows="7" readonly>${statThre.memo }</textarea></td>
  </tr>
  </table>

</div>
</body>