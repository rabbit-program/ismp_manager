<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<div id="contant" class="mainbg">
  <div class="contant">
    <h2 >添加信息</h2>
      <div id="data" class="greenborder overf pad1" >
        <form method="post" name="upasiform" id="upasiform">
          <table id="senfe" sortcol="-1">
            <tbody>
              <tr>
                 <th width="18%" style="cursor:pointer">名称</th>
                <td colspan="6">
                <input type="text" name="asi.name" id="textfieldName" /></td>
              </tr>
              <tr>
                <th width="18%" style="cursor:pointer">描述</th>
                <td colspan="6"><textarea name="asi.desc" cols="100%" rows="3" id="textfieldDesc"/></td>
              </tr>
              <tr>
              <th width="18%" style="cursor:pointer">委办局</th>
                <td><select id="doselect" name="domainId"></select></td>
              </tr>
              <tr>
              </tr>
            </tbody>
          </table>
        </form>
    </div>
    <div class="martop8 Height_t">
    <ul id="page">
        <li><a href="javascript:void(0)"  class="R6 R7 boxy" id="yadd">更新</a></li>
        <li><a href="javascript:void(0)" class="R6 R7 boxy" id="cz">返回</a></li>
     </ul>
    <br />
  </div>
</div>
</div>