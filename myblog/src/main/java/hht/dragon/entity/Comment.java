package hht.dragon.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 评论类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:21
 */
@Entity
@Table(name = "comment")
public class Comment {
    //评论编号
    @Id
    @GeneratedValue
    private Integer id;
    //评论者编号
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //评论时间
    private String comment_date;
    //评论内容
    private String comment_text;
    //单向多对一
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    //一对多
    @OneToMany
    @JoinColumn(name = "comment_id")
    private Set<CommentChild> commentChildren;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Set<CommentChild> getCommentChildren() {
        return commentChildren;
    }

    public void setCommentChildren(Set<CommentChild> commentChildren) {
        this.commentChildren = commentChildren;
    }

}
