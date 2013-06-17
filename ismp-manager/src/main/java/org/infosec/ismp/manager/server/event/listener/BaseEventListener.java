/**
 * 
 */
package org.infosec.ismp.manager.server.event.listener;

import com.espertech.esper.client.UpdateListener;

/**
 * 抽象类，定义基本事件监听器
 * @author Jianyu Shen
 *
 * 2009-6-1 下午04:41:44 
 */
public abstract class BaseEventListener implements UpdateListener{

    protected ComplexEventListener complexEventListener;
    
    /**
     * 
     * @param complexEventListener
     */
    public BaseEventListener(ComplexEventListener vComplexEventListener){
        this.complexEventListener = vComplexEventListener;
    }
    
}
