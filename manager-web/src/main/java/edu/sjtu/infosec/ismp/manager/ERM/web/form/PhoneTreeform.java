package edu.sjtu.infosec.ismp.manager.ERM.web.form;

import org.apache.struts.action.ActionForm;

public class PhoneTreeform extends ActionForm {
	
	private static final long serialVersionUID = 1L;

	private Integer resp_info_id;
	
	private String jobid;
	
	private String team_code;

	private String mp;

	private String job;

	private String email;

	private String fax;

	private String name;

	private Integer id;
	
	private Integer pid;
	
	private Integer fid;
	
	private String linkManid;

	
	

	public String getLinkManid() {
		return linkManid;
	}

	public void setLinkManid(String linkManid) {
		this.linkManid = linkManid;
	}

	public Integer getResp_info_id() {
		return resp_info_id;
	}

	public void setResp_info_id(Integer resp_info_id) {
		this.resp_info_id = resp_info_id;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getTeam_code() {
		return team_code;
	}

	public void setTeam_code(String team_code) {
		this.team_code = team_code;
	}

	public String getMp() {
		return mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}
}
