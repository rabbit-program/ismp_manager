package org.infosec.ismp.agent.winsensor.util;

import java.util.Collection;

/**
 * @author Rocky
 * @version create time：Nov 19, 2010 10:41:19 AM
 * 
 */
public class CollectionsUtil {

	public static String mergeAllElements(Collection<String> collection) {
		StringBuffer stringBuffer = new StringBuffer();
		Object[] str = collection.toArray();
		
		for (int i = 0; i < str.length; i++) {
			if (i == str.length - 1) {
				stringBuffer.append(str[i].toString());
			} else {
				stringBuffer.append(str[i].toString()).append(",");
			}
		}
		
		return stringBuffer.toString();
	}
}
