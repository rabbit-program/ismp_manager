package edu.sjtu.infosec.ismp.manager.AM.comm;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

import edu.sjtu.infosec.ismp.manager.AM.model.DeviceChartVO;



public class DeviceCountChart { 
 

	public static CategoryDataset createDataset(List<DeviceChartVO> datas)
			throws Exception
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy年");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
		if(datas != null && !datas.isEmpty())
		{
			for(DeviceChartVO vo : datas)
			{
				Map map = vo.getDataMap();
				Iterator it = map.keySet().iterator();
				for(;it.hasNext();)
				{
					Integer key = (Integer)it.next();
					Integer value = (Integer)map.get(key); 
					if(key.equals(AssetConstant.NETWORK_DEVICE_TYPE))
						dataset.addValue(value, "网络设备", format.format(vo.getYear())); 
					if(key.equals(AssetConstant.SECURITY_DEVICE_TYPE))
						dataset.addValue(value, "安全设备", format.format(vo.getYear())); 
					if(key.equals(AssetConstant.SERVER_DEVICE_TYPE))
						dataset.addValue(value, "服务器", format.format(vo.getYear())); 
					if(key.equals(AssetConstant.TERMINAL_DEVICE_TYPE))
						dataset.addValue(value, "终端PC", format.format(vo.getYear())); 
				}
			}
		}
		return dataset;

	}

	
 

	public static JFreeChart createChart(CategoryDataset dataset)
	{

		JFreeChart chart = ChartFactory.createBarChart("资产设备历年统计", // chart title
				"年数", // domain axis label
				"设备数量", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				false, // tooltips?
				false // URLs?
				);

		Font font = new Font("宋体", Font.PLAIN, 14); 
		chart.setBackgroundPaint(Color.white);
		chart.getTitle().setFont(font);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		CategoryAxis xAxis = plot.getDomainAxis();
		xAxis.setLabelFont(font);
		xAxis.setTickLabelFont(font);
		

		ValueAxis yAxis = plot.getRangeAxis();
		yAxis.setLabelFont(font);
		yAxis.setTickLabelFont(font); 

		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		chart.getLegend().setItemFont(font);
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
		renderer.setBaseItemLabelsVisible(true);
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
		renderer.setBaseToolTipGenerator(new IntervalCategoryToolTipGenerator("{0}",  new SimpleDateFormat("yyyy")));
		return chart;

	}
}
