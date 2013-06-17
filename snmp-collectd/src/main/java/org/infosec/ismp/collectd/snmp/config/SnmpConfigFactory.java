package org.infosec.ismp.collectd.snmp.config;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.infosec.ismp.collectd.snmp.castor.CastorUtils;
import org.infosec.ismp.collectd.snmp.configuration.Column;
import org.infosec.ismp.collectd.snmp.configuration.Device;
import org.infosec.ismp.collectd.snmp.configuration.SnmpConfiguration;
import org.infosec.ismp.collectd.snmp.configuration.Table;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

/**
 * @author guoxianwei
 * @date 2010-11-2 下午01:39:38
 * 
 */
public class SnmpConfigFactory implements SnmpConfig {

	/**
	 * The config class loaded from the config file
	 */
	protected SnmpConfiguration m_config;

	private static SnmpConfig m_singleton = null;

	private static boolean m_loaded = false;

	private SnmpConfigFactory(String configFile) throws IOException,
			MarshalException, ValidationException {
		createSnmpConfiguration(configFile);
	}

	public SnmpConfigFactory(Resource[] res) {
		Assert.notNull(res, "res  must not be null");
		m_config = SnmpConfiguration.newSnmpConfiguration();

		for (Resource r : res) {
				Device device;
				try {
					device = CastorUtils.unmarshal(Device.class,
							r);
					m_config.addDevice(device);
				} catch (MarshalException e) {
					e.printStackTrace();
				} catch (ValidationException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

				


		}

	}

	/**
	 * Load the config from the default config file and create the singleton
	 * instance of this factory.
	 * 
	 * @throws java.io.IOException
	 *             Thrown if the specified config file cannot be read
	 * @throws org.exolab.castor.xml.MarshalException
	 *             Thrown if the file does not conform to the schema.
	 * @throws org.exolab.castor.xml.ValidationException
	 *             Thrown if the contents do not match the required schema.
	 */
	public static synchronized void init(String dir) throws IOException,
			MarshalException, ValidationException {
		if (m_loaded) {
			return;
		}

		m_singleton = new SnmpConfigFactory(dir);

		m_loaded = true;
	}

	private synchronized void createSnmpConfiguration(String fileDir)
			throws IOException, MarshalException, ValidationException {
		Assert.notNull(fileDir, "FileDir  must not be null");
		File cfgFile = new File(fileDir);
		if (cfgFile.isDirectory()) {
			m_config = SnmpConfiguration.newSnmpConfiguration();
			File[] files = cfgFile.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.getName().toLowerCase().endsWith("xml")) {
						Device device = CastorUtils.unmarshal(Device.class,
								new FileSystemResource(file));

						m_config.addDevice(device);
					}

				}
			}

		}
	}

	@Override
	public synchronized SnmpConfiguration getConfiguration() {
		if (m_config == null) {
			throw new IllegalStateException(
					"The device xml file has not been loaded");
		}
		return m_config;
	}

	@Override
	public synchronized Device getDevice(final String deviceType,
			final String brand) {
		if (devices() != null) {
			for (Device dev : devices()) {
				if (dev.getType().equals(deviceType)
						&& (dev.getBrand() == null || "".equals(dev.getBrand()) || dev
								.getBrand().equals(brand))) {
					return dev;
				}
			}
		}

		return null;
	}

	@Override
	public Table getTableInDevice(String tableName, Device dev) {
		for (Table tab : tables(dev)) {
			if (tableName.equals(tab.getName()))
				return tab;
		}
		return null;
	}

	@Override
	public Enumeration<Device> enumerateDevice() {
		return getConfiguration().enumerateDevice();
	}

	public Iterable<Table> tables(Device dev) {
		return dev.getTableCollection();
	}

	public Iterable<Device> devices() {
		return getConfiguration().getDeviceCollection();
	}

	public Iterable<Column> columns(Table table) {
		return table.getColumnCollection();
	}

	public static synchronized SnmpConfig getInstance() {
		if (!m_loaded)
			throw new IllegalStateException(
					"The factory has not been initialized");

		return m_singleton;
	}

	public static synchronized void setInstance(SnmpConfig config) {
		m_singleton = config;
		m_loaded = true;
	}

	public static void init(Resource[] array) {
		if (m_loaded) {
			return;
		}

		m_singleton = new SnmpConfigFactory(array);

		m_loaded = true;

	}

}
