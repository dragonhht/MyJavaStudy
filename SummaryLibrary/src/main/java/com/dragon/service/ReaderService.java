package com.dragon.service;

import com.dragon.entity.BorrowExtend;
import com.dragon.entity.MessageExtend;
import com.dragon.entity.ReaderExtend;

import java.util.List;

/**
 * 读者Service类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-22
 * Time : 下午9:46
 */
public interface ReaderService {

    /**
     * 读者登录
     *
     * @param reader
     *
     * @return 读者数据
     */
    ReaderExtend readerLogin(ReaderExtend reader);

    /**
     * 读者注册
     *
     * @param reader 含读者信息的实体类
     *
     * @return 注册成功后的账号
     */
    long readerRegist(ReaderExtend reader);

    /**
     * 修改密码
     *
     * @param reader 含读者编号和新密码的实体类
     *
     * @return 修改结果
     */
    boolean updatePassword(ReaderExtend reader);

    /**
     * 通过读者编号查找当前借阅的图书
     *
     * @param readerId 读者编号
     *
     * @return
     */
    List<BorrowExtend> getNowBorrowCord(long readerId);

    /**
     * 通过编号获取读者信息
     *
     * @param readerId 读者编号
     *
     * @return 读者信息
     */
    ReaderExtend getReaderById(long readerId);

    /**
     * 添加留言
     *
     * @param message 留言相关信息
     *
     * @return 是否添加成功
     */
    boolean addMessage(MessageExtend message);
}

