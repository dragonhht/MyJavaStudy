package com.dragon.service;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BorrowExtend;
import com.dragon.entity.ReaderExtend;

import java.util.List;

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
     */
    public boolean addBook(BookExtend book);

    /**
     * 删除图书信息
     *
     * @param bookId  图书编号
     *
     */
    public boolean delBook(long bookId);

    /**
     * 修改图书信息
     *
     * @param book  图书信息
     *
     */
    public boolean updateBook(BookExtend book);

    /**
     * 读者借阅图书
     *
     * @param borrow  借阅信息
     *
     */
    public boolean borrowBook(BorrowExtend borrow);

    /**
     * 读者归还图书
     *
     * @param borrow  借阅信息
     *
     */
    public boolean returnBook(BorrowExtend borrow);

    /**
     * 授权管理员
     *
     * @param readerId  读者编号
     *
     */
    public boolean grantReader(long readerId);

    /**
     * 获取所有的管理员信息
     *
     * @return 管理员列表
     */
    public List<ReaderExtend> getAdmin();

    /**
     * 撤销管理员
     *
     * @return 结果
     */
    public boolean delAdmin(long readerId);
}
