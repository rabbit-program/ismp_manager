package org.infosec.ismp.applet.manager.component.panel.info.cpu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.infosec.ismp.applet.manager.component.panel.component.TitlePanel;
import org.infosec.ismp.applet.manager.component.panel.info.AbstractTitlePanel;
import org.infosec.ismp.applet.manager.component.panel.utils.ImageToolTipTabbedPanel;
import org.infosec.ismp.applet.manager.component.panel.utils.PercentIcon;

import twaver.Element;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.Bubble;
import twaver.chart.BubbleChart;
import twaver.chart.PercentChart;

/**
 * CPU面板
 * 接口
 * setCpuList
 * addCpu
 * clearCpuList
 * setValue
 */
public class CPUPanel extends AbstractTitlePanel {

	private List cpuList = new ArrayList();
	private JTabbedPane pane = new ImageToolTipTabbedPanel();
	private Map elementPanelMap = new HashMap();

	public CPUPanel() {
		pane.setBackground(Color.WHITE);
		pane.setOpaque(false);

		this.setLayout(new BorderLayout());
		this.add(pane);
	}

	private void setTab() {
		pane.removeAll();
		elementPanelMap.clear();
		int size = cpuList.size();
		for (int i = 0; i < size; i++) {
			Element node = (Element) cpuList.get(i);
			CpuChartPanel cpuChart = new CpuChartPanel(node);
			elementPanelMap.put(node, cpuChart);
			pane.addTab("", cpuChart.getIcon(), cpuChart);
		}
		pane.invalidate();
		pane.repaint();
	}

	/**
	 * 设置cpulist，cpulist中存储的是element表示每个cpu的信息。
	 * 和每个tab页面相对应
	 * @param statusList
	 */
	public void setCpuList(List statusList) {
		if (statusList != null) {
			this.cpuList = statusList;
		} else {
			this.cpuList = new ArrayList();
		}
		setTab();
	}

	/**
	 * 设置某个cpu的值
	 * 
	 * @param element			要设置值的cpu
	 * @param value				具体的值
	 * @throws RuntimeException
	 */
	public void setValue(Element element, double value) throws RuntimeException {
		if (!cpuList.contains(element)) {
			throw new RuntimeException("The Element is not contained, please add first");
		}
		CpuChartPanel chartPanel = (CpuChartPanel) elementPanelMap.get(element);
		chartPanel.setValue(value);
		pane.repaint();
	}

	/**
	 * 添加一个cpu，这会增加一个对应的tab页面
	 * 
	 * @param element	要添加的cpu
	 */
	public void addCpu(Element element) {
		if (cpuList.contains(element)) {
			return;
		}
		this.cpuList.add(element);
		CpuChartPanel cpuChart = new CpuChartPanel(element);
		pane.addTab("", cpuChart.getIcon(), cpuChart);
		elementPanelMap.put(element, cpuChart);
	}

	/**
	 * 清空所有的cpu信息。
	 */
	public void clearCpuList() {
		this.cpuList = new ArrayList();
		setTab();
	}

	public JPanel getTitlePanel() {
		return new TitlePanel("CPU", this);
	}

}

/**
 * cpu信息面板，左侧是一个percentchart，右侧是一个linechart
 */
class CpuChartPanel extends JPanel {
	private TDataBox box = new TDataBox();
	private BubbleChart lineChart = new BubbleChart(box) {
		protected String getValueText(Element element, Bubble bubble, int index) {
			return super.getValueText(element, bubble, index) + "%";
		}

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
	private PercentChart percentChart = new PercentChart(box) {
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
	private PercentIcon icon = new PercentIcon();
	private int index = 0;
	private Element element;

	public CpuChartPanel(Element element) {
		this.element = element;
		element.putChartColor(Color.GREEN);
		box.addElement(element);
		icon.setText(element.getName());
		element.putChartPercentStyle(TWaverConst.PERCENT_STYLE_SEGMENT);
		setIcon(element);
		initGUI();
		element.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				Element element = (Element) evt.getSource();
				if (TWaverConst.PROPERTYNAME_CHART_VALUES.equals(evt.getPropertyName())) {
					List list = new ArrayList(element.getChartValues());
					int size = list.size();
					double xmin = lineChart.getXScaleMinValue();
					for (int i = size - 1; i >= 0; i--) {
						Object obj = list.get(i);
						if (obj instanceof Bubble) {
							Bubble bubble = (Bubble) obj;
							if (bubble.getX() < xmin) {
								list.remove(bubble);
							}
						}
					}
					element.putChartValues(list);
					setIcon(element);
					lineChart.publishData(false);
				} else if (TWaverConst.PROPERTYNAME_NAME.equals(evt.getPropertyName())) {
					icon.setText(element.getName());
				}
			}
		});
	}

	private void setIcon(Element element) {
		List list = element.getChartValues();
		if (list.size() > 0) {
			Bubble last = (Bubble) list.get(list.size() - 1);
			icon.setValue(last.getY());
		}
	}

	private void initGUI() {

		lineChart.getLegendPane().setVisible(false);
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
		//		lineChart.setBackgroundVisible(true);
		lineChart.setBackgroundGradient(true);
		lineChart.setValueTextCenter(true);
		lineChart.setBorder(BorderFactory.createTitledBorder("CPU使用记录"));

		percentChart.setPercentType(TWaverConst.PERCENT_TYPE_VERTICAL);
		percentChart.setSegmentCount(10);
		percentChart.setPreferredSize(new Dimension(80, 50));
		percentChart.setThickness(20);
		percentChart.setBorder(BorderFactory.createTitledBorder("CPU使用"));

		this.setBackground(Color.WHITE);
		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
		this.add(percentChart, BorderLayout.WEST);

	}

	public PercentIcon getIcon() {
		return icon;
	}

	public BubbleChart getChart() {
		return lineChart;
	}

	/**
	 * 设置cpu的值。
	 * 
	 * @param value
	 */
	public void setValue(double value) {
		icon.setValue(value);
		/*	Color color = Color.GREEN;
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
