package hht.dragon.service.imp;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.CommentChild;
import hht.dragon.entity.User;
import hht.dragon.repository.CommentChildReponsitory;
import hht.dragon.repository.CommentRepository;
import hht.dragon.repository.TouristRepository;
import hht.dragon.repository.UserRepository;
import hht.dragon.service.UserService;
import hht.dragon.utils.GetDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户service的实现类.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-24
 * Time : 下午4:48
 */
@SuppressWarnings("CheckStyle")
@Service
public class UserServiceImp implements UserService {

	/** User的数据库操作类. */
    @Autowired
    private UserRepository userRepository;
    /** comment的数据库操作类. */
    @Autowired
    private CommentRepository commentRepository;
    /** commentChild的数据库操作类. */
    @Autowired
    private CommentChildReponsitory commentChildReponsitory;
    /** Article的数据库操作类 .*/
    @Autowired
    private TouristRepository touristRepository;

    @Override
    public User login(User user) {
        User user1 = null;
        user1 = userRepository.getByidAndPassword(user.getUserId(), user.getPassword());
        return user1;
    }

    @Override
    public Integer supportArticle(Integer userId, Integer articleId) {
        Integer num = 0;
        boolean ok = false;
        ok = isSupport(userId, articleId);
        if (ok) {
            User user = getUserById(userId);
            Article article = getArticleById(articleId);
            num = article.getSupportUser().size();
            num = ++num;
            user.getSupportArticle().add(article);
            userRepository.save(user);
        }
        return num;
    }

    @Override
    public User getUserById(Integer userId) {
        User user = null;
        user = userRepository.getUserById(userId);
        return user;
    }

    @Override
    public User getUserByName(String userName) {
        User user = null;
        user = userRepository.getUserByUserName(userName);
        return user;
    }

    @Override
    public Article getArticleById(Integer articleId) {
        Article article = null;
        article = userRepository.getArticleById(articleId);
        return article;
    }

    @Override
    public boolean isSupport(Integer userId, Integer articleId) {
        Article article = null;
        boolean ok = false;
        article = userRepository.isSupport(userId, articleId);
        if (article == null) {
            ok = true;
        }
        return ok;
    }

    @Override
    public boolean contactArticle(Integer userId, Integer articleId, String commentText) {
        boolean ok = false;
        User user = null;
        Article article = null;
        String commentDate = null;
        Comment comment = new Comment();
        user = userRepository.getUserById(userId);
        article = userRepository.getArticleById(articleId);
		commentDate = GetDate.getDate();
        comment.setArticle(article);
        comment.setUser(user);
        comment.setCommentText(commentText);
        comment.setCommentDate(commentDate);
        Comment commentTest = commentRepository.save(comment);
        if (commentTest != null) {
            ok = true;
        }
        return ok;
    }

    @Override
    public boolean contactComment(Integer userId, Integer commentId, String commentText) {
        boolean ok = false;
        User user = null;
        Comment comment = null;
        String commentChildDate = null;
        CommentChild commentChild = new CommentChild();
        user = userRepository.getUserById(userId);
        comment = commentRepository.getOne(commentId);
		commentChildDate = GetDate.getDate();
        commentChild.setCommentDate(commentChildDate);
        commentChild.setComment(comment);
        commentChild.setCommentText(commentText);
        commentChild.setUser(user);
        CommentChild commentChild1 = commentChildReponsitory.save(commentChild);
        if (commentChild1 != null) {
            ok = true;
        }
        return ok;
    }

    @Override
    public Article saveArticle(Article article, Integer userId) {
        User user = null;
        String articleDate = null;
        Article articleResult = null;
        articleDate = GetDate.getDate();
        user = userRepository.getUserById(userId);
        article.setUser(user);
        article.setArticleDate(articleDate);
        articleResult = touristRepository.save(article);
        return articleResult;
    }

    @Override
    public Integer regist(User user) {
        User user1 = null;
        user.setRegistDate(new Date());
        user1 = userRepository.save(user);
        return user1.getUserId();
    }

	@SuppressWarnings("CheckStyle")
	@Override
	public User updateUser(User user) {
    	User user1 = null;
		//数据库中的用户信息
		User dbUser = null;
		dbUser = userRepository.getUserById(user.getUserId());
		user.setRoles(dbUser.getRoles());
		user.setSupportArticle(dbUser.getSupportArticle());
		user.setArticles(dbUser.getArticles());
		user.setPassword(dbUser.getPassword());
		user.setImg(dbUser.getImg());
    	user1 = userRepository.save(user);
		return user1;
	}

    @Override
    public boolean saveImg(String img, Integer userId) {
    	boolean ok = false;
    	User user = null;
    	try {
			user = userRepository.getUserById(userId);
			user.setImg(img);
			userRepository.save(user);
			ok = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

        return ok;
    }

	@Override
	public Page<Comment> getNewComment(Integer userId) {
    	final Integer pageSize = 10;
    	Page<Comment> comments = null;
		//按评论日期倒序
		Sort sort = new Sort(Sort.Direction.DESC, "commentDate");
		Pageable pageable = new PageRequest(0, pageSize, sort);
		comments = userRepository.getNewComments(userId, pageable);
		return comments;
	}
}
