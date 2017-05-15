package hht.dragon.controller;


import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import hht.dragon.service.TouristService;
import hht.dragon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * 游客控制器.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:09
 */
@Controller
public class TouristController {
    /** 游客Service类. */
    @Autowired
    private TouristService touristService;
    /** 用户Service类. */
    @Autowired
    private UserService userService;

    /**
     * 访问首页.
     * @param model 用于返回数据
     * @return 首页页面
     */
    @RequestMapping("/index")
    public String index(Model model) {
        Page<Article> hotArticles = null;
        Page<Article> latstArticles = null;

        hotArticles = touristService.getHotArticle();
        latstArticles = touristService.getLatstArticle();

//        model.addAttribute("currentpage", "index");
        model.addAttribute("hotarticles", hotArticles);
        model.addAttribute("latstarticles", latstArticles);
        return "index";
    }


    /**
     * 浏览文章.
     *
     * @param articleId 文章编号
     * @param model 用于返回数据
     *
     * @return 文章展示页面
     */
    @RequestMapping("/single/{articleId}")
    public String single(@PathVariable("articleId") Integer articleId, Model model) {
        Article article = null;
        Page<Article> hotArticles = null;
        Set<Comment> comments = null;
        int commentCount = 0, supportcount = 0;
        article = touristService.getArticleById(articleId);
        if (article != null) {
            if (article.getComments() != null) {
                commentCount = article.getComments().size();
            }
            supportcount = article.getSupportUser().size();
            hotArticles = touristService.getHotArticle();
        }
		comments = touristService.getArticleComments(articleId);
        article.setComments(comments);
        model.addAttribute("article", article);
        model.addAttribute("commentcount", commentCount);
        model.addAttribute("supportcount", supportcount);
        model.addAttribute("hotarticles", hotArticles);
//        model.addAttribute("comments", comments);
        return "single";
    }

    /**
     * 访问博客列表页面.
     * @param model 用于返回数据
     * @param page_num 页数
     * @return 博客列表页面
     */
    @RequestMapping("/articles/{page_num}")
    public String articles(Model model, @PathVariable("page_num") Integer page_num) {
        int pageNum = 0;
        Page<Article> articleList = null;
        Page<Article> hotArticle = null;
        articleList = touristService.getArticleList(page_num);
        pageNum = touristService.getArticlePageCount();
        if (pageNum == 0) {
            pageNum = 1;
        }
        hotArticle = touristService.getHotArticle();
//        model.addAttribute("currentpage", "articles");
        model.addAttribute("nowpage", page_num);
        model.addAttribute("pagecount", pageNum);
        model.addAttribute("articlelist", articleList);
        model.addAttribute("hotarticles", hotArticle);
        return "articles_list";
    }

    /**
     * 跳转作者界面.
     *
     * @param userId 作者编号
     * @param nowpage 当前页面
     * @param model 用于返回数据
     * @return 作者首页
     */
    @RequestMapping("/visituser/{userId}/{nowpage}")
    public String visituser(@PathVariable("userId") Integer userId, @PathVariable("nowpage") Integer nowpage, Model model) {
        User user = null;
        Page<Article> articles = null;
        Page<Comment> comments = null;
        int pageNum = 0;
        user = touristService.getUserById(userId);
        if (user == null) {
            return "";
        }
        pageNum = touristService.getUsetArticlePageCount(userId);
        if (pageNum == 0) {
            pageNum = 1;
        }
        articles = touristService.getUserArticles(userId, nowpage);
        comments = userService.getNewComment(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("nowpage", nowpage);
        model.addAttribute("pagecount", pageNum);
        model.addAttribute("userarticles", articles);
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("newcomments", comments);
        return "myindex";
    }

    /**
     * 搜索.
     * @param searchText 搜索的关键字
     * @param nowpage 当前页面
     * @param model 用于返回数据
     * @return 结果页面
     */
    @GetMapping("/search/{nowpage}")
    public String search(String searchText, @PathVariable("nowpage") Integer nowpage, Model model) {
        Page<Article> articles = null;
        Integer pageNum = 0;
        Page<Article> hotArticle = null;
        pageNum = touristService.getSearchArticleCount(searchText);
        articles = touristService.getSearchArticles(searchText, nowpage);
        if (pageNum == 0) {
            pageNum = 1;
        }
        hotArticle = touristService.getHotArticle();
        model.addAttribute("articles", articles);
        model.addAttribute("pagecount", pageNum);
        model.addAttribute("nowpage", nowpage);
        model.addAttribute("searchText", searchText);
        model.addAttribute("hotarticles", hotArticle);
        return "search";
    }

    /**
     * 用户注册.
     * @param user 用户信息
     * @param model 用于返回数据
     * @return 结果页面
     */
    @PostMapping("/regist")
    public String regist(User user, Model model) {
        Integer userId;
        String passwprd = null;
        passwprd = user.getPassword();
        // 将密码加密
        BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
        user.setPassword(bpe.encode(passwprd));

        userId = userService.regist(user);
        model.addAttribute("registId", userId);
        model.addAttribute("message", "regist");
        return "msg";
    }

    /**
     * 访问留言页面.
     * @param model 用于返回数据
     * @return 留言页面
     */
    @RequestMapping("/contact")
    public String contact(Model model) {
        Page<Article> latstArticles = null;
        latstArticles = touristService.getLatstArticle();
        model.addAttribute("latstarticles", latstArticles);
        return "contact";
    }


	/**
	 * 跳转值忘记密码页面.
	 * @return 忘记密码页面
	 */
	@RequestMapping("/forgetPassword")
	public String forgetPassword() {
    	return "check_user";
	}

	/**
	 * 验证用户.
	 * @param userId 用户编号
	 * @param model 用于返回数据
	 * @return 相关结果页面
	 */
	@PostMapping("/checkuser")
	public String checkUser(Integer userId, Model model) {
		boolean ok = false;
		ok = userService.checkUser(userId);
		if (ok) {
			model.addAttribute("message", "checkuser");
			return "msg";
		}
		return "redirect:/forgetPassword";
	}

	/**
	 * 跳转修改密码页面
	 * @param userId 用户编号
	 * @param uuid 验证用户身份的uuid
	 * @param model 用于返回数据
	 * @return 相关结果页面
	 */
	@GetMapping("/updatepassword")
	public String updatePassword(Integer userId, String uuid, Model model) {
		User user = null;
		user = userService.getUserById(userId);
		String userUuid = user.getUuid();
		if (userUuid.equals(uuid)) {
			model.addAttribute("userId", userId);
			return "set_password";
		}
		model.addAttribute("message", "checkerror");
		return "msg";
	}

	/**
	 * 设置密码
	 * @param password 新密码
	 * @param repassword 确认密码
	 * @param userId 用户编号
	 * @param model 用于返回数据
	 * @return 结果显示页面
	 */
	@PostMapping("/setpassword")
	public String setPassword(String password, String repassword, Integer userId, Model model) {
		if (password.equals(repassword)) {
			userService.updatePassword(userId, password);
			model.addAttribute("message", "setok");
			return "msg";
		}
		model.addAttribute("message", "seterror");
		return "msg";
	}

    /**
     * 用户登录.
     * @param user 用户信息
     * @param session session
     * @return 登录结果页面
     */
//    @PostMapping("/login")
//    public String login(User user, HttpSession session) {
//        User user1 = null;
//        String returnString = "redirect:/tologin";
//        user1 = userService.login(user);
//        if (user1 != null) {
//            Integer id = user.getUserId();
//            String name = user1.getUserName();
//            session.setAttribute("userId", id);
//            session.setAttribute("userName", name);
//            returnString = "redirect:/visituser/" + id + "/0";
//        }
//
//        return returnString;
//    }

}
