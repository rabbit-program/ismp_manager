<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0);  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ include file="/common/taglibs.jsp"%>
<%@page import="java.util.List"%>
<%@page	import="edu.sjtu.infosec.ismp.manager.AM.model.AssetPositionBO"%>
<%@page import="java.util.Map"%>
<%@page import="edu.sjtu.infosec.ismp.security.Role"%>
<%@page import="edu.sjtu.infosec.ismp.security.Domain"%><html>

<head>
<meta http-equiv="pragma" content="no-cache"> 
     <meta http-equiv="cache-control" content="no-cache"> 
     <meta http-equiv="expires" content="0">   
	<link rel="StyleSheet" href="${ctx }/css/comm/tree/dtree.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/AM/dtree.js"></script> 

</head>

<body>
<div class="dtree"><script type="text/javascript">
    d = new dTree('d'); 
    <sec:authorize ifAllGranted='ROLE_AdminAll'>
    d.add(0,-1,'物理位置管理','javaScript:addLou()');  
    </sec:authorize>
  
   <% 
  String tree = (String)request.getAttribute("tree"); 
  String rootTree = (String)request.getAttribute("rootTree");  
  String[] rootlist =  rootTree.split(";");
  String[] treelist =  tree.split(";");
  for(int i = 0; i < rootlist.length; i++){
   %>  
   d.add(<%= rootlist[i]%>);
   <%
  }
  for(int i=0; i < treelist.length; i++)
  {
	  %>
	  d.add(<%= treelist[i]%>);
	  <%
  }
   %>
  
                       
    document.write(d);
 
    
    function fwd(tid){     
        
        document.getElementById("pid").value=tid;       
        document.forms[0].target="childFrameLoaction";
        document.forms[0].action="location.do";       
        document.forms[0].submit();
    }
    
    function addLou(){  
      window.parent['childFrameLoaction'].location.href="fwdPage.do?location=1"; 
    }
    </script></div>


<form action="" method="post">
<input type="hidden" name="pid" id="pid" />
<input type="hidden" value="findlocationDevicePagin" name="method" />
</form> 
</body>
</html>