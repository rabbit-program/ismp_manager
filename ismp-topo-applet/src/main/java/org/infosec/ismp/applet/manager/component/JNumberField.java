package org.infosec.ismp.applet.manager.component;

import javax.swing.*;   
import javax.swing.text.*;   
import java.awt.*;   
import java.awt.event.*;   
import java.io.*;   
   
/* 
 * <p>Description: JNumberField 数字格式输入框</p>  
 */   
public class JNumberField   
    extends JTextField   
    implements ActionListener, FocusListener, Serializable {   
    public JNumberField() {   
        this(true);   
    }   
   
    public JNumberField(boolean addAction) {   
        this(0, 16, addAction);   
    }   
   
    public JNumberField(int decLen) {   
        this(decLen, true);   
    }   
   
    public JNumberField(int decLen, boolean addAction) {   
        this(decLen, 16, addAction);   
    }   
   
    public JNumberField(int decLen, int maxLen) {   
        this(decLen, maxLen, true);   
    }   
   
    public JNumberField(int decLen, int maxLen, boolean addAction) {   
        setPreferredSize(new Dimension(70, 25));   
        setDocument(new NumberDocument(decLen, maxLen));   
        super.setHorizontalAlignment(JTextField.RIGHT);   
        if (addAction) addActionListener(this);   
        addFocusListener(this);   
    }   
   
    public JNumberField(int decLen, int maxLen, double minRange,   
                        double maxRange,   
                        boolean addAction) {   
        setPreferredSize(new Dimension(70, 25));   
        setDocument(new NumberDocument(decLen, maxLen, minRange, maxRange));   
        super.setHorizontalAlignment(JTextField.RIGHT);   
        if (addAction) addActionListener(this);   
        addFocusListener(this);   
    }   
   
    public void actionPerformed(ActionEvent e) {   
        transferFocus();   
    }   
   
    public void focusGained(FocusEvent e) {   
        selectAll();   
    }   
   
    public void focusLost(FocusEvent e) {   
    }   
   
    public static void main(String[] args) {   
//        try {   
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());   
//        }   
//        catch (Exception e) {   
//        }   
        JFrame frame = new JFrame();   
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.setTitle("JNumberField Demo");   
        frame.getContentPane().setLayout(new FlowLayout());   
        frame.getContentPane().add(new JNumberField(), BorderLayout.CENTER);   
        frame.getContentPane().add(new JNumberField(10), BorderLayout.CENTER);   
        frame.getContentPane().add(new JNumberField(10, 16),   
                                   BorderLayout.CENTER);   
        frame.getContentPane().add(new JNumberField(10, 16, -10, 100, false),   
                                   BorderLayout.CENTER);   
        frame.setSize(400, 320);   
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();   
        frame.setLocation( (d.width - frame.getSize().width) / 2,   
                          (d.height - frame.getSize().height) / 2);   
        frame.setVisible(true);   
    }   
}   
   
class NumberDocument   
    extends PlainDocument {   
    int maxLength = 16;   
    int decLength = 0;   
    double minRange = Double.MIN_VALUE;   
    double maxRange = Double.MAX_VALUE;   
    public NumberDocument(int decLen, int maxLen) {   
        maxLength = maxLen;   
        decLength = decLen;   
    }   
   
    /**  
     * @param decLen int  小数位长度  
     * @param maxLen int  最大长度(含小数位)  
     * @param minRange double  最小值  
     * @param maxRange double  最大值  
     */   
    public NumberDocument(int decLen, int maxLen, double minRange,   
                          double maxRange) {   
        this(decLen, maxLen);   
        this.minRange = minRange;   
        this.maxRange = maxRange;   
    }   
   
    public NumberDocument(int decLen) {   
        decLength = decLen;   
    }   
   
    public NumberDocument() {}   
   
    public void insertString(int offset, String s, AttributeSet a) throws   
        BadLocationException {   
        int len = getLength();   
        String str = getText(0, len);   
        int decPos = str.indexOf(".");   
        if (   
            s.equals("F") || s.equals("f") || s.equals("D") || s.equals("d")   
            || (str + s).length() > maxLength   
            ||   
            (decPos > -1 && offset > decPos &&   
             ( (str.substring(decPos + 1)) + s).length() > decLength)   
            ||   
            (str.trim().equals("0") && !s.substring(0, 1).equals(".") &&   
             offset != 0)   
            || (s.equals(".") && decLength == 0)   
            ||   
            (s.indexOf(".") > -1 &&   
             s.substring(s.indexOf(".") + 1).length() > decLength)   
            ) {   
            Toolkit.getDefaultToolkit().beep();   
            return;   
        }   
        try {   
            str = str.substring(0, offset) + s + str.substring(offset, len);   
            if (!str.equals("-") || (str.equals("-") && minRange <= 0)) {   
                double d = Double.parseDouble(str);   
                if (d < minRange || d > maxRange)   
                    throw new Exception();   
            }   
        }   
        catch (Exception e) {   
            Toolkit.getDefaultToolkit().beep();   
            return;   
        }   
        super.insertString(offset, s, a);   
    }   
   
}  