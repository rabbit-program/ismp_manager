package edu.sjtu.infosec.ismp.manager.OSS.klbm.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.sjtu.infosec.ismp.security.Domain;

/**
 * 知识库
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "oss_klbm_knowledge_base")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class OssKnowledgeBase implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 所属域
	 */
    @ManyToOne 
    @JoinColumn(name="domain_id")
	private Domain domain;
	/**
	 * 编号
	 */
    @Column(name="sn")
	private String sn;
	/**
	 * 名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 内容
	 */
    @Column(name="file_content")
	private String file_content;
	/**
	 * 发布人员
	 */
    @Column(name="issuer")
	private String issuer;
	/**
	 * 创建时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
	/**
	 * 最后修改时间
	 */
    @Column(name="last_update_time")
	private Timestamp lastUpdateTime;
	/**
	 * 备注
	 */
    @Column(name="remark")
	private String remark;

    
    
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Domain getDomain() {
		return domain;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFile_content() {
		return file_content;
	}
	public void setFile_content(String file_content) {
		this.file_content = file_content;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
