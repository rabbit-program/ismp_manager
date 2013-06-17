package org.infosec.ismp.applet.manager.component.panel.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * 资源父类，通过PropertyChangeSupport，属性变化会fire出事件，更新界面。
 */
public class Info implements Serializable {
	protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		if (oldValue == newValue) {
			return;
		}
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}

	public void firePropertyChange(String propertyName, int oldValue, int newValue) {
		if (oldValue == newValue) {
			return;
		}
		propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
	}
}
