package com.dragon.service.impl;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BorrowExtend;
import com.dragon.entity.ReaderExtend;
import com.dragon.mapper.AdminMapper;
import com.dragon.service.AdminService;
import com.dragon.utils.getDate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-22
 * Time : 下午7:58
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Resource
    private AdminMapper adminMapper;

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public boolean addBook(BookExtend book) {
        boolean ok = false;

        String buyDate = getDate.getDateDay();
        book.setBuyDate(buyDate);
        long bookId = getNewBookId();
        book.setBookId(bookId);

        try {
            adminMapper.addBook(book);
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public boolean delBook(long bookId) {
        boolean ok =false;

        try {
            adminMapper.delBook(bookId);
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    public boolean updateBook(BookExtend book) {
        boolean ok =false;

        try {
            adminMapper.updateBook(book);
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    public boolean borrowBook(BorrowExtend borrow) {
        boolean ok = false;

        try {
            adminMapper.borrowBook(borrow);
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    public boolean returnBook(BorrowExtend borrow) {
        boolean ok = false;

        try {
            adminMapper.returnBook(borrow);
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    public boolean grantReader(long readerId) {
        boolean ok = false;

        try {
            adminMapper.grantReader(readerId);
            ok = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ok;
    }

    public List<ReaderExtend> getAdmin() {
        List<ReaderExtend> admins = null;

        try {
            admins = adminMapper.getAdmin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }

    public boolean delAdmin(long readerId) {
        boolean ok = false;

        try {
            adminMapper.delAdmin(readerId);
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
    private long getNewBookId() {
        long newBookId = 0;

        try {

            try {
                newBookId = adminMapper.getNewBookId();
            } catch (Exception e) {
                newBookId = 0;
            }

            System.out.println("最新的图书编号:"+newBookId);
            //判断数据库中是否有数据
            if (newBookId == 0) {
                newBookId=1000000001l;
            } else {

                newBookId = newBookId + 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("得到的图书编号:"+newBookId);
        return newBookId;
    }
}
