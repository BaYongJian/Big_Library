package jjjs.byj.services;

import jjjs.byj.domain.Borrow;

import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-06 11:51
 */
public interface IBorrowService {

    /**
     * 根据书名查询借阅该书籍的账户
     * @param borrowBookName
     * @return
     */
    List<Borrow> findByBookName(String borrowBookName);

    /**
     * 根据账户查询借阅的书籍
     * @param borrowUserName
     * @return
     */
    List<Borrow> findByUserName(String borrowUserName);

    /**
     * 查询所有
     * @return
     */
    List<Borrow> findAll();

    /**
     * 普通账号借阅书籍
     * @param borrow
     */
    void borrowBookByUser(Borrow borrow);

    /**
     * 根据书籍名称、账号名称查询一列
     * @param bookName
     * @param userName
     * @return
     */
    Borrow findByBookNAmeAndUserNAme(String bookName,String userName);
}
