package com.dragon.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.entity.BookExtend;
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
     * 多方式查找
     *
     * @param selectWay 查询方式
     * @param bookMessage 查询的信息
     *
     * @return
     */
    @RequestMapping("/searchBook")
    public String searchBook(String selectWay, String bookMessage, Model model) {
        List<BookExtend> resultBooks = null;

        resultBooks = searchService.searchBook(selectWay, bookMessage);

        model.addAttribute("resultBooks", resultBooks);


        return "result";
    }
}

