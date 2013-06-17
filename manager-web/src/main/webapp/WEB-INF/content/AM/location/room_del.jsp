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
<script type='text/javascript' src='${ctx }/dwr/interface/checkLocation.js'></script>
<script type='text/javascript' src='${ctx }/dwr/util.js'></script>
<script type='text/javascript' src='${ctx }/dwr/engine.js'></script>
<script type="text/javascript">
                   
                    function forwardPage(){
                        location.href="fwdPage.do?location=1";
                    }
                           
                   
                    function checkAll() 
                    { 
                      var house = document.getElementsByName("locationCheckBox");  
                      var selectId = document.getElementById("selectId"); 
                      
                      for (var i=0; i<house.length; i++) 
                          house[i].checked = selectId.checked ? true: false; 
                    } 
                    
              

                    function deleteAction(){
                        var arrList = document.getElementsByName("locationCheckBox");
                        var index = "";
                        for (var i=0; i<arrList.length; i++){
                             if(arrList[i].checked){
                                 index += arrList[i].value + ",";
                             }
                         }
                         if(index == ""){
                             alert("请选中需要删除项!");
                             return;
                         }       
                     if(confirm("确认删除所选项吗？")){                        
                    	  parent.location.href="location.do?method=delTree&locationCheckBox=" + index;
                     }else{                         
                        return;
                     }
                 } 
                    function house(pid){
                        location.href="location.do?method=getChialNode&del=1&parentId="+pid;
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

                    function selectHouse(value){ 
                    	checkLocation.getChildParentDWR(value, function(data){   
                    		  var inputs = "";   
                              for(var i=0;i < data.length; i ++)
                              {
                                   var tmp=data[i]; 
                                   inputs += "<input type='checkbox' name='locationCheckBox' value='"+tmp['id'] + "'/>" +tmp['description'];
                                  }
                              
                              document.getElementById("roomList").innerHTML=inputs;;
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
				
				<a href="#" class="R6 R7" onclick="house('${sessionScope.parentId}')">删除楼号</a>
				<a href="#" class="R6 R7" >删除房号</a>
				</td>
				<td width="400" class="css4">
				<div align="right">
				<a href="#" class="R6 R7" onclick="forwardPage()">添加楼栋信息</a>
				</div>
				</td>
			</tr>
		</table>
	<div id="data">
      
		<html:form action="/ismp/domain/local/am/location.do?method=delTree" target="mainchiltFrame">
				<table >
							<tr>
								<td height="27" colspan="3">
								<div align="center">部门 :<select name="select"
									onChange="doLoc(value)">
									<option>选择</option>
									<logic:notEmpty name="managerbo" scope="request">
										<logic:iterate id="m" name="managerbo" scope="request">
											<option value="${m.id }">${m.domainName }</option>
										</logic:iterate>
									</logic:notEmpty>
								</select> 楼栋: <select name="select" id="houseId"
									onchange="selectHouse(value)">
									<option>选择</option>
								</select></div>
								<div align="left">全选<input type=checkbox id="selectId"
									onclick="checkAll()"></div>
								</td>
							</tr>
							<tr>
								<td>
								<div id="roomList" align="center"></div>
								</td>
							</tr>
							<tr>
								<td height="42" colspan="3">

								
								</td>
							</tr>
						</table>
						<div align="center">
							<input type="button" onClick="deleteAction()" class="submit" name="Submit2" value="删除">
						</div>
		</html:form>
	</div>
</body>
</html>