package org.infosec.ismp.agent.winsensor;
/**
 * @author Rocky
 * @version create time：Oct 12, 2010 2:39:35 PM
 * 
 */
public class WinsensorConstant {
	
	//device is not monitor.
	public static final int DEVICE_NOT_MONITOR_STATUS = 0;
	
	//device is monitoring.
	public static final int DEVICE_MONITORING_STATUS = 1;
	
	// device is pause monitor.
	public static final int DEVICE_MONITOR_PAUSE_STATUS = 2;
	
	//Sensor client upload file size limit.
	public static final int UPLOAD_FILE_SIZE_LIMIT = 1*1024*1000;
	
	//Sensor client upload file buffer size.
	public static final int UPLOAD_FILE_BUFFER_SIZE = 2048;
	
	//Sensor client default timeout, millisecond.
	public static final long DEVICE_DEFAULT_TIMEOUT = 3*60*1000;
	
	//Sensor client default retries.
	public static final int DEVICE_DEFAULT_RETRIES = 3;
}
