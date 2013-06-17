<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>上传文件信息的更新</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />

<script language="javascript">
function checkGospInput() {
	var sn = document.getElementById("sn").value; 
    var issueUnit = document.getElementById("issueUnit").value; 
    var remark = document.getElementById("remark").value;  

     if (sn == null|| sn == undefined|| sn == ""|| sn.length > 255) {
        alert("上传文件编号必填且不超过255个字符!");
        sn.focus; 
        return ;
    }else if (issueUnit == null|| issueUnit == undefined|| issueUnit == ""|| issueUnit.length > 255) {
       alert("发布单位必填且不超过255个字符!");
       issueUnit.focus; 
       return ;
   }  else if (remark == null|| remark == undefined || remark == ""|| remark.length > 255) {
       alert("上传文件描述 必填且不超过255个字符!");
       remark.focus; 
       return ;
   } 
   document.forms[0].submit();
}
</script>
</head>

<body>
<html:form action="/ismp/domain/local/gosp/lawRulesUpdate.do?method=update">
    <div id="data" class="pad1 ">
        <h2>上传文件信息的录入 "<span class="alert">*</span>"为必填项</h2>
        <table>
            <tr>
                <th>上传文件编号<span class="alert">*</span></th>
                <td><input size="8" id="sn" name="sn" value="${lawsAndRules.sn}" /></td>
             <!--     <th>所属单位<span class="alert">*</span></th>
                <td>
                    <select id="dmid" name="dmid">
                        <c:forEach items="${udl}" var="ud">
                            <option value="${ud.id}"<c:if test="${ud.id == lawsAndRules.domain.id}">selected='selected'</c:if>>${ud.domainName}</option>
                        </c:forEach>
                    </select>
                </td>-->
            </tr>
            <tr>
                <th>发布单位<span class="alert">*</span></th>
                <td colspan="3"><textarea cols="60" rows="5" id="issueUnit" name="issueUnit">${lawsAndRules.issueUnit}</textarea></td>
            </tr>
            <tr>
                <th>法律法规描述<span class="alert">*</span></th>
                <td colspan="3"><textarea id="remark" name="remark" cols="60" rows="5">${lawsAndRules.remark}</textarea></td>
            </tr>
        </table>
        <div class="paddiv"></div>
        <input type="button" value="提交" class="R6 R7" onclick="checkGospInput()" />
        <div class="paddiv"></div>
    </div>
</html:form>
</body>
</html>