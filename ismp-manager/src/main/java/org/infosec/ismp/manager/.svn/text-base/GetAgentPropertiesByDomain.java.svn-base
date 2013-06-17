package org.infosec.ismp.manager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.collections.iterators.IteratorEnumeration;

/**
 * 获取domain-agent.properties文件属性
 * @author jiel
 *
 */
public class GetAgentPropertiesByDomain {
	private static Map<String,List<String>> agents = new HashMap<String,List<String>>();
	
	 static{
		InputStream is = GetAgentPropertiesByDomain.class.getResourceAsStream("/domain-agent.properties");				
		Properties props = new Properties(); 
		try {
			props.load(is);
			Set keys = props.keySet();
			for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
				String key =  iterator.next();
				String property=props.getProperty(key);
				List<String> propertyList = new ArrayList<String>();
				if(property!=null&&!"".equals(property)){
					String[] propertys =property.split(",");				
					for (int i = 0; i < propertys.length; i++) {
						propertyList.add(propertys[i]);
					}
				}
				agents.put(key, propertyList);
			}		
		} catch (IOException e) {
			e.printStackTrace();
		}	finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}				
	}
	/**
	 * 根据domain-agent.properties文件KEY获取value列表值
	 * @param domain
	 * @return
	 */
	public List<String> getAgentNames(String domain){		
		return agents.get(domain);
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		GetAgentPropertiesByDomain domain = new GetAgentPropertiesByDomain();		
		List agents1 = domain.getAgentNames("testDomain1");
		System.out.println(agents1);
		if(null!=agents1){
			for (int i = 0; i < agents1.size(); i++) {
				System.out.println(agents1.get(i));
			}			
		}

	}

}
