package com.github.dragonhht;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.dragonhht.model.Person;
import com.github.dragonhht.model.User;
import com.google.gson.Gson;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 这里只写两种json.
 *
 * @author: huang
 * @Date: 2019-4-25
 */
public class JsonTest {

    private User user = new User();
    private int size = 20000;
    private String json = null;
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
     * jackson
     */
    @Test
    public void testJackson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // 对象转json字符串
            json = mapper.writeValueAsString(user);
        }
        System.out.println("jackson, 对象 ——> json用时: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // json字符串转对象
            u = mapper.readValue(json,  User.class);
        }
        System.out.println("jackson, json ——> 对象用时: " + (System.currentTimeMillis() - start));
    }

    /**
     * fastjson
     */
    @Test
    public void testFastJson() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // 对象转json字符串
            json = JSON.toJSONString(user);
        }
        System.out.println("fastjson, 对象 ——> json用时: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // json字符串转对象
            u = JSON.parseObject(json, new TypeReference<User>(){});
        }
        System.out.println("fastjson, json ——> 对象用时: " + (System.currentTimeMillis() - start));
    }

    /**
     * gson
     */
    @Test
    public void testGson() {
        Gson gson = new Gson();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // 对象转json字符串
            json = gson.toJson(user);
        }
        System.out.println("Gson, 对象 ——> json用时: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            // json字符串转对象
            u = gson.fromJson(json, User.class);
        }
        System.out.println("Gson, json ——> 对象用时: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void compare() throws IOException {
        testJackson();
        testFastJson();
        testGson();
    }

}
