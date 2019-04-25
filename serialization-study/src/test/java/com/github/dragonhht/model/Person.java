package com.github.dragonhht.model;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import lombok.*;

import java.io.Serializable;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-25
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person implements Serializable {

    @Protobuf(fieldType = FieldType.STRING)
    private String id;
    @Protobuf(fieldType = FieldType.STRING)
    private String name;
    @Protobuf(fieldType = FieldType.STRING)
    private String address;

}
