package org.infosec.ismp.applet.manager.utilities;

import java.util.HashMap;
import java.util.Map;

import org.infosec.ismp.applet.manager.model.TopoDataBox;
import org.infosec.ismp.manager.rmi.tm.manager.model.DeviceModelEntity;
import org.infosec.ismp.manager.rmi.tm.manager.model.TradeMarkEntity;

import twaver.TDataBox;

public class TopoConst {
	   public static boolean isInited= false;
	   public static final TDataBox BOX = new TopoDataBox("网络设备");
	   public static  String DOMAIN_ID = "domain_id_";
	   public static final String TOOLBAR = "FeaturesEditorToolbar";
	   public static DeviceModelEntity[] DEVICE_MODELS;
	   public static TradeMarkEntity[] TRADE_MARKS;
	   public static Map<TradeMarkEntity,DeviceModelEntity[]> MODELS_WITH_BRAND 
			= new HashMap<TradeMarkEntity,DeviceModelEntity[]>();
	   
	   private static Map<String,String> GUI_ID = new HashMap<String,String>();
	   private static Map<String,String> DATABASE_ID = new HashMap<String,String>();
	   
	   /**
	    * 根据数据库ID 获得界面ID
	    * @param databaseId 数据库ID
	    * @return GUI_ID
	    */
	   public static String getTopoID(String databaseId) {
		  return  GUI_ID.get(databaseId);
	   }   
	   
	   /**
	    * 根据GUI_ID 查找数据ID
	    * @param guid
	    * @return
	    */
	   public static String getDatabaseID(String guid) {
		  return  DATABASE_ID.get(guid);
	   }   
	   
	   /**
	    * 注册两个关联的对象ID
	    * @param databasId
	    * @param guid
	    */
	   public static void registerID(String databasId,String guid) {
		   GUI_ID.put(databasId, guid);
		   DATABASE_ID.put(guid, databasId);
	   }
	/*   
	   
	   private static Map<String,NodeEntity> NODELENTITY_BY_DOMAINMODEL_ID = new HashMap<String,NodeEntity>();
	   private static Map<String,DomainModel> DOMAINMODEL_BY_NODELENTITY_ID = new HashMap<String,DomainModel>();
	   */
	   /**
	    * 注册两个Domain关联对象
	    * @param databasId
	    * @param guid
	    */
//	   public static void registerDomain(NodeEntity databaseNode,DomainModel guiModel) {
//		   NODELENTITY_BY_DOMAINMODEL_ID.put(guiModel.getID().toString(), databaseNode);
//		   DOMAINMODEL_BY_NODELENTITY_ID.put(databaseNode.getNodeId(), guiModel);
//	   }
//	   
//	   public static NodeEntity getNodeEntityByDomainModeId(String domainId) {
//		   return NODELENTITY_BY_DOMAINMODEL_ID.get(domainId);
//	   }
//	   
//	   public static 
}
