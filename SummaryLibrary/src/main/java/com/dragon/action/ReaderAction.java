package com.dragon.action;

import java.util.List;

import javax.annotation.Resource;

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
        boolean ok = false;

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
        ok = readerService.readerRegist(reader);
        ok = true;

        if (ok) {

            // 注册成功跳转成功提示界面
            return "msg";
        } else {

            // 注册失败不跳转页面,但提示相关信息
            model.addAttribute("error", "注册失败,请等会重试");

            return "regist";
        }
    }


    public void setReaderService(ReaderService readerService) {
        this.readerService = readerService;
    }
}

