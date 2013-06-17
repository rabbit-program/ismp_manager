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

<title>动态脆弱点${dynaVuln.id}详细信息</title>
</head>
<body>
<div  id="data" class="pad1 ">
<table>
  <tr>
    <th> 动态脆弱点编号 </th>
    <td>${dynaVuln.id}</td>
    <th> 关联资产 </th>
    <td><c:choose>
          <c:when test="${dynaVuln.asse==null}">
                 (未关联资产)
          </c:when>
          <c:otherwise>
            ${dynaVuln.asse.assetName}
          </c:otherwise>
        </c:choose></td>
  </tr>
  <tr>
    <th> 脆弱点类别 </th>
    <td>${vulnKind.kind}</td>
    <th> 严重程度 </th>
    <td><span class="font_tip"><b><c:choose>
                       <c:when test="${dynaVuln.seriLeve=='L'}">
                                                                 低风险
                       </c:when>
                       <c:when test="${dynaVuln.seriLeve=='M'}">
                                                                 中风险
                       </c:when>
                        <c:when test="${dynaVuln.seriLeve=='H'}">
                                                                 高风险
                       </c:when>
                     </c:choose></b></span></td>
  </tr>
  <tr>
    <th> 脆弱点来源 </th>
    <td> ${dynaVuln.source} </td>
    <th>&nbsp;</th>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <th> 脆弱点描述 </th>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="4"><div style="width:450px;"> <textarea cols="145" rows="5" readonly>${vulnPoin.describe}</textarea></div></td>
  </tr>
  </table>

</div>
</body>