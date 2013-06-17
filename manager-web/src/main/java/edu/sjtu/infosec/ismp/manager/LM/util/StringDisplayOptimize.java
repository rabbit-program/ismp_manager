package edu.sjtu.infosec.ismp.manager.LM.util;

import edu.sjtu.infosec.ismp.manager.LM.util.modle.StringOptimize;

public class StringDisplayOptimize {
	
	/**
	 * 2010-9-14 LINCHAO
	 * @param stringOptimize
	 * @param optimizeSize
	 * @return
	 */
	public static StringOptimize stringOptimize(String stringOptimize,Integer optimizeSize){
		StringOptimize so = new StringOptimize();
		
		so.setStringSize(stringOptimize.trim().length());
		so.setOptimizeSize(optimizeSize);
		so.setStringOptimize(stringOptimize);
		
		if(so.getStringSize()>=so.getOptimizeSize()){
			so.setStringOptimizeLater(stringOptimize.substring(0, optimizeSize)+"...");
			return so;
		}
		so.setStringOptimizeLater(stringOptimize);
		return so;
	}
	
	public static void main(String[] args) {
		StringOptimize so = stringOptimize("dfffffffffffffffffffffffffffffffffffff",10);
		System.out.println(so.getStringOptimizeLater());
	}
}
