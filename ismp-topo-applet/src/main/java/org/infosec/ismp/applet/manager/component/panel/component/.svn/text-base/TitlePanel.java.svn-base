package org.infosec.ismp.applet.manager.component.panel.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.infosec.ismp.applet.manager.component.panel.SJTUConst;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;

/**
 * 标题面板。
 */
public class TitlePanel extends JPanel {

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		panel.add(new InfoComponent("info"));
		JPanel comp = new TitlePanel("啊", panel);
//		SJTUUtils.showCompoentInFrame(comp);
	}

	private String text;
	private Font textFont = SJTUConst.LABELFONT;
	private Color textColor = Color.WHITE;
	private Color titleColor = new Color(120, 180, 230, 128);
	private Color titleGradientColor = new Color(120, 200, 230, 128);
//	private JComponent content;

	public TitlePanel(String text, JComponent content) {
		this.text = text;
//		this.content = content;
		content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		Title title = new Title();
		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(content, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createLineBorder(Color.GREEN.darker()));
	}

	/**
	 * 标题栏
	 */
	class Title extends JComponent {
		public Dimension getPreferredSize() {
			JLabel label = SJTUUtils.getLabel(text, textFont, textColor);
			Dimension labelSize = label.getPreferredSize();
			return new Dimension(labelSize.width, labelSize.height + 8);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			Dimension size = this.getSize();
			GradientPaint paint = new GradientPaint(size.height / 2f, 0, titleColor, size.height / 2f, size.height / 1.2f, titleGradientColor, false);
			g2d.setPaint(paint);
			g2d.setColor(titleGradientColor);
			g2d.fillRoundRect(0, 0, size.width, size.height, 3, 2);
			g2d.setColor(titleColor);
			g2d.fillRect(0, size.height / 2, size.width, size.height);

			JLabel label = SJTUUtils.getLabel(text, textFont, textColor);
			Dimension labelSize = label.getPreferredSize();
			int x = (int) (size.width / 2.0 - labelSize.width / 2.0);
			int y = (int) (size.height / 2.0 - labelSize.height / 2.0);
			int w = labelSize.width;
			int h = labelSize.height;
			SJTUUtils.paintComponent(g2d, label, this, x, y, w, h);
		}

	}

}
