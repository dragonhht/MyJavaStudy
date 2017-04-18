package hht.dragon.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 文章类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:12
 */
@Entity
@Table(name = "article")
public class Article {
    //文章编号
    @Id
    @GeneratedValue
    private Integer article_id;
    //文章标题
    private String article_title;
    //文章发表时间
    private String article_date;
    //文章内容
    private String article_text;
    //作者编号
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //一对多
    @OneToMany
    @JoinColumn(name = "article_id")
    private Set<Comment> comments;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_date() {
        return article_date;
    }

    public void setArticle_date(String article_date) {
        this.article_date = article_date;
    }

    public String getArticle_text() {
        return article_text;
    }

    public void setArticle_text(String article_text) {
        this.article_text = article_text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id=" + article_id +
                ", article_title='" + article_title + '\'' +
                ", article_date='" + article_date + '\'' +
                ", article_text='" + article_text + '\'' +
                '}';
    }
}
