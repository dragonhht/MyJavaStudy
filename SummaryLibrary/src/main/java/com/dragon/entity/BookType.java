package com.dragon.entity;

/**
 * 图书类型类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-24
 * Time : 上午11:07
 */
public class BookType {

    /** 图书类型编号 */
    private long typeId;

    /** 图书类型名称 */
    private String typeName;

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}


