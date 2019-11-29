package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.UserDAO;
import cn.OnlineTestSystem.domain.User;

import java.util.List;

/**
 * @ClassName UserDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:22
 * @Version 1.0
 **/
public class UserDAOImpl extends BaseDAO implements UserDAO {
    @Override
    public Boolean addUser(User user) {
        return null;
    }

    @Override
    public Boolean delUserById(Integer id) {
        return null;
    }

    @Override
    public Boolean modifyUser(User user) {
        return null;
    }

    @Override
    public User findUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> findUsersByNickname(String name) {
        return null;
    }
}
