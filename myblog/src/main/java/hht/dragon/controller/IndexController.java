package hht.dragon.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 导航控制器.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-12
 * Time : 下午8:47
 */
@Controller
public class IndexController {




    /**
     * 访问登录界面.
     *
     * @return 登录界面
     */
    @RequestMapping("/tologin")
    public String toLogin() {
        return "login";
    }

    /**
     * 跳转注册页面.
     *
     * @return 注册页面
     */
    @RequestMapping("/toregister")
    public String toRegister() {
        return "register";
    }
}
