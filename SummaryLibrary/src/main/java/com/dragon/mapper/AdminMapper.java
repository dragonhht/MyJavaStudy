package com.dragon.mapper;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BorrowExtend;
import com.dragon.entity.ReaderExtend;

import java.util.List;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-22
 * Time : 下午8:22
 */
public interface AdminMapper {
    /**
     * 添加图书信息
     *
     * @param book 图书相关信息
     *
     *
     * @throws Exception
     */
    public void addBook(BookExtend book) throws Exception;

    /**
     * 删除图书信息
     *
     * @param bookId 图书编号
     *
     *
     * @throws Exception
     */
    public void delBook(long bookId) throws Exception;

    /**
     * 修改图书信息
     *
     * @param book 图书相关信息
     *
     *
     * @throws Exception
     */
    public void updateBook(BookExtend book) throws Exception;

    /**
     * 读者借阅图书
     *
     * @param borrow  借阅信息
     *
     * @throws Exception
     */
    public void borrowBook(BorrowExtend borrow) throws Exception;

    /**
     * 读者归还图书
     *
     * @param borrow  借阅信息
     *
     * @throws Exception
     */
    public void returnBook(BorrowExtend borrow) throws Exception;

    /**
     * 授权管理员
     *
     * @param readerId  读者编号
     *
     * @throws Exception
     */
    public void grantReader(long readerId) throws Exception;

    /**
     * 获取所有的管理员
     *
     * @return 管理员信息
     *
     * @throws Exception
     */
    public List<ReaderExtend> getAdmin() throws Exception;

    /**
     * 撤销管理员
     *
     * @param readerId 读者编号
     *
     * @throws Exception
     */
    public void delAdmin(long readerId) throws Exception;
}
