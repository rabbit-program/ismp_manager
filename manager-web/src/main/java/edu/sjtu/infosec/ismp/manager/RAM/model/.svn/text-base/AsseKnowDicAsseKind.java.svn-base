package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 知识库资产类别字典表类.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "RAM_KNOW_DIC_ASSE_KIND")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseKnowDicAsseKind implements Serializable {

    /**
     * 记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;
    
    /**
     * 类别编号
     */
    @Column(name="ASSET_KIND_ID", length = 20, nullable = false)
    private String assetKindId;
    
    /**
     * 类别名称
     */
    @Column(name="ASSET_KIND_NAME", length = 50, nullable = false)
    private String assetKindName;
    
    /**
     * 父类
     */
    @Column(name="asse_know_dic_asse_kind_id", length = 50, nullable = false)
    private Integer asse_kind_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssetKindId() {
		return assetKindId;
	}

	public void setAssetKindId(String assetKindId) {
		this.assetKindId = assetKindId;
	}

	public String getAssetKindName() {
		return assetKindName;
	}

	public void setAssetKindName(String assetKindName) {
		this.assetKindName = assetKindName;
	}

	public Integer getAsse_kind_id() {
		return asse_kind_id;
	}

	public void setAsse_kind_id(Integer asse_kind_id) {
		this.asse_kind_id = asse_kind_id;
	}
}
