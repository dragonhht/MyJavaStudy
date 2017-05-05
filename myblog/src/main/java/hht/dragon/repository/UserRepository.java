package hht.dragon.repository;

import hht.dragon.entity.Article;
import hht.dragon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户JpaRepository接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:45
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    //登录
    @Query("select u from User u where u.user_id = ?1 and u.password = ?2")
    public User getByidAndPassword(Integer user_id, String password);

    //通过用户编号查询用户
    @Query("select u from User u where u.user_id = ?1")
    public User getUserById(Integer user_id);

    //通过用户姓名查询用户
    @Query("select u from User u where u.userName = ?1")
    public User getUserByUserName(String userName);

    //通过文章编号查询文章
    @Query("select a from Article a where a.article_id = ?1")
    public Article getArticleById(Integer article_id);


    //查询是否已经点赞
    @Query("select a from Article a join a.support_user u where u.user_id = ?1 and a.article_id = ?2")
    public Article isSupport(Integer user_id, Integer article_id);


}
