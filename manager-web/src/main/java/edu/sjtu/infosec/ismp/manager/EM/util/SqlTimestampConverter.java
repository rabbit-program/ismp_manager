package edu.sjtu.infosec.ismp.manager.EM.util;

import java.sql.Timestamp;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.StringUtils;

/**
 * SqlTimestampConverter.
 */
public class SqlTimestampConverter implements Converter {

    // ----------------------------------------------------- Instance Variables

    /**
     * The default value specified to our Constructor, if any.
     */
    private Object defaultValue = null;

    /**
     * Should we return the default value on conversion errors?
     */
    private boolean useDefault = true;

    /**
     * Create a {@link Converter} that will throw a {@link ConversionException}
     * if a conversion error occurs.
     */
    public SqlTimestampConverter() {

        this.defaultValue = null;
        this.useDefault = false;

    }

    /**
     * Create a {@link Converter} that will return the specified default value
     * if a conversion error occurs.
     * 
     * @param defaultvalue
     *            The default value to be returned
     */
    public SqlTimestampConverter(Object defaultvalue) {

        this.defaultValue = defaultvalue;
        this.useDefault = true;

    }

    // --------------------------------------------------------- Public Methods

    /**
     * Convert the specified input object into an output object of the specified
     * type.
     * 
     * @param type
     *            Data type to which this value should be converted
     * @param value
     *            The input value to be converted
     * @return Timestamp Object
     */
    public Object convert(Class type, Object value) {

        if (value == null
                || (value instanceof String && StringUtils.isBlank(value
                        .toString()))) {
            if (useDefault) {
                return (defaultValue);
            } else {
                throw new ConversionException("No value specified");
            }
        }

        if (value instanceof Timestamp) {
            return (value);
        }

        try {
            return (Timestamp.valueOf(value.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            if (useDefault) {
                return (defaultValue);
            } else {
                throw new ConversionException(e);
            }
        }

    }
}
