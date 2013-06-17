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
import org.infosec.ismp.applet.manager.model.TopoServerModel;
import org.infosec.ismp.applet.manager.model.TopoWeblogicModel;
import org.infosec.ismp.applet.manager.utilities.InitUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;
import org.infosec.ismp.applet.manager.utilities.TypeUtil;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.SNMPEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TopoManageConstant;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;

import twaver.network.TNetwork;
import twaver.swing.TableLayout;


/**
 * 数据库面板
 * @author 肖高峰
 *
 */
@SuppressWarnings("serial")
public class DeviceDialog extends JDialog {
	private JTextField txtName = new JTextField();
	private JIpAddressField txtIpAddress = new JIpAddressField();
	private JNumberField txtPort = new JNumberField();
	private JTextField txtCommunity = new JTextField();
	private JComboBox cmbVersion  = new JComboBox();
	private JComboBox cmbBrand = new JComboBox();
	private JComboBox cmbModel = new JComboBox();
	private JComboBox cmbSystem = new JComboBox();
	private JLabel lblBrand = new JLabel("设备品牌");
	private JLabel lblModel = new JLabel("设备型号");
	private JLabel lblSystem = new JLabel("操作系统");
	
	protected JButton buttonEnter = new JButton("确定");
	protected JButton buttonCancel = new JButton("取消");
	
	private DevicePanel pane;
	
    /**
     * 数据模型
     */
    private NodeModel model;
    /**
     * 拓扑面板
     */
    private TNetwork network;
	public DeviceDialog(NodeModel node,TNetwork network) {
		this.network = network;
    	if(this.network == null) {
    		JOptionPane.showMessageDialog(null,"当前拓扑面板不存在！","系统异常" , JOptionPane.ERROR_MESSAGE);
    		DeviceDialog.this.dispose();
    		return;
    	}
		model = node;
		if(model == null) {
			this.model = new NodeModel();
		} else if(model.getNodeId() == null || model.getNodeId().equals("")) {
			this.setTitle("添加设备");
		}else {
			this.setTitle("修改设备");
		}
		initGUI();
	}
	
	
	/**
	 * 初始化界面
	 */
	private void initGUI() {
		
		this.setLocationRelativeTo(null);
		pane = new DevicePanel();
		pane.setModel(model);
		this.getContentPane().add(pane);
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
					DialogBuilder.disposeDeviceDialog();
					DeviceDialog.this.dispose();
					
				}
			}
		});
	
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.disposeDeviceDialog();
				DeviceDialog.this.dispose();
			}
		}); 
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				DialogBuilder.disposeDeviceDialog();
			}
		});
	}
	
	//填充数据
	public void fillData() {
		model.setName(txtName.getText());
		model.setIpAddress(txtIpAddress.getText());
		model.setManagerStyle(TopoManageConstant.SNMP);
		model.setType(TypeUtil.getNodeTypeBySimpleClassName(model.getClass().getSimpleName()));
		if(cmbSystem.getSelectedItem() != null) {
			model.setSystem(cmbSystem.getSelectedItem().toString());
		}
		if(cmbBrand.getSelectedItem() != null) {
			model.setBrand((TradeMarkEntity)cmbBrand.getSelectedItem());
		}
		if(cmbModel.getSelectedItem() != null) {
			model.setModel((DeviceModelEntity)cmbModel.getSelectedItem());
		}
		SNMPEntity snmp = model.getSnmp();
		if(snmp == null) {
			snmp = new SNMPEntity();
		}
		snmp.setVersion(cmbVersion.getSelectedItem().toString());
		snmp.setCommunity(txtCommunity.getText());
		snmp.setPort(txtPort.getText());
		model.setSnmp(snmp);
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
		} else if(txtCommunity.getText().equals("") || txtCommunity.getText().trim().equals("")) {
			info = "请输入团体名！";
			txtCommunity.requestFocus();
		} else if(txtPort.getText().equals("") || txtPort.getText().trim().equals("")) {
			info = "请输入端口！";
			txtPort.requestFocus();
		} 
		if(!info.equals("")) {
			JOptionPane.showMessageDialog(DeviceDialog.this,info,"提示" , JOptionPane.INFORMATION_MESSAGE);
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
		pane.setModel(model);
	}
	
	public static void main(String[] args) {
		new DeviceDialog(null,new TNetwork());
	}
	
	private class DevicePanel extends AbstractViewPanel {
		public DevicePanel() {
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

			JLabel lblName = new JLabel("设备名称");
			JLabel lblIpAddress = new JLabel("IP地址");
			JLabel lblPort = new JLabel("端口");
			JLabel lblCommunity = new JLabel("团体名");
			JLabel lblVersion  = new JLabel("版本");

			txtIpAddress.setPreferredSize(new Dimension(200, 25));
			txtName.setPreferredSize(new Dimension(200, 25));
			txtPort.setText("161");
			txtCommunity.setText("public");
			JPanel panelButton = new JPanel();
			panelButton.add(buttonEnter);
			panelButton.add(buttonCancel);
			JPanel pane = this;
			TableLayout layout = new TableLayout(size);
			pane.setLayout(layout);
			pane.add(lblName, "1,  1");
			pane.add(txtName, "1,  3");
			pane.add(lblIpAddress, "3,  1");
			pane.add(txtIpAddress, "3, 3");
			pane.add(lblCommunity, "1 , 5");
			pane.add(txtCommunity, "1 , 7");
			pane.add(lblPort, "3 , 5");
			pane.add(txtPort, "3 , 7");
			pane.add(lblBrand, "1, 9");
			pane.add(cmbBrand, "1, 11");
			pane.add(lblModel, "3 , 9");
			pane.add(cmbModel, "3 , 11");
			pane.add(lblVersion,"1 , 13");
			pane.add(cmbVersion,"1 , 15");
			pane.add(lblSystem,"3 , 13");
			pane.add(cmbSystem,"3 , 15");
			pane.add(panelButton, "1,17,3,17");
			
			cmbVersion.setModel(new DefaultComboBoxModel(new String[]{"1","2"}));
			
		}

		@Override
		protected void updateFileds() {
			//为了节省代码---这里偷懒没有再写server面板。只在这里做了一下判断
			if(super.model instanceof TopoServerModel) {
				lblSystem.setEnabled(true);
				cmbSystem.setEnabled(true);
				cmbSystem.setModel(new DefaultComboBoxModel(new String[]{"windows","AIX"}));
			} else {
				lblSystem.setEnabled(false);
				cmbSystem.setEnabled(false);
			}
			
			//为了节省代码---这里偷懒没有再写weblogic面板。只在这里做了一下判断
			if(super.model instanceof TopoWeblogicModel) {
				lblBrand.setEnabled(false);
				cmbBrand.setEnabled(false);
				lblModel.setEnabled(false);
				cmbModel.setEnabled(false);
			} else {
				lblBrand.setEnabled(true);
				cmbBrand.setEnabled(true);
				lblModel.setEnabled(true);
				cmbModel.setEnabled(true);
				TradeMarkEntity[] brands = TopoConst.TRADE_MARKS;
				if(brands != null ) {
					cmbBrand.setModel(new DefaultComboBoxModel(brands));
					if(brands.length > 0) {
						cmbModel.setModel(new DefaultComboBoxModel(TopoConst.MODELS_WITH_BRAND.get(brands[0])));
					}
				}
				cmbBrand.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						cmbModel.setModel(new DefaultComboBoxModel
								(TopoConst.MODELS_WITH_BRAND.get((TradeMarkEntity)cmbBrand.getSelectedItem())));
					}
				});
			}
			txtName.setText(super.model.getName()== null ? "" : super.model.getName());
			String[] ips = getIp(super.model.getIpAddress());
			if(ips != null && ips.length == 4) {
				txtIpAddress.ip1.setText(ips[0]);
				txtIpAddress.ip2.setText(ips[1]);
				txtIpAddress.ip3.setText(ips[2]);
				txtIpAddress.ip4.setText(ips[3]);
			}
			
			SNMPEntity snmp = super.model.getSnmp();
			if(snmp == null) return;
			
			txtCommunity.setText(snmp.getCommunity()== null ? "" : snmp.getCommunity());
			txtPort.setText(snmp.getPort()== null ? "" : snmp.getPort());
			
			
			TradeMarkEntity brand = super.model.getBrand();
			if( brand!= null && !brand.equals("")) {
				cmbBrand.setSelectedItem(brand);
			}
			
			DeviceModelEntity deviceModel = super.model.getModel();
			if( deviceModel!= null && !deviceModel.equals("")) {
				cmbModel.setSelectedItem(deviceModel);
			}
			String version = snmp.getVersion();
			if( version!= null && !version.equals("")) {
				cmbVersion.setSelectedItem(version);
			}
			String system = super.model.getSystem();
			if( version!= null && !version.equals("")) {
				cmbSystem.setSelectedItem(system);
			}
			
			
		}
	}
}
