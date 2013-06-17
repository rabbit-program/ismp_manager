package org.infosec.ismp.applet.manager.component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import org.infosec.ismp.applet.manager.model.NodeModel;

/**
 * 设备抽象面板
 * @author 肖高峰
 *
 */
public abstract class AbstractViewPanel extends JPanel implements PropertyChangeListener{
	protected NodeModel model;
	private static final long serialVersionUID = 785977303562477195L;
	
	public void setModel(NodeModel node) {
		if(node == null) {
			throw new RuntimeException("传入的NodeModel摸型为空！");
		}
		this.model = node;
		updateFileds();
	}
	
	protected abstract void updateFileds();
	
	public void propertyChange(PropertyChangeEvent evt) {
		updateFileds();
	}
}
