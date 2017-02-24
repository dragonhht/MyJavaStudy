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

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}

