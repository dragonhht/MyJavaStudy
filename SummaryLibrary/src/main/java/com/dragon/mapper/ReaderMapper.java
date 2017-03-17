package com.dragon.mapper;

import com.dragon.entity.BorrowExtend;
import com.dragon.entity.MessageExtend;
import com.dragon.entity.ReaderExtend;

import java.util.List;

/**
 * 读者操作mapper接口
 * <p>
 * User : Dragon_hht
 * Date : 17-2-25
 * Time : 上午8:41
 */
public interface ReaderMapper {

    /**
     * 读者登录
     *
     * @param reader
     *
     * @return 数据库查询到的读者信息
     *
     * @throws Exception
     */
    ReaderExtend readerLogin(ReaderExtend reader) throws Exception;

    /**
     * 读者注册
     *
     * @param reader 含读者信息的实体类
     *
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

    /**
     * 通过读者编号查找当前借阅的图书
     *
     * @param readerId 读者编号
     *
     * @return
     *
     * @throws Exception
     */
    List<BorrowExtend> getNowBorrowCord(long readerId) throws Exception;

    /**
     * 通过编号查询读者
     *
     * @param readerId 读者编号
     *
     * @return 读者信息
     *
     * @throws Exception
     */
    ReaderExtend getReaderById(long readerId) throws Exception;

    /**
     * 添加留言
     *
     * @param message 留言相关信息
     *
     *
     * @throws Exception
     */
    void addMessage(MessageExtend message) throws Exception;
}

