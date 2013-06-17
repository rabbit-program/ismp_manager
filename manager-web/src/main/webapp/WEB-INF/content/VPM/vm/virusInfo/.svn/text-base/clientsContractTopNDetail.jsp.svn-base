<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="org.jfree.data.general.DefaultPieDataset"%> 
<%@ page import="org.jfree.chart.*"%> 
<%@ page import="org.jfree.chart.plot.*"%> 
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%> 
<%@ page import="org.jfree.chart.labels.StandardPieToolTipGenerator"%> 
<%@ page import="org.jfree.chart.urls.StandardPieURLGenerator"%> 
<%@ page import="org.jfree.chart.entity.StandardEntityCollection"%> 
<%@ page import="java.io.*"%> 
<%@ page import="edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopClients"%>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>客户端感染TOP10明细</title>
          <link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
          <link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
          <link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
          <link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
	</head>
	<body>
        <div  id="data" class="pad1 ">
	        <div class="greenborder Height_a pad3" style="margin: 12px;">
	            <P ALIGN="center">
	               <span style="font-size: 21px;font-weight: bold;">客户端感染TOP10</span>
	            </P>
	            <% 
	                List<TopClients> tcList = (List<TopClients>)request.getAttribute("tcList");
	                if(tcList!=null && tcList.size()>0){
	                        DefaultPieDataset clientData = new DefaultPieDataset();
	                        for(TopClients tc :tcList){
	                            clientData.setValue(tc.getVirusClients().getName()+"("+tc.getVirusClients().getClientIP()+")",tc.getVirusCount()); 
	                        }
	                        
	                        PiePlot3D clientPlot = new PiePlot3D(clientData);
	                        //clientPlot.setURLGenerator(new StandardPieURLGenerator("/JFreeChartProjet/pie/pie3d.do"));
	                        JFreeChart clientChart = new JFreeChart("",JFreeChart.DEFAULT_TITLE_FONT, clientPlot, false); 
	                        clientChart.setBackgroundPaint(java.awt.Color.white);
	                        //clientChart.setTitle("程序员学历情况调查表");
	                        clientPlot.setToolTipGenerator(new StandardPieToolTipGenerator());
	                        StandardEntityCollection clientSec = new StandardEntityCollection(); 
	                        ChartRenderingInfo clientInfo = new ChartRenderingInfo(clientSec); 
	                        
	                        PrintWriter clientW = new PrintWriter(out);
	                        String clientFilename = ServletUtilities.saveChartAsPNG(clientChart, 500, 300, clientInfo, session);
	                        ChartUtilities.writeImageMap(clientW, "clientMap", clientInfo, false); 
	                        
	                        String clientGraphURL = request.getContextPath() + "/DisplayChart?filename=" + clientFilename;
	                    %>
	                    <P ALIGN="center"> 
	                        <img src="<%= clientGraphURL %>" width=500 height=300 border=0 usemap="#clientMap"> 
	                    </P>
	            <% 
	                }else{
	            %>
	                    <P ALIGN="center">
	                                             没有数据！
	                    </P>
	            <% 
	                }
	            %>
	        </div>
	        <br/>
	        <table class="martop8">
	            <tr>
	                <th>客户端名称</th>
	                <th>客户端IP</th>
	                <th>感染病毒次数</th>
	            </tr>
	            <c:forEach var="topClient" items="${tcList}">
		            <tr>
		                <td>${topClient.virusClients.name}</td>
		                <td>${topClient.virusClients.clientIP}</td>
		                <td>${topClient.virusCount}</td>
		            </tr>
	            </c:forEach>
	        </table>
        </div>
	</body>
</html>