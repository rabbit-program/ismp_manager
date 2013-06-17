package edu.sjtu.infosec.ismp.manager.AIM.dao.impl;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.infosec.ismp.manager.rmi.aim.model.AlertInfoBO;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.sjtu.infosec.ismp.manager.AIM.dao.SendAlertDao;
import edu.sjtu.infosec.ismp.manager.AIM.model.AlertRuleBO;
import edu.sjtu.infosec.ismp.manager.AIM.service.AlertFusionRuleServices;
import edu.sjtu.infosec.ismp.manager.comm.comm.send.SendMsg;

public class SendAlertDaoImpl extends HibernateDaoSupport implements
		SendAlertDao {

	
	private String mailaddress;// 邮件服务器地址
	private String addresser;// 发件人
	private String mailPassword;// 邮件密码
	private String socketServerAddress;// 发送手机短消息的socket服务器 IP地址
	private Integer port;// 端口

	public void setSocketServerAddress(String socketServerAddress) {
		this.socketServerAddress = socketServerAddress;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	public void setAddresser(String addresser) {
		this.addresser = addresser;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}
	public boolean sendAlertService(AlertInfoBO alertInfoBO) throws Exception {
		initConfig();
		Criteria cri = getSession().createCriteria(AlertRuleBO.class);
		List<AlertRuleBO> list = this.getListByCriteria(alertInfoBO, cri);
		if(list!=null && list.size()>0){
			for(AlertRuleBO alertRuleBO :list){
				// 并且根据规则执行相应的消息发送
				// 判断是否发送邮件
				if (alertRuleBO.getSendEmail() != null
						&& alertRuleBO.getSendEmail() > 0
						&& alertRuleBO.getSendEmail() == 1) {
                    String emailTargets []=alertRuleBO.getEmailTarget().split(";");
                    if(emailTargets!=null&&emailTargets.length>0){
                        int i=0;
                        for (String string : emailTargets) {
                        	if(i>=10){
                        		break;
                        	}
                        	SendMsg.sendMail(string, alertInfoBO.getAlertReason(), socketServerAddress, port);
							i++;
						}
                    }
					
				}
				// 判断是否发送桌面消息
				if (alertRuleBO.getSendMsg() != null
						&& alertRuleBO.getSendMsg() > 0
						&& alertRuleBO.getSendMsg() == 1) {
					String msgTargets[]=alertRuleBO.getMsgTarget().split(";");
					 if(msgTargets!=null&&msgTargets.length>0){
	                        int i=0;
	                        
	                        for (String string : msgTargets) {
	                        	if(i>=10){
	                        		break;
	                        	}
	                        	i++;
	                        	SendMsg.sendNetMsg(string, alertInfoBO.getAlertReason());
	                        }
					 }
				}
				// 判读规则中是否要发送短消息
				if (alertRuleBO.getSendSms() != null
						&& alertRuleBO.getSendSms() > 0
						&& alertRuleBO.getSendSms() == 1) {
					String mobileMess [] =alertRuleBO.getSmsTarget().split(";");
					 if(mobileMess!=null&&mobileMess.length>0){
	                        int i=0;
	                        //发送邮件到规则中指定的 邮箱地址 ,最多10个
	                        
	                        for (String string : mobileMess) {
	                        	if(i>=10){
	                        		break;
	                        	}
	                        	i++;
//					           MsgSend.sendMobileMes(string,
//							       context, socketServerAddress, port);
	                        	SendMsg.sendMobileMes(string, alertInfoBO.getAlertReason(), socketServerAddress, port);
	                        }
					 }
				}
				
			}
		}
		return false;
	}
	
	private List<AlertRuleBO> getListByCriteria(AlertInfoBO alertInfoBO,Criteria criteria){
		criteria.add(Restrictions.gt("priority", alertInfoBO.getLevel()));
		criteria.add(Restrictions.eq("type", alertInfoBO.getAlertType()));
		criteria.add(Restrictions.eq("subType", alertInfoBO.getAlertSubType()));
		criteria.add(Restrictions.eq("deprecated", 1));
		criteria.add(Restrictions.eq("enabled", 1));
		return criteria.list();
	}
	
	private void initConfig(){
		Properties properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("mailConfig.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		socketServerAddress = properties.getProperty("socket.address");
		port = Integer.parseInt(properties.getProperty("socket.port"));
	}
	
}
