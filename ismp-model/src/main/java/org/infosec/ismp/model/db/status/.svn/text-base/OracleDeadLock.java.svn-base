package org.infosec.ismp.model.db.status;

import java.io.Serializable;

/**
 * @author guoxianwei
 * @date 2010-12-2 下午06:27:17
 * 
 */
public class OracleDeadLock implements Serializable {
	
	private static final long serialVersionUID = 658671616089199501L;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public Long getSid() {
		return sid;
	}

	public Long getSerial() {
		return serial;
	}

	public String getProgram() {
		return program;
	}

	public String getMachine() {
		return machine;
	}

	public String getOsuser() {
		return osuser;
	}

	public String getType() {
		return type;
	}

	public Integer getImode() {
		return imode;
	}

	public Integer getRequest() {
		return request;
	}

	public Integer getBlock() {
		return block;
	}

	public Long getCtime() {
		return ctime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public void setSerial(Long serial) {
		this.serial = serial;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public void setOsuser(String osuser) {
		this.osuser = osuser;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setImode(Integer imode) {
		this.imode = imode;
	}

	public void setRequest(Integer request) {
		this.request = request;
	}

	public void setBlock(Integer block) {
		this.block = block;
	}

	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}

	private Long id; // id

	private String username; // Oracle用户名

	private Long sid; // Session唯一标识

	private Long serial; // Session serial number

	private String program; // 系统程序名

	private String machine; // 系统机器名

	private String osuser; // 系统用户名

	private String type; // 锁类型

	private Integer imode; // 会话保持的锁的模式

	private Integer request; // 会话申请的锁的模式

	private Integer block; // 当前锁是否阻塞另一个锁

	private Long ctime; // 死锁时间（单位：秒）
}
