package com.github.dragonhht.protostuff.main;

import com.github.dragonhht.protostuff.model.Student;
import com.github.dragonhht.protostuff.utils.ProtostuffUtil;

import java.util.Arrays;

/**
 * Description.
 * User: huang
 * Date: 18-10-30
 */
public class Main {

    public static void main(String[] args) {

        Student student = new Student();
        student.setStuName("dragonhht");
        student.setAge(18);
        student.setStuNo("11111111");

        byte[] serializerResult = ProtostuffUtil.serializer(student);
        System.out.println("编码结果:" + Arrays.toString(serializerResult));

        Student deSerializerResult = ProtostuffUtil.deserializer(serializerResult,Student.class);
        System.out.println("解码结果:" + deSerializerResult.toString());
    }

}
