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
<script type="text/javascript">
                   
                    function forwardPage(){
                        location.href="fwdPage.do?location=1";
                    }
                    function addRomm(){                      
                         var pid=document.getElementById("weibanju").value;
                         location.href="location.do?method=getChialNode&delRomm=1&parentId="+pid;
                    }
                    function loufang(flag){
                        if(flag==false){
                           document.getElementById("chial").style.display="none";
                           document.getElementById("parent").style.display="";
                           document.getElementById("lou").style.display="none";
                        }else{
                            document.getElementById("chial").style.display="";
                            document.getElementById("parent").style.display="none";
                            document.getElementById("lou").style.display="none";
                        }
                    }
                    function getFang(){                         
                         var pid=document.getElementById("weibanju").value;
                         location.href="location.do?method=getChialNodeHouse&delFang=1&parentId="+pid;
                    }                   
                    function checkLou(){                     
                        var louhao=document.getElementById("fang").value;
                        var p=document.getElementById("weibanju").value;
                        var louName=document.getElementById("ln").value;
                        if(p==''){
                            alert('请选择委办局');
                            return false;
                        }
                        else if(louName==''){
                            alert('选择楼号名称');
                            return false;
                        }
                        else if(louhao==''){
                            alert("请输入房间信息");
                            return false;
                        }

                        else{
                            return true;
                        }                        
                    }
                    function checkL(){                     
                        var louhao=document.getElementById("louNumber").value;
                        var p=document.getElementById("p").value;
                        if(p==''){
                            alert('请选择委办局');
                            return false;
                        }
                        if(louhao==''){
                            alert("请输入楼栋名称");
                            return false;
                        }else{
                            return true;
                        }                        
                    }


                 
                    function checkAll(e, itemName) 
                    { 
                      var aa = document.getElementsByName(itemName); 
                      for (var i=0; i<aa.length; i++) 
                       aa[i].checked = e.checked; 
                    } 
                    function checkItem(e, allName) 
                    { 
                      var all = document.getElementsByName(allName)[0]; 
                      if(!e.checked) all.checked = false; 
                      else 
                      { 
                        var aa = document.getElementsByName(e.name); 
                        for (var i=0; i<aa.length; i++) 
                         if(!aa[i].checked) return; 
                        all.checked = true; 
                      } 
                    } 

                    function del(){
                        var a = document.getElementsByName("locationCheckBox");
                        var n = a.length;
                        var k = 0;
                        for (var i=0; i<n; i++){
                             if(a[i].checked){
                                 k = 1;
                             }
                         }
                         if(k==0){
                             alert("请选中需要删除项!");
                             return;
                         }       
                     if(confirm("确认删除所选项吗？")){                        
                        document.forms[0].submit();
                     }else{                         
                        return;
                     }
                 } 
 
                    function delP(pid){
                        location.href="location.do?method=getChialNode&del=1&parentId="+pid;
                    }
                    function deleteLoc(pid){
                        location.href="location.do?method=getChialRomm&delRomm=1&parentId="+pid;
                    }
             
    </script>
</head>
<body>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="14"></td>
				<td width="14"></td>
				<td width="410" class="css4">
					<a href="#" class="R6 R7" onclick="delP('${sessionScope.parentId}')">删除楼号</a>
					<a href="#" class="R6 R7" onclick="deleteLoc('${sessionScope.parentId}')">删除房号</a>
					</td>
				<td width="410" class="css4">
				<div align="right">
					<a href="#" class="R6 R7" onclick="forwardPage()">添加楼栋信息</a>	
				</div>
				</td>
			</tr>
		</table>
		<div id="data">
      	<h2 class="martop8">房间列表</h2>
		<html:form	action="/ismp/domain/local/am/location.do?method=delTree" target="mainchiltFrame">
				<table>
						<tr>
							<td height="27" colspan="3"><label>
							<div align="center">域: <select name="select"
								id="weibanju" onChange="delRomm();">
								<logic:notEmpty name="managerbo" scope="session">
									<logic:iterate id="m" name="managerbo" scope="session">
										<option value="${m.id }"
											<c:if test="${parentId==m.id}"> selected="selected"</c:if>>${m.domainName }</option>
									</logic:iterate>
								</logic:notEmpty>
							</select></div>
							<div align="center">楼栋: <select name="select"	id="weibanju" onChange="getFang()">
								<logic:notEmpty name="RommList">
									<option>请选择楼栋</option>
									<logic:iterate id="pl" name="RommList">

										<c:if test="${parentId==pl.parentId}">
											<option value="${pl.id }">${pl.description }</option>
										</c:if>
									</logic:iterate>
								</logic:notEmpty>
							</select></div>
							全选 <input type=checkbox name=mmAll	onclick="checkAll(this, 'locationCheckBox')"></td>
						</tr>

						<tr>
							<td height="42" colspan="3">
							<div align="center"><input type="button" class="submit"	onclick="del();" name="Submit2" value="删除"></div>
							</td>
						</tr>
				</table>
		</html:form>
		</div>
</body>
</html>