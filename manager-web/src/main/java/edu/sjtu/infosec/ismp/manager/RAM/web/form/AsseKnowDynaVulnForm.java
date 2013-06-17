package edu.sjtu.infosec.ismp.manager.RAM.web.form;

import org.apache.struts.action.ActionForm;

/**
 * 界面层 动态脆弱点分析表单类.
 */
public class AsseKnowDynaVulnForm extends ActionForm {
	private static final long serialVersionUID = -7495557181315428207L;

	/**
     * 编号
     **/
    private Integer id;

    /**
     * 项目编号
     **/
    private Integer asseInfoProjId;
    
    /**
     * 脆弱点编号
     **/
    private Integer asseKnowStatVulnPoinId;

    /**
     * 脆弱点类别编号
     **/
    private Integer asseKnowStatVulnKindId;
    
    /**
     * 关联资产
     **/
    private String assetCode;

    /**
     * 所属业务编号
     */
    private String asseInfoBusiId;
    
    /**
     * 严重程度
     **/
    private String seriLeve;

    /**
     * 来源
     */
    private String source;
    
    /**
     * 动态脆弱点分析id数组
     **/
    private String[] dynaVulnPoinIds;
    
    /**
     * 静态脆弱点类别编号数组
     **/
    private String[] statVulnKindIds;
    
    /**
     * 静态脆弱点编号数组
     **/
    private String[] statVulnPoinIds;
    
    /**
     * 严重程度数组
     **/
    private String[] secuLeves;

    /**
     * @return id
     **/
	public Integer getId() {
		return id;
	}

	/**
     * @param vid
     *            资产脆弱性记录编号
     **/
	public void setId(Integer vid) {
		this.id = vid;
	}

	/**
     * @return asseInfoProjId
     **/
	public Integer getAsseInfoProjId() {
		return asseInfoProjId;
	}

	/**
     * @param vasseInfoProjId 关联测评项目Id
     **/
	public void setAsseInfoProjId(Integer vasseInfoProjId) {
		this.asseInfoProjId = vasseInfoProjId;
	}

	/**
     * @return asseKnowStatVulnPoinId
     **/
	public Integer getAsseKnowStatVulnPoinId() {
		return asseKnowStatVulnPoinId;
	}

	/**
     * @param vasseKnowStatVulnPoinId
     *            脆弱点编号
     **/
	public void setAsseKnowStatVulnPoinId(Integer vasseKnowStatVulnPoinId) {
		this.asseKnowStatVulnPoinId = vasseKnowStatVulnPoinId;
	}

	/**
     * @return asseKnowStatVulnKindId
     **/
	public Integer getAsseKnowStatVulnKindId() {
		return asseKnowStatVulnKindId;
	}

	/**
     * @param vasseKnowStatVulnKindId
     *            脆弱点类别编号
     **/
	public void setAsseKnowStatVulnKindId(Integer vasseKnowStatVulnKindId) {
		this.asseKnowStatVulnKindId = vasseKnowStatVulnKindId;
	}

	/**
     * @return assetCode
     **/
	public String getAssetCode() {
		return assetCode;
	}

	/**
     * @param vassetCode
     *       关联资产编号
     **/
	public void setAssetCode(String vassetCode) {
		this.assetCode = vassetCode;
	}

	/**
     * @return asseInfoBusiId
     */
    public String getAsseInfoBusiId() {
        return asseInfoBusiId;
    }

    /**
     * @param asseInfoBusiVid
     *            所属业务id
     */
    public void setAsseInfoBusiId(String asseInfoBusiVid) {
        this.asseInfoBusiId = asseInfoBusiVid;
    }
    
	/**
     * @return seriLeve
     **/
	public String getSeriLeve() {
		return seriLeve;
	}

	/**
     * @param vseriLeve
     *            严重程度
     **/
	public void setSeriLeve(String vseriLeve) {
		this.seriLeve = vseriLeve;
	}

	/**
     * @return source
     **/
	public String getSource() {
		return source;
	}

	/**
     * @param vsource
     *            来源
     **/
	public void setSource(String vsource) {
		this.source = vsource;
	}

	/**
     * @return dynaVulnPoinIds
     **/
	public String[] getDynaVulnPoinIds() {
		return dynaVulnPoinIds;
	}

	/**
     * @param vdynaVulnPoinIds
     *     动态脆弱点分析id数组
     **/
	public void setDynaVulnPoinIds(String[] vdynaVulnPoinIds) {
		this.dynaVulnPoinIds = vdynaVulnPoinIds;
	}

	/**
     * @return dynaVulnPoinIds
     **/
	public String[] getStatVulnKindIds() {
		return statVulnKindIds;
	}

	/**
     * @param vstatVulnKindIds
     *     脆弱点类别id数组
     **/
	public void setStatVulnKindIds(String[] vstatVulnKindIds) {
		this.statVulnKindIds = vstatVulnKindIds;
	}

	/**
     * @return dynaVulnPoinIds
     **/
	public String[] getStatVulnPoinIds() {
		return statVulnPoinIds;
	}

	/**
     * @param vstatVulnPoinIds
     *     脆弱点id数组
     **/
	public void setStatVulnPoinIds(String[] vstatVulnPoinIds) {
		this.statVulnPoinIds = vstatVulnPoinIds;
	}

	/**
     * @return dynaVulnPoinIds
     **/
	public String[] getSecuLeves() {
		return secuLeves;
	}

	/**
     * @param vsecuLeves
     *     严重程度数组
     **/
	public void setSecuLeves(String[] vsecuLeves) {
		this.secuLeves = vsecuLeves;
	}
    
    
}
