package edu.sjtu.infosec.ismp.manager.BSAM.comm;

import java.util.Comparator;

import edu.sjtu.infosec.ismp.security.Domain;
/**
 * 域排序比较器
 * @author cc
 * 2010-12-31 10:32:41
 */
public class DomainComparator implements Comparator<Domain> {
	///域比较器，用来对域进行自定义排序
	public int compare(Domain p1, Domain p2) {
		if(p1.getId() < p2.getId()){
			return -1;
		}else if(p1.getId() == p2.getId()){
			return 0;
		}else {
			return 1;
		}
	}
	
}
