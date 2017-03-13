package com.dragon.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.entity.ReaderExtend;
import com.dragon.service.ReaderService;

/**
 * 读者操作类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-25
 * Time : 上午8:36
 */
@Controller
@RequestMapping(value = "/reader")
public class ReaderAction {

    /** 读者Service类 */
    @Resource
    private ReaderService readerService;

    /**
     * 读者登录
     *
     * @param model
     * @param reader
     * @param bindingResult
     *
     * @return 结果页面
     */
    @RequestMapping("/login")
    public String login(Model model, @Validated ReaderExtend reader, BindingResult bindingResult, HttpSession session) {

        ReaderExtend readerExtend = null;

        //数据校验
        if (bindingResult.hasErrors()) {
            model.addAttribute("loginError", "您有信息未填写");
            return "login";
        }

        readerExtend = readerService.readerLogin(reader);
        if (readerExtend !=null) {
            session.setAttribute("readerName", readerExtend.getReaderName());
            session.setAttribute("readerId", readerExtend.getReaderId());
            return "index";
        } else {
            model.addAttribute("loginError", "账号或密码错误");
            return "login";
        }


    }

    /**
     * 读者注册
     *
     * @param model
     * @param reader 读者信息
     * @param bindingResult
     *
     * @return 结果页面
     */
    @RequestMapping("/regist")
    public String regist(Model model, @Validated ReaderExtend reader, BindingResult bindingResult) {
        //注册成功后的ID
        long successId = 0l;

        // 获取校验错误信息
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for (ObjectError error : allErrors) {
                model.addAttribute("error", error.getDefaultMessage());
            }

            return "regist";
        }

        // 验证密码是否一致
        if (!reader.getRepassword().trim().equals(reader.getPassword().trim())) {
            model.addAttribute("pwdError", "两次密码不一致");

            return "regist";
        }

        // 保存数据
        successId = readerService.readerRegist(reader);

        if (successId != 0l) {

            // 注册成功跳转成功提示界面
            model.addAttribute("registSuccess", successId);
            return "msg";
        } else {

            // 注册失败不跳转页面,但提示相关信息
            model.addAttribute("error", "注册失败,请等会重试");

            return "regist";
        }
    }

    /**
     * 跳转个人中心主页
     *
     * @return 个人中心主页
     */
    @RequestMapping("reader")
    public String reader(long readerId, Model model) {
        ReaderExtend reader = null;
        reader = readerService.getReaderById(readerId);
        model.addAttribute("readerMessage", reader);

        return "Reader";
    }

    @RequestMapping("/login_out")
    public String login_out(HttpSession session) {

        session.invalidate();

        return "index";
    }

    public void setReaderService(ReaderService readerService) {
        this.readerService = readerService;
    }
}

