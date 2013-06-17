package org.infosec.ismp.applet.manager.component.panel.view.network;

import java.awt.BorderLayout;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.infosec.ismp.applet.manager.component.panel.SJTUConst;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;
import org.infosec.ismp.applet.manager.component.panel.view.BorderPanel;

import twaver.swing.TableLayout;

/**
 * 网络状态面板
 * 接口：addStatus & setStatusList
 */
public class NetworkStatusPanel extends BorderPanel {
	List statusList = new ArrayList();
	JTabbedPane pane = new JTabbedPane();

	public NetworkStatusPanel() {
		super("  网络状态  ");
		initGUI();
		setTab();
	}

	public void initGUI() {
		this.setBackground(SJTUConst.PANELBACKGROUND);
		this.setLayout(new BorderLayout());
		this.add(pane, BorderLayout.CENTER);
	}

	private void setTab() {
		pane.removeAll();
		if (statusList != null && statusList.size() > 0) {
			int size = statusList.size();
			for (int i = 0; i < size; i++) {
				NetworkStatus status = (NetworkStatus) statusList.get(i);
				NetworkStatusTabPanel panel = new NetworkStatusTabPanel(status);
				pane.addTab(status.getPortName(), panel);
			}
		} else {
			NetworkStatusTabPanel panel = new NetworkStatusTabPanel(null);
			pane.addTab("网络接口", panel);
		}
		pane.invalidate();
		pane.repaint();
	}

	public void setStatusList(List statusList) {
		if (statusList != null) {
			this.statusList = statusList;
		} else {
			this.statusList = new ArrayList();
		}
		setTab();
	}

	public void addStatus(NetworkStatus status) {
		if (statusList.size() == 0) {
			pane.removeAll();
		}
		if (statusList.contains(status)) {
			return;
		}
		this.statusList.add(status);
		NetworkStatusTabPanel panel = new NetworkStatusTabPanel(status);
		pane.addTab(status.getPortName(), panel);
	}

	public void clearStatusList() {
		this.statusList = new ArrayList();
		setTab();
	}
}

/**
 * 网络状态面板
 * 接口 setNetworkStatus&getNetworkStatus
 */
class NetworkStatusTabPanel extends JPanel implements PropertyChangeListener {

	private NetworkStatus networkStatus;

	private JTextField physicalAddressField = SJTUUtils.getTextField();
	private JTextField ipAddressField = SJTUUtils.getTextField();
	private JTextField netMaskField = SJTUUtils.getTextField();
	private JTextField isUpField = SJTUUtils.getTextField();
	private JTextField inBytesField = SJTUUtils.getTextField();
	private JTextField outBytesField = SJTUUtils.getTextField();
	private JTextField inPacketsField = SJTUUtils.getTextField();
	private JTextField outPacketsField = SJTUUtils.getTextField();
	private JTextField descriptionField = SJTUUtils.getTextField();
	private JTextField speedField = SJTUUtils.getTextField();

	public NetworkStatusTabPanel() {
		this(null);
	}

	public NetworkStatusTabPanel(NetworkStatus networkStatus) {
		this.networkStatus = networkStatus;
		if (networkStatus != null) {
			networkStatus.addPropertyChangeListener(this);
		}
		initGUI();
		updateFields();
	}

	private void initGUI() {
		this.setBackground(SJTUConst.PANELBACKGROUND);

		double rows[] = { TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED };
		double cols[] = { TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL };
		TableLayout layout = new TableLayout(cols, rows, 10, 5);
		this.setLayout(layout);

		this.add(SJTUUtils.getLabel("MAC地址"), "0,0,0,0");
		this.add(physicalAddressField, "1,0,1,0");
		this.add(SJTUUtils.getLabel("IP地址"), "2,0,2,0");
		this.add(ipAddressField, "3,0,3,0");

		this.add(SJTUUtils.getLabel("IP地址子网掩码   "), "0,1,0,1");
		this.add(netMaskField, "1,1,1,1");
		this.add(SJTUUtils.getLabel("接口工作状态   "), "2,1,2,1");
		this.add(isUpField, "3,1,3,1");

		this.add(SJTUUtils.getLabel("流入字节数   "), "0,2,0,2");
		this.add(inBytesField, "1,2,1,2");
		this.add(SJTUUtils.getLabel("流出字节数   "), "2,2,2,2");
		this.add(outBytesField, "3,2,3,2");

		this.add(SJTUUtils.getLabel("流入IP报文数   "), "0,3,0,3");
		this.add(inPacketsField, "1,3,1,3");
		this.add(SJTUUtils.getLabel("流出IP报文数   "), "2,3,2,3");
		this.add(outPacketsField, "3,3,3,3");

		this.add(SJTUUtils.getLabel("接口速度   "), "0,4,0,4");
		this.add(speedField, "1,4,1,4");
		this.add(SJTUUtils.getLabel("接口文字描述   "), "2,4,2,4");
		this.add(descriptionField, "3,4,3,4");
	}

	private void updateFields() {
		if (networkStatus != null) {
			physicalAddressField.setText(networkStatus.getPhysicalAddress());
			ipAddressField.setText(networkStatus.getIpAddress());
			netMaskField.setText(networkStatus.getNetMask());
			if (networkStatus.isUp()) {
				isUpField.setText("可用");
				isUpField.setForeground(Color.GREEN);
			} else {
				isUpField.setText("不可用");
				isUpField.setForeground(Color.RED);
			}
			inBytesField.setText(networkStatus.getInBytes() + "byte");
			outBytesField.setText(networkStatus.getOutBytes() + "byte");

			inPacketsField.setText(networkStatus.getInPackets() + "");
			outPacketsField.setText(networkStatus.getOutPackets() + "");
			speedField.setText(networkStatus.getSpeed() + "bit/s");
			descriptionField.setText(networkStatus.getDescription());
		} else {
			physicalAddressField.setText("");
			ipAddressField.setText("");
			netMaskField.setText("");
			isUpField.setText("");
			inBytesField.setText("");
			outBytesField.setText("");
			inPacketsField.setText("");
			outPacketsField.setText("");
			speedField.setText("");
			descriptionField.setText("");
		}
	}

	public void propertyChange(PropertyChangeEvent evt) {
		updateFields();
	}

	public NetworkStatus getNetworkStatus() {
		return networkStatus;
	}

	public void setNetworkStatus(NetworkStatus status) {
		this.networkStatus = status;
		updateFields();
	}
}
