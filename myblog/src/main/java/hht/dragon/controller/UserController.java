package hht.dragon.controller;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import hht.dragon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户操作.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:42
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/** 用户Service类. */
    @Autowired
    private UserService service;

	/**
	 * 用户注销.
	 * @param session session
	 * @return 首页
	 */
	@RequestMapping("/loginout")
	public String loginout(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
	}

    /**
     * 点赞.
     * @param articleId 文章编号
     * @param response response
     * @param session session
     */
    @RequestMapping("/supportItem/{articleId}")
    public void supportItem(@PathVariable("articleId") Integer articleId, HttpServletResponse response, HttpSession session) {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = null;
        Integer userId = 0, supportcount;
        userId = (Integer) session.getAttribute("userId");

        supportcount = service.supportArticle(userId, articleId);

        try {
            out = response.getWriter();
            out.println(supportcount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 评论文章.
     * @param articleId 文章编号
     * @param commentText 评论内容
     * @param session session
     * @return 文章展示页面
     */
    @GetMapping("/contactarticle")
    public String contactArticle(Integer articleId, String commentText, HttpSession session) {
        Integer userId;
        userId = (Integer) session.getAttribute("userId");
        service.contactArticle(userId, articleId, commentText);
        return "redirect:/single/" + articleId;
    }


    /**
     * 评论他人评论.
     * @param articleId 文章编号
     * @param comment_id 被评论的评论编号
     * @param commentChile_text 评论内容
     * @param session session
     * @return 文章展示页面
     */
    @GetMapping("/contactcomment")
    public String contactComment(Integer articleId, Integer comment_id, String commentChile_text, HttpSession session) {
        Integer userId;
        userId = (Integer) session.getAttribute("userId");
        service.contactComment(userId, comment_id, commentChile_text);
        return "redirect:/single/" + articleId;
    }

    /**
     * 跳转博客书写界面.
	 * @param model 用于返回数据
	 * @param session session
     * @return 在线写文章页面
     */
    @RequestMapping("/writeblog")
    public String writeBlog(Model model, HttpSession session) {
		Page<Comment> comments = null;
		Integer userId = (Integer) session.getAttribute("userId");
		comments = service.getNewComment(userId);
		model.addAttribute("newcomments", comments);
    	return "write_blog";
    }

    /**
     * 保存文章.
     * @param article 文章信息
	 * @param session session
     * @return 结果展示页面
     */
    @PostMapping("/saveblog")
    public String saveBlog(Article article, HttpSession session) {
        Article article1 = null;
        Integer userId;
        userId = (Integer) session.getAttribute("userId");
        article1 = service.saveArticle(article, userId);
        if (article != null) {
            Integer articleId = 0;
            articleId = article1.getArticleId();
            return "redirect:/single/" + articleId;
        }
        return null;
    }

    /**
     * 跳转至用户信息修改页面.
	 * @param model 用于返回数据
	 * @param flage 是否修改完成
	 * @param session session
     * @return 用户信息修改页面
     */
    @RequestMapping("/toupdatemsg")
    public String toUpdateMsg(Model model, boolean flage, HttpSession session) {
    	User user = null;
    	String stutas = "普通用户";
		Page<Comment> comments = null;
    	Integer userId = (Integer) session.getAttribute("userId");
    	user = service.getUserById(userId);
    	if (user.getStatus() == 1) {
			stutas = "管理员";
		}
		comments = service.getNewComment(userId);
    	model.addAttribute("usermsg", user);
    	model.addAttribute("status", stutas);
    	model.addAttribute("flage", flage);
    	model.addAttribute("newcomments", comments);
        return "update_message";
    }

	/**
	 * 修改用户信息.
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
		return "redirect:/user/toupdatemsg?flage=" + ok;
 	}

	/**
	 * 上传用户头像.
	 * @param file 头像文件
	 * @param session session
	 * @return 上传结果
	 */
 	@RequestMapping("/upload")
	public String uploadImg(MultipartFile file, HttpSession session) {
		if (file.isEmpty()) {
			return "文件为空";
		}
		//获取文件名
		//String filename = file.getOriginalFilename();
//System.out.println("文件名:::"+ filename);
		//文件保存路径
		String filePath = "/home/huang/image/Myblog/";
		//文件访问路径,使用另一个tomcat
		String getImg = "http://localhost:8080/pic/";
		Integer userId = (Integer) session.getAttribute("userId");
		getImg = getImg + userId;
		filePath = filePath + userId;
		File newFile = new File(filePath);
		if (!newFile.getParentFile().exists()) {
			newFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(newFile);
			service.saveImg(getImg, userId);
			return "redirect:/user/toupdatemsg";
		} catch (Exception e) {
			return "上传失败";
		}
	}

}
