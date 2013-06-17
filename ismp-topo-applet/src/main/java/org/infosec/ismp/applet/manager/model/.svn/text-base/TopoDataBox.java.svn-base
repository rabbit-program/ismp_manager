package org.infosec.ismp.applet.manager.model;

import org.infosec.ismp.applet.manager.task.AddOrUpdateLinkTask;
import org.infosec.ismp.applet.manager.task.DeleteDomainTask;
import org.infosec.ismp.applet.manager.task.DeleteNodeTask;
import org.infosec.ismp.applet.manager.utilities.TopoConst;

import twaver.DataBoxAdapter;
import twaver.DataBoxEvent;
import twaver.DataBoxSelectionEvent;
import twaver.DataBoxSelectionListener;
import twaver.Element;
import twaver.TDataBox;
import twaver.network.TNetwork;

public class TopoDataBox extends TDataBox{
	public TopoDataBox(String name) {
		super(name);
		init();
	}
	
	public void init() {
//		this.getSelectionModel().addDataBoxSelectionListener(
//				new TNetwork().setCurrentSubNetwork();
//				new DataBoxSelectionListener() {
//					public void selectionChanged(DataBoxSelectionEvent e) {
//						System.out.println("(((((((((((((((((((((((((((((((((((((((");
//					}
//				});

			this.addDataBoxListener(new DataBoxAdapter() {
			// ----做删除
			public void elementRemoved(DataBoxEvent e) {
				Element element  = e.getElement();
				if(element == null) {
					return;
				}
				if(element instanceof NodeModel) {
					new DeleteNodeTask((NodeModel)element).execute();
				} else if(element instanceof DomainModel) {
					new DeleteDomainTask((DomainModel)element).execute();
				}
			}
			
			
			  public void elementsCleared(DataBoxEvent e)
			  {
			  }
			
			// 添加数据
			public void elementAdded(DataBoxEvent e) {
				Element element  = e.getElement();
				if(element == null) {
					return;
				}
				if(element instanceof LinkModel && TopoConst.isInited) {
					new AddOrUpdateLinkTask((LinkModel)element).execute();
				}
			}
			
		});
		
		
	}
	
}
