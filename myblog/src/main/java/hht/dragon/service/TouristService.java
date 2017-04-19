package hht.dragon.service;

import hht.dragon.entity.Article;
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

}
