package com.dragon.mapper;

import java.util.List;

import com.dragon.entity.BookExtend;

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
     * @return 图书信息
     *
     * @throws Exception
     */
    List<BookExtend> searchBookByAuthor(String bookMessage) throws Exception;

    /**
     * 通过图书名查询图书
     *
     * @return 图书信息
     *
     * @throws Exception
     */
    List<BookExtend> searchBookByName(String bookMessage) throws Exception;

    /**
     * 通过出版社查询图书
     *
     * @return 图书信息
     *
     * @throws Exception
     */
    List<BookExtend> searchBookByPublish(String bookMessage) throws Exception;
}


