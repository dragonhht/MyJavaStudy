package hht.dragon.repository;

import hht.dragon.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 发送邮件的邮箱的相关操作.
 * <p>
 * User : Dragon_hht
 * Date : 17-5-15
 * Time : 下午5:29
 */
public interface EmailRepository extends JpaRepository<Email, Integer> {
}
