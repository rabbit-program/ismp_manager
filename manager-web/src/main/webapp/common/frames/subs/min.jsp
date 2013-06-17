<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <%@ include file="/common/meta.jsp" %>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
        <link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
            var displayBar=true;
            
            function switchBar(obj){
                if (displayBar){
                    parent.MainFrame.cols="0,13,*";
                    document.getElementById("minl").style.display="none";
                    document.getElementById("minr").style.display="";
                    displayBar=false;
                }else{
                    parent.MainFrame.cols="180,13,*";
                    document.getElementById("minl").style.display="";
                    document.getElementById("minr").style.display="none";
                    displayBar=true;
                }
            }
        </script>
	</head>
	<body class="minbg">
	   <div id="minl" class="arrow"><a href="#" title="Close Menu" onclick="switchBar();">3</a></div>
       <div id="minr" class="arrow" style="display:none;"><a href="#" title="Close Menu" onclick="switchBar();">4</a></div>
	</body>
</html>