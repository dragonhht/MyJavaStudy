package hht.dragon.service;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import hht.dragon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 用户Service类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:46
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param user 用户信息
     * @return 用户信息
     */
    public User login(User user);

    /**
     * 点赞
     * @param user_id 用户编号
     * @param article_id 文章编号
     * @return 点赞总数
     */
    public Integer supportArticle(Integer user_id, Integer article_id);

    /**
     * 通过用户编号查询用户
     * @param user_id 用户编号
     * @return 用户信息
     */
    public User getUserById(Integer user_id);

	/**
	 * 通过姓名查询用户
	 * @param userName 用户姓名
	 * @return 用户信息
	 */
	public User getUserByName(String userName);

    /**
     * 通过文章编号查询文章
     * @param article_id 文章编号
     * @return 文章信息
     */
    public Article getArticleById(Integer article_id);

    /**
     * 查询是否该用户已经点赞
     * @param user_id 用户编号
     * @param article_id 文章编号
     * @return 结果
     */
    public boolean isSupport(Integer user_id, Integer article_id);

    /**
     * 评论文章
     * @param user_id 评论的用户编号
     * @param article_id 文章编号
     * @param comment_text 评论内容
     * @return 保存结果
     */
    public boolean contactArticle(Integer user_id, Integer article_id, String comment_text);

    /**
     * 评论评论
     * @param user_id 用户编号
     * @param comment_id 评论编号
     * @param comment_text 评论内容
     * @return
     */
    public boolean contactComment(Integer user_id, Integer comment_id, String comment_text);

    /**
     * 保存文章
     * @param article 文章信息
     * @param user_id 用户编号
     * @return
     */
    public Article saveArticle(Article article, Integer user_id);


    /**
     * 用户注册
     * @param user 用户信息
     * @return 注册成功后的编号
     */
    public Integer regist(User user);

	/**
	 * 修改用户信息
	 * @param user 用户信息
	 * @return 修改后的用户信息
	 */
	public User updateUser(User user);

	/**
	 * 保存图片
	 * @param img 图片路径
	 * @param user_id 用户编号
	 * @return
	 */
	public boolean saveImg(String img, Integer user_id);

	/**
	 * 获取最新关于作者的评论
	 * @param user_id 作者编号
	 * @return 评论信息
	 */
	public Page<Comment> getNewComment(Integer user_id);

}
