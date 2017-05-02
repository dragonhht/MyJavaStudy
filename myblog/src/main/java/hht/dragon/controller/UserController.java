package hht.dragon.controller;

import hht.dragon.entity.Article;
import hht.dragon.entity.User;
import hht.dragon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 用户操作
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:42
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    /**
     * 用户登录
     * @param user 用户信息
     * @return 登录结果页面
     */
    @PostMapping("/login")
    public String login(User user, HttpSession session) {
        User user1 = null;
        String returnString = "redirect:/tologin";
        user1 = service.login(user);
        if (user1 != null) {
            Integer id = user.getUser_id();
            String name = user1.getUserName();
            session.setAttribute("userId", id);
            session.setAttribute("userName", name);
            returnString = "redirect:/visituser/"+ id +"/0";
        }

        return returnString;
    }

    /**
     * 用户注销
     * @param session
     * @return
     */
    @RequestMapping("/loginout")
    public String loginout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

    /**
     * 点赞
     * @param article_id
     * @param response
     * @param session
     */
    @RequestMapping("/supportItem/{article_id}")
    public void supportItem(@PathVariable("article_id") Integer article_id, HttpServletResponse response, HttpSession session) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        Integer user_id = 0,supportcount;
        user_id = (Integer) session.getAttribute("userId");

        supportcount = service.supportArticle(user_id,article_id);

        try {
            out = response.getWriter();
            out.println(supportcount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 评论文章
     * @param article_id 文章编号
     * @param comment_text 评论内容
     * @param session
     * @return
     */
    @GetMapping("/contactarticle")
    public String contactArticle(Integer article_id, String comment_text, HttpSession session) {
        Integer user_id;
        user_id = (Integer) session.getAttribute("userId");
        service.contactArticle(user_id, article_id, comment_text);
        return "redirect:/single/"+article_id;
    }


    /**
     * 评论他人评论
     * @param article_id 文章编号
     * @param comment_id 被评论的评论编号
     * @param commentChile_text 评论内容
     * @param session
     * @return
     */
    @GetMapping("/contactcomment")
    public String contactComment(Integer article_id, Integer comment_id, String commentChile_text, HttpSession session) {
        Integer user_id;
        user_id = (Integer) session.getAttribute("userId");
        service.contactComment(user_id, comment_id, commentChile_text);
        return "redirect:/single/"+article_id;
    }

    /**
     * 跳转博客书写界面
     * @return
     */
    @RequestMapping("/writeblog")
    public String writeBlog() {
        return "write_blog";
    }

    /**
     * 保存文章
     * @param article 文章信息
     * @return 结果展示页面
     */
    @GetMapping("/saveblog")
    public String saveBlog(Article article, HttpSession session) {
        Article article1 = null;
        Integer user_id;
        user_id = (Integer) session.getAttribute("userId");
        article1 = service.saveArticle(article, user_id);
        if (article != null) {
            Integer article_id = 0;
            article_id = article1.getArticle_id();
            return "redirect:/single/"+article_id;
        }
        return null;
    }

}
