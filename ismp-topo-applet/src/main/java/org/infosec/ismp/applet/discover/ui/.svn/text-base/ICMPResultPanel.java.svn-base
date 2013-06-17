package org.infosec.ismp.applet.discover.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.infosec.ismp.applet.comm.TopoDiscoverService;
import org.infosec.ismp.applet.discover.service.ICMPSearchAppletService;
import org.infosec.ismp.manager.rmi.tm.discover.model.Node;
import org.infosec.ismp.manager.rmi.tm.discover.model.NodeType;



/**
 * ICMPResultPanel
 * @author sshanshan
 * @date 2009-6-13
 * @version 1.0
 */
public class ICMPResultPanel extends JPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    private JLabel title = new JLabel("请选择需要加入拓扑视图的节点", SwingConstants.CENTER);
    private JButton selectAll = new JButton("全选");
    private JButton removeAll = new JButton("重置");
    private JButton okbutton = new JButton("确定");
    private DefaultTableModel model = new DefaultTableModel();
    private JTable table;
    private List<ICMPEntryData> data = null;;
    private ArrayList<Node> result = new ArrayList<Node>();
//    private AgentBO agentBO = null;
    /**
     * 构造函数
     * @param data icmp搜索的参数
     * @param agentBO
     */
//    public ICMPResultPanel(List<ICMPEntryData> data,AgentBO agentBO) {
    public ICMPResultPanel(List<ICMPEntryData> data) {
        this.data = data;
//        this.agentBO = agentBO;
        init();
    }
    
    /**
     * 初始函数
     */
    public void init() {

        this.setLayout(new BorderLayout());
        
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Class getColumnClass(int index) {
                if (index == 0)
                    return Boolean.class;
                else
                    return String.class;
            }
        };

        model.addColumn("请选择");
        model.addColumn("节点IP");
        model.addColumn("节点类型");
        model.addColumn("尝试次数");
        model.addColumn("响应时间");
        model.addColumn("节点描述");
        
        table.setAutoCreateColumnsFromModel(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.setShowGrid(true);
        //table.setPreferredSize(new Dimension(600, 300));
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setPreferredSize(new Dimension(1, 23));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setResizingAllowed(false);
        table.setColumnSelectionAllowed(true);

        TableColumn tableColumn = table.getColumn("请选择");
        tableColumn.setMinWidth(50);
        tableColumn.setMaxWidth(50);
        tableColumn.setCellRenderer(new EDCellRenderer());
        tableColumn = table.getColumn("节点IP");
        tableColumn.setMinWidth(100);
        tableColumn.setMaxWidth(100);
        tableColumn.setCellRenderer(new EDCellRenderer());
        tableColumn = table.getColumn("节点类型");
        tableColumn.setMinWidth(100);
        tableColumn.setMaxWidth(100);
        tableColumn.setCellRenderer(new EDCellRenderer());
        tableColumn = table.getColumn("尝试次数");
        tableColumn.setMinWidth(60);
        tableColumn.setMaxWidth(60);
        tableColumn.setCellRenderer(new EDCellRenderer());
        tableColumn = table.getColumn("响应时间");
        tableColumn.setMinWidth(60);
        tableColumn.setMaxWidth(60);
        tableColumn.setCellRenderer(new EDCellRenderer());
        tableColumn = table.getColumn("节点描述");
        tableColumn.setMinWidth(230);
        tableColumn.setMaxWidth(230);
        tableColumn.setCellRenderer(new EDCellRenderer());

        for (ICMPEntryData icmp : data) {
            Vector v = new Vector();
            v.add(icmp.getIsSelect());
            v.add(icmp.getIp());
            v.add(icmp.getType());
            v.add(icmp.getTryTimes());
            v.add(icmp.getResponseTime());
            v.add(icmp.getDescription());
            model.addRow(v);
        }

        JPanel titlePane = new JPanel();
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints cons = new GridBagConstraints();
        cons.insets = new Insets(5, 20, 5, 20);
        cons.anchor = GridBagConstraints.CENTER;
        cons.fill = GridBagConstraints.BOTH;
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 1;
        cons.weightx = 1;
        cons.weighty = 1;
        titlePane.setLayout(grid);
        grid.setConstraints(title, cons);
        titlePane.add(title);

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(2, 1, 5, 5));

        JPanel checkboxPane = new JPanel();
        checkboxPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        selectAll.addActionListener(this);
        removeAll.addActionListener(this);
        checkboxPane.add(selectAll);
        checkboxPane.add(removeAll);

        JPanel okPane = new JPanel();
        okPane.setLayout(grid);
        cons.insets = new Insets(0, 5, 5, 5);
        okbutton.addActionListener(this);
        grid.setConstraints(okbutton, cons);
        okPane.add(okbutton);

        buttonPane.add(checkboxPane);
        buttonPane.add(okPane);

        this.add(BorderLayout.NORTH, titlePane);
        this.add(BorderLayout.CENTER, new JScrollPane(table));
        this.add(BorderLayout.SOUTH, buttonPane);
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        ICMPEntryData snmpdata = new ICMPEntryData();
        ICMPEntryData snmpdata1 = new ICMPEntryData();
        ArrayList<ICMPEntryData> data = new ArrayList<ICMPEntryData>();
        snmpdata.setIp("127.0.0.1");
        snmpdata1.setIp("123.123.123.123");
        data.add(snmpdata);
        data.add(snmpdata1);
//        ICMPResultPanel test = new ICMPResultPanel(data,null);
        ICMPResultPanel test = new ICMPResultPanel(data);
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setSize(600, 400);
        mainFrame.setLocation(
                (screenDimension.width - mainFrame.getSize().width) / 2,
                (screenDimension.height - mainFrame.getSize().height) / 2);
        mainFrame.setTitle("发现节点");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(test, BorderLayout.CENTER);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        try {
//            UIManager.setLookAndFeel(UIManager
//                    .getCrossPlatformLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(mainFrame);
        } catch (Exception e) {
            System.err.println("can't get SystemLookAndFeel");
        }
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    /**
     * EDCellRenderer
     * @author sshanshan
     */
    class EDCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int col) {
            Component com = super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, col);
            com.setFont(new java.awt.Font("Dialog", 0, 12));
            com.setForeground(new Color(0, 0, 0));
            if (col==0) {
                JCheckBox box = new JCheckBox();
                box.setHorizontalAlignment(CENTER);
                box.setSelected((Boolean)value);
                com = box;
            }else{
                ((JLabel) com).setToolTipText(((JLabel) com).getText());
                ((JLabel) com).setHorizontalAlignment(CENTER);
            }
            if (row % 2 == 0) {
                com.setBackground(new Color(255, 255, 220));
            } else {
                com.setBackground(new Color(220, 220, 200));
            }
            if (table.isRowSelected(row)) {
                com.setBackground(new Color(100, 150, 250));
            }
            return com;
        }
    }
    /**
     * 事件处理函数，全选／重置／确定
     */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
        if (source == selectAll) {
        	int j = 0;   
        	for(int i=0; i<model.getRowCount(); i++){
        		model.setValueAt(true, i, j);
        	}
        }else if (source == removeAll){
        	int j = 0;
        	for(int i = 0; i<model.getRowCount(); i++){
        		model.setValueAt(false, i, j);
        	}
        }else if(source == okbutton){
        	int j = 0;
        	for(int i = 0; i<model.getRowCount(); i++){
        		if (model.getValueAt(i,j).equals(true)){
        			Node node = new Node();
        			node.setIpAddr((model.getValueAt(i, 1)==null)?"":model.getValueAt(i, 1).toString());
        			node.setNodeType((model.getValueAt(i, 2)==null)?(new NodeType()):(NodeType)(model.getValueAt(i, 2)));
        			node.setTryNum(Integer.parseInt((model.getValueAt(i, 3)==null)?"":model.getValueAt(i, 3).toString()));
        			node.setSearchTime((model.getValueAt(i, 4)==null)?"":model.getValueAt(i, 4).toString());
        			node.setDescription((model.getValueAt(i, 5)==null)?"":model.getValueAt(i, 5).toString());
        			node.setName(node.getIpAddr());
					result.add(node);
        		}
        	}
        	if(result!=null && result.size() > 0){
	        	ICMPSearchAppletService icmpSearchService = ICMPSearchAppletService.getInstance();
	        	icmpSearchService.addNodeList(result);
	        	try {
//					TopoDeviceClassManager.displayTopoDiscover(this.agentBO);
            		TopoDiscoverService.displayTopoDiscover();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	((JFrame)this.getParent().getParent().getParent().getParent()).setVisible(false);
	        	((JFrame)this.getParent().getParent().getParent().getParent()).dispose();
        	} else {
        		javax.swing.JOptionPane.showMessageDialog((JFrame)this.getParent().getParent().getParent().getParent(), "请选择记录再保存");
        	}
        }
		
	}
}
