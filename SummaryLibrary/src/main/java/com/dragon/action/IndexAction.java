package com.dragon.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页相关页面跳转
 * <p>
 * User : Dragon_hht
 * Date : 17-2-24
 * Time : 上午10:03
 */
@Controller
public class IndexAction {

    /**
     * 跳转首页
     *
     * @return 首页
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 跳转登录页面
     *
     * @return 登录页面
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 跳转注册页面
     *
     * @return 注册页面
     */
    @RequestMapping("/regist")
    public String regist() {
        return "regist";
    }
}


