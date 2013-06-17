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
import org.hibernate.annotations.Type;



/**
 * 知识库项目总体评估值类.
 */
@Entity
@Table(name = "RAM_KNOW_DYNA_ASSE_VALU")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class AsseKnowDynaAsseValue implements Serializable {

    /**
     * 项目总体评估值记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    /**
     * 测评项目编号
     */
    @Column(name = "PROJ_CODE", length = 20, nullable = false)
    private String projCode;

    /**
     * 总评
     */
    @Column(name = "TOTAL_ASSE")
    @Type(type="text")
    private String totalAsse;

    /**
     * 专家意见
     */
    @Column(name = "EXPERT_SUGGEST")
    @Type(type="text")
    private String expertSuggest;
    
    /**
     * 评估对象网络拓扑
     */
    @Column(name = "WEB_TOPOINFO")
    @Type(type="text")
    private String webTopoInfo;

    /**
     * @return projCode
     */
    public String getProjCode() {
        return projCode;
    }

    /**
     * 资产评估要素结果集
     */
    @OneToMany(mappedBy = "dynaAsseValue")
    @Cascade(value = { CascadeType.SAVE_UPDATE })
    private Set<AsseKnowDynaElemResu> dynaElemResus;

    /**
     * @param projcode
     *            测评项目编号
     */
    public void setProjCode(String projcode) {
        this.projCode = projcode;
    }

    /**
     * @param vid
     *            项目总体评估值记录编号
     */
    public void setId(Integer vid) {
        this.id = vid;

    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return totalAsse
     */
    public String getTotalAsse() {
        return totalAsse;
    }

    /**
     * @param totalasse
     *            总评
     */
    public void setTotalAsse(String totalasse) {
        this.totalAsse = totalasse;
    }

    /**
     * @return expertSuggest
     */
    public String getExpertSuggest() {
        return expertSuggest;
    }

    /**
     * @param expertsuggest
     *            专家意见
     */
    public void setExpertSuggest(String expertsuggest) {
        this.expertSuggest = expertsuggest;
    }

    
    /**
     * @return webTopoInfo
     */
    public String getWebTopoInfo() {
		return webTopoInfo;
	}

    /**
     * @param vwebTopoInfo
     *  评估对象网络拓扑
     */
	public void setWebTopoInfo(String vwebTopoInfo) {
		this.webTopoInfo = vwebTopoInfo;
	}

	/**
     * @return dynaElemResus
     */

    public Set<AsseKnowDynaElemResu> getDynaElemResus() {
        return dynaElemResus;
    }

    /**
     * @param dynaelemResus
     *            资产评估要素结果集
     */
    public void setDynaElemResus(Set<AsseKnowDynaElemResu> dynaelemResus) {
        this.dynaElemResus = dynaelemResus;
    }

    /**
     * 比较是否相等
     * 
     * @param o
     *            项目总体评估实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowDynaAsseValue)) {
            return false;
        }
        AsseKnowDynaAsseValue another = (AsseKnowDynaAsseValue) o;
        return new EqualsBuilder().append(id, another.id).isEquals();
    }

    /**
     * 获取项目总体评估哈希值
     * 
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 项目总体评估实例属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(projCode).append(
                totalAsse).append(expertSuggest).append(webTopoInfo).toString();
    }

}
