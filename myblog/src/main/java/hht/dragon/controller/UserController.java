package hht.dragon.controller;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import hht.dragon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
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

    /**
     * 点赞
     * @param article_id
     * @param response
     * @param session
     */
    @RequestMapping("/supportItem/{article_id}")
    public void supportItem(@PathVariable("article_id") Integer article_id, HttpServletResponse response, HttpSession session) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        Integer user_id = 0,supportcount;
        user_id = (Integer) session.getAttribute("userId");

        supportcount = service.supportArticle(user_id,article_id);

        try {
            out = response.getWriter();
            out.println(supportcount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 评论文章
     * @param article_id 文章编号
     * @param comment_text 评论内容
     * @param session
     * @return
     */
    @GetMapping("/contactarticle")
    public String contactArticle(Integer article_id, String comment_text, HttpSession session) {
        Integer user_id;
        user_id = (Integer) session.getAttribute("userId");
        service.contactArticle(user_id, article_id, comment_text);
        return "redirect:/single/"+article_id;
    }


    /**
     * 评论他人评论
     * @param article_id 文章编号
     * @param comment_id 被评论的评论编号
     * @param commentChile_text 评论内容
     * @param session
     * @return
     */
    @GetMapping("/contactcomment")
    public String contactComment(Integer article_id, Integer comment_id, String commentChile_text, HttpSession session) {
        Integer user_id;
        user_id = (Integer) session.getAttribute("userId");
        service.contactComment(user_id, comment_id, commentChile_text);
        return "redirect:/single/"+article_id;
    }

    /**
     * 跳转博客书写界面
     * @return
     */
    @RequestMapping("/writeblog")
    public String writeBlog(Model model, HttpSession session) {
		Page<Comment> comments = null;
		Integer user_id = (Integer) session.getAttribute("userId");
		comments = service.getNewComment(user_id);
		model.addAttribute("newcomments", comments);
    	return "write_blog";
    }

    /**
     * 保存文章
     * @param article 文章信息
     * @return 结果展示页面
     */
    @GetMapping("/saveblog")
    public String saveBlog(Article article, HttpSession session) {
        Article article1 = null;
        Integer user_id;
        user_id = (Integer) session.getAttribute("userId");
        article1 = service.saveArticle(article, user_id);
        if (article != null) {
            Integer article_id = 0;
            article_id = article1.getArticle_id();
            return "redirect:/single/"+article_id;
        }
        return null;
    }

    /**
     * 跳转至用户信息修改页面
     * @return 用户信息修改页面
     */
    @RequestMapping("/toupdatemsg")
    public String toUpdateMsg(Model model,boolean flage, HttpSession session) {
    	User user = null;
    	String stutas = "普通用户";
		Page<Comment> comments = null;
    	Integer user_id = (Integer) session.getAttribute("userId");
    	user = service.getUserById(user_id);
    	if (user.getStatus() == 1) {
			stutas = "管理员";
		}
		comments = service.getNewComment(user_id);
    	model.addAttribute("usermsg", user);
    	model.addAttribute("status", stutas);
    	model.addAttribute("flage", flage);
    	model.addAttribute("newcomments", comments);
        return "update_message";
    }

	/**
	 * 修改用户信息
	 * @param user 用户信息
	 * @return 显示页面
	 */
	@PostMapping("/updatemsg")
	public String updatemsg(User user) {
		User userTest = null;
		boolean ok = false;
		userTest = service.updateUser(user);
		if (userTest != null) {
			ok = true;
		}
		return "redirect:/user/toupdatemsg?flage="+ok;
 	}

 	@RequestMapping("/upload")
	public String uploadImg(MultipartFile file, HttpSession session) {
		if (file.isEmpty()) {
			return "文件为空";
		}
		//获取文件名
//		String filename = file.getOriginalFilename();
//System.out.println("文件名:::"+ filename);
		//文件保存路径
		String filePath = "/home/huang/image/Myblog/";
		//文件访问路径,使用另一个tomcat
		String getImg = "http://localhost:8080/pic/";
		Integer user_id = (Integer) session.getAttribute("userId");
		getImg = getImg + user_id;
		filePath = filePath + user_id;
		File newFile = new File(filePath);
		if (!newFile.getParentFile().exists()) {
			newFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(newFile);
			service.saveImg(getImg, user_id);
			return "redirect:/user/toupdatemsg";
		}catch (Exception e) {
			return "上传失败";
		}
	}

}
