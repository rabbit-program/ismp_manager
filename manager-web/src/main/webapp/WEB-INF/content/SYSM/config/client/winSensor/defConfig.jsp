<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>系统管理--WinSensor配置--默认配置</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<script type="text/javascript">
function onClean(){
    document.getElementById("dbUrl").value="";
    document.getElementById("dbDriver").value="";
    document.getElementById("username").value="";
    document.getElementById("password").value="";
}

function onClean1(){
    document.getElementById("dbUrl1").value="";
    document.getElementById("dbDriver1").value="";
    document.getElementById("username1").value="";
    document.getElementById("password1").value="";
}

function  trim(str){
    for(var i=0; i<str.length&&str.charAt(i)==" "; i++)  ;
    for(var j=str.length; j>0&&str.charAt(j-1)==" ";j--)  ;
    if(i>j) return "";  
    return  str.substring(i,j);  
} 

function validateForm(form){
    if (trim(document.getElementById("dbUrl").value) == null
            || document.getElementById("dbUrl").value == undefined
            || trim(document.getElementById("dbUrl").value) == ""
            || document.getElementById("dbUrl").value.length > 200) {
        alert("数据库必填且不能超过200个字符!");
        return false;
    } else if (trim(document.getElementById("dbDriver").value) == null
            || document.getElementById("dbDriver").value == undefined
            || trim(document.getElementById("dbDriver").value) == ""
            || document.getElementById("dbDriver").value.length > 200) {
        alert("数据库驱动必填且不能超过200个字符!");
        return false;
    } else if (trim(document.getElementById("username").value) == null
            || document.getElementById("username").value == undefined
            || trim(document.getElementById("username").value) == ""
            || document.getElementById("username").value.length > 200) {
        alert("用户名必填且不能超过200个字符!");
        return false;
    } else if (trim(document.getElementById("password").value) == null
            || document.getElementById("password").value == undefined
            || trim(document.getElementById("password").value) == ""
            || document.getElementById("password").value.length > 200) {
        alert("密码必填且不能超过200个字符!");
        return false;
    } else {
        return true;
    }
}

function validateForm1(form){
    if (trim(document.getElementById("dbUrl1").value) == null
            || document.getElementById("dbUrl1").value == undefined
            || trim(document.getElementById("dbUrl1").value) == ""
            || document.getElementById("dbUrl1").value.length > 200) {
        alert("数据库必填且不能超过200个字符!");
        return false;
    } else if (trim(document.getElementById("dbDriver1").value) == null
            || document.getElementById("dbDriver1").value == undefined
            || trim(document.getElementById("dbDriver1").value) == ""
            || document.getElementById("dbDriver1").value.length > 200) {
        alert("数据库驱动必填且不能超过200个字符!");
        return false;
    } else if (trim(document.getElementById("username1").value) == null
            || document.getElementById("username1").value == undefined
            || trim(document.getElementById("username1").value) == ""
            || document.getElementById("username1").value.length > 200) {
        alert("用户名必填且不能超过200个字符!");
        return false;
    } else if (trim(document.getElementById("password1").value) == null
            || document.getElementById("password1").value == undefined
            || trim(document.getElementById("password1").value) == ""
            || document.getElementById("password1").value.length > 200) {
        alert("密码必填且不能超过200个字符!");
        return false;
    } else {
        return true;
    }
}
</script>   
 </head>
    <body>
        <div id="contant" class="mainbg">
            <div id="banner" class="grayline overf bannerH" ></div>
            <form action="#" method="post" name="f2" id="f2" onsubmit="return validateForm2(this);">
	            <div class="contant">
	                <h2>WinSensor配置--默认配置</h2>
	                <div class="greenborder greenback overf pad3 Height_a" >
	                    <div style="float:left; margin-right:8px;">所属单位:
	                        <select id="selectid" name="selectid">
	                            <option value="-1">请选择单位</option>
	                            <logic:present name="udl">
	                                <logic:notEmpty name="udl">
	                                    <logic:iterate id="u" name="udl">
	                                         <c:choose>
	                                           <c:when test="${u.id == selectid}">
	                                            <c:set var="select13" value="selected"></c:set>
	                                           </c:when>
	                                           <c:otherwise>
	                                            <c:set var="select13" value=""></c:set>
	                                           </c:otherwise>
	                                          </c:choose>
	                                        <option value="${u.id}"  ${select13 }>${u.domainName}</option>
	                                    </logic:iterate>
	                                </logic:notEmpty>
	                            </logic:present>
	                            <sec:authorize ifAllGranted='ROLE_AdminAll'>
	                               <c:choose>
	                                 <c:when test="${selectid == -2}">
	                                  <option value="-2" selected="selected">未知域</option>
	                                 </c:when>
	                                 <c:otherwise>
	                                   <option value="-2" >未知域</option>
	                                 </c:otherwise>
	                                </c:choose>
	                            </sec:authorize>
	                        </select>
	                    </div>
	                </div>
	
	                <div class="paddiv"></div>
	                <jsp:include page="/WEB-INF/content/SYSM/config/client/winSensor/sub/register.jsp"></jsp:include>
	                <h2></h2>
	                <jsp:include page="/WEB-INF/content/SYSM/config/client/winSensor/sub/hostResource.jsp"></jsp:include>
	                <h2></h2>
	                <jsp:include page="/WEB-INF/content/SYSM/config/client/winSensor/sub/windowsUpdate.jsp"></jsp:include>
	                <h2></h2>
	                <jsp:include page="/WEB-INF/content/SYSM/config/client/winSensor/sub/softwareUpdate.jsp"></jsp:include>
	                <h2></h2>
	                <jsp:include page="/WEB-INF/content/SYSM/config/client/winSensor/sub/windowsLog.jsp"></jsp:include>
	                <h2></h2>
	                <jsp:include page="/WEB-INF/content/SYSM/config/client/winSensor/sub/winSensorManager.jsp"></jsp:include>
	
	                <div id="data" class="greenborder overf pad1" >
		                <div class="martop8 Height_t">
		                    <ul id="page">
		                        <li><input class="R6 R7 boxy" type="submit" value="保存"/></li>
		                        <li><input class="R6 R7 boxy" type="button" value="重置" onclick="onClean6();"/></li>
		                        <li><input class="R6 R7 boxy" type="button" value="关闭" onclick="window.close();"/></li>
		                    </ul>
		                    <br />
		                </div>
	                </div>
	            </div>
            </form>
        </div>
    </body>
</html>