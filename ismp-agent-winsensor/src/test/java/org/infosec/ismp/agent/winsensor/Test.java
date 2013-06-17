package org.infosec.ismp.agent.winsensor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rocky
 * @version create time：Nov 2, 2010 2:50:26 PM
 * 
 */
public class Test {
	
	public Map<String, List<String>> getList() {
		long maxId = 10000;
		List<String> alert = new ArrayList<String>();
		Map<String, List<String>>  value = new HashMap<String, List<String>>();
		value.put(String.valueOf(maxId), alert);
		return value;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello.");
		
		System.out.println("Long max value: " + Long.MAX_VALUE + " Long min value: " + Long.MIN_VALUE);
		
		DecimalFormat decimalFormat = new DecimalFormat();
		
		System.out.println("Double max value: " + decimalFormat.format(Double.MAX_VALUE) + " Long min value: " + Double.MIN_VALUE);
	}

}
