<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<div id="contant" class="mainbg">
  <div class="contant">
    <h2>应用内容详细内容</h2>
    <div class="greenborder greenback overf pad3 " >
       <div class=" greenback overf pad3" style="width:610px">详细内容详细内容详细内容详细内容详细内容详细内容详</div>  
       <div class=" greenback overf pad3" >
         <input class="submit80" type="submit" id="DesignatedAuthority" name="测试2" value="指定权限" />
         <input class="submit" type="button" id="editAuthority" value="编辑" />
       </div>
    </div>
    <h2 class="martop8">分配记录</h2>
    <div id="data" class="greenborder overf pad1 " >
      <form name="f1" id="f1" action="" method="post">
        <table id="senfe" sortcol="-1">
          <thead>
            <tr>
              <th width="22%" style="cursor:pointer" onclick="sortTable('senfe',0);">用户名</th>
              <th width="18%" style="cursor:pointer" onclick="sortTable('senfe',0);">权限</th>
              <th width="20%" style="cursor:pointer" onclick="sortTable('senfe',0);">时间</th>
              <th width="13%">操作人</th>
              <th width="12%">操作</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>某某某</td>
              <td class="tdnowrap"><a href="#">删除</a>| <a href="@">修改</a></td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
   <div class="Height_t">
        <ul id="page" class="martop10">
             <li style="margin-right: 12px;"><a href="javascript:void(0)"  id="addsucrity" class="R6">添加</a></li>
             <li><a class="first" href="javascript:void(0)"></a></li>
             <li><a class="pre" href="javascript:void(0)" title=""></a></li>
             <li><a class="next" href="javascript:void(0)"></a></li>
             <li><a class="last" href="javascript:void(0)"></a></li>
             <li>共 <span id="pageSize"></span> 页 跳至
               <input type="text" id="tpageCount" size="2" class="input"/> &nbsp; </li>
             <li><a class="R6" href="javascript:void(0)" id="pageGo">GO</a></li>
        </ul> 
</div>
  </div>
</div>