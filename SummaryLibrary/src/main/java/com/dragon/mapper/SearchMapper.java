package com.dragon.mapper;

import com.dragon.entity.BookExtend;

import java.util.List;

/**
 * 图书查询Mapper接口
 * <p>
 * User : Dragon_hht
 * Date : 17-2-24
 * Time : 上午10:45
 */
public interface SearchMapper {

    List<BookExtend> searchBookByName()throws Exception;

}
