package org.infosec.ismp.manager.ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

/**
 * 用于windows下ping服务
 * 
 * @author jiel
 * 
 */
public class WindowsPinger {

	public static String ping(String ip) throws IOException {
		StringBuffer pingResult = new StringBuffer();

		StringBuffer pingCmd = new StringBuffer("ping " + ip);		
			Runtime r = Runtime.getRuntime();
			Process p = r.exec(pingCmd.toString());
			BufferedReader in = new BufferedReader(new InputStreamReader(p
					.getInputStream(),"GB2312"));
			char[] charbuffer = new char[256] ;
			int count;
			while ((count=in.read(charbuffer))>0) {
				pingResult.append(charbuffer,0,count);				
			}
			in.close();
//			  byte[] buffer = new byte[256];
//			  int cnt = 0;
//			  InputStream is = p.getInputStream();
//			  while((cnt=is.read(buffer))>=0) {
////			   System.out.print(new String(buffer,0,cnt));
//			   pingResult.append(new String(buffer,0,cnt,"GB2312"));
//			  }
//			  is.close();
		return pingResult.toString();
	}
	public static void main(String[] args) throws IOException {
		System.out.println(ping("www.163.com"));
	}

}
