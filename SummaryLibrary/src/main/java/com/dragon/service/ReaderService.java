package com.dragon.service;

import com.dragon.entity.ReaderExtend;

/**
 * 读者Service类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-22
 * Time : 下午9:46
 */
public interface ReaderService {

    /**
     * 读者注册
     *
     * @param reader 含读者信息的实体类
     *
     * @return 注册结果
     */
    boolean readerRegist(ReaderExtend reader);

    /**
     * 修改密码
     *
     * @param reader 含读者编号和新密码的实体类
     *
     * @return 修改结果
     */
    boolean updatePassword(ReaderExtend reader);

}

