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

import edu.sjtu.infosec.ismp.security.Domain;


/**
 * 信息库资产信息类.
 */
@Entity
@Table(name = "ram_info_asse")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate = true)
public class AsseInfoAsse implements Serializable {

    /**
     * 主键id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
    
    
    /**
     * 资产编号
     * */
    @Column(name="ASSET_CODE", length = 50, nullable = false,unique=true)
    private String assetCode;
    
    /**
     * 项目编号
     * */
    @Column(name="asse_info_proj_id")
    private Integer asseInfoProjId;
    
    /**
     * 资产名称
     * */
    @Column(name="ASSET_NAME", length = 50)
    private String assetName;
    
    /**
     * 所属业务
     * */
    @Column(name="asse_info_busi_id",length=20)
    private Integer asseInfoBusiId;
    
    /**
     * 重要性
     * */
    @Column(name="IMPORTANCE", length = 5)
    private String importance;
    
    /**
     * 备注
     * */
    @Column(name="MEMO")
    @Type(type="text")
    private String memo;
    
    /**
     * 负责人
     * */
    @Column(name="RESP_MAN", length = 20)
    private String respMan;
    
    /**
     * IP地址
     * */
    @Column(name="IP", length = 20)
    private String ip;
    
    /**
     * 关联机构
     * */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
    
    /**
     * 关联资产类别
     * */
    @ManyToOne
    @JoinColumn(name="asse_know_dic_asse_kind_id")
    private AsseKnowDicAsseKind asseKind;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public Integer getAsseInfoProjId() {
		return asseInfoProjId;
	}

	public void setAsseInfoProjId(Integer asseInfoProjId) {
		this.asseInfoProjId = asseInfoProjId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Integer getAsseInfoBusiId() {
		return asseInfoBusiId;
	}

	public void setAsseInfoBusiId(Integer asseInfoBusiId) {
		this.asseInfoBusiId = asseInfoBusiId;
	}

	public String getImportance() {
		return importance;
	}

	public void setImportance(String importance) {
		this.importance = importance;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getRespMan() {
		return respMan;
	}

	public void setRespMan(String respMan) {
		this.respMan = respMan;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public AsseKnowDicAsseKind getAsseKind() {
		return asseKind;
	}

	public void setAsseKind(AsseKnowDicAsseKind asseKind) {
		this.asseKind = asseKind;
	}
}
