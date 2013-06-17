package org.infosec.ismp.applet.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.infosec.ismp.applet.comm.util.ServerConfig;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.chart.LineChart;

/**
 * EventRealTimeChart
 * 
 * @author sshanshan
 * @date 2009-06-20
 * @version 1.0
 */
public class EventRealTimeChart extends JApplet {

	public void init() {
		String serverPath=getParameter("serverPath");
		ServerConfig.init(serverPath);
//		ServerConfig.init("http://localhost:8080/manager-web");
		ChartPanel chartPanel = new ChartPanel();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(chartPanel, BorderLayout.CENTER);
	}

	public void start() {

	}

	public void stop() {

	}
}

class ChartPanel extends JPanel implements Runnable ,ActionListener{
	Thread thread = null;
	JLabel Label1 = new JLabel("曲线1");
	JLabel Label2 = new JLabel("曲线2");
	JLabel Label3 = new JLabel("曲线3");
	JLabel Label4 = new JLabel("曲线4");
	JLabel Label5 = new JLabel("曲线5");
	JLabel level = new JLabel("回放速率:");

	JSlider slider = new JSlider(JSlider.HORIZONTAL,0,4,0);
	Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();   
    
	JButton redo = new JButton("重放");
	JButton stop = new JButton("停止");
	
	List x = new ArrayList();
	TDataBox box1 = null;

	Element line1 = new Node();
	Element line2 = new Node();
	Element line3 = new Node();
	Element line4 = new Node();
	Element line5 = new Node();
	Element value = new Node();
	LineChart lineChart = new LineChart();
	HistoryChart historyChart = new HistoryChart(lineChart);

	public ChartPanel() {
		thread = new Thread(this);
		thread.start();
		chartInit();
	}

	public void chartInit() {
		try {
			/*
			 * InputStream in = TWaverUtil.getInputStream(
			 * "/edu/sjtu/infosec/ismp/manager/applet/event/google.txt");
			 * BufferedReader reader = new BufferedReader( new
			 * InputStreamReader(in)); String line = null; while ((line =
			 * reader.readLine()) != null) { String[] ss = line.split("\\,");
			 * x.add(0, ss[0]); line1.getChartValues().add(0,
			 * Double.valueOf(ss[3])); line2.getChartValues().add(0,
			 * Double.valueOf(ss[1])); line3.getChartValues().add(0,
			 * Double.valueOf(ss[4])); line4.getChartValues().add(0,
			 * Double.valueOf(ss[2])); line5.getChartValues().add(0,
			 * Double.valueOf(ss[3])); value.getChartValues().add(0,
			 * Double.valueOf(ss[4]));
			 */
			/*
			 * addLine1(1.0); addLine2(2.0); addLine3(3.0); addLine4(4.0);
			 * addLine5(5.0);
			 */
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

		historyChart.setXScaleTextList(x);
		box1 = historyChart.getDataBox();
		box1.addElement(line1);
		box1.addElement(line2);
		box1.addElement(line3);
		box1.addElement(line4);
		box1.addElement(line5);

		lineChart.setXScaleTextList(x);
		TDataBox box2 = lineChart.getDataBox();
		box2.addElement(line1);
		box2.addElement(line2);
		box2.addElement(line3);
		box2.addElement(line4);
		box2.addElement(line5);



		labelTable.put(0, new JLabel("慢"));   
	    labelTable.put(1, new JLabel("较慢"));   
	    labelTable.put(2, new JLabel("中"));   
	    labelTable.put(3, new JLabel("较快"));   
	    labelTable.put(4, new JLabel("快"));   
		slider.setPaintLabels(true); 
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing(1);
		slider.setLabelTable(labelTable);
		slider.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent evt){
				JSlider source = (JSlider)evt.getSource();
				if (source.getValueIsAdjusting() == false){
					System.out.println(source.getValue());
				}
			}
		});

		
		JPanel controlPane = TWaverUtil.createVerticalPanel(2);
		controlPane.add(createCheckBox(line1, box1, box2));
		controlPane.add(createCheckBox(line2, box1, box2));
		controlPane.add(createCheckBox(line3, box1, box2));
		controlPane.add(createCheckBox(line4, box1, box2));
		controlPane.add(createCheckBox(line5, box1, box2));

		final JCheckBox showValue = new JCheckBox("显示数值");
		controlPane.add(showValue);
		showValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChart.setValueTextVisible(showValue.isSelected());
			}
		});
		final JCheckBox showInflexion = new JCheckBox("显示顶点");
		controlPane.add(showInflexion);
		showInflexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChart.setInflexionVisible(showInflexion.isSelected());
			}
		});
		
		redo.addActionListener(this);
		stop.addActionListener(this);
		redo.setEnabled(true);
    	stop.setEnabled(false);
    	
    	this.setLayout(new BorderLayout());
    	
    	JPanel west = new JPanel();
    	west.setLayout(new BorderLayout());
		JPanel control = new JPanel();
		GridBagLayout grid = new GridBagLayout();
        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.fill = GridBagConstraints.BOTH;
        cons.insets = new Insets(10, 10, 10, 10);
        control.setLayout(grid);

        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 2;
        cons.weightx = 1;
        cons.weighty = 0;
        grid.setConstraints(controlPane, cons);
        control.add(controlPane);
        
        cons.gridy = 1;
        cons.gridwidth = 1;
        grid.setConstraints(level, cons);
        control.add(level);
        
        cons.gridy = 2;
        cons.gridwidth = 2;
        grid.setConstraints(slider, cons);
        control.add(slider);
        
        cons.gridy = 3;
        cons.gridwidth = 1;
        grid.setConstraints(redo, cons);
        control.add(redo);
        
        cons.gridx = 1;
        grid.setConstraints(stop, cons);
        control.add(stop);
		
        west.add(control, BorderLayout.NORTH);
        
		JPanel chart = new JPanel(new GridLayout(2, 1));
		chart.add(historyChart);
		chart.add(lineChart);
		
		this.add(west, BorderLayout.WEST);
		
		this.add(chart, BorderLayout.CENTER);

	}

	private JCheckBox createCheckBox(final Element element,
			final TDataBox box1, final TDataBox box2) {
		final JCheckBox checkBox = new JCheckBox(element.getName(), box1
				.contains(element));
		checkBox.setForeground(element.getChartColor());
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					box1.addElement(element);
					box2.addElement(element);
				} else {
					box1.removeElement(element);
					box2.removeElement(element);
				}
			}
		});
		return checkBox;
	}

	public class HistoryChart extends LineChart {
		private int valuesCount = 0;
		private LineChart rangeChart = null;
		private Point startPoint = null;
		private Point endPoint = null;
		private Point lastPoint = null;

		public void paintChart(Graphics2D g2d, int width, int height) {
			super.paintChart(g2d, width, height);
			if (startPoint != null && endPoint != null) {
				Rectangle bounds = this.getBackgroundBounds();
				g2d.setColor(new Color(0, 255, 0, 128));
				int x = Math.min(startPoint.x, endPoint.x);
				int y = bounds.y;
				int w = Math.abs(endPoint.x - startPoint.x);
				int h = bounds.height;
				g2d.fillRect(x, y, w, h);
			}

		}

		private boolean isValidEvent(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				Rectangle bounds = this.getBackgroundBounds();
				bounds.grow(1, 1);
				if (bounds.contains(e.getPoint())) {
					return true;
				}
			}
			return false;
		}

		private boolean isInsideEvent(MouseEvent e) {
			if (startPoint != null && endPoint != null) {
				if (e.getX() >= startPoint.x && e.getX() <= endPoint.getX()) {
					return true;
				}
				if (e.getX() >= endPoint.x && e.getX() <= startPoint.getX()) {
					return true;
				}
			}
			return false;
		}

		public void mousePressed(MouseEvent e) {
			lastPoint = null;
			if (isValidEvent(e)) {
				if (isInsideEvent(e)) {
					this.lastPoint = e.getPoint();
				} else {
					this.startPoint = e.getPoint();
					this.endPoint = e.getPoint();
					this.lastPoint = null;
				}
				this.changeRange();
			}
		}

		public void mouseDragged(MouseEvent e) {
			if (isValidEvent(e) && this.startPoint != null) {
				if (lastPoint != null) {
					int offset = this.lastPoint.x - e.getX();
					this.startPoint.x -= offset;
					this.endPoint.x -= offset;
					this.lastPoint = e.getPoint();
				} else {
					this.endPoint = e.getPoint();
				}
				this.changeRange();
			}
		}

		private void changeRange() {
			this.getChartPane().repaint();
			System.out.println("startPoint.x = " + startPoint.x);
			System.out.println("endPoint.x = " + endPoint.x);
			if (this.startPoint.x == this.endPoint.x) {
				this.rangeChart.setStartIndex(0);
				this.rangeChart.setEndIndex(Integer.MAX_VALUE);
				this.rangeChart.setXScaleTextSpanCount(0);
			} else {
				double x1 = this.getStartX();
				double x2 = this.getEndX();
				System.out.println("x1 = " + x1);
				System.out.println("x2 = " + x2);
				double w = (x2 - x1) / (this.valuesCount - 1);
				System.out.println("this.valuesCount = " + this.valuesCount);
				System.out.println("w = " + w);
				int s = (int) ((startPoint.x - x1) / w);
				int e = (int) ((endPoint.x - x1) / w);
				if (s > e) {
					int tmp = e;
					e = s;
					s = tmp;
				}
				if (s < 0) {
					s = 0;
				}
				if (e > this.valuesCount) {
					e = this.valuesCount;
				}

				this.rangeChart.setStartIndex(s);
				System.out.println("startIndex = " + s);
				this.rangeChart.setEndIndex(e);
				System.out.println("endIndex = " + e);
				int span = Math.max(1, 15 * (e - s)
						/ rangeChart.getBackgroundBounds().width - 1);
				this.rangeChart.setXScaleTextSpanCount(span);
				this.rangeChart.publishData();
				this.rangeChart.repaint();
			}
		}

		public HistoryChart(LineChart rangeChart) {
			this.rangeChart = rangeChart;
			this.setEnableXTranslate(false);
			this.setEnableXZoom(false);
			this.setEnableYTranslate(false);
			this.setEnableYZoom(false);
			this.setLineType(TWaverConst.LINE_TYPE_AREA);
			this.setValueSpanCount(0);
			this.setXScaleTextSpanCount(0);
			this.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_RIGHT);
			this.setLowerLimit(0);
			this.setYScaleTextVisible(true);
			this.setYScaleValueGap(100);
			this.setLegendLayout(TWaverConst.LEGEND_LAYOUT_VERTICAL);
			this.getLegendPane().setVisible(false);
			this.setEnableToolTipText(false);
		}
	}

	public void addX(String name) {
		if (x.size() > 20) {
			x.remove(0);
		}
		x.add(name);
		this.historyChart.valuesCount++;
	}

	public void addLine1(double d1) {
		if (line1.getChartValues().size() > 20) {
			line1.getChartValues().remove(0);
		}
		line1.getChartValues().add(line1.getChartValues().size(), d1);
	}

	public void addLine2(double d2) {
		if (line2.getChartValues().size() > 20) {
			line2.getChartValues().remove(0);
		}
		line2.getChartValues().add(line2.getChartValues().size(), d2);
	}

	public void addLine3(double d3) {
		if (line3.getChartValues().size() > 20) {
			line3.getChartValues().remove(0);
		}
		line3.getChartValues().add(line3.getChartValues().size(), d3);
	}

	public void addLine4(double d4) {
		if (line4.getChartValues().size() > 20) {
			line4.getChartValues().remove(0);
		}
		line4.getChartValues().add(line4.getChartValues().size(), d4);
	}

	public void addLine5(double d5) {
		if (line5.getChartValues().size() > 20) {

			line5.getChartValues().remove(0);
		}
		line5.getChartValues().add(line5.getChartValues().size(), d5);

	}

	public void run() {
		Thread me = Thread.currentThread();
		int i = 0;
		while (thread == me && i < 10) {
			try {
				System.out.println("××××读入数据××××");

				/*
				 * StateCalcServiceRemoting stateCalcService = new
				 * StateCalcServiceRemoting(); AppletGetStateCalcDate service =
				 * stateCalcService .getStateCalcService(); List<StateCalcBO>
				 * list = service.getDate(); for (StateCalcBO stateCalcBO :
				 * list) { System.out.println(stateCalcBO.getAttaIndex());
				 * addLine1(Double.valueOf(stateCalcBO.getAttaIndex()
				 * .toString()));
				 * 
				 * addLine2(Double.valueOf(stateCalcBO.getHostAbnoIndex()
				 * .toString()));
				 * addLine3(Double.valueOf(stateCalcBO.getSelfFrag()
				 * .toString()));
				 * addLine4(Double.valueOf(stateCalcBO.getThreaten()
				 * .toString()));
				 * addLine5(Double.valueOf(stateCalcBO.getVirusIndex()
				 * .toString())); chartInit(); }
				 */

				/*
				 * addLine1(1.0); addLine2(2.0); addLine3(3.0); addLine4(4.0);
				 * addLine5(5.0);
				 */
				i++;
				addX(i + "");
				addLine1(i + 0.1);
				addLine2(i + 0.2);
				addLine3(i + 0.3);
				addLine4(i + 0.4);
				addLine5(i + 0.5);
				/*
				 * addLine2(2.5); addLine3(3.5); addLine4(4.5); addLine5(5.5);
				 */
				Thread.currentThread().sleep(1000);
				lineChart.publishData();
				historyChart.publishData();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// this.repaint(1000);

		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
        if (source == redo) {
        	redo.setEnabled(false);
        	stop.setEnabled(true);
        }else if (source == stop){
        	redo.setEnabled(true);
        	stop.setEnabled(false);
        }
	}

}