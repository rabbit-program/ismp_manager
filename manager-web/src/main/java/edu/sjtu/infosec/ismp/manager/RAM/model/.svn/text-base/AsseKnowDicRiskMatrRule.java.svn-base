package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * 知识库风险矩阵规则字典表类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_DIC_RISK_MATR_RULE")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class AsseKnowDicRiskMatrRule implements Serializable {

    /**
     * 记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    /**
     * 资产重要性
     */
    @Column(name = "asse_impo", length = 5, nullable = false)
    private String asseImpo;

    /**
     * 脆弱点严重性
     */
    @Column(name = "vuln_seri", length = 5, nullable = false)
    private String vulnSeri;

    /**
     * 威胁发生可能性
     */
    @Column(name = "thre_poss", length = 5, nullable = false)
    private String threPoss;

    /**
     * 风险值
     */
    @Column(name = "risk_valu", length = 5, nullable = false)
    private String riskValu;

    /**
     * 构造函数
     * 
     * @param asseimpo
     *            资产重要性
     * @param vulnseri
     *            脆弱点严重性
     * @param threposs
     *            威胁发生可能性
     */
    public AsseKnowDicRiskMatrRule(String asseimpo, String vulnseri,
            String threposs) {

        this.asseImpo = asseimpo;
        this.vulnSeri = vulnseri;
        this.threPoss = threposs;
    }

    /**
     * 构造函数
     */
    public AsseKnowDicRiskMatrRule() {
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param dicId
     *            记录编号
     */
    public void setId(Integer dicId) {
        this.id = dicId;
    }

    /**
     * @return asseImpo
     */
    public String getAsseImpo() {
        return asseImpo;
    }

    /**
     * @param asseimpo
     *            资产重要性
     */
    public void setAsseImpo(String asseimpo) {
        this.asseImpo = asseimpo;
    }

    /**
     * @return vulnSeri
     */
    public String getVulnSeri() {
        return vulnSeri;
    }

    /**
     * @param vulnseri
     *            脆弱点严重性
     */
    public void setVulnSeri(String vulnseri) {
        this.vulnSeri = vulnseri;
    }

    /**
     * @return threPoss
     */
    public String getThrePoss() {
        return threPoss;
    }

    /**
     * @param threposs
     *            威胁发生可能性
     */
    public void setThrePoss(String threposs) {
        this.threPoss = threposs;
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
     *            风险矩阵规则实例
     * @return true/false
     */
    public boolean equals(Object o) {

        if (!(o instanceof AsseKnowDicRiskMatrRule)) {
            return false;
        }
        AsseKnowDicRiskMatrRule another = (AsseKnowDicRiskMatrRule) o;
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
     * 风险矩阵规则属性查看
     * 
     * @return 属性字符串
     */
    public String toString() {

        return new ToStringBuilder(this).append(id).append(asseImpo).append(
                vulnSeri).append(threPoss).append(riskValu).toString();
    }

}
