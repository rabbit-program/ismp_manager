package edu.sjtu.infosec.ismp.util;

/**
 * ip地址格式化
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public class IpFormat {
	/**
	 * ip地址格式化为16进制字符串
	 * @param ip 各部分需要用“.”分隔开，例如“192.168.1.1”
	 * @return 16进制ip字符串（不被任何字符分割，例如“c0a80101”）
	 * @throws Exception
	 */
	public static String stingToHex(String ip) throws Exception {
		if(ip == null){
			throw new Exception("ip地址不能为null！");
		}else if(ip.equals("")){
			throw new Exception("ip地址不能为空字符串！");
		}else{
			String[] iPSubs = ip.split("\\.");
			if (iPSubs.length != 4) {
				throw new Exception("ip地址格式不对！");
			}else{
				if (!(iPSubs[0].matches("\\d{1,3}"))) {
					throw new Exception("ip地址第一段格式不对！");
				}
				if (!(iPSubs[1].matches("\\d{1,3}"))) {
					throw new Exception("ip地址第二段格式不对！");
				}
				if (!(iPSubs[2].matches("\\d{1,3}"))) {
					throw new Exception("ip地址第三段格式不对！");
				}
				if (!(iPSubs[3].matches("\\d{1,3}"))) {
					throw new Exception("ip地址第四段格式不对！");
				}
			}
	        //IP的四段
	        int ipSub1 = Integer.parseInt(iPSubs[0]);
	        int ipSub2 = Integer.parseInt(iPSubs[1]);
	        int ipSub3 = Integer.parseInt(iPSubs[2]);
	        int ipSub4 = Integer.parseInt(iPSubs[3]);

	        //开始IP的四段十六进制
	        String ipSub1H = Integer.toHexString(ipSub1);
	        if(ipSub1H.length()==1){
	        	ipSub1H="0"+ipSub1H;
	        }
	        String ipSub2H = Integer.toHexString(ipSub2);
	        if(ipSub2H.length()==1){
	        	ipSub2H="0"+ipSub2H;
	        }
	        String ipSub3H = Integer.toHexString(ipSub3);
	        if(ipSub3H.length()==1){
	        	ipSub3H="0"+ipSub3H;
	        }
	        String ipSub4H = Integer.toHexString(ipSub4);
	        if(ipSub4H.length()==1){
	        	ipSub4H="0"+ipSub4H;
	        }

	        //十六进制IP
	        String ipH = ipSub1H + ipSub2H + ipSub3H + ipSub4H;
			return ipH;
		}
	}

	/**
	 * 10进制ip地址格式化为16进制字符串
	 * @param ip 例如“3232235777”
	 * @return 16进制ip字符串（不被任何字符分割，例如“c0a80101”）
	 * @throws Exception
	 */
	public static String decimalToHex(Long ipD) throws Exception {
		String ipH = Long.toHexString(ipD);
		return ipH;
	}

	/**
	 * ip地址格式化为10进制long型数值
	 * @param ip 各部分需要用“.”分隔开，例如“192.168.1.1”
	 * @return long型10进制ip数值（不被任何字符分割，例如“3232235777”）
	 * @throws Exception
	 */
	public static long stingToDecimal(String ip) throws Exception {
		String ipH = stingToHex(ip);
		long ipD = Long.parseLong(ipH,16);
		return ipD;
	}

	/**
	 * 16进制ip地址格式化为10进制long型数值
	 * @param ip 8位16进制数的ip，例如“c0a80101”
	 * @return long型10进制ip数值（不被任何字符分割，例如“3232235777”）
	 * @throws Exception
	 */
	public static long hexToDecimal(String ipH) throws Exception {
		long ipD = Long.parseLong(ipH,16);
		return ipD;
	}

	/**
	 * 16进制ip地址格式化为用“.”分隔开字符串
	 * @param ip 8位16进制数的ip，例如“c0a80101”
	 * @return 用“.”分隔开ip字符串（不被任何字符分割，例如“192.168.1.1”）
	 * @throws Exception
	 */
	public static String hexToString(String ipH) throws Exception {
		if(ipH == null){
			throw new Exception("16进制的ip地址格式不对，ip地址不能为null！");
		}else if(ipH.equals("")){
			throw new Exception("16进制的ip地址格式不对，ip地址不能为空字符串！");
		}else if(ipH.length()!=8){
			throw new Exception("16进制的ip地址格式不对，不是8位16进制数的ip！");
		}else{
			String ipSub1 = ipH.substring(0, 2);
			String ipSub2 = ipH.substring(2, 4);
			String ipSub3 = ipH.substring(4, 6);
			String ipSub4 = ipH.substring(6, 8);
			
			long ipSub1D = Long.parseLong(ipSub1,16);
			long ipSub2D = Long.parseLong(ipSub2,16);
			long ipSub3D = Long.parseLong(ipSub3,16);
			long ipSub4D = Long.parseLong(ipSub4,16);
			
			String ip = ipSub1D + "." + ipSub2D + "." + ipSub3D + "." + ipSub4D;
			return ip;
		}
	}

	/**
	 * 10进制ip地址格式化为用“.”分隔开字符串
	 * @param ip 例如“3232235777”
	 * @return 用“.”分隔开ip字符串（不被任何字符分割，例如“192.168.1.1”）
	 * @throws Exception
	 */
	public static String decimalToString(Long ipD) throws Exception {
		String ipH = decimalToHex(ipD);
		String ip = hexToString(ipH);
		return ip;
	}
	
	
	
	//测试
	public static void main(String[] args) {
		try {
			String ip = "192.168.1.1";
			String ipH = "c0a80101";
			long ipD = 3232235777l;
			
			System.out.println(IpFormat.stingToHex(ip));
			System.out.println(IpFormat.decimalToHex(ipD));
			System.out.println(IpFormat.stingToDecimal(ip));
			System.out.println(IpFormat.hexToDecimal(ipH));
			System.out.println(IpFormat.hexToString(ipH));
			System.out.println(IpFormat.decimalToString(ipD));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
