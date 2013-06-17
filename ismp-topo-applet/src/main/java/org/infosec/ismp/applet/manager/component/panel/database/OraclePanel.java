package org.infosec.ismp.applet.manager.component.panel.database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import org.infosec.ismp.applet.manager.application.dynamicInfo.DynamicInfo;
import org.infosec.ismp.applet.manager.component.panel.SJTUConst;
import org.infosec.ismp.applet.manager.component.panel.reflash.HostRefreshPanelUI;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;
import org.infosec.ismp.applet.manager.component.panel.utils.TableUtil;
import org.infosec.ismp.applet.manager.component.panel.view.BorderPanel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.NullFilter;
import org.infosec.ismp.manager.rmi.db.model.DatabaseResultStatus;
import org.infosec.ismp.manager.rmi.db.model.DeadLock;
import org.infosec.ismp.manager.rmi.db.model.ProcessMemory;
import org.infosec.ismp.manager.rmi.db.model.Workspace;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceInformation;

import twaver.swing.TableLayout;

/**
 * Orcale 展示面板
 * @author 肖高峰
 *
 */
@SuppressWarnings("serial")
public class OraclePanel extends JPanel {
	private DatabaseResultStatus oracleStatus;
	private OracleInfoPanel oracleInfoPanel = new OracleInfoPanel("Oracle信息");
	private DeadLockPanel deadLockPanel = new DeadLockPanel("死锁");
	private ProcessMemoryPanel processMemeoryPanel = new ProcessMemoryPanel("进程、内存 管理");
	private TablespaceUserPanel tablespaceUserPanel = new TablespaceUserPanel("表空间使用信息");
	private NodeModel node;
	private boolean flag = true ;
	private DataRefresh dataRefresh;
	public OraclePanel(NodeModel node) {
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
							if(deviceInfo.getDatabaseResultStatus() != null) {
								oracleStatus = deviceInfo.getDatabaseResultStatus();
								node.setImage(node.activeBigICO());
								node.setIcon(node.activeSmallICO());
							} else {
								node.setImage("");
								node.setIcon("");
							}
							OraclePanel.this.reflashData();
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
		double rows[] = { TableLayout.PREFERRED, TableLayout.FILL,
				TableLayout.FILL, TableLayout.FILL };
		double cols[] = { TableLayout.FILL };
		TableLayout layout = new TableLayout(cols, rows, 10, 15);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setLayout(layout);

		this.add(oracleInfoPanel, "0,0,0,0");
		this.add(tablespaceUserPanel,"0,1");
		this.add(processMemeoryPanel,"0,2");
		this.add(deadLockPanel, "0,3");
		
		
	}

	public void reflashData() {
		oracleInfoPanel.updateField();
		deadLockPanel.updateField();
		processMemeoryPanel.updateField();
		tablespaceUserPanel.updateField();
	}

	class OracleInfoPanel extends BorderPanel {
		private JTextField txtCacheHitRatio = SJTUUtils.getTextField();
		private JTextField txtCpuUsed = SJTUUtils.getTextField();
		private JTextField txtTransactionValue = SJTUUtils.getTextField();
		private JTextField txtSession = SJTUUtils.getTextField();
		private JTextField txtDatabaseName = SJTUUtils.getTextField();
		private JTextField txtCreateDate = SJTUUtils.getTextField();

		public OracleInfoPanel(String title) {
			super(title);
			initGUI();
		}

		@Override
		public void initGUI() {
			this.setBackground(SJTUConst.PANELBACKGROUND);
			double rows[] = { TableLayout.PREFERRED, TableLayout.PREFERRED,
					TableLayout.PREFERRED };
			double cols[] = { TableLayout.PREFERRED, TableLayout.FILL,
					TableLayout.PREFERRED, TableLayout.FILL };
			TableLayout layout = new TableLayout(cols, rows, 10, 5);
			this.setLayout(layout);
			this.add(SJTUUtils.getLabel("数据库名称"), "0,0");
			this.add(txtDatabaseName, "1,0");
			this.add(SJTUUtils.getLabel("CPU 使用率"), "0,1");
			this.add(txtCpuUsed, "1,1");
			this.add(SJTUUtils.getLabel("事务数"), "0,2");
			this.add(txtTransactionValue, "1,2");

			this.add(SJTUUtils.getLabel("Session 数量"), "2,0");
			this.add(txtSession, "3,0");
			this.add(SJTUUtils.getLabel("Cache 命中率"), "2,1");
			this.add(txtCacheHitRatio, "3,1");
			this.add(SJTUUtils.getLabel("创建时间"), "2,2");
			this.add(txtCreateDate, "3,2");

		}

		@SuppressWarnings("deprecation")
		protected void updateField() {
			if (oracleStatus != null) {
				txtCacheHitRatio.setText((int)(oracleStatus.getCacheHitRatio() * 100) + "%");
				txtCpuUsed.setText(oracleStatus.getCpuBusyRatio() * 100 + "");
				txtTransactionValue.setText(oracleStatus.getTransactionNum()
						+ "");
				txtSession.setText(oracleStatus.getSessionNum() + "");
				txtCreateDate.setText(oracleStatus.getCreateTime().toLocaleString());
				txtDatabaseName.setText(node.getName());
			} else {
				txtCacheHitRatio.setText("");
				txtCpuUsed.setText("");
				txtTransactionValue.setText("");
				txtSession.setText("");
				txtCreateDate.setText("");
			}

		}

	}
	

	class DeadLockPanel extends BorderPanel {
		private Object[][] data;

		private String[] columnNames = { "Oracle用户名", "Session唯一标识", "系统程序名",
				"系统机器名", "系统用户名", "锁类型", "会话保持的锁的模式", "会话申请的锁的模式",
				"当前锁是否阻塞另一个锁", "死锁时间(单位:秒)" };
		
		private DefaultTableModel model = new DefaultTableModel(data,
				columnNames);

		public DeadLockPanel(String title) {
			super(title);
			initGUI();
		}

		@Override
		public void initGUI() {
			TableUtil.addTable(this,model);
		}

		protected void updateField() {
			if (oracleStatus != null) {
				List<DeadLock> list = oracleStatus.getDeadLocks();
				data = new Object[list.size()][columnNames.length];
				if (list != null && list.size() > 0) {
					int i = 0;
					for (DeadLock deadLock : list) {
						data[i][0] = deadLock.getUsername();
						data[i][1] = deadLock.getSid();
						data[i][2] = deadLock.getProgram();
						data[i][3] = deadLock.getMachine();
						data[i][4] = deadLock.getOsuser();
						data[i][5] = deadLock.getType();
						data[i][6] = deadLock.getImode();
						data[i][7] = deadLock.getRequest();
						data[i][8] = deadLock.getBlock();
						data[i][9] = deadLock.getCtime();
						i++;
					}

				} else {
					data = null;
				}
			}
			model.setDataVector(data, columnNames);
		}

	}

	
	class ProcessMemoryPanel extends BorderPanel {
		private Object[][] data;
		private String[] columnNames = { "Oracle进程ID", "进程名称", "已使用内存(单位:M)",
				"已分配内存(单位:M)", "最大已分配内存(单位:M)", "利用率"};
		private DefaultTableModel model = new DefaultTableModel(data,
				columnNames);

		public ProcessMemoryPanel(String title) {
			super(title);
			initGUI();
		}

		@Override
		public void initGUI() {
			TableUtil.addTable(this,model);
		}

		protected void updateField() {
			if (oracleStatus != null) {
				List<ProcessMemory> list = oracleStatus.getProcessMemories();
				data = new Object[list.size()][columnNames.length];
				if (list != null && list.size() > 0) {
					int i = 0;
					for (ProcessMemory processMemory : list) {
						data[i][0] = processMemory.getPid();
						data[i][1] = processMemory.getName();
						data[i][2] = processMemory.getPgaUsedMem();
						data[i][3] = processMemory.getPgaAllocMem();
						data[i][4] = processMemory.getPgaMaxMem();
						data[i][5] = processMemory.getUsedRatio();
						i++;
					}

				} else {
					data = null;
				}
			}
			model.setDataVector(data, columnNames);
		}

	}

	class TablespaceUserPanel extends BorderPanel {
		private Object[][] data ;

		private String[] columnNames = { "表空间名", "表空间类型", 
				"表空间大小(单位:M)", "已使用大小(单位:M)", "利用率"};
		private DefaultTableModel model = new DefaultTableModel(data,
				columnNames);

		public TablespaceUserPanel(String title) {
			super(title);
			initGUI();
		}

		@Override
		public void initGUI() {
			TableUtil.addTable(this,model);
		}

		protected void updateField() {
			if (oracleStatus != null) {
				List<Workspace> list = oracleStatus.getWorkspaces();
				data = new Object[list.size()][columnNames.length];
				if (list != null && list.size() > 0) {
					int i = 0;
					for (Workspace wokspace : list) {
						data[i][0] = wokspace.getName();
						data[i][1] = wokspace.getType();
						data[i][2] = wokspace.getCapability();
						data[i][3] = wokspace.getUsedSpace();
						data[i][4] = wokspace.getUsedRatio();
						i++;
					}

				} else {
					data = null;
				}
			}
			model.setDataVector(data, columnNames);
		}

	}

	public DatabaseResultStatus getOracleStatus() {
		return oracleStatus;
	}

	public void setOracleStatus(DatabaseResultStatus oracleStatus) {
		this.oracleStatus = oracleStatus;
	}

	public static void main(String[] args) {
//		OraclePanel o = new OraclePanel();
//		SJTUUtils.showCompoentInFrame(o);
		// o.reflashData();

	}
}
