package edu.sjtu.infosec.ismp.manager.comm.comm.conn.jdbc;
import java.util.Properties;
import java.io.*;
/**
 * 读取属性文件
 * @author ZBing
 *
 */
public class ReadProp {
    public Properties read() {
    	 Properties properties = new Properties();
        	InputStream inputStream =getClass().getResourceAsStream("/connection/jdbc/synrav.properties");
        	 try {
        		 properties.load(inputStream);
        	 } catch (IOException e1) {
        		 e1.printStackTrace();
        	 }
        return properties;
    } 
}
