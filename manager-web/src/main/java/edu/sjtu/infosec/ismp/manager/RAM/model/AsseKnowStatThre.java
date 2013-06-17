package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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
import org.hibernate.annotations.Type;



/**
 * 知识库静态威胁类.
 */
@Entity
@Table(name = "RAM_KNOW_STAT_THRE")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseKnowStatThre implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
     * 静态威胁Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
    
    /**
     * 静态威胁编号
     * */
    @Column(name="threcode", length=10,  nullable = false)
    private String threCode;

    

	/**
     * 关联静态脆弱点
     */
    @ManyToOne
    @Cascade(value={CascadeType.SAVE_UPDATE})
    @JoinColumn(name="asse_know_stat_vuln_poin_id")
    private AsseKnowStatVulnPoin vulnPoin;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getThreCode() {
		return threCode;
	}

	public void setThreCode(String threCode) {
		this.threCode = threCode;
	}

	public AsseKnowStatVulnPoin getVulnPoin() {
		return vulnPoin;
	}

	public void setVulnPoin(AsseKnowStatVulnPoin vulnPoin) {
		this.vulnPoin = vulnPoin;
	}

	public String getThreat() {
		return threat;
	}

	public void setThreat(String threat) {
		this.threat = threat;
	}

	public AsseKnowStatThreKind getThreKind() {
		return threKind;
	}

	public void setThreKind(AsseKnowStatThreKind threKind) {
		this.threKind = threKind;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
