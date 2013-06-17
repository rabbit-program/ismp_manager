package org.infosec.ismp.manager.mos;
/**
 * 所有被管理对象的父类
 * @author lianglin
 *
 */
public abstract class ManagedObjectComponent {
	// public final static int UNKNOWN_STATE=0;
	// public final static int UP_STATE=1;
	// public final static int DOWN_STATE=2;
    public enum MOStatus{UNKNOWN_STATE,UP_STATE,DOWN_STATE};
    /**
     * 被管理对象的
     */
    protected MOStatus m_status;
	public MOStatus getStatus() {
		return m_status;
	}
	public void setStatus(MOStatus status) {
		m_status = status;
	}
    
    
}
