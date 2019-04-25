package com.github.dragonhht;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.github.dragonhht.model.Person;
import com.github.dragonhht.model.User;
import com.github.dragonhht.utils.ProtostuffUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-4-25
 */
public class ByteTest {

    private User user = new User();
    private int size = 20000;
    private byte[] bytes = null;
    private User u = null;

    @Before
    public void init() {
        user.setAge(18);
        user.setId("1234567890");
        user.setName("sragonhht");
        for (int i = 0; i < 10; i++) {
            user.addPerson(new Person("id_" + i, "name_" + i, "address_" + i));
        }
    }

    /**
     * JProtoBuf
     */
    @Test
    public void testJProtoBuf() throws IOException {
        Codec<User> userCodec = ProtobufProxy.create(User.class);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // 对象序列化
           bytes = userCodec.encode(user);
        }
        System.out.println("JProtoBuf, 对象序列化用时: " + (System.currentTimeMillis() - start) + " , 长度: " + bytes.length);

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // 对象反序列化
            u = userCodec.decode(bytes);
        }
        System.out.println("JProtoBuf, 反序列化用时: " + (System.currentTimeMillis() - start));
        System.out.println(u);
    }

    /**
     * Protostuff
     */
    @Test
    public void testProtostuff() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // 对象序列化
            bytes = ProtostuffUtil.serializer(user);
        }
        System.out.println("Protostuff, 对象序列化用时: " + (System.currentTimeMillis() - start) + " , 长度: " + bytes.length);

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // 对象反序列化
            u = ProtostuffUtil.deserializer(bytes, User.class);
        }
        System.out.println("Protostuff, 反序列化用时: " + (System.currentTimeMillis() - start));
        // 内容有损失？？？
        System.out.println(u);
    }

    /**
     * Hessian
     */
    @Test
    public void testHessian() throws IOException {

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(bo);

        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // 对象序列化
            ho.writeObject(user);
            if (i == 0) {
                bytes = bo.toByteArray();
            }
        }
        System.out.println("Hessian, 对象序列化用时: " + (System.currentTimeMillis() - start) + " , 长度: " + bytes.length);

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // 对象反序列化
            HessianInput hi = new HessianInput(new ByteArrayInputStream(bo.toByteArray()));
            u = (User) hi.readObject();
        }
        System.out.println("Hessian, 反序列化用时: " + (System.currentTimeMillis() - start));
        System.out.println(u);
    }

    @Test
    public void compare() throws IOException {
        testJProtoBuf();
        testProtostuff();
        testHessian();
    }

}
