package edu.sjtu.infosec.ismp.manager.comm.comm.send;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;

import org.apache.log4j.Logger;

import edu.sjtu.infosec.ismp.util.EscapeUnescape;

public class SendMsg {
	private static Logger logger = Logger.getLogger(SendMsg.class);
	/**
     * 手机短信 （单发）
     * @param mobileNo
     * @param message
     * @param socketServerAddress
     * @param prot
     * @param accountId
     * @param password
     * @param serviceId
     */
    public static String sendMobileMes(String mobile, String message, String socketIp, Integer socketProt) {
    	String serverSay = "";
        try{
            String toSay = "sms|"+mobile+"|"+message;//只用修改此参数，其他的均不用变
            toSay = EscapeUnescape.escape(toSay);
            
            Socket s1 = new Socket(socketIp, socketProt);
            Socket s2 = new Socket(socketIp, socketProt);
    		logger.debug("Client启动成功!\n==========================================");
            OutputStream s1out = s1.getOutputStream();
            BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(s1out));
            bw1.write(toSay);
            bw1.close();
            s1.close();
            InputStream is1 = s2.getInputStream();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
            String line = null;
            while((line=br1.readLine()) != null){
                if(serverSay!=null && !serverSay.equals("")){
                    serverSay = serverSay + "\n" + line;
                }else{
                    serverSay = serverSay + line; 
                }
            }
    		logger.debug("服务器说：" + serverSay);
            br1.close();
            s2.close();
    		logger.debug("==========================================\nClient操作结束!");
        }catch(ConnectException connExc){
        	serverSay = "3";
    		logger.debug("Could not connect to the server!");
    		logger.debug("Client启动失败!\n==========================================");
        }catch(IOException e){
        	serverSay = "4";
            e.printStackTrace();
    		logger.debug("Client操作失败!\n==========================================");
        }
		return serverSay;
    }
    /**
     * 手机群发
     * @param mobileNos
     * @param message
     * @param socketServerAddress
     * @param prot
     */
    public static void sendMobileMes(String mobileNos[], String message,
    		String socketIp, Integer socketProt) {
        try{
        	String serverSay = "";
        	String mobiles = "";
        	for(String mobile : mobileNos){
        		if(mobiles!=null && !mobiles.equals("")){
        			mobiles = mobiles + mobile;
        		}else{
            		mobiles = mobile;
        		}
        	}
            String toSay = "sms|"+mobiles+"|"+message;//只用修改此参数，其他的均不用变
            toSay = EscapeUnescape.escape(toSay);
            
            Socket s1 = new Socket(socketIp, socketProt);
            Socket s2 = new Socket(socketIp, socketProt);
    		logger.debug("Client启动成功!\n==========================================");
            OutputStream s1out = s1.getOutputStream();
            BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(s1out));
            bw1.write(toSay);
            bw1.close();
            s1.close();
            InputStream is1 = s2.getInputStream();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
            String line = null;
            while((line=br1.readLine()) != null){
                if(serverSay!=null && !serverSay.equals("")){
                    serverSay = serverSay + "\n" + line;
                }else{
                    serverSay = serverSay + line; 
                }
            }
    		logger.debug("服务器说：" + serverSay);
            br1.close();
            s2.close();
    		logger.debug("==========================================\nClient操作结束!");
        }catch(ConnectException connExc){
    		logger.debug("Could not connect to the server!");
    		logger.debug("Client启动失败!\n==========================================");
        }catch(IOException e){
            e.printStackTrace();
    		logger.debug("Client操作失败!\n==========================================");
        }
    }
    /**
     * 发送邮件
     * @param email 邮箱地址
     * @param message 邮件内容
     * @param socketIp 远程服务IP
     * @param socketProt 远程服务端口
     */
    public static String sendMail(String email, String message, String socketIp, Integer socketProt){
    	String serverSay = "";
        try{
            String toSay = "email|"+email+"|"+message;//只用修改此参数，其他的均不用变
            toSay = EscapeUnescape.escape(toSay);
            
            Socket s1 = new Socket(socketIp, socketProt);
            Socket s2 = new Socket(socketIp, socketProt);
    		logger.debug("Client启动成功!\n==========================================");
            OutputStream s1out = s1.getOutputStream();
            BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(s1out));
            bw1.write(toSay);
            bw1.close();
            s1.close();
            InputStream is1 = s2.getInputStream();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
            String line = null;
            while((line=br1.readLine()) != null){
                if(serverSay!=null && !serverSay.equals("")){
                    serverSay = serverSay + "\n" + line;
                }else{
                    serverSay = serverSay + line; 
                }
            }
    		logger.debug("服务器说：" + serverSay);
            br1.close();
            s2.close();
    		logger.debug("==========================================\nClient操作结束!");
        }catch(ConnectException connExc){
        	serverSay = email + ":false";
    		logger.debug("Could not connect to the server!");
    		logger.debug("Client启动失败!\n==========================================");
        }catch(IOException e){
        	serverSay = email + ":false";
            e.printStackTrace();
    		logger.debug("Client操作失败!\n==========================================");
        }
		return serverSay;
    }
    /**
     * 发送桌面消息
     * @param address
     * @param message
     */
    public static void sendNetMsg(String address, String message) {
    	try {
			Process p = Runtime.getRuntime().exec(
					"net send " + address + " " + message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
	public static void main(String[] args) {
		String mess = "浦东安管平台：" 
						+ "\n中心端服务器中上传了一个软件 "
						+ "\n\t软件名称:mail.exe"
						+ "\n\t软件大小:123456字节";
		String emailTo = "wuguojie@pengyue.com.cn";
		String socketIp = "127.0.0.1";
		int socketProt = 5432;
		
		SendMsg.sendMail(emailTo, mess, socketIp, socketProt);
	}
}
