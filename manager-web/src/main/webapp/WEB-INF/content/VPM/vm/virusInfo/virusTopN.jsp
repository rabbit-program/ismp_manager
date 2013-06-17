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
		<title>病毒TOP10</title>
	</head>
	<body>
	    <!-- <div class="rightblock border mar8 pad8"> -->
            <P ALIGN="center">
				病毒TOP10
			    &nbsp;&nbsp;&nbsp;&nbsp;<span><a href="${ctx}/ismp/domain/local/vpm/vm/contractInfoTop.do?cc=virus&di=${depId}&vci=${virusClientsId}&tn=10" target="_black">详细</a></span>
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
				        String virusFilename = ServletUtilities.saveChartAsPNG(virusChart, 400, 240, virusInfo, session);
				        ChartUtilities.writeImageMap(virusW, "virusMap", virusInfo, false); 
				        
				        String virusGraphURL = request.getContextPath() + "/DisplayChart?filename=" + virusFilename;
			        %>
				    <P ALIGN="center"> 
				        <img src="<%= virusGraphURL %>" width=400 height=240 border=0 usemap="#virusMap"> 
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