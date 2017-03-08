package com.dragon.service.impl;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BookInType;
import com.dragon.mapper.SearchMapper;
import com.dragon.service.SearchService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * 查找图书实现类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-27
 * Time : 下午7:42
 */
@Service
public class SearchServiceImpl implements SearchService{

    @Resource
    SearchMapper searchMapper;


    public List<BookInType> searchBook(String selectWay, String bookMessage) {
        //结果信息
        List<BookInType> resultBooks=null;

        //按书名查找
        if ("0".equals(selectWay)) {
            try {
                bookMessage = "%" + bookMessage + "%";
                resultBooks = searchMapper.searchBookByName(bookMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //按作者查找
        if ("1".equals(selectWay)) {
            try {
                bookMessage = "%" + bookMessage + "%";
                resultBooks = searchMapper.searchBookByAuthor(bookMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //按出版社查询
        if ("2".equals(selectWay)) {
            try {
                bookMessage = "%" + bookMessage + "%";
                resultBooks = searchMapper.searchBookByPublish(bookMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return resultBooks;
    }

    public BookInType searchBookById(long bookId) {

        BookInType resultBook = null;

        try {
            resultBook = searchMapper.searchBookById(bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultBook;
    }

    public List<BookInType> searchBookByType(long typeId) {
        List<BookInType> resultBooks = null;

        try {
            resultBooks = searchMapper.searchBookByType(typeId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultBooks;
    }


    public void setSearchMapper(SearchMapper searchMapper) {
        this.searchMapper = searchMapper;
    }
}
