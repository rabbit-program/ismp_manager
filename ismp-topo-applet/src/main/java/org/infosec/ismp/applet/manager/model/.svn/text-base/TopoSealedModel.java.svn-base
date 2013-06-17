package org.infosec.ismp.applet.manager.model;

import javax.swing.ImageIcon;


/**
 * @author 肖高峰
 * 未知类型
 */
@SuppressWarnings("serial")
public class TopoSealedModel extends NodeModel implements TopoNode{
	/**
	 * 模型的名字 并重写name属性
	 */
	private static final String name="未知类型设备";
	
	public TopoSealedModel() {
		super.setName(name);
	}
	
	
	/**
     * 获取激活大图标
     */
    public String activeBigICO() {
		return super.getImageURL();
    }
    
    /**
     * 获取激活小图标
     */
    
    public String activeSmallICO() {
		return super.getIconURL();
    }
    
    /**
	 * 获得设备大图标
	 * @return ImageIcon
	 */
    public ImageIcon getImage(){
		return super.getImage();
    }

	/**
	 * 获得设备小图标
	 * @return ImageIcon
	 */
    public ImageIcon getIcon(){
    	return super.getIcon();
	 }
}
