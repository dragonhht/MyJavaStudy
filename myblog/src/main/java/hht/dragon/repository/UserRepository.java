package hht.dragon.repository;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * 用户JpaRepository接口.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:45
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 登录验证.
     * @param userId 用户编号
     * @param password 登录密码
     * @return 用户信息
     */
    @Query("select u from User u where u.userId = ?1 and u.password = ?2")
    User getByidAndPassword(Integer userId, String password);

    /**
     * 通过用户编号查询用户.
     * @param userId 用户编号
     * @return 用户信息
     */
    @Query("select u from User u where u.userId = ?1")
    User getUserById(Integer userId);

    /**
     * 通过用户名称查询用户.
     * @param userName 用户名称
     * @return 用户信息
     */
    @Query("select u from User u where u.userName = ?1")
    User getUserByUserName(String userName);

    /**
     * 通过文章编号查询文章.
     * @param articleId 文章编号
     * @return 文章信息
     */
    @Query("select a from Article a where a.articleId = ?1")
    Article getArticleById(Integer articleId);

    /**
     * 查询用户是否已经支持了文章.
     * @param userId 用户编号
     * @param articleId 文章编号
     * @return 文章信息
     */
    @Query("select a from Article a join a.supportUser u where u.userId = ?1 and a.articleId = ?2")
    Article isSupport(Integer userId, Integer articleId);

    /**
     * 查询关于用户文章的评论.
     * @param userId 用户编号
     * @param pageable 分页设置
     * @return 评论信息
     */
    @Query("select c from Comment c where c.article.user.userId = ?1")
	Page<Comment> getNewComments(Integer userId, Pageable pageable);

}
