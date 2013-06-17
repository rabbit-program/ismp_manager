此文档为WEB开发指导意见文档：
 一、文件存放位置
  1. js文件放在src/main/webapp/js文件下
  2. css文件放在src/main/webapp/css文件下
  3. 图片文件放在src/main/webapp/img文件下
  4. 所有页面共有文件放在src/main/webapp/common文件下
  5. 除以上文件，其他jsp文件放在src/main/webapp/WEB-INF/content文件下，按模块分文件夹
     放置，如登录页面文件放置在src/main/webapp/WEB-INF/content/login/目录下,以此类推，
     模块名由前台组长决定。
 =============================================================================
   注意：
 	一）、模块命名说明如下：
 		1、运维支撑（运维人员管理<pm>、运维知识库管理<klbm>、安全管理操作审计<smoa>、运维工单<wom>），简称"OSS"
 		2、拓扑管理，简称"TM"
 		3、资产管理，简称"AM"
 		4、病毒补丁（病毒管理<vm>、补丁管理<pm>、软件分发<sd>），简称"VPM"
 		5、事件管理，简称"EM"
 		6、态势感知，简称"BSAM"
 		7、日志审计（设备日志<dLog>、平台日志<pfLog>），简称"LM"
 		8、服务检测，简称"SCM"
 		9、风险评估，简称"RAM"
 		10、应急响应，简称"ERM"
 		11、告警管理，简称"AIM"
 		12、系统管理（系统用户<user>、系统配置<config>、系统论坛<bbs>、agent管理<agent>），简称"SYSM"
 		13、帮助，简称"HM"
 		14、等级保护，简称“GOSP”
        15、网站安全监测，简称“WSM”
 	二）、包结构说明：
 		1、所有的工具类全都放在edu.sjtu.infosec.ismp.util下
 		2、所有的公共类、接口、对象、action等都放在edu.sjtu.infosec.ismp.manager.comm下
 		3、各模块自有内容放在对应的模块内
 		4、所有的action类映射配置都放在src\main\resources\actions下
 		5、所有的action的struts配置都放在src\main\webapp\WEB-INF下
 		6、所有的dao配置都放在src\main\resources\dao下
 		7、所有的service配置都放在src\main\resources\service下
 		8、所有的sql脚本都放在src\main\resources\sql下
 		        该包下按照数据库类型进行分组，目前仅分为mysql和Oracle；
 		        每类数据库组下又分“表结构”和“初始化数据”组，各模块将各自的SQL脚本写入对应组下对应的“模块名.sql”文件中；
 		        平台启动和运行基本初始化数据写在每类数据库组下的“初始化数据.sql”中。
 	三）、web相关内容结构说明：
 		1、所有的js都放在src\main\webapp\js下对应的模块内，公共的直接放在src\main\webapp\js\comm
 		2、所有的css都放在src\main\webapp\css下对应的模块内，公共的直接放在src\main\webapp\css\comm
 		3、所有的img都放在src\main\webapp\img下对应的模块内，公共的直接放在src\main\webapp\img\comm
 		4、所有的公共页面都放在src\main\webapp\common下
 			a、所有的自定义标签都放在src\main\webapp\common\customTags下对应名称的文件夹下
 			b、所有的通用错误页面都放在src\main\webapp\common\errors下
 			c、所有的通用页面框架都放在src\main\webapp\common\frames下
 				主框架放在src\main\webapp\common\frames\main下，例如“home.jsp”
 				子框架放在src\main\webapp\common\frames\subs下，例如“top.jsp”
 			d、所有的通用警告页面都放在src\main\webapp\common\warns下
 			e、其他的直接放在src\main\webapp\common下
 			f、所有的分页都使用公用的页面<%@ include file="/common/customTags/page/page.jsp"%>；
 			        设置每页显示记录条数统一为：
 			            一级页面为5条；
 			            二级及其以下页面，各模块自行控制，可以设置为5条，也可设置为10条，主要根据页面效果来定。
 		5、各模块的页面都放在src\main\webapp\WEB-INF\content下对应的模块内
 	四）、用户权限相关内容全部放在“edu.sjtu.infosec.ismp.security”包下
 	五）、由于目前属于编码调试阶段，在下载manager-web工程的时候，必须同时下载ismp-manager-rmi工程，否则会报错：找不到ismp-manager-rmi
 =============================================================================
 二 、svn提交时注意不要导入target文件和.project,.classpath, .settings等eclipse配置文件，
   因为这些文件都是动态生成的，或者由maven插件生成的。