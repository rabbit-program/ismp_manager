package org.infosec.ismp.agent.winsensor.communication.services;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Rocky
 * @version create time：Oct 11, 2010 2:21:48 PM
 * 
 */
public class HostResourcesHolderTest {

	@SuppressWarnings("unchecked")
	public void parseXmlFile(File file) {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(file);
			Element root = document.getRootElement();
			System.out.println(root.getName());
			System.out.println(root.getStringValue());
			
			for(Iterator<Element> i = root.elementIterator(); i.hasNext();) {
				Element element = i.next();
				System.out.println(element.getName());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HostResourcesHolderTest hostResourcesHolderTest = new HostResourcesHolderTest();
		hostResourcesHolderTest.parseXmlFile(
				new File("D:\\RockyWorkSpace\\ismp-agent-winsensor\\src\\main\\resources\\hostResources.xml"));
	}

}
