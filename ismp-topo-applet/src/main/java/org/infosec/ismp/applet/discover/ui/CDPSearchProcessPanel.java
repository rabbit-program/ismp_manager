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

import org.infosec.ismp.applet.discover.service.CDPSearchAppletService;
/**
 * CDPSearchProcessPanel
 * @author sshanshan
 * @date 2009-06-19
 * @version 1.0
 */
public class CDPSearchProcessPanel extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
    private JTextArea flowout = new JTextArea("发现输出详细信息："+"\n");
    private JLabel process = new JLabel("发现进度",SwingConstants.CENTER);
    private int percent = 0;

    private JProgressBar progressBar = new JProgressBar(0,100);
    private JButton stop = new JButton("停止");
    private CDPPanel cdpPanel = null;
    
    public CDPSearchProcessPanel(CDPPanel cdpPanel) {
        this.cdpPanel = cdpPanel;
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

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        if (source == stop) {
        	JOptionPane.showMessageDialog(CDPSearchProcessPanel.this,"正在停止，请耐心等待...","提示" , JOptionPane.INFORMATION_MESSAGE);
            stop.setEnabled(false);
            CDPSearchAppletService cdpSearchService = CDPSearchAppletService.getInstance();
            cdpSearchService.stopSearch(false);
        }
    }        

    public void setPercent(int percent) {
        this.percent = percent;
        progressBar.setValue(percent);
        
    }
    
    public void setMessage(String message) {
        flowout.append(message);
        flowout.setCaretPosition(flowout.getText().length());
    }

    public void clearFlowout(){
        flowout.setText("发现输出详细信息："+"\n");
        flowout.setCaretPosition(flowout.getText().length());
    }
    
    public void setStop(boolean b){
        stop.setEnabled(b);
    }
    
    
}
