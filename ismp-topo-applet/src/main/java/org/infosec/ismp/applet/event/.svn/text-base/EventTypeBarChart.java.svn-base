package org.infosec.ismp.applet.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.infosec.ismp.applet.comm.util.HttpInvokerProxyFactoryBeanUtil;
import org.infosec.ismp.applet.comm.util.ServerConfig;
import org.infosec.ismp.manager.rmi.event.Ilnvoker;

import twaver.Element;
import twaver.Node;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.chart.AbstractChart;
import twaver.chart.BarChart;

/**
 * 实现事件类型统计柱状图
 * @author wudengke 2009-6-29
 *
 */
public class EventTypeBarChart extends JApplet {

	public void init() {
		Timestamp starttime = null;
		Timestamp endtime = null;
		ServerConfig.init(this.getParameter("serverpath"));
		String s = this.getParameter("beginTime");
		String e = this.getParameter("endTime");
		String bureauId = this.getParameter("bureauId");
//		String s="1994-06-23 11:54:49";
//		String e="2009-09-23 11:58:19";
		starttime = Timestamp.valueOf(s);
		endtime = Timestamp.valueOf(e);
		EventBarChartPanel barChartPanel = new EventBarChartPanel(starttime,endtime,bureauId);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(barChartPanel, BorderLayout.CENTER);
	}

	public void start() {

	}

	public void stop() {

	}
}

class EventBarChartPanel extends JPanel {
	Timestamp starttime = null;
	Timestamp endtime = null;
	private Ilnvoker realTime = (Ilnvoker) HttpInvokerProxyFactoryBeanUtil
	.getService(ServerConfig.getServerPath()
			+ "/remoting/eventInvokerServiceRemoting", Ilnvoker.class);
	private TDataBox box = new TDataBox();
	private BarChart bar = new BarChart(box);
	
	public EventBarChartPanel(Timestamp starttime,Timestamp endtime,String bureauId) {
		this.starttime = starttime;
		this.endtime = endtime;
		this.setLayout(new BorderLayout());

//		new MouseListener(bar);

		bar.setTitle("<html><font color='black'>事件类型统计(件)</html>");
		bar.getTitleLabel().setBackground(null);
		bar.setLegendOrientation(TWaverConst.LABEL_ORIENTATION_HORIZONTAL);
		bar.setValueTextVisible(false);
		bar.setEnableXZoom(false);
		bar.setEnableXTranslate(false);
		bar.setEnableYZoom(false);
		bar.setEnableYTranslate(false);
		bar.setYScaleTextVisible(true);
		bar.setYScaleMinTextVisible(true);
		bar.setYScaleValueGapAutoCalculate(true);
		bar.setValueTextVisible(true);
		
		List<Object> list = realTime.staticticsEventType(starttime,endtime,Integer.valueOf(bureauId));
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				addNode(obj[0].toString().trim(), Double.parseDouble(String
						.valueOf(obj[1])));
			}

		}

		this.add(bar, BorderLayout.CENTER);
	}
	
	public class MouseListener extends MouseMotionAdapter {

		private AbstractChart chart = null;

		public MouseListener(AbstractChart chart) {
			this.chart = chart;
			JLabel label = chart.getTitleLabel();
			label.setOpaque(true);
			label.setForeground(Color.WHITE);
//			this.chart.getChartPane().addMouseMotionListener(this);
		}

		public void mouseMoved(MouseEvent e) {
			Element element = chart.getElementAt(e.getPoint());
			if (element != null) {
				String value = TWaverConst.DEFAULT_INT_FORMATER.format(element
						.getChartValue());
				JLabel label = chart.getTitleLabel();
				label.setText(element.getName() + ":" + value + "$");
				label.setBackground(element.getChartColor());
				chart.getDataBox().getSelectionModel().setSelection(element);
			}
		}
	}

	private void addNode(String name, double value) {
		Element element = new Node();
		element.setName(name);
		element.setVisible(true);
		element.putChartValue(value);
		element.putChartColor(TWaverUtil.getRandomColor());
		box.addElement(element);
	}
}
