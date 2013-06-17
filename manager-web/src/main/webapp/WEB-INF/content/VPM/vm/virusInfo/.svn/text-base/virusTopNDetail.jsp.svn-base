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
<%@ page import="edu.sjtu.infosec.ismp.manager.VPM.vm.model.TopVirus"%>

<%@ include file="/common/taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>病毒TOP10明细</title>
		          <link href="${ctx}/css/comm/other/Newcommon.css" rel="stylesheet" type="text/css" />
          <link href="${ctx}/css/comm/other/Maincontant.css" rel="stylesheet" type="text/css" />
          <link rel="stylesheet" href="${ctx}/css/comm/other/common.css" type="text/css" />
          <link rel="stylesheet" href="${ctx}/css/comm/other/boxy.css" type="text/css" />
	</head>
	<body>
        <div id="data" class="pad1 " style="text-align: center;">
	        <div  class="greenborder Height_a pad3" style="margin: 12px;">
	            <P ALIGN="center">
	               <span style="font-size: 21px;font-weight: bold;">病毒TOP10</span>
	            </P>
	            <% 
	                List<TopVirus> tvList = (List<TopVirus>)request.getAttribute("tvList");
	                if(tvList!=null && tvList.size()>0){
	                        DefaultPieDataset virusData = new DefaultPieDataset();
	                        for(TopVirus tv :tvList){
	                            virusData.setValue(tv.getVirus().getName(),tv.getVirusCount()); 
	                        }
	                        
	                        PiePlot3D virusPlot = new PiePlot3D(virusData);
	                        //virusPlot.setURLGenerator(new StandardPieURLGenerator("/JFreeChartProjet/pie/pie3d.do"));
	                        JFreeChart virusChart = new JFreeChart("",JFreeChart.DEFAULT_TITLE_FONT, virusPlot, false); 
	                        virusChart.setBackgroundPaint(java.awt.Color.white);
	                        //virusChart.setTitle("程序员学历情况调查表");
	                        virusPlot.setToolTipGenerator(new StandardPieToolTipGenerator());
	                        StandardEntityCollection virusSec = new StandardEntityCollection(); 
	                        ChartRenderingInfo virusInfo = new ChartRenderingInfo(virusSec); 
	                        
	                        PrintWriter virusW = new PrintWriter(out);
	                        String virusFilename = ServletUtilities.saveChartAsPNG(virusChart, 500, 300, virusInfo, session);
	                        ChartUtilities.writeImageMap(virusW, "virusMap", virusInfo, false); 
	                        
	                        String virusGraphURL = request.getContextPath() + "/DisplayChart?filename=" + virusFilename;
	                    %>
	                    <P ALIGN="center"> 
	                        <img src="<%= virusGraphURL %>" width=500 height=300 border=0 usemap="#virusMap"> 
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
	        <table class="martop8" >
	            <tr>
	                <th>病毒名称</th>
	                <th>病毒类型</th>
	                <th>病毒发作次数</th>
	            </tr>
	            <c:forEach var="topVirus" items="${tvList}">
		            <tr>
		                <td>${topVirus.virus.name}</td>
		                <td>${topVirus.virus.type.name}</td>
		                <td>${topVirus.virusCount}</td>
		            </tr>
	            </c:forEach>
	        </table>
        </div>
	</body>
</html>