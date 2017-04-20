package hht.dragon.service;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import hht.dragon.entity.Article;
import hht.dragon.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

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
     * @param article_id 文章编号
     *
     * @return 文章信息
     */
     public Article getArticleById(Integer article_id);


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
     * @param user_id 用户编号
     *
     * @return 用户信息
     */
    public User getUserById(Integer user_id);

    /**
     * 计算作者首页文章页数
     * @param user_id 作者编号
     * @return
     */
    public int getUsetArticlePageCount(Integer user_id);
}
