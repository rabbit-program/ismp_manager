package org.infosec.ismp.agent.winsensor.util;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.infosec.ismp.agent.comm.util.OperationConstant;
import org.infosec.ismp.agent.comm.winsensor.model.operation.Problem;
import org.infosec.ismp.agent.comm.winsensor.model.status.CPUStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.HardDiskStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.HostResource;
import org.infosec.ismp.agent.comm.winsensor.model.status.LocalARP;
import org.infosec.ismp.agent.comm.winsensor.model.status.LocalDNS;
import org.infosec.ismp.agent.comm.winsensor.model.status.LocalRouter;
import org.infosec.ismp.agent.comm.winsensor.model.status.LocalSystemStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.MemoryStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.NetworkStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.PartitionStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.ProcessStatus;
import org.infosec.ismp.agent.comm.winsensor.model.status.WinsensorClientStatus;
import org.infosec.ismp.agent.comm.winsensor.model.windowslog.WindowsLog;
import org.infosec.ismp.agent.winsensor.exception.ParseXmlException;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyBO;
import org.infosec.ismp.agent.winsensor.operation.entity.AgentDutyManagerBO;
import org.infosec.ismp.agent.winsensor.operation.entity.ProblemBO;
import org.infosec.ismp.agent.winsensor.register.WinsensorRegisterInfo;
import org.infosec.ismp.agent.winsensor.strategy.BaseStrategy;
import org.infosec.ismp.agent.winsensor.strategy.entity.HostResourceStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.RegisterStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.SoftwareUpdateStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsLogStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.WindowsUpdateStrategyBO;
import org.infosec.ismp.agent.winsensor.strategy.entity.WinsensorManagerStrategyBO;

/**
 * @author Rocky
 * @version create time：Oct 26, 2010 10:52:10 AM
 * 
 */
public class XmlParseUtil {
	
	public Document createRegisterBackStrategy(List<BaseStrategy> strategies) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("Response");
		Element winsensor = root.addElement("WinSensor");
		for (BaseStrategy strategy : strategies) {
			if (strategy instanceof HostResourceStrategyBO) {
				HostResourceStrategyBO hostResourceStrategy = (HostResourceStrategyBO) strategy;
				Element hostResourceElement = winsensor.addElement("HostResource");
				hostResourceElement.addElement("Url").setText(hostResourceStrategy.getUrl());
				hostResourceElement.addElement("Interval").setText(String.valueOf(hostResourceStrategy.getInterval()));
			} else if (strategy instanceof RegisterStrategyBO) {
				RegisterStrategyBO registerStrategy = (RegisterStrategyBO) strategy;
				Element registerElement = winsensor.addElement("Register");
				registerElement.addElement("Url").setText( registerStrategy.getUrl());
				registerElement.addElement("Interval").setText(String.valueOf(registerStrategy.getInterval()));
			} else if (strategy instanceof SoftwareUpdateStrategyBO) {
				SoftwareUpdateStrategyBO softwareUpdateStrategy = (SoftwareUpdateStrategyBO) strategy;
				Element softwareUpdateElement = winsensor.addElement("SoftwareUpdate");
				softwareUpdateElement.addElement("DIP").setText(softwareUpdateStrategy.getDIp());
				softwareUpdateElement.addElement("DPort").setText(String.valueOf(softwareUpdateStrategy.getDPort()));
				softwareUpdateElement.addElement("DInterval").setText(String.valueOf(softwareUpdateStrategy.getDInterval()));
				softwareUpdateElement.addElement("RIP").setText(softwareUpdateStrategy.getRIp());
				softwareUpdateElement.addElement("RPort").setText(String.valueOf(softwareUpdateStrategy.getRPort()));
				softwareUpdateElement.addElement("RInterval").setText(String.valueOf(softwareUpdateStrategy.getRInterval()));
			} else if (strategy instanceof WindowsLogStrategyBO) {
				WindowsLogStrategyBO windowsLogStrategy = (WindowsLogStrategyBO) strategy;
				Element windowsLogElement = winsensor.addElement("WindowsLog");
				windowsLogElement.addElement("Url").setText(windowsLogStrategy.getUrl());
				windowsLogElement.addElement("Interval").setText(String.valueOf(windowsLogStrategy.getInterval()));
				windowsLogElement.addElement("System").setText(windowsLogStrategy.getSystem().toString());
				windowsLogElement.addElement("Application").setText(windowsLogStrategy.getApplication().toString());
				windowsLogElement.addElement("Security").setText(windowsLogStrategy.getSecurity().toString());
				windowsLogElement.addElement("Information").setText(windowsLogStrategy.getInformation().toString());
				windowsLogElement.addElement("Warning").setText(windowsLogStrategy.getWarning().toString());
				windowsLogElement.addElement("Error").setText(windowsLogStrategy.getError().toString());
				windowsLogElement.addElement("ASuccess").setText(windowsLogStrategy.getASuccess().toString());
				windowsLogElement.addElement("AFailure").setText(windowsLogStrategy.getAFailure().toString());
			} else if (strategy instanceof WindowsUpdateStrategyBO) {
				WindowsUpdateStrategyBO windowsUpdateStrategy = (WindowsUpdateStrategyBO) strategy;
				Element windowsUpdateElement = winsensor.addElement("WindowsUpdate");
				windowsUpdateElement.addElement("Url").setText(windowsUpdateStrategy.getUrl());
				windowsUpdateElement.addElement("Interval").setText(String.valueOf(windowsUpdateStrategy.getInterval()));
			} else if (strategy instanceof WinsensorManagerStrategyBO) {
				WinsensorManagerStrategyBO winsensorManagerStrategy = (WinsensorManagerStrategyBO) strategy;
				Element winsensorManagerElement = winsensor.addElement("WinsensorManager");
				winsensorManagerElement.addElement("AutoUpdateUrl").setText(winsensorManagerStrategy.getAutoUpdateUrl());
				winsensorManagerElement.addElement("Interval").setText(String.valueOf(winsensorManagerStrategy.getInterval()));
				winsensorManagerElement.addElement("LocalInterval").setText(String.valueOf(winsensorManagerStrategy.getLocalInterval()));
				winsensorManagerElement.addElement("EntryPoint").setText(String.valueOf(winsensorManagerStrategy.getEntryPoint()));
				winsensorManagerElement.addElement("ManagerPort").setText(String.valueOf(winsensorManagerStrategy.getManagerPort()));
				winsensorManagerElement.addElement("OpenTime").setText(winsensorManagerStrategy.getOpenTime());
				winsensorManagerElement.addElement("IsAbleToStopSensor").setText(winsensorManagerStrategy.getIsAbleToStopSensor().toString());
				winsensorManagerElement.addElement("IsAbleToStopService").setText(winsensorManagerStrategy.getIsAbleToStopService().toString());
				winsensorManagerElement.addElement("IsShowTheIcon").setText(winsensorManagerStrategy.getIsShowTheIcon().toString());
			}
		}
	
		root.addElement("MessageID");
		return document;
	}
	

	public Document createDuty(AgentDutyManagerBO dutyManager) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("PersonOnDuty");
		root.addAttribute("beginDate", dutyManager.getBeginDate());
		root.addAttribute("endDate", dutyManager.getEndDate());
		root.addAttribute("complaintNumber", dutyManager.getComplaintNumber());
		List<AgentDutyBO> duties = dutyManager.getDuties();
		
		for (AgentDutyBO duty : duties) {
			Element person = root.addElement("Person");
			person.addAttribute("ID", String.valueOf(duty.getRemoteDutyId()));
			person.addElement("Role").setText((duty.getIsManager() == true) ? "Manager" : "Worker");
			person.addElement("Name").setText(duty.getName());
			person.addElement("Sex").setText(duty.getSex());
			person.addElement("Email").setText(duty.getEmail());
			person.addElement("WorkPhone").setText(duty.getPhone());
			person.addElement("Mobile").setText(duty.getMobilePhone());
			person.addElement("Responsibility").setText(duty.getResponsibility());
		}
		
		return document;
	}

	public Document createRemovedDuty() {
		Document document = DocumentHelper.createDocument();
		document.addElement("PersonOnDuty");
		
		return document;
	}
	
	public Document createProblemsCommitSuccessInfo(List<Problem> problems) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("LocalTroubles");
		
		for (Problem problem : problems) {
			Element trouble = root.addElement("Trouble");
			trouble.addElement("sendSuccess").setText("true");
			
			Element troubleInfo = trouble.addElement("TroubleInfo");
			troubleInfo.addElement("tid").setText(problem.getProblemId());
		}
		
		return document;
	}

	public Document createOrdersStatusChangedInfo(List<ProblemBO> problems) {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("LocalTroubles");
		SimpleDateFormat format = new SimpleDateFormat(OperationConstant.DUTY_MANAGER_DATE_FORMAT);
		
		if (problems != null && problems.size() > 0) {
			for (ProblemBO problem : problems) {
				if ((problem.getIfProblemClosed() != null) && (problem.getIfProblemClosed() == true) 
						&& (problem.getIfSendProbClosed() != null) && (problem.getIfSendProbClosed() == false)) {
					Element trouble = root.addElement("Trouble");
					trouble.addElement("isDropped").setText("true");
					Element troubleInfo = trouble.addElement("TroubleInfo");
					troubleInfo.addElement("tid").setText(problem.getProblemId());
				}
				
				if ((problem.getIfGeneratedWorkOrders() != null) && (problem.getIfGeneratedWorkOrders() == true) 
						&& (problem.getIfSendGeneWorkOrders() != null) && (problem.getIfSendGeneWorkOrders() == false)) {
					Element trouble = root.addElement("Trouble");
					trouble.addElement("isToken").setText("true");
					Element troubleInfo = trouble.addElement("TroubleInfo");
					troubleInfo.addElement("tid").setText(problem.getProblemId());
					
					Element serviceInfo = trouble.addElement("ServiceInfo");
					serviceInfo.addElement("sid").addText(problem.getWorkOrdersId());
					serviceInfo.addElement("takeTime").addText(format.format(problem.getWorkOrdersGeneTime()));
				}
				
				if ((problem.getIfWorkOrdersClosed() != null) && (problem.getIfWorkOrdersClosed() == true) 
						&& (problem.getIfSendWorkOrdersClosed() != null) && (problem.getIfSendWorkOrdersClosed() == false)) {
					Element trouble = root.addElement("Trouble");
					trouble.addElement("isReTake").setText("true");
					Element troubleInfo = trouble.addElement("TroubleInfo");
					troubleInfo.addElement("tid").setText(problem.getProblemId());
				}
				
				if ((problem.getIfWorkOrdersComplete() != null) && (problem.getIfWorkOrdersComplete() == true) 
						&& (problem.getIfSendOrdersCompleted() != null) && (problem.getIfSendOrdersCompleted() == false)) {
					Element trouble = root.addElement("Trouble");
					trouble.addElement("isDone").setText("true");
					Element troubleInfo = trouble.addElement("TroubleInfo");
					troubleInfo.addElement("tid").setText(problem.getProblemId());
				}
			}
		} else {
			root.addElement("none");
		}
		
		return document;
	}
	
	public WinsensorRegisterInfo parseWinsensorRegisterInfo(InputStream inputStream) throws ParseXmlException{
		WinsensorRegisterInfo registerInfo = null;
		SAXReader reader = new SAXReader();
		reader.setEncoding("UTF-8");
		try {
			Document document = reader.read(inputStream);
			Element root = document.getRootElement();
			String rootName = root.getName();
			if (rootName.equalsIgnoreCase("Request")) {
				registerInfo = new WinsensorRegisterInfo();
				
				Node registerNode = root.selectSingleNode("Register");
				registerInfo.setSensorId(registerNode.selectSingleNode("SensorID").getText());
				registerInfo.setIp(registerNode.selectSingleNode("Ip").getText());
				registerInfo.setMac(registerNode.selectSingleNode("Mac").getText());
				registerInfo.setActiveTime(registerNode.selectSingleNode("AliveTime").getText());
				registerInfo.setName(registerNode.selectSingleNode("Name").getText());
				registerInfo.setWorkGroup(registerNode.selectSingleNode("WorkGroup").getText());
				registerInfo.setWinsensorVersion(registerNode.selectSingleNode("WinSensorVersion").getText());
				registerInfo.setWinsensorServiceVersion(registerNode.selectSingleNode("WinSensorServiceVersion").getText());
			}
		} catch (DocumentException e) {
			throw new ParseXmlException("Parse register info error: " + e.getMessage());
		}
		
		return registerInfo;
	}
	
	
	public String parseDutyConnection(InputStream inputStream) {
		SAXReader reader = new SAXReader();
		reader.setEncoding("UTF-8");
		String sensorId = "";
		
		try {
			Document document = reader.read(inputStream);
			Element root = document.getRootElement();
			String rootName = root.getName();
			
			if (rootName.equalsIgnoreCase("Duty")) {
				sensorId = root.selectSingleNode("SID").getText();
			}
			
		} catch (DocumentException e) {
			throw new ParseXmlException("Parse duty connection error: " + e.getMessage());
		}
		
		return sensorId;
	}

	public Document parseProblemConnection(InputStream inputStream) {
		SAXReader reader = new SAXReader();
		
		reader.setEncoding("UTF-8");
		Document document = null;
		
		try {
			document = reader.read(inputStream);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return document;
	}
	
	@SuppressWarnings("unchecked")
	public Boolean parseIfCommitProblems(Document document) {
		
		Element root = document.getRootElement();
		String rootName = root.getName();
		
		if (rootName.equalsIgnoreCase("LocalTroubles")) {
			List<Node> nodes = root.selectNodes("Trouble");
			
			if (nodes.size() > 0) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<Problem> parseOperationProblems(Document document) {
		List<Problem> problems = new ArrayList<Problem>();
		Element root = document.getRootElement();
		
		String sensorId = root.selectSingleNode("sensorID").getText();
		List<Node> nodes = root.selectNodes("Trouble");
		Iterator<Node> iterator = nodes.iterator();
		
		while (iterator.hasNext()) {
			Node node = iterator.next();
			
			Node troubleInfoNode = node.selectSingleNode("TroubleInfo");
			String title = troubleInfoNode.selectSingleNode("title").getText();
			String problemId = troubleInfoNode.selectSingleNode("tid").getText();
			String createTime = troubleInfoNode.selectSingleNode("submitTime").getText();
			String detail = troubleInfoNode.selectSingleNode("detail").getText();
			
			Node userInfoNode = node.selectSingleNode("UserInfo");
			String userName = userInfoNode.selectSingleNode("userName").getText();
			String workPhone = userInfoNode.selectSingleNode("workPhone").getText();
			String email = userInfoNode.selectSingleNode("email").getText();
			String mobile = userInfoNode.selectSingleNode("mobile").getText();
			String qq = userInfoNode.selectSingleNode("qq").getText();
			String msn = userInfoNode.selectSingleNode("msn").getText();
			String serviceAddress = userInfoNode.selectSingleNode("serviceAddress").getText();
			
			Problem problem = new Problem();
			problem.setSensorId(sensorId);
			problem.setProblemId(problemId);
			problem.setTitle(title);
			problem.setDescription(detail);
			problem.setContact(userName);
			String contactAddress = ((StringUtils.isBlank(workPhone) == true) ? "" : ("Work Phone: " + workPhone)) + 
			((StringUtils.isBlank(mobile) == true) ? "" : ("Mobile Phone: " + mobile)) + 
			((StringUtils.isBlank(qq) == true) ? "" : ("QQ: " + qq)) + 
			((StringUtils.isBlank(msn) == true) ? "" : ("MSN: " + msn)) + 
			((StringUtils.isBlank(email) == true) ? "" : ("Mobile Phone: " + email));
			problem.setContactAddress(contactAddress);
			problem.setServiceAddress(serviceAddress);
			problem.setCreateTime(createTime);
			
			problems.add(problem);
		}
		
		return problems;
	}
	
	public String parseOperationWorkOrdersSensorId(Document document) {
		String sensorId = "";
		Element root = document.getRootElement();
		String rootName = root.getName();
		
		if (rootName.equalsIgnoreCase("LocalTroubles")) {
			sensorId = root.selectSingleNode("sensorID").getText();
		}
		
		return sensorId;
	}
	
	public List<WindowsLog> parseWindowsLog(InputStream inputStream) throws ParseXmlException {
		List<WindowsLog> value = new ArrayList<WindowsLog>();
		SAXReader reader = new SAXReader();
		reader.setEncoding("UTF-8");
		
		try {
			Document document = reader.read(inputStream);
			Element root = document.getRootElement();
			String rootName = root.getName();
			String sensorId = root.selectSingleNode("SID").getText();
			String sensorIp = root.selectSingleNode("IP").getText();
			
			if (rootName.equalsIgnoreCase("WLog")) {
				parseWindowsLogRootInfo(root, "Sys", "systemLog", value, sensorId, sensorIp);
				parseWindowsLogRootInfo(root, "App", "applicationLog", value, sensorId, sensorIp);
				parseWindowsLogRootInfo(root, "Sec", "security", value, sensorId, sensorIp);
			}
		} catch (DocumentException e) {
			throw new ParseXmlException("Parse windowsLog info error: " + e.getMessage());
		} 
		
		return value;
	}
	
	@SuppressWarnings("unchecked")
	public List<WindowsLog> parseWindowsLogRootInfo(Element root, String nodeName, String logCatigory, 
			List<WindowsLog> value, String sensorId, String sensorIp) {
		List<Node> appNodes = root.selectNodes(nodeName);
		Iterator<Node> appIterator = appNodes.iterator();
		while (appIterator.hasNext()) {
			Node node = appIterator.next();
			WindowsLog windowsLog = new WindowsLog();
			windowsLog.setSensorId(sensorId);
			windowsLog.setSensorIp(sensorIp);
			windowsLog.setLogCatigory(logCatigory);
			windowsLog.setType(node.selectSingleNode("t").getText());
			
			String originalDate = node.selectSingleNode("d").getText();
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = null;
			
			try {
				date = format.parse(originalDate);
			} catch (ParseException e) {
				format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				try {
					date = format.parse(originalDate);
				} catch (ParseException e1) {
					System.out.println("Please check date format, original d is: " + originalDate);
				}
			}
			windowsLog.setDate(date);
			
			windowsLog.setSource(node.selectSingleNode("s").getText());
			windowsLog.setCatigories(node.selectSingleNode("c").getText());
			windowsLog.setId(node.selectSingleNode("id").getText());
			windowsLog.setUsers(node.selectSingleNode("un").getText());
			windowsLog.setComputer(node.selectSingleNode("mn").getText());
			windowsLog.setMessage(node.selectSingleNode("msg").getText());
			value.add(windowsLog);
		}
		
		return value;
	}
	
	/*
	 * Parse XML file, which contains basic information about sensor clients and client machine. 
	 * When the XML format changes, the need to rewrite the current method.
	 */
	@SuppressWarnings("unchecked")
	public HostResource parseHostResource(InputStream inputStream) throws ParseXmlException{
		SAXReader reader = new SAXReader();
		reader.setEncoding("UTF-8");
		HostResource hostResource = null;
		
		try {
			Document document = reader.read(inputStream);
			Element root = document.getRootElement();
			String rootName = root.getName();
			if (rootName.equalsIgnoreCase("HostResource")) {
				hostResource = new HostResource();
				
				//parse CPU info.
				CPUStatus cpuStatus = new CPUStatus();
				Node cpuNode = root.selectSingleNode("CPU");
				List<Node> usePres = cpuNode.selectNodes("usePre");
				Integer loads[] = new Integer[usePres.size()];
				for (int i = 0; i < loads.length; i++) {
					loads[i] = new Integer(usePres.get(i).getText());
				}
				cpuStatus.setLoads(loads);
				hostResource.setCpuStatus(cpuStatus);
				
				//parse memory info.
				MemoryStatus memoryStatus = new MemoryStatus();
				Node memoryNode = root.selectSingleNode("Memory");
				memoryStatus.setSize(new Long(memoryNode.selectSingleNode("total").getText()));
				memoryStatus.setUsed(new Long(memoryNode.selectSingleNode("use").getText()));
				hostResource.setMemoryStatus(memoryStatus);
				
				//parse network info.
				List<NetworkStatus> networkStatuses = new ArrayList<NetworkStatus>();
				List<Node> networkNodes = root.selectNodes("Network");
				Iterator<Node> iterator = networkNodes.iterator();
				while (iterator.hasNext()) {
					Node networkNode = iterator.next();
					NetworkStatus networkStatus = new NetworkStatus();
					
					String description = networkNode.selectSingleNode("description").getText();
					networkStatus.setDescription(description);
					String originalIpAddress = networkNode.selectSingleNode("ipAddress").getText();
					String[] ipAddress = originalIpAddress.split("\\|");
					networkStatus.setIpAddress(ipAddress);
					String originalIpSubnet = networkNode.selectSingleNode("ipSubnet").getText();
					String[] ipSubnet = originalIpSubnet.split("\\|");
					networkStatus.setIpSubnet(ipSubnet);
					String originalGateway = networkNode.selectSingleNode("gateway").getText();
					String[] gateway = originalGateway.split("\\|");
					networkStatus.setGateway(gateway);
					String mac = networkNode.selectSingleNode("mac").getText();
					networkStatus.setMac(mac);
					String originalDns = networkNode.selectSingleNode("dns").getText();
					String[] dns = originalDns.split("\\|");
					networkStatus.setDns(dns);
					Double bandWidth = new Double(networkNode.selectSingleNode("bandWidth").getText());
					networkStatus.setBandWidth(bandWidth);
					Boolean iPEnabled = Boolean.valueOf(networkNode.selectSingleNode("ipEnabled").getText());
					networkStatus.setIPEnabled(iPEnabled);
					Long recPacket = new Long(networkNode.selectSingleNode("recPacket").getText());
					networkStatus.setRecPacket(recPacket);
					Long sendPacket = new Long(networkNode.selectSingleNode("sendPacket").getText());
					networkStatus.setSendPacket(sendPacket);
					Long recBytesPreSec = new Long(networkNode.selectSingleNode("recBytesPreSec").getText());
					networkStatus.setRecBytesPreSec(recBytesPreSec);
					Long sendBytesPreSec = new Long(networkNode.selectSingleNode("sendBytesPreSec").getText());
					networkStatus.setSendBytesPreSec(sendBytesPreSec);
					
					networkStatuses.add(networkStatus);
				}
				hostResource.setNetworkStatus(networkStatuses);
				
				//parse hardDisk info.
				List<HardDiskStatus> hardDiskStatuses = new ArrayList<HardDiskStatus>();
				List<Node> hardDiskNodes = root.selectNodes("Disk");
				iterator = hardDiskNodes.iterator();
				while (iterator.hasNext()) {
					Node hardDiskNode = iterator.next();
					HardDiskStatus hardDiskStatus = new HardDiskStatus();

					String model = hardDiskNode.selectSingleNode("model").getText();
					hardDiskStatus.setModel(model);
					String interfaceType = hardDiskNode.selectSingleNode("interfaceType").getText();
					hardDiskStatus.setInterfaceType(interfaceType);
					Long size = new Long(hardDiskNode.selectSingleNode("totalSize").getText());
					hardDiskStatus.setSize(size);
					long usedSize = 0;
					
					List<PartitionStatus> partitionStatuses = new ArrayList<PartitionStatus>();
					List<Node> diskAreaNodes = hardDiskNode.selectNodes("DiskArea");
					Iterator<Node> it = diskAreaNodes.iterator();
					while (it.hasNext()) {
						Node diskAreaNode = it.next();
						PartitionStatus partitionStatus = new PartitionStatus();
						
						String name = diskAreaNode.selectSingleNode("name").getText();
						partitionStatus.setName(name);
						Long partitionSize = new Long(diskAreaNode.selectSingleNode("size").getText());
						partitionStatus.setSize(partitionSize);
						Long partitionUsedSize = new Long(diskAreaNode.selectSingleNode("use").getText());
						partitionStatus.setUsed(partitionUsedSize);
						usedSize = usedSize + partitionUsedSize.longValue();
						String fileSystem = diskAreaNode.selectSingleNode("fileSystem").getText();
						partitionStatus.setFileSystem(fileSystem);
						
						partitionStatuses.add(partitionStatus);
					}
					hardDiskStatus.setPartitionStatus(partitionStatuses);
					hardDiskStatus.setUsed(Long.valueOf(usedSize));
					
					hardDiskStatuses.add(hardDiskStatus);
				}
				hostResource.setHardDiskStatus(hardDiskStatuses);
				
				//parse process info.
				List<ProcessStatus> processStatuses = new ArrayList<ProcessStatus>();
				List<Node> processNodes = root.selectNodes("Process");
				iterator = processNodes.iterator();
				while (iterator.hasNext()) {
					Node processNode = iterator.next();
					ProcessStatus processStatus = new ProcessStatus();
					
					String pid = processNode.selectSingleNode("pid").getText();
					processStatus.setPid(pid);
					String name = processNode.selectSingleNode("name").getText();
					processStatus.setName(name);
					String path = processNode.selectSingleNode("path").getText();
					processStatus.setRunPath(path);
					String description = processNode.selectSingleNode("description").getText();
					processStatus.setDescription(description);
					Long useMemory = new Long(processNode.selectSingleNode("useMemory").getText());
					processStatus.setAllocatedMemorySize(useMemory);
					Long useCPU = new Long(processNode.selectSingleNode("useCPU").getText());
					processStatus.setConsumedCPUTime(useCPU);
					
					processStatuses.add(processStatus);
				}
				hostResource.setProcessStatus(processStatuses);
				
				//parse client machine basic info.
				LocalSystemStatus localSystemStatus = new LocalSystemStatus();
				Node localSystemNode = root.selectSingleNode("LocalSystem");
				localSystemStatus.setPhyInfo(localSystemNode.selectSingleNode("phyInfo").getText());
				//TODO In sensor client new version can open this code.
//				localSystemStatus.setOsInfo(localSystemNode.selectSingleNode("osInfo").getText());
				localSystemStatus.setRegistry(localSystemNode.selectSingleNode("registry").getText());
				localSystemStatus.setDescription(localSystemNode.selectSingleNode("description").getText());
				localSystemStatus.setComputerName(localSystemNode.selectSingleNode("computerName").getText());
				localSystemStatus.setUserName(localSystemNode.selectSingleNode("userName").getText());
				localSystemStatus.setDomain(localSystemNode.selectSingleNode("domain").getText());
				localSystemStatus.setAliveTime(localSystemNode.selectSingleNode("aliveTime").getText());
				
				List<LocalDNS> localDNSes = new ArrayList<LocalDNS>();
				List<Node> localDNSNodes = localSystemNode.selectNodes("localDNS");
				Iterator<Node> iteratorDNS = localDNSNodes.iterator();
				while (iteratorDNS.hasNext()) {
					Node localDNSNode = iteratorDNS.next();
					LocalDNS localDNS = new LocalDNS();
					
					localDNS.setDomain(localDNSNode.selectSingleNode("domain").getText()	);
					localDNS.setIp(localDNSNode.selectSingleNode("ip").getText());
					
					localDNSes.add(localDNS);
				}
				localSystemStatus.setLocalDNS(localDNSes);
				
				List<LocalRouter> localRouters = new ArrayList<LocalRouter>();
				List<Node> localRouterNodes = localSystemNode.selectNodes("localRouter");
				Iterator<Node> iteratorRouter = localRouterNodes.iterator();
				while (iteratorRouter.hasNext()) {
					Node localRouterNode = iteratorRouter.next();
					LocalRouter localRouter = new LocalRouter();
					
					localRouter.setDestination(localRouterNode.selectSingleNode("destination").getText());
					localRouter.setNetMask(localRouterNode.selectSingleNode("netMask").getText());
					localRouter.setGateway(localRouterNode.selectSingleNode("gateway").getText());
					localRouter.setMetric(localRouterNode.selectSingleNode("metric").getText());
					
					localRouters.add(localRouter);
				}
				localSystemStatus.setLocalRouter(localRouters);
				
				List<LocalARP> localARPs = new ArrayList<LocalARP>();
				List<Node> localARPNodes = localSystemNode.selectNodes("localARP");
				Iterator<Node> iteratorARP = localARPNodes.iterator();
				while (iteratorARP.hasNext()) {
					Node localARPNode = iteratorARP.next();
					LocalARP localARP = new LocalARP();
					
					localARP.setLocalIp(localARPNode.selectSingleNode("localIp").getText());
					localARP.setIp(localARPNode.selectSingleNode("ip").getText());
					localARP.setMac(localARPNode.selectSingleNode("mac").getText());
					localARP.setType(localARPNode.selectSingleNode("type").getText());
					
					localARPs.add(localARP);
				}
				localSystemStatus.setLocalARP(localARPs);
				hostResource.setLocalSystemlStatus(localSystemStatus);
				
				//parse client basic info.
				WinsensorClientStatus winsensorClientStatus = new WinsensorClientStatus();
				Node winsensorNode = root.selectSingleNode("WinSensor");
				winsensorClientStatus.setSensorId(winsensorNode.selectSingleNode("sensorID").getText());
				winsensorClientStatus.setVersion(winsensorNode.selectSingleNode("version").getText());
				winsensorClientStatus.setServiceVersion(winsensorNode.selectSingleNode("serviceVersion").getText());
				String lastUpdateTimeStr = winsensorNode.selectSingleNode("lastUpdateTime").getText();
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date lastUpdateTime = null;
				try {
					lastUpdateTime = format.parse(lastUpdateTimeStr);
				} catch (ParseException e) {
					format = new SimpleDateFormat("yyyy/MM/dd");
					try {
						lastUpdateTime = format.parse(lastUpdateTimeStr);
					} catch (ParseException e1) {
						System.out.println("Please check date format, original lastUpdateTime is: " + lastUpdateTimeStr);
					}
				}
				winsensorClientStatus.setLastUpdateTime(lastUpdateTime);
				winsensorClientStatus.setAutoUpdateUrl(winsensorNode.selectSingleNode("autoUpdateUrl").getText());
				
				hostResource.setWinsensorClientStatus(winsensorClientStatus);
			}
		} catch (DocumentException e) {
			throw new ParseXmlException("Parse hostResource info error: " + e.getMessage());
		}
		
		return hostResource;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String ip ="192.168.9.166";
		String[] ips = ip.split("\\|");
		for (int i = 0; i < ips.length; i++) {
			System.out.println(ips[i]);
		}
		
		String dateStr = "2008/09/05";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			format = new SimpleDateFormat("yyyy/MM/dd");
			try {
				date = format.parse(dateStr);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
//		System.out.println(format.format(date));
		
		String originalDate = "2010-1-7 9:54:04";
		format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			date = format.parse(originalDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(format.format(date));
		
	}
}
