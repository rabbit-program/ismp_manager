<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<div id="data" class="pad1 ">
<h2>投诉信息</h2>
<form action="${ctx}/ismp/oss/pm/dsinfo.do?method=addOrUpdateDomainToComplaint" id="complaintFrom" method="post">
  <table>
    <tr>
      <th> 委办局</th>
      <td> <input type="hidden"" name="domain" id="domain"> <input type="hidden"" name="complaint.id" id="complaint"></td>
    </tr>
    <tr>
      <th> 投诉电话</th>
      <td><input type="text" id="phone" name="complaint.complaintPhone"/></td>
    </tr>
    <tr>
      <th> 投诉类型</th>
      <td> <input type="text" id="type" name="complaint.complaintType"/> </td>
    </tr>
    <tr>
      <th> 投诉说明</th>
      <td><textarea name="complaint.complaintHelp" rows="5" id="help"  ></textarea></td>
    </tr>
  </table>
  <div class="paddiv"></div>
   <a href="javascript:void(0)" id="save" name="save" class="R6">保存</a>
  <div class="paddiv"></div>
</form>
</div>