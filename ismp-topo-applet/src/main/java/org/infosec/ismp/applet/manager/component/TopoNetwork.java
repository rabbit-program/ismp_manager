package org.infosec.ismp.applet.manager.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.infosec.ismp.applet.manager.application.action.ActionInfo;
import org.infosec.ismp.applet.manager.model.NodeModel;
import org.infosec.ismp.applet.manager.model.TopoDatabaseModel;
import org.infosec.ismp.applet.manager.model.TopoSensorModel;
import org.infosec.ismp.applet.manager.model.TopoWeblogicModel;
import org.infosec.ismp.applet.manager.utilities.TopoConst;

import twaver.DataBoxSelectionEvent;
import twaver.DataBoxSelectionListener;
import twaver.Element;
import twaver.MovableFilter;
import twaver.Node;
import twaver.ResizableFilter;
import twaver.ResizableNode;
import twaver.ShapeLink;
import twaver.ShapeNode;
import twaver.TDataBox;
import twaver.TSubNetwork;
import twaver.network.TNetwork;

@SuppressWarnings("serial")
public class TopoNetwork extends TNetwork{
	/**
	 * 编辑状态
	 */
	private boolean isEditable = true;
	public TopoNetwork(TDataBox box){
		super(box);
		init();
	}
	
	/**
	 * 设置是否启用键盘事件
	 * @param b
	 */
	public void setKeyboard(boolean b) {
		this.setEnableDeleteWithKeyboard(b);//键盘可以删除
	}
	/**
	 * 初始化网络面板
	 */
	private void init() {
	this.setEnableUndoRedoWithKeyboard(true);//键盘对重做和恢复成效
    this.setEnsureVisibleOnSelected(false);//确保所选内容可见
	this.setEnableDeleteWithKeyboard(true);//键盘可以删除
	this.setEnableCopyPasteWithKeyboard(false);//键盘可以Copy/Paste
	this.setEnableDoubleClickToUp(false);//禁掉twaver的双击事件
	this.setEnableAttachmentDefaultAction(false);
	//设备编辑文本过滤器事件
//	this.setElementLabelEditableFilter(new EditableFilter(){
//		public boolean isEditable(Element element) {
//			return isEditable;
//		}
//	});
	
	//设备移动过滤器事件
	this.setMovableFilter(new MovableFilter(){
		public boolean isMovable(Element element) {
			return isEditable;
		}
	});
	//设备大小过滤器
    this.setResizableFilter(new ResizableFilter(){
		public boolean isResizable(Element element) {
			if(!isEditable){
				return false;
			}
			return element instanceof ResizableNode || 
					element instanceof ShapeLink || 
					element instanceof ShapeNode;
		}
	});
    /**
	 * 自定义双击事件
	 */
	this.addElementDoubleClickedActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Element element = (Element)e.getSource();
			if(element instanceof NodeModel) {
				NodeModel node = (NodeModel)element;
				if(node instanceof TopoDatabaseModel) {
					ActionInfo.actionDatabaseInfo(node);
				} else if(node instanceof TopoSensorModel) {
					ActionInfo.actionSensorInfo(node);
				} else if(node instanceof TopoWeblogicModel) {
					ActionInfo.actionWeblogicInfo(node);
				} else {
					ActionInfo.actionDeviceInfo(node);
				}
			}
		}
	});
    this.setPopupMenuGenerator(new TopoPopupMenuGenerator(this));
    
    this.getSelectionModel().addDataBoxSelectionListener(
		new DataBoxSelectionListener() {
			public void selectionChanged(DataBoxSelectionEvent e) {
				//Element element = (Element)e.getSource();
				Element lastSelectedElement = TopoConst.BOX.getLastSelectedElement();
				if(lastSelectedElement == null || !(lastSelectedElement instanceof Node)) {
					return;
				}
				Element parent = lastSelectedElement.getParent();
				if(parent == null) {
					TopoNetwork.this.setCurrentSubNetwork(null);
				}
				if(parent instanceof TSubNetwork) {
					if(parent != null) {
						TopoNetwork.this.setCurrentSubNetwork((TSubNetwork)parent);
					} else {
						TopoNetwork.this.setCurrentSubNetwork(null);
					}
				}
				
			}
		});
	}
}
