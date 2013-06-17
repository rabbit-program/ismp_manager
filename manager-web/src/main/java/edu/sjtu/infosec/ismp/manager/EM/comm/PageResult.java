package edu.sjtu.infosec.ismp.manager.EM.comm;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * PageResult.
 *
 */
public class PageResult extends Object {

    /** 翻页导航条状态 */    
    private Page page;

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

}
