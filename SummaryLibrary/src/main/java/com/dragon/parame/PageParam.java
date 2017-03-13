package com.dragon.parame;

/**
 * 分页相关的参数
 * <p>
 * User : Dragon_hht
 * Date : 17-3-12
 * Time : 下午4:52
 */
public class PageParam {

    /** 每页的最大数量 */
    private int pageSize = 10;

    /** 页数计数器 */
    private int pageCount = 1;

    /** 查询的信息 */
    private String bookMessage;

    /** 查询方式 */
    private String selectWay;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getBookMessage() {
        return bookMessage;
    }

    public void setBookMessage(String bookMessage) {
        this.bookMessage = bookMessage;
    }

    public String getSelectWay() {
        return selectWay;
    }

    public void setSelectWay(String selectWay) {
        this.selectWay = selectWay;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", bookMessage='" + bookMessage + '\'' +
                ", selectWay='" + selectWay + '\'' +
                '}';
    }
}

