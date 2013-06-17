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
<% 
String projectPath=request.getScheme()+"://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath();
pageContext.setAttribute("projectPath", projectPath);
%>
<title>历史态势</title>
<script type="text/javascript">
         function searchOnClick(){
             var name = document.getElementById("name").value;
             var type = document.getElementById("situationType").value;
             var hostComputerId = document.getElementById("hostComputerId").value;
             var beginDate = document.getElementById("d5221").value;
             var endDate = document.getElementById("d5222").value;
             if(beginDate == '' || endDate == ''){
                 alert("请选开始和结束时间");
                 return ;
             }
             document.getElementById("situationId").style.display="";
             document.applets["situationApplet"].setAction(hostComputerId,name, type,beginDate,endDate);
         }
</script>
<script type="text/javascript" src="${ctx}/js/comm/date/WdatePicker.js"></script>
</head>
<body onload="this.focus();">
<input type="hidden" name="name" id="name" value="${name }" />
<input type="hidden" name="situationType" id="situationType" value="${type }" />
<input type="hidden" name="hostComputerId" id="hostComputerId" value="${id }" />
<!--<div id="main">-->
<div id="contant" class="mainbg">
    <div class="contant" >
        <div class="overf h20 martop10">
          <li id="m">
               <a class="mback" href="#">
                    <span class="menus10">历史态势</span>
               </a>
          </li>
        </div>
        <div id="data" class="greenborder overf pad1" >
             <table width="100%" border="0" cellspacing="0" cellpadding="0">
		        <tr>
		          <td class="bottom_pad" >
		            <div id="list">
		              <table>
		                <tr>
		                  <th width="64" class="head"><div align="right">开始时间</div></th>
		                  <td width="168">
		                        <input name="dispatchpolicycenterbo.dispatchStartDate" readonly="readonly" id="d5221"
		                            onFocus="var d5222=$dp.$('d5222');WdatePicker({onpicked:function(){d5222.focus();},dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'d5222\')}'})"  class="main"  />
		                  </td>
		                  <th width="64" class="head"><div align="right">结束时间</div></th>
		                  <td width="168">
		                        <input type="text" readonly="readonly" name="dispatchpolicycenterbo.dispatchEndDate" id="d5222" class="main"
		                            onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'d5221\')}'})"  />
		                  </td>
		                  <td width="54">
		                        <input name="button" type="button" class="commonbtn" onclick="searchOnClick()" value="确定" hidefocus="Add"/>
		                  </td>
		                </tr>
		              </table>
		            </div>
		           </td>
		        </tr>
              </table>
         </div>
         <div id="situationId" style="display: none">
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		        <tr>
		            <td class="title">历史态势展示</td>
		            <td class="title_back">&nbsp;</td>
		        </tr>
		    </table>
		
		    <applet name="situationApplet" codebase="../../../../applet/BSAM/" 
		        code="edu.sjtu.infosec.ismp.manager.BSAM.applet.History"    
		        archive="expo2.jar,kasa_charts.jar"
		        width="100%" height="240">  
		        <param name="path" value="${projectPath}"/>
		     </applet>
		</div>      
      </div>
   </div>
</body>
</html>  