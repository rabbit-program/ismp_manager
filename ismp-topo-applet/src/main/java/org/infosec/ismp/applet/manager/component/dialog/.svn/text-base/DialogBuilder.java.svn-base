package org.infosec.ismp.applet.manager.component.dialog;

import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.model.NodeModel;

import twaver.network.TNetwork;

/**
 * 产生当前唯一个Dialog
 * 
 * @author 肖高峰
 *
 */
public class DialogBuilder {
	private static DomainDialog domain = null;
	public static DomainDialog builderDomainDialog(DomainModel model,TNetwork network) {
		if(domain == null) {
			domain = new DomainDialog(model,network);
		} else {
			domain.setModel(model);
		}
		return domain;
	}
	
	public static void disposeDomainDialog() {
		domain = null;
	}
	
	private static DatabaseDialog database = null;
	public static DatabaseDialog builderDatabaseDialog(NodeModel model,TNetwork network) {
		if(database == null) {
			database = new DatabaseDialog(model,network);
		} else {
			database.setModel(model);
		}
		return database;
	}
	
	public static void disposeDatabaseDialog() {
		database = null;
	}
	
	private static DeviceDialog device = null;
	public static DeviceDialog builderDeviceDialog(NodeModel model,TNetwork network) {
		if(device == null) {
			device = new DeviceDialog(model,network);
		} else {
			device.setModel(model);
		}
		return device;
	}
	
	public static void disposeDeviceDialog() {
		device = null;
	}
	
	
	private static TopoAutoLayout layout = null;
	public static TopoAutoLayout builderTopoAutoLayout(TNetwork network) {
		if(layout == null) {
			layout = new TopoAutoLayout(network);
		} 
		return layout;
	}
	
	public static void disposeTopoAutoLayout() {
		layout = null;
	}
	
}
