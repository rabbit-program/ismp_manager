package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 知识库安全级别字典表类.
 */
@Entity
@Table(name = "RAM_KNOW_DIC_SECU_LEVE")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseKnowDicSecuLeve implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
     * 记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 安全级别编码
     */
    @Column(name="SECU_LEVE_ID", length = 20, nullable = false)
    private String secuLeveId;

    /**
     * 安全级别名称
     */
    @Column(name="SECU_LEVE_NAME", length = 20, nullable = false)
    private String secuLeveName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSecuLeveId() {
		return secuLeveId;
	}

	public void setSecuLeveId(String secuLeveId) {
		this.secuLeveId = secuLeveId;
	}

	public String getSecuLeveName() {
		return secuLeveName;
	}

	public void setSecuLeveName(String secuLeveName) {
		this.secuLeveName = secuLeveName;
	}
}
