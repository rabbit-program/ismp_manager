/**
 * 
 */
package org.infosec.ismp.manager.server.event.process;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.infosec.ismp.manager.server.event.listener.ComplexEventListener;

/**
 * 打印事件时间
 * @author Jianyu Shen
 *
 * 2009-6-2 上午10:08:58
 */
public class FaciComplexListener implements ComplexEventListener{

    /**
     * 显示处理事件的时间
     */
    public void onComplexEvent(String complexEvent){
        DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance();
        String date = dateFormat.format(new Date());

//        System.out.println("CEP: " + date + " " + complexEvent);
    }
    
}
