<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@page import="edu.sjtu.infosec.ismp.util.EscapeUnescape" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>文件打印</title>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Newcommon.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/Maincontant.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/comm/other/common.css" />
        <script type="text/javascript" src="${ctx}/js/comm/other/table.js"></script>
    <script type="text/javascript">
    function fun(path)
    {  
         var selectedValue = document.getElementById("selectresp").value;
         forward=path+"/ismp/domain/local/erm/respPrint.do?method=showContent"
         +"&selectid="+selectedValue;
       window.location.href=forward;
    }

    function printFile() {
        var inputRtfFile = document.getElementById("printcontent").innerHTML;
        if(inputRtfFile == "" || inputRtfFile==null || inputRtfFile==undefined){
            alert("请选择预案文件");
            
        }else{
        	OpenWindow=window.open("", "OpenWindow", "top=10000,left=10000 ");   
            OpenWindow.document.write( " <textarea   cols=42   style= 'border:0;overflow:visible; '> "+inputRtfFile+ " </textarea> ");  
            OpenWindow.document.close();
            OpenWindow.print();   
            OpenWindow.close();  
        }
    }

    function Onsave(){
    	var selectresp=document.getElementById("selectresp").value;
    	var printcontent= document.getElementById("printcontent").value;
    	if(selectresp==null || selectresp==""){
            alert("请选择预案");
        }else if(printcontent==null || printcontent==""){
            alert("预案文件内容不能为空");
        }
    	if(selectresp!=""&&printcontent!=""&&selectresp!=null&&printcontent!=null){
    		document.saveForm.action="${ctx}/ismp/domain/local/erm/respPrint.do?method=saveorupdate";
            saveForm.submit();
        }
    }
    
    function generateYuAnFile(Path){
        var proj_key = document.getElementById("selectresp").value;
        if(proj_key == "" || proj_key==null || proj_key==undefined){
            alert("请选择预案");
        }else{
            //var contiBasicInfoId = document.getElementById("contiBasicInfoId").value;
            //alert(contiBasicInfoId);
            url=Path+"/ismp/domain/local/erm/reports/RespSchemeReport.do?schemeId="+proj_key;
            window.open(url,"report","scrollbars=yes");
        }
    }
</script>
</head>
    <body>
  <form id="saveForm" name="saveForm" method="post" action="${ctx}/ismp/domain/local/erm/respPrint.do?method=saveorupdate">
        <div id="contant" class="mainbg">
            <%@ include file="/WEB-INF/content/ERM/comm/topMenu.jsp"%>

            <div class="contant">
                <h2>文件打印</h2>
                <div id="data" class="greenborder overf pad1 " >
                      
                        <table id="senfe" sortcol="-1">
                            <thead>
                            </thead>
                            <tbody>
                                <tr>
                                    <th>选择预案</th>
                                    <td>
                                    <select name="selectresp" id="selectresp" onchange="fun('${ctx }');">
                                    <option>-请选择-</option>
                                    <c:forEach items="${respList}" var="resp">
                                     <c:choose>
                                       <c:when test="${resp.id == selectid}">
                                        <c:set var="select13" value="selected"></c:set>
                                       </c:when>
                                       <c:otherwise>
                                        <c:set var="select13" value=""></c:set>
                                       </c:otherwise>
                                      </c:choose>
                                     <option value="${resp.id}" ${select13 }>${resp.name}</option>
                                    </c:forEach>
                                        <input type="hidden" name="id" value="${printid}" />
                                   </select>

                                    </td>
                                </tr>
                                <tr>
                                    <th>预案文件内容</th>
                                    <td><textarea  cols="180" rows="10" id="printcontent" name="printcontent">${printres }</textarea></td>
                                </tr>
                            </tbody>
                        </table>
<%
if(null!=request.getAttribute("printres"))
{
    session.setAttribute("pcontent",EscapeUnescape.escape(request.getAttribute("printres").toString()));
}
%>                  
                </div>
                <div class="paddiv"></div>
                <div style="height:40px;"><a href="javascript:generateYuAnFile('${ctx}')" class="R6 R7">生成预案文件</a><a href="javascript:Onsave();" class="R6 R7">保存预案文件</a></div> 
            </div>
        </div>
</form>
    </body>
    <script type="text/javascript" src="${ctx}/js/comm/other/tablelink.js"></script>
</html>