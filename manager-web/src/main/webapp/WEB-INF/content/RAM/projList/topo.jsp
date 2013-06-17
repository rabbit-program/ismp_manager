<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<script type="text/javascript" language="javascript">
function nextStep() {
    var cpKind = document.getElementById("cpKind").value;
    var projId = document.getElementById("projId").value;
    if(cpKind!='cp2') {
        window.location.href="${ctx}/ismp/domain/local/ram/papeManager.do?method=prePaperDesign&projId="+projId;
    }else{
        window.location.href="${ctx}/ismp/domain/local/ram/leakScanManager.do?method=showLeakScan&projId="+projId;
    }
}
</script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="act" id="m"><a href="#"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">风险评估</span></a></li>
  </div>
  <div class="contant pad3 overf">
    <div class="overf pad3  martop10" >
      <table width="100%">
        <tr>
          <td><img src="${ctx}/img/RAM/danger_banner_01.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_02.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_03.gif" /></td>
          <td><img src="${ctx}/img/RAM/daner_bannera_04.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_05.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_06.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_07.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_08.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_09.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_10.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_11.gif" /></td>
          <td><img src="${ctx}/img/RAM/danger_banner_12.gif" /></td>
        </tr>
      </table>
    </div>
    <h2 >拓扑信息展示</h2>
    <div id="data" class="greenborder" style="min-height:200px;">
      <div class="greenback pad3" style="height:26px;">
        <p style="padding-top:2px;"><a href="#" class="R6">进入</a></p>
      </div>
      这里是拓扑展示内容。 </div>
      <input type="hidden" id="cpKind"  name="cpKind" value="${asseInfoProj.cpKind}" />
      <input type="hidden" id="projId" name="projId" value="${asseInfoProj.id}" />
   <div style="margin:0 auto; padding-top:12px; width:120px; height:30px; clear:both;"><a href="javascript:nextStep();" class="R6">下一步</a></div>
  </div>
</div>
</body>
</html>

