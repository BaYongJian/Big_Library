package jjjs.byj.services.impl;

import jjjs.byj.dao.IBookDao;
import jjjs.byj.domain.Book;
import jjjs.byj.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-06 08:51
 */
@Service("bookService")
public class BookService implements IBookService {

    @Autowired
    private IBookDao bookDao;

    /**
     * 查询所有书籍
     * @return
     */
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    /**
     * 按照名称查询书籍
     * @param bookName
     * @return
     */
    @Override
    public Book findByName(String bookName) {
        return bookDao.findByName(bookName);
    }

    /**
     * 添加书籍
     * @param book
     */
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    /**
     * 删除书籍
     * @param bookName
     */
    @Override
    public void deleteBook(String bookName) {
        bookDao.deleteBook(bookName);
    }

    /**
     * 借阅书籍
     * @param bookName
     */
    @Override
    public void borrowBook(String bookName) {
        bookDao.borrowBook(bookName);
    }

    /**
     * 归还书籍
     * @param bookName
     */
    @Override
    public void returnBook(String bookName) {
        bookDao.returnBook(bookName);
    }
}
