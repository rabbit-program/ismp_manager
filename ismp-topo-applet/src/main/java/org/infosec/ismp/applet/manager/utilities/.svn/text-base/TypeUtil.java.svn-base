package org.infosec.ismp.applet.manager.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.model.TopoDatabaseModel;
import org.infosec.ismp.applet.manager.model.TopoFirewallModel;
import org.infosec.ismp.applet.manager.model.TopoIdsModel;
import org.infosec.ismp.applet.manager.model.TopoRouterModel;
import org.infosec.ismp.applet.manager.model.TopoSealedModel;
import org.infosec.ismp.applet.manager.model.TopoSensorModel;
import org.infosec.ismp.applet.manager.model.TopoServerModel;
import org.infosec.ismp.applet.manager.model.TopoSwitchModel;
import org.infosec.ismp.applet.manager.model.TopoWeblogicModel;
import org.infosec.ismp.manager.rmi.tm.manager.model.NodeTypeEntity;

public class TypeUtil {
	private static Map<String, NodeTypeEntity> typeMap = new HashMap<String, NodeTypeEntity>();

	public static NodeModel getType(String typeEnglish) {
		NodeModel node = null;
		if (typeEnglish.equals("router")) {
			node = new TopoRouterModel();
		} else if (typeEnglish.equals("switch")) {
			node = new TopoSwitchModel();
		} else if (typeEnglish.equals("pc")) {
			node = new TopoSensorModel();
		} else if (typeEnglish.equals("firewall")) {
			node = new TopoFirewallModel();
		} else if (typeEnglish.equals("server")) {
			node = new TopoServerModel();
		} else if (typeEnglish.equals("ids")) {
			node = new TopoIdsModel();
		} else if (typeEnglish.equals("weblogic")) {
			node = new TopoWeblogicModel();
		} else if (typeEnglish.equals("database")) {
			node = new TopoDatabaseModel();
		} else if (typeEnglish.equals("sealed")) {
			node = new TopoSealedModel();
		}else {
			node = new NodeModel();
		}
		return node;
	}

	public static void putType(List<NodeTypeEntity> types) {
		if (types == null)
			return;
		for (NodeTypeEntity type : types) {
			typeMap.put(type.getEnglishTag(), type);
		}
	}

	public static NodeTypeEntity getNodeTypeBySimpleClassName(String simpleName) {
		if (simpleName.equals("TopoRouterModel")) {
			return typeMap.get("router");
		} else if (simpleName.equals("TopoSwitchModel")) {
			return typeMap.get("switch");
		} else if (simpleName.equals("TopoSensorModel")) {
			return typeMap.get("pc");
		} else if (simpleName.equals("TopoFirewallModel")) {
			return typeMap.get("firewall");
		} else if (simpleName.equals("TopoIdsModel")) {
			return typeMap.get("ids");
		} else if (simpleName.equals("TopoServerModel")) {
			return typeMap.get("server");
		} else if (simpleName.equals("TopoWeblogicModel")) {
			return typeMap.get("weblogic");
		} else if (simpleName.equals("TopoDatabaseModel")) {
			return typeMap.get("database");
		} else if(simpleName.equals("TopoSealedModel")) {
			return typeMap.get("sealed");
		}
		return null;
	}

}
