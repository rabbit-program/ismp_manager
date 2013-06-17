package edu.sjtu.infosec.ismp.manager.VPM.pm.model;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 补丁更新策略
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "vpm_pm_patch_update_tactics")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class PatchUpdateTactics implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 名称
	 */
    @Column(name="name")
	private String name;
	/**
	 * 是否自动更新
	 * 0：不自动更新
	 * 1：自动更新		推荐
	 */
    @Column(name="is_auto_update")
	private int isAutoUpdate;
	/**
	 * 更新地址
	 */
    @Column(name="update_address")
	private String updateAddress;
	/**
	 * 更新方式
	 * 2 通知下载并通知安装
	 * 3 自动下载并通知安装
	 * 4 自动下载并计划安装（在计划时间安装）	推荐
	 */
    @Column(name="update_way")
	private int updateWay;
	/**
	 * 下载更新时间
	 */
    @Column(name="update_time")
	private String updateTime;
	/**
	 * 创建时间
	 */
    @Column(name="create_time")
	private Timestamp createTime;
	/**
	 * 策略最后变更时间
	 */
    @Column(name="last_change_time")
	private Timestamp lastChangeTime;
	/**
	 * 备注
	 */
    @Column(name="remarks")
	private String remarks;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsAutoUpdate() {
		return isAutoUpdate;
	}
	public void setIsAutoUpdate(int isAutoUpdate) {
		this.isAutoUpdate = isAutoUpdate;
	}
	public String getUpdateAddress() {
		return updateAddress;
	}
	public void setUpdateAddress(String updateAddress) {
		this.updateAddress = updateAddress;
	}
	public int getUpdateWay() {
		return updateWay;
	}
	public void setUpdateWay(int updateWay) {
		this.updateWay = updateWay;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getLastChangeTime() {
		return lastChangeTime;
	}
	public void setLastChangeTime(Timestamp lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
