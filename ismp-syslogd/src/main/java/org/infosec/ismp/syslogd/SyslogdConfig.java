package org.infosec.ismp.syslogd;

import org.infosec.ismp.model.syslog.UeiList;
import org.infosec.ismp.model.syslog.UeiMatch;

/**
 * 读取syslogd的配置信息，Agent和Manager上的配置信息读取方法可能不一致，
 * 都需要满足该接口。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public interface SyslogdConfig {
	/**
	 * 获取syslog接受端口
	 * @return
	 */
	public int getSyslogPort();

	/**
	 * 获得所有的匹配对象
	 * @return
	 */
	public UeiList getUeiList();

	/**
	 * 与数据库同步
	 */
	public void synDataSource();

	public void saveUeiMatch(UeiMatch ueiMatch);

	public void deleteUeiMatch(UeiMatch ueiMatch);

}
