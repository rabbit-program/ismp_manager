package org.infosec.ismp.applet.manager.component.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.infosec.ismp.applet.manager.component.panel.info.basic.RoutinePanel;
import org.infosec.ismp.applet.manager.component.panel.info.cpu.CPUPanel;
import org.infosec.ismp.applet.manager.component.panel.info.file.FilePanel;
import org.infosec.ismp.applet.manager.component.panel.info.memory.MemoryPanel;
import org.infosec.ismp.applet.manager.component.panel.info.netport.NetPortScrollPanel;
import org.infosec.ismp.applet.manager.component.panel.info.user.UserNumberPanel;
import org.infosec.ismp.applet.manager.component.panel.info.waitqueue.WaitQueuePanel;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;

import twaver.swing.TableLayout;

/**
 * 详细信息面板
 */
public class InfoPanel extends JPanel {
	
	public static void main(String[] args) {
		SJTUUtils.showCompoentInFrame(new InfoPanel());
	}

	public InfoPanel() {
		initGUI();
		initData();
	}
	public RoutinePanel routinePanel = new RoutinePanel();
	private WaitQueuePanel waitQueuePanel = new WaitQueuePanel();
	private UserNumberPanel userNumberPanel = new UserNumberPanel();

	private CPUPanel cpupPanel = new CPUPanel();
	private MemoryPanel memoryPanel = new MemoryPanel();
	private FilePanel filePanel = new FilePanel();
	private NetPortScrollPanel netPortPanel = new NetPortScrollPanel();

	private void initGUI() {
		this.setLayout(new BorderLayout(20, 20));
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.add(createLeftPanel(), BorderLayout.WEST);
		this.add(createRightPanel(), BorderLayout.EAST);
		this.add(createCenterPanel(), BorderLayout.CENTER);
	}

	private JPanel createLeftPanel() {
		JPanel panel = new JPanel();
		double rows[] = { TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED };
		double cols[] = { TableLayout.FILL };

		TableLayout layout = new TableLayout(cols, rows, 10, 30);
		panel.setLayout(layout);

		panel.add(routinePanel.getTitlePanel(), "0,0,0,0");
		panel.add(waitQueuePanel.getTitlePanel(), "0,1,0,1");
		panel.add(userNumberPanel.getTitlePanel(), "0,2,0,2");
		return panel;
	}

	private JPanel createCenterPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 20));
		panel.add(cpupPanel.getTitlePanel());
		panel.add(memoryPanel.getTitlePanel());
		panel.add(filePanel.getTitlePanel());
		return panel;
	}

	private JPanel createRightPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(netPortPanel.getTitlePanel(), BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(230, 10));
		return panel;
	}
	
	/**
	 * 设置线程的计数
	 * @param length
	 */
	public void setProcessCount(int length) {
		waitQueuePanel.setProcessCount(length);
		
	}
	public void initData() {
		//基本信息
		routinePanel.setOs("--");
		routinePanel.setVersion("--");
		routinePanel.setRunTime("--");

		//已死内存
		waitQueuePanel.setDeadProcessCount(0);
	}

	public CPUPanel getCpupPanel() {
		return cpupPanel;
	}

	public MemoryPanel getMemoryPanel() {
		return memoryPanel;
	}

	public FilePanel getFilePanel() {
		return filePanel;
	}

	public NetPortScrollPanel getNetPortPanel() {
		return netPortPanel;
	}

	public WaitQueuePanel getWaitQueuePanel() {
		return waitQueuePanel;
	}

}
