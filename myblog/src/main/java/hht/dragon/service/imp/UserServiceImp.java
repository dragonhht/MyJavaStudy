package hht.dragon.service.imp;

import hht.dragon.entity.Article;
import hht.dragon.entity.User;
import hht.dragon.repository.UserRepository;
import hht.dragon.service.UserService;
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

    @Override
    public User login(User user) {
        User user1 = null;
        user1 = userRepository.getByidAndPassword(user.getUser_id(), user.getPassword());
        return user1;
    }

    @Override
    public Integer supportArticle(Integer user_id, Integer article_id) {
        Integer num = 0;
        User user = getUserById(user_id);
        Article article = getArticleById(article_id);
        num = article.getSuppot_count();
        num = ++num;
        article.getSupport_user().add(user);
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
}
