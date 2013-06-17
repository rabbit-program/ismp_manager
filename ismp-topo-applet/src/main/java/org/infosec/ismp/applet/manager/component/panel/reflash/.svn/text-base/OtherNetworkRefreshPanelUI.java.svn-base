package org.infosec.ismp.applet.manager.component.panel.reflash;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.infosec.ismp.applet.manager.application.dynamicInfo.DynamicInfo;
import org.infosec.ismp.applet.manager.component.panel.info.cpu.CPUPanel;
import org.infosec.ismp.applet.manager.component.panel.info.memory.MemoryPanel;
import org.infosec.ismp.applet.manager.component.panel.info.netport.NetPort;
import org.infosec.ismp.applet.manager.component.panel.info.netport.NetPortScrollPanel;
import org.infosec.ismp.applet.manager.component.panel.view.asset.AssetDevicePanel;
import org.infosec.ismp.applet.manager.component.panel.view.infoview.CPUViewPanel;
import org.infosec.ismp.applet.manager.component.panel.view.infoview.MemoryViewPanel;
import org.infosec.ismp.applet.manager.component.panel.view.network.NetworkStatusPanel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.NullFilter;
import org.infosec.ismp.manager.rmi.snmp.model.host.NetworkStatus;

import twaver.Element;


/**
 * 刷新界面数据
 * 
 * @author 肖高峰
 * 
 */
public class OtherNetworkRefreshPanelUI {
	private NullFilter data;
	
	/**
	 * 构造一个带数据源的面板刷新定时器
	 * @param data
	 */
	public OtherNetworkRefreshPanelUI(NullFilter data) {
		if (data == null) {
		
		} else {
			this.data = data;
		}
	}
	
	//资产信息
	public void refreshAsset(final AssetDevicePanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.setAssetDevice(data.getAssetDevice());
						} catch (Exception e) {
							System.out.println("资产基本信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	public void refreshIsActive(final NodeModel node, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							if(data.isOtherNetworkActive()) {
								node.setImage(node.activeBigICO());
								node.setIcon(node.activeSmallICO());
							} else {
								node.setImage("");
								node.setIcon("");
							}
						} catch (Exception e) {
							System.out.println("设备基本信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	// 刷新Device 基本信息
	public void refreshDevice(final org.infosec.ismp.applet.manager.component.panel.view.device.DeviceInfoPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.setDeviceInfo(data.getDeviceInfo());
						} catch (Exception e) {
							System.out.println("设备基本信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	// 刷新Sensor 基本信息
//	public void refreshSensor(final SensorPanel panel, int frequency) {
//		Timer timer = new Timer(frequency, new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				SwingUtilities.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							panel.setSensor(data.getSensor());
//						
//						} catch (Exception e) {
//							PrintMessage.printMessageToConsole(
//									"Sensor基本信息刷新发生错误！...",
//									PrintMessage.PRINT_BUG_MESSAGE);
//							e.printStackTrace();
//						}
//					}
//				});
//			}
//		});
//		timer.start();
//		TimerManager.addDynameTimer(data.getDevice(), timer);
//	}
	//资产信息
/*	public void refreshAsset(final AssetDevicePanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.setAssetDevice(data.getAssetDevice());
						} catch (Exception e) {
							PrintMessage.printMessageToConsole(
									"资产基本信息刷新发生错误！...",
									PrintMessage.PRINT_BUG_MESSAGE);
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		TimerManager.addDynameTimer(data.getDevice(), timer);
	}*/
	
	int networkLength = 0;
	List<NetworkStatus> networksTemp = null;
	// 刷新 接口基本信息
	public void refreshNetwork(final NetworkStatusPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							List<org.infosec.ismp.applet.manager.component.panel.view.network.NetworkStatus> networks = data.getOtherNetworkStatusAll();
							if(networks == null || networks.size() == 0) {
								return;
							}
							panel.clearStatusList();
							panel.setStatusList(networks);
						} catch (Exception e) {
							System.out.println("网络接口中间信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	
	// 刷新详细信息 内存底图形
	public void refreshMemory(final MemoryViewPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.setMemoryCount(data.getOtherNetworkMemorySize());
							panel.setUsedMemeory(data.getOtherNetworkMemoryUsed());
						} catch (Exception e) {
							System.out.println("主机内存底部信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	
	// 刷新详细信息 CPU底图形
	public void refreshCPU(final CPUViewPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.getDataBox().clear();
							panel.getDataBox().addElements(data.getOtherNetworkCPUs());
						} catch (Exception e) {
							System.out.println("CPU底部信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	
	int cpusLength = 0;
	List<Element> cpus = null;
	// 刷新动态面板CPU
	public void refreshMidCPUs(final CPUPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							
							List<Element> elements = data.getOtherNetworkCPUs();
							if(elements == null || elements.size() == 0) {
								return;
							}
							//如果CPU的块数不一样
							if(cpusLength != elements.size()) {
								panel.clearCpuList();
								panel.setCpuList(elements);
								cpusLength = elements.size();
								cpus = elements;
							}
							//设置值
							for(int i = 0; i < elements.size(); i++) {
								panel.setValue(cpus.get(i), elements.get(i).getChartValue());
							}
						} catch (Exception e) {
							System.out.println("CPU中间信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	// 刷新动态面板内存。
	public void refreshMidMemory(final MemoryPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.setValue((data.getOtherNetworkMemoryUsed()/data.getOtherNetworkMemorySize())*100);
						} catch (Exception e) {
							System.out.println("主机内存中间信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	
	
	// 刷新动态面板网接口
	public void refreshMidNetwork(final NetPortScrollPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.clearPortList();
							for(org.infosec.ismp.applet.manager.component.panel.view.network.NetworkStatus e : data.getOtherNetworkStatusAll()) {
								 NetPort port1 = new NetPort();
								 port1.setName(e.getDescription());
								 port1.setSendSpeed(e.getOutBytes());
								 port1.setReceiveSpeed(e.getInBytes());
								 panel.addNetPort(port1);
							}
						} catch (Exception e) {
							System.out.println("网络接口中间信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
}
