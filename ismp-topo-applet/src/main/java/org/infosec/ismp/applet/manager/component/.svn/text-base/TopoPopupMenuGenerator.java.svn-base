package org.infosec.ismp.applet.manager.component;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import org.infosec.ismp.applet.manager.application.action.ActionInfo;
import org.infosec.ismp.applet.manager.application.active.ActiveDevice;
import org.infosec.ismp.applet.manager.application.active.ActiveLink;
import org.infosec.ismp.applet.manager.component.dialog.DialogBuilder;
import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.model.LinkModel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.model.TopoDatabaseModel;
import org.infosec.ismp.applet.manager.model.TopoFirewallModel;
import org.infosec.ismp.applet.manager.model.TopoIdsModel;
import org.infosec.ismp.applet.manager.model.TopoRouterModel;
import org.infosec.ismp.applet.manager.model.TopoSensorModel;
import org.infosec.ismp.applet.manager.model.TopoServerModel;
import org.infosec.ismp.applet.manager.model.TopoSwitchModel;
import org.infosec.ismp.applet.manager.model.TopoWeblogicModel;
import org.infosec.ismp.applet.manager.utilities.TopoConst;

import twaver.Element;
import twaver.Node;
import twaver.PopupMenuGenerator;
import twaver.TDataBox;
import twaver.TView;
import twaver.network.TNetwork;
import twaver.network.action.AlignBottomAction;
import twaver.network.action.AlignCenterAction;
import twaver.network.action.AlignLeftAction;
import twaver.network.action.AlignMiddleAction;
import twaver.network.action.AlignRightAction;
import twaver.network.action.AlignTopAction;
import twaver.network.action.BottomPileAction;
import twaver.network.action.EvenHSpaceAction;
import twaver.network.action.EvenVSpaceAction;
import twaver.network.action.LeftPileAction;
import twaver.network.action.RightPileAction;
import twaver.network.action.TopPileAction;
import twaver.network.background.ColorBackground;



public class TopoPopupMenuGenerator implements PopupMenuGenerator{
	private TNetwork network;

	public TopoPopupMenuGenerator(TNetwork network){
		this.network = network;
	}
	//@Override
	public JPopupMenu generate(TView view, MouseEvent event) {
		final TDataBox box = view.getDataBox();
		Element element = box.getLastSelectedElement();
		if(element instanceof DomainModel) {
			return getDomainPopupMenu((DomainModel)element);
		} else if(element instanceof LinkModel) {
			LinkModel link = (LinkModel)element;
			return getLinkPopupMenu(link);
		} else if(element instanceof TopoSensorModel) {
			TopoSensorModel pc = (TopoSensorModel)element;
			return getSensorPopupMenu(pc);
		} else if(element instanceof NodeModel) {
			NodeModel node = (NodeModel)element;
			return getDevicePopupMenu(node);
		} else {
			return getNullPopupMenu();
		}
	}
	
	//空白处右键菜单
	private JPopupMenu getNullPopupMenu() {
		JPopupMenu popMenu = new JPopupMenu();
		popMenu.add(getAddDomain());
		popMenu.add(getAddServerDevice());
		popMenu.add(getAddSwitchDevice());
		popMenu.add(getAddRouterDevice());
		popMenu.add(getAddIDSDevice());
		popMenu.add(getAddFirewallDevice());
		popMenu.add(getAddWeblogic());
		popMenu.add(getAddDatabaseDevice());
		popMenu.addSeparator();
		popMenu.add(getColorMenu());
		return popMenu;
	}
	
	//普通SNMP设备右键菜单  isAgent 是否已激活
	private JPopupMenu getDevicePopupMenu(NodeModel node) {
		JPopupMenu popMenu = new JPopupMenu();
		popMenu.add(getDeviceInfo(node));
		if(node.getStatus() != null && node.getStatus() == 1) {
			popMenu.add(getCloseAgent(node));
		} else {
			popMenu.add(getStartAgent(node));
		}
		popMenu.add(getUpdateDevice(node));
		popMenu.add(getDeleteDevice(node));
		popMenu.addSeparator();
		popMenu.add(getPing());
		popMenu.add(getAlarmInfo());
		popMenu.addSeparator();
		popMenu.add(getAlignMenu());
		popMenu.add(getEvenSpaceMenu());
		popMenu.add(getPileMenu());
		return popMenu;
	}
	
	//普通云图右键菜单  
	private JPopupMenu getDomainPopupMenu(DomainModel domain) {
		JPopupMenu popMenu = new JPopupMenu();
		popMenu.add(getUpdateDevice(domain));
		popMenu.add(getDeleteDevice(domain));
		popMenu.addSeparator();
		popMenu.add(getAlarmInfo());
		popMenu.addSeparator();
		popMenu.add(getAlignMenu());
		popMenu.add(getEvenSpaceMenu());
		popMenu.add(getPileMenu());
		return popMenu;
	}
	
	//PC右键菜单 isAgent 是否已激活
	private JPopupMenu getSensorPopupMenu(NodeModel node) {
		JPopupMenu popMenu = new JPopupMenu();
		popMenu.add(getDeviceInfo(node));
		if(node.getStatus()!= null && node.getStatus() == 1) {
			popMenu.add(getCloseAgent(node));
		} else {
			popMenu.add(getStartAgent(node));
		}
		popMenu.add(getDeleteDevice(node));
		popMenu.addSeparator();
		popMenu.add(getAlarmInfo());
		popMenu.addSeparator();
		popMenu.add(getAlignMenu());
		popMenu.add(getEvenSpaceMenu());
		popMenu.add(getPileMenu());
		return popMenu;
	}
	
	//连接线右键菜单 isAgent 是否已激活
	private JPopupMenu getLinkPopupMenu(LinkModel link) {
		JPopupMenu popMenu = new JPopupMenu();
		popMenu.add(getLinkInfo());
		Node fromNode = link.getFrom();
		Node toNode = link.getTo();
		
		if(fromNode == null || toNode == null || 
			!(fromNode instanceof NodeModel)  || !(toNode instanceof NodeModel)) {
		} else {
			if(link.getLinkState() != null && link.getLinkState() == 1) {
				popMenu.add(getCloseAgent(link));
			} else {
				popMenu.add(getStartAgent(link));
			}
		}
		
		popMenu.add(getDeleteDevice(link));
		popMenu.addSeparator();
		popMenu.add(getAlarmInfo());
		return popMenu;
	}
	
	private JMenu getAlignMenu() {
		JMenu menu = new JMenu("对齐");
		menu.add(new AlignLeftAction(network));
		menu.add(new AlignCenterAction(network));
		menu.add(new AlignRightAction(network));
		menu.addSeparator();
		menu.add(new AlignTopAction(network));
		menu.add(new AlignMiddleAction(network));
		menu.add(new AlignBottomAction(network));
		return menu;
	}

	private JMenu getEvenSpaceMenu() {
		JMenu menu = new JMenu("间距");
		menu.add(new EvenHSpaceAction(network));
		menu.add(new EvenVSpaceAction(network));
		return menu;
	}

	private JMenu getPileMenu() {
		JMenu menu = new JMenu("堆列");
		menu.add(new LeftPileAction(network));
		menu.add(new RightPileAction(network));
		menu.add(new TopPileAction(network));
		menu.add(new BottomPileAction(network));
		return menu;
	}
	
	private JMenuItem getColorMenu() {
		JMenuItem item = new JMenuItem("背景颜色");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(network, "颜色选择器",
						Color.white);
				if (color != null) {
					network.setCurrentBackground(new ColorBackground(color));
				}
			}
		});
		return item;
	}
	
	private JMenuItem getDeviceInfo(final NodeModel node) {
		JMenuItem item = new JMenuItem("设备详细信息");
		
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(node instanceof TopoDatabaseModel) {
					ActionInfo.actionDatabaseInfo(node);
				} else if(node instanceof TopoSensorModel) {
					ActionInfo.actionSensorInfo(node);
				} else if(node instanceof TopoWeblogicModel) {
					ActionInfo.actionWeblogicInfo(node);
				} else {
					ActionInfo.actionDeviceInfo(node);
				}
			}
		});
		
		return item;
	}
	
	private JMenuItem getLinkInfo() {
		JMenuItem item = new JMenuItem("连接详细信息");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null,"功能正在开发中..." , "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		return item;
	}
	
	private JMenuItem getCloseAgent(final NodeModel node) {
		JMenuItem item = new JMenuItem("关闭设备监控");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveDevice.unActionDevice(node);
			}
		});
		return item;
		
	}
	
	private JMenuItem getStartAgent(final NodeModel node) {
		JMenuItem item = new JMenuItem("开启设备监控");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveDevice.activeDevice(node);
			}
		});
		return item;
		
		
	}
	
	private JMenuItem getStartAgent(final LinkModel link) {
		final JMenuItem item = new JMenuItem("开启连接监控");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveLink.activeLink(link);
			}
		});
		return item;
	}
	
	private JMenuItem getCloseAgent(final LinkModel link) {
		JMenuItem item = new JMenuItem("关闭连接监控");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActiveLink.unActionLink(link);
			}
		});
		return item;
		
	}
	
	private JMenuItem getUpdateDevice(final NodeModel node) {
		JMenuItem item = new JMenuItem("修改设备");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(node instanceof TopoDatabaseModel) {
					DialogBuilder.builderDatabaseDialog(node,network);
				} else {
					DialogBuilder.builderDeviceDialog(node , network);
				}
			}
		});
		return item;
	}
	
	private JMenuItem getUpdateDevice(final DomainModel domain) {
		JMenuItem item = new JMenuItem("修改云图");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.builderDomainDialog(domain , network);
			}
		});
		return item;
	}
	
	private JMenuItem getDeleteDevice(final LinkModel link) {
		JMenuItem item = new JMenuItem("删除连接");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TopoConst.BOX.removeElement(link);
				//new DeleteLinkTask(link).execute();
			}
		});
		return item;
	}
	
	private JMenuItem getDeleteDevice(final DomainModel domain) {
		JMenuItem item = new JMenuItem("删除云图");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	new DeleteDomainTask(domain).execute();
				TopoConst.BOX.removeElement(domain);
			}
		});
		return item;
	}
	
	private JMenuItem getDeleteDevice(final NodeModel node) {
		JMenuItem item = new JMenuItem("删除设备");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new DeleteNodeTask(node).execute();
				TopoConst.BOX.removeElement(node);
			}
		});
		return item;
	}
	
	private JMenuItem getPing() {
		JMenuItem item = new JMenuItem("Ping 操作");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null,"功能正在开发中..." , "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		return item;
	}
	
	private JMenuItem getAlarmInfo() {
		JMenuItem item = new JMenuItem("告警信息");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showMessageDialog(null,"功能正在开发中..." , "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		return item;
	}
	
	private JMenuItem getAddServerDevice() {
		JMenuItem item = new JMenuItem("新增服务器设备");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.builderDeviceDialog(new TopoServerModel(), network);
			}
		});
		return item;
	}
	private JMenuItem getAddSwitchDevice() {
		JMenuItem item = new JMenuItem("新增交换机设备");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.builderDeviceDialog(new TopoSwitchModel(), network);
			}
		});
		
		return item;
	}
	private JMenuItem getAddWeblogic() {
		JMenuItem item = new JMenuItem("新增Weblogic服务");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.builderDeviceDialog(new TopoWeblogicModel(), network);
			}
		});
	
		return item;
	}
	private JMenuItem getAddRouterDevice() {
		JMenuItem item = new JMenuItem("新增路由器设备");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.builderDeviceDialog(new TopoRouterModel(), network);
			}
		});
		return item;
	}
	private JMenuItem getAddIDSDevice() {
		JMenuItem item = new JMenuItem("新增IDS设备");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.builderDeviceDialog(new TopoIdsModel(), network);
			}
		});
		return item;
	}
	private JMenuItem getAddFirewallDevice() {
		JMenuItem item = new JMenuItem("新增防火墙设备");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.builderDeviceDialog(new TopoFirewallModel(), network);
			}
		});
		return item;
	}
	private JMenuItem getAddDatabaseDevice() {
		JMenuItem item = new JMenuItem("新增数据库设备");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.builderDatabaseDialog(new TopoDatabaseModel(), network);
			}
		});
		return item;
	}
	private JMenuItem getAddDomain() {
		JMenuItem item = new JMenuItem("新增云图");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogBuilder.builderDomainDialog(new DomainModel(), network);
			}
		});
		return item;
	}
}
