package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;



/**
 * 知识库静态漏洞类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_STAT_LEAK")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowStatLeak implements Serializable {

	/**
     * 静态漏洞Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
	
    /**
     * 插件Id
     **/
    @Column(name="PLUGIN_ID", length = 15)
    private String pluginId;
    
    /**
     * nsfocusId
     **/
    @Column(name="NSFOCUS_ID", length = 15)
    private String nsfocusId;
    
    /**
     * bugtraqId
     **/
    @Column(name="BUGTRAQ_ID", length = 15)
    private String bugtraqId;
    
    /**
     * risk
     * */
    @Column(name="RISK", length = 15)
    private String risk;
    
    /**
     * cveId
     * */
    @Column(name="CVE_ID", length = 20)
    private String cveId;
    
    
    
    /**
     * solution
     * */
    @Column(name="SOLUTION")
    @Type(type="text")
    private String solution;
    
    /**
     * IP地址
     * */
    @Column(name="IP", length = 15)
    private String ip;

    /**
     * 漏洞名称
     * */
    @Column(name="NAME")
    @Type(type="text")
    private String name;

    

	/**
     * 端口号
     * */
    @Column(name="LEAKPORT", length = 5)
    private String port;

    /**
     * 协议
     * */
    @Column(name="PROTOCOL", length = 10)
    private String protocol;

    /**
     * 漏洞编号 
     * */
    @Column(name="VUL_ID", length = 20)
    private String vulId;
    
    /**
     * 对应的返回值
     * */
    @Column(name="MESS_STRING")
    @Type(type="text")
    private String message;
    
    /**
     * 关联静态脆弱点类别
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_stat_vuln_kind_id")
    private AsseKnowStatVulnKind vulnKind;
	
    /**
     * 关联静态漏洞威胁集
     */
    @OneToMany(mappedBy="leak")
    @Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.REMOVE})
    private Set<AsseKnowStatLeakThre> leakThres;
    
    /**
     * @return id
     */
	public Integer getId() {
		return id;
	}

	/**
     * @param vid
     * 静态漏洞Id
     */
	public void setId(Integer vid) {
		this.id = vid;
	}

	/**
     * @return pluginId
     */
	public String getPluginId() {
		return pluginId;
	}

	/**
     * @param vpluginId
     * pluginId
     */
	public void setPluginId(String vpluginId) {
		this.pluginId = vpluginId;
	}

	/**
     * @return nsfocusId
     */
	public String getNsfocusId() {
		return nsfocusId;
	}

	/**
     * @param vnsfocusId
     * nsfocusId
     */
	public void setNsfocusId(String vnsfocusId) {
		this.nsfocusId = vnsfocusId;
	}

	/**
     * @return bugtraqId
     */
	public String getBugtraqId() {
		return bugtraqId;
	}

	/**
     * @param vbugtraqId
     * bugtraqId
     */
	public void setBugtraqId(String vbugtraqId) {
		this.bugtraqId = vbugtraqId;
	}

	/**
     * @return risk
     */
	public String getRisk() {
		return risk;
	}

	/**
     * @param vrisk
     * risk
     */
	public void setRisk(String vrisk) {
		this.risk = vrisk;
	}

	/**
     * @return cveId
     */
	public String getCveId() {
		return cveId;
	}

	/**
     * @param vcveId
     * cveId
     */
	public void setCveId(String vcveId) {
		this.cveId = vcveId;
	}

	/**
     * @return solution
     */
	public String getSolution() {
		return solution;
	}

	/**
     * @param vsolution
     * solution
     */
	public void setSolution(String vsolution) {
		this.solution = vsolution;
	}

	/**
     * @return ip
     */
	public String getIp() {
		return ip;
	}

	/**
     * @param vip
     * ip
     */
	public void setIp(String vip) {
		this.ip = vip;
	}

	/**
     * @return name
     */
	public String getName() {
		return name;
	}

	/**
     * @param vname
     * name
     */
	public void setName(String vname) {
		this.name = vname;
	}
	
	/**
     * @return port
     */
	public String getPort() {
		return port;
	}

	/**
     * @param vport
     * port
     */
	public void setPort(String vport) {
		this.port = vport;
	}

	/**
     * @return protocol
     */
	public String getProtocol() {
		return protocol;
	}

	/**
     * @param vprotocol
     * protocol
     */
	public void setProtocol(String vprotocol) {
		this.protocol = vprotocol;
	}

	/**
     * @return vulId
     */
	public String getVulId() {
		return vulId;
	}

	/**
     * @param vvulId
     * vulId
     */
	public void setVulId(String vvulId) {
		this.vulId = vvulId;
	}

	/**
     * @return message
     */
	public String getMessage() {
		return message;
	}

	/**
     * @param vmessage
     * message
     */
	public void setMessage(String vmessage) {
		this.message = vmessage;
	}

	/**
     * @return vulnKind
     */
	public AsseKnowStatVulnKind getVulnKind() {
		return vulnKind;
	}

	/**
     * @param vulnkind
     * vulnKind
     */
	public void setVulnKind(AsseKnowStatVulnKind vulnkind) {
		this.vulnKind = vulnkind;
	}

	/**
     * @return leakThres
     */
    public Set<AsseKnowStatLeakThre> getLeakThres() {
		return leakThres;
	}

    /**
     * @param vleakThres
     * 静态漏洞威胁集
     */
	public void setLeakThres(Set<AsseKnowStatLeakThre> vleakThres) {
		this.leakThres = vleakThres;
	}
	
	/**
     * 比较是否相等
     * 
     * @param o
     * 静态漏洞实例
     * @return true/false
     */
	public boolean equals(Object o) {
		
		if (!(o instanceof AsseKnowStatLeak)) {
            return false;
        }
		AsseKnowStatLeak another = (AsseKnowStatLeak) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
	}

	/**
     * 获取静态漏洞对象哈希值
     * 
     * @return 哈希值
     */
	public int hashCode() {
		
		return new HashCodeBuilder().append(id).hashCode();
	}

	/**
     * 静态漏洞实例属性查看
     * 
     * @return 属性字符串
     */
	public String toString() {
		
		return new ToStringBuilder(this).append(id).append(vulId)
		                                .append(cveId).append(name).toString();
	}

}
