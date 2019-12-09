package jjjs.byj.services;

import jjjs.byj.domain.User;

import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-04 10:13
 */
public interface IUserService {

    /**
     * 查询账户
     * @param userName
     * @return
     */
    User findByName(String userName);

    /**
     * 添加账户
     * @param user
     */
    void sign(User user);

    /**
     * 查询所有普通账户
     * @return
     */
    List<User>findAll();

    /**
     * 删除账号
     * @param userName
     */
    void deleteUser(String userName);

    /**
     * 借阅书籍的账号
     * @param userName
     */
    void borrowUser(String userName);

    /**
     * 归还书籍
     * @param userName
     */
    void returnBook(String userName);
}
