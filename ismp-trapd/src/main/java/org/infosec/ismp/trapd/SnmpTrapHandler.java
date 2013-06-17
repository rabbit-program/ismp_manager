package org.infosec.ismp.trapd;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Vector;

import org.infosec.ismp.manager.rmi.event.modle.TrapEvent;
import org.infosec.ismp.manager.rmi.event.modle.TrapEventWrapper;
import org.infosec.ismp.util.ThreadCategory;
import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.MessageDispatcherImpl;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.mp.MPv3;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.USM;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TcpAddress;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 负责接收snmpTrap的类
 * @author lianglin
 *
 */
@Component
public class SnmpTrapHandler implements CommandResponder {
	private MultiThreadedMessageDispatcher dispatcher;
	private Snmp snmp = null;
	private Address listenAddress;
	private ThreadPool threadPool;
	private TrapNodeMessageSend messageSend;

	@Autowired(required=true)
	@Qualifier(value="snmpTrapSend")
	public void setMessageSend(TrapNodeMessageSend messageSend) {
		this.messageSend = messageSend;
	}

	private  TrapNodeManager trapNodeManager;

	public SnmpTrapHandler() {
	}
	
	
	public void setTrapNodeManager(TrapNodeManager trapNodeManager) {
		this.trapNodeManager = trapNodeManager;
	}



	private void init() throws UnknownHostException, IOException {
//		Assert.state(trapNodeManager!=null,"trapNodeManager必须设置，请检查");
		threadPool = ThreadPool.create("Trap", 2);
		dispatcher = new MultiThreadedMessageDispatcher(threadPool,
				new MessageDispatcherImpl());
		listenAddress = GenericAddress.parse(System.getProperty(
				"snmp4j.listenAddress", "udp:0.0.0.0/162")); // 本地IP与监听端口
		TransportMapping transport;
		// 对TCP与UDP协议进行处理
		if (listenAddress instanceof UdpAddress) {
			transport = new DefaultUdpTransportMapping(
					(UdpAddress) listenAddress);
		} else {
			transport = new DefaultTcpTransportMapping(
					(TcpAddress) listenAddress);
		}
		snmp = new Snmp(dispatcher, transport);
		snmp.getMessageDispatcher().addMessageProcessingModel(new MPv1());
		snmp.getMessageDispatcher().addMessageProcessingModel(new MPv2c());
		snmp.getMessageDispatcher().addMessageProcessingModel(new MPv3());
		USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(
				MPv3.createLocalEngineID()), 0);
		SecurityModels.getInstance().addSecurityModel(usm);
		snmp.listen();
	}

	public void run() {
		try {
			init();
			snmp.addCommandResponder(this);
			System.out.println("开始监听Trap信息!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 实现CommandResponder的processPdu方法, 用于处理传入的请求、PDU等信息 当接收到trap时，会自动进入这个方法
	 * 
	 * @param respEvnt
	 */
	public void processPdu(CommandResponderEvent respEvnt) {
		// 解析Response
//		 System.out.println("地址是： "+respEvnt.getPeerAddress());
		Address address = respEvnt.getPeerAddress();
		String addressStr = address.toString();
		int index = addressStr.indexOf('/');
		String fromIp = addressStr.substring(0, index);
		List<TrapNode> nodes = trapNodeManager.getAllTrapNodes();
		boolean matchFlag = false;
		for (TrapNode node : nodes) {
			String ip = node.getIpAddr();
			if (fromIp.equals(ip)) {
				TrapEvent event = new TrapEvent();
				event.setMaxSizeResponsePDU(respEvnt.getMaxSizeResponsePDU());
				event.setMessageProcessingModel(respEvnt
						.getMessageProcessingModel());
				event.setPdu(respEvnt.getPDU());
				event.setPeerAddress(respEvnt.getPeerAddress());
				event.setSecurityLevel(respEvnt.getSecurityLevel());
				event.setSecurityModel(respEvnt.getSecurityModel());
				event.setSecurityName(respEvnt.getSecurityName());
				event.setTransportMapping(respEvnt.getTransportMapping());
				event.setProcessed(respEvnt.isProcessed());
				matchFlag = true;
				
				TrapEventWrapper wrapper = new TrapEventWrapper(event);
				wrapper.setIp(fromIp);
				wrapper.setNodeId(node.getNodeid());
				
				messageSend.springsend(wrapper);
				break;
			}
		}
		if (!matchFlag) {
           log().info("收到的Trap event 被抛弃");
		}
		// Constants.addTrap(event);

	}

	/**
	 * 显示解析好的事件的信息 display
	 */
	public void display(TrapEvent trap) {

		if (trap != null && trap.getPdu() != null) {
			Vector<VariableBinding> recVBs = trap.getPdu()
					.getVariableBindings();
			for (int i = 0; i < recVBs.size(); i++) {
				VariableBinding recVB = recVBs.elementAt(i);
				System.out
						.println(recVB.getOid() + " : " + recVB.getVariable());
			}
		} else {
			System.out.println("trap is null!");
		}
	}

	/**
	 * @param s把16进制转换成字符串
	 * @return
	 */
	public static String toStringHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(
						s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			s = new String(baKeyword, "gb2312");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	public static String toStringHexUtf8(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(
						s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			s = new String(baKeyword, "utf8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	public static void main(String[] args) {
		SnmpTrapHandler handler = new SnmpTrapHandler();
		handler.setTrapNodeManager(new TrapNodeManager());
		handler.run();
		while (true) {
			System.out.println("test");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
