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
    @ResultMap("userMap")
    @Insert("Insert into user (user_name,password,permission)values(#{userName},#{password},#{permission})")
    void sign(User user);

    /**
     * 查询所有普通账户
     * @return
     */
    @ResultMap("userMap")
    @Select("Select * from user where permission = 0 order by user_name ASC")
    List<User> findAll();

    /**
     * 删除账号
     * @param userName
     */
    @ResultMap("userMap")
    @Delete("Delete from user where user_name = #{userName}")
    void deleteUser(String userName);

}
