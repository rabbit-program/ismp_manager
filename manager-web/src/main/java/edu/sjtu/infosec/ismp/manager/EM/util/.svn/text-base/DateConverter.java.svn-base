package edu.sjtu.infosec.ismp.manager.EM.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;

/**
 * DateConverter.
 * 
 * @version 1.0 11 May 2009
 * @author zhou chenye
 */
public class DateConverter implements Converter {

    /**
     * 日期格式���ڸ�ʽ
     */
    public static final String TS_FORMAT = DateUtil.getDatePattern()
            + " HH:mm:ss.S";

    /**
     * Convert a Object to a Date and a Date to a String
     *
     * @param type the class type to output
     * @param value the object to convert
     * @return object the converted object (Double or String)
     */
    public Object convert(Class type, Object value) {

        if (value == null) {
            return null;
        } else if (type == Timestamp.class) {
            return convertToDate(type, value, TS_FORMAT);
        } else if (type == Date.class) {
            return convertToDate(type, value, DateUtil.getDatePattern());
        } else if (type == String.class) {
            return convertToString(type, value);
        }

        throw new ConversionException("Could not convert "
                + value.getClass().getName() + " to " + type.getName());
    }

    /**
     * Convert a Object to a Date according to the pattern
     *
     * @param type the class type to output
     * @param value the object to convert
     * @param pattern the date pattern
     * @return object the converted object (Date)
     */
    protected Object convertToDate(Class type, Object value, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        if (value instanceof String) {
            try {
                if (StringUtils.isEmpty(value.toString())) {
                    return null;
                }

                Date date = df.parse((String) value);
                if (type.equals(Timestamp.class)) {
                    return new Timestamp(date.getTime());
                }
                return date;
            } catch (Exception pe) {
                pe.printStackTrace();
                throw new ConversionException("Error converting String to Date");
            }
        } else if (value instanceof Timestamp) {
            return (Date) value;
        }

        throw new ConversionException("Could not convert "
                + value.getClass().getName() + " to " + type.getName());
    }

    /**
     * Convert a Date to a String
     *
     * @param type the class type to output
     * @param value the object to convert
     * @return object the converted object (String)
     */
    protected Object convertToString(Class type, Object value) {

        if (value instanceof Date) {
            DateFormat df = new SimpleDateFormat(DateUtil.getDatePattern());
            if (value instanceof Timestamp) {
                df = new SimpleDateFormat(TS_FORMAT);
            }

            try {
                return df.format(value);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ConversionException("Error converting Date to String");
            }
        } else {
            return value.toString();
        }
    }
}
