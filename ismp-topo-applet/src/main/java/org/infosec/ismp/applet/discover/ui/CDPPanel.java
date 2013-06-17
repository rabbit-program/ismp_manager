package org.infosec.ismp.applet.discover.ui;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

/**
 * CDPPanel
 * @author sshanshan
 * @date 2009-06-19
 * @version 1.0
 */
public class CDPPanel extends JPanel{
    private CDPParamPanel paramPane = new CDPParamPanel(this);
    private CDPSearchProcessPanel processPane = new CDPSearchProcessPanel(this);

//    public CDPPanel(String userName, String roleName) {
    public CDPPanel(int userId) {
//        init(userName, roleName);
        init(userId);
    }

//    public void init(String userName, String roleName) {
    public void init(int userId) {
    	paramPane.setUserId(userId);
//    	paramPane.setUserName(userName);
//    	paramPane.setRoleName(roleName);
        this.setLayout(new GridLayout(1,2,5,5));
        this.add(paramPane);
        this.add(processPane);
    }

	public CDPParamPanel getParamPane() {
		return paramPane;
	}

	public CDPSearchProcessPanel getProcessPane() {
		return processPane;
	}

//    public void addAgentList(List<AgentBO> agentList){
//    	this.paramPane.addAgentList(agentList);
//    }
}
