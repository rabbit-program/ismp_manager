package org.infosec.ismp.applet.manager.component.panel.reflash;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.infosec.ismp.applet.manager.application.dynamicInfo.DynamicInfo;
import org.infosec.ismp.applet.manager.component.panel.database.OraclePanel;
import org.infosec.ismp.applet.manager.component.panel.info.basic.RoutinePanel;
import org.infosec.ismp.applet.manager.component.panel.info.cpu.CPUPanel;
import org.infosec.ismp.applet.manager.component.panel.info.file.FileElement;
import org.infosec.ismp.applet.manager.component.panel.info.file.FilePanel;
import org.infosec.ismp.applet.manager.component.panel.info.memory.MemoryPanel;
import org.infosec.ismp.applet.manager.component.panel.info.netport.NetPort;
import org.infosec.ismp.applet.manager.component.panel.info.netport.NetPortScrollPanel;
import org.infosec.ismp.applet.manager.component.panel.info.waitqueue.WaitQueuePanel;
import org.infosec.ismp.applet.manager.component.panel.progress.ProcessPanel;
import org.infosec.ismp.applet.manager.component.panel.view.asset.AssetDevicePanel;
import org.infosec.ismp.applet.manager.component.panel.view.infoview.CPUViewPanel;
import org.infosec.ismp.applet.manager.component.panel.view.infoview.DiskViewPanel;
import org.infosec.ismp.applet.manager.component.panel.view.infoview.MemoryViewPanel;
import org.infosec.ismp.applet.manager.component.panel.view.network.NetworkStatus;
import org.infosec.ismp.applet.manager.component.panel.view.network.NetworkStatusPanel;
import org.infosec.ismp.applet.manager.component.panel.view.sensor.SensorPanel;
import org.infosec.ismp.applet.manager.component.panel.weblogic.WeblogicPanel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.NullFilter;

import twaver.Element;
import twaver.TDataBox;


/**
 * 刷新界面数据
 * 
 * @author 肖高峰
 * 
 */
public class SensorRefreshPanelUI {
	private NullFilter data;
	
	/**
	 * 构造一个带数据源的面板刷新定时器
	 * @param data
	 */
	public SensorRefreshPanelUI(NullFilter data) {
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
							if(data.isSensorActive()) {
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
	public void refreshSensor(final SensorPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.setSensor(data.getSensor());
						
						} catch (Exception e) {
							System.out.println("Sensor基本信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
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
	}
	*/
	// 刷新 接口基本信息
	public void refreshNetwork(final NetworkStatusPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							List<NetworkStatus> networks = data.getSensorNetworkStatusAll();
							if(networks == null || networks.size() == 0) {
								return;
							}
							panel.clearStatusList();
							panel.setStatusList(networks);
						} catch (Exception e) {
							System.out.println("Sensor网络接口中间信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	// 刷新详细信息 硬盘底图形
	public void refreshHardDisk(final DiskViewPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.setDiskCount(data.getSensorHardDiskSize());
							panel.setUsedDisk(data.getSensorHardDiskUsed());
						} catch (Exception e) {
							System.out.println("Sensor 硬盘底部信息刷新发生错误！...");
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
							panel.setMemoryCount(data.getSensorMemorySize());
							panel.setUsedMemeory(data.getSensorMemoryUsed());
						} catch (Exception e) {
							System.out.println("Sensor 内存底部信息刷新发生错误！...");
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
							panel.getDataBox().addElements(data.getSensorCPUs());
						} catch (Exception e) {
							System.out.println("Sensor CPU底部信息刷新发生错误！...");
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
							
							List<Element> elements = data.getSensorCPUs();
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
							System.out.println("Sensor CPU中间信息刷新发生错误！...");
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
							panel.setValue((data.getSensorMemoryUsed()/data.getSensorMemorySize())*100);
						} catch (Exception e) {
							System.out.println("Sensor 内存中间信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	
	// 刷新动态面板硬盘
	public void refreshMidHardDisk(final FilePanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.clearFiles();
							for(FileElement f : data.getSensorFileElements()) {
								panel.addFile(f);
							}
						} catch (Exception e) {
							System.out.println("Sensor 硬盘中间信息刷新发生错误！...");
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
							for(NetworkStatus e : data.getSensorNetworkStatusAll()) {
								 NetPort port1 = new NetPort();
								 port1.setName(e.getDescription());
								 port1.setSendSpeed(e.getOutBytes());
								 port1.setReceiveSpeed(e.getInBytes());
								 panel.addNetPort(port1);
							}
						} catch (Exception e) {
							System.out.println("Sensor 网络接口中间信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	// 刷新进程
	public void refreshProcess(final ProcessPanel panel,final WaitQueuePanel processPanel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							List pro =data.getSensorProcessAll();
							if(pro == null) return;
							TDataBox box = panel.getProcessBox();
							box.clear();
							box.addElements(pro);
							panel.setBox(box);
							processPanel.setProcessCount(pro.size());
						} catch (Exception e) {
							System.out.println("Sensor 线程信息刷新发生错误！...");
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	// 刷新阈值信息
	/*public void refreshMonitor(final MonitorPanel panel, int frequency) {
		Timer timer = new Timer(frequency, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							panel.getBox().clear();
						} catch (Exception e) {
							PrintMessage.printMessageToConsole(
									"线程信息刷新发生错误！...",
									PrintMessage.PRINT_BUG_MESSAGE);
							e.printStackTrace();
						}
					}
				});
			}
		});
		timer.start();
		DynamicInfo.addDynameTimer(data.getDevice().getNodeId(), timer);
	}
	*/
	
	
}
