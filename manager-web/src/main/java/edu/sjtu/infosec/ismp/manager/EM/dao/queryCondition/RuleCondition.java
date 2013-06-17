package edu.sjtu.infosec.ismp.manager.EM.dao.queryCondition;


/**
 * 用于关联规则查询
 * @author wudengke 2009-6-20
 *
 */
public class RuleCondition {
	
	/**
	 * 协议类型集合
	 */
	private String[] prot_types;
	
	/**
	 * 源IP集合
	 */
	private String[] src_ips;
	
	/**
	 * 目的IP集合
	 */
	private String[] dest_ips;
	
	/**
	 * 目的端口集合
	 */
	private String[] dest_ports;
	
	/**
	 * 表明协议相同
	 */
	private boolean protocol_same;
	
	/**
	 * 表明事件类型相同
	 */
	private boolean eventtype_same;
	
	/**
	 * 表明源IP相同
	 */
	private boolean srcip_same;
	
	/**
	 * 表明目的IP相同
	 */
	private boolean destip_same;
	
	/**
	 * 表明目的端口相同
	 */
	private boolean destport_same;
	
	/**
	 * 表明时间窗长度(毫秒)
	 */
	private long rulelength;
	
	private Integer[] bureauId;

	public Integer[] getBureauId() {
		return bureauId;
	}

	public void setBureauId(Integer[] bureauId) {
		this.bureauId = bureauId;
	}

	public String[] getProt_types() {
		return prot_types;
	}

	public void setProt_types(String[] prot_types) {
		this.prot_types = prot_types;
	}

	public String[] getSrc_ips() {
		return src_ips;
	}

	public void setSrc_ips(String[] src_ips) {
		this.src_ips = src_ips;
	}

	public String[] getDest_ips() {
		return dest_ips;
	}

	public void setDest_ips(String[] dest_ips) {
		this.dest_ips = dest_ips;
	}

	public String[] getDest_ports() {
		return dest_ports;
	}

	public void setDest_ports(String[] dest_ports) {
		this.dest_ports = dest_ports;
	}

	public boolean isProtocol_same() {
		return protocol_same;
	}

	public void setProtocol_same(boolean protocol_same) {
		this.protocol_same = protocol_same;
	}

	public boolean isEventtype_same() {
		return eventtype_same;
	}

	public void setEventtype_same(boolean eventtype_same) {
		this.eventtype_same = eventtype_same;
	}

	public boolean isSrcip_same() {
		return srcip_same;
	}

	public void setSrcip_same(boolean srcip_same) {
		this.srcip_same = srcip_same;
	}

	public boolean isDestip_same() {
		return destip_same;
	}

	public void setDestip_same(boolean destip_same) {
		this.destip_same = destip_same;
	}

	public boolean isDestport_same() {
		return destport_same;
	}

	public void setDestport_same(boolean destport_same) {
		this.destport_same = destport_same;
	}

	public long getRulelength() {
		return rulelength;
	}

	public void setRulelength(long rulelength) {
		this.rulelength = rulelength;
	}

}
