package edu.sjtu.infosec.ismp.manager.RAM.web.form;

import org.apache.struts.action.ActionForm;


/**
 * 界面层 业务信息表单类.
 */
public class AsseInfoBusiForm extends ActionForm {

    /**
     * 主键id
     * */
    private Integer id;
    
    /**
     * 业务编号
     * */
    private String businessId;
    
    /**
     * 业务名称
     * */
    private String businessName;
    
    /**
     * 业务负责人
     * */
    private String respMan;
    
    /**
     * 业务重要性
     * */
    private String importance;

    /**
     * @return businessId
     * */
    public  String getBusinessId() {
        return businessId;
    }

    /**
     * @return id
     * */
    public Integer getId() {
        return id;
    }

    /**
     * @param vid 主键id
     * */
    public void setId(Integer vid) {
        this.id = vid;
    }

    /**
     * @param businessid 业务编号
     * */
    public  void setBusinessId(String businessid) {
        this.businessId = businessid;
    }

    /**
     * @return businessName
     * */
    public  String getBusinessName() {
        return businessName;
    }

    /**
     * @param businessname 业务名称
     * */
    public  void setBusinessName(String businessname) {
        this.businessName = businessname;
    }

    /**
     * @return respMan
     * */
    public  String getRespMan() {
        return respMan;
    }

    /**
     * @param respman 业务负责人
     * */
    public  void setRespMan(String respman) {
        this.respMan = respman;
    }

    /**
     * @return importance
     * */
    public  String getImportance() {
        return importance;
    }

    /**
     * @param impo 重要性
     * */
    public  void setImportance(String impo) {
        this.importance = impo;
    }
    
}
