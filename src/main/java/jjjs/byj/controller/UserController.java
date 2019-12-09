package jjjs.byj.controller;

import jjjs.byj.domain.User;
import jjjs.byj.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-04 10:11
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 注册操作
     * @param user
     * @return
     */
    @RequestMapping("/sign")
    public String sign(User user){
        User user1 = userService.findByName(user.getUserName());
        if(user1 != null){
            return "Error/User/SignError";
        }else{
            if(user.getPassword().length() < 6 || user.getPassword().length() > 20){
                return "Error/User/PasswordLengthError";
            }
            user.setPermission(0);
            userService.sign(user);
            return "Function/UserFunction";
        }
    }

    /**
     * 登录操作
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(User user,Model model){
        User user1 = userService.findByName(user.getUserName());
        if(user1 != null && (user.getPassword().equals(user1.getPassword()))){
            if(user1.getPermission() == 1){
                return "Function/RootFunction";
            }else{
                model.addAttribute("userName",user.getUserName());
                return "Function/UserFunction";
            }
        }
        return "Error/User/UserNameOrPasswordError";
    }

    /**
     * 查询所有普通账户
     * 管理员操作
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "User/Admin/SelectUser";
    }

    /**
     * 查询一个普通账户
     * 管理员操作
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping("/findByName")
    public String findByName(String userName,Model model){
        User user = userService.findByName(userName);
        if(user == null || user.getPermission() == 1){
            return "Error/User/NullUserError";
        }
        List<User> users = new LinkedList<>();
        users.add(user);
        model.addAttribute("users",users);
        return "User/Admin/SelectUser";
    }

    /**
     * 增加账户操作
     * 管理员操作
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user){
        User user1 = userService.findByName(user.getUserName());
        if(user1 != null){
            return "Error/User/SignError";
        }else {
            if (user.getPassword().length() < 6 || user.getPassword().length() > 20) {
                return "Error/User/PasswordLengthError";
            }
            userService.sign(user);
            return "Success/SignSuccess";
        }
    }

    /**
     * 删除账户操作
     * 管理员操作
     * @param user
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(User user){
        User user1 = userService.findByName(user.getUserName());
        if(user1 == null){
            return "Error/User/NullUserError";
        }else if(!user.getPassword().equals(user1.getPassword())){
            return "Error/User/PasswordError";
        }
        userService.deleteUser(user.getUserName());
        return "Success/DeleteSuccess";
    }
}
