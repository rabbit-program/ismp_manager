package org.infosec.ismp.applet.manager.component.panel.info.memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.infosec.ismp.applet.manager.component.panel.component.TitlePanel;
import org.infosec.ismp.applet.manager.component.panel.info.AbstractTitlePanel;

import twaver.Element;
import twaver.Node;
import twaver.chart.Bubble;
import twaver.chart.BubbleChart;
import twaver.chart.PercentChart;

/**
 * 内存面板
 * 接口
 * setValue
 */
public class MemoryPanel extends AbstractTitlePanel {
	private Element element = new Node();
	private BubbleChart lineChart = new BubbleChart() {
		protected Color getValueTextColor(Element element, Bubble bubble, int index) {
			Color color = Color.GREEN;
			double value = bubble.getY();
			if (value > 60) {
				color = Color.ORANGE;
			}
			if (value > 80) {
				color = Color.RED;
			}
			return color;
		}
	};
	private PercentChart percentChart = new PercentChart() {
		public Color getColor(Element element) {
			double value = element.getChartValue();
			if (value < 60) {
				return Color.GREEN;
			}
			if (value > 80) {
				return Color.RED;
			}
			return Color.ORANGE;
		}
	};
	private int index = 0;

	public MemoryPanel() {
		element.putChartColor(Color.GREEN);
		initGUI();
	}

	private void initGUI() {
		lineChart.setTitle("物理内存使用记录");
		lineChart.setShadowOffset(0);
		lineChart.setYScaleMinValue(0);
		lineChart.setYScaleMaxValue(100);
		lineChart.setYScaleValueGap(20);
		lineChart.setYAxisVisible(true);
		lineChart.setXScaleMinValue(0);
		lineChart.setXScaleMaxValue(19);
		lineChart.setXScaleValueGap(1);
		lineChart.setXAxisVisible(false);
		lineChart.setXScaleLineVisible(true);
		lineChart.setBackgroundVisible(true);
		lineChart.setBackgroundGradient(true);
		lineChart.getDataBox().addElement(element);
		lineChart.getLegendPane().setVisible(false);

		percentChart.setGradient(true);
		percentChart.setPercentLabelCenter(true);
		percentChart.setTitle("物理内存");
		percentChart.getDataBox().addElement(element);
		percentChart.setPreferredSize(new Dimension(10, 50));

		this.setLayout(new BorderLayout(4, 5));
		this.add(percentChart, BorderLayout.NORTH);
		this.add(lineChart, BorderLayout.CENTER);
	}

	public JPanel getTitlePanel() {
		return new TitlePanel("内存", this);
	}

	/**
	 * 设置内存值
	 * 此值应该>=0 & <=100
	 * @param value
	 */
	public void setValue(double value) {
		/*		Color color = Color.GREEN;
				if (value > 60) {
					color = Color.ORANGE;
				}
				if (value > 80) {
					color = Color.RED;
				}
				element.putChartColor(color);*/

		element.putChartValue(value);
		element.addChartBubble(new Bubble(index, value));
		double max = lineChart.getXScaleMaxValue();
		if (index > max) {
			lineChart.setXScaleMinValue(index - 19);
			lineChart.setXScaleMaxValue(index);
		}
		index++;
	}
}
