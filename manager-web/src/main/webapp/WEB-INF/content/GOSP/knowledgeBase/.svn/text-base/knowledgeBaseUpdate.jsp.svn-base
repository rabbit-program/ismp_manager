<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>知识库信息的更新</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />

<script language="javascript">
function checkGospInput() {
    var name = document.getElementById("name").value;
    //var dmid = document.getElementById("dmid").value;
    var file_content = document.getElementById("file_content").value; 
    var issuer = document.getElementById("issuer").value;
    var sn = document.getElementById("sn").value; 
    var remark = document.getElementById("remark").value;  
    
    if (name == null|| name == undefined || name == "" || name.length >50) {
       alert("知识库的名字必填不能超过50个字符!");
       name.focus; 
       return ;
    } else if (file_content == null|| file_content == undefined|| file_content == ""|| file_content.length > 255) {
       alert("知识库内容必填且不超过255个字符!");
       file_content.focus; 
       return ;
    }else if(issuer == null || issuer == undefined || issuer == "" || issuer.length >255){
        alert("发布人员必填不能超过255个字符!");
        issuer.focus;
        return;
    }else if (sn == null|| sn == undefined|| sn == ""|| sn.length > 255) {
       alert("知识库编号必填且不超过255个字符!");
       sn.focus; 
       return ;
    } else if (remark == null|| remark == undefined || remark == ""|| remark.length > 255) {
       alert("知识库描述 必填且不超过255个字符!");
       remark.focus; 
       return ;
    } 
    document.forms[0].submit();
}
</script>
</head>

<body>
<html:form action="/ismp/domain/local/gosp/updateKB.do?method=update">
    <div id="data" class="pad1 ">
        
        <table>
            <tr>
                <th>知识库名称<span class="alert">*</span></th>
                <td><input size="8" id="name" name="name" value="${KBInfo.name}" /></td>
               <!--<th>所属单位<span class="alert">*</span></th>
                <td>
                    <select id="dmid" name="dmid">
                        <c:forEach items="${udl}" var="ud">
                            <option value="${ud.id}"<c:if test="${ud.id == KBInfo.domain.id}">selected='selected'</c:if>>${ud.domainName}</option>
                        </c:forEach>
                    </select>
                </td>-->
            </tr>
            <tr>
                <th>知识库内容<span class="alert">*</span></th>
                <td colspan="3"><textarea cols="60" rows="5" id="file_content" name="file_content">${KBInfo.file_content}</textarea></td>
            </tr>
            <tr>
                <th>发布人员<span class="alert">*</span></th>
                <td colspan="3"><textarea id="issuer" name="issuer" cols="60" rows="5" >${KBInfo.issuer}</textarea></td>
            </tr>
            <tr>
                <th>知识库编号<span class="alert">*</span></th>
                <td colspan="3"><textarea id="sn" name="sn" cols="60" rows="5">${KBInfo.sn}</textarea></td>
            </tr>
            <tr>
                <th>知识库描述<span class="alert">*</span></th>
                <td colspan="3"><textarea id="remark" name="remark" cols="60" rows="5">${KBInfo.remark}</textarea></td>
            </tr>
        </table>
        <div class="paddiv"></div>
        <input type="button" value="提交" class="R6 R7" onclick="checkGospInput()" />
        <div class="paddiv"></div>
    </div>
</html:form>
</body>
</html>