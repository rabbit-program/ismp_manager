package org.infosec.ismp.model.event;

import org.infosec.ismp.model.Parm;
import org.infosec.ismp.model.Parms;

public class EventHelper {
	public static String getValue(Parms parms,String parmName){
		Parm[] parm = parms.getParm();
		String value=null;
		if(parm!=null&&parm.length>0){
			for(int i=0,count=parm.length;i<count;i++){
				if(parm[i].getParmName().equalsIgnoreCase(parmName)){
					value=parm[i].getValue().getContent();
					break;
				}
			}
		}
		
		return value;
	}
}
