package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.dao.UserDAO;
import cn.OnlineTestSystem.domain.Qbank;
import cn.OnlineTestSystem.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:22
 * @Version 1.0
 **/
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    /**
     * @Author: Shangjin
     * @Description:添加一个新的用户
     * @Param:
     * @Return:
     * @Date: 21:59 2019-11-29
     */
    public Boolean addUser(User user) {
        String sql = "INSERT INTO user(nick_name,email, password, role) VALUES (?,?,?,?)";
        try {
            this.update(sql, user.getNickName(), user.getEmail(), user.getPassword(), user.getRole());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:通过ID删除某用户
     * @Param:
     * @Return:
     * @Date: 22:00 2019-11-29
     */
    public Boolean delUserById(Integer id) {
        String sql = "DELETE FROM user WHERE user_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:修改某用户信息，以此用户的ID为依据
     * @Param:
     * @Return:
     * @Date: 22:00 2019-11-29
     */
    public Boolean modifyUser(User user) {
        String sql = "UPDATE user SET nick_name=?, email=?, password=?, role=? WHERE user_id=?";
        try {
            this.update(sql, user.getNickName(), user.getEmail(), user.getPassword(), user.getRole(), user.getUserId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:通过用户ID查找某用户
     * @Param:
     * @Return:
     * @Date: 22:00 2019-11-29
     */
    public User findUserById(Integer id) {
        String sql = "SELECT * FROM user WHERE user_id=?";
        try {
            return this.get(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /**
     * @Author: Shangjin
     * @Description:通过用户昵称查找所有用户
     * @Param:
     * @Return:
     * @Date: 22:01 2019-11-29
     */
    public List<User> findUsersByNickname(String name) {
        String sql = "SELECT * FROM user WHERE nick_name=?";
        try {
            return  this.getForList(sql, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findUsersByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email=?";
        try {
            return  this.getForList(sql, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /**
     * @Author: yinxiaochen
     * @Description: 获取所有用户信息
     * @Param:
     * @Return:
     * @Date: 20:19 2019-12-19
     */
    public List<User> getAllUser() {
        String sql = "SELECT * FROM  user";
        try {
            return this.getForList(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    /**
     * @Author: yinxiaochen
     * @Description: 获取有限用户信息
     * @Param: int start, int limit
     * @Return: List<User>
     * @Date: 21:40 2019-12-23
     */
    public List<User> getLimitedUser(int start, int limit) {
        String sql = "SELECT * FROM  user LIMIT " + start + "," + limit;
        try {
            return this.getForList(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    /**
     * @Author: yinxiaochen
     * @Description: 获取用户表行数
     * @Param:
     * @Return:
     * @Date: 21:41 2019-12-23
     */
    public int getUserCount() {
        String sql = "SELECT COUNT(*) FROM user";
        try {
            Long c =  this.getForValue(sql);
            return c.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
