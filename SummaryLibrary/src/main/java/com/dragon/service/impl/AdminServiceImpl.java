package com.dragon.service.impl;

import com.dragon.entity.BookExtend;
import com.dragon.entity.BorrowExtend;
import com.dragon.mapper.AdminMapper;
import com.dragon.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
