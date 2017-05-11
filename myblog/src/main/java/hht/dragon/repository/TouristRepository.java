package hht.dragon.repository;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

/**
 * 游客Repository接口.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:18
 */
public interface TouristRepository extends JpaRepository<Article, Integer> {

    /**
     * 查询热搜文章.
     * @param pageable 分页设置
     * @return 热搜文章
     */
    @Query("select a from Article a order by lookCount desc ")
    Page<Article> getHostArticle(Pageable pageable);

    /**
     * 查询最新文章.
     * @param pageable 分页设置
     * @return 最新文章
     */
    @Query("select a from Article a order by articleDate desc ")
    Page<Article> getLatstArticle(Pageable pageable);

    /**
     * 分页查询文章.
     * @param pageable 分页设置
     * @return 文章信息
     */
    @Query("select a from Article a order by articleDate desc ")
    Page<Article> getArticleList(Pageable pageable);

    /**
     * 查询文章数量.
     * @return 文章数量
     */
    @Query("select count(*) from Article")
    int getArticleCount();

    /**
     * 通过用户编号查询用户.
     * @param userId 用户编号
     * @return 用户信息
     */
    @Query("select u from User u where u.userId = ?1")
    User getUserById(Integer userId);

    /**
     * 通过用户编号查询文章.
     * @param userId 用户编号
     * @param pageable 分页设置
     * @return 文章信息
     */
    @Query("select a from Article a where a.user.userId = ?1")
    Page<Article> getArticleByUserId(Integer userId, Pageable pageable);

    /**
     * 获取搜索结果的数量.
     * @param userName 用户名
     * @param text 文章内容
     * @param title 文章标题
     * @return 文章数量
     */
    @Query("select count(*) from Article a where a.user.userName like ?1 or a.articleText like ?2 or a.articleTitle like ?3")
    int getSearchArticleCount(String userName, String text, String title);

    /**
     * 查询文章.
     * @param userName 用户名
     * @param text 文章内容
     * @param title 文章标题
     * @param pageable 分页设置
     * @return 文章信息
     */
    @Query("select a from Article a where a.user.userName like ?1 or a.articleText like ?2 or a.articleTitle like ?3")
    Page<Article> getSearchArticles(String userName, String text, String title, Pageable pageable);

    /**
     * 通过文章编号查询评论.
     * @param articleId 文章拿灰姑娘编号
     * @return 文章信息
     */
    @Query("select c from Comment c where c.article.articleId = ?1 order by c.commentDate desc")
	Set<Comment> getArticleComment(Integer articleId);

}
