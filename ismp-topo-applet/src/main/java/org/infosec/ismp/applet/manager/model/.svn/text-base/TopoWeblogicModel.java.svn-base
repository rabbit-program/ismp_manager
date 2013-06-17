package org.infosec.ismp.applet.manager.model;

import javax.swing.ImageIcon;

import org.infosec.ismp.applet.manager.model.image.ImagePath;

import twaver.TUIManager;
import twaver.TWaverUtil;

@SuppressWarnings("serial")
public class TopoWeblogicModel  extends NodeModel implements TopoNode{
	/**
	 * 模型的名字 并重写name属性
	 */
	private static final String name="Weblogic服务";
	/**
	 * 灰色小图标
	 */
	private static final ImageIcon H = new ImageIcon(ImagePath.class.getResource("TopoWeblogicModel-H.png"));
	/**
	 * 灰色大图标
	 */
	private static final ImageIcon DH = new ImageIcon(ImagePath.class.getResource("TopoWeblogicModel-DH.png"));
	
	/**
	 * 彩色小图标
	 */
	private static final ImageIcon C = new ImageIcon(ImagePath.class.getResource("TopoWeblogicModel-C.png"));
	/**
	 * 彩色大图标
	 */
	private static final ImageIcon DC = new ImageIcon(ImagePath.class.getResource("TopoWeblogicModel-DC.png"));
	
	static {
		TUIManager.registerIcon(TopoWeblogicModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoWeblogicModel-H.png");
		TUIManager.registerImage(TopoWeblogicModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoWeblogicModel-DH.png");
		TWaverUtil.registerImageIcon("TopoWeblogicModel", DC);
		TWaverUtil.registerImageIcon("TopoWeblogicModelSmall", C);
	} 
	
	public TopoWeblogicModel() {
		super.setName(name);
	}
	
	
	/**
     * 获取激活大图标
     */
    public String activeBigICO() {
		return "TopoWeblogicModel";	
    }
    
    /**
     * 获取激活小图标
     */
    
    public String activeSmallICO() {
		return "TopoWeblogicModelSmall";	
    }
    
    /**
	 * 获得设备大图标
	 * @return ImageIcon
	 */
    public ImageIcon getImage(){
    	return DH;
    }

	/**
	 * 获得设备小图标
	 * @return ImageIcon
	 */
    public ImageIcon getIcon(){
    	return H;
	 }
}
