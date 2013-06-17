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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.infosec.ismp.applet.discover.listener.impl.DefaultSearchListener;
import org.infosec.ismp.applet.discover.service.PCSearchAppletService;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.appletForm.PCAppletForm;

/**
 * PCParamPanel
 * @author Wu Guojie
 * @date 2009-7-22
 * @version 1.0
 */
public class PCParamPanel extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    /**
	 * pc发现所需的参数
	 */
    private ArrayList<PCEntryData> pcEntries = null; 
    /**
	 * 传入的PCPanel句柄
	 */
    private PCPanel pcPanel = null;
    /**
	 * 代理列表
	 */
//    private List<AgentBO> agentList = new ArrayList<AgentBO>();
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
    
//    JLabel agentID = new JLabel("数据代理", SwingConstants.CENTER);
    JLabel startIP = new JLabel("起始地址", SwingConstants.CENTER);
    JLabel endIP = new JLabel("终止地址", SwingConstants.CENTER);
//    JLabel initParamStart = new JLabel("数据正在加载中，请稍候...", SwingConstants.CENTER);
    JLabel title = new JLabel();

    JTextField startIPT = new JTextField();
    JTextField endIPT = new JTextField();

    JButton execute = new JButton("开始");

//    JComboBox agentC = new JComboBox();

    /**
	 * 构造函数
	 * @param pcPanel
	 */
    public PCParamPanel(PCPanel pcPanel) {
    	/*PCSearchAppletService pcSearchService = PCSearchAppletService.getInstance();
    	agentList = pcSearchService.getAllRegisteredAgentBO();*/
        this.pcPanel = pcPanel;
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout(5, 5));

        JPanel param = new JPanel();

        startIP.setSize(100, 100);
        startIPT.setSize(200, 100);

        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.CENTER;
        cons.fill = GridBagConstraints.BOTH;
        param.setLayout(grid);

//        if(agentList.size()==0){
//        	agentC.addItem("无可用的数据采集代理");
//        }else{
//        	for (int i = 0, n = agentList.size(); i < n; i++){
//            	agentC.addItem(agentList.get(i));
//            }
//        }
        

        ImageIcon image = new ImageIcon(getClass().getResource("PC.jpg"));
        title.setIcon(image);

        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 6;
        cons.weightx = 0;
        cons.weighty = 0;
        cons.insets = new Insets(0, 0, 5, 0);
        grid.setConstraints(title, cons);
        param.add(title);

//        cons.gridx = 0;
//        cons.gridy = 1;
//        cons.gridwidth = 1;
//        cons.weightx = 0;
//        cons.weighty = 0;
//        cons.insets = new Insets(5, 9, 5, 9);
//        grid.setConstraints(agentID, cons);
//        param.add(agentID);
        
//        cons.gridx = 1;
//        cons.gridwidth = 2;
//        cons.weightx = 1;
//        cons.insets = new Insets(5, 5, 5, 5);
//        grid.setConstraints(agentC, cons);
//        param.add(agentC);
        
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 1;
        cons.weightx = 0;
        cons.weighty = 0;
        cons.insets = new Insets(5, 9, 5, 9);
        grid.setConstraints(startIP, cons);
        param.add(startIP);

        cons.gridx = 1;
        cons.gridwidth = 2;
        cons.weightx = 1;
        cons.insets = new Insets(5, 5, 5, 5);
        grid.setConstraints(startIPT, cons);
        param.add(startIPT);

        cons.gridx = 0;
        cons.gridy = 3;
        cons.gridwidth = 1;
        cons.weightx = 0;
        cons.insets = new Insets(5, 9, 5, 9);
        grid.setConstraints(endIP, cons);
        param.add(endIP);

        cons.gridx = 1;
        cons.gridwidth = 2;
        cons.weightx = 1;
        cons.insets = new Insets(5, 5, 5, 5);
        grid.setConstraints(endIPT, cons);
        param.add(endIPT);

//        cons.gridx = 0;
//        cons.gridy = 4;
//        cons.gridwidth = 6;
//        cons.weightx = 0;
//        initParamStart.setForeground(Color.orange);
//        grid.setConstraints(initParamStart, cons);
//        param.add(initParamStart);

        JPanel button = new JPanel();
        button.setLayout(grid);
        cons.weightx = 1;
        execute.addActionListener(this);
        grid.setConstraints(execute, cons);
        button.add(execute);
        execute.setEnabled(true);

        this.add(BorderLayout.NORTH, param);
        this.add(BorderLayout.SOUTH, button);
    }

    
    /**
	 * 事件处理函数，开始搜索/参数输送入错误/修改团体名列表/各种异常处理
	 */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == execute) {
        	if (IPCompare(startIPT.getText(),endIPT.getText())==-2){
				JOptionPane.showMessageDialog(null, "输入的 IP 地址格式不正确 ！");
				return;
			}else if (IPCompare(startIPT.getText(),endIPT.getText())>0){
				JOptionPane.showMessageDialog(null, "起始IP地址大于终止IP地址 ！");
				return;
			}
            execute.setEnabled(false);
//            agentC.setEnabled(false);
            startIPT.setEnabled(false);
            endIPT.setEnabled(false);
            PCAppletForm form = new PCAppletForm();
			form.setUserId(userId);
//            form.setUserName(userName);
//            form.setRoleName(roleName);
//            form.setAgentBO((AgentBO)agentC.getSelectedItem());
            form.setStartIP(startIPT.getText());
            form.setEndIP(endIPT.getText());
            DefaultSearchListener listener = new DefaultSearchListener(){
                @Override
                public void addSearchMessage(String message) {
                    pcPanel.getProcessPane().setMessage(message);
                }
                
                @Override
                public void canSearch(boolean isRunning) {
            		if (isRunning == true){
            			JOptionPane.showMessageDialog(null, "当前有其他用户正在使用该功能，请稍候再试 ！");
            			pcPanel.getProcessPane().setStop(false);
            			pcPanel.getParamPane().execute.setEnabled(true);
//            			pcPanel.getParamPane().agentC.setEnabled(true);
            			pcPanel.getParamPane().startIPT.setEnabled(true);
            			pcPanel.getParamPane().endIPT.setEnabled(true);
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
                	pcPanel.getProcessPane().setPercent(percent);
                }
                
                @Override
				public void remoteServiceExecuteError(String executeName) {
					JOptionPane.showMessageDialog(null, executeName);
					pcPanel.getProcessPane().setStop(false);
					if(!executeName.contains("停止失败")){
			            PCSearchAppletService pcSearchService = PCSearchAppletService.getInstance();
						pcSearchService.stopSearch(true);
					}
					pcPanel.getParamPane().execute.setEnabled(true);
//					pcPanel.getParamPane().agentC.setEnabled(true);
					pcPanel.getParamPane().startIPT.setEnabled(true);
					pcPanel.getParamPane().endIPT.setEnabled(true);
				}

				@Override
				public void remoteServiceNotResponse(String message) {
					JOptionPane.showMessageDialog(null, message);
					pcPanel.getProcessPane().setStop(false);
		            PCSearchAppletService pcSearchService = PCSearchAppletService.getInstance();
					pcSearchService.stopSearch(true);
					pcPanel.getParamPane().execute.setEnabled(true);
//					pcPanel.getParamPane().agentC.setEnabled(true);
					pcPanel.getParamPane().startIPT.setEnabled(true);
					pcPanel.getParamPane().endIPT.setEnabled(true);
				}

				@Override
				public void inputError(String error) {
					JOptionPane.showMessageDialog(null, error);
					pcPanel.getProcessPane().setStop(false);
		            PCSearchAppletService pcSearchService = PCSearchAppletService.getInstance();
					pcSearchService.stopSearch(true);
					pcPanel.getParamPane().execute.setEnabled(true);
//					pcPanel.getParamPane().agentC.setEnabled(true);
					pcPanel.getParamPane().startIPT.setEnabled(true);
					pcPanel.getParamPane().endIPT.setEnabled(true);
				}
                
                @Override
                public void onSearchFinished(List<Node> list) {
                	pcPanel.getProcessPane().setStop(false);
                    pcEntries = new ArrayList<PCEntryData>();
                    for(Node node : list){
                        PCEntryData pcdata = new PCEntryData();
                        pcdata.setId(node.getId());
                        pcdata.setIp(node.getIpAddr());
                        pcdata.setMac(node.getMac());
                        pcdata.setType(node.getNodeType());
                        pcdata.setDescription(node.getDescription());
                        pcdata.setSensorId(node.getSensorId());
                        pcEntries.add(pcdata);
                    }
                    if(pcEntries == null || pcEntries.isEmpty()){
                        JOptionPane.showMessageDialog(null, "用户停止或没有发现任何拓扑节点");
                    }else{
                    	final JFrame f = new JFrame();
//                        PCResultPanel result = new PCResultPanel(pcEntries, (AgentBO)agentC.getSelectedItem());
                        PCResultPanel result = new PCResultPanel(pcEntries);
                        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
                        f.setSize(600, 400);
                        f.setLocation(
                                (screenDimension.width - f.getSize().width) / 2,
                                (screenDimension.height - f.getSize().height) / 2);
                        f.setTitle("发现节点");
                        f.setLayout(new BorderLayout());
                        f.getContentPane().add(result, BorderLayout.CENTER);
                        f.setVisible(true);
                        f.setResizable(false);
                        try {
//                            UIManager.setLookAndFeel(UIManager
//                                    .getCrossPlatformLookAndFeelClassName());
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
                    pcPanel.getParamPane().execute.setEnabled(true);
//                    pcPanel.getParamPane().agentC.setEnabled(true);
                    pcPanel.getParamPane().startIPT.setEnabled(true);
                    pcPanel.getParamPane().endIPT.setEnabled(true);
                }
            };
            pcPanel.getProcessPane().clearFlowout();
            pcPanel.getProcessPane().setPercent(0);
            pcPanel.getProcessPane().setStop(true);
            PCSearchAppletService pcSearchService = PCSearchAppletService.getInstance();
            pcSearchService.doSearch(form, listener);
       
        }

    }
    
    /**
	 * validIP 判断ip是否合法
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
	 * @param ip1 起始ip
	 * @param ip2 终止ip
	 * @return -2（ip不合法），-1/0（起始ip小于或等于终止ip），1（起始ip大于终止ip）
	 */
	int IPCompare(String ip1, String ip2) {
		if (!validIP(ip1) || !validIP(ip2)){
			return -2;
		}
		long ipInt1 = 0, ipInt2 = 0;
		StringTokenizer token = new StringTokenizer(ip1, ".");
		for (int i = 0; i < 4; i++) {
			String slice = token.nextToken();
			long num = Integer.parseInt(slice);
			ipInt1 += num * (Math.pow(256,(3 - i)));
		}
		token = new StringTokenizer(ip2, ".");
		for (int i = 0; i < 4; i++) {
			String slice = token.nextToken();
			long num = Integer.parseInt(slice);
			ipInt2 += num * (Math.pow(256,(3 - i)));
		}
		if ((ipInt1 - ipInt2) > 0){
			return 1;
		}
		else {
			if ((ipInt1 - ipInt2) < 0){
				return -1;
			}
			else {
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
