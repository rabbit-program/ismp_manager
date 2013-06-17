package org.infosec.ismp.model.snmp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guoxianwei
 * @date 2010-12-21 下午04:54:24
 * 
 */
public final class Results implements Serializable {

	private static final long serialVersionUID = -8090403852995876386L;

	private String m_nodeid;
	
	private String m_type;
	
	private String m_brand;
	
	private String m_ipAddr;
	
	private List<Result> m_results = new ArrayList<Result>();

	public String getNodeid() {
		return m_nodeid;
	}

	public String getType() {
		return m_type;
	}

	public void setNodeid(String nodeid) {
		m_nodeid = nodeid;
	}

	public void setType(String type) {
		m_type = type;
	}

	public void addResult(Result result) {
		 m_results.add(result);
	}

	public List<Result> getResultList() {
		return m_results;
	}

	public String getIpAddr() {
		return m_ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		m_ipAddr = ipAddr;
	}
	public String getBrand() {
		return m_brand;
	}

	public void setBrand(String brand) {
		m_brand = brand;
	}
}

