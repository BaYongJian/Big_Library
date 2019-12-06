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
}
