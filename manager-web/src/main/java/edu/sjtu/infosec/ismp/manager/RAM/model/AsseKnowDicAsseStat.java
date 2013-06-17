package edu.sjtu.infosec.ismp.manager.RAM.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 知识库测评状态字典表类.
 */
@Entity
@Table(name = "RAM_KNOW_DIC_ASSE_STAT")
@org.hibernate.annotations.Entity(dynamicInsert=true, dynamicUpdate=true)
public class AsseKnowDicAsseStat implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
     * 记录编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Integer id;

    /**
     * 测评状态编号
     */
    @Column(name="ASSE_STAT_ID", length = 20, nullable = false)
    private String asseStatId;

    /**
     * 测评状态名称
     */
    @Column(name="ASSE_STAT_NAME", length = 20, nullable = false)
    private String asseStatName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAsseStatId() {
		return asseStatId;
	}

	public void setAsseStatId(String asseStatId) {
		this.asseStatId = asseStatId;
	}

	public String getAsseStatName() {
		return asseStatName;
	}

	public void setAsseStatName(String asseStatName) {
		this.asseStatName = asseStatName;
	}
}
