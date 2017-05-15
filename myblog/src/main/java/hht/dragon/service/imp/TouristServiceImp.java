package hht.dragon.service.imp;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.User;
import hht.dragon.repository.TouristRepository;
import hht.dragon.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Set;

/**
 * 游客service实现类.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:17
 */
@Service
public class TouristServiceImp implements TouristService {
    /** 每页显示的数量. */
    static final Integer PAGE_SIZE = 20;
    /** 首页文章信息显示的数量. */
    static final Integer INDEX_ARTICLE_NUM = 10;

    /** Article的数据库操作类. */
    @Autowired
    private TouristRepository touristRepository;

    @Override
    public Page<Article> getHotArticle() {
        Page<Article> hotArticles = null;
        Pageable pageable = new PageRequest(0, INDEX_ARTICLE_NUM);
        hotArticles = touristRepository.getHostArticle(pageable);
        return hotArticles;
    }

    @Override
    public Page<Article> getLatstArticle() {
        Page<Article> latstArticles = null;
        Pageable pageable = new PageRequest(0, INDEX_ARTICLE_NUM);
        latstArticles = touristRepository.getLatstArticle(pageable);
        return latstArticles;
    }

    @Override
    public Article getArticleById(Integer articleId) {
        Article article = null;
        Integer lookCount = 0;
        article = touristRepository.findOne(articleId);
        lookCount = article.getLookCount();
        lookCount++;
        article.setLookCount(lookCount);
        article = touristRepository.save(article);
        return article;
    }

    @Override
    public Page<Article> getArticleList(Integer pageNum) {
        //按文章上传日期倒序
        Sort sort = new Sort(Sort.Direction.DESC, "articleDate");
        Pageable pageable1 = new PageRequest(pageNum, PAGE_SIZE, sort);
        Page<Article> articlePage = touristRepository.getArticleList(pageable1);
        return articlePage;
    }

    /**
     * 计算分页页数.
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
    public User getUserById(Integer userId) {
        User user = null;
        user = touristRepository.getUserById(userId);
        return user;
    }



    @Override
    public int getUsetArticlePageCount(Integer userId) {
        int pagNum = 0;
        int num = 0;
        User user = null;
        user = touristRepository.getUserById(userId);
        if (user != null) {
            num = user.getArticles().size();
        }
        pagNum = getPageCount(num);
        return pagNum;
    }

    @Override
    public Page<Article> getUserArticles(Integer userId, Integer pageNum) {
        Page<Article> articles = null;
        //按文章上传日期倒序
        Sort sort = new Sort(Sort.Direction.DESC, "articleDate");
        Pageable pageable1 = new PageRequest(pageNum, PAGE_SIZE, sort);
        articles = touristRepository.getArticleByUserId(userId, pageable1);
        return articles;
    }

    @Override
    public int getSearchArticleCount(String searchText) {
        int num = 0;
        int pageNum = 0;
        searchText = "%" + searchText + "%";
        num = touristRepository.getSearchArticleCount(searchText, searchText, searchText);
        pageNum = getPageCount(num);
        return pageNum;
    }

    @Override
    public Page<Article> getSearchArticles(String searchText, Integer pageNum) {
        Page<Article> articles = null;
        searchText = "%" + searchText + "%";
        //按文章上传日期倒序
        Sort sort = new Sort(Sort.Direction.DESC, "articleDate");
        Pageable pageable1 = new PageRequest(pageNum, PAGE_SIZE, sort);
        articles = touristRepository.getSearchArticles(searchText, searchText, searchText, pageable1);
        return articles;
    }

	@Override
	public Set<Comment> getArticleComments(Integer articleId) {
		Set<Comment> comments = null;
		comments = touristRepository.getArticleComment(articleId);
		return comments;
	}

}
