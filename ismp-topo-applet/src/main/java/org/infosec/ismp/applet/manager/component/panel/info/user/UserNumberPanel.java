package org.infosec.ismp.applet.manager.component.panel.info.user;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.infosec.ismp.applet.manager.component.panel.component.InfoComponent;
import org.infosec.ismp.applet.manager.component.panel.component.TitlePanel;
import org.infosec.ismp.applet.manager.component.panel.info.AbstractTitlePanel;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;

import twaver.swing.TableLayout;

/**
 * 当前用户数
 * 接口
 * setUserCount
 * getUserCount
 */
public class UserNumberPanel extends AbstractTitlePanel {
	private InfoComponent userNumberLabel = new InfoComponent("1");

	public UserNumberPanel() {
		double rows[] = { TableLayout.PREFERRED, TableLayout.PREFERRED };
		double cols[] = { TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL };
		TableLayout layout = new TableLayout(cols, rows);
		this.setLayout(layout);
		JLabel label = SJTUUtils.getLabel("当前在线用户(人)", false);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		this.add(label, "1,0,1,0");
		this.add(userNumberLabel, "1,1,1,1");
	}

	public JPanel getTitlePanel() {
		return new TitlePanel("当前用户数", this);
	}

	/**
	 * 获取当前用户数
	 * @return
	 */
	public int getUserCount() {
		return Integer.parseInt(userNumberLabel.getText());
	}

	/**
	 * 设置当前用户数
	 * @param userCount
	 */
	public void setUserCount(int userCount) {
		userNumberLabel.setText(userCount + "");
	}

}
