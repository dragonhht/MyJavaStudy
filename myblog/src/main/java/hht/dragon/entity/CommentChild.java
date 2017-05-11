package hht.dragon.entity;

import javax.persistence.*;

/**
 * 评论的子评论.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-27
 * Time : 下午7:29
 */
@Entity
@Table(name = "commentchild")
public class CommentChild {

    /** 回复的编号. */
    @Id
    @GeneratedValue
    private Integer id;
    /** 回复者编号. */
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    /** 回复的时间. */
    private String commentDate;
    /** 回复的内容. */
    private String commentText;
    /** 回复的评论. */
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

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
     * Gets comment.
     *
     * @return the comment
     */
    public Comment getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
