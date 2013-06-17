package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 知识库测评类型字典表类.
 */
@Entity
@Table(name = "RAM_KNOW_DIC_CP_KIND")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseKnowDicCpKind implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
     * 记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 测评类型编号
     */
    @Column(name="CP_KIND_ID", length = 20, nullable = false)
    private String cpKindId;

    /**
     * 测评类型名称
     */
    @Column(name="CP_KIND_NAME", length = 20, nullable = false)
    private String cpKindName;

    
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpKindId() {
		return cpKindId;
	}

	public void setCpKindId(String cpKindId) {
		this.cpKindId = cpKindId;
	}

	public String getCpKindName() {
		return cpKindName;
	}

	public void setCpKindName(String cpKindName) {
		this.cpKindName = cpKindName;
	}

   
}
