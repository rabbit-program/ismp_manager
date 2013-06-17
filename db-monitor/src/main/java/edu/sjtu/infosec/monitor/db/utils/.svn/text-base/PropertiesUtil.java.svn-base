/**
 * 
 */
package edu.sjtu.infosec.monitor.db.utils;

import java.util.Properties;
import java.io.*;
/**
 * 读取属性文件
 *
 */
public class PropertiesUtil {
    public Properties load(final String configFileName) {
        InputStream inputStream = this.getClass().getClassLoader()
                .getResourceAsStream(configFileName);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println(this.getClass().getName() + " 加载配置文件<"+configFileName+">失败！");
        } finally {
        	try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }        
        return properties;
    }
}