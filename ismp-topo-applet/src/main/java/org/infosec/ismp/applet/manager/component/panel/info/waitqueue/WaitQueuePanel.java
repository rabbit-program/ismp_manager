package org.infosec.ismp.applet.manager.component.panel.info.waitqueue;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.infosec.ismp.applet.manager.component.panel.component.InfoComponent;
import org.infosec.ismp.applet.manager.component.panel.component.TitlePanel;
import org.infosec.ismp.applet.manager.component.panel.info.AbstractTitlePanel;
import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;

import twaver.swing.TableLayout;

/**
 * 等待处理队列
 * 接口
 * 进程数：		getProcessCount & setProcessCount
 * 僵死进程数：  getDeadProcessCount & setDeadProcessCount
 */
public class WaitQueuePanel extends AbstractTitlePanel {
	private InfoComponent processLabel = new InfoComponent();
	private InfoComponent deadProcessLabel = new InfoComponent();

	public WaitQueuePanel() {
		JPanel queuePanel = new JPanel(new GridLayout(2, 1, 2, 20));
		double rows[] = { TableLayout.PREFERRED, TableLayout.PREFERRED };
		double cols[] = { TableLayout.PREFERRED };
		TableLayout layout = new TableLayout(cols, rows);
		JPanel processPanel = new JPanel(layout);
		JLabel label = SJTUUtils.getLabel("进程数", false);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		processPanel.add(label, "0,0,0,0");

		processPanel.add(processLabel, "0,1,0,1");
		queuePanel.add(processPanel);
		JPanel deadProcessPanel = new JPanel(layout);
		label = SJTUUtils.getLabel("僵死进程数", false);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		deadProcessPanel.add(label, "0,0,0,0");
		deadProcessPanel.add(deadProcessLabel, "0,1,0,1");
		queuePanel.add(deadProcessPanel);

		this.add(queuePanel);
	}

	public JPanel getTitlePanel() {
		return new TitlePanel("等待处理队列", this);
	}

	/**
	 * 获取进程数
	 * @return
	 */
	public int getProcessCount() {
		return Integer.parseInt(processLabel.getText());
	}

	/**
	 * 设置进程数
	 * @param processCount
	 */
	public void setProcessCount(int processCount) {
		this.processLabel.setText(processCount + "");
	}

	/**
	 * 获取僵死进程数
	 * @return
	 */
	public int getDeadProcessCount() {
		return Integer.parseInt(deadProcessLabel.getText());
	}

	/**
	 * 设置僵死进程数
	 * @param deadProcessCount
	 */
	public void setDeadProcessCount(int deadProcessCount) {
		this.deadProcessLabel.setText(deadProcessCount + "");
	}
}
