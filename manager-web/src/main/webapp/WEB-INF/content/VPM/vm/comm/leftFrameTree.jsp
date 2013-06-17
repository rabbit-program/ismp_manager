<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@page import="edu.sjtu.infosec.ismp.security.Domain"%>
<%@page import="edu.sjtu.infosec.ismp.manager.VPM.vm.model.VirusClients"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
    <link rel="StyleSheet" href="${ctx}/css/comm/tree/dtree.css" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/VPM/VM/dtree.js"></script> 
</head> 
<body>
<div class="dtree">
<!--<p style="margin:0 0 5px 2px"><a href="javascript: d.openAll();">全部展开</a> | <a href="javascript: d.closeAll();">全部关闭</a></p>-->
    <script type="text/javascript">
        d = new dTree('d'); 
        var sid=5;
        var url="asset.do?netid=5";
        d.add(0,-1,"<a href='${ctx}/ismp/domain/local/vpm/vm/virusInfo.do'>单位分布</a>");
        
        <%
        Map<Domain, List<VirusClients>> vcom = (Map<Domain, List<VirusClients>>)request.getAttribute("treeStruc");
        Set<Domain> list =  (Set<Domain>)vcom.keySet();
        if(list !=null && !list.isEmpty())
        {   
            for(Domain bo:list)
            {
                %>
                d.add(<%=bo.getId()%>0,0,'<%=bo.getDomainName()%>','${ctx}/ismp/domain/local/vpm/vm/virusInfo.do?di=<%=bo.getId()%>'); 
                <% 
                List<VirusClients> managerToVirusList = vcom.get(bo);
                if(managerToVirusList !=null && !managerToVirusList.isEmpty())
                {   
                    for(VirusClients sc:managerToVirusList)
                    {
                        %>
                        d.add(<%=sc.getId()%>11,<%=sc.getDepartment().getId()%>0,'<%=sc.getName()%>','${ctx}/ismp/domain/local/vpm/vm/clientsVirusInfoAction.do?vci=<%=sc.getId()%>');
                        <% 
                    }
                }
            }
        }
        %>
        
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

        //function doAction(locid){ 
           // window.parent['childFrame'].location.href="virusInfo.do?di="+locid;
         //  window.open (""); 
       // }
 
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