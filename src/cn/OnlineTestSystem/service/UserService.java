package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.daoimpl.UserDAOImpl;
import cn.OnlineTestSystem.domain.User;
import cn.OnlineTestSystem.dao.BaseDAO;
import java.sql.SQLException;
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
}