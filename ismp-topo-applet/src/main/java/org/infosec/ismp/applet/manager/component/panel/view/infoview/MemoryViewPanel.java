package org.infosec.ismp.applet.manager.component.panel.view.infoview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import twaver.Element;
import twaver.ElementAttribute;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.chart.PercentChart;
import twaver.table.TPropertySheet;

/**
 * 内存信息面板
 * 接口
 * setUsedMemeory
 * setMemoryCount
 */
public class MemoryViewPanel extends JPanel {
	private TDataBox dataBox = new TDataBox();
	private Element usedElement = new Node();
	private double memoryCount = 0;
	private double usedMemory = 0;
	private Element attribute = new Node();
	private PercentChart chart = new PercentChart(dataBox) {
		public Color getPercentColor(Element element) {
			Color color = Color.GREEN;
			if (element.getChartValue() >= 60) {
				color = Color.ORANGE;
			}
			if (element.getChartValue() >= 80) {
				color = Color.RED;
			}

			return color;
		}
	};
	private TPropertySheet sheet = new TPropertySheet();

	public MemoryViewPanel() {
		chart.setXGap(20);
		chart.setThickness(100);
		chart.setGradient(true);
		dataBox.addElement(usedElement);
		chart.setSpareFill(true);
		chart.setSegmentCount(20);

		usedElement.putChartPercentStyle(TWaverConst.PERCENT_STYLE_SEGMENT);

		initSheet();
		initGUI();
	}

	private void initGUI() {
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new BorderLayout());

		JSplitPane pane = new JSplitPane();
		pane.setDividerSize(2);
		pane.setRightComponent(chart);
		pane.setLeftComponent(new JScrollPane(sheet));
		pane.setDividerLocation(300);

		this.add(pane, BorderLayout.CENTER);
	}

	private void initSheet() {
		sheet.setElement(attribute);
		List list = new ArrayList();
		list.add(getElementaAttribute("内存容量(KByte)", "all"));
		list.add(getElementaAttribute("内存已用容量(KByte)", "used"));
		sheet.registerElementClassAttributes(Node.class, list);
	}

	private ElementAttribute getElementaAttribute(String name, String key) {
		ElementAttribute attribute = new ElementAttribute();
		attribute.setDisplayName(name);
		attribute.setClientPropertyKey(key);
		return attribute;
	}

	/**
	 * 设置已用内存
	 * 
	 * @param number
	 */
	public void setUsedMemeory(double number) {
		usedMemory = number;
		if (memoryCount != 0) {
			usedElement.putChartValue(usedMemory / memoryCount * 100);
		} else {
			usedElement.putChartValue(0);
		}
		attribute.putClientProperty("used", number + "");
	}

	/**
	 * 设置内存总量
	 * @param number
	 */
	public void setMemoryCount(double number) {
		memoryCount = number;
		if (memoryCount != 0) {
			usedElement.putChartValue(usedMemory / memoryCount * 100);
		} else {
			usedElement.putChartValue(0);
		}
		attribute.putClientProperty("all", number + "");
	}
}
