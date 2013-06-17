package edu.sjtu.infosec.ismp.manager.comm.model.page;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Page
 * @author Wu Guojie
 * @date 2010-08-06
 * @version 1.0
 */
public class Page {

    /** 是否有上一页 */    
    private boolean hasPrePage;    
      
    /** 是否有下一页 */    
    private boolean hasNextPage;    
      
    /** 每页的数量 */    
    private int everyPage = new Integer(5).intValue();  
      
    /** 总页数 */    
    private int totalPage;    
      
    /** 当前页*/    
    private int currentPage;    
      
    /** 起始点 */    
    private int beginIndex;    
      
    /** 总记录数*/    
    private int totalCount;
    
    private int prePage;       //上一页
    
    private List list;
    
    public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	private int nextPage;   //下一页
    /** 
     * 构造函数
     * */  
    public Page(){}
    
    /** 
     * 构造函数
     * @param beginindex 
     * beginIndex.
     * @param everypage 
     * everyPage.
     * */ 
    public Page(int beginindex, int everypage) {
        this.beginIndex = beginindex;
        this.everyPage = everypage;
    }
    
    /** 
     * 构造函数
     * @param everypage 
     * everyPage.
     * */ 
    public Page(int everypage){
        this.everyPage = everypage;
    }
    
    /** 
     * 构造函数
     * @param hasprePage 
     * 是否有上一页.
     * @param hasnextPage 
     * 是否有下一页.
     * @param everypage 
     * 每页多少条记录.
     * @param totalpage 
     * 共多少页.
     * @param currentpage 
     * 现第几页.
     * @param beginindex 
     * 第一条记录所在位置.
     * @param totalcount 
     * 共多少条记录.
     * */
    public Page(boolean hasprePage, 
                boolean hasnextPage, 
                int everypage, 
                int totalpage, 
                int currentpage, 
                int beginindex, 
                int totalcount) {
        this.hasPrePage = hasprePage;
        this.hasNextPage = hasnextPage;
        this.everyPage = everypage;
        this.totalPage = totalpage;
        this.currentPage = currentpage;
        this.beginIndex = beginindex;
        this.totalCount = totalcount;
    }
    
    /** 
     * 
     * @return true/false 
     * 
     * */ 
    public boolean isHasPrePage() {
        return hasPrePage;
    }

    /** 
     * 
     * @param hasprePage 
     * hasPrePage
     * */ 
    public void setHasPrePage(boolean hasprePage) {
        this.hasPrePage = hasprePage;
    }

    /** 
     * 
     * @return true/false 
     * 
     * */ 
    public boolean isHasNextPage() {
        return hasNextPage;
    }

    /** 
     * 
     * @param hasnextPage 
     * hasnextPage
     * */ 
    public void setHasNextPage(boolean hasnextPage) {
        this.hasNextPage = hasnextPage;
    }

    /** 
     * 
     * @return everyPage 
     * 
     * */ 
    public int getEveryPage() {
        return everyPage;
    }

    /** 
     * 
     * @param everypage 
     * everypage
     * */ 
    public void setEveryPage(int everypage) {
        this.everyPage = everypage;
    }

    /** 
     * 
     * @return totalPage 
     * 
     * */ 
    public int getTotalPage() {
        return totalPage;
    }

    /** 
     * 
     * @param totalpage 
     * totalpage
     * */ 
    public void setTotalPage(int totalpage) {
        this.totalPage = totalpage;
    }

    /** 
     * 
     * @return currentPage 
     * 
     * */ 
    public int getCurrentPage() {
        return currentPage;
    }

    /** 
     * 
     * @param currentpage 
     * currentpage
     * */ 
    public void setCurrentPage(int currentpage) {
        this.currentPage = currentpage;
    }

    /** 
     * 
     * @return beginIndex 
     * 
     * */ 
    public int getBeginIndex() {
        return beginIndex;
    }

    /** 
     * 
     * @param beginindex 
     * beginindex
     * */ 
    public void setBeginIndex(int beginindex) {
        this.beginIndex = beginindex;
    }

    /** 
     * 
     * @return totalCount 
     * 
     * */ 
    public int getTotalCount() {
        return totalCount;
    }

    /** 
     * 
     * @param totalcount 
     * totalcount
     * */
    public void setTotalCount(int totalcount) {
        this.totalCount = totalcount;
    }

    /** 
     * @param o .
     * Page.
     * @return boolean.
     * 
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
        .append("hasPrePage:"+hasPrePage)
        .append(" hasNextPage:"+hasNextPage)
        .append(" everyPage:"+everyPage)
        .append(" totalPage:"+totalPage)
        .append(" currentPage:"+currentPage)
        .append(" beginIndex:"+beginIndex)
        .append(" totalCount:"+totalCount)
        .hashCode();
    }

    /** 
     * 
     * @return String 
     * 
     * */ 
    public String toString() {
        
        return new ToStringBuilder(this)
        .append("hasPrePage:"+hasPrePage)
        .append(" hasNextPage:"+hasNextPage)
        .append(" everyPage:"+everyPage)
        .append(" totalPage:"+totalPage)
        .append(" currentPage:"+currentPage)
        .append(" beginIndex:"+beginIndex)
        .append(" totalCount:"+totalCount)
        .toString();
        
    }
    
}
