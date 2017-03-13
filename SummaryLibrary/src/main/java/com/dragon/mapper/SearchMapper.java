package com.dragon.mapper;

import java.util.List;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BookInType;
import com.dragon.parame.PageParam;

/**
 * 图书查询Mapper接口
 * <p>
 * User : Dragon_hht
 * Date : 17-2-24
 * Time : 上午10:45
 */
public interface SearchMapper {

    /**
     * 通过作者查询图书
     *
     *
     * @param pageParam
     * @return 图书信息
     *
     * @throws Exception
     */
    List<BookInType> searchBookByAuthor(PageParam pageParam) throws Exception;

    /**
     * 通过图书编号查询图书
     *
     * @param bookId 图书编号
     *
     * @return
     *
     * @throws Exception
     */
    BookInType searchBookById(long bookId) throws Exception;

    /**
     * 通过图书名查询图书
     *
     *
     * @param pageParam
     * @return 图书信息
     *
     * @throws Exception
     */
    List<BookInType> searchBookByName(PageParam pageParam) throws Exception;

    /**
     * 通过出版社查询图书
     *
     *
     * @param pageParam
     * @return 图书信息
     *
     * @throws Exception
     */
    List<BookInType> searchBookByPublish(PageParam pageParam) throws Exception;

    /**
     * 通过图书类型查询图书
     *
     * @param typeId 图书类型编号
     *
     * @return 查询结果
     *
     * @throws Exception
     */
    List<BookInType> searchBookByType(long typeId) throws Exception;

    /**
     * 获取通过作者查找到的总数量
     *
     * @param bookMessage 作者信息
     *
     * @return 通过作者查找到的总数量
     *
     * @throws Exception
     */
    int getResultSumByAuthor(String bookMessage) throws Exception;

    /**
     * 获取通过图书名查找到的总数量
     *
     * @param bookMessage 图书名
     *
     * @return 通过图书名查找到的总数量
     *
     * @throws Exception
     */
    int getResultSumByName(String bookMessage) throws Exception;

    /**
     * 获取通过出版社查找到的总数量
     *
     * @param bookMessage 出版社信息
     *
     * @return 通过出版社查找到的总数量
     *
     * @throws Exception
     */
    int getResultSumByPublish(String bookMessage) throws Exception;
}

