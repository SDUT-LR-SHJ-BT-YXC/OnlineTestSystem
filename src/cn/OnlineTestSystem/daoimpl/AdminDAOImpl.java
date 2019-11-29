package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.AdminDAO;
import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.domain.Admin;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName AdminDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:11
 * @Version 1.0
 **/
public class AdminDAOImpl extends BaseDAO<Admin> implements AdminDAO{

    public AdminDAOImpl() {
        super();
    }

    @Override
    public Admin findAdminById(Integer id) {
        String sql = "SELECT * FROM admins WHERE admin_id=?";
        try {
            return this.get(sql, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> findAdminsByName(String name) {
        String sql ="SELECT * FROM admins WHERE admin_name=?";
        try {
            return  this.getForList(sql, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean addAdmin(Admin admin) {
        String sql = "INSERT INTO admins(password, admin_name) VALUES (?,?)";
        try {
            this.update(sql, admin.getPassword(), admin.getAdminName());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delAdmin(Integer id) {
        String sql = "DELETE FROM admins WHERE admin_id=?";
        try {
            this.update(sql, id);
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean modifyAdminInfo(Admin admin) {
        String sql = "UPDATE admins SET password=?,admin_name=? WHERE admin_id=?";
        try {
            this.update(sql, admin.getPassword(), admin.getAdminName(), admin.getAdminId());
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }
}
