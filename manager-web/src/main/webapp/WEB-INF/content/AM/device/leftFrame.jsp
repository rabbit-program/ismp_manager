<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<%@page import="edu.sjtu.infosec.ismp.security.Domain"%>
<%@page import="java.util.List;" %>
<html> 
<head> 
	<link rel="StyleSheet" href="${ctx }/css/comm/tree/dtree.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/AM/dtree.js"></script> 
</head> 
<body>
<div class="dtree">
	<script type="text/javascript">
				
		d = new dTree('d'); 
		
		var sid=5;
		var url="asset.do?netid=5";
		d.add(0,-1,'资产管理-设备'); 
	  
	    <%
	    List<Domain> list =  (List<Domain>)session.getAttribute("managerbo");
	    if(list !=null && !list.isEmpty())
	    {   
	    	for(Domain bo:list)
	    	{
	    		%>
	    		d.add(<%=bo.getId()%>0,0,'<%=bo.getDomainName()%>','javascript:doAction(<%=bo.getId()%>)'); 
    		    d.add(<%=bo.getId()%>11,<%=bo.getId()%>0,'网络设备','javascript:fwd(<%=bo.getId()%>,1)');
    	        d.add(<%=bo.getId()%>22,<%=bo.getId()%>0,'安全设备','javascript:fwd(<%=bo.getId()%>,2)');
    	        d.add(<%=bo.getId()%>33,<%=bo.getId()%>0,'服务器','javascript:fwd(<%=bo.getId()%>,3)');
    	        d.add(<%=bo.getId()%>44,<%=bo.getId()%>0,'桌面主机','javascript:fwd(<%=bo.getId()%>,4)');  
	    		<% 
	    	}
	    }
	    %>
	    d.add(01,0,'未分配');
        d.add(03,01,'网络设备','javascript:fwdAll(1)');
        d.add(04,01,'安全设备','javascript:fwdAll(2)');
        d.add(05,01,'服务器','javascript:fwdAll(3)');
        d.add(06,01,'桌面主机','javascript:fwdAll(4)');
		document.write(d);
	
        function fwd(locid,tid){   
          
          document.getElementById("typeid").value=tid;       
          document.getElementById("locid").value=locid;       
          document.getElementById("method").value="findAssetByLoc";       
		  document.forms[0].target="childFrame";
		  document.forms[0].action="asset.do";		  
          document.forms[0].submit();
		}
        function fwdAll(tid){   
            
            document.getElementById("typeid").value=tid;   
            document.forms[0].target="childFrame";
            document.getElementById("method").value="findAssetAll";       
            document.forms[0].action="asset.do";        
            document.forms[0].submit();
          }

        function doAction(locid){ 
        	window.parent['childFrame'].location.href="assetAvailability.do?method=assetAnalysis&locid="+locid;
         //  window.open (""); 
        }
 
	</script>
</div>
<div>
    <form action="" method="get">
           <input type="hidden" name="tid" id="typeid"/>
           <input type="hidden" name="locid" id="locid"/>
           <input type="hidden" id="method"  name="method" />
    </form>
</div>
</body>
</html>