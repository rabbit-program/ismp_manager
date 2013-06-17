package org.infosec.ismp.applet.manager.component.panel.view.infoview;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import twaver.Element;
import twaver.TDataBox;
import twaver.chart.PercentChart;

/**
 * CPU信息一览面板
 * 使用方法：
 * getDataBox
 * setDataBox
 * 通过以上两个方法进行数据设置
 * 参考InfoViewPanel.test
 */
public class CPUViewPanel extends JPanel {
	private TDataBox box = new TDataBox();
	private PercentChart chart = new PercentChart(box) {
		public Color getColor(Element element) {
			Color color = Color.GREEN;
			double value = element.getChartValue();
			if (value > 60) {
				color = Color.ORANGE;
			}
			if (value > 80) {
				color = Color.RED;
			}
			return color;
		}
	};

	public CPUViewPanel() {
		chart.setXGap(20);
		chart.setThickness(30);
		chart.setGradient(true);

		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new BorderLayout());

		this.add(chart, BorderLayout.CENTER);
	}

	public TDataBox getDataBox() {
		return box;
	}

	public void setDataBox(TDataBox box) {
		this.box = box;
		chart.setDataBox(box);
	}

}
