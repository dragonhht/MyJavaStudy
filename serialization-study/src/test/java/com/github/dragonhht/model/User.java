package com.github.dragonhht.model;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-25
 */
@Getter
@Setter
@ToString
public class User implements Serializable {

    @Protobuf(fieldType = FieldType.STRING)
    private String id;
    @Protobuf(fieldType = FieldType.STRING)
    private String name;
    @Protobuf(fieldType = FieldType.INT32)
    private int age;
    @Protobuf(fieldType = FieldType.OBJECT)
    private List<Person> persons = new LinkedList<Person>();

    public void addPerson(Person person) {
        this.persons.add(person);
    }
}
