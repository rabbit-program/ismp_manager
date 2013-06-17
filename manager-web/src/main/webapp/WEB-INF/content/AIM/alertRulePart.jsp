<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>告警规则详细内容</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript">
    function splitTargets(targets,targetsId){
        var ts=targets.split(";");
        var tss;
        for(var i=0;i<ts.length;i++){
            if(i==0){
                if(ts[i]!=''){
                  tss=(i+1)+":"+ts[i];
                }else{
                    tss="空";  
                }
            }else{
                tss=tss+"<br>"+(i+1)+":"+ts[i];
            }
            document.getElementById(targetsId).innerHTML=tss;
        }
    }
</script>
</head>

<body >

<div id="data" class="pad1 ">
<c:if test="${alertRulebo!=null}">
      <table>
        <tr class="graytr">
          <th ><div align="center">事&nbsp;&nbsp;件&nbsp;优&nbsp;先&nbsp;&nbsp;级:</div></th>
          <td >${alertRulebo.priority }</td>
          <th ><div align="center">类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型:</div></th>
          <td >${alertRulebo.type }</td>
        </tr>
        <tr>
          <th><div align="center">子&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型:</div></th>
          <td >${alertRulebo.subType }</td>
          <th ><div align="center">规则&nbsp;是否&nbsp;启用:</div></th>
          <td ><c:if test="${alertRulebo.enabled==1}"> 启用 </c:if>
              <c:if test="${alertRulebo.enabled==0}"> 禁用 </c:if></td>
        </tr>
        <tr class="graytr">
          <th ><div align="center">启用桌面消息告警:</div></th>
          <td ><c:if test="${alertRulebo.sendMsg==1}"> 是 </c:if>
              <c:if test="${alertRulebo.sendMsg==0}"> 否 </c:if></td>
          <th ><div align="center">桌&nbsp;面&nbsp;IP&nbsp;地&nbsp;址:</div></th>
          <td >
            <script type="text/javascript">splitTargets('${alertRulebo.msgTarget}','msgTargetId')</script>          </td>
        </tr>
        <tr>
          <th><div align="center">启用&nbsp;Email&nbsp;告警:</div></th>
          <td><c:if test="${ alertRulebo.sendEmail==1}">是</c:if>
              <c:if test="${ alertRulebo.sendEmail==0}">否</c:if></td>
          <th ><div align="center">Email&nbsp;告警地址:</div></th>
          <td >
            <script type="text/javascript">splitTargets('${alertRulebo.emailTarget}','emailTargetId')</script>          </td>
        </tr>
        <tr class="graytr">
          <th><div align="center">启用&nbsp;短消&nbsp;息告警:</div></th>
          <td ><c:if test="${ alertRulebo.sendSms==1}">是</c:if>
              <c:if test="${ alertRulebo.sendSms==0}">否</c:if></td>
          <th><div align="center">短&nbsp;消&nbsp;息&nbsp;号&nbsp;码:</div></th>
          <td>
            <script type="text/javascript">splitTargets('${alertRulebo.smsTarget}','smsTargetId')</script>          </td>
        </tr>
        <c:if test="${department != null}">
        <tr class="graytr">
          <th><div align="center">规则所属部门：</div></th>
          <td colspan="3">${department.managerName }</td>
          
       
          <td ></td>
        </tr>
        </c:if>
      </table>
</c:if>
<c:if test="${alertRulebo==null}">
    <p align="center"><font class="red">  没有触发告警规则！</font></p>
</c:if>
</div>
</body>
</html>