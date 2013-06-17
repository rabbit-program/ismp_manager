package edu.sjtu.infosec.ismp.manager.AM.comm;

public class AssetConstant {

	// 网络设备类别
	public static final Integer NETWORK_DEVICE_TYPE = new Integer(1);
	// 安全设备类别
	public static final Integer SECURITY_DEVICE_TYPE = new Integer(2);
	// 服务器类别
	public static final Integer SERVER_DEVICE_TYPE = new Integer(3);
	// 终端pc类别
	public static final Integer TERMINAL_DEVICE_TYPE = new Integer(4);

	// 软件模块常量
	// 系统软件
	public static final String SOFT_OS = "os";
	//数据库
	public static final String SOFT_DB = "db";
	// 应用软件
	public static final String SOFT_APPLY = "app";
	// 开发工具
	public static final String SOFT_OA = "oa";
	//其他软件
	public static final String SOFT_OTHER = "other";

	// 硬件模块
	public static final String HARDWARE_CPU = "cpu";
	public static final String HARDWARE_HD = "harddisk";
	public static final String HARDWARE_MEM = "memory";
	public static final String HARDWARE_INF = "interface";

	// 可用性类别
	public static final Integer AVAILABILITY_ALIVE = new Integer(0);
	public static final Integer AVAILABILITY_CPU = new Integer(1);

	public static final Integer AVAILABILITY_MEM = new Integer(2);

	public static final Integer AVAILABILITY_HD = new Integer(3);
	
	public static final Integer AVAILABILITY_Net = new Integer(4);
	//统计表类别
	public static final Integer REPORT_DAY = new Integer(1);
	public static final Integer REPORT_MONTH = new Integer(2);
	
	//操作类型
	public static final String MAINTAIN_TYPE_ADD = "add";
	public static final String MAINTAIN_TYPE_DELETE = "delete";
	public static final String MAINTAIN_TYPE_UPDATE = "update";
	
	//asset通讯字
	
	public static final int DEVICE_MANAGER_TO_CENTER = 40;
	
	public static final int SOFTWARE_MANAGER_TO_CENTER = 41;
	
    public static final int HARDWARE_MANAGER_TO_CENTER = 42;
    
    public static final int POSITION_MANAGER_TO_CENTER = 43;
    
    public static final int ASSET_TO_SOFTWARE_MANAGER_TO_CENTER = 44;
    
    public static final int ASSET_TO_HARDWARE_MANAGER_TO_CENTER = 45;
    
    public static final int ASSET_TO_POSITION_MANAGER_TO_CENTER = 46;
    
    public static final int DAILY_AVAILABILITY_MANAGER_TO_CENTER = 47;
    
    public static final int MONTHLY_AVAILABILITY_MANAGER_TO_CENTER = 48;
    
    public static final int AVAILABILITY_AGENT_TO_MANAGER = 49;
    
    //asset通讯方法关键字
    
	public static final String ASSET_ADD = new String("add");
	public static final String ASSET_UPDATE = new String("update");
	public static final String ASSET_DELETE = new String("delete");
	
	
	
}
