package hht.dragon.repository;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

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
    @Query("select u from User u where u.user_id = ?1")
    public User getUserById(Integer user_id);

    //通过用户编号查询文章
    @Query("select a from Article a where a.user.user_id = ?1")
    public Page<Article> getArticleByUserId(Integer user_id, Pageable pageable);

    //查询搜索的结果数
    @Query("select count(*) from Article a where a.user.userName like ?1 or a.article_text like ?2 or a.article_title like ?3")
    public int getSearchArticleCount(String userName, String text, String title);

    //查询文章
    @Query("select a from Article a where a.user.userName like ?1 or a.article_text like ?2 or a.article_title like ?3")
    public Page<Article> getSearchArticles(String userName, String text,String title, Pageable pageable);

    //查询评论
    @Query("select c from Comment c where c.article.article_id = ?1 order by c.comment_date desc")
	public Set<Comment> getArticleComment(Integer article_id);

}
