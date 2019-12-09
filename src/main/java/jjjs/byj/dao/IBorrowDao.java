package jjjs.byj.dao;

import jjjs.byj.domain.Borrow;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-06 11:51
 */
@Repository
public interface IBorrowDao {

    /**
     * 根据书名查询借阅该书籍的账户
     * @param borrowBookName
     * @return
     */
    @Select("Select * from borrow where borrow_book_name = #{borrowBookName} order by borrow_user_name")
    @Results(id="borrowMap",value = {
            @Result(column="borrow_user_name",property="borrowUserName"),
            @Result(column="borrow_book_name",property="borrowBookName"),
            @Result(column="borrow_book_time",property="borrowBookTime"),
            @Result(column="return_book_time",property="returnBookTime"),
    })
    List<Borrow> findByBookName(String borrowBookName);

    /**
     * 根据账户查询借阅的书籍
     * @param borrowUserName
     * @return
     */
    @ResultMap("borrowMap")
    @Select("Select * from borrow where borrow_user_name = #{borrowUserName} order by borrow_book_name ASC")
    List<Borrow> findByUserName(String borrowUserName);

    /**
     * 查询所有
     * @return
     */
    @ResultMap("borrowMap")
    @Select("Select * from borrow order by borrow_user_name")
    List<Borrow> findAll();

    /**
     * 普通账号借阅书籍
     * @param borrow
     */
    @ResultMap("borrowMap")
    @Insert("Insert into borrow (borrow_user_name,borrow_book_name,borrow_book_time,return_book_time) " +
            "values (#{borrowUserName},#{borrowBookName},#{borrowBookTime},#{returnBookTime})")
    void borrowBookByUser(Borrow borrow);

    /**
     * 根据书籍名称、账号名称查询一列
     * @param bookName
     * @param userName
     * @return
     */
    @ResultMap("borrowMap")
    @Select("Select * from borrow where borrow_book_name = #{bookName} and borrow_user_name = #{userName}")
    Borrow findByBookNameAndUserName(@Param("bookName")String bookName,@Param("userName")String userName);

    /**
     * 根据书籍名称、账户名称归还书籍
     * @param userName
     * @param bookName
     */
    @ResultMap("borrowMap")
    @Delete("Delete from borrow where borrow_user_name = #{userName} and borrow_book_name = #{bookName}")
    void returnBook(@Param("userName")String userName,@Param("bookName")String bookName);
}
