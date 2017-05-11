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
    @JoinColumn(name = "userId")
    private User user;
    //评论时间
    private String commentDate;
    //评论内容
    private String commentText;
    //单向多对一
    @ManyToOne
    @JoinColumn(name = "articleId")
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

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
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
