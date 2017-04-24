package hht.dragon.service;

import hht.dragon.entity.Article;
import hht.dragon.entity.User;
import hht.dragon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
     * 通过文章编号查询文章
     * @param article_id 文章编号
     * @return 文章信息
     */
    public Article getArticleById(Integer article_id);

}
