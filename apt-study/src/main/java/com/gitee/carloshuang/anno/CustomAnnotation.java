package com.gitee.carloshuang.anno;

import java.lang.annotation.*;

/**
 * 自定义注解.
 *
 * @author: Carlos Huang
 * @Date: 2020-8-16
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface CustomAnnotation {
}
