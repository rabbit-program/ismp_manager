/**
 * 
 */
package org.infosec.ismp.manager.server.event.analytic.trap;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jianyu Shen
 * 
 *         2009-6-15 下午07:58:39
 */
public class TrapTransformer {

	public TrapTransformer() {

	}

	public String transformLong2Time(String longTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		if (longTime.length() == 12)
			return simpleDateFormat.format(new Date(Long.parseLong(longTime)));
		else
			return simpleDateFormat.format(new Date(
					Long.parseLong(longTime) * 1000));
	}

	public String transformFirewallTime(String firewallTime) {
		String str = firewallTime.replaceAll("_", " ");
		String[] da = str.split(" ");
		String[] ti = da[0].split("-");
		if (ti[1].trim().length() == 1) {
			ti[1] = "0" + ti[1];
		}
		if (ti[2].trim().length() == 1) {
			ti[2] = "0" + ti[2];
		}
		str = ti[0] + "-" + ti[1] + "-" + ti[2] + " " + da[1];
		return str;
	}

	public String transformIdsTime(String idsTime) {
		String str = idsTime.replaceAll("_", " ");
		String[] da = str.split(" ");
		String[] ti = da[0].split("-");
		if (ti[1].trim().length() == 1) {
			ti[1] = "0" + ti[1];
		}
		if (ti[2].trim().length() == 1) {
			ti[2] = "0" + ti[2];
		}
		str = ti[0] + "-" + ti[1] + "-" + ti[2] + " " + da[1];
		return str;
	}

	public String transformIdsThreRank(String threRank) {
		String[] strs = threRank.split(":");
		String str = strs[1].trim();
		if (str.equals("高")) {
			str = "5";
		}
		if (str.equals("中")) {
			str = "3";
		}
		if (str.equals("低")) {
			str = "1";
		}
		return str;
	}
	
	public String transformIceyeIdsThreRank(String threRank) {
		String str = threRank.trim();
		if (str.equals("高")) {
			str = "5";
		}
		if (str.equals("中")) {
			str = "3";
		}
		if (str.equals("低")) {
			str = "1";
		}
		return str;
	}
	
	

	// public String transformType(Integer typeFlag){
	//    	
	// }
}
