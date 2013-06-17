package edu.sjtu.infosec.ismp.manager.RAM.web.form;

import org.apache.struts.action.ActionForm;

/**
 * 界面层 问卷表单类.
 */

public class AsseInfoPapeForm extends ActionForm  {

    /**
     * 编号
     */
    private Integer id;

    /**
     * 项目编号
     * */
    private String asseInfoProjId;
    
    /**
     * 关联安全要素
     */
    private String secuElemId;

    /**
     * 答案
     */
    private String answer;

    /**
     * 现场记录
     */
    private String record;

    

    /**
     * 备注
     */
    private String memo;

    

    /**
     * @return id
     */
    public  Integer getId() {
        return id;
    }

    /**
     * @param recoId
     *            编号
     */
    public  void setId(Integer recoId) {
        this.id = recoId;
    }
    
    /**
     * @return asseInfoProjId
     * */
    public String getAsseInfoProjId() {
        return asseInfoProjId;
    }

    /**
     * @param asseInfoProjVid
     *            项目编号
     * */
    public void setAsseInfoProjId(String asseInfoProjVid) {
        this.asseInfoProjId = asseInfoProjVid;
    }
    

    /**
     * @return secuElem
     */
    
    public  String getSecuElemId() {
        return secuElemId;
    }

    /**
     * @param secuelem
     *            安全要素
     */
    public  void setSecuElemId(String secuelemId) {
        this.secuElemId = secuelemId;
    }

    /**
     * @return answer
     */
    public  String getAnswer() {
        return answer;
    }

    /**
     * @param answ
     *            答案
     */
    public  void setAnswer(String answ) {
        this.answer = answ;
    }

    /**
     * @return record
     */
    public  String getRecord() {
        return record;
    }

    /**
     * @param reco
     *            现场记录
     */
    public  void setRecord(String reco) {
        this.record = reco;
    }

    /**
     * @return memo
     */
    public  String getMemo() {
        return memo;
    }

    /**
     * @param paperMemo
     *            备注
     */
    public  void setMemo(String paperMemo) {
        this.memo = paperMemo;
    }
}
