package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * 知识库静态脆弱点类别类.
 */
@Entity
@Table(name = "RAM_KNOW_STAT_VULN_KIND")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowStatVulnKind implements Serializable {

    /**
     * 静态脆弱点类别编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
    
    /**
     * 静态脆弱点类别名称
     */
    @Column(name="KIND", length = 100, nullable = false)
    private String kind;
    
    /**
     * 关联静态脆弱点集
     */
    @OneToMany(mappedBy="vulnKind")
    @Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.REMOVE})
    private Set<AsseKnowStatVulnPoin> vulnPoins;
    
    /**
     * 关联静态漏洞集
     */
    @OneToMany(mappedBy="vulnKind")
    @Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.REMOVE})
    private Set<AsseKnowStatLeak> leaks;

    
    

	/**
     * 构造函数
     */
    public AsseKnowStatVulnKind() {
    }

    /**
     * 构造函数
     * @param vulnKind
     * 静态脆弱点类别名称
     */
    public AsseKnowStatVulnKind(String vulnKind) {
        this.kind = vulnKind;
    }

    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param vulnKindId
     * 静态脆弱点类别编号
     */
    public  void setId(Integer vulnKindId) {
        this.id = vulnKindId;
    }

    /**
     * @return kind
     */
    public  String getKind() {
        return kind;
    }

    /**
     * @param vulnKind
     * 静态脆弱点类别名称
     */
    public  void setKind(String vulnKind) {
        this.kind = vulnKind;
    }

    /**
     * @return vulnPoins
     */
    public  Set<AsseKnowStatVulnPoin> getVulnPoins() {
        return vulnPoins;
    }

    /**
     * @param vulnpoins
     * 关联静态脆弱点集
     */
    public  void setVulnPoins(Set<AsseKnowStatVulnPoin> vulnpoins) {
        this.vulnPoins = vulnpoins;
    }

    /**
     * @return leaks
     */
    public Set<AsseKnowStatLeak> getLeaks() {
		return leaks;
	}

    /**
     * @param vleaks
     * 关联静态漏洞集
     */
	public void setLeaks(Set<AsseKnowStatLeak> vleaks) {
		this.leaks = vleaks;
	}

    /**
     * 获取哈希值
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 静态脆弱点类别实例属性查看
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(kind).toString();
    }

    /**
     * 比较是否相等
     * @param o
     * 静态脆弱点类别实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowStatVulnKind)) {
            return false;
        }
        AsseKnowStatVulnKind another = (AsseKnowStatVulnKind) o;
        
        
        return new EqualsBuilder()
        .append(id, another.id)
        .isEquals();
    }
    
}
