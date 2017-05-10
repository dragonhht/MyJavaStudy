package hht.dragon.test;

import hht.dragon.MyblogApplication;
import hht.dragon.controller.UserController;
import hht.dragon.entity.Article;
import hht.dragon.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 用户模块测试
 * <p>
 * User : Dragon_hht
 * Date : 17-5-10
 * Time : 下午3:22
 */
// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyblogApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class testUser {
	@Autowired
	private UserService userService;

	//添加文章
	@Test
	public void testSaveArticle() {
		String title = "测试";
		String text = "just for test";
		Integer user_id = 1;
		for (int i = 0; i <= 1000; i++) {
			Article article = new Article();
			article.setArticle_text(text);
			article.setArticle_title(title);
			userService.saveArticle(article, user_id);
		}
	}

	//添加评论
	@Test
	public void testSaveComment() {
		Integer user_id = 1;
		Integer article_id = 1;
		String text = "评论测试";
		for (int i=0; i<100; i++) {
			userService.contactArticle(user_id, article_id, text);
		}
	}

	//添加评论的评论
	@Test
	public void testAddCommentChild() {
		Integer user_id  = 1;
		Integer comment_id = 2;
		for (int i = 0; i < 100; i++) {
			String text = "测试 "+ i;
			userService.contactComment(user_id, comment_id, text);
		}
	}
}
