package hht.dragon.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户实体类
 * <p>
 * User : Dragon_hht
 * Date : 17-4-13
 * Time : 下午6:34
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    //用户名
    @Length(min = 1, max = 10)
    private String userName;
    //电子邮箱
    @Email
    private String email;
    //联系电话
    private String phone;
    //身份
    private int status;
    //个性签名
    private String signature;
    //头像
    private String img;
    //注册时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registDate;
    //住址
    private String address;
    //密码
    @Length(min = 1, max = 11)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", signature='" + signature + '\'' +
                ", img='" + img + '\'' +
                ", registDate=" + registDate +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
