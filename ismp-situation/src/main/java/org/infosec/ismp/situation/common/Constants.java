package org.infosec.ismp.situation.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 常量.
 * 
 */
public class Constants {
	
	public Constants(){
		if(T == 0){
			setT(readT());
		}
	}

    /**
     * getDatePattern
     * 
     * @param key
     *            key
     * @return datePattern
     */
    public static synchronized String getDatePattern(String key) {
//        String retValue = "";
//        Locale locale = LocaleContextHolder.getLocale();
//        try {
//            retValue = ResourceBundle.getBundle(Constants.BUNDLE_KEY, locale)
//                    .getString(key);
//        } catch (MissingResourceException mse) {
//            retValue = "";
//        }
        return "yyyy-MM-dd HH:mm:ss";
    }

    

    /** DELAYTIME */
    public static final String DELAYTIME = "240";

    /** The name of the ResourceBundle used in this application */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /** The encryption algorithm key to be used for passwords */
    public static final String ENC_ALGORITHM = "algorithm";

    /** A flag to indicate if passwords should be encrypted */
    public static final String ENCRYPT_PASSWORD = "encryptPassword";

    
    /**
     * Session scope attribute that holds the locale set by the user. By setting
     * this key to the same one that Struts uses, we get synchronization in
     * Struts w/o having to do extra work or have two session-level variables.
     */
    public static final String PREFERRED_LOCALE_KEY = "org.apache.struts.action.LOCALE";

    /**
     * public static final String PAGENO ="pageNo";
     * 
     * public static final String PAGESIZE ="pageSize";
     */
    public static final int PAGESIZE = 5;

   
  //机房标识  locationIdentify
	public static final Integer JiFang = 1;
	
	//机柜标识  locationIdentify
	public static final Integer JiGui = 2;
	
	//网络标识  locationIdentify
	public static final Integer WangLuo = 4;
	
	//安全域标识  locationIdentify
	public static final Integer AnQuanYu = 8;
	
	//主机标识  locationIdentify
	public static final Integer ZhuJi = 16;
	
	private static long T = 0;
	

	public static long getT() {
		return T;
	}

	public static void setT(long t) {
		T = t;
	}


	//攻击威胁指数标识  locationIdentify
	public static final Integer AttackThreatZS = 11;
	
	//病毒疫情指数标识  locationIdentify
	public static final Integer VirusYiQingZS = 22;
	
	//非法连接指数标识  locationIdentify
	public static final Integer UnValidConnectionZS = 44;
	
	private long readT() {
		System.out.println("==========读取T===========");
		long t = 0l;
		final InputStream inputStream = this.getClass().getClassLoader()
        .getResourceAsStream("jdbc.properties");
         final Properties properties = new Properties();
         try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         t = new Long(((String)properties.get("t"))).longValue();
		return t;
	}
	
    public static void main(String[] args){
    	Constants c = new Constants();
    	System.out.println(c.getT());
    }
}
