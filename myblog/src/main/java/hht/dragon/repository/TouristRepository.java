package hht.dragon.repository;

import hht.dragon.entity.Article;
import hht.dragon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * 游客Repository接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:18
 */
public interface TouristRepository extends JpaRepository<Article,Integer>{

    //查询热搜文章
    @Query("select a from Article a order by lookCount desc ")
    public Page<Article> getHostArticle(Pageable pageable);

    //查询最新文章
    @Query("select a from Article a order by article_date desc ")
    public Page<Article> getLatstArticle(Pageable pageable);

    //分页查询文章
    @Query("select a from Article a order by article_date desc ")
    public Page<Article> getArticleList(Pageable pageable);

    //查询有多少篇文章
    @Query("select count(*) from Article")
    public int getArticleCount();

    //通过用户编号查询用户
    @Query("select u from User u where u.id = ?1")
    public User getUserById(Integer user_id);

}
