package org.infosec.ismp.applet.manager.component.panel.info.file;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.infosec.ismp.applet.manager.component.panel.component.TitlePanel;
import org.infosec.ismp.applet.manager.component.panel.info.AbstractTitlePanel;
import org.infosec.ismp.applet.manager.component.panel.utils.ImageToolTipTabbedPanel;

import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.chart.BarChart;
import twaver.chart.PieChart;

/**
 * 文件系统面板
 * 接口
 * setFileList
 * addFile
 * clearFiles
 */
public class FilePanel extends AbstractTitlePanel {
	private List fileList = new ArrayList();
	private JPanel piePanel = new JPanel();
	private JPanel barPanel = new JPanel();
	private FileBarChart chart = new FileBarChart();

	public FilePanel() {
		initGUI();
	}

	private void initGUI() {
		JTabbedPane pane = new ImageToolTipTabbedPanel();
		pane.addTab("饼图", piePanel);
		pane.addTab("柱状图", barPanel);

		this.setLayout(new BorderLayout());
		this.add(pane, BorderLayout.CENTER);

		setPanel();
	}

	private void setPanel() {
		setPiePanel();
		setBarChart();
		this.validate();
		this.repaint();
	}

	private void setPiePanel() {
		int size = fileList.size();
		piePanel.removeAll();
		piePanel.setLayout(new GridLayout(1, size, 5, 5));
		for (int i = 0; i < size; i++) {
			FileElement element = (FileElement) fileList.get(i);
			FilePieChart chart = new FilePieChart(element);
			piePanel.add(chart);
		}
	}

	private void setBarChart() {
		chart = new FileBarChart();
		barPanel.removeAll();
		barPanel.setLayout(new BorderLayout());
		barPanel.add(chart);
		barPanel.validate();
		barPanel.repaint();
	}

	public JPanel getTitlePanel() {
		return new TitlePanel("文件系统", this);
	}

	/**
	 * 设置文件系统列表，list中的每个类型都是是FileElement，对应于一个piechart和barchart的一个轴。
	 * 
	 * @param fileList
	 */
	public void setFileList(List fileList) {
		this.fileList = fileList;
		if (fileList == null) {
			this.fileList = new ArrayList();
		}
		setPanel();
	}

	/**
	 * 添加一个文件信息。
	 * 
	 * @param element
	 */
	public void addFile(FileElement element) {
		if (fileList.contains(element)) {
			return;
		}
		fileList.add(element);
		FilePieChart pie = new FilePieChart(element);
		piePanel.add(pie);
		piePanel.validate();
		piePanel.repaint();

		setBarChart();
	}

	/**
	 * 清除所有文件系统信息。
	 */
	public void clearFiles() {
		this.fileList = new ArrayList();
		setPanel();
	}

	/**
	 * 文件系统，柱状图
	 */
	class FileBarChart extends JPanel {
		private TDataBox box = new TDataBox();
		private BarChart chart = new BarChart(box);
		private Node usedNode = new Node();
		private Node unUsedNode = new Node();

		public FileBarChart() {
			initGUI();
			final int size = fileList.size();
			for (int i = 0; i < size; i++) {
				FileElement element = (FileElement) fileList.get(i);
				element.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						if ((FileElement.FILEPREFIX + FileElement.FILEUNUSED).equals(TWaverUtil.getPropertyName(evt))) {
							setBarValues();
						} else if ((FileElement.FILEPREFIX + FileElement.FILEUSED).equals(TWaverUtil.getPropertyName(evt))) {
							setBarValues();
						} else if (TWaverConst.PROPERTYNAME_NAME.equals(evt.getPropertyName())) {
							setBarValues();
						}
					}
				});
			}
			setBarValues();
		}

		public void setBarValues() {
			int size = fileList.size();
			List xscaleList = new ArrayList();
			usedNode.clearChartValues();
			unUsedNode.clearChartValues();
			for (int i = 0; i < size; i++) {
				FileElement element = (FileElement) fileList.get(i);
				xscaleList.add(element.getName());
				usedNode.addChartValue(element.getUsedFile());
				unUsedNode.addChartValue(element.getUnUsedFile());
			}
			chart.setXScaleTextList(xscaleList);
		}

		private void initGUI() {
			usedNode.setName("已用");
			unUsedNode.setName("未用");
			usedNode.putChartColor(Color.RED);
			unUsedNode.putChartColor(Color.GREEN.darker());
			box.addElement(usedNode);
			box.addElement(unUsedNode);

			chart.setOpaque(false);
			chart.setBarType(TWaverConst.BAR_TYPE_PERCENT);
			chart.setBackgroundGradient(true);
			chart.setBackgroundVisible(true);
			chart.setValueTextCenter(true);

			this.setLayout(new BorderLayout());
			this.add(chart);
		}
	}
}

/**
 * 文件系统，饼图
 */
class FilePieChart extends JPanel {
	private TDataBox box = new TDataBox();
	private PieChart chart = new PieChart(box);
	private FileElement element;
	private Node usedNode = new Node();
	private Node unUsedNode = new Node();

	public FilePieChart(FileElement element) {
		this.element = element;

		initData();
		initGUI();

		/**
		 * 如有数据变化，更新到当前piechart
		 */
		this.element.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (TWaverUtil.getPropertyName(evt).equals(FileElement.FILEPREFIX + FileElement.FILEUNUSED)) {
					Double unUsed = (Double) evt.getNewValue();
					unUsedNode.putChartValue(unUsed.doubleValue());
					
					unUsedNode.setName("未用("+unUsed+")");
				} else if (TWaverUtil.getPropertyName(evt).equals(FileElement.FILEPREFIX + FileElement.FILEUSED)) {
					Double used = (Double) evt.getNewValue();
					usedNode.putChartValue(used.doubleValue());
					usedNode.setName("已用("+used+")");
					
				}
			}
		});
	}

	private void initData() {
//		usedNode.setName("已用");
//		unUsedNode.setName("未用");
		unUsedNode.setName("未用("+element.getUnUsedFile()+")");
		usedNode.setName("已用("+element.getUsedFile()+")");
		usedNode.putChartColor(Color.RED);
		usedNode.putChartValue(element.getUsedFile());
		unUsedNode.putChartColor(Color.GREEN.darker());
		unUsedNode.putChartValue(element.getUnUsedFile());
		box.addElement(usedNode);
		box.addElement(unUsedNode);
	}
	
	private void initGUI() {
		chart.set3D(true);
		chart.setTitle(element.getName());
		chart.setValueTextPercent(true);

		this.setLayout(new BorderLayout());
		this.add(chart);
	}
}
