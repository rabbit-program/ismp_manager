package org.infosec.ismp.applet.discover.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.infosec.ismp.applet.discover.service.SNMPSearchAppletService;

/**
 * SNMPSearchProcessPanel
 * @author sshanshan
 * @date 2009-06-16
 * @version 1.0
 */
public class SNMPSearchProcessPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
    /**
     *  发现输出信息显示
     */
    private JTextArea flowout = new JTextArea("发现输出详细信息："+"\n");
    JLabel process = new JLabel("发现进度",SwingConstants.CENTER);
    /**
     * 发现进度百分比
     */
    private int percent = 0;

    JProgressBar progressBar = new JProgressBar(0,100);
    private JButton stop = new JButton("停止");
    /**
     * 传入的snmpPanel句柄
     */
    private SNMPPanel snmpPanel = null;
    
    /**
     * 构造函数
     * @param snmpPanel
     */
    public SNMPSearchProcessPanel(SNMPPanel snmpPanel) {
        this.snmpPanel = snmpPanel;
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setLayout(new BorderLayout(5,5));
        
        JScrollPane scrollPane = new JScrollPane(flowout,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints cons = new GridBagConstraints();
        cons.insets = new Insets(5,5,5,5);
        cons.anchor = GridBagConstraints.NORTHWEST;
        cons.fill = GridBagConstraints.BOTH;
        
        JPanel center = new JPanel();
        center.setLayout(grid);
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 3;
        cons.weightx = 1;
        cons.weighty = 1;
        grid.setConstraints(scrollPane, cons);
        center.add(scrollPane);
     
        JPanel south = new JPanel();
        south.setLayout(grid);

        progressBar.setStringPainted(true);
        

        cons.insets = new Insets(10,5,5,5);
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth =1;
        cons.weightx = 0;
        cons.weighty = 0;
        cons.fill = GridBagConstraints.BOTH;
        grid.setConstraints(process, cons);
        south.add(process);
        
        cons.gridx = 1;
        cons.gridwidth = 1;
        cons.weightx = 1;
        cons.weighty = 0;
        grid.setConstraints( progressBar, cons );
        south.add(progressBar);
      
        cons.gridx = 0;
        cons.gridy = 1;
        cons.gridwidth = 2;

        cons.weighty = 1;
        stop.addActionListener(this);
        stop.setEnabled(false);
        grid.setConstraints( stop, cons );
        south.add(stop);
    
        this.add(BorderLayout.CENTER, center);
        this.add(BorderLayout.SOUTH, south);
        
        
    }
    /**
     * 事件处理函数，处理停止搜索事件
     */
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        if (source == stop) {
        	 JOptionPane.showMessageDialog(SNMPSearchProcessPanel.this,"正在停止，请耐心等待...","提示" , JOptionPane.INFORMATION_MESSAGE);
            stop.setEnabled(false);
            SNMPSearchAppletService snmpSearchService = SNMPSearchAppletService.getInstance();
            snmpSearchService.stopSearch(false);
        }
    }        

    /**
     * 设置发现进度百分比
     * @param percent
     */
    public void setPercent(int percent) {
        this.percent = percent;
        progressBar.setValue(percent);
        
    }
    /**
     * 设置发现输出信息
     * @param message
     */
    public void setMessage(String message) {
        flowout.append(message);
        flowout.setCaretPosition(flowout.getText().length());
    }
    /**
     * 清空发现输出信息
     */
    public void clearFlowout(){
        flowout.setText("发现输出详细信息："+"\n");
        flowout.setCaretPosition(flowout.getText().length());
    }
    /**
     * 设置停止按钮可用不可用
     * @param true/false
     */
    public void setStop(boolean b){
        stop.setEnabled(b);
    }
    
    
}
