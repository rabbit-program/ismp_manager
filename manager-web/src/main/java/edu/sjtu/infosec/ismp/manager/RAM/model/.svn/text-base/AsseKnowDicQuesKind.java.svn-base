package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;
import java.util.Set;

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
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;



/**
 * 知识库问题类型字典表类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_DIC_QUES_KIND")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseKnowDicQuesKind implements Serializable {

    /**
     * 问题类型编码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 类型名称
     */
    @Column(name="QUES_KIND_NAME", length = 20, nullable = false)
    private String quesKindName;

    /**
     * 页面元素代码
     */
    @Column(name="HTML_CODE", nullable = false)
    @Type(type="text")
    private String htmlCode;

    /**
     * 关联安全要素集
     */
    @OneToMany(mappedBy="quesKind")
    @Cascade(value={CascadeType.SAVE_UPDATE})
    private Set<AsseKnowStatSecuElem> asseKnowStatSecuElems;

    /**
     * @return quesKindId
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param dicId
     * 问题类型编码
     */
    public  void setId(Integer dicId) {
        this.id = dicId;
    }

    /**
     * @return quesKindName
     */
    public  String getQuesKindName() {
        return quesKindName;
    }

    /**
     * @param queskindName
     * 问题类型名称
     */
    public  void setQuesKindName(String queskindName) {
        this.quesKindName = queskindName;
    }

    /**
     * @return htmlCode
     */
    public  String getHtmlCode() {
        return htmlCode;
    }

    /**
     * @param htmlcode
     * 页面元素代码
     */
    public  void setHtmlCode(String htmlcode) {
        this.htmlCode = htmlcode;
    }

    /**
     * @return asseKnowStatSecuElems
     */
    
    public  Set<AsseKnowStatSecuElem> getAsseKnowStatSecuElems() {
        return asseKnowStatSecuElems;
    }

    /**
     * @param asseknowStatSecuElems
     * 关联安全要素集
     */
    public  void setAsseKnowStatSecuElems(Set<AsseKnowStatSecuElem> asseknowStatSecuElems) {
        this.asseKnowStatSecuElems = asseknowStatSecuElems;
    }

    /**
     * 比较是否相等
     * @param o
     * 问题类型实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowDicQuesKind)) {
            return false;
        }
        AsseKnowDicQuesKind another = (AsseKnowDicQuesKind) o;
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
     * 问题类型属性查看
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(
                quesKindName).append(htmlCode).toString();
    }

}
