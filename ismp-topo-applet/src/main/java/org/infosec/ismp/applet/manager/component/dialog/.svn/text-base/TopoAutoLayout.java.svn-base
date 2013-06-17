/**
 * 版权所有：上海鹏越惊虹信息技术发展有限公司
 */
package org.infosec.ismp.applet.manager.component.dialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import twaver.SpringLayouter;
import twaver.TDataBox;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.network.OverviewPane;
import twaver.network.TNetwork;

/**
 * @author 肖高峰
 *
 */
@SuppressWarnings("serial")
public class TopoAutoLayout extends JInternalFrame{
	private static String name = "视图布局";
	@SuppressWarnings("unused")
	private TDataBox box ;
	private TNetwork network ;
	private ButtonGroup group = new ButtonGroup();
	private JPanel controlPane = TWaverUtil.createVerticalPanel(3);
	@SuppressWarnings("unused")
	private JRadioButton currentRadioButton = null;
	/**
	 * 构造 方法
	 * @param network 操作对象
	 */
	public TopoAutoLayout(final TNetwork network){
		super(name,false,true);
		this.network =network;
		box = network.getDataBox();
		this.initControlPane();
		
		this.getContentPane().add(controlPane);
      	this.setTitle(name);     	
      	this.pack();
      	this.setLocation(600, 60);
      	this.setSize(180, 300);
		network.getLayeredPane().add(this, 0);
		//network.doLayout(TWaverConst.LAYOUT_SYMMETRIC);
		
		
		this.network.setElementTransparentAreaSelectable(true);		
		
		this.setVisible(true);
	}
	/**
	 * 初始化布局面板
	 */
	private void initControlPane(){
		final SpringLayouter layouter = network.getSpringLayouter();
		final JSlider stepSize = new JSlider(1, 50, layouter.getStepSize());
		final JSlider forceSize = new JSlider(10, 200, layouter.getForceSize());
		
		stepSize.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				layouter.setStepSize(stepSize.getValue());
			}
		});
		forceSize.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
				layouter.setForceSize(forceSize.getValue());
			}
		});
		
		addInternalFrameListener(new InternalFrameAdapter(){ 
			 public   void   internalFrameClosing(InternalFrameEvent e) {
				 DialogBuilder.disposeTopoAutoLayout();
			 } 
		});
		

		this.controlPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		//this.addSlider("间隔大小：", stepSize);
		//this.addSlider("扩散大小:", forceSize);
		//this.controlPane.add(overview);
		//this.controlPane.add(attachment);	


		this.addRadioButton("环形布局", TWaverConst.LAYOUT_CIRCULAR);
		this.addRadioButton("对称布局", TWaverConst.LAYOUT_SYMMETRIC);
		this.addRadioButton("树形布局", TWaverConst.LAYOUT_TREE);
		this.addRadioButton("等级布局", TWaverConst.LAYOUT_HIERARCHIC);		
		this.addRadioButton("向东布局", TWaverConst.LAYOUT_EAST);
		this.addRadioButton("向西布局", TWaverConst.LAYOUT_WEST);
		
		//小视图
		OverviewPane overview = new OverviewPane(network);
		overview.setUpdateInterval(50);
		overview.setPreferredSize(new Dimension(100, 100));
		this.controlPane.add(overview);
	}
	
	/**
	 * 添加单选布局按钮到面板
	 * @param label 按钮文本
	 * @param type 布局类型
	 */
	private void addRadioButton(String label, final int type){
		final JRadioButton button = new JRadioButton(label);
		this.group.add(button);
		this.controlPane.add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				network.doLayout(type);
				currentRadioButton = button;
			}
		});
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		TopoAutoLayout.name = name;
	}
	
}
