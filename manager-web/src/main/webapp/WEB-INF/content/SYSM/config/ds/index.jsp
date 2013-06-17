<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title>系统管理--数据上报</title>

        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<script type="text/javascript">
function onClean(){
    document.getElementById("centerIp").value="";
    document.getElementById("dataSynPort").value="";
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
    if (trim(document.getElementById("centerIp").value) == null
            || document.getElementById("centerIp").value == undefined
            || trim(document.getElementById("centerIp").value) == ""
            || checkIP(document.getElementById("centerIp").value)==false) {
        alert("center端IP必填且IP地址必须合法!");
        return false;
    } else if (trim(document.getElementById("dataSynPort").value) == null
            || document.getElementById("dataSynPort").value == undefined
            || trim(document.getElementById("dataSynPort").value) == ""
            || isNumber(trim(document.getElementById("dataSynPort").value))==false
            || document.getElementById("dataSynPort").value.length > 200) {
        alert(" 数据通讯端口必需为数字且不能超过200个字符!");
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
                <h2>数据上报</h2>
                <div id="data" class="greenborder overf pad1" >
                    <form action="${ctx}/ismp/domain/local/sysm/config/ds/dataSynConfigModify.do" method="post" name="f1" id="f1" onsubmit="return validateForm(this);">
                        <table>
	                        <tr>
	                            <th width="18%">
	                                center端IP
	                            </th>
	                            <td colspan="6">
	                                <input type="text" name="centerIp" id="centerIp" value="${configDataSyn.centerIp}"/>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th width="18%">
	                                                                                                   数据通讯端口
	                            </th>
	                            <td colspan="6">
	                                <input type="text" name="dataSynPort" id="dataSynPort" value="${configDataSyn.dataSynPort }"/>
	                            </td>
	                        </tr>
                        </table>
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
                    <br />
                </div>
              </form>
              </div>
            </div>
        </div>
    </body>
</html>