/**
 * 
 */
package org.infosec.ismp.manager.server.event.analytic.trap;

import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.manager.rmi.event.modle.NormalizedEvent;
import org.infosec.ismp.manager.rmi.event.modle.TrapEvent;
import org.infosec.ismp.manager.server.event.EventTrapReceive;
import org.infosec.ismp.manager.server.event.analytic.trap.digester.TrapBinding;
import org.infosec.ismp.manager.server.event.analytic.trap.digester.TrapMatcher;
import org.infosec.ismp.manager.server.event.analytic.trap.digester.TrapParser;
import org.infosec.ismp.manager.server.event.analytic.trap.digester.TrapParsers;
import org.infosec.ismp.manager.server.event.analytic.trap.digester.TrapTransform;
import org.infosec.ismp.manager.server.event.util.Constants;
import org.snmp4j.smi.VariableBinding;
import org.springframework.stereotype.Component;

/**
 * @author 林超
 * 
 * @date {@link MultiThreadedTrapReceiver}
 * 
 */
@Component
public class MultiThreadedTrapReceiver implements EventTrapReceive {

	protected final Log log = LogFactory.getLog(getClass());

	private IDSTrapAssemble idsTrapAssemble;// 用于处理IDS数据

	public void setIdsTrapAssemble(IDSTrapAssemble idsTrapAssemble) {
		this.idsTrapAssemble = idsTrapAssemble;
	}

	int firewallCount = 0;

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 标准化事件格式

	Vector<NormalizedEvent> batch = new Vector<NormalizedEvent>(); // 实例化一个存放解析并进行归一化后的事件向量

	// List<NormalizedEvent> eventBatch = new ArrayList<NormalizedEvent>();
	//    
	// private EventSender sendEvent = new EventSenderImpl();
	//    
	// public static final int MANAGER_EVENT_FLAG = 21;

	URL input;
	URL rules;

	/**
     * 
     */
	public MultiThreadedTrapReceiver() {
		ClassLoader c = MultiThreadedTrapReceiver.class.getClassLoader();
		input = c.getResource("trap.xml");
		rules = c.getResource("trap_rule.xml");
	}

	private int sumEvent = 0;
	private long sumStartTime = 0;

	/**
	 * 运行监听接收trap程序，同时进行对trap的解析，采用digester方式 run
	 */
	public synchronized void trapAnalytic(TrapEvent trap, String domainId,
			String nodeId, String ip) {

		if (sumStartTime == 0) {
			sumStartTime = System.currentTimeMillis();
		}
//		System.out
//				.println("----MultiThreadedTrapReceiver.trapAnalytic(Integer agentId,Vector<TrapEvent> traps)------");
		/**
		 * 存放要解析的事件
		 */
		Map<String, TrapParser> trapParserMap = new HashMap<String, TrapParser>();

		// PrintWriter log;
		// String logFile = "log/audit_trap_error.log";
		// try {
		// log = new PrintWriter(new FileWriter(logFile, true), true);
		// } catch (IOException e) {
		// System.err.println("error exception: " + logFile);
		// log = new PrintWriter(System.err);
		// }

		try {

			// File input = new File("configs/trap.xml");
			// File rules = new File("configs/trap_rule.xml"); // 配置解析规则
			Digester digester;
			digester = DigesterLoader.createDigester(rules);

			TrapParsers trapParsers = (TrapParsers) digester.parse(input);
			trapParserMap = trapParsers.getTrapParsers();

			// log.println(new java.util.Date() + "\n" + trapParsers
			// + "\n----------------------------");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		long startTime = System.currentTimeMillis();
		log.debug("开始处理事件时间(毫秒)：" + startTime);
		int num = 0; // 处理事件数据计数用
		int errNum = 0;

		try {
			// if(trapSize != 0){
			// System.out.println("trap is " + traps.get(0));
			// }
			// ****************************
			num += num;

			// ****************************

			TrapParser trapParser = (TrapParser) trapParserMap.get(ip); // 在配置文件已提前定义好的要监听并接收trap的设备IP
			// ，目前是接收本地发送的trap

			// System.out.println("-----解析规则对象trapParser------"
			// + trapParser);

			if (trapParser != null) {
				String type = trapParser.getType().trim();// 获取该设备信息型号
				// ．
				String deconding = trapParser.getDeconding();// 需转换的字符编码
				NormalizedEvent event = new NormalizedEvent(); // 初始化归一化事件

				if (trapParser != null) {
					Vector<TrapMatcher> trapMatchers = trapParser
							.getTrapMatchers();
					// System.out.println("trapmatcher's size is "
					// + trapMatchers.size());
					//FIXME for NPE bug 
					for (TrapMatcher trapMatcher : trapMatchers) {
						Vector<TrapBinding> trapBindings = trapMatcher
								.getTrapBindings();

						/**
						 * TrapBinding是匹配发送过来的trap信息的第几行是我们想要的内容， 即bindingNumber
						 */
						for (TrapBinding trapBinding : trapBindings) {
							int i = Integer.parseInt(trapBinding
									.getBindingNumber());
							Vector<VariableBinding> recVBs = trap.getPdu()
									.getVariableBindings(); // 取出PDU中储存的所有trap事件信息
							if (recVBs.size() >= i && recVBs.size() > 0) {
								String message = "";
								if (i > 0) {
									VariableBinding recVB = recVBs.elementAt(i); // 取出配置文件中定义好的某行的trap信息
									message = new String((String) recVB
											.getVariable().toString());
//
//									System.out
//											.println("------message---1111111-----"
//													+ message);

									// 进行16进制转换和编码转换

									String mestr = message.replace(":", "");
									boolean flag = mestr
											.matches("[\\da-fA-F]+");
									if (flag) {
										message = toStringHex(mestr);
									}
									if (deconding != null
											&& deconding.trim().length() > 0) {
										byte[] bs = message.getBytes();
										String str = new String(bs, deconding);
										message = str;
									}
//									System.out
//											.println("------message---222222222-----"
//													+ message);
								} else if (i == 0 && type.equals("3")
										&& recVBs.size() > 10) {
									for (int j = 2; j < recVBs.size(); j++) {
										VariableBinding recVB = recVBs
												.elementAt(j);
										String mes = new String((String) recVB
												.getVariable().toString()
												.trim());
//										System.out
//												.println("------type.equals(3)---------"
//														+ mes);
										// 进行16进制转换和编码转换
										if (j != 8 && j != 9 && j != 12
												&& j != 14) {
											String mestr = mes.replace(":", "");
											boolean flag = mestr
													.matches("[\\da-fA-F]{2,}");
											if (flag) {
												if (j == 15) {
													mes = toStringHexUtf8(mestr);
												} else {
													mes = toStringHex(mestr);
												}
											}
											if (deconding != null
													&& deconding.trim()
															.length() > 0) {
												byte[] bs = mes.getBytes();
												String str = new String(bs,
														deconding);
												mes = str;
											}
//											System.out
//													.println("------type.equals(3)-----"
//															+ mes);
										}
										message = message + mes + ";";
										log.debug(message);
//										System.out
//												.println("------message---333333333333----"
//														+ message);
									}
								}

								/**
								 * 用正则表达式匹配获取的事件信息
								 */
								if (message != null && message.length() > 0) {
									String regex = trapBinding.getRegex();
									Pattern pattern = Pattern.compile(regex);
									Matcher matcher = pattern.matcher(message);
									if (matcher.find()) {
										String[] parsedMessage = new String[matcher
												.groupCount()];
										for (int k = 0; k < parsedMessage.length; k++) {
											parsedMessage[k] = matcher
													.group(k + 1);
										}

										Vector<TrapTransform> trapTransforms = trapBinding
												.getTrapTransforms();
										if (trapTransforms.size() > 0) {
											TrapTransformer transformer = new TrapTransformer();
											for (TrapTransform trapTransform : trapTransforms) {
												String sn = trapTransform
														.getSerialNumber();
												String time = parsedMessage[Integer
														.parseInt(sn)];
												if (time != null
														&& time.trim().length() > 0) {
													String methodName = trapTransform
															.getMethod();
													Method transforming = transformer
															.getClass()
															.getMethod(
																	methodName,
																	String.class);
													parsedMessage[Integer
															.parseInt(sn)] = (String) transforming
															.invoke(
																	transformer,
																	parsedMessage[Integer
																			.parseInt(sn)]);
												}

											}
										}

										/**
										 * 对事件进行归一化处理和存储
										 */
										if (type.equals("1")) {
											event = idsTrapAssemble
													.assemble(parsedMessage);
										} else if (type.equals("2")) {
											event = idsTrapAssemble
													.yingYanAssemble(parsedMessage);
										} else if (type.equals("3")) {
											event = idsTrapAssemble
													.iceyeAssemble(parsedMessage);
										}
										event.setIpaddr(ip);
										event.setDomain(domainId);
									} else {
										// System.out.println(
										// "nu match!");
									}
								}
							}
						}
					}

					/**
					 * 对归一化后的事件进行过滤，剔除掉格式不符合的事件，这里是根据源IP，目的IP， 和事件时间来过滤事件
					 */
					if (event.getDestip().equals("")
							|| event.getSrcip().equals("")
							|| event.getTimestamp() == null) {
						errNum++;
						if (errNum % 10 == 0) {
							log.debug("丢弃事件数量：" + errNum);
						}

						// System.out
						// .println(
						// "\n the trap formatter is not right!! \n")
						// ;
					} else {
//						System.out.println("threrank XXXxXXXXXXXXXXXXXXX is "
//								+ event.getThrerank());
//						System.out.println("event src_ip is "
//								+ event.getSrcip());
//
//						System.out.println("event faci_ip is "
//								+ event.getIpaddr());
//
//						System.out.println("---------------------");
						// 2010-6-1 lchao
                        //FIXME 发送给态势模块
						Constants.addAuditEvent(event);
						sumEvent++;

//						System.out.println(System.currentTimeMillis() + "---"
//								+ sumStartTime + "=="
//								+ (System.currentTimeMillis() - sumStartTime));
//						System.out.println(sumEvent);
						if ((System.currentTimeMillis() - sumStartTime) >= 60000) {
							System.out.println("现在已处理条数：" + sumEvent);
							System.out
									.println("耗费时间(毫秒):"
											+ (System.currentTimeMillis() - sumStartTime));
							sumEvent = 0;
							sumStartTime = System.currentTimeMillis();
						}
					}
				} else {
					// System.out.println("trap parser is null!");
				}
			}
			// eventBatch = Constants.getNormalEvents();
			// if(eventBatch.size() > 0){
			// sendEvent.sendEventsToManager(MANAGER_EVENT_FLAG,
			// eventBatch);
			// }

			log.debug("现在已处理条数：" + num);
			long endTime = System.currentTimeMillis();
			log.debug("耗费时间(毫秒):" + (endTime - startTime));
		} catch (Exception e2) {
			e2.printStackTrace();
			// System.out.println("while错误");
		}

	}

	// public List<BaseEvent> getBatch() {
	// return batch;
	// }
	//
	// public void setBatch(List<BaseEvent> vBatch) {
	// batch = vBatch;
	// }

	// /**
	// * 显示解析好的事件的信息 display
	// */
	// public void display() {
	// Vector<CommandResponderEvent> traps = new
	// Vector<CommandResponderEvent>();
	// traps = Constants.getTraps(traps);
	// System.out.println("trap NO:" + traps.size());
	// int iCount = 0;
	// if (traps.size() > 0) {
	// for (CommandResponderEvent trap : traps) {
	// if (trap != null && trap.getPDU() != null) {
	// Vector<VariableBinding> recVBs = trap.getPDU()
	// .getVariableBindings();
	// System.out.println("received one trap:" + (++iCount));
	// for (int i = 0; i < recVBs.size(); i++) {
	// VariableBinding recVB = recVBs.elementAt(i);
	// System.out.println(recVB.getOid() + " : "
	// + recVB.getVariable());
	// }
	// } else {
	// System.out.println("trap is null!");
	// }
	// }
	// }
	// traps.removeAllElements();
	// }

	/**
	 * @param s把16进制转换成字符串
	 * @return
	 */
	public static String toStringHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
						i * 2, i * 2 + 2), 16));
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
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(
						i * 2, i * 2 + 2), 16));
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
		// MultiThreadedTrapReceiver multithreadedtrapreceiver = new
		// MultiThreadedTrapReceiver();
		// multithreadedtrapreceiver.start();

	}

}
