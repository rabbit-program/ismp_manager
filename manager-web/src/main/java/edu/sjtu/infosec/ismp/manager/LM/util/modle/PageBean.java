package edu.sjtu.infosec.ismp.manager.LM.util.modle;

import java.io.Serializable;
import java.util.List;

public class PageBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8329716761247980255L;
	
	//每页多少行
	private Integer pageRowNum;
	
	//当前第几页
	private Integer pageNo;
	
	//一共多少页
	private Integer pageMaxSum;
	
	//一共多少行
	private Integer resultRowSum;
	
	//存放返回结果
	private List<?> pageResult;

	public Integer getPageRowNum() {
		return pageRowNum;
	}

	public void setPageRowNum(Integer pageRowNum) {
		this.pageRowNum = pageRowNum;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public Integer getResultRowSum() {
		return resultRowSum;
	}

	public void setResultRowSum(Integer resultRowSum) {
		this.resultRowSum = resultRowSum;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageMaxSum() {
		return pageMaxSum;
	}

	public void setPageMaxSum(Integer pageMaxSum) {
		this.pageMaxSum = pageMaxSum;
	}

	public List<?> getPageResult() {
		return pageResult;
	}

	public void setPageResult(List<?> pageResult) {
		this.pageResult = pageResult;
	}
	
	
}
