package org.infosec.ismp.applet.manager.component.panel.view.infoview;

import java.awt.BorderLayout;

import javax.swing.JTabbedPane;

import org.infosec.ismp.applet.manager.component.panel.SJTUConst;
import org.infosec.ismp.applet.manager.component.panel.utils.ImageToolTipTabbedPanel;
import org.infosec.ismp.applet.manager.component.panel.view.BorderPanel;

/**
 * 信息一览面板
 * 接口
 * 1、getCpuPanel cpu面板
 * 2、getMemoryPanel 内存面板
 * 3、getDiskViewPanel 硬盘信息面板
 */
public class InfoViewPanel extends BorderPanel {
	public InfoViewPanel() {
		super("   信息一览    ");
		initGUI();
	}

	private CPUViewPanel cpuPanel = new CPUViewPanel();
	private MemoryViewPanel memoryPanel = new MemoryViewPanel();
	private DiskViewPanel diskViewPanel = new DiskViewPanel();
	
	
	public void initGUI() {
		this.setBackground(SJTUConst.PANELBACKGROUND);
		JTabbedPane pane = new ImageToolTipTabbedPanel();
		pane.addTab("CPU", cpuPanel);
		pane.addTab("内存", memoryPanel);
		pane.addTab("硬盘", diskViewPanel);
		this.setLayout(new BorderLayout());
		this.add(pane, BorderLayout.CENTER);
	}
//	private void initData() {	
//		timer = new Timer(DynameicDeviceDataManager.agentTime, new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//		//System.out.println("---------------timer---------");
//		 MySwingWorker worker = new MySwingWorker(){
//			private TopoDeviceInfo deviceInfo;	
//			@Override
//			public Object construct() {
//		//		System.out.println("---into infoViewPanel  worker construct!--");
//				deviceInfo = dyname.getTopoDeviceInfo();			
//				return deviceInfo;
//			}
//			@Override
//			public void finished() {
//				deviceInfo = (TopoDeviceInfo) get();
//		//		System.out.println("infoviewPael----"+deviceInfo);
//				if(deviceInfo!=null){
//				    if(deviceInfo.getMemoryStatus()!=null){
//				    	memoryPanel.setEnabled(true);
//				    memoryPanel.setUsedMemeory(dyname.getTopoDeviceInfo().getMemoryStatus().getUsed());
//					memoryPanel.setMemoryCount(dyname.getTopoDeviceInfo().getMemoryStatus().getSize());
//				    } else {
//				    	memoryPanel.setEnabled(false);
//				    }
//				    if(deviceInfo.getHardDiskStatus()!=null){
//				    	diskViewPanel.setEnabled(true);
//					    diskViewPanel.setUsedDisk(dyname.getTopoDeviceInfo().getHardDiskStatus().getUsed());
//						diskViewPanel.setDiskCount(dyname.getTopoDeviceInfo().getHardDiskStatus().getSize());
//					    } else {
//					    	diskViewPanel.setEnabled(false);
//					    }
//				
//				    int i=0;
//				    if(deviceInfo.getCupstatus()!=null && deviceInfo.getCupstatus().getLoads() != null){
//				    	 cpuPanel.setEnabled(true);
//				    	 cpuPanel.getDataBox().clear();
//				    	 for(Integer cpuNum:deviceInfo.getCupstatus().getLoads()) {
//						     Element c1 = new Node();
//					          c1.setName("cpu"+i);
//						      c1.putChartValue(cpuNum);
//						      cpuPanel.getDataBox().addElement(c1);
//						      i++;
//						      }
//				     } else {
//				    	 cpuPanel.setEnabled(false);
//				     }
//					}
//			}
//		};
//		worker.start();
//			}
//			});
//		timer.start();
//	}
	
	/**
	 * CPU 面板
	 * @return CPUViewPanel
	 */
	public CPUViewPanel getCpuPanel() {
		return cpuPanel;
	}
	
	/**
	 * 内存面板
	 * @return
	 */
	public MemoryViewPanel getMemoryPanel() {
		return memoryPanel;
	}
	
	/**
	 * 硬盘面板
	 * @return
	 */
	public DiskViewPanel getDiskViewPanel() {
		return diskViewPanel;
	}

}
