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
 * 交换机模型
 */
@SuppressWarnings("serial")
public class TopoSwitchModel extends NodeModel implements TopoNode{
	/**
	 * 模型的名字 并重写name属性
	 */
	private static final String name="交换机";
	/**
	 * 灰色小图标
	 */
	private static final ImageIcon H = new ImageIcon(ImagePath.class.getResource("TopoSwitchModel-H.gif"));
	/**
	 * 灰色大图标
	 */
	private static final ImageIcon DH = new ImageIcon(ImagePath.class.getResource("TopoSwitchModel-DH.gif"));
	
	/**
	 * 彩色小图标
	 */
	private static final ImageIcon C = new ImageIcon(ImagePath.class.getResource("TopoSwitchModel-C.gif"));
	/**
	 * 彩色大图标
	 */
	private static final ImageIcon DC = new ImageIcon(ImagePath.class.getResource("TopoSwitchModel-DC.gif"));
	
	static {
		TUIManager.registerIcon(TopoSwitchModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoSwitchModel-H.gif");
		TUIManager.registerImage(TopoSwitchModel.class, "/org/infosec/ismp/applet/manager/model/image/TopoSwitchModel-DH.gif");
		TWaverUtil.registerImageIcon("TopoSwitchModel", DC);
		TWaverUtil.registerImageIcon("TopoSwitchModelSmall", C);
	}
	
	public TopoSwitchModel() {
		super.setName(name);
	}
	
	
	/**
     * 获取激活大图标
     */
    public String activeBigICO() {
		return "TopoSwitchModel";	
    }
    
    /**
     * 获取激活小图标
     */
    
    public String activeSmallICO() {
		return "TopoSwitchModelSmall";	
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
