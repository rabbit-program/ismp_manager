package edu.sjtu.infosec.ismp.manager.TM.manager.lewking;

import java.util.ArrayList;


public class FactoryBeanTest  {

	public static void main(String[] args){
		 
/*		Integer i = new Integer(42);
		Object o = new Object();
		System.out.println(i.equals(42));
		 
		System.out.println();
		
		String s = new String("42");
		
		Double d = new Double (42.0);
		Long l = new Long (42);
		String s1 = new String("42");
		System.out.println( d.equals(42));
		ArrayList al=new ArrayList();   
		int n=40;   
		Integer nI=new Integer(n);   
		al.add(n);//不可以   
		al.add(nI);//可以  
*/		 
		StringBuffer a = new StringBuffer("A");

        StringBuffer b = new StringBuffer("B");
        
        new FactoryBeanTest().operate(a,b);
        
       
        
        System.out.println(a + "," + b);
	}
	 void operate(StringBuffer x, StringBuffer y) {

		x.append(y);

		 y = x;

		
System.out.println();
	}

}
