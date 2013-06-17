<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新建检测项目</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript">
    ///校验数字
    function limitNum(obj) {
        if (obj.replace(/[\d+]/ig, "").length > 0) {
            return false;
        } else {
            return true;
        }
    }
    ///切换服务类型触发
    function changeMethod(type) {
        window.location.href = "${ctx}/ismp/domain/local/scm/monitorAction.do?method=changeDisplay&type="  + type;
    }
    ///选择服务类型子类型时自动填写部分内容
    function auto(monitorType) {
        if (monitorType == 'DB') {
            if (document.getElementById("subType").value == "MYSQL") {
                document.getElementById("description").value = "MySQL DataBase 监控";
                document.getElementById("port").value = "3306";
            }
            if (document.getElementById("subType").value == "ORALCE") {
                document.getElementById("description").value = "Oracle DataBase 监控";
                document.getElementById("port").value = "1521";
            }
            if (document.getElementById("subType").value == "DB2") {
                document.getElementById("description").value = "DB2 DataBase 监控";
                document.getElementById("port").value = "50000";
            }
            if (document.getElementById("subType").value == "SQLSERVER") {
                document.getElementById("description").value = "SQLSERVER Server DataBase 监控";
                document.getElementById("port").value = "1433";
            }
        } else if (monitorType == 'TCP') {
            if (document.getElementById("subType").value == "POP3") {
                document.getElementById("description").value = "post office protocol v3";
                document.getElementById("port").value = "110";
            } else if (document.getElementById("subType").value == "SMTP") {
                document.getElementById("description").value = "simple mail transfer protocol";
                document.getElementById("port").value = "25";
            } else if (document.getElementById("subType").value == "FTP") {
                document.getElementById("description").value = "file transfer protocol";
                document.getElementById("port").value = "21";
            } else if (document.getElementById("subType").value == "IMAP") {
                document.getElementById("description").value = "internet mail access protocol ";
                document.getElementById("port").value = "143";
            } else if (document.getElementById("subType").value == "SSH") {
                document.getElementById("description").value = "secure shell protocol ";
                document.getElementById("port").value = "22";
            } else if (document.getElementById("subType").value == "SNMP") {
                document.getElementById("description").value = "simple network management protocol";
                document.getElementById("port").value = "161";
            } else if (document.getElementById("subType").value == "ICMP") {
                document.getElementById("description").value = "Internet Control Message Protocol";
                document.getElementById("port").value = "";
            } 
        } else if (monitorType == 'WEB') {
            if (document.getElementById("subType").value == "HTTP") {
                document.getElementById("description").value = "hyperText transfer protocol";
                document.getElementById("port").value = "80";
            } else if (document.getElementById("subType").value == "HTTPS") {
                document.getElementById("description").value = "security url";
                document.getElementById("port").value = "443";
            }
        } else if (monitorType == 'UDP') {
        	if (document.getElementById("subType").value == "DNS") {
        		document.getElementById("description").value = "domain name system";
                document.getElementById("port").value = "53";
            } else if (document.getElementById("subType").value == "DHCP") {
                document.getElementById("description").value = "dynamic host configuration protocol";
            }
            
        }
    }
    ///输监控地址结束的时候同步"检测项目名称"
    function autocaption() {
        document.getElementById("name").value = document
                .getElementById("ip").value;
    }
    ///日检测时段
    function daycheck() {
        var isdaycheck = document.getElementById("isdaycheck");
        if (isdaycheck.checked) {
            document.getElementById("beginHour").disabled = false;
            document.getElementById("endHour").disabled = false;
        } else {
            document.getElementById("beginHour").disabled = true;
            document.getElementById("endHour").disabled = true;
        }
    }
    ///周检测时段
    function weekcheckvalidate() {
        var isweekcheck = document.getElementById("isweekcheck");
        if (isweekcheck.checked) {
            document.getElementById("weekcheck1").disabled = false;
            document.getElementById("weekcheck2").disabled = false;
            document.getElementById("weekcheck3").disabled = false;
            document.getElementById("weekcheck4").disabled = false;
            document.getElementById("weekcheck5").disabled = false;
            document.getElementById("weekcheck6").disabled = false;
            document.getElementById("weekcheck7").disabled = false;
        } else {
            document.getElementById("weekcheck1").disabled = true;
            document.getElementById("weekcheck2").disabled = true;
            document.getElementById("weekcheck3").disabled = true;
            document.getElementById("weekcheck4").disabled = true;
            document.getElementById("weekcheck5").disabled = true;
            document.getElementById("weekcheck6").disabled = true;
            document.getElementById("weekcheck7").disabled = true;
        }
    }
   
    ///表单提交校验
    function check(monitorType) {
        var subType = document.getElementById("subType").value;
        if (subType == null) {
            alert("请选择服务子类型");
            return false;
        }
        subType = subType.replace(/(^\s*)/g, "").replace(/(\s*$)/g, "");
        if (subType.length == 0) {
            alert("请选择服务子类型");
            return false;
        }

        var ip = document.getElementById("ip").value;
        if(subType != "SMTP" && subType != "IMAP" && subType != "POP3"){
        	if (ip == null || ip == "undefined" || ip == "" || ip.length > 50) {
                alert("ip地址必填且不超过50个字符!");
                return false;
            }
        	var exp=/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/; 
        	var reg = ip.match(exp); 
        	if(reg == null){ 
        		   alert("IP地址不合法！");
        		   return false; 
        	}
        }
        var url = document.getElementById("url").value;
        if(subType == "HTTP" || subType == "HTTPS" || subType == "SMTP" || subType == "IMAP" || subType == "POP3"){
        	if (url == null || url == "undefined" || url == "" || url.length > 50) {
                alert("监控地址必填且不超过50个字符!并且类型HTTP的URL必须以http://开头！类型HTTPS的URL必须以https://开头！");
                return false;
            }
        	url = url.replace(/(^\s*)/g, "").replace(/(\s*$)/g, "");
            if (url.length == 0) {
                alert("监控地址必填且不超过50个字符!并且类型HTTP的URL必须以http://开头！类型HTTPS的URL必须以https://开头！");
                return false;
            }
        }

        var port = document.getElementById("port").value;
        if(subType != "ICMP"){
        	if (port == null || port == "undefined" || port == "" || port.length > 20) {
                alert("端口号必填且不超过20个字符!");
                return false;
            }
        	port = port.replace(/(^\s*)/g, "").replace(/(\s*$)/g, "");
            if (port.length == 0) {
                alert("端口号必填且不超过20个字符!");
                return false;
            }
            var check = limitNum(port);
            if (!check) {
                alert("端口输入不合法");
                return false;
            }
        }
        
        var retry = document.getElementById("retry").value;
        if(subType == "ICMP" || subType == "IMAP" || subType == "SMTP" || subType == "POP3"){
        	if(null == retry || retry == "" || retry == "undefined" || retry.length > 20){
                alert("重试次数必填且不超过20个字符");
                return false;
            }
            var retryCheck=limitNum(retry);
            if(!retryCheck){
                alert("重试次数必须为正整数!");
                return false;
            }
        }

        var domainId = document.getElementById("domainId").value;
        if(null == domainId || domainId == "" || domainId == "undefined"){
        	alert("所属域不能为空");
        	return false;
        }
        
        var name = document.getElementById("name").value;
        if (name == null || name == "" || name == "undefined" || name.length > 50) {
            alert("检测项目名称必填且不超过50个字符!");
            return false;
        }
      
        name = name.replace(/(^\s*)/g, "").replace(/(\s*$)/g, "");
        if (name.length == 0) {
            alert("检测项目名称必填且不超过50个字符!");
            return false;
        }

        var description = document.getElementById("description").value;
        if (description == null || description == "" || description == "undefined" || description.length > 100) {
            alert("检测项目描述必填且不超过100个字符!");
            return false;
        }

        description = description.replace(/(^\s*)/g, "").replace(/(\s*$)/g, "");
        if (description.length == 0) {
            alert("检测项目描述必填且不超过100个字符!");
            return false;
        }

        var admonitoryText = document.getElementById("admonitoryText").value;
        if (admonitoryText.length > 100) {
            alert("告警附文不超过100个字符");
            return false;
        }
        
        var begintime = document.getElementById("beginHour").value.split(":")[0];
        var endtime = document.getElementById("endHour").value.split(":")[0];
        if (begintime > endtime) {
            alert("日检测时间段选择不合法");
            return false;
        } else if (begintime == endtime && begintime != 0) {
            alert("日检测时间段选择不合法");
            return false;
        }
        
        var userid = document.getElementById("userid").value;
        var password = document.getElementById("password").value;
        ///var version = document.getElementById("version").value;
        ///var community = document.getElementById("community").value;

        if (userid.length > 50) {
            alert("用户名不超过50个字符");
            return false;
        }
        if (password.length > 100) {
            alert("密码不超过100个字符");
            return false;
        }
        /**
        if (version.length > 20) {
            alert("版本号不超过20个字符");
            return false;
        }
        var versionCheck2=limitNum(version);
        if(!versionCheck2){
            alert("版本号为正整数！");
            return false;
        }
        if (community.length > 50) {
            alert("团体名不超过50个字符");
            return false;
        } **/
        
        if(subType == "FTP"){
            if (userid == null || userid == "" || userid == "undefined" || userid.length > 50) {
                alert("子类型为FTP,用户名必填且不超过50个字符!");
                return false;
            }
            userid = userid.replace(/(^\s*)/g, "").replace(/(\s*$)/g, "");
            if (userid.length == 0) {
                alert("子类型为FTP,用户名必填且不超过50个字符!");
                return false;
            }
            if (password == null || password == "" || password == "undefined" || password.length > 100) {
                alert("子类型为FTP,密码必填且不超过100个字符!");
                return false;
            }
        }
        /** 
        if(subType == "SNMP"){
            if (version == null || version == "" || version == "undefined" || version.length > 20) {
                alert("子类型为SNMP,版本号必填且不超过20个字符!");
                return false;
            }
            var versionCheck=limitNum(version);
            if(!versionCheck){
                alert("子类型为SNMP,版本号必填且为正整数！");
                return false;
            }

            if (community == null || community == "" || community == "undefined" || community.length > 50) {
                alert("子类型为SNMP,团体名必填且不超过50个字符!");
                return false;
            }

            community = community.replace(/(^\s*)/g, "").replace(/(\s*$)/g, "");
            if (community.length == 0) {
                alert("子类型为SNMP,团体名必填且不超过50个字符!");
                return false;
            }
        }**/
        
        var index = document.getElementById("domainId").selectedIndex;
        var newDomainName = document.getElementById("domainId").options[index].id;
        if(null != newDomainName && typeof(newDomainName) != "undefined"){
            document.getElementById("domainName").value =  newDomainName;
        }
        document.forms["monitorSaveOrUpdate"].submit();
    }
</script>
</head>
<body>
<html:form action="/ismp/domain/local/scm/monitorAction.do?method=monitorSaveOrUpdate" styleId="monitorSaveOrUpdate">
    <input type="hidden" name="currPage" id="currPage"    value="${currPage}" />
    <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
    <input type="hidden" name="id" id="id"    value="${monitor.id}" />
    <input type="hidden" name="domainName" id="domainName"  value="" />
    <input type="hidden" name="type" value="${monitorType}"/>
    <table id="data" class="pad1" style="width:775px;height: 550px;" align="center" >
        <tr>
            <td align="left" valign="top" style="width: 50%;">
			      <h2 class="martop8">服务类型</h2>
			      <table style="width: 100%;">
			        <tr>
			        <td style="padding: 0;width: 20%;">
			            <table>
			                <tr><th><a href="javascript:changeMethod('TCP')">TCP</a></th></tr>
			                <tr><th><a href="javascript:changeMethod('WEB')">WEB</a></th></tr>
<!--			                <tr><th><a href="javascript:changeMethod('DB')">DB</a></th></tr>-->
			                <tr><th><a href="javascript:changeMethod('UDP')">UDP</a></th></tr>
			            </table>
			        </td>
			        <td style="padding: 0；width: 80%">
			            <table style="width: 100%;border: 0" >
			                <tr>
<!--			                   <c:if test="${monitorType == 'DB'}">-->
<!--			                        <input type="hidden" name="type" id="type" value="DB" />-->
<!--			                        <td width="110px" rowspan="5" align="left" id="dataServer">-->
<!--			                            <div id="selectList">-->
<!--			                                <select name="subType" id="subType" size="9" style="width: 90px" onclick="auto('${monitorType}')">-->
<!--			                                    <option value="ORALCE" selected="selected">ORACLE</option>-->
<!--			                                    <option value="MYSQL">MYSQL</option>-->
<!--			                                    <option value="DB2">DB2</option>-->
<!--			                                    <option value="SQLSERVER">SQLSERVER</option>-->
<!--			                                </select>-->
<!--			                            </div>-->
<!--			                        </td>-->
<!--			                    </c:if>-->
			
			                    <c:if test="${monitorType == 'TCP'}">
			                        <input type="hidden" name="type" id="type" value="TCP" />
			                        <td width="110px" rowspan="5" align="left" id="tcpServer">
			                            <div id="selectList">
			                                <select name="subType" id="subType" size="7" style="width: 90px" onclick="auto('${monitorType}')">
<!--			                                    <option value="POP3" selected="selected">POP3</option>-->
			                                    <option value="SMTP" selected="selected">SMTP</option>
			                                    <option value="FTP">FTP</option>
			                                    <option value="IMAP">IMAP</option>
<!--			                                    <option value="SSH">SSH</option>-->
<!--			                                    <option value="SNMP">SNMP</option>-->
			                                    <option value="ICMP">ICMP</option>
			                                    <option value="POP3">POP3</option>
			                                </select>
			                            </div>
			                        </td>
			                    </c:if>
			
			                    <c:if test="${monitorType == 'WEB'}">
			                        <input type="hidden" name="type" id="type" value="WEB" />
			                        <td width="110px" rowspan="5" align="left" id="webServer">
			                            <div id="selectList">
			                                <select name="subType" id="subType" size="7" style="width: 90px" onclick="auto('${monitorType}')">
			                                    <option value="HTTP" selected="selected">HTTP</option>
			                                    <option value="HTTPS">HTTPS</option>
			                                </select>
			                            </div>
			                        </td>
			                    </c:if>
			
			                    <c:if test="${monitorType == 'UDP'}">
			                        <input type="hidden" name="type" id="type" value="UDP" />
			                        <td width="110px" rowspan="5" align="left" id="webServer">
			                            <div id="selectList">
			                                <select name="subType" id="subType" size="7" style="width: 90px" onclick="auto('${monitorType}')">
			                                    <option value="DNS" selected="selected">DNS</option>
<!--			                                    <option value="DHCP" >DHCP</option>-->
			                                </select>
			                            </div>
			                        </td>
			                    </c:if>
			                </tr>
			            </table>
			        </td>
                    </tr>
			      </table>
<!--			    </div>-->
            </td>
            <td align="left" valign="top" style="width: 50%;">
			    <h2 class="martop8">检测参数</h2>
			      <table style="width: 100%;">
			              <tr>
<!--			                  <th> 监控地址</th>-->
<!--			                  <td><input type="text"  id="url" name="url" size="20" onkeyup="autocaption()" /></td>-->
			                  <th> IP地址</th>
			                  <td><input type="text"  id="ip" name="ip" size="20" onkeyup="autocaption()" /></td>
			                  <th> 端口 </th>
			                  <td><input type="text"  id="port" name="port" size="20" /></td>
			              </tr>
			              <tr>
			                  <th> 超时时间</th>
			                  <td align="left">
                                <select id="timeout" name="timeout" >
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3" selected="selected">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="15">15</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                    <option value="45">45</option>
                                    <option value="60">60</option>
                                </select>秒
                              </td>
			                  <th> 重试次数 </th>
			                  <td align="left" >
                                <input type="text" id="retry" name="retry" />
                              </td>
			              </tr>

                          <tr>
                            <th>用户名:</th>
                            <td align="left">
                                <input type="text" id="userid" name="userid" size="20" />
                            </td>
                            <th>密码:&nbsp;&nbsp;</th>
                            <td>
                                <input type="password" id="password" name="password" size="20" />
                            </td>
                          </tr>
                          
                          <tr>
                            <th>监控地址:</th>
                            <td align="left">
                                <input type="text" id="url" name="url" size="20" />
                            </td>
                            <th>&nbsp;&nbsp;</th>
                            <td align="left">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                            </td>
                          </tr>
                          
<!--                          <tr>-->
<!--                            <th>版本号:</th>-->
<!--                            <td align="left">-->
<!--                                <input type="text" id="version" name="version" size="20" />-->
<!--                            </td>-->
<!--                            <th>团体名:&nbsp;&nbsp;</th>-->
<!--                            <td>-->
<!--                                <input type="text" id="community" name="community" size="20" />-->
<!--                            </td>-->
<!--                          </tr>-->

		         </table>
<!--			    </div> -->
            </td>
        </tr>
        <tr>
            <td align="left" valign="top" style="width: 50%;">
<!--                <div style="float:left;width:298px; clear:both;padding-right:2px;background-color: green">-->
			       <h2 class="martop8">时间策略</h2>
			       <table style="width: 100%;">
			         <tr>
			           <th > 检测时间间隔 </th>
			           <td colspan="2">
<!--			              <select name="timeSpace" id="connectOutTime">-->
			              <select name="intervalTime" id="intervalTime">
			                 <option value="1">1</option>
			                 <option value="2">2</option>
			                 <option value="3">3</option>
			                 <option value="4">4</option>
			                 <option value="5">5</option>
			                 <option value="6">6</option>
			                 <option value="7">7</option>
			                 <option value="8">8</option>
			                 <option value="9">9</option>
			                 <option value="10">10</option>
			                 <option value="20">20</option>
			                 <option value="30" selected="selected">30</option>
			                 <option value="40">40</option>
			                 <option value="50">50</option>
			                 <option value="60">60</option>
			                 <option value="120">120</option>
			                 <option value="180">180</option>
			                 <option value="240">240</option>
			                 <option value="300">300</option>
			                 <option value="600">600</option>
			              </select>秒
			           </td>
			         </tr>
			         <tr>
			           <th> 日检测时段 </th>
			           <td colspan="2">
                            <input type="checkbox" name="isdaycheck" id="isdaycheck" onclick="daycheck()"></input>
                       </td>
			         </tr>
			         <tr>
                       <th >&nbsp;&nbsp;&nbsp;&nbsp;</th>
			           <td colspan="2">
			              <select name="beginHour" id="beginHour" disabled="true">
			                 <option value="00:00">00:00</option>
			                 <option value="01:00">01:00</option>
			                 <option value="02:00">02:00</option>
			                 <option value="03:00">03:00</option>
			                 <option value="04:00">04:00</option>
			                 <option value="05:00">05:00</option>
			                 <option value="06:00">06:00</option>
			                 <option value="07:00">07:00</option>
			                 <option value="08:00">08:00</option>
			                 <option value="09:00">09:00</option>
			                 <option value="10:00">10:00</option>
			                 <option value="11:00">11:00</option>
			                 <option value="12:00">12:00</option>
			                 <option value="13:00">13:00</option>
			                 <option value="14:00">14:00</option>
			                 <option value="15:00">15:00</option>
			                 <option value="16:00">16:00</option>
			                 <option value="17:00">17:00</option>
			                 <option value="18:00">18:00</option>
			                 <option value="19:00">19:00</option>
			                 <option value="20:00">20:00</option>
			                 <option value="21:00">21:00</option>
			                 <option value="22:00">22:00</option>
			                 <option value="23:00">23:00</option>
			              </select>&nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;
			              <select name="endHour" id="endHour" disabled="true">
			                 <option value="00:00">00:00</option>
			                 <option value="01:00">01:00</option>
			                 <option value="02:00">02:00</option>
			                 <option value="03:00">03:00</option>
			                 <option value="04:00">04:00</option>
			                 <option value="05:00">05:00</option>
			                 <option value="06:00">06:00</option>
			                 <option value="07:00">07:00</option>
			                 <option value="08:00">08:00</option>
			                 <option value="09:00">09:00</option>
			                 <option value="10:00">10:00</option>
			                 <option value="11:00">11:00</option>
			                 <option value="12:00">12:00</option>
			                 <option value="13:00">13:00</option>
			                 <option value="14:00">14:00</option>
			                 <option value="15:00">15:00</option>
			                 <option value="16:00">16:00</option>
			                 <option value="17:00">17:00</option>
			                 <option value="18:00">18:00</option>
			                 <option value="19:00">19:00</option>
			                 <option value="20:00">20:00</option>
			                 <option value="21:00">21:00</option>
			                 <option value="22:00">22:00</option>
			                 <option value="23:00">23:00</option>
			              </select>
			           </td>
			         </tr>
			         <tr>
			           <th> 周检测时段 </th>
			           <td colspan="2">
                           <input type="checkbox"  name="isweekcheck" id="isweekcheck" onclick="weekcheckvalidate()" />
                       </td>
			         </tr>
			         <tr>
			           <th> &nbsp;&nbsp;&nbsp;&nbsp; </th>
			           <td colspan="2">
                         <input type="checkbox" name="weekcheck" id="weekcheck1" value="Mon" disabled="true" />一
                         <input type="checkbox" name="weekcheck" id="weekcheck2" value="Tue" disabled="true" />二
                         <input type="checkbox" name="weekcheck" id="weekcheck3" value="Wed" disabled="true" />三
                         <input type="checkbox" name="weekcheck" id="weekcheck4" value="Thu" disabled="true" />四
                         <input type="checkbox" name="weekcheck" id="weekcheck5" value="Fri" disabled="true" />五
                         <input type="checkbox" name="weekcheck" id="weekcheck6" value="Sat" disabled="true" />六
                         <input type="checkbox" name="weekcheck" id="weekcheck7" value="Sun" disabled="true" />日
                       </td>
			         </tr>
			       </table>
<!--			     </div>-->
            </td>
            <td align="left" valign="top" style="width: 50%;">
<!--                <div style="float:right; width:298px;background-color: aqua">-->
		        <h2 class="martop8"> 告警策略 </h2>
		          <table style="width: 100%;">
		            <tr>
		              <th > 检测连续失败 </th>
		              <td>
		                <select name="checkfailcount" id="checkfailcount">
		                   <option value="1">1</option>
		                   <option value="2">2</option>
		                   <option value="3" selected="selected">3</option>
		                   <option value="4">4</option>
		                   <option value="5">5</option>
		                   <option value="6">6</option>
		                   <option value="7">7</option>
		                   <option value="8">8</option>
		                   <option value="9">9</option>
		                   <option value="10">10</option>
		                   <option value="15">15</option>
		                   <option value="20">20</option>
		                   <option value="30">30</option>
		                   <option value="45">45</option>
		                   <option value="60">60</option>
		                </select>次后告警
		              </td>
		            </tr>
		            <tr>
		              <th> &nbsp;&nbsp;&nbsp;&nbsp; </th>
		              <td> &nbsp;&nbsp;&nbsp;&nbsp; </td>
		            </tr>
		            <tr>
		              <th> 告警优先级 </th>
		              <td>
		                 <select name="eventPriority" id="eventPriority">
		                    <option value="1">1&nbsp;&nbsp;</option>
		                    <option value="2" selected="selected">2</option>
		                    <option value="3">3</option>
		                    <option value="4">4</option>
		                    <option value="5">5</option>
		                 </select>
		              </td>
		            </tr>
                    <tr>
                      <th> &nbsp;&nbsp;&nbsp;&nbsp; </th>
                      <td> &nbsp;&nbsp;&nbsp;&nbsp; </td>
                    </tr>
		            <tr>
		              <th> 所属域 </th>
		              <td>
                        <select name="domainId" id="domainId" class="main" style="width: 220px">
                            <option value="">-请选择-</option>
                            <c:forEach items="${userDomainList }" var="domain">
                            <c:choose>
                                <c:when test="${domain.id == monitor.domain.id }">
                                    <c:set var="domainSelect" value="selected" />
                                </c:when>
                                <c:otherwise>
                                    <c:set var="domainSelect" value="" />
                                </c:otherwise>
                            </c:choose>
                            <option value="${domain.id}" ${domainSelect} id="${domain.domainName}">${domain.domainName }(${domain.id })</option>
                            </c:forEach>
                         </select>
		              </td>
		            </tr>
		            </table>
<!--		        </div>-->
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <h2>&nbsp;&nbsp;&nbsp;&nbsp;</h2>
                <table style="width: 100%;">
		            <tr>
		              <th width="25%"> 检测项目名称 </th>
		              <td width="25%"><input type="text" id="name" name="name" ></input></td>
		              <th width="25%"> 检测项目描述 </th>
		              <td width="25%">
	                    <c:if test="${monitorType == 'DB'}">
	                        <input type="text" id="description" name="description"  
	                               value="Oracle DataBase 监控"></input>
	                    </c:if>

	                    <c:if test="${monitorType == 'WEB'}">
	                        <input type="text" id="description" name="description" 
	                               value="hyperText transfer protocol"></input>
	                    </c:if>

	                    <c:if test="${monitorType == 'TCP'}">
	                        <input type="text" id="description" name="description" 
	                               value="post office protocol v3"></input>
	                    </c:if>
 
	                    <c:if test="${monitorType == 'ICMP'}">
	                        <input type="text" id="description" name="description" 
	                               value=""></input>
	                    </c:if>

	                    <c:if test="${monitorType == 'UDP'}">
	                        <input type="text" id="description" name="description" 
	                               value="domain name system"></input>
	                    </c:if>
		              </td>
		            </tr>

		            <tr>
		              <th> 告警附文 </th>
		              <td><input type="text" id="admonitoryText" name="admonitoryText" /></td>
<!--		              <th> 服务类别 </th>-->
		              <th> </th>
<!--		              <td><input type="text" id="serviceType" name="serviceType" /></td>-->
		              <td></td>
		            </tr>
		        </table>    
            </td>
       </tr>
        
       <tr>
           <td colspan="2" align="center">&nbsp;&nbsp;&nbsp;&nbsp;</td>  
       </tr> 
       <tr>
           <td colspan="2" align="center">
                <input type="button" value="提交" onclick="check('${monitorType}')" style="width: 50px; height: 25px;" />
                <input type="reset" name="reset" value="重置" style="width: 50px; height: 25px;" />
           </td>  
       </tr> 
    </table>
</html:form>
</body>
</html>        
    
