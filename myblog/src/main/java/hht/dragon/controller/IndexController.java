package hht.dragon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-4-12
 * Time : 下午8:47
 */
@Controller
public class IndexController {

    /**
     * 访问首页
     *
     * @return 首页页面
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 访问登录界面
     *
     * @return 登录界面
     */
    @RequestMapping("/tologin")
    public String toLogin() {
        return "login";
    }

    /**
     * 跳转注册页面
     *
     * @return 注册页面
     */
    @RequestMapping("/toregister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "index_2";
    }

    @RequestMapping("/home2")
    public String home2() {
        return "home_categories_description";
    }

    @RequestMapping("/home3")
    public String home3() {
        return "home_categories_articles";
    }

    @RequestMapping("/articles")
    public String articles() {
        return "articles_list";
    }

    @RequestMapping("/faq")
    public String faq() {
        return "faq";
    }

    @RequestMapping("/blueSkin")
    public String blueSkin() {
        return "blue_skin";
    }

    @RequestMapping("/greenSkin")
    public String greenSkin() {
        return "green_skin";
    }

    @RequestMapping("/redSkin")
    public String redSkin() {
        return "red_skin";
    }

    @RequestMapping("/fullWidth")
    public String fullWidth() {
        return "full_width";
    }

    @RequestMapping("/elements")
    public String elements() {
        return "elements";
    }

    @RequestMapping("/page")
    public String page() {
        return "page";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/single")
    public String single() {
        return "single";
    }

    @RequestMapping("/maintop")
    public String maintop() {
        return "main_top";
    }
}
