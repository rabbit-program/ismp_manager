package org.infosec.ismp.applet.manager.component.panel.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class TableUtil {
	public final static JTable getTable() {
		return new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component prepareRenderer = super.prepareRenderer(renderer,
						row, column);
				if (this.getSelectedRow() == row) {
					prepareRenderer.setBackground(new Color(200, 220, 180));
				} else {
					if (row % 2 == 0) {
						prepareRenderer.setBackground(Color.WHITE);
					} else {
						prepareRenderer.setBackground(new Color(120, 180, 230,
								128));
					}
				}
				return prepareRenderer;
			}

			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	}
	
	public final static JComponent addTable(JComponent component,TableModel model) {
		JScrollPane pane = new JScrollPane();
		component.setLayout(new BorderLayout());
		JTable t = getTable();
		t.setModel(model);
		JViewport viewport  = pane.getViewport();
		viewport.add(t.getTableHeader(), BorderLayout.PAGE_START);
		viewport.add(t, BorderLayout.CENTER);
		component.add(pane);
		return component;
	}
}
