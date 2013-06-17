package org.infosec.ismp.applet.manager.component.panel.info.netport;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.infosec.ismp.applet.manager.component.panel.component.TitlePanel;
import org.infosec.ismp.applet.manager.component.panel.info.AbstractTitlePanel;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;

import twaver.Element;
import twaver.MovableFilter;
import twaver.SelectableFilter;
import twaver.TDataBox;
import twaver.TWaverUtil;
import twaver.network.TNetwork;
import twaver.swing.LabelValueLayout;
import twaver.swing.SingleFiledLayout;

/**
 * 网络接口
 * 接口
 * setPortList
 * addNetPort
 * clearPortList
 */
public class NetPortScrollPanel extends AbstractTitlePanel {

	private List portList = new ArrayList();
	private JPanel netPanel = new JPanel(new SingleFiledLayout());
	private JScrollPane pane = new JScrollPane(netPanel);

	public NetPortScrollPanel() {
		this.setLayout(new BorderLayout());
		setPortList(portList);
		this.add(pane, BorderLayout.CENTER);
	}

	/**
	 * 设置网络端口信息
	 * portList中存储的数据类型是NetPort
	 * 
	 * @param portList
	 */
	public void setPortList(List portList) {
		if (portList == null) {
			this.portList = new ArrayList();
		} else {
			this.portList = portList;
		}
		int size = portList.size();
		netPanel.removeAll();
		for (int i = 0; i < size; i++) {
			NetPort netPort = (NetPort) portList.get(i);
			NetPortPanel port = new NetPortPanel(netPort);
			netPanel.add(port);
		}
		this.validate();
		this.repaint();
	}

	/**
	 * 添加网络端口信息。
	 * 
	 * @param netPort
	 */
	public void addNetPort(NetPort netPort) {
		if (portList.contains(netPort)) {
			return;
		}
		portList.add(netPort);
		NetPortPanel port = new NetPortPanel(netPort);
		netPanel.add(port);
		this.validate();
		this.repaint();
	}

	/**
	 * 清除所有端口信息。
	 */
	public void clearPortList() {
		portList = new ArrayList();
		netPanel.removeAll();
		this.validate();
		this.repaint();
	}

	public JPanel getTitlePanel() {
		return new TitlePanel("网络接口", this);
	}

}

/**
 * 网络端口面板
 * 
 */
class NetPortPanel extends JPanel {
	private NetPort netPort = new NetPort();
	private JTextField sendField = SJTUUtils.getTextField();
	private JTextField receiveField = SJTUUtils.getTextField();

	public NetPortPanel(NetPort netPort) {
		this.netPort = netPort;
		initGUI();

		sendField.setText(netPort.getSendSpeed() + "kbps");
		receiveField.setText(netPort.getReceiveSpeed() + "kbps");
		
		/*
		 *当有数据变化时，更新面板。 
		 */
		this.netPort.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (TWaverUtil.getPropertyName(evt).equals(NetPort.FILEPREFIX + NetPort.SENDSPEED)) {
					Double send = (Double) evt.getNewValue();
					sendField.setText(send.doubleValue() + "kbps");
				} else if (TWaverUtil.getPropertyName(evt).equals(NetPort.FILEPREFIX + NetPort.RECEIVESPEED)) {
					Double receive = (Double) evt.getNewValue();
					receiveField.setText(receive.doubleValue() + "kbps");
				}
			}
		});
	}

	private void initGUI() {
		TDataBox box = new TDataBox();
		try {
			box.parse("/org/infosec/ismp/applet/manager/data/port.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		JPanel infoPanel = new JPanel(new LabelValueLayout(5, 2, false));
		infoPanel.add(SJTUUtils.getLabel("发送速率"));
		infoPanel.add(sendField);
		infoPanel.add(SJTUUtils.getLabel("接收速率"));
		infoPanel.add(receiveField);

		TNetwork network = new TNetwork(box);
		network.getToolbar().setVisible(false);
		network.setPreferredSize(new Dimension(180,100));
		network.setMovableFilter(new MovableFilter() {
			public boolean isMovable(Element arg0) {
				return false;
			}
		});
		network.addSelectableFilter(new SelectableFilter() {
			public boolean isSelectable(Element arg0) {
				return false;
			}
		});

		this.setLayout(new SingleFiledLayout());
		//////////////
		this.add(network);
		////////////////////
		this.add(infoPanel);

		this.setBorder(BorderFactory.createTitledBorder(netPort.getName()));
	}
}
