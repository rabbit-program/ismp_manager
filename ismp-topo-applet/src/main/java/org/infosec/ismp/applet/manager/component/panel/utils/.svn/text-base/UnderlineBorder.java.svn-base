package org.infosec.ismp.applet.manager.component.panel.utils;

import java.awt.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * 下划线 border
 */
public class UnderlineBorder implements Border, Serializable {
    public static final UnderlineBorder INSTANCE = new UnderlineBorder();
    public static final UnderlineBorder INSTANCE_BLUE = new UnderlineBorder(Color.BLUE);
    public static final Border INSTANCE_NORMAL = new JTextField().getBorder();

    private static final int DEFAULT_BOTTOM = 2;

    private Color lineColor = null;

    private int bottom = DEFAULT_BOTTOM;

    public UnderlineBorder() {
        this(Color.gray, DEFAULT_BOTTOM);
    }

    public UnderlineBorder(Color color) {
        this(color, DEFAULT_BOTTOM);
    }

    public UnderlineBorder(Color color, int bottom) {
        this.lineColor = color;
        this.bottom = bottom;
    }


    public void paintBorder(Component c,
                            Graphics g,
                            int x,
                            int y,
                            int width,
                            int height) {
        g.setColor(lineColor);
        g.drawLine(x,
                   y + height - bottom,
                   x + width,
                   y + height - bottom);
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, bottom, 0);
    }

    public boolean isBorderOpaque() {
        return true;
    }
}
