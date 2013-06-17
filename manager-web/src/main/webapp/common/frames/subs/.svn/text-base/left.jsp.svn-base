<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <%@ include file="/common/meta.jsp" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
        <link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
        <link href="${ctx}/css/comm/other/Menu.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			funA = function(element){
				var nClass=new Array("li","li","li","li","","li","li","li","li","","li","li","li","li","","li","li","li","li");
				var aClass=new Array("ok","ok","ok","ok","li","ok","ok","ok","ok","","ok","ok","ok","ok","","ok","ok","ok","ok");
				var objUl = document.getElementById("SearchT").children[0];
				for(var i = 0; i < objUl.children.length; i++){
				    objUl.children[i].children[0].className = nClass[i];
				}
				var begin = element.name.indexOf("a");
				var index = element.name.substr(begin + 1, (element.name.length-begin+1));
				element.className = aClass[index];
			}
		</script>
	</head>
	<body class="menubg">
		<div class="menu">
			<div id="SearchT">
				<ul>
					<li><a href="${ctx}/applet/topo/topomanager.jsp" name="a0" onclick="funA(this)" class="li" target="mainContant"><span class="tp">拓扑管理</span></a></li>
					<li><a href="${ctx}/ismp/domain/local/am/fwdPage.do?index=1" name="a1" onclick="funA(this)" class="li" target="mainContant"><span class="zc">资产管理</span></a></li>
					<li><a href="${ctx}/ismp/domain/local/oss/clientQuestion.do?method=showQuestion<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>" name="a2" onclick="funA(this)" class="li" target="mainContant"><span class="yw">运维支撑</span></a></li>
					<li><a href="${ctx}/ismp/domain/local/gosp/findLawRules.do<sec:authorize ifAllGranted='ROLE_AdminAll'>?isAll=1</sec:authorize>" name="a3" onclick="funA(this)" class="li" target="mainContant"><span class="bh">等级保护</span></a></li>
					<li style="margin:6px 0 0 -4px"><img src="${ctx}/img/comm/other/cut01.PNG" /></li>
					<li><a href="${ctx}/ismp/domain/local/vpm/vm/vmAction.do" name="a5" onclick="funA(this)" class="li" target="mainContant"><span class="vp">病毒补丁</span></a></li>
                    <li><a href="${ctx}/ismp/domain/local/scm/monitorAction.do?method=getMonitorList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>" name="a6" onclick="funA(this)" class="li" target="mainContant"><span class="server">服务检测</span></a></li>
					<li><a href="${ctx }/eventAction.do?method=showListByTag" name="a7" onclick="funA(this)" class="li" target="mainContant"><span class="event">事件管理</span></a></li>
<!--                <li><a href="${ctx}/ismp/domain/local/bsam/situationAction.do<sec:authorize ifAllGranted='ROLE_AdminAll'>?isAll=1</sec:authorize>" name="a8" onclick="funA(this)" class="li" target="mainContant"><span class="ts">态势感知</span></a></li>-->
					<li><a href="${ctx}/ismp/domain/local/bsam/situationAction.do?method=getSecurityAreaSituationList<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>" name="a8" onclick="funA(this)" class="li" target="mainContant"><span class="ts">态势感知</span></a></li>
					<li style="margin:6px 0 0 -4px"><img src="${ctx}/img/comm/other/cut01.PNG" /></li>
					<li><a href="${ctx}/ismp/domain/local/ram/projManager.do?method=showProject<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>" name="a10" onclick="funA(this)" class="li" target="mainContant"><span class="danger">风险评估</span></a></li>
					<li><a href="${ctx}/ismp/domain/local/erm/respShow.do<sec:authorize ifAllGranted='ROLE_AdminAll'>?isAll=1</sec:authorize>" name="a11" onclick="funA(this)" class="li" target="mainContant"><span class="alarm">应急响应</span></a></li>      
					<li><a href="${ctx}/ismp/lm/dlog/sysLogAction.do?method=originalDisplay" name="a12" onclick="funA(this)" class="li" target="mainContant"><span class="dairy">日志审计</span></a></li>
					<li><a href="${ctx}/ismp/domain/local/aim/alert.do?method=getListAlertType&home=1" name="a13" onclick="funA(this)" class="li" target="mainContant"><span class="bell">告警管理</span></a></li>
					<li style="margin:6px 0 0 -4px"><img src="${ctx}/img/comm/other/cut01.PNG" /></li>
                    <li><a href="${ctx}/ismp/domain/local/wsm/webMonitor.do?method=showWebMonitor<sec:authorize ifAllGranted='ROLE_AdminAll'>&isAll=1</sec:authorize>" name="a15" onclick="funA(this)" class="li" target="mainContant"><span class="aqjc">网站安全监测</span></a></li>
                    <li><a href="${ctx}/ismp/sysm/other/appSysInfo.do?method=getAppSysInfo" name="a16" onclick="funA(this)" class="li" target="mainContant"><span class="yyqx">应用系统权限管理</span></a></li>
					<li><a href="${ctx}/ismp/domain/local/userConfig.do?method=forward&main=1" name="a15" onclick="funA(this)" class="li" target="mainContant"><span class="system">系统管理</span></a></li>
					<li><a href="${ctx}/j_spring_security_logout" name="a16" onclick="funA(this)" class="li" target="_top"><span class="exit">安全退出</span></a></li>
                </ul>
			</div>
		</div>
	</body>
</html>