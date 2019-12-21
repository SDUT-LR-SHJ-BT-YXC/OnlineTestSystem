package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.UserDAOImpl;
import cn.OnlineTestSystem.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserService
 * @Desciption TODO
 * @Author liurong
 * @Date 2019/12/3  20:31
 * @Version 1.0
 **/
public class UserService{

    public UserDAOImpl userdimpl = new UserDAOImpl();
    /**
     * 判断是否注册成功
     * @Param: [user]
     * @Return: boolean
     * @Author: liurong
     * @Date: 2019/12/3 22:30
     */
    public boolean Register(User user) {
        return userdimpl.addUser(user);
    }
    /**
     * 判断邮箱是否重复
     * @Param: [email]
     * @Return: boolean
     * @Author: liurong
     * @Date: 2019/12/3 22:29
     */
    public boolean isExistEmail(String email){
        //2019-12-04 12：15尚进重写
        if(userdimpl.findUsersByEmail(email).size() > 0){
            return true;
        }
        else{
            return  false;
        }
    }

    /**
     * 判断用户ID和密码是否一致
     * @Param: [user_id, password]
     * @Return: boolean
     * @Author: liurong
     * @Date: 2019/12/3 22:30
     */
    public boolean isLogin(String email,String password){
        System.out.println(userdimpl.findUsersByEmail(email).size());

        if(userdimpl.findUsersByEmail(email).size() == 0 || (!password.equals(userdimpl.findUsersByEmail(email).get(0).getPassword()))){
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据邮箱查找用户ID
     * @Param: [email]
     * @Return: int
     * @Author: liurong
     * @Date: 2019/12/3 22:31
     */
    public int findUserId(String email){
        List<User> users = new ArrayList<>();
        users = userdimpl.findUsersByEmail(email);
        if(users.size() == 0){
            return -1;
        } else {
            return users.get(0).getUserId();
        }
    }

    /*
     * 登录成功，返回用户类
     * @Param: [email]
     * @Return: cn.OnlineTestSystem.domain.User
     * @Author: liurong
     * @Date: 2019/12/6 23:45
     */
    public User getUser(String email){
        List<User> users = new ArrayList<>();
        users = userdimpl.findUsersByEmail(email);
        if(users.size() == 0){
            return null;
        } else {
            int id =  users.get(0).getUserId();
            User user = userdimpl.findUserById(id);
            return user;
        }
    }
    /**
     * @Author: Shangjin
     * @Description:更新账户信息
     * @Param:
     * @Return:
     * @Date: 19:31 2019-12-08
     */
    public boolean modifyUser(User user){
        return userdimpl.modifyUser(user);
    }

    /*
     * 返回用户角色
     * @Param: [email]
     * @Return: int
     * @Author: liurong
     * @Date: 2019/12/20 23:18
     */
    public int getRole(String email){
        List<User> users =  userdimpl.findUsersByEmail(email);
        return users.get(0).getRole();
    }

    /*
     * 更改用户权限
     * @Param: [userId]
     * @Return: null
     * @Author: yinxiaochen
     * @Date: 2019/12/21 20:21
     */
    public void changeRole(int userid){
        User usr = userdimpl.findUserById(userid);
        if(usr.getRole() == 0)
            usr.setRole(1);
        else if(usr.getRole() == 1)
            usr.setRole(0);
        userdimpl.modifyUser(usr);
        return;
    }
}
