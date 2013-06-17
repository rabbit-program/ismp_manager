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
 * 知识库静态脆弱点类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_STAT_VULN_POIN")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowStatVulnPoin implements Serializable {

    /**
     * 静态脆弱点编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
    
    /**
     * 静态脆弱点描述
     */
    @Column(name="VULN_POIN_DESCRIBE", nullable = false)
    @Type(type="text")
    private String describe;
    
    /**
     * 关联静态脆弱点类别
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_stat_vuln_kind_id")
    private AsseKnowStatVulnKind vulnKind;
    
    /**
     * 来源
     */
    @Column(name="SOURCE", length = 10)
    private String source;
    
    /**
     * 解决方案
     */
    @Column(name="RESOLVE")
    @Type(type="text")
    private String resolve;
    
    /**
     * 关联静态威胁集
     */
    @OneToMany(mappedBy="vulnPoin")
    @Cascade(value={CascadeType.SAVE_UPDATE})
    private Set<AsseKnowStatThre> thres;
    
    /**
     * 关联安全要素集
     */
    @OneToMany(mappedBy="vulnPoin")
    @Cascade(value={CascadeType.SAVE_UPDATE})
    private Set<AsseKnowStatSecuElem> secuElems;

    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param vulnPoinId
     * 静态脆弱点编号
     */
    public  void setId(Integer vulnPoinId) {
        this.id = vulnPoinId;
    }

    /**
     * @return describe
     */
    public  String getDescribe() {
        return describe;
    }

    /**
     * @param desc
     * 静态脆弱点描述
     */
    public  void setDescribe(String desc) {
        this.describe = desc;
    }

    /**
     * @return vulnKind
     */
    
    public  AsseKnowStatVulnKind getVulnKind() {
        return vulnKind;
    }

    /**
     * @param vulnkind
     * 关联静态脆弱点类别
     */
    public  void setVulnKind(AsseKnowStatVulnKind vulnkind) {
        this.vulnKind = vulnkind;
    }

    /**
     * @return source
     */
    public  String getSource() {
        return source;
    }

    /**
     * @param sour
     * 来源
     */
    public  void setSource(String sour) {
        this.source = sour;
    }

    /**
     * @return resolve
     */
    public  String getResolve() {
        return resolve;
    }

    /**
     * @param reso
     * 解决方案
     */
    public  void setResolve(String reso) {
        this.resolve = reso;
    }

    /**
     * @return thres
     */
    
    public  Set<AsseKnowStatThre> getThres() {
        return thres;
    }

    /**
     * @param threats
     * 关联静态威胁集
     */
    public  void setThres(Set<AsseKnowStatThre> threats) {
        this.thres = threats;
    }

    /**
     * @return secuElems
     */
    
    public  Set<AsseKnowStatSecuElem> getSecuElems() {
        return secuElems;
    }

    /**
     * @param secuelems
     * 关联安全要素集
     */
    public  void setSecuElems(Set<AsseKnowStatSecuElem> secuelems) {
        this.secuElems = secuelems;
    }

    /**
     * 比较是否相等
     * @param o
     * 静态脆弱点实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowStatVulnPoin)) {
            return false;
        }
        AsseKnowStatVulnPoin another = (AsseKnowStatVulnPoin) o;
        return new EqualsBuilder().append(id, another.id)
        .isEquals();
    }

    /**
     * 获取哈希值
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 静态脆弱点实例属性查看
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(describe).append(
                source).append(resolve).toString();
    }

}
