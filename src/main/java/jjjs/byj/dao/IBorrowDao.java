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
    @Select("Select * from borrow where borrow_book_name = #{borrowBookName}")
    @Results(id="borrowMap",value = {
            @Result(column="borrow_user_name",property="borrowUserName"),
            @Result(column="borrow_book_name",property="borrowBookName"),
            @Result(column="borrow_book_time",property="borrowBookTime"),
            @Result(column="return_book_time",property="returnBookTime"),
            @Result(column="whether_timeout",property="whetherTimeout"),
    })
    List<Borrow> findByBookName(String borrowBookName);

    /**
     * 根据账户查询借阅的书籍
     * @param borrowUserName
     * @return
     */
    @ResultMap("borrowMap")
    @Select("Select * from borrow where borrow_user_name = #{borrowUserName}")
    List<Borrow> findByUserName(String borrowUserName);

    /**
     * 查询所有
     * @return
     */
    @ResultMap("borrowMap")
    @Select("Select * from borrow")
    List<Borrow> findAll();
}
