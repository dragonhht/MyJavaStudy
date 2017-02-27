package com.dragon.entity;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 读者实体类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-22
 * Time : 下午9:33
 */
public class Reader {

    /** 读者编号 */
    @NotNull(message = "{reader.readerId.not-null.error }")
    private long readerId;

    /** 读者姓名 */
    @Size(min = 1, max = 20, message = "{reader.readername.length.error}")
    private String readerName;

    /** 手机号码 */
    private String phone;

    /** 电子邮箱 */
    @Email(message = "{reader.email.error}")
    @Size(min = 1, message = "{reader.email.error}")
    private String email;

    /**  密码 */
    @Size(min = 1, message = "{reader.password.not-null.error}")
    private String password;


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


    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReaderName() {
        return readerName;
    }


    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", readerName='" + readerName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

