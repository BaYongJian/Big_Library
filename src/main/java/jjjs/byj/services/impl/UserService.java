package jjjs.byj.services.impl;

import jjjs.byj.dao.IUserDao;
import jjjs.byj.domain.User;
import jjjs.byj.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-04 10:14
 */
@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 查询用户
     * @param userName
     * @return
     */
    @Override
    public User findByName(String userName) {
        return userDao.findByName(userName);
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void sign(User user){
        userDao.sign(user);
    }

    /**
     * 查询所有普通账户
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 删除账户
     * @param userName
     */
    @Override
    public void deleteUser(String userName) {
        userDao.deleteUser(userName);
    }
}
