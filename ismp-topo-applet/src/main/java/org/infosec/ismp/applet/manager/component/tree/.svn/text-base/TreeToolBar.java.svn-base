package org.infosec.ismp.applet.manager.component.tree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import twaver.ChildrenSortableFilter;
import twaver.DataBoxSelectionEvent;
import twaver.DataBoxSelectionListener;
import twaver.Element;
import twaver.Node;
import twaver.TWaverConst;
import twaver.TWaverUtil;
import twaver.tree.TTree;

public class TreeToolBar extends JToolBar{
	
	private TTree tree;
	private ButtonGroup group = new ButtonGroup();
	private JButton[] moveButtons = new JButton[4]; 
	
	public void resetMoveButtons(){
		boolean enabled = true;
		if(tree.getSortComparator() != null || tree.getDataBox().getSelectionModel().size() == 0){
			enabled = false;
		}
		moveButtons[0].setEnabled(enabled);
		moveButtons[1].setEnabled(enabled);
		moveButtons[2].setEnabled(enabled);
		moveButtons[3].setEnabled(enabled);
	}
	
	public TreeToolBar(final TTree tree){
		this.tree = tree;
		this.tree.getDataBox().getSelectionModel().addDataBoxSelectionListener(
			new DataBoxSelectionListener(){
				public void selectionChanged(DataBoxSelectionEvent e) {
					resetMoveButtons();	
			}
		});
		
		this.setFloatable(false);
		tree.setChildrenSortableFilter(new ChildrenSortableFilter(){
			public boolean isChildrenSortable(Element parentElement) {
				if(parentElement == null){
					return false;
				}
				if(parentElement.isEmpty()){
					return false;
				}
				return parentElement.getChildren().get(0) instanceof Node;
			}
		});
		
		this.addGroupButton("default.gif", "Reset Order", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tree.setSortComparator(null);
				tree.expandAll();
				resetMoveButtons();
			}
		});
		this.addGroupButton("sort1.png", "Sort Ascending", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tree.setSortComparator(new Comparator(){
					public int compare(Object o1, Object o2) {
						Element e1 = (Element)o1;
						Element e2 = (Element)o2;
						return e1.getName().compareTo(e2.getName());
					}
				});
				tree.expandAll();
				resetMoveButtons();
			}
		});
		this.addGroupButton("sort2.png", "Sort Descending", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tree.setSortComparator(new Comparator(){
					public int compare(Object o1, Object o2) {
						Element e1 = (Element)o1;
						Element e2 = (Element)o2;
						return e2.getName().compareTo(e1.getName());
					}
				});
				tree.expandAll();
				resetMoveButtons();
			}
		});
		this.addSeparator();
		
		moveButtons[0] = addButton("top.png", "Move Selection To Top", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tree.getDataBox().moveSelectionToTop();
			}
		});
		moveButtons[1] = addButton("up.gif", "Move Selection To Up", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tree.getDataBox().moveSelectionToUp();
			}
		});
		moveButtons[2] = addButton("down.gif", "Move Selection To Down", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tree.getDataBox().moveSelectionToDown();
			}
		});
		moveButtons[3] = addButton("bottom.png", "Move Selection To Bottom", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tree.getDataBox().moveSelectionToBottom();
			}
		});
		this.addSeparator();
		
		this.addButton("expand.png", "Expand All", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tree.expandAll();
			}
		});
		this.addButton("collapse.png", "Collapse All", new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				tree.collapseAll();
				tree.expandRoot();
			}
		});
		
		resetMoveButtons();
	}
	
	private JToggleButton addGroupButton(String icon, String tooltipText, ActionListener l){
		JToggleButton button = new JToggleButton();
		group.add(button);
		button.addActionListener(l);
		button.setToolTipText(tooltipText);
		button.setMargin(TWaverConst.NONE_INSETS);
		button.setIcon(TWaverUtil.getIcon("/org/infosec/ismp/applet/manager/component/tree/icon/" + icon));
		this.add(button);
		return button;
	}
	
	private JButton addButton(String icon, String tooltipText, ActionListener l){
		JButton button = new JButton();
		button.addActionListener(l);
		button.setToolTipText(tooltipText);
		button.setMargin(TWaverConst.NONE_INSETS);
		button.setIcon(TWaverUtil.getIcon("/org/infosec/ismp/applet/manager/component/tree/icon/" + icon));
		this.add(button);
		return button;
	}
}