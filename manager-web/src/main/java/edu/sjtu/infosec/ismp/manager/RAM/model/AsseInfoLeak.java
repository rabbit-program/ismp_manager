package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Type;


/**
 * 信息库扫描信息类.
 * 
 */
@Entity
@Table(name = "RAM_INFO_LEAK")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseInfoLeak implements Serializable {

    /**
     * 记录编号
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * pluginId
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
     * 关联测评项目
     * */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "asse_info_proj_id", nullable = false)
    private AsseInfoProj asseInfoProj;

    /**
     * IP地址
     * */
    @Column(name="IP", length = 15)
    private String ip;

    /**
     * 关联资产
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_info_asse_id")
    private AsseInfoAsse asse;
    
    /**
     * 漏洞名称
     * */
    @Column(name="LOCATION")
    @Type(type="text")
    private String location;

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
    @Column(name="KNOW_ID", length = 20)
    private String knowId;

    /**
     * 告警类型
     * */
    @Column(name="WARN_KIND", length = 10)
    private String warnKind;

    /**
     * 威胁备注
     * */
    @Column(name="LEAKDESCRIBE")
    @Type(type="text")
    private String describe;

    /**
     * 漏洞对应返回值
     * */
    @Column(name="MESS_STRING")
    @Type(type="text")
    private String message;
    
    /**
     * @return id
     * */
    public Integer getId() {
        return id;
    }

    /**
     * @param leakId 记录编号
     * */
    public  void setId(Integer leakId) {
        this.id = leakId;
    }

    /**
     * @return asseInfoProj
     * */
    
    public  AsseInfoProj getAsseInfoProj() {
        return asseInfoProj;
    }

    /**
     * @param asseinfoProj 关联测评项目
     * */
    public  void setAsseInfoProj(AsseInfoProj asseinfoProj) {
        this.asseInfoProj = asseinfoProj;
    }

    /**
     * @return ip
     * */
    public  String getIp() {
        return ip;
    }

    /**
     * @param leakIp IP地址
     * */
    public  void setIp(String leakIp) {
        this.ip = leakIp;
    }

    /**
     * @return asse
     */
    public  AsseInfoAsse getAsse() {
        return asse;
    }
    
    /**
     * @param asseInfo
     *            关联资产
     */
    public  void setAsse(AsseInfoAsse asseInfo) {
        this.asse = asseInfo;
    }
    
    /**
     * @return location
     * */
    public  String getLocation() {
        return location;
    }

    /**
     * @param loca 漏洞所在位置
     * */
    public  void setLocation(String loca) {
        this.location = loca;
    }

    /**
     * @return port
     * */
    public  String getPort() {
        return port;
    }

    /**
     * @param appPort 端口
     * */
    public  void setPort(String appPort) {
        this.port = appPort;
    }

    /**
     * @return protocol
     * */
    public  String getProtocol() {
        return protocol;
    }

    /**
     * @param prot 协议
     * */
    public  void setProtocol(String prot) {
        this.protocol = prot;
    }

    /**
     * @return knowId
     * */
    public  String getKnowId() {
        return knowId;
    }

    /**
     * @param knowid 知识库Id
     * */
    public  void setKnowId(String knowid) {
        this.knowId = knowid;
    }

    /**
     * @return warnKind
     * */
    public  String getWarnKind() {
        return warnKind;
    }

    /**
     * @param warnkind 告警类型
     * */
    public  void setWarnKind(String warnkind) {
        this.warnKind = warnkind;
    }

    /**
     * @return describe
     * */
    public  String getDescribe() {
        return describe;
    }

    /**
     * @param desc 漏洞描述
     * */
    public  void setDescribe(String desc) {
        this.describe = desc;
    }
    
    
    /**
     * @return pluginId
     * */
    public String getPluginId() {
		return pluginId;
	}

    /**
     * @param vpluginId
     * */
	public void setPluginId(String vpluginId) {
		this.pluginId = vpluginId;
	}

	/**
     * @return nsfocusId
     * */
	public String getNsfocusId() {
		return nsfocusId;
	}

	/**
     * @param vnsfocusId
     * */
	public void setNsfocusId(String vnsfocusId) {
		this.nsfocusId = vnsfocusId;
	}

	/**
     * @return bugtraqId
     * */
	public String getBugtraqId() {
		return bugtraqId;
	}

	/**
     * @param vbugtraqId
     * */
	public void setBugtraqId(String vbugtraqId) {
		this.bugtraqId = vbugtraqId;
	}

	/**
     * @return risk
     * */
	public String getRisk() {
		return risk;
	}

	/**
     * @param vrisk
     * */
	public void setRisk(String vrisk) {
		this.risk = vrisk;
	}

	/**
     * @return cveId
     * */
	public String getCveId() {
		return cveId;
	}

	/**
     * @param vcveId
     * */
	public void setCveId(String vcveId) {
		this.cveId = vcveId;
	}

	/**
     * @return solution
     * */
	public String getSolution() {
		return solution;
	}

	/**
     * @param vsolution
     * */
	public void setSolution(String vsolution) {
		this.solution = vsolution;
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

	/** 比较是否相等 
     * @param o 漏洞实例
     * @return true/false
     * */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseInfoLeak)) {
            return false;
        }
        AsseInfoLeak another = (AsseInfoLeak) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }

    /** 获取哈希值 
     * @return 哈希值
     * */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /** 漏洞属性查看 
     * @return 属性字符串
     * */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(ip).append(cveId)
          .append(location).append(port).append(protocol).append(knowId).append(warnKind)
                .append(describe).toString();
    }

}
