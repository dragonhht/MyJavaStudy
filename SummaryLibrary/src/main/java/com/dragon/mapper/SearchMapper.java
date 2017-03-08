package com.dragon.mapper;

import java.util.List;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BookInType;

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
     * @param bookMessage
     * @return 图书信息
     *
     * @throws Exception
     */
    List<BookInType> searchBookByAuthor(String bookMessage) throws Exception;

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
     * @param bookMessage
     * @return 图书信息
     *
     * @throws Exception
     */
    List<BookInType> searchBookByName(String bookMessage) throws Exception;

    /**
     * 通过出版社查询图书
     *
     *
     * @param bookMessage
     * @return 图书信息
     *
     * @throws Exception
     */
    List<BookInType> searchBookByPublish(String bookMessage) throws Exception;

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
}

