package hht.dragon.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;


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
    /** 文章编号 */
    @Id
    @GeneratedValue
    private Integer articleId;
	/**文章标题 */
    private String articleTitle;
    /** 文章发表时间 */
    private String articleDate;
    /** 文章内容 */
    private String articleText;
    /** 浏览次数 */
    private Integer lookCount=0;
    /** 点赞次数 */
    private Integer suppotCount =0;
    /** 作者编号 */
    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;

    /** 文章的评论 */
    @OneToMany
    @JoinColumn(name = "articleId")
    private Set<Comment> comments;

    /** 文章的点赞用户 */
    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "support", joinColumns = {@JoinColumn(name = "articleId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
    private Set<User> supportUser;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
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

    public Integer getLookCount() {
        return lookCount;
    }

    public void setLookCount(Integer lookCount) {
        this.lookCount = lookCount;
    }

    public Integer getSuppotCount() {
        return suppotCount;
    }

    public void setSuppotCount(Integer suppotCount) {
        this.suppotCount = suppotCount;
    }

    public Set<User> getSupportUser() {
        return supportUser;
    }

    public void setSupportUser(Set<User> supportUser) {
        this.supportUser = supportUser;
    }
}
