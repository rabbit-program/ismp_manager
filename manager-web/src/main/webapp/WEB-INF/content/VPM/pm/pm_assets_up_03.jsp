<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="data" class="pad1 ">
<h2>映射关系录入</h2>
  <table>
    <tr>
      <th> 委办局</th>
      <td><select id="doselect"></select></td>
    </tr>
  </table>
  <div class="paddiv"></div>
  <a href="javascript:void(0)" id="save" onclick="sh.supdoMain(Boxy.get(this),Boxy.getEleValue(this));" class="R6">保存</a>
  <div class="paddiv"></div>
</div>