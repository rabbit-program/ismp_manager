package edu.sjtu.infosec.ismp.manager.VPM.vm.model;

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

/**
 * 病毒告警
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
@Entity
@Table(name = "vpm_vm_va")
@org.hibernate.annotations.Entity(dynamicInsert = true, dynamicUpdate = true)
public class VirusAlerts implements Serializable {
	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	/**
	 * 病毒所在客户端
	 */
    @ManyToOne 
    @JoinColumn(name="virus_clients_id")
	private VirusClients virusClients;
	/**
	 * 病毒信息
	 */
    @ManyToOne 
    @JoinColumn(name="virus_id")
	private Virus virus;
	/**
	 * 已感染文件的路径
	 */
    @Column(name="path")
	private String path;
	/**
	 * 已感染文件的名称
	 */
    @Column(name="file_name")
	private String fileName;
	/**
	 * 查杀结果
	 */
    @ManyToOne 
    @JoinColumn(name="kill_result_id")
	private KillResultType killResult;
	/**
	 * 病毒发现者
	 */
    @Column(name="finder")
	private String finder;
	/**
	 * 病毒来源
	 */
    @Column(name="virus_source")
	private String virusSource;
	/**
	 * 发现时间
	 */
    @Column(name="find_time")
	private Timestamp findTime;
	/**
	 * 末次发现时间
	 */
    @Column(name="last_find_time")
	private Timestamp lastFindTime;
	/**
	 * 此时间段查出的病毒数
	 */
    @Column(name="vcount")
	private int vcount;
	public int getVcount() {
		return vcount;
	}

	public void setVcount(int vcount) {
		this.vcount = vcount;
	}

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

	public VirusClients getVirusClients() {
		return virusClients;
	}

	public void setVirusClients(VirusClients virusClients) {
		this.virusClients = virusClients;
	}

	public Virus getVirus() {
		return virus;
	}

	public void setVirus(Virus virus) {
		this.virus = virus;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public KillResultType getKillResult() {
		return killResult;
	}

	public void setKillResult(KillResultType killResult) {
		this.killResult = killResult;
	}

	public String getFinder() {
		return finder;
	}

	public void setFinder(String finder) {
		this.finder = finder;
	}

	public String getVirusSource() {
		return virusSource;
	}

	public void setVirusSource(String virusSource) {
		this.virusSource = virusSource;
	}

	public Timestamp getFindTime() {
		return findTime;
	}

	public void setFindTime(Timestamp findTime) {
		this.findTime = findTime;
	}

	public Timestamp getLastFindTime() {
		return lastFindTime;
	}

	public void setLastFindTime(Timestamp lastFindTime) {
		this.lastFindTime = lastFindTime;
	}



	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
