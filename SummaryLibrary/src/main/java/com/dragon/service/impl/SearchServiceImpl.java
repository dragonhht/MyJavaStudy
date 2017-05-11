package com.dragon.service.impl;

import com.dragon.entity.BookInType;
import com.dragon.mapper.SearchMapper;
import com.dragon.parame.PageParam;
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


    public List<BookInType> searchBook(PageParam pageParam) {
        //结果信息
        List<BookInType> resultBooks=null;
        //查找方式
        String selectWay = pageParam.getSelectWay();
        //查找信息
        String bookMessage = pageParam.getBookMessage();
        //查询到的数量
        int count;

System.out.println("处理前PageParame参数:"+pageParam);
        //按书名查找
        if ("0".equals(selectWay)) {
            try {
                bookMessage = "%" + bookMessage + "%";
                pageParam.setBookMessage(bookMessage);
                int pageCount = (pageParam.getPageCount() - 1)  * pageParam.getPageSize();
                pageParam.setPageCount(pageCount);



                resultBooks = searchMapper.searchBookByName(pageParam);
                count = searchMapper.getResultSumByName(bookMessage);
                if (count % 10 != 0) {
                    count = count + pageParam.getPageSize();
                }

                count = count / pageParam.getPageSize();

                if (resultBooks !=null && resultBooks.size()>0) {
                    resultBooks.get(0).setCount(count);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //按作者查找
        if ("1".equals(selectWay)) {
            try {
                bookMessage = "%" + bookMessage + "%";
                pageParam.setBookMessage(bookMessage);
                int pageCount = (pageParam.getPageCount() - 1) * pageParam.getPageSize();
                pageParam.setPageCount(pageCount);
System.out.println("处理后PageParame参数:"+pageParam);
                resultBooks = searchMapper.searchBookByAuthor(pageParam);
                count = searchMapper.getResultSumByAuthor(bookMessage);

                if (count % 10 != 0) {
                    count = count + pageParam.getPageSize();
                }

                count = count / pageParam.getPageSize();

                if (resultBooks !=null && resultBooks.size()>0) {
                    resultBooks.get(0).setCount(count);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //按出版社查询
        if ("2".equals(selectWay)) {
            try {
                bookMessage = "%" + bookMessage + "%";
                pageParam.setBookMessage(bookMessage);
                int pageCount = (pageParam.getPageCount() - 1) * pageParam.getPageSize();
                pageParam.setPageCount(pageCount);

                resultBooks = searchMapper.searchBookByPublish(pageParam);
                count = searchMapper.getResultSumByPublish(bookMessage);

                if (count % 10 != 0) {
                    count = count + pageParam.getPageSize();
                }

                count = count / pageParam.getPageSize();

                if (resultBooks !=null && resultBooks.size()>0) {
                    resultBooks.get(0).setCount(count);
                }

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
