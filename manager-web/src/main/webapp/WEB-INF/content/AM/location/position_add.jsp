<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type='text/javascript' src='${ctx }/dwr/interface/checkLocation.js'></script>
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>
<script type="text/javascript"> 
    function addRomm() { 
        location.href = "location.do?method=getChialNode";
    }
    function delRomm() { 
        var pid = document.getElementById("posi").value;
        location.href = "location.do?method=getChialNode&del=1&parentId=" + pid;
    }
    function checkAction() {
        var desc = document.getElementById("descId").value;
        var posId = document.getElementById("posi").value; 
        if (posId == '') {
            alert('请选择委办局');
            return;
        }
        if (desc == '') {
            alert("请输入楼栋名称");
            return;
        }
       
       checkLocation.getChildPosIdDWR(desc, posId, function(data){ 
           if (data == true) {
               alert('楼栋名称重复了,重新输入!');
               return;
           } else {
               document.forms[0].action = "location.do?method=addPos";
               document.forms[0].submit();
           }
           });  
    } 
</script>
</head>
<body>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="13"></td>
                <td width="13"></td>
                <td width="410" class="css4">
                <sec:authorize ifAllGranted='ROLE_AdminAll'>
                 	<a href="#" class="R6 R7">添加楼号</a>
					<a href="#" class="R6 R7" onclick="addRomm()">添加房号</a>
                 </sec:authorize>
                 </td>
                <td width="410" class="css4">
                <div align="right">
                <sec:authorize ifAllGranted='ROLE_AdminAll'>
                	<a href="#" class="R6 R7" onclick="delRomm()">删除楼栋信息</a>
                </sec:authorize>
                </div>
                </td>
            </tr>
        </table>


	<div id="data">
      <h2 class="martop8">添加楼号</h2>
	<html:form action="/ismp/domain/local/am/location.do?method=addPos"
                        target="mainchiltFrame"> 
                        <table>
                            <tr>
                                <th>部门:</th>
                                <td>
                                  <div align="left">
                                    <select  name="position.positionId" 
                                    id="posi">
                                      <logic:notEmpty name="managerbo" scope="session">
                                        <logic:iterate id="m" name="managerbo" scope="session"> 
                                          <option value="${m.id }">${m.domainName }</option> 
                                        </logic:iterate>
                                      </logic:notEmpty>
                                    </select>
                              </div></td>
                              </tr>
                              <tr>
                                <th>楼栋名称:</th>
                              <td><input name="position.description" size="20"
                                    type="text" id="descId" maxlength="40"></td>
                              
                            </tr>
                      </table> 
                      <div align="center">
                      <sec:authorize ifAllGranted='ROLE_AdminAll'>
                      <input type="button" name="Submit" class="submit" onClick="checkAction();"  value="添加">
                      </sec:authorize>
                      </div>
     </html:form>
     </div>
</body>
</html>