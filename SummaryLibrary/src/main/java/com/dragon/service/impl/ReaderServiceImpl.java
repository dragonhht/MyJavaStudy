package com.dragon.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.dragon.entity.ReaderExtend;
import com.dragon.mapper.ReaderMapper;
import com.dragon.service.ReaderService;

/**
 * 读者Service实现类
 * <p>
 * User : Dragon_hht
 * Date : 17-2-25
 * Time : 上午9:13
 */
@Service
public class ReaderServiceImpl implements ReaderService {

    /** 读者Mapper实例 */
    @Resource
    private ReaderMapper readerMapper;


    public boolean readerRegist(ReaderExtend reader) {
        //成功判断变量
        boolean ok = false;
        //新的编号
        long newReaderId=0l;

        try {
            newReaderId = getNewReaderId();
            //将新的编号放入对象
            reader.setReaderId(newReaderId);

            readerMapper.readerRegist(reader);
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
System.out.println("注册情况 ++"+ok);
        return ok;
    }


    public boolean updatePassword(ReaderExtend reader) {
        //成功判断
        boolean ok = false;

        try {
            readerMapper.updatePassword(reader);
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }


    /**
     * 获取一个新的读者编号
     *
     * @return 新的读者编号
     */
    private long getNewReaderId() {
        long newReaderId = 0;

        try {

            try {
                newReaderId = readerMapper.getLastReaderId();
            } catch (Exception e) {
                newReaderId = 0;
            }

 System.out.println("最新的读者编号:"+newReaderId);
            //判断数据库中是否有数据
            if (newReaderId == 0) {
                newReaderId=1000000001l;
            } else {

                newReaderId = newReaderId + 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
System.out.println("得到的读者编号:"+newReaderId);
        return newReaderId;
    }


    public void setReaderMapper(ReaderMapper readerMapper) {
        this.readerMapper = readerMapper;
    }
}

