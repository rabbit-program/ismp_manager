<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">    
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/date/skin/WdatePicker.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/jquery.form.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/winSensor.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/comm.js"></script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="nor" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('vm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/virus.gif) no-repeat; padding-left:22px;">病毒管理</span></a></li>
    <li class="act" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('pm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">补丁管理</span></a></li>
    <li class="nor"><a href="javascript:void(0)" onclick="javascript:to_url('sd','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">软件分发</span></a></li>
  </div>
  <div class="contant" >
    <div class="overf h20 martop10">
      <li id="m"><a class="mbacka" href="${ctx}/ismp/domain/local/vpm/pm/pmAction.do"><span class="menus10"> WinSensor资产映射</span></a></li>
      <li><a class="mback" href="${ctx}/ismp/domain/local/vpm/pm/pmUpdateAction.do" target="mainContant"><span class="menus11">补丁更新</span></a></li>
    </div>  
       <input type="hidden" id="qxid" value="<sec:authorize ifAllGranted='ROLE_AdminAll'>1</sec:authorize>"/>
    <div class="greenborder pad3 overf">
    <h2 class="martop10">请选择查询条件</h2>
    <form name="searchForm" id="searchForm" action="${ctx}/ismp/domain/local/vpm/pm/patchAction.do?method=getWinSensorAssetInfo&isAll=<sec:authorize ifAllGranted='ROLE_AdminAll'>1</sec:authorize>" method="post">
    <div class="greenborder greenback overf pad3 Height_a" >
      <span style="float:left;">客户端名称<input type="text" size="8" name="s.name" class="input"/> sensorIP<input type="text" size="8" name="s.sensorIP" class="input"/>
                创建时间(起始)<input type="text" size="8" id="startTime" name="createStartDatePage" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
                创建时间(最末)<input type="text" size="8" id="endTime" name="createEndDatePage" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></span> 
                <a href="javascript:void(0)"  onClick="sh.pageAjax(1)" class="R6" style="margin-left:12px;">
                搜索</a><a href="javascript:void(0)" onclick="sh.formReset()" class="R6" style="margin-left:12px;">重置</a>
    </form>
    </div>
      <h2 class="martop10">资产映射列表</h2>
      <div id="data" class="greenborder overf pad1" >
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> sensorIP <span class="webdings">6</span></th>
                <th> 客户端名称</th>
                <th> 所关联资产 </th>
                <th> 所属委办局 </th>
                <th> 关联时间 </th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
      </div>
      <div class="paddiv">This is for verticl spacing</div>
      <ul id="page">
              <li><a class="first" href="javascript:void(0)"></a></li>
              <li><a class="pre" href="javascript:void(0)"></a></li>
              <li><a class="next" href="javascript:void(0)"></a></li>
              <li><a class="last" href="javascript:void(0)"></a></li>
              <li>共 <span id="pageSize"></span> 页 跳至
                <input type="text" id="tpageCount" size="2" class="input"/> &nbsp; </li>
              <li><a class="R6" id="pageGo" href="javascript:void(0)">GO</a></li>
      </ul>
      <br />
      <br />
      <br />
    </div>
  </div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
