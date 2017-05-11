package hht.dragon.repository;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 用户JpaRepository接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:45
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    //登录
    @Query("select u from User u where u.userId = ?1 and u.password = ?2")
    public User getByidAndPassword(Integer userId, String password);

    //通过用户编号查询用户
    @Query("select u from User u where u.userId = ?1")
    public User getUserById(Integer userId);

    //通过用户姓名查询用户
    @Query("select u from User u where u.userName = ?1")
    public User getUserByUserName(String userName);

    //通过文章编号查询文章
    @Query("select a from Article a where a.articleId = ?1")
    public Article getArticleById(Integer articleId);


    //查询是否已经点赞
    @Query("select a from Article a join a.supportUser u where u.userId = ?1 and a.articleId = ?2")
    public Article isSupport(Integer userId, Integer articleId);

	//查询我的文章最新的十条评论
	@Query("select c from Comment c where c.article.user.userId = ?1")
	public Page<Comment> getNewComments(Integer userId, Pageable pageable);

}
