package edu.sjtu.infosec.ismp.manager.EM.util;

import java.text.DecimalFormat;
import java.text.ParseException;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CurrencyConverter.
 * 
 * @version 1.0 11 May 2009
 * @author zhou chenye
 */
public class CurrencyConverter implements Converter {

    /**
     *日志
     */
    protected final Log log = LogFactory.getLog(CurrencyConverter.class);

    /**
     * DecimalFormat
     */
    protected static final DecimalFormat FORMATTER = new DecimalFormat(
            "###,###.00");

    /**
     * Convert a String to a Double and a Double to a String
     *
     * @param type the class type to output
     * @param value the object to convert
     * @return object the converted object (Double or String)
     */
    public final Object convert(final Class type, final Object value) {
        // for a null value, return null,double value return itself.
        if (value == null || type.equals(Double.class)) {
            return value;
        } else {
            if (value instanceof String) {
                if (log.isDebugEnabled()) {
                    log.debug("value (" + value + ") instance of String");
                }

                try {
                    if (StringUtils.isBlank(String.valueOf(value))) {
                        return null;
                    }

                    if (log.isDebugEnabled()) {
                        log.debug("converting '" + value + "' to a decimal");
                    }

                    //formatter.setDecimalSeparatorAlwaysShown(true);
                    Number num = FORMATTER.parse(String.valueOf(value));

                    return new Double(num.doubleValue());
                } catch (ParseException pe) {
                    pe.printStackTrace();
                }
            } else if (value instanceof Double) {
                if (log.isDebugEnabled()) {
                    log.debug("value (" + value + ") instance of Double");
                    log.debug("returning double: " + FORMATTER.format(value));
                }

                return FORMATTER.format(value);
            }
        }

        throw new ConversionException("Could not convert " + value + " to "
                + type.getName() + "!");
    }

    /**
     * Convert a Double to a  a String
     *
     * @param value the double value
     * @return String the converted object (String)
     */
    public static final String doubleFormat(double value) {

        String retValue = new DecimalFormat("###,###.00").format(value);

        return retValue;
    }

}
