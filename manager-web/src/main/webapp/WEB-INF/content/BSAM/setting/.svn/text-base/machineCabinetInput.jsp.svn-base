<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/common/meta.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Mainframe</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<title>机柜信息</title>
<script type="text/javascript">
  function ret(){
	  var currPage = document.getElementById("currPage").value;
      var isAll = document.getElementById("isAll").value;
      window.location.href="machineCabinetAction.do?method=getMachineCabinetList&currPage="+currPage+"&isAll="+isAll;
  }

  function chk(){
      var nameReg = /\s+|;+|:+|{+|}+/;
      var form = document.forms[0];
      var machineCabinetName = document.getElementById("machineCabinetName").value;
      var description = document.getElementById("description").value;
      var machineRoomId = document.getElementById("machineRoomId").value;
      if(machineCabinetName==null || machineCabinetName==''){
          alert("机柜名字不能为空");
          document.getElementById("machineCabinetName").focus();
          return false;
      }else if(machineCabinetName.length > 50){
          alert("机柜名字不能超过50个字符");
          document.getElementById("machineCabinetName").focus();
          return false;
      }else if(machineCabinetName.match(nameReg)){
          alert("机柜名字不能包含空格、分号、冒号和大括号");
          document.getElementById("machineCabinetName").focus();
          return false;
      }else if(description==null || description==''){
          alert("机柜信息不能为空");
          document.getElementById("description").focus();
          return false;
      }else if(description.length > 255){
          alert("机柜信息不能超过255个字符");
          document.getElementById("description").focus();
          return false;
      }else if(machineRoomId==null || machineRoomId==''){
          alert("物理位置不能为空");
          document.getElementById("machineRoomId").focus();
          return false;
      }
      ///alert(location);
      
      var index = document.getElementById("machineRoomId").selectedIndex;
      var newMachineRoomName = document.getElementById("machineRoomId").options[index].id;
      if(null != newMachineRoomName && typeof(newMachineRoomName) != "undefined"){
          document.getElementById("machineRoomName").value =  newMachineRoomName;
      }
     form.submit();
  }
 </script>
</head>
<body>
<div id="contant" class="mainbg">
    <%@ include file="/WEB-INF/content/BSAM/comm/topMenu.jsp"%>
    <div class="contant" >
        <div class="overf h20 martop10">
          <li id="m">
               <a class="mbacka" href="${ctx}/ismp/domain/local/bsam/machineCabinetAction.do?method=getMachineCabinetList&currPage=${currPage}&isAll=${isAll}">
                    <span class="menus11">机柜添加/修改</span>
               </a>
          </li>
        </div>
        <div id="data" class="greenborder overf pad1" >
            <html:form action="/ismp/domain/local/bsam/machineCabinetAction.do?method=machineCabinetSaveOrUpdate" >
                <input type="hidden" name="currPage" id="currPage"    value="${currPage}">
                <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
                <input type="hidden" name="id" id="id"    value="${machineCabinet.id}">
                <input type="hidden" name="machineRoomName" id="machineRoomName"  value="">
                <table id="senfe" sortcol="-1">
                   <tr>
                      <th class="head">机柜名称</th>
                      <td><input name="machineCabinetName" type="text" class="main" id="machineCabinetName" size="38" value=${machineCabinet.machineCabinetName }></td>
                   </tr>
                   <tr>
                      <th class="head">所在机房</th>
                      <td>
                         <select name="machineRoomId" id="machineRoomId" class="main" style="width: 220px">  
                            <option value="">-请选择-</option>
                            <c:forEach items="${machineRoomList }" var="machineRoom">
	                        <c:choose>
	                            <c:when test="${machineRoom.id == machineCabinet.machineRoom.id }">
	                                <c:set var="machineRoomSelect" value="selected" />
	                            </c:when>
	                            <c:otherwise>
	                                <c:set var="machineRoomSelect" value="" />
	                            </c:otherwise>
	                        </c:choose>
                            <option value="${machineRoom.id}" ${machineRoomSelect } id="${machineRoom.machineRoomName }">
                            ${machineRoom.machineRoomName }(${machineRoom.id })</option>
                            </c:forEach>
                         </select>
                       </td>
                   </tr>
                   <tr>
                      <th class="head">机柜信息</th>
                      <td>
                         <textArea name="description" class="main" id="description" rows="7" cols="40" >${machineCabinet.description }</textArea>
                      </td>
                   </tr>
                </table>
            </html:form>
        </div>
        <div class="martop8 Height_t">
            <ul id="page">
            <li><input type=button class="R6 R7" value="确定" hidefocus="Add" onclick="chk()" /></li>
            <li><input type="button" class="R6 R7" value="返回" hidefocus="Add" onclick="ret()" /></li>
            </ul><br />
        </div>
    </div>
</div>
</body>
</html>