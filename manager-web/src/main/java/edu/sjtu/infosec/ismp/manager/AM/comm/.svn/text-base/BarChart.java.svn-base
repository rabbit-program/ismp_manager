package edu.sjtu.infosec.ismp.manager.AM.comm;

import java.awt.Font;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 * 资产管理模块可用性统计的柱状图
 * 
 * @author zjiajie
 * 
 */
public class BarChart {
	/**
	 * 创建柱状图
	 * 
	 * @param data为一组Integer的List
	 *            ，表示设备使用率； type为柱状图类型，1为日表，2为月表
	 * 
	 */
	public static JFreeChart creatBarChart(List<Integer> data, int type) {
		String xLabel = null;
		switch (type) {
		// 日表
		case (1):
			xLabel = "小时";
			break;
		// 月表
		case (2):
			xLabel = "天";
			break;
		case (3):
			xLabel = "月";
			break;
		}
		String yLabel = "使用率";
		CategoryDataset dataset = getDataSet(data, type);
		JFreeChart chart = ChartFactory.createBarChart(null, // 图表标题
				xLabel, // 目录轴的显示标签
				yLabel, // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				false, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		//设置主题、解决乱码。
		StandardChartTheme theme = new StandardChartTheme("unicode") {
			public void apply(JFreeChart chart) {
				chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,
						RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
				super.apply(chart);
			}
		};
		theme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 20));
		theme.setLargeFont(new Font("宋体", Font.PLAIN, 14));
		theme.setRegularFont(new Font("宋体", Font.PLAIN, 12));
		theme.setSmallFont(new Font("宋体", Font.PLAIN, 10));
		ChartFactory.setChartTheme(theme);
		//主题结束
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setRangeCrosshairVisible(true);
		BarRenderer renderer = new BarRenderer();
		renderer.setBaseItemLabelsVisible(true);
		renderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
				ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
		ValueAxis valueAxis = plot.getRangeAxis();
		valueAxis.setLowerBound(0);
		valueAxis.setUpperBound(100);
		plot.setRenderer(renderer);
		return chart;
	}

	/**
	 * 获取数据集对象
	 * 
	 * @return
	 */
	private static CategoryDataset getDataSet(List<Integer> data, int type) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		switch (type) {
		// 日表
		case (1):
			for (Integer i = 0; i < data.size(); i++) {
				dataset.addValue(data.get(i), "1", i);
			}
			break;
		// 月表
		case (2):
			for (Integer i = 0; i < data.size(); i++) {
				dataset.addValue(data.get(i), "1", new Integer(i + 1));
			}
			break;
		// 年报
		case (3):
			for (Integer i = 0; i < data.size(); i++) {
				dataset.addValue(data.get(i), "1", new Integer(i + 1));
			}
		}
		return dataset;
	}
}
