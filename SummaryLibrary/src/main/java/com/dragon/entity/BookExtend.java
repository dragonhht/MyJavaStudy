package com.dragon.entity;

/**
 * 图书实体类扩展类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-24
 * Time : 上午11:14
 */
public class BookExtend extends Book {

    /** 借阅状态 */
    private String lend = "不可借";



    public String getLend() {
        return lend;
    }

    public void setLend(String lend) {
        this.lend = lend;
    }
}

