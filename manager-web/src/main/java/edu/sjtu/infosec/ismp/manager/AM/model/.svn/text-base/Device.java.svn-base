package edu.sjtu.infosec.ismp.manager.AM.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * 完整类名：edu.sjtu.infosec.ismp.base.device.Device <br>
 * 所在工程：ismp-base <br>
 * 说明：
 * 
 * @author $Author: event $
 * @version $Revision: 22078 $ $Date: 2009-06-23 17:02:56 +0800 (周二, 23 六月 2009)
 *          $
 * 
 */
public class Device implements Serializable{

    private static final long serialVersionUID = -3058412529773594974L;

    private String type;// 设备种类

	private String brand;// 设备品牌

	private String model;// 设备型号

	private String optionalClassifier;// 保留字段

	private String ipAddress; // 设备IP地址

	private String physAddress;// 设备物理地址

	private String community; // SNMP需要的团体名
	
	private Integer idFromAsset; // 资产模块的id号

	public Integer getIdFromAsset() {
		return idFromAsset;
	}

	public void setIdFromAsset(Integer idFromAsset) {
		this.idFromAsset = idFromAsset;
	}

	private static final String REGEX = "([0-9,a-f,A-F]{2}[:,\\-]){5}[0-9,a-f,A-F]{2}";

	private static final Pattern PATTERN = Pattern.compile(REGEX);

	// /**
	// * 构造方法
	// *
	// * @param vPhysAddress
	// */
	// public Device(String vPhysAddress) {
	// if (vPhysAddress == null) {
	// throw new IllegalArgumentException("null physAddress");
	// }
	//
	// Matcher m = PATTERN.matcher(vPhysAddress);
	// if (!m.matches()) {
	// throw new IllegalArgumentException("malformed physAddress");
	// }
	// physAddress = vPhysAddress;
	// }

	/**
	 * 方法说明：
	 * 
	 * @return
	 */
	public String getCommunity() {
		return community;
	}

	/**
	 * 方法说明：
	 * 
	 * @param community
	 */
	public void setCommunity(String community) {
		this.community = community;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOptionalClassifier() {
		return optionalClassifier;
	}

	public void setOptionalClassifier(String optionalClassifier) {
		this.optionalClassifier = optionalClassifier;
	}

	public String getPhysAddress() {
		return physAddress;
	}

	public void setPhysAddress(String physAddress) {
		if(physAddress!=null){
			String trimmed = physAddress.trim();
			
			this.physAddress = trimmed.replaceAll(Pattern.quote("-"), ":").toUpperCase();
		}
	}

	/**
	 * Getter方法
	 * 
	 * @return the ipAddress
	 */
	public final String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Setter方法
	 * 
	 * @param vIpAddress
	 *            the ipAddress to set
	 */
	public final void setIpAddress(String vIpAddress) {
		ipAddress = vIpAddress;
	}
	

	public boolean equals(final Object other) {
		if (!(other instanceof Device))
			return false;
		Device castOther = (Device) other;
		EqualsBuilder eqb=new EqualsBuilder();
		  if(!("pc").equals(type)){
		  eqb.append(type, castOther.type).append(brand,
				castOther.brand).append(model, castOther.model).append(
				optionalClassifier, castOther.optionalClassifier).
				append(ipAddress, castOther.ipAddress).append(community, castOther.community);
				
		  }else{
			  eqb.append(physAddress, castOther.physAddress);  
		  }
		 
		 return eqb.isEquals();
	}

	public int hashCode() {
		
		 HashCodeBuilder	hcb=new HashCodeBuilder();
		 if(!"pc".equals(type)){
		hcb.append(type).append(brand).append(model)
				.append(optionalClassifier).append(ipAddress).append(idFromAsset);
		 }else{
			 hcb.append(physAddress) ;
		 }
		 
		 return hcb.toHashCode();
	}

	public String toString() {
		ToStringBuilder tsb= new ToStringBuilder(this);
		
		if(!"pc".equals(type)){
		tsb.append("type", type).append("brand",
				brand).append("model", model).append("optionalClassifier",
				optionalClassifier).append("ipAddress", ipAddress)
				.append("community", community);
		}else{
			tsb.append(physAddress);
		}
		return tsb.toString();
	}

}
