package org.infosec.ismp.applet.manager.application;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import org.infosec.ismp.applet.manager.component.TopoNetwork;
import org.infosec.ismp.applet.manager.component.TopoPopupMenuGenerator;
import org.infosec.ismp.applet.manager.component.TopoTree;
import org.infosec.ismp.applet.manager.component.tree.TreeToolBar;
import org.infosec.ismp.applet.manager.model.DomainModel;
import org.infosec.ismp.applet.manager.model.LinkModel;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.utilities.AppUtil;
import org.infosec.ismp.applet.manager.utilities.TopoConst;

import twaver.DataBoxSelectionEvent;
import twaver.DataBoxSelectionListener;
import twaver.Element;
import twaver.ElementAttribute;
import twaver.Node;
import twaver.VisibleFilter;
import twaver.network.NetworkToolBarFactory;
import twaver.network.TNetwork;
import twaver.swing.TExpandPane;
import twaver.swing.TableLayout;
import twaver.table.TPropertySheet;
import twaver.table.TPropertySheetPane;
import twaver.tree.TTree;

public class MainPane extends JPanel{
    private TTree tree;   
    private JSplitPane rootSplit = new JSplitPane();
    private JTextField txtSearch = new JTextField();
   // private TPropertySheet sheet = new TPropertySheet(TopoConst.BOX);
    private Element attribute = new Node();
	private TPropertySheet sheet = new TPropertySheet();
    private TNetwork network;
    
    public MainPane() {   
    	tree = new TopoTree(TopoConst.BOX);
    	network = new TopoNetwork(TopoConst.BOX);
    	JToolBar toolbar = NetworkToolBarFactory.getToolBar(TopoConst.TOOLBAR, network);
    	network.setToolbar(toolbar);
        tree.setEnsureVisibleOnSelected(true);
        
        tree.setPopupMenuGenerator(new TopoPopupMenuGenerator(network));
        tree.expandRow(0);

    	JLabel lbSearch = new JLabel();
        lbSearch.setText(" 快速搜索:");
        JPanel searchPane = new JPanel(new BorderLayout());
        searchPane.add(lbSearch, BorderLayout.NORTH);     
        searchPane.add(AppUtil.createDropDownSelector(this, txtSearch), BorderLayout.CENTER);        
        TExpandPane searchPopup = new TExpandPane(searchPane, TExpandPane.NORTH, true, false);
        
    	double[] rows = new double[] {
        	TableLayout.PREFERRED,
        	TableLayout.PREFERRED,
        	//TableLayout.FILL,
        	TableLayout.PREFERRED,
        	TableLayout.PREFERRED,
    	};

        double[] columns = new double[] {
        	TableLayout.FILL
        };
        
        JPanel leftPanel = new JPanel(new TableLayout(columns, rows));
        
        leftPanel.add(searchPopup, "0,0");
        leftPanel.add(new TreeToolBar(tree), "0,1");
        leftPanel.add(new JScrollPane(tree), "0,2");
        leftPanel.add(getProrpertyPane(), "0,3");
        
        rootSplit.setContinuousLayout(true);
        rootSplit.setOneTouchExpandable(true);
        rootSplit.setLeftComponent(leftPanel);
        rootSplit.setRightComponent(network);
        
 //       this.navigateManager = new NavigateManager(tree, rootSplit, scrollReadMe);
        
    	rows = new double[] { 
    			TableLayout.FILL
    	};
		columns = new double[] { 
			TableLayout.FILL,
		}; 

       this.setLayout(new TableLayout(columns, rows));
       this.add(rootSplit,"0,0");

		
		txtSearch.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ESCAPE){
					txtSearch.setText(null);
				}
				tree.updateTViewUI();
				tree.expandAll();
				selectNode();
			}
		});
		
        tree.addVisibleFilter(new VisibleFilter(){
			public boolean isVisible(Element element) {
		        String text = txtSearch.getText();
		        if (!(element instanceof Node) || text == null || text.trim().equals("")) {
		            return true;
		        }
		        if(element.getName() == null) {
		        	return false;
		        }
		        if(element instanceof DomainModel) {
		        	List<Element> childrens = element.getChildren();
		        	for(Element children:childrens) {
		        		if(children.getName()!=null && children.getName().toLowerCase().indexOf(text.toLowerCase()) >= 0) {
		        			return true;
		        		}
		        	}
		        }
				return element.getName().toLowerCase().indexOf(text.toLowerCase()) >= 0;
			}
        });
        SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				txtSearch.requestFocus();
			}
        });
    }
    
    private TPropertySheetPane getProrpertyPane() {
    	  initSheet();
    	  return new TPropertySheetPane(sheet);
    }
    
    private void initSheet() {
		sheet.setElement(attribute);
		List list = new ArrayList();
		list.add(getElementaAttribute("ID", "topoID"));
		list.add(getElementaAttribute("名称", "topoName"));
		list.add(getElementaAttribute("IP地址","topoIP"));
		list.add(getElementaAttribute("类型", "topoType"));
		list.add(getElementaAttribute("品牌","topoMark"));
		list.add(getElementaAttribute("型号","topoModel"));
		list.add(getElementaAttribute("状态","topoStatu"));
		list.add(getElementaAttribute("所属域","topoDomain"));
		list.add(getElementaAttribute("Mac地址","topoMac"));
		sheet.registerElementClassAttributes(Node.class, list);
		
		attribute.putClientProperty("topoID", "");
		TopoConst.BOX.getSelectionModel().addDataBoxSelectionListener(
		new DataBoxSelectionListener() {
			public void selectionChanged(DataBoxSelectionEvent e) {
				Element source = TopoConst.BOX.getLastSelectedElement();
				if(source instanceof DomainModel) {
					DomainModel domain = (DomainModel)source;
					attribute.putClientProperty("topoID", domain.getId()+"");
					attribute.putClientProperty("topoName", domain.getDomainName());
					attribute.putClientProperty("topoIP", "");
					attribute.putClientProperty("topoType", "云图");
					attribute.putClientProperty("topoMark", "");
					attribute.putClientProperty("topoModel", "");
					attribute.putClientProperty("topoStatu", "");
					if(domain.getParentDomain() != null) {
						attribute.putClientProperty("topoDomain", domain.getParentDomain().getDomainName());
					} else {
						attribute.putClientProperty("topoDomain", "");
					}
					attribute.putClientProperty("topoMac", "");
				} else if(source instanceof NodeModel){
					NodeModel node = (NodeModel)source;
					attribute.putClientProperty("topoID", node.getNodeId());
					attribute.putClientProperty("topoName", node.getName());
					attribute.putClientProperty("topoIP", node.getIpAddress());
					attribute.putClientProperty("topoType", node.getType() == null ? "":node.getType().getName());
					attribute.putClientProperty("topoMark", node.getBrand() == null ? "":node.getBrand().getMarkName());
					attribute.putClientProperty("topoModel", node.getModel() == null ? "":node.getModel().getName());
					if(node.getStatus() != null && node.getStatus() == 1) {
						attribute.putClientProperty("topoStatu", "已激活");
					} else {
						attribute.putClientProperty("topoStatu", "未激活");
					}
					if(node.getParentDomain() != null) {
						attribute.putClientProperty("topoDomain", node.getParentDomain().getDomainName());
					} else {
						attribute.putClientProperty("topoDomain", "");
					}
					attribute.putClientProperty("topoMac", node.getMac()== null ? "":node.getMac());
				} else if(source instanceof LinkModel) {
					LinkModel link = (LinkModel)source;
					attribute.putClientProperty("topoID",link.getLinkId()+"");
					attribute.putClientProperty("topoName", "");
					attribute.putClientProperty("topoIP", "");
					attribute.putClientProperty("topoType", "");
					attribute.putClientProperty("topoMark", "");
					attribute.putClientProperty("topoModel", "");
					if(link.getLinkState() != null && link.getLinkState() == 1) {
						attribute.putClientProperty("topoStatu", "已激活");
					} else {
						attribute.putClientProperty("topoStatu", "未激活");
					}
					attribute.putClientProperty("topoDomain", "");
					attribute.putClientProperty("topoMac", "");
				} else {
					attribute.putClientProperty("topoID", "");
					attribute.putClientProperty("topoName", "");
					attribute.putClientProperty("topoIP", "");
					attribute.putClientProperty("topoType", "");
					attribute.putClientProperty("topoMark", "");
					attribute.putClientProperty("topoModel", "");
					attribute.putClientProperty("topoStatu", "");
					attribute.putClientProperty("topoDomain", "");
					attribute.putClientProperty("topoMac", "");
				}
			}
		});
	}

	private ElementAttribute getElementaAttribute(String name, String key) {
		ElementAttribute attribute = new ElementAttribute();
		attribute.setDisplayName(name);
		attribute.setClientPropertyKey(key);
		return attribute;
	}

    
    public void clearSearch(){
    	txtSearch.setText("");
    	tree.updateTViewUI();
    	tree.expandAll();
    	Element element = tree.getDataBox().getLastSelectedElement();
    	if(element != null){
    		tree.ensureVisible(element);
    	}
    }
    
    public void selectNode() {
        String text = txtSearch.getText();
        if (text == null || text.trim().equals("")) {
            return;
        } else {
            text = text.trim().toLowerCase();
            List list = new ArrayList();
            //TODO change NodeMode.class
            Iterator it = TopoConst.BOX.iterator(Node.class);
            while (it.hasNext()) {
                Element element = (Element) it.next();
            	if(tree.isVisible(element)){
            		list.add(element);
            		if(element.getParent() != null && !list.contains(element.getParent())) {
            			list.add(element.getParent());
            		}
            	}
            }
            TopoConst.BOX.getSelectionModel().setSelection(list);
        }
    }
    
//    private JButton createExportImageButton(){
//		JButton button = new JButton(TWaverUtil.getIcon("/demo/resource/images/exportImage.png"));
//		button.setFocusPainted(false);
//		button.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				TWaverUtil.exportImage(rootSplit.getRightComponent());
//			}
//		});
//		return button;
//    }
}