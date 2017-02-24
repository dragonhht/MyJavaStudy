package com.dragon.entity;

/**
 * 读者实体类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-22
 * Time : 下午9:33
 */
public class Reader {

    /** 读者编号 */
    private String readerID;

    /** 读者姓名 */
    private String readerName;

    /** 手机号码 */
    private String phone;

    /** 电子邮箱 */
    private String email;


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


    public String getReaderID() {
        return readerID;
    }


    public void setReaderID(String readerID) {
        this.readerID = readerID;
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
                "readerID='" + readerID + '\'' +
                ", readerName='" + readerName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

