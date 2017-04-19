package hht.dragon.controller;


import hht.dragon.entity.Article;
import hht.dragon.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        int commentCount = 0;
        article = touristService.getArticleById(article_id);
        if (article != null) {
            if (article.getComments() != null) {
                commentCount = article.getComments().size();
            }
        }
        model.addAttribute("article", article);
        model.addAttribute("commentcount", commentCount);
        return "single";
    }

}
