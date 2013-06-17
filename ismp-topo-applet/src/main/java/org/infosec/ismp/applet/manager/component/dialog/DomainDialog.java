package org.infosec.ismp.applet.manager.component.dialog;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.infosec.ismp.applet.manager.model.DomainModel;

import twaver.network.TNetwork;
import twaver.swing.TableLayout;

/**
 * 部门对话框
 * @author 肖高峰
 *
 */
@SuppressWarnings("serial")
public class DomainDialog  extends JDialog implements PropertyChangeListener{
    /**
     * 名称输入框
     */
	private JTextField txtName = new JTextField(11);
    /**
     * 备注输入框
     */
    private JTextArea  txaRemark=new JTextArea(3,11);
    
    private JButton btnEnter = new JButton("确定");
    private JButton btnCancel = new JButton("取消");
    /**
     * 云图模型
     */
    private DomainModel model;
    
    /**
     * 加入到哪个面
     */
    private TNetwork network;
    
    /**
     * 实例化一个云图
     * @param model 模型
     * @param title 标题
     */
    public DomainDialog(DomainModel model,TNetwork network) {
    	this.network = network;
    	if(this.network == null) {
    		JOptionPane.showMessageDialog(null,"当前拓扑面板不存在！","系统异常" , JOptionPane.ERROR_MESSAGE);
    		DomainDialog.this.dispose();
    		return;
    	}
    	this.model = model;
    	if(this.model == null) {
			this.model = new DomainModel();
		} else if(this.model.getId() == null) {
			this.setTitle("添加设备");
		} else {
			this.setTitle("修改设备");
		}
    	
    	initGUI();
    	this.pack();
    	this.setVisible(true);
    }
    
    private void initGUI() {
    	this.setLocationRelativeTo(null);
    	this.setSize(190, 176);
    	double b = 10;
		double f = TableLayout.FILL;
		double p = TableLayout.PREFERRED;
		double vs = 5;
		double vg = 10;
		double hg = 5;
		// b - border yes or no
		// f - FILL
		// p - 优选                                                                    eclipse Platfor
		// vs - 标签和文本字段的垂直间距
		// vg - 表单元素之间的垂直                                 
		// hg - 表单元素之间的水平差距
		double size[][] = { { b, f, hg, p, b },
				{ b, p, vg, p, p, p, vs, p, b } };
		
		JLabel  lblName = new JLabel("名称 :");
		JLabel  lblRemark= new JLabel("描述 :");
		
		JScrollPane sp = new JScrollPane();
		sp.getViewport().add(txaRemark);
		
		JPanel pane = new JPanel();
		pane.add(btnEnter);
		pane.add(btnCancel);
		
		Container c = this.getContentPane();
		c.setLayout(new TableLayout(size));
		c.add(lblName,"1,1");
		c.add(txtName,"3,1");
		c.add(lblRemark,"1,4");
		c.add(sp,"3,3,3,5");
		c.add(pane,"1,7,3,7");
		
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtName.getText().equals("")) {
					JOptionPane.showMessageDialog(DomainDialog.this, "未输入云图名称！");
					txtName.requestFocus();
				} else {
					model.setDomainName(txtName.getText());
					model.setDescription(txaRemark.getText());
					if(network.getCurrentSubNetwork() instanceof DomainModel) {
						model.setParentDomain((DomainModel)network.getCurrentSubNetwork());
					}
					model.save();
					DialogBuilder.disposeDomainDialog();
					DomainDialog.this.dispose();
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.disposeDomainDialog();
				DomainDialog.this.dispose();
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				DialogBuilder.disposeDomainDialog();
			}
		});
		
		updateFileds();

    }
    
    private void updateFileds() {
    	if(model.getDomainName() != null && !model.getDomainName().equals("")) {
    		txtName.setText(model.getDomainName());
    	}
		if(model.getDescription() != null && !model.getDescription().equals("")) {
    		txaRemark.setText(model.getDescription());
    	}
    }
    
	public void propertyChange(PropertyChangeEvent evt) {
		updateFileds();
	}

	public DomainModel getModel() {
		return model;
	}

	public void setModel(DomainModel model) {
		this.model = model;
		updateFileds();
	}
	
//	public static void main(String[] args) {
//		new DomainDialog(null);
//	}
 
}
