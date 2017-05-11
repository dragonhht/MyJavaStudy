package com.dragon.service;

import java.util.List;
import com.dragon.entity.BookInType;
import com.dragon.parame.PageParam;

/**
 * 图书查找类接口
 * <p>
 * User : Dragon_hht
 * Date : 17-2-27
 * Time : 下午7:38
 */
public interface SearchService {

    /**
     * 多种方式查找图书
     *
     * @param pageParam
     *
     * @return 图书信息
     */
    List<BookInType> searchBook(PageParam pageParam);

    /**
     * 通过图书编号查询图书
     *
     * @param bookId 图书编号
     *
     * @return
     */
    BookInType searchBookById(long bookId);

    /**
     * 通过图书类型查询图书
     *
     * @param typeId 图书类型编号
     *
     * @return 查询结果
     */
    List<BookInType> searchBookByType(long typeId);
}

