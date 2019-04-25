package com.github.dragonhht.utils;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * 使用Protostuff进行编解码.
 * User: huang
 * Date: 18-10-30
 */
public class ProtostuffUtil {
    public ProtostuffUtil() {
    }

    /**
     * 编码.
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[] serializer(T obj) {
        Schema schema = RuntimeSchema.getSchema(obj.getClass());
        return ProtobufIOUtil.toByteArray(obj, schema, LinkedBuffer.allocate(256));
    }

    /**
     * 解码.
     * @param bytes 编码后的二进制
     * @param clazz 解码后的类
     * @param <T>
     * @return
     */
    public static <T> T deserializer(byte[] bytes, Class<T> clazz) {

        T obj = null;
        try {
            obj = clazz.newInstance();
            Schema schema = RuntimeSchema.getSchema(obj.getClass());
            ProtostuffIOUtil.mergeFrom(bytes, obj, schema);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
