package edu.sjtu.infosec.ismp.manager.EM.comm;

import java.io.Serializable;
import java.util.Comparator;

/**
 * LabelValue.
 *
 */
public class LabelValue implements Comparable, Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 3689355407466181430L;

    /**
     * Comparator that can be used for a case insensitive sort of
     * <code>LabelValue</code> objects.
     */
    public static final Comparator CASE_INSENSITIVE_ORDER = new Comparator() {
        public int compare(Object o1, Object o2) {
            String label1 = ((LabelValue) o1).getLabel();
            String label2 = ((LabelValue) o2).getLabel();
            return label1.compareToIgnoreCase(label2);
        }
    };

    // ----------------------------------------------------------- Constructors

    /**
     * Default constructor.
     */
    public LabelValue() {
        super();
    }

    /**
     * Construct an instance with the supplied property values.
     *
     * @param llabel 
     * The label to be displayed to the user.
     * @param vvalue 
     * The value to be returned to the server.
     */
    public LabelValue(String llabel, String vvalue) {
        this.label = llabel;
        this.value = vvalue;
    }

    // ------------------------------------------------------------- Properties

    /**
     * The property which supplies the option label visible to the end user.
     */
    private String label = null;

    /**
     * getLabel.
     * @return label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * setLabel.
     * @param llabel
     * label
     */
    public void setLabel(String llabel) {
        this.label = llabel;
    }

    /**
     * The property which supplies the value returned to the server.
     */
    private String value = null;

    /**
     * getValue.
     * @return value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * setValue.
     * @param vvalue
     * value
     */
    public void setValue(String vvalue) {
        this.value = vvalue;
    }

    // --------------------------------------------------------- Public Methods

    /**
     * Compare LabelValueBeans based on the label, because that's the human
     * viewable part of the object.
     * @param o
     * Object
     * 
     * @see Comparable
     * 
     * @return int
     */
    public int compareTo(Object o) {
        // Implicitly tests for the correct type, throwing
        // ClassCastException as required by interface
        String otherLabel = ((LabelValue) o).getLabel();

        return this.getLabel().compareTo(otherLabel);
    }

    /**
     * @return a string representation of this object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("LabelValue[");
        sb.append(this.label);
        sb.append(", ");
        sb.append(this.value);
        sb.append("]");
        return (sb.toString());
    }

    /**
     * LabelValueBeans are equal if their values are both null or equal.
     * @param obj
     * Object
     * @see java.lang.Object#equals(java.lang.Object)
     * @return boolean.
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof LabelValue)) {
            return false;
        }

        LabelValue bean = (LabelValue) obj;
        
        int nil = 0;
        
        if (this.getValue() == null) {
            nil =  1 ;
        }
        
        if(bean.getValue() == null) {
            nil += 1;
        }else{
            nil += 0;
        }
        
        if (nil == 2) {
            return true;
        } else if (nil == 1) {
            return false;
        } else {
            return this.getValue().equals(bean.getValue());
        }

    }

    /**
     * The hash code is based on the object's value.
     *
     * @see java.lang.Object#hashCode()
     * @return int.
     */
    public int hashCode() {
        
        int  hashCode = new Integer("17").intValue();
        
        if (this.getValue() != null) {
          hashCode = this.getValue().hashCode();
        }
        return hashCode;
    }
    
}
