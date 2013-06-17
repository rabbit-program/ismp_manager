package edu.sjtu.infosec.ismp.manager.VPM.sd.web.form;

import java.sql.Timestamp;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.DispatchPolicy;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.ExecutePolicy;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.SoftwareInfo;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.TypeInfo;
import edu.sjtu.infosec.ismp.manager.VPM.sd.model.ValidatePolicy;

public class SoftwareForm  extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8934497559099343924L;
	private DispatchPolicy dp = new DispatchPolicy();
	private ExecutePolicy ep = new ExecutePolicy();
	private SoftwareInfo si = new SoftwareInfo();
	private TypeInfo ti = new TypeInfo();
	private ValidatePolicy vp = new ValidatePolicy();
	private FormFile formFile;
	
	// 分发时间
	private String starttime;
	private String endtime;
	
    //封着页面时间通用字段
	private String commonStartTime;
	private String commonEndTime;
	
	//
	private String isDispatch;
	private String isExecute;
	private String isValidate;
	
    //软件路径
	private String path;

	private String xmlPath;
	
	/**
	 * @return the dp
	 */
	public DispatchPolicy getDp() {
		return dp;
	}
	/**
	 * @param dp the dp to set
	 */
	public void setDp(DispatchPolicy dp) {
		this.dp = dp;
	}
	/**
	 * @return the ep
	 */
	public ExecutePolicy getEp() {
		return ep;
	}
	/**
	 * @param ep the ep to set
	 */
	public void setEp(ExecutePolicy ep) {
		this.ep = ep;
	}
	/**
	 * @return the xmlPath
	 */
	public String getXmlPath() {
		return xmlPath;
	}
	/**
	 * @param xmlPath the xmlPath to set
	 */
	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}
	/**
	 * @return the si
	 */
	public SoftwareInfo getSi() {
		si.setDispatchPolicy(dp);
		si.setExecutePolicy(ep);
		si.setTypeInfo(ti);
		si.setValidatePolicy(vp);
		return si;
	}
	/**
	 * @param si the si to set
	 */
	public void setSi(SoftwareInfo si) {
		this.si = si;
	}
	/**
	 * @return the ti
	 */
	public TypeInfo getTi() {
		return ti;
	}
	/**
	 * @param ti the ti to set
	 */
	public void setTi(TypeInfo ti) {
		this.ti = ti;
	}
	/**
	 * @return the vp
	 */
	public ValidatePolicy getVp() {
		return vp;
	}
	/**
	 * @param vp the vp to set
	 */
	public void setVp(ValidatePolicy vp) {
		this.vp = vp;
	}
	/**
	 * @return the formFile
	 */
	public FormFile getFormFile() {
		return formFile;
	}
	/**
	 * @param formFile the formFile to set
	 */
	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}
	/**
	 * @return the starttime
	 */
	public String getStarttime() {
		return starttime;
	}
	/**
	 * @param starttime the starttime to set
	 */
	public void setStarttime(String starttime) {
		if(!starttime.isEmpty()){
			this.dp.setDispatchStartTime(getTime(starttime));
			this.starttime = starttime;
		}else{
			this.starttime = null;
		}
	}
	/**
	 * @return the endtime
	 */
	public String getEndtime() {
		return endtime;
	}
	/**
	 * @param endtime the endtime to set
	 */
	public void setEndtime(String endtime) {
		if(!endtime.isEmpty()){
			this.dp.setDispatchEndTime(getTime(endtime));
			this.endtime = endtime;
		}else{
			this.endtime = null;
		}
	}
	/**
	 * 
	 * @param timel
	 * @return String  将时间转换成分钟
	 */
	private Long getTime(String time){
		  try {
				if (time != null && time.indexOf(":") != -1) {
					String hour = time.substring(0, time
							.indexOf(":"));
					
					Long hourL = Long.valueOf(hour) * 60;
					String minut = time.substring(time
							.indexOf(":") + 1, time.length());
					Long minuteL = Long.valueOf(minut);
				  return hourL + minuteL;
			    }
		} catch (Exception e) {
		}
	return 0L;
	}
	/**
	 * @return the commonStartTime
	 */
	public String getCommonStartTime() {
		return commonStartTime;
	}
	/**
	 * @param commonStartTime the commonStartTime to set
	 */
	public void setCommonStartTime(String commonStartTime) {
		if(!commonStartTime.isEmpty()){
			this.dp.setDispatchStartDate(Timestamp.valueOf(commonStartTime));
			this.commonStartTime = commonStartTime;
		}else{
			this.commonStartTime = null;
		}
	}
	/**
	 * @return the commonEndTime
	 */
	public String getCommonEndTime() {
		return commonEndTime;
	}
	/**
	 * @param commonEndTime the commonEndTime to set
	 */
	public void setCommonEndTime(String commonEndTime) {
		if(!commonEndTime.isEmpty()){
			this.dp.setDispatchEndDate(Timestamp.valueOf(commonEndTime));
			this.commonEndTime = commonEndTime;
		}else{
			this.commonEndTime = null;
		}
	}
	/**
	 * @param isDispatch the isDispatch to set
	 */
	public void setIsDispatch(String isDispatch) {
		 this.dp.setDispatchCheckTag(getIsBool(isDispatch));
	}
	/**
	 * @param isExecute the isExecute to set
	 */
	public void setIsExecute(String isExecute) {
		this.ep.setExecuteCheckTag(getIsBool(isExecute));
	}
	/**
	 * @param isvalidate the isvalidate to set
	 */
	public void setIsValidate(String isValidate) {
		this.vp.setValidateCheckTag(getIsBool(isValidate));
	}
	private Boolean getIsBool(String bs){
		if(!bs.isEmpty()){
			if( bs.equals("true")){
				return true;
			}else if(bs.equals("false")){
				return false;
			}
		}
		return  null;
	}
	/**
	 * @return the patch
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param patch the patch to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
}
