package jjjs.byj.services;

import jjjs.byj.domain.Book;

import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-06 08:51
 */
public interface IBookService {

    /**
     * 查询所有书籍
     * @return
     */
    List<Book> findAll();

    /**
     * 按照名称查询书籍
     * @param bookName
     * @return
     */
    Book findByName(String bookName);

    /**
     * 添加书籍
     * @param book
     */
    void addBook(Book book);

    /**
     * 删除书籍
     * @param bookName
     */
    void deleteBook(String bookName);
}
