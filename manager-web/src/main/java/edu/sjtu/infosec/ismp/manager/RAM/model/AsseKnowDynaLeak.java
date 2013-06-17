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
 * 知识库资产漏洞类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_DYNA_LEAK")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowDynaLeak implements Serializable {

	/**
     * 资产脆弱性记录编号
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
     * 信息库漏洞扫描信息id 
     * */
    @Column(name="ASSE_INFO_LEAK_ID")
    private Integer infoLeakId;
    
    /**
     * 漏洞编号 
     * */
    @Column(name="VUL_ID", length = 20)
    private String vulId;
    
    /**
     * cveId
     * */
    @Column(name="CVE_ID", length = 20)
    private String cveId;
    
    /**
     * 漏洞名称
     * */
    @Column(name="LOCATION")
    @Type(type="text")
    private String location;

    /**
     * 脆弱点类别编号
     */
    @Column(name="asse_know_stat_vuln_kind_id")
    private Integer asseKnowStatVulnKindId;

    /**
     * 关联资产
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_info_asse_id")
    private AsseInfoAsse asse;

    

    /**
     * 严重程度
     */
    @Column(name="SERI_LEVE", length = 2)
    private String seriLeve;

    /**
     * 来源
     */
    @Column(name="SOURCE", length = 10)
    private String source;

    /**
     * 测评项目编号
     */
    @Column(name="asse_info_proj_id", nullable = false)
    private Integer asseInfoProjId;

    /**
     * 关联资产威胁集
     */
    @OneToMany(mappedBy="dynaLeak")
    @Cascade(value={CascadeType.SAVE_UPDATE})
    private Set<AsseKnowDynaLeakThre> dynaLeakThres;

    /**
     * 关联知识库动态评估结果
     * */
    @OneToMany(mappedBy="dynaLeak")
    @Cascade(value={CascadeType.SAVE_UPDATE})
    private Set<AsseKnowDynaAsseResu> asseKnowDynaAsseResus;
    
    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param vid
     *            资产脆弱性记录编号
     */
    public  void setId(Integer vid) {
        this.id = vid;
    }

    
    
    /**
     * @return infoLeakId
     */
    public Integer getInfoLeakId() {
		return infoLeakId;
	}

    /**
     * @param vinfoLeakId
     *  infoLeakId
     */
	public void setInfoLeakId(Integer vinfoLeakId) {
		this.infoLeakId = vinfoLeakId;
	}

	/**
     * @return asseKnowStatVulnKindId
     */
    public Integer getAsseKnowStatVulnKindId() {
        return asseKnowStatVulnKindId;
    }

    
	/**
     * @return asse
     */
    public  AsseInfoAsse getAsse() {
        return asse;
    }

    /**
     * @param asseKnowStatVulnKindVid
     *            脆弱点类别编号
     */
    public void setAsseKnowStatVulnKindId(Integer asseKnowStatVulnKindVid) {
        this.asseKnowStatVulnKindId = asseKnowStatVulnKindVid;
    }

    /**
     * @param asseInfo
     *            关联资产
     */
    public  void setAsse(AsseInfoAsse asseInfo) {
        this.asse = asseInfo;
    }

    

    /**
     * @return seriLeve
     */
    public  String getSeriLeve() {
        return seriLeve;
    }

    /**
     * @param serileve
     *            严重程度
     */
    public  void setSeriLeve(String serileve) {
        this.seriLeve = serileve;
    }

    /**
     * @return source
     */
    public  String getSource() {
        return source;
    }

    /**
     * @param sour
     *            来源
     */
    public  void setSource(String sour) {
        this.source = sour;
    }

    /**
     * @return asseInfoProjId.
     */
    public Integer getAsseInfoProjId() {
        return asseInfoProjId;
    }

    /**
     * @param asseInfoProjVid
     *            测评项目id
     */
    public void setAsseInfoProjId(Integer asseInfoProjVid) {
        this.asseInfoProjId = asseInfoProjVid;
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
     * @return dynaLeakThres
     */
    public Set<AsseKnowDynaLeakThre> getDynaLeakThres() {
		return dynaLeakThres;
	}
    

    /**
     * @param vdynaLeakThres
     * 关联漏洞威胁集
     */
    public void setDynaLeakThres(Set<AsseKnowDynaLeakThre> vdynaLeakThres) {
		this.dynaLeakThres = vdynaLeakThres;
	}

    /**
     * @return asseKnowDynaAsseResus
     * */
    public Set<AsseKnowDynaAsseResu> getAsseKnowDynaAsseResus() {
        return asseKnowDynaAsseResus;
    }


	/**
     * @param asseknowDynaAsseResus 动态评估结果
     * */
    public void setAsseKnowDynaAsseResus(
            Set<AsseKnowDynaAsseResu> asseknowDynaAsseResus) {
        this.asseKnowDynaAsseResus = asseknowDynaAsseResus;
    }
    
    /**
     * 比较是否相等
     * 
     * @param o
     *            资产脆弱性实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowDynaLeak)) {
            return false;
        }
        AsseKnowDynaLeak another = (AsseKnowDynaLeak) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }

    /**
     * 获取资产脆弱性实例哈希值
     * 
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 资产脆弱性实例属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(
                asseKnowStatVulnKindId).append(seriLeve).append(source)
                .append(asseInfoProjId).toString();
    }

	
}
