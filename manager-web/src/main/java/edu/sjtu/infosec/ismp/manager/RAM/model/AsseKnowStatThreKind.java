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
 * 知识库静态威胁类别类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_STAT_THRE_KIND")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowStatThreKind implements Serializable {

    /**
     * 静态威胁类别编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 静态威胁类别名称
     */
    @Column(name="KIND", length = 100, nullable = false)
    private String kind;

    /**
     * 关联静态威胁集
     */
    @OneToMany(mappedBy="threKind")
    @Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.REMOVE})
    private Set<AsseKnowStatThre> thres;
    
    /**
     * 关联静态漏洞威胁集
     */
    @OneToMany(mappedBy="threKind")
    @Cascade(value={CascadeType.SAVE_UPDATE,CascadeType.REMOVE})
    private Set<AsseKnowStatLeakThre> leakThres;

    

	/**
     * 构造函数
     */
    public AsseKnowStatThreKind() {
    }

    /**
     * 构造函数
     * 
     * @param threKind
     *            静态威胁类别名称
     */
    public AsseKnowStatThreKind(String threKind) {
        this.kind = threKind;
    }

    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param threKindId
     *            静态威胁类别编号
     */
    public  void setId(Integer threKindId) {
        this.id = threKindId;
    }

    /**
     * @return kind
     */
    public  String getKind() {
        return kind;
    }

    /**
     * @param threats
     *            关联静态威胁集
     */
    public  void setThres(Set<AsseKnowStatThre> threats) {
        this.thres = threats;
    }
    
    /**
     * @param threKind
     *            静态威胁类别名称
     */
    public  void setKind(String threKind) {
        this.kind = threKind;
    }

    /**
     * @return thres
     */
    public  Set<AsseKnowStatThre> getThres() {
        return thres;
    }   

    /**
     * @return leakThres
     */
    public Set<AsseKnowStatLeakThre> getLeakThres() {
		return leakThres;
	}

    /**
     * @param vleakThres
     * 静态漏洞威胁集
     */
	public void setLeakThres(Set<AsseKnowStatLeakThre> vleakThres) {
		this.leakThres = vleakThres;
	}
	
    /**
     * 获取静态威胁类别哈希值
     * 
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 比较是否相等
     * 
     * @param o
     *            静态威胁类别实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowStatThreKind)) {
            return false;
        }
        AsseKnowStatThreKind another = (AsseKnowStatThreKind) o;

        return new EqualsBuilder().append(id, another.id).isEquals();
    }

    /**
     * 静态威胁类别实例属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(kind).toString();
    }

}
