<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>系统管理--信息发送</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
    
<script type="text/javascript">
function onClean(){
    document.getElementById("sendIp").value="";
    document.getElementById("sendPort").value="";
    document.getElementById("emailServer").value="";
    document.getElementById("email").value="";
    document.getElementById("username").value="";
    document.getElementById("password").value="";
}

function  trim(str){
    for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
    for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
    if(i>j) return "";  
    return  str.substring(i,j);  
} 

function checkIP(obj) { 
    var exp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/; 
    var reg = obj.match(exp); 
    if(reg==null) { 
        return false;
    } 
    else { 
        return true;
    } 
}  

function isNumber(oNum) { 
    if(!oNum) return false; 
    var strP=/^\d+(\.\d+)?$/; 
    if(!strP.test(oNum)) return false; 
    try{ 
         if(parseFloat(oNum)!=oNum) return false; 
    } catch(ex) { 
         return false; 
    } 
    return true; 
}

function validateForm(form){
	//var email=document.getElementById("email").value;
    if (trim(document.getElementById("sendIp").value) == null
            || document.getElementById("sendIp").value == undefined
            || trim(document.getElementById("sendIp").value) == ""
            || checkIP(document.getElementById("sendIp").value)==false) {
        alert("IP必填且IP地址必须合法!");
        return false;
    } else if (trim(document.getElementById("sendPort").value) == null
            || document.getElementById("sendPort").value == undefined
            || trim(document.getElementById("sendPort").value) == ""
            || isNumber(trim(document.getElementById("sendPort").value))==false
            || document.getElementById("sendPort").value.length > 200) {
        alert("Port必须为数字且不能超过200个字符!");
        return false;
    //} else if (trim(document.getElementById("emailServer").value) == null
      //      || document.getElementById("emailServer").value == undefined
      //      || trim(document.getElementById("emailServer").value) == ""
      //      || document.getElementById("emailServer").value.length > 200) {
      //  alert("邮件服务器必填且不能超过200个字符!");
      //  return false;
    //} else if (trim(document.getElementById("email").value) == null
     //       || document.getElementById("email").value == undefined
     //       || trim(document.getElementById("email").value) == ""
     //       || document.getElementById("email").value.length > 200
     //       || email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) == -1) {
     //   alert("邮箱地址必填且必须合法!");
     //   return false;
    //} else if (trim(document.getElementById("username").value) == null
    //        || document.getElementById("username").value == undefined
    //        || trim(document.getElementById("username").value) == ""
    //        || document.getElementById("username").value.length > 200) {
    //    alert("用户名必填且不能超过200个字符!");
    //    return false;
    //} else if (trim(document.getElementById("password").value) == null
    //        || document.getElementById("password").value == undefined
     //       || trim(document.getElementById("password").value) == ""
     //       || document.getElementById("password").value.length > 200) {
     //   alert("密码必填且不能超过200个字符!");
     //   return false;
    } else {
        return true;
    }
}
</script>
</head>
    <body>
        <div id="contant" class="mainbg">
            <div id="banner" class="grayline overf bannerH" ></div>
            <form action="${ctx}/ismp/domain/local/sysm/config/sms/smsConfigModify.do" method="post" name="f1" id="f1" onsubmit="return validateForm(this);">
            <div class="contant">
                <h2>信息发送</h2>
                     <div id="data" class="greenborder overf pad1" >
                        <table>
                            <tr>
                                <th colspan="7">
                                    <label for="textfield">— 发送接口设置 —</label>
                                </th>
                            </tr>
                            <tr>
                                <th width="18%">IP</th>
                                <td colspan="6"><input type="text" name="sendIp" id="sendIp" value="${configSms.sendIp}"/></td>
                            </tr>
                            <tr>
                                <th width="18%">Port</th>
                                <td colspan="6">
                                <input type="text" name="sendPort" id="sendPort" value="${configSms.sendPort}"/></td>
                            </tr>
                        </table>
                      </div>
                <h2 ></h2>
                <div id="data" class="greenborder overf pad1" style="display: none">
                        <table>
                            <tr>
                                <th colspan="7">
                                    <label for="textfield">— 发件箱设置 —</label>
                                </th>
                            </tr>
                            <tr>
                                <th width="18%">邮件服务器</th>
                                <td colspan="6"><input type="text" name="emailServer" id="emailServer"  value="${configSms.emailServer}"/></td>
                            </tr>
                            <tr>
                                <th width="18%">邮箱地址</th>
                                <td colspan="6"><input type="text" name="email" id="email" value="${configSms.email}"/></td>
                            </tr>
                            <tr>
                                <th width="18%">用户名</th>
                                <td colspan="6"><input type="text" name="username" id="username" value="${configSms.username}" /></td>
                            </tr>
                            <tr>
                                <th width="18%">密码</th>
                                <td colspan="6">
                                <input type="text" name="password" id="password" value="${configSms.password}"/></td>
                            </tr>
                        </table>
                </div>
                <c:if test="${!empty message}">
                <font color="red"><c:out value="${message}"></c:out></font>
                <c:remove var="message"  scope="request" />
                </c:if>
                <div class="martop8 Height_t">
                    <ul id="page">
                        <li><input class="R6 R7 boxy" type="submit" value="保存"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="重置" onclick="onClean();"/></li>
                        <li><input class="R6 R7 boxy" type="button" value="关闭" onclick="window.close();"/></li>
                    </ul>
                </div>
            </div>
		</form>
        </div>
    </body>
</html>