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
import twaver.chart.PieChart;
import twaver.table.TPropertySheet;

/**
 * 硬盘信息一览面板
 * 接口：
 * setUsedDisk
 * setDiskCount
 */
public class DiskViewPanel extends JPanel {

	private TDataBox box = new TDataBox();
	private PieChart chart = new PieChart(box) {
		protected String getFormatedText(Element element, double value) {
			return element.getName() + ":" + super.getFormatedText(element, value);
		}
	};
	private TPropertySheet sheet = new TPropertySheet();
	private Element attribute = new Node();

	private Element used = new Node();
	private Element unUsed = new Node();

	private double usedDisk;
	private double diskCount;

	public DiskViewPanel() {
		initGUI();
		initSheet();
	}

	private void initGUI() {
		chart.set3D(true);
		chart.setValueTextPercent(true);
		chart.getLegendPane().setVisible(false);

		used.putChartColor(Color.RED);
		unUsed.putChartColor(Color.GREEN);
		used.setName("已用");
		unUsed.setName("未用");
		box.addElement(used);
		box.addElement(unUsed);
		

		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setLayout(new BorderLayout());
		JSplitPane  pane = new JSplitPane();
		pane.setDividerSize(2);
		pane.setRightComponent(chart);
		pane.setLeftComponent(new JScrollPane(sheet));
		pane.setDividerLocation(300);
		this.add(pane, BorderLayout.CENTER);
	}

	private void initSheet() {
		sheet.setElement(attribute);
		List list = new ArrayList();
		list.add(getElementaAttribute("硬盘容量(KByte)", "all"));
		list.add(getElementaAttribute("硬盘已用容量(KByte)", "used"));
		sheet.registerElementClassAttributes(Node.class, list);
	}

	private ElementAttribute getElementaAttribute(String name, String key) {
		ElementAttribute attribute = new ElementAttribute();
		attribute.setDisplayName(name);
		attribute.setClientPropertyKey(key);
		return attribute;
	}

	public double getUsedDisk() {
		return usedDisk;
	}

	/**
	 * 设置未使用硬盘容量
	 * 
	 * @param usedDisk
	 */
	public void setUsedDisk(double usedDisk) {
		this.usedDisk = usedDisk;
		used.putChartValue(usedDisk);
		attribute.putClientProperty("used", usedDisk + "");
	}

	public double getDiskCount() {
		return diskCount;
	}

	/**
	 * 设置硬盘容量总数
	 * 
	 * @param diskCount
	 */
	public void setDiskCount(double diskCount) {
		this.diskCount = diskCount;
		unUsed.putChartValue(diskCount - usedDisk);
		attribute.putClientProperty("all", diskCount + "");
	}
}
