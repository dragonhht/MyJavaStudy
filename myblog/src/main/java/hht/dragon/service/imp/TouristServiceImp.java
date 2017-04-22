package hht.dragon.service.imp;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import hht.dragon.repository.TouristRepository;
import hht.dragon.service.TouristService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Set;

/**
 * 游客service实现类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:17
 */
@Service
public class TouristServiceImp implements TouristService{
    static final Integer PAGE_SIZE = 5;

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
        Integer lookCount = 0;
        article = touristRepository.findOne(article_id);
        lookCount = article.getLookCount();
        lookCount++;
        article.setLookCount(lookCount);
        article = touristRepository.save(article);
        return article;
    }

    @Override
    public Page<Article> getArticleList(Integer pageNum) {
        //按文章上传日期倒序
        Sort sort = new Sort(Sort.Direction.DESC, "article_date");
        Pageable pageable1 = new PageRequest(pageNum, PAGE_SIZE, sort);
        Page<Article> articlePage = touristRepository.getArticleList(pageable1);
        return articlePage;
    }

    /**
     * 计算分页页数
     *
     * @param num 信息总数
     * @return 分页数目
     */
    private int getPageCount(Integer num) {
        Integer pageNum = 0;
        if ((num % PAGE_SIZE) != 0) {
            pageNum = num / PAGE_SIZE + 1;
        } else {
            pageNum = num / PAGE_SIZE;
        }
        return pageNum;
    }

    @Override
    public int getArticlePageCount() {
        int pagNum = 0;
        int num = 0;
        num = touristRepository.getArticleCount();
        pagNum = getPageCount(num);
        return pagNum;
    }

    @Override
    public User getUserById(Integer user_id) {
        User user = null;
        user = touristRepository.getUserById(user_id);
        return user;
    }



    @Override
    public int getUsetArticlePageCount(Integer user_id) {
        int pagNum = 0;
        int num = 0;
        User user = null;
        user = touristRepository.getUserById(user_id);
        if (user != null) {
            num = user.getArticles().size();
        }
        pagNum = getPageCount(num);
        return pagNum;
    }

    @Override
    public Page<Article> getUserArticles(Integer user_id, Integer pageNum) {
        Page<Article> articles = null;
        //按文章上传日期倒序
        Sort sort = new Sort(Sort.Direction.DESC, "article_date");
        Pageable pageable1 = new PageRequest(pageNum, PAGE_SIZE, sort);
        articles = touristRepository.getArticleByUserId(user_id, pageable1);
        return articles;
    }
}
