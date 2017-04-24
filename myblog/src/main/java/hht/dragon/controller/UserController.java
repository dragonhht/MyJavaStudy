package hht.dragon.controller;

import hht.dragon.entity.User;
import hht.dragon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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

    @RequestMapping("/supportItem/{article_id}")
    public void supportItem(@PathVariable("article_id") Integer article_id, HttpServletResponse response, HttpSession session) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;

    }

}
