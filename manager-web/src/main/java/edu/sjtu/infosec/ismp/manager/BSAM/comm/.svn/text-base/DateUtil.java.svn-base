package edu.sjtu.infosec.ismp.manager.BSAM.comm;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * DateUtil.
 * 
 * @version 1.0 11 May 2009
 * @author zhou chenye
 */
public class DateUtil {
    //~ Static fields/initializers =============================================

    /**
     * 日志
     */
    private static Log log = LogFactory.getLog(DateUtil.class);

    /**
     * 默认日期格式
     */
    private static String defaultDatePattern = null;

    /**
     * 时间格式
     */
    private static String timePattern = "yyyy-MM-dd HH:mm:ss";

    //~ Methods ================================================================

    /**
     * Return default datePattern (MM/dd/yyyy)
     * @return a string representing the date pattern on the UI
     */
    public static  String getDatePattern() {
        defaultDatePattern = "yyyy-MM-dd HH:mm:ss";
        return defaultDatePattern;
    }

    /**
     * This method attempts to convert an Oracle-formatted date
     * in the form dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException ParseException
     */
    public static final Date convertStringToDate(String aMask, String strDate)
            throws ParseException {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '"
                    + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }
    
    /**
     * This method returns the current date time in the format:
     * MM/dd/yyyy HH:MM a
     *
     * @param theTime the current time
     * @return the current date/time
     * @throws ParseException 
     */
    public static String getTimeNow() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        return todayAsString;
    }

    /**
     * This method returns the current date time in the format:
     * MM/dd/yyyy HH:MM a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     * 
     * @return the current date
     * @throws ParseException ParseException
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * 
     * @see java.text.SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based
     * on the System Property 'dateFormat'
     * in the format you specify on input
     * 
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }
    
    public String convertTimestampToString(Timestamp timestamp) throws ParseException {
    	String str = "";
    	SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
        str = df1.format(timestamp);
       
        return str;
    }
    
    public String formatString(String str) throws ParseException {
    	    System.out.println(str);
    	    long time = Long.parseLong(str);
    	    SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");//定义格式，不显示毫秒
//            DateFormat df2 = new SimpleDateFormat("EEE MMM d HH:mm:ss 'UTC'Z yyyy", Locale.US);
//        	Date date = df2.parse(str);
    	    Date date = new Date(time); 
        	str = df1.format(date);
        	System.out.println(str);
        return str;
    }

    /**
     * This method converts a String to a date using the datePattern
     * 
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * 
     * @throws ParseException ParseException
     */
    public static Date convertStringToDate(String strDate)
            throws ParseException {
        Date aDate = null;

        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate
                    + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());

        }

        return aDate;
    }
    
    public static void main(String[] args) throws ParseException{
        System.out.println(getDatePattern());
        System.out.println(getToday().getTime());
        System.out.println(getTimeNow());
        System.out.println(Timestamp.valueOf(getTimeNow()));
        Timestamp now = new Timestamp(System.currentTimeMillis());//获取系统当前时间
        System.out.println();
        DateUtil jDateUtil = new DateUtil();
        String str = jDateUtil.convertTimestampToString(now);
        System.out.println(str);
        //str = "Wed Jun 3 16:00:28 UTC+0800 2009";
        str = "Wed Jun 3 16:00:28 UTC+0800 2009";
        str = jDateUtil.formatString("1244016028000");
        System.out.println(str);
    }
}
