package com.dragon.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BookInType;
import com.dragon.service.SearchService;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-2-24
 * Time : 上午10:43
 */
@Controller
@RequestMapping("/search")
public class searchAction {

    /** 查询服务 */
    @Resource
    SearchService searchService;

    /**
     * 图书收藏界面跳转
     *
     * @param bookId 图书编号
     * @param model
     *
     * @return
     */
    @RequestMapping("/collection")
    public String collection(long bookId, Model model) {
        BookInType resultBook = null;
        //图书借阅
        String lend = "可借";

        resultBook = searchService.searchBookById(bookId);

        if (resultBook != null) {
            if (resultBook.getBookLend() == 1) {
                resultBook.setLend(lend);
            }
        }

        model.addAttribute("collectionResult", resultBook);

        return "Collection";
    }

    /**
     * 多方式查找
     *
     * @param selectWay 查询方式
     * @param bookMessage 查询的信息
     * @param model
     *
     * @return
     */
    @RequestMapping("/searchBook")
    public String searchBook(String selectWay, String bookMessage, Model model) {
        List<BookInType> resultBooks = null;

        resultBooks = searchService.searchBook(selectWay, bookMessage);

        // 简述处理
        for (BookInType book : resultBooks) {
            String sketch = book.getBookSketch();
            int    len    = 0;

            if (sketch != null) {
                len = sketch.length();
            }

            if (len >= 280) {
                sketch = sketch.substring(0, 280) + "...";
                book.setBookSketch(sketch);
            }
        }

        model.addAttribute("resultBooks", resultBooks);

        return "result";
    }

    /**
     * 通过类型查找图书
     *
     * @param typeId 图书类型编号
     * @param model
     *
     * @return 结果页面
     */
    @RequestMapping("/searchByType")
    public String searchByType(long typeId, Model model) {
        List<BookInType> resultBooks = null;
        resultBooks = searchService.searchBookByType(typeId);
        model.addAttribute("resultBooks", resultBooks);

        return "result";
    }
}

