package org.infosec.ismp.applet.manager.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.applet.discover.ui.TopoDiscoverMainFrame;
import org.infosec.ismp.applet.manager.component.dialog.DialogBuilder;
import org.infosec.ismp.applet.manager.component.dialog.SensorAllotDialog;
import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.model.TopoDatabaseModel;
import org.infosec.ismp.applet.manager.model.TopoFirewallModel;
import org.infosec.ismp.applet.manager.model.TopoIdsModel;
import org.infosec.ismp.applet.manager.model.TopoRouterModel;
import org.infosec.ismp.applet.manager.model.TopoSensorModel;
import org.infosec.ismp.applet.manager.model.TopoServerModel;
import org.infosec.ismp.applet.manager.model.TopoSwitchModel;
import org.infosec.ismp.applet.manager.model.TopoWeblogicModel;
import org.infosec.ismp.applet.manager.task.GetAllUnDomainSensorTask;
import org.infosec.ismp.applet.manager.utilities.TopoConst;

import twaver.Element;
import twaver.TUIManager;
import twaver.network.TNetwork;
import twaver.network.toolbar.BaseNetworkToggleButton;

/**
 * 所有自定义Button
 * @author 肖高峰
 */
@SuppressWarnings("serial")
public class EquipmentButton extends BaseNetworkToggleButton{
	
	public static class DomainButton extends EquipmentButton{
		public DomainButton(TNetwork network) {
			super(DomainModel.class, network);
		}
	}
    
	public static class DatabaseButton extends EquipmentButton{
		public DatabaseButton(TNetwork network) {
			super(TopoDatabaseModel.class, network);
		}
	}
	public static class FirewallButton extends EquipmentButton{
		public FirewallButton(TNetwork network) {
			super(TopoFirewallModel.class, network);
		}
	}
	public static class IdsButton extends EquipmentButton{
		public IdsButton(TNetwork network) {
			super(TopoIdsModel.class, network);
		}
	}
	public static class RouterButton extends EquipmentButton{
		public RouterButton(TNetwork network) {
			super(TopoRouterModel.class, network);
		}
	}
	public static class SensorButton extends EquipmentButton{
		public SensorButton(TNetwork network) {
			super(TopoSensorModel.class, network);
		}
	}
	public static class ServerButton extends EquipmentButton{
		public ServerButton(TNetwork network) {
			super(TopoServerModel.class, network);
		}
	}
	public static class SwitchButton extends EquipmentButton{
		public SwitchButton(TNetwork network) {
			super(TopoSwitchModel.class, network);
		}
	}
	
	public static class WeblogicButton extends EquipmentButton{
		public WeblogicButton(TNetwork network) {
			super(TopoWeblogicModel.class, network);
		}
	}
	
	public static class TopoDiscoverButton extends EquipmentButton{
		public TopoDiscoverButton(TNetwork network) {
			super(TopoDiscover.class, network);
		}
	}
	
	public static class TopoLayoutButton extends EquipmentButton{
		public TopoLayoutButton(TNetwork network) {
			super(TopoLayout.class, network);
		}
	}

	
	@SuppressWarnings("unchecked")
	public EquipmentButton(final Class elementType, final TNetwork network){
		super(network);
		this.setDefaultButtonGroup();
		try {
			Element element = ((twaver.Element)elementType.newInstance());
			setToolTipText(element.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setIcon(TUIManager.getIcon(elementType));
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Element element = null;
				try {
					element = ((twaver.Element)elementType.newInstance());
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				}
				if(element instanceof TopoDatabaseModel) {
					DialogBuilder.builderDatabaseDialog((NodeModel)element, network);
				} else if(element instanceof DomainModel) {
					DialogBuilder.builderDomainDialog((DomainModel)element, network);
				} else if(element instanceof TopoDiscover) {
					new TopoDiscoverMainFrame(1);
				}else if(element instanceof TopoLayout) {
					DialogBuilder.builderTopoAutoLayout(network);
				}else if(element instanceof TopoSensorModel){
					SensorAllotDialog senosr = new SensorAllotDialog();
					List<DomainModel> domain = new ArrayList<DomainModel>();
					for(Object o:TopoConst.BOX.getAllElements()) {
						if(o instanceof DomainModel) {
							domain.add((DomainModel)o);
						}
					}
					senosr.setDomainModel(domain);
					new GetAllUnDomainSensorTask(senosr).execute();
				}else {
					DialogBuilder.builderDeviceDialog((NodeModel)element, network);
				}
			}
			
		});
	}
}