package org.infosec.ismp.syslogd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 定义syslog事件代号和对应的匹配方案
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class UeiMatch {

	private String m_uei;

	private String m_ipAddr;

	private String m_encoding;

	private Match m_match;

	private List<ParameterAssignment> parameterAssignmentList = new ArrayList<ParameterAssignment>();

	public List<ParameterAssignment> getParameterAssignmentList() {
		return parameterAssignmentList;
	}

	public void setParameterAssignmentList(
			List<ParameterAssignment> parameterAssignmentList) {
		this.parameterAssignmentList = parameterAssignmentList;
	}

	public UeiMatch() {
		super();
	}

	public UeiMatch(String uei, Match match) {
		super();
		this.m_uei = uei;
		this.m_match = match;
	}

	public String getUei() {
		return this.m_uei;
	}

	public Match getMatch() {
		return m_match;
	}

	public void setMatch(Match match) {
		this.m_match = match;
	}

	public void setUei(String uei) {
		this.m_uei = uei;
	}

	public int getParameterAssignmentCount() {
		return parameterAssignmentList.size();
	}

	public Collection<ParameterAssignment> getParameterAssignmentCollection() {
		return new ArrayList<ParameterAssignment>(parameterAssignmentList);
	}

	public String getIpAddr() {
		return m_ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		m_ipAddr = ipAddr;
	}

	public String getEncoding() {
		return m_encoding;
	}

	public void setEncoding(String encoding) {
		m_encoding = encoding;
	}

}
