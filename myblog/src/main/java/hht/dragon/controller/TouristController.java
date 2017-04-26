package hht.dragon.controller;


import hht.dragon.entity.Article;
import hht.dragon.entity.User;
import hht.dragon.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 游客控制器
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:09
 */
@Controller
public class TouristController {

    @Autowired
    private TouristService touristService;

    /**
     * 访问首页
     *
     * @return 首页页面
     */
    @RequestMapping("/index")
    public String index(Model model) {
        Page<Article> hotArticles = null;
        Page<Article> latstArticles = null;

        hotArticles = touristService.getHotArticle();
        latstArticles = touristService.getLatstArticle();

//        model.addAttribute("currentpage", "index");
        model.addAttribute("hotarticles", hotArticles);
        model.addAttribute("latstarticles", latstArticles);
        return "index";
    }


    /**
     * 浏览文章
     *
     * @param article_id 文章编号
     * @param model
     *
     * @return 文章展示页面
     */
    @RequestMapping("/single/{article_id}")
    public String single(@PathVariable("article_id") Integer article_id, Model model) {
        Article article = null;
        int commentCount = 0,supportcount = 0;
        article = touristService.getArticleById(article_id);
        if (article != null) {
            if (article.getComments() != null) {
                commentCount = article.getComments().size();
            }
            supportcount = article.getSupport_user().size();
        }
        System.out.println(article.getArticle_text());
        model.addAttribute("article", article);
        model.addAttribute("commentcount", commentCount);
        model.addAttribute("supportcount", supportcount);
        return "single";
    }

    /**
     * 访问博客列表页面
     *
     * @return
     */
    @RequestMapping("/articles/{page_num}")
    public String articles(Model model, @PathVariable("page_num") Integer page_num) {
        int pageNum = 0;
        Page<Article> articleList = null;
        articleList = touristService.getArticleList(page_num);
        pageNum = touristService.getArticlePageCount();
        if (pageNum == 0) {
            pageNum = 1;
        }
//        model.addAttribute("currentpage", "articles");
        model.addAttribute("nowpage", page_num);
        model.addAttribute("pagecount", pageNum);
        model.addAttribute("articlelist", articleList);

        return "articles_list";
    }

    /**
     * 跳转作者界面
     *
     * @param user_id 作者编号
     * @param model
     * @return 作者首页
     */
    @RequestMapping("/visituser/{user_id}/{nowpage}")
    public String visituser(@PathVariable("user_id") Integer user_id,@PathVariable("nowpage") Integer nowpage, Model model) {
        User user = null;
        Page<Article> articles = null;
        int pageNum = 0;
        user = touristService.getUserById(user_id);
        if (user == null) {
            return "";
        }
        pageNum = touristService.getUsetArticlePageCount(user_id);
        if (pageNum == 0) {
            pageNum = 1;
        }
        articles = touristService.getUserArticles(user_id, nowpage);
System.out.println(nowpage);
        model.addAttribute("userId", user_id);
        model.addAttribute("nowpage", nowpage);
        model.addAttribute("pagecount", pageNum);
        model.addAttribute("userarticles", articles);
        model.addAttribute("userName", user.getUserName());
        return "myindex";
    }

    /**
     * 搜索
     * @param searchText 搜索的关键字
     * @return 结果页面
     */
    @GetMapping("/search/{nowpage}")
    public String search(String searchText, @PathVariable("nowpage") Integer nowpage, Model model) {
        Page<Article> articles = null;
        Integer pageNum = 0;
        pageNum = touristService.getSearchArticleCount(searchText);
        articles = touristService.getSearchArticles(searchText, nowpage);
        if (pageNum == 0) {
            pageNum = 1;
        }
        model.addAttribute("articles", articles);
        model.addAttribute("pagecount", pageNum);
        model.addAttribute("nowpage", nowpage);
        model.addAttribute("searchText", searchText);
        return "search";
    }
}
