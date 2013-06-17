package org.infosec.ismp.manager.rmi.aim.service;

import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;

/**
 * Alert处理器
 * @author lianglin
 *
 */
public interface AlertConsumer {
     public void onAlert(AlertInfoBO alert);
}
