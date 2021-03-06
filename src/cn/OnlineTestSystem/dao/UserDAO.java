package cn.OnlineTestSystem.dao;

import cn.OnlineTestSystem.domain.User;

import java.util.List;

/**
 * @ClassName UserDAO
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 21:00
 * @Version 1.0
 **/
public interface UserDAO {
    public Boolean addUser(User user);
    public Boolean delUserById(Integer id);
    public Boolean modifyUser(User user);
    public User findUserById(Integer id);
    public List<User> findUsersByNickname(String name);
    public List<User> findUsersByEmail(String email);
    public List<User> getAllUser();
    public List<User> getLimitedUser(int start, int limit);
    public int getUserCount();
}
