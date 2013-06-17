/**
 * 版权所有：上海鹏越惊虹信息技术发展有限公司
 */
package org.infosec.ismp.applet.manager.model;

import javax.swing.ImageIcon;

import org.infosec.ismp.applet.manager.model.image.ImagePath;

import twaver.TUIManager;
import twaver.TWaverUtil;

/**
 * @author 肖高峰
 * @version 创建时间：2009-6-6 下午06:31:30
 * IDS模型类
 */

@SuppressWarnings("serial")
public class TopoIdsModel extends NodeModel implements TopoNode{
	/**
	 * 模型的名字 并重写name属性
	 */
	private static final String name="IDS";
	/**
	 * 灰色小图标
	 */
	private static final ImageIcon H = new ImageIcon(ImagePath.class.getResource("TopoIdsModel-H.gif"));
	/**
	 * 灰色大图标
	 */
	private static final ImageIcon DH = new ImageIcon(ImagePath.class.getResource("TopoIdsModel-DH.gif"));
	
	/**
	 * 彩色小图标
	 */
	private static final ImageIcon C = new ImageIcon(ImagePath.class.getResource("TopoIdsModel-C.gif"));
	/**
	 * 彩色大图标
	 */
	private static final ImageIcon DC = new ImageIcon(ImagePath.class.getResource("TopoIdsModel-DC.gif"));
	
	static {
		TUIManager.registerIcon(TopoIdsModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoIdsModel-H.gif");
		TUIManager.registerImage(TopoIdsModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoIdsModel-DH.gif");
		TWaverUtil.registerImageIcon("TopoIdsModel", DC);
		TWaverUtil.registerImageIcon("TopoIdsModelSmall", C);
	} 
	
	public TopoIdsModel() {
		super.setName(name);
	}
	
	
	/**
     * 获取激活大图标
     */
    public String activeBigICO() {
		return "TopoIdsModel";	
    }
    
    /**
     * 获取激活小图标
     */
    
    public String activeSmallICO() {
		return "TopoIdsModelSmall";	
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
