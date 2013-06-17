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
import org.hibernate.annotations.Type;



/**
 * 知识库静态漏洞威胁类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_STAT_CVE_THRE")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowStatCVEThre implements Serializable {

	/**
     * 静态漏洞威胁Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
    
    /**
     * 静态威胁编号
     * */
    @Column(name="threCode", length=30,  nullable = false)
    private String threCode;

    

    /**
     * cveId
     * */
    @Column(name="CVE_ID", length = 20)
    private String cveId;

    /**
     * 静态威胁描述
     */
    @Column(name="THREAT")
    @Type(type="text")
    private String threat;

    /**
     * 关联静态威胁类别
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_stat_thre_kind_id")
    private AsseKnowStatThreKind threKind;

    /**
     * 备注
     */
    @Column(name="MEMO")
    @Type(type="text")
    private String memo;
    
    /**
     * 构造函数
     */
    public AsseKnowStatCVEThre() {
    }

    /**
     * 构造函数
     * 
     * @param thre
     *            静态威胁描述
     */
    public AsseKnowStatCVEThre(String thre) {
        this.threat = thre;
    }

    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param threId
     *            静态威胁Id
     */
    public  void setId(Integer threId) {
        this.id = threId;
    }

    /**
     * @return threCode
     */
    public String getThreCode() {
		return threCode;
	}

    /**
     * @param vthreCode
     *      静态威胁编号
     */
	public void setThreCode(String vthreCode) {
		this.threCode = vthreCode;
	}
	
	/**
     * @return cveId
     * */
	public String getCveId() {
		return cveId;
	}

	/**
     * @param vcveId
     * */
	public void setCveId(String vcveId) {
		this.cveId = vcveId;
	}

    /**
     * @return threat
     */
    public  String getThreat() {
        return threat;
    }

    

	

	/**
     * @param thre
     *            静态威胁描述
     */
    public  void setThreat(String thre) {
        this.threat = thre;
    }

    /**
     * 比较是否相等
     * 
     * @param o
     *            静态威胁实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowStatCVEThre)) {
            return false;
        }
        AsseKnowStatCVEThre another = (AsseKnowStatCVEThre) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }
    
    /**
     * @return threKind
     */
    
    public  AsseKnowStatThreKind getThreKind() {
        return threKind;
    }

    /**
     * @param threkind
     *            关联静态威胁类别
     */
    public  void setThreKind(AsseKnowStatThreKind threkind) {
        this.threKind = threkind;
    }
    
    /**
     * @return memo
     */
    public  String getMemo() {
        return memo;
    }

    /**
     * @param vMemo
     *            备注
     */
    public  void setMemo(String vMemo) {
        this.memo = vMemo;
    }

    /**
     * 获取静态威胁对象哈希值
     * 
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 静态威胁实例属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(cveId).append(threat).toString();
    }
	
}
