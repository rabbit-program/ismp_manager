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
<script type="text/javascript" src="${ctx}/js/VPM/PM/comm.js"></script>
</head>
<body >
<div id="contant" class="mainbg">
  <div id="banner" class="grayline overf bannerH" >
    <li class="nor" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('vm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/virus.gif) no-repeat; padding-left:22px;">病毒管理</span></a></li>
    <li class="nor" id="m"><a href="javascript:void(0)" onclick="javascript:to_url('pm','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/01.gif) no-repeat; padding-left:22px;">补丁管理</span></a></li>
    <li class="act"><a href="javascript:void(0)" onclick="javascript:to_url('sd','${ctx}',this);return true;"><span style="background:url(${ctx}/img/comm/other/03.gif) no-repeat; padding-left:22px;">软件分发</span></a></li>
   </div>
  <div class="contant">
    <div class="greenborder pad3 overf">
      <h2 class="martop10">查看方式</h2>
      <div class="greenborder greenback overf pad3 Height_a" > <a href="#" class="R6 R7">本地目录</a><a href="#" class="R6 R7" style="margin-left:12px;">远程目录</a><a href="#" class="R6 R7" style="margin-left:12px;">分发记录</a> </div>
      <h2 class="martop10">条件查询</h2>
      <div id="search" class="greenborder greenback overf pad1" >
        <table>
          <tr>
            <th>软件名称</th>
            <td><input type="text" size="12" class="input"/></td>
            <th>软件上传起始时间</th>
            <td><input type="text" size="12" class="input"/>
              -
              <input type="text" size="12" class="input"/></td>
            <th>执行策略</th>
            <td><select>
                <option>All Item</option>
              </select></td>
          </tr>
          <tr>
            <th>软件类型</th>
            <td><select>
                <option>All Item</option>
              </select></td>
            <th>软件分发起始日期</th>
            <td><input type="text" size="12" class="input"/>
              -
              <input type="text" size="12" class="input"/></td>
            <th>验证策略</th>
            <td><select>
                <option>All Item</option>
              </select></td>
          </tr>
          <tr>
            <th>软件类别</th>
            <td><select>
                <option>All Item</option>
              </select></td>
            <th>分发状态</th>
            <td><select>
                <option>All Item</option>
              </select></td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
      </div>
      <a href="#" class="R6 martop8">查询</a>
      <div class="paddiv"></div>
      <h2>软件分发列表</h2>
      <div id="data" class="greenborder overf pad1" >
        <form name="f1" id="f1" action="" method="post">
          <table id="senfe" sortcol="-1">
            <thead>
              <tr>
                <th><input class="noneborder" type="checkbox" name="checkbox" id="checkbox" />
                  全选</th>
                <th> 分发软件名 </th>
                <th> 大小(字节) </th>
                <th> 类别 </th>
                <th> 分发策略 </th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td><input class="noneborder" type="checkbox" name="checkbox" id="checkbox" /></td>
                <td><a href="#" onclick="Boxy.load('pm_pop04.html');"><span style="float:left">windows patch3.0.22.09</span></a></td>
                <td><span style="float:left">F9FnVZGYZnbZS9XXD3p1..</span></td>
                <td><span style="float:left">产品市场销售部</span></td>
                <td> 2010-12-12 </td>
                <td><a href="#" onclick="Boxy.load('pm_pop05.html');" class="R6">修改</a></td>
              </tr>
              <tr>
                <td><input class="noneborder" type="checkbox" name="checkbox" id="checkbox" /></td>
                <td><span style="float:left">windows patch3.0.22.09</span></td>
                <td><span style="float:left">F9FnVZGYZnbZS9XXD3p1..</span></td>
                <td><span style="float:left">产品市场销售部</span></td>
                <td> 2010-12-11 </td>
                <td><a href="#" class="R6">修改</a></td>
              </tr>
              <tr>
                <td><input class="noneborder" type="checkbox" name="checkbox" id="checkbox" /></td>
                <td><span style="float:left">windows patch3.0.22.09</span></td>
                <td><span style="float:left">F9FnVZGYZnbZS9XXD3p1..</span></td>
                <td><span style="float:left">产品市场销售部</span></td>
                <td> 2010-02-12 </td>
                <td><a href="#" class="R6">修改</a></td>
              </tr>
              <tr>
                <td><input class="noneborder" type="checkbox" name="checkbox" id="checkbox" /></td>
                <td><span style="float:left">192.168.9.120</span></td>
                <td><span style="float:left">F9FnVZGYZnbZS9XXD3p1..</span></td>
                <td><span style="float:left">产品市场销售部</span></td>
                <td> 2001-12-12 </td>
                <td><a href="#" class="R6">修改</a></td>
              </tr>
              <tr>
                <td><input class="noneborder" type="checkbox" name="checkbox" id="checkbox" /></td>
                <td><span style="float:left">192.168.9.120</span></td>
                <td><span style="float:left">F9FnVZGYZnbZS9XXD3p1..</span></td>
                <td><span style="float:left">产品市场销售部</span></td>
                <td> 2010-12-12 </td>
                <td><a href="#" class="R6">修改</a></td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
      <ul id="page" class="martop8">
        <li><a href="#" class="R6">添加</a></li>
        <li style="margin-right:18px;"><a href="#" class="R6">删除</a></li>
        <li><a class="first" href="#"></a></li>
        <li><a class="pre" href="#"></a></li>
        <li><a class="next" href="#"></a></li>
        <li><a class="last" href="#"></a></li>
        <li>共 5 页 跳至
          <input type="text" size="2" class="input"/>
          &nbsp; </li>
        <li><a class="R6" href="#">GO</a></li>
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
