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
 * 信息库问卷类.
 * 


 */
@Entity
@Table(name = "RAM_INFO_PAPE")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseInfoPape implements Serializable {

    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 项目编号
     * */
    @Column(name="asse_info_proj_id", nullable = false)
    private Integer asseInfoProjId;
    
    /**
     * 关联安全要素
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "asse_know_stst_secu_elem_id", nullable = false)
    private AsseKnowStatSecuElem secuElem;

    /**
     * 答案
     */
    @Column(name="ANSWER", length = 20)
    private String answer;

    /**
     * 现场记录
     */
    @Column(name="RECORD")
    @Type(type="text")
    private String record;

    

    /**
     * 备注
     */
    @Column(name="MEMO")
    @Type(type="text")
    private String memo;

    

    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param recoId
     *            编号
     */
    public  void setId(Integer recoId) {
        this.id = recoId;
    }
    
    /**
     * @return asseInfoProjId
     * */
    public Integer getAsseInfoProjId() {
        return asseInfoProjId;
    }

    /**
     * @param asseInfoProjVid
     *            项目编号
     * */
    public void setAsseInfoProjId(Integer asseInfoProjVid) {
        this.asseInfoProjId = asseInfoProjVid;
    }
    

    /**
     * @return secuElem
     */
    
    public  AsseKnowStatSecuElem getSecuElem() {
        return secuElem;
    }

    /**
     * @param secuelem
     *            安全要素
     */
    public  void setSecuElem(AsseKnowStatSecuElem secuelem) {
        this.secuElem = secuelem;
    }

    /**
     * @return answer
     */
    public  String getAnswer() {
        return answer;
    }

    /**
     * @param answ
     *            答案
     */
    public  void setAnswer(String answ) {
        this.answer = answ;
    }

    /**
     * @return record
     */
    public  String getRecord() {
        return record;
    }

    /**
     * @param reco
     *            现场记录
     */
    public  void setRecord(String reco) {
        this.record = reco;
    }

    /**
     * @return memo
     */
    public  String getMemo() {
        return memo;
    }

    /**
     * @param paperMemo
     *            备注
     */
    public  void setMemo(String paperMemo) {
        this.memo = paperMemo;
    }


    /**
     * 获取哈希值
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
     *            问卷实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        
        if (!(o instanceof AsseInfoPape)) {
            return false;
        }
        AsseInfoPape another = (AsseInfoPape) o;
        
        return new EqualsBuilder().append(id, another.id).isEquals();
    }
    
    /**
     * 问卷属性查看
     * 
     * @return 属性字符串
     */
    public  String toString() {
        
        return new ToStringBuilder(this).append(id).append(asseInfoProjId)
                .append(answer).append(record).append(memo).toString();
    }

}
