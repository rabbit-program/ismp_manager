package edu.sjtu.infosec.sms.service.impl.CMCC.old;

import com.wondertek.esmp.esms.empp.EMPPConnectResp;
import com.wondertek.esmp.esms.empp.EMPPSubmitSMResp;
import com.wondertek.esmp.esms.empp.EmppApi;

public class MsgSendUseEMPP {
	private static MsgSendUseEMPP self = null;

	private MsgSendUseEMPP() {
	}

    public static MsgSendUseEMPP getInstance() {
	   if (self == null) {
	     self = new MsgSendUseEMPP();
	   }
	   return self;
	}
    
// 手机短信 单发
    public static void sendMobileMes(String mobileNo, String message,String socketServerAddress, 
    		Integer prot,String accountId,String password,String serviceId) {
    	
    	EmppApi emppApi = new EmppApi();
		RecvListener listener = new RecvListener(emppApi);

		try {
			//建立同服务器的连接
			EMPPConnectResp response = emppApi.connect(socketServerAddress, prot,accountId,
					password, listener);
			System.out.println(response);
			if (response == null) {
				System.out.println("连接超时失败");
				return;
			}
			if (!emppApi.isConnected()) {
				System.out.println("连接失败:响应包状态位=" + response.getStatus());
				return;
			}
		} catch (Exception e) {
			System.out.println("发生异常，导致连接失败");
			e.printStackTrace();
			return;
		}
		
//		发送短信
		if (emppApi.isSubmitable()) {
			
			//简单方式发送短信,支持长短信
			try{
//				emppApi.submitMsgAsync(message,new String[]{mobileNo},serviceId);
				
				//同步发送方式update 20060307
				EMPPSubmitSMResp []  resp = emppApi.submitMsg(message,new String[]{mobileNo},serviceId);
				System.out.println("resp result:"+resp[0].getResult());

			}catch (Exception e1) {
				e1.printStackTrace();
			} 
			
	//		详细设置短信的各个属性,不支持长短信
//			EMPPSubmitSM msg = (EMPPSubmitSM) EMPPObject
//					.createEMPP(EMPPData.EMPP_SUBMIT);
//			String mobile = "13564468230";
//			List dstId = new ArrayList();
//			dstId.add(mobile);
//
//			msg.setDstTermId(dstId);
//			msg.setSrcTermId(accountId);
//			msg.setServiceId(serviceId);
//
//			EMPPShortMsg msgContent = new EMPPShortMsg(
//					EMPPShortMsg.EMPP_MSG_CONTENT_MAXLEN);
//
//			try {
//				msgContent.setMessage("09939可以收发短信");
//				msg.setShortMessage(msgContent);
//				msg.assignSequenceNumber();
//				emppApi.submitMsgAsync(msg);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
		}
    }
    
	public static void main(String[] args) {

		String host = "192.168.0.215";
		int port = 9981;
		String accountId = "555580001";
		String password = "cool1226";
		String serviceId = "555580001";
		System.out.println("####################");
		MsgSendUseEMPP.sendMobileMes("18918397176", "测试短信", host, port, accountId, password, serviceId);
		System.out.println("####################");
	}
}
