package com.github.dragonhht.protostuff.model;

import io.protostuff.Tag;
import lombok.Data;

/**
 * Description.
 * User: huang
 * Date: 18-10-30
 */
@Data
public class Student {
    @Tag(1)
    private String stuName;
    @Tag(2)
    private String stuNo;
    @Tag(3)
    private int age;

}
