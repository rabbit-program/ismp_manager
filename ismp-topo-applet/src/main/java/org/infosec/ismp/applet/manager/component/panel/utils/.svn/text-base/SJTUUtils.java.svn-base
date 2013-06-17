package org.infosec.ismp.applet.manager.component.panel.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.CellRendererPane;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import org.infosec.ismp.applet.manager.application.dynamicInfo.DynamicInfo;
import org.infosec.ismp.applet.manager.component.panel.SJTUConst;
import org.infosec.ismp.applet.manager.model.NodeModel;

/**
 * 工具类
 */
public class SJTUUtils {
	/*
	public static void showCompoentInFrame(final Container container,final TopoManageDevice device,final BackgroundData dyname) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setTitle(device.getDeviceIp()+" 名称："+device.getDeviceName());
				frame.setContentPane(container);
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(800, 700);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.addWindowListener(new WindowAdapter(){
						public void windowClosing(WindowEvent event) {
//							TimerManager.stopDynameTimer(device);
//							dyname.stopThread();
						}
					});
			}
		});
	}
	*/
	
	public static void showCompoentInFrame(final Container container) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setContentPane(container);
//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(800, 600);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		});
	}
	
	public static void showCompoentInFrame(final Container container,final NodeModel node) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setContentPane(container);
				frame.setSize(800, 600);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				DynamicInfo.startGetDynamicInfo(node);
				frame.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent event) {
						DynamicInfo.stopGetDynamicInfo(node);
					}
				});
			}
		});
	}
	
	private static CellRendererPane cellRendererPane = new CellRendererPane();

	public static Border getTitleBorder(String title) {
		return BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLineBorder(Color.LIGHT_GRAY)), title,
				TitledBorder.LEFT, TitledBorder.TOP, SJTUConst.LABELFONT);
	}

	public static void paintComponent(Graphics2D g, Component c, Container container, int x, int y, int w, int h) {
		g.setStroke(new BasicStroke(1));
		cellRendererPane.paintComponent(g, c, container, x, y, w, h, true);
	}

	public static JLabel getLabel(String text, Font font, Color color) {
		JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText(text);
		label.setFont(font);
		if (color != null) {
			label.setForeground(color);
		}
		return label;
	}

	public static Dimension getPreferredSize(String text, Font font) {
		return getLabel(text, font, null).getPreferredSize();
	}

	public static JLabel getLabel(String text) {
		return getLabel(text, true);
	}

	public static JLabel getLabel(String text, Icon icon) {
		JLabel label = getLabel(text, true);
		if (icon != null) {
			label.setIcon(icon);
		}
		return label;
	}

	public static JLabel getLabel(String text, Icon icon, boolean needSemicolon) {
		JLabel label = getLabel(text, needSemicolon);
		if (icon != null) {
			label.setIcon(icon);
		}
		return label;
	}

	public static JLabel getLabel(String text, boolean needSemicolon) {
		if (text != null && !text.endsWith(":")) {
			text = text + " ";
		}
		JLabel label;
		if (needSemicolon) {
			label = new JLabel(text) {
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					Dimension size = this.getSize();
					JLabel textLabel = getLabel(":", SJTUConst.LABELFONT, null);
					Dimension textSize = textLabel.getPreferredSize();
					int x = size.width - textSize.width - 1;
					int y = size.height / 2 - textSize.height / 2;
					int w = textSize.width;
					int h = textSize.height;
					SJTUUtils.paintComponent((Graphics2D) g, textLabel, this, x, y, w, h);
				}
			};
		} else {
			label = new JLabel(text);
		}
		label.setFont(SJTUConst.LABELFONT);
		return label;
	}

	public static JTextField getTextField() {
		return getTextField(null);
	}

	public static JTextField getTextField(String text) {
		return getTextField(text, true);
	}

	public static JTextField getTextField(String text, boolean textincenter) {
		return getTextField(text, textincenter, false);
	}

	public static JTextField getTextField(boolean textincenter) {
		return getTextField(null, textincenter, false);
	}

	public static JTextField getTextField(String text, boolean textincenter, boolean editable) {
		JTextField field = new JTextField(10) {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

			}
		};
		if (textincenter) {
			field.setHorizontalAlignment(JTextField.CENTER);
		}
		field.setBackground(null);
		field.setEditable(editable);
		if (text != null) {
			field.setText(text);
		}
		field.setBorder(UnderlineBorder.INSTANCE);
		return field;
	}

	public static JTabbedPane createTabbedPane(int tabPlacement) {
		switch (tabPlacement) {
		case JTabbedPane.LEFT:
		case JTabbedPane.RIGHT:
			Object textIconGap = UIManager.get("TabbedPane.textIconGap");
			Insets tabInsets = UIManager.getInsets("TabbedPane.tabInsets");
			UIManager.put("TabbedPane.textIconGap", new Integer(1));
			UIManager.put("TabbedPane.tabInsets", new Insets(tabInsets.left, tabInsets.top, tabInsets.right, tabInsets.bottom));
			JTabbedPane tabPane = new JTabbedPane(tabPlacement);
			UIManager.put("TabbedPane.textIconGap", textIconGap);
			UIManager.put("TabbedPane.tabInsets", tabInsets);
			return tabPane;
		default:
			return new JTabbedPane(tabPlacement);
		}
	}


}
