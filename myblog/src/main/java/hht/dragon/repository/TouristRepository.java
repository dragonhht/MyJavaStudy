package hht.dragon.repository;

import hht.dragon.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 游客Repository接口
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:18
 */
public interface TouristRepository extends JpaRepository<Article,Integer>{

}
