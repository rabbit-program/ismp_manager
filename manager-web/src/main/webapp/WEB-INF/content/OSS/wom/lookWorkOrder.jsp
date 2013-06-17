<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
<script language="javascript">

</script>
</head>

<body>
	<div id="data" class="pad1 ">
	    <h2>查看工单</h2>
	    <table>
	        <tr>
	            <th>工单号</th>
	            <td>${workOrder.sn}</td>
	            <th>所属域</th>
	            <td>
	               ${workOrder.domain.domainName}
	            </td>
	        </tr>
            <tr>
                <th>问题标题</th>
                <td colspan="3">${workOrder.question.name}</td>
            </tr>
	        <tr>
	            <th>问题描述</th>
	            <td colspan="3"><textarea cols="70" rows="5" readonly>${workOrder.question.desc}</textarea></td>
	        </tr>
            <tr>
                <th>问题来源</th>
                <td colspan="3">${workOrder.question.source}</td>
            </tr>
	        <tr>
	            <th>备注</th>
	            <td colspan="3"><textarea cols="70" rows="5" readonly>${workOrder.question.remark}</textarea></td>
	        </tr>
	        <tr>
	            <th>处理人</th>
	            <td colspan="3">${workOrder.operator.name}
                </td>
	        </tr>
             <tr>
                <th>处理时限</th>
                <td>
                   ${workOrder.endTime}
                </td>
                <th>紧急程度</th>
                <td>
                     <c:if test="${workOrder.level==1}">高</c:if>
					 <c:if test="${workOrder.level==2}">中</c:if>
					 <c:if test="${workOrder.level==3}">低</c:if>
                    </td>
            </tr>
             <tr>
                <th>通知方式</th>
                <td>
                     <c:if test="${workOrder.noticeWay==1}">短信</c:if>
                     <c:if test="${workOrder.noticeWay==2}">E_mail</c:if>
                     <c:if test="${workOrder.noticeWay==3}">短信和E_mail</c:if>
                <th>客户评价</th>
                <td> ${workOrder.clientValue } </td>
            </tr>
            <tr>
                <th>联系人</th>
                <td>${workOrder.question.linkman}</td>
                <th>联系方式</th>
                <td>${workOrder.question.contactInfo}</td>
            </tr>
	        <tr>
	            <th>服务地址</th>
	            <td colspan="3">${workOrder.question.serverUrl}</td>
	        </tr>
	    </table>
	</div>
</body>
</html>