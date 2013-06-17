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
 * 知识库静态安全要素类.
 */
@Entity
@Table(name = "RAM_KNOW_STAT_SECU_ELEM")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowStatSecuElem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID", length=20)
    private Integer id;
    
    /**
     * 要素编码
     */
    @Column(name="ELEM_CODE", length = 10, nullable=false,unique=true)
    private String elemCode;

    /**
     * 要素名称
     */
    @Column(name="ELEM_NAME", length = 30)
    private String name;

    /**
     * 指标内容
     */
    @Column(name="CONTENT")
    @Type(type="text")
    private String content;

    /**
     * 备注
     */
    @Column(name="MEMO")
    @Type(type="text")
    private String memo;

    /**
     * 要素页面URL
     */
    @Column(name="URL", length = 100)
    private String url;
    
    /**
     * 问题类型
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_dic_ques_kind_id")
    private AsseKnowDicQuesKind quesKind;

    /**
     * 父安全要素
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_stat_secu_elem_id")
    private AsseKnowStatSecuElem parentSecuElem;

    /**
     * 关联跳转点
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_stat_secu_elem_id_jump")
    private AsseKnowStatSecuElem jumpSecuElem;

    /**
     * 关联静态脆弱点
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_stat_vuln_poin_id")
    private AsseKnowStatVulnPoin vulnPoin;
    
    
    /**
     * 关联问卷集
     */
    @OneToMany(mappedBy="secuElem")
    @Cascade(value={CascadeType.SAVE_UPDATE})
    private Set<AsseInfoPape> papes;

    /**
     * 构造函数
     */
    public AsseKnowStatSecuElem() {
    }

    /**
     * 构造函数
     * 
     * @param elemcode
     *            要素编码
     */
    public AsseKnowStatSecuElem(String elemcode) {
        this.elemCode = elemcode;
    }

    /**
     * 构造函数
     * 
     * @param elemcode
     *            要素编码
     * @param secuElemName
     *            要素名称
     */
    public AsseKnowStatSecuElem(String elemcode, String secuElemName) {
        this.elemCode = elemcode;
        this.name = secuElemName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer vid) {
        this.id = vid;
    }

    /**
     * @return elemCode
     */
    public  String getElemCode() {
        return elemCode;
    }

    /**
     * @param elemcode
     *            要素编码
     */
    public  void setElemCode(String elemcode) {
        this.elemCode = elemcode;
    }

    /**
     * @return name
     */
    public  String getName() {
        return name;
    }

    /**
     * @param elemName
     *            要素名称
     */
    public  void setName(String elemName) {
        this.name = elemName;
    }

    /**
     * @return content
     */
    public  String getContent() {
        return content;
    }

    /**
     * @param cont
     *            指标内容
     */
    public  void setContent(String cont) {
        this.content = cont;
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
     * @return quesKind
     */
    
    public  AsseKnowDicQuesKind getQuesKind() {
        return quesKind;
    }

    /**
     * @param queskind
     *            关联问题类型
     */
    public  void setQuesKind(AsseKnowDicQuesKind queskind) {
        this.quesKind = queskind;
    }

    /**
     * @return parentSecuElem
     */
    
    public  AsseKnowStatSecuElem getParentSecuElem() {
        return parentSecuElem;
    }

    /**
     * @param parentsecuElem
     *            父安全要素
     */
    public  void setParentSecuElem(AsseKnowStatSecuElem parentsecuElem) {
        this.parentSecuElem = parentsecuElem;
    }

    /**
     * @param jumpsecuElem
     *            跳转点
     */
    public  void setJumpSecuElem(AsseKnowStatSecuElem jumpsecuElem) {
        this.jumpSecuElem = jumpsecuElem;
    }
    
    /**
     * @return jumpSecuElem
     */
    
    public  AsseKnowStatSecuElem getJumpSecuElem() {
        return jumpSecuElem;
    }


    /**
     * @return vulnPoin
     */
    
    public  AsseKnowStatVulnPoin getVulnPoin() {
        return vulnPoin; //
    }

    /**
     * @param vulnpoin
     *            关联静态脆弱点
     */
    public  void setVulnPoin(AsseKnowStatVulnPoin vulnpoin) {
        this.vulnPoin = vulnpoin;
    }

    /**
     * @return url
     */
    public  String getUrl() {
        return url;
    }

    /**
     * @param elemUrl
     *            要素页面URL
     */
    public  void setUrl(String elemUrl) {
        this.url = elemUrl;
    }

    /**
     * @return papes
     */
    
    public  Set<AsseInfoPape> getPapes() {
        return papes;
    }

    /**
     * @param elemPapes
     *            关联问卷集
     */
    public  void setPapes(Set<AsseInfoPape> elemPapes) {
        this.papes = elemPapes;
    }

  
    /**
     * 比较是否相等
     * 
     * @param o
     *            安全要素实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowStatSecuElem)) {
            return false;
        }
        AsseKnowStatSecuElem another = (AsseKnowStatSecuElem) o;
        return new EqualsBuilder().append(elemCode, another.elemCode)
                .isEquals();
    }

    /**
     * 获取哈希值
     * 
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(elemCode).hashCode();
    }

    /**
     * 安全要素实例属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(elemCode).append(name).append(
                content).append(url).toString();
    }

}
