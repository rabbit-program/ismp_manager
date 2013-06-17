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
<link rel="stylesheet" href="${ctx}/css/VPM/pm/pmUpdate.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/date/skin/WdatePicker.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/jquery.boxy.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/js/floatdiv.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/jquery.simple.tree.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/patchUpdate.js"></script>
<script type="text/javascript" src="${ctx}/js/VPM/PM/comm.js"></script>
</head>
<body>
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="nor" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('vm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/virus.gif) no-repeat; padding-left:22px;">病毒管理</span></a></li>
    <li class="act" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('pm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">补丁管理</span></a></li>
    <li class="nor"><a href="javascript:void(0)" onclick="javascript:to_url('sd','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">软件分发</span></a></li>
   </div>
  <div class="contant">
    <div class="overf h20 martop10">
      <li id="m"><a  class="mback" href="${ctx}/ismp/domain/local/vpm/pm/pmAction.do"><span class="menus10"> WinSensor资产映射</span></a></li>
      <li><a  class="mbacka" href="${ctx}/ismp/domain/local/vpm/pm/pmUpdateAction.do"><span class="menus11">补丁更新</span></a></li>
    </div>
    <div class="greenborder pad1 overf">
      <table width="100%">
        <tr>
          <td width="180" valign="top">
         <div id="tree1" class="greenborder greenback overf pad3" style="width:180px;height:410px; min-height:200px; overflow:auto; float:none;"> 
               <ul class="simpleTree">
                    <li class="root" id='1'>
                      <a href="javascript:allto()" style="background:none; text-align:left;">单位分布</a>
                        <ul class="ajax">
                            <li id='3'>
                              {url:${ctx}/ismp/domain/local/vpm/pm/doManinTree.do?method=getDoMain}
                            </li>
                        </ul>
                    </li>
                </ul>
         </div>
         </td>
           <td valign="top"><div class="greenborder overf pad1 Height_a" style="margin-left:2px; padding:2px;"><a href="${ctx}/ismp/domain/local/vpm/pm/pmUpdateAction.do" target="mainContant" class="R6 R7">补丁策略</a><a href="${ctx}/ismp/domain/local/vpm/pm/statisticsIndexAction.do" target="mainContant" class="R6 R7">补丁统计</a><a href="${ctx}/ismp/domain/local/vpm/pm/tacticsIndex.do" target="mainContant" class="R6 R7">策略配置</a> </div>
            <h2 class="martop10">请选择查询条件</h2>
            <div class="greenborder greenback overf pad3 Height_a" id="seachdiv"> <span style="float:left;"> 策略最后变更时间(起)：
              <input type="text" size="8" id="createStartDate" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
              策略最后变更时间(末)：
              <input type="text" size="8" id="createEndDate" class="input" readonly="readonly" onclick="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
              </span> <a href="javascript:void(0)" name="seachTime" class="R6" style="margin-left:12px;">搜索</a><a href="javascript:void(0)" class="R6" name="resetdate" style="margin-left:12px;">重置</a> </div>
            <h2 class="martop10">查看列表</h2>
            <div id="data" class="greenborder overf pad1" >
              <form name="f1" id="f1" action="" method="post">
                <table id="senfe" sortcol="-1">
                  <thead>
                    <tr>
                      <th><input class="noneborder" type="checkbox" name="checkall1" id="checkall1" />
                      </th>
                      <th style="cursor:pointer" onclick="sortTable('senfe',0);"> sensorID <span class="webdings">6</span></th>
                      <th> 客户端名称</th>
                      <th> 是否自动更新 </th>
                      <th>更新时间</th>
                      <th> 策略最后变更时间 </th>
                      <th>操作</th>
                    </tr>
                  </thead>
                  <tbody>
                  </tbody>
                </table>
              </form>
            </div>
            <ul id="page" class="martop10">
              <li><a href="javascript:void(0)"  id="checkall1but" class="R6">全选</a></li>
              <li><a href="javascript:void(0)" class="R6">重置</a></li>
              <li><a href="javascript:void(0)" id="tacitcsa" class="R6 R7" style="margin-right:12px;">策略定制</a></li>
              <li><a class="first" href="javascript:void(0)"></a></li>
              <li><a class="pre" href="javascript:void(0)"></a></li>
              <li><a class="next" href="javascript:void(0)"></a></li>
              <li><a class="last" href="javascript:void(0)"></a></li>
              <li>共 <span id="pageSize"></span> 页 跳至
                <input type="text" id="tpageCount" size="2" class="input"/> 

                &nbsp; </li>
              <li><a class="R6" id="pageGo" href="javascript:void(0)">GO</a></li>
            </ul></td>
        </tr>
      </table>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>
