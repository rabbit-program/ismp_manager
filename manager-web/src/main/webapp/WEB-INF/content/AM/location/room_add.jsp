<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
<script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
<script type="text/javascript" src="${ctx}/js/comm/other/sorttable.js"></script>
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>
<script type='text/javascript' src='${ctx }/dwr/interface/checkLocation.js'></script>
<script type="text/javascript">
 
    function room() { 
           location.href = "location.do?method=getChialNode&del=1";
    }
    function house() {
        location.href = "fwdPage.do?location=1";
    }

    function validateSubmit() {  
        var houseId = document.getElementById("houseId").value; 
        var roomId = document.getElementById("roomId").value; 
        if(houseId=='') {
            alert('请选择楼号');
            return;
        }
        if(roomId=='')
        {
            alert('请输入房号');
            return;
        } 
        checkLocation.getChildParentIdDWR(roomId, houseId, function(data){ 
              if (data == true) {
                  alert('名称重复了,请重新选择!');
                  return;
              } else { 
                  document.forms[0].action = "location.do?method=addTree";
                  document.forms[0].submit(); 
              }

            });
    } 
 
    function doLoc(value) {
        checkLocation.getChildPosDWR(value, function(data) {
            DWRUtil.removeAllOptions("houseId");
            DWRUtil.addOptions("houseId", [{
                id :'',
                name :"选择"
            }],"id","name");
            DWRUtil.addOptions("houseId", data, "id", "description");
        });
    }
</script>
</head>
<body>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="14"></td>
                <td width="14"></td>
                <td width="420" class="css4">
                <sec:authorize ifAllGranted='ROLE_AdminAll'>
                	<a href="#" class="R6 R7" onClick="house()">添加楼号</a>
					<a href="#" class="R6 R7" >添加房号</a>
                </sec:authorize>
                </td>
                <td width="410" class="css4">
                <div align="right">
                	<sec:authorize ifAllGranted='ROLE_AdminAll'>
                	<a href="#" class="R6 R7" onclick="room()">删除楼栋信息</a>
                	</sec:authorize>
                	</div>
                </td>
            </tr>
        </table>


	<div id="data">
      <h2 class="martop8">添加房号</h2>
		<html:form action="/ismp/domain/local/am/location.do?method=addTree" target="mainchiltFrame">
	                 <table>
	                   <tr>
	                     <th>部门：</th>
	                     <td><select name="poid"
	                               id="weibanju" onChange="doLoc(value)">
	                           <option value="">选择</option>
	                           <logic:notEmpty name="managerbo" scope="session">
	                             <logic:iterate id="m" name="managerbo" scope="session">
	                               <option value="${m.id }" >${m.domainName}</option>
	                             </logic:iterate>
	                           </logic:notEmpty>
	                       </select></td>
	                   </tr>
	                   <tr>
	                     <th>楼栋名称：</th>
	                     <td>  <select name="position.parentId" id="houseId">
	                           <option value="">选择</option>
	                         </select></td>
	                   </tr>
	                   <tr>
	                     <th>房间号：</th>
	                     <td><input name="position.description"  size="20"  type="text" id="roomId" maxlength="40"></td>
	                   </tr>
	                   <tr><td><input type="text" name="textfield2" style="display:none;"/></td></tr>
	                   
	                 </table>
	                 <div align="center">
	                         <input type="button" class="submit"
	                                name="admi222" onClick="validateSubmit()" value="添加">           
	                  </div>
	      </html:form>
      </div>
</body>
</html>