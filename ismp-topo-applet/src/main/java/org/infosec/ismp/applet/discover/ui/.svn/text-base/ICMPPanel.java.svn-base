package org.infosec.ismp.applet.discover.ui;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

/**
 * ICMPPanel
 * @author sshanshan
 * @date 2009-6-13
 * @version 1.0
 */

public class ICMPPanel extends JPanel{
    /**
     * ICMPSearchProcessPanel
     */
    private ICMPSearchProcessPanel processPane = new ICMPSearchProcessPanel(this);
    /**
     * ICMPParamPanel
     */
    private ICMPParamPanel paramPane = new ICMPParamPanel(this);
    /**
     * 构造函数
     */
//    public ICMPPanel(String userName, String roleName) {
    public ICMPPanel(int userId) {
//        init(userName, roleName);
        init(userId);
    }
    /**
     * 初始函数
     */
//    public void init(String userName, String roleName){
    public void init(int userId){
    	paramPane.setUserId(userId);
//    	paramPane.setUserName(userName);
//    	paramPane.setRoleName(roleName);
        this.setLayout(new GridLayout(1,2,5,5));
        this.add(paramPane);
        this.add(processPane);
    }

    /**
     * 获取ICMPParamPanel
     * @return paramPane
     */
    public ICMPParamPanel getParamPane() {
        return paramPane;
    }

    /**
     * 获取ICMPSearchProcessPanel
     * @return processPane
     */
    public ICMPSearchProcessPanel getProcessPane() {
        return processPane;
    }

//    public void addAgentList(List<AgentBO> agentList){
//    	this.paramPane.addAgentList(agentList);
//    }
}
