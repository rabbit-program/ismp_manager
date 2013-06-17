package org.infosec.ismp.applet.manager.component.dialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.infosec.ismp.applet.manager.component.AbstractViewPanel;
import org.infosec.ismp.applet.manager.component.JIpAddressField;
import org.infosec.ismp.applet.manager.component.JNumberField;
import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.TypeUtil;
import org.infosec.ismp.manager.rmi.tm.manager.comm.DatabaseConst;
import org.infosec.ismp.manager.rmi.tm.manager.model.DatabaseEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TopoManageConstant;

import twaver.network.TNetwork;
import twaver.swing.TableLayout;

/**
 * 数据库面板
 * @author 肖高峰
 *
 */
@SuppressWarnings("serial")
public class DatabaseDialog extends JDialog {
	private static final long INTERVAL= 30L; //轮询最低的时间
	private JTextField txtName = new JTextField();
	private JIpAddressField txtIpAddress = new JIpAddressField();
	private JComboBox cmbType = new JComboBox();
	private JTextField txtUserName = new JTextField();
	private JTextField txtPassword = new JTextField();
	private JNumberField txtInterval = new JNumberField();
	protected JButton buttonEnter = new JButton("确定");
	protected JButton buttonCancel = new JButton("取消");
    private JComboBox cmbVersion = new JComboBox();
	
    /**
     * 数据模型
     */
    private NodeModel model;
    /**
     * 拓扑面板
     */
    private TNetwork network;
    
    private DatabasePanel panel;
	public DatabaseDialog(NodeModel node,TNetwork network) {
		this.network = network;
    	if(this.network == null) {
    		JOptionPane.showMessageDialog(null,"当前拓扑面板不存在！","系统异常" , JOptionPane.ERROR_MESSAGE);
    		DatabaseDialog.this.dispose();
    		return;
    	}
		model = node;
		if(model == null) {
			this.model = new NodeModel();
		} else if(model.getNodeId() == null || model.getNodeId().equals("")) {
			this.setTitle("添加数据库");
		}else {
			this.setTitle("修改数据库");
		}
		initGUI();
	}
	
	
	
	/**
	 * 初始化界面
	 */
	private void initGUI() {
		
		this.setLocationRelativeTo(null);
		panel = new DatabasePanel();
		panel.setModel(model);
		this.getContentPane().add(panel);
		
		pack();
		setVisible(true);
		
		buttonEnter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(doCheck()) {
					if(network.getCurrentSubNetwork() instanceof DomainModel) {
						model.setParentDomain((DomainModel)network.getCurrentSubNetwork());
					}
					fillData();
					model.setIsVisible(1);
					model.save(model);
					DialogBuilder.disposeDatabaseDialog();
					DatabaseDialog.this.dispose();
				}
			}
		});
	
		
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.disposeDatabaseDialog();
				DatabaseDialog.this.dispose();
			}
		}); 
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				DialogBuilder.disposeDatabaseDialog();
			}
		});
	}
	
	//填充数据
	protected void fillData() {
		DatabaseEntity database = model.getDatabase();
		if(database == null) {
			database = new DatabaseEntity();
		}
		model.setName(txtName.getText());
		model.setManagerStyle(TopoManageConstant.DATABASE);
		model.setType(TypeUtil.getNodeTypeBySimpleClassName(model.getClass().getSimpleName()));
		database.setDatabaseName(txtName.getText());
		database.setUrl(txtIpAddress.getText());
		database.setIp(txtName.getText());
		database.setUpInterval(Long.valueOf(txtInterval.getText()));
		database.setPassword(txtPassword.getText());
		database.setUsername(txtUserName.getText());
		database.setVersion(cmbVersion.getSelectedItem() == null ? "" : cmbVersion.getSelectedItem().toString());
		database.setType(cmbType.getSelectedItem() == null ? "" : cmbType.getSelectedItem().toString());
		model.setDatabase(database);
	}
	
	//检查数据
	protected boolean doCheck() {
		String info = "";
		if(txtName.getText().equals("") || txtName.getText().trim().equals("")) {
			info = "请输入数据库名称！";
			txtName.requestFocus();
		} else if(txtIpAddress.getText().equals("0.0.0.0")) {
			info = "请输入数据库IP地址！";
			txtIpAddress.ip1.requestFocus();
		} else if(txtUserName.getText().equals("") || txtUserName.getText().trim().equals("")) {
			info = "请输入数据库用户名！";
			txtUserName.requestFocus();
		} else if(txtInterval.getText().equals("")) {
			info = "请输入监控轮询间隔！";
			txtInterval.requestFocus();
		} else if(Long.parseLong(txtInterval.getText()) < INTERVAL) {
			info = "监控轮询间隔不能低于 "+INTERVAL+" 秒！";
			txtInterval.requestFocus();
		} else if(txtName.getText().length() > 20) {
			info = "数据库名称长度不能超过20！";
			txtName.requestFocus();
		}else if(txtUserName.getText().length() > 20) {
			info = "用户名称长度不能超过20！";
			txtUserName.requestFocus();
		}else if(txtPassword.getText().length() > 20) {
			info = "密码长度不能超过20！";
			txtPassword.requestFocus();
		}
		if(!info.equals("")) {
			JOptionPane.showMessageDialog(DatabaseDialog.this,info,"提示" , JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
	
	private String[] getIp(String ip) {
		if(ip != null && !ip.equals("")) {
			return ip.split("[.]");
		}
		return null;
	}
	
	public NodeModel getModel() {
		return model;
	}

	public void setModel(NodeModel model) {
		this.model = model;
		panel.setModel(model);
	}
	
	public static void main(String[] args) {
		new DatabaseDialog(null,new TNetwork());
	}
	
	private class DatabasePanel extends AbstractViewPanel {
		public DatabasePanel() {
			initGUI();
		}
		
		private void initGUI() {
			double b = 10;
			double f = TableLayout.FILL;
			double p = TableLayout.PREFERRED;
			double vs = 5;
			double vg = 10;
			double hg = 10;
			// b - border yes or no
			// f - FILL
			// p - 优选                                                                    eclipse Platfor
			// vs - 标签和文本字段的垂直间距
			// vg - 表单元素之间的垂直                                 
			// hg - 表单元素之间的水平差距
			double size[][] = { { b, f, hg, p, b },
					{ b, p, vs, p, vg, p, vs, p, vg, p, vs, p, vg,p,vs, p,vg,p, b } };

			JLabel labelName = new JLabel("数据库名称");
			JLabel labelIpAddress = new JLabel("数据库IP地址");
			JLabel labelType = new JLabel("数据库类型");
			JLabel labelUserName = new JLabel("数据库用户名");
			JLabel labelPassword = new JLabel("数据库密码");
			JLabel labelInterval = new JLabel("监控轮询间隔(>=30秒)");
			JLabel lblVersion = new JLabel("版本");

			cmbType.setPreferredSize(new Dimension(200, 25));
			txtUserName.setPreferredSize(new Dimension(200,25));
			txtInterval.setPreferredSize(new Dimension(200, 25));
			txtInterval.setHorizontalAlignment(JTextField.LEFT);
			txtIpAddress.setPreferredSize(new Dimension(200, 25));
			txtInterval.setText(INTERVAL+"");
			JPanel panelButton = new JPanel();
			panelButton.add(buttonEnter);
			panelButton.add(buttonCancel);
			JPanel pane = this;
			TableLayout layout = new TableLayout(size);
			pane.setLayout(layout);
			pane.add(labelName, "1,  1");
			pane.add(txtName, "1,  3");
			pane.add(labelIpAddress, "3,  1");
			pane.add(txtIpAddress, "3, 3");
			pane.add(labelUserName, "1 , 5");
			pane.add(txtUserName, "1 , 7");
			pane.add(labelPassword, "3 , 5");
			pane.add(txtPassword, "3 , 7");
			pane.add(labelType, "1, 9");
			pane.add(cmbType, "1, 11");
			pane.add(labelInterval, "3 , 9");
			pane.add(txtInterval, "3 , 11");
			
			pane.add(lblVersion,"1 , 13");
			pane.add(cmbVersion,"1 , 15");
			pane.add(panelButton, "1,17,3,17");
			
			cmbType.setModel(new DefaultComboBoxModel(DatabaseConst.DATABASE_TYPE));
			cmbVersion.setModel(new DefaultComboBoxModel(DatabaseConst.DATABASE_VERSION_ORACLE));
			cmbType.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					cmbVersion.setModel(new DefaultComboBoxModel
							(DatabaseConst.DATABASE_TYPE_VERSION.get(cmbType.getSelectedItem())));
				}
			});
		}

		@Override
		protected void updateFileds() {
			String[] ips = getIp(model.getIpAddress());
			if(ips != null && ips.length == 4) {
				txtIpAddress.ip1.setText(ips[0]);
				txtIpAddress.ip2.setText(ips[1]);
				txtIpAddress.ip3.setText(ips[2]);
				txtIpAddress.ip4.setText(ips[3]);
			}
			txtName.setName(model.getName());
			DatabaseEntity database = model.getDatabase();
			if(database == null) return;
			txtName.setText(database.getDatabaseName()== null ? "" : database.getDatabaseName());
			txtUserName.setText(database.getUsername()== null ? "" : database.getUsername());
			txtPassword.setText(database.getPassword()== null ? "" : database.getPassword());
			txtInterval.setText(database.getUpInterval() > 30L ? INTERVAL+"" : database.getUpInterval()+"");
			txtUserName.setText(database.getUsername()== null ? "" : database.getUsername());
			String type = database.getType();
			if( type!= null && !type.equals("")) {
				cmbType.setSelectedItem(type);
			}
			String version = database.getVersion();
			if( version!= null && !version.equals("")) {
				cmbVersion.setSelectedItem(version);
			}
			
		}
	}

}
