package hht.dragon.service.imp;

import hht.dragon.entity.Article;
import hht.dragon.entity.Comment;
import hht.dragon.entity.CommentChild;
import hht.dragon.entity.User;
import hht.dragon.repository.CommentChildReponsitory;
import hht.dragon.repository.TouristRepository;
import hht.dragon.repository.UserRepository;
import hht.dragon.service.UserService;
import hht.dragon.utils.getDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-4-24
 * Time : 下午4:48
 */
@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentChildReponsitory commentChildReponsitory;

    @Override
    public User login(User user) {
        User user1 = null;
        user1 = userRepository.getByidAndPassword(user.getUser_id(), user.getPassword());
        return user1;
    }

    @Override
    public Integer supportArticle(Integer user_id, Integer article_id) {
        Integer num = 0;
        boolean ok = false;
        ok = isSupport(user_id, article_id);
        if (ok) {
            User user = getUserById(user_id);
            Article article = getArticleById(article_id);
            num = article.getSupport_user().size();
            num = ++num;
            user.getSupport_article().add(article);
            userRepository.save(user);
        }
        return num;
    }

    @Override
    public User getUserById(Integer user_id) {
        User user = null;
        user = userRepository.getUserById(user_id);
        return user;
    }

    @Override
    public Article getArticleById(Integer article_id) {
        Article article = null;
        article = userRepository.getArticleById(article_id);
        return article;
    }

    @Override
    public boolean isSupport(Integer user_id, Integer article_id) {
        Article article = null;
        boolean ok = false;
        article = userRepository.isSupport(user_id, article_id);
        if (article == null) {
            ok = true;
        }
        return ok;
    }

    @Override
    public boolean contactArticle(Integer user_id, Integer article_id, String comment_text) {
        boolean ok = false;
        User user = null;
        Article article = null;
        String comment_date = null;
        Comment comment = new Comment();
        user = userRepository.getUserById(user_id);
        article = userRepository.getArticleById(article_id);
        comment_date = getDate.getDate();
        comment.setArticle(article);
        comment.setUser(user);
        comment.setComment_text(comment_text);
        comment.setComment_date(comment_date);
        Comment commentTest = commentRepository.save(comment);
        if (commentTest != null) {
            ok = true;
        }
        return ok;
    }

    @Override
    public boolean contactComment(Integer user_id, Integer comment_id, String comment_text) {
        boolean ok = false;
        User user = null;
        Comment comment = null;
        String commentChild_date = null;
        CommentChild commentChild = new CommentChild();
        user = userRepository.getUserById(user_id);
        comment = commentRepository.getOne(comment_id);
        commentChild_date = getDate.getDate();
        commentChild.setComment_date(commentChild_date);
        commentChild.setComment(comment);
        commentChild.setComment_text(comment_text);
        commentChild.setUser(user);
        CommentChild commentChild1 = commentChildReponsitory.save(commentChild);
        if (commentChild1 != null) {
            ok = true;
        }
        return ok;
    }
}
