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
}
