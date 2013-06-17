/**
 * 
 */
package org.infosec.ismp.manager.server.event.process;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.infosec.ismp.manager.rmi.event.modle.NormalizedEvent;

/**
 * 测试事件生成器
 * @author Jianyu Shen
 *
 * 2009-6-1 下午04:50:42
 */
public class EventGenerator {

    private final Random random; //随机数用于随机生成事件
    
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //规范时间格式
     
    /**
     * 
     */
    public EventGenerator(){
        this.random = new Random();
    }
    
    /**
     * 
     * @return
     */
    public List<NormalizedEvent> generateBatch(){
        List<NormalizedEvent> batch = new LinkedList<NormalizedEvent>();
        
        generateEvent(batch);
        
        return batch;
    }
    
    /**
     * 
     * generateEvent
     * void
     * 生成归一化事件
     */
    private void generateEvent(List<NormalizedEvent> eventBatch){

        for(int i = 0; i < 20; i++){
            
            NormalizedEvent event = new NormalizedEvent();
            
            if(random.nextInt(10) < 1){     
                event.setIpaddr("192.168.1.1");
                event.setSrcip("128.129.3.1");
                event.setSrcport("12");
                event.setDestip("18.39.223.65");
                event.setDestport("945");
                event.setMessageType("DDOS");
                event.setDevicetype("ids");
                event.setThrerank(1);
                event.setTimestamp(Timestamp.valueOf(df.format(new Date())));
                event.setDomain("1");
            }else if(random.nextInt(10) < 1){
                event.setIpaddr("192.168.1.2");
                event.setSrcip("18.39.223.65");
                event.setSrcport("12");
                event.setDestip("143.66.144.23");
                event.setDestport("808");
                event.setMessageType("FLOOD");
                event.setDevicetype("firewall");
                event.setThrerank(2);
                event.setTimestamp(Timestamp.valueOf(df.format(new Date())));
                event.setDomain("1");
            }else if(random.nextInt(10) < 3){
                event.setIpaddr("192.168.1.3");
                event.setSrcip("192.168.9.119");
                event.setSrcport("192");
                event.setDestip("122.212.43.23");
                event.setDestport("255");
                event.setMessageType("WORM");
                event.setDevicetype("AAA_IDS");
                event.setThrerank(3);
                event.setTimestamp(Timestamp.valueOf(df.format(new Date())));
                event.setDomain("3");
            }else if(random.nextInt(10) < 8){
                event.setIpaddr("192.168.1.4");
                event.setSrcip("28.29.38.19");
                event.setSrcport("12");
                event.setDestip("87.162.226.87");
                event.setDestport("38");
                event.setMessageType("DOTEST");
                event.setDevicetype("ids");
                event.setThrerank(4);
                event.setDomain("1");
                event.setTimestamp(Timestamp.valueOf(df.format(new Date())));
            }else if(random.nextInt(10) < 5){
                event.setIpaddr("192.168.1.5");
                event.setSrcip("28.29.38.19");
                event.setSrcport("12");
                event.setDestip("43.98.44.66");
                event.setDestport("123");
                event.setMessageType("FLOOD");
                event.setDevicetype("ids");
                event.setThrerank(5);
                event.setDomain("2");
                event.setTimestamp(Timestamp.valueOf(df.format(new Date())));
            }else if(random.nextInt(10) < 6){
                event.setIpaddr("192.168.1.6");
                event.setSrcip("192.168.9.119");
                event.setSrcport("12");
                event.setDestip("122.212.43.23");
                event.setDestport("545");
                event.setMessageType("VIRUS");
                event.setDevicetype("BBB_IDS");
                event.setThrerank(2);
                event.setDomain("3");
                event.setTimestamp(Timestamp.valueOf(df.format(new Date())));
            }else if(random.nextInt(10) < 7){
                event.setIpaddr("192.168.1.7");
                event.setSrcip("192.168.9.119");
                event.setSrcport("12");
                event.setDestip("122.212.43.23");
                event.setDestport("545");
                event.setMessageType("ARP_IP");
                event.setDevicetype("switch");
                event.setThrerank(1);
                event.setDomain("3");
                event.setTimestamp(Timestamp.valueOf(df.format(new Date())));
            }else if(random.nextInt(10) < 4){
                event.setIpaddr("192.168.1.8");
                event.setSrcip("192.168.9.119");
                event.setSrcport("12");
                event.setDestip("122.212.43.23");
                event.setDestport("545");
                event.setMessageType("ARP_IP");
                event.setDevicetype("switch");
                event.setThrerank(3);
                event.setDomain("3");
                event.setTimestamp(Timestamp.valueOf(df.format(new Date())));
            }else{
                event.setIpaddr("192.168.1.9");
                event.setSrcip("192.168.9.119");
                event.setSrcport("12");
                event.setDestip("43.98.44.66");
                event.setDestport("545");
                event.setMessageType("SSLATTACK");
                event.setDevicetype("WEB");
                event.setThrerank(4);
                event.setDomain("3");
                event.setTimestamp(Timestamp.valueOf(df.format(new Date())));
            }
            
            if(event != null){
                eventBatch.add(event);
            }
        }
    }
}
