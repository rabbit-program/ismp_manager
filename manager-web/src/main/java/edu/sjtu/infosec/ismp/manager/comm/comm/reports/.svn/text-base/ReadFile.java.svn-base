package edu.sjtu.infosec.ismp.manager.comm.comm.reports;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.OutputStream;

/**
 * 读取文件
 * @author Wu Guojie
 * @date 2009-7-2
 * @version 1.0
 */
public class ReadFile {
	public static void readFileToOutputStream(OutputStream out, String filePath) throws Exception {
        BufferedInputStream inputstream = new BufferedInputStream(new FileInputStream(filePath));
        byte[] b = new byte[100];
        int len;
        try{
            while((len=inputstream.read(b))>0)   {
            	out.write(b, 0, len);
            }
            inputstream.close();
            out.close();
        }catch(Exception e){
        	e.printStackTrace();
            out.close();
        	throw new Exception("下载文件时出错！");
        }
	}
}
