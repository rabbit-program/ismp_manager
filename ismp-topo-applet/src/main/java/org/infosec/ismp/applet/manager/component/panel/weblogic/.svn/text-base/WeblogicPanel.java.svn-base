package org.infosec.ismp.applet.manager.component.panel.weblogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import org.infosec.ismp.applet.manager.application.dynamicInfo.DynamicInfo;
import org.infosec.ismp.applet.manager.component.panel.database.OraclePanel;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;
import org.infosec.ismp.applet.manager.component.panel.utils.TableUtil;
import org.infosec.ismp.applet.manager.component.panel.view.BorderPanel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicDeviceStatus;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicJdbcConnectionPoolStatus;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicJvmStatus;
import org.infosec.ismp.manager.rmi.snmp.model.weblogic.WeblogicThreadPoolStatus;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceInformation;

import twaver.swing.TableLayout;

@SuppressWarnings("serial")
public class WeblogicPanel extends JPanel{
	private List<WeblogicThreadPoolStatus> threadPoolsStatus;
	private List<WeblogicJvmStatus> jvmsStatus;
	private List<WeblogicJdbcConnectionPoolStatus> jdbcConnectionPoolsStatus;
	private JdbcConnectionPoolsStatusPanel jdbcConnectionPoolsStatusPanel = new JdbcConnectionPoolsStatusPanel("JDBC连接池状态");
	private ThreadPoolsStatusPanel threadPoolsStatusPanel = new ThreadPoolsStatusPanel("线程状态");
	private JvmsStatusPanel jvmsStatusPanel = new JvmsStatusPanel("JVM状态");
	private NodeModel node;
	private boolean flag ;
	private DataRefresh dataRefresh;
	public WeblogicPanel(NodeModel node){
		this.node = node;
		initGUI();
		node.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getPropertyName().equals("CP:"+NodeModel.DEVICE_INFORMATION)) {
					DeviceInformation deviceInfo = (DeviceInformation)evt.getNewValue();
					if(flag) {
						dataRefresh = new DataRefresh(deviceInfo);
						dataRefresh.start();
						flag = false;
					}
					dataRefresh.setDeviceInfo(deviceInfo);
				}
			}
			
		});
	}
	
	/**
	 * 引用数据线程。
	 */
	class DataRefresh extends Thread {
		DeviceInformation deviceInfo = null;
		public DataRefresh(DeviceInformation info) {
			this.deviceInfo = info;
		}
		public void run() {
			Timer timer = new Timer(5000, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							if(deviceInfo.getSnmpDeviceStatus() != null && deviceInfo.getSnmpDeviceStatus().getWeblogicDeviceStatus() != null) {
								WeblogicPanel.this.reflashData(deviceInfo.getSnmpDeviceStatus().getWeblogicDeviceStatus());
								node.setImage(node.activeBigICO());
								node.setIcon(node.activeSmallICO());
							} else {
								node.setImage("");
								node.setIcon("");
							}
							
						}
					});
				}
			});
			timer.start();
			DynamicInfo.addDynameTimer(node.getNodeId(), timer);
		}
		public void setDeviceInfo(DeviceInformation deviceInfo) {
			this.deviceInfo = deviceInfo;
		}
	}
	private void initGUI() {
		double rows[] = { TableLayout.FILL,
				TableLayout.FILL, TableLayout.FILL };
		double cols[] = { TableLayout.FILL };
		TableLayout layout = new TableLayout(cols, rows, 10, 15);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setLayout(layout);

		this.add(jdbcConnectionPoolsStatusPanel, "0,0,0,0");
		this.add(threadPoolsStatusPanel, "0,1");
		this.add(jvmsStatusPanel,"0,2");
	}
	
	public void reflashData(WeblogicDeviceStatus weblogicDeviceStatus) {
		this.threadPoolsStatus = weblogicDeviceStatus.getThreadPoolStatus();
		this.jvmsStatus = weblogicDeviceStatus.getJvmStatus();
		this.jdbcConnectionPoolsStatus = weblogicDeviceStatus.getJdbcConnectionPoolStatus();
		threadPoolsStatusPanel.updateField();
		jvmsStatusPanel.updateField();
		jdbcConnectionPoolsStatusPanel.updateField();
		
	}
	
	class JdbcConnectionPoolsStatusPanel extends BorderPanel {
		private Object[][] data;
		private String[] columnNames = { "JDBC连接池名称", "JDBC连接池类型", "活动连接数",
				"等待连接数", "连接池的最大容量", "连接的平均时间", "丢失的连接数量",
				"可用连接数", "不可用连接数"  };
		
		private DefaultTableModel model = new DefaultTableModel(data,
				columnNames);
		public JdbcConnectionPoolsStatusPanel(String title) {
			super(title);
			initGUI();
		}
		
		@Override
		public void initGUI() {
			TableUtil.addTable(this,model);
		}

		protected void updateField() {
			if (jdbcConnectionPoolsStatus != null) {
				List<WeblogicJdbcConnectionPoolStatus> list = jdbcConnectionPoolsStatus;
				data = new Object[list.size()][columnNames.length];
				if (list != null && list.size() > 0) {
					int i = 0;
					for (WeblogicJdbcConnectionPoolStatus jdbcConnectionPoolStatus : list) {
						data[i][0] = jdbcConnectionPoolStatus.getName();
						data[i][1] = jdbcConnectionPoolStatus.getType();
						data[i][2] = jdbcConnectionPoolStatus.getActiveConnectionsCount();
						data[i][3] = jdbcConnectionPoolStatus.getWaitingForConnectionCount();
						data[i][4] = jdbcConnectionPoolStatus.getMaxCapacity();
						data[i][5] = jdbcConnectionPoolStatus.getConnectionDelayTime();
						data[i][6] = jdbcConnectionPoolStatus.getLeakedConnectionCount();
						data[i][7] = jdbcConnectionPoolStatus.getNumAvailable();
						data[i][8] = jdbcConnectionPoolStatus.getNumUnavailable();
						i++;
					}

				} else {
					data = null;
				}
			}
			model.setDataVector(data, columnNames);
		}

	}
	
	class ThreadPoolsStatusPanel extends BorderPanel {

		private Object[][] data;
		private String[] columnNames = { "线程池名称", "线程池类型", "正在执行的线程数量",
				"空闲线程数量", "队列请求数量", "队列请求最大容量", "已经完成请求数量"};
		
		private DefaultTableModel model = new DefaultTableModel(data,
				columnNames);
		public ThreadPoolsStatusPanel(String title) {
			super(title);
			initGUI();
		}
		
		@Override
		public void initGUI() {
			TableUtil.addTable(this,model);
		}

		protected void updateField() {
			if (threadPoolsStatus != null) {
				List<WeblogicThreadPoolStatus> list = threadPoolsStatus;
				data = new Object[list.size()][columnNames.length];
				if (list != null && list.size() > 0) {
					int i = 0;
					for (WeblogicThreadPoolStatus threadPoolStatus : list) {
						data[i][0] = threadPoolStatus.getName();
						data[i][1] = threadPoolStatus.getType();
						data[i][2] = threadPoolStatus.getExecuteThreadTotalCount();
						data[i][3] = threadPoolStatus.getExecuteThreadIdleCount();
						data[i][4] = threadPoolStatus.getRequestCount();
						data[i][5] = threadPoolStatus.getRequestCapacity();
						data[i][6] = threadPoolStatus.getCompletedRequestCount();
						i++;
					}

				} else {
					data = null;
				}
			}
			model.setDataVector(data, columnNames);
		}

		
	}
	
	class JvmsStatusPanel extends BorderPanel {

		private Object[][] data;
		private String[] columnNames = { "JVM名称", "JVM类型", "JVM版本",
				"JVM中已使用内存数量(bytes)", "JVM中空闲内存数量(bytes)" };
		
		private DefaultTableModel model = new DefaultTableModel(data,
				columnNames);
		public JvmsStatusPanel(String title) {
			super(title);
			initGUI();
		}
		
		@Override
		public void initGUI() {
			TableUtil.addTable(this,model);
		}

		protected void updateField() {
			if (jvmsStatus != null) {
				List<WeblogicJvmStatus> list = jvmsStatus;
				data = new Object[list.size()][columnNames.length];
				if (list != null && list.size() > 0) {
					int i = 0;
					for (WeblogicJvmStatus jvmStatus : list) {
						data[i][0] = jvmStatus.getName();
						data[i][1] = jvmStatus.getType();
						data[i][2] = jvmStatus.getJavaVersion();
						data[i][3] = jvmStatus.getHeapSizeCurrent();
						data[i][4] = jvmStatus.getHeapFreeCurrent();
						i++;
					}

				} else {
					data = null;
				}
			}
			model.setDataVector(data, columnNames);
		}
	}
	
	public static void main(String[] args) {
		//SJTUUtils.showCompoentInFrame(new WeblogicPanel());
	}
}
