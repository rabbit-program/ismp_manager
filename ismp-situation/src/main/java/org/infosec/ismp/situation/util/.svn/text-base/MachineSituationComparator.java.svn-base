package org.infosec.ismp.situation.util;

import java.util.Comparator;

import org.infosec.ismp.situation.model.MachineSituation;

/**
 * 主机态势排序比较器
 * @author cc
 * 2011-3-7 14:34:00
 */
public class MachineSituationComparator implements Comparator<MachineSituation> {
	///域比较器，用来对域进行排序
	public int compare(MachineSituation m1, MachineSituation m2) {
		if(m1.getWholeSituation() < m2.getWholeSituation()){
			return 1;
		}else if(m1.getId() == m2.getId()){
			return 0;
		}else {
			return -1;
		}
	}
	
}
