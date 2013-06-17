<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<script type="text/javascript" src="${ctx}/js/VPM/VM/virusClients.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/comm.js"></script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="act" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('vm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/virus.gif) no-repeat; padding-left:22px;">病毒管理</span></a></li>
    <li class="nor" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('pm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">补丁管理</span></a></li>
    <li class="nor"><a href="javascript:void(0)" onclick="javascript:to_url('sd','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">软件分发</span></a></li>
  </div>
  <div class="contant">
    <div class="overf h20 martop10">
      <li id="m"><a  class="mbacka" href="${ctx}/ismp/domain/local/vpm/vm/vmAction.do"><span class="menus10"> 客户端管理</span></a></li>
      <li><a  class="mback" href="${ctx}/ismp/domain/local/vpm/vm/virusInfo.do"><span class="menus11">病毒管理</span></a></li>
    </div>
    <div class="greenborder pad3 overf">
    <h2 class="martop10">请选择查询条件</h2>
    <form name="searchForm" id="searchForm" action="${ctx}/ismp/domain/local/vpm/vm/virusMappedAction.do?method=getVirusClientsAll" method="post">
    <div class="greenborder greenback overf pad3 Height_a" >
      <span style="float:left;">客户端名称<input name="vc.name" type="text" size="8" class="input"/> 客户端编号<input type="text" name="vc.clientID" size="8" class="input"/> 客户端IP<input type="text"  name="vc.clientIP" size="8" class="input"/> 创建时间(起始)<input type="text" size="8" name="csd"  class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 创建时间(最末)<input type="text" name="ced"  size="8" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></span> <a href="javascript:void(0)" onClick="vc.pageAjax(1)" class="R6" style="margin-left:12px;">搜索</a><a href="javascript:void(0)" class="R6" onclick="vc.formReset()" style="margin-left:12px;">重置</a>
    </div>
    </form>
      <h2 class="martop10">客户端列表</h2>
      <div id="data" class="greenborder overf pad1" >
        <form name="f1" id="f1" action="" method="post">
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th style="cursor:pointer" onclick="sortTable('senfe',0);"> 客户端IP <span class="webdings">6</span></th>
                <th> 客户端名称</th>
                <th> 客户端编号 </th>
                <th> 资产编号 </th>
                <th> 部门名称 </th>
                <th> 录入时间 </th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
        </form>
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
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
