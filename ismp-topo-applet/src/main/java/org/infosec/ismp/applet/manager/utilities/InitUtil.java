package org.infosec.ismp.applet.manager.utilities;

import org.infosec.ismp.applet.manager.component.button.LinkButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.DatabaseButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.DomainButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.FirewallButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.IdsButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.RouterButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.SensorButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.ServerButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.SwitchButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.TopoDiscoverButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.TopoLayoutButton;
import org.infosec.ismp.applet.manager.component.button.EquipmentButton.WeblogicButton;
import org.infosec.ismp.applet.manager.model.TopoDatabaseModel;
import org.infosec.ismp.applet.manager.model.TopoFirewallModel;
import org.infosec.ismp.applet.manager.model.TopoIdsModel;
import org.infosec.ismp.applet.manager.model.TopoRouterModel;
import org.infosec.ismp.applet.manager.model.TopoSensorModel;
import org.infosec.ismp.applet.manager.model.TopoServerModel;
import org.infosec.ismp.applet.manager.model.TopoSwitchModel;
import org.infosec.ismp.applet.manager.model.TopoWeblogicModel;
import org.infosec.ismp.applet.manager.task.GetAllTypeTask;
import org.infosec.ismp.applet.manager.task.InitBrandAndModelTask;

import twaver.TUIManager;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.network.NetworkToolBarFactory;

public class InitUtil {
	public static void init() {
		TWaverUtil.init(TWaverConst.ZH_CN, null);
		registerDefaults();
		registerToolbarButton();
		//registerBeanInfo();
		
	}
	
    public static void initDatabaseData() {
    	initNodes();
    	initTradeMarkAndDeviceModel();
    }
	
	private static void registerDefaults(){
		//注册全屏F11
		TUIManager.registerDefault(TWaverConst.NETWORK_FULL_SCREEN_KEYBOARD, "F11"); 
		//线展开状态属性名称
		TUIManager.registerDefault(TWaverConst.PROPERTYNAME_LINK_BUNDLE_EXPAND, Boolean.TRUE);
		
		TUIManager.registerDefault(TWaverConst.TABLE_SHOW_PREDEFINED_COLUMNS_IN_POPUPMENU, Boolean.FALSE);
		
		TUIManager.registerDefault(TWaverConst.NETWORK_ANIMATE_COMPONENT_ATTACHMENT, Boolean.TRUE);
        TUIManager.registerDefault(TWaverConst.NETWORK_ANIMATE_SUBNETWORK_ENTER, Boolean.TRUE);
        TUIManager.registerDefault(TWaverConst.NETWORK_ANIMATE_ELEMENT_MOVE, Boolean.TRUE);
        TUIManager.registerDefault(TWaverConst.NETWORK_ANIMATE_ELEMENT_DELETE, Boolean.TRUE);
        TUIManager.registerDefault(TWaverConst.NETWORK_ANIMATE_ELEMENT_RESIZE, Boolean.TRUE);
        
        TUIManager.registerDefault(TWaverConst.TCHART_ENABLE_XTRANSLATE, Boolean.FALSE);
		TUIManager.registerDefault(TWaverConst.TCHART_ENABLE_YTRANSLATE, Boolean.FALSE);
		TUIManager.registerDefault(TWaverConst.TCHART_ENABLE_XZOOM, Boolean.FALSE);
		TUIManager.registerDefault(TWaverConst.TCHART_ENABLE_YZOOM, Boolean.FALSE);
		
	}
	
	private static void registerToolbarButton(){
		NetworkToolBarFactory.registerButton("LinkButton", LinkButton.class);	
		NetworkToolBarFactory.registerButton("DatabaseButton", DatabaseButton.class);	
		NetworkToolBarFactory.registerButton("FirewallButton", FirewallButton.class);	
		NetworkToolBarFactory.registerButton("IdsButton", IdsButton.class);	
		NetworkToolBarFactory.registerButton("RouterButton", RouterButton.class);	
		NetworkToolBarFactory.registerButton("SensorButton", SensorButton.class);	
		NetworkToolBarFactory.registerButton("ServerButton", ServerButton.class);	
		NetworkToolBarFactory.registerButton("SwitchButton", SwitchButton.class);
		NetworkToolBarFactory.registerButton("DomainButton", DomainButton.class);
		NetworkToolBarFactory.registerButton("LayoutButton", TopoLayoutButton.class);
		NetworkToolBarFactory.registerButton("TopoDiscoverButton", TopoDiscoverButton.class);
		NetworkToolBarFactory.registerButton("WeblogicButton", WeblogicButton.class);
		
		NetworkToolBarFactory.registerToolbar(TopoConst.TOOLBAR, new String[]{
				TWaverConst.TOOLBAR_SELECTION,
				"LinkButton",
				TWaverConst.TOOLBAR_SEPARATOR_ID,
				"DomainButton",
				"ServerButton",
				"SwitchButton",
				"RouterButton",
				"IdsButton",
				"FirewallButton",
				"DatabaseButton",
				"WeblogicButton",
				"SensorButton",
				TWaverConst.TOOLBAR_SEPARATOR_ID, //空间
				"LayoutButton",
				TWaverConst.TOOLBAR_FULLSCREEN,
				TWaverConst.TOOLBAR_LAZYMOVE,
				TWaverConst.TOOLBAR_MAGNIFIER,
				TWaverConst.TOOLBAR_PAN,
				TWaverConst.TOOLBAR_UP,
				TWaverConst.TOOLBAR_ZOOMIN,
				TWaverConst.TOOLBAR_ZOOMOUT,
				TWaverConst.TOOLBAR_ZOOMBACK,
				TWaverConst.TOOLBAR_ZOOMTOOVERVIEW,
				TWaverConst.TOOLBAR_ZOOMTORECTANGLE,
				TWaverConst.TOOLBAR_ZOOMRESET,
				TWaverConst.TOOLBAR_OVERVIEW,
				TWaverConst.TOOLBAR_SEPARATOR_ID,
				"TopoDiscoverButton"
		});
	}
	
	private static void registerBeanInfo(){
	//	 TWaverUtil.registerBeanInfoWithoutDefault(NodeModel.class);
		 TWaverUtil.registerBeanInfoWithoutDefault(TopoFirewallModel.class);
		 TWaverUtil.registerBeanInfoWithoutDefault(TopoIdsModel.class);
		 TWaverUtil.registerBeanInfoWithoutDefault(TopoRouterModel.class);
		 TWaverUtil.registerBeanInfoWithoutDefault(TopoServerModel.class);
		 TWaverUtil.registerBeanInfoWithoutDefault(TopoSensorModel.class);
		 TWaverUtil.registerBeanInfoWithoutDefault(TopoWeblogicModel.class);
		 TWaverUtil.registerBeanInfoWithoutDefault(TopoSwitchModel.class);
		 TWaverUtil.registerBeanInfoWithoutDefault(TopoDatabaseModel.class);
	}
	
	private static void initTradeMarkAndDeviceModel() {
		new InitBrandAndModelTask().execute();
	}
	private static void initNodes() {
		new GetAllTypeTask().execute();
	}
}
