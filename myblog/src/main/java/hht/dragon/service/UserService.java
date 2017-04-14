package hht.dragon.service;

import hht.dragon.entity.User;
import hht.dragon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户Service类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:46
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    /**
     *
     * 用户注册
     *
     * @param user 用户信息
     * @return 新增用户的编号
     */
    public Integer regist(User user) {
        User user1 = userRepository.save(user);
        return user1.getId();
    }

    public User login(User user) {
        return userRepository.getByIdAndPassword(user.getId(), user.getPassword());
    }
}
