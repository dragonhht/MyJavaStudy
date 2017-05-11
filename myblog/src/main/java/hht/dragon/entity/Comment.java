package hht.dragon.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * 评论类.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:21
 */
@Entity
@Table(name = "comment")
public class Comment {
    /** 评论编号. */
    @Id
    @GeneratedValue
    private Integer id;
    /** 评论者编号. */
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    /** 评论时间. */
    private String commentDate;
    /** 评论内容. */
    private String commentText;
    /** 评论的文章. */
    @ManyToOne
    @JoinColumn(name = "articleId")
    private Article article;

    /** 评论的回复. */
    @OneToMany
    @JoinColumn(name = "comment_id")
    private Set<CommentChild> commentChildren;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets comment date.
     *
     * @return the comment date
     */
    public String getCommentDate() {
        return commentDate;
    }

    /**
     * Sets comment date.
     *
     * @param commentDate the comment date
     */
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    /**
     * Gets comment text.
     *
     * @return the comment text
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * Sets comment text.
     *
     * @param commentText the comment text
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    /**
     * Gets article.
     *
     * @return the article
     */
    public Article getArticle() {
        return article;
    }

    /**
     * Sets article.
     *
     * @param article the article
     */
    public void setArticle(Article article) {
        this.article = article;
    }

    /**
     * Gets comment children.
     *
     * @return the comment children
     */
    public Set<CommentChild> getCommentChildren() {
        return commentChildren;
    }

    /**
     * Sets comment children.
     *
     * @param commentChildren the comment children
     */
    public void setCommentChildren(Set<CommentChild> commentChildren) {
        this.commentChildren = commentChildren;
    }

}
