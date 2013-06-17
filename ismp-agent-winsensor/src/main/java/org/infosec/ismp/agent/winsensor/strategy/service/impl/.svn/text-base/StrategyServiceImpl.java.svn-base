package org.infosec.ismp.agent.winsensor.strategy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommBaseStrategy;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommHostResourceStrategy;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommRegisterStrategy;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommSoftwareUpdateStrategy;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommWindowsLogStrategy;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommWindowsUpdateStrategy;
import org.infosec.ismp.agent.comm.winsensor.model.strategy.CommWinsensorManagerStrategy;
import org.infosec.ismp.agent.winsensor.entity.WinsensorDeviceBO;
import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;
import org.infosec.ismp.agent.winsensor.strategy.entity.HostResourceStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.RegisterStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.SoftwareUpdateStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsLogStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsUpdateStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.WinsensorManagerStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.service.HostResourceStrategyService;
import org.infosec.ismp.agent.winsensor.strategy.service.RegisterStrategyService;
import org.infosec.ismp.agent.winsensor.strategy.service.SoftwareUpdateStrategyService;
import org.infosec.ismp.agent.winsensor.strategy.service.StrategyService;
import org.infosec.ismp.agent.winsensor.strategy.service.WindowsLogStrategyService;
import org.infosec.ismp.agent.winsensor.strategy.service.WindowsUpdateStrategyService;
import org.infosec.ismp.agent.winsensor.strategy.service.WinsensorManagerStrategyService;

/**
 * @author Rocky
 * @version create time：Oct 21, 2010 6:36:24 PM
 * 
 */
public class StrategyServiceImpl implements StrategyService {
	
	private HostResourceStrategyService hostResourceStrategyService;
	
	private RegisterStrategyService registerStrategyService;
	
	private SoftwareUpdateStrategyService softwareUpdateStrategyService;
	
	private WindowsLogStrategyService windowsLogStrategyService;
	
	private WindowsUpdateStrategyService windowsUpdateStrategyService;
	
	private WinsensorManagerStrategyService winsensorManagerStrategyService;
	
	private String agentIp;
	
	private String windowsLogPath;
	
	private String windowsLogPort;
	
	@Override
	public void addStrategy(List<CommBaseStrategy> strategies) {
		for (CommBaseStrategy commStrategy : strategies) {
			if (commStrategy instanceof CommHostResourceStrategy) {
				HostResourceStrategyBO strategy = new HostResourceStrategyBO();
				
				strategy.setUrl(((CommHostResourceStrategy) commStrategy).getUrl());
				strategy.setInterval(((CommHostResourceStrategy) commStrategy).getInterval());
				
				strategy.setCreateTime(commStrategy.getCreateTime());
				strategy.setIp(commStrategy.getIp());
				strategy.setSensorId(commStrategy.getSensorId());
				strategy.setRemoteId(commStrategy.getRemoteId());
				
				hostResourceStrategyService.addStrategy((HostResourceStrategyBO) strategy);
			} else if (commStrategy instanceof CommRegisterStrategy) {
				RegisterStrategyBO strategy = new RegisterStrategyBO();
				
				strategy.setUrl(((CommRegisterStrategy) commStrategy).getUrl());
				strategy.setInterval(((CommRegisterStrategy) commStrategy).getInterval());
				
				strategy.setCreateTime(commStrategy.getCreateTime());
				strategy.setIp(commStrategy.getIp());
				strategy.setSensorId(commStrategy.getSensorId());
				strategy.setRemoteId(commStrategy.getRemoteId());
				
				registerStrategyService.addStrategy((RegisterStrategyBO) strategy);
			} else if (commStrategy instanceof CommSoftwareUpdateStrategy) {
				SoftwareUpdateStrategyBO strategy = new SoftwareUpdateStrategyBO();
				
				strategy.setDIp(((CommSoftwareUpdateStrategy) commStrategy).getDIp());
				strategy.setDPort(((CommSoftwareUpdateStrategy) commStrategy).getDPort());
				strategy.setDInterval(((CommSoftwareUpdateStrategy) commStrategy).getDInterval());
				strategy.setRIp(((CommSoftwareUpdateStrategy) commStrategy).getRIp());
				strategy.setRPort(((CommSoftwareUpdateStrategy) commStrategy).getRPort());
				strategy.setRInterval(((CommSoftwareUpdateStrategy) commStrategy).getRInterval());
				
				strategy.setCreateTime(commStrategy.getCreateTime());
				strategy.setIp(commStrategy.getIp());
				strategy.setSensorId(commStrategy.getSensorId());
				strategy.setRemoteId(commStrategy.getRemoteId());
				
				softwareUpdateStrategyService.addStrategy((SoftwareUpdateStrategyBO) strategy);
			} else if (commStrategy instanceof CommWindowsLogStrategy) {
				WindowsLogStrategyBO strategy = new WindowsLogStrategyBO();
				
				String url = ((CommWindowsLogStrategy) commStrategy).getUrl();
				if (StringUtils.isBlank(url)) {
					url = "http://" + agentIp + ":" + windowsLogPort + windowsLogPath;
				}
				strategy.setUrl(url);
				strategy.setInterval(((CommWindowsLogStrategy) commStrategy).getInterval());
				strategy.setSystem(((CommWindowsLogStrategy) commStrategy).getSystem());
				strategy.setApplication(((CommWindowsLogStrategy) commStrategy).getApplication());
				strategy.setSecurity(((CommWindowsLogStrategy) commStrategy).getSecurity());
				strategy.setInformation(((CommWindowsLogStrategy) commStrategy).getInformation());
				strategy.setWarning(((CommWindowsLogStrategy) commStrategy).getWarning());
				strategy.setError(((CommWindowsLogStrategy) commStrategy).getError());
				strategy.setASuccess(((CommWindowsLogStrategy) commStrategy).getASuccess());
				strategy.setAFailure(((CommWindowsLogStrategy) commStrategy).getAFailure());
				
				strategy.setCreateTime(commStrategy.getCreateTime());
				strategy.setIp(commStrategy.getIp());
				strategy.setSensorId(commStrategy.getSensorId());
				strategy.setRemoteId(commStrategy.getRemoteId());
				
				windowsLogStrategyService.addStrategy((WindowsLogStrategyBO) strategy);
			} else if (commStrategy instanceof CommWindowsUpdateStrategy) {
				WindowsUpdateStrategyBO strategy = new WindowsUpdateStrategyBO();
				
				strategy.setUrl(((CommWindowsUpdateStrategy) commStrategy).getUrl());
				strategy.setInterval(((CommWindowsUpdateStrategy) commStrategy).getInterval());
				
				strategy.setCreateTime(commStrategy.getCreateTime());
				strategy.setIp(commStrategy.getIp());
				strategy.setSensorId(commStrategy.getSensorId());
				strategy.setRemoteId(commStrategy.getRemoteId());
				
				windowsUpdateStrategyService.addStrategy((WindowsUpdateStrategyBO) strategy);
			} else if (commStrategy instanceof CommWinsensorManagerStrategy) {
				WinsensorManagerStrategyBO strategy = new WinsensorManagerStrategyBO();
				
				strategy.setAutoUpdateUrl(((CommWinsensorManagerStrategy) commStrategy).getAutoUpdateUrl());
				strategy.setInterval(((CommWinsensorManagerStrategy) commStrategy).getInterval());
				strategy.setLocalInterval(((CommWinsensorManagerStrategy) commStrategy).getLocalInterval());
				strategy.setEntryPoint(((CommWinsensorManagerStrategy) commStrategy).getEntryPoint());
				strategy.setManagerPort(((CommWinsensorManagerStrategy) commStrategy).getManagerPort());
				strategy.setOpenTime(((CommWinsensorManagerStrategy) commStrategy).getOpenTime());
				strategy.setIsAbleToStopSensor(((CommWinsensorManagerStrategy) commStrategy).getIsAbleToStopSensor());
				strategy.setIsAbleToStopService(((CommWinsensorManagerStrategy) commStrategy).getIsAbleToStopService());
				strategy.setIsShowTheIcon(((CommWinsensorManagerStrategy) commStrategy).getIsShowTheIcon());
				
				strategy.setCreateTime(commStrategy.getCreateTime());
				strategy.setIp(commStrategy.getIp());
				strategy.setSensorId(commStrategy.getSensorId());
				strategy.setRemoteId(commStrategy.getRemoteId());
				
				winsensorManagerStrategyService.addStrategy((WinsensorManagerStrategyBO) strategy);
			}
		}
	}

	@Override
	public List<BaseStrategy> getAllTypeUnissuedStrategy(WinsensorDeviceBO device) {
		List<BaseStrategy> strategies = new ArrayList<BaseStrategy>();
		HostResourceStrategyBO hostResourceStrategy = hostResourceStrategyService.findStrategy(
				device.getIpAddress(), device.getSensorId(), false);
		if (hostResourceStrategy != null) {
			strategies.add(hostResourceStrategy);
		}
		RegisterStrategyBO registerStrategy = registerStrategyService.findStrategy(
				device.getIpAddress(), device.getSensorId(), false);
		if (registerStrategy != null) {
			strategies.add(registerStrategy);
		}
		SoftwareUpdateStrategyBO softwareUpdateStrategy = softwareUpdateStrategyService.findStrategy(
				device.getIpAddress(), device.getSensorId(), false);
		if (softwareUpdateStrategy != null) {
			strategies.add(softwareUpdateStrategy);
		}
		WindowsLogStrategyBO windowsLogStrategy = windowsLogStrategyService.findStrategy(
				device.getIpAddress(), device.getSensorId(), false);
		if (windowsLogStrategy != null) {
			strategies.add(windowsLogStrategy);
		}
		WindowsUpdateStrategyBO windowsUpdateStrategy = windowsUpdateStrategyService.findStrategy(
				device.getIpAddress(), device.getSensorId(), false);
		if (windowsUpdateStrategy != null) {
			strategies.add(windowsUpdateStrategy);
		}
		WinsensorManagerStrategyBO winsensorManagerStrategy = winsensorManagerStrategyService.findStrategy(
				device.getIpAddress(), device.getSensorId(), false);
		if (winsensorManagerStrategy != null) {
			strategies.add(winsensorManagerStrategy);
		}
		
		return strategies;
	}

	@Override
	public Map<String, List<BaseStrategy>> getAllTypeUnissuedStrategy(
			List<String> sensorIds) {
		List<BaseStrategy> allStrategy = new ArrayList<BaseStrategy>();
		allStrategy.addAll(hostResourceStrategyService.findAllUnissuedStrategy());
		allStrategy.addAll(registerStrategyService.findAllUnissuedStrategy());
		allStrategy.addAll(softwareUpdateStrategyService.findAllUnissuedStrategy());
		allStrategy.addAll(windowsLogStrategyService.findAllUnissuedStrategy());
		allStrategy.addAll(windowsUpdateStrategyService.findAllUnissuedStrategy());
		allStrategy.addAll(winsensorManagerStrategyService.findAllUnissuedStrategy());
		
		Map<String, List<BaseStrategy>> temp = new HashMap<String, List<BaseStrategy>>();
		for (int i = 0; i < allStrategy.size(); i++) {
			String sensorId = allStrategy.get(i).getSensorId();
			if (sensorIds.contains(sensorId)) {
				if (temp.containsKey(sensorId)) {
					temp.get(sensorId).add(allStrategy.get(i));
				} else {
					List<BaseStrategy> strategy = new ArrayList<BaseStrategy>();
					strategy.add(allStrategy.get(i));
					temp.put(sensorId, strategy);
				}
			}
		}
		
		return temp;
	}

	@Override
	public void updateStrategy(List<BaseStrategy> strategies) {
		for (BaseStrategy strategy : strategies) {
			if (strategy instanceof HostResourceStrategyBO) {
				hostResourceStrategyService.updateStrategy((HostResourceStrategyBO) strategy);
			} else if (strategy instanceof RegisterStrategyBO) {
				registerStrategyService.updateStrategy((RegisterStrategyBO) strategy);
			} else if (strategy instanceof SoftwareUpdateStrategyBO) {
				softwareUpdateStrategyService.updateStrategy((SoftwareUpdateStrategyBO) strategy);
			} else if (strategy instanceof WindowsLogStrategyBO) {
				windowsLogStrategyService.updateStrategy((WindowsLogStrategyBO) strategy);
			} else if (strategy instanceof WindowsUpdateStrategyBO) {
				windowsUpdateStrategyService.updateStrategy((WindowsUpdateStrategyBO) strategy);
			} else if (strategy instanceof WinsensorManagerStrategyBO) {
				winsensorManagerStrategyService.updateStrategy((WinsensorManagerStrategyBO) strategy);
			}
		}
	}

	public HostResourceStrategyService getHostResourceStrategyService() {
		return hostResourceStrategyService;
	}

	public void setHostResourceStrategyService(
			HostResourceStrategyService hostResourceStrategyService) {
		this.hostResourceStrategyService = hostResourceStrategyService;
	}

	public RegisterStrategyService getRegisterStrategyService() {
		return registerStrategyService;
	}

	public void setRegisterStrategyService(
			RegisterStrategyService registerStrategyService) {
		this.registerStrategyService = registerStrategyService;
	}

	public SoftwareUpdateStrategyService getSoftwareUpdateStrategyService() {
		return softwareUpdateStrategyService;
	}

	public void setSoftwareUpdateStrategyService(
			SoftwareUpdateStrategyService softwareUpdateStrategyService) {
		this.softwareUpdateStrategyService = softwareUpdateStrategyService;
	}

	public WindowsLogStrategyService getWindowsLogStrategyService() {
		return windowsLogStrategyService;
	}

	public void setWindowsLogStrategyService(
			WindowsLogStrategyService windowsLogStrategyService) {
		this.windowsLogStrategyService = windowsLogStrategyService;
	}

	public WindowsUpdateStrategyService getWindowsUpdateStrategyService() {
		return windowsUpdateStrategyService;
	}

	public void setWindowsUpdateStrategyService(
			WindowsUpdateStrategyService windowsUpdateStrategyService) {
		this.windowsUpdateStrategyService = windowsUpdateStrategyService;
	}

	public WinsensorManagerStrategyService getWinsensorManagerStrategyService() {
		return winsensorManagerStrategyService;
	}

	public void setWinsensorManagerStrategyService(
			WinsensorManagerStrategyService winsensorManagerStrategyService) {
		this.winsensorManagerStrategyService = winsensorManagerStrategyService;
	}

	public String getAgentIp() {
		return agentIp;
	}

	public void setAgentIp(String agentIp) {
		this.agentIp = agentIp;
	}

	public String getWindowsLogPath() {
		return windowsLogPath;
	}

	public void setWindowsLogPath(String windowsLogPath) {
		this.windowsLogPath = windowsLogPath;
	}

	public String getWindowsLogPort() {
		return windowsLogPort;
	}

	public void setWindowsLogPort(String windowsLogPort) {
		this.windowsLogPort = windowsLogPort;
	}
}
