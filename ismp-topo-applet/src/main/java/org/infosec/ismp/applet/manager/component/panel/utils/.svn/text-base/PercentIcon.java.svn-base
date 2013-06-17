package org.infosec.ismp.applet.manager.component.panel.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Point2D;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;

/**
 * 显示百分比的icon
 */
public class PercentIcon implements Icon {
	private String text = "";
	private double value = 0;
	private Font valueFont = new Font("Dialog", Font.PLAIN, 12);
	private int size = 60;
	private Color color = Color.GREEN;
	private int count = 3;
	private double gap = 1;

	public PercentIcon() {

	}

	public PercentIcon(String text, double value) {
		this.text = text;
		this.value = value;
	}

	public int getIconHeight() {
		return size;
	}

	public int getIconWidth() {
		return size;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		color = Color.GREEN;
		if (value >= 60) {
			color = Color.ORANGE;
		}
		if (value >= 80) {
			color = Color.RED;
		}
		g2d.setColor(color);
		double startAngle = 360 * value / 100;
		double extent = 360 / count - gap;
		for (int i = 0; i < count; i++) {
			paintArc(g2d, x + 5, y + 5, size - 10, size - 10, startAngle + i * extent + gap, extent, color);
		}
		String labelText = value + "%";
		if (text != null && text.trim().length() != 0) {
			labelText = text + "(" + value + "%)";
		}
		JLabel label = SJTUUtils.getLabel(labelText, valueFont, color);
		Dimension labelSize = label.getPreferredSize();
		float centerX = (float) (x + size / 2.0);
		float centerY = (float) (y + size / 2.0);
		g2d.setFont(valueFont);
		g2d.setColor(color.darker());
		g2d.drawString(labelText, (float) (centerX - labelSize.getWidth() / 2), (float) (centerY + labelSize.getHeight() / 2 - 5));
	}

	public void paintArc(Graphics2D g2d, int x, int y, int w, int h, double startAngle, double extent, Color color) {
		double width = 7;
		Arc2D.Double outArc = new Arc2D.Double(x, y, w, h, startAngle, extent, Arc2D.PIE);
		Arc2D.Double inArc = new Arc2D.Double(x + width, y + width, w - 2 * width, h - 2 * width, startAngle, extent, Arc2D.PIE);
		Area arc = new Area(outArc);
		arc.subtract(new Area(inArc));
		Point2D start = outArc.getStartPoint();
		Point2D end = outArc.getEndPoint();
		GradientPaint paint = new GradientPaint(start, color, end, new Color(255, 255, 255, 60), false);
		g2d.setPaint(paint);
		g2d.fill(arc);
	}

	public static void main(String[] args) {
		JTabbedPane pane = new ImageToolTipTabbedPanel();
		pane.addTab("1", new PercentIcon("1", 0), new JTree());
		pane.addTab("2", new PercentIcon("2", 40), new JTree());
		pane.addTab("3", new PercentIcon("3", 60), new JTree());
		pane.addTab("4", new PercentIcon("4", 80), new JTree());
		pane.addTab("4", new PercentIcon("5", 100), new JTree());
//		SJTUUtils.showCompoentInFrame(pane);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Font getValueFont() {
		return valueFont;
	}

	public void setValueFont(Font valueFont) {
		this.valueFont = valueFont;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
