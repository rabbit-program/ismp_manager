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
 * 知识库静态安全阈值类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_STAT_WARN_STRI")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowStatWarnStri implements Serializable {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
    
    /**
     * 高风险点阈值
     */
    @Column(name="VULN_HIGH_NUM")
    private Integer vulnHighNum;
    
    /**
     * 中风险点阈值
     */
    @Column(name="VULN_MIDU_NUM")
    private Integer vulnMiduNum;
    
    /**
     * 低风险点阈值
     */
    @Column(name="VULN_LOW_NUM")
    private Integer vulnLowNum;
    
    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param warnStriId
     * 静态安全阈值记录编号
     */
    public  void setId(Integer warnStriId) {
        this.id = warnStriId;
    }

    /**
     * @return vulnHighNum
     */
    public  Integer getVulnHighNum() {
        return vulnHighNum;
    }

    /**
     * @param vulnhighNum
     * 高风险点阈值
     */
    public  void setVulnHighNum(Integer vulnhighNum) {
        this.vulnHighNum = vulnhighNum;
    }

    /**
     * @return vulnMiduNum
     */
    public  Integer getVulnMiduNum() {
        return vulnMiduNum;
    }

    /**
     * @param vulnmiduNum
     * 中风险点阈值
     */
    public  void setVulnMiduNum(Integer vulnmiduNum) {
        this.vulnMiduNum = vulnmiduNum;
    }

    /**
     * @return vulnLowNum
     */
    public  Integer getVulnLowNum() {
        return vulnLowNum;
    }

    /**
     * @param vulnlowNum
     * 低风险点阈值
     */
    public  void setVulnLowNum(Integer vulnlowNum) {
        this.vulnLowNum = vulnlowNum;
    }

    
    /**
     * 比较是否相等
     * @param o
     * 静态风险点阈值实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowStatWarnStri)) {
            return false;
        }
        AsseKnowStatWarnStri another = (AsseKnowStatWarnStri) o;
        return new EqualsBuilder()
          .append(id, another.id).isEquals();
    }

    /**
     * 获取哈希值
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }
    
    /**
     * 静态风险点阈值实例属性查看
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(vulnHighNum)
                .append(vulnMiduNum).append(vulnLowNum).toString();
    }

}
