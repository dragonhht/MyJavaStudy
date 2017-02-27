package com.dragon.service;

import java.util.List;

import com.dragon.entity.BookExtend;

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
     * @param selectWay
     * @param bookMessage
     *
     * @return 图书信息
     */
    List<BookExtend> searchBook(String selectWay, String bookMessage);
}

