package hht.dragon.service;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

/**
 * 游客service接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:17
 */
public interface TouristService {

    /**
     * 查询热搜文章
     *
     * @return 热搜文章信息
     */
     public Page<Article> getHotArticle();

    /**
     * 查询最新文章
     *
     * @return 最新文章信息
     */
     public Page<Article> getLatstArticle();

    /**
     * 通过文章编号获取文章详细信息
     *
     * @param articleId 文章编号
     *
     * @return 文章信息
     */
     public Article getArticleById(Integer articleId);


    /**
     * 获取文章列表
     *
     * @return 文章列表
     */
     public Page<Article> getArticleList(Integer pageNum);

    /**
     * 计算文章分页页数
     *
     * @return 分页数量
     */
    public int getArticlePageCount();

    /**
     * 通过用户编号查询用户
     *
     * @param userId 用户编号
     *
     * @return 用户信息
     */
    public User getUserById(Integer userId);

    /**
     * 计算作者首页文章页数
     * @param userId 作者编号
     * @return
     */
    public int getUsetArticlePageCount(Integer userId);

    /**
     * 通过用户编号查询文章
     * @param userId 用户编号
     * @return
     */
    public Page<Article> getUserArticles(Integer userId, Integer pageNum);

    /**
     * 计算搜索结果的页数
     * @param searchText 搜索的关键字
     * @return
     */
    public int getSearchArticleCount(String searchText);

    /**
     * 查询文章或作者
     * @param searchText 搜索关键字
     * @return 搜索到的结果
     */
    public Page<Article> getSearchArticles(String searchText, Integer pageNum);

    /**
     * 查询文章评论
     * @param articleId 文章编号
     * @return 查询到的文章
     */
    public Set<Comment> getArticleComments(Integer articleId);
}
