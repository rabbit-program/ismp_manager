package org.infosec.ismp.applet.manager.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.infosec.ismp.applet.manager.application.action.ActionInfo;
import org.infosec.ismp.applet.manager.model.NodeModel;

import twaver.Element;
import twaver.Link;
import twaver.TDataBox;
import twaver.VisibleFilter;
import twaver.tree.ElementNode;
import twaver.tree.TTree;

@SuppressWarnings("serial")
public class TopoTree extends TTree{

	public TopoTree(TDataBox box) {
		super(box);
		
		this.addVisibleFilter(new VisibleFilter(){
			public boolean isVisible(Element element) {
		        if (!(element instanceof Link)) {
		            return true;
		        }
				return false;
			}
        });
		
		this.addElementNodeDoubleClickedActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ElementNode elementNode = (ElementNode)e.getSource();
				Element element = elementNode.getElement();
				if(element instanceof NodeModel) {
					ActionInfo.actionDeviceInfo((NodeModel)element);
				}
			}
		});
	}
	
	

}
