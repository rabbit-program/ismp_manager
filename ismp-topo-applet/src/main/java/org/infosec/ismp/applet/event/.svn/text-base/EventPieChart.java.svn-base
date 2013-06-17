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
import twaver.TaskAdapter;
import twaver.TaskScheduler;
import twaver.chart.AbstractChart;
import twaver.chart.PieChart;

/**
 * 实现域事件统计饼图
 * @author wudengke 2009-6-29
 *
 */
public class EventPieChart extends JApplet {

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
		PieChartPanel pieChartPanel = new PieChartPanel(starttime,endtime,bureauId);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(pieChartPanel, BorderLayout.CENTER);
		(new Thread(pieChartPanel)).start();
	}

	public void start() {

	}

	public void stop() {

	}
}

class PieChartPanel extends JPanel implements Runnable{
	Timestamp starttime = null;
	Timestamp endtime = null;
	private Ilnvoker realTime = (Ilnvoker) HttpInvokerProxyFactoryBeanUtil
	.getService(ServerConfig.getServerPath()
			+ "/remoting/eventInvokerServiceRemoting", Ilnvoker.class);

	private TDataBox box = new TDataBox();
	private PieChart pie = new PieChart(box);

	public PieChartPanel(Timestamp starttime,Timestamp endtime,String bureauId) {
		this.starttime = starttime;
		this.endtime = endtime;
		this.setLayout(new BorderLayout());

//		new MouseListener(pie);

		pie.setTitle("<html><font color='black'>域事件统计(件)</html>");
		pie.getTitleLabel().setBackground(null);
		pie.setLegendOrientation(TWaverConst.LABEL_ORIENTATION_HORIZONTAL);
		pie.setValueTextVisible(false);
		pie.setEnableXZoom(false);
		pie.setEnableXTranslate(false);
		pie.setEnableYZoom(false);
		pie.setEnableYTranslate(false);
		pie.setValueTextVisible(true);
		pie.setHollow(true);
		
		List<Object> list = realTime.StatisticsDomain(starttime,endtime,Integer.valueOf(bureauId));
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				addNode(obj[0].toString().trim(), Double.parseDouble(String
						.valueOf(obj[1])),i);
			}

		}
		this.add(pie, BorderLayout.CENTER);
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

	private void addNode(String name, double value,int i) {
		Element element = new Node();
		element.setName(name);
		element.setVisible(true);
		element.putChartValue(value);
		switch (i) {
			case 0:
				element.putChartColor(Color.RED);
				break;
			case 1:
				element.putChartColor(Color.YELLOW);
				break;
			case 2:
				element.putChartColor(Color.GREEN);
				break;
			case 3:
				element.putChartColor(Color.PINK);
				break;
			case 4:
				element.putChartColor(Color.CYAN);
				break;
			case 5:
				element.putChartColor(Color.BLUE);
				break;
			case 6:
				element.putChartColor(Color.GRAY);
				break;
			case 7:
				element.putChartColor(Color.MAGENTA);
				break;
			case 8:
				element.putChartColor(Color.ORANGE);
				break;
			default:element.putChartColor(TWaverUtil.getRandomColor());
		}
		
		box.addElement(element);
	}
	public void run() {
		TaskScheduler.getInstance().register(new TaskAdapter() {
			
			
			public void run(long clock) {
				pie.setStartAngle(pie.getStartAngle() + 10);
			}
			public int getInterval() {
				return 2000;
			}
		});
		if (box.getSelectionModel().size() == 0) {
			pie.setStartAngle(pie.getStartAngle() + 1);
		}
	}
}
