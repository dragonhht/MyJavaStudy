package com.dragon.entity;

/**
 * 图书类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-24
 * Time : 上午11:01
 */
public class Book {

    /** 图书编号 */
    private long bookId;

    /** 图书名 */
    private String bookName;

    /** 价格 */
    private int price;

    /** 作者 */
    private String author;

    /** 购买时间 */
    private String buyDate;

    /** 出版社 */
    private String publish;

    /** 借阅状态 */
    private int bookLend;

    /** 图书类型 */
    private String type;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public int getBookLend() {
        return bookLend;
    }

    public void setBookLend(int bookLend) {
        this.bookLend = bookLend;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


