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
 * 知识库安全告警类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_DYNA_WARN")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowDynaWarn implements Serializable {

    /**
     * 记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 测评项目编号
     */
    @Column(name="asse_info_proj_id", nullable = false)
    private Integer asseInfoProjId;

    /**
     * 高风险点数量
     */
    @Column(name="VULN_HIGH_NUM")
    private Integer vulnHighNum;

    /**
     * 中风险点数量
     */
    @Column(name="VULN_MIDU_NUM")
    private Integer vulnMiduNum;

    /**
     * 低风险点数量
     */
    @Column(name="VULN_LOW_NUM")
    private Integer vulnLowNum;

    /**
     * 高风险IP数量
     */
    @Column(name="HIGH_IP_NUM")
    private Integer highIpNum;

    /**
     * 中风险IP数量
     */
    @Column(name="MIDU_IP_NUM")
    private Integer miduIpNum;

    /**
     * 低风险IP数量
     */
    @Column(name="LOW_IP_NUM")
    private Integer lowIpNum;

    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param warnId
     *            记录编号
     */
    public  void setId(Integer warnId) {
        this.id = warnId;
    }

    /**
     * @return asseInfoProjId..
     */
    public Integer getAsseInfoProjId() {
        return asseInfoProjId;
    }

    /**
     * @param asseInfoProjVid
     *            测评项目id...
     */
    public void setAsseInfoProjId(Integer asseInfoProjVid) {
        this.asseInfoProjId = asseInfoProjVid;
    }

    /**
     * @return vulnHighNum
     */
    public  Integer getVulnHighNum() {
        return vulnHighNum;
    }

   

    /**
     * @param vulnhighNum
     *            高风险点数量
     */
    public  void setVulnHighNum(Integer vulnhighNum) {
        this.vulnHighNum = vulnhighNum;
    }

    /**
     * @param vulnmiduNum
     *            中风险点数量
     */
    public  void setVulnMiduNum(Integer vulnmiduNum) {
        this.vulnMiduNum = vulnmiduNum;
    }

    /**
     * @return vulnMiduNum
     */
    public  Integer getVulnMiduNum() {
        return vulnMiduNum;
    }

    /**
     * @return vulnLowNum
     */
    public  Integer getVulnLowNum() {
        return vulnLowNum;
    }

    /**
     * @param vulnlowNum
     *            低风险点数量
     */
    public  void setVulnLowNum(Integer vulnlowNum) {
        this.vulnLowNum = vulnlowNum;
    }

    /**
     * @return highIpNum
     */
    public  Integer getHighIpNum() {
        return highIpNum;
    }

    /**
     * @param highipNum
     *            高风险IP数量
     */
    public  void setHighIpNum(Integer highipNum) {
        this.highIpNum = highipNum;
    }

    /**
     * @return miduIpNum
     */
    public  Integer getMiduIpNum() {
        return miduIpNum;
    }
    
    /**
     * 比较是否相等
     * 
     * @param o
     *            安全告警实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowDynaWarn)) {
            return false;
        }
        AsseKnowDynaWarn another = (AsseKnowDynaWarn) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }

    /**
     * @param miduipNum
     *            中风险IP数量
     */
    public  void setMiduIpNum(Integer miduipNum) {
        this.miduIpNum = miduipNum;
    }

    /**
     * @return lowIpNum
     */
    public  Integer getLowIpNum() {
        return lowIpNum;
    }

    /**
     * @param lowipNum
     *            低风险IP数量
     */
    public  void setLowIpNum(Integer lowipNum) {
        this.lowIpNum = lowipNum;
    }

    /**
     * 获取哈希值
     * 
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 安全告警实例属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(asseInfoProjId).append(
                vulnHighNum).append(vulnMiduNum).append(vulnLowNum).append(
                highIpNum).append(miduIpNum).append(lowIpNum).toString();
    }

}
