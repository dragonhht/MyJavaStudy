package hht.dragon.controller;

import hht.dragon.entity.User;
import hht.dragon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户操作
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:42
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @param bindingResult
     * @param repassword
     * @return 相关结果页面
     */
    @PostMapping("/regist")
    public ModelAndView regist(@Valid User user, BindingResult bindingResult, String repassword) {
System.out.println(user);

        ModelAndView mav =new ModelAndView();
        mav.setViewName("register");

        if (bindingResult.hasErrors()) {
            List<ObjectError> errorss = bindingResult.getAllErrors();
            mav.addObject("registErrors", errorss);

            return mav;
        }

        if (!repassword.equals(user.getPassword())) {
            return mav;
        }

        boolean ok = false;
        Integer userId = service.regist(user);

        if (userId != 0) {
            ok = true;
        }

        if (ok) {
            mav.setViewName("msg");
            mav.addObject("userId", userId);
        }

        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(User user) {
        boolean ok = false;
        User user1 = null;
        ModelAndView mav = new ModelAndView("login");
        user1 = service.login(user);
        if (user1 != null) {
            ok = true;
        }
        if (ok) {
            mav.setViewName("index");
            mav.addObject("login", "true");
            mav.addObject("userName", user1.getUserName());
        }

        return mav;
    }

}
