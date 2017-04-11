package com.dragon.action;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BorrowExtend;
import com.dragon.entity.ReaderExtend;
import com.dragon.service.AdminService;
import com.dragon.utils.getDate;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

    /**
     * 跳转管理员管理界面
     *
     * @return 结果页面
     */
    @RequestMapping("/grant")
    public String grant(Model model) {
        List<ReaderExtend> admins = null;

        admins = adminService.getAdmin();

        model.addAttribute("admins", admins);
        return "adminGrant";
    }

    /**
     * 跳转管理员管理界面
     *
     * @param readerId 读者编号
     * @param response
     *
     * @return 结果页面
     */
    @RequestMapping("/grantReader")
    public void grantReader(long readerId, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        boolean ok = false;

        ok = adminService.grantReader(readerId);

        try {
            out = response.getWriter();

            if (ok) {
                out.println("授权成功");
            }else {
                out.println("授权失败");
            }

        } catch (IOException e) {
            out.println("授权失败");
            e.printStackTrace();
        }
    }

    /**
     * 跳转管理员管理界面
     *
     * @param readerId 读者编号
     *
     * @return 结果页面
     */
    @RequestMapping("/delAdmin")
    public String delAdmin(long readerId) {
        boolean ok =false;

        ok = adminService.delAdmin(readerId);

        if (ok) {
            return "redirect:/admin/grant.action";
        }else {
            return "";
        }

    }

    /**
     * 跳转新增图书界面
     *
     * @return 结果页面
     */
    @RequestMapping("/addBook")
    public String addBook() {
        return "addBook";
    }


    /**
     * 添加图书
     *
     * @param book 图书信息
     *
     * @return 结果页面
     */
    @RequestMapping("/addBookMessage")
    public void addBookMessage(BookExtend book, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        boolean ok = false;

        ok = adminService.addBook(book);

        try {
            out = response.getWriter();

            if (ok) {
                out.println("添加成功");
            } else {
                out.println("添加失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转删除图书界面
     *
     * @return 结果页面
     */
    @RequestMapping("/delBookPage")
    public String delBookPage() {
        return "delBook";
    }

    /**
     * 删除图书
     *
     * @param bookId 图书编号
     *
     */
    @RequestMapping("/delBook")
    public void delBook(long bookId, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        boolean ok =false;

        ok = adminService.delBook(bookId);

        try {
            out = response.getWriter();
            if (ok) {
                out.println("编号为: "+ bookId  +" 的图书已成功删除");
            } else {
                out.println("删除失败");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
