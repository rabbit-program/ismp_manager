<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ include file="/common/taglibs.jsp"%>
<%@page import="edu.sjtu.infosec.ismp.security.Domain"%>
<%@page import="java.util.List;" %>

<head>
	<title>Destroydrop &raquo; Javascripts &raquo; Tree</title>
	<link rel="StyleSheet" href="${ctx }/css/comm/tree/dtree.css" type="text/css" />
	<script type="text/javascript" src="${ctx }/js/AM/dtree.js"></script> 
</head>

<body>
<div class="dtree">
	<script type="text/javascript">  
		d = new dTree('d');
		os="os";
	    db="db";
	    app="app";
	    oa="oa";
	    other="other";
	    d.add(0,-1,'资产管理-软件');
	 //   d.add(1,0,'软件类别');
	    <%
	    List<Domain> list =  (List<Domain>)session.getAttribute("managerbo");
        if(list !=null && !list.isEmpty())
        {   
            for(Domain bo:list)
            {%>
            d.add(<%=bo.getId()%>0,0,'<%=bo.getDomainName()%>'); 
            d.add(<%=bo.getId()%>11,<%=bo.getId()%>0,'操作系统','javascript:fwd(<%= bo.getId()%>,os)');
            d.add(<%=bo.getId()%>22,<%=bo.getId()%>0,'数据库','javascript:fwd(<%= bo.getId()%>,db)');
            d.add(<%=bo.getId()%>33,<%=bo.getId()%>0,'应用软件','javascript:fwd(<%= bo.getId()%>,app)');        
            d.add(<%=bo.getId()%>44,<%=bo.getId()%>0,'办公软件','javascript:fwd(<%= bo.getId()%>,oa)');
            d.add(<%=bo.getId()%>66,<%=bo.getId()%>0,'其他','javascript:fwd(<%= bo.getId()%>,other)');
        <%  
            }
        }
        %> 
	
		document.write(d);
	 
        function fwd(locid, tid){          
          document.getElementById("locid").value=locid;       
          document.getElementById("typeid").value=tid;       
		  document.forms[0].target="childFrame";
		  document.forms[0].action="soft.do";		  
          document.forms[0].submit();
		}
	</script>
</div>

    <form action="" method="post">
           <input type="hidden" name="sid" id="typeid"/>
           <input type="hidden" name="locid" id="locid"/>
           <input type="hidden" value="findSoftPagin" name="method" />
    </form>
</body>
</html>