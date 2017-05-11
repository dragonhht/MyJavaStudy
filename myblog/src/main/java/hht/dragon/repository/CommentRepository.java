package hht.dragon.repository;

import hht.dragon.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassDescription.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-26
 * Time : 下午8:43
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
