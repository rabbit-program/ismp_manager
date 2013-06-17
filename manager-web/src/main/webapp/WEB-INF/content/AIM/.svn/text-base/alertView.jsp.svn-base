<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/taglibs.jsp"%>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript">
   function doClose(){
	   window.top.opener.flushBySelf();
	   window.top.close();
   }
</script>
</head>
<body >
<div id="contant">
<div id="main">
<html:form action="/ismp/domain/local/aim/alertRule.do"  target="alertToRuleFrame">
    <input type="hidden" value="getAlertRules" name="method">
    <input type="hidden" name="alertRuleId" value="${alertInfobo.rule}">
     <div  id="data" class="pad1 ">
       <h2 class="martop10">告警详细信息 </h2>
       <div class="pad3 overf" >
        <table>
            <tr class="graytr">
                <th>
                <div align="center">告警时间:</div>             </th>
                <td><bean:write property="time" name="alertInfobo"
                    format="yyyy年MM月dd日  HH:mm:ss" /></td>
                <th>
                <div align="center">优&nbsp;&nbsp;先&nbsp;&nbsp;级:</div>              </th>
                <td>${alertInfobo.level }</td>
            </tr>
            <tr>
                <th>
                <div align="center">告警类型:</div>             </th>
                <td>${alertInfobo.alertType }</td>
                <th>
                <div align="center">子&nbsp;&nbsp;类&nbsp;&nbsp;型:</div>              </th>
                <td>${alertInfobo.alertSubType }</td>
            </tr>
            <tr class="graytr">
                <th>
                <div align="center">节&nbsp;&nbsp;点&nbsp;&nbsp;ID:</div>             </th>
                <td>${ alertInfobo.nodeid}</td>
                <th>
                <div align="center">告&nbsp;&nbsp;警&nbsp;&nbsp;源:</div>              </th>
                <td>${alertInfobo.srcIP}</td>
            </tr>
            <tr>
                <th>
                <div align="center">告警原因:</div>             </th>
                <td>${ alertInfobo.alertReason}</td>
                <th>
                <div align="center">告警状态:</div>             </th>
                <td><c:if test="${ alertInfobo.status==1}"> 未读 </c:if> <c:if
                    test="${ alertInfobo.status==0}"> 已读 </c:if></td>
            </tr>

            <tr class="graytr">
                <th>
                <div align="center">事件描述:</div>             </th>
                <td width="35%">${alertInfobo.rawContent}</td>
                <th>
                <div align="center">告警类别:</div>             </th>
                <td>${alertInfobo.type}</td>
            </tr>
            <tr>
                <th>
                <div align="center">归并次数:</div>             </th>
                <td>&nbsp;${fusionCount}</td>
                <th>
                <div align="center">归并时间:</div>             </th>
                <td>
                <logic:notEmpty name="fustionTimeAll">
                    <logic:iterate indexId="i" id="ft" name="fustionTimeAll">
                                                ${i+1 }:${ft }<br>
                    </logic:iterate>
                </logic:notEmpty>
                <logic:empty name="fustionTimeAll">
                                                  没发生归并                </logic:empty>              </td>
            </tr>
            <tr class="graytr">
                <th>
                <div align="center">告警所属部门:</div>             </th>
                <td width="35%">${domain.domainName}</td>
                <td>
                <div align="center"></div></td>
                <td></td>
            </tr>
        </table>
    </div>
     </div>
     <h2 class="martop10">触发规则列表 </h2>
     <div  id="data" class="pad3 overf ">
     <logic:notEmpty name="alertruleList">
     	<table>
     		<thead>
     			<tr>
     			<th>规则号 </th>
                <th>优先级条件</th>
                <th>类型条件</th>
                <th>子类型条件</th>
                <th>桌面消息告警</th>
                <th>Email消息告警</th>
                <th>短信告警</th>
     			</tr>
     		</thead>
     		<tbody>
     		
     			<logic:iterate id="alertrule" name="alertruleList" indexId="index">
              <tr>
                <td> <div align="center">${alertrule.id }</div> </td>
                <td><div align="center">${alertrule.priority } </div> </td>
                <td><div align="center">${alertrule.type }</div></td>
                <td><div align="center">${alertrule.subType }</div></td>
                <td><div align="center">${alertrule.msgTarget }</div></td>
                <td><div align="center">${alertrule.emailTarget}</div></td>
                <td><div align="center">${alertrule.smsTarget }</div></td>
              </tr>
             </logic:iterate>
     		</tbody>
     	</table>
     	</logic:notEmpty>
     	<logic:empty name="alertruleList">
     		<div align="center"><h1>没有触发规则</h1></div>
     	</logic:empty>
     </div>
</html:form>
</div>
</div>
</body>
</html>