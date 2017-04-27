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
    @JoinColumn(name = "user_id")
    private User user;
    //评论时间
    private String comment_date;
    //评论内容
    private String comment_text;
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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
