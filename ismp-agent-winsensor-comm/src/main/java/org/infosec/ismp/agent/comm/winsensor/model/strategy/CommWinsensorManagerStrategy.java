package org.infosec.ismp.agent.comm.winsensor.model.strategy;


/**
 * @author Rocky
 * @version create time：Dec 6, 2010 2:14:01 PM
 * 
 */
public class CommWinsensorManagerStrategy extends CommBaseStrategy {

	private static final long serialVersionUID = 6761782763427219747L;
	
	private String autoUpdateUrl;		//自动更新地址
	
	private int interval;		//自动更新周期
	
	private int localInterval;		//本地自动更新周期
	
	private String entryPoint;		//更新后的入口点
	
	private int managerPort;		//管理端口
	
	private String openTime;		//端口开放时间
	
	private Boolean isAbleToStopSensor;		//是否允许用户关闭Winsensor
	
	private Boolean isAbleToStopService;		//是否允许用户关闭WinsensorService
	
	private Boolean isShowTheIcon;		//是否显示Winsensor小图标

	public String getAutoUpdateUrl() {
		return autoUpdateUrl;
	}

	public void setAutoUpdateUrl(String autoUpdateUrl) {
		this.autoUpdateUrl = autoUpdateUrl;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public int getLocalInterval() {
		return localInterval;
	}

	public void setLocalInterval(int localInterval) {
		this.localInterval = localInterval;
	}

	public String getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(String entryPoint) {
		this.entryPoint = entryPoint;
	}

	public int getManagerPort() {
		return managerPort;
	}

	public void setManagerPort(int managerPort) {
		this.managerPort = managerPort;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public Boolean getIsAbleToStopSensor() {
		return isAbleToStopSensor;
	}

	public void setIsAbleToStopSensor(Boolean isAbleToStopSensor) {
		this.isAbleToStopSensor = isAbleToStopSensor;
	}

	public Boolean getIsAbleToStopService() {
		return isAbleToStopService;
	}

	public void setIsAbleToStopService(Boolean isAbleToStopService) {
		this.isAbleToStopService = isAbleToStopService;
	}

	public Boolean getIsShowTheIcon() {
		return isShowTheIcon;
	}

	public void setIsShowTheIcon(Boolean isShowTheIcon) {
		this.isShowTheIcon = isShowTheIcon;
	}
}
