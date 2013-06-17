<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/meta.jsp" %>
<% 
String projectPath=request.getScheme()+"://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath();
pageContext.setAttribute("projectPath", projectPath);
%>  
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
    <tr>
<!--       <td class="title">态势展示</td>-->
       <td class="title">&nbsp;&nbsp;</td>
       <td class="title_back">&nbsp;</td>
    </tr>   
</table>
<applet name="situationApplet" codebase="../../../../applet/BSAM/" 
    code="edu.sjtu.infosec.ismp.manager.BSAM.applet.Start"   
    archive="expo2.jar,kasa_charts.jar"
    width="100%" height="240">
    <param name="path" value="${projectPath}"/>
 </applet>
