package jjjs.byj.services.impl;

import jjjs.byj.dao.IBorrowDao;
import jjjs.byj.domain.Borrow;
import jjjs.byj.services.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-06 11:51
 */
@Service("borrowService")
public class BorrowService implements IBorrowService {

    @Autowired
    private IBorrowDao borrowDao;

    /**
     * 根据书名查询借阅该书籍的账户
     * @param borrowBookName
     * @return
     */
    @Override
    public List<Borrow> findByBookName(String borrowBookName) {
        return borrowDao.findByBookName(borrowBookName);
    }

    /**
     * 根据账户查询借阅的书籍
     * @param borrowUserName
     * @return
     */
    @Override
    public List<Borrow> findByUserName(String borrowUserName) {
        return borrowDao.findByUserName(borrowUserName);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Borrow> findAll() {
        return borrowDao.findAll();
    }

    /**
     * 普通账户借阅书籍
     * @param borrow
     */
    @Override
    public void borrowBookByUser(Borrow borrow) {
        borrowDao.borrowBookByUser(borrow);
    }

    /**
     * 根据书籍名称、账号名称查询一列
     * @param bookName
     * @param userName
     * @return
     */
    @Override
    public Borrow findByBookNameAndUserName(String bookName, String userName) {
        return borrowDao.findByBookNameAndUserName(bookName,userName);
    }

    /**
     * 根据书籍名称、账户名称归还书籍
     * @param borrowUserName
     * @param borrowBookName
     */
    @Override
    public void returnBook(String borrowUserName, String borrowBookName) {
        borrowDao.returnBook(borrowUserName,borrowBookName);
    }
}
