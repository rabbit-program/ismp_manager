package org.infosec.ismp.applet.manager.model;

import javax.swing.ImageIcon;

import org.infosec.ismp.applet.manager.model.image.ImagePath;

import twaver.TUIManager;
import twaver.TWaverUtil;

@SuppressWarnings("serial")
public class TopoDatabaseModel  extends NodeModel implements TopoNode{
	/**
	 * 模型的名字 并重写name属性
	 */
	private static final String name="数据库";
	/**
	 * 灰色小图标
	 */
	private static final ImageIcon H = new ImageIcon(ImagePath.class.getResource("TopoDatabaseModel-H.png"));
	/**
	 * 灰色大图标
	 */
	private static final ImageIcon DH = new ImageIcon(ImagePath.class.getResource("TopoDatabaseModel-DH.png"));
	
	/**
	 * 彩色小图标
	 */
	private static final ImageIcon C = new ImageIcon(ImagePath.class.getResource("TopoDatabaseModel-C.png"));
	/**
	 * 彩色大图标
	 */
	private static final ImageIcon DC = new ImageIcon(ImagePath.class.getResource("TopoDatabaseModel-DC.png"));
	
	static {
		TUIManager.registerIcon(TopoDatabaseModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoDatabaseModel-H.png");
		TUIManager.registerImage(TopoDatabaseModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoDatabaseModel-DH.png");
		TWaverUtil.registerImageIcon("TopoDatabaseModel", DC);
		TWaverUtil.registerImageIcon("TopoDatabaseModelSmall", C);
	} 
	
	public TopoDatabaseModel() {
		super.setName(name);
	}
	
	
	/**
     * 获取激活大图标
     */
    public String activeBigICO() {
		return "TopoDatabaseModel";	
    }
    
    /**
     * 获取激活小图标
     */
    
    public String activeSmallICO() {
		return "TopoDatabaseModelSmall";	
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
