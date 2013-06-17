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
 * 知识库资产脆弱性类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_DYNA_VULN")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowDynaVuln implements Serializable {

    /**
     * 资产脆弱性记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 脆弱点编号
     */
    @Column(name="asse_know_stat_vuln_poin_id", nullable = false)
    private Integer asseKnowStatVulnPoinId;

    /**
     * 脆弱点类别编号
     */
    @Column(name="asse_know_stat_vuln_kind_id", nullable = false)
    private Integer asseKnowStatVulnKindId;

    /**
     * 关联资产
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_info_asse_id")
    private AsseInfoAsse asse;

    /**
     * 所属业务编号
     */
    @Column(name="asse_info_busi_id")
    private Integer asseInfoBusiId;

    /**
     * 严重程度
     */
    @Column(name="SERI_LEVE", length = 2)
    private String seriLeve;

    /**
     * 来源
     */
    @Column(name="SOURCE", length = 10)
    private String source;

    /**
     * 测评项目编号
     */
    @Column(name="asse_info_proj_id", nullable = false)
    private Integer asseInfoProjId;

    /**
     * 关联资产威胁集
     */
    @OneToMany(mappedBy="dynaVuln")
    @Cascade(value={CascadeType.SAVE_UPDATE})
    private Set<AsseKnowDynaThre> dynaThres;

    /**
     * 关联知识库动态评估结果
     * */
    @OneToMany(mappedBy="dynaVuln")
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
     *            资产脆弱性记录编号
     */
    public  void setId(Integer vid) {
        this.id = vid;
    }

    /**
     * @return asseKnowStatVulnPoinId
     */
    public Integer getAsseKnowStatVulnPoinId() {
        return asseKnowStatVulnPoinId;
    }

    /**
     * @param asse_know_stat_vuln_poin_vid
     *            脆弱点编号
     */
    public void setAsseKnowStatVulnPoinId(Integer asseKnowStatVulnPoinVid) {
        this.asseKnowStatVulnPoinId = asseKnowStatVulnPoinVid;
    }
    

    /**
     * @return asseKnowStatVulnKindId
     */
    public Integer getAsseKnowStatVulnKindId() {
        return asseKnowStatVulnKindId;
    }

    /**
     * @return asse
     */
    public  AsseInfoAsse getAsse() {
        return asse;
    }

    /**
     * @param asseKnowStatVulnKindVid
     *            脆弱点类别编号
     */
    public void setAsseKnowStatVulnKindId(Integer asseKnowStatVulnKindVid) {
        this.asseKnowStatVulnKindId = asseKnowStatVulnKindVid;
    }

    /**
     * @param asseInfo
     *            关联资产
     */
    public  void setAsse(AsseInfoAsse asseInfo) {
        this.asse = asseInfo;
    }

    /**
     * @return asseInfoBusiId
     */
    public Integer getAsseInfoBusiId() {
        return asseInfoBusiId;
    }

    /**
     * @param asseInfoBusiVid
     *            所属业务id
     */
    public void setAsseInfoBusiId(Integer asseInfoBusiVid) {
        this.asseInfoBusiId = asseInfoBusiVid;
    }

    /**
     * @return seriLeve
     */
    public  String getSeriLeve() {
        return seriLeve;
    }

    /**
     * @param serileve
     *            严重程度
     */
    public  void setSeriLeve(String serileve) {
        this.seriLeve = serileve;
    }

    /**
     * @return source
     */
    public  String getSource() {
        return source;
    }

    /**
     * @param sour
     *            来源
     */
    public  void setSource(String sour) {
        this.source = sour;
    }

    /**
     * @return asseInfoProjId.
     */
    public Integer getAsseInfoProjId() {
        return asseInfoProjId;
    }

    /**
     * @param asseInfoProjVid
     *            测评项目id
     */
    public void setAsseInfoProjId(Integer asseInfoProjVid) {
        this.asseInfoProjId = asseInfoProjVid;
    }

    /**
     * @return dynaThres
     */
    
    public  Set<AsseKnowDynaThre> getDynaThres() {
        return dynaThres;
    }

    /**
     * @param dynathres
     *            关联资产威胁集
     */
    public  void setDynaThres(Set<AsseKnowDynaThre> dynathres) {
        this.dynaThres = dynathres;
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
     *            资产脆弱性实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowDynaVuln)) {
            return false;
        }
        AsseKnowDynaVuln another = (AsseKnowDynaVuln) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }

    /**
     * 获取资产脆弱性实例哈希值
     * 
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 资产脆弱性实例属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(asseKnowStatVulnPoinId).append(
                asseKnowStatVulnKindId).append(asseInfoBusiId).append(seriLeve).append(source)
                .append(asseInfoProjId).toString();
    }

}