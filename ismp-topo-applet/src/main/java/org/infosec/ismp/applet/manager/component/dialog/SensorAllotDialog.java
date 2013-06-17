package org.infosec.ismp.applet.manager.component.dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.task.SaveDomainSensorTask;

public class SensorAllotDialog extends JDialog{
	private Map<DomainModel,List<NodeModel>> map = new HashMap<DomainModel,List<NodeModel>>();
	private List<DomainModel> domain = new ArrayList<DomainModel>();
	private List<NodeModel> pc = new ArrayList<NodeModel>();
	private ButtonGroup group = new ButtonGroup();
	private DefaultListModel radioModel = new DefaultListModel();
	private DefaultListModel checkModel = new DefaultListModel();
	private JButton btnEnter = new JButton("确定");
	private JButton btnCancel = new JButton("取消");
	 protected static Border noFocusBorder =
         new EmptyBorder(1, 1, 1, 1);
	private boolean selectFlag = false;
	public static void main(String[] args) {
		SensorAllotDialog s = new SensorAllotDialog();
		List<DomainModel> domain = new ArrayList<DomainModel>();
		DomainModel d1 = new DomainModel();
		d1.setName("1111");
		DomainModel d2 = new DomainModel();
		d2.setName("2222");
		DomainModel d3 = new DomainModel();
		d3.setName("3333");
		domain.add(d1);
		domain.add(d2);
		domain.add(d3);
		List<NodeModel> node = new ArrayList<NodeModel>();
		NodeModel n1 = new NodeModel();
		n1.setName("aaaa");
		NodeModel n2 = new NodeModel();
		n2.setName("bbbb");
		NodeModel n3 = new NodeModel();
		n3.setName("cccc");
		NodeModel n4 = new NodeModel();
		n4.setName("dddd");
		node.add(n1);
		node.add(n2);
		node.add(n3);
		node.add(n4);
		s.setDomainModel(domain);
		s.setSensorModel(node);
		
		
	}
	 public SensorAllotDialog() {
		 initGUI();
		 this.setTitle("PC分配域");
		 this.setLocationRelativeTo(null);
	 }
	 
	 public void initGUI() {
		 CheckBoxList checkBoxList = new CheckBoxList();
		 checkBoxList.setModel(checkModel);
		 JScrollPane domainPanel = new JScrollPane();
		 domainPanel.setBorder(BorderFactory.createTitledBorder("域(部门)"));
		 JScrollPane pcPanel = new JScrollPane();
		 pcPanel.setBorder(BorderFactory.createTitledBorder("PC设备"));
		 final RadioButtonList  radioButtonList = new RadioButtonList();
		 radioButtonList.setModel(radioModel);
		 Container contaier = this.getContentPane();
		 contaier.setLayout(new BorderLayout());
		 domainPanel.getViewport().add(radioButtonList);
		 pcPanel.getViewport().add(checkBoxList);
		
		 JPanel midPanel = new JPanel();
		 midPanel.setLayout(new GridLayout(1,2));
		 midPanel.add(domainPanel);
		 midPanel.add(pcPanel);
		 JPanel buttonPanel = new JPanel();
		 buttonPanel.add(btnEnter);
		 buttonPanel.add(btnCancel);
		 contaier.add(midPanel,BorderLayout.CENTER);
		 contaier.add(buttonPanel,BorderLayout.SOUTH);
		 
		 btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Set<DomainModel> set = map.keySet();
				List<DomainModel> tempNodes = new ArrayList<DomainModel>(set);
				List<NodeModel> nodes = new ArrayList<NodeModel>();
				for(DomainModel domain:tempNodes) {
					for(NodeModel node: map.get(domain)) {
						node.setParentDomain(domain);
						nodes.add(node);
					}
				}
				new SaveDomainSensorTask(nodes).execute();
				SensorAllotDialog.this.dispose();
			}
		 });
		 btnEnter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SensorAllotDialog.this.dispose();
				}
		 });
		 radioButtonList.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				RadioButtonList list = (RadioButtonList)e.getSource();
				JRadioButton radio = (JRadioButton)list.getSelectedValue();
				DomainModel domain = (DomainModel)radio.getClientProperty(radio);
				checkModel.clear();
				setSensorModel(pc);
				List<NodeModel> nodes = map.get(domain);
				for(NodeModel node:nodes) {
					 JCheckBox checkBox = new JCheckBox(node.getName());
					 checkBox.putClientProperty(checkBox, node);
					 checkBox.setSelected(true);
					 checkModel.addElement(checkBox);
				}
			}
		 });
		 
		 checkBoxList.addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent e) {
					CheckBoxList list = (CheckBoxList)e.getSource();
					JCheckBox check = (JCheckBox)list.getSelectedValue();
					if(check == null || check.getClientProperty(check) == null) return;
					NodeModel node = (NodeModel)check.getClientProperty(check);
					
					DefaultListModel listModel = (DefaultListModel)radioButtonList.getModel();
					JRadioButton selectRadio = null;
					for(Enumeration en = listModel.elements();en.hasMoreElements();) {
						JRadioButton radio = (JRadioButton)en.nextElement();
						if(radio.isSelected())  {
							selectRadio = radio;
						}
					}
					
					if(selectRadio == null || selectRadio.getClientProperty(selectRadio) == null) return;
					DomainModel domain = (DomainModel)selectRadio.getClientProperty(selectRadio);
					
					if(selectFlag) {
						if(check.isSelected()) {
							pc.remove(node);
							List<NodeModel> nodes = map.get(domain);
							nodes.add(node);
						} else {
							pc.add(node);
							List<NodeModel> nodes = map.get(domain);
							nodes.remove(node);
						}
					}
					selectFlag = !selectFlag;
				}
			 });
		 
		 this.setSize(350, 300);
		 this.setVisible(true);
	 }
	 
	 public void setDomainModel(List<DomainModel> domians) {
		 if(domians != null || domians.size() != 0) {
			 this.domain = domians;
			 for(DomainModel d:domians) {
				 JRadioButton radioButton = new JRadioButton(d.getName());
				 radioButton.putClientProperty(radioButton, d);
				 group.add(radioButton);
				 radioModel.addElement(radioButton);
				 map.put(d, new ArrayList<NodeModel>());
			 }
			 if(radioModel.getSize() > 0) {
				 ((JRadioButton)radioModel.get(0)).setSelected(true);
			 }
		 }
	 }
	 
	 public void setSensorModel(List<NodeModel> pcs) {
		 if(pcs != null || pcs.size() != 0) {
			 this.pc = pcs;
			 for(NodeModel p:pcs) {
				 JCheckBox checkBox = new JCheckBox(p.getIpAddress());
				 checkBox.putClientProperty(checkBox, p);
				 checkModel.addElement(checkBox);
			 }
		 }
	 }
	 
	
		class CheckBoxList extends JList
		{
		//   protected static final Border noFocusBorder =   new EmptyBorder(1, 1, 1, 1);

		   public CheckBoxList()
		   {
		      setCellRenderer(new CellRenderer());

		      addMouseListener(new MouseAdapter()
		         {
		            public void mousePressed(MouseEvent e)
		            {
		               int index = locationToIndex(e.getPoint());

		               if (index != -1) {
		                  JCheckBox checkbox = (JCheckBox)
		                              getModel().getElementAt(index);
		                  checkbox.setSelected(
		                                     !checkbox.isSelected());
		                  repaint();
		               }
		            }
		         }
		      );

		      setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		   }

		   protected class CellRenderer implements ListCellRenderer
		   {
		      public Component getListCellRendererComponent(
		                    JList list, Object value, int index,
		                    boolean isSelected, boolean cellHasFocus)
		      {
		         JCheckBox checkbox = (JCheckBox) value;
		         checkbox.setBackground(isSelected ?
		                 getSelectionBackground() : getBackground());
		         checkbox.setForeground(isSelected ?
		                 getSelectionForeground() : getForeground());
		         checkbox.setEnabled(isEnabled());
		         checkbox.setFont(getFont());
		         checkbox.setFocusPainted(false);
		         checkbox.setBorderPainted(true);
		         checkbox.setBorder(isSelected ?
		          UIManager.getBorder(
		           "List.focusCellHighlightBorder") : noFocusBorder);
		         return checkbox;
		      }
		   }
		}

		class RadioButtonList extends JList
		{
			// protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

		   public RadioButtonList()
		   {
		      setCellRenderer(new CellRenderer());

		      addMouseListener(new MouseAdapter()
		         {
		            public void mousePressed(MouseEvent e)
		            {
		               int index = locationToIndex(e.getPoint());

		               if (index != -1) {
		            	   JRadioButton radioButton = (JRadioButton)
		                              getModel().getElementAt(index);
		            	   radioButton.setSelected(
		                                     !radioButton.isSelected());
		                  repaint();
		               }
		            }
		         }
		      );

		      setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		   }

		   protected class CellRenderer implements ListCellRenderer
		   {
		      public Component getListCellRendererComponent(
		                    JList list, Object value, int index,
		                    boolean isSelected, boolean cellHasFocus)
		      {	
		    	  JRadioButton radioButton = (JRadioButton) value;
		    	  radioButton.setBackground(isSelected ?
		                 getSelectionBackground() : getBackground());
		    	  radioButton.setForeground(isSelected ?
		                 getSelectionForeground() : getForeground());
		    	  radioButton.setEnabled(isEnabled());
		    	  radioButton.setFont(getFont());
		    	  radioButton.setFocusPainted(false);
		    	  radioButton.setBorderPainted(true);
		    	  radioButton.setBorder(isSelected ?
		          UIManager.getBorder(
		           "List.focusCellHighlightBorder") : noFocusBorder);
		         return radioButton;
		      }
		   }
		}
	 
}

