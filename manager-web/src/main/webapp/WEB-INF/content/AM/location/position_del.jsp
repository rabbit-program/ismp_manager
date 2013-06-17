<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/assessmentCss.css" rel="stylesheet" type="text/css" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type='text/javascript'
    src='${basePath }/dwr/interface/checkLocation.js'></script>
<script type='text/javascript' src='${basePath }/dwr/engine.js'></script>
<script type='text/javascript' src='${basePath }/dwr/util.js'></script>
<script type="text/javascript">
                   
                    function forwardPage(){
                        location.href="fwdPage.do?location=1";
                    }
        
                    function delRomm(){
                        var pid=document.getElementById("weibanju").value;
                        var pid=document.getElementById("weibanju").value;
                        location.href="location.do?method=getChialNodeHouse&delFang=1&parentId="+pid;
                       // location.href="location.do?method=getChialNode&del=1&parentId="+pid;
                    }
                    function selectRomm(value){  
                    	        checkLocation.getChildPosDWR(value, function(data) {  
                        	     var inputs = "";   
                    	        for(var i=0;i < data.length; i ++)
                    	        {
                    	        	 var tmp=data[i]; 
                    	        	 inputs += "<input type='checkbox' name='locationCheckBox' value='"+tmp['id'] + "'/>" +tmp['description'];
                        	        }
                    	        
                    	        document.getElementById("houseList").innerHTML=inputs;;
                    	      
                    	        });
                    	  
                    } 
                 
                    function checkAll() 
                    { 
                      var house = document.getElementsByName("locationCheckBox");  
                      var selectId = document.getElementById("selectId"); 
                      
                      for (var i=0; i<house.length; i++) 
                    	  house[i].checked = selectId.checked ? true: false; 
                    } 
                    
                  
                    function deleteAction(){
                           var arrlist = document.getElementsByName("locationCheckBox"); 
                           var index = "";
                           for (var i=0; i<arrlist.length; i++){
                                if(arrlist[i].checked){
                                	index += arrlist[i].value + ",";
                                }
                            } 
                            if(index==""){
                                alert("请选中需要删除项!");
                                return;
                            }       
                        if(confirm("确认删除所选项吗？")){   
                          parent.location.href="location.do?method=delTree&locationCheckBox=" + index;
                        }else{                         
                           return;
                        }
                    } 
                  
                 
    </script>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="14"></td>
				<td width="14"></td>
				<td width="408" class="css4">
					<a href="#" class="R6 R7" >删除楼号 </a>
					<a href="#" class="R6 R7" onclick="delRomm()">删除房号 </a>
				</td>
				<td width="408" class="css4">
				<div align="right">
					<a href="#" class="R6 R7" onclick="forwardPage()">添加楼栋信息</a>
				</div>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>

	<tr>
		<td width="3%" rowspan="3">&nbsp;</td>
		<td>
		<table width="90%" border="0" cellspacing="0" cellpadding="0"
			align="left" class="bian">
			<tr>
				<td bgcolor="f9f9fb">
				<table width="69%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="229"><html:form
							action="location.do?method=delTree">
							<table width="578" height="155" border="0" align="center"
								cellspacing="1" class="css1">
								<tr>
									<td height="27" colspan="3">
									<div align="center">部门: <select name="select"
										id="weibanju" onChange="selectRomm(this.value)">
                                        <option>选择</option>
										<logic:notEmpty name="managerbo" scope="session">
											<logic:iterate id="m" name="managerbo" scope="session">
												<option value="${m.id }">${m.domainName }</option>
											</logic:iterate>
										</logic:notEmpty>
									</select></div>
									全选 <input type=checkbox id="selectId"
										onclick="checkAll()"></td>
								</tr>
								<tr>
									<td height="27" colspan="3">
									<div id="houseList" align="center"> 
                                         
                                         </div>
									 </td>
								</tr>
								 
							</table>
							<div class="css4">
								<input type="button" onclick="deleteAction();" class="an-1" name="Submit2" value="删除">
							</div>
						</html:form></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
</body>
</html>