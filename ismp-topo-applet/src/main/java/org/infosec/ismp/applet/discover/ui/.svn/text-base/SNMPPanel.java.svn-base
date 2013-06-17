package org.infosec.ismp.applet.discover.ui;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

/**
 * SNMPPanel
 * @author sshanshan
 * @date 2009-06-18
 * @version 1.0
 */
public class SNMPPanel extends JPanel{
	/**
	 * SNMPParamPanel
	 */
    private SNMPParamPanel paramPane = new SNMPParamPanel(this);
    /**
     * SNMPSearchProcessPanel
     */
    private SNMPSearchProcessPanel processPane = new SNMPSearchProcessPanel(this);

    /**
     * 构造函数
     */
    public SNMPPanel(int userId) {
//        init(userName, roleName);
        init(userId);
    }

    /**
     * 初始函数
     */
    public void init(int userId) {
    	paramPane.setUserId(userId);
//    	paramPane.setUserName(userName);
//    	paramPane.setRoleName(roleName);
        this.setLayout(new GridLayout(1,2,5,5));
        this.add(paramPane);
        this.add(processPane);
    }

    /**
     * 获取paramPane
     * @return paramPane
     */
	public SNMPParamPanel getParamPane() {
		return paramPane;
	}

	/**
	 * 获取processPane
	 * @return processPane
	 */
	public SNMPSearchProcessPanel getProcessPane() {
		return processPane;
	}

//    public void addAgentList(List<AgentBO> agentList){
//    	this.paramPane.addAgentList(agentList);
//    }
}



