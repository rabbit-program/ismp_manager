package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



/**
 * 知识库资产评估要素结果类.
 * 
 */
@Entity
@Table(name = "RAM_KNOW_DYNA_ELEM_RESU")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowDynaElemResu implements Serializable {

    /**
     * 资产评估要素结果记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 关联资产
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_info_asse_id", nullable = false)
    private AsseInfoAsse asse;

    /**
     * 测评项目编号
     */
    @Column(name="asse_info_proj_id", nullable = false)
    private Integer asseInfoProjId;

    /**
     * 关联项目总体评估值
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_dyna_asse_valu_id")
    private AsseKnowDynaAsseValue dynaAsseValue;

    /**
     * 高风险点数
     */
    @Column(name="VULN_HIGH_NUM")
    private Integer vulnHighNum;

    /**
     * 中风险点数
     */
    @Column(name="VULN_MIDU_NUM")
    private Integer vulnMiduNum;

    /**
     * 低风险点数
     */
    @Column(name="VULN_LOW_NUM")
    private Integer vulnLowNum;

    /**
     * 是否告警
     */
    @Column(name="IS_WARN", length = 2)
    private String isWarn;

    /**
     * @param vid
     *            资产评估要素结果记录编号
     */
    public void setId(Integer vid) {
        this.id = vid; //
    }

    /**
     * @return asse
     */
    public  AsseInfoAsse getAsse() {
        return asse;
    }

    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }
    
    /**
     * @param asseInfo
     *            关联资产
     */
    public  void setAsse(AsseInfoAsse asseInfo) {
        this.asse = asseInfo;
    }

    /**
     * @return asseInfoProjId
     .*/
    public Integer getAsseInfoProjId() {
        return asseInfoProjId;
    }

    /**
     * @param asse_info_proj_vid
     *            测评项目编号
     */
    public void setAsseInfoProjId(Integer asseInfoProjVid) {
        this.asseInfoProjId = asseInfoProjVid;
    }

    /**
     * @return dynaAsseValue
     */
    public  AsseKnowDynaAsseValue getDynaAsseValue() {
        return dynaAsseValue;
    }

    
    /**
     * @param asseValue
     *            关联项目总体评估值
     */
    public  void setDynaAsseValue(AsseKnowDynaAsseValue asseValue) {
        this.dynaAsseValue = asseValue;
    }

    /**
     * @return vulnHighNum
     */
    public  Integer getVulnHighNum() {
        return vulnHighNum;
    }

    /**
     * @param highNum
     *            高风险点数
     */
    public  void setVulnHighNum(Integer highNum) {
        this.vulnHighNum = highNum;
    }

    /**
     * @return vulnMiduNum
     */
    public  Integer getVulnMiduNum() {
        return vulnMiduNum;
    }

    /**
     * @param miduNum
     *            中风险点数
     */
    public  void setVulnMiduNum(Integer miduNum) {
        this.vulnMiduNum = miduNum;
    }

    /**
     * @return vulnLowNum
     */
    public  Integer getVulnLowNum() {
        return vulnLowNum;
    }

    /**
     * @param lowNum
     *            低风险点数
     */
    public  void setVulnLowNum(Integer lowNum) {
        this.vulnLowNum = lowNum;
    }

    /**
     * @return isWarn
     */
    public  String getIsWarn() {
        return isWarn;
    }

    /**
     * @param iswarn
     *            是否告警
     */
    public  void setIsWarn(String iswarn) {
        this.isWarn = iswarn;
    }

    /**
     * 比较是否相等
     * 
     * @param o
     *            资产评估要素结果实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowDynaElemResu)) {
            return false;
        }
        AsseKnowDynaElemResu another = (AsseKnowDynaElemResu) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }

    /**
     * 获取资产评估要素哈希值
     * 
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 资产评估要素结果实例属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(asseInfoProjId).append(
                vulnHighNum).append(vulnMiduNum).append(vulnLowNum).append(
                isWarn).toString();
    }

}
