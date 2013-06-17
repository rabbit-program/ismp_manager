package edu.sjtu.infosec.ismp.manager.EM.web.form;

import org.apache.struts.action.ActionForm;

/**
 * 
 * @version 1.0 2009-06-06
 * @author yli
 */
public class EventCorrelationForm extends ActionForm{
	
	private String id;

	private String rule_name;
	
    private String corr_type;
    
    private String prot_rule;
    
    private String src_ip;
    
    private String dest_ip;
    
    private String dest_port;
    
    private Integer bureauId;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRule_name() {
		return rule_name;
	}

	public void setRule_name(String rule_name) {
		this.rule_name = rule_name;
	}

	public String getCorr_type() {
		return corr_type;
	}

	public void setCorr_type(String corr_type) {
		this.corr_type = corr_type;
	}

	public String getProt_rule() {
		return prot_rule;
	}

	public void setProt_rule(String prot_rule) {
		this.prot_rule = prot_rule;
	}

	public String getSrc_ip() {
		return src_ip;
	}

	public void setSrc_ip(String src_ip) {
		this.src_ip = src_ip;
	}

	public String getDest_ip() {
		return dest_ip;
	}

	public void setDest_ip(String dest_ip) {
		this.dest_ip = dest_ip;
	}

	public String getDest_port() {
		return dest_port;
	}

	public void setDest_port(String dest_port) {
		this.dest_port = dest_port;
	}

	public Integer getBureauId() {
		return bureauId;
	}

	public void setBureauId(Integer bureauId) {
		this.bureauId = bureauId;
	}
	
}
