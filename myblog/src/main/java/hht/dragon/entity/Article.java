package hht.dragon.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.util.Set;

/**
 * 文章类.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-18
 * Time : 下午7:12
 */
@Entity
@Table(name = "article")
public class Article {
    /** 文章编号. */
    @Id
    @GeneratedValue
    private Integer articleId;
   	/**文章标题. */
    private String articleTitle;
    /** 文章发表时间. */
    private String articleDate;
    /** 文章内容.*/
    private String articleText;
    /** 浏览次数. */
    private Integer lookCount = 0;
    /** 点赞次数. */
    private Integer suppotCount = 0;
    /** 作者编号. */
    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;

    /** 文章的评论. */
    @OneToMany
    @JoinColumn(name = "articleId")
    private Set<Comment> comments;

    /** 文章的点赞用户. */
    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "support", joinColumns = {@JoinColumn(name = "articleId")}, inverseJoinColumns = {@JoinColumn(name = "userId")})
    private Set<User> supportUser;

    /**
     * Gets article id.
     *
     * @return the article id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * Sets article id.
     *
     * @param articleId the article id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets article title.
     *
     * @return the article title
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * Sets article title.
     *
     * @param articleTitle the article title
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * Gets article date.
     *
     * @return the article date
     */
    public String getArticleDate() {
        return articleDate;
    }

    /**
     * Sets article date.
     *
     * @param articleDate the article date
     */
    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }

    /**
     * Gets article text.
     *
     * @return the article text
     */
    public String getArticleText() {
        return articleText;
    }

    /**
     * Sets article text.
     *
     * @param articleText the article text
     */
    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    /**
     * Gets look count.
     *
     * @return the look count
     */
    public Integer getLookCount() {
        return lookCount;
    }

    /**
     * Sets look count.
     *
     * @param lookCount the look count
     */
    public void setLookCount(Integer lookCount) {
        this.lookCount = lookCount;
    }

    /**
     * Gets suppot count.
     *
     * @return the suppot count
     */
    public Integer getSuppotCount() {
        return suppotCount;
    }

    /**
     * Sets suppot count.
     *
     * @param suppotCount the suppot count
     */
    public void setSuppotCount(Integer suppotCount) {
        this.suppotCount = suppotCount;
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
     * Gets comments.
     *
     * @return the comments
     */
    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * Sets comments.
     *
     * @param comments the comments
     */
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Gets support user.
     *
     * @return the support user
     */
    public Set<User> getSupportUser() {
        return supportUser;
    }

    /**
     * Sets support user.
     *
     * @param supportUser the support user
     */
    public void setSupportUser(Set<User> supportUser) {
        this.supportUser = supportUser;
    }
}
