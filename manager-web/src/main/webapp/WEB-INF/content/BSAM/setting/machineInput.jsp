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
<title>主机信息</title>
<script type="text/javascript">
	function ret() {
		var currPage = document.getElementById("currPage").value;
	    var isAll = document.getElementById("isAll").value;
		window.location.href = "machineAction.do?method=getMachineList&currPage="+currPage+"&isAll="+isAll;
	}
	function chk() {
		var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])(\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])){3}$/;

		var nameReg = /\s+|;+|:+|{+|}+/;

		var form = document.forms[0];

		var ip = document.getElementById("ip").value;

		var machineName = document.getElementById("machineName").value;

		var description = document.getElementById("description").value;

		var weight = document.getElementById("weight").value;

		var temp = document.getElementsByName("parentType");
		
        var Checked = false;

        var parentTypeValue = "";
        
          for (i=0;i<temp.length;i++){
            if(temp[i].checked){
               parentTypeValue = temp[i].value;
               Checked = true;
               break;
            } else {
               Checked = false;
            }
          }
		if (ip == null || ip == '') {
			alert("主机ip不能为空");
			document.getElementById("ip").focus();
			return false;
		} else if (ip.length > 15) {
			alert("主机ip不能超过15个字符");
			document.getElementById("ip").focus();
			return false;
		} else if (!ip.match(reg)) {
			alert("主机ip格式有误");
			document.getElementById("ip").focus();
			return false;
		} else if (machineName == null || machineName == '') {
			alert("主机名字不能为空");
			document.getElementById("machineName").focus();
			return false;
		} else if (machineName.length > 50) {
			alert("主机名字不能超过50个字符");
			document.getElementById("machineName").focus();
			return false;
		} else if (machineName.match(nameReg)) {
			alert("主机名字不能包含空格、分号、冒号和大括号");
			document.getElementById("machineName").focus();
			return false;
		} else if (description == null || description == '') {
			alert("主机信息不能为空");
			document.getElementById("description").focus();
			return false;
		}else if (description.length > 255) {
            alert("主机信息不能超过255个字符");
            document.getElementById("description").focus();
            return false;
        } else if(Checked == false){
			alert("上级物理位置必须选择");
			return false;  
		} else if (weight == null || weight == '') {
			alert("权重不能为空");
			document.getElementById("weight").focus();
			return false;
		} else if (!/^[0-9]*[1-9][0-9]*$/.test(weight)) {
			alert("权重必须是正整数");
			document.getElementById("weight").focus();
			return false;
		} else if (weight > 100) {
			alert("权重不能超过100");
			document.getElementById("weight").focus();
			return false;
		}
		if(parentTypeValue == "JiGui"){
			var machineCabinetId = document.getElementById("machineCabinetId").value;
			if (machineCabinetId == null || machineCabinetId == '') {
	            alert("主机所在机柜必选");
	            document.getElementById("machineCabinetId").focus();
	            return false;
	        }else {
	        	var jiGuiIndex = document.getElementById("machineCabinetId").selectedIndex;
	            var newMachineCabinetName = document.getElementById("machineCabinetId").options[jiGuiIndex].id;
	            if(null != newMachineCabinetName && typeof(newMachineCabinetName) != "undefined"){
	                document.getElementById("machineCabinetName").value =  newMachineCabinetName;
	            } 
		    } 
		}else if(parentTypeValue == "JiFang"){
			var machineRoomId = document.getElementById("machineRoomId").value;
            if (machineRoomId == null || machineRoomId == '') {
                alert("主机所在机房必选");
                document.getElementById("machineRoomId").focus();
                return false;
            }else {
            	var jiFangIndex = document.getElementById("machineRoomId").selectedIndex;
                var newMachineRoomName = document.getElementById("machineRoomId").options[jiFangIndex].id;
                if(null != newMachineRoomName && typeof(newMachineRoomName) != "undefined"){
                    document.getElementById("machineRoomName").value =  newMachineRoomName;
                } 
            }
		}else if(parentTypeValue == "AnQuanYu"){
			var securityAreaId = document.getElementById("securityAreaId").value;
            if (securityAreaId == null || securityAreaId == '') {
                alert("主机所在安全域必选");
                document.getElementById("securityAreaId").focus();
                return false;
            }else {
            	var anQuanYuIndex = document.getElementById("securityAreaId").selectedIndex;
                var newSecurityAreaName = document.getElementById("securityAreaId").options[anQuanYuIndex].id;
                if(null != newSecurityAreaName && typeof(newSecurityAreaName) != "undefined"){
                    document.getElementById("securityAreaName").value =  newSecurityAreaName;
                }
            }
		}
		form.submit();
	}
	function changeParentType(parentType){
		if("JiGui" == parentType){
			document.getElementById("JiGui").style.display = "block"; 
			document.getElementById("JiFang").style.display = "none"; 
			document.getElementById("AnQuanYu").style.display = "none"; 
	    }else if("JiFang" == parentType){
	    	document.getElementById("JiGui").style.display = "none"; 
            document.getElementById("JiFang").style.display = "block"; 
            document.getElementById("AnQuanYu").style.display = "none";   
		}else if("AnQuanYu" == parentType){
			document.getElementById("JiGui").style.display = "none"; 
            document.getElementById("JiFang").style.display = "none"; 
            document.getElementById("AnQuanYu").style.display = "block";
	    }
		  
    }
</script>
</head>
<body>
<div id="contant" class="mainbg">
    <%@ include file="/WEB-INF/content/BSAM/comm/topMenu.jsp"%>
    <div class="contant" >
        <div class="overf h20 martop10">
          <li id="m">
               <a class="mbacka" href="${ctx}/ismp/domain/local/bsam/machineAction.do?method=getMachineList&currPage=${currPage}&isAll=${isAll}">
                    <span class="menus10">主机添加/修改</span>
               </a>
          </li>
        </div>
        <div id="data" class="greenborder overf pad1" >
            <html:form action="/ismp/domain/local/bsam/machineAction.do?method=machineSaveOrUpdate" >
                <input type="hidden" name="currPage" id="currPage"    value="${currPage}">
                <input type="hidden" id="isAll" name="isAll" value="${isAll}"/> 
                <input type="hidden" name="id" id="id" value="${machine.id}" />
                <input type="hidden" name="machineCabinetName" id="machineCabinetName"  value="">
                <input type="hidden" name="machineRoomName" id="machineRoomName"  value="">
                <input type="hidden" name="securityAreaName" id="securityAreaName"  value="">
	            <table id="senfe" sortcol="-1">
	                <tr>
	                   <th class="head">主机IP</th>
	                   <td><input name="ip" type="text" class="main" id="ip" size="38" value=${machine.ip }></td>
	                </tr>
	                <tr>
	                   <th class="head">主机名称</th>
	                   <td><input name="machineName" type="text" class="main" id="machineName" size="38" value=${machine.machineName }></td>
	                </tr>
	                <tr>
	                   <th class="head">权重</th>
	                   <td><input name="weight" type="text" class="main" id="weight" size="38" value=${machine.weight }></td>
	                </tr>
	                <tr>
	                   <th class="head">上级位置</th>
	                   <td>
                            <input type="radio" name="parentType" value="JiGui" onclick="changeParentType('JiGui')" <c:if test="${machine.parentType eq 'JiGui' }">checked="checked"</c:if> />&nbsp;&nbsp;机柜&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="parentType" value="JiFang" onclick="changeParentType('JiFang')" <c:if test="${machine.parentType eq 'JiFang' }">checked="checked"</c:if> />&nbsp;&nbsp;机房&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="parentType" value="AnQuanYu" onclick="changeParentType('AnQuanYu')" <c:if test="${machine.parentType eq 'AnQuanYu' }">checked="checked"</c:if>/>&nbsp;&nbsp;安全域&nbsp;&nbsp;&nbsp;&nbsp;
                       </td>
	                </tr>
	                <tr  id="JiGui" <c:if test="${machine.parentType != 'JiGui' }">style="display: none"</c:if> >
	                   <th class="head">所在机柜</th>
	                   <td>
	                      <select name="machineCabinetId" id="machineCabinetId" class="main" style="width: 220px">
	                        <option value="">-请选择-</option>
	                        <c:forEach items="${machineCabinetList }" var="machineCabinet">
	                            <c:choose>
	                                <c:when test="${machineCabinet.id == machine.machineCabinet.id }">
	                                    <c:set var="machineCabinetSelect" value="selected" />
	                                </c:when>
	                                <c:otherwise>
	                                    <c:set var="machineCabinetSelect" value="" />
	                                </c:otherwise>
	                            </c:choose>
	                            <option value="${machineCabinet.id}" ${machineCabinetSelect } id="${machineCabinet.machineCabinetName }">
	                            ${machineCabinet.machineCabinetName }(${machineCabinet.id })</option>
	                        </c:forEach>
	                      </select>
	                   </td>
	                </tr>
                    <tr id="JiFang" <c:if test="${machine.parentType != 'JiFang' }">style="display: none"</c:if>>
                      <th class="head">所在机房</th>
                      <td>
                         <select name="machineRoomId" id="machineRoomId" class="main" style="width: 220px">  
                            <option value="">-请选择-</option>
                            <c:forEach items="${machineRoomList }" var="machineRoom">
                            <c:choose>
                                <c:when test="${machineRoom.id == machine.machineRoom.id }">
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
                    <tr id="AnQuanYu" <c:if test="${machine.parentType != 'AnQuanYu' }">style="display: none"</c:if>>
                      <th class="head">所在安全域</th>
                      <td>
                         <select name="securityAreaId" id="securityAreaId" class="main" style="width: 220px">
                            <option value="">-请选择-</option>
                            <c:forEach items="${userDomainList }" var="domain">
                            <c:choose>
                                <c:when test="${domain.id == machine.domain.id }">
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
                       <th class="head">主机信息</th>
                       <td><textArea name="description" class="main" id="description" rows="7" cols="40">${machine.description }</textArea></td>
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
