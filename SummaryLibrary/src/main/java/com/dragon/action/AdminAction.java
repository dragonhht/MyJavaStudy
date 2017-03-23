package com.dragon.action;

import com.dragon.entity.BorrowExtend;
import com.dragon.service.AdminService;
import com.dragon.utils.getDate;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-22
 * Time : 下午7:56
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Resource
    private AdminService adminService;

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 跳转管理员功能界面
     *
     * @return 结果页面
     */
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    /**
     * 图书借阅
     *
     */
    @RequestMapping("/borrow")
    public void borrow(BorrowExtend borrow, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        boolean ok = false;

        //借阅日期
        String borrowDate = getDate.getDateDay();
        borrow.setBorrowDate(borrowDate);
        //应还日期
        String returnDay = getDate.addDateDay(30);
        borrow.setReturnDate(returnDay);

System.out.println(borrow);

        ok = adminService.borrowBook(borrow);

        try {
            out = response.getWriter();

            if (ok) {
                out.println("借阅成功");
            }else {
                out.println("借阅失败");
            }
        } catch (IOException e) {
            out.println("借阅失败");
            e.printStackTrace();
        }
    }

    /**
     * 跳转图书归还界面
     *
     * @return 结果页面
     */
    @RequestMapping("/returnbook")
    public String returnbook() {
        return "adminReturnBook";
    }


    @RequestMapping("/readerReturnBook")
    public void readerReturnBook(BorrowExtend borrow, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        boolean ok = false;

System.out.println(borrow);

        ok = adminService.returnBook(borrow);

        try {
            out = response.getWriter();

            if (ok) {
                out.println("归还成功");
            }else {
                out.println("归还失败");
            }

        } catch (IOException e) {
            out.println("归还失败");
            e.printStackTrace();
        }

    }

}
