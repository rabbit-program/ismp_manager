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

<script language="javascript" >
function Onclose(){
	window.close();
}
function checkboxs(){
   var chk = false;
   var checkBoxList = document.all.noticeWays;
   for(j=0;j<checkBoxList.length;j++){
       if(checkBoxList[j].checked){
           chk = true;
       }
   }
   return chk;
}

function validateWorkOrderForm(form){
	if (document.getElementById("domain").value == null
            || document.getElementById("domain").value == undefined
            || document.getElementById("domain").value == "") {
        alert("所属域必选!");
        return false;
    } else if (document.getElementById("name").value == null
            || document.getElementById("name").value == undefined
            || document.getElementById("name").value == ""
            || document.getElementById("name").value.length > 255) {
        alert("问题标题不能为空且不能超过255个字符!");
        return false;
    } else if (document.getElementById("desc").value == null
            || document.getElementById("desc").value == undefined
            || document.getElementById("desc").value == ""
            || document.getElementById("desc").value.length > 500) {
        alert("描述必填且不能超过500个字符!");
        return false;
    } if (document.getElementById("remark").value == null
            || document.getElementById("remark").value == undefined
            || document.getElementById("remark").value == ""
            || document.getElementById("remark").value.length > 500) {
        alert("备注名称必填且不能超过500个字符!");
        return false;
    } else if (document.getElementById("operator").value == null
            || document.getElementById("operator").value == undefined
            || document.getElementById("operator").value == "") {
        alert("处理人必选!");
        return false;
    } else if (document.getElementById("endTime").value == null
            || document.getElementById("endTime").value == undefined
            || document.getElementById("endTime").value == "") {
        alert("处理时限必选!");
        return false;
    } if (document.getElementById("level").value == null
            || document.getElementById("level").value == undefined
            || document.getElementById("level").value == ""
            || document.getElementById("level").value.length > 500) {
        alert("紧急程度必选!");
        return false;
    } if (checkboxs()==false) {
        alert("通知方式必选!");
        return false;
    } else if (document.getElementById("linkman").value == null
            || document.getElementById("linkman").value == undefined
            || document.getElementById("linkman").value == ""
            || document.getElementById("linkman").value.length > 50) {
        alert("联系人必填且不超过50个字符!");
        return false;
    } else if (document.getElementById("contactInfo").value == null
            || document.getElementById("contactInfo").value == undefined
            || document.getElementById("contactInfo").value == ""
            || document.getElementById("contactInfo").value.length > 150) {
        alert("联系方式必填且不超过150个字符!");
        return false;
    }else if (document.getElementById("serverUrl").value == null
            || document.getElementById("serverUrl").value == undefined
            || document.getElementById("serverUrl").value == ""
            || document.getElementById("serverUrl").value.length > 100) {
        alert("服务地址必填且不超过100个字符!");
        return false;
    }else {
        return true;
    }
}
</script>
</head>

<body>
<c:if test="${question==null}">
<form action="${ctx}/ismp/domain/local/oss/workOrder.do?method=addWorkOrder&isAll=${isAll}" id="form1" name="form1"  method="post" onsubmit="return validateWorkOrderForm(this);">
	<input id="isAll" name="isAll" type="hidden" value="${isAll}" />
	<div id="data" class="pad1 ">
	    <h2>新建工单 "<span class="alert">*</span>"为必填项</h2>
     <c:if test="${!empty sessionScope.message}">
            <font color="red"><c:out value="${sessionScope.message}"></c:out></font>
        <c:remove var="message"  scope="session" />
    </c:if>
	    <table>
	        <tr>
                <input id="isNew" name="isNew" type="hidden" value="0"/>
	            <th>工单号<span class="alert">*</span></th>
	            <td><input size="20" name="sn" id="sn" value="${sn}" readonly/></td>
	            <th>所属域<span class="alert">*</span></th>
	            <td>
	                <select id="domain" name="domain">
	                    <c:forEach items="${udl}" var="ud">
	                        <option value="${ud.id}">${ud.domainName}</option>
	                    </c:forEach>
	                </select>
	            </td>
	        </tr>
            <tr>
                <th>问题标题<span class="alert">*</span></th>
                <td colspan="3"><input size="35" name="name" id="name" /></td>
            </tr>
	        <tr>
	            <th>问题描述<span class="alert">*</span></th>
	            <td colspan="3"><textarea cols="60" rows="6" name="desc" id="desc"></textarea></td>
	        </tr>
            <tr>
                <th>问题来源<span class="alert">*</span></th>
                <td colspan="3"><input size="35" name="source" id="source" readonly/></td>
            </tr>
	        <tr>
	            <th>备注<span class="alert">*</span></th>
	            <td colspan="3"><textarea name="remark" cols="60" rows="6" id="remark"></textarea></td>
	        </tr>
	        <tr>
	            <th>处理人<span class="alert">*</span></th>
	            <td colspan="3">
                   <select id="operator" name="operator">
                        <c:forEach items="${rosterList}" var="oper">
                            <option value="${oper.id}">${oper.name}</option>
                        </c:forEach>
                    </select>
                </td>
	        </tr>
             <tr>
                <th>处理时限<span class="alert">*</span></th>
                <td>
                    <input type="text" id="endTime" name="endTime" value="${endTime}" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" readonly="true"/>
                </td>
                <th>紧急程度<span class="alert">*</span></th>
                <td>
                     <select id="level" name="level">
                       <option value="1">高</option>
					   <option value="2">中</option>
					   <option value="3">低</option>
                    </select></td>
            </tr>
             <tr>
                <th>通知方式<span class="alert">*</span></th>
                <td colspan="3">
                <input type="checkbox" value="1"  name="noticeWays"/>短信 
                &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" value="2"  name="noticeWays"/>E-mail</td>
            </tr>
            <tr>
                <th>联系人<span class="alert">*</span></th>
                <td><input size="20" name="linkman" id="linkman" /></td>
                <th>联系方式<span class="alert">*</span></th>
                <td><input size="20" name="contactInfo" id="contactInfo" /></td>
            </tr>
	        <tr>
	            <th>服务地址<span class="alert">*</span></th>
	            <td colspan="3"><input size="35" name="serverUrl" id="serverUrl" /></td>
	        </tr>
	    </table>
	    <div class="paddiv"></div>
	    <input type="submit" value="提交" class="R6 R7" />
		 <input type="button" value="取消" class="R6 R7"  onclick="Onclose()"/>
	    <div class="paddiv"></div>
	</div>
</form>
</c:if>

<c:if test="${question!=null}">
<form action="${ctx}/ismp/domain/local/oss/workOrder.do?method=addWorkOrder&isAll=${isAll}" id="form1" name="form1" method="post" onsubmit="return validateWorkOrderForm(this);">
    <input id="id" name="id" type="hidden" value="${question.id}"/>
    <input id="q_sn" name="q_sn" type="hidden" value="${question.sn}"/>
    <input id="sensorId" name="sensorId" type="hidden" value="${question.sensorId}"/>
    <input id="isAll" name="isAll" type="hidden" value="${isAll}" />
    <input id="isNew" name="isNew" type="hidden" value="${question.isNew}"/>
    <div id="data" class="pad1 ">
        <h2>新建工单 "<span class="alert">*</span>"为必填项</h2>
 <c:if test="${!empty sessionScope.message}">
            <font color="red"><c:out value="${sessionScope.message}"></c:out></font>
        <c:remove var="message"  scope="session" />
    </c:if>
        <table>

            <tr>
                <th>工单号<span class="alert">*</span></th>
                <td><input size="20" name="sn" id="sn" value="${sn}" readonly/></td>
                <th>所属域<span class="alert">*</span></th>
                <td>
                    <select id="domain" name="domain">
                        <c:forEach items="${udl}" var="ud">
                            <c:choose>
                             <c:when test="${ud.id == question.domain.id}">
                              <c:set var="select13" value="selected"></c:set>
                             </c:when>
                             <c:otherwise>
                              <c:set var="select13" value="aaa"></c:set>
                             </c:otherwise>
                            </c:choose>
                            <option value="${ud.id}" ${select13}>${ud.domainName}</option>
                        </c:forEach>
                    </select>
                
                </td>
            </tr>
            <tr>
                <th>问题标题<span class="alert">*</span></th>
                <td colspan="3"><input size="35" name="name" id="name" value="${question.name}" readonly/></td>
            </tr>
            <tr>
                <th>问题描述<span class="alert">*</span></th>
                <td colspan="3"><textarea cols="60" rows="6" name="desc" id="desc" readonly>${question.desc}</textarea></td>
            </tr>
            <tr>
                <th>问题来源<span class="alert">*</span></th>
                <td colspan="3"><input size="35" name="source" id="source"  value="${question.source}" readonly/></td>
            </tr>
            <tr>
                <th>备注<span class="alert">*</span></th>
                <td colspan="3"><textarea name="remark" cols="60" rows="6" id="remark" >${question.remark}</textarea></td>
            </tr>
            <tr>
                <th>处理人<span class="alert">*</span></th>
                <td colspan="3">
                   <select id="operator" name="operator">
                        <c:forEach items="${rosterList}" var="oper">
                            <option value="${oper.id}">${oper.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
             <tr>
                <th>处理时限<span class="alert">*</span></th>
                <td>
                    <input type="text" id="endTime" name="endTime" value="${endTime}" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" readonly="true"/>
                </td>
                <th>紧急程度<span class="alert">*</span></th>
                <td>
                     <select id="level" name="level">
                       <option value="1">高</option>
                       <option value="2">中</option>
                       <option value="3">低</option>
                    </select></td>
            </tr>
             <tr>
                <th>通知方式<span class="alert">*</span></th>
                <td colspan="3">
                <input type="checkbox" value="1" id="noticeWays" name="noticeWays"/>短信 
                &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="checkbox" value="2" id="noticeWays" name="noticeWays"/>E-mail</td>
            </tr>
            <tr>
                <th>联系人<span class="alert">*</span></th>
                <td><input size="20" name="linkman" id="linkman" value="${question.linkman}" readonly/></td>
                <th>联系方式<span class="alert">*</span></th>
                <td><input size="20" name="contactInfo" id="contactInfo" value="${question.contactInfo}" readonly/></td>
            </tr>
            <tr>
                <th>服务地址<span class="alert">*</span></th>
                <td colspan="3"><input size="35" name="serverUrl" id="serverUrl"  value="${question.serverUrl}" readonly/></td>
            </tr>
        </table>
        <div class="paddiv"></div>
        <input type="submit" value="提交" class="R6 R7" />
        <input type="button" value="取消" class="R6 R7"  onclick="Onclose()"/>
        <div class="paddiv"></div>
    </div>
</form>
</c:if>
</body>
</html>