package org.infosec.ismp.model.snmp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * @author guoxianwei
 * @date 2010-11-2 上午11:15:02
 * 
 */
public final class Result implements Serializable{
	
	private static final long serialVersionUID = -498915822449253106L;

	public Result(){}
	
	private String m_trackerName;

	private List<Map<String, Object>> m_listResults = Collections.synchronizedList(new ArrayList<Map<String, Object>>());

	public String getTrackerName() {
		return m_trackerName;
	}
	public void setTrackerName(String trackerName) {
		m_trackerName = trackerName;
	}

	public List<Map<String, Object>> getListResults() {
		return m_listResults;
	}
	public void setListResults(List<Map<String, Object>> listResults) {
		m_listResults = listResults;
	}

}

