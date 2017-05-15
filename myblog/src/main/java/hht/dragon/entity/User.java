package hht.dragon.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 用户实体类.
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:34
 */
@Entity
@Table(name = "user")
public class User {
    /** 用户编号. */
    @Id
    @GeneratedValue
    private Integer userId;
    /**  用户名. */
    @Length(min = 1, max = 10)
    private String userName;
    /** 电子邮箱. */
    @Email
    private String email;
    /** 手机号码. */
    private String phone;
    /** 身份权限. */
    private int status = 0;
    /** 个性签名. */
    private String signature;
    /**  头像. */
    private String img = "../img/temp/man.png";
    /**  注册时间. */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registDate;
    /**  家庭住址. */
    private String address;
    /** 登录密码. */
    @Length(min = 1)
    private String password;
    /** 用户验证密码修改. */
    private String uuid = "0";
    /**  上传的文章. */
    @OneToMany
    @JoinColumn(name = "userId")
    @JsonBackReference
    private Set<Article> articles;

    /**  支持的文章. */
    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "support", joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "articleId")})
    private Set<Article> supportArticle;

    /**  角色. */
    @ManyToMany(cascade = {}, fetch = FetchType.EAGER)
    @JoinTable(name = "userrole", joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Set<UserRole> roles;

	/**
	 * Gets user id.
	 *
	 * @return the user id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets user id.
	 *
	 * @param userId the user id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets user name.
	 *
	 * @param userName the user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets phone.
	 *
	 * @param phone the phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Sets status.
	 *
	 * @param status the status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Gets signature.
	 *
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * Sets signature.
	 *
	 * @param signature the signature
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * Gets img.
	 *
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * Sets img.
	 *
	 * @param img the img
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * Gets regist date.
	 *
	 * @return the regist date
	 */
	public Date getRegistDate() {
		return registDate;
	}

	/**
	 * Sets regist date.
	 *
	 * @param registDate the regist date
	 */
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	/**
	 * Gets address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets address.
	 *
	 * @param address the address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets articles.
	 *
	 * @return the articles
	 */
	public Set<Article> getArticles() {
		return articles;
	}

	/**
	 * Sets articles.
	 *
	 * @param articles the articles
	 */
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	/**
	 * Gets support article.
	 *
	 * @return the support article
	 */
	public Set<Article> getSupportArticle() {
		return supportArticle;
	}

	/**
	 * Sets support article.
	 *
	 * @param supportArticle the support article
	 */
	public void setSupportArticle(Set<Article> supportArticle) {
		this.supportArticle = supportArticle;
	}

	/**
	 * Gets roles.
	 *
	 * @return the roles
	 */
	public Set<UserRole> getRoles() {
		return roles;
	}

	/**
	 * Sets roles.
	 *
	 * @param roles the roles
	 */
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	/**
	 * Gets uuid.
	 *
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * Sets uuid.
	 *
	 * @param uuid the uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
