package jjjs.byj.dao;

import jjjs.byj.domain.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-06 08:45
 */
@Repository
public interface IBookDao {

    /**
     * 查询所有书籍
     * @return
     */
    @Select("Select * from book order by book_name ASC")
    @Results(id="bookMap",value = {
            @Result(column="book_name",property="bookName",id=true),
            @Result(column="book_writer",property="bookWriter"),
            @Result(column="book_total",property="bookTotal"),
            @Result(column="book_remaining",property="bookRemaining"),
    })
    List<Book> findAll();

    /**
     * 按照名称查询书籍
     * @param bookName
     * @return
     */
    @ResultMap("bookMap")
    @Select("Select * from book where book_name = #{bookName}")
    Book findByName(String bookName);

    /**
     * 添加书籍
     * @param book
     */
    @ResultMap("bookMap")
    @Insert("Insert into book (book_name,book_writer,book_total,book_remaining)values" +
            "(#{bookName},#{bookWriter},#{bookTotal},#{bookRemaining})")
    void addBook(Book book);

    /**
     * 删除书籍
     * @param bookName
     */
    @ResultMap("bookMap")
    @Delete("Delete from book where book_name = #{bookName}")
    void deleteBook(String bookName);

    /**
     * 借阅书籍
     * @param bookName
     */
    @ResultMap("bookMap")
    @Update("Update book set book_remaining = book_remaining - 1 where book_name = #{bookName}")
    void borrowBook(String bookName);

    /**
     * 归还书籍
     * @param bookName
     */
    @ResultMap("bookMap")
    @Update("Update book set book_remaining = book_remaining + 1 where book_name = #{bookName}")
    void returnBook(String bookName);
}
