package cn.OnlineTestSystem.daoimpl;

import cn.OnlineTestSystem.dao.AdminDAO;
import cn.OnlineTestSystem.dao.BaseDAO;
import cn.OnlineTestSystem.domain.Admin;

import java.util.List;

/**
 * @ClassName AdminDAOImpl
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-29 16:11
 * @Version 1.0
 **/
public class AdminDAOImpl extends BaseDAO implements AdminDAO{

    @Override
    public Admin findAdminById(Integer id) {
        return null;
    }

    @Override
    public List<Admin> findAdminsByName(String name) {
        return null;
    }

    @Override
    public Boolean addAdmin(Admin admin) {
        return null;
    }

    @Override
    public Boolean delAdmin(Integer id) {
        return null;
    }

    @Override
    public Boolean modifyAdminInfo(Admin admin) {
        return null;
    }
}
