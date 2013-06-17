<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ page import="java.net.InetAddress"%>

<html>
<title>MANAGER APPLET</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<%    
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<SCRIPT language="Javascript">
    function addApplet(){
        var typeValue = navigator.appName;  
    
        if (typeValue == 'Microsoft Internet Explorer') { 
            document.write('<OBJECT ',   
                   'classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"',
                   'codebase="http://http://java.com/zh_CN/download#Version=1,6,0,0"',
                   'width="100%"',   
                   'height="100%">',   
                   '<PARAM NAME="java_code" VALUE="org.infosec.ismp.applet.manager.AppletStart"> ',
                   ' <PARAM NAME="ARCHIVE" VALUE="twaver-2.3.jar,liquidlnf-1.0.jar,spring-web-3.0.2.RELEASE.jar,spring-beans-3.0.2.RELEASE.jar,aopalliance-1.0.jar,spring-context-3.0.2.RELEASE.jar,spring-core-3.0.2.RELEASE.jar,commons-logging-api-1.1.jar,spring-aop-3.0.2.RELEASE.jar,commons-lang-2.5.jar,ismp-manager-rmi-1.0-SNAPSHOT.jar,ismp-topo-applet-2.0-SNAPSHOT.jar,ismp-agent-winsensor-comm-2.0-SNAPSHOT.jar" > ',
    ' <param name="basePath" value="<%=basePath%>"/>',
	                   '</OBJECT>');   
   
        }else if(typeValue == 'Netscape') {
            document.write( '<OBJECT',   
                                'width="100%"',   
                                'height="100%"',   
                                'classid="clsid:CAFEEFAC-0015-0000-0000-ABCDEFFEDCBA"> ',
                                '<param name="java_code" value="org.infosec.ismp.applet.manager.AppletStart">',
                                '<comment>',
                                    '<embed code="org.infosec.ismp.applet.manager.AppletStart"',  
                                         'type="application/x-java-applet;jpi-version=1.6.0"> ', 
                                         'pluginspage="http://java.com/zh_CN/download"/> ',
                                      '<noembed>',  
                                            '<p>ERROR</p>',
                                      '</noembed>',  
                                   ' </embed>',  
                                 ' </comment>', 
                                 ' <PARAM NAME="ARCHIVE" VALUE="twaver-2.3.jar,liquidlnf-1.0.jar,spring-web-3.0.2.RELEASE.jar,spring-beans-3.0.2.RELEASE.jar,aopalliance-1.0.jar,spring-context-3.0.2.RELEASE.jar,spring-core-3.0.2.RELEASE.jar,commons-logging-api-1.1.jar,spring-aop-3.0.2.RELEASE.jar,commons-lang-2.5.jar,ismp-manager-rmi-1.0-SNAPSHOT.jar,ismp-topo-applet-2.0-SNAPSHOT.jar,ismp-agent-winsensor-comm-2.0-SNAPSHOT.jar" > ',
    ' <param name="basePath" value="<%=basePath%>"/>',
	                             '</OBJECT> ');   
      
        } else {
             document.write('<p>ERROR</p>');   
        }
    }
</SCRIPT>
</head>
<body onload="addApplet();">
</body>
</head>
