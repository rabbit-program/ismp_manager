package org.infosec.ismp.applet.discover.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.infosec.ismp.applet.discover.listener.impl.DefaultSearchListener;
import org.infosec.ismp.applet.discover.service.SNMPSearchAppletService;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.SNMPAppletForm;

/**
 * SNMPParamPanel
 * @author sshanshan
 * @date 2009-06-18
 * @version 1.0
 */

public class SNMPParamPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	/**
	 * 默认团体名列表
	 */
	static String[] communityNameList = { "public", "private" };
	/**
	 * 尝试次数选项
	 */
	static int[] trytimesList = { 1, 2, 3, 4, 5 };
	/**
	 * 超时选项
	 */
	static int[] timeoutList = { 1, 2, 3, 4, 5 };
	/**
	 * 传入的snmpPanel句柄
	 */
	private SNMPPanel snmpPanel = null;
	/**
	 * snmp发现所需的参数
	 */
	private ArrayList<SNMPEntryData> snmpEntries = null;
	/**
	 * 用户更改后的团体名列表
	 */
	private ArrayList<String> myCommunity = new ArrayList<String>();
	/**
	 * 代理列表
	 */
//	private List<AgentBO> agentList = new ArrayList<AgentBO>();
	private int userId;
//	private String userName;
//	private String roleName;

	public void setUserId(int userId) {
		this.userId = userId;
	}

//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}

//	JLabel agentID = new JLabel("数据代理", SwingConstants.CENTER);
	JLabel startIP = new JLabel("起始地址", SwingConstants.CENTER);
	JLabel endIP = new JLabel("终止地址", SwingConstants.CENTER);
	JLabel port = new JLabel("端口范围", SwingConstants.CENTER);
	JLabel community = new JLabel("团体名称", SwingConstants.CENTER);
	JLabel trytimes = new JLabel("尝试次数", SwingConstants.CENTER);
	JLabel timeout = new JLabel("网络超时", SwingConstants.CENTER);
	JLabel link = new JLabel("—", SwingConstants.CENTER);
	JLabel trytimesUnit = new JLabel("次", SwingConstants.CENTER);
	JLabel timeoutUnit = new JLabel("秒", SwingConstants.CENTER);
//    JLabel initParamStart = new JLabel("数据正在加载中，请稍候...", SwingConstants.CENTER);
	JLabel title = new JLabel();

	JTextField startIPT = new JTextField();
	JTextField endIPT = new JTextField();
	JTextField startPort = new JTextField("161",10);
	JTextField endPort = new JTextField("161",10);
	JTextField communityT = new JTextField();

	JButton up = new JButton("从列表中移除");
	JButton down = new JButton("添加至列表");
	JButton execute = new JButton("开始");

	DefaultListModel model = new DefaultListModel();
	JList communityList = new JList(model);

//	JComboBox agentC = new JComboBox();
	JComboBox trytimesC = new JComboBox();
	JComboBox timeoutC = new JComboBox();

	/**
	 * 构造函数
	 * @param snmpPanel
	 */
	public SNMPParamPanel(SNMPPanel snmpPanel) {
		/*SNMPSearchAppletService snmpSearchService = SNMPSearchAppletService
				.getInstance();
		agentList = snmpSearchService.getAllRegisteredAgentBO();*/

		this.snmpPanel = snmpPanel;

		this.setBorder(BorderFactory.createEtchedBorder());
		this.setLayout(new BorderLayout());

		JPanel paramPanel = new JPanel();

		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints cons = new GridBagConstraints();
		cons.anchor = GridBagConstraints.CENTER;
		cons.fill = GridBagConstraints.BOTH;
		paramPanel.setLayout(grid);

//		if (agentList.size() == 0) {
//			agentC.addItem("无可用的数据采集代理");
//		} else {
//			for (int i = 0, n = agentList.size(); i < n; i++) {
//				agentC.addItem(agentList.get(i));
//			}
//		}

		for (int i = 0, n = communityNameList.length; i < n; i++) {
			model.addElement(communityNameList[i]);
			myCommunity.add(communityNameList[i]);
		}
		communityList.setVisibleRowCount(3);
		communityList.setFixedCellHeight(25);
		JScrollPane scrollPane = new JScrollPane(communityList);

		for (int i = 0, n = trytimesList.length; i < n; i++) {
			trytimesC.addItem(trytimesList[i] + "");
		}

		for (int i = 0, n = timeoutList.length; i < n; i++) {
			timeoutC.addItem(timeoutList[i] + "");
		}

		ImageIcon image = new ImageIcon(getClass().getResource("SNMP.jpg"));
		title.setIcon(image);

		cons.gridx = 0;
		cons.gridy = 0;
		cons.gridwidth = 6;
		cons.weightx = 0;
		cons.weighty = 0;
		cons.insets = new Insets(0, 0, 5, 0);
		grid.setConstraints(title, cons);
		paramPanel.add(title);

//		cons.gridx = 0;
//		cons.gridy = 1;
//		cons.gridwidth = 1;
//		cons.weightx = 0;
//		cons.weighty = 0;
//		cons.insets = new Insets(5, 10, 5, 9);
//		grid.setConstraints(agentID, cons);
//		paramPanel.add(agentID);

//		cons.gridx = 1;
//		cons.gridwidth = 5;
//		cons.weightx = 1;
//		cons.insets = new Insets(5, 5, 5, 5);
//		grid.setConstraints(agentC, cons);
//		paramPanel.add(agentC);

		cons.gridx = 0;
		cons.gridy = 2;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.weighty = 0;
		cons.insets = new Insets(5, 10, 5, 9);
		grid.setConstraints(startIP, cons);
		paramPanel.add(startIP);

		cons.gridx = 1;
		cons.gridwidth = 5;
		cons.weightx = 1;
		cons.insets = new Insets(5, 5, 5, 5);
		grid.setConstraints(startIPT, cons);
		paramPanel.add(startIPT);

		cons.gridx = 0;
		cons.gridy = 3;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.insets = new Insets(5, 10, 5, 9);
		grid.setConstraints(endIP, cons);
		paramPanel.add(endIP);

		cons.gridx = 1;
		cons.gridwidth = 5;
		cons.weightx = 1;
		cons.insets = new Insets(5, 5, 5, 5);
		grid.setConstraints(endIPT, cons);
		paramPanel.add(endIPT);

		cons.gridx = 0;
		cons.gridy = 4;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.insets = new Insets(5, 10, 5, 9);
		grid.setConstraints(port, cons);
		paramPanel.add(port);

		cons.gridx = 1;
		cons.gridwidth = 2;
		cons.weightx = 0.5;
		cons.insets = new Insets(5, 5, 5, 5);
		grid.setConstraints(startPort, cons);
		paramPanel.add(startPort);

		cons.gridx = 3;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.fill = GridBagConstraints.NONE;
		grid.setConstraints(link, cons);
		paramPanel.add(link);

		cons.gridx = 4;
		cons.gridwidth = 2;
		cons.weightx = 0.5;
		cons.fill = GridBagConstraints.BOTH;
		grid.setConstraints(endPort, cons);
		paramPanel.add(endPort);

		cons.gridx = 0;
		cons.gridy = 5;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.insets = new Insets(5, 10, 5, 9);
		grid.setConstraints(community, cons);
		paramPanel.add(community);

		cons.gridx = 1;
		cons.gridwidth = 5;
		cons.weightx = 1;
		cons.insets = new Insets(5, 5, 5, 5);
		grid.setConstraints(communityT, cons);
		paramPanel.add(communityT);

		cons.gridx = 2;
		cons.gridy = 6;
		cons.gridwidth = 1;
		cons.anchor = GridBagConstraints.EAST;
		cons.fill = GridBagConstraints.NONE;
		down.addActionListener(this);
		grid.setConstraints(down, cons);
		paramPanel.add(down);

		cons.gridx = 4;
		cons.anchor = GridBagConstraints.WEST;
		up.addActionListener(this);
		grid.setConstraints(up, cons);
		paramPanel.add(up);

		cons.gridx = 1;
		cons.gridy = 7;
		cons.gridwidth = 5;
		cons.weightx = 1;
		cons.weighty = 1;
		cons.anchor = GridBagConstraints.CENTER;
		cons.fill = GridBagConstraints.BOTH;
		grid.setConstraints(scrollPane, cons);
		paramPanel.add(scrollPane);

		cons.gridx = 0;
		cons.gridy = 8;
		cons.weighty = 0;
		cons.gridwidth = 1;
		cons.weightx = 0;
		cons.insets = new Insets(5, 10, 5, 9);
		grid.setConstraints(trytimes, cons);
		paramPanel.add(trytimes);

		cons.weighty = 0;
		cons.gridx = 1;
		cons.gridwidth = 4;
		cons.weightx = 0.9;
		cons.insets = new Insets(5, 5, 5, 5);
		grid.setConstraints(trytimesC, cons);
		paramPanel.add(trytimesC);

		cons.weighty = 0;
		cons.gridx = 5;
		cons.gridwidth = 1;
		cons.weightx = 0.1;
		grid.setConstraints(trytimesUnit, cons);
		paramPanel.add(trytimesUnit);

		cons.gridx = 0;
		cons.gridy = 9;
		cons.weightx = 0;
		cons.insets = new Insets(5, 10, 5, 9);
		grid.setConstraints(timeout, cons);
		paramPanel.add(timeout);

		cons.weighty = 0;
		cons.gridx = 1;
		cons.gridwidth = 4;
		cons.weightx = 0.9;
		cons.insets = new Insets(5, 5, 5, 5);
		grid.setConstraints(timeoutC, cons);
		paramPanel.add(timeoutC);

		cons.weighty = 0;
		cons.gridx = 5;
		cons.gridwidth = 1;
		cons.weightx = 0.1;
		grid.setConstraints(timeoutUnit, cons);
		paramPanel.add(timeoutUnit);

//        cons.gridx = 0;
//        cons.gridy = 10;
//        cons.gridwidth = 6;
//        cons.weightx = 0;
//        initParamStart.setForeground(Color.orange);
//        grid.setConstraints(initParamStart, cons);
//        paramPanel.add(initParamStart);

		JPanel button = new JPanel();
		button.setLayout(grid);
		cons.weightx = 1;
		execute.addActionListener(this);
		grid.setConstraints(execute, cons);
		button.add(execute);
        execute.setEnabled(true);

		this.add(BorderLayout.NORTH, paramPanel);
		this.add(BorderLayout.SOUTH, button);
	}

	/**
	 * 事件处理函数，开始搜索/参数输送入错误/修改团体名列表/各种异常处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == execute) {
			if (IPCompare(startIPT.getText(), endIPT.getText()) == -2) {
				JOptionPane.showMessageDialog(null, "输入的 IP 地址格式不正确 ！");
				return;
			} else if (IPCompare(startIPT.getText(), endIPT.getText()) > 0) {
				JOptionPane.showMessageDialog(null, "起始IP地址大于终止IP地址 ！");
				return;
			}
			if (!validPort(startPort.getText())
					|| !validPort(endPort.getText())) {
				JOptionPane.showMessageDialog(null, "输入的 端口格式不正确 ！");
				return;
			}
			execute.setEnabled(false);
//			agentC.setEnabled(false);
			startIPT.setEnabled(false);
			endIPT.setEnabled(false);
			startPort.setEnabled(false);
			endPort.setEnabled(false);
			communityT.setEnabled(false);
			communityList.setEnabled(false);
			up.setEnabled(false);
			down.setEnabled(false);
			trytimesC.setEnabled(false);
			timeoutC.setEnabled(false);
			SNMPAppletForm form = new SNMPAppletForm();
			form.setUserId(userId);
//			form.setUserName(userName);
//			form.setRoleName(roleName);
//			form.setAgentBO((AgentBO) agentC.getSelectedItem());
			form.setStartIP(startIPT.getText());
			form.setEndIP(endIPT.getText());
			form.setStartPort(Integer.parseInt(startPort.getText()));
			form.setEndPort(Integer.parseInt(endPort.getText()));
			form.setCommunityList(myCommunity);
			form.setTryNum(Integer.parseInt(trytimesC.getSelectedItem()
					.toString()));
			form.setOutTime(Integer.parseInt(timeoutC.getSelectedItem()
					.toString()));
			DefaultSearchListener listener = new DefaultSearchListener() {
				@Override
				public void addSearchMessage(String message) {
					snmpPanel.getProcessPane().setMessage(message);
				}

				@Override
				public void canSearch(boolean isRunning) {
					if (isRunning == true) {
						JOptionPane.showMessageDialog(null,
								"当前有其他用户正在使用该功能，请稍候再试 ！");
						snmpPanel.getProcessPane().setStop(false);
						snmpPanel.getParamPane().execute.setEnabled(true);
//						snmpPanel.getParamPane().agentC.setEnabled(true);
						snmpPanel.getParamPane().startIPT.setEnabled(true);
						snmpPanel.getParamPane().endIPT.setEnabled(true);
						snmpPanel.getParamPane().startPort.setEnabled(true);
						snmpPanel.getParamPane().endPort.setEnabled(true);
						snmpPanel.getParamPane().communityT.setEnabled(true);
						snmpPanel.getParamPane().up.setEnabled(true);
						snmpPanel.getParamPane().down.setEnabled(true);
						snmpPanel.getParamPane().trytimesC.setEnabled(true);
						snmpPanel.getParamPane().timeoutC.setEnabled(true);
					}
				}

				@Override
                public void saveDBSuccessed(boolean isSuccessed){
            		if(isSuccessed){
            			JOptionPane.showMessageDialog(null, "节点保存成功 ！");
            		}else{
            			JOptionPane.showMessageDialog(null, "节点保存失败 ！");
            		}
            	}
				
				@Override
				public void reloadPercentBar(int percent) {
					snmpPanel.getProcessPane().setPercent(percent);
				}

				@Override
				public void remoteServiceExecuteError(String executeName) {
					JOptionPane.showMessageDialog(null, executeName);
					snmpPanel.getProcessPane().setStop(false);
					if(!executeName.contains("停止失败")){
						SNMPSearchAppletService snmpSearchService = SNMPSearchAppletService.getInstance();
						snmpSearchService.stopSearch(true);
					}
					snmpPanel.getParamPane().execute.setEnabled(true);
//					snmpPanel.getParamPane().agentC.setEnabled(true);
					snmpPanel.getParamPane().startIPT.setEnabled(true);
					snmpPanel.getParamPane().endIPT.setEnabled(true);
					snmpPanel.getParamPane().startPort.setEnabled(true);
					snmpPanel.getParamPane().endPort.setEnabled(true);
					snmpPanel.getParamPane().communityT.setEnabled(true);
					snmpPanel.getParamPane().communityList.setEnabled(true);
					snmpPanel.getParamPane().up.setEnabled(true);
					snmpPanel.getParamPane().down.setEnabled(true);
					snmpPanel.getParamPane().trytimesC.setEnabled(true);
					snmpPanel.getParamPane().timeoutC.setEnabled(true);

				}

				@Override
				public void remoteServiceNotResponse(String message) {
					JOptionPane.showMessageDialog(null, message);
					snmpPanel.getProcessPane().setStop(false);
					SNMPSearchAppletService snmpSearchService = SNMPSearchAppletService
							.getInstance();
					snmpSearchService.stopSearch(true);
					snmpPanel.getParamPane().execute.setEnabled(true);
//					snmpPanel.getParamPane().agentC.setEnabled(true);
					snmpPanel.getParamPane().startIPT.setEnabled(true);
					snmpPanel.getParamPane().endIPT.setEnabled(true);
					snmpPanel.getParamPane().startPort.setEnabled(true);
					snmpPanel.getParamPane().endPort.setEnabled(true);
					snmpPanel.getParamPane().communityT.setEnabled(true);
					snmpPanel.getParamPane().communityList.setEnabled(true);
					snmpPanel.getParamPane().up.setEnabled(true);
					snmpPanel.getParamPane().down.setEnabled(true);
					snmpPanel.getParamPane().trytimesC.setEnabled(true);
					snmpPanel.getParamPane().timeoutC.setEnabled(true);
				}

				@Override
				public void inputError(String error) {
					JOptionPane.showMessageDialog(null, error);
					snmpPanel.getProcessPane().setStop(false);
					SNMPSearchAppletService snmpSearchService = SNMPSearchAppletService
							.getInstance();
					snmpSearchService.stopSearch(true);
					snmpPanel.getParamPane().execute.setEnabled(true);
//					snmpPanel.getParamPane().agentC.setEnabled(true);
					snmpPanel.getParamPane().startIPT.setEnabled(true);
					snmpPanel.getParamPane().endIPT.setEnabled(true);
					snmpPanel.getParamPane().startPort.setEnabled(true);
					snmpPanel.getParamPane().endPort.setEnabled(true);
					snmpPanel.getParamPane().communityT.setEnabled(true);
					snmpPanel.getParamPane().communityList.setEnabled(true);
					snmpPanel.getParamPane().up.setEnabled(true);
					snmpPanel.getParamPane().down.setEnabled(true);
					snmpPanel.getParamPane().trytimesC.setEnabled(true);
					snmpPanel.getParamPane().timeoutC.setEnabled(true);
				}

				@Override
				public void onSearchFinished(List<Node> list) {
					snmpPanel.getProcessPane().setStop(false);
					snmpEntries = new ArrayList<SNMPEntryData>();
					for (Node node : list) {
						SNMPEntryData snmpdata = new SNMPEntryData();
						snmpdata.setPort(node.getPort());
						snmpdata.setId(node.getId());
						snmpdata.setIp(node.getIpAddr());
						snmpdata.setType(node.getNodeType());
						snmpdata.setTryTimes(node.getTryNum());
						snmpdata.setCommunity(node.getCommunity());
						snmpdata.setResponseTime(node.getSearchTime());
						snmpdata.setDescription(node.getDescription());
						snmpEntries.add(snmpdata);
					}
					if (snmpEntries == null || snmpEntries.isEmpty()) {
						JOptionPane.showMessageDialog(null, "没有发现任何拓扑节点");
					} else {
						final JFrame f = new JFrame();
//						SNMPResultPanel result = new SNMPResultPanel(
//								snmpEntries,(AgentBO)agentC.getSelectedItem());
						SNMPResultPanel result = new SNMPResultPanel(snmpEntries);
						Dimension screenDimension = Toolkit.getDefaultToolkit()
								.getScreenSize();
						f.setSize(600, 400);
						f
								.setLocation(
										(screenDimension.width - f.getSize().width) / 2,
										(screenDimension.height - f.getSize().height) / 2);
						f.setTitle("发现节点");
						f.setLayout(new BorderLayout());
						f.getContentPane().add(result, BorderLayout.CENTER);
						f.setVisible(true);
						f.setResizable(false);
						try {
//							UIManager.setLookAndFeel(UIManager
//									.getCrossPlatformLookAndFeelClassName());
							SwingUtilities.updateComponentTreeUI(f);
						} catch (Exception e) {
							System.err.println("can't get SystemLookAndFeel");
						}
						f.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosing(WindowEvent e) {
								f.setVisible(false);
								f.dispose();
							}
						});
					}
					snmpPanel.getParamPane().execute.setEnabled(true);
//					snmpPanel.getParamPane().agentC.setEnabled(true);
					snmpPanel.getParamPane().startIPT.setEnabled(true);
					snmpPanel.getParamPane().endIPT.setEnabled(true);
					snmpPanel.getParamPane().startPort.setEnabled(true);
					snmpPanel.getParamPane().endPort.setEnabled(true);
					snmpPanel.getParamPane().communityT.setEnabled(true);
					snmpPanel.getParamPane().communityList.setEnabled(true);
					snmpPanel.getParamPane().up.setEnabled(true);
					snmpPanel.getParamPane().down.setEnabled(true);
					snmpPanel.getParamPane().trytimesC.setEnabled(true);
					snmpPanel.getParamPane().timeoutC.setEnabled(true);
				}
			};
			snmpPanel.getProcessPane().clearFlowout();
			snmpPanel.getProcessPane().setPercent(0);
			snmpPanel.getProcessPane().setStop(true);
			SNMPSearchAppletService snmpSearchService = SNMPSearchAppletService
					.getInstance();
			snmpSearchService.doSearch(form, listener);
		} else if (source == up) {
			if (communityList.getSelectedValue() == null) {
				JOptionPane.showMessageDialog(null, "请选择要删除的团体名称 ！");
			} else if (model.isEmpty()) {
				JOptionPane.showMessageDialog(null, "没有可以删除的团体名 称！");
			} else {
				Object o = communityList.getSelectedValue();
				model.removeElement(o);
				myCommunity.remove(o);
			}
		} else if (source == down) {
			if (!communityT.getText().equals("")) {
				myCommunity.add(communityT.getText().toString());
				model.addElement(communityT.getText());
				communityT.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "输入的团体名称为空 ！");
			}
		}
	}

	/**
	 * validPort判断端口格式是否合法
	 * 
	 * @param port
	 * @return 合法/不合法
	 */
	boolean validPort(String port) {
		boolean valid = true;
		if (!port.equals("")) {
			try {
				int p = Integer.parseInt(port);
				try {
					if (p < 0 || p > 65535) {
						valid = false;
					}
				} catch (Exception ex) {
					valid = false;
				}
			} catch (Exception ex) {
				valid = false;
			}
		} else {
			valid = false;
		}
		return valid;
	}

	/**
	 * validIP 判断ip是否合法
	 * 
	 * @param ip
	 * @return 合法/不合法
	 */
	boolean validIP(String ip) {
		boolean valid = true;
		StringTokenizer token = new StringTokenizer(ip, ".");
		for (int i = 0; i < 4; i++) {
			try {
				String slice = token.nextToken();
				try {
					int num = Integer.parseInt(slice);
					if (num < 0 || num > 255) {
						valid = false;
					}
				} catch (Exception ex) {
					valid = false;
				}
			} catch (Exception ex) {
				valid = false;
			}
		}
		return valid;
	}

	/**
	 * IPCompare比较两个ip的大小
	 * 
	 * @param ip1
	 *            起始ip
	 * @param ip2
	 *            终止ip
	 * @return -2（ip不合法），-1/0（起始ip小于或等于终止ip），1（起始ip大于终止ip）
	 */
	int IPCompare(String ip1, String ip2) {
		if (!validIP(ip1) || !validIP(ip2)) {
			return -2;
		}
		long ipInt1 = 0, ipInt2 = 0;
		StringTokenizer token = new StringTokenizer(ip1, ".");
		for (int i = 0; i < 4; i++) {
			String slice = token.nextToken();
			long num = Integer.parseInt(slice);
			ipInt1 += num * (Math.pow(256, (3 - i)));
		}
		token = new StringTokenizer(ip2, ".");
		for (int i = 0; i < 4; i++) {
			String slice = token.nextToken();
			long num = Integer.parseInt(slice);
			ipInt2 += num * (Math.pow(256, (3 - i)));
		}
		if ((ipInt1 - ipInt2) > 0) {
			return 1;
		} else {
			if ((ipInt1 - ipInt2) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}
    
//    public void addAgentList(List<AgentBO> agentList){
//    	this.agentC.removeAllItems();
//        if(agentList.size()==0){
//        	this.agentC.addItem("无可用的数据采集代理");
//        }else{
//        	for (int i = 0, n = agentList.size(); i < n; i++){
//            	this.agentC.addItem(agentList.get(i));
//            }
//        }
//        this.initParamStart.setText("");
//        this.execute.setEnabled(true);
//    }
}
