package hht.dragon.entity;

import javax.persistence.*;

/**
 * 评论的子评论
 * <p>
 * User : Dragon_hht
 * Date : 17-4-27
 * Time : 下午7:29
 */
@Entity
@Table(name = "commentchild")
public class CommentChild {

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
    @JoinColumn(name = "comment_id")
    private Comment comment;

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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
