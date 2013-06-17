package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
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



/**
 * 知识库动态评估结果类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_DYNA_ASSE_RESU")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class AsseKnowDynaAsseResu implements Serializable {

    /**
     * 动态评估结果记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    /**
     * 测评项目编号
     */
    @Column(name = "asse_info_proj_id", nullable = false)
    private Integer asseInfoProjId;

    /**
     * 资产
     */
    @ManyToOne
    @Cascade(value = { CascadeType.SAVE_UPDATE })
    @JoinColumn(name = "asse_info_asse_id")
    private AsseInfoAsse asse;

    /**
     * 脆弱点
     */
    @ManyToOne
    @Cascade(value = { CascadeType.SAVE_UPDATE })
    @JoinColumn(name = "asse_know_dyna_vuln_id")
    private AsseKnowDynaVuln dynaVuln;
    
    /**
     * 威胁
     */
    @ManyToOne
    @Cascade(value = { CascadeType.SAVE_UPDATE })
    @JoinColumn(name = "asse_know_dyna_thre_id")
    private AsseKnowDynaThre dynaThre;
    
    /**
     * 资产漏洞
     */
    @ManyToOne
    @Cascade(value = { CascadeType.SAVE_UPDATE })
    @JoinColumn(name = "asse_know_dyna_leak_id")
    private AsseKnowDynaLeak dynaLeak;
    
    /**
     * 资产漏洞威胁
     */
    @ManyToOne
    @Cascade(value = { CascadeType.SAVE_UPDATE })
    @JoinColumn(name = "asse_know_dyna_leak_thre_id")
    private AsseKnowDynaLeakThre dynaLeakThre;
    
    /**
     * 风险值
     */
    @Column(name = "risk_valu", length = 5)
    private String riskValu;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param vid
     *            记录编号
     */
    public void setId(Integer vid) {
        this.id = vid;
    }

    /**
     * @return asseInfoProjId
     */
    public Integer getAsseInfoProjId() {
        return asseInfoProjId;
    }

    /**
     * @param asseInfoProjVid
     *            测评项目编号
     */
    public void setAsseInfoProjId(Integer asseInfoProjVid) {
        this.asseInfoProjId = asseInfoProjVid;
    }

    /**
     * @return asse
     */
    public AsseInfoAsse getAsse() {
        return asse;
    }

    /**
     * @param asseInfo
     *        资产
     */
    public void setAsse(AsseInfoAsse asseInfo) {
        this.asse = asseInfo;
    }

    
    /**
     * @return dynaVuln
     */
    public AsseKnowDynaVuln getDynaVuln() {
		return dynaVuln;
	}

    /**
     * @param vdynaVuln
     *        脆弱点
     */
	public void setDynaVuln(AsseKnowDynaVuln vdynaVuln) {
		this.dynaVuln = vdynaVuln;
	}

	/**
     * @return dynaThre
     */
	public AsseKnowDynaThre getDynaThre() {
		return dynaThre;
	}

	/**
     * @param vdynaThre
     *        威胁
     */
	public void setDynaThre(AsseKnowDynaThre vdynaThre) {
		this.dynaThre = vdynaThre;
	}

	/**
     * @return dynaLeak
     */
	public AsseKnowDynaLeak getDynaLeak() {
		return dynaLeak;
	}

	/**
     * @param vdynaLeak
     *        资产漏洞
     */
	public void setDynaLeak(AsseKnowDynaLeak vdynaLeak) {
		this.dynaLeak = vdynaLeak;
	}

	/**
     * @return dynaLeakThre
     */
	public AsseKnowDynaLeakThre getDynaLeakThre() {
		return dynaLeakThre;
	}

	/**
     * @param vdynaLeakThre
     *        资产漏洞威胁
     */
	public void setDynaLeakThre(AsseKnowDynaLeakThre vdynaLeakThre) {
		this.dynaLeakThre = vdynaLeakThre;
	}

	/**
     * @return riskValu
     */
    public String getRiskValu() {
        return riskValu;
    }

    /**
     * @param riskvalu
     *            风险值
     */
    public void setRiskValu(String riskvalu) {
        this.riskValu = riskvalu;
    }

    /**
     * 比较是否相等
     * 
     * @param o
     *            动态评估结果实例
     * @return true/false
     */
    public boolean equals(Object o) {

        if (!(o instanceof AsseKnowDynaAsseResu)) {
            return false;
        }
        AsseKnowDynaAsseResu another = (AsseKnowDynaAsseResu) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }

    /**
     * 获取安全级别哈希值
     * 
     * @return 哈希值
     */
    public int hashCode() {

        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 动态评估结果属性查看
     * 
     * @return 属性字符串
     */
    public String toString() {

        return new ToStringBuilder(this).append(id).append(asseInfoProjId)
                .append(riskValu).toString();
    }

}
