package org.infosec.ismp.applet.manager.component.panel.progress;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;

import twaver.Element;
import twaver.ElementAttribute;
import twaver.swing.TableLayout;

/**
 * 进程详细信息面板
 */
public class ProcessDetalPanel extends JPanel {
	private List processList = new ArrayList();
	private List textFiledList = new ArrayList();
	private Process element;
	private Border lineBorder = BorderFactory.createEmptyBorder(5, 15, 5, 15);

	public ProcessDetalPanel() {
		setDetails();
		this.setBorder(BorderFactory.createTitledBorder(lineBorder, "详细信息"));
	}

	private void setDetails() {
		this.removeAll();
		int size = processList.size();
		textFiledList.clear();

		double cols[] = { TableLayout.PREFERRED, TableLayout.FILL, TableLayout.PREFERRED, TableLayout.FILL };
		int length;
		if (size % 2 == 0) {
			length = size / 2;
		} else {
			length = size / 2 + 1;
		}
		double rows[] = new double[length];
		for (int i = 0; i < length; i++) {
			rows[i] = TableLayout.PREFERRED;
		}
		TableLayout layout = new TableLayout(cols, rows, 20, 5);
		this.setLayout(layout);
		for (int i = 0; i < size; i++) {
			int row = i / 2;
			int col = (i % 2) * 2;
			ElementAttribute cotext = (ElementAttribute) processList.get(i);
			this.add(SJTUUtils.getLabel(cotext.getDisplayName()), "" + col + "," + row + "," + col + "," + row);
			JTextField field = SJTUUtils.getTextField();
			this.add(field, "" + (col + 1) + "," + row + "," + (col + 1) + "," + row);
			textFiledList.add(field);
		}
		setValues();
	}

	private void setValues() {
		int size = textFiledList.size();
		for (int i = 0; i < size; i++) {
			JTextField field = (JTextField) textFiledList.get(i);
			if (element == null) {
				field.setText("");
			} else {
				ElementAttribute cotext = (ElementAttribute) processList.get(i);
				Object clientProperty = element.getClientProperty(cotext.getClientPropertyKey());
				if (clientProperty != null) {
					field.setText(clientProperty.toString());
				} else {
					field.setText("");
				}
			}
		}
	}

	public void setProcessList(List processList) {
		if (processList == null) {
			this.processList = new ArrayList();
		} else {
			this.processList = processList;
		}
		setDetails();
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Process element) {
		this.element = element;
		if (element == null) {
			this.setBorder(BorderFactory.createTitledBorder(lineBorder, "详细信息"));
		} else {
			this.setBorder(BorderFactory.createTitledBorder(lineBorder, element.getProcessName() + "的详细信息"));
		}
		setValues();
	}

}
