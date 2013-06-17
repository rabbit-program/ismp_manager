<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>病毒管理---病毒告警详情</title>
	    <link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
       <link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
       <link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
        <link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />	
    <script type="text/javascript">
    function openRealTimeData(){    
    	   //var clientID=document.getElementById("sensorId").value;
    	    window.open('${ctx}/ismp/domain/local/vpm/vm/clientsVirusInfoAction.do') ;
    	}
    </script>
	</head>
	<body>
    <div  id="data" class="pad1 ">
      <ul class="border">
        <li style="float:none;">
          <table width="80%" border="0" cellspacing="0" cellpadding="0" class="martop8">                                                                              
                
                        <tr>
                          <td colspan="7" align="center"><h1>病毒告警详细信息</h1></td>
                        </tr>
                        <tr> 
                          <th>病毒名称</th>                          
                          <th>病毒类型 </th> 
                          <th>发现时间</th>                          
                          <th>处理结果 </th> 
                          <th>被感染文件</th>                          
                          <th>发现次数 </th>                        
                          <th>被感染的客户端 </th>
                        </tr>                                             
                                     
                        <tr>
                            <td><div align="center">${alerts.virus.name}</div></td>
                            <td><div align="center">${alerts.virus.type.name}</div></td>
                            <td><div align="center">${alerts.findTime}</div></td>
                            <td><div align="center">${alerts.killResult.name}</div></td>
                            <td><div align="center">${alerts.fileName}</div></td>
                            <td><div align="center">${alerts.vcount}</div></td>
                            <td><div align="center">${alerts.virusClients.name} ( ${alerts.virusClients.clientIP} )</div></td>
                            
                        </tr>
                </table>
        </li>
      </ul>
    </div>
	  
	</body>
</html>