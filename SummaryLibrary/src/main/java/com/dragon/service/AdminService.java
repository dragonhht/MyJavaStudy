package com.dragon.service;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BorrowExtend;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-22
 * Time : 下午8:51
 */
public interface AdminService {

    /**
     * 添加图书信息
     *
     * @param book  图书信息
     *
     * @throws Exception
     */
    public boolean addBook(BookExtend book);

    /**
     * 删除图书信息
     *
     * @param bookId  图书编号
     *
     * @throws Exception
     */
    public boolean delBook(long bookId);

    /**
     * 修改图书信息
     *
     * @param book  图书信息
     *
     * @throws Exception
     */
    public boolean updateBook(BookExtend book);

    /**
     * 读者借阅图书
     *
     * @param borrow  借阅信息
     *
     * @throws Exception
     */
    public boolean borrowBook(BorrowExtend borrow);

    /**
     * 读者归还图书
     *
     * @param borrow  借阅信息
     *
     * @throws Exception
     */
    public boolean returnBook(BorrowExtend borrow);
}
