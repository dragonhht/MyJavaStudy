package hht.dragon.test;

import hht.dragon.MyblogApplication;
import hht.dragon.entity.Article;
import hht.dragon.entity.User;
import hht.dragon.repository.UserRepository;
import hht.dragon.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 用户模块测试.
 * <p>
 * User : Dragon_hht
 * Date : 17-5-10
 * Time : 下午3:22
 */
// SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyblogApplication.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class UserTest {
	/** 测试的次数. */
	static final Integer TEST_COUNT = 100;
	/**用户的service类. */
	@Autowired
	private UserService userService;


	/**
	 * 添加文章.
	 */
	@Test
	public void testSaveArticle() {
		String title = "测试";
		String text = "just for test";
		Integer userId = 1;
		for (int i = 0; i <= TEST_COUNT; i++) {
			Article article = new Article();
			article.setArticleText(text);
			article.setArticleTitle(title);
			userService.saveArticle(article, userId);
		}
	}

	/**
	 * 添加评论.
	 */
	@Test
	public void testSaveComment() {
		Integer userId = 1;
		Integer articleId = 1;
		String text = "评论测试";
		for (int i = 0; i < TEST_COUNT; i++) {
			userService.contactArticle(userId, articleId, text);
		}
	}

	/**
	 * 添加评论的评论.
	 */
	@Test
	public void testAddCommentChild() {
		Integer userId  = 1;
		Integer commentId = 2;
		for (int i = 0; i < TEST_COUNT; i++) {
			String text = "测试 " + i;
			userService.contactComment(userId, commentId, text);
		}
	}

}
