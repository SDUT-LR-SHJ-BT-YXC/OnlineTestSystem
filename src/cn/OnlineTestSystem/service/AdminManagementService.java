package cn.OnlineTestSystem.service;

import cn.OnlineTestSystem.dao.UserDAO;
import cn.OnlineTestSystem.daoimpl.QbankDAOImpl;
import cn.OnlineTestSystem.daoimpl.UserDAOImpl;
import cn.OnlineTestSystem.domain.*;
import java.util.List;

/**
 * @ClassName AdminManagementService
 * @Desciption 管理员管理用户操作
 * @Author yinxiaochen
 * @Date 2019-12-19 19:59
 * @Version 1.0
 **/
public class AdminManagementService {
    private UserDAOImpl dao;

    public AdminManagementService(){
        dao = new UserDAOImpl();
    }
    /**
     * @Author: yinxiaochen
     * @Description: 获取全部用户信息
     * @Param:
     * @Return:
     * @Date: 20:21 2019-12-19
     */
    public List<User> getAllUser(){
        List<User> user = dao.getAllUser();
        return user;
    }
    /**
     * @Author: yinxiaochen
     * @Description: 获取对应行数用户信息
     * @Param:
     * @Return:
     * @Date: 21:30 2019-12-23
     */
    public List<User> getLimitedUser(int page, int limit){
        int start = limit * (page - 1);
        List<User> user = dao.getLimitedUser(start, limit);
        return user;
    }
    /**
     * @Author: yinxiaochen
     * @Description: 获取对应行数用户信息
     * @Param:
     * @Return:
     * @Date: 21:45 2019-12-23
     */
    public int getUserSize(){
        return dao.getUserCount();
    }
}
