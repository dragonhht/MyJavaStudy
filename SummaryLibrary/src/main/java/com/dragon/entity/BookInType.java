package com.dragon.entity;

/**
 * 图书类型对应
 * <p>
 * User : Dragon_hht
 * Date : 17-2-28
 * Time : 下午7:48
 */
public class BookInType extends BookExtend{

    /** 图书类型编号 */
    private long typeId;

    /** 图书类型名称 */
    private String typeName;

    /** 查询到的数量 */
    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

