

package org.infosec.ismp.agent.syslog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.infosec.ismp.util.BaseObject;

/**
 * @author guoxianwei
 * @date 2010-9-20 上午09:45:35
 * 
 */
@Entity
@Table(name="syslog_parser_config")
public class SyslogParserConfig extends BaseObject{

	private static final long serialVersionUID = 6881987322944150232L;

	private int id;
	private String type;
	private String ipAddr;
	private String domainId;
	private String srcId;
//	private String uei;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
		return id;
	}
    @Column(name="type",length=128)
	public String getType() {
		return type;
	}
    @Column(name="ip_addr",length=128)
	public String getIpAddr() {
		return ipAddr;
	}
//    @Column(name="uei",length=128)
//	public String getUei() {
//		return uei;
//	}
//	public void setUei(String uei) {
//		this.uei = uei;
//	}
    
    
    
	public void setId(int id) {
		this.id = id;
	}

	public String getSrcId() {
		return srcId;
	}
	public void setSrcId(String srcId) {
		this.srcId = srcId;
	}
	public String getDomainId() {
		return domainId;
	}
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	public void setType(String type) {
		this.type = type;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

}

