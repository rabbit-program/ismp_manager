package edu.sjtu.infosec.ismp.manager.VPM.pm.comm;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
public class PMPage {

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
    /**是否在当前页*/
    private int countPage;
    
	private int prePage;       //上一页
    
    private int nextPage;   //下一页
   
    private PMPage pageInfo ;
    
	public PMPage getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(PMPage pageInfo) {
		this.pageInfo = pageInfo;
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
    public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

    /** 
     * 构造函数
     * */  
    public PMPage(){}
    
    /** 
     * 构造函数
     * @param beginindex 
     * beginIndex.
     * @param everypage 
     * everyPage.
     * */ 
    public PMPage(int beginindex, int everypage) {
        this.beginIndex = beginindex;
        this.everyPage = everypage;
    }
    
    /** 
     * 构造函数
     * @param everypage 
     * everyPage.
     * */ 
    public PMPage(int everypage){
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
    public PMPage(boolean hasprePage, 
                boolean hasnextPage, 
                int everypage, 
                int totalpage, 
                int currentpage, 
                int beginindex, 
                int totalcount,
                int countPage) {
        this.hasPrePage = hasprePage;
        this.hasNextPage = hasnextPage;
        this.everyPage = everypage;
        this.totalPage = totalpage;
        this.currentPage = currentpage;
        this.beginIndex = beginindex;
        this.totalCount = totalcount;
        this.countPage = countPage;
    }
    
    /** 
     * 
     * @return true/false 
     * 
     * */ 
    public boolean getHasPrePage() {
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
    public boolean getHasNextPage() {
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
    @SuppressWarnings("static-access")
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
