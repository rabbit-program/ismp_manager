package edu.sjtu.infosec.ismp.manager.EM.util;

import edu.sjtu.infosec.ismp.manager.EM.comm.Page;


/**
 * PageUtil.
 * 
 * @version 1.0 11 May 2009
 * @author zhou chenye
 */
public class PageUtil {

    /**
     * This method create a Page Object to be used in web navigation.
     *
     * @param page 设置好everyPage和currentPage的page对象
     * @param totalRecords 总记录数
     * @return Page 返回计算出hasPrePage、hasNextPage、totalPage和beginIndex的Page
     */
    public static Page createPage(Page page, int totalRecords) {
        return createPage(page.getEveryPage(), page.getCurrentPage(),
                totalRecords);
    }

    /**
     * This method create a Page Object to be used in web navigation.
     *
     * @param everyPage 每页记录数
     * @param currentPage 当前第几页
     * @param totalCount 总记录数
     * @return Page 返回计算出hasPrePage、hasNextPage、totalPage和beginIndex的Page
     */
    public static Page createPage(int everyPage, int currentPage, int totalCount) {
        Page createPage = null;
        everyPage = getEveryPage(everyPage);
        currentPage = getCurrentPage(currentPage);
        boolean hasPrePage = hasPrePage(currentPage);
        int totalPage = getTotalPage(everyPage, totalCount);
        boolean hasNextPage = hasNextPage(currentPage, totalPage);
        int beginIndex = getBeginIndex(currentPage, everyPage);
        createPage = new Page(hasPrePage, hasNextPage, everyPage, totalPage,
                currentPage, beginIndex, totalCount);
        System.out.println("hasPrePage:" + hasPrePage);
        System.out.println("hasNextPage:" + hasNextPage);
        return createPage;
    }

    /**
     * This method to get everyPage.
     *
     * @param everyPage 每页记录数
     * @return 每页记录数
     */
    private static int getEveryPage(int everyPage) {
        
        if(everyPage == 0) {
            return new Integer("10").intValue();
        }else{
            return everyPage;
        }
        
    }

    /**
     * This method to get currentPage.
     *
     * @param currentPage 当前页数
     * @return 当前页数
     */
    private static int getCurrentPage(int currentPage) {
        
        if(currentPage == 0) {
            return new Integer("1").intValue();
        }else{
            return currentPage;
        }
    }

    /**
     * This method to get beginIndex.
     *
     * @param currentPage 当前页数
     * @param everyPage 每页数
     * @return 当前页第一条记录位置
     */
    private static int getBeginIndex(int currentPage, int everyPage) {
        int beginIndex = 0;
        beginIndex = (currentPage - 1) * everyPage;
        return beginIndex;
    }

    /**
     * This method to get totalPage.
     *
     * @param totalCount 总记录数
     * @param everyPage 每页数
     * @return 总页数
     */
    private static int getTotalPage(int everyPage, int totalCount) {
        int totalPage = 1;
        if (totalCount % everyPage == 0) {
            totalPage = totalCount / everyPage;
        } else {
            totalPage = totalCount / everyPage + 1;
        }
        return totalPage;
    }

    /**
     * This method to judge if hasPrePage.
     *
     * @param currentPage 当前页数
     * @return 是否有前一页
     */
    private static boolean hasPrePage(int currentPage) {
        
        boolean hasPrePage = true;
        if(currentPage == 1) {
            hasPrePage = false;
        }
        return hasPrePage;
    }

    /**
     * This method to judge if hasNextPage.
     * @param totalPage 总页数
     * @param currentPage 当前页数
     * @return 是否有后一页
     */
    private static boolean hasNextPage(int currentPage, int totalPage) {
        
        boolean hasNextPage = true;
        if(currentPage == totalPage || totalPage == 1 || totalPage == 0) {
            hasNextPage = false;
        }
        return hasNextPage;
    }
}
