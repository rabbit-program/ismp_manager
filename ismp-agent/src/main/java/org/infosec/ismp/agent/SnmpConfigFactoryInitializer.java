package org.infosec.ismp.agent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.infosec.ismp.collectd.snmp.config.SnmpConfigFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

public class SnmpConfigFactoryInitializer {
	public static void init(String classpath) throws Exception {
		String resolvedLocation = SystemPropertyUtils
				.resolvePlaceholders(classpath);
		URL url = ResourceUtils.getURL(resolvedLocation);
		Resource resource = new UrlResource(url);

		SnmpConfigFactory.init(url.getFile());
	}

	public static void init(String[] classpathes) throws Exception {
		List<Resource> resourceList = new ArrayList<Resource>();
		Assert.notNull(classpathes, "the classpathes array must not be null");
		if(classpathes!=null){
			for (String classpath : classpathes) {
				String resolvedLocation = SystemPropertyUtils
						.resolvePlaceholders(classpath);
				URL url = ResourceUtils.getURL(resolvedLocation);
				Resource resource = new UrlResource(url);
				resourceList.add(resource);
				
			}
		}
		SnmpConfigFactory.init(resourceList.toArray(new Resource[0]));
	}
}
