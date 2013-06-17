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
        <title>客户端感染TOP10</title>
    </head>
    <body>
        <!-- <div class="leftblock border mar8 pad8"> -->
            <P ALIGN="center">
                客户端感染TOP10
                &nbsp;&nbsp;&nbsp;&nbsp;<span><a href="${ctx}/ismp/domain/local/vpm/vm/contractInfoTop.do?cc=clients&di=${depId}&tn=10" target="_black">详细</a></span>
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
                        String clientFilename = ServletUtilities.saveChartAsPNG(clientChart, 400, 240, clientInfo, session);
                        ChartUtilities.writeImageMap(clientW, "clientMap", clientInfo, false); 
                        
                        String clientGraphURL = request.getContextPath() + "/DisplayChart?filename=" + clientFilename;
                    %>
                    <P ALIGN="center"> 
                        <img src="<%= clientGraphURL %>" width=400 height=240 border=0 usemap="#clientMap"> 
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
        <!-- </div> -->
    </body>
</html>