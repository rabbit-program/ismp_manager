package org.infosec.ismp.applet.discover.ui;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

/**
 * PCPanel
 * @author Wu Guojie
 * @date 2009-7-22
 * @version 1.0
 */
public class PCPanel extends JPanel {
    /**
     * PCSearchProcessPanel
     */
    private PCSearchProcessPanel processPane = new PCSearchProcessPanel(this);
    /**
     * PCParamPanel
     */
    private PCParamPanel paramPane = new PCParamPanel(this);
    /**
     * 构造函数
     */
//    public PCPanel(String userName, String roleName) {
    public PCPanel(int userId) {
//        init(userName, roleName);
        init(userId);
    }
    /**
     * 初始函数
     */
    public void init(int userId){
    	paramPane.setUserId(userId);
//    	paramPane.setUserName(userName);
//    	paramPane.setRoleName(roleName);
        this.setLayout(new GridLayout(1,2,5,5));
        this.add(paramPane);
        this.add(processPane);
    }

    /**
     * 获取PCParamPanel
     * @return paramPane
     */
    public PCParamPanel getParamPane() {
        return paramPane;
    }

    /**
     * 获取PCSearchProcessPanel
     * @return processPane
     */
    public PCSearchProcessPanel getProcessPane() {
        return processPane;
    }

//    public void addAgentList(List<AgentBO> agentList){
//    	this.paramPane.addAgentList(agentList);
//    }
}
