package hht.dragon.service.imp;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.repository.TouristRepository;
import hht.dragon.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 游客service实现类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:17
 */
@Service
public class TouristServiceImp implements TouristService{

    @Autowired
    private TouristRepository touristRepository;
    private Pageable pageable = new Pageable() {
        @Override
        public int getPageNumber() {
            return 0;
        }

        @Override
        public int getPageSize() {
            return 10;
        }

        @Override
        public int getOffset() {
            return 0;
        }

        @Override
        public Sort getSort() {
            return null;
        }

        @Override
        public Pageable next() {
            return null;
        }

        @Override
        public Pageable previousOrFirst() {
            return null;
        }

        @Override
        public Pageable first() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }
    };

    @Override
    public Page<Article> getHotArticle() {
        Page<Article> hotArticles = null;
        hotArticles = touristRepository.getHostArticle(pageable);
        return hotArticles;
    }

    @Override
    public Page<Article> getLatstArticle() {
        Page<Article> latstArticles = null;
        latstArticles = touristRepository.getLatstArticle(pageable);
        return latstArticles;
    }

    @Override
    public Article getArticleById(Integer article_id) {
        Article article = null;
        article = touristRepository.findOne(article_id);
        return article;
    }
}
