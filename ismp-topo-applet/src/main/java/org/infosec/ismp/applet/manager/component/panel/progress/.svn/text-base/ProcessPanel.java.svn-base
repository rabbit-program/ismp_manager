package org.infosec.ismp.applet.manager.component.panel.progress;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

import org.infosec.ismp.applet.manager.component.panel.utils.SJTUUtils;

import twaver.Element;
import twaver.ElementAttribute;
import twaver.TDataBox;
import twaver.swing.TExpandPane;
import twaver.table.PageListener;
import twaver.table.TElementTable;

/**
 * 进程信息面板。
 * 具体使用参考 test()方法。
 */
public class ProcessPanel extends JPanel {
	private ProcessPanel processPane;
	private List attributeList = new ArrayList();

	//	private DynameicDeviceDataManager dyname;
	private Timer timer;
	TDataBox processBox = new TDataBox();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SJTUUtils.showCompoentInFrame(new ProcessPanel());
	}
	public  ProcessPanel() {
		processPane = this;
        attributeList.add(createElementAttribute("进程名称", Process.CLIENTKEY + Process.PROCESSNAME,false));
		attributeList.add(createElementAttribute("进程描述信息", Process.CLIENTKEY + Process.PROCESSDESCIPTION,false));
		attributeList.add(createElementAttribute("进程运行路径", Process.CLIENTKEY + Process.PROCESSRUNPATH,false));
		attributeList.add(createElementAttribute("进程分配的内存", Process.CLIENTKEY + Process.PROCESSMEMORY,false));
		attributeList.add(createElementAttribute("进程消耗CPU时间", Process.CLIENTKEY + Process.PROCESSCPUTIME,false));
		initTableAttributes();
		initGUI();
		
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setColumns();
		setProcessList(attributeList);
	
	}

	
	public TDataBox getProcessBox() {
		return processBox;
	}
	
	public ElementAttribute createElementAttribute(String displayName, String key,boolean isEditable) {
		ElementAttribute attribute = new ElementAttribute();
		attribute.setDisplayName(displayName);
		attribute.setClientPropertyKey(key);
		attribute.setEditable(isEditable);
		return attribute;
	}

	private TDataBox box = new TDataBox();
	/**
	 * 初始化一个带数据table实例
	 */
	private TElementTable table = new TElementTable(box) {
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			Component prepareRenderer = super.prepareRenderer(renderer, row, column);
			if (table.getSelectedRow() == row) {
				prepareRenderer.setBackground(new Color(200, 220, 180));
			} else {
				if (row % 2 == 0) {
					prepareRenderer.setBackground(Color.WHITE);
				} else {
					prepareRenderer.setBackground(new Color(120, 180, 230, 128));
				}
			}
			return prepareRenderer;
		}

	};
	private List processList = new ArrayList();
	private ProcessDetalPanel detalPanel = new ProcessDetalPanel();
	private TExpandPane expandPane;

	public void setProcessList(List processList) {
		this.processList = processList;
		if (processList == null) {
			this.processList = new ArrayList();
		}
		detalPanel.setProcessList(processList);
		setColumns();
	}

	private void setColumns() {
//		table.getCheckColumn().setVisible(true);
		table.setElementClass(Element.class);
		table.registerElementClassAttributes(Element.class, processList);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}

	public ElementAttribute createElementAttribute(ElementAttribute context) {
		ElementAttribute attribute = new ElementAttribute();
		attribute.setClientPropertyKey(context.getName());
		attribute.setDisplayName(context.getDisplayName());
		attribute.setRowPackParticipable(true);
		attribute.setExtraWidthAssignable(true);
		attribute.setEditable(false);
		return attribute;
	}

/*	public ProcessPanel() {
		initTableAttributes();
		initGUI();
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setColumns();
	}*/
	
	private int currentRows =  0;//select current row index
	private Process currentProcess = null;//select current row Element
	/**
	 * 添加table 事件
	 */
	private void initTableAttributes() {
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setTableBodyPopupMenuFactory(null);
		table.getTableModel().addPageListener(new PageListener() {
			public void pageChanged() {
				table.packAllColumns(true);
			}
		});
		table.addElementDoubleClickedActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				expandPane.setExpand(true);
			}
		});
		table.addElementClickedActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentRows = table.getSelectedRow();
				currentProcess = (Process)box.getLastSelectedElement();
			}
		});
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Element element = box.getLastSelectedElement();
					detalPanel.setElement((Process) element);
				}
			}
		});
	}
	
	private void initGUI() {
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		expandPane = new TExpandPane(detalPanel, TExpandPane.SOUTH, 200, true, false);
		centerPanel.add(expandPane, BorderLayout.SOUTH);

		centerPanel.setBackground(Color.RED);
		this.setLayout(new BorderLayout());
		this.add(centerPanel, BorderLayout.CENTER);
	}

	public TDataBox getBox() {
		return box;
	}

	public void setBox(TDataBox box) {
		if(box == null) return;
		this.box = box;
		table.setDataBox(box);
	
		try {
			table.setRowSelectionInterval(currentRows, currentRows);
		} catch(java.lang.IllegalArgumentException e) {
		//	throw new RuntimeException();
		}
		if(currentProcess != null) {
			detalPanel.setElement(currentProcess);
		}
	}
	public ProcessPanel getProcessPane() {
		return processPane;
	}
	
	
}
