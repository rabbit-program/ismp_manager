package edu.sjtu.infosec.ismp.manager.EM.comm;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 常量.
 * 
 */
public class Constants {

    /**
     * getDatePattern
     * 
     * @param key
     *            key
     * @return datePattern
     */
    public static synchronized String getDatePattern(String key) {
        String retValue = "";
        Locale locale = LocaleContextHolder.getLocale();
        try {
            retValue = ResourceBundle.getBundle(Constants.BUNDLE_KEY, locale)
                    .getString(key);
        } catch (MissingResourceException mse) {
            retValue = "";
        }
        return retValue;
    }

    

    /** DELAYTIME */
    public static final String DELAYTIME = getDatePattern("delayTime");

    /** The name of the ResourceBundle used in this application */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /** The encryption algorithm key to be used for passwords */
    public static final String ENC_ALGORITHM = "algorithm";

    /** A flag to indicate if passwords should be encrypted */
    public static final String ENCRYPT_PASSWORD = "encryptPassword";

    /** The name of the configuration hashmap stored in application scope. */
    public static final String CONFIG = "dataCenterDBConfMap";
    /** The name of the configuration file location. */
    public static final String CONFIGFILE = "/WEB-INF/comm/webApp.properties";

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

    /** AsseKind Dictable Class */
    public static final String ASSEKINDDICCLASS = "edu.sjtu.infosec.ismp.manager.model.assessment.AsseKnowDicAsseKind";
    /** AsseStat Dictable Class */
    public static final String ASSESTATDICCLASS = "edu.sjtu.infosec.ismp.manager.model.assessment.AsseKnowDicAsseStat";
    /** CpKind Dictable Class */
    public static final String CPKINDDICCLASS = "edu.sjtu.infosec.ismp.manager.model.assessment.AsseKnowDicCpKind";
    /** Prog Dictable Class */
    public static final String PROGDICCLASS = "edu.sjtu.infosec.ismp.manager.model.assessment.AsseKnowDicProg";
    /** QuesKind Dictable Class */
    public static final String QUESKINDDICCLASS = "edu.sjtu.infosec.ismp.manager.model.assessment.AsseKnowDicQuesKind";
    /** SecuLeve Dictable Class */
    public static final String SECULEVEDICCLASS = "edu.sjtu.infosec.ismp.manager.model.assessment.AsseKnowDicSecuLeve";
    /** RiskMatrRule Dictable Class */
    public static final String RISKMATRRULEDICCLASS = "edu.sjtu.infosec.ismp.manager.model"
            + ".assessment.AsseKnowDicRiskMatrRule";

    /** AsseKind Dictable Name */
    public static final String ASSEKINDDICNAME = "资产类型";
    /** AsseStat Dictable Name */
    public static final String ASSESTATDICNAME = "评估状态";
    /** CpKind Dictable Name */
    public static final String CPKINDDICNAME = "测评类型";
    /** Prog Dictable Name */
    public static final String PROGDICNAME = "评估流程";
    /** QuesKind Dictable Name */
    public static final String QUESKINDDICNAME = "问题类型";
    /** SecuLeve Dictable Name */
    public static final String SECULEVEDICNAME = "安全级别";
    /** RiskMatrRule Dictable Name */
    public static final String RISKMATRRULEDICNAME = "风险矩阵规则";

    /** 测评状态 */
    public static final String NOTFINISH = "stat01";
    public static final String PROCESSING = "stat02";
    public static final String HAVEFINISHED = "stat03";

    /** 测评类型 */
    public static final String MANAGEMENT = "cp1";
    public static final String TECHNOLOGY = "cp2";

    /** 评估流程 */
    public static final String BUILDVIEW = "prog1";
    public static final String INPUTBUSINESS = "prog2";
    public static final String INPUTASSERT = "prog3";
    public static final String TOPOINFOVIEW = "prog4";
    public static final String PAPERDESIGN = "prog5";
    public static final String ANSWERPAPER = "prog6";
    public static final String SCANLEAK = "prog7";
    public static final String VULNANALYSIS = "prog8";
    public static final String THREANALYSIS = "prog9";
    public static final String VULNTHRERELATION = "prog10";
    public static final String RISKCALCULATE = "prog11";
    public static final String REPORT = "prog12";

    /** 安全级别 */
    public static final String HIGH = "H";
    public static final String MIDDUM = "M";
    public static final String LOW = "L";
    
    public static void main(String[] args){
        System.out.println(BUILDVIEW);
    }
}
