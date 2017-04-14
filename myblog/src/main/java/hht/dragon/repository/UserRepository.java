package hht.dragon.repository;

import hht.dragon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户JpaRepository接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:45
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    public User getByIdAndPassword(Integer id, String password);

}
