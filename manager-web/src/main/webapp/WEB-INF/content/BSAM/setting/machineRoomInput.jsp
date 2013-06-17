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
<title>机房信息</title>
<script type="text/javascript">
  function ret(){
	  var currPage = document.getElementById("currPage").value;
      var isAll = document.getElementById("isAll").value;
	  window.location.href="${ctx}/ismp/domain/local/bsam/machineRoomAction.do?method=getMachineRoomList&currPage="+currPage+"&isAll="+isAll;
  }

  function chk(){
      var nameReg = /\s+|;+|:+|{+|}+/;
      var form = document.forms[0];
      var machineRoomName = document.getElementById("machineRoomName").value;
      var description = document.getElementById("description").value;
      var securityAreaId = document.getElementById("securityAreaId").value;
      
      if(machineRoomName==null || machineRoomName==''){
          alert("机房名字不能为空");
          document.getElementById("machineRoomName").focus();
          return false;
      }else if(machineRoomName.length > 50){
          alert("机房名字不能超过50个字符");
          document.getElementById("machineRoomName").focus();
          return false;
      }else if(machineRoomName.match(nameReg)){
          alert("机房名字不能包含空格、分号、冒号和大括号");
          document.getElementById("machineRoomName").focus();
          return false;
      }else if(description==null || description==''){
          alert("机房信息不能为空");
          document.getElementById("description").focus();
          return false;
      }else if(description.length > 255){
          alert("机房信息不能超过255个字符");
          document.getElementById("description").focus();
          return false;
      }else if(securityAreaId==null || securityAreaId==''){
          alert("所在安全域不能为空");
          document.getElementById("securityAreaId").focus();
          return false;
      }
      var index = document.getElementById("securityAreaId").selectedIndex;
      var newSecurityAreaName = document.getElementById("securityAreaId").options[index].id;
      if(null != newSecurityAreaName && typeof(newSecurityAreaName) != "undefined"){
    	  document.getElementById("securityAreaName").value =  newSecurityAreaName;
      }
      ///alert(location);
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
               <a class="mbacka" href="${ctx}/ismp/domain/local/bsam/machineRoomAction.do?method=getMachineRoomList&currPage=${currPage}&isAll=${isAll}">
                    <span class="menus12">机房添加/修改</span>
               </a>
          </li>
        </div>
        <div id="data" class="greenborder overf pad1" >
            <html:form action="/ismp/domain/local/bsam/machineRoomAction.do?method=machineRoomSaveOrUpdate" >
                <input type="hidden" name="currPage" id="currPage"    value="${currPage}">
                <input type="hidden" id="isAll" name="isAll" value="${isAll}"/>
                <input type="hidden" name="id" id="id"    value="${machineRoom.id}">
                <input type="hidden" name="securityAreaName" id="securityAreaName"  value="">
                <table id="senfe" sortcol="-1">
	                <tr>
	                  <th class="head">机房名称</th>
	                  <td><input name="machineRoomName" type="text" class="main" id="machineRoomName" size="38" value=${machineRoom.machineRoomName }></td>
	                </tr>
	                <tr>
	                  <th class="head">所在安全域</th>
	                  <td>
	                     <select name="securityAreaId" id="securityAreaId" class="main" style="width: 220px">
	                        <option value="">-请选择-</option>
	                        <c:forEach items="${userDomainList }" var="domain">
	                        <c:choose>
	                            <c:when test="${domain.id == machineRoom.domain.id }">
	                                <c:set var="securityAreaSelect" value="selected" />
	                            </c:when>
	                            <c:otherwise>
	                                <c:set var="securityAreaSelect" value="" />
	                            </c:otherwise>
	                        </c:choose>
	                        <option value="${domain.id}" ${securityAreaSelect} id="${domain.domainName}">
	                        ${domain.domainName }(${domain.id })</option>
	                        </c:forEach>
	                     </select>
	                   </td>
	                 </tr>
	                 <tr>
	                   <th class="head">机房信息</th>
	                   <td>
	                     <textArea name="description" class="main" id="description" rows="7" cols="40" >${machineRoom.description }</textArea>
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