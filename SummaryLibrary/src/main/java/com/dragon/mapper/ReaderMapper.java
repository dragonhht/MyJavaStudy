package com.dragon.mapper;

import com.dragon.entity.ReaderExtend;

/**
 * 读者操作mapper接口
 * <p>
 * User : Dragon_hht
 * Date : 17-2-25
 * Time : 上午8:41
 */
public interface ReaderMapper {

    /**
     * 读者注册
     *
     * @param reader 含读者信息的实体类
     *
     * @return 读者编号
     *
     * @throws Exception
     */
    void readerRegist(ReaderExtend reader) throws Exception;

    /**
     * 修改密码
     *
     * @param reader 含读者信息的实体类
     *
     * @throws Exception
     */
    void updatePassword(ReaderExtend reader) throws Exception;

    /**
     * 获取最新的读者编号
     *
     * @return 最新的读者编号
     *
     * @throws Exception
     */
    long getLastReaderId() throws Exception;
}

