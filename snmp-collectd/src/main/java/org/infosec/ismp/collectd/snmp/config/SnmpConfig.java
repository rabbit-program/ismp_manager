package org.infosec.ismp.collectd.snmp.config;

import java.util.Enumeration;

import org.infosec.ismp.collectd.snmp.configuration.Device;
import org.infosec.ismp.collectd.snmp.configuration.SnmpConfiguration;
import org.infosec.ismp.collectd.snmp.configuration.Table;



/**
 * @author guoxianwei
 * @date 2010-11-5 下午03:11:54
 * 
 */
public interface SnmpConfig {
	
  public abstract SnmpConfiguration getConfiguration();
  
  public Device getDevice(String deviceType,String brand);
  
  public abstract Table getTableInDevice(String tableName, Device dev);
  
  public Enumeration<Device> enumerateDevice();
}

