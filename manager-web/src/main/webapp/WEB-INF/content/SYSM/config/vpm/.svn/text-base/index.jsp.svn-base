<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>系统管理--病毒补丁</title>
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
            <div class="contant">
                <h2>病毒补丁</h2>
                <jsp:include page="/WEB-INF/content/SYSM/config/vpm/pm/index.jsp"></jsp:include>
                <h2></h2>
                <jsp:include page="/WEB-INF/content/SYSM/config/vpm/vm/index.jsp"></jsp:include>
            </div>
        </div>
    </body>
</html>