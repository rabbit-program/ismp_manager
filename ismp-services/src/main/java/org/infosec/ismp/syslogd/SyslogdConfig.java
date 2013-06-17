package org.infosec.ismp.syslogd;

/**
 * 读取syslogd的配置信息，Agent和Manager上的配置信息读取方法可能不一致，
 * 都需要满足该接口。
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public interface SyslogdConfig {

	public int getSyslogPort();

	public UeiList getUeiList();

}
