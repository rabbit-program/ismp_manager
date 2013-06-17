<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<%@page import="java.util.List"%>
<%@page import="edu.sjtu.infosec.ismp.security.Domain"%><html>

<head>
	<title>Destroydrop &raquo; Javascripts &raquo; Tree</title>
	<link rel="StyleSheet" href="${ctx }/css/comm/tree/dtree.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/AM/dtree.js"></script>
</head>

<body>
<div class="dtree">
	<script type="text/javascript">
		 	
		d = new dTree('d');
		cpu = "cpu";
		hard="harddisk";
		memory="memory";
		intfce="interface"; 
		d.add(0,-1,'资产管理-硬件');
		
		//d.add(1,0,'硬件类别'); 
		  <%
	        List<Domain> list =  (List<Domain>)session.getAttribute("managerbo");
	        if(list !=null && !list.isEmpty())
	        {   
	            for(Domain bo:list)
	            {%>
	            d.add(<%=bo.getId()%>0,0,'<%=bo.getDomainName()%>'); 
	            d.add(<%=bo.getId()%>33,<%=bo.getId()%>0,'CPU','javascript:fwd(<%= bo.getId()%>,cpu)');
	            d.add(<%=bo.getId()%>44,<%=bo.getId()%>0,'硬盘','javascript:fwd(<%= bo.getId()%>,hard)');
	            d.add(<%=bo.getId()%>55,<%=bo.getId()%>0,'内存','javascript:fwd(<%= bo.getId()%>,memory)');   
	            d.add(<%=bo.getId()%>66,<%=bo.getId()%>0,'网卡','javascript:fwd(<%= bo.getId()%>,intfce)');   
	            <%   
	            }
	        }
	        %> 
	            
		document.write(d);
		 
        function fwd(locid, tid){                    
          document.getElementById("locid").value=locid;       
          document.getElementById("typeid").value=tid;       
		  document.forms[0].target="childFrame";
		  document.forms[0].action="hardware.do";		  
          document.forms[0].submit();
		}
	</script>
</div>

    <form action="" method="post">
           <input type="hidden" name="hid" id="typeid"/>
           <input type="hidden" name="locid" id="locid"/>
           <input type="hidden" value="findHardWarePagin" name="method" />
    </form>
</body>
</html>