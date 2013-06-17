package org.infosec.ismp.manager.mos;

import java.io.Serializable;

/**
 * 被管理对象的相关信息（需要持久化和序列化）
 * 
 * @author lianglin
 * 
 */
public class MODeviceInfo implements Serializable {
	/**
	 * 代表全局唯一ID
	 */
	private Integer m_nodeid;
	/**
	 * 设备地址
	 */
	private String m_ipAddr;
	/**
	 * snmp timeout
	 */
	private int m_timeout;
	/**
	 * 
	 */
	private int m_retries;
	/**
	 * snmp port
	 */
	private int m_port;
	/**
	 * snmp version
	 */
	private int m_version;
	/**
	 * 
	 */
	private int m_maxRequestSize;
	/**
	 * 
	 */
	private int m_securityLevel;
	/**
	 * 
	 */
	private String m_securityName;
	/**
	 * 
	 */
	private String m_readCommunity;
	/**
	 * 一个UDP包含变量数
	 */
	private int m_maxVarsPerPdu;
	/**
	 *  
	 */
	private int m_maxRepetitions;
	/**
	 *  for write
	 */
	private String m_writeCommunity;
	/**
	 *  for snmp v3
	 */
	private String m_authPassPhrase;
	/**
	 *  for snmp v3
	 */
	private String m_authProtocol;
	/**
	 *  for snmp v3
	 */
	private String m_privProtocol;
	/**
	 * for snmp v3
	 */
	private String m_privPassPhrase;
	/**
	 * 轮询间隔
	 */
	private long m_interval;
}
