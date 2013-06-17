<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>网络等保状态信息录入</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/boxy.css" />

<script language="javascript">
function checkGospInput() {
	var regExp=/\d/;
	//level == null || level == undefined || level == ""
    var name = document.getElementById("name").value;
    //var dmid = document.getElementById("dmid").value;
    var desc = document.getElementById("desc").value; 
    var level = document.getElementById("level").value;
    var state = document.getElementById("state").value; 
    var remark = document.getElementById("remark").value;  
    
    if (name == null|| name == undefined || name == "" || name.length > 60) {
       alert("网络等保状态的名称必填不能超过60个字符!");
       name.focus; 
       return ;
    } else if (desc == null|| desc == undefined|| desc == ""|| desc.length > 255) {
       alert("网络描述的内容必填且不超过255个字符!");
       desc.focus; 
       return ;
    }else if(!regExp.test(level) || level == null || level == undefined || level == ""){
        alert("网络等级必填且必须是数字!");
        level.focus;
        return;
    }else if (!regExp.test(state) || state == null || state == undefined|| state == "") {
       alert("网络状况必填且必须是数字!");
       state.focus; 
       return ;
    } else if (remark == null|| remark == undefined || remark == ""|| remark.length > 255) {
       alert("网络等保状态必填且不超过255个字符!");
       remark.focus; 
       return ;
    } 
    document.forms[0].submit();
}
</script>
</head>

<body>
<html:form action="/ismp/domain/local/gosp/addNetSafe.do?isAll=${isAll}">
    <input id="isAdd" name="isAdd" type="hidden" value="1" />
    <div id="data" class="pad1 ">
        <h2>网络等保状态信息录入 "<span class="alert">*</span>"为必填项</h2>
        <table>
            <tr>
                <th>网络名称<span class="alert">*</span></th>
                <td><input size="12" name="name" id="name" /></td>
              <!-- <th>所属单位<span class="alert">*</span></th>
                <td>
                    <select id="dmid" name="dmid">
                        <c:forEach items="${udl}" var="ud">
                            <option value="${ud.id}">${ud.domainName}</option>
                        </c:forEach>
                    </select>
                </td>-->
            </tr>
            <tr>
                <th>网络描述<span class="alert">*</span></th>
                <td colspan="3"><textarea cols="60" rows="5" name="desc" id="desc"></textarea></td>
            </tr>
            <tr>
                <th>网络等级<span class="alert">*</span></th>
                <td colspan="3"><textarea name="level" cols="60" rows="5" id="level"></textarea></td>
            </tr>
            <tr>
                <th>网络状况<span class="alert">*</span></th>
                <td colspan="3"><textarea name="state" cols="60" rows="5" id="state"></textarea></td>
            </tr>
            <tr>
                <th>网络等保状况备注<span class="alert">*</span></th>
                <td colspan="3"><textarea name="remark" cols="60" rows="5" id="remark"></textarea></td>
            </tr>
        </table>
        <div class="paddiv"></div>
        <input type="button" value="提交" class="R6 R7" onclick="checkGospInput()" />
        <div class="paddiv"></div>
    </div>
</html:form>
</body>
</html>