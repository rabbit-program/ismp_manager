package edu.sjtu.infosec.ismp.manager.comm.model.page;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import edu.sjtu.infosec.ismp.manager.VPM.pm.comm.PMPage;

/**
 * PageResult
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public class PageResult {

    /** 翻页导航条状态 */    
    private Page page;


	private PMPage pmpage;

    /** 页面记录列表 */    
    private List pageList;

    /** 
     * 构造函数
     * */ 
    public PageResult() {
        super();
    }

    /** 
     * 构造函数
     * @param ppage 
     * 翻页导航条状态.
     * @param pagelist 
     * 页面记录列表.
     * */ 
    public PageResult(Page ppage, List pagelist) {
        this.page = ppage;
        this.pageList = pagelist;
    }

    /** 
     * 
     * @return page 
     * 
     * */
    public Page getPage() {
        return page;
    }

    /** 
     * 
     * @param ppage 
     * Page
     * */ 
    public void setPage(Page ppage) {
        this.page = ppage;
    }

    /** 
     * 
     * @return pageList 
     * 
     * */
    public List getPageList() {
        return pageList;
    }

    /** 
     * 
     * @param pagelist 
     * pageList
     * */ 
    public void setPageList(List pagelist) {
        this.pageList = pagelist;
    }

    /** 
     * @param o 
     * Page
     * @return boolean 
     * */ 
    public boolean equals(Object o) {
        
        return new EqualsBuilder().reflectionEquals(this, o);
    }

    /** 
     * 
     * @return hashCode 
     * 
     * */ 
    public int hashCode() {
        
        return new HashCodeBuilder()
        .append(page)
        .append(" pageList.size():"+pageList.size())
        .hashCode();
    }

    /** 
     * 
     * @return String 
     * 
     * */ 
    public String toString() {
        
        return new ToStringBuilder(this)
        .append("page:"+page)
        .append(" pageList.size():"+pageList.size())
        .toString();
    }
    
    public PMPage getPmpage() {
		return pmpage;
	}

	public void setPmpage(PMPage pmpage) {
		this.pmpage = pmpage;
	}
}
