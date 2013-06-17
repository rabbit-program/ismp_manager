package org.infosec.ismp.applet.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JApplet;
import javax.swing.JCheckBox;
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
import twaver.chart.LineChart;

/**
 * 实现设备当前事件动态曲线图
 * @author wudengke 2009-6-29
 *
 */
public class EventOneLineChart extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8011047679762657210L;

	public void init() {
		ServerConfig.init(this.getParameter("serverpath"));
//		ServerConfig.init("http://localhost:8080/manager-web");
		String faciIp = this.getParameter("faciIp");
		String bureauId = this.getParameter("bureauId");
		LineOneChartPanel lineChartPanel = new LineOneChartPanel(faciIp,bureauId);
		lineChartPanel.setFaciIp(faciIp);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(lineChartPanel, BorderLayout.CENTER);
		(new Thread(lineChartPanel)).start();
	}

	public void start() {

	}

	public void stop() {

	}
}

class LineOneChartPanel extends JPanel implements Runnable {
	private Ilnvoker realTime = (Ilnvoker) HttpInvokerProxyFactoryBeanUtil
			.getService(ServerConfig.getServerPath()
					+ "/remoting/eventInvokerServiceRemoting", Ilnvoker.class);
	private JLabel Label1 = new JLabel("曲线1");
	
	private String faciIp;
	
	public void setFaciIp(String faciIp) {
		this.faciIp = faciIp;
	}

	final LineChart lineChart = new LineChart();

	List x = new ArrayList();

	Element line1 = new Node();
	Element value = new Node();

	public LineOneChartPanel(String faciIp,String bureauId) {
		chartInit(faciIp,bureauId);

	}
	
	public void chartInit(String faciIp,String bureauId) {
		try {
			List<Object> list = realTime.initRealTimeList(faciIp,Integer.valueOf(bureauId));
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Object[] ss = (Object[]) list.get(i);
					Timestamp tt = (Timestamp) ss[0];
					int hh = tt.getHours();
					int mm = tt.getMinutes();
					int se = tt.getSeconds();
					x.add(hh+":"+mm+":"+se);
					line1.getChartValues().add(line1.getChartValues().size(),
							Double.valueOf(ss[1].toString()));
					if (line1.getChartValues().size() > 15) {
						x.remove(0);
						line1.getChartValues().remove(0);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		line1.setName("设备当前事件量");

		line1.putChartColor(Color.RED);

		lineChart.setEnableXTranslate(false);
		lineChart.setEnableYTranslate(false);
		lineChart.setEnableXZoom(false);
		lineChart.setEnableYZoom(false);
		lineChart.setXScaleTextSpanCount(0);
		lineChart.setXScaleTextOrientation(TWaverConst.LABEL_ORIENTATION_HORIZONTAL);
		lineChart.setYScaleTextVisible(true);

		
		lineChart.setXScaleTextList(x);
		TDataBox box = lineChart.getDataBox();
		box.addElement(line1);

		JPanel controlPane = TWaverUtil.createVerticalPanel(2);
		controlPane.add(createCheckBox(line1, box));

		final JCheckBox showValue = new JCheckBox("显示值");
		controlPane.add(showValue);
		showValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineChart.setValueTextVisible(showValue.isSelected());
			}
		});
		final JCheckBox showInflexion = new JCheckBox("显示拐点");
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

	public void run() {
		Timestamp time = Timestamp.valueOf("2010-11-25 15:14:00.0");
		while (true) {
			List<Object> list = realTime.getDates();
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					Object[] obj = (Object[]) list.get(i);
					if (obj[0].toString().trim().equals(faciIp)) {
						if (!time.equals((Timestamp) obj[2])) {
							time = (Timestamp) obj[2];
							if (line1.getChartValues().size() > 15) {
								x.remove(0);
								line1.getChartValues().remove(0);
							}
							Timestamp tt = (Timestamp) obj[2];
							int hh = tt.getHours();
							int mm = tt.getMinutes();
							int se = tt.getSeconds();
							x.add(hh + ":" + mm + ":" + se);
							line1.getChartValues().add(
									line1.getChartValues().size(),
									Double.valueOf(obj[1].toString()));
						}
					}
				}	
				
				lineChart.publishData();
			}
				
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}