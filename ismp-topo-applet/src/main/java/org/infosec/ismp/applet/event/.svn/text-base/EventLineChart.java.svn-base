package org.infosec.ismp.applet.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JApplet;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.chart.LineChart;
/**
 * EventLineChart
 * @author sshanshan
 * @date 2009-06-20
 * @version 1.0
 */
public class EventLineChart extends JApplet {

	public void init() {
		LineChartPanel lineChartPanel = new LineChartPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(lineChartPanel, BorderLayout.CENTER);

	}

	public void start() {

	}

	public void stop() {

	}
}

class LineChartPanel extends JPanel {
	private JLabel Label1 = new JLabel("曲线1");
	private JLabel Label2 = new JLabel("曲线2");
	private JLabel Label3 = new JLabel("曲线3");
	private JLabel Label4 = new JLabel("曲线4");
	private JLabel Label5 = new JLabel("曲线5");

	List x = new ArrayList();

	Element line1 = new Node();
	Element line2 = new Node();
	Element line3 = new Node();
	Element line4 = new Node();
	Element line5 = new Node();
	Element value = new Node();
	LineChart lineChart = new LineChart();

	public LineChartPanel() {

		chartInit();

	}

	public void chartInit() {
		try {
			InputStream in = TWaverUtil.getInputStream("/org/infosec/ismp/applet/event/google.txt");
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] ss = line.split("\\,");
				x.add(0, ss[0]);
				line1.getChartValues().add(0, Double.valueOf(ss[3]));
				line2.getChartValues().add(0, Double.valueOf(ss[1]));
				line3.getChartValues().add(0, Double.valueOf(ss[4]));
				line4.getChartValues().add(0, Double.valueOf(ss[2]));
				line5.getChartValues().add(0, Double.valueOf(ss[3]));
				value.getChartValues().add(0, Double.valueOf(ss[4]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		line1.setName("曲线1");
		line2.setName("曲线2");
		line3.setName("曲线3");
		line4.setName("曲线4");
		line5.setName("曲线5");

		line1.putChartColor(Color.GREEN);
		line2.putChartColor(Color.RED);
		line3.putChartColor(Color.YELLOW);
		line4.putChartColor(Color.BLUE);
		line5.putChartColor(Color.ORANGE);

		
		lineChart.setEnableXTranslate(false);
		lineChart.setEnableYTranslate(false);
		lineChart.setEnableXZoom(false);
		lineChart.setEnableYZoom(false);
		lineChart.setXScaleTextSpanCount(0);
		lineChart.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);

		lineChart.setXScaleTextList(x);
		TDataBox box = lineChart.getDataBox();
		box.addElement(line1);
		box.addElement(line2);
		box.addElement(line3);
		box.addElement(line4);
		box.addElement(line5);

		JPanel controlPane = TWaverUtil.createVerticalPanel(2);
		controlPane.add(createCheckBox(line1, box));
		controlPane.add(createCheckBox(line2, box));
		controlPane.add(createCheckBox(line3, box));
		controlPane.add(createCheckBox(line4, box));
		controlPane.add(createCheckBox(line5, box));

		final JCheckBox showValue = new JCheckBox("Show Value");
		controlPane.add(showValue);
		showValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChart.setValueTextVisible(showValue.isSelected());
			}
		});
		final JCheckBox showInflexion = new JCheckBox("Show Inflexion");
		controlPane.add(showInflexion);
		showInflexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChart.setInflexionVisible(showInflexion.isSelected());
			}
		});

		this.setLayout(new BorderLayout());
		this.add(lineChart, BorderLayout.CENTER);
		this.add(controlPane, BorderLayout.WEST);
	}

	private JCheckBox createCheckBox(final Element element, final TDataBox box) {
		final JCheckBox checkBox = new JCheckBox(element.getName(), box
				.contains(element));
		checkBox.setForeground(element.getChartColor());
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					box.addElement(element);
				} else {
					box.removeElement(element);
				}
			}
		});
		return checkBox;
	}
}