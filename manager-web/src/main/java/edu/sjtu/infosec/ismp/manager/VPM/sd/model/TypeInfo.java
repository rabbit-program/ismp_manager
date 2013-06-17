package edu.sjtu.infosec.ismp.manager.VPM.sd.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @Description: 软件类型对象
 * @author liuqing
 */
@Entity
@Table(name = "vpm_sd_type_info")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class TypeInfo implements Serializable {
	
	/**
	 * 主键Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	/**
	 * 软件类型名称
	 */
	@Column(name = "name")
	private String name;
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
}
