package jjjs.byj.dao;

import jjjs.byj.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-04 10:15
 */
@Repository
public interface IUserDao {

    /**
     * 查询账户
     * @param userName 用户名
     * @return
     */
    @Select("Select * from user where user_name = #{userName}")
    @Results(id="userMap",value = {
            @Result(column="user_name",property="userName",id=true),
            @Result(column="password",property="password"),
            @Result(column="permission",property="permission"),
            @Result(column="borrow_book",property="borrowBook"),
    })
    User findByName(String userName);

    /**
     * 注册账户
     * @param user
     */
    @Insert("Insert into user (user_name,password,permission)values(#{userName},#{password},#{permission})")
    @ResultMap("userMap")
    void sign(User user);

    /**
     * 查询所有普通账户
     * @return
     */
    @Select("Select * from user where permission = 0 order by user_name ASC")
    @ResultMap("userMap")
    List<User> findAll();

    /**
     * 删除账号
     * @param userName
     */
    @Delete("Delete from user where user_name = #{userName}")
    @ResultMap("userMap")
    void deleteUser(String userName);

    /**
     * 借阅书籍的账号
     * @param userName
     */
    @Update("Update user set borrow_book = borrow_book + 1 where user_name = #{userName}")
    @ResultMap("userMap")
    void borrowUser(String userName);

    /**
     * 归还书籍
     * @param userName
     */
    @Update("Update user set borrow_book = borrow_book - 1 where user_name = #{userName}")
    @ResultMap("userMap")
    void returnBook(String userName);

    /**
     * 修改密码
     * @param userName
     * @param password
     */
    @Update("Update user set password = #{arg1} where user_name = #{arg0}")
    @ResultMap("userMap")
    void changePassword(String userName, String password);
}
