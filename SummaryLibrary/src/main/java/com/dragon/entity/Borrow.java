package com.dragon.entity;

/**
 * 图书借阅信息类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-24
 * Time : 上午11:10
 */
public class Borrow {

    /** 读者编号 */
    private long readerId;

    /** 图书编号 */
    private long bookId;

    /** 借阅时间 */
    private String borrowDate;

    /** 应还时间 */
    private String returnDate;

    public long getReadId() {
        return readerId;
    }

    public void setReadId(long readId) {
        this.readerId = readId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "readerId=" + readerId +
                ", bookId=" + bookId +
                ", borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}


