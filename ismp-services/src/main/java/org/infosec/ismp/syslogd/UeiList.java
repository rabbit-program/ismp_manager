package org.infosec.ismp.syslogd;

import java.util.ArrayList;
import java.util.List;

/**
 * syslog事件匹配方案的集合
 * @author <a href="mailto:lianglin1979@sjtu.edu.cn">lianglin</a>
 *
 */
public class UeiList {
	private final List<UeiMatch> ueiMatchList;

	public UeiList() {
		this.ueiMatchList = new ArrayList<UeiMatch>();
	}

	public void addUeiMatch(final UeiMatch ueiMatch) {
		this.ueiMatchList.add(ueiMatch);
	}

	public void addUeiMatch(final int index, final UeiMatch ueiMatch) {
		this.ueiMatchList.add(index, ueiMatch);
	}

	public List<UeiMatch> getUeiMatchCollection() {
		return new ArrayList<UeiMatch>(ueiMatchList);
	}

}
