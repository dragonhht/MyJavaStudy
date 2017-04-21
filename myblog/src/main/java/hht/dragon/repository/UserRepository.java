package hht.dragon.repository;

import hht.dragon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户JpaRepository接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:45
 */
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("select u from User u where u.user_id = ?1 and u.password = ?2")
    public User getByidAndPassword(Integer user_id, String password);

}
