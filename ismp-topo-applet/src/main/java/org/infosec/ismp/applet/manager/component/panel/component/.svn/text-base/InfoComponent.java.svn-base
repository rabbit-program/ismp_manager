package org.infosec.ismp.applet.manager.component.panel.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.infosec.ismp.applet.manager.component.panel.SJTUConst;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;


/**
 * 信息按钮。
 */
public class InfoComponent extends JComponent {
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		InfoComponent comp = new InfoComponent("test");
				comp.setPreferredSize(new Dimension(200, 100));
		panel.add(comp);
		SJTUUtils.showCompoentInFrame(panel);
	}

	private Color fillColor = Color.GRAY;
	private String text;
	private Color textColor = Color.BLUE;
	private Font textFont = SJTUConst.LABELFONT;

	public InfoComponent() {
		this("");
	}

	public InfoComponent(String text) {
		this.text = text;
		this.setDoubleBuffered(true);
		this.setOpaque(false);
	}

	public Dimension getPreferredSize() {
		Dimension preferredSize = super.getPreferredSize();
		if (preferredSize != null && preferredSize.width > 1 && preferredSize.height > 1) {
			return preferredSize;
		}
		return new Dimension(90, 40);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = this.getSize();
		/*g2d.setColor(g2d.getBackground());
		g2d.fillRect(0, 0, size.width, size.height);*/
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Ellipse2D.Double ell = new Ellipse2D.Double(0, 0, size.width, size.height);
		GradientPaint paint = new GradientPaint((float) (size.width / 2.0), 0, fillColor.brighter(), (float) (size.width / 2.0), size.height, fillColor);
		g2d.setPaint(paint);
		g2d.fill(ell);

		double percent = 0.8;
		Ellipse2D.Double smallEll = new Ellipse2D.Double(size.width * (1 - percent) / 2, 2, size.width * 0.8, size.height * 0.8);
		paint = new GradientPaint((float) (size.width / 2.0), 0, Color.WHITE, (float) (size.width / 2.0), (float) (size.height * 0.8), fillColor.brighter());
		g2d.setPaint(paint);
		g2d.fill(smallEll);

		if (text != null && !("".equals(text.trim())) && textFont != null) {
			Dimension textSize = SJTUUtils.getPreferredSize(text, textFont);
			int x = (int) (size.width / 2.0 - textSize.width / 2.0);
			int y = (int) (size.height / 2.0 - textSize.height / 2.0);
			JLabel label = SJTUUtils.getLabel(text, textFont, textColor);
			SJTUUtils.paintComponent(g2d, label, this, x, y, textSize.width, textSize.height);
		}
	}

	public boolean contains(int x, int y) {
		Dimension size = this.getSize();
		Ellipse2D.Double ell = new Ellipse2D.Double(0, 0, size.width, size.height);
		return ell.contains(x, y);
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
		this.repaint();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		this.repaint();
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
		this.repaint();
	}

	public Font getTextFont() {
		return textFont;
	}

	public void setTextFont(Font textFont) {
		this.textFont = textFont;
		this.repaint();
	}
}
