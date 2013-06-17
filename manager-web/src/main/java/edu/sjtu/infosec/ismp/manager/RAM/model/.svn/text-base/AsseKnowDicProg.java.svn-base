package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * 知识库评估流程字典表类.
 * 


 */
@Entity
@Table(name = "RAM_KNOW_DIC_PROG")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseKnowDicProg implements Serializable {

    /**
     * 记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
    
    /**
     * 评估流程编号
     */
    @Column(name="PROG_ID", length = 20, nullable = false)
    private String progId;
    
    /**
     * 评估流程名称
     */
    @Column(name="PROG_NAME", length = 20, nullable = false)
    private String progName;
    
    /**
     * 构造函数
     * @param progid
     * 评估流程编号
     * @param progname
     * 评估流程名称
     */
    public AsseKnowDicProg(String progid, String progname) {
        this.progId = progid;
        this.progName = progname;
      }
    
    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }
    
    /**
     * 构造函数
     */
    public AsseKnowDicProg() {}
    
    /**
     * @param dicId
     * 记录编号
     */
    public  void setId(Integer dicId) {
        this.id = dicId;
    }

    /**
     * @return progId
     */
    public  String getProgId() {
        return progId;
    }

    /**
     * @param progid
     * 评估流程编号
     */
    public  void setProgId(String progid) {
        this.progId = progid;
    }

    /**
     * @return progName
     */
    public  String getProgName() {
        return progName;
    }

    /**
     * @param progname
     * 评估流程名称
     */
    public  void setProgName(String progname) {
        this.progName = progname;
    }

    /**
     * 比较是否相等
     * @param o
     * 评估流程实例
     * @return true/false
     */
    public  boolean equals(Object o) {
        if (!(o instanceof AsseKnowDicProg)) {
            return false;
        }
        AsseKnowDicProg another = (AsseKnowDicProg) o;
        
        return new EqualsBuilder().append(id, another.id).isEquals();
    
    }

    /**
     * 获取哈希值
     * @return 哈希值
     */
    public  int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }

    /**
     * 评估流程属性查看
     * @return 属性字符串
     */
    public  String toString() {
        return new ToStringBuilder(this).append(id).append(progId).append(
                progName).toString();
    }

}
