package com.dragon.entity;

/**
 * 借阅信息扩展类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-24
 * Time : 上午11:16
 */
public class BorrowExtend extends Borrow {

    /** 图书名 */
    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}

