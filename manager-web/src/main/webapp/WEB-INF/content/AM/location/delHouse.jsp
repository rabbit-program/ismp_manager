<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
<link href="css/assessmentCss.css" rel="stylesheet" type="text/css" />
<link href="css/css.css" rel="stylesheet" type="text/css" />
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

                    function del(id){
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
                        location.href="location.do?method=getChialNodeHouse&delFang=1&parentId="+pid;
                    }
                    function doLoc(pid){
                        
                        var  chilParentId= document.getElementById("houseId").value;
                        var parentId=document.getElementById("weibanju").value;
                        location.href="location.do?method=getLastNode&paId="+parentId+"&chilparentId="+chilParentId;
                         //location.href="location.do?method=getChialNodeHouse&delRomm=1&parentId="+pid;
                        
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
                <td width="10"></td>
                <td width="24"> </td>
                <td width="400" class="css4"> <input type="button"  class="an-1" onClick="delP('${sessionScope.parentId}')" value="删除楼号"/> 
                 <input type="button" class="an-1" onClick="deleteLoc('${sessionScope.parentId}')" value="删除房号"/></td>
                <td width="400" class="css4">
                <div align="right"><input type="button" value="添加楼栋信息" class="an-1" onClick="forwardPage()"></div>
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
        <table width="90%" border="0" cellspacing="0" cellpadding="0" class="bian">
            <tr>
                <td height="4" background="images/a-021.gif"></td>
            </tr>
            <tr>
                <td bgcolor="f9f9fb">
                <table width="69%" border="0" align="center" cellpadding="0"
                    cellspacing="0" class="css1">
                    <tr>
                        <td height="36">
 
                        <p align="center"></p>                        </td>
 
                        <p align="center"><!-- <input type="button" class="an-1" onchange=""
                          onc="javascript:location.href='location.do?method=getChialNode&del=1&parentId=${sessionScope.parentId}'" value="删除楼号">  
                          <input class="an-1"  type="button" onclick="javascript:location.href='location.do?method=getChialRomm&delRomm=1&parentId=${sessionScope.parentId }'" value="删除房号  ">                  --></td>
 
                    </tr>

                    <tr>
                        <td height="229"><label></label>
                        <p align="center"><label></label></p>
                        <html:form action="location.do?method=delTree"
                            target="mainchiltFrame">
                            <table width="569" border="0" align="center">
                                <tr>
                                    <td width="563">
                                    <table width="578" height="155" border="0" align="center"
                                        cellspacing="1" class="css1">
                                        <tr>
                                            <td height="27" colspan="3"><label>
                                            <div align="center">委办局:<select  name="select"
                                        id="weibanju" onChange="getFang()">
   
                                        <logic:notEmpty name="managerbo" scope="session">
                                            <logic:iterate id="m" name="managerbo" scope="session"> 
                                                      <c:if test="${parentId==m.id}"> 
                                                          <option value="${m.id }" selected="selected">${m.managerName }</option> 
                                                      </c:if>
                                                      <c:if test="${parentId!=m.id}"> 
                                                          <option value="${m.id }">${m.managerName }</option> 
                                                      </c:if>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </select> </div>
                                            <div align="center">楼栋: <select name="select"
                                                id="houseId" onChange="doLoc(value)">
                                                <logic:notEmpty name="HouseList"> 
                                                    <logic:iterate id="pl" name="HouseList">
                                                        <c:if test="${paId==pl.id}">
                                                            <option value="${pl.id }" selected="selected">${pl.description
                                                            }</option>
                                                        </c:if>
                                                        <c:if test="${paId!=pl.id}">
                                                            <option value="${pl.id }">${pl.description}</option>
                                                        </c:if>
                                                    </logic:iterate>
                                                </logic:notEmpty>
                                            </select></div>
                                            <div align="left">全选<input type=checkbox name=mmAll
                                                onclick="checkAll(this, 'locationCheckBox')">  
                                            </label>
                                            </div>                                            </td>
                                        </tr>
                                        <logic:notEmpty name="RoomList">
                                            <logic:iterate id="pl" name="RoomList" indexId="i">
                                                <c:if test="${i%3==0}">
                                                <tr>                                                </c:if>
                                                <td><label>
                                                <div align="left"><input type="checkbox"
                                                    name="locationCheckBox" value="${pl.id }">
                                                ${pl.description }
                                                </label>
                                                </div>
                                                <div align="left"></div>
                                                <div align="left"></div>
                                                <div align="center"></div>                                                </td>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                        <logic:empty name="RoomList">
                                            <tr>
                                                <td>
                                                <p align="center">没有记录!</p>                                                </td>
                                            </tr>
                                        </logic:empty>
                                        <tr>
                                            <td height="42" colspan="3"><label></label> <label></label>
                                            <label>
                                            <div align="center"><input type="button" onClick="del();" class="an-1" name="Submit2"
                                                value="删除"></div>
                                            </label></td>
                                        </tr>
                                    </table>                                    </td>
                                </tr>
                            </table>
                        </html:form>



                        <p>&nbsp;</p>

                        <p align="center">&nbsp;</p>                        </td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                </table>                
            
            <tr>
                <td background="images/a-026.gif"></td>
            </tr>
        </table>
        </td>
    </tr>
    <tr>
        <td>&nbsp;</td>
    </tr>
    <tr>


    </tr>
    <tr>
        <td colspan="2">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="2">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td width="15"></td>
            </tr>
        </table>
</body>
</html>