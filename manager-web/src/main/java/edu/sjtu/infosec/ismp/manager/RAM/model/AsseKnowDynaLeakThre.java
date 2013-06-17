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



/**
 * 知识库资产漏洞威胁类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_DYNA_LEAK_THRE")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowDynaLeakThre implements Serializable {

	/**
     * 资产威胁性记录编号
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
    @JoinColumn(name="asse_info_asse_id")
    private AsseInfoAsse asse;

    /**
     * 关联资产漏洞
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_dyna_leak_id")
    private AsseKnowDynaLeak dynaLeak;

    /**
     * 静态威胁Id
     */
    @Column(name="asse_know_stat_cve_thre_id")
    private Integer asseKnowStatCveThreId;
    
    /**
     * 静态威胁编号
     * */
    @Column(name="threCode", length=10)
    private String threCode;

    /**
     * 威胁类别编号
     */
    @Column(name="asse_know_stat_thre_kind_id")
    private Integer asseKnowStatThreKindId;

    /**
     * 安全事件发生可能性
     */
    @Column(name="POSSIBILITY", length = 2, nullable = false)
    private String possibility;

    /**
     * 测评项目编号
     */
    @Column(name="asse_info_proj_id", nullable = false)
    private Integer asseInfoProjId;

    /**
     * 关联知识库动态评估结果
     * */
    @OneToMany(mappedBy="dynaLeakThre")
    @Cascade(value={CascadeType.SAVE_UPDATE})
    private Set<AsseKnowDynaAsseResu> asseKnowDynaAsseResus;
    
    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param vid
     *            资产威胁性记录编号
     .*/
    public  void setId(Integer vid) {
        this.id = vid;
    }

    /**
     * @return asse
     */
    
    public  AsseInfoAsse getAsse() {
        return asse;
    }

    /**
     * @param asseInfo
     *            关联资产
     */
    public  void setAsse(AsseInfoAsse asseInfo) {
        this.asse = asseInfo;
    }

    /**
     * @return dynaLeak
     */
    public AsseKnowDynaLeak getDynaLeak() {
		return dynaLeak;
	}
    

    /**
     * @param vdynaLeak
     * 关联资产漏洞
     */
    public void setDynaLeak(AsseKnowDynaLeak vdynaLeak) {
		this.dynaLeak = vdynaLeak;
	}

    /**
     * @return asseKnowStatThreId
     */
    public Integer getAsseKnowStatCveThreId() {
        return asseKnowStatCveThreId;
    }

    

	/**
     * @param asseKnowStatThreVid
     *            静态威胁Id
     */
    public void setAsseKnowStatCveThreId(Integer asseknowStatCveThreVid) {
        this.asseKnowStatCveThreId = asseknowStatCveThreVid;
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
     * @return asseKnowStatThreKindId
     */
    public Integer getAsseKnowStatThreKindId() {
        return asseKnowStatThreKindId;
    }
    
    /**
     * @param asseKnowStatThreKindVid
     *            威胁类别编号
     */
    public void setAsseKnowStatThreKindId(Integer asseKnowStatThreKindVid) {
        this.asseKnowStatThreKindId = asseKnowStatThreKindVid;
    }
    
    /**
     * @return possibility
     */
    public  String getPossibility() {
        return possibility;
    }
    
    
    /**
     * @param poss
     *            安全事件发生可能性
     */
    public  void setPossibility(String poss) {
        this.possibility = poss;
    }

    /**
     * @return asseInfoProjId
     */
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
     * @return asseKnowDynaAsseResus
     * */
    public Set<AsseKnowDynaAsseResu> getAsseKnowDynaAsseResus() {
        return asseKnowDynaAsseResus;
    }

    /**
     * @param asseknowDynaAsseResus 动态评估结果
     * */
    public void setAsseKnowDynaAsseResus(
            Set<AsseKnowDynaAsseResu> asseknowDynaAsseResus) {
        this.asseKnowDynaAsseResus = asseknowDynaAsseResus;
    }
    
    /**
     * 比较是否相等
     * 
     * @param o
     *            资产威胁性实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowDynaLeakThre)) {
            return false;
        }
        AsseKnowDynaLeakThre another = (AsseKnowDynaLeakThre) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }

   
    /**
     * 获取资产威胁实例哈希值
     * 
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 资产威胁性实例属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(asseKnowStatThreKindId).append(
        		threCode).append(possibility).append(asseInfoProjId).toString();
    }
	
}
