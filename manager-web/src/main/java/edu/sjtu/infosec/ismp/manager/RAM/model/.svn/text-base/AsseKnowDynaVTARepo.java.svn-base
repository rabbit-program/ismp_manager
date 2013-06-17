package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * 知识库动态V-T-A-R评估报告类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_DYNA_VTA_REPO")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class AsseKnowDynaVTARepo implements Serializable {

    /**
     * 动态V-T-A-R评估报告记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    /**
     * 关联测评项目
     * */
    @ManyToOne
    @Cascade(value = { CascadeType.SAVE_UPDATE })
    @JoinColumn(name = "asse_info_proj_id", nullable = false)
    private AsseInfoProj asseInfoProj;

    /**
     * 资产Id
     * */
    @Column(name = "asset_Id")
    private Integer assetId;
    
    /**
     * 资产名称
     * */
    @Column(name = "asse_name", length = 50, nullable = false)
    private String asseName;

    /**
     * 资产脆弱点
     * */
    @Column(name = "vuln_poin_name")
    @Type(type="text")
    private String vulnPoinName;

    /**
     * 资产威胁
     * */
    @Column(name = "thre_name")
    @Type(type="text")
    private String threName;

    /**
     * 风险值
     */
    @Column(name = "risk_valu", length = 5, nullable = false)
    private String riskValu;

    /**
     * 改进建议
     */
    @Column(name = "sugg")
    @Type(type="text")
    private String sugg;

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
     * @return asseInfoProj
     */
    public AsseInfoProj getAsseInfoProj() {
        return asseInfoProj;
    }

    /**
     * @param asseinfoProj
     *            关联测评项目
     */
    public void setAsseInfoProj(AsseInfoProj asseinfoProj) {
        this.asseInfoProj = asseinfoProj;
    }

    
    
    public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer vassetId) {
		this.assetId = vassetId;
	}

	/**
     * @return asseName
     */
    public String getAsseName() {
        return asseName;
    }

    /**
     * @param assename
     *            资产名称
     */
    public void setAsseName(String assename) {
        this.asseName = assename;
    }

    /**
     * @return vulnPoinName
     */
    public String getVulnPoinName() {
        return vulnPoinName;
    }

    /**
     * @param vulnpoinName
     *            资产脆弱点
     */
    public void setVulnPoinName(String vulnpoinName) {
        this.vulnPoinName = vulnpoinName;
    }

    /**
     * @return threName
     */
    public String getThreName() {
        return threName;
    }

    /**
     * @param threname
     *            资产威胁
     */
    public void setThreName(String threname) {
        this.threName = threname;
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
     * @return sugg
     */
    public String getSugg() {
        return sugg;
    }

    /**
     * @param vsugg
     *            改进建议
     */
    public void setSugg(String vsugg) {
        this.sugg = vsugg;
    }

    public boolean equals(Object o) {

        if (!(o instanceof AsseKnowDynaVTARepo)) {
            return false;
        }
        AsseKnowDynaVTARepo another = (AsseKnowDynaVTARepo) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }

    public int hashCode() {

        return new HashCodeBuilder().append(id).hashCode();
    }

    public String toString() {

        return new ToStringBuilder(this).append(id).append(asseInfoProj)
                .append(asseName).append(vulnPoinName).append(threName).append(
                        riskValu).toString();
    }

}
