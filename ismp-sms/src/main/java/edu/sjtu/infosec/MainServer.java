package edu.sjtu.infosec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import edu.sjtu.infosec.comm.EscapeUnescape;
import edu.sjtu.infosec.email.service.EmailSendService;
import edu.sjtu.infosec.email.service.impl.EmailSendServiceImpl;
import edu.sjtu.infosec.sms.service.SmsService;
import edu.sjtu.infosec.sms.service.impl.DaMeng.SmsServiceImpl;

/**
 * 发短消息和邮件的服务启动类
 * @author Wu Guojie
 * @date 2010-8-16
 * @version 1.0
 * 注意：
 * 		一、发送格式为：发送方式|接收方|信息
 * 			“发送方式”说明：
 * 				1、“all”表示手机和邮箱共同发送
 * 				2、“email”表示只发邮件
 * 				3、“sms”表示只发短信
 * 			“接收方”说明：
 * 				1、只发短信，此处格式为：“手机1,手机2,...”
 * 				2、只发邮件，此处格式为：“邮箱1,邮箱2,...”
 * 				3、手机和邮箱共同发送，此处格式为：“手机1,手机2,...;邮箱1,邮箱2,...”
 * 			“信息”说明：
 * 				此处为要发送的内容
 * 		二、发送端要求，以字符串形式进行发送，字符串格式如上发送格式说明，发送的文本需要通过EscapeUnescape类中的escape方法先进行编码，再发送，以解决中文乱码的问题
 * 			例如：
 * 				String say = "all|手机1,手机2,...;邮箱1,邮箱2,...|信息内容";
 * 				say = EscapeUnescape.escape(toSay);
 * 			同时，要求发送端要有两个Socket，一个用于发送消息，一个用于接收回复
 */
public class MainServer {
	public static void main(String[] args) {
        System.out.println("Server开始启动...");
        int port = 5432;
        ServerSocket s = null;
        //在端口5432上注册service
        try{
            s = new ServerSocket(port);
            System.out.println("Server启动成功，服务链接端口为：" + port + "!\n==========================================");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Server启动失败!\n==========================================");
        }
        
        while(true){
            String clientSay = "";
            try{
                Socket s1 = s.accept();
                Socket s2 = s.accept();
                
                InputStream is1 = s1.getInputStream();
                BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
                String line = null;
                while((line=br1.readLine()) != null){
                    clientSay = clientSay + line; 
                }
                br1.close();
                s1.close();
                clientSay = EscapeUnescape.unescape(clientSay);
                System.out.println("客户端说：" + clientSay);
                
                OutputStream s1out = s2.getOutputStream();
                BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(s1out));
                
                String[] cs = clientSay.split("\\|");
//                System.out.println("长度："+cs.length);
                if(cs!=null && cs.length>=3){
        			String server = "smtp.sina.com.cn";
        			String from = "sxq236@sina.com";
        			String password = "123456";
        			
            		String socketAddr = "172.16.1.2";
            		Integer prot = 9110;
            		
                	String sf = cs[0];
                	String st = cs[1];
                	String mess = cs[2];
            		
                	if(sf.equals("all")){//all
                		if(st!=null && !st.trim().equals("")){
                    		String[] sta = st.split(";");
                    		if(sta!=null && sta.length==2){
                    			String mta = sta[0];
                    			String eta = sta[1];
                    			if(mta!=null && !mta.trim().equals("")){
                            		String[] mt = mta.split(",");
                            		String[] et = eta.split(",");
                            		
                            		if(mt!=null && mt.length>=1){
                            			SmsService ss = new SmsServiceImpl();
                            			if(mt.length == 1){
                                			String mobile = mt[0];
                                			try {
                                				String state = ss.sendMessToOneState(mobile, mess, socketAddr, prot);
        	                                	bw1.write(state);
        									} catch (Exception e) {
        	                                	bw1.write("0");
//        										e.printStackTrace();
        									}
                            			}else{
                                			try {
                                				ss.sendMessToMuch(mt, mess, socketAddr, prot);
        	                                	bw1.write("短信已发送，成功与否未知！");
        									} catch (Exception e) {
        	                                	bw1.write("短信发送出错，发送方式为：all.sms！");
//        										e.printStackTrace();
        									}
                            			}
                            		}else{
                                    	bw1.write("数据格式传输有误，发送方式为：all.sms！");
                            		}
                            		
                            		if(et!=null && et.length>=1){
                            			EmailSendService ess = new EmailSendServiceImpl();
                                    	bw1.write(";");
                            			int i = 0;
                            			for(String emailTo : et){
                            				if(i>0){
                                            	bw1.write(",");
                            				}
                                			boolean esss = ess.send(emailTo, mess, server, from, password);
                                        	bw1.write(emailTo+":"+esss);
                                        	i++;
                            			}
                            		}else{
                                    	bw1.write("数据格式传输有误，发送方式为：all.email！");
                            		}
                    			}else{
                                	bw1.write("数据格式传输有误，发送方式为：all！");
                    			}
                    		}else{
                            	bw1.write("数据格式传输有误，发送方式为：all！");
                    		}
                		}else{
                			bw1.write("数据格式传输有误，发送方式为：all！");
                		}
                	}else if(sf.equals("email")){//email
                		if(st!=null && !st.trim().equals("")){
                    		String[] et = st.split(",");
                    		if(et!=null && et.length>=1){
                    			EmailSendService ess = new EmailSendServiceImpl();
                    			int i = 0;
                    			for(String emailTo : et){
                    				if(i>0){
                                    	bw1.write(",");
                    				}
                        			boolean esss = ess.send(emailTo, mess, server, from, password);
                                	bw1.write(emailTo+":"+esss);
                                	i++;
                    			}
                    		}else{
                            	bw1.write("数据格式传输有误，发送方式为：email！");
                    		}
                		}else{
                			bw1.write("数据格式传输有误，发送方式为：email！");
                		}
                	}else if(sf.equals("sms")){//sms
                		if(st!=null && !st.trim().equals("")){
                    		String[] mt = st.split(",");
                    		if(mt!=null && mt.length>=1){
                    			SmsService ss = new SmsServiceImpl();
                    			if(mt.length == 1){
                        			String mobile = mt[0];
                        			try {
                        				String state = ss.sendMessToOneState(mobile, mess, socketAddr, prot);
	                                	bw1.write(state);
									} catch (Exception e) {
	                                	bw1.write("0");
//										e.printStackTrace();
									}
                    			}else{
                        			try {
                        				ss.sendMessToMuch(mt, mess, socketAddr, prot);
	                                	bw1.write("短信已发送，成功与否未知！");
									} catch (Exception e) {
	                                	bw1.write("短信发送出错，发送方式为：sms！");
//										e.printStackTrace();
									}
                    			}
                    		}else{
                            	bw1.write("数据格式传输有误，发送方式为：sms！");
                    		}
                		}else{
                			bw1.write("数据格式传输有误，发送方式为：sms！");
                		}
                	}else{
                    	bw1.write("数据格式传输有误，发送方式为：sms！");
                	}
                }else{
                	bw1.write("数据不能为空，发送方式为：sms！");
                }
                bw1.close();
                s2.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
	}
}
